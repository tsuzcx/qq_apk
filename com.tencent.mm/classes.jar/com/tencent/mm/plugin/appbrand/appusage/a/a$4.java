package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$4
  implements a.a
{
  private int fIQ = 0;
  
  a$4(a parama, PBool paramPBool1, PBool paramPBool2) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    com.tencent.mm.plugin.appbrand.v.c.aa(this);
    com.tencent.mm.modelgeo.c.Ob().c(this);
    paramInt = this.fIQ + 1;
    this.fIQ = paramInt;
    if ((paramInt > 1) || (this.fIP.value)) {
      return false;
    }
    this.fIO.value = true;
    a.c(this.fKw);
    if (!paramBoolean)
    {
      y.i("MicroMsg.AppBrandRecommendLogic", "onGetLocation, fail");
      a.d(this.fKw);
      return false;
    }
    y.i("MicroMsg.AppBrandRecommendLogic", "onGetLocation, success");
    a.a(this.fKw, paramFloat2);
    a.b(this.fKw, paramFloat1);
    a.c(this.fKw, bk.UY());
    a.d(this.fKw);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.a.4
 * JD-Core Version:    0.7.0.1
 */