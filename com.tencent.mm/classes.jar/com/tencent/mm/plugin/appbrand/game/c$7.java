package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class c$7
  implements k.a
{
  c$7(c paramc) {}
  
  public final void fM(String paramString)
  {
    y.e("MicroMsg.WAGameAppService", "Inject SDK game Script Failed: %s", new Object[] { paramString });
    if (this.fZR.getRuntime() != null) {
      this.fZR.getRuntime().fzG.n(12, System.currentTimeMillis() - c.l(this.fZR));
    }
    h.nFQ.a(778L, 26L, 1L, false);
    com.tencent.mm.plugin.appbrand.report.c.H(this.fZR.mAppId, 24, 0);
    com.tencent.mm.plugin.appbrand.report.c.a(this.fZR.mAppId, this.fZR.getRuntime().aaa().fPS.fEN, this.fZR.getRuntime().aaa().fPS.fEM, 778, 26);
  }
  
  public final void onSuccess(String paramString)
  {
    y.i("MicroMsg.WAGameAppService", "Inject SDK game Script suc: %s", new Object[] { paramString });
    if (this.fZR.getRuntime() != null) {
      this.fZR.getRuntime().fzG.n(12, System.currentTimeMillis() - c.l(this.fZR));
    }
    h.nFQ.a(778L, 27L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.7
 * JD-Core Version:    0.7.0.1
 */