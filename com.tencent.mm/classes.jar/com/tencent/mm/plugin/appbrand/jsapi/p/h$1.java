package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    synchronized (h.a(this.gBj))
    {
      if (h.a(this.gBj).isEmpty()) {
        return;
      }
      l locall = (l)h.a(this.gBj).remove(0);
      int i = h.a(this.gBj).size();
      locall.dispatch();
      y.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", new Object[] { locall.getName(), Integer.valueOf(i) });
    }
    synchronized (h.a(this.gBj))
    {
      boolean bool = h.a(this.gBj).isEmpty();
      if (!bool)
      {
        c.DS().k(this, h.access$200());
        return;
        localObject1 = finally;
        throw localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.h.1
 * JD-Core Version:    0.7.0.1
 */