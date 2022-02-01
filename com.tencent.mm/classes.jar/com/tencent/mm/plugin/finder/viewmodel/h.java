package com.tencent.mm.plugin.finder.viewmodel;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "followCollector", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "friendCollector", "machineCollector", "collectDeprecatedFeeds", "", "tabType", "", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "collectReadFeeds", "commentScene", "readList", "isGlobalRead", "", "feedId", "", "isRead", "Companion", "TabStreamCollector", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends n<PluginFinder>
{
  public static final a GLj;
  public final b GLk;
  public final b GLl;
  public final b GLm;
  
  static
  {
    AppMethodBeat.i(337198);
    GLj = new a((byte)0);
    AppMethodBeat.o(337198);
  }
  
  public h()
  {
    AppMethodBeat.i(337182);
    this.GLk = new b(1);
    this.GLl = new b(3);
    this.GLm = new b(4);
    AppMethodBeat.o(337182);
  }
  
  public final void L(int paramInt, List<? extends cc> paramList)
  {
    AppMethodBeat.i(337220);
    if (paramList == null)
    {
      AppMethodBeat.o(337220);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[collectReadFeeds] commentScene=").append(paramInt).append(" readList=").append(paramList.size()).append(" first=");
    cc localcc = (cc)p.oL(paramList);
    long l;
    if (localcc == null)
    {
      l = 0L;
      Log.i("Finder.TabStreamUnreadVM", d.hF(l));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(337220);
      return;
      l = localcc.bZA();
      break;
      this.GLl.hO(paramList).bDh();
      AppMethodBeat.o(337220);
      return;
      this.GLk.hO(paramList).bDh();
      AppMethodBeat.o(337220);
      return;
      this.GLm.hO(paramList).bDh();
    }
  }
  
  public final boolean az(int paramInt, long paramLong)
  {
    AppMethodBeat.i(337239);
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(337239);
      return true;
    case 3: 
      bool = this.GLl.re(paramLong);
      AppMethodBeat.o(337239);
      return bool;
    case 1: 
      bool = this.GLk.re(paramLong);
      AppMethodBeat.o(337239);
      return bool;
    }
    boolean bool = this.GLm.re(paramLong);
    AppMethodBeat.o(337239);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "", "tabType", "", "(I)V", "deprecatedCollection", "Landroid/util/LongSparseArray;", "", "lock", "getLock", "()Ljava/lang/Object;", "readCollection", "checkReport", "", "collectDeprecated", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "collectRead", "readList", "component1", "copy", "equals", "", "other", "hashCode", "isRead", "feedId", "", "printSparseArray", "list", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final LongSparseArray<String> GLn;
    private final LongSparseArray<String> GLo;
    private final int hJx;
    private final Object lock;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(337205);
      this.hJx = paramInt;
      this.GLn = new LongSparseArray();
      this.GLo = new LongSparseArray();
      this.lock = new Object();
      AppMethodBeat.o(337205);
    }
    
    public final void bDh()
    {
      AppMethodBeat.i(337247);
      LinkedList localLinkedList = new LinkedList();
      bui localbui = new bui();
      ??? = z.FrZ;
      localbui.AJo = z.SD(this.hJx);
      for (;;)
      {
        Object localObject3;
        int j;
        synchronized (this.lock)
        {
          localObject3 = d.a(this.GLo, (m)new a(this));
          int k = ((LongSparseArray)localObject3).size();
          Object localObject4;
          if (k > 0)
          {
            i = 0;
            j = i + 1;
            long l = ((LongSparseArray)localObject3).keyAt(i);
            Object localObject5 = (String)((LongSparseArray)localObject3).valueAt(i);
            localObject4 = new byg();
            ((byg)localObject4).hKN = l;
            ((byg)localObject4).objectNonceId = ((String)localObject5);
            ((byg)localObject4).hJx = this.hJx;
            localObject5 = z.FrZ;
            ((byg)localObject4).sessionBuffer = z.p(((byg)localObject4).hKN, localbui.AJo);
            localObject5 = ah.aiuX;
            localLinkedList.add(localObject4);
            if (j < k) {
              break label376;
            }
          }
          if (this.GLo.size() > 0) {
            this.GLo.clear();
          }
          localObject3 = ah.aiuX;
          if (!((Collection)localLinkedList).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label370;
            }
            ??? = new StringBuilder("[checkReport] tabType=").append(this.hJx).append(", begin to report unread... ");
            localObject4 = (Iterable)localLinkedList;
            localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
            localObject4 = ((Iterable)localObject4).iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break label334;
            }
            ((Collection)localObject3).add(d.hF(((byg)((Iterator)localObject4).next()).hKN));
          }
        }
        int i = 0;
        continue;
        label334:
        Log.i("Finder.TabStreamUnreadVM", (List)localObject3);
        new c((List)localObject1, localbui).bFJ();
        label370:
        AppMethodBeat.o(337247);
        return;
        label376:
        i = j;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
      } while (this.hJx == paramObject.hJx);
      return false;
    }
    
    public final b hO(List<? extends cc> paramList)
    {
      AppMethodBeat.i(337228);
      s.u(paramList, "readList");
      for (;;)
      {
        synchronized (this.lock)
        {
          Iterator localIterator = ((Iterable)paramList).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = (cc)localIterator.next();
          if (this.GLn.indexOfKey(paramList.bZA()) >= 0) {
            continue;
          }
          LongSparseArray localLongSparseArray = this.GLn;
          long l = paramList.bZA();
          if ((paramList instanceof BaseFinderFeed))
          {
            paramList = ((BaseFinderFeed)paramList).feedObject.getObjectNonceId();
            localLongSparseArray.append(l, paramList);
          }
        }
        paramList = "";
      }
      paramList = ah.aiuX;
      AppMethodBeat.o(337228);
      return this;
    }
    
    public final int hashCode()
    {
      return this.hJx;
    }
    
    public final boolean re(long paramLong)
    {
      AppMethodBeat.i(337214);
      if (this.GLn.indexOfKey(paramLong) >= 0)
      {
        AppMethodBeat.o(337214);
        return true;
      }
      AppMethodBeat.o(337214);
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(337256);
      String str = "TabStreamCollector(tabType=" + this.hJx + ')';
      AppMethodBeat.o(337256);
      return str;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "feedId", "", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<Long, String, Boolean>
    {
      a(h.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.h
 * JD-Core Version:    0.7.0.1
 */