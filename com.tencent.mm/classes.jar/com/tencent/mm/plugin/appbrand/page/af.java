package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPreloadedWidgetProvider;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandPreloadedWidgetProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "getPreloadedWidget", "WIDGET", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class af
  implements ax
{
  private final o jCo;
  
  public af(o paramo)
  {
    AppMethodBeat.i(189552);
    this.jCo = paramo;
    AppMethodBeat.o(189552);
  }
  
  public final <WIDGET extends View> WIDGET aC(Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(189551);
    p.h(paramClass, "clazz");
    paramClass = this.jCo.aWQ().aC(paramClass);
    AppMethodBeat.o(189551);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af
 * JD-Core Version:    0.7.0.1
 */