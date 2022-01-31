package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;

public enum d
{
  private WeakReference<Context> eAW;
  public HashMap<Integer, b> eAX;
  public final Object eAY;
  public boolean isRunning;
  public Timer mTimer;
  
  static
  {
    AppMethodBeat.i(134250);
    jiQ = new d("INSTANCE");
    jiR = new d[] { jiQ };
    AppMethodBeat.o(134250);
  }
  
  private d()
  {
    AppMethodBeat.i(134247);
    this.eAW = null;
    this.eAX = new HashMap();
    this.isRunning = false;
    this.mTimer = null;
    this.eAY = new Object();
    AppMethodBeat.o(134247);
  }
  
  public final void Py()
  {
    AppMethodBeat.i(134248);
    synchronized (this.eAY)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(134248);
        return;
      }
      if (this.mTimer != null) {
        this.mTimer.cancel();
      }
      this.isRunning = false;
      AppMethodBeat.o(134248);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(134249);
    ab.i("MicroMsg.PerformanceMonitor", "alvinluo PerformanceMonitor release");
    if (this.eAX != null) {
      this.eAX.clear();
    }
    AppMethodBeat.o(134249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.d
 * JD-Core Version:    0.7.0.1
 */