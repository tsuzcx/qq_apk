package com.tencent.mm.plugin.finder.feed.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FeedInfoAsyncLoadMgr;", "", "()V", "asyncLoaderQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/feed/component/IFeedInfoAsyncLoader;", "enableMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "pauseAsyncLoader", "", "loader", "registerAsyncLoader", "request", "feedList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "resumeAsyncLoader", "unregisterAsyncLoader", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a Bca;
  private static final j<d> nqI;
  public final ConcurrentLinkedQueue<i> Bcb;
  public final ConcurrentHashMap<i, Boolean> Bcc;
  
  static
  {
    AppMethodBeat.i(364069);
    Bca = new a((byte)0);
    nqI = k.cm((a)b.Bcd);
    AppMethodBeat.o(364069);
  }
  
  public d()
  {
    AppMethodBeat.i(364059);
    this.Bcb = new ConcurrentLinkedQueue();
    this.Bcc = new ConcurrentHashMap();
    AppMethodBeat.o(364059);
  }
  
  public final void gb(List<? extends FinderItem> paramList)
  {
    AppMethodBeat.i(364083);
    if (paramList == null)
    {
      AppMethodBeat.o(364083);
      return;
    }
    Object localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((FinderItem)((Iterator)localObject1).next()).getFeedObject();
    }
    Iterator localIterator = ((Iterable)this.Bcb).iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      localObject1 = (Map)this.Bcc;
      s.s(locali, "loader");
      Object localObject2 = ((Map)localObject1).get(locali);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Boolean.TRUE;
      }
      if (((Boolean)localObject1).booleanValue()) {
        locali.gb(paramList);
      }
    }
    AppMethodBeat.o(364083);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FeedInfoAsyncLoadMgr$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/finder/feed/component/FeedInfoAsyncLoadMgr;", "getInstance", "()Lcom/tencent/mm/plugin/finder/feed/component/FeedInfoAsyncLoadMgr;", "instance$delegate", "Lkotlin/Lazy;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static d edf()
    {
      AppMethodBeat.i(364036);
      d locald = (d)d.blL().getValue();
      AppMethodBeat.o(364036);
      return locald;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/component/FeedInfoAsyncLoadMgr;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<d>
  {
    public static final b Bcd;
    
    static
    {
      AppMethodBeat.i(364030);
      Bcd = new b();
      AppMethodBeat.o(364030);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.d
 * JD-Core Version:    0.7.0.1
 */