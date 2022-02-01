package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"getUsername", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isGame", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPluginApp", "isWeishiApp", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimeWCAccessible
{
  public static final boolean D(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50150);
    if (!(paramAppBrandRuntime instanceof q)) {
      paramAppBrandRuntime = null;
    }
    for (;;)
    {
      paramAppBrandRuntime = (q)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null)
      {
        boolean bool = paramAppBrandRuntime.bsr();
        AppMethodBeat.o(50150);
        return bool;
      }
      AppMethodBeat.o(50150);
      return false;
    }
  }
  
  public static final boolean E(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(227895);
    if (paramAppBrandRuntime != null) {}
    for (paramAppBrandRuntime = paramAppBrandRuntime.getAppId();; paramAppBrandRuntime = null)
    {
      boolean bool = p.j(paramAppBrandRuntime, "wxfe02ecfe70800f46");
      AppMethodBeat.o(227895);
      return bool;
    }
  }
  
  public static final String c(f paramf)
  {
    AppMethodBeat.i(50147);
    if (!(paramf instanceof k)) {
      paramf = null;
    }
    for (;;)
    {
      paramf = (k)paramf;
      if (paramf != null) {}
      for (paramf = paramf.getRuntime();; paramf = null)
      {
        f localf = paramf;
        if (!(paramf instanceof q)) {
          localf = null;
        }
        paramf = (q)localf;
        if (paramf == null) {
          break;
        }
        paramf = paramf.bsC();
        if (paramf == null) {
          break;
        }
        paramf = paramf.username;
        AppMethodBeat.o(50147);
        return paramf;
      }
      AppMethodBeat.o(50147);
      return null;
    }
  }
  
  public static final boolean d(f paramf)
  {
    AppMethodBeat.i(50151);
    if (!(paramf instanceof k)) {
      paramf = null;
    }
    for (;;)
    {
      paramf = (k)paramf;
      if (paramf != null)
      {
        paramf = paramf.getRuntime();
        if (paramf != null)
        {
          boolean bool = isGame(paramf);
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
        boolean bool = paramAppBrandInitConfig.NA();
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
    if (!(paramAppBrandRuntime instanceof q)) {
      paramAppBrandRuntime = null;
    }
    for (;;)
    {
      paramAppBrandRuntime = (q)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null)
      {
        boolean bool = paramAppBrandRuntime.NA();
        AppMethodBeat.o(50148);
        return bool;
      }
      AppMethodBeat.o(50148);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible
 * JD-Core Version:    0.7.0.1
 */