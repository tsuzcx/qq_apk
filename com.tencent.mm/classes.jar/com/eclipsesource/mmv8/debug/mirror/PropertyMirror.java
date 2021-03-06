package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PropertyMirror
  extends Mirror
{
  PropertyMirror(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public String getName()
  {
    AppMethodBeat.i(61520);
    String str = this.v8Object.executeStringFunction("name", null);
    AppMethodBeat.o(61520);
    return str;
  }
  
  public Mirror getValue()
  {
    AppMethodBeat.i(61521);
    V8Object localV8Object = this.v8Object.executeObjectFunction("value", null);
    try
    {
      ValueMirror localValueMirror = createMirror(localV8Object);
      return localValueMirror;
    }
    finally
    {
      localV8Object.release();
      AppMethodBeat.o(61521);
    }
  }
  
  public boolean isProperty()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.mirror.PropertyMirror
 * JD-Core Version:    0.7.0.1
 */