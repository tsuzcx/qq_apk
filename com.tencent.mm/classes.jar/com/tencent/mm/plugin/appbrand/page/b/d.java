package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onIntercepted", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d<T extends AppBrandRuntime>
  implements e<T>
{
  public static final d.a tCQ;
  
  static
  {
    AppMethodBeat.i(325094);
    tCQ = new d.a((byte)0);
    AppMethodBeat.o(325094);
  }
  
  public final boolean a(T paramT, String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(325105);
    s.u(paramT, "runtime");
    s.u(paramString, "scene");
    paramRunnable = paramT.getPageContainer().getCurrentPage();
    if (paramRunnable == null) {}
    for (paramRunnable = null; paramRunnable == null; paramRunnable = paramRunnable.a(i.tCX))
    {
      Log.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(325105);
      return false;
    }
    if (paramRunnable.afc(paramString))
    {
      Log.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "scene:[" + paramString + "] intercept!!");
      n(paramT, paramString);
      AppMethodBeat.o(325105);
      return true;
    }
    AppMethodBeat.o(325105);
    return false;
  }
  
  public final e.a cGt()
  {
    return (e.a)e.a.a.tCR;
  }
  
  public final i cGu()
  {
    return i.tCX;
  }
  
  public void n(T paramT, String paramString)
  {
    AppMethodBeat.i(325121);
    s.u(paramT, "runtime");
    s.u(paramString, "scene");
    AppMethodBeat.o(325121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.d
 * JD-Core Version:    0.7.0.1
 */