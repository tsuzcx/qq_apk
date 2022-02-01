package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "currentTabType", "getCurrentTabType", "()I", "setCurrentTabType", "(I)V", "isEnableStoreLastTabType", "", "isNeedCheckShowCollapsibleTip", "isNeedShowDoubleClickTip", "refreshExpired", "clearTipCache", "", "get", "tabType", "getBusinessInfoKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getLastRedDotTabType", "getTargetEnterTabType", "incrementCollapsibleTipCount", "count", "incrementDoubleClickTipCount", "isAutoRefresh", "isShowCollapsibleTip", "isShowDoubleClickTip", "markFocusTabType", "markUnFocusTabType", "onCleared", "resetCache", "store", "lastExitPosition", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "storeLastTabType", "source", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "Cache", "Companion", "LastTabTypeSource", "RefreshState", "plugin-finder_release"})
public final class FinderHomeTabStateVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final b sZl;
  public final ConcurrentHashMap<Integer, a> sZf;
  public int sZg;
  private int sZh;
  private boolean sZi;
  private boolean sZj;
  public boolean sZk;
  
  static
  {
    AppMethodBeat.i(205410);
    sZl = new b((byte)0);
    AppMethodBeat.o(205410);
  }
  
  public FinderHomeTabStateVM()
  {
    AppMethodBeat.i(205409);
    this.sZf = new ConcurrentHashMap();
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sZh = ((Number)com.tencent.mm.plugin.finder.storage.b.cGt().value()).intValue();
    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sZi = com.tencent.mm.plugin.finder.storage.b.cGG();
    this.sZj = true;
    this.sZk = true;
    AppMethodBeat.o(205409);
  }
  
  public static al.a Gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return al.a.IGR;
    case 3: 
      return al.a.IGS;
    case 1: 
      return al.a.IGR;
    case 4: 
      return al.a.IGU;
    }
    return al.a.IGT;
  }
  
  private static int cOd()
  {
    AppMethodBeat.i(205397);
    com.tencent.mm.kernel.e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(al.a.IGQ, -1);
    AppMethodBeat.o(205397);
    return i;
  }
  
  public static void cOf()
  {
    AppMethodBeat.i(205406);
    com.tencent.mm.kernel.e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(al.a.IGV, 0);
    locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IGV, Integer.valueOf(i + 1));
    AppMethodBeat.o(205406);
  }
  
  public static void fY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205407);
    com.tencent.mm.kernel.e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(Gl(paramInt1), 0);
    locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(Gl(paramInt1), Integer.valueOf(i + paramInt2));
    AppMethodBeat.o(205407);
  }
  
  public final boolean Gg(int paramInt)
  {
    AppMethodBeat.i(205399);
    a locala = Gi(paramInt);
    d locald = locala.sZr;
    if (locald == d.sZz)
    {
      AppMethodBeat.o(205399);
      return true;
    }
    if ((locald == d.sZy) || (locald == d.sZB))
    {
      if (System.currentTimeMillis() - locala.sZq > this.sZh)
      {
        locala.a(d.sZA);
        AppMethodBeat.o(205399);
        return true;
      }
    }
    else if (locald == d.sZA)
    {
      AppMethodBeat.o(205399);
      return true;
    }
    locala.a(d.sZB);
    AppMethodBeat.o(205399);
    return false;
  }
  
  public final void Gh(int paramInt)
  {
    AppMethodBeat.i(205401);
    a locala = Gi(paramInt);
    locala.a(d.sZy);
    locala.sZq = System.currentTimeMillis();
    ad.i("Finder.TlTabStateVM", "[markUnFocusTabType] tabType=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(205401);
  }
  
  public final a Gi(int paramInt)
  {
    AppMethodBeat.i(205403);
    if (this.sZf.get(Integer.valueOf(paramInt)) == null) {
      ((Map)this.sZf).put(Integer.valueOf(paramInt), new a(paramInt));
    }
    Object localObject = this.sZf.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      p.gfZ();
    }
    localObject = (a)localObject;
    AppMethodBeat.o(205403);
    return localObject;
  }
  
  public final boolean Gj(int paramInt)
  {
    AppMethodBeat.i(205405);
    if (!this.sZj)
    {
      AppMethodBeat.o(205405);
      return false;
    }
    com.tencent.mm.kernel.e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    if (locale.ajl().getInt(Gl(paramInt), 0) < 3)
    {
      AppMethodBeat.o(205405);
      return true;
    }
    this.sZj = false;
    AppMethodBeat.o(205405);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<al> paramArrayList, ArrayList<c> paramArrayList1)
  {
    AppMethodBeat.i(205395);
    p.h(paramArrayList, "lastDataList");
    p.h(paramArrayList1, "lastSectionDataList");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sZh = ((Number)com.tencent.mm.plugin.finder.storage.b.cGt().value()).intValue();
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sZi = com.tencent.mm.plugin.finder.storage.b.cGG();
    localObject1 = ((Iterable)paramArrayList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (al)((Iterator)localObject1).next();
      if ((localObject2 instanceof BaseFinderFeed)) {
        ((BaseFinderFeed)localObject2).cCH();
      }
    }
    localObject1 = Gi(paramInt1);
    ((a)localObject1).sZo = paramInt2;
    ((a)localObject1).sZp = paramInt3;
    ((a)localObject1).dN((List)paramArrayList);
    Object localObject2 = (List)paramArrayList1;
    p.h(localObject2, "<set-?>");
    ((a)localObject1).sZn = ((List)localObject2);
    if ((paramArrayList.isEmpty()) && (paramArrayList1.isEmpty())) {}
    for (paramArrayList = d.sZz;; paramArrayList = d.sZy)
    {
      ((a)localObject1).a(paramArrayList);
      ad.i("Finder.TlTabStateVM", "[store] tabType=" + paramInt1 + " lastExitPosition=" + paramInt2 + " lastExitFromTopPx=" + paramInt3 + " refreshState=" + ((a)localObject1).sZr + ' ' + "current=" + i.formatTime("yyyy-MM-dd HH:mm:ss", ((a)localObject1).sZq / 1000L));
      AppMethodBeat.o(205395);
      return;
    }
  }
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(205398);
    p.h(paramc, "source");
    ad.i("Finder.TlTabStateVM", "[storeLastTabType] tabType=" + paramInt + " source=" + paramc + " isEnableStoreLastTabType=" + this.sZi);
    if ((paramc == c.sZt) || (paramc == c.sZw))
    {
      paramc = g.ajC();
      p.g(paramc, "MMKernel.storage()");
      paramc.ajl().set(al.a.IGQ, Integer.valueOf(paramInt));
      AppMethodBeat.o(205398);
      return;
    }
    if (paramc == c.sZs)
    {
      paramc = g.ajC();
      p.g(paramc, "MMKernel.storage()");
      paramc.ajl().set(al.a.IGP, Integer.valueOf(paramInt));
      paramc = g.ajC();
      p.g(paramc, "MMKernel.storage()");
      paramc.ajl().set(al.a.IGQ, Integer.valueOf(-1));
    }
    AppMethodBeat.o(205398);
  }
  
  public final void af()
  {
    AppMethodBeat.i(205404);
    super.af();
    AppMethodBeat.o(205404);
  }
  
  public final int fsM()
  {
    AppMethodBeat.i(221578);
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IGP, 4);
    int i;
    int m;
    if (this.sZi)
    {
      i = k;
      if (!Gg(k)) {
        break label172;
      }
      m = cOd();
      if (m != -1) {
        break label166;
      }
      localObject = g.ad(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      int n = ((PluginFinder)localObject).getRedDotManager().czP();
      j = n;
      if (n != -1) {}
    }
    label166:
    for (int j = i;; j = m)
    {
      ad.i("Finder.TlTabStateVM", "[getLastTabType] autoRefresh... ret=" + j + " lastRedType=" + m + " lastExitTabType=" + k + " defaultServerTabType=" + i);
      AppMethodBeat.o(221578);
      return j;
      i = 4;
      break;
    }
    label172:
    ad.i("Finder.TlTabStateVM", "[getLastTabType] no autoRefresh... lastExitTabType=".concat(String.valueOf(k)));
    AppMethodBeat.o(221578);
    return k;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getLastSectionDataList", "setLastSectionDataList", "refreshState", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "getRefreshState", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "setRefreshState", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;)V", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private final int duh;
    public List<? extends al> sZm;
    public List<c> sZn;
    public int sZo;
    public int sZp;
    public long sZq;
    FinderHomeTabStateVM.d sZr;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(205387);
      this.duh = paramInt;
      this.sZm = ((List)new LinkedList());
      this.sZn = ((List)new LinkedList());
      this.sZr = FinderHomeTabStateVM.d.sZz;
      AppMethodBeat.o(205387);
    }
    
    public final void a(FinderHomeTabStateVM.d paramd)
    {
      AppMethodBeat.i(205386);
      p.h(paramd, "<set-?>");
      this.sZr = paramd;
      AppMethodBeat.o(205386);
    }
    
    public final void dN(List<? extends al> paramList)
    {
      AppMethodBeat.i(205385);
      p.h(paramList, "<set-?>");
      this.sZm = paramList;
      AppMethodBeat.o(205385);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.duh != paramObject.duh) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.duh;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205388);
      String str = "Cache(tabType=" + this.duh + ")";
      AppMethodBeat.o(205388);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "", "(Ljava/lang/String;I)V", "SOURCE_EXIT", "SOURCE_RED_DOT", "SOURCE_RESET", "SOURCE_MULTI_TAB_NEW", "SOURCE_RED_DOT_REVOKE", "plugin-finder_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(205389);
      c localc1 = new c("SOURCE_EXIT", 0);
      sZs = localc1;
      c localc2 = new c("SOURCE_RED_DOT", 1);
      sZt = localc2;
      c localc3 = new c("SOURCE_RESET", 2);
      sZu = localc3;
      c localc4 = new c("SOURCE_MULTI_TAB_NEW", 3);
      sZv = localc4;
      c localc5 = new c("SOURCE_RED_DOT_REVOKE", 4);
      sZw = localc5;
      sZx = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(205389);
    }
    
    private c() {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "", "(Ljava/lang/String;I)V", "Default", "HardRefresh", "Timeout", "InCacheTime", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(205392);
      d locald1 = new d("Default", 0);
      sZy = locald1;
      d locald2 = new d("HardRefresh", 1);
      sZz = locald2;
      d locald3 = new d("Timeout", 2);
      sZA = locald3;
      d locald4 = new d("InCacheTime", 3);
      sZB = locald4;
      sZC = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(205392);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM
 * JD-Core Version:    0.7.0.1
 */