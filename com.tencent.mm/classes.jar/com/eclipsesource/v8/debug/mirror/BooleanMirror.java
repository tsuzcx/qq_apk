package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

public class BooleanMirror
  extends ValueMirror
{
  BooleanMirror(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public boolean isBoolean()
  {
    return true;
  }
  
  public String toString()
  {
    return this.v8Object.executeStringFunction("toText", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.BooleanMirror
 * JD-Core Version:    0.7.0.1
 */