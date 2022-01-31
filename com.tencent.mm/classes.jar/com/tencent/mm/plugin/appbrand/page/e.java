package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.plugin.appbrand.ui.m;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.i.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory$DefaultFactory;", "()V", "mKeepPersistentViews", "", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBarContainer;", "[Ljava/lang/Class;", "mScreenAdaptiveViews", "Landroid/view/ViewGroup;", "contains", "", "array", "objectToFind", "", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "createKeepPersistentView", "WIDGET", "Landroid/view/View;", "originalContext", "Landroid/content/Context;", "clazz", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "onCreateWidget", "context", "plugin-appbrand-integration_release"})
public final class e
  extends be.a
{
  private final Class<? extends ViewGroup>[] ivq;
  private final Class<d>[] ivr;
  
  public e()
  {
    AppMethodBeat.i(134758);
    this.ivq = new Class[] { b.class, a.class };
    this.ivr = new Class[] { d.class };
    AppMethodBeat.o(134758);
  }
  
  private static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(143905);
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (j.e(paramArrayOfObject[i], paramObject))
      {
        AppMethodBeat.o(143905);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(143905);
    return false;
  }
  
  public final <WIDGET extends View> WIDGET b(Context paramContext, Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(134757);
    j.q(paramContext, "context");
    j.q(paramClass, "clazz");
    if (contains(this.ivq, paramClass))
    {
      paramContext = super.b((Context)new m(paramContext), paramClass);
      AppMethodBeat.o(134757);
      return paramContext;
    }
    if (contains(this.ivr, paramClass))
    {
      if ((paramContext instanceof g)) {}
      for (paramContext = (g)paramContext;; paramContext = g.dc(paramContext))
      {
        paramContext = super.b((Context)paramContext, paramClass);
        AppMethodBeat.o(134757);
        return paramContext;
      }
    }
    paramContext = super.b(paramContext, paramClass);
    AppMethodBeat.o(134757);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.e
 * JD-Core Version:    0.7.0.1
 */