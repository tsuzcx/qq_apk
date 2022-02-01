package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.game.page.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWCUtils;", "", "()V", "resetWindowAndroidToNil", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "plugin-appbrand-integration_release"})
public final class y
{
  public static final y nqw;
  
  static
  {
    AppMethodBeat.i(229240);
    nqw = new y();
    AppMethodBeat.o(229240);
  }
  
  public static final void c(x paramx)
  {
    AppMethodBeat.i(229239);
    p.h(paramx, "$this$resetWindowAndroidToNil");
    Object localObject1 = paramx.bQQ();
    p.g(localObject1, "this.stackIterator()");
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (t)((Iterator)localObject1).next();
      if (((localObject2 instanceof e)) || ((localObject2 instanceof ak)))
      {
        localObject2 = ((t)localObject2).getCurrentPageView();
        p.g(localObject2, "it.currentPageView");
        ((ac)localObject2).b(null);
      }
      else if ((localObject2 instanceof m))
      {
        localObject2 = ((m)localObject2).bQJ();
        p.g(localObject2, "it.pagesIterator()");
        while (((Iterator)localObject2).hasNext())
        {
          ac localac = (ac)((Iterator)localObject2).next();
          p.g(localac, "p");
          localac.b(null);
        }
      }
    }
    localObject1 = paramx.getPreloadedPageView();
    if (localObject1 != null) {
      ((ac)localObject1).b(null);
    }
    localObject1 = paramx.getCurrentPage();
    if (localObject1 != null)
    {
      localObject1 = ((t)localObject1).getCurrentPageView();
      if (localObject1 != null)
      {
        paramx.j((ac)localObject1);
        AppMethodBeat.o(229239);
        return;
      }
    }
    AppMethodBeat.o(229239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y
 * JD-Core Version:    0.7.0.1
 */