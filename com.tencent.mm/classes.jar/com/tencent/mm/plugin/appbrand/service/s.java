package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/service/WXNativeInjector;", "", "()V", "WXNATIVE", "", "getWXNATIVE", "()Ljava/lang/String;", "WXNATIVEFILE", "getWXNATIVEFILE", "enableWxNative", "", "component", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "getWXNativeJSRet", "getWXNativeJSScript", "getWXNativeJSScriptName", "plugin-appbrand-integration_release"})
public final class s
{
  private static final String luK = "WxNative";
  private static final String luL = "wxNative.js";
  public static final s luM;
  
  static
  {
    AppMethodBeat.i(51061);
    luM = new s();
    luK = "WxNative";
    luL = "wxNative.js";
    AppMethodBeat.o(51061);
  }
  
  public static String bng()
  {
    return luK;
  }
  
  public static String bnh()
  {
    AppMethodBeat.i(51060);
    String str = d.Ne(luL);
    k.g(str, "AppBrandIOUtil.getAssetAsString(WXNATIVEFILE)");
    AppMethodBeat.o(51060);
    return str;
  }
  
  public static String bni()
  {
    return ";injectNativateRet";
  }
  
  public static boolean c(c paramc)
  {
    AppMethodBeat.i(51059);
    k.h(paramc, "component");
    paramc = paramc.getRuntime();
    k.g(paramc, "component.runtime");
    if ((paramc.aMT()) || (h.DEBUG) || (h.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(51059);
      return true;
    }
    AppMethodBeat.o(51059);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.s
 * JD-Core Version:    0.7.0.1
 */