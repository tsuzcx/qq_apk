package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class p$8$1
  implements k.a
{
  p$8$1(p.8 param8) {}
  
  public final void fM(String paramString)
  {
    y.e("MicroMsg.AppBrandService", "inject module(%s) script failed: %s", new Object[] { this.fAi.fAh, paramString });
    h.nFQ.a(370L, 32L, 1L, false);
  }
  
  public final void onSuccess(String paramString)
  {
    h.nFQ.a(370L, 31L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.8.1
 * JD-Core Version:    0.7.0.1
 */