package com.tencent.mm.plugin.appbrand.performance;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.c.d;

public enum b$a
{
  private volatile HandlerThread mThread;
  
  static
  {
    AppMethodBeat.i(317247);
    tDJ = new a("INST");
    tDK = new a[] { tDJ };
    AppMethodBeat.o(317247);
  }
  
  private b$a() {}
  
  public final HandlerThread cGG()
  {
    AppMethodBeat.i(317248);
    if (this.mThread == null) {}
    try
    {
      if (this.mThread == null)
      {
        this.mThread = d.jz("MicroMsg.AppBrandPerformanceManager.DumpTraceThread", 5);
        this.mThread.start();
      }
      HandlerThread localHandlerThread = this.mThread;
      AppMethodBeat.o(317248);
      return localHandlerThread;
    }
    finally
    {
      AppMethodBeat.o(317248);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b.a
 * JD-Core Version:    0.7.0.1
 */