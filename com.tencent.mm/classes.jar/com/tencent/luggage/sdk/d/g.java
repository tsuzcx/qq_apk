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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/runtime/RuntimePkgReaderFactoryInterceptorImpl;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgReaderInternalImplFactory$FactoryInterceptor;", "()V", "forceNewReader", "", "getForceNewReader", "()Z", "setForceNewReader", "(Z)V", "forceNewReaderForGame", "getForceNewReaderForGame", "setForceNewReaderForGame", "createInternalReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "wrapper", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgRuntimeReader;", "isGame", "luggage-wechat-full-sdk_release"})
public final class g
  implements bo.a
{
  private static volatile boolean cCo;
  private static volatile boolean cCp;
  public static final g cCq;
  
  static
  {
    AppMethodBeat.i(183002);
    cCq = new g();
    AppMethodBeat.o(183002);
  }
  
  public static void OV()
  {
    cCo = true;
  }
  
  public static void OW()
  {
    cCp = true;
  }
  
  private static boolean isGame(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183001);
    AppBrandInitConfig localAppBrandInitConfig = paramAppBrandRuntime.OU();
    paramAppBrandRuntime = localAppBrandInitConfig;
    if (!(localAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
      paramAppBrandRuntime = null;
    }
    paramAppBrandRuntime = (AppBrandInitConfigLU)paramAppBrandRuntime;
    if ((paramAppBrandRuntime != null) && (paramAppBrandRuntime.cyo == 4))
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
    Object localObject = (AppBrandSysConfigLU)paramAppBrandRuntime.d(AppBrandSysConfigLU.class, false);
    if (localObject != null)
    {
      localObject = ((AppBrandSysConfigLU)localObject).leE;
      if (localObject != null)
      {
        localObject = ((WxaPkgWrappingInfo)localObject).kOb;
        if ((localObject != null) && (!((WxaRuntimeModulePluginListMap)localObject).isEmpty()))
        {
          paramAppBrandRuntime = new bn(paramAppBrandRuntime);
          if (paramAppBrandRuntime == null) {
            break label149;
          }
          parambg.Vq("__plugin__/");
          parambg.Vq("__extended__/");
        }
      }
    }
    for (;;)
    {
      paramAppBrandRuntime = (q)paramAppBrandRuntime;
      AppMethodBeat.o(183000);
      return paramAppBrandRuntime;
      if ((cCo) && (!isGame(paramAppBrandRuntime)))
      {
        paramAppBrandRuntime = new bn(paramAppBrandRuntime);
        break;
      }
      if ((cCp) && (isGame(paramAppBrandRuntime)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.g
 * JD-Core Version:    0.7.0.1
 */