package com.tencent.luggage.sdk.d;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.appcache.bo.a;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/runtime/RuntimePkgReaderFactoryInterceptorImpl;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgReaderInternalImplFactory$FactoryInterceptor;", "()V", "forceNewReader", "", "getForceNewReader", "()Z", "setForceNewReader", "(Z)V", "forceNewReaderForGame", "getForceNewReaderForGame", "setForceNewReaderForGame", "createInternalReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "wrapper", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgRuntimeReader;", "isGame", "luggage-wechat-full-sdk_release"})
public final class g
  implements bo.a
{
  private static volatile boolean cpV;
  private static volatile boolean cpW;
  public static final g cpX;
  
  static
  {
    AppMethodBeat.i(183002);
    cpX = new g();
    AppMethodBeat.o(183002);
  }
  
  public static void by(boolean paramBoolean)
  {
    cpV = paramBoolean;
  }
  
  public static void bz(boolean paramBoolean)
  {
    cpW = paramBoolean;
  }
  
  private static boolean isGame(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183001);
    AppBrandInitConfig localAppBrandInitConfig = paramAppBrandRuntime.Fn();
    paramAppBrandRuntime = localAppBrandInitConfig;
    if (!(localAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
      paramAppBrandRuntime = null;
    }
    paramAppBrandRuntime = (AppBrandInitConfigLU)paramAppBrandRuntime;
    if ((paramAppBrandRuntime != null) && (paramAppBrandRuntime.cmt == 4))
    {
      AppMethodBeat.o(183001);
      return true;
    }
    AppMethodBeat.o(183001);
    return false;
  }
  
  public final q a(AppBrandRuntime paramAppBrandRuntime, bg parambg)
  {
    AppMethodBeat.i(183000);
    p.h(paramAppBrandRuntime, "rt");
    p.h(parambg, "wrapper");
    Object localObject = (AppBrandSysConfigLU)paramAppBrandRuntime.c(AppBrandSysConfigLU.class, false);
    if (localObject != null)
    {
      localObject = ((AppBrandSysConfigLU)localObject).kbw;
      if (localObject != null)
      {
        localObject = ((WxaPkgWrappingInfo)localObject).jMa;
        if ((localObject != null) && (!((WxaRuntimeModulePluginListMap)localObject).isEmpty()))
        {
          paramAppBrandRuntime = new bn(paramAppBrandRuntime);
          if (paramAppBrandRuntime == null) {
            break label149;
          }
          parambg.Mh("__plugin__/");
          parambg.Mh("__extended__/");
        }
      }
    }
    for (;;)
    {
      paramAppBrandRuntime = (q)paramAppBrandRuntime;
      AppMethodBeat.o(183000);
      return paramAppBrandRuntime;
      if ((cpV) && (!isGame(paramAppBrandRuntime)))
      {
        paramAppBrandRuntime = new bn(paramAppBrandRuntime);
        break;
      }
      if ((cpW) && (isGame(paramAppBrandRuntime)))
      {
        paramAppBrandRuntime = new bn(paramAppBrandRuntime);
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
 * Qualified Name:     com.tencent.luggage.sdk.d.g
 * JD-Core Version:    0.7.0.1
 */