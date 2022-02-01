package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.launching.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  static void b(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47464);
    Log.i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", new Object[] { paramAppBrandInitConfigWC });
    c.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    com.tencent.mm.plugin.appbrand.launching.i.a(paramContext, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    h.bLi().a(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.bLj());
    AppMethodBeat.o(47464);
  }
  
  public static ICommLibReader caE()
  {
    AppMethodBeat.i(268723);
    if (au.bHb() == null) {
      WxaCommLibRuntimeReader.bHf();
    }
    ICommLibReader localICommLibReader = au.bHb();
    AppMethodBeat.o(268723);
    return localICommLibReader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.i
 * JD-Core Version:    0.7.0.1
 */