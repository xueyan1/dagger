/*
 * Copyright (C) 2016 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dagger.internal.codegen;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import javax.annotation.Nullable;

/** An object which associates a {@link BindingExpression} instance with a {@link BindingKey}. */
// TODO(dpb): Rename and/or split up this type.
interface HasBindingExpressions {

  /**
   * Returns the {@link BindingExpression} associated with the given {@link BindingKey} or {@code
   * null} if no association exists.
   */
  // TODO(dpb): Move the hierarchical map of binding expressions out into a separate class.
  // This should remove the need for HasBindingExpressions
  @Nullable
  BindingExpression getBindingExpression(BindingKey bindingKey);

  /** Returns the expression used to initialize a binding expression field. */
  CodeBlock getFieldInitialization(BindingExpression bindingExpression);

  /** Adds the given field to the component. */
  void addField(FieldSpec fieldSpec);

  /** Adds the given code block to the initialize methods of the component. */
  void addInitialization(CodeBlock codeBlock);

  /**
   * Returns the {@code private} members injection method that injects objects with the {@code key}.
   */
  MethodSpec getMembersInjectionMethod(Key key);
}
