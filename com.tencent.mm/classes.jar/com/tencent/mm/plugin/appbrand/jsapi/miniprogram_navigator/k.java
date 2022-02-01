package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.o;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "to", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
public final class k
{
  public static final k kWo;
  
  static
  {
    AppMethodBeat.i(50584);
    kWo = new k();
    AppMethodBeat.o(50584);
  }
  
  public static final boolean a(o paramo1, o paramo2, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(50583);
    p.h(paramo1, "from");
    p.h(paramo2, "to");
    p.h(paramAppBrandInitConfigWC, "config");
    if ((paramo1.Eb()) && (paramAppBrandInitConfigWC.Eb()))
    {
      f.lNC.a((Context)paramo1.getContext(), null, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.jCN, paramAppBrandInitConfigWC.dPf, paramAppBrandInitConfigWC.aDD, paramAppBrandInitConfigWC.Ea(), paramAppBrandInitConfigWC.cmv, null);
      AppMethodBeat.o(50583);
      return true;
    }
    AppMethodBeat.o(50583);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k
 * JD-Core Version:    0.7.0.1
 */