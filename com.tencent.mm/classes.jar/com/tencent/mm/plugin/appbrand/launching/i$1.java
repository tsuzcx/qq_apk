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
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class i$1
  implements Runnable
{
  i$1(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(47118);
    Context localContext = this.val$context;
    AppBrandInitConfigWC localAppBrandInitConfigWC = this.pRm;
    AppBrandStatObject localAppBrandStatObject = this.pRn;
    localAppBrandInitConfigWC.nYc = Util.nowMilliSecond();
    if (g.c(localContext, localAppBrandInitConfigWC, localAppBrandStatObject))
    {
      if ((localContext instanceof Activity))
      {
        localAppBrandInitConfigWC.cxf = localAppBrandStatObject;
        m.a((Activity)localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
      }
      Log.i("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl [applaunch] start functional runtime, config[%s]", new Object[] { localAppBrandInitConfigWC });
      AppMethodBeat.o(47118);
      return;
    }
    try
    {
      h localh = i.cjb().a(localContext, new p(localAppBrandInitConfigWC, localAppBrandStatObject));
      if ((localContext instanceof Activity)) {
        localAppBrandInitConfigWC.cxf = localAppBrandStatObject;
      }
      Log.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", new Object[] { localAppBrandInitConfigWC });
      if ((localh == h.cBV) && (j.ajU(localAppBrandInitConfigWC.cwP) == null))
      {
        Log.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] init AppLaunchPrepareProcess boost instance, appId:%s, versionType:%d", new Object[] { localAppBrandInitConfigWC.appId, Integer.valueOf(localAppBrandInitConfigWC.cBI) });
        new j(localAppBrandInitConfigWC, localAppBrandStatObject).bZC();
        r.a(21, localAppBrandInitConfigWC.appId, localAppBrandInitConfigWC.appVersion, localAppBrandInitConfigWC.cBI, localAppBrandInitConfigWC.Qv());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.i.1
 * JD-Core Version:    0.7.0.1
 */