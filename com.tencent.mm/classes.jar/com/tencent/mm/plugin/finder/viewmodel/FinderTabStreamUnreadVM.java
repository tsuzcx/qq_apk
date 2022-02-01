package com.tencent.mm.plugin.finder.viewmodel;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "followCollector", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "friendCollector", "machineCollector", "collectDeprecatedFeeds", "", "tabType", "", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "collectReadFeeds", "commentScene", "readList", "isGlobalRead", "", "feedId", "", "isRead", "Companion", "TabStreamCollector", "plugin-finder_release"})
public final class FinderTabStreamUnreadVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final a wuN;
  public final b wuK;
  public final b wuL;
  public final b wuM;
  
  static
  {
    AppMethodBeat.i(255383);
    wuN = new a((byte)0);
    AppMethodBeat.o(255383);
  }
  
  public FinderTabStreamUnreadVM()
  {
    AppMethodBeat.i(255382);
    this.wuK = new b(1);
    this.wuL = new b(3);
    this.wuM = new b(4);
    AppMethodBeat.o(255382);
  }
  
  public final void o(int paramInt, List<? extends bo> paramList)
  {
    AppMethodBeat.i(255381);
    if (paramList == null)
    {
      AppMethodBeat.o(255381);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[collectReadFeeds] commentScene=").append(paramInt).append(" readList=").append(paramList.size()).append(" first=");
    bo localbo = (bo)j.kt(paramList);
    long l;
    if (localbo != null)
    {
      l = localbo.lT();
      Log.i("Finder.TabStreamUnreadVM", d.zs(l));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(255381);
      return;
      l = 0L;
      break;
      this.wuL.eI(paramList).aWm();
      AppMethodBeat.o(255381);
      return;
      this.wuK.eI(paramList).aWm();
      AppMethodBeat.o(255381);
      return;
      this.wuM.eI(paramList).aWm();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "", "tabType", "", "(I)V", "deprecatedCollection", "Landroid/util/LongSparseArray;", "", "lock", "getLock", "()Ljava/lang/Object;", "readCollection", "checkReport", "", "collectDeprecated", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "collectRead", "readList", "component1", "copy", "equals", "", "other", "hashCode", "isRead", "feedId", "", "printSparseArray", "list", "toString", "plugin-finder_release"})
  public static final class b
  {
    final int dLS;
    private final Object lock;
    final LongSparseArray<String> wuO;
    private final LongSparseArray<String> wuP;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(255379);
      this.dLS = paramInt;
      this.wuO = new LongSparseArray();
      this.wuP = new LongSparseArray();
      this.lock = new Object();
      AppMethodBeat.o(255379);
    }
    
    public final boolean Gz(long paramLong)
    {
      AppMethodBeat.i(255376);
      if (this.wuO.indexOfKey(paramLong) >= 0)
      {
        AppMethodBeat.o(255376);
        return true;
      }
      AppMethodBeat.o(255376);
      return false;
    }
    
    public final void aWm()
    {
      AppMethodBeat.i(255378);
      final LinkedList localLinkedList = new LinkedList();
      final bbn localbbn = new bbn();
      ??? = k.vfA;
      localbbn.tCE = k.Kw(this.dLS);
      Object localObject3;
      for (;;)
      {
        synchronized (this.lock)
        {
          d.b(d.a(this.wuP, (m)new a(this, localLinkedList, localbbn)), (m)new b(this, localLinkedList, localbbn));
          if (this.wuP.size() > 0) {
            this.wuP.clear();
          }
          localObject3 = x.SXb;
          if (!((Collection)localLinkedList).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label270;
            }
            ??? = new StringBuilder("[checkReport] tabType=").append(this.dLS).append(", begin to report unread... ");
            Object localObject4 = (Iterable)localLinkedList;
            localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
            localObject4 = ((Iterable)localObject4).iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            ((Collection)localObject3).add(d.zs(((bdv)((Iterator)localObject4).next()).hFK));
          }
        }
        int i = 0;
      }
      Log.i("Finder.TabStreamUnreadVM", (List)localObject3);
      new a((List)localObject1, localbbn).aYI();
      label270:
      AppMethodBeat.o(255378);
    }
    
    public final b eI(List<? extends bo> paramList)
    {
      AppMethodBeat.i(255377);
      p.h(paramList, "readList");
      for (;;)
      {
        synchronized (this.lock)
        {
          Iterator localIterator = ((Iterable)paramList).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = (bo)localIterator.next();
          if (this.wuO.indexOfKey(paramList.lT()) >= 0) {
            continue;
          }
          LongSparseArray localLongSparseArray = this.wuO;
          long l = paramList.lT();
          if ((paramList instanceof BaseFinderFeed))
          {
            paramList = ((BaseFinderFeed)paramList).feedObject.getObjectNonceId();
            localLongSparseArray.append(l, paramList);
          }
        }
        paramList = "";
      }
      paramList = x.SXb;
      AppMethodBeat.o(255377);
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
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
      AppMethodBeat.i(255380);
      String str = "TabStreamCollector(tabType=" + this.dLS + ")";
      AppMethodBeat.o(255380);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "feedId", "", "<anonymous parameter 1>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$1"})
    static final class a
      extends q
      implements m<Long, String, Boolean>
    {
      a(FinderTabStreamUnreadVM.b paramb, LinkedList paramLinkedList, bbn parambbn)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "k", "", "v", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$2"})
    static final class b
      extends q
      implements m<Long, String, x>
    {
      b(FinderTabStreamUnreadVM.b paramb, LinkedList paramLinkedList, bbn parambbn)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM
 * JD-Core Version:    0.7.0.1
 */