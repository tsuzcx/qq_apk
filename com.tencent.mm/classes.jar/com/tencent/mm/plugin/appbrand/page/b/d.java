package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onIntercepted", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"})
public class d<T extends AppBrandRuntime>
  implements e<T>
{
  public static final a qxQ;
  
  static
  {
    AppMethodBeat.i(245748);
    qxQ = new a((byte)0);
    AppMethodBeat.o(245748);
  }
  
  public final boolean a(T paramT, String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(245741);
    p.k(paramT, "runtime");
    p.k(paramString, "scene");
    paramRunnable = paramT.bBX();
    p.j(paramRunnable, "runtime.pageContainer");
    paramRunnable = paramRunnable.getCurrentPage();
    if (paramRunnable != null) {}
    for (paramRunnable = paramRunnable.a(i.qxX); paramRunnable == null; paramRunnable = null)
    {
      Log.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(245741);
      return false;
    }
    if (paramRunnable.alT(paramString))
    {
      Log.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "scene:[" + paramString + "] intercept!!");
      n(paramT, paramString);
      AppMethodBeat.o(245741);
      return true;
    }
    AppMethodBeat.o(245741);
    return false;
  }
  
  public final e.a cfG()
  {
    return (e.a)e.a.a.qxR;
  }
  
  public final i cfH()
  {
    return i.qxX;
  }
  
  public void n(T paramT, String paramString)
  {
    AppMethodBeat.i(245743);
    p.k(paramT, "runtime");
    p.k(paramString, "scene");
    AppMethodBeat.o(245743);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.d
 * JD-Core Version:    0.7.0.1
 */