package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPreloadedWidgetProvider;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandPreloadedWidgetProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "getPreloadedWidget", "WIDGET", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class ae
  implements aw
{
  private final com.tencent.mm.plugin.appbrand.p jFm;
  
  public ae(com.tencent.mm.plugin.appbrand.p paramp)
  {
    AppMethodBeat.i(223821);
    this.jFm = paramp;
    AppMethodBeat.o(223821);
  }
  
  public final <WIDGET extends View> WIDGET aC(Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(223820);
    d.g.b.p.h(paramClass, "clazz");
    paramClass = this.jFm.aXl().aC(paramClass);
    AppMethodBeat.o(223820);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae
 * JD-Core Version:    0.7.0.1
 */