package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.finder.feed.model.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.b;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.h;
import d.l;
import d.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/FinderHotRelatedCache;", "", "()V", "TAG", "", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "prefetchCache", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "relatedFeedSet", "relatedPreloadFeedSet", "totalExposeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "clear", "", "clearFetchRelatedFeed", "feedId", "clearPrefetchCache", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isCollectUnread", "", "source", "clearPrefetchRelatedFeed", "getHotRelatedFeed", "getPosTriggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "getPrefetchCache", "isCanFetch", "isCanPrefetch", "markFetchRelatedFeed", "markPrefetchRelatedFeed", "restoreTotalExposeMap", "map", "Landroid/util/LongSparseArray;", "saveTotalExposeMap", "setPrefetchCache", "info", "update", "feed", "plugin-finder_release"})
public final class g
{
  private static final ConcurrentHashMap<Long, FinderItem> cache;
  private static final LinkedList<h> szP;
  private static final ConcurrentHashMap<Long, Object> szQ;
  private static final ConcurrentHashMap<Long, Object> szR;
  public static o<Long, b> szS;
  public static final g szT;
  
  static
  {
    AppMethodBeat.i(203815);
    szT = new g();
    cache = new ConcurrentHashMap();
    szP = new LinkedList();
    szQ = new ConcurrentHashMap();
    szR = new ConcurrentHashMap();
    AppMethodBeat.o(203815);
  }
  
  public static void a(aqy paramaqy, boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(203814);
    d.g.b.p.h(paramString, "source");
    Object localObject1 = new StringBuilder("[clearPrefetchCache] feedId=");
    Object localObject2 = szS;
    long l1;
    if (localObject2 != null)
    {
      localObject2 = (Long)((o)localObject2).first;
      if (localObject2 != null)
      {
        l1 = ((Long)localObject2).longValue();
        ad.i("Finder.HotRelatedCache", c.rc(l1) + " source=" + paramString);
        paramString = szS;
        if (paramString == null) {
          break label232;
        }
        paramString = (b)paramString.second;
        if (paramString == null) {
          break label232;
        }
        paramString = paramString.saR;
        if (paramString == null) {
          break label232;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      }
    }
    label232:
    for (paramString = com.tencent.mm.plugin.finder.utils.p.a((List)paramString, BaseFinderFeed.class);; paramString = null)
    {
      if (paramString != null)
      {
        localObject1 = szS;
        l1 = l2;
        if (localObject1 != null)
        {
          localObject1 = (Long)((o)localObject1).first;
          l1 = l2;
          if (localObject1 != null) {
            l1 = ((Long)localObject1).longValue();
          }
        }
        ad.i("Finder.HotRelatedCache", "[clearPrefetchRelatedFeed] feedId=" + c.rc(l1));
        szR.remove(Long.valueOf(l1));
        if (paramBoolean)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
          com.tencent.mm.plugin.finder.utils.p.a(4, paramString, paramaqy);
        }
      }
      szS = null;
      AppMethodBeat.o(203814);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public static void b(LongSparseArray<h> paramLongSparseArray)
  {
    AppMethodBeat.i(203803);
    StringBuilder localStringBuilder = new StringBuilder();
    szP.clear();
    if (paramLongSparseArray != null)
    {
      int i = 0;
      int j = paramLongSparseArray.size();
      while (i < j)
      {
        szP.add(paramLongSparseArray.valueAt(i));
        localStringBuilder.append(c.rc(paramLongSparseArray.keyAt(i)) + ", ");
        i += 1;
      }
    }
    ad.i("Finder.HotRelatedCache", "[saveTotalExposeMap] ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(203803);
  }
  
  public static void c(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(203805);
    d.g.b.p.h(paramFinderItem, "feed");
    ((Map)cache).put(Long.valueOf(paramLong), paramFinderItem);
    paramFinderItem.setPosTriggerConfig(paramFinderItem.parseJsonOfPosTriggerConfig());
    AppMethodBeat.o(203805);
  }
  
  public static void c(LongSparseArray<h> paramLongSparseArray)
  {
    AppMethodBeat.i(203804);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLongSparseArray != null)
    {
      Iterator localIterator = ((Iterable)szP).iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        long l = localh.LvK.lP();
        paramLongSparseArray.append(l, localh);
        localStringBuilder.append(c.rc(l) + ", ");
      }
    }
    ad.i("Finder.HotRelatedCache", "[restoreTotalExposeMap] ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(203804);
  }
  
  public static FinderItem wW(long paramLong)
  {
    AppMethodBeat.i(203806);
    FinderItem localFinderItem = (FinderItem)cache.get(Long.valueOf(paramLong));
    AppMethodBeat.o(203806);
    return localFinderItem;
  }
  
  public static FinderItem.b wX(long paramLong)
  {
    AppMethodBeat.i(203807);
    Object localObject = (FinderItem)cache.get(Long.valueOf(paramLong));
    if (localObject == null) {
      ad.w("Finder.HotRelatedCache", "[get] feedId=" + c.rc(paramLong) + " config is null.");
    }
    if (localObject != null)
    {
      localObject = ((FinderItem)localObject).getPosTriggerConfig();
      AppMethodBeat.o(203807);
      return localObject;
    }
    AppMethodBeat.o(203807);
    return null;
  }
  
  public static boolean wY(long paramLong)
  {
    AppMethodBeat.i(203808);
    if (!szQ.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(203808);
      return true;
    }
    AppMethodBeat.o(203808);
    return false;
  }
  
  public static boolean wZ(long paramLong)
  {
    AppMethodBeat.i(203809);
    if (!szR.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(203809);
      return true;
    }
    AppMethodBeat.o(203809);
    return false;
  }
  
  public static void xa(long paramLong)
  {
    AppMethodBeat.i(203810);
    ad.i("Finder.HotRelatedCache", "[markFetchRelatedFeed] feedId=" + c.rc(paramLong));
    ((Map)szQ).put(Long.valueOf(paramLong), new Object());
    AppMethodBeat.o(203810);
  }
  
  public static void xb(long paramLong)
  {
    AppMethodBeat.i(203811);
    ad.i("Finder.HotRelatedCache", "[clearFetchRelatedFeed] feedId=" + c.rc(paramLong));
    szQ.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(203811);
  }
  
  public static void xc(long paramLong)
  {
    AppMethodBeat.i(203812);
    ad.i("Finder.HotRelatedCache", "[markPrefetchRelatedFeed] feedId=" + c.rc(paramLong));
    ((Map)szR).put(Long.valueOf(paramLong), new Object());
    AppMethodBeat.o(203812);
  }
  
  public static b xd(long paramLong)
  {
    AppMethodBeat.i(203813);
    Object localObject = szS;
    if ((localObject != null) && (((Number)((o)localObject).first).longValue() == paramLong))
    {
      ad.i("Finder.HotRelatedCache", "[getPrefetchCache] use cache, feedId=" + c.rc(paramLong) + ' ');
      localObject = szS;
      if (localObject != null)
      {
        localObject = (b)((o)localObject).second;
        AppMethodBeat.o(203813);
        return localObject;
      }
      AppMethodBeat.o(203813);
      return null;
    }
    AppMethodBeat.o(203813);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.g
 * JD-Core Version:    0.7.0.1
 */