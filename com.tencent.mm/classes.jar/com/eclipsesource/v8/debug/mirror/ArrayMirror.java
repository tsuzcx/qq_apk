package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

public class ArrayMirror
  extends ObjectMirror
{
  private static final String LENGTH = "length";
  
  ArrayMirror(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public boolean isArray()
  {
    return true;
  }
  
  public int length()
  {
    return this.v8Object.executeIntegerFunction("length", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.ArrayMirror
 * JD-Core Version:    0.7.0.1
 */