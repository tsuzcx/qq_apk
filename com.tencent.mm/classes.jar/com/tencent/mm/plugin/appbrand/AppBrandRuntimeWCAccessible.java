package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getUsername", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isGame", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPluginApp", "isWeishiApp", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class AppBrandRuntimeWCAccessible
{
  public static final boolean G(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50150);
    if ((paramAppBrandRuntime instanceof w)) {}
    for (paramAppBrandRuntime = (w)paramAppBrandRuntime; paramAppBrandRuntime == null; paramAppBrandRuntime = null)
    {
      AppMethodBeat.o(50150);
      return false;
    }
    boolean bool = paramAppBrandRuntime.ccB();
    AppMethodBeat.o(50150);
    return bool;
  }
  
  public static final boolean H(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(316849);
    if (paramAppBrandRuntime == null) {}
    for (paramAppBrandRuntime = null;; paramAppBrandRuntime = paramAppBrandRuntime.mAppId)
    {
      boolean bool = s.p(paramAppBrandRuntime, "wxfe02ecfe70800f46");
      AppMethodBeat.o(316849);
      return bool;
    }
  }
  
  public static final String d(f paramf)
  {
    AppMethodBeat.i(50147);
    if ((paramf instanceof k))
    {
      paramf = (k)paramf;
      if (paramf != null) {
        break label51;
      }
      paramf = null;
      label23:
      if (!(paramf instanceof w)) {
        break label61;
      }
    }
    label51:
    label61:
    for (paramf = (w)paramf;; paramf = null)
    {
      if (paramf != null) {
        break label66;
      }
      AppMethodBeat.o(50147);
      return null;
      paramf = null;
      break;
      paramf = paramf.getRuntime();
      break label23;
    }
    label66:
    paramf = paramf.getInitConfig();
    if (paramf == null)
    {
      AppMethodBeat.o(50147);
      return null;
    }
    paramf = paramf.username;
    AppMethodBeat.o(50147);
    return paramf;
  }
  
  public static final boolean e(f paramf)
  {
    AppMethodBeat.i(50151);
    if ((paramf instanceof k)) {}
    for (paramf = (k)paramf; paramf == null; paramf = null)
    {
      AppMethodBeat.o(50151);
      return false;
    }
    paramf = paramf.getRuntime();
    if (paramf == null)
    {
      AppMethodBeat.o(50151);
      return false;
    }
    boolean bool = isGame(paramf);
    AppMethodBeat.o(50151);
    return bool;
  }
  
  public static final boolean g(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(50149);
    if ((paramAppBrandInitConfig instanceof AppBrandInitConfigWC)) {}
    for (paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig; paramAppBrandInitConfig == null; paramAppBrandInitConfig = null)
    {
      AppMethodBeat.o(50149);
      return false;
    }
    boolean bool = paramAppBrandInitConfig.aqJ();
    AppMethodBeat.o(50149);
    return bool;
  }
  
  public static final boolean isGame(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50148);
    if ((paramAppBrandRuntime instanceof w)) {}
    for (paramAppBrandRuntime = (w)paramAppBrandRuntime; paramAppBrandRuntime == null; paramAppBrandRuntime = null)
    {
      AppMethodBeat.o(50148);
      return false;
    }
    boolean bool = paramAppBrandRuntime.aqJ();
    AppMethodBeat.o(50148);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible
 * JD-Core Version:    0.7.0.1
 */