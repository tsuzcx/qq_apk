package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "", "()V", "mMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Landroid/view/View;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "clear", "", "offer", "clazz", "widget", "poll", "WIDGET", "ctx", "Landroid/content/Context;", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$b
{
  private final HashMap<Class<? extends View>, LinkedList<View>> bIx;
  
  public f$b()
  {
    AppMethodBeat.i(50901);
    this.bIx = new HashMap();
    AppMethodBeat.o(50901);
  }
  
  private static final LinkedList a(b paramb, Class paramClass)
  {
    AppMethodBeat.i(325168);
    s.u(paramb, "this$0");
    s.u(paramClass, "$clazz");
    LinkedList localLinkedList = new LinkedList();
    ((Map)paramb.bIx).put(paramClass, localLinkedList);
    AppMethodBeat.o(325168);
    return localLinkedList;
  }
  
  public final void a(Class<? extends View> paramClass, View paramView)
  {
    AppMethodBeat.i(50898);
    s.u(paramClass, "clazz");
    s.u(paramView, "widget");
    if ((LinkedList)this.bIx.get(paramClass) == null) {
      a(this, paramClass);
    }
    paramClass = this.bIx.get(paramClass);
    s.checkNotNull(paramClass);
    ((LinkedList)paramClass).addLast(paramView);
    AppMethodBeat.o(50898);
  }
  
  public final <WIDGET extends View> WIDGET b(Class<? extends WIDGET> paramClass, Context paramContext)
  {
    AppMethodBeat.i(325174);
    s.u(paramClass, "clazz");
    s.u(paramContext, "ctx");
    Object localObject = (LinkedList)this.bIx.get(paramClass);
    label46:
    float f1;
    float f2;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof View)) {
        break label146;
      }
      if (localObject == null) {
        break label158;
      }
      f1 = paramContext.getResources().getDisplayMetrics().density;
      f2 = ((View)localObject).getContext().getResources().getDisplayMetrics().density;
      if (f1 != f2) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label158;
      }
      Log.i("MicroMsg.AppBrandDecorWidgetFactoryWC", "getPreloadedWidget: [%s]([%f]) preloaded but outer density([%f]) has changed, ret null", new Object[] { paramClass.getCanonicalName(), Float.valueOf(f2), Float.valueOf(f1) });
      AppMethodBeat.o(325174);
      return null;
      localObject = (View)((LinkedList)localObject).pollFirst();
      break;
      localObject = null;
      break label46;
    }
    label158:
    AppMethodBeat.o(325174);
    return localObject;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(50900);
    Object localObject = this.bIx.values();
    s.s(localObject, "mMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((LinkedList)((Iterator)localObject).next()).clear();
    }
    this.bIx.clear();
    AppMethodBeat.o(50900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f.b
 * JD-Core Version:    0.7.0.1
 */