package com.tencent.mm.plugin.appbrand.performance;

import android.os.HandlerThread;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a
{
  private volatile HandlerThread mThread;
  
  static
  {
    AppMethodBeat.i(278976);
    qyO = new a("INST");
    qyP = new a[] { qyO };
    AppMethodBeat.o(278976);
  }
  
  private b$a() {}
  
  public final HandlerThread cfU()
  {
    AppMethodBeat.i(278974);
    if (this.mThread == null) {}
    try
    {
      if (this.mThread == null)
      {
        this.mThread = d.bDk("MicroMsg.AppBrandPerformanceManager.DumpTraceThread");
        this.mThread.start();
      }
      HandlerThread localHandlerThread = this.mThread;
      AppMethodBeat.o(278974);
      return localHandlerThread;
    }
    finally
    {
      AppMethodBeat.o(278974);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b.a
 * JD-Core Version:    0.7.0.1
 */