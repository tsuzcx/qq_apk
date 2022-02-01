package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ValueMirror
  extends Mirror
{
  private static final String VALUE = "value";
  
  ValueMirror(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public Object getValue()
  {
    AppMethodBeat.i(61534);
    Object localObject = this.v8Object.executeFunction("value", null);
    AppMethodBeat.o(61534);
    return localObject;
  }
  
  public boolean isValue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.mirror.ValueMirror
 * JD-Core Version:    0.7.0.1
 */