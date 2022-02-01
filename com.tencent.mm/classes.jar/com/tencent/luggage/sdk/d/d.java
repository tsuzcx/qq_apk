package com.tencent.luggage.sdk.d;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bn.a;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/sdk/runtime/RuntimePkgReaderFactoryInterceptorImpl;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgReaderInternalImplFactory$FactoryInterceptor;", "()V", "forceNewReader", "", "getForceNewReader", "()Z", "setForceNewReader", "(Z)V", "forceNewReaderForGame", "getForceNewReaderForGame", "setForceNewReaderForGame", "createInternalReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "wrapper", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgRuntimeReader;", "isGame", "luggage-wechat-full-sdk_release"})
public final class d
  implements bn.a
{
  private static volatile boolean cps;
  private static volatile boolean cpt;
  public static final d cpu;
  
  static
  {
    AppMethodBeat.i(183002);
    cpu = new d();
    AppMethodBeat.o(183002);
  }
  
  public static void by(boolean paramBoolean)
  {
    cps = paramBoolean;
  }
  
  public static void bz(boolean paramBoolean)
  {
    cpt = paramBoolean;
  }
  
  private static boolean isGame(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183001);
    AppBrandInitConfig localAppBrandInitConfig = paramAppBrandRuntime.Fi();
    paramAppBrandRuntime = localAppBrandInitConfig;
    if (!(localAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
      paramAppBrandRuntime = null;
    }
    paramAppBrandRuntime = (AppBrandInitConfigLU)paramAppBrandRuntime;
    if ((paramAppBrandRuntime != null) && (paramAppBrandRuntime.cmr == 4))
    {
      AppMethodBeat.o(183001);
      return true;
    }
    AppMethodBeat.o(183001);
    return false;
  }
  
  public final q a(AppBrandRuntime paramAppBrandRuntime, bf parambf)
  {
    AppMethodBeat.i(183000);
    p.h(paramAppBrandRuntime, "rt");
    p.h(parambf, "wrapper");
    Object localObject = (AppBrandSysConfigLU)paramAppBrandRuntime.c(AppBrandSysConfigLU.class, false);
    if (localObject != null)
    {
      localObject = ((AppBrandSysConfigLU)localObject).jYh;
      if (localObject != null)
      {
        localObject = ((WxaPkgWrappingInfo)localObject).jIZ;
        if ((localObject != null) && (!((WxaRuntimeModulePluginListMap)localObject).isEmpty()))
        {
          paramAppBrandRuntime = new bm(paramAppBrandRuntime);
          if (paramAppBrandRuntime == null) {
            break label149;
          }
          parambf.LE("__plugin__/");
          parambf.LE("__extended__/");
        }
      }
    }
    for (;;)
    {
      paramAppBrandRuntime = (q)paramAppBrandRuntime;
      AppMethodBeat.o(183000);
      return paramAppBrandRuntime;
      if ((cps) && (!isGame(paramAppBrandRuntime)))
      {
        paramAppBrandRuntime = new bm(paramAppBrandRuntime);
        break;
      }
      if ((cpt) && (isGame(paramAppBrandRuntime)))
      {
        paramAppBrandRuntime = new bm(paramAppBrandRuntime);
        break;
      }
      paramAppBrandRuntime = null;
      break;
      label149:
      paramAppBrandRuntime = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.d
 * JD-Core Version:    0.7.0.1
 */