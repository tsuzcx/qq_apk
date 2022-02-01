package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;

public class UndefinedMirror
  extends ValueMirror
{
  UndefinedMirror(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public boolean isUndefined()
  {
    return true;
  }
  
  public String toString()
  {
    return "undefined";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.mirror.UndefinedMirror
 * JD-Core Version:    0.7.0.1
 */