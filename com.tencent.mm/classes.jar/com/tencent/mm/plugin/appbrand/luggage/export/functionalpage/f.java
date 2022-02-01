package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.b;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalConfigAssembler;", "", "()V", "assembleAppConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "assembleSysConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "plugin-appbrand-integration_release"})
public final class f
{
  public static final f qaJ;
  
  static
  {
    AppMethodBeat.i(50866);
    qaJ = new f();
    AppMethodBeat.o(50866);
  }
  
  public static final AppBrandSysConfigWC a(l paraml)
  {
    AppMethodBeat.i(50864);
    p.k(paraml, "runtime");
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paraml.getAppId()), n.class);
    if (localAppBrandSysConfigWC != null)
    {
      localAppBrandSysConfigWC.nYR = new WxaPkgWrappingInfo();
      localAppBrandSysConfigWC.nYR.nHY = paraml.bDy().cBI;
      localAppBrandSysConfigWC.nYR.pkgVersion = paraml.bDy().appVersion;
      localAppBrandSysConfigWC.nYR.nIa = true;
      AppMethodBeat.o(50864);
      return localAppBrandSysConfigWC;
    }
    AppMethodBeat.o(50864);
    return null;
  }
  
  public static final b b(l paraml)
  {
    AppMethodBeat.i(50865);
    p.k(paraml, "runtime");
    b localb = b.db(paraml.getAppId(), "{}");
    localb.nWl = paraml.bDy().nBq;
    p.j(localb, "AppBrandAppConfig.parse(…onfig.enterPath\n        }");
    AppMethodBeat.o(50865);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f
 * JD-Core Version:    0.7.0.1
 */