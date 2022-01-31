package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class Frame
  extends Mirror
{
  private static final String ARGUMENT_COUNT = "argumentCount";
  private static final String ARGUMENT_NAME = "argumentName";
  private static final String ARGUMENT_VALUE = "argumentValue";
  private static final String COLUMN = "column";
  private static final String FUNC = "func";
  private static final String LINE = "line";
  private static final String LOCAL_COUNT = "localCount";
  private static final String LOCAL_NAME = "localName";
  private static final String LOCAL_VALUE = "localValue";
  private static final String NAME = "name";
  private static final String POSITION = "position";
  private static final String SCOPE = "scope";
  private static final String SCOPE_COUNT = "scopeCount";
  private static final String SCRIPT = "script";
  private static final String SOURCE_LOCATION = "sourceLocation";
  private static final String SOURCE_TEXT = "sourceText";
  
  public Frame(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public int getArgumentCount()
  {
    return this.v8Object.executeIntegerFunction("argumentCount", null);
  }
  
  public String getArgumentName(int paramInt)
  {
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramInt);
    try
    {
      String str = this.v8Object.executeStringFunction("argumentName", localV8Array);
      return str;
    }
    finally
    {
      localV8Array.release();
    }
  }
  
  public ValueMirror getArgumentValue(int paramInt)
  {
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramInt);
    Object localObject = null;
    try
    {
      V8Object localV8Object1 = this.v8Object.executeObjectFunction("argumentValue", localV8Array);
      localObject = localV8Object1;
      if (!isValue(localV8Object1))
      {
        localObject = localV8Object1;
        throw new IllegalStateException("Argument value is not a ValueMirror");
      }
    }
    finally
    {
      localV8Array.release();
      if (localObject != null) {
        localObject.release();
      }
    }
    localObject = localV8Object2;
    ValueMirror localValueMirror = new ValueMirror(localV8Object2);
    localV8Array.release();
    if (localV8Object2 != null) {
      localV8Object2.release();
    }
    return localValueMirror;
  }
  
  public FunctionMirror getFunction()
  {
    Object localObject1 = null;
    try
    {
      V8Object localV8Object = this.v8Object.executeObjectFunction("func", null);
      localObject1 = localV8Object;
      FunctionMirror localFunctionMirror = new FunctionMirror(localV8Object);
      return localFunctionMirror;
    }
    finally
    {
      if (localObject1 != null) {
        localObject1.release();
      }
    }
  }
  
  public int getLocalCount()
  {
    return this.v8Object.executeIntegerFunction("localCount", null);
  }
  
  public String getLocalName(int paramInt)
  {
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramInt);
    try
    {
      String str = this.v8Object.executeStringFunction("localName", localV8Array);
      return str;
    }
    finally
    {
      localV8Array.release();
    }
  }
  
  public ValueMirror getLocalValue(int paramInt)
  {
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramInt);
    Object localObject = null;
    try
    {
      V8Object localV8Object1 = this.v8Object.executeObjectFunction("localValue", localV8Array);
      localObject = localV8Object1;
      if (!isValue(localV8Object1))
      {
        localObject = localV8Object1;
        throw new IllegalStateException("Local value is not a ValueMirror");
      }
    }
    finally
    {
      localV8Array.release();
      if (localObject != null) {
        localObject.release();
      }
    }
    localObject = localV8Object2;
    ValueMirror localValueMirror = createMirror(localV8Object2);
    localV8Array.release();
    if (localV8Object2 != null) {
      localV8Object2.release();
    }
    return localValueMirror;
  }
  
  public Scope getScope(int paramInt)
  {
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramInt);
    Object localObject1 = null;
    try
    {
      V8Object localV8Object = this.v8Object.executeObjectFunction("scope", localV8Array);
      localObject1 = localV8Object;
      Scope localScope = new Scope(localV8Object);
      return localScope;
    }
    finally
    {
      localV8Array.release();
      if (localObject1 != null) {
        localObject1.release();
      }
    }
  }
  
  public int getScopeCount()
  {
    return this.v8Object.executeIntegerFunction("scopeCount", null);
  }
  
  public SourceLocation getSourceLocation()
  {
    V8Object localV8Object1 = this.v8Object.executeObjectFunction("sourceLocation", null);
    FunctionMirror localFunctionMirror = getFunction();
    String str2 = localFunctionMirror.getScriptName();
    for (;;)
    {
      try
      {
        V8Object localV8Object2 = (V8Object)localV8Object1.get("script");
        if (localV8Object2 == null) {
          break label117;
        }
        localObject1 = localV8Object2.getString("name");
        localV8Object2.release();
      }
      finally
      {
        Object localObject1;
        localFunctionMirror.release();
        localV8Object1.release();
      }
      localObject1 = new SourceLocation((String)localObject1, localV8Object1.getInteger("position"), localV8Object1.getInteger("line"), localV8Object1.getInteger("column"), localV8Object1.getString("sourceText"));
      localFunctionMirror.release();
      localV8Object1.release();
      return localObject1;
      localObject1 = "undefined";
      continue;
      label117:
      String str1 = null;
      if ((str1 == null) && (str2 != null)) {
        str1 = str2;
      }
    }
  }
  
  public boolean isFrame()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.Frame
 * JD-Core Version:    0.7.0.1
 */