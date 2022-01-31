package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.sdk.platformtools.y;

final class k$a$2
  implements com.tencent.mm.plugin.appbrand.v.k.a
{
  k$a$2(k.a parama, String paramString1, boolean paramBoolean, long paramLong, String paramString2) {}
  
  public final void fM(String paramString)
  {
    y.e("MicroMsg.WAGameWeixinJSContextLogic", "create with appID(%s), scriptPath(%s), sdkScript inject failed", new Object[] { this.gau.fxC.mAppId, this.fxI });
    this.gau.cC(false);
  }
  
  public final void onSuccess(String paramString)
  {
    y.i("MicroMsg.WAGameWeixinJSContextLogic", "create with appID(%s), scriptPath(%s), sdkScript inject succeed", new Object[] { this.gau.fxC.mAppId, this.fxI });
    a.aov();
    b.a(this.fxN, this.gau.fxC.mAppId, this.fxK, this.fxI, this.fxO.length());
    this.gau.cC(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.k.a.2
 * JD-Core Version:    0.7.0.1
 */