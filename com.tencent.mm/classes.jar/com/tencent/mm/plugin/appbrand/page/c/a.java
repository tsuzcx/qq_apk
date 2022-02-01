package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageNavigateBackDefaultInterceptor;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "()V", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "luggage-wxa-app_release"})
public final class a
  implements d<AppBrandRuntime>
{
  public static final a lgN;
  
  static
  {
    AppMethodBeat.i(176460);
    lgN = new a();
    AppMethodBeat.o(176460);
  }
  
  public final boolean a(AppBrandRuntime paramAppBrandRuntime, String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(176459);
    k.h(paramAppBrandRuntime, "runtime");
    k.h(paramString, "scene");
    k.h(paramRunnable, "continueNavigateBack");
    AppMethodBeat.o(176459);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.a
 * JD-Core Version:    0.7.0.1
 */