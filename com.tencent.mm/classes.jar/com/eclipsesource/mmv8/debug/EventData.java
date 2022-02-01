package com.eclipsesource.mmv8.debug;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EventData
  implements Releasable
{
  protected V8Object v8Object;
  
  EventData(V8Object paramV8Object)
  {
    AppMethodBeat.i(61472);
    this.v8Object = paramV8Object.twin();
    AppMethodBeat.o(61472);
  }
  
  public void release()
  {
    AppMethodBeat.i(61473);
    if (!this.v8Object.isReleased()) {
      this.v8Object.release();
    }
    AppMethodBeat.o(61473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.EventData
 * JD-Core Version:    0.7.0.1
 */