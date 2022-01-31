package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.sdk.platformtools.y;

final class f$2
  implements k.a
{
  f$2(f paramf, boolean paramBoolean, long paramLong, String paramString1, String paramString2) {}
  
  public final void fM(String paramString)
  {
    y.e("MicroMsg.AppBrandJSContextInterfaceWC", "create with appID(%s), scriptPath(%s), sdkScript inject failed", new Object[] { this.fxM.fxC.mAppId, this.fxI });
    this.fxM.cC(false);
  }
  
  public final void onSuccess(String paramString)
  {
    a.aov();
    b.a(this.fxN, this.fxM.fxC.mAppId, this.fxK, this.fxI, this.fxO.length());
    y.i("MicroMsg.AppBrandJSContextInterfaceWC", "create with appID(%s), scriptPath(%s), sdkScript inject succeed", new Object[] { this.fxM.fxC.mAppId, this.fxI });
    this.fxM.cC(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.2
 * JD-Core Version:    0.7.0.1
 */