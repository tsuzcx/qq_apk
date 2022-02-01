package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PropertiesArray
  implements Releasable
{
  private V8Array v8Array;
  
  PropertiesArray(V8Array paramV8Array)
  {
    AppMethodBeat.i(61516);
    this.v8Array = paramV8Array.twin();
    AppMethodBeat.o(61516);
  }
  
  public PropertyMirror getProperty(int paramInt)
  {
    AppMethodBeat.i(61517);
    V8Object localV8Object = this.v8Array.getObject(paramInt);
    try
    {
      PropertyMirror localPropertyMirror = new PropertyMirror(localV8Object);
      return localPropertyMirror;
    }
    finally
    {
      localV8Object.release();
      AppMethodBeat.o(61517);
    }
  }
  
  public int length()
  {
    AppMethodBeat.i(61519);
    int i = this.v8Array.length();
    AppMethodBeat.o(61519);
    return i;
  }
  
  public void release()
  {
    AppMethodBeat.i(61518);
    if (!this.v8Array.isReleased()) {
      this.v8Array.release();
    }
    AppMethodBeat.o(61518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.mirror.PropertiesArray
 * JD-Core Version:    0.7.0.1
 */