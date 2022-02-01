package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/service/WXNativeInjector;", "", "()V", "WXNATIVE", "", "getWXNATIVE", "()Ljava/lang/String;", "WXNATIVEFILE", "getWXNATIVEFILE", "enableWxNative", "", "component", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "getWXNativeJSRet", "getWXNativeJSScript", "getWXNativeJSScriptName", "plugin-appbrand-integration_release"})
public final class s
{
  private static final String lWE = "WxNative";
  private static final String lWF = "wxNative.js";
  public static final s lWG;
  
  static
  {
    AppMethodBeat.i(51061);
    lWG = new s();
    lWE = "WxNative";
    lWF = "wxNative.js";
    AppMethodBeat.o(51061);
  }
  
  public static String buc()
  {
    return lWE;
  }
  
  public static String bud()
  {
    AppMethodBeat.i(51060);
    String str = d.Rn(lWF);
    k.g(str, "AppBrandIOUtil.getAssetAsString(WXNATIVEFILE)");
    AppMethodBeat.o(51060);
    return str;
  }
  
  public static String bue()
  {
    return ";injectNativateRet";
  }
  
  public static boolean d(c paramc)
  {
    AppMethodBeat.i(51059);
    k.h(paramc, "component");
    paramc = paramc.getRuntime();
    k.g(paramc, "component.runtime");
    if ((paramc.aTJ()) || (h.DEBUG) || (h.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(51059);
      return true;
    }
    AppMethodBeat.o(51059);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.s
 * JD-Core Version:    0.7.0.1
 */