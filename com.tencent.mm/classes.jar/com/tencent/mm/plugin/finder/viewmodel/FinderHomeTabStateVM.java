package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "currentTabType", "getCurrentTabType", "()I", "setCurrentTabType", "(I)V", "isNeedCheckShowCollapsibleTip", "", "isNeedShowDoubleClickTip", "clearTipCache", "", "get", "tabType", "getBusinessInfoKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getLastTabType", "incrementCollapsibleTipCount", "count", "incrementDoubleClickTipCount", "isAutoRefresh", "isShowCollapsibleTip", "isShowDoubleClickTip", "maskCanUpdateExitTime", "onCleared", "resetCache", "store", "lastExitPosition", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "storeLastTabType", "source", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "Cache", "Companion", "LastTabTypeSource", "plugin-finder_release"})
public final class FinderHomeTabStateVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final b Lhd;
  private final ConcurrentHashMap<Integer, a> LgZ;
  public int Lha;
  private boolean Lhb;
  public boolean Lhc;
  
  static
  {
    AppMethodBeat.i(200321);
    Lhd = new b((byte)0);
    AppMethodBeat.o(200321);
  }
  
  public FinderHomeTabStateVM()
  {
    AppMethodBeat.i(200320);
    this.LgZ = new ConcurrentHashMap();
    this.Lhb = true;
    this.Lhc = true;
    AppMethodBeat.o(200320);
  }
  
  public static ae.a ahR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ae.a.LAM;
    case 3: 
      return ae.a.LAN;
    case 1: 
      return ae.a.LAM;
    case 4: 
      return ae.a.LAP;
    }
    return ae.a.LAO;
  }
  
  public static int fXh()
  {
    AppMethodBeat.i(200310);
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    int i = locale.afk().getInt(ae.a.LAL, 1);
    AppMethodBeat.o(200310);
    return i;
  }
  
  public static void fXj()
  {
    AppMethodBeat.i(200317);
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    int i = locale.afk().getInt(ae.a.LAQ, 0);
    locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    locale.afk().set(ae.a.LAQ, Integer.valueOf(i + 1));
    AppMethodBeat.o(200317);
  }
  
  public static void lc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200318);
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    int i = locale.afk().getInt(ahR(paramInt1), 0);
    locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    locale.afk().set(ahR(paramInt1), Integer.valueOf(i + paramInt2));
    AppMethodBeat.o(200318);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<BaseFinderFeed> paramArrayList, ArrayList<v> paramArrayList1)
  {
    AppMethodBeat.i(200306);
    k.h(paramArrayList, "lastDataList");
    k.h(paramArrayList1, "lastSectionDataList");
    ad.i("Finder.TlTabStateVM", "tabType=" + paramInt1 + " lastExitPosition=" + paramInt2 + " lastExitFromTopPx=" + paramInt3 + " lastDataList size=" + paramArrayList.size() + ' ' + "current=" + h.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L));
    Object localObject = ((Iterable)paramArrayList).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BaseFinderFeed)((Iterator)localObject).next()).showLikeTips = false;
    }
    localObject = (Map)this.LgZ;
    a locala = new a(paramInt1);
    locala.Lhf = paramInt2;
    locala.Lhg = paramInt3;
    paramArrayList = (List)paramArrayList;
    k.h(paramArrayList, "<set-?>");
    locala.Lhe = paramArrayList;
    paramArrayList = (a)this.LgZ.get(Integer.valueOf(paramInt1));
    if ((paramArrayList != null) && (paramArrayList.Lhi == true)) {
      locala.Lhh = System.currentTimeMillis();
    }
    paramArrayList = (List)paramArrayList1;
    k.h(paramArrayList, "<set-?>");
    locala.Lhj = paramArrayList;
    locala.Lhi = false;
    ((Map)localObject).put(Integer.valueOf(paramInt1), locala);
    AppMethodBeat.o(200306);
  }
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(200308);
    k.h(paramc, "source");
    ad.i("Finder.TlTabStateVM", "[storeLastTabType] tabType=" + paramInt + " source=" + paramc);
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    locale.afk().set(ae.a.LAL, Integer.valueOf(paramInt));
    if (paramc != c.Lhk) {
      ahO(paramInt).Lhh = 0L;
    }
    AppMethodBeat.o(200308);
  }
  
  public final void ae()
  {
    AppMethodBeat.i(200314);
    super.ae();
    AppMethodBeat.o(200314);
  }
  
  public final void ahM(int paramInt)
  {
    AppMethodBeat.i(200309);
    if (this.LgZ.get(Integer.valueOf(paramInt)) == null) {
      ((Map)this.LgZ).put(Integer.valueOf(paramInt), new a(paramInt));
    }
    a locala = (a)this.LgZ.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.Lhi = true;
      AppMethodBeat.o(200309);
      return;
    }
    AppMethodBeat.o(200309);
  }
  
  public final boolean ahN(int paramInt)
  {
    AppMethodBeat.i(200311);
    long l1 = System.currentTimeMillis();
    long l2 = ahO(paramInt).Lhh;
    Object localObject = b.qJA;
    int i;
    if (l1 - l2 <= b.cqj())
    {
      localObject = (Collection)ahO(paramInt).Lhe;
      if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
        break label113;
      }
      i = 1;
      if (i == 0) {
        break label123;
      }
      localObject = (Collection)ahO(paramInt).Lhj;
      if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
        break label118;
      }
    }
    label113:
    label118:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label123;
      }
      AppMethodBeat.o(200311);
      return true;
      i = 0;
      break;
    }
    label123:
    AppMethodBeat.o(200311);
    return false;
  }
  
  public final a ahO(int paramInt)
  {
    AppMethodBeat.i(200313);
    a locala2 = (a)this.LgZ.get(Integer.valueOf(paramInt));
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a(paramInt);
    }
    AppMethodBeat.o(200313);
    return locala1;
  }
  
  public final boolean ahP(int paramInt)
  {
    AppMethodBeat.i(200316);
    if (!this.Lhb)
    {
      AppMethodBeat.o(200316);
      return false;
    }
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    if (locale.afk().getInt(ahR(paramInt), 0) < 3)
    {
      AppMethodBeat.o(200316);
      return true;
    }
    this.Lhb = false;
    AppMethodBeat.o(200316);
    return false;
  }
  
  public final void fXi()
  {
    AppMethodBeat.i(200315);
    a(1, c.Lhm);
    this.LgZ.clear();
    AppMethodBeat.o(200315);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "", "tabType", "", "(I)V", "canUpdateExitTime", "", "getCanUpdateExitTime", "()Z", "setCanUpdateExitTime", "(Z)V", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getLastSectionDataList", "setLastSectionDataList", "getTabType", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private final int IoU;
    public List<? extends BaseFinderFeed> Lhe;
    public int Lhf;
    public int Lhg;
    long Lhh;
    boolean Lhi;
    public List<v> Lhj;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(200301);
      this.IoU = paramInt;
      this.Lhe = ((List)new LinkedList());
      this.Lhj = ((List)new LinkedList());
      AppMethodBeat.o(200301);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.IoU != paramObject.IoU) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.IoU;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200302);
      String str = "Cache(tabType=" + this.IoU + ")";
      AppMethodBeat.o(200302);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "", "(Ljava/lang/String;I)V", "SOURCE_EXIT", "SOURCE_RED_DOT", "SOURCE_RESET", "plugin-finder_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(200303);
      c localc1 = new c("SOURCE_EXIT", 0);
      Lhk = localc1;
      c localc2 = new c("SOURCE_RED_DOT", 1);
      Lhl = localc2;
      c localc3 = new c("SOURCE_RESET", 2);
      Lhm = localc3;
      Lhn = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(200303);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM
 * JD-Core Version:    0.7.0.1
 */