package com.tencent.mm.plugin.finder.feed.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.protocal.protobuf.bui;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "", "()V", "backCache", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getBackCache", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "setBackCache", "(Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;)V", "cacheMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getCacheMap", "()Ljava/util/HashMap;", "cacheMap$1", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fromCache", "getFromCache", "setFromCache", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "toCache", "getToCache", "setToCache", "toKey", "", "getToKey", "()J", "setToKey", "(J)V", "addToCacheMap", "", "key", "value", "clearCacheMap", "eraseCacheMap", "getBack", "intent", "Landroid/content/Intent;", "getFrom", "next", "Lkotlin/Function1;", "getFromCacheMap", "passTo", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
{
  private static final ConcurrentHashMap<Long, s> Bgw;
  public static final a BjI;
  public bui Auc;
  public s BjJ;
  public s BjK;
  private s BjL;
  private long BjM;
  final HashMap<String, s> BjN;
  public b lastBuffer;
  
  static
  {
    AppMethodBeat.i(366440);
    BjI = new a((byte)0);
    Bgw = new ConcurrentHashMap();
    AppMethodBeat.o(366440);
  }
  
  public u()
  {
    AppMethodBeat.i(366420);
    this.BjN = new HashMap();
    AppMethodBeat.o(366420);
  }
  
  public final void a(s params, Intent paramIntent)
  {
    AppMethodBeat.i(366447);
    kotlin.g.b.s.u(params, "toCache");
    kotlin.g.b.s.u(paramIntent, "intent");
    this.BjL = params;
    if (this.BjM != 0L) {
      a.nL(this.BjM);
    }
    long l = cn.bDu();
    ((Map)Bgw).put(Long.valueOf(l), params);
    paramIntent.putExtra("LoaderCacheStoreIntentKey", l);
    this.BjM = l;
    AppMethodBeat.o(366447);
  }
  
  public final void a(String paramString, s params)
  {
    AppMethodBeat.i(366453);
    kotlin.g.b.s.u(paramString, "key");
    kotlin.g.b.s.u(params, "value");
    this.BjN.put(paramString, params);
    AppMethodBeat.o(366453);
  }
  
  public final s avZ(String paramString)
  {
    AppMethodBeat.i(366460);
    kotlin.g.b.s.u(paramString, "key");
    paramString = (s)this.BjN.get(paramString);
    AppMethodBeat.o(366460);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore$Companion;", "", "()V", "INTENT_KEY", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getCacheFromIntent", "intent", "Landroid/content/Intent;", "removeCache", "key", "saveCache", "cache", "saveCacheToIntent", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static s as(Intent paramIntent)
    {
      AppMethodBeat.i(365902);
      long l = paramIntent.getLongExtra("LoaderCacheStoreIntentKey", 0L);
      if (l == 0L)
      {
        AppMethodBeat.o(365902);
        return null;
      }
      paramIntent = nL(l);
      AppMethodBeat.o(365902);
      return paramIntent;
    }
    
    static s nL(long paramLong)
    {
      AppMethodBeat.i(365894);
      if (u.edS().containsKey(Long.valueOf(paramLong)))
      {
        s locals = (s)u.edS().remove(Long.valueOf(paramLong));
        AppMethodBeat.o(365894);
        return locals;
      }
      AppMethodBeat.o(365894);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.u
 * JD-Core Version:    0.7.0.1
 */