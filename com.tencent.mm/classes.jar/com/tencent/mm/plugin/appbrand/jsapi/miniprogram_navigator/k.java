package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.o;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "to", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
public final class k
{
  public static final k jZr;
  
  static
  {
    AppMethodBeat.i(50584);
    jZr = new k();
    AppMethodBeat.o(50584);
  }
  
  public static final boolean a(o paramo1, o paramo2, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(50583);
    d.g.b.k.h(paramo1, "from");
    d.g.b.k.h(paramo2, "to");
    d.g.b.k.h(paramAppBrandInitConfigWC, "config");
    if ((paramo1.CZ()) && (paramAppBrandInitConfigWC.CZ()))
    {
      f.kOI.a((Context)paramo1.getContext(), null, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.iJb, paramAppBrandInitConfigWC.iOP, paramAppBrandInitConfigWC.aAS, paramAppBrandInitConfigWC.CY(), paramAppBrandInitConfigWC.cfi, null);
      AppMethodBeat.o(50583);
      return true;
    }
    AppMethodBeat.o(50583);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k
 * JD-Core Version:    0.7.0.1
 */