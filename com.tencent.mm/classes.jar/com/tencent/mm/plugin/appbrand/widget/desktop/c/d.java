package com.tencent.mm.plugin.appbrand.widget.desktop.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public enum d
{
  private WeakReference<Context> gbi;
  public HashMap<Integer, b> gbj;
  public final Object gbl;
  public boolean isRunning;
  public Timer mTimer;
  
  static
  {
    AppMethodBeat.i(49862);
    mAj = new d("INSTANCE");
    mAk = new d[] { mAj };
    AppMethodBeat.o(49862);
  }
  
  private d()
  {
    AppMethodBeat.i(49859);
    this.gbi = null;
    this.gbj = new HashMap();
    this.isRunning = false;
    this.mTimer = null;
    this.gbl = new Object();
    AppMethodBeat.o(49859);
  }
  
  public final void aeu()
  {
    AppMethodBeat.i(49860);
    synchronized (this.gbl)
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
    ac.i("MicroMsg.PerformanceMonitor", "alvinluo PerformanceMonitor release");
    if (this.gbj != null) {
      this.gbj.clear();
    }
    AppMethodBeat.o(49861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.d
 * JD-Core Version:    0.7.0.1
 */