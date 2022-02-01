package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.util.AndroidRuntimeException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.f;
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
        localAppBrandInitConfigWC.jXv = bt.flT();
        if (g.c(localContext, localAppBrandInitConfigWC, localAppBrandStatObject))
        {
          if ((localContext instanceof Activity))
          {
            localAppBrandInitConfigWC.cmC = localAppBrandStatObject;
            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m.a((Activity)localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
          }
          ad.i("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl [applaunch] start functional runtime, config[%s]", new Object[] { localAppBrandInitConfigWC });
          AppMethodBeat.o(47118);
          return;
        }
        if (localAppBrandInitConfigWC.Eb())
        {
          localAppBrandInitConfigWC.jXC = null;
          if (localAppBrandInitConfigWC.launchMode == 1) {
            localAppBrandInitConfigWC.jVL = "portrait";
          }
        }
        for (;;)
        {
          try
          {
            int i = f.d(localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
            if ((localContext instanceof Activity)) {
              localAppBrandInitConfigWC.cmC = localAppBrandStatObject;
            }
            ad.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", new Object[] { localAppBrandInitConfigWC });
            if (i == 1)
            {
              ad.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] init AppLaunchPrepareProcess boost instance");
              new k(localAppBrandInitConfigWC, localAppBrandStatObject).bqQ();
              com.tencent.mm.plugin.appbrand.m.a(21, localAppBrandInitConfigWC.appId, localAppBrandInitConfigWC.aDD, localAppBrandInitConfigWC.dPf, localAppBrandInitConfigWC.Eb());
            }
            AppMethodBeat.o(47118);
            return;
          }
          catch (AndroidRuntimeException localAndroidRuntimeException)
          {
            ad.e("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl re = %s", new Object[] { localAndroidRuntimeException });
            AppMethodBeat.o(47118);
          }
          localAppBrandInitConfigWC.jXC = new WebRenderingCacheDirectoryDescriptor();
          localAppBrandInitConfigWC.jXC.mgQ = h.TK(localAppBrandInitConfigWC.appId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j
 * JD-Core Version:    0.7.0.1
 */