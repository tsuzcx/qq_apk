package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getUsername", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isGame", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPluginApp", "isWeishiApp", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimeWCAccessible
{
  public static final boolean E(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50150);
    if (!(paramAppBrandRuntime instanceof t)) {
      paramAppBrandRuntime = null;
    }
    for (;;)
    {
      paramAppBrandRuntime = (t)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null)
      {
        boolean bool = paramAppBrandRuntime.bDl();
        AppMethodBeat.o(50150);
        return bool;
      }
      AppMethodBeat.o(50150);
      return false;
    }
  }
  
  public static final boolean F(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(272069);
    if (paramAppBrandRuntime != null) {}
    for (paramAppBrandRuntime = paramAppBrandRuntime.getAppId();; paramAppBrandRuntime = null)
    {
      boolean bool = p.h(paramAppBrandRuntime, "wxfe02ecfe70800f46");
      AppMethodBeat.o(272069);
      return bool;
    }
  }
  
  public static final String e(e parame)
  {
    AppMethodBeat.i(50147);
    if (!(parame instanceof j)) {
      parame = null;
    }
    for (;;)
    {
      parame = (j)parame;
      if (parame != null) {}
      for (parame = parame.getRuntime();; parame = null)
      {
        e locale = parame;
        if (!(parame instanceof t)) {
          locale = null;
        }
        parame = (t)locale;
        if (parame == null) {
          break;
        }
        parame = parame.bDy();
        if (parame == null) {
          break;
        }
        parame = parame.username;
        AppMethodBeat.o(50147);
        return parame;
      }
      AppMethodBeat.o(50147);
      return null;
    }
  }
  
  public static final boolean f(e parame)
  {
    AppMethodBeat.i(50151);
    if (!(parame instanceof j)) {
      parame = null;
    }
    for (;;)
    {
      parame = (j)parame;
      if (parame != null)
      {
        parame = parame.getRuntime();
        if (parame != null)
        {
          boolean bool = isGame(parame);
          AppMethodBeat.o(50151);
          return bool;
        }
      }
      AppMethodBeat.o(50151);
      return false;
    }
  }
  
  public static final boolean g(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(50149);
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC)) {
      paramAppBrandInitConfig = null;
    }
    for (;;)
    {
      paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
      if (paramAppBrandInitConfig != null)
      {
        boolean bool = paramAppBrandInitConfig.Qv();
        AppMethodBeat.o(50149);
        return bool;
      }
      AppMethodBeat.o(50149);
      return false;
    }
  }
  
  public static final boolean isGame(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50148);
    if (!(paramAppBrandRuntime instanceof t)) {
      paramAppBrandRuntime = null;
    }
    for (;;)
    {
      paramAppBrandRuntime = (t)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null)
      {
        boolean bool = paramAppBrandRuntime.Qv();
        AppMethodBeat.o(50148);
        return bool;
      }
      AppMethodBeat.o(50148);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible
 * JD-Core Version:    0.7.0.1
 */