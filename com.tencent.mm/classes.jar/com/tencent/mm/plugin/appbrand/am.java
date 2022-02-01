package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class am
{
  public static Bitmap L(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(195579);
    if (AppBrandRuntimeWCAccessible.isGame(paramAppBrandRuntime))
    {
      paramAppBrandRuntime = (com.tencent.luggage.game.d.a.a.b)((com.tencent.mm.plugin.appbrand.service.c)paramAppBrandRuntime.Du()).Q(com.tencent.luggage.game.d.a.a.b.class);
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = com.tencent.magicbrush.b.a(paramAppBrandRuntime.getMagicBrush().cpg);
        AppMethodBeat.o(195579);
        return paramAppBrandRuntime;
      }
      ad.printErrStackTrace("MicroMsg.AppBrand.RuntimeRestartHelper", new com.tencent.luggage.game.d.a.a.c(), "hy: not game service", new Object[0]);
      AppMethodBeat.o(195579);
      return null;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.aLK().getCurrentPage();
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(195579);
      return null;
    }
    paramAppBrandRuntime = ca.cF(paramAppBrandRuntime);
    AppMethodBeat.o(195579);
    return paramAppBrandRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.am
 * JD-Core Version:    0.7.0.1
 */