package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(61533);
    String str = this.v8Object.executeStringFunction("toText", null);
    AppMethodBeat.o(61533);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.StringMirror
 * JD-Core Version:    0.7.0.1
 */