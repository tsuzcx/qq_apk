package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.j.a;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.widget.recent.m;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandRecentDesktopViewModel;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewModel;", "()V", "hasMore", "", "lastItemCreateTime", "", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "getUsageStorage", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "getInitialDataList", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "getLocalNextPageDataList", "", "callback", "Lkotlin/Function1;", "getNextPageDataList", "title", "", "viewType", "", "Companion", "plugin-appbrand-integration_release"})
public final class f
  extends c
{
  public static final f.a rqr;
  private boolean hasMore = true;
  private long rqp = 9223372036854775807L;
  private ah rqq;
  
  static
  {
    AppMethodBeat.i(265746);
    rqr = new f.a((byte)0);
    AppMethodBeat.o(265746);
  }
  
  private final void A(final b<? super List<? extends AppBrandDesktopView.a>, x> paramb)
  {
    AppMethodBeat.i(265745);
    com.tencent.e.h.ZvG.bf((Runnable)new b(this, paramb));
    AppMethodBeat.o(265745);
  }
  
  private final ah cnD()
  {
    AppMethodBeat.i(265741);
    if (this.rqq == null) {
      this.rqq = ((ah)com.tencent.mm.plugin.appbrand.widget.recent.c.rEB.cqe());
    }
    ah localah = this.rqq;
    AppMethodBeat.o(265741);
    return localah;
  }
  
  public final String aBd()
  {
    AppMethodBeat.i(265742);
    String str = a.ba(MMApplicationContext.getContext(), au.i.appbrand_desktop_recent);
    p.j(str, "ResourceHelper.getString….appbrand_desktop_recent)");
    AppMethodBeat.o(265742);
    return str;
  }
  
  public final boolean aDl()
  {
    return this.hasMore;
  }
  
  public final int cnA()
  {
    return 1;
  }
  
  public final List<AppBrandDesktopView.a> cnB()
  {
    ArrayList localArrayList;
    List localList;
    for (;;)
    {
      LocalUsageInfo localLocalUsageInfo;
      try
      {
        AppMethodBeat.i(265743);
        localArrayList = new ArrayList();
        Object localObject1 = cnD();
        if (localObject1 != null)
        {
          localObject1 = ((ah)localObject1).zh(com.tencent.mm.plugin.appbrand.widget.recent.h.rEK.count);
          if (localObject1 == null) {
            break;
          }
          localObject1 = kotlin.a.j.l((Iterable)localObject1);
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((Iterable)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject1).next();
          AppBrandDesktopView.a locala = new AppBrandDesktopView.a(1);
          locala.g(localLocalUsageInfo);
          localArrayList.add(locala);
          if (localLocalUsageInfo != null) {
            break label139;
          }
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo");
          AppMethodBeat.o(265743);
          throw ((Throwable)localObject1);
        }
      }
      finally {}
      localList = null;
      continue;
      label139:
      this.rqp = ((AppBrandRecentTaskInfo)localLocalUsageInfo).coZ;
    }
    if (localArrayList.size() >= com.tencent.mm.plugin.appbrand.widget.recent.h.rEK.count) {}
    for (boolean bool = true;; bool = false)
    {
      this.hasMore = bool;
      localList = (List)localArrayList;
      AppMethodBeat.o(265743);
      return localList;
    }
  }
  
  public final void z(b<? super List<? extends AppBrandDesktopView.a>, x> paramb)
  {
    AppMethodBeat.i(265744);
    p.k(paramb, "callback");
    if (com.tencent.mm.plugin.appbrand.appusage.j.bJh())
    {
      com.tencent.mm.plugin.appbrand.appusage.j.bJf().a(Util.nowMilliSecond(), false, null, 3, 2, 32, -1L, (j.a)new f.c(this, paramb));
      AppMethodBeat.o(265744);
      return;
    }
    A(paramb);
    AppMethodBeat.o(265744);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf, b paramb) {}
    
    public final void run()
    {
      int i = 0;
      boolean bool = true;
      AppMethodBeat.i(271585);
      ArrayList localArrayList;
      for (;;)
      {
        LocalUsageInfo localLocalUsageInfo;
        synchronized (this.rqs)
        {
          localArrayList = new ArrayList();
          int j = com.tencent.mm.plugin.appbrand.widget.recent.h.rEK.count;
          Object localObject1 = this.rqs;
          if (com.tencent.mm.plugin.appbrand.appusage.j.bJh())
          {
            f.a((f)localObject1, bool);
            localObject1 = f.a(this.rqs);
            if (localObject1 == null) {
              break label177;
            }
            localObject1 = ((ah)localObject1).i(f.b(this.rqs), j + 1);
            if (localObject1 == null) {
              break;
            }
            localObject1 = kotlin.a.j.l((Iterable)localObject1);
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject1).next();
            i += 1;
            if (i <= j) {
              break label183;
            }
            f.a(this.rqs, true);
          }
        }
        bool = false;
        continue;
        label177:
        localObject3 = null;
        continue;
        label183:
        Object localObject4 = new AppBrandDesktopView.a(1);
        ((AppBrandDesktopView.a)localObject4).g(localLocalUsageInfo);
        localArrayList.add(localObject4);
        localObject4 = this.rqs;
        if (localLocalUsageInfo == null)
        {
          localObject3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo");
          AppMethodBeat.o(271585);
          throw ((Throwable)localObject3);
        }
        f.a((f)localObject4, ((AppBrandRecentTaskInfo)localLocalUsageInfo).coZ);
      }
      paramb.invoke(localArrayList);
      Object localObject3 = x.aazN;
      AppMethodBeat.o(271585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f
 * JD-Core Version:    0.7.0.1
 */