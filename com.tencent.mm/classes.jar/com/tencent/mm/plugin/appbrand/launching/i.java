package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class i
{
  public static void a(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47119);
    paramContext = new i.1(paramContext, paramAppBrandInitConfigWC, paramAppBrandStatObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.i
 * JD-Core Version:    0.7.0.1
 */