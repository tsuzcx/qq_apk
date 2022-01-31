package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.NullMirror
 * JD-Core Version:    0.7.0.1
 */