package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.model.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderHotRelatedCache;", "", "()V", "TAG", "", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "prefetchCache", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "relatedFeedSet", "relatedPreloadFeedSet", "totalExposeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "clear", "", "clearFetchRelatedFeed", "feedId", "clearPrefetchCache", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isCollectUnread", "", "source", "clearPrefetchRelatedFeed", "getHotRelatedFeed", "getPosTriggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "getPrefetchCache", "isCanFetch", "isCanPrefetch", "markFetchRelatedFeed", "markPrefetchRelatedFeed", "restoreTotalExposeMap", "map", "Landroid/util/LongSparseArray;", "saveTotalExposeMap", "setPrefetchCache", "info", "update", "feed", "plugin-finder_release"})
public final class h
{
  private static final ConcurrentHashMap<Long, FinderItem> cache;
  private static final LinkedList<k> vGg;
  private static final ConcurrentHashMap<Long, Object> vGh;
  private static final ConcurrentHashMap<Long, Object> vGi;
  public static o<Long, b> vGj;
  public static final h vGk;
  
  static
  {
    AppMethodBeat.i(251994);
    vGk = new h();
    cache = new ConcurrentHashMap();
    vGg = new LinkedList();
    vGh = new ConcurrentHashMap();
    vGi = new ConcurrentHashMap();
    AppMethodBeat.o(251994);
  }
  
  public static FinderItem FH(long paramLong)
  {
    AppMethodBeat.i(251985);
    FinderItem localFinderItem = (FinderItem)cache.get(Long.valueOf(paramLong));
    AppMethodBeat.o(251985);
    return localFinderItem;
  }
  
  public static FinderItem.b FI(long paramLong)
  {
    AppMethodBeat.i(251986);
    Object localObject = (FinderItem)cache.get(Long.valueOf(paramLong));
    if (localObject == null) {
      Log.w("Finder.HotRelatedCache", "[get] feedId=" + d.zs(paramLong) + " config is null.");
    }
    if (localObject != null)
    {
      localObject = ((FinderItem)localObject).getPosTriggerConfig();
      AppMethodBeat.o(251986);
      return localObject;
    }
    AppMethodBeat.o(251986);
    return null;
  }
  
  public static boolean FJ(long paramLong)
  {
    AppMethodBeat.i(251987);
    if (!vGh.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(251987);
      return true;
    }
    AppMethodBeat.o(251987);
    return false;
  }
  
  public static boolean FK(long paramLong)
  {
    AppMethodBeat.i(251988);
    if (!vGi.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(251988);
      return true;
    }
    AppMethodBeat.o(251988);
    return false;
  }
  
  public static void FL(long paramLong)
  {
    AppMethodBeat.i(251989);
    Log.i("Finder.HotRelatedCache", "[markFetchRelatedFeed] feedId=" + d.zs(paramLong));
    ((Map)vGh).put(Long.valueOf(paramLong), new Object());
    AppMethodBeat.o(251989);
  }
  
  public static void FM(long paramLong)
  {
    AppMethodBeat.i(251990);
    Log.i("Finder.HotRelatedCache", "[clearFetchRelatedFeed] feedId=" + d.zs(paramLong));
    vGh.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(251990);
  }
  
  public static void FN(long paramLong)
  {
    AppMethodBeat.i(251991);
    Log.i("Finder.HotRelatedCache", "[markPrefetchRelatedFeed] feedId=" + d.zs(paramLong));
    ((Map)vGi).put(Long.valueOf(paramLong), new Object());
    AppMethodBeat.o(251991);
  }
  
  public static b FO(long paramLong)
  {
    AppMethodBeat.i(251992);
    Object localObject = vGj;
    if ((localObject != null) && (((Number)((o)localObject).first).longValue() == paramLong))
    {
      Log.i("Finder.HotRelatedCache", "[getPrefetchCache] use cache, feedId=" + d.zs(paramLong) + ' ');
      localObject = vGj;
      if (localObject != null)
      {
        localObject = (b)((o)localObject).second;
        AppMethodBeat.o(251992);
        return localObject;
      }
      AppMethodBeat.o(251992);
      return null;
    }
    AppMethodBeat.o(251992);
    return null;
  }
  
  public static void a(bbn parambbn, boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(251993);
    p.h(paramString, "source");
    Object localObject1 = new StringBuilder("[clearPrefetchCache] feedId=");
    Object localObject2 = vGj;
    long l1;
    if (localObject2 != null)
    {
      localObject2 = (Long)((o)localObject2).first;
      if (localObject2 != null)
      {
        l1 = ((Long)localObject2).longValue();
        Log.i("Finder.HotRelatedCache", d.zs(l1) + " source=" + paramString);
        paramString = vGj;
        if (paramString == null) {
          break label232;
        }
        paramString = (b)paramString.second;
        if (paramString == null) {
          break label232;
        }
        paramString = paramString.tUz;
        if (paramString == null) {
          break label232;
        }
        localObject1 = y.vXH;
      }
    }
    label232:
    for (paramString = y.a((List)paramString, BaseFinderFeed.class);; paramString = null)
    {
      if (paramString != null)
      {
        localObject1 = vGj;
        l1 = l2;
        if (localObject1 != null)
        {
          localObject1 = (Long)((o)localObject1).first;
          l1 = l2;
          if (localObject1 != null) {
            l1 = ((Long)localObject1).longValue();
          }
        }
        Log.i("Finder.HotRelatedCache", "[clearPrefetchRelatedFeed] feedId=" + d.zs(l1));
        vGi.remove(Long.valueOf(l1));
        if (paramBoolean)
        {
          localObject1 = y.vXH;
          y.a(4, paramString, parambbn);
        }
      }
      vGj = null;
      AppMethodBeat.o(251993);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public static void b(LongSparseArray<k> paramLongSparseArray)
  {
    AppMethodBeat.i(251982);
    StringBuilder localStringBuilder = new StringBuilder();
    vGg.clear();
    if (paramLongSparseArray != null)
    {
      int i = 0;
      int j = paramLongSparseArray.size();
      while (i < j)
      {
        vGg.add(paramLongSparseArray.valueAt(i));
        localStringBuilder.append(d.zs(paramLongSparseArray.keyAt(i)) + ", ");
        i += 1;
      }
    }
    Log.i("Finder.HotRelatedCache", "[saveTotalExposeMap] ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(251982);
  }
  
  public static void c(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(251984);
    p.h(paramFinderItem, "feed");
    ((Map)cache).put(Long.valueOf(paramLong), paramFinderItem);
    paramFinderItem.setPosTriggerConfig(paramFinderItem.parseJsonOfPosTriggerConfig());
    AppMethodBeat.o(251984);
  }
  
  public static void c(LongSparseArray<k> paramLongSparseArray)
  {
    AppMethodBeat.i(251983);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLongSparseArray != null)
    {
      Iterator localIterator = ((Iterable)vGg).iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        long l = localk.Rrp.lT();
        paramLongSparseArray.append(l, localk);
        localStringBuilder.append(d.zs(l) + ", ");
      }
    }
    Log.i("Finder.HotRelatedCache", "[restoreTotalExposeMap] ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(251983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.h
 * JD-Core Version:    0.7.0.1
 */