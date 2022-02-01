package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.util.AndroidRuntimeException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

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
        localAppBrandInitConfigWC.kaK = bu.fpO();
        if (g.c(localContext, localAppBrandInitConfigWC, localAppBrandStatObject))
        {
          if ((localContext instanceof Activity))
          {
            localAppBrandInitConfigWC.cmE = localAppBrandStatObject;
            m.a((Activity)localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
          }
          ae.i("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl [applaunch] start functional runtime, config[%s]", new Object[] { localAppBrandInitConfigWC });
          AppMethodBeat.o(47118);
          return;
        }
        if (localAppBrandInitConfigWC.Ee())
        {
          localAppBrandInitConfigWC.kaR = null;
          if (localAppBrandInitConfigWC.launchMode == 1) {
            localAppBrandInitConfigWC.cpm = "portrait";
          }
        }
        for (;;)
        {
          try
          {
            int i = f.d(localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
            if ((localContext instanceof Activity)) {
              localAppBrandInitConfigWC.cmE = localAppBrandStatObject;
            }
            ae.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", new Object[] { localAppBrandInitConfigWC });
            if (i == 1)
            {
              ae.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] init AppLaunchPrepareProcess boost instance");
              new k(localAppBrandInitConfigWC, localAppBrandStatObject).brA();
              n.a(21, localAppBrandInitConfigWC.appId, localAppBrandInitConfigWC.aDD, localAppBrandInitConfigWC.dQv, localAppBrandInitConfigWC.Ee());
            }
            AppMethodBeat.o(47118);
            return;
          }
          catch (AndroidRuntimeException localAndroidRuntimeException)
          {
            ae.e("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl re = %s", new Object[] { localAndroidRuntimeException });
            AppMethodBeat.o(47118);
          }
          localAppBrandInitConfigWC.kaR = new WebRenderingCacheDirectoryDescriptor();
          localAppBrandInitConfigWC.kaR.mlP = h.Ut(localAppBrandInitConfigWC.appId);
        }
      }
    };
    if (ar.isMainThread())
    {
      paramContext.run();
      AppMethodBeat.o(47119);
      return;
    }
    ar.f(paramContext);
    AppMethodBeat.o(47119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j
 * JD-Core Version:    0.7.0.1
 */