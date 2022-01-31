package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$5
  implements k.a
{
  c$5(c paramc) {}
  
  public final void fM(String paramString)
  {
    y.e("MicroMsg.WAGameAppService", "Inject WAGame Library Script Failed: %s", new Object[] { paramString });
  }
  
  public final void onSuccess(String paramString)
  {
    y.i("MicroMsg.WAGameAppService", "Inject WAGame Library Script suc: %s", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.5
 * JD-Core Version:    0.7.0.1
 */