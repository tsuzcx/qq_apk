package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.sdk.platformtools.i;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/service/WXNativeInjector;", "", "()V", "WXNATIVE", "", "getWXNATIVE", "()Ljava/lang/String;", "WXNATIVEFILE", "getWXNATIVEFILE", "enableWxNative", "", "component", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "getWXNativeJSRet", "getWXNativeJSScript", "getWXNativeJSScriptName", "plugin-appbrand-integration_release"})
public final class t
{
  private static final String mwt = "WxNative";
  private static final String mwu = "wxNative.js";
  public static final t mwv;
  
  static
  {
    AppMethodBeat.i(51061);
    mwv = new t();
    mwt = "WxNative";
    mwu = "wxNative.js";
    AppMethodBeat.o(51061);
  }
  
  public static String byh()
  {
    return mwt;
  }
  
  public static String byi()
  {
    AppMethodBeat.i(51060);
    String str = d.UT(mwu);
    p.g(str, "AppBrandIOUtil.getAssetAsString(WXNATIVEFILE)");
    AppMethodBeat.o(51060);
    return str;
  }
  
  public static String byj()
  {
    return ";injectNativateRet";
  }
  
  public static boolean d(c paramc)
  {
    AppMethodBeat.i(51059);
    p.h(paramc, "component");
    paramc = paramc.getRuntime();
    p.g(paramc, "component.runtime");
    if ((paramc.aWT()) || (i.DEBUG) || (i.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(51059);
      return true;
    }
    AppMethodBeat.o(51059);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.t
 * JD-Core Version:    0.7.0.1
 */