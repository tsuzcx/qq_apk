package com.tencent.mm.plugin.finder.viewmodel;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "followCollector", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "friendCollector", "machineCollector", "collectDeprecatedFeeds", "", "tabType", "", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "collectReadFeeds", "commentScene", "readList", "isRead", "", "feedId", "", "Companion", "TabStreamCollector", "plugin-finder_release"})
public final class FinderTabStreamUnreadVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final a tle;
  public final b tlb;
  public final b tlc;
  public final b tld;
  
  static
  {
    AppMethodBeat.i(206078);
    tle = new a((byte)0);
    AppMethodBeat.o(206078);
  }
  
  public FinderTabStreamUnreadVM()
  {
    AppMethodBeat.i(206077);
    this.tlb = new b(1);
    this.tlc = new b(3);
    this.tld = new b(4);
    AppMethodBeat.o(206077);
  }
  
  public final void k(int paramInt, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(206076);
    if (paramList == null)
    {
      AppMethodBeat.o(206076);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[collectReadFeeds] commentScene=").append(paramInt).append(" readList=").append(paramList.size()).append(" first=");
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)j.jm(paramList);
    long l;
    if (localBaseFinderFeed != null)
    {
      l = localBaseFinderFeed.lP();
      ae.i("Finder.TabStreamUnreadVM", c.rp(l));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(206076);
      return;
      l = 0L;
      break;
      this.tlc.dS(paramList).aCO();
      AppMethodBeat.o(206076);
      return;
      this.tlb.dS(paramList).aCO();
      AppMethodBeat.o(206076);
      return;
      this.tld.dS(paramList).aCO();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "", "tabType", "", "(I)V", "deprecatedCollection", "Landroid/util/LongSparseArray;", "", "lock", "getLock", "()Ljava/lang/Object;", "readCollection", "checkReport", "", "collectDeprecated", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "collectRead", "readList", "component1", "copy", "equals", "", "other", "hashCode", "isRead", "feedId", "", "printSparseArray", "list", "toString", "plugin-finder_release"})
  public static final class b
  {
    final int dvm;
    private final Object lock;
    final LongSparseArray<String> tlf;
    private final LongSparseArray<String> tlg;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(206073);
      this.dvm = paramInt;
      this.tlf = new LongSparseArray();
      this.tlg = new LongSparseArray();
      this.lock = new Object();
      AppMethodBeat.o(206073);
    }
    
    public final void aCO()
    {
      AppMethodBeat.i(206072);
      final LinkedList localLinkedList = new LinkedList();
      final arn localarn = new arn();
      ??? = i.syT;
      localarn.sch = i.Fw(this.dvm);
      Object localObject3;
      for (;;)
      {
        synchronized (this.lock)
        {
          c.b(c.a(this.tlg, (m)new a(this, localLinkedList, localarn)), (m)new b(this, localLinkedList, localarn));
          if (this.tlg.size() > 0) {
            this.tlg.clear();
          }
          localObject3 = z.Nhr;
          if (!((Collection)localLinkedList).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label270;
            }
            ??? = new StringBuilder("[checkReport] tabType=").append(this.dvm).append(", begin to report unread... ");
            Object localObject4 = (Iterable)localLinkedList;
            localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
            localObject4 = ((Iterable)localObject4).iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            ((Collection)localObject3).add(c.rp(((asz)((Iterator)localObject4).next()).rRn));
          }
        }
        int i = 0;
      }
      ae.i("Finder.TabStreamUnreadVM", (List)localObject3);
      new com.tencent.mm.plugin.finder.cgi.a((List)localObject1, localarn).aET();
      label270:
      AppMethodBeat.o(206072);
    }
    
    public final b dS(List<? extends BaseFinderFeed> paramList)
    {
      AppMethodBeat.i(206070);
      p.h(paramList, "readList");
      synchronized (this.lock)
      {
        paramList = ((Iterable)paramList).iterator();
        if (paramList.hasNext())
        {
          localObject2 = (BaseFinderFeed)paramList.next();
          this.tlf.append(((BaseFinderFeed)localObject2).lP(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId());
        }
      }
      paramList = z.Nhr;
      paramList = new StringBuilder("[collectRead] tabType=").append(this.dvm).append(", ");
      ??? = this.tlf;
      Object localObject2 = new StringBuilder("[");
      c.b((LongSparseArray)???, (m)new c((StringBuilder)localObject2));
      ((StringBuilder)localObject2).append("]");
      ??? = ((StringBuilder)localObject2).toString();
      p.g(???, "ss.toString()");
      ae.d("Finder.TabStreamUnreadVM", (String)??? + ' ');
      AppMethodBeat.o(206070);
      return this;
    }
    
    public final void dT(List<? extends BaseFinderFeed> paramList)
    {
      AppMethodBeat.i(206071);
      p.h(paramList, "deprecatedList");
      synchronized (this.lock)
      {
        localObject2 = ((Iterable)paramList).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject2).next();
          this.tlg.append(localBaseFinderFeed.lP(), localBaseFinderFeed.feedObject.getObjectNonceId());
        }
      }
      Object localObject2 = z.Nhr;
      ??? = new StringBuilder("[collectDeprecated] tabType=").append(this.dvm).append(", ");
      localObject2 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramList.add(c.rp(((BaseFinderFeed)((Iterator)localObject2).next()).lP()));
      }
      ae.i("Finder.TabStreamUnreadVM", (List)paramList + ' ');
      AppMethodBeat.o(206071);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
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
      AppMethodBeat.i(206074);
      String str = "TabStreamCollector(tabType=" + this.dvm + ")";
      AppMethodBeat.o(206074);
      return str;
    }
    
    public final boolean xR(long paramLong)
    {
      AppMethodBeat.i(206069);
      if (this.tlf.indexOfKey(paramLong) >= 0)
      {
        AppMethodBeat.o(206069);
        return true;
      }
      AppMethodBeat.o(206069);
      return false;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "feedId", "", "<anonymous parameter 1>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$1"})
    static final class a
      extends q
      implements m<Long, String, Boolean>
    {
      a(FinderTabStreamUnreadVM.b paramb, LinkedList paramLinkedList, arn paramarn)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "k", "", "v", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$2"})
    static final class b
      extends q
      implements m<Long, String, z>
    {
      b(FinderTabStreamUnreadVM.b paramb, LinkedList paramLinkedList, arn paramarn)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "k", "", "<anonymous parameter 1>", "", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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