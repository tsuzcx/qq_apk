package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class p$5
  implements k.a
{
  p$5(p paramp, boolean paramBoolean, long paramLong, int paramInt) {}
  
  public final void fM(String paramString)
  {
    int j = 0;
    y.e("MicroMsg.AppBrandService", "Inject SDK Service Script Failed: %s, wx.version = %s", new Object[] { paramString, WxaCommLibRuntimeReader.abP().abC() });
    h.nFQ.a(370L, 6L, 1L, false);
    c.H(this.fAc.mAppId, 24, 0);
    int i = -1;
    if (p.a(this.fAc) != null)
    {
      j = p.a(this.fAc).aaa().fPS.fEN;
      i = p.a(this.fAc).aaa().fPS.fEM;
    }
    c.a(this.fAc.mAppId, j, i, 370, 6);
  }
  
  public final void onSuccess(String paramString)
  {
    y.i("MicroMsg.AppBrandService", "Inject SDK Service Script Success wx.version = %s", new Object[] { WxaCommLibRuntimeReader.abP().abC() });
    a.aov();
    b.a(this.fxN, this.fAc.mAppId, this.fAe, "WAService.js", this.fAf);
    h.nFQ.a(370L, 7L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.5
 * JD-Core Version:    0.7.0.1
 */