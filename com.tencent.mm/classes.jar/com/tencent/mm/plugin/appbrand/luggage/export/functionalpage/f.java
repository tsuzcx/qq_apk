package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalConfigAssembler;", "", "()V", "assembleAppConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "assembleSysConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "plugin-appbrand-integration_release"})
public final class f
{
  public static final f lST;
  
  static
  {
    AppMethodBeat.i(50866);
    lST = new f();
    AppMethodBeat.o(50866);
  }
  
  public static final AppBrandSysConfigWC a(l paraml)
  {
    AppMethodBeat.i(50864);
    p.h(paraml, "runtime");
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)XIPCInvoker.a("com.tencent.mm", new IPCString(paraml.getAppId()), n.class);
    if (localAppBrandSysConfigWC != null)
    {
      localAppBrandSysConfigWC.kbw = new WxaPkgWrappingInfo();
      localAppBrandSysConfigWC.kbw.jLV = paraml.aXx().dQv;
      localAppBrandSysConfigWC.kbw.pkgVersion = paraml.aXx().aDD;
      localAppBrandSysConfigWC.kbw.jLX = true;
      AppMethodBeat.o(50864);
      return localAppBrandSysConfigWC;
    }
    AppMethodBeat.o(50864);
    return null;
  }
  
  public static final a b(l paraml)
  {
    AppMethodBeat.i(50865);
    p.h(paraml, "runtime");
    a locala = a.cE(paraml.getAppId(), "{}");
    locala.jZa = paraml.aXx().jFL;
    p.g(locala, "AppBrandAppConfig.parse(…onfig.enterPath\n        }");
    AppMethodBeat.o(50865);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f
 * JD-Core Version:    0.7.0.1
 */