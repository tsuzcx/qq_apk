package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import a.l;
import android.content.Context;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.o;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "to", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "navigateToStandaloneActivity", "", "plugin-appbrand-integration_release"})
public final class j
{
  public static final j hTu;
  
  static
  {
    AppMethodBeat.i(134683);
    hTu = new j();
    AppMethodBeat.o(134683);
  }
  
  public static final boolean a(o paramo1, o paramo2, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(134682);
    a.f.b.j.q(paramo1, "from");
    a.f.b.j.q(paramo2, "to");
    a.f.b.j.q(paramAppBrandInitConfigWC, "config");
    if ((paramo1.vY()) && (paramAppBrandInitConfigWC.vY()))
    {
      f.ioc.a((Context)paramo1.atV(), null, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.hiw, paramAppBrandInitConfigWC.gXd, paramAppBrandInitConfigWC.bDc, paramAppBrandInitConfigWC.vX(), paramAppBrandInitConfigWC.hiz, null);
      AppMethodBeat.o(134682);
      return true;
    }
    AppMethodBeat.o(134682);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j
 * JD-Core Version:    0.7.0.1
 */