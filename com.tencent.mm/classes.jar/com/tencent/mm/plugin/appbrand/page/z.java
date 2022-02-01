package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.game.page.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWCUtils;", "", "()V", "resetWindowAndroidToNil", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
{
  public static final z twN;
  
  static
  {
    AppMethodBeat.i(324925);
    twN = new z();
    AppMethodBeat.o(324925);
  }
  
  public static final void c(y paramy)
  {
    AppMethodBeat.i(324923);
    s.u(paramy, "<this>");
    Object localObject1 = paramy.cEm();
    s.s(localObject1, "this.stackIterator()");
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (u)((Iterator)localObject1).next();
      if ((localObject2 instanceof e)) {}
      for (boolean bool = true;; bool = localObject2 instanceof al)
      {
        if (!bool) {
          break label73;
        }
        ((u)localObject2).getCurrentPageView().a(null);
        break;
      }
      label73:
      if ((localObject2 instanceof n))
      {
        localObject2 = ((n)localObject2).cEa();
        s.s(localObject2, "it.pagesIterator()");
        while (((Iterator)localObject2).hasNext()) {
          ((ad)((Iterator)localObject2).next()).a(null);
        }
      }
    }
    localObject1 = paramy.getPreloadedPageView();
    if (localObject1 != null) {
      ((ad)localObject1).a(null);
    }
    localObject1 = paramy.getCurrentPage();
    if (localObject1 != null)
    {
      localObject1 = ((u)localObject1).getCurrentPageView();
      if (localObject1 != null) {
        paramy.k((ad)localObject1);
      }
    }
    AppMethodBeat.o(324923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z
 * JD-Core Version:    0.7.0.1
 */