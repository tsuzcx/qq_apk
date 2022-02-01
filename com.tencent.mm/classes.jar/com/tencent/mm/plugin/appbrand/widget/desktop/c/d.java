package com.tencent.mm.plugin.appbrand.widget.desktop.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public enum d
{
  public HashMap<Integer, b> gxA;
  public final Object gxC;
  private WeakReference<Context> gxz;
  public boolean isRunning;
  public Timer mTimer;
  
  static
  {
    AppMethodBeat.i(49862);
    nfZ = new d("INSTANCE");
    nga = new d[] { nfZ };
    AppMethodBeat.o(49862);
  }
  
  private d()
  {
    AppMethodBeat.i(49859);
    this.gxz = null;
    this.gxA = new HashMap();
    this.isRunning = false;
    this.mTimer = null;
    this.gxC = new Object();
    AppMethodBeat.o(49859);
  }
  
  public final void ahv()
  {
    AppMethodBeat.i(49860);
    synchronized (this.gxC)
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
    ae.i("MicroMsg.PerformanceMonitor", "alvinluo PerformanceMonitor release");
    if (this.gxA != null) {
      this.gxA.clear();
    }
    AppMethodBeat.o(49861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.d
 * JD-Core Version:    0.7.0.1
 */