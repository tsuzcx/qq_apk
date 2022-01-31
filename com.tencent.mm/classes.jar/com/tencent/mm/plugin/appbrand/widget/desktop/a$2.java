package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.d;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.d.1;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Timer;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(133666);
    d locald;
    if (!c.jiO.eAT)
    {
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStart performanceMonitor");
      ??? = c.jiO;
      if (!((c)???).eAT)
      {
        ((c)???).eAT = true;
        ab.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { bo.dtY() });
        ((c)???).choreographer.postFrameCallback((Choreographer.FrameCallback)???);
      }
      locald = d.jiQ;
    }
    synchronized (locald.eAY)
    {
      if (locald.isRunning)
      {
        ab.w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
        a.n(this.jcW);
        AppMethodBeat.o(133666);
        return;
      }
      if (locald.mTimer != null) {
        locald.mTimer.cancel();
      }
      System.gc();
      locald.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
      locald.eAX.clear();
      locald.eAX.put(Integer.valueOf(1), new com.tencent.mm.plugin.appbrand.widget.desktop.b.a());
      locald.mTimer.scheduleAtFixedRate(new d.1(locald), 0L, 5L);
      locald.isRunning = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.2
 * JD-Core Version:    0.7.0.1
 */