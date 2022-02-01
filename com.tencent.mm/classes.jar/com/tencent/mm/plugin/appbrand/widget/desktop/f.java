package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.widget.recent.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandRecentDesktopViewModel;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewModel;", "()V", "hasMore", "", "lastItemCreateTime", "", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "getUsageStorage", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "getInitialDataList", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "getLocalNextPageDataList", "", "callback", "Lkotlin/Function1;", "getNextPageDataList", "title", "", "viewType", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends c
{
  public static final f.a uAA;
  private boolean hasMore = true;
  private long uAB = 9223372036854775807L;
  private ag uAC;
  
  static
  {
    AppMethodBeat.i(324217);
    uAA = new f.a((byte)0);
    AppMethodBeat.o(324217);
  }
  
  private static final void a(f paramf, b paramb)
  {
    int i = 0;
    boolean bool = true;
    AppMethodBeat.i(324214);
    s.u(paramf, "this$0");
    s.u(paramb, "$callback");
    ArrayList localArrayList;
    for (;;)
    {
      int j;
      LocalUsageInfo localLocalUsageInfo;
      try
      {
        localArrayList = new ArrayList();
        j = com.tencent.mm.plugin.appbrand.widget.recent.h.uPX.count;
        if (com.tencent.mm.plugin.appbrand.appusage.i.ciL())
        {
          paramf.hasMore = bool;
          localObject = paramf.cPG();
          if (localObject != null) {
            break label153;
          }
          localObject = null;
          if (localObject == null) {
            break;
          }
          localObject = p.l((Iterable)localObject);
          if (localObject == null) {
            break;
          }
          localObject = ((Iterable)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject).next();
          i += 1;
          if (i <= j) {
            break label172;
          }
          paramf.hasMore = true;
          continue;
        }
        bool = false;
      }
      finally
      {
        AppMethodBeat.o(324214);
      }
      continue;
      label153:
      Object localObject = ((ag)localObject).r(paramf.uAB, j + 1);
      continue;
      label172:
      AppBrandDesktopView.a locala = new AppBrandDesktopView.a(1);
      locala.uAl = localLocalUsageInfo;
      ah localah = ah.aiuX;
      localArrayList.add(locala);
      paramf.uAB = ((AppBrandRecentTaskInfo)localLocalUsageInfo).egK;
    }
    paramb.invoke(localArrayList);
    paramb = ah.aiuX;
    AppMethodBeat.o(324214);
  }
  
  private static final void a(f paramf, b paramb, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(324207);
    s.u(paramf, "this$0");
    s.u(paramb, "$callback");
    Log.i("MicroMsg.AppBrandRecentDesktopViewModel", "fetchNextPageFromServer: " + paramBoolean + ' ' + paramString);
    paramf.ac(paramb);
    AppMethodBeat.o(324207);
  }
  
  private final void ac(b<? super List<? extends AppBrandDesktopView.a>, ah> paramb)
  {
    AppMethodBeat.i(324204);
    com.tencent.threadpool.h.ahAA.bn(new f..ExternalSyntheticLambda1(this, paramb));
    AppMethodBeat.o(324204);
  }
  
  private final ag cPG()
  {
    AppMethodBeat.i(324198);
    if (this.uAC == null) {
      this.uAC = ((ag)com.tencent.mm.plugin.appbrand.widget.recent.c.uPM.cSJ());
    }
    ag localag = this.uAC;
    AppMethodBeat.o(324198);
    return localag;
  }
  
  public final String aUa()
  {
    AppMethodBeat.i(324227);
    String str = a.bt(MMApplicationContext.getContext(), ba.i.appbrand_desktop_recent);
    s.s(str, "getString(MMApplicationC….appbrand_desktop_recent)");
    AppMethodBeat.o(324227);
    return str;
  }
  
  public final boolean aWl()
  {
    return this.hasMore;
  }
  
  public final void ab(b<? super List<? extends AppBrandDesktopView.a>, ah> paramb)
  {
    AppMethodBeat.i(324233);
    s.u(paramb, "callback");
    if (com.tencent.mm.plugin.appbrand.appusage.i.ciL())
    {
      com.tencent.mm.plugin.appbrand.appusage.i.ciJ().a(Util.nowMilliSecond(), false, null, 3, 2, 32, -1L, new f..ExternalSyntheticLambda0(this, paramb));
      AppMethodBeat.o(324233);
      return;
    }
    ac(paramb);
    AppMethodBeat.o(324233);
  }
  
  public final int cPD()
  {
    return 1;
  }
  
  public final List<AppBrandDesktopView.a> cPE()
  {
    ArrayList localArrayList;
    List localList;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(324231);
        localArrayList = new ArrayList();
        Object localObject1 = cPG();
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break;
          }
          localObject1 = p.l((Iterable)localObject1);
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((Iterable)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject1).next();
          AppBrandDesktopView.a locala = new AppBrandDesktopView.a(1);
          locala.uAl = localLocalUsageInfo;
          ah localah = ah.aiuX;
          localArrayList.add(locala);
          this.uAB = ((AppBrandRecentTaskInfo)localLocalUsageInfo).egK;
          continue;
        }
        localList = localObject2.zu(com.tencent.mm.plugin.appbrand.widget.recent.h.uPX.count);
      }
      finally {}
    }
    if (localArrayList.size() >= com.tencent.mm.plugin.appbrand.widget.recent.h.uPX.count) {}
    for (boolean bool = true;; bool = false)
    {
      this.hasMore = bool;
      localList = (List)localArrayList;
      AppMethodBeat.o(324231);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f
 * JD-Core Version:    0.7.0.1
 */