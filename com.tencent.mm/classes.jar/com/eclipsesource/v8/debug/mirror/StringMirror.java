package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

public class StringMirror
  extends ValueMirror
{
  StringMirror(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public boolean isString()
  {
    return true;
  }
  
  public String toString()
  {
    return this.v8Object.executeStringFunction("toText", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.StringMirror
 * JD-Core Version:    0.7.0.1
 */