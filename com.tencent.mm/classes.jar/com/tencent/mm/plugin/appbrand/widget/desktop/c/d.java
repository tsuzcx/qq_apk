package com.tencent.mm.plugin.appbrand.widget.desktop.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public enum d
{
  private WeakReference<Context> fWB;
  public HashMap<Integer, b> fWC;
  public final Object fWE;
  public boolean isRunning;
  public Timer mTimer;
  
  static
  {
    AppMethodBeat.i(49862);
    lYh = new d("INSTANCE");
    lYi = new d[] { lYh };
    AppMethodBeat.o(49862);
  }
  
  private d()
  {
    AppMethodBeat.i(49859);
    this.fWB = null;
    this.fWC = new HashMap();
    this.isRunning = false;
    this.mTimer = null;
    this.fWE = new Object();
    AppMethodBeat.o(49859);
  }
  
  public final void ade()
  {
    AppMethodBeat.i(49860);
    synchronized (this.fWE)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(49860);
        return;
      }
      if (this.mTimer != null) {
        this.mTimer.cancel();
      }
      this.isRunning = false;
      AppMethodBeat.o(49860);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(49861);
    ad.i("MicroMsg.PerformanceMonitor", "alvinluo PerformanceMonitor release");
    if (this.fWC != null) {
      this.fWC.clear();
    }
    AppMethodBeat.o(49861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.d
 * JD-Core Version:    0.7.0.1
 */