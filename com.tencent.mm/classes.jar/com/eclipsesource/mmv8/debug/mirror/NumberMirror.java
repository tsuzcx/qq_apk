package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(61509);
    String str = this.v8Object.executeStringFunction("toText", null);
    AppMethodBeat.o(61509);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.mirror.NumberMirror
 * JD-Core Version:    0.7.0.1
 */