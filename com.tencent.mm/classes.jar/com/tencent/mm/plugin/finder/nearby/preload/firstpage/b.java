package com.tencent.mm.plugin.finder.nearby.preload.firstpage;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader.b;
import com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader.c;
import com.tencent.mm.plugin.finder.nearby.live.c.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/NearbyLiveFirstPagePreload;", "Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/FirstPagePreload;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "pullType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;I)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "preloadCacheManager", "Lcom/tencent/mm/plugin/finder/nearby/preload/cache/PreloadCacheManager;", "getPullType", "()I", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "checkIfStartPreload", "", "fetchFirstPage", "", "request", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "fetchInternal", "getCommentScene", "initFinderReportContextObj", "intent", "Landroid/content/Intent;", "initTag", "isValidPreloadInterval", "onFetchDone", "rsp", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsResponse;", "recordLastPreloadTimeStamp", "requestCache", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "startPreload", "Companion", "plugin-finder-nearby_release"})
public final class b
  extends a<IResponse<bu>>
  implements c.a
{
  private static int zIM;
  public static final a zIN;
  private final int pullType;
  private bid xbu;
  private final bcz zDU;
  private final com.tencent.mm.plugin.finder.nearby.preload.cache.a zIL;
  
  static
  {
    AppMethodBeat.i(200584);
    zIN = new a((byte)0);
    zIM = -1;
    AppMethodBeat.o(200584);
  }
  
  public b(bcz parambcz, int paramInt)
  {
    AppMethodBeat.i(200583);
    this.zDU = parambcz;
    this.pullType = paramInt;
    this.zIL = new com.tencent.mm.plugin.finder.nearby.preload.cache.a();
    AppMethodBeat.o(200583);
  }
  
  private final void dMw()
  {
    AppMethodBeat.i(200558);
    setTAG(getTAG() + "_@" + this.zDU.SOa + "-" + this.zDU.SOb);
    AppMethodBeat.o(200558);
  }
  
  private static int getCommentScene()
  {
    AppMethodBeat.i(200582);
    int i = ((com.tencent.c.a.b.a.d)com.tencent.mm.kernel.h.ag(com.tencent.c.a.b.a.d.class)).getTargetCommentScene(94);
    AppMethodBeat.o(200582);
    return i;
  }
  
  public final void a(NearbyLiveFeedLoader.c paramc, NearbyLiveFeedLoader.b paramb)
  {
    AppMethodBeat.i(200581);
    p.k(paramc, "rsp");
    p.k(paramb, "request");
    Log.i(getTAG(), "onSceneEnd errType:" + paramc.getErrType() + ' ' + "errCode:" + paramc.getErrCode() + " errMsg:" + paramc.getErrMsg() + " rsp:" + paramc.getIncrementList());
    dMr().aGV("onFetchDone");
    a(new com.tencent.mm.plugin.findersdk.b.h(paramc.getErrType(), paramc.getErrCode(), paramc.getErrMsg(), paramc, SystemClock.elapsedRealtime()));
    com.tencent.mm.plugin.finder.nearby.preload.cache.a locala = this.zIL;
    int i = paramb.zDV;
    paramb = (ArrayList)paramc.getIncrementList();
    com.tencent.mm.cd.b localb = paramc.getLastBuffer();
    int j;
    if (paramb == null)
    {
      Log.i("PreloadCacheManager", "store memoryCacheFlag:" + i + " return for dataList is null.");
      zIM = paramc.zEb * 1000;
      i = this.pullType;
      paramc = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
      getCommentScene();
      j = com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ou(this.zDU.SOa);
      switch (i)
      {
      }
    }
    for (;;)
    {
      a(dMq(), (kotlin.g.a.a)c.zIO);
      AppMethodBeat.o(200581);
      return;
      Log.i("PreloadCacheManager", "store memoryCacheFlag:" + i + " dataList:" + paramb.size() + " lastBuffer:" + localb);
      com.tencent.mm.plugin.finder.viewmodel.b.a(locala.tlCache, i, 0, 0, paramb, null, localb, true, 16);
      locala.tlCache.RH(i);
      break;
      this.zIL.a(j, SystemClock.elapsedRealtime(), 0L, 0L);
      continue;
      this.zIL.a(j, 0L, SystemClock.elapsedRealtime(), 0L);
      continue;
      this.zIL.a(j, 0L, 0L, SystemClock.elapsedRealtime());
    }
  }
  
  public final void aq(Intent paramIntent)
  {
    AppMethodBeat.i(200565);
    p.k(paramIntent, "intent");
    dMw();
    this.xbu = new bid();
    Object localObject1 = this.xbu;
    if (localObject1 == null) {
      p.bGy("contextObj");
    }
    Object localObject2 = new StringBuilder();
    com.tencent.mm.plugin.finder.nearby.d locald = com.tencent.mm.plugin.finder.nearby.d.zCK;
    ((bid)localObject1).wmz = (com.tencent.mm.plugin.finder.nearby.d.dLl() + "-" + cm.bfE());
    localObject1 = this.xbu;
    if (localObject1 == null) {
      p.bGy("contextObj");
    }
    localObject2 = com.tencent.mm.plugin.finder.nearby.d.zCK;
    ((bid)localObject1).xkX = com.tencent.mm.plugin.finder.nearby.d.get3TabTargetTabCommentScene();
    localObject2 = this.xbu;
    if (localObject2 == null) {
      p.bGy("contextObj");
    }
    localObject1 = paramIntent.getStringExtra("key_context_id");
    paramIntent = (Intent)localObject1;
    if (localObject1 == null)
    {
      paramIntent = n.zWF;
      paramIntent = n.dPD();
    }
    ((bid)localObject2).wmL = paramIntent;
    localObject2 = this.xbu;
    if (localObject2 == null) {
      p.bGy("contextObj");
    }
    localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    paramIntent = (Intent)localObject1;
    if (localObject1 == null) {
      paramIntent = "";
    }
    ((bid)localObject2).sessionId = paramIntent;
    paramIntent = this.xbu;
    if (paramIntent == null) {
      p.bGy("contextObj");
    }
    paramIntent.BmS = "";
    paramIntent = this.xbu;
    if (paramIntent == null) {
      p.bGy("contextObj");
    }
    paramIntent.extraInfo = "";
    paramIntent = this.xbu;
    if (paramIntent == null) {
      p.bGy("contextObj");
    }
    paramIntent.wmC = "";
    AppMethodBeat.o(200565);
  }
  
  public final void d(bid parambid)
  {
    AppMethodBeat.i(200560);
    p.k(parambid, "contextObj");
    dMw();
    this.xbu = parambid;
    AppMethodBeat.o(200560);
  }
  
  public final void dMs()
  {
    int j = 0;
    AppMethodBeat.i(200568);
    Object localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    getCommentScene();
    int i = com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ou(this.zDU.SOa);
    localObject = com.tencent.mm.plugin.finder.nearby.preload.cache.a.Oz(i);
    g localg = g.Xox;
    boolean bool;
    if (!((com.tencent.mm.plugin.finder.viewmodel.b)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).OO(i))
    {
      bool = true;
      Log.i(getTAG(), "checkIfStartPreload isPreload:" + ((com.tencent.mm.plugin.finder.viewmodel.b.a)localObject).BgC + " isValidData:" + bool);
      if ((!bool) || (!((com.tencent.mm.plugin.finder.viewmodel.b.a)localObject).BgC)) {
        break label145;
      }
    }
    label145:
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        break label150;
      }
      Log.w(getTAG(), "startPreload return for checkIfStartPreload.");
      AppMethodBeat.o(200568);
      return;
      bool = false;
      break;
    }
    label150:
    i = this.pullType;
    localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    getCommentScene();
    int k = com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ou(this.zDU.SOa);
    long l;
    switch (i)
    {
    default: 
      l = SystemClock.elapsedRealtime();
      if (zIM == 0)
      {
        Log.i(getTAG(), "isValidPreloadInterval return false for server PRELOAD_INTERVAL_MS:" + zIM);
        i = j;
      }
      break;
    }
    for (;;)
    {
      if (i != 0) {
        break label391;
      }
      Log.w(getTAG(), "startPreload return for isValidPreloadInterval.");
      AppMethodBeat.o(200568);
      return;
      l = this.zIL.OB(k).BgD;
      break;
      l = this.zIL.OB(k).BgE;
      break;
      l = this.zIL.OB(k).BgF;
      break;
      if ((zIM != -1) && (l != 0L))
      {
        l = SystemClock.elapsedRealtime() - l;
        if (l < zIM)
        {
          Log.i(getTAG(), "isValidPreloadInterval return false for interval:" + l + " < PRELOAD_INTERVAL_MS:" + zIM);
          i = j;
          continue;
        }
      }
      i = 1;
    }
    label391:
    localObject = com.tencent.mm.plugin.finder.nearby.live.base.a.zEO;
    if (!com.tencent.mm.plugin.finder.nearby.live.base.a.a("startPreload first page", this.zDU))
    {
      Log.w(getTAG(), "startPreload return for hit nearby city tab.");
      AppMethodBeat.o(200568);
      return;
    }
    super.dMs();
    AppMethodBeat.o(200568);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.h<IResponse<bu>> dMt()
  {
    AppMethodBeat.i(200572);
    com.tencent.mm.plugin.findersdk.b.h localh = super.dMt();
    if (localh != null) {
      new com.tencent.mm.plugin.finder.cgi.h(2, ((IResponse)localh.BvG).getLastBuffer()).bhW();
    }
    AppMethodBeat.o(200572);
    return localh;
  }
  
  public final void dMu()
  {
    AppMethodBeat.i(200578);
    dMr().aGV("fetchInternal");
    Object localObject1 = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    getCommentScene();
    int i = com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ou(this.zDU.SOa);
    int j = this.zDU.SOa;
    localObject1 = new NearbyLiveFeedLoader.b(this.pullType, this.zDU, i, j + 1001, getCommentScene());
    ab.c localc = (ab.c)new b();
    Object localObject2 = com.tencent.mm.plugin.finder.nearby.trace.b.zJB;
    com.tencent.mm.plugin.finder.nearby.trace.b.a.OL(((NearbyLiveFeedLoader.b)localObject1).zDV).zJv = System.currentTimeMillis();
    localObject2 = this.xbu;
    if (localObject2 == null) {
      p.bGy("contextObj");
    }
    new com.tencent.mm.plugin.finder.nearby.live.c((bid)localObject2).a((NearbyLiveFeedLoader.b)localObject1, (c.a)this, localc);
    Log.i(getTAG(), "fetchInternal request:".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(200578);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/NearbyLiveFirstPagePreload$Companion;", "", "()V", "PRELOAD_INTERVAL_MS", "", "getPRELOAD_INTERVAL_MS", "()I", "setPRELOAD_INTERVAL_MS", "(I)V", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/preload/firstpage/NearbyLiveFirstPagePreload$fetchInternal$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder-nearby_release"})
  public static final class b
    implements ab.c
  {
    public final boolean b(dyy paramdyy)
    {
      AppMethodBeat.i(201961);
      p.k(paramdyy, "resp");
      AppMethodBeat.o(201961);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final c zIO;
    
    static
    {
      AppMethodBeat.i(202600);
      zIO = new c();
      AppMethodBeat.o(202600);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.firstpage.b
 * JD-Core Version:    0.7.0.1
 */