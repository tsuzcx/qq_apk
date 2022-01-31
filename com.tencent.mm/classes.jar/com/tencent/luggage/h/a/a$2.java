package com.tencent.luggage.h.a;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    synchronized (a.e(this.bjr))
    {
      y.d("MicroMsg.DefaultTencentLocationManager", "pendingPerWgsListener.size:%d, pendingPerGcjListener.size:%d", new Object[] { Integer.valueOf(a.f(this.bjr).size()), Integer.valueOf(a.g(this.bjr).size()) });
      if (a.g(this.bjr).size() > 0) {
        a.c(this.bjr).addAll(a.g(this.bjr));
      }
      if (a.f(this.bjr).size() > 0) {
        a.c(this.bjr).addAll(a.f(this.bjr));
      }
      a.d(this.bjr);
      if ((a.f(this.bjr).size() <= 0) && (a.g(this.bjr).size() <= 0)) {
        return;
      }
      this.bjr.bjo.k(a.h(this.bjr), 2000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.h.a.a.2
 * JD-Core Version:    0.7.0.1
 */