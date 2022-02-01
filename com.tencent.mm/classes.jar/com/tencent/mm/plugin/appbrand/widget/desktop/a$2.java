package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.d;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.d.1;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Timer;

final class a$2
  extends b
{
  a$2(a parama) {}
  
  public final String getKey()
  {
    return "MicroMsg.AppBrandDesktopAnimController#startMonitorRunnable";
  }
  
  public final void run()
  {
    AppMethodBeat.i(49386);
    d locald;
    if (!c.lYe.fWx)
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStart performanceMonitor");
      ??? = c.lYe;
      if (!((c)???).fWx)
      {
        ((c)???).fWx = true;
        ad.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { bt.eGN() });
        ((c)???).adb().postFrameCallback((Choreographer.FrameCallback)???);
      }
      locald = d.lYh;
    }
    synchronized (locald.fWE)
    {
      if (locald.isRunning)
      {
        ad.w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
        a.n(this.lSQ);
        AppMethodBeat.o(49386);
        return;
      }
      if (locald.mTimer != null) {
        locald.mTimer.cancel();
      }
      System.gc();
      locald.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
      locald.fWC.clear();
      locald.fWC.put(Integer.valueOf(1), new com.tencent.mm.plugin.appbrand.widget.desktop.c.a());
      locald.mTimer.scheduleAtFixedRate(new d.1(locald), 0L, 5L);
      locald.isRunning = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.2
 * JD-Core Version:    0.7.0.1
 */