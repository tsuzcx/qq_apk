package com.tencent.mm.plugin.appbrand.weishi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;

public final class f
{
  public static boolean c(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(49344);
    if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfig.appId))
    {
      paramActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(49344);
      return true;
    }
    AppMethodBeat.o(49344);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.f
 * JD-Core Version:    0.7.0.1
 */