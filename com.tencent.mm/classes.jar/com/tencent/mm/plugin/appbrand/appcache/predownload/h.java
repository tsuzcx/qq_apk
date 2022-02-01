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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader;", "", "()V", "BATCH_PRELOAD_SCENES", "", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync$BatchSyncScene;", "[Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync$BatchSyncScene;", "NULL", "Lkotlin/Function0;", "", "PRELOADING_USERNAME_LIST", "Lcom/tencent/mm/plugin/appbrand/util/LightThreadSafeOneToManyHolder;", "", "QBAR_STRING_PRELOADED_TIMESTAMP", "Ljava/util/concurrent/ConcurrentHashMap;", "", "QBAR_STRING_PRELOAD_INTERVAL_MIN", "TAG", "batchPreloadAttrs", "usernameList", "", "scene", "onSuccess", "checkIfWaitWxaAttrsPreloadDone", "", "username", "block", "notifyPreloadDone", "preloadByQBarRawString", "qbarString", "plugin-appbrand-integration_release"})
public final class h
{
  public static final o.a[] kPj;
  private static final a<x> kPk;
  private static final com.tencent.mm.plugin.appbrand.ac.h<String, a<x>> kPl;
  private static final ConcurrentHashMap<String, Long> kPm;
  private static final long kPn;
  public static final h kPo;
  
  static
  {
    AppMethodBeat.i(228030);
    kPo = new h();
    kPj = new o.a[] { o.a.lfd, o.a.lfe, o.a.lff, o.a.lfg };
    kPk = (a)h.a.kPp;
    kPl = new com.tencent.mm.plugin.appbrand.ac.h();
    kPm = new ConcurrentHashMap();
    kPn = TimeUnit.MINUTES.toMillis(5L);
    AppMethodBeat.o(228030);
  }
  
  public static void VE(final String paramString)
  {
    AppMethodBeat.i(228027);
    p.h(paramString, "qbarString");
    Long localLong2 = (Long)kPm.get(paramString);
    Long localLong1 = localLong2;
    if (localLong2 == null) {
      localLong1 = Long.valueOf(0L);
    }
    p.g(localLong1, "QBAR_STRING_PRELOADED_TIMESTAMP[qbarString] ?: 0L");
    long l = localLong1.longValue();
    if (Util.milliSecondsToNow(l) < kPn)
    {
      Log.i("MicroMsg.WxaAttributesBatchPreLoader", "preloadByQBarRawString with qbarString:" + paramString + ", hit interval control, lastPreloadTimestamp:" + l);
      AppMethodBeat.o(228027);
      return;
    }
    ((Map)kPm).put(paramString, Long.valueOf(Util.nowMilliSecond()));
    new e(Util.currentTicks(), paramString, paramString).aYI();
    AppMethodBeat.o(228027);
  }
  
  public static void a(List<String> paramList, o.a parama, final a<x> parama1)
  {
    AppMethodBeat.i(228028);
    p.h(paramList, "usernameList");
    p.h(parama, "scene");
    p.h(parama1, "onSuccess");
    aa.a(paramList, parama, (aa.d)new c(paramList, parama1)).a((d.b)d.kPt);
    AppMethodBeat.o(228028);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader$batchPreloadAttrs$2", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrSyncHelper$WxaAttrBatchSyncListenerEx;", "usernameList", "", "", "done", "", "onRequested", "requestedUsernameList", "plugin-appbrand-integration_release"})
  public static final class c
    implements aa.e
  {
    private List<String> gMT;
    
    c(List paramList, a parama) {}
    
    public final void bj(List<String> paramList)
    {
      AppMethodBeat.i(228021);
      if (paramList == null) {
        paramList = (List)v.SXr;
      }
      for (;;)
      {
        this.gMT = ((List)new LinkedList((Collection)paramList));
        paramList = ((Iterable)this.kPr).iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          Object localObject = h.kPo;
          localObject = h.bwO();
          h localh = h.kPo;
          ((com.tencent.mm.plugin.appbrand.ac.h)localObject).r(str, h.bwP());
        }
        AppMethodBeat.o(228021);
        return;
      }
    }
    
    public final void done()
    {
      AppMethodBeat.i(228022);
      h localh = h.kPo;
      h.bi(this.kPr);
      parama1.invoke();
      AppMethodBeat.o(228022);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "updatedList", "", "", "kotlin.jvm.PlatformType", "", "onTerminate"})
  static final class d<T>
    implements d.b<List<String>>
  {
    public static final d kPt;
    
    static
    {
      AppMethodBeat.i(228025);
      kPt = new d();
      AppMethodBeat.o(228025);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader$preloadByQBarRawString$1", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"})
  public static final class e
    extends o
  {
    e(long paramLong, String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.h
 * JD-Core Version:    0.7.0.1
 */