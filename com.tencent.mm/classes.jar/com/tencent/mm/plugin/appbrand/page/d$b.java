package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "", "()V", "mMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Landroid/view/View;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "clear", "", "offer", "clazz", "widget", "poll", "WIDGET", "(Ljava/lang/Class;)Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class d$b
{
  final HashMap<Class<? extends View>, LinkedList<View>> dz;
  
  public d$b()
  {
    AppMethodBeat.i(50901);
    this.dz = new HashMap();
    AppMethodBeat.o(50901);
  }
  
  public final void a(final Class<? extends View> paramClass, View paramView)
  {
    AppMethodBeat.i(50898);
    p.h(paramClass, "clazz");
    p.h(paramView, "widget");
    if ((LinkedList)this.dz.get(paramClass) == null) {
      ((a)new a(this, paramClass)).invoke();
    }
    paramClass = this.dz.get(paramClass);
    if (paramClass == null) {
      p.gfZ();
    }
    ((LinkedList)paramClass).addLast(paramView);
    AppMethodBeat.o(50898);
  }
  
  public final <WIDGET extends View> WIDGET aD(Class<? extends WIDGET> paramClass)
  {
    Object localObject = null;
    AppMethodBeat.i(50899);
    p.h(paramClass, "clazz");
    paramClass = (LinkedList)this.dz.get(paramClass);
    if (paramClass != null)
    {
      paramClass = (View)paramClass.pollFirst();
      if ((paramClass instanceof View)) {
        break label58;
      }
      paramClass = localObject;
    }
    label58:
    for (;;)
    {
      AppMethodBeat.o(50899);
      return paramClass;
      paramClass = null;
      break;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(50900);
    Object localObject = this.dz.values();
    p.g(localObject, "mMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((LinkedList)((Iterator)localObject).next()).clear();
    }
    this.dz.clear();
    AppMethodBeat.o(50900);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/LinkedList;", "Landroid/view/View;", "invoke"})
  static final class a
    extends q
    implements a<LinkedList<View>>
  {
    a(d.b paramb, Class paramClass)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.b
 * JD-Core Version:    0.7.0.1
 */