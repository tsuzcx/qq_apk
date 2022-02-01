package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.af.j;
import com.tencent.mm.plugin.appbrand.config.ag;
import com.tencent.mm.plugin.appbrand.config.ag.d;
import com.tencent.mm.plugin.appbrand.config.ag.e;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader;", "", "()V", "BATCH_PRELOAD_SCENES", "", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync$BatchSyncScene;", "[Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync$BatchSyncScene;", "NULL", "Lkotlin/Function0;", "", "PRELOADING_USERNAME_LIST", "Lcom/tencent/mm/plugin/appbrand/util/LightThreadSafeOneToManyHolder;", "", "QBAR_STRING_PRELOADED_TIMESTAMP", "Ljava/util/concurrent/ConcurrentHashMap;", "", "QBAR_STRING_PRELOAD_INTERVAL_MIN", "TAG", "batchPreloadAttrs", "usernameList", "", "scene", "onSuccess", "checkIfWaitWxaAttrsPreloadDone", "", "username", "block", "notifyPreloadDone", "preloadByQBarRawString", "qbarString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h qIX;
  public static final q.a[] qIY;
  private static final a<ah> qIZ;
  private static final j<String, a<ah>> qJa;
  private static final ConcurrentHashMap<String, Long> qJb;
  private static final long qJc;
  
  static
  {
    AppMethodBeat.i(320513);
    qIX = new h();
    qIY = new q.a[] { q.a.qZy, q.a.qZz, q.a.qZA, q.a.qZB };
    qIZ = (a)h.a.qJd;
    qJa = new j();
    qJb = new ConcurrentHashMap();
    qJc = TimeUnit.MINUTES.toMillis(5L);
    AppMethodBeat.o(320513);
  }
  
  public static void VJ(String paramString)
  {
    AppMethodBeat.i(320484);
    s.u(paramString, "qbarString");
    Long localLong2 = (Long)qJb.get(paramString);
    Long localLong1 = localLong2;
    if (localLong2 == null) {
      localLong1 = Long.valueOf(0L);
    }
    long l = ((Number)localLong1).longValue();
    if (Util.milliSecondsToNow(l) < qJc)
    {
      Log.i("MicroMsg.WxaAttributesBatchPreLoader", "preloadByQBarRawString with qbarString:" + paramString + ", hit interval control, lastPreloadTimestamp:" + l);
      AppMethodBeat.o(320484);
      return;
    }
    ((Map)qJb).put(paramString, Long.valueOf(Util.nowMilliSecond()));
    new e(Util.currentTicks(), paramString).bFJ();
    AppMethodBeat.o(320484);
  }
  
  public static void a(List<String> paramList, q.a parama, final a<ah> parama1)
  {
    AppMethodBeat.i(320490);
    s.u(paramList, "usernameList");
    s.u(parama, "scene");
    s.u(parama1, "onSuccess");
    ag.a(paramList, parama, (ag.d)new c(paramList, parama1)).a(h..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(320490);
  }
  
  private static final void cO(List paramList)
  {
    AppMethodBeat.i(320502);
    Collection localCollection = (Collection)paramList;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        d.B((a)new h.d(paramList));
      }
      AppMethodBeat.o(320502);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader$batchPreloadAttrs$2", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrSyncHelper$WxaAttrBatchSyncListenerEx;", "usernameList", "", "", "done", "", "onRequested", "requestedUsernameList", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ag.e
  {
    private List<String> maB;
    
    c(List<String> paramList, a<ah> parama) {}
    
    public final void cQ(List<String> paramList)
    {
      AppMethodBeat.i(320392);
      if (paramList == null) {
        paramList = (List)ab.aivy;
      }
      for (;;)
      {
        this.maB = ((List)new LinkedList((Collection)paramList));
        paramList = ((Iterable)this.qJf).iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          h.chr().v(str, h.chs());
        }
        AppMethodBeat.o(320392);
        return;
      }
    }
    
    public final void done()
    {
      AppMethodBeat.i(320396);
      h localh = h.qIX;
      h.cP(this.qJf);
      parama1.invoke();
      AppMethodBeat.o(320396);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appcache/predownload/WxaAttributesBatchPreLoader$preloadByQBarRawString$1", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends q
  {
    e(long paramLong, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.h
 * JD-Core Version:    0.7.0.1
 */