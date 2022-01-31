package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.plugin.appbrand.permission.d.b;

final class c$1
  implements d.b
{
  c$1(c paramc, c.a parama, int paramInt, i parami) {}
  
  public final void a(d.a parama)
  {
    if ((this.fxB.fxx == null) || (!this.fxB.fxx.isRunning())) {
      return;
    }
    if (parama.ret == 0)
    {
      this.fxz.proceed();
      return;
    }
    this.fxB.fxx.C(this.dIS, this.fxA.h(parama.bHk, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.1
 * JD-Core Version:    0.7.0.1
 */