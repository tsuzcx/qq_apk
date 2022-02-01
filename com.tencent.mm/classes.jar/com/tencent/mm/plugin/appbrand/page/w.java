package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.game.page.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWCUtils;", "", "()V", "resetWindowAndroidToNil", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "plugin-appbrand-integration_release"})
public final class w
{
  public static final w mbF;
  
  static
  {
    AppMethodBeat.i(189550);
    mbF = new w();
    AppMethodBeat.o(189550);
  }
  
  public static final void c(v paramv)
  {
    AppMethodBeat.i(189549);
    p.h(paramv, "$this$resetWindowAndroidToNil");
    Iterator localIterator = paramv.buf();
    p.g(localIterator, "this.stackIterator()");
    while (localIterator.hasNext())
    {
      Object localObject = (r)localIterator.next();
      if (((localObject instanceof e)) || ((localObject instanceof ai)))
      {
        localObject = ((r)localObject).getCurrentPageView();
        p.g(localObject, "it.currentPageView");
        ((aa)localObject).a(null);
      }
      else if ((localObject instanceof k))
      {
        localObject = ((k)localObject).btY();
        p.g(localObject, "it.pagesIterator()");
        while (((Iterator)localObject).hasNext())
        {
          aa localaa = (aa)((Iterator)localObject).next();
          p.g(localaa, "p");
          localaa.a(null);
        }
      }
    }
    paramv = paramv.getPreloadedPageView();
    if (paramv != null)
    {
      paramv.a(null);
      AppMethodBeat.o(189549);
      return;
    }
    AppMethodBeat.o(189549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w
 * JD-Core Version:    0.7.0.1
 */