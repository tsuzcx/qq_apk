package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"getUsername", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isGame", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPluginApp", "isWeishiApp", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimeWCAccessible
{
  public static final boolean D(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50150);
    if (!(paramAppBrandRuntime instanceof p)) {
      paramAppBrandRuntime = null;
    }
    for (;;)
    {
      paramAppBrandRuntime = (p)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null)
      {
        boolean bool = paramAppBrandRuntime.aXo();
        AppMethodBeat.o(50150);
        return bool;
      }
      AppMethodBeat.o(50150);
      return false;
    }
  }
  
  public static final boolean E(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(223191);
    if (paramAppBrandRuntime != null) {}
    for (paramAppBrandRuntime = paramAppBrandRuntime.getAppId();; paramAppBrandRuntime = null)
    {
      boolean bool = d.g.b.p.i(paramAppBrandRuntime, "wxfe02ecfe70800f46");
      AppMethodBeat.o(223191);
      return bool;
    }
  }
  
  public static final String c(c paramc)
  {
    AppMethodBeat.i(50147);
    if (!(paramc instanceof h)) {
      paramc = null;
    }
    for (;;)
    {
      paramc = (h)paramc;
      if (paramc != null) {}
      for (paramc = paramc.getRuntime();; paramc = null)
      {
        c localc = paramc;
        if (!(paramc instanceof p)) {
          localc = null;
        }
        paramc = (p)localc;
        if (paramc == null) {
          break;
        }
        paramc = paramc.aXx();
        if (paramc == null) {
          break;
        }
        paramc = paramc.username;
        AppMethodBeat.o(50147);
        return paramc;
      }
      AppMethodBeat.o(50147);
      return null;
    }
  }
  
  public static final boolean d(c paramc)
  {
    AppMethodBeat.i(50151);
    if (!(paramc instanceof h)) {
      paramc = null;
    }
    for (;;)
    {
      paramc = (h)paramc;
      if (paramc != null)
      {
        paramc = paramc.getRuntime();
        if (paramc != null)
        {
          boolean bool = isGame(paramc);
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
        boolean bool = paramAppBrandInitConfig.Ee();
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
    if (!(paramAppBrandRuntime instanceof p)) {
      paramAppBrandRuntime = null;
    }
    for (;;)
    {
      paramAppBrandRuntime = (p)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null)
      {
        boolean bool = paramAppBrandRuntime.Ee();
        AppMethodBeat.o(50148);
        return bool;
      }
      AppMethodBeat.o(50148);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible
 * JD-Core Version:    0.7.0.1
 */