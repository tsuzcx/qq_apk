package com.tencent.mm.plugin.finder.feed.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.aqy;
import d.g.b.p;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "", "()V", "backCache", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getBackCache", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "setBackCache", "(Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fromCache", "getFromCache", "setFromCache", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "toCache", "getToCache", "setToCache", "toKey", "", "getToKey", "()J", "setToKey", "(J)V", "getBack", "", "intent", "Landroid/content/Intent;", "getFrom", "next", "Lkotlin/Function1;", "passTo", "Companion", "plugin-finder_release"})
public final class f
{
  private static final ConcurrentHashMap<Long, e> scx;
  public static final a scy;
  b lastBuffer;
  aqy rIl;
  e sct;
  e scu;
  private e scv;
  private long scw;
  
  static
  {
    AppMethodBeat.i(202515);
    scy = new a((byte)0);
    scx = new ConcurrentHashMap();
    AppMethodBeat.o(202515);
  }
  
  public final void a(e parame, Intent paramIntent)
  {
    AppMethodBeat.i(202514);
    p.h(parame, "toCache");
    p.h(paramIntent, "intent");
    this.scv = parame;
    if (this.scw != 0L) {
      a.wj(this.scw);
    }
    this.scw = a.a(paramIntent, parame);
    AppMethodBeat.o(202514);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore$Companion;", "", "()V", "INTENT_KEY", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getCacheFromIntent", "intent", "Landroid/content/Intent;", "removeCache", "key", "saveCache", "cache", "saveCacheToIntent", "plugin-finder_release"})
  public static final class a
  {
    static long a(Intent paramIntent, e parame)
    {
      AppMethodBeat.i(202511);
      long l = cf.aCK();
      ((Map)f.cBV()).put(Long.valueOf(l), parame);
      paramIntent.putExtra("LoaderCacheStoreIntentKey", l);
      AppMethodBeat.o(202511);
      return l;
    }
    
    static e aj(Intent paramIntent)
    {
      AppMethodBeat.i(202512);
      long l = paramIntent.getLongExtra("LoaderCacheStoreIntentKey", 0L);
      if (l == 0L)
      {
        AppMethodBeat.o(202512);
        return null;
      }
      paramIntent = wj(l);
      AppMethodBeat.o(202512);
      return paramIntent;
    }
    
    static e wj(long paramLong)
    {
      AppMethodBeat.i(202510);
      if (f.cBV().containsKey(Long.valueOf(paramLong)))
      {
        e locale = (e)f.cBV().remove(Long.valueOf(paramLong));
        AppMethodBeat.o(202510);
        return locale;
      }
      AppMethodBeat.o(202510);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.f
 * JD-Core Version:    0.7.0.1
 */