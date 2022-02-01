package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.q;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "to", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
public final class l
{
  public static final l mfk;
  
  static
  {
    AppMethodBeat.i(50584);
    mfk = new l();
    AppMethodBeat.o(50584);
  }
  
  public static final boolean a(q paramq1, q paramq2, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(50583);
    p.h(paramq1, "from");
    p.h(paramq2, "to");
    p.h(paramAppBrandInitConfigWC, "config");
    if ((paramq1.NA()) && (paramAppBrandInitConfigWC.NA()))
    {
      f.mZp.a((Context)paramq1.getContext(), null, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.kHw, paramAppBrandInitConfigWC.eix, paramAppBrandInitConfigWC.appVersion, paramAppBrandInitConfigWC.Nz(), paramAppBrandInitConfigWC.cys, null);
      AppMethodBeat.o(50583);
      return true;
    }
    AppMethodBeat.o(50583);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.l
 * JD-Core Version:    0.7.0.1
 */