package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.game.page.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWCUtils;", "", "()V", "resetWindowAndroidToNil", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "plugin-appbrand-integration_release"})
public final class v
{
  public static final v lau;
  
  static
  {
    AppMethodBeat.i(196410);
    lau = new v();
    AppMethodBeat.o(196410);
  }
  
  public static final void c(u paramu)
  {
    AppMethodBeat.i(196409);
    k.h(paramu, "$this$resetWindowAndroidToNil");
    Iterator localIterator = paramu.bjn();
    k.g(localIterator, "this.stackIterator()");
    while (localIterator.hasNext())
    {
      Object localObject = (q)localIterator.next();
      if (((localObject instanceof e)) || ((localObject instanceof an)))
      {
        localObject = ((q)localObject).getCurrentPageView();
        k.g(localObject, "it.currentPageView");
        ((aa)localObject).a(null);
      }
      else if ((localObject instanceof j))
      {
        localObject = ((j)localObject).bjg();
        k.g(localObject, "it.pagesIterator()");
        while (((Iterator)localObject).hasNext())
        {
          aa localaa = (aa)((Iterator)localObject).next();
          k.g(localaa, "p");
          localaa.a(null);
        }
      }
    }
    paramu = paramu.getPreloadedPageView();
    if (paramu != null)
    {
      paramu.a(null);
      AppMethodBeat.o(196409);
      return;
    }
    AppMethodBeat.o(196409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v
 * JD-Core Version:    0.7.0.1
 */