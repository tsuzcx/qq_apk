package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/service/WXNativeInjector;", "", "()V", "WXNATIVE", "", "getWXNATIVE", "()Ljava/lang/String;", "WXNATIVEFILE", "getWXNATIVEFILE", "enableWxNative", "", "component", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "getWXNativeJSRet", "getWXNativeJSScript", "getWXNativeJSScriptName", "plugin-appbrand-integration_release"})
public final class aa
{
  private static final String nMW = "WxNative";
  private static final String nMX = "wxNative.js";
  public static final aa nMY;
  
  static
  {
    AppMethodBeat.i(51061);
    nMY = new aa();
    nMW = "WxNative";
    nMX = "wxNative.js";
    AppMethodBeat.o(51061);
  }
  
  public static String bVu()
  {
    return nMW;
  }
  
  public static String bVv()
  {
    AppMethodBeat.i(51060);
    String str = d.afA(nMX);
    p.g(str, "AppBrandIOUtil.getAssetAsString(WXNATIVEFILE)");
    AppMethodBeat.o(51060);
    return str;
  }
  
  public static String bVw()
  {
    return ";injectNativateRet";
  }
  
  public static boolean f(c paramc)
  {
    AppMethodBeat.i(51059);
    p.h(paramc, "component");
    paramc = paramc.getRuntime();
    p.g(paramc, "component.runtime");
    if ((paramc.bsr()) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(51059);
      return true;
    }
    AppMethodBeat.o(51059);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.aa
 * JD-Core Version:    0.7.0.1
 */