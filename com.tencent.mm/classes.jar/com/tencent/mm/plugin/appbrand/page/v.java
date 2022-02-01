package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.game.page.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWCUtils;", "", "()V", "resetWindowAndroidToNil", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "plugin-appbrand-integration_release"})
public final class v
{
  public static final v mfY;
  
  static
  {
    AppMethodBeat.i(223819);
    mfY = new v();
    AppMethodBeat.o(223819);
  }
  
  public static final void c(u paramu)
  {
    AppMethodBeat.i(223818);
    p.h(paramu, "$this$resetWindowAndroidToNil");
    Iterator localIterator = paramu.buQ();
    p.g(localIterator, "this.stackIterator()");
    while (localIterator.hasNext())
    {
      Object localObject = (q)localIterator.next();
      if (((localObject instanceof e)) || ((localObject instanceof ah)))
      {
        localObject = ((q)localObject).getCurrentPageView();
        p.g(localObject, "it.currentPageView");
        ((z)localObject).a(null);
      }
      else if ((localObject instanceof j))
      {
        localObject = ((j)localObject).buJ();
        p.g(localObject, "it.pagesIterator()");
        while (((Iterator)localObject).hasNext())
        {
          z localz = (z)((Iterator)localObject).next();
          p.g(localz, "p");
          localz.a(null);
        }
      }
    }
    paramu = paramu.getPreloadedPageView();
    if (paramu != null)
    {
      paramu.a(null);
      AppMethodBeat.o(223818);
      return;
    }
    AppMethodBeat.o(223818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v
 * JD-Core Version:    0.7.0.1
 */