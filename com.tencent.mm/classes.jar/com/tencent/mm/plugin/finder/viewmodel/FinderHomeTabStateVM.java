package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "currentTabType", "getCurrentTabType", "()I", "setCurrentTabType", "(I)V", "isEnableStoreLastTabType", "", "isNeedCheckShowCollapsibleTip", "isNeedShowDoubleClickTip", "refreshExpired", "clearTipCache", "", "get", "tabType", "getBusinessInfoKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getTargetEnterTabType", "incrementCollapsibleTipCount", "count", "incrementDoubleClickTipCount", "isAutoRefresh", "isShowCollapsibleTip", "isShowDoubleClickTip", "markFocusTabType", "markUnFocusTabType", "onCleared", "resetCache", "store", "lastExitPosition", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "storeLastTabType", "source", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "Cache", "Companion", "LastTabTypeSource", "RefreshState", "plugin-finder_release"})
public final class FinderHomeTabStateVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final FinderHomeTabStateVM.b tkz;
  public final ConcurrentHashMap<Integer, a> tkt;
  public int tku;
  private int tkv;
  private boolean tkw;
  private boolean tkx;
  public boolean tky;
  
  static
  {
    AppMethodBeat.i(206058);
    tkz = new FinderHomeTabStateVM.b((byte)0);
    AppMethodBeat.o(206058);
  }
  
  public FinderHomeTabStateVM()
  {
    AppMethodBeat.i(206057);
    this.tkt = new ConcurrentHashMap();
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.tkv = ((Number)com.tencent.mm.plugin.finder.storage.b.cIq().value()).intValue();
    localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.tkw = com.tencent.mm.plugin.finder.storage.b.cID();
    this.tkx = true;
    this.tky = true;
    AppMethodBeat.o(206057);
  }
  
  public static am.a GK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return am.a.Jbs;
    case 3: 
      return am.a.Jbt;
    case 1: 
      return am.a.Jbs;
    case 4: 
      return am.a.Jbv;
    }
    return am.a.Jbu;
  }
  
  public static void cQP()
  {
    AppMethodBeat.i(206054);
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.Jbw, 0);
    locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.Jbw, Integer.valueOf(i + 1));
    AppMethodBeat.o(206054);
  }
  
  public static void fY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206055);
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(GK(paramInt1), 0);
    locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(GK(paramInt1), Integer.valueOf(i + paramInt2));
    AppMethodBeat.o(206055);
  }
  
  public final boolean EX(int paramInt)
  {
    AppMethodBeat.i(206047);
    a locala = GH(paramInt);
    d locald = locala.tkF;
    if (locald == d.tkN)
    {
      AppMethodBeat.o(206047);
      return true;
    }
    if ((locald == d.tkM) || (locald == d.tkP))
    {
      if (System.currentTimeMillis() - locala.tkE > this.tkv)
      {
        locala.a(d.tkO);
        AppMethodBeat.o(206047);
        return true;
      }
    }
    else if (locald == d.tkO)
    {
      AppMethodBeat.o(206047);
      return true;
    }
    locala.a(d.tkP);
    AppMethodBeat.o(206047);
    return false;
  }
  
  public final void GG(int paramInt)
  {
    AppMethodBeat.i(206049);
    a locala = GH(paramInt);
    locala.a(d.tkM);
    locala.tkE = System.currentTimeMillis();
    ae.i("Finder.TlTabStateVM", "[markUnFocusTabType] tabType=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(206049);
  }
  
  public final a GH(int paramInt)
  {
    AppMethodBeat.i(206051);
    if (this.tkt.get(Integer.valueOf(paramInt)) == null) {
      ((Map)this.tkt).put(Integer.valueOf(paramInt), new a(paramInt));
    }
    Object localObject = this.tkt.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      p.gkB();
    }
    localObject = (a)localObject;
    AppMethodBeat.o(206051);
    return localObject;
  }
  
  public final boolean GI(int paramInt)
  {
    AppMethodBeat.i(206053);
    if (!this.tkx)
    {
      AppMethodBeat.o(206053);
      return false;
    }
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    if (locale.ajA().getInt(GK(paramInt), 0) < 3)
    {
      AppMethodBeat.o(206053);
      return true;
    }
    this.tkx = false;
    AppMethodBeat.o(206053);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<am> paramArrayList, ArrayList<c> paramArrayList1)
  {
    AppMethodBeat.i(206043);
    p.h(paramArrayList, "lastDataList");
    p.h(paramArrayList1, "lastSectionDataList");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.tkv = ((Number)com.tencent.mm.plugin.finder.storage.b.cIq().value()).intValue();
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.tkw = com.tencent.mm.plugin.finder.storage.b.cID();
    this.tku = 0;
    localObject1 = ((Iterable)paramArrayList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (am)((Iterator)localObject1).next();
      if ((localObject2 instanceof BaseFinderFeed)) {
        ((BaseFinderFeed)localObject2).cEu();
      }
    }
    localObject1 = GH(paramInt1);
    ((a)localObject1).tkC = paramInt2;
    ((a)localObject1).tkD = paramInt3;
    ((a)localObject1).dR((List)paramArrayList);
    Object localObject2 = (List)paramArrayList1;
    p.h(localObject2, "<set-?>");
    ((a)localObject1).tkB = ((List)localObject2);
    if ((paramArrayList.isEmpty()) && (paramArrayList1.isEmpty())) {}
    for (paramArrayList = d.tkN;; paramArrayList = d.tkM)
    {
      ((a)localObject1).a(paramArrayList);
      ae.i("Finder.TlTabStateVM", "[store] tabType=" + paramInt1 + " lastExitPosition=" + paramInt2 + " lastExitFromTopPx=" + paramInt3 + " refreshState=" + ((a)localObject1).tkF + ' ' + "current=" + i.formatTime("yyyy-MM-dd HH:mm:ss", ((a)localObject1).tkE / 1000L));
      AppMethodBeat.o(206043);
      return;
    }
  }
  
  public final void a(int paramInt, FinderHomeTabStateVM.c paramc)
  {
    AppMethodBeat.i(206046);
    p.h(paramc, "source");
    ae.i("Finder.TlTabStateVM", "[storeLastTabType] tabType=" + paramInt + " source=" + paramc + " isEnableStoreLastTabType=" + this.tkw);
    if (paramc == FinderHomeTabStateVM.c.tkG)
    {
      paramc = g.ajR();
      p.g(paramc, "MMKernel.storage()");
      paramc.ajA().set(am.a.Jbq, Integer.valueOf(paramInt));
      paramc = g.ajR();
      p.g(paramc, "MMKernel.storage()");
      paramc.ajA().set(am.a.Jbr, Integer.valueOf(-1));
    }
    AppMethodBeat.o(206046);
  }
  
  public final void af()
  {
    AppMethodBeat.i(206052);
    super.af();
    AppMethodBeat.o(206052);
  }
  
  public final int cQO()
  {
    AppMethodBeat.i(206050);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.Jbq, 4);
    if (this.tkw) {}
    for (int i = k; EX(k); i = 4)
    {
      localObject = g.ad(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      int m = ((PluginFinder)localObject).getRedDotManager().cBt();
      int j = m;
      if (m == -1) {
        j = i;
      }
      ae.i("Finder.TlTabStateVM", "[getLastTabType] autoRefresh... ret=" + j + " lastRedType=-1 lastExitTabType=" + k + " defaultServerTabType=" + i);
      AppMethodBeat.o(206050);
      return j;
    }
    ae.i("Finder.TlTabStateVM", "[getLastTabType] no autoRefresh... lastExitTabType=".concat(String.valueOf(k)));
    AppMethodBeat.o(206050);
    return k;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getLastSectionDataList", "setLastSectionDataList", "refreshState", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "getRefreshState", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "setRefreshState", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;)V", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private final int dvm;
    public List<? extends am> tkA;
    public List<c> tkB;
    public int tkC;
    public int tkD;
    public long tkE;
    FinderHomeTabStateVM.d tkF;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(206035);
      this.dvm = paramInt;
      this.tkA = ((List)new LinkedList());
      this.tkB = ((List)new LinkedList());
      this.tkF = FinderHomeTabStateVM.d.tkN;
      AppMethodBeat.o(206035);
    }
    
    public final void a(FinderHomeTabStateVM.d paramd)
    {
      AppMethodBeat.i(206034);
      p.h(paramd, "<set-?>");
      this.tkF = paramd;
      AppMethodBeat.o(206034);
    }
    
    public final void dR(List<? extends am> paramList)
    {
      AppMethodBeat.i(206033);
      p.h(paramList, "<set-?>");
      this.tkA = paramList;
      AppMethodBeat.o(206033);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.dvm != paramObject.dvm) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.dvm;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206036);
      String str = "Cache(tabType=" + this.dvm + ")";
      AppMethodBeat.o(206036);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "", "(Ljava/lang/String;I)V", "Default", "HardRefresh", "Timeout", "InCacheTime", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(206040);
      d locald1 = new d("Default", 0);
      tkM = locald1;
      d locald2 = new d("HardRefresh", 1);
      tkN = locald2;
      d locald3 = new d("Timeout", 2);
      tkO = locald3;
      d locald4 = new d("InCacheTime", 3);
      tkP = locald4;
      tkQ = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(206040);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM
 * JD-Core Version:    0.7.0.1
 */