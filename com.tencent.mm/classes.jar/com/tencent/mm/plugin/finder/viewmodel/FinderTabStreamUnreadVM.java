package com.tencent.mm.plugin.finder.viewmodel;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "followCollector", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "friendCollector", "machineCollector", "collectDeprecatedFeeds", "", "tabType", "", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "collectReadFeeds", "commentScene", "readList", "Companion", "TabStreamCollector", "plugin-finder_release"})
public final class FinderTabStreamUnreadVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final FinderTabStreamUnreadVM.a scP;
  private final b scM;
  private final b scN;
  private final b scO;
  
  static
  {
    AppMethodBeat.i(204450);
    scP = new FinderTabStreamUnreadVM.a((byte)0);
    AppMethodBeat.o(204450);
  }
  
  public FinderTabStreamUnreadVM()
  {
    AppMethodBeat.i(204449);
    this.scM = new b(1);
    this.scN = new b(3);
    this.scO = new b(4);
    AppMethodBeat.o(204449);
  }
  
  public final void i(int paramInt, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(204448);
    if (paramList == null)
    {
      AppMethodBeat.o(204448);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204448);
      return;
      this.scN.dE(paramList).azv();
      AppMethodBeat.o(204448);
      return;
      this.scM.dE(paramList).azv();
      AppMethodBeat.o(204448);
      return;
      this.scO.dE(paramList).azv();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "", "tabType", "", "(I)V", "deprecatedCollection", "Landroid/util/LongSparseArray;", "", "lock", "getLock", "()Ljava/lang/Object;", "readCollection", "checkReport", "", "collectDeprecated", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "collectRead", "readList", "component1", "copy", "equals", "", "other", "hashCode", "printSparseArray", "list", "toString", "plugin-finder_release"})
  public static final class b
  {
    final int diw;
    private final Object lock;
    final LongSparseArray<String> scQ;
    private final LongSparseArray<String> scR;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(204445);
      this.diw = paramInt;
      this.scQ = new LongSparseArray();
      this.scR = new LongSparseArray();
      this.lock = new Object();
      AppMethodBeat.o(204445);
    }
    
    public final void azv()
    {
      AppMethodBeat.i(204444);
      final LinkedList localLinkedList = new LinkedList();
      final anm localanm = new anm();
      ??? = d.rxr;
      localanm.rfR = d.DW(this.diw);
      Object localObject3;
      for (;;)
      {
        synchronized (this.lock)
        {
          c.b(c.a(this.scR, (m)new a(this, localLinkedList, localanm)), (m)new b(this, localLinkedList, localanm));
          if (this.scR.size() > 0)
          {
            this.scR.clear();
            this.scQ.clear();
          }
          localObject3 = y.KTp;
          if (!((Collection)localLinkedList).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label277;
            }
            ??? = new StringBuilder("[checkReport] tabType=").append(this.diw).append(", begin to report unread... ");
            Object localObject4 = (Iterable)localLinkedList;
            localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
            localObject4 = ((Iterable)localObject4).iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            ((Collection)localObject3).add(c.pb(((aot)((Iterator)localObject4).next()).qXP));
          }
        }
        int i = 0;
      }
      ac.i("Finder.TabStreamUnreadVM", (List)localObject3);
      new com.tencent.mm.plugin.finder.cgi.a((List)localObject1, localanm).aBB();
      label277:
      AppMethodBeat.o(204444);
    }
    
    public final b dE(List<? extends BaseFinderFeed> paramList)
    {
      AppMethodBeat.i(204442);
      k.h(paramList, "readList");
      synchronized (this.lock)
      {
        paramList = ((Iterable)paramList).iterator();
        if (paramList.hasNext())
        {
          localObject2 = (BaseFinderFeed)paramList.next();
          this.scQ.append(((BaseFinderFeed)localObject2).lx(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId());
        }
      }
      paramList = y.KTp;
      paramList = new StringBuilder("[collectRead] tabType=").append(this.diw).append(", ");
      ??? = this.scQ;
      Object localObject2 = new StringBuilder("[");
      c.b((LongSparseArray)???, (m)new FinderTabStreamUnreadVM.b.c((StringBuilder)localObject2));
      ((StringBuilder)localObject2).append("]");
      ??? = ((StringBuilder)localObject2).toString();
      k.g(???, "ss.toString()");
      ac.d("Finder.TabStreamUnreadVM", (String)??? + ' ');
      AppMethodBeat.o(204442);
      return this;
    }
    
    public final void dF(List<? extends BaseFinderFeed> paramList)
    {
      AppMethodBeat.i(204443);
      k.h(paramList, "deprecatedList");
      synchronized (this.lock)
      {
        localObject2 = ((Iterable)paramList).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject2).next();
          this.scR.append(localBaseFinderFeed.lx(), localBaseFinderFeed.feedObject.getObjectNonceId());
        }
      }
      Object localObject2 = y.KTp;
      ??? = new StringBuilder("[collectDeprecated] tabType=").append(this.diw).append(", ");
      localObject2 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramList.add(c.pb(((BaseFinderFeed)((Iterator)localObject2).next()).lx()));
      }
      ac.i("Finder.TabStreamUnreadVM", (List)paramList + ' ');
      AppMethodBeat.o(204443);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
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
      AppMethodBeat.i(204446);
      String str = "TabStreamCollector(tabType=" + this.diw + ")";
      AppMethodBeat.o(204446);
      return str;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "feedId", "", "<anonymous parameter 1>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$1"})
    static final class a
      extends d.g.b.l
      implements m<Long, String, Boolean>
    {
      a(FinderTabStreamUnreadVM.b paramb, LinkedList paramLinkedList, anm paramanm)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "k", "", "v", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$2"})
    static final class b
      extends d.g.b.l
      implements m<Long, String, y>
    {
      b(FinderTabStreamUnreadVM.b paramb, LinkedList paramLinkedList, anm paramanm)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public c(FinderTabStreamUnreadVM paramFinderTabStreamUnreadVM, int paramInt, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM
 * JD-Core Version:    0.7.0.1
 */