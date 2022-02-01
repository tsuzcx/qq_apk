package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.widget.recent.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandMyDesktopViewModel;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewModel;", "()V", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "getCollectionStorage", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "getInitialDataList", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "getNextPageDataList", "", "callback", "Lkotlin/Function1;", "title", "", "viewType", "", "plugin-appbrand-integration_release"})
public final class e
  extends c
{
  private ag rqo;
  
  public final String aBd()
  {
    AppMethodBeat.i(275201);
    String str = a.ba(MMApplicationContext.getContext(), au.i.appbrand_desktop_my);
    p.j(str, "ResourceHelper.getString…ring.appbrand_desktop_my)");
    AppMethodBeat.o(275201);
    return str;
  }
  
  public final int cnA()
  {
    return 2;
  }
  
  public final List<AppBrandDesktopView.a> cnB()
  {
    AppMethodBeat.i(275205);
    ArrayList localArrayList = new ArrayList();
    if (this.rqo == null) {
      this.rqo = ((ag)com.tencent.mm.plugin.appbrand.widget.recent.c.rEB.cqf());
    }
    Object localObject = this.rqo;
    if (localObject != null) {}
    for (localObject = ((ag)localObject).a(h.rEJ.count, h.rEJ.nQx); localObject != null; localObject = null)
    {
      localObject = kotlin.a.j.l((Iterable)localObject);
      if (localObject == null) {
        break;
      }
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject).next();
        AppBrandDesktopView.a locala = new AppBrandDesktopView.a(2);
        locala.g(localLocalUsageInfo);
        localArrayList.add(locala);
      }
    }
    localObject = (List)localArrayList;
    AppMethodBeat.o(275205);
    return localObject;
  }
  
  public final void z(b<? super List<? extends AppBrandDesktopView.a>, x> paramb)
  {
    AppMethodBeat.i(275206);
    p.k(paramb, "callback");
    paramb.invoke((List)v.aaAd);
    AppMethodBeat.o(275206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.e
 * JD-Core Version:    0.7.0.1
 */