package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"getUsername", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isGame", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPluginApp", "isWeishiApp", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimeWCAccessible
{
  public static final boolean I(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50150);
    if (!(paramAppBrandRuntime instanceof o)) {
      paramAppBrandRuntime = null;
    }
    for (;;)
    {
      paramAppBrandRuntime = (o)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null)
      {
        boolean bool = paramAppBrandRuntime.aTJ();
        AppMethodBeat.o(50150);
        return bool;
      }
      AppMethodBeat.o(50150);
      return false;
    }
  }
  
  public static final boolean J(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(187076);
    if (paramAppBrandRuntime != null) {}
    for (paramAppBrandRuntime = paramAppBrandRuntime.getAppId();; paramAppBrandRuntime = null)
    {
      boolean bool = k.g(paramAppBrandRuntime, "wxfe02ecfe70800f46");
      AppMethodBeat.o(187076);
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
        if (!(paramc instanceof o)) {
          localc = null;
        }
        paramc = (o)localc;
        if (paramc == null) {
          break;
        }
        paramc = paramc.aTS();
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
  
  public static final boolean h(AppBrandInitConfig paramAppBrandInitConfig)
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
        boolean bool = paramAppBrandInitConfig.CC();
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
    if (!(paramAppBrandRuntime instanceof o)) {
      paramAppBrandRuntime = null;
    }
    for (;;)
    {
      paramAppBrandRuntime = (o)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null)
      {
        boolean bool = paramAppBrandRuntime.CC();
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