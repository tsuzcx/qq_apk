package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$3
  implements am.a
{
  a$3(a parama, PBool paramPBool1, PBool paramPBool2) {}
  
  public final boolean tC()
  {
    if (this.fIO.value) {
      return false;
    }
    this.fIP.value = true;
    a.c(this.fKw);
    y.i("MicroMsg.AppBrandRecommendLogic", "onTimerExpired");
    a.d(this.fKw);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.a.3
 * JD-Core Version:    0.7.0.1
 */