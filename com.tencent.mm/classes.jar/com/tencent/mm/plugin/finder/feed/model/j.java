package com.tencent.mm.plugin.finder.feed.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.bbn;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "", "()V", "backCache", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getBackCache", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "setBackCache", "(Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;)V", "cacheMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getCacheMap", "()Ljava/util/HashMap;", "cacheMap$1", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fromCache", "getFromCache", "setFromCache", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "toCache", "getToCache", "setToCache", "toKey", "", "getToKey", "()J", "setToKey", "(J)V", "addToCacheMap", "", "key", "value", "clearCacheMap", "eraseCacheMap", "getBack", "intent", "Landroid/content/Intent;", "getFrom", "next", "Lkotlin/Function1;", "getFromCacheMap", "passTo", "Companion", "plugin-finder_release"})
public final class j
{
  private static final ConcurrentHashMap<Long, h> tVA;
  public static final a tYb;
  public b lastBuffer;
  public h tXW;
  public h tXX;
  private h tXY;
  private long tXZ;
  final HashMap<String, h> tYa;
  public bbn ttO;
  
  static
  {
    AppMethodBeat.i(244947);
    tYb = new a((byte)0);
    tVA = new ConcurrentHashMap();
    AppMethodBeat.o(244947);
  }
  
  public j()
  {
    AppMethodBeat.i(244946);
    this.tYa = new HashMap();
    AppMethodBeat.o(244946);
  }
  
  public final void a(h paramh, Intent paramIntent)
  {
    AppMethodBeat.i(244945);
    p.h(paramh, "toCache");
    p.h(paramIntent, "intent");
    this.tXY = paramh;
    if (this.tXZ != 0L) {
      a.EG(this.tXZ);
    }
    long l = cl.aWy();
    ((Map)tVA).put(Long.valueOf(l), paramh);
    paramIntent.putExtra("LoaderCacheStoreIntentKey", l);
    this.tXZ = l;
    AppMethodBeat.o(244945);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore$Companion;", "", "()V", "INTENT_KEY", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getCacheFromIntent", "intent", "Landroid/content/Intent;", "removeCache", "key", "saveCache", "cache", "saveCacheToIntent", "plugin-finder_release"})
  public static final class a
  {
    static h EG(long paramLong)
    {
      AppMethodBeat.i(244942);
      if (j.ddz().containsKey(Long.valueOf(paramLong)))
      {
        h localh = (h)j.ddz().remove(Long.valueOf(paramLong));
        AppMethodBeat.o(244942);
        return localh;
      }
      AppMethodBeat.o(244942);
      return null;
    }
    
    public static h al(Intent paramIntent)
    {
      AppMethodBeat.i(244943);
      long l = paramIntent.getLongExtra("LoaderCacheStoreIntentKey", 0L);
      if (l == 0L)
      {
        AppMethodBeat.o(244943);
        return null;
      }
      paramIntent = EG(l);
      AppMethodBeat.o(244943);
      return paramIntent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.j
 * JD-Core Version:    0.7.0.1
 */