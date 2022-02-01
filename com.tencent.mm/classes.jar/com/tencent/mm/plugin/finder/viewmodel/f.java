package com.tencent.mm.plugin.finder.viewmodel;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.i;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "followCollector", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "friendCollector", "machineCollector", "collectDeprecatedFeeds", "", "tabType", "", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "collectReadFeeds", "commentScene", "readList", "isGlobalRead", "", "feedId", "", "isRead", "Companion", "TabStreamCollector", "plugin-finder_release"})
public final class f
  extends i<PluginFinder>
{
  public static final a Bhm;
  public final b Bhj;
  public final b Bhk;
  public final b Bhl;
  
  static
  {
    AppMethodBeat.i(286666);
    Bhm = new a((byte)0);
    AppMethodBeat.o(286666);
  }
  
  public f()
  {
    AppMethodBeat.i(286665);
    this.Bhj = new b(1);
    this.Bhk = new b(3);
    this.Bhl = new b(4);
    AppMethodBeat.o(286665);
  }
  
  public final boolean as(int paramInt, long paramLong)
  {
    AppMethodBeat.i(286664);
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(286664);
      return true;
    case 3: 
      bool = this.Bhk.NA(paramLong);
      AppMethodBeat.o(286664);
      return bool;
    case 1: 
      bool = this.Bhj.NA(paramLong);
      AppMethodBeat.o(286664);
      return bool;
    }
    boolean bool = this.Bhl.NA(paramLong);
    AppMethodBeat.o(286664);
    return bool;
  }
  
  public final void r(int paramInt, List<? extends bu> paramList)
  {
    AppMethodBeat.i(286663);
    if (paramList == null)
    {
      AppMethodBeat.o(286663);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[collectReadFeeds] commentScene=").append(paramInt).append(" readList=").append(paramList.size()).append(" first=");
    bu localbu = (bu)j.lp(paramList);
    long l;
    if (localbu != null)
    {
      l = localbu.mf();
      Log.i("Finder.TabStreamUnreadVM", d.Fw(l));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(286663);
      return;
      l = 0L;
      break;
      this.Bhk.fc(paramList).bfq();
      AppMethodBeat.o(286663);
      return;
      this.Bhj.fc(paramList).bfq();
      AppMethodBeat.o(286663);
      return;
      this.Bhl.fc(paramList).bfq();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "", "tabType", "", "(I)V", "deprecatedCollection", "Landroid/util/LongSparseArray;", "", "lock", "getLock", "()Ljava/lang/Object;", "readCollection", "checkReport", "", "collectDeprecated", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "collectRead", "readList", "component1", "copy", "equals", "", "other", "hashCode", "isRead", "feedId", "", "printSparseArray", "list", "toString", "plugin-finder_release"})
  public static final class b
  {
    final LongSparseArray<String> Bhn;
    private final LongSparseArray<String> Bho;
    private final int fEH;
    private final Object lock;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(286190);
      this.fEH = paramInt;
      this.Bhn = new LongSparseArray();
      this.Bho = new LongSparseArray();
      this.lock = new Object();
      AppMethodBeat.o(286190);
    }
    
    public final boolean NA(long paramLong)
    {
      AppMethodBeat.i(286187);
      if (this.Bhn.indexOfKey(paramLong) >= 0)
      {
        AppMethodBeat.o(286187);
        return true;
      }
      AppMethodBeat.o(286187);
      return false;
    }
    
    public final void bfq()
    {
      AppMethodBeat.i(286189);
      final LinkedList localLinkedList = new LinkedList();
      final bid localbid = new bid();
      ??? = n.zWF;
      localbid.xkX = n.Pz(this.fEH);
      Object localObject3;
      for (;;)
      {
        synchronized (this.lock)
        {
          localObject3 = d.a(this.Bho, (m)new a(this, localLinkedList, localbid));
          int j = ((LongSparseArray)localObject3).size();
          i = 0;
          Object localObject4;
          if (i < j)
          {
            long l = ((LongSparseArray)localObject3).keyAt(i);
            Object localObject5 = (String)((LongSparseArray)localObject3).valueAt(i);
            localObject4 = new bku();
            ((bku)localObject4).xbk = l;
            ((bku)localObject4).objectNonceId = ((String)localObject5);
            ((bku)localObject4).fEH = this.fEH;
            localObject5 = n.zWF;
            ((bku)localObject4).sessionBuffer = n.N(((bku)localObject4).xbk, localbid.xkX);
            localLinkedList.add(localObject4);
            i += 1;
            continue;
          }
          if (this.Bho.size() > 0) {
            this.Bho.clear();
          }
          localObject3 = x.aazN;
          if (!((Collection)localLinkedList).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label366;
            }
            ??? = new StringBuilder("[checkReport] tabType=").append(this.fEH).append(", begin to report unread... ");
            localObject4 = (Iterable)localLinkedList;
            localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
            localObject4 = ((Iterable)localObject4).iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            ((Collection)localObject3).add(d.Fw(((bku)((Iterator)localObject4).next()).xbk));
          }
        }
        int i = 0;
      }
      Log.i("Finder.TabStreamUnreadVM", (List)localObject3);
      new b((List)localObject1, localbid).bhW();
      label366:
      AppMethodBeat.o(286189);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (this.fEH != paramObject.fEH) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final b fc(List<? extends bu> paramList)
    {
      AppMethodBeat.i(286188);
      p.k(paramList, "readList");
      for (;;)
      {
        synchronized (this.lock)
        {
          Iterator localIterator = ((Iterable)paramList).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = (bu)localIterator.next();
          if (this.Bhn.indexOfKey(paramList.mf()) >= 0) {
            continue;
          }
          LongSparseArray localLongSparseArray = this.Bhn;
          long l = paramList.mf();
          if ((paramList instanceof BaseFinderFeed))
          {
            paramList = ((BaseFinderFeed)paramList).feedObject.getObjectNonceId();
            localLongSparseArray.append(l, paramList);
          }
        }
        paramList = "";
      }
      paramList = x.aazN;
      AppMethodBeat.o(286188);
      return this;
    }
    
    public final int hashCode()
    {
      return this.fEH;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(286191);
      String str = "TabStreamCollector(tabType=" + this.fEH + ")";
      AppMethodBeat.o(286191);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "feedId", "", "<anonymous parameter 1>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$1"})
    static final class a
      extends q
      implements m<Long, String, Boolean>
    {
      a(f.b paramb, LinkedList paramLinkedList, bid parambid)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.f
 * JD-Core Version:    0.7.0.1
 */