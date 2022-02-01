package com.tencent.mm.plugin.appbrand.jsapi.aa.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.s.a.d;
import com.tencent.mm.sdk.platformtools.ad;

final class c$2
  implements Runnable
{
  c$2(c paramc, aa paramaa) {}
  
  public final void run()
  {
    AppMethodBeat.i(139554);
    if ((!this.kzG.isRunning()) || (this.kzG.kWU == null))
    {
      ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, invalid state");
      AppMethodBeat.o(139554);
      return;
    }
    d locald = this.kzG.kWU.getFullscreenImpl();
    if (locald != null)
    {
      locald.aNT();
      ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen");
      AppMethodBeat.o(139554);
      return;
    }
    ad.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, state error");
    AppMethodBeat.o(139554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.2
 * JD-Core Version:    0.7.0.1
 */