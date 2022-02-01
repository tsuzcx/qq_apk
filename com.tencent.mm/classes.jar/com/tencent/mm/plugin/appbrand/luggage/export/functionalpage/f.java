package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalConfigAssembler;", "", "()V", "assembleAppConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "assembleSysConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f tfP;
  
  static
  {
    AppMethodBeat.i(50866);
    tfP = new f();
    AppMethodBeat.o(50866);
  }
  
  public static final AppBrandSysConfigWC a(l paraml)
  {
    AppMethodBeat.i(50864);
    s.u(paraml, "runtime");
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paraml.mAppId), n.class);
    if (localAppBrandSysConfigWC == null)
    {
      AppMethodBeat.o(50864);
      return null;
    }
    localAppBrandSysConfigWC.qYY = new WxaPkgWrappingInfo();
    localAppBrandSysConfigWC.qYY.qHO = paraml.getInitConfig().eul;
    localAppBrandSysConfigWC.qYY.pkgVersion = paraml.getInitConfig().appVersion;
    localAppBrandSysConfigWC.qYY.qHQ = true;
    localAppBrandSysConfigWC.epC = new LaunchWxaAppInfoParcelized(AppRuntimeApiPermissionBundle.tEi, null, null, false, false);
    AppMethodBeat.o(50864);
    return localAppBrandSysConfigWC;
  }
  
  public static final b b(l paraml)
  {
    AppMethodBeat.i(50865);
    s.u(paraml, "runtime");
    b localb = b.ds(paraml.mAppId, "{}");
    localb.qVW = paraml.getInitConfig().qAF;
    s.s(localb, "parse(runtime.appId, \"{}…onfig.enterPath\n        }");
    AppMethodBeat.o(50865);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f
 * JD-Core Version:    0.7.0.1
 */