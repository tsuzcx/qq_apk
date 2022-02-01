package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.aa.d;
import com.tencent.mm.plugin.appbrand.config.aa.e;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.config.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.a.v;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader;", "", "()V", "BATCH_PRELOAD_SCENES", "", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync$BatchSyncScene;", "[Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync$BatchSyncScene;", "NULL", "Lkotlin/Function0;", "", "PRELOADING_USERNAME_LIST", "Lcom/tencent/mm/plugin/appbrand/util/LightThreadSafeOneToManyHolder;", "", "QBAR_STRING_PRELOADED_TIMESTAMP", "Ljava/util/concurrent/ConcurrentHashMap;", "", "QBAR_STRING_PRELOAD_INTERVAL_MIN", "TAG", "batchPreloadAttrs", "usernameList", "", "scene", "onSuccess", "checkIfWaitWxaAttrsPreloadDone", "", "username", "block", "notifyPreloadDone", "preloadByQBarRawString", "qbarString", "plugin-appbrand-integration_release"})
public final class h
{
  public static final o.a[] nJp;
  private static final a<x> nJq;
  private static final com.tencent.mm.plugin.appbrand.ac.h<String, a<x>> nJr;
  private static final ConcurrentHashMap<String, Long> nJs;
  private static final long nJt;
  public static final h nJu;
  
  static
  {
    AppMethodBeat.i(279549);
    nJu = new h();
    nJp = new o.a[] { o.a.nZq, o.a.nZr, o.a.nZs, o.a.nZt };
    nJq = (a)h.a.nJv;
    nJr = new com.tencent.mm.plugin.appbrand.ac.h();
    nJs = new ConcurrentHashMap();
    nJt = TimeUnit.MINUTES.toMillis(5L);
    AppMethodBeat.o(279549);
  }
  
  public static void a(List<String> paramList, o.a parama, final a<x> parama1)
  {
    AppMethodBeat.i(279547);
    p.k(paramList, "usernameList");
    p.k(parama, "scene");
    p.k(parama1, "onSuccess");
    aa.a(paramList, parama, (aa.d)new c(paramList, parama1)).a((d.b)h.d.nJz);
    AppMethodBeat.o(279547);
  }
  
  public static void adn(final String paramString)
  {
    AppMethodBeat.i(279545);
    p.k(paramString, "qbarString");
    Long localLong2 = (Long)nJs.get(paramString);
    Long localLong1 = localLong2;
    if (localLong2 == null) {
      localLong1 = Long.valueOf(0L);
    }
    p.j(localLong1, "QBAR_STRING_PRELOADED_TIMESTAMP[qbarString] ?: 0L");
    long l = localLong1.longValue();
    if (Util.milliSecondsToNow(l) < nJt)
    {
      Log.i("MicroMsg.WxaAttributesBatchPreLoader", "preloadByQBarRawString with qbarString:" + paramString + ", hit interval control, lastPreloadTimestamp:" + l);
      AppMethodBeat.o(279545);
      return;
    }
    ((Map)nJs).put(paramString, Long.valueOf(Util.nowMilliSecond()));
    new e(Util.currentTicks(), paramString, paramString).bhW();
    AppMethodBeat.o(279545);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    public static final b nJw;
    
    static
    {
      AppMethodBeat.i(247716);
      nJw = new b();
      AppMethodBeat.o(247716);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader$batchPreloadAttrs$2", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrSyncHelper$WxaAttrBatchSyncListenerEx;", "usernameList", "", "", "done", "", "onRequested", "requestedUsernameList", "plugin-appbrand-integration_release"})
  public static final class c
    implements aa.e
  {
    private List<String> jxh;
    
    c(List paramList, a parama) {}
    
    public final void bh(List<String> paramList)
    {
      AppMethodBeat.i(266126);
      if (paramList == null) {
        paramList = (List)v.aaAd;
      }
      for (;;)
      {
        this.jxh = ((List)new LinkedList((Collection)paramList));
        paramList = ((Iterable)this.nJx).iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          Object localObject = h.nJu;
          localObject = h.bHV();
          h localh = h.nJu;
          ((com.tencent.mm.plugin.appbrand.ac.h)localObject).k(str, h.bHW());
        }
        AppMethodBeat.o(266126);
        return;
      }
    }
    
    public final void done()
    {
      AppMethodBeat.i(266129);
      h localh = h.nJu;
      h.bg(this.nJx);
      parama1.invoke();
      AppMethodBeat.o(266129);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader$preloadByQBarRawString$1", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"})
  public static final class e
    extends o
  {
    e(long paramLong, String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.h
 * JD-Core Version:    0.7.0.1
 */