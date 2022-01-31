package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8ResultUndefined;

public class Mirror
  implements Releasable
{
  private static final String IS_ARRAY = "isArray";
  private static final String IS_BOOLEAN = "isBoolean";
  private static final String IS_FUNCTION = "isFunction";
  private static final String IS_NULL = "isNull";
  private static final String IS_NUMBER = "isNumber";
  private static final String IS_OBJECT = "isObject";
  private static final String IS_STRING = "isString";
  private static final String IS_UNDEFINED = "isUndefined";
  private static final String IS_VALUE = "isValue";
  protected V8Object v8Object;
  
  Mirror(V8Object paramV8Object)
  {
    this.v8Object = paramV8Object.twin();
  }
  
  protected static ValueMirror createMirror(V8Object paramV8Object)
  {
    if (isNull(paramV8Object)) {
      return new NullMirror(paramV8Object);
    }
    if (isUndefined(paramV8Object)) {
      return new UndefinedMirror(paramV8Object);
    }
    if (isFunction(paramV8Object)) {
      return new FunctionMirror(paramV8Object);
    }
    if (isArray(paramV8Object)) {
      return new ArrayMirror(paramV8Object);
    }
    if (isObject(paramV8Object)) {
      return new ObjectMirror(paramV8Object);
    }
    if (isString(paramV8Object)) {
      return new StringMirror(paramV8Object);
    }
    if (isNumber(paramV8Object)) {
      return new NumberMirror(paramV8Object);
    }
    if (isBoolean(paramV8Object)) {
      return new BooleanMirror(paramV8Object);
    }
    return new ValueMirror(paramV8Object);
  }
  
  private static boolean isArray(V8Object paramV8Object)
  {
    try
    {
      boolean bool = paramV8Object.executeBooleanFunction("isArray", null);
      return bool;
    }
    catch (V8ResultUndefined paramV8Object) {}
    return false;
  }
  
  private static boolean isBoolean(V8Object paramV8Object)
  {
    try
    {
      boolean bool = paramV8Object.executeBooleanFunction("isBoolean", null);
      return bool;
    }
    catch (V8ResultUndefined paramV8Object) {}
    return false;
  }
  
  private static boolean isFunction(V8Object paramV8Object)
  {
    try
    {
      boolean bool = paramV8Object.executeBooleanFunction("isFunction", null);
      return bool;
    }
    catch (V8ResultUndefined paramV8Object) {}
    return false;
  }
  
  private static boolean isNull(V8Object paramV8Object)
  {
    try
    {
      boolean bool = paramV8Object.executeBooleanFunction("isNull", null);
      return bool;
    }
    catch (V8ResultUndefined paramV8Object) {}
    return false;
  }
  
  private static boolean isNumber(V8Object paramV8Object)
  {
    try
    {
      boolean bool = paramV8Object.executeBooleanFunction("isNumber", null);
      return bool;
    }
    catch (V8ResultUndefined paramV8Object) {}
    return false;
  }
  
  private static boolean isObject(V8Object paramV8Object)
  {
    try
    {
      boolean bool = paramV8Object.executeBooleanFunction("isObject", null);
      return bool;
    }
    catch (V8ResultUndefined paramV8Object) {}
    return false;
  }
  
  private static boolean isString(V8Object paramV8Object)
  {
    try
    {
      boolean bool = paramV8Object.executeBooleanFunction("isString", null);
      return bool;
    }
    catch (V8ResultUndefined paramV8Object) {}
    return false;
  }
  
  private static boolean isUndefined(V8Object paramV8Object)
  {
    try
    {
      boolean bool = paramV8Object.executeBooleanFunction("isUndefined", null);
      return bool;
    }
    catch (V8ResultUndefined paramV8Object) {}
    return false;
  }
  
  protected static boolean isValue(V8Object paramV8Object)
  {
    try
    {
      boolean bool = paramV8Object.executeBooleanFunction("isValue", null);
      return bool;
    }
    catch (V8ResultUndefined paramV8Object) {}
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof Mirror)) {
      return false;
    }
    return this.v8Object.equals(((Mirror)paramObject).v8Object);
  }
  
  public int hashCode()
  {
    return this.v8Object.hashCode();
  }
  
  public boolean isArray()
  {
    return false;
  }
  
  public boolean isBoolean()
  {
    return false;
  }
  
  public boolean isFrame()
  {
    return false;
  }
  
  public boolean isFunction()
  {
    return false;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isNumber()
  {
    return false;
  }
  
  public boolean isObject()
  {
    return false;
  }
  
  public boolean isProperty()
  {
    return false;
  }
  
  public boolean isString()
  {
    return false;
  }
  
  public boolean isUndefined()
  {
    return this.v8Object.executeBooleanFunction("isUndefined", null);
  }
  
  public boolean isValue()
  {
    return false;
  }
  
  public void release()
  {
    if ((this.v8Object != null) && (!this.v8Object.isReleased()))
    {
      this.v8Object.release();
      this.v8Object = null;
    }
  }
  
  public String toString()
  {
    return this.v8Object.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.Mirror
 * JD-Core Version:    0.7.0.1
 */