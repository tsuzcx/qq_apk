package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.game.page.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWCUtils;", "", "()V", "resetWindowAndroidToNil", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "plugin-appbrand-integration_release"})
public final class z
{
  public static final z qsi;
  
  static
  {
    AppMethodBeat.i(275367);
    qsi = new z();
    AppMethodBeat.o(275367);
  }
  
  public static final void c(y paramy)
  {
    AppMethodBeat.i(275364);
    p.k(paramy, "$this$resetWindowAndroidToNil");
    Object localObject1 = paramy.cdG();
    p.j(localObject1, "this.stackIterator()");
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (u)((Iterator)localObject1).next();
      if (((localObject2 instanceof e)) || ((localObject2 instanceof al)))
      {
        localObject2 = ((u)localObject2).getCurrentPageView();
        p.j(localObject2, "it.currentPageView");
        ((ad)localObject2).b(null);
      }
      else if ((localObject2 instanceof n))
      {
        localObject2 = ((n)localObject2).cdz();
        p.j(localObject2, "it.pagesIterator()");
        while (((Iterator)localObject2).hasNext())
        {
          ad localad = (ad)((Iterator)localObject2).next();
          p.j(localad, "p");
          localad.b(null);
        }
      }
    }
    localObject1 = paramy.getPreloadedPageView();
    if (localObject1 != null) {
      ((ad)localObject1).b(null);
    }
    localObject1 = paramy.getCurrentPage();
    if (localObject1 != null)
    {
      localObject1 = ((u)localObject1).getCurrentPageView();
      if (localObject1 != null)
      {
        paramy.j((ad)localObject1);
        AppMethodBeat.o(275364);
        return;
      }
    }
    AppMethodBeat.o(275364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z
 * JD-Core Version:    0.7.0.1
 */