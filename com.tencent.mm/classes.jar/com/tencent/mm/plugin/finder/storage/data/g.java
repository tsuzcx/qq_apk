package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.storage.FinderItem.b;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.view.recyclerview.h;
import d.g.b.k;
import d.l;
import d.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderHotRelatedCache;", "", "()V", "TAG", "", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "prefetchCache", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "relatedFeedSet", "relatedPreloadFeedSet", "totalExposeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "clear", "", "clearFetchRelatedFeed", "feedId", "clearPrefetchCache", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isCollectUnread", "", "source", "clearPrefetchRelatedFeed", "get", "getPrefetchCache", "isCanFetch", "isCanPrefetch", "markFetchRelatedFeed", "markPrefetchRelatedFeed", "restoreTotalExposeMap", "map", "Landroid/util/LongSparseArray;", "saveTotalExposeMap", "setPrefetchCache", "info", "update", "config", "plugin-finder_release"})
public final class g
{
  private static final ConcurrentHashMap<Long, FinderItem.b> cache;
  private static final LinkedList<h> rEL;
  private static final ConcurrentHashMap<Long, Object> rEM;
  private static final ConcurrentHashMap<Long, Object> rEN;
  public static o<Long, com.tencent.mm.plugin.finder.feed.model.a> rEO;
  public static final g rEP;
  
  static
  {
    AppMethodBeat.i(203037);
    rEP = new g();
    cache = new ConcurrentHashMap();
    rEL = new LinkedList();
    rEM = new ConcurrentHashMap();
    rEN = new ConcurrentHashMap();
    AppMethodBeat.o(203037);
  }
  
  public static void a(long paramLong, FinderItem.b paramb)
  {
    AppMethodBeat.i(203028);
    k.h(paramb, "config");
    ((Map)cache).put(Long.valueOf(paramLong), paramb);
    AppMethodBeat.o(203028);
  }
  
  public static void a(anm paramanm, boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(203036);
    k.h(paramString, "source");
    Object localObject1 = new StringBuilder("[clearPrefetchCache] feedId=");
    Object localObject2 = rEO;
    long l1;
    if (localObject2 != null)
    {
      localObject2 = (Long)((o)localObject2).first;
      if (localObject2 != null)
      {
        l1 = ((Long)localObject2).longValue();
        ac.i("Finder.HotRelatedCache", c.pb(l1) + " source=" + paramString);
        paramString = rEO;
        if (paramString == null) {
          break label213;
        }
        paramString = (com.tencent.mm.plugin.finder.feed.model.a)paramString.second;
        if (paramString == null) {
          break label213;
        }
      }
    }
    label213:
    for (paramString = paramString.incrementList;; paramString = null)
    {
      if (paramString != null)
      {
        localObject1 = rEO;
        l1 = l2;
        if (localObject1 != null)
        {
          localObject1 = (Long)((o)localObject1).first;
          l1 = l2;
          if (localObject1 != null) {
            l1 = ((Long)localObject1).longValue();
          }
        }
        ac.i("Finder.HotRelatedCache", "[clearPrefetchRelatedFeed] feedId=" + c.pb(l1));
        rEN.remove(Long.valueOf(l1));
        if (paramBoolean)
        {
          localObject1 = n.rPN;
          n.a(4, paramString, paramanm);
        }
      }
      rEO = null;
      AppMethodBeat.o(203036);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public static void b(LongSparseArray<h> paramLongSparseArray)
  {
    AppMethodBeat.i(203026);
    StringBuilder localStringBuilder = new StringBuilder();
    rEL.clear();
    if (paramLongSparseArray != null)
    {
      int i = 0;
      int j = paramLongSparseArray.size();
      while (i < j)
      {
        rEL.add(paramLongSparseArray.valueAt(i));
        localStringBuilder.append(c.pb(paramLongSparseArray.keyAt(i)) + ", ");
        i += 1;
      }
    }
    ac.i("Finder.HotRelatedCache", "[saveTotalExposeMap] ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(203026);
  }
  
  public static void c(LongSparseArray<h> paramLongSparseArray)
  {
    AppMethodBeat.i(203027);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLongSparseArray != null)
    {
      Iterator localIterator = ((Iterable)rEL).iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        long l = localh.JCE.lx();
        paramLongSparseArray.append(l, localh);
        localStringBuilder.append(c.pb(l) + ", ");
      }
    }
    ac.i("Finder.HotRelatedCache", "[restoreTotalExposeMap] ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(203027);
  }
  
  public static FinderItem.b uV(long paramLong)
  {
    AppMethodBeat.i(203029);
    FinderItem.b localb = (FinderItem.b)cache.get(Long.valueOf(paramLong));
    if (localb == null) {
      ac.w("Finder.HotRelatedCache", "[get] feedId=" + c.pb(paramLong) + " config is null.");
    }
    AppMethodBeat.o(203029);
    return localb;
  }
  
  public static boolean uW(long paramLong)
  {
    AppMethodBeat.i(203030);
    if (!rEM.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(203030);
      return true;
    }
    AppMethodBeat.o(203030);
    return false;
  }
  
  public static boolean uX(long paramLong)
  {
    AppMethodBeat.i(203031);
    if (!rEN.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(203031);
      return true;
    }
    AppMethodBeat.o(203031);
    return false;
  }
  
  public static void uY(long paramLong)
  {
    AppMethodBeat.i(203032);
    ac.i("Finder.HotRelatedCache", "[markFetchRelatedFeed] feedId=" + c.pb(paramLong));
    ((Map)rEM).put(Long.valueOf(paramLong), new Object());
    AppMethodBeat.o(203032);
  }
  
  public static void uZ(long paramLong)
  {
    AppMethodBeat.i(203033);
    ac.i("Finder.HotRelatedCache", "[clearFetchRelatedFeed] feedId=" + c.pb(paramLong));
    rEM.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(203033);
  }
  
  public static void va(long paramLong)
  {
    AppMethodBeat.i(203034);
    ac.i("Finder.HotRelatedCache", "[markPrefetchRelatedFeed] feedId=" + c.pb(paramLong));
    ((Map)rEN).put(Long.valueOf(paramLong), new Object());
    AppMethodBeat.o(203034);
  }
  
  public static com.tencent.mm.plugin.finder.feed.model.a vb(long paramLong)
  {
    AppMethodBeat.i(203035);
    Object localObject = rEO;
    if ((localObject != null) && (((Number)((o)localObject).first).longValue() == paramLong))
    {
      ac.i("Finder.HotRelatedCache", "[getPrefetchCache] use cache, feedId=" + c.pb(paramLong) + ' ');
      localObject = rEO;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.finder.feed.model.a)((o)localObject).second;
        AppMethodBeat.o(203035);
        return localObject;
      }
      AppMethodBeat.o(203035);
      return null;
    }
    AppMethodBeat.o(203035);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.g
 * JD-Core Version:    0.7.0.1
 */