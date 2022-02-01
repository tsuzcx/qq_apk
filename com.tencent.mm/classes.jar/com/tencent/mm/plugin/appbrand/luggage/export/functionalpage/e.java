package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalConfigAssembler;", "", "()V", "assembleAppConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "assembleSysConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e lqT;
  
  static
  {
    AppMethodBeat.i(50866);
    lqT = new e();
    AppMethodBeat.o(50866);
  }
  
  public static final AppBrandSysConfigWC a(j paramj)
  {
    AppMethodBeat.i(50864);
    k.h(paramj, "runtime");
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)XIPCInvoker.a("com.tencent.mm", new IPCString(paramj.getAppId()), l.class);
    if (localAppBrandSysConfigWC != null)
    {
      localAppBrandSysConfigWC.jEg = new WxaPkgWrappingInfo();
      localAppBrandSysConfigWC.jEg.jpa = paramj.aTS().joY;
      localAppBrandSysConfigWC.jEg.pkgVersion = paramj.aTS().aBM;
      localAppBrandSysConfigWC.jEg.jpc = true;
      AppMethodBeat.o(50864);
      return localAppBrandSysConfigWC;
    }
    AppMethodBeat.o(50864);
    return null;
  }
  
  public static final a b(j paramj)
  {
    AppMethodBeat.i(50865);
    k.h(paramj, "runtime");
    a locala = a.cA(paramj.getAppId(), "{}");
    locala.jBO = paramj.aTS().jjf;
    k.g(locala, "AppBrandAppConfig.parse(…onfig.enterPath\n        }");
    AppMethodBeat.o(50865);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e
 * JD-Core Version:    0.7.0.1
 */