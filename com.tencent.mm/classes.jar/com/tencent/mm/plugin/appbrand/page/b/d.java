package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onIntercepted", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"})
public class d<T extends AppBrandRuntime>
  implements e<T>
{
  public static final a mlq;
  
  static
  {
    AppMethodBeat.i(208124);
    mlq = new a((byte)0);
    AppMethodBeat.o(208124);
  }
  
  public final boolean a(T paramT, String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(208122);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    paramRunnable = paramT.aWm();
    p.g(paramRunnable, "runtime.pageContainer");
    paramRunnable = paramRunnable.getCurrentPage();
    if (paramRunnable != null) {}
    for (paramRunnable = paramRunnable.a(i.mlx); paramRunnable == null; paramRunnable = null)
    {
      ae.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(208122);
      return false;
    }
    if (paramRunnable.Uk(paramString))
    {
      ae.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "scene:[" + paramString + "] intercept!!");
      m(paramT, paramString);
      AppMethodBeat.o(208122);
      return true;
    }
    AppMethodBeat.o(208122);
    return false;
  }
  
  public final e.a bwv()
  {
    return (e.a)e.a.a.mlr;
  }
  
  public final i bww()
  {
    return i.mlx;
  }
  
  public void m(T paramT, String paramString)
  {
    AppMethodBeat.i(208123);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    AppMethodBeat.o(208123);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.d
 * JD-Core Version:    0.7.0.1
 */