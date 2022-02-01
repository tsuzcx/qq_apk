package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.config.n.a;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.config.x.c;
import com.tencent.mm.plugin.appbrand.config.x.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import d.a.v;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader;", "", "()V", "NULL", "Lkotlin/Function0;", "", "PRELOADING_USERNAME_LIST", "Lcom/tencent/mm/plugin/appbrand/util/LightThreadSafeOneToManyHolder;", "", "QBAR_STRING_PRELOADED_TIMESTAMP", "Ljava/util/concurrent/ConcurrentHashMap;", "", "QBAR_STRING_PRELOAD_INTERVAL_MIN", "TAG", "batchPreloadAttrs", "usernameList", "", "scene", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync$BatchSyncScene;", "onSuccess", "checkIfWaitWxaAttrsPreloadDone", "", "username", "block", "notifyPreloadDone", "preloadByQBarRawString", "qbarString", "plugin-appbrand-integration_release"})
public final class h
{
  private static final a<z> jNc;
  private static final com.tencent.mm.plugin.appbrand.y.h<String, a<z>> jNd;
  private static final ConcurrentHashMap<String, Long> jNe;
  private static final long jNf;
  public static final h jNg;
  
  static
  {
    AppMethodBeat.i(223238);
    jNg = new h();
    jNc = (a)h.a.jNh;
    jNd = new com.tencent.mm.plugin.appbrand.y.h();
    jNe = new ConcurrentHashMap();
    jNf = TimeUnit.MINUTES.toMillis(5L);
    AppMethodBeat.o(223238);
  }
  
  public static void Mw(final String paramString)
  {
    AppMethodBeat.i(223235);
    p.h(paramString, "qbarString");
    Long localLong2 = (Long)jNe.get(paramString);
    Long localLong1 = localLong2;
    if (localLong2 == null) {
      localLong1 = Long.valueOf(0L);
    }
    p.g(localLong1, "QBAR_STRING_PRELOADED_TIMESTAMP[qbarString] ?: 0L");
    long l = localLong1.longValue();
    if (bu.DD(l) < jNf)
    {
      ae.i("MicroMsg.WxaAttributesBatchPreLoader", "preloadByQBarRawString with qbarString:" + paramString + ", hit interval control, lastPreloadTimestamp:" + l);
      AppMethodBeat.o(223235);
      return;
    }
    ((Map)jNe).put(paramString, Long.valueOf(bu.fpO()));
    new e(bu.HQ(), paramString, paramString).aET();
    AppMethodBeat.o(223235);
  }
  
  public static void a(List<String> paramList, n.a parama, a<z> parama1)
  {
    AppMethodBeat.i(223236);
    p.h(paramList, "usernameList");
    p.h(parama, "scene");
    p.h(parama1, "onSuccess");
    x.a(paramList, parama, (x.c)new c(paramList)).a((d.b)d.jNk);
    AppMethodBeat.o(223236);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    public static final b jNi;
    
    static
    {
      AppMethodBeat.i(223228);
      jNi = new b();
      AppMethodBeat.o(223228);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader$batchPreloadAttrs$2", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrSyncHelper$WxaAttrBatchSyncListenerEx;", "usernameList", "", "", "done", "", "onRequested", "requestedUsernameList", "plugin-appbrand-integration_release"})
  public static final class c
    implements x.d
  {
    private List<String> ghn;
    
    c(List paramList) {}
    
    public final void aY(List<String> paramList)
    {
      AppMethodBeat.i(223229);
      if (paramList == null) {
        paramList = (List)v.NhH;
      }
      for (;;)
      {
        this.ghn = ((List)new LinkedList((Collection)paramList));
        paramList = ((Iterable)this.jNj).iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          Object localObject = h.jNg;
          localObject = h.bbB();
          h localh = h.jNg;
          ((com.tencent.mm.plugin.appbrand.y.h)localObject).j(str, h.bbC());
        }
        AppMethodBeat.o(223229);
        return;
      }
    }
    
    public final void done()
    {
      AppMethodBeat.i(223230);
      h localh = h.jNg;
      h.aX(this.jNj);
      AppMethodBeat.o(223230);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "updatedList", "", "", "kotlin.jvm.PlatformType", "", "onTerminate"})
  static final class d<T>
    implements d.b<List<String>>
  {
    public static final d jNk;
    
    static
    {
      AppMethodBeat.i(223233);
      jNk = new d();
      AppMethodBeat.o(223233);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader$preloadByQBarRawString$1", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"})
  public static final class e
    extends n
  {
    e(long paramLong, String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.h
 * JD-Core Version:    0.7.0.1
 */