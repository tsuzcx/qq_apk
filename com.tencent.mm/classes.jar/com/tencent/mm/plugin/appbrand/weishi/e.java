package com.tencent.mm.plugin.appbrand.weishi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;

public final class e
{
  public static boolean b(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(133640);
    if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfig.appId))
    {
      paramActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(133640);
      return true;
    }
    AppMethodBeat.o(133640);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.e
 * JD-Core Version:    0.7.0.1
 */