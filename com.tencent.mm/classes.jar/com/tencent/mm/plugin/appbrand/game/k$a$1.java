package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.quality.a;

final class k$a$1
  implements com.tencent.mm.plugin.appbrand.v.k.a
{
  k$a$1(k.a parama, String paramString1, String paramString2, long paramLong, com.tencent.mm.plugin.appbrand.v.k.a parama1) {}
  
  public final void fM(String paramString)
  {
    if (this.fxL != null) {
      this.fxL.fM(paramString);
    }
  }
  
  public final void onSuccess(String paramString)
  {
    a.b(this.gau.fxC.mAppId, this.fxG, this.fxJ, this.eow);
    if (this.fxL != null) {
      this.fxL.onSuccess(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.k.a.1
 * JD-Core Version:    0.7.0.1
 */