package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onIntercepted", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"})
public class d<T extends AppBrandRuntime>
  implements e<T>
{
  public static final a mgq;
  
  static
  {
    AppMethodBeat.i(197515);
    mgq = new a((byte)0);
    AppMethodBeat.o(197515);
  }
  
  public final boolean a(T paramT, String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(197513);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    paramRunnable = paramT.aVN();
    p.g(paramRunnable, "runtime.pageContainer");
    paramRunnable = paramRunnable.getCurrentPage();
    if (paramRunnable != null) {}
    for (paramRunnable = paramRunnable.a(h.mgy); paramRunnable == null; paramRunnable = null)
    {
      ad.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(197513);
      return false;
    }
    if (paramRunnable.TB(paramString))
    {
      ad.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "scene:[" + paramString + "] intercept!!");
      m(paramT, paramString);
      AppMethodBeat.o(197513);
      return true;
    }
    AppMethodBeat.o(197513);
    return false;
  }
  
  public final e.a bvE()
  {
    return (e.a)e.a.a.mgs;
  }
  
  public final h bvF()
  {
    return h.mgy;
  }
  
  public void m(T paramT, String paramString)
  {
    AppMethodBeat.i(197514);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    AppMethodBeat.o(197514);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.d
 * JD-Core Version:    0.7.0.1
 */