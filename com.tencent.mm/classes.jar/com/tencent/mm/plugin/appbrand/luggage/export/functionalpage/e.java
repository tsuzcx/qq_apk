package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalConfigAssembler;", "", "()V", "assembleAppConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "assembleSysConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e kPu;
  
  static
  {
    AppMethodBeat.i(50866);
    kPu = new e();
    AppMethodBeat.o(50866);
  }
  
  public static final AppBrandSysConfigWC a(j paramj)
  {
    AppMethodBeat.i(50864);
    k.h(paramj, "runtime");
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)XIPCInvoker.a("com.tencent.mm", new IPCString(paramj.getAppId()), l.class);
    if (localAppBrandSysConfigWC != null)
    {
      localAppBrandSysConfigWC.jdS = new WxaPkgWrappingInfo();
      localAppBrandSysConfigWC.jdS.iOQ = paramj.aNc().iOP;
      localAppBrandSysConfigWC.jdS.pkgVersion = paramj.aNc().aAS;
      localAppBrandSysConfigWC.jdS.iOS = true;
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
    a locala = a.cq(paramj.getAppId(), "{}");
    locala.jbB = paramj.aNc().iJb;
    k.g(locala, "AppBrandAppConfig.parse(…onfig.enterPath\n        }");
    AppMethodBeat.o(50865);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e
 * JD-Core Version:    0.7.0.1
 */