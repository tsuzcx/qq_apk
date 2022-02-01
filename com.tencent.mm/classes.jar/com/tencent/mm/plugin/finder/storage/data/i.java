package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem.c;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.h;
import d.g.b.k;
import d.l;
import d.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderHotRelatedCache;", "", "()V", "TAG", "", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "prefetchCache", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "relatedFeedSet", "relatedPreloadFeedSet", "totalExposeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "clear", "", "clearFetchRelatedFeed", "feedId", "clearPrefetchCache", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isCollectUnread", "", "source", "clearPrefetchRelatedFeed", "get", "getPrefetchCache", "isCanFetch", "isCanPrefetch", "markFetchRelatedFeed", "markPrefetchRelatedFeed", "restoreTotalExposeMap", "map", "Landroid/util/LongSparseArray;", "saveTotalExposeMap", "setPrefetchCache", "info", "update", "config", "plugin-finder_release"})
public final class i
{
  private static final LinkedList<h> KXr;
  private static final ConcurrentHashMap<Long, Object> KXs;
  private static final ConcurrentHashMap<Long, Object> KXt;
  public static o<Long, com.tencent.mm.plugin.finder.feed.model.c> KXu;
  public static final i KXv;
  private static final ConcurrentHashMap<Long, FinderItem.c> cache;
  
  static
  {
    AppMethodBeat.i(199070);
    KXv = new i();
    cache = new ConcurrentHashMap();
    KXr = new LinkedList();
    KXs = new ConcurrentHashMap();
    KXt = new ConcurrentHashMap();
    AppMethodBeat.o(199070);
  }
  
  public static FinderItem.c BT(long paramLong)
  {
    AppMethodBeat.i(199062);
    FinderItem.c localc = (FinderItem.c)cache.get(Long.valueOf(paramLong));
    if (localc == null) {
      ad.w("Finder.HotRelatedCache", "[get] feedId=" + com.tencent.mm.ad.c.ly(paramLong) + " config is null.");
    }
    AppMethodBeat.o(199062);
    return localc;
  }
  
  public static boolean BU(long paramLong)
  {
    AppMethodBeat.i(199063);
    if (!KXs.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(199063);
      return true;
    }
    AppMethodBeat.o(199063);
    return false;
  }
  
  public static boolean BV(long paramLong)
  {
    AppMethodBeat.i(199064);
    if (!KXt.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(199064);
      return true;
    }
    AppMethodBeat.o(199064);
    return false;
  }
  
  public static void BW(long paramLong)
  {
    AppMethodBeat.i(199065);
    ad.i("Finder.HotRelatedCache", "[markFetchRelatedFeed] feedId=" + com.tencent.mm.ad.c.ly(paramLong));
    ((Map)KXs).put(Long.valueOf(paramLong), new Object());
    AppMethodBeat.o(199065);
  }
  
  public static void BX(long paramLong)
  {
    AppMethodBeat.i(199066);
    ad.i("Finder.HotRelatedCache", "[clearFetchRelatedFeed] feedId=" + com.tencent.mm.ad.c.ly(paramLong));
    KXs.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(199066);
  }
  
  public static void BY(long paramLong)
  {
    AppMethodBeat.i(199067);
    ad.i("Finder.HotRelatedCache", "[markPrefetchRelatedFeed] feedId=" + com.tencent.mm.ad.c.ly(paramLong));
    ((Map)KXt).put(Long.valueOf(paramLong), new Object());
    AppMethodBeat.o(199067);
  }
  
  public static com.tencent.mm.plugin.finder.feed.model.c BZ(long paramLong)
  {
    AppMethodBeat.i(199068);
    Object localObject = KXu;
    if ((localObject != null) && (((Number)((o)localObject).first).longValue() == paramLong))
    {
      ad.i("Finder.HotRelatedCache", "[getPrefetchCache] use cache, feedId=" + com.tencent.mm.ad.c.ly(paramLong) + ' ');
      localObject = KXu;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.finder.feed.model.c)((o)localObject).second;
        AppMethodBeat.o(199068);
        return localObject;
      }
      AppMethodBeat.o(199068);
      return null;
    }
    AppMethodBeat.o(199068);
    return null;
  }
  
  public static void a(long paramLong, FinderItem.c paramc)
  {
    AppMethodBeat.i(199061);
    k.h(paramc, "config");
    ((Map)cache).put(Long.valueOf(paramLong), paramc);
    AppMethodBeat.o(199061);
  }
  
  public static void a(dzp paramdzp, boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(199069);
    k.h(paramString, "source");
    Object localObject1 = new StringBuilder("[clearPrefetchCache] feedId=");
    Object localObject2 = KXu;
    long l1;
    if (localObject2 != null)
    {
      localObject2 = (Long)((o)localObject2).first;
      if (localObject2 != null)
      {
        l1 = ((Long)localObject2).longValue();
        ad.i("Finder.HotRelatedCache", com.tencent.mm.ad.c.ly(l1) + " source=" + paramString);
        paramString = KXu;
        if (paramString == null) {
          break label212;
        }
        paramString = (com.tencent.mm.plugin.finder.feed.model.c)paramString.second;
        if (paramString == null) {
          break label212;
        }
      }
    }
    label212:
    for (paramString = paramString.incrementList;; paramString = null)
    {
      if (paramString != null)
      {
        localObject1 = KXu;
        l1 = l2;
        if (localObject1 != null)
        {
          localObject1 = (Long)((o)localObject1).first;
          l1 = l2;
          if (localObject1 != null) {
            l1 = ((Long)localObject1).longValue();
          }
        }
        ad.i("Finder.HotRelatedCache", "[clearPrefetchRelatedFeed] feedId=" + com.tencent.mm.ad.c.ly(l1));
        KXt.remove(Long.valueOf(l1));
        if (paramBoolean)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
          com.tencent.mm.plugin.finder.utils.i.a(paramString, paramdzp);
        }
      }
      KXu = null;
      AppMethodBeat.o(199069);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public static void b(LongSparseArray<h> paramLongSparseArray)
  {
    AppMethodBeat.i(199059);
    StringBuilder localStringBuilder = new StringBuilder();
    KXr.clear();
    if (paramLongSparseArray != null)
    {
      int i = 0;
      int j = paramLongSparseArray.size();
      while (i < j)
      {
        KXr.add(paramLongSparseArray.valueAt(i));
        localStringBuilder.append(com.tencent.mm.ad.c.ly(paramLongSparseArray.keyAt(i)) + ", ");
        i += 1;
      }
    }
    ad.i("Finder.HotRelatedCache", "[saveTotalExposeMap] ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(199059);
  }
  
  public static void c(LongSparseArray<h> paramLongSparseArray)
  {
    AppMethodBeat.i(199060);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLongSparseArray != null)
    {
      Iterator localIterator = ((Iterable)KXr).iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        long l = localh.LDU.bMs();
        paramLongSparseArray.append(l, localh);
        localStringBuilder.append(com.tencent.mm.ad.c.ly(l) + ", ");
      }
    }
    ad.i("Finder.HotRelatedCache", "[restoreTotalExposeMap] ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(199060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.i
 * JD-Core Version:    0.7.0.1
 */