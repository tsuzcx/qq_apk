package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.feed.model.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.b;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.h;
import d.l;
import d.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderHotRelatedCache;", "", "()V", "TAG", "", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "prefetchCache", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "relatedFeedSet", "relatedPreloadFeedSet", "totalExposeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "clear", "", "clearFetchRelatedFeed", "feedId", "clearPrefetchCache", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isCollectUnread", "", "source", "clearPrefetchRelatedFeed", "getHotRelatedFeed", "getPosTriggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "getPrefetchCache", "isCanFetch", "isCanPrefetch", "markFetchRelatedFeed", "markPrefetchRelatedFeed", "restoreTotalExposeMap", "map", "Landroid/util/LongSparseArray;", "saveTotalExposeMap", "setPrefetchCache", "info", "update", "feed", "plugin-finder_release"})
public final class g
{
  private static final ConcurrentHashMap<Long, FinderItem> cache;
  private static final LinkedList<h> sKM;
  private static final ConcurrentHashMap<Long, Object> sKN;
  private static final ConcurrentHashMap<Long, Object> sKO;
  public static o<Long, b> sKP;
  public static final g sKQ;
  
  static
  {
    AppMethodBeat.i(204406);
    sKQ = new g();
    cache = new ConcurrentHashMap();
    sKM = new LinkedList();
    sKN = new ConcurrentHashMap();
    sKO = new ConcurrentHashMap();
    AppMethodBeat.o(204406);
  }
  
  public static void a(arn paramarn, boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(204405);
    d.g.b.p.h(paramString, "source");
    Object localObject1 = new StringBuilder("[clearPrefetchCache] feedId=");
    Object localObject2 = sKP;
    long l1;
    if (localObject2 != null)
    {
      localObject2 = (Long)((o)localObject2).first;
      if (localObject2 != null)
      {
        l1 = ((Long)localObject2).longValue();
        ae.i("Finder.HotRelatedCache", c.rp(l1) + " source=" + paramString);
        paramString = sKP;
        if (paramString == null) {
          break label232;
        }
        paramString = (b)paramString.second;
        if (paramString == null) {
          break label232;
        }
        paramString = paramString.sjH;
        if (paramString == null) {
          break label232;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      }
    }
    label232:
    for (paramString = com.tencent.mm.plugin.finder.utils.p.a((List)paramString, BaseFinderFeed.class);; paramString = null)
    {
      if (paramString != null)
      {
        localObject1 = sKP;
        l1 = l2;
        if (localObject1 != null)
        {
          localObject1 = (Long)((o)localObject1).first;
          l1 = l2;
          if (localObject1 != null) {
            l1 = ((Long)localObject1).longValue();
          }
        }
        ae.i("Finder.HotRelatedCache", "[clearPrefetchRelatedFeed] feedId=" + c.rp(l1));
        sKO.remove(Long.valueOf(l1));
        if (paramBoolean)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
          com.tencent.mm.plugin.finder.utils.p.a(4, paramString, paramarn);
        }
      }
      sKP = null;
      AppMethodBeat.o(204405);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public static void b(LongSparseArray<h> paramLongSparseArray)
  {
    AppMethodBeat.i(204394);
    StringBuilder localStringBuilder = new StringBuilder();
    sKM.clear();
    if (paramLongSparseArray != null)
    {
      int i = 0;
      int j = paramLongSparseArray.size();
      while (i < j)
      {
        sKM.add(paramLongSparseArray.valueAt(i));
        localStringBuilder.append(c.rp(paramLongSparseArray.keyAt(i)) + ", ");
        i += 1;
      }
    }
    ae.i("Finder.HotRelatedCache", "[saveTotalExposeMap] ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(204394);
  }
  
  public static void c(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204396);
    d.g.b.p.h(paramFinderItem, "feed");
    ((Map)cache).put(Long.valueOf(paramLong), paramFinderItem);
    paramFinderItem.setPosTriggerConfig(paramFinderItem.parseJsonOfPosTriggerConfig());
    AppMethodBeat.o(204396);
  }
  
  public static void c(LongSparseArray<h> paramLongSparseArray)
  {
    AppMethodBeat.i(204395);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLongSparseArray != null)
    {
      Iterator localIterator = ((Iterable)sKM).iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        long l = localh.LSx.lP();
        paramLongSparseArray.append(l, localh);
        localStringBuilder.append(c.rp(l) + ", ");
      }
    }
    ae.i("Finder.HotRelatedCache", "[restoreTotalExposeMap] ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(204395);
  }
  
  public static FinderItem xn(long paramLong)
  {
    AppMethodBeat.i(204397);
    FinderItem localFinderItem = (FinderItem)cache.get(Long.valueOf(paramLong));
    AppMethodBeat.o(204397);
    return localFinderItem;
  }
  
  public static FinderItem.b xo(long paramLong)
  {
    AppMethodBeat.i(204398);
    Object localObject = (FinderItem)cache.get(Long.valueOf(paramLong));
    if (localObject == null) {
      ae.w("Finder.HotRelatedCache", "[get] feedId=" + c.rp(paramLong) + " config is null.");
    }
    if (localObject != null)
    {
      localObject = ((FinderItem)localObject).getPosTriggerConfig();
      AppMethodBeat.o(204398);
      return localObject;
    }
    AppMethodBeat.o(204398);
    return null;
  }
  
  public static boolean xp(long paramLong)
  {
    AppMethodBeat.i(204399);
    if (!sKN.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(204399);
      return true;
    }
    AppMethodBeat.o(204399);
    return false;
  }
  
  public static boolean xq(long paramLong)
  {
    AppMethodBeat.i(204400);
    if (!sKO.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(204400);
      return true;
    }
    AppMethodBeat.o(204400);
    return false;
  }
  
  public static void xr(long paramLong)
  {
    AppMethodBeat.i(204401);
    ae.i("Finder.HotRelatedCache", "[markFetchRelatedFeed] feedId=" + c.rp(paramLong));
    ((Map)sKN).put(Long.valueOf(paramLong), new Object());
    AppMethodBeat.o(204401);
  }
  
  public static void xs(long paramLong)
  {
    AppMethodBeat.i(204402);
    ae.i("Finder.HotRelatedCache", "[clearFetchRelatedFeed] feedId=" + c.rp(paramLong));
    sKN.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(204402);
  }
  
  public static void xt(long paramLong)
  {
    AppMethodBeat.i(204403);
    ae.i("Finder.HotRelatedCache", "[markPrefetchRelatedFeed] feedId=" + c.rp(paramLong));
    ((Map)sKO).put(Long.valueOf(paramLong), new Object());
    AppMethodBeat.o(204403);
  }
  
  public static b xu(long paramLong)
  {
    AppMethodBeat.i(204404);
    Object localObject = sKP;
    if ((localObject != null) && (((Number)((o)localObject).first).longValue() == paramLong))
    {
      ae.i("Finder.HotRelatedCache", "[getPrefetchCache] use cache, feedId=" + c.rp(paramLong) + ' ');
      localObject = sKP;
      if (localObject != null)
      {
        localObject = (b)((o)localObject).second;
        AppMethodBeat.o(204404);
        return localObject;
      }
      AppMethodBeat.o(204404);
      return null;
    }
    AppMethodBeat.o(204404);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.g
 * JD-Core Version:    0.7.0.1
 */