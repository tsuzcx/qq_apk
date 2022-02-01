package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.util.AndroidRuntimeException;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.processes.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.n;
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
        Object localObject = j.this;
        AppBrandInitConfigWC localAppBrandInitConfigWC = paramAppBrandInitConfigWC;
        AppBrandStatObject localAppBrandStatObject = paramAppBrandStatObject;
        localAppBrandInitConfigWC.qYe = Util.nowMilliSecond();
        if (g.c((Context)localObject, localAppBrandInitConfigWC, localAppBrandStatObject))
        {
          if ((localObject instanceof Activity))
          {
            localAppBrandInitConfigWC.epn = localAppBrandStatObject;
            m.a((Activity)localObject, localAppBrandInitConfigWC, localAppBrandStatObject);
          }
          Log.i("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl [applaunch] start functional runtime, config[%s]", new Object[] { localAppBrandInitConfigWC });
          AppMethodBeat.o(47118);
          return;
        }
        try
        {
          localObject = i.cJV().a((Context)localObject, new n(localAppBrandInitConfigWC, localAppBrandStatObject));
          Log.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", new Object[] { localAppBrandInitConfigWC });
          if ((localObject == h.euA) && (k.acV(localAppBrandInitConfigWC.eoP) == null))
          {
            Log.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] init AppLaunchPrepareProcess boost instance, appId:%s, versionType:%d", new Object[] { localAppBrandInitConfigWC.appId, Integer.valueOf(localAppBrandInitConfigWC.eul) });
            new k(localAppBrandInitConfigWC, localAppBrandStatObject).czO();
            r.a(21, localAppBrandInitConfigWC.appId, localAppBrandInitConfigWC.appVersion, localAppBrandInitConfigWC.eul, localAppBrandInitConfigWC.aqJ());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j
 * JD-Core Version:    0.7.0.1
 */