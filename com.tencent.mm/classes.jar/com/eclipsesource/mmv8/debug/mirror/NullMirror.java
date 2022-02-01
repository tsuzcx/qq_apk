package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;

public class NullMirror
  extends ValueMirror
{
  NullMirror(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public boolean isNull()
  {
    return true;
  }
  
  public String toString()
  {
    return "null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.mirror.NullMirror
 * JD-Core Version:    0.7.0.1
 */