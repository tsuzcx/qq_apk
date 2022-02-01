package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$Cache;", "isEnableStoreLastTabType", "", "lastPreloadTimeStampCaches", "Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$LastPreloadTimeStampCache;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "redDotManager$delegate", "Lkotlin/Lazy;", "refreshExpired", "getRefreshExpired", "()I", "setRefreshExpired", "(I)V", "squareTabsPreloadResponseCaches", "", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "subTabDataCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$SubTabCache;", "clearSubTabData", "", "genSubTabDataKey", "mainTab", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "subTabInfo", "get", "tabType", "getPreloadSquareTabsCache", "memoryCacheFlag", "getPreloadTimeStampCache", "liveTabId", "getSubTabData", "dataId", "isAutoRefresh", "markUnFocusTabType", "resetCache", "saveSubTabData", "data", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "store", "lastExitPosition", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "fromPreload", "subTabId", "storePreloadSquareTabsCache", "response", "storePreloadTimeStampCache", "lastFindPrefetchTimeStampMs", "", "lastRedDotPrefetchTimeStampMs", "lastTabPagesPrefetchTimeStampMs", "Cache", "Companion", "LastPreloadTimeStampCache", "RefreshState", "SubTabCache", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends com.tencent.mm.ui.component.n<PluginFinder>
{
  public static final b GLE;
  private final j EWh;
  private final ConcurrentHashMap<Integer, a> GKl;
  private final ConcurrentHashMap<Integer, c> GKm;
  public ConcurrentHashMap<String, com.tencent.mm.plugin.findersdk.b.i<p>> GKn;
  private int GKr;
  private boolean GKs;
  public final HashMap<String, n.f> akir;
  
  static
  {
    AppMethodBeat.i(337194);
    GLE = new b((byte)0);
    AppMethodBeat.o(337194);
  }
  
  public n()
  {
    AppMethodBeat.i(337151);
    this.GKl = new ConcurrentHashMap();
    this.GKm = new ConcurrentHashMap();
    this.GKn = new ConcurrentHashMap();
    this.akir = new HashMap();
    d locald = d.FAy;
    this.GKr = ((Number)d.eRD().bmg()).intValue();
    this.EWh = k.cm((a)e.GLQ);
    AppMethodBeat.o(337151);
  }
  
  public static String a(bnn parambnn1, bnn parambnn2)
  {
    AppMethodBeat.i(370293);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambnn1 == null)
    {
      parambnn1 = "";
      localStringBuilder = localStringBuilder.append(parambnn1).append('_');
      if (parambnn2 != null) {
        break label65;
      }
    }
    label65:
    for (parambnn1 = "";; parambnn1 = Integer.valueOf(parambnn2.ZVZ))
    {
      parambnn1 = parambnn1;
      AppMethodBeat.o(370293);
      return parambnn1;
      parambnn1 = Integer.valueOf(parambnn1.ZVZ);
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<cc> paramArrayList, ArrayList<c> paramArrayList1, com.tencent.mm.bx.b paramb, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(337173);
    s.u(paramArrayList, "lastDataList");
    s.u(paramArrayList1, "lastSectionDataList");
    Object localObject1 = d.FAy;
    this.GKr = ((Number)d.eRD().bmg()).intValue();
    localObject1 = d.FAy;
    this.GKs = d.eRN();
    localObject1 = ((Iterable)paramArrayList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cc)((Iterator)localObject1).next();
      if ((localObject2 instanceof BaseFinderFeed)) {
        ((BaseFinderFeed)localObject2).eDg();
      }
    }
    localObject1 = Vb(paramInt1);
    ((a)localObject1).GKx = paramInt2;
    ((a)localObject1).GKy = paramInt3;
    Object localObject2 = (List)paramArrayList;
    s.u(localObject2, "<set-?>");
    ((a)localObject1).GLv = ((List)localObject2);
    localObject2 = (List)paramArrayList1;
    s.u(localObject2, "<set-?>");
    ((a)localObject1).GKw = ((List)localObject2);
    if ((paramArrayList.isEmpty()) && (paramArrayList1.isEmpty())) {}
    for (paramArrayList = d.GLM;; paramArrayList = d.GLL)
    {
      ((a)localObject1).a(paramArrayList);
      ((a)localObject1).lastBuffer = paramb;
      ((a)localObject1).GKC = paramBoolean;
      ((a)localObject1).GLG = paramInt4;
      Log.i("NearbyLivePreloadCacheVM", "[store] tabType=" + paramInt1 + " lastExitPosition=" + paramInt2 + " lastExitFromTopPx=" + paramInt3 + " refreshState=" + ((a)localObject1).GLF + " subTabId:" + paramInt4 + "current=" + f.formatTime("yyyy-MM-dd HH:mm:ss", ((a)localObject1).GKz / 1000L));
      AppMethodBeat.o(337173);
      return;
    }
  }
  
  public final c QY(int paramInt)
  {
    AppMethodBeat.i(337235);
    if (this.GKm.get(Integer.valueOf(paramInt)) == null) {
      ((Map)this.GKm).put(Integer.valueOf(paramInt), new c(paramInt));
    }
    Object localObject = this.GKm.get(Integer.valueOf(paramInt));
    s.checkNotNull(localObject);
    s.s(localObject, "lastPreloadTimeStampCaches[liveTabId]!!");
    localObject = (c)localObject;
    AppMethodBeat.o(337235);
    return localObject;
  }
  
  public final boolean Rp(int paramInt)
  {
    AppMethodBeat.i(337206);
    a locala = Vb(paramInt);
    d locald = locala.GLF;
    Log.i("NearbyLivePreloadCacheVM", "isAutoRefresh " + locald + " tabType: " + paramInt);
    if (locald == d.GLM)
    {
      AppMethodBeat.o(337206);
      return true;
    }
    if ((locald == d.GLL) || (locald == d.GLO))
    {
      if (System.currentTimeMillis() - locala.GKz > this.GKr)
      {
        locala.a(d.GLN);
        AppMethodBeat.o(337206);
        return true;
      }
    }
    else if (locald == d.GLN)
    {
      AppMethodBeat.o(337206);
      return true;
    }
    locala.a(d.GLO);
    AppMethodBeat.o(337206);
    return false;
  }
  
  public final void UT(int paramInt)
  {
    AppMethodBeat.i(337216);
    a locala = Vb(paramInt);
    locala.a(d.GLL);
    locala.GKz = System.currentTimeMillis();
    Log.i("NearbyLivePreloadCacheVM", s.X("[markUnFocusTabType] tabType=", Integer.valueOf(paramInt)));
    AppMethodBeat.o(337216);
  }
  
  public final a Vb(int paramInt)
  {
    AppMethodBeat.i(337226);
    if (this.GKl.get(Integer.valueOf(paramInt)) == null) {
      ((Map)this.GKl).put(Integer.valueOf(paramInt), new a(paramInt));
    }
    Object localObject = this.GKl.get(Integer.valueOf(paramInt));
    s.checkNotNull(localObject);
    s.s(localObject, "caches[tabType]!!");
    localObject = (a)localObject;
    AppMethodBeat.o(337226);
    return localObject;
  }
  
  public final void resetCache()
  {
    AppMethodBeat.i(337245);
    this.GKl.clear();
    this.GKm.clear();
    this.GKn.clear();
    AppMethodBeat.o(337245);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$Cache;", "", "tabType", "", "(I)V", "fromPreload", "", "getFromPreload", "()Z", "setFromPreload", "(Z)V", "isInAppPush", "setInAppPush", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "lastRootScrollPy", "getLastRootScrollPy", "setLastRootScrollPy", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getLastSectionDataList", "setLastSectionDataList", "refreshState", "Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$RefreshState;", "getRefreshState", "()Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$RefreshState;", "setRefreshState", "(Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$RefreshState;)V", "subTabId", "getSubTabId", "setSubTabId", "getTabType", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public boolean GKC;
    List<c> GKw;
    public int GKx;
    public int GKy;
    public long GKz;
    n.d GLF;
    public int GLG;
    public List<? extends cc> GLv;
    private final int hJx;
    public com.tencent.mm.bx.b lastBuffer;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(337114);
      this.hJx = paramInt;
      this.GLv = ((List)new LinkedList());
      this.GKw = ((List)new LinkedList());
      this.GLF = n.d.GLL;
      AppMethodBeat.o(337114);
    }
    
    public final void a(n.d paramd)
    {
      AppMethodBeat.i(337121);
      s.u(paramd, "<set-?>");
      this.GLF = paramd;
      AppMethodBeat.o(337121);
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
      AppMethodBeat.i(337128);
      String str = "Cache(tabType=" + this.hJx + ')';
      AppMethodBeat.o(337128);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$LastPreloadTimeStampCache;", "", "liveTabId", "", "(I)V", "lastFindPrefetchTimeStampMs", "", "getLastFindPrefetchTimeStampMs", "()J", "setLastFindPrefetchTimeStampMs", "(J)V", "lastRedDotPrefetchTimeStampMs", "getLastRedDotPrefetchTimeStampMs", "setLastRedDotPrefetchTimeStampMs", "lastTabPagesPrefetchTimeStampMs", "getLastTabPagesPrefetchTimeStampMs", "setLastTabPagesPrefetchTimeStampMs", "getLiveTabId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    private final int GLH;
    public long GLI;
    public long GLJ;
    public long GLK;
    
    public c(int paramInt)
    {
      this.GLH = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof c)) {
          return false;
        }
        paramObject = (c)paramObject;
      } while (this.GLH == paramObject.GLH);
      return false;
    }
    
    public final int hashCode()
    {
      return this.GLH;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(337119);
      String str = "LastPreloadTimeStampCache(liveTabId=" + this.GLH + ')';
      AppMethodBeat.o(337119);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$RefreshState;", "", "(Ljava/lang/String;I)V", "Default", "HardRefresh", "Timeout", "InCacheTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(337140);
      GLL = new d("Default", 0);
      GLM = new d("HardRefresh", 1);
      GLN = new d("Timeout", 2);
      GLO = new d("InCacheTime", 3);
      GLP = new d[] { GLL, GLM, GLN, GLO };
      AppMethodBeat.o(337140);
    }
    
    private d() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<com.tencent.mm.plugin.finder.extension.reddot.i>
  {
    public static final e GLQ;
    
    static
    {
      AppMethodBeat.i(337099);
      GLQ = new e();
      AppMethodBeat.o(337099);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.n
 * JD-Core Version:    0.7.0.1
 */