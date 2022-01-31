package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PropertiesArray
  implements Releasable
{
  private V8Array v8Array;
  
  PropertiesArray(V8Array paramV8Array)
  {
    AppMethodBeat.i(74893);
    this.v8Array = paramV8Array.twin();
    AppMethodBeat.o(74893);
  }
  
  public PropertyMirror getProperty(int paramInt)
  {
    AppMethodBeat.i(74894);
    V8Object localV8Object = this.v8Array.getObject(paramInt);
    try
    {
      PropertyMirror localPropertyMirror = new PropertyMirror(localV8Object);
      return localPropertyMirror;
    }
    finally
    {
      localV8Object.release();
      AppMethodBeat.o(74894);
    }
  }
  
  public int length()
  {
    AppMethodBeat.i(74896);
    int i = this.v8Array.length();
    AppMethodBeat.o(74896);
    return i;
  }
  
  public void release()
  {
    AppMethodBeat.i(74895);
    if (!this.v8Array.isReleased()) {
      this.v8Array.release();
    }
    AppMethodBeat.o(74895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.PropertiesArray
 * JD-Core Version:    0.7.0.1
 */