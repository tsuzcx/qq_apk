package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.sdk.platformtools.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/service/WXNativeInjector;", "", "()V", "WXNATIVE", "", "getWXNATIVE", "()Ljava/lang/String;", "WXNATIVEFILE", "getWXNATIVEFILE", "enableWxNative", "", "component", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "getWXNativeJSRet", "getWXNativeJSScript", "getWXNativeJSScriptName", "plugin-appbrand-integration_release"})
public final class u
{
  private static final String mBq = "WxNative";
  private static final String mBr = "wxNative.js";
  public static final u mBs;
  
  static
  {
    AppMethodBeat.i(51061);
    mBs = new u();
    mBq = "WxNative";
    mBr = "wxNative.js";
    AppMethodBeat.o(51061);
  }
  
  public static String bza()
  {
    return mBq;
  }
  
  public static String bzb()
  {
    AppMethodBeat.i(51060);
    String str = d.VE(mBr);
    d.g.b.p.g(str, "AppBrandIOUtil.getAssetAsString(WXNATIVEFILE)");
    AppMethodBeat.o(51060);
    return str;
  }
  
  public static String bzc()
  {
    return ";injectNativateRet";
  }
  
  public static boolean d(c paramc)
  {
    AppMethodBeat.i(51059);
    d.g.b.p.h(paramc, "component");
    paramc = paramc.getRuntime();
    d.g.b.p.g(paramc, "component.runtime");
    if ((paramc.aXo()) || (j.DEBUG) || (j.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(51059);
      return true;
    }
    AppMethodBeat.o(51059);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.u
 * JD-Core Version:    0.7.0.1
 */