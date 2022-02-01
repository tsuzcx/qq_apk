package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.sdk.platformtools.ac;

public final class am
{
  public static Bitmap L(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(186279);
    if (AppBrandRuntimeWCAccessible.isGame(paramAppBrandRuntime))
    {
      paramAppBrandRuntime = (com.tencent.luggage.game.d.a.a.b)((com.tencent.mm.plugin.appbrand.service.c)paramAppBrandRuntime.CX()).Q(com.tencent.luggage.game.d.a.a.b.class);
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = com.tencent.magicbrush.b.a(paramAppBrandRuntime.getMagicBrush().cml);
        AppMethodBeat.o(186279);
        return paramAppBrandRuntime;
      }
      ac.printErrStackTrace("MicroMsg.AppBrand.RuntimeRestartHelper", new com.tencent.luggage.game.d.a.a.c(), "hy: not game service", new Object[0]);
      AppMethodBeat.o(186279);
      return null;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.aSA().getCurrentPage();
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(186279);
      return null;
    }
    paramAppBrandRuntime = bv.cH(paramAppBrandRuntime);
    AppMethodBeat.o(186279);
    return paramAppBrandRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.am
 * JD-Core Version:    0.7.0.1
 */