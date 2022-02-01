package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.g;
import com.tencent.mm.plugin.appbrand.launching.c;
import com.tencent.mm.plugin.appbrand.launching.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
{
  static void b(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47464);
    ae.i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", new Object[] { paramAppBrandInitConfigWC });
    c.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    j.a(paramContext, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    g.beC().a(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC);
    AppMethodBeat.o(47464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.i
 * JD-Core Version:    0.7.0.1
 */