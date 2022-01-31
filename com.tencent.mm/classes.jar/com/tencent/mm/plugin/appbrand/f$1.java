package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.v.k.a;

final class f$1
  implements k.a
{
  f$1(f paramf, String paramString1, String paramString2, long paramLong, k.a parama) {}
  
  public final void fM(String paramString)
  {
    if (this.fxL != null) {
      this.fxL.fM(paramString);
    }
  }
  
  public final void onSuccess(String paramString)
  {
    a.b(this.fxM.fxC.mAppId, this.fxG, this.fxJ, this.fxK);
    if (this.fxL != null) {
      this.fxL.onSuccess(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.1
 * JD-Core Version:    0.7.0.1
 */