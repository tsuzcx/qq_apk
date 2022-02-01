package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.plugin.appbrand.launching.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
{
  static void b(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47464);
    Log.i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", new Object[] { paramAppBrandInitConfigWC });
    e.a(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    j.a(paramContext, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    h.ckG().a(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.ckH());
    AppMethodBeat.o(47464);
  }
  
  public static ICommLibReader cAW()
  {
    AppMethodBeat.i(321017);
    if (av.cgx() == null) {
      WxaCommLibRuntimeReader.cgC();
    }
    ICommLibReader localICommLibReader = av.cgx();
    AppMethodBeat.o(321017);
    return localICommLibReader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.k
 * JD-Core Version:    0.7.0.1
 */