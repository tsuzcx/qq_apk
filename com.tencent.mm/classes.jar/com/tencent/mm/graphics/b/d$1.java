package com.tencent.mm.graphics.b;

import com.tencent.mm.sdk.platformtools.y;
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
    synchronized (d.a(this.dDz))
    {
      if (d.b(this.dDz))
      {
        Iterator localIterator = d.c(this.dDz).values().iterator();
        if (!localIterator.hasNext()) {
          break label79;
        }
        ((a)localIterator.next()).BK();
      }
    }
    y.w("MicroMsg.PerformanceMonitor", "hy: already stopped");
    cancel();
    label79:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.graphics.b.d.1
 * JD-Core Version:    0.7.0.1
 */