package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "currentTabType", "getCurrentTabType", "()I", "setCurrentTabType", "(I)V", "isEnableStoreLastTabType", "", "isNeedCheckShowCollapsibleTip", "isNeedShowDoubleClickTip", "lastPreloadTimeStampCaches", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastPreloadTimeStampCache;", "lastTabType", "getLastTabType", "setLastTabType", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "redDotManager$delegate", "Lkotlin/Lazy;", "refreshExpired", "getRefreshExpired", "setRefreshExpired", "squareTabsPreloadResponseCaches", "", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "clearTipCache", "", "get", "tabType", "getBusinessInfoKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getPreloadSquareTabsCache", "memoryCacheFlag", "getPreloadTimeStampCache", "liveTabId", "getTargetEnterTabType", "incrementCollapsibleTipCount", "count", "incrementDoubleClickTipCount", "isAutoRefresh", "isShowCollapsibleTip", "isShowDoubleClickTip", "markFocusTabType", "markUnFocusTabType", "onCleared", "resetCache", "store", "lastRootScrollPy", "lastExitPosition", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "fromPreload", "storeLastTabType", "source", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "storePreloadSquareTabsCache", "response", "storePreloadTimeStampCache", "lastFindPrefetchTimeStampMs", "", "lastRedDotPrefetchTimeStampMs", "lastTabPagesPrefetchTimeStampMs", "Cache", "Companion", "LastPreloadTimeStampCache", "LastTabTypeSource", "RefreshState", "plugin-finder_release"})
public final class b
  extends i<PluginFinder>
{
  public static final b Bgv;
  private final ConcurrentHashMap<Integer, a> Bgm;
  private final ConcurrentHashMap<Integer, c> Bgn;
  public ConcurrentHashMap<String, com.tencent.mm.plugin.findersdk.b.h<com.tencent.mm.an.q>> Bgo;
  public int Bgp;
  public int Bgq;
  private int Bgr;
  private boolean Bgs;
  private boolean Bgt;
  private boolean Bgu;
  private final kotlin.f zLw;
  
  static
  {
    AppMethodBeat.i(283322);
    Bgv = new b((byte)0);
    AppMethodBeat.o(283322);
  }
  
  public b()
  {
    AppMethodBeat.i(283321);
    this.Bgm = new ConcurrentHashMap();
    this.Bgn = new ConcurrentHashMap();
    this.Bgo = new ConcurrentHashMap();
    d locald = d.AjH;
    this.Bgr = ((Number)d.dTo().aSr()).intValue();
    this.zLw = g.ar((a)f.BgS);
    this.Bgt = true;
    this.Bgu = true;
    AppMethodBeat.o(283321);
  }
  
  public static ar.a RL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ar.a.Vzi;
    case 3: 
      return ar.a.Vzj;
    case 1: 
      return ar.a.Vzi;
    case 4: 
      return ar.a.Vzl;
    }
    return ar.a.Vzk;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<bu> paramArrayList, ArrayList<c> paramArrayList1, com.tencent.mm.cd.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(283307);
    p.k(paramArrayList, "lastDataList");
    p.k(paramArrayList1, "lastSectionDataList");
    Object localObject1 = d.AjH;
    this.Bgr = ((Number)d.dTo().aSr()).intValue();
    localObject1 = d.AjH;
    this.Bgs = d.dTy();
    this.Bgp = 0;
    localObject1 = ((Iterable)paramArrayList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bu)((Iterator)localObject1).next();
      if ((localObject2 instanceof BaseFinderFeed)) {
        ((BaseFinderFeed)localObject2).dKr();
      }
    }
    localObject1 = RI(paramInt1);
    ((a)localObject1).Bgy = paramInt2;
    ((a)localObject1).Bgz = paramInt3;
    ((a)localObject1).fa((List)paramArrayList);
    Object localObject2 = (List)paramArrayList1;
    p.k(localObject2, "<set-?>");
    ((a)localObject1).Bgx = ((List)localObject2);
    if ((paramArrayList.isEmpty()) && (paramArrayList1.isEmpty())) {}
    for (paramArrayList = e.BgO;; paramArrayList = e.BgN)
    {
      ((a)localObject1).a(paramArrayList);
      ((a)localObject1).lastBuffer = paramb;
      ((a)localObject1).BgC = paramBoolean;
      Log.i("Finder.TlTabStateVM", "[store] tabType=" + paramInt1 + " lastExitPosition=" + paramInt2 + " lastExitFromTopPx=" + paramInt3 + " refreshState=" + ((a)localObject1).BgB + ' ' + "current=" + com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", ((a)localObject1).BgA / 1000L));
      AppMethodBeat.o(283307);
      return;
    }
  }
  
  public static void ekc()
  {
    AppMethodBeat.i(283318);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.Vzm, 0);
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.Vzm, Integer.valueOf(i + 1));
    AppMethodBeat.o(283318);
  }
  
  private final com.tencent.mm.plugin.finder.extension.reddot.f getRedDotManager()
  {
    AppMethodBeat.i(283306);
    com.tencent.mm.plugin.finder.extension.reddot.f localf = (com.tencent.mm.plugin.finder.extension.reddot.f)this.zLw.getValue();
    AppMethodBeat.o(283306);
    return localf;
  }
  
  public static void hk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283319);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(RL(paramInt1), 0);
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(RL(paramInt1), Integer.valueOf(i + paramInt2));
    AppMethodBeat.o(283319);
  }
  
  public final c OB(int paramInt)
  {
    AppMethodBeat.i(283314);
    if (this.Bgn.get(Integer.valueOf(paramInt)) == null) {
      ((Map)this.Bgn).put(Integer.valueOf(paramInt), new c(paramInt));
    }
    Object localObject = this.Bgn.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      p.iCn();
    }
    localObject = (c)localObject;
    AppMethodBeat.o(283314);
    return localObject;
  }
  
  public final boolean OO(int paramInt)
  {
    AppMethodBeat.i(283310);
    a locala = RI(paramInt);
    e locale = locala.BgB;
    if (locale == e.BgO)
    {
      AppMethodBeat.o(283310);
      return true;
    }
    if ((locale == e.BgN) || (locale == e.BgQ))
    {
      if (System.currentTimeMillis() - locala.BgA > this.Bgr)
      {
        locala.a(e.BgP);
        AppMethodBeat.o(283310);
        return true;
      }
    }
    else if (locale == e.BgP)
    {
      AppMethodBeat.o(283310);
      return true;
    }
    locala.a(e.BgQ);
    AppMethodBeat.o(283310);
    return false;
  }
  
  public final void RH(int paramInt)
  {
    AppMethodBeat.i(283311);
    a locala = RI(paramInt);
    locala.a(e.BgN);
    locala.BgA = System.currentTimeMillis();
    Log.i("Finder.TlTabStateVM", "[markUnFocusTabType] tabType=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(283311);
  }
  
  public final a RI(int paramInt)
  {
    AppMethodBeat.i(283313);
    if (this.Bgm.get(Integer.valueOf(paramInt)) == null) {
      ((Map)this.Bgm).put(Integer.valueOf(paramInt), new a(paramInt));
    }
    Object localObject = this.Bgm.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      p.iCn();
    }
    localObject = (a)localObject;
    AppMethodBeat.o(283313);
    return localObject;
  }
  
  public final boolean RJ(int paramInt)
  {
    AppMethodBeat.i(283317);
    if (!this.Bgt)
    {
      AppMethodBeat.o(283317);
      return false;
    }
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    if (localf.aHp().getInt(RL(paramInt), 0) < 3)
    {
      AppMethodBeat.o(283317);
      return true;
    }
    this.Bgt = false;
    AppMethodBeat.o(283317);
    return false;
  }
  
  public final void a(int paramInt, b.d paramd)
  {
    AppMethodBeat.i(283309);
    p.k(paramd, "source");
    Log.i("Finder.TlTabStateVM", "[storeLastTabType] tabType=" + paramInt + " source=" + paramd + " isEnableStoreLastTabType=" + this.Bgs);
    if (paramd == b.d.BgH)
    {
      paramd = com.tencent.mm.kernel.h.aHG();
      p.j(paramd, "MMKernel.storage()");
      paramd.aHp().set(ar.a.Vze, Integer.valueOf(paramInt));
      paramd = com.tencent.mm.kernel.h.aHG();
      p.j(paramd, "MMKernel.storage()");
      paramd.aHp().set(ar.a.Vzh, Integer.valueOf(-1));
    }
    AppMethodBeat.o(283309);
  }
  
  public final int ekb()
  {
    int i = 4;
    AppMethodBeat.i(283312);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int k = localf.aHp().getInt(ar.a.Vze, 4);
    if (this.Bgs) {
      i = k;
    }
    if (getRedDotManager().aBf("FinderEntrance") != null) {}
    for (boolean bool = true; (OO(k)) || (bool); bool = false)
    {
      int m = getRedDotManager().dqG();
      int j = m;
      if (m == -1) {
        j = i;
      }
      Log.i("Finder.TlTabStateVM", "[getTargetEnterTabType] autoRefresh... ret=" + j + " hasEntranceCtrlInfo=" + bool + " lastExitTabType=" + k + " defaultServerTabType=" + i);
      AppMethodBeat.o(283312);
      return j;
    }
    Log.i("Finder.TlTabStateVM", "[getTargetEnterTabType] no autoRefresh... hasEntranceCtrlInfo=false lastExitTabType=" + k + " defaultServerTabType=" + i);
    AppMethodBeat.o(283312);
    return k;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(283315);
    super.onCleared();
    AppMethodBeat.o(283315);
  }
  
  public final void resetCache()
  {
    AppMethodBeat.i(283316);
    a(4, b.d.BgJ);
    this.Bgm.clear();
    this.Bgn.clear();
    this.Bgo.clear();
    AppMethodBeat.o(283316);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "", "tabType", "", "(I)V", "fromPreload", "", "getFromPreload", "()Z", "setFromPreload", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "lastRootScrollPy", "getLastRootScrollPy", "setLastRootScrollPy", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getLastSectionDataList", "setLastSectionDataList", "refreshState", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "getRefreshState", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "setRefreshState", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;)V", "getTabType", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public long BgA;
    b.e BgB;
    public boolean BgC;
    public List<? extends bu> Bgw;
    public List<c> Bgx;
    public int Bgy;
    public int Bgz;
    private final int fEH;
    public com.tencent.mm.cd.b lastBuffer;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(282724);
      this.fEH = paramInt;
      this.Bgw = ((List)new LinkedList());
      this.Bgx = ((List)new LinkedList());
      this.BgB = b.e.BgN;
      AppMethodBeat.o(282724);
    }
    
    public final void a(b.e parame)
    {
      AppMethodBeat.i(282723);
      p.k(parame, "<set-?>");
      this.BgB = parame;
      AppMethodBeat.o(282723);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.fEH != paramObject.fEH) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final void fa(List<? extends bu> paramList)
    {
      AppMethodBeat.i(282722);
      p.k(paramList, "<set-?>");
      this.Bgw = paramList;
      AppMethodBeat.o(282722);
    }
    
    public final int hashCode()
    {
      return this.fEH;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(282725);
      String str = "Cache(tabType=" + this.fEH + ")";
      AppMethodBeat.o(282725);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastPreloadTimeStampCache;", "", "liveTabId", "", "(I)V", "lastFindPrefetchTimeStampMs", "", "getLastFindPrefetchTimeStampMs", "()J", "setLastFindPrefetchTimeStampMs", "(J)V", "lastRedDotPrefetchTimeStampMs", "getLastRedDotPrefetchTimeStampMs", "setLastRedDotPrefetchTimeStampMs", "lastTabPagesPrefetchTimeStampMs", "getLastTabPagesPrefetchTimeStampMs", "setLastTabPagesPrefetchTimeStampMs", "getLiveTabId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class c
  {
    public long BgD;
    public long BgE;
    public long BgF;
    private final int BgG;
    
    public c(int paramInt)
    {
      this.BgG = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (this.BgG != paramObject.BgG) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.BgG;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(291647);
      String str = "LastPreloadTimeStampCache(liveTabId=" + this.BgG + ")";
      AppMethodBeat.o(291647);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "", "(Ljava/lang/String;I)V", "Default", "HardRefresh", "Timeout", "InCacheTime", "plugin-finder_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(291164);
      e locale1 = new e("Default", 0);
      BgN = locale1;
      e locale2 = new e("HardRefresh", 1);
      BgO = locale2;
      e locale3 = new e("Timeout", 2);
      BgP = locale3;
      e locale4 = new e("InCacheTime", 3);
      BgQ = locale4;
      BgR = new e[] { locale1, locale2, locale3, locale4 };
      AppMethodBeat.o(291164);
    }
    
    private e() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements a<com.tencent.mm.plugin.finder.extension.reddot.f>
  {
    public static final f BgS;
    
    static
    {
      AppMethodBeat.i(284339);
      BgS = new f();
      AppMethodBeat.o(284339);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.b
 * JD-Core Version:    0.7.0.1
 */