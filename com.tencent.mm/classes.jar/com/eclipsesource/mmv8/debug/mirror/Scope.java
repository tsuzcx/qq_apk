package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Scope
  extends Mirror
{
  private static final String SCOPE_OBJECT = "scopeObject";
  private static final String SCOPE_TYPE = "scopeType";
  private static final String SET_VARIABLE_VALUE = "setVariableValue";
  
  Scope(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public ObjectMirror getScopeObject()
  {
    Object localObject1 = null;
    AppMethodBeat.i(61531);
    try
    {
      V8Object localV8Object = this.v8Object.executeObjectFunction("scopeObject", null);
      localObject1 = localV8Object;
      ObjectMirror localObjectMirror = (ObjectMirror)createMirror(localV8Object);
      return localObjectMirror;
    }
    finally
    {
      if (localObject1 != null) {
        localObject1.release();
      }
      AppMethodBeat.o(61531);
    }
  }
  
  public Scope.ScopeType getType()
  {
    AppMethodBeat.i(61525);
    Scope.ScopeType localScopeType = Scope.ScopeType.values()[this.v8Object.executeIntegerFunction("scopeType", null)];
    AppMethodBeat.o(61525);
    return localScopeType;
  }
  
  public void setVariableValue(String paramString, double paramDouble)
  {
    AppMethodBeat.i(61530);
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramString);
    localV8Array.push(paramDouble);
    try
    {
      this.v8Object.executeVoidFunction("setVariableValue", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61530);
    }
  }
  
  public void setVariableValue(String paramString, int paramInt)
  {
    AppMethodBeat.i(61526);
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramString);
    localV8Array.push(paramInt);
    try
    {
      this.v8Object.executeVoidFunction("setVariableValue", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61526);
    }
  }
  
  public void setVariableValue(String paramString, V8Value paramV8Value)
  {
    AppMethodBeat.i(61527);
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramString);
    localV8Array.push(paramV8Value);
    try
    {
      this.v8Object.executeVoidFunction("setVariableValue", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61527);
    }
  }
  
  public void setVariableValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(61529);
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramString1);
    localV8Array.push(paramString2);
    try
    {
      this.v8Object.executeVoidFunction("setVariableValue", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61529);
    }
  }
  
  public void setVariableValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(61528);
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramString);
    localV8Array.push(paramBoolean);
    try
    {
      this.v8Object.executeVoidFunction("setVariableValue", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61528);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.mirror.Scope
 * JD-Core Version:    0.7.0.1
 */