package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
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
    AppMethodBeat.i(74911);
    Object localObject = this.v8Object.executeFunction("value", null);
    AppMethodBeat.o(74911);
    return localObject;
  }
  
  public boolean isValue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.ValueMirror
 * JD-Core Version:    0.7.0.1
 */