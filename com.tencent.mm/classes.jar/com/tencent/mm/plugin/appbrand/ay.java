package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class ay
{
  public static Bitmap F(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(226251);
    if (AppBrandRuntimeWCAccessible.isGame(paramAppBrandRuntime))
    {
      paramAppBrandRuntime = (com.tencent.luggage.game.d.a.a.b)((c)paramAppBrandRuntime.NY()).S(com.tencent.luggage.game.d.a.a.b.class);
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = com.tencent.magicbrush.b.a(paramAppBrandRuntime.getMagicBrush().cLA);
        AppMethodBeat.o(226251);
        return paramAppBrandRuntime;
      }
      Log.printErrStackTrace("MicroMsg.AppBrand.RuntimeRestartHelper", new com.tencent.luggage.game.d.a.a.d(), "hy: not game service", new Object[0]);
      AppMethodBeat.o(226251);
      return null;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.brh().getCurrentPage();
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(226251);
      return null;
    }
    paramAppBrandRuntime = ca.cD(paramAppBrandRuntime);
    AppMethodBeat.o(226251);
    return paramAppBrandRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ay
 * JD-Core Version:    0.7.0.1
 */