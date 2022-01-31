package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.sdk.platformtools.y;

final class r$c$1$1
  implements w.a
{
  r$c$1$1(r.c.1 param1, float paramFloat1, float paramFloat2, double paramDouble) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "locationReport, errType %d, errCode %d, errMsg %s, longitude %f, latitude %f, accuracy %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Float.valueOf(this.fJf), Float.valueOf(this.fJg), Double.valueOf(this.elS) });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r.c.1.1
 * JD-Core Version:    0.7.0.1
 */