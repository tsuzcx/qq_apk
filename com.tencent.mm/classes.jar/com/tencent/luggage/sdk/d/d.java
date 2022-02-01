package com.tencent.luggage.sdk.d;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.bm.a;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/runtime/RuntimePkgReaderFactoryInterceptorImpl;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgReaderInternalImplFactory$FactoryInterceptor;", "()V", "forceNewReader", "", "getForceNewReader", "()Z", "setForceNewReader", "(Z)V", "forceNewReaderForGame", "getForceNewReaderForGame", "setForceNewReaderForGame", "createInternalReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "wrapper", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgRuntimeReader;", "isGame", "luggage-wechat-full-sdk_release"})
public final class d
  implements bm.a
{
  private static volatile boolean cfb;
  private static volatile boolean cfc;
  public static final d cfd;
  
  static
  {
    AppMethodBeat.i(183002);
    cfd = new d();
    AppMethodBeat.o(183002);
  }
  
  public static void by(boolean paramBoolean)
  {
    cfb = paramBoolean;
  }
  
  public static void bz(boolean paramBoolean)
  {
    cfc = paramBoolean;
  }
  
  private static boolean isGame(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183001);
    AppBrandInitConfig localAppBrandInitConfig = paramAppBrandRuntime.DJ();
    paramAppBrandRuntime = localAppBrandInitConfig;
    if (!(localAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
      paramAppBrandRuntime = null;
    }
    paramAppBrandRuntime = (AppBrandInitConfigLU)paramAppBrandRuntime;
    if ((paramAppBrandRuntime != null) && (paramAppBrandRuntime.cca == 4))
    {
      AppMethodBeat.o(183001);
      return true;
    }
    AppMethodBeat.o(183001);
    return false;
  }
  
  public final q a(AppBrandRuntime paramAppBrandRuntime, be parambe)
  {
    AppMethodBeat.i(183000);
    k.h(paramAppBrandRuntime, "rt");
    k.h(parambe, "wrapper");
    Object localObject = (AppBrandSysConfigLU)paramAppBrandRuntime.c(AppBrandSysConfigLU.class, false);
    if (localObject != null)
    {
      localObject = ((AppBrandSysConfigLU)localObject).jEg;
      if (localObject != null)
      {
        localObject = ((WxaPkgWrappingInfo)localObject).jpf;
        if ((localObject != null) && (!((WxaRuntimeModulePluginListMap)localObject).isEmpty()))
        {
          paramAppBrandRuntime = new bl(paramAppBrandRuntime);
          if (paramAppBrandRuntime == null) {
            break label149;
          }
          parambe.Im("__plugin__/");
          parambe.Im("__extended__/");
        }
      }
    }
    for (;;)
    {
      paramAppBrandRuntime = (q)paramAppBrandRuntime;
      AppMethodBeat.o(183000);
      return paramAppBrandRuntime;
      if ((cfb) && (!isGame(paramAppBrandRuntime)))
      {
        paramAppBrandRuntime = new bl(paramAppBrandRuntime);
        break;
      }
      if ((cfc) && (isGame(paramAppBrandRuntime)))
      {
        paramAppBrandRuntime = new bl(paramAppBrandRuntime);
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