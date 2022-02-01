package com.tencent.mm.plugin.finder.feed.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.protocal.protobuf.bid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "", "()V", "backCache", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getBackCache", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "setBackCache", "(Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;)V", "cacheMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getCacheMap", "()Ljava/util/HashMap;", "cacheMap$1", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fromCache", "getFromCache", "setFromCache", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "toCache", "getToCache", "setToCache", "toKey", "", "getToKey", "()J", "setToKey", "(J)V", "addToCacheMap", "", "key", "value", "clearCacheMap", "eraseCacheMap", "getBack", "intent", "Landroid/content/Intent;", "getFrom", "next", "Lkotlin/Function1;", "getFromCacheMap", "passTo", "Companion", "plugin-finder-base_release"})
public final class s
{
  private static final ConcurrentHashMap<Long, q> xHs;
  public static final a xKa;
  public b lastBuffer;
  public q xJV;
  public q xJW;
  private q xJX;
  private long xJY;
  final HashMap<String, q> xJZ;
  public bid xbu;
  
  static
  {
    AppMethodBeat.i(259175);
    xKa = new a((byte)0);
    xHs = new ConcurrentHashMap();
    AppMethodBeat.o(259175);
  }
  
  public s()
  {
    AppMethodBeat.i(259174);
    this.xJZ = new HashMap();
    AppMethodBeat.o(259174);
  }
  
  public final void a(q paramq, Intent paramIntent)
  {
    AppMethodBeat.i(259169);
    p.k(paramq, "toCache");
    p.k(paramIntent, "intent");
    this.xJX = paramq;
    if (this.xJY != 0L) {
      a.La(this.xJY);
    }
    long l = cm.bfC();
    ((Map)xHs).put(Long.valueOf(l), paramq);
    paramIntent.putExtra("LoaderCacheStoreIntentKey", l);
    this.xJY = l;
    AppMethodBeat.o(259169);
  }
  
  public final void a(String paramString, q paramq)
  {
    AppMethodBeat.i(259171);
    p.k(paramString, "key");
    p.k(paramq, "value");
    this.xJZ.put(paramString, paramq);
    AppMethodBeat.o(259171);
  }
  
  public final q aBJ(String paramString)
  {
    AppMethodBeat.i(259172);
    p.k(paramString, "key");
    paramString = (q)this.xJZ.get(paramString);
    AppMethodBeat.o(259172);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore$Companion;", "", "()V", "INTENT_KEY", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getCacheFromIntent", "intent", "Landroid/content/Intent;", "removeCache", "key", "saveCache", "cache", "saveCacheToIntent", "plugin-finder-base_release"})
  public static final class a
  {
    static q La(long paramLong)
    {
      AppMethodBeat.i(261421);
      if (s.dus().containsKey(Long.valueOf(paramLong)))
      {
        q localq = (q)s.dus().remove(Long.valueOf(paramLong));
        AppMethodBeat.o(261421);
        return localq;
      }
      AppMethodBeat.o(261421);
      return null;
    }
    
    public static q ai(Intent paramIntent)
    {
      AppMethodBeat.i(261423);
      long l = paramIntent.getLongExtra("LoaderCacheStoreIntentKey", 0L);
      if (l == 0L)
      {
        AppMethodBeat.o(261423);
        return null;
      }
      paramIntent = La(l);
      AppMethodBeat.o(261423);
      return paramIntent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.s
 * JD-Core Version:    0.7.0.1
 */