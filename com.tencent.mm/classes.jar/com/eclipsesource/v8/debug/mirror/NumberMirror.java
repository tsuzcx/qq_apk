package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

public class NumberMirror
  extends ValueMirror
{
  NumberMirror(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public boolean isNumber()
  {
    return true;
  }
  
  public String toString()
  {
    return this.v8Object.executeStringFunction("toText", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.NumberMirror
 * JD-Core Version:    0.7.0.1
 */