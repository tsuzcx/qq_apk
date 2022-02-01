package com.tencent.mm.plugin.appbrand;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.page.cd;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.i;
import com.tencent.mm.sdk.platformtools.Log;

public final class ba
{
  public static Bitmap G(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(253234);
    if (AppBrandRuntimeWCAccessible.isGame(paramAppBrandRuntime))
    {
      paramAppBrandRuntime = (com.tencent.luggage.game.d.a.a.b)((c)paramAppBrandRuntime.QW()).R(com.tencent.luggage.game.d.a.a.b.class);
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = com.tencent.magicbrush.b.a(paramAppBrandRuntime.getMagicBrush().cMk);
        AppMethodBeat.o(253234);
        return paramAppBrandRuntime;
      }
      Log.printErrStackTrace("MicroMsg.AppBrand.RuntimeRestartHelper", new com.tencent.luggage.game.d.a.a.d(), "hy: not game service", new Object[0]);
      AppMethodBeat.o(253234);
      return null;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.bBX().getCurrentPage();
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(253234);
      return null;
    }
    paramAppBrandRuntime = cd.cW(paramAppBrandRuntime);
    AppMethodBeat.o(253234);
    return paramAppBrandRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ba
 * JD-Core Version:    0.7.0.1
 */