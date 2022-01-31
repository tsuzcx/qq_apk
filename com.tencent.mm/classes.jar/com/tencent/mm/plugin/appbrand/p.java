package com.tencent.mm.plugin.appbrand;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWCAccessible;", "", "()V", "getUsername", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isGame", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPluginApp", "plugin-appbrand-integration_release"})
public final class p
{
  public static final p gRD;
  
  static
  {
    AppMethodBeat.i(134453);
    gRD = new p();
    AppMethodBeat.o(134453);
  }
  
  public static final String b(c paramc)
  {
    AppMethodBeat.i(134448);
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
        paramc = paramc.atS();
        if (paramc == null) {
          break;
        }
        paramc = paramc.username;
        AppMethodBeat.o(134448);
        return paramc;
      }
      AppMethodBeat.o(134448);
      return null;
    }
  }
  
  public static final boolean c(c paramc)
  {
    Object localObject = null;
    AppMethodBeat.i(134451);
    if (!(paramc instanceof h)) {
      paramc = null;
    }
    for (;;)
    {
      h localh = (h)paramc;
      paramc = localObject;
      if (localh != null) {
        paramc = localh.getRuntime();
      }
      boolean bool = m(paramc);
      AppMethodBeat.o(134451);
      return bool;
    }
  }
  
  public static final boolean i(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134450);
    j.q(paramAppBrandInitConfig, "initConfig");
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC)) {
      paramAppBrandInitConfig = null;
    }
    for (;;)
    {
      paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
      if (paramAppBrandInitConfig != null)
      {
        boolean bool = paramAppBrandInitConfig.vY();
        AppMethodBeat.o(134450);
        return bool;
      }
      AppMethodBeat.o(134450);
      return false;
    }
  }
  
  public static final boolean m(i parami)
  {
    AppMethodBeat.i(134449);
    if (!(parami instanceof o)) {
      parami = null;
    }
    for (;;)
    {
      parami = (o)parami;
      if (parami != null)
      {
        boolean bool = parami.vY();
        AppMethodBeat.o(134449);
        return bool;
      }
      AppMethodBeat.o(134449);
      return false;
    }
  }
  
  public static final boolean n(i parami)
  {
    AppMethodBeat.i(134452);
    if (!(parami instanceof o)) {
      parami = null;
    }
    for (;;)
    {
      parami = (o)parami;
      if (parami != null)
      {
        boolean bool = parami.atM();
        AppMethodBeat.o(134452);
        return bool;
      }
      AppMethodBeat.o(134452);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p
 * JD-Core Version:    0.7.0.1
 */