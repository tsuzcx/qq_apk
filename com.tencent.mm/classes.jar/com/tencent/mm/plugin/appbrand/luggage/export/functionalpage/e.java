package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalConfigAssembler;", "", "()V", "assembleAppConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "assembleSysConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e ioB;
  
  static
  {
    AppMethodBeat.i(134737);
    ioB = new e();
    AppMethodBeat.o(134737);
  }
  
  public static final AppBrandSysConfigWC a(j paramj)
  {
    AppMethodBeat.i(134735);
    a.f.b.j.q(paramj, "runtime");
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)XIPCInvoker.a("com.tencent.mm", new IPCString(paramj.getAppId()), l.class);
    if (localAppBrandSysConfigWC != null)
    {
      localAppBrandSysConfigWC.hiX = new WxaPkgWrappingInfo();
      localAppBrandSysConfigWC.hiX.gXe = paramj.atS().gXd;
      localAppBrandSysConfigWC.hiX.gXf = paramj.atS().bDc;
      localAppBrandSysConfigWC.hiX.gXh = true;
      AppMethodBeat.o(134735);
      return localAppBrandSysConfigWC;
    }
    AppMethodBeat.o(134735);
    return null;
  }
  
  public static final a b(j paramj)
  {
    AppMethodBeat.i(134736);
    a.f.b.j.q(paramj, "runtime");
    a locala = a.zV("{}");
    locala.hgZ = paramj.atS().hiw;
    a.f.b.j.p(locala, "AppBrandAppConfig.parse(…onfig.enterPath\n        }");
    AppMethodBeat.o(134736);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e
 * JD-Core Version:    0.7.0.1
 */