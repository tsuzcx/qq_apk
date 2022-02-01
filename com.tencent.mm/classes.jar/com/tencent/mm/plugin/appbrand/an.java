package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.page.bu;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.i;
import com.tencent.mm.sdk.platformtools.ae;

public final class an
{
  public static Bitmap F(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(222050);
    if (AppBrandRuntimeWCAccessible.isGame(paramAppBrandRuntime))
    {
      paramAppBrandRuntime = (com.tencent.luggage.game.d.a.a.b)((com.tencent.mm.plugin.appbrand.service.c)paramAppBrandRuntime.Ey()).Q(com.tencent.luggage.game.d.a.a.b.class);
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = com.tencent.magicbrush.b.a(paramAppBrandRuntime.getMagicBrush().cxs);
        AppMethodBeat.o(222050);
        return paramAppBrandRuntime;
      }
      ae.printErrStackTrace("MicroMsg.AppBrand.RuntimeRestartHelper", new com.tencent.luggage.game.d.a.a.c(), "hy: not game service", new Object[0]);
      AppMethodBeat.o(222050);
      return null;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.aWm().getCurrentPage();
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(222050);
      return null;
    }
    paramAppBrandRuntime = bu.cK(paramAppBrandRuntime);
    AppMethodBeat.o(222050);
    return paramAppBrandRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.an
 * JD-Core Version:    0.7.0.1
 */