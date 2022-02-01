package com.tencent.mm.plugin.finder.feed.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.ch;
import com.tencent.mm.protocal.protobuf.arn;
import d.g.b.p;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "", "()V", "backCache", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getBackCache", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "setBackCache", "(Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fromCache", "getFromCache", "setFromCache", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "toCache", "getToCache", "setToCache", "toKey", "", "getToKey", "()J", "setToKey", "(J)V", "getBack", "", "intent", "Landroid/content/Intent;", "getFrom", "next", "Lkotlin/Function1;", "passTo", "Companion", "plugin-finder_release"})
public final class f
{
  private static final ConcurrentHashMap<Long, e> slo;
  public static final a slp;
  b lastBuffer;
  arn rQw;
  e slk;
  e sll;
  private e slm;
  private long sln;
  
  static
  {
    AppMethodBeat.i(202991);
    slp = new a((byte)0);
    slo = new ConcurrentHashMap();
    AppMethodBeat.o(202991);
  }
  
  public final void a(e parame, Intent paramIntent)
  {
    AppMethodBeat.i(202990);
    p.h(parame, "toCache");
    p.h(paramIntent, "intent");
    this.slm = parame;
    if (this.sln != 0L) {
      a.wz(this.sln);
    }
    this.sln = a.a(paramIntent, parame);
    AppMethodBeat.o(202990);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore$Companion;", "", "()V", "INTENT_KEY", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getCacheFromIntent", "intent", "Landroid/content/Intent;", "removeCache", "key", "saveCache", "cache", "saveCacheToIntent", "plugin-finder_release"})
  public static final class a
  {
    static long a(Intent paramIntent, e parame)
    {
      AppMethodBeat.i(202987);
      long l = ch.aDa();
      ((Map)f.cDH()).put(Long.valueOf(l), parame);
      paramIntent.putExtra("LoaderCacheStoreIntentKey", l);
      AppMethodBeat.o(202987);
      return l;
    }
    
    static e ak(Intent paramIntent)
    {
      AppMethodBeat.i(202988);
      long l = paramIntent.getLongExtra("LoaderCacheStoreIntentKey", 0L);
      if (l == 0L)
      {
        AppMethodBeat.o(202988);
        return null;
      }
      paramIntent = wz(l);
      AppMethodBeat.o(202988);
      return paramIntent;
    }
    
    static e wz(long paramLong)
    {
      AppMethodBeat.i(202986);
      if (f.cDH().containsKey(Long.valueOf(paramLong)))
      {
        e locale = (e)f.cDH().remove(Long.valueOf(paramLong));
        AppMethodBeat.o(202986);
        return locale;
      }
      AppMethodBeat.o(202986);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.f
 * JD-Core Version:    0.7.0.1
 */