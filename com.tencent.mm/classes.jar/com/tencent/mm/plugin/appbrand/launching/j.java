package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.util.AndroidRuntimeException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

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
        localAppBrandInitConfigWC.ldO = Util.nowMilliSecond();
        if (g.c(localContext, localAppBrandInitConfigWC, localAppBrandStatObject))
        {
          if ((localContext instanceof Activity))
          {
            localAppBrandInitConfigWC.cyA = localAppBrandStatObject;
            m.a((Activity)localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
          }
          Log.i("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl [applaunch] start functional runtime, config[%s]", new Object[] { localAppBrandInitConfigWC });
          AppMethodBeat.o(47118);
          return;
        }
        try
        {
          int i = h.bWb().d(localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
          if ((localContext instanceof Activity)) {
            localAppBrandInitConfigWC.cyA = localAppBrandStatObject;
          }
          Log.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", new Object[] { localAppBrandInitConfigWC });
          if (i == 1)
          {
            Log.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] init AppLaunchPrepareProcess boost instance");
            new k(localAppBrandInitConfigWC, localAppBrandStatObject).bNl();
            o.a(21, localAppBrandInitConfigWC.appId, localAppBrandInitConfigWC.appVersion, localAppBrandInitConfigWC.eix, localAppBrandInitConfigWC.NA());
          }
          AppMethodBeat.o(47118);
          return;
        }
        catch (AndroidRuntimeException localAndroidRuntimeException)
        {
          Log.e("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl re = %s", new Object[] { localAndroidRuntimeException });
          AppMethodBeat.o(47118);
        }
      }
    };
    if (MMHandlerThread.isMainThread())
    {
      paramContext.run();
      AppMethodBeat.o(47119);
      return;
    }
    MMHandlerThread.postToMainThread(paramContext);
    AppMethodBeat.o(47119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j
 * JD-Core Version:    0.7.0.1
 */