package com.tencent.mm.performance.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b hQi;
  public volatile boolean hQj = false;
  
  static
  {
    AppMethodBeat.i(73328);
    hQi = new b();
    AppMethodBeat.o(73328);
  }
  
  public final void init()
  {
    AppMethodBeat.i(73327);
    try
    {
      if (!this.hQj)
      {
        System.loadLibrary("wxperf");
        this.hQj = true;
      }
      AppMethodBeat.o(73327);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.hQj = false;
      AppMethodBeat.o(73327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.jni.b
 * JD-Core Version:    0.7.0.1
 */