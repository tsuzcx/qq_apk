package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPreloadedWidgetProvider;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandPreloadedWidgetProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "getPreloadedWidget", "WIDGET", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class af
  implements ax
{
  private final o jPl;
  
  public af(o paramo)
  {
    AppMethodBeat.i(187350);
    this.jPl = paramo;
    AppMethodBeat.o(187350);
  }
  
  public final <WIDGET extends View> WIDGET aC(Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(187349);
    k.h(paramClass, "clazz");
    paramClass = this.jPl.aTG().aC(paramClass);
    AppMethodBeat.o(187349);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af
 * JD-Core Version:    0.7.0.1
 */