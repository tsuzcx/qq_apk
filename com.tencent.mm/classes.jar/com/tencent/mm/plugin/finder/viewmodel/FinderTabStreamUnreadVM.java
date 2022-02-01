package com.tencent.mm.plugin.finder.viewmodel;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "followCollector", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "friendCollector", "machineCollector", "collectDeprecatedFeeds", "", "tabType", "", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "collectReadFeeds", "commentScene", "readList", "isRead", "", "feedId", "", "Companion", "TabStreamCollector", "plugin-finder_release"})
public final class FinderTabStreamUnreadVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final a taq;
  public final b tan;
  public final b tao;
  public final b tap;
  
  static
  {
    AppMethodBeat.i(205468);
    taq = new a((byte)0);
    AppMethodBeat.o(205468);
  }
  
  public FinderTabStreamUnreadVM()
  {
    AppMethodBeat.i(205467);
    this.tan = new b(1);
    this.tao = new b(3);
    this.tap = new b(4);
    AppMethodBeat.o(205467);
  }
  
  public final void j(int paramInt, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(205466);
    if (paramList == null)
    {
      AppMethodBeat.o(205466);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[collectReadFeeds] commentScene=").append(paramInt).append(" readList=").append(paramList.size()).append(" first=");
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)j.jd(paramList);
    long l;
    if (localBaseFinderFeed != null)
    {
      l = localBaseFinderFeed.lP();
      ad.i("Finder.TabStreamUnreadVM", c.rc(l));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(205466);
      return;
      l = 0L;
      break;
      this.tao.dO(paramList).aCy();
      AppMethodBeat.o(205466);
      return;
      this.tan.dO(paramList).aCy();
      AppMethodBeat.o(205466);
      return;
      this.tap.dO(paramList).aCy();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "", "tabType", "", "(I)V", "deprecatedCollection", "Landroid/util/LongSparseArray;", "", "lock", "getLock", "()Ljava/lang/Object;", "readCollection", "checkReport", "", "collectDeprecated", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "collectRead", "readList", "component1", "copy", "equals", "", "other", "hashCode", "isRead", "feedId", "", "printSparseArray", "list", "toString", "plugin-finder_release"})
  public static final class b
  {
    final int duh;
    private final Object lock;
    final LongSparseArray<String> tar;
    private final LongSparseArray<String> tas;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(205463);
      this.duh = paramInt;
      this.tar = new LongSparseArray();
      this.tas = new LongSparseArray();
      this.lock = new Object();
      AppMethodBeat.o(205463);
    }
    
    public final void aCy()
    {
      AppMethodBeat.i(205462);
      final LinkedList localLinkedList = new LinkedList();
      final aqy localaqy = new aqy();
      ??? = h.soM;
      localaqy.rTD = h.Fa(this.duh);
      Object localObject3;
      for (;;)
      {
        synchronized (this.lock)
        {
          c.b(c.a(this.tas, (m)new a(this, localLinkedList, localaqy)), (m)new b(this, localLinkedList, localaqy));
          if (this.tas.size() > 0) {
            this.tas.clear();
          }
          localObject3 = z.MKo;
          if (!((Collection)localLinkedList).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label270;
            }
            ??? = new StringBuilder("[checkReport] tabType=").append(this.duh).append(", begin to report unread... ");
            Object localObject4 = (Iterable)localLinkedList;
            localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
            localObject4 = ((Iterable)localObject4).iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            ((Collection)localObject3).add(c.rc(((ask)((Iterator)localObject4).next()).rIZ));
          }
        }
        int i = 0;
      }
      ad.i("Finder.TabStreamUnreadVM", (List)localObject3);
      new com.tencent.mm.plugin.finder.cgi.a((List)localObject1, localaqy).aED();
      label270:
      AppMethodBeat.o(205462);
    }
    
    public final b dO(List<? extends BaseFinderFeed> paramList)
    {
      AppMethodBeat.i(205460);
      p.h(paramList, "readList");
      synchronized (this.lock)
      {
        paramList = ((Iterable)paramList).iterator();
        if (paramList.hasNext())
        {
          localObject2 = (BaseFinderFeed)paramList.next();
          this.tar.append(((BaseFinderFeed)localObject2).lP(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId());
        }
      }
      paramList = z.MKo;
      paramList = new StringBuilder("[collectRead] tabType=").append(this.duh).append(", ");
      ??? = this.tar;
      Object localObject2 = new StringBuilder("[");
      c.b((LongSparseArray)???, (m)new c((StringBuilder)localObject2));
      ((StringBuilder)localObject2).append("]");
      ??? = ((StringBuilder)localObject2).toString();
      p.g(???, "ss.toString()");
      ad.d("Finder.TabStreamUnreadVM", (String)??? + ' ');
      AppMethodBeat.o(205460);
      return this;
    }
    
    public final void dP(List<? extends BaseFinderFeed> paramList)
    {
      AppMethodBeat.i(205461);
      p.h(paramList, "deprecatedList");
      synchronized (this.lock)
      {
        localObject2 = ((Iterable)paramList).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject2).next();
          this.tas.append(localBaseFinderFeed.lP(), localBaseFinderFeed.feedObject.getObjectNonceId());
        }
      }
      Object localObject2 = z.MKo;
      ??? = new StringBuilder("[collectDeprecated] tabType=").append(this.duh).append(", ");
      localObject2 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramList.add(c.rc(((BaseFinderFeed)((Iterator)localObject2).next()).lP()));
      }
      ad.i("Finder.TabStreamUnreadVM", (List)paramList + ' ');
      AppMethodBeat.o(205461);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (this.duh != paramObject.duh) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.duh;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205464);
      String str = "TabStreamCollector(tabType=" + this.duh + ")";
      AppMethodBeat.o(205464);
      return str;
    }
    
    public final boolean xx(long paramLong)
    {
      AppMethodBeat.i(205459);
      if (this.tar.indexOfKey(paramLong) >= 0)
      {
        AppMethodBeat.o(205459);
        return true;
      }
      AppMethodBeat.o(205459);
      return false;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "feedId", "", "<anonymous parameter 1>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$1"})
    static final class a
      extends q
      implements m<Long, String, Boolean>
    {
      a(FinderTabStreamUnreadVM.b paramb, LinkedList paramLinkedList, aqy paramaqy)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "k", "", "v", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$2"})
    static final class b
      extends q
      implements m<Long, String, z>
    {
      b(FinderTabStreamUnreadVM.b paramb, LinkedList paramLinkedList, aqy paramaqy)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "k", "", "<anonymous parameter 1>", "", "invoke"})
    static final class c
      extends q
      implements m<Long, String, z>
    {
      c(StringBuilder paramStringBuilder)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.a<z>
  {
    public c(FinderTabStreamUnreadVM paramFinderTabStreamUnreadVM, int paramInt, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM
 * JD-Core Version:    0.7.0.1
 */