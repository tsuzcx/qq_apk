package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.al;

public final class f
{
  public static void a(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(131771);
    paramContext = new f.1(paramContext, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    if (al.isMainThread())
    {
      paramContext.run();
      AppMethodBeat.o(131771);
      return;
    }
    al.d(paramContext);
    AppMethodBeat.o(131771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f
 * JD-Core Version:    0.7.0.1
 */