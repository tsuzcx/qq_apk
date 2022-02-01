package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(61479);
    int i = this.v8Object.executeIntegerFunction("length", null);
    AppMethodBeat.o(61479);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.ArrayMirror
 * JD-Core Version:    0.7.0.1
 */