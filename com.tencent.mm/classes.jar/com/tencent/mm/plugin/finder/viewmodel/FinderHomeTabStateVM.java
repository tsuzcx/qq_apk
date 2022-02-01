package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "currentTabType", "getCurrentTabType", "()I", "setCurrentTabType", "(I)V", "isNeedCheckShowCollapsibleTip", "", "isNeedShowDoubleClickTip", "clearTipCache", "", "get", "tabType", "getBusinessInfoKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getLastTabType", "incrementCollapsibleTipCount", "count", "incrementDoubleClickTipCount", "isAutoRefresh", "isShowCollapsibleTip", "isShowDoubleClickTip", "markFocusTabType", "markUnFocusTabType", "onCleared", "resetCache", "store", "lastExitPosition", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "storeLastTabType", "source", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "Cache", "Companion", "LastTabTypeSource", "RefreshState", "plugin-finder_release"})
public final class FinderHomeTabStateVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final FinderHomeTabStateVM.b sbT;
  private final ConcurrentHashMap<Integer, a> sbP;
  public int sbQ;
  private boolean sbR;
  public boolean sbS;
  
  static
  {
    AppMethodBeat.i(204395);
    sbT = new FinderHomeTabStateVM.b((byte)0);
    AppMethodBeat.o(204395);
  }
  
  public FinderHomeTabStateVM()
  {
    AppMethodBeat.i(204394);
    this.sbP = new ConcurrentHashMap();
    this.sbR = true;
    this.sbS = true;
    AppMethodBeat.o(204394);
  }
  
  public static ah.a EX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ah.a.GUl;
    case 3: 
      return ah.a.GUm;
    case 1: 
      return ah.a.GUl;
    case 4: 
      return ah.a.GUo;
    }
    return ah.a.GUn;
  }
  
  public static void a(int paramInt, FinderHomeTabStateVM.c paramc)
  {
    AppMethodBeat.i(204382);
    k.h(paramc, "source");
    StringBuilder localStringBuilder = new StringBuilder("[storeLastTabType] tabType=").append(paramInt).append(" source=").append(paramc).append(" isEnableStoreLastTabType=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    ac.i("Finder.TlTabStateVM", com.tencent.mm.plugin.finder.storage.b.cAm());
    if (paramc == FinderHomeTabStateVM.c.scb)
    {
      paramc = g.agR();
      k.g(paramc, "MMKernel.storage()");
      paramc.agA().set(ah.a.GUk, Integer.valueOf(paramInt));
      AppMethodBeat.o(204382);
      return;
    }
    if (paramc == FinderHomeTabStateVM.c.sca)
    {
      paramc = g.agR();
      k.g(paramc, "MMKernel.storage()");
      paramc.agA().set(ah.a.GUj, Integer.valueOf(paramInt));
      paramc = g.agR();
      k.g(paramc, "MMKernel.storage()");
      paramc.agA().set(ah.a.GUk, Integer.valueOf(-1));
    }
    AppMethodBeat.o(204382);
  }
  
  public static void cFL()
  {
    AppMethodBeat.i(204391);
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    int i = locale.agA().getInt(ah.a.GUp, 0);
    locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GUp, Integer.valueOf(i + 1));
    AppMethodBeat.o(204391);
  }
  
  public static void fK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204392);
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    int i = locale.agA().getInt(EX(paramInt1), 0);
    locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    locale.agA().set(EX(paramInt1), Integer.valueOf(i + paramInt2));
    AppMethodBeat.o(204392);
  }
  
  public final boolean ES(int paramInt)
  {
    AppMethodBeat.i(204383);
    a locala = EU(paramInt);
    Object localObject = locala.sbZ;
    if (localObject == d.scg)
    {
      AppMethodBeat.o(204383);
      return true;
    }
    if ((localObject == d.scf) || (localObject == d.sci))
    {
      long l1 = System.currentTimeMillis();
      long l2 = locala.sbY;
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (l1 - l2 > com.tencent.mm.plugin.finder.storage.b.czK())
      {
        locala.a(d.sch);
        AppMethodBeat.o(204383);
        return true;
      }
    }
    else if (localObject == d.sch)
    {
      AppMethodBeat.o(204383);
      return true;
    }
    locala.a(d.sci);
    AppMethodBeat.o(204383);
    return false;
  }
  
  public final void ET(int paramInt)
  {
    AppMethodBeat.i(204385);
    a locala = EU(paramInt);
    locala.a(d.scf);
    locala.sbY = System.currentTimeMillis();
    ac.i("Finder.TlTabStateVM", "[markUnFocusTabType] tabType=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(204385);
  }
  
  public final a EU(int paramInt)
  {
    AppMethodBeat.i(204387);
    if (this.sbP.get(Integer.valueOf(paramInt)) == null) {
      ((Map)this.sbP).put(Integer.valueOf(paramInt), new a(paramInt));
    }
    Object localObject = this.sbP.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      k.fOy();
    }
    localObject = (a)localObject;
    AppMethodBeat.o(204387);
    return localObject;
  }
  
  public final boolean EV(int paramInt)
  {
    AppMethodBeat.i(204390);
    if (!this.sbR)
    {
      AppMethodBeat.o(204390);
      return false;
    }
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    if (locale.agA().getInt(EX(paramInt), 0) < 3)
    {
      AppMethodBeat.o(204390);
      return true;
    }
    this.sbR = false;
    AppMethodBeat.o(204390);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<BaseFinderFeed> paramArrayList, ArrayList<com.tencent.mm.plugin.finder.model.b> paramArrayList1)
  {
    AppMethodBeat.i(204380);
    k.h(paramArrayList, "lastDataList");
    k.h(paramArrayList1, "lastSectionDataList");
    a locala = EU(paramInt1);
    locala.sbW = paramInt2;
    locala.sbX = paramInt3;
    List localList = (List)paramArrayList;
    k.h(localList, "<set-?>");
    locala.sbU = localList;
    localList = (List)paramArrayList1;
    k.h(localList, "<set-?>");
    locala.sbV = localList;
    if ((paramArrayList.isEmpty()) && (paramArrayList1.isEmpty())) {}
    for (paramArrayList = d.scg;; paramArrayList = d.scf)
    {
      locala.a(paramArrayList);
      ac.i("Finder.TlTabStateVM", "[store] tabType=" + paramInt1 + " lastExitPosition=" + paramInt2 + " lastExitFromTopPx=" + paramInt3 + " refreshState=" + locala.sbZ + "current=" + h.formatTime("yyyy-MM-dd HH:mm:ss", locala.sbY / 1000L));
      AppMethodBeat.o(204380);
      return;
    }
  }
  
  public final void ae()
  {
    AppMethodBeat.i(204388);
    super.ae();
    AppMethodBeat.o(204388);
  }
  
  public final int cFJ()
  {
    int i = 4;
    AppMethodBeat.i(204386);
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    int k = ((e)localObject).agA().getInt(ah.a.GUj, 4);
    localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.cAm()) {
      i = k;
    }
    if (ES(k))
    {
      localObject = g.agR();
      k.g(localObject, "MMKernel.storage()");
      int m = ((e)localObject).agA().getInt(ah.a.GUk, -1);
      if (m == -1) {}
      for (int j = i;; j = m)
      {
        ac.i("Finder.TlTabStateVM", "[getLastTabType] autoRefresh... ret=" + j + " lastRedType=" + m + " lastExitTabType=" + k + " defaultServerTabType=" + i);
        AppMethodBeat.o(204386);
        return j;
      }
    }
    ac.i("Finder.TlTabStateVM", "[getLastTabType] no autoRefresh... lastExitTabType=".concat(String.valueOf(k)));
    AppMethodBeat.o(204386);
    return k;
  }
  
  public final void cFK()
  {
    AppMethodBeat.i(204389);
    a(4, FinderHomeTabStateVM.c.scc);
    this.sbP.clear();
    AppMethodBeat.o(204389);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getLastSectionDataList", "setLastSectionDataList", "refreshState", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "getRefreshState", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "setRefreshState", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;)V", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private final int diw;
    public List<? extends BaseFinderFeed> sbU;
    public List<com.tencent.mm.plugin.finder.model.b> sbV;
    public int sbW;
    public int sbX;
    long sbY;
    FinderHomeTabStateVM.d sbZ;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(204372);
      this.diw = paramInt;
      this.sbU = ((List)new LinkedList());
      this.sbV = ((List)new LinkedList());
      this.sbZ = FinderHomeTabStateVM.d.scg;
      AppMethodBeat.o(204372);
    }
    
    public final void a(FinderHomeTabStateVM.d paramd)
    {
      AppMethodBeat.i(204371);
      k.h(paramd, "<set-?>");
      this.sbZ = paramd;
      AppMethodBeat.o(204371);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.diw != paramObject.diw) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.diw;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204373);
      String str = "Cache(tabType=" + this.diw + ")";
      AppMethodBeat.o(204373);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "", "(Ljava/lang/String;I)V", "Default", "HardRefresh", "Timeout", "InCacheTime", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(204377);
      d locald1 = new d("Default", 0);
      scf = locald1;
      d locald2 = new d("HardRefresh", 1);
      scg = locald2;
      d locald3 = new d("Timeout", 2);
      sch = locald3;
      d locald4 = new d("InCacheTime", 3);
      sci = locald4;
      scj = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(204377);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM
 * JD-Core Version:    0.7.0.1
 */