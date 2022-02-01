package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "to", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
public final class k
{
  public static final k kZW;
  
  static
  {
    AppMethodBeat.i(50584);
    kZW = new k();
    AppMethodBeat.o(50584);
  }
  
  public static final boolean a(com.tencent.mm.plugin.appbrand.p paramp1, com.tencent.mm.plugin.appbrand.p paramp2, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(50583);
    d.g.b.p.h(paramp1, "from");
    d.g.b.p.h(paramp2, "to");
    d.g.b.p.h(paramAppBrandInitConfigWC, "config");
    if ((paramp1.Ee()) && (paramAppBrandInitConfigWC.Ee()))
    {
      f.lSd.a((Context)paramp1.getContext(), null, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.jFL, paramAppBrandInitConfigWC.dQv, paramAppBrandInitConfigWC.aDD, paramAppBrandInitConfigWC.Ed(), paramAppBrandInitConfigWC.cmx, null);
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