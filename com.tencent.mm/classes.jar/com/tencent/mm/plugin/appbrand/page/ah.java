package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPreloadedWidgetProvider;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandPreloadedWidgetProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "getPreloadedWidget", "WIDGET", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "ctx", "Landroid/content/Context;", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class ah
  implements ba
{
  private final q kGW;
  
  public ah(q paramq)
  {
    AppMethodBeat.i(229242);
    this.kGW = paramq;
    AppMethodBeat.o(229242);
  }
  
  public final <WIDGET extends View> WIDGET a(Class<WIDGET> paramClass, Context paramContext)
  {
    AppMethodBeat.i(229241);
    p.h(paramClass, "clazz");
    p.h(paramContext, "ctx");
    paramContext = this.kGW.bsn();
    Context localContext = this.kGW.getAppContext();
    p.g(localContext, "runtime.appContext");
    paramClass = paramContext.a(paramClass, localContext);
    AppMethodBeat.o(229241);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah
 * JD-Core Version:    0.7.0.1
 */