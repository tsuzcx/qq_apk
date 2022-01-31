package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class p$7
  implements k.a
{
  p$7(p paramp, String paramString, long paramLong) {}
  
  public final void fM(String paramString)
  {
    y.e("MicroMsg.AppBrandService", "Inject External Service Script Failed: %s", new Object[] { paramString });
    try
    {
      h.nFQ.a(370L, 10L, 1L, false);
      c.H(this.fAc.mAppId, 24, 0);
      c.a(this.fAc.mAppId, p.a(this.fAc).aaa().fPS.fEN, p.a(this.fAc).aaa().fPS.fEM, 370, 10);
      return;
    }
    catch (NullPointerException paramString)
    {
      y.e("MicroMsg.AppBrandService", "Inject External Service Script Failed, report npe = %s", new Object[] { paramString });
    }
  }
  
  public final void onSuccess(String paramString)
  {
    a.b(this.fAc.mAppId, "app-service.js", this.fAg, this.fxK);
    h.nFQ.a(370L, 11L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.7
 * JD-Core Version:    0.7.0.1
 */