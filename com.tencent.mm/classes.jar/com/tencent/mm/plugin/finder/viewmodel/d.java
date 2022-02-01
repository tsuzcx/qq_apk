package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "currentTabType", "getCurrentTabType", "()I", "setCurrentTabType", "(I)V", "isEnableStoreLastTabType", "", "isNeedCheckShowCollapsibleTip", "isNeedShowDoubleClickTip", "lastPreloadTimeStampCaches", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastPreloadTimeStampCache;", "lastTabType", "getLastTabType", "setLastTabType", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "redDotManager$delegate", "Lkotlin/Lazy;", "refreshExpired", "getRefreshExpired", "setRefreshExpired", "sceneState", "Lcom/tencent/mm/protocal/protobuf/FinderStreamSceneStatus;", "getSceneState", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamSceneStatus;", "setSceneState", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamSceneStatus;)V", "squareTabsPreloadResponseCaches", "", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "clearTipCache", "", "get", "tabType", "getBusinessInfoKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getPreloadSquareTabsCache", "memoryCacheFlag", "getPreloadTimeStampCache", "liveTabId", "getTargetEnterTabType", "incrementCollapsibleTipCount", "count", "incrementDoubleClickTipCount", "isAutoRefresh", "isShowCollapsibleTip", "isShowDoubleClickTip", "markFocusTabType", "markUnFocusTabType", "onCleared", "resetCache", "resetRefreshState", "taType", "store", "lastRootScrollPy", "lastExitPosition", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "fromPreload", "storeLastTabType", "source", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "storePreloadSquareTabsCache", "response", "storePreloadTimeStampCache", "lastFindPrefetchTimeStampMs", "", "lastRedDotPrefetchTimeStampMs", "lastTabPagesPrefetchTimeStampMs", "updateRefreshState", "Cache", "Companion", "LastPreloadTimeStampCache", "LastTabTypeSource", "RefreshState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends n<PluginFinder>
{
  public static final b GKk;
  private final j EWh;
  private final ConcurrentHashMap<Integer, a> GKl;
  private final ConcurrentHashMap<Integer, Object> GKm;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.findersdk.b.i<p>> GKn;
  public bwj GKo;
  public int GKp;
  public int GKq;
  private int GKr;
  private boolean GKs;
  private boolean GKt;
  private boolean GKu;
  
  static
  {
    AppMethodBeat.i(337318);
    GKk = new b((byte)0);
    AppMethodBeat.o(337318);
  }
  
  public d()
  {
    AppMethodBeat.i(337250);
    this.GKl = new ConcurrentHashMap();
    this.GKm = new ConcurrentHashMap();
    this.GKn = new ConcurrentHashMap();
    this.GKo = new bwj();
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.GKr = ((Number)com.tencent.mm.plugin.finder.storage.d.eRD().bmg()).intValue();
    this.EWh = k.cm((a)e.GKR);
    this.GKt = true;
    this.GKu = true;
    AppMethodBeat.o(337250);
  }
  
  public static at.a UY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return at.a.adbl;
    case 3: 
      return at.a.adbm;
    case 1: 
      return at.a.adbl;
    case 4: 
      return at.a.adbo;
    }
    return at.a.adbn;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<cc> paramArrayList, ArrayList<c> paramArrayList1)
  {
    AppMethodBeat.i(337273);
    s.u(paramArrayList, "lastDataList");
    s.u(paramArrayList1, "lastSectionDataList");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.GKr = ((Number)com.tencent.mm.plugin.finder.storage.d.eRD().bmg()).intValue();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.GKs = com.tencent.mm.plugin.finder.storage.d.eRN();
    this.GKp = 0;
    localObject1 = ((Iterable)paramArrayList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cc)((Iterator)localObject1).next();
      if ((localObject2 instanceof BaseFinderFeed)) {
        ((BaseFinderFeed)localObject2).eDg();
      }
    }
    localObject1 = UV(paramInt1);
    ((a)localObject1).GKx = paramInt2;
    ((a)localObject1).GKy = paramInt3;
    ((a)localObject1).aE(paramArrayList);
    Object localObject2 = (List)paramArrayList1;
    s.u(localObject2, "<set-?>");
    ((a)localObject1).GKw = ((List)localObject2);
    if ((paramArrayList.isEmpty()) && (paramArrayList1.isEmpty())) {}
    for (paramArrayList = d.GKM;; paramArrayList = d.GKL)
    {
      ((a)localObject1).a(paramArrayList);
      ((a)localObject1).lastBuffer = null;
      ((a)localObject1).GKC = false;
      Log.i("Finder.TlTabStateVM", "[store] tabType=" + paramInt1 + " lastExitPosition=" + paramInt2 + " lastExitFromTopPx=" + paramInt3 + " refreshState=" + ((a)localObject1).GKB + " current=" + com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", ((a)localObject1).GKz / 1000L));
      AppMethodBeat.o(337273);
      return;
    }
  }
  
  public static void fmN()
  {
    AppMethodBeat.i(337287);
    int i = h.baE().ban().getInt(at.a.adbr, 0);
    h.baE().ban().set(at.a.adbr, Integer.valueOf(i + 1));
    AppMethodBeat.o(337287);
  }
  
  private final com.tencent.mm.plugin.finder.extension.reddot.i getRedDotManager()
  {
    AppMethodBeat.i(337260);
    com.tencent.mm.plugin.finder.extension.reddot.i locali = (com.tencent.mm.plugin.finder.extension.reddot.i)this.EWh.getValue();
    AppMethodBeat.o(337260);
    return locali;
  }
  
  public static void iG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(337297);
    int i = h.baE().ban().getInt(UY(paramInt1), 0);
    h.baE().ban().set(UY(paramInt1), Integer.valueOf(i + paramInt2));
    AppMethodBeat.o(337297);
  }
  
  public final boolean Rp(int paramInt)
  {
    AppMethodBeat.i(337334);
    a locala = UV(paramInt);
    d locald = locala.GKB;
    if (locald == d.GKM)
    {
      AppMethodBeat.o(337334);
      return true;
    }
    if ((locald == d.GKL) || (locald == d.GKO))
    {
      if (System.currentTimeMillis() - locala.GKz > this.GKr)
      {
        locala.a(d.GKN);
        AppMethodBeat.o(337334);
        return true;
      }
    }
    else
    {
      if (locald == d.GKP)
      {
        if (System.currentTimeMillis() - locala.GKA > this.GKr)
        {
          locala.a(d.GKN);
          AppMethodBeat.o(337334);
          return true;
        }
        AppMethodBeat.o(337334);
        return false;
      }
      if (locald == d.GKN)
      {
        AppMethodBeat.o(337334);
        return true;
      }
    }
    locala.a(d.GKO);
    AppMethodBeat.o(337334);
    return false;
  }
  
  public final void UT(int paramInt)
  {
    AppMethodBeat.i(337343);
    a locala = UV(paramInt);
    locala.a(d.GKL);
    locala.GKz = System.currentTimeMillis();
    Log.i("Finder.TlTabStateVM", s.X("[markUnFocusTabType] tabType=", Integer.valueOf(paramInt)));
    AppMethodBeat.o(337343);
  }
  
  public final void UU(int paramInt)
  {
    AppMethodBeat.i(337350);
    a locala = UV(paramInt);
    locala.a(d.GKP);
    locala.GKA = System.currentTimeMillis();
    AppMethodBeat.o(337350);
  }
  
  public final a UV(int paramInt)
  {
    AppMethodBeat.i(337366);
    if (this.GKl.get(Integer.valueOf(paramInt)) == null) {
      ((Map)this.GKl).put(Integer.valueOf(paramInt), new a(paramInt));
    }
    Object localObject = this.GKl.get(Integer.valueOf(paramInt));
    s.checkNotNull(localObject);
    s.s(localObject, "caches[tabType]!!");
    localObject = (a)localObject;
    AppMethodBeat.o(337366);
    return localObject;
  }
  
  public final boolean UW(int paramInt)
  {
    AppMethodBeat.i(337384);
    if (!this.GKt)
    {
      AppMethodBeat.o(337384);
      return false;
    }
    if (h.baE().ban().getInt(UY(paramInt), 0) < 3)
    {
      AppMethodBeat.o(337384);
      return true;
    }
    this.GKt = false;
    AppMethodBeat.o(337384);
    return false;
  }
  
  public final void a(int paramInt, d.c paramc)
  {
    AppMethodBeat.i(337324);
    s.u(paramc, "source");
    Log.i("Finder.TlTabStateVM", "[storeLastTabType] tabType=" + paramInt + " source=" + paramc + " isEnableStoreLastTabType=" + this.GKs);
    if (paramc == d.c.GKF)
    {
      h.baE().ban().set(at.a.adbg, Integer.valueOf(paramInt));
      h.baE().ban().set(at.a.adbj, Integer.valueOf(-1));
    }
    AppMethodBeat.o(337324);
  }
  
  public final int fmM()
  {
    int i = 4;
    AppMethodBeat.i(337360);
    int k = h.baE().ban().getInt(at.a.adbg, 4);
    if (this.GKs) {
      i = k;
    }
    boolean bool;
    int j;
    if (getRedDotManager().Su("FinderEntrance") != null)
    {
      bool = true;
      if ((!Rp(k)) && (!bool)) {
        break label215;
      }
      j = getRedDotManager().dZq();
      switch (j)
      {
      }
    }
    for (;;)
    {
      Log.i("Finder.TlTabStateVM", "[getTargetEnterTabType] autoRefresh... ret=" + j + " hasEntranceCtrlInfo=" + bool + " lastExitTabType=" + k + " defaultServerTabType=" + i);
      if ((!Rp(j)) && (getRedDotManager().eFD()))
      {
        a locala = UV(j);
        locala.GKz = -1L;
        locala.a(d.GKM);
      }
      AppMethodBeat.o(337360);
      return j;
      bool = false;
      break;
      j = i;
      continue;
      j = k;
    }
    label215:
    Log.i("Finder.TlTabStateVM", "[getTargetEnterTabType] no autoRefresh... hasEntranceCtrlInfo=false lastExitTabType=" + k + " defaultServerTabType=" + i);
    AppMethodBeat.o(337360);
    return k;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(337371);
    super.onCleared();
    AppMethodBeat.o(337371);
  }
  
  public final void resetCache()
  {
    AppMethodBeat.i(337377);
    a(4, d.c.GKH);
    this.GKl.clear();
    this.GKm.clear();
    this.GKn.clear();
    AppMethodBeat.o(337377);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "", "tabType", "", "(I)V", "fromPreload", "", "getFromPreload", "()Z", "setFromPreload", "(Z)V", "isAtAppPush", "setAtAppPush", "isOuterAppPush", "setOuterAppPush", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getLastDataList", "()Ljava/util/ArrayList;", "setLastDataList", "(Ljava/util/ArrayList;)V", "lastExitFromTopPx", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "value", "", "lastExitTime", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "lastRootScrollPy", "getLastRootScrollPy", "setLastRootScrollPy", "lastSectionDataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getLastSectionDataList", "()Ljava/util/List;", "setLastSectionDataList", "(Ljava/util/List;)V", "lastShareExitTime", "getLastShareExitTime", "setLastShareExitTime", "refreshState", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "getRefreshState", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "setRefreshState", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;)V", "getTabType", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public long GKA;
    d.d GKB;
    boolean GKC;
    public boolean GKD;
    public boolean GKE;
    public ArrayList<cc> GKv;
    public List<c> GKw;
    public int GKx;
    public int GKy;
    public long GKz;
    private final int hJx;
    com.tencent.mm.bx.b lastBuffer;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(337292);
      this.hJx = paramInt;
      this.GKv = new ArrayList();
      this.GKw = ((List)new LinkedList());
      this.GKB = d.d.GKL;
      AppMethodBeat.o(337292);
    }
    
    public final void a(d.d paramd)
    {
      AppMethodBeat.i(337311);
      s.u(paramd, "<set-?>");
      this.GKB = paramd;
      AppMethodBeat.o(337311);
    }
    
    public final void aE(ArrayList<cc> paramArrayList)
    {
      AppMethodBeat.i(337302);
      s.u(paramArrayList, "<set-?>");
      this.GKv = paramArrayList;
      AppMethodBeat.o(337302);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
      } while (this.hJx == paramObject.hJx);
      return false;
    }
    
    public final int hashCode()
    {
      return this.hJx;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(337317);
      String str = "Cache(tabType=" + this.hJx + ')';
      AppMethodBeat.o(337317);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "", "(Ljava/lang/String;I)V", "Default", "HardRefresh", "Timeout", "InCacheTime", "ShareRecommend", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(337323);
      GKL = new d("Default", 0);
      GKM = new d("HardRefresh", 1);
      GKN = new d("Timeout", 2);
      GKO = new d("InCacheTime", 3);
      GKP = new d("ShareRecommend", 4);
      GKQ = new d[] { GKL, GKM, GKN, GKO, GKP };
      AppMethodBeat.o(337323);
    }
    
    private d() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<com.tencent.mm.plugin.finder.extension.reddot.i>
  {
    public static final e GKR;
    
    static
    {
      AppMethodBeat.i(337281);
      GKR = new e();
      AppMethodBeat.o(337281);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.d
 * JD-Core Version:    0.7.0.1
 */