package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c$2
  implements b.a
{
  private int hbI = 0;
  
  c$2(c paramc, PBool paramPBool1, PBool paramPBool2) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(129739);
    e.ai(this);
    d.agQ().c(this);
    paramInt = this.hbI + 1;
    this.hbI = paramInt;
    if ((paramInt > 1) || (this.hbH.value))
    {
      AppMethodBeat.o(129739);
      return false;
    }
    this.hbG.value = true;
    c.a(this.hdd);
    if (!paramBoolean)
    {
      ab.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, fail");
      if (c.b(this.hdd) != null) {
        c.b(this.hdd).J(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(129739);
      return false;
    }
    ab.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
    c.am(paramFloat2);
    c.an(paramFloat1);
    c.ht(bo.aoy());
    if (c.b(this.hdd) != null) {
      c.b(this.hdd).J(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(129739);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c.2
 * JD-Core Version:    0.7.0.1
 */