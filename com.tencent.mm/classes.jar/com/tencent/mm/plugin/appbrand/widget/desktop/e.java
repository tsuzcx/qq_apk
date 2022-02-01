package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.widget.recent.h;
import com.tencent.mm.plugin.appbrand.widget.recent.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandMyDesktopViewModel;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewModel;", "()V", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "getCollectionStorage", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "getInitialDataList", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "getNextPageDataList", "", "callback", "Lkotlin/Function1;", "title", "", "viewType", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c
{
  private af uAz;
  
  public final String aUa()
  {
    AppMethodBeat.i(324203);
    String str = a.bt(MMApplicationContext.getContext(), ba.i.appbrand_desktop_my);
    s.s(str, "getString(MMApplicationC…ring.appbrand_desktop_my)");
    AppMethodBeat.o(324203);
    return str;
  }
  
  public final void ab(b<? super List<? extends AppBrandDesktopView.a>, ah> paramb)
  {
    AppMethodBeat.i(324224);
    s.u(paramb, "callback");
    paramb.invoke((List)ab.aivy);
    AppMethodBeat.o(324224);
  }
  
  public final int cPD()
  {
    return 2;
  }
  
  public final List<AppBrandDesktopView.a> cPE()
  {
    AppMethodBeat.i(324219);
    ArrayList localArrayList = new ArrayList();
    if (this.uAz == null) {
      this.uAz = ((af)com.tencent.mm.plugin.appbrand.widget.recent.c.uPM.cSK());
    }
    Object localObject1 = this.uAz;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 != null; localObject1 = ((af)localObject1).a(h.uPW.count, h.uPW.qQm))
    {
      localObject1 = p.l((Iterable)localObject1);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (LocalUsageInfo)((Iterator)localObject1).next();
        AppBrandDesktopView.a locala = new AppBrandDesktopView.a(2);
        locala.uAl = ((LocalUsageInfo)localObject2);
        localObject2 = ah.aiuX;
        localArrayList.add(locala);
      }
    }
    localObject1 = (List)localArrayList;
    AppMethodBeat.o(324219);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.e
 * JD-Core Version:    0.7.0.1
 */