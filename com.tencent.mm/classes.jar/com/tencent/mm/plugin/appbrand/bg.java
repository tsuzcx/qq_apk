package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.launching.report.a;
import com.tencent.mm.plugin.appbrand.page.ch;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Objects;
import org.apache.commons.c.i;

public final class bg
{
  public static Bitmap J(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(316590);
    if (AppBrandRuntimeWCAccessible.isGame(paramAppBrandRuntime))
    {
      paramAppBrandRuntime = (com.tencent.luggage.game.d.a.a.b)((c)paramAppBrandRuntime.ari()).aa(com.tencent.luggage.game.d.a.a.b.class);
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = com.tencent.magicbrush.b.a(paramAppBrandRuntime.getMagicBrush().eHE);
        AppMethodBeat.o(316590);
        return paramAppBrandRuntime;
      }
      Log.printErrStackTrace("MicroMsg.AppBrand.RuntimeRestartHelper", new com.tencent.luggage.game.d.a.a.d(), "hy: not game service", new Object[0]);
      AppMethodBeat.o(316590);
      return null;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.getPageContainer().getCurrentPage();
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(316590);
      return null;
    }
    paramAppBrandRuntime = ch.dD(paramAppBrandRuntime);
    AppMethodBeat.o(316590);
    return paramAppBrandRuntime;
  }
  
  public static void a(w paramw, final AppBrandInitConfigWC paramAppBrandInitConfigWC, final a parama)
  {
    AppMethodBeat.i(316584);
    if ((paramw == null) || (paramAppBrandInitConfigWC == null))
    {
      Log.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
      AppMethodBeat.o(316584);
      return;
    }
    paramw.i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43985);
        Log.i("MicroMsg.AppBrand.RuntimeRestartHelper", "performRestart OnUiThread appId[%s]", new Object[] { bg.this.mAppId });
        try
        {
          Bitmap localBitmap = bg.J(bg.this);
          h.a(bg.this, localBitmap);
          Objects.requireNonNull(parama);
          paramAppBrandInitConfigWC.epn = bg.this.asA().epn;
          if ((bg.this.getInitConfig() == null) || (i.qA(bg.this.getInitConfig().eoP, paramAppBrandInitConfigWC.eoP))) {
            paramAppBrandInitConfigWC.aqI();
          }
          paramAppBrandInitConfigWC.qYu = new AppBrandRuntimeReloadReportBundle(bg.this.getInitConfig().qYm.eup, parama.stringValue);
          bg.this.a(paramAppBrandInitConfigWC, parama.stringValue);
          AppMethodBeat.o(43985);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.AppBrand.RuntimeRestartHelper", "performRestart  takeSnapshot appId[%s], e[%s]", new Object[] { bg.this.mAppId, localException });
          }
        }
      }
    }, 0L);
    AppMethodBeat.o(316584);
  }
  
  static void v(w paramw)
  {
    AppMethodBeat.i(316595);
    Log.i("MicroMsg.AppBrand.RuntimeRestartHelper", "restartAppImplOnLaunchRequestedLatestVersion appId:%s", new Object[] { paramw.mAppId });
    new bg..ExternalSyntheticLambda1(paramw).run();
    AppMethodBeat.o(316595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bg
 * JD-Core Version:    0.7.0.1
 */