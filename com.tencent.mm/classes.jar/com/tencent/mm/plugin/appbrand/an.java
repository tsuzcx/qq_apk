package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bu;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ad;

public final class an
{
  public static Bitmap I(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(187940);
    if (AppBrandRuntimeWCAccessible.isGame(paramAppBrandRuntime))
    {
      paramAppBrandRuntime = (com.tencent.luggage.game.d.a.a.b)((com.tencent.mm.plugin.appbrand.service.c)paramAppBrandRuntime.Ew()).Q(com.tencent.luggage.game.d.a.a.b.class);
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = com.tencent.magicbrush.b.a(paramAppBrandRuntime.getMagicBrush().cwN);
        AppMethodBeat.o(187940);
        return paramAppBrandRuntime;
      }
      ad.printErrStackTrace("MicroMsg.AppBrand.RuntimeRestartHelper", new com.tencent.luggage.game.d.a.a.c(), "hy: not game service", new Object[0]);
      AppMethodBeat.o(187940);
      return null;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.aVN().getCurrentPage();
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(187940);
      return null;
    }
    paramAppBrandRuntime = bu.cJ(paramAppBrandRuntime);
    AppMethodBeat.o(187940);
    return paramAppBrandRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.an
 * JD-Core Version:    0.7.0.1
 */