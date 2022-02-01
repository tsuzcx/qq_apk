package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.launching.c;
import com.tencent.mm.plugin.appbrand.launching.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  static void b(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47464);
    Log.i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", new Object[] { paramAppBrandInitConfigWC });
    c.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    j.a(paramContext, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    h.bzT().a(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC);
    AppMethodBeat.o(47464);
  }
  
  public static ICommLibReader bOk()
  {
    AppMethodBeat.i(227140);
    if (at.bvT() == null) {
      WxaCommLibRuntimeReader.bvY();
    }
    ICommLibReader localICommLibReader = at.bvT();
    AppMethodBeat.o(227140);
    return localICommLibReader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.i
 * JD-Core Version:    0.7.0.1
 */