package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.mm.ah.a.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.b.d.d;
import com.tencent.mm.plugin.appbrand.launching.j.d;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.vending.g.b;
import java.util.concurrent.atomic.AtomicBoolean;

final class i$2$1
  implements j.d
{
  i$2$1(i.2 param2, boolean paramBoolean, int paramInt, AtomicBoolean paramAtomicBoolean, b paramb) {}
  
  public final void a(a.a<ane> parama)
  {
    if (!com.tencent.mm.plugin.appbrand.n.a.b(parama)) {
      if (!this.fFh) {
        break label49;
      }
    }
    label49:
    for (int i = 50;; i = 49)
    {
      parama = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(this.fFi, i);
      this.fFz.set(true);
      this.fFj.resume();
      return;
    }
  }
  
  public final void b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (paramWxaPkgWrappingInfo != null) {
      ((d)e.G(d.class)).a(this.fFA.fFy, new String[0]);
    }
    if (this.fFz.get()) {
      return;
    }
    int i;
    if (paramWxaPkgWrappingInfo != null) {
      if (this.fFh) {
        i = 52;
      }
    }
    for (;;)
    {
      paramWxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(this.fFi, i);
      this.fFj.resume();
      return;
      i = 47;
      continue;
      if (this.fFh) {
        i = 53;
      } else {
        i = 48;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.i.2.1
 * JD-Core Version:    0.7.0.1
 */