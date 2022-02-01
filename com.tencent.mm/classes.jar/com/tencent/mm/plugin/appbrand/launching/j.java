package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.util.AndroidRuntimeException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
{
  public static void a(Context paramContext, final AppBrandInitConfigWC paramAppBrandInitConfigWC, final AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47119);
    paramContext = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47118);
        Context localContext = this.val$context;
        AppBrandInitConfigWC localAppBrandInitConfigWC = paramAppBrandInitConfigWC;
        AppBrandStatObject localAppBrandStatObject = paramAppBrandStatObject;
        localAppBrandInitConfigWC.jdm = bt.eGO();
        if (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f.c(localContext, localAppBrandInitConfigWC, localAppBrandStatObject))
        {
          if ((localContext instanceof Activity))
          {
            localAppBrandInitConfigWC.cfo = localAppBrandStatObject;
            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k.a((Activity)localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
          }
          ad.i("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl [applaunch] start functional runtime, config[%s]", new Object[] { localAppBrandInitConfigWC });
          AppMethodBeat.o(47118);
          return;
        }
        if (localAppBrandInitConfigWC.CZ())
        {
          localAppBrandInitConfigWC.jdt = null;
          if (localAppBrandInitConfigWC.launchMode == 1) {
            localAppBrandInitConfigWC.jbC = "portrait";
          }
        }
        for (;;)
        {
          try
          {
            int i = com.tencent.mm.plugin.appbrand.task.f.d(localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
            if ((localContext instanceof Activity)) {
              localAppBrandInitConfigWC.cfo = localAppBrandStatObject;
            }
            ad.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", new Object[] { localAppBrandInitConfigWC });
            if (i == 1)
            {
              ad.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] init AppLaunchPrepareProcess boost instance");
              new k(localAppBrandInitConfigWC, localAppBrandStatObject).bgk();
              m.a(21, localAppBrandInitConfigWC.appId, localAppBrandInitConfigWC.aAS, localAppBrandInitConfigWC.iOP, localAppBrandInitConfigWC.CZ());
            }
            AppMethodBeat.o(47118);
            return;
          }
          catch (AndroidRuntimeException localAndroidRuntimeException)
          {
            ad.e("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl re = %s", new Object[] { localAndroidRuntimeException });
            AppMethodBeat.o(47118);
          }
          localAppBrandInitConfigWC.jdt = new WebRenderingCacheDirectoryDescriptor();
          localAppBrandInitConfigWC.jdt.lhl = h.LZ(localAppBrandInitConfigWC.appId);
        }
      }
    };
    if (aq.isMainThread())
    {
      paramContext.run();
      AppMethodBeat.o(47119);
      return;
    }
    aq.f(paramContext);
    AppMethodBeat.o(47119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j
 * JD-Core Version:    0.7.0.1
 */