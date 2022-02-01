package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "currentTabType", "getCurrentTabType", "()I", "setCurrentTabType", "(I)V", "isEnableStoreLastTabType", "", "isNeedCheckShowCollapsibleTip", "isNeedShowDoubleClickTip", "refreshExpired", "getRefreshExpired", "setRefreshExpired", "clearTipCache", "", "get", "tabType", "getBusinessInfoKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getTargetEnterTabType", "incrementCollapsibleTipCount", "count", "incrementDoubleClickTipCount", "isAutoRefresh", "isShowCollapsibleTip", "isShowDoubleClickTip", "markFocusTabType", "markUnFocusTabType", "onCleared", "resetCache", "store", "lastRootScrollPy", "lastExitPosition", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "storeLastTabType", "source", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "Cache", "Companion", "LastTabTypeSource", "RefreshState", "plugin-finder_release"})
public final class FinderHomeTabStateVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final b wub;
  private final ConcurrentHashMap<Integer, a> wtV;
  public int wtW;
  public int wtX;
  private boolean wtY;
  private boolean wtZ;
  private boolean wua;
  
  static
  {
    AppMethodBeat.i(255357);
    wub = new b((byte)0);
    AppMethodBeat.o(255357);
  }
  
  public FinderHomeTabStateVM()
  {
    AppMethodBeat.i(255356);
    this.wtV = new ConcurrentHashMap();
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.wtX = ((Number)com.tencent.mm.plugin.finder.storage.c.dsa().value()).intValue();
    localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.wtY = com.tencent.mm.plugin.finder.storage.c.dsj();
    this.wtZ = true;
    this.wua = true;
    AppMethodBeat.o(255356);
  }
  
  public static ar.a Mt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ar.a.Okr;
    case 3: 
      return ar.a.Oks;
    case 1: 
      return ar.a.Okr;
    case 4: 
      return ar.a.Oku;
    }
    return ar.a.Okt;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<bo> paramArrayList, ArrayList<com.tencent.mm.plugin.finder.model.c> paramArrayList1)
  {
    AppMethodBeat.i(255341);
    p.h(paramArrayList, "lastDataList");
    p.h(paramArrayList1, "lastSectionDataList");
    Mq(paramInt1).wue = paramInt2;
    a(paramInt1, paramInt3, paramInt4, paramArrayList, paramArrayList1);
    AppMethodBeat.o(255341);
  }
  
  public static void dHS()
  {
    AppMethodBeat.i(255353);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.Okv, 0);
    locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Okv, Integer.valueOf(i + 1));
    AppMethodBeat.o(255353);
  }
  
  public static void gu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255354);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(Mt(paramInt1), 0);
    locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(Mt(paramInt1), Integer.valueOf(i + paramInt2));
    AppMethodBeat.o(255354);
  }
  
  public final boolean JN(int paramInt)
  {
    AppMethodBeat.i(255346);
    a locala = Mq(paramInt);
    d locald = locala.wui;
    if (locald == d.wuq)
    {
      AppMethodBeat.o(255346);
      return true;
    }
    if ((locald == d.wup) || (locald == d.wus))
    {
      if (System.currentTimeMillis() - locala.wuh > this.wtX)
      {
        locala.a(d.wur);
        AppMethodBeat.o(255346);
        return true;
      }
    }
    else if (locald == d.wur)
    {
      AppMethodBeat.o(255346);
      return true;
    }
    locala.a(d.wus);
    AppMethodBeat.o(255346);
    return false;
  }
  
  public final void Mp(int paramInt)
  {
    AppMethodBeat.i(255347);
    a locala = Mq(paramInt);
    locala.a(d.wup);
    locala.wuh = System.currentTimeMillis();
    Log.i("Finder.TlTabStateVM", "[markUnFocusTabType] tabType=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(255347);
  }
  
  public final a Mq(int paramInt)
  {
    AppMethodBeat.i(255349);
    if (this.wtV.get(Integer.valueOf(paramInt)) == null) {
      ((Map)this.wtV).put(Integer.valueOf(paramInt), new a(paramInt));
    }
    Object localObject = this.wtV.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      p.hyc();
    }
    localObject = (a)localObject;
    AppMethodBeat.o(255349);
    return localObject;
  }
  
  public final boolean Mr(int paramInt)
  {
    AppMethodBeat.i(255352);
    if (!this.wtZ)
    {
      AppMethodBeat.o(255352);
      return false;
    }
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    if (locale.azQ().getInt(Mt(paramInt), 0) < 3)
    {
      AppMethodBeat.o(255352);
      return true;
    }
    this.wtZ = false;
    AppMethodBeat.o(255352);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<bo> paramArrayList, ArrayList<com.tencent.mm.plugin.finder.model.c> paramArrayList1)
  {
    AppMethodBeat.i(255343);
    p.h(paramArrayList, "lastDataList");
    p.h(paramArrayList1, "lastSectionDataList");
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.wtX = ((Number)com.tencent.mm.plugin.finder.storage.c.dsa().value()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.wtY = com.tencent.mm.plugin.finder.storage.c.dsj();
    this.wtW = 0;
    localObject = ((Iterable)paramArrayList).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bo localbo = (bo)((Iterator)localObject).next();
      if ((localbo instanceof BaseFinderFeed)) {
        ((BaseFinderFeed)localbo).dku();
      }
    }
    localObject = Mq(paramInt1);
    ((a)localObject).wuf = paramInt2;
    ((a)localObject).wug = paramInt3;
    ((a)localObject).eF((List)paramArrayList);
    ((a)localObject).eG((List)paramArrayList1);
    if ((paramArrayList.isEmpty()) && (paramArrayList1.isEmpty())) {}
    for (paramArrayList = d.wuq;; paramArrayList = d.wup)
    {
      ((a)localObject).a(paramArrayList);
      Log.i("Finder.TlTabStateVM", "[store] tabType=" + paramInt1 + " lastExitPosition=" + paramInt2 + " lastExitFromTopPx=" + paramInt3 + " refreshState=" + ((a)localObject).wui + ' ' + "current=" + com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", ((a)localObject).wuh / 1000L));
      AppMethodBeat.o(255343);
      return;
    }
  }
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(255345);
    p.h(paramc, "source");
    Log.i("Finder.TlTabStateVM", "[storeLastTabType] tabType=" + paramInt + " source=" + paramc + " isEnableStoreLastTabType=" + this.wtY);
    if (paramc == c.wuj)
    {
      paramc = g.aAh();
      p.g(paramc, "MMKernel.storage()");
      paramc.azQ().set(ar.a.Oko, Integer.valueOf(paramInt));
      paramc = g.aAh();
      p.g(paramc, "MMKernel.storage()");
      paramc.azQ().set(ar.a.Okq, Integer.valueOf(-1));
    }
    AppMethodBeat.o(255345);
  }
  
  public final int dHR()
  {
    AppMethodBeat.i(255348);
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    int k = ((e)localObject).azQ().getInt(ar.a.Oko, 4);
    if (this.wtY) {}
    for (int i = k; JN(k); i = 4)
    {
      localObject = g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      int m = ((PluginFinder)localObject).getRedDotManager().daF();
      int j = m;
      if (m == -1) {
        j = i;
      }
      Log.i("Finder.TlTabStateVM", "[getLastTabType] autoRefresh... ret=" + j + " lastRedType=-1 lastExitTabType=" + k + " defaultServerTabType=" + i);
      AppMethodBeat.o(255348);
      return j;
    }
    Log.i("Finder.TlTabStateVM", "[getLastTabType] no autoRefresh... lastExitTabType=".concat(String.valueOf(k)));
    AppMethodBeat.o(255348);
    return k;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(255350);
    super.onCleared();
    AppMethodBeat.o(255350);
  }
  
  public final void resetCache()
  {
    AppMethodBeat.i(255351);
    a(4, c.wul);
    this.wtV.clear();
    AppMethodBeat.o(255351);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "lastRootScrollPy", "getLastRootScrollPy", "setLastRootScrollPy", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getLastSectionDataList", "setLastSectionDataList", "refreshState", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "getRefreshState", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "setRefreshState", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;)V", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private final int dLS;
    public List<? extends bo> wuc;
    public List<com.tencent.mm.plugin.finder.model.c> wud;
    public int wue;
    public int wuf;
    public int wug;
    public long wuh;
    FinderHomeTabStateVM.d wui;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(255333);
      this.dLS = paramInt;
      this.wuc = ((List)new LinkedList());
      this.wud = ((List)new LinkedList());
      this.wui = FinderHomeTabStateVM.d.wup;
      AppMethodBeat.o(255333);
    }
    
    public final void a(FinderHomeTabStateVM.d paramd)
    {
      AppMethodBeat.i(255332);
      p.h(paramd, "<set-?>");
      this.wui = paramd;
      AppMethodBeat.o(255332);
    }
    
    public final void eF(List<? extends bo> paramList)
    {
      AppMethodBeat.i(255330);
      p.h(paramList, "<set-?>");
      this.wuc = paramList;
      AppMethodBeat.o(255330);
    }
    
    public final void eG(List<com.tencent.mm.plugin.finder.model.c> paramList)
    {
      AppMethodBeat.i(255331);
      p.h(paramList, "<set-?>");
      this.wud = paramList;
      AppMethodBeat.o(255331);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.dLS != paramObject.dLS) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.dLS;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(255334);
      String str = "Cache(tabType=" + this.dLS + ")";
      AppMethodBeat.o(255334);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "", "(Ljava/lang/String;I)V", "SOURCE_EXIT", "SOURCE_RED_DOT", "SOURCE_RESET", "SOURCE_MULTI_TAB_NEW", "SOURCE_RED_DOT_REVOKE", "plugin-finder_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(255335);
      c localc1 = new c("SOURCE_EXIT", 0);
      wuj = localc1;
      c localc2 = new c("SOURCE_RED_DOT", 1);
      wuk = localc2;
      c localc3 = new c("SOURCE_RESET", 2);
      wul = localc3;
      c localc4 = new c("SOURCE_MULTI_TAB_NEW", 3);
      wum = localc4;
      c localc5 = new c("SOURCE_RED_DOT_REVOKE", 4);
      wun = localc5;
      wuo = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(255335);
    }
    
    private c() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "", "(Ljava/lang/String;I)V", "Default", "HardRefresh", "Timeout", "InCacheTime", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(255338);
      d locald1 = new d("Default", 0);
      wup = locald1;
      d locald2 = new d("HardRefresh", 1);
      wuq = locald2;
      d locald3 = new d("Timeout", 2);
      wur = locald3;
      d locald4 = new d("InCacheTime", 3);
      wus = locald4;
      wut = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(255338);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM
 * JD-Core Version:    0.7.0.1
 */