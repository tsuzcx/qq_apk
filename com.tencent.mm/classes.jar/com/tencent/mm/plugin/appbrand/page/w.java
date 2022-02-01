package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.game.page.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWCUtils;", "", "()V", "resetWindowAndroidToNil", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "plugin-appbrand-integration_release"})
public final class w
{
  public static final w lCe;
  
  static
  {
    AppMethodBeat.i(187348);
    lCe = new w();
    AppMethodBeat.o(187348);
  }
  
  public static final void c(v paramv)
  {
    AppMethodBeat.i(187347);
    d.g.b.k.h(paramv, "$this$resetWindowAndroidToNil");
    Iterator localIterator = paramv.bqf();
    d.g.b.k.g(localIterator, "this.stackIterator()");
    while (localIterator.hasNext())
    {
      Object localObject = (r)localIterator.next();
      if (((localObject instanceof e)) || ((localObject instanceof ai)))
      {
        localObject = ((r)localObject).getCurrentPageView();
        d.g.b.k.g(localObject, "it.currentPageView");
        ((aa)localObject).a(null);
      }
      else if ((localObject instanceof k))
      {
        localObject = ((k)localObject).bpY();
        d.g.b.k.g(localObject, "it.pagesIterator()");
        while (((Iterator)localObject).hasNext())
        {
          aa localaa = (aa)((Iterator)localObject).next();
          d.g.b.k.g(localaa, "p");
          localaa.a(null);
        }
      }
    }
    paramv = paramv.getPreloadedPageView();
    if (paramv != null)
    {
      paramv.a(null);
      AppMethodBeat.o(187347);
      return;
    }
    AppMethodBeat.o(187347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w
 * JD-Core Version:    0.7.0.1
 */