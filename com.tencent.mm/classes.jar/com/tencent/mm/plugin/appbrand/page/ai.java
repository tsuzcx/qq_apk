package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPreloadedWidgetProvider;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandPreloadedWidgetProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "getPreloadedWidget", "WIDGET", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "ctx", "Landroid/content/Context;", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  implements bc
{
  private final w qxC;
  
  public ai(w paramw)
  {
    AppMethodBeat.i(325213);
    this.qxC = paramw;
    AppMethodBeat.o(325213);
  }
  
  public final <WIDGET extends View> WIDGET a(Class<WIDGET> paramClass, Context paramContext)
  {
    AppMethodBeat.i(325216);
    s.u(paramClass, "clazz");
    s.u(paramContext, "ctx");
    paramClass = this.qxC.ccx().a(paramClass, this.qxC.mContext);
    AppMethodBeat.o(325216);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ai
 * JD-Core Version:    0.7.0.1
 */