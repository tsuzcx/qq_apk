package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

public class FunctionMirror
  extends ObjectMirror
{
  private static final String NAME = "name";
  private static final String SCRIPT = "script";
  
  FunctionMirror(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public String getName()
  {
    return this.v8Object.executeStringFunction("name", null);
  }
  
  public String getScriptName()
  {
    V8Object localV8Object = this.v8Object.executeObjectFunction("script", null);
    try
    {
      String str = localV8Object.executeStringFunction("name", null);
      return str;
    }
    finally
    {
      localV8Object.release();
    }
  }
  
  public boolean isFunction()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.FunctionMirror
 * JD-Core Version:    0.7.0.1
 */