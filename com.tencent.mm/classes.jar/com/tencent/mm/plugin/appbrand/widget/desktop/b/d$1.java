package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;

public final class d$1
  extends TimerTask
{
  public d$1(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(134244);
    synchronized (d.a(this.jiS))
    {
      if (d.b(this.jiS))
      {
        Iterator localIterator = d.c(this.jiS).values().iterator();
        if (!localIterator.hasNext()) {
          break label89;
        }
        ((b)localIterator.next()).Pw();
      }
    }
    ab.w("MicroMsg.PerformanceMonitor", "hy: already stopped");
    cancel();
    label89:
    AppMethodBeat.o(134244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.d.1
 * JD-Core Version:    0.7.0.1
 */