package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onIntercepted", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"})
public class d<T extends AppBrandRuntime>
  implements e<T>
{
  public static final a nvO;
  
  static
  {
    AppMethodBeat.i(219740);
    nvO = new a((byte)0);
    AppMethodBeat.o(219740);
  }
  
  public final boolean a(T paramT, String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(219738);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    paramRunnable = paramT.brh();
    p.g(paramRunnable, "runtime.pageContainer");
    paramRunnable = paramRunnable.getCurrentPage();
    if (paramRunnable != null) {}
    for (paramRunnable = paramRunnable.a(i.nvV); paramRunnable == null; paramRunnable = null)
    {
      Log.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(219738);
      return false;
    }
    if (paramRunnable.adY(paramString))
    {
      Log.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "scene:[" + paramString + "] intercept!!");
      m(paramT, paramString);
      AppMethodBeat.o(219738);
      return true;
    }
    AppMethodBeat.o(219738);
    return false;
  }
  
  public final e.a bSD()
  {
    return (e.a)e.a.a.nvP;
  }
  
  public final i bSE()
  {
    return i.nvV;
  }
  
  public void m(T paramT, String paramString)
  {
    AppMethodBeat.i(219739);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    AppMethodBeat.o(219739);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.d
 * JD-Core Version:    0.7.0.1
 */