package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$1
  implements ap.a
{
  c$1(c paramc, PBool paramPBool1, PBool paramPBool2) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(129738);
    if (this.hbG.value)
    {
      AppMethodBeat.o(129738);
      return false;
    }
    this.hbH.value = true;
    c.a(this.hdd);
    ab.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
    if (c.b(this.hdd) != null) {
      c.b(this.hdd).J(c.axM(), c.axN());
    }
    AppMethodBeat.o(129738);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c.1
 * JD-Core Version:    0.7.0.1
 */