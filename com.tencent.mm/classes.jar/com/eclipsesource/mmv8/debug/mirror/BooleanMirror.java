package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(61480);
    String str = this.v8Object.executeStringFunction("toText", null);
    AppMethodBeat.o(61480);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.mirror.BooleanMirror
 * JD-Core Version:    0.7.0.1
 */