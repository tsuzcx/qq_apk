package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ConcurrentV8$1
  implements V8Runnable
{
  ConcurrentV8$1(ConcurrentV8 paramConcurrentV8) {}
  
  public void run(V8 paramV8)
  {
    AppMethodBeat.i(75029);
    if ((paramV8 != null) && (!paramV8.isReleased())) {
      paramV8.release();
    }
    AppMethodBeat.o(75029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.utils.ConcurrentV8.1
 * JD-Core Version:    0.7.0.1
 */