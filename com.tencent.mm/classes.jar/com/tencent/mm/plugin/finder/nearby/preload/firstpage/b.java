package com.tencent.mm.plugin.finder.nearby.preload.firstpage;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader.c;
import com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader.d;
import com.tencent.mm.plugin.finder.nearby.live.c.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.n;
import com.tencent.mm.plugin.finder.viewmodel.n.a;
import com.tencent.mm.plugin.finder.viewmodel.n.c;
import com.tencent.mm.plugin.findersdk.b.i;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/NearbyLiveFirstPagePreload;", "Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/FirstPagePreload;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "currentCommentScene", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "pullType", "(ILcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;I)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getCurrentCommentScene", "()I", "preloadCacheManager", "Lcom/tencent/mm/plugin/finder/nearby/preload/cache/PreloadCacheManager;", "getPullType", "relatedRecommendResponse", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsResponse;", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "appendRelatedRecommendList", "", "checkIfStartPreload", "", "fetchFirstPage", "request", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "consume", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$CgiConsumeCallback;", "fetchInternal", "fetchRelatedRecommendList", "objectId", "", "getCommentScene", "initFinderReportContextObj", "intent", "Landroid/content/Intent;", "initTag", "isClickEnterPreloadValid", "isValidPreloadInterval", "onFetchDone", "rsp", "recordLastPreloadTimeStamp", "requestCache", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "startPreload", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a<IResponse<cc>>
  implements c.a
{
  public static final b.a EQd;
  private static int EQg;
  private bui Auc;
  private final bnn EIq;
  private final com.tencent.mm.plugin.finder.nearby.preload.cache.a EQe;
  private NearbyLiveFeedLoader.d EQf;
  public final int odF;
  public final int pullType;
  
  static
  {
    AppMethodBeat.i(340028);
    EQd = new b.a((byte)0);
    EQg = -1;
    AppMethodBeat.o(340028);
  }
  
  public b(int paramInt1, bnn parambnn, int paramInt2)
  {
    AppMethodBeat.i(340001);
    this.odF = paramInt1;
    this.EIq = parambnn;
    this.pullType = paramInt2;
    this.EQe = new com.tencent.mm.plugin.finder.nearby.preload.cache.a();
    AppMethodBeat.o(340001);
  }
  
  private final void a(NearbyLiveFeedLoader.c paramc)
  {
    AppMethodBeat.i(340012);
    Object localObject = com.tencent.mm.plugin.finder.nearby.trace.b.ERu;
    com.tencent.mm.plugin.finder.nearby.trace.b.a.Rm(paramc.EIr).ERx = System.currentTimeMillis();
    bui localbui = this.Auc;
    localObject = localbui;
    if (localbui == null)
    {
      s.bIx("contextObj");
      localObject = null;
    }
    new com.tencent.mm.plugin.finder.nearby.live.c((bui)localObject).a(paramc, (c.a)this, null);
    AppMethodBeat.o(340012);
  }
  
  private final void eGC()
  {
    AppMethodBeat.i(340007);
    setTAG(getTAG() + "_@" + this.EIq.ZVZ + '-' + this.EIq.ZWa);
    AppMethodBeat.o(340007);
  }
  
  public final void a(NearbyLiveFeedLoader.d paramd, NearbyLiveFeedLoader.c paramc)
  {
    AppMethodBeat.i(340106);
    s.u(paramd, "rsp");
    s.u(paramc, "request");
    Object localObject1 = getTAG();
    Object localObject2 = new StringBuilder("onSceneEnd errType:").append(paramd.getErrType()).append(" errCode:").append(paramd.getErrCode()).append(" errMsg:").append(paramd.getErrMsg()).append(" rsp:");
    bg localbg = bg.ABl;
    Log.i((String)localObject1, bg.fU(paramd.getIncrementList()) + "}pullType: " + paramc.pullType + " + prefetchMinInterval: " + paramd.EII);
    if (paramc.pullType == 16)
    {
      this.EQf = paramd;
      AppMethodBeat.o(340106);
      return;
    }
    eGx().aDn("onFetchDone");
    a(new i(paramd.getErrType(), paramd.getErrCode(), paramd.getErrMsg(), paramd, SystemClock.elapsedRealtime()));
    localObject1 = this.EQe;
    int i = paramc.EIr;
    paramc = (ArrayList)paramd.getIncrementList();
    localObject2 = paramd.getLastBuffer();
    int j;
    if (paramc == null)
    {
      Log.i("PreloadCacheManager", "store memoryCacheFlag:" + i + " return for dataList is null.");
      EQg = paramd.EII * 1000;
      i = this.pullType;
      paramd = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
      j = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(this.odF, this.EIq.ZVZ);
      switch (i)
      {
      }
    }
    for (;;)
    {
      a(eGw(), (kotlin.g.a.a)b.b.EQh);
      AppMethodBeat.o(340106);
      return;
      Log.i("PreloadCacheManager", "store memoryCacheFlag:" + i + " dataList:" + paramc.size() + " lastBuffer:" + localObject2);
      n.a(((com.tencent.mm.plugin.finder.nearby.preload.cache.a)localObject1).tlCache, i, 0, 0, paramc, null, (com.tencent.mm.bx.b)localObject2, true, 0, 144);
      ((com.tencent.mm.plugin.finder.nearby.preload.cache.a)localObject1).tlCache.UT(i);
      break;
      this.EQe.a(j, SystemClock.elapsedRealtime(), 0L, 0L);
      continue;
      this.EQe.a(j, 0L, SystemClock.elapsedRealtime(), 0L);
      continue;
      this.EQe.a(j, 0L, 0L, SystemClock.elapsedRealtime());
    }
  }
  
  public final void aE(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(340047);
    s.u(paramIntent, "intent");
    eGC();
    this.Auc = new bui();
    Object localObject3 = this.Auc;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("contextObj");
      localObject1 = null;
    }
    localObject3 = new StringBuilder();
    com.tencent.mm.plugin.finder.nearby.d locald = com.tencent.mm.plugin.finder.nearby.d.EFs;
    ((bui)localObject1).zIB = (com.tencent.mm.plugin.finder.nearby.d.eEd() + '-' + cn.bDw());
    localObject3 = this.Auc;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("contextObj");
      localObject1 = null;
    }
    localObject3 = com.tencent.mm.plugin.finder.nearby.d.EFs;
    ((bui)localObject1).AJo = com.tencent.mm.plugin.finder.nearby.d.get3TabTargetTabCommentScene();
    localObject3 = this.Auc;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("contextObj");
      localObject1 = null;
    }
    localObject3 = paramIntent.getStringExtra("key_context_id");
    paramIntent = (Intent)localObject3;
    if (localObject3 == null)
    {
      paramIntent = z.FrZ;
      paramIntent = z.bUm();
    }
    ((bui)localObject1).zIO = paramIntent;
    paramIntent = this.Auc;
    if (paramIntent == null)
    {
      s.bIx("contextObj");
      paramIntent = null;
      localObject3 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      paramIntent.sessionId = ((String)localObject1);
      localObject1 = this.Auc;
      paramIntent = (Intent)localObject1;
      if (localObject1 == null)
      {
        s.bIx("contextObj");
        paramIntent = null;
      }
      paramIntent.GSV = "";
      localObject1 = this.Auc;
      paramIntent = (Intent)localObject1;
      if (localObject1 == null)
      {
        s.bIx("contextObj");
        paramIntent = null;
      }
      paramIntent.extraInfo = "";
      paramIntent = this.Auc;
      if (paramIntent != null) {
        break label307;
      }
      s.bIx("contextObj");
      paramIntent = localObject2;
    }
    label307:
    for (;;)
    {
      paramIntent.zIE = "";
      AppMethodBeat.o(340047);
      return;
      break;
    }
  }
  
  public final void d(bui parambui)
  {
    AppMethodBeat.i(340034);
    s.u(parambui, "contextObj");
    eGC();
    this.Auc = parambui;
    AppMethodBeat.o(340034);
  }
  
  public final void eGA()
  {
    AppMethodBeat.i(340069);
    eGx().aDn("fetchInternal");
    Object localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    int i = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(this.odF, this.EIq.ZVZ);
    int j = this.EIq.ZVZ;
    localObject = new NearbyLiveFeedLoader.c(this.pullType, this.EIq, null, i, j + 1001, this.odF, null, 0, 0L, 448);
    a((NearbyLiveFeedLoader.c)localObject);
    Log.i(getTAG(), s.X("fetchInternal request:", localObject));
    AppMethodBeat.o(340069);
  }
  
  public final void eGD()
  {
    Object localObject4 = null;
    AppMethodBeat.i(340093);
    if (this.EQf == null)
    {
      Log.e(getTAG(), "appendRelatedRecommendList relatedRecommendResponse = null");
      AppMethodBeat.o(340093);
      return;
    }
    Object localObject1 = eGw();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof ArrayList)) {
        break label134;
      }
      localObject1 = (ArrayList)localObject1;
      label62:
      localObject2 = this.EQf;
      if (localObject2 != null) {
        break label140;
      }
    }
    label134:
    label140:
    for (Object localObject2 = null;; localObject2 = ((NearbyLiveFeedLoader.d)localObject2).getIncrementList())
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label150;
      }
      Log.e(getTAG(), "appendRelatedRecommendList list = null");
      AppMethodBeat.o(340093);
      return;
      localObject1 = (IResponse)((i)localObject1).hKP;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((IResponse)localObject1).getIncrementList();
      break;
      localObject1 = null;
      break label62;
    }
    label150:
    Object localObject3 = getTAG();
    Object localObject5 = new StringBuilder("dataList:\n ");
    Object localObject6 = bg.ABl;
    localObject5 = ((StringBuilder)localObject5).append(bg.fU((List)localObject1)).append(" \n newList: \n ");
    localObject6 = bg.ABl;
    Log.i((String)localObject3, bg.fU((List)localObject2));
    localObject3 = ((List)localObject1).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject3).hasNext())
    {
      localObject5 = (cc)((Iterator)localObject3).next();
      if (((localObject5 instanceof bn)) && (((bn)localObject5).eDD()))
      {
        j = 1;
        label274:
        if (j == 0) {
          break label459;
        }
        label278:
        localObject3 = Integer.valueOf(i);
        if (((Number)localObject3).intValue() == -1) {
          break label471;
        }
        i = 1;
        label298:
        if (i == 0) {
          break label476;
        }
        label302:
        if (localObject3 != null) {
          break label482;
        }
        j = 0;
        label309:
        localObject5 = new LinkedList();
        localObject3 = ((Iterable)localObject2).iterator();
      }
    }
    label513:
    label517:
    for (;;)
    {
      label330:
      if (!((Iterator)localObject3).hasNext()) {
        break label519;
      }
      localObject6 = (cc)((Iterator)localObject3).next();
      localObject2 = ((List)localObject1).iterator();
      i = 0;
      label366:
      int k;
      if (((Iterator)localObject2).hasNext()) {
        if (((cc)((Iterator)localObject2).next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localObject6) == 0)
        {
          k = 1;
          label401:
          if (k == 0) {
            break label496;
          }
          label405:
          localObject2 = Integer.valueOf(i);
          if (((Number)localObject2).intValue() != -1) {
            break label508;
          }
          i = 1;
          label425:
          if (i == 0) {
            break label513;
          }
        }
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label517;
        }
        ((Number)localObject2).intValue();
        ((LinkedList)localObject5).add(localObject6);
        break label330;
        j = 0;
        break label274;
        label459:
        i += 1;
        break;
        i = -1;
        break label278;
        label471:
        i = 0;
        break label298;
        label476:
        localObject3 = null;
        break label302;
        label482:
        j = ((Integer)localObject3).intValue();
        break label309;
        k = 0;
        break label401;
        label496:
        i += 1;
        break label366;
        i = -1;
        break label405;
        label508:
        i = 0;
        break label425;
        localObject2 = null;
      }
    }
    label519:
    localObject2 = eGw();
    if (localObject2 == null)
    {
      localObject2 = null;
      if (localObject2 != null)
      {
        localObject3 = this.EQf;
        if (localObject3 != null) {
          break label665;
        }
        localObject3 = null;
        label552:
        ((IResponse)localObject2).setLastBuffer((com.tencent.mm.bx.b)localObject3);
      }
      localObject3 = getTAG();
      localObject6 = new StringBuilder("mergeInsertData startIndex = ").append(j).append(", incrementSize: ").append(((LinkedList)localObject5).size()).append(" lastBuffer = ");
      localObject2 = eGw();
      if (localObject2 != null) {
        break label675;
      }
      localObject2 = localObject4;
    }
    for (;;)
    {
      Log.i((String)localObject3, localObject2);
      ((ArrayList)localObject1).addAll(j + 1, (Collection)localObject5);
      AppMethodBeat.o(340093);
      return;
      localObject2 = (IResponse)((i)localObject2).hKP;
      break;
      label665:
      localObject3 = ((NearbyLiveFeedLoader.d)localObject3).getLastBuffer();
      break label552;
      label675:
      IResponse localIResponse = (IResponse)((i)localObject2).hKP;
      localObject2 = localObject4;
      if (localIResponse != null) {
        localObject2 = localIResponse.getLastBuffer();
      }
    }
  }
  
  public final void eGy()
  {
    int j = 0;
    AppMethodBeat.i(340059);
    Object localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    int i = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(this.odF, this.EIq.ZVZ);
    localObject = com.tencent.mm.plugin.finder.nearby.preload.cache.a.QW(i);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    boolean bool;
    if (!((n)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(n.class)).Rp(i))
    {
      bool = true;
      Log.i(getTAG(), "checkIfStartPreload isPreload:" + ((n.a)localObject).GKC + " isValidData:" + bool);
      if ((!bool) || (!((n.a)localObject).GKC)) {
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
      AppMethodBeat.o(340059);
      return;
      bool = false;
      break;
    }
    label150:
    localObject = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
    if ((!com.tencent.mm.plugin.finder.nearby.preload.a.eGu()) || (this.pullType != 0)) {
      i = 1;
    }
    while (i == 0)
    {
      Log.w(getTAG(), "startPreload return for isClickEnterPreloadValid.");
      AppMethodBeat.o(340059);
      return;
      localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
      i = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(this.odF, this.EIq.ZVZ);
      localObject = com.tencent.mm.ui.component.k.aeZF;
      if (!((n)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(n.class)).Rp(i)) {}
      for (bool = true;; bool = false)
      {
        Log.i(getTAG(), "isClickEnterPreloadValid  isValidData:" + bool + " tab_id = " + this.EIq.ZVZ);
        if (bool) {
          break label298;
        }
        i = 1;
        break;
      }
      label298:
      i = 0;
    }
    i = this.pullType;
    localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    int k = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(this.odF, this.EIq.ZVZ);
    long l;
    switch (i)
    {
    case 13: 
    default: 
      l = SystemClock.elapsedRealtime();
      if (i != 0) {
        if (EQg == 0)
        {
          Log.i(getTAG(), s.X("isValidPreloadInterval return false for server PRELOAD_INTERVAL_MS:", Integer.valueOf(EQg)));
          i = j;
        }
      }
      break;
    }
    for (;;)
    {
      if (i != 0) {
        break label552;
      }
      Log.w(getTAG(), "startPreload return for isValidPreloadInterval.");
      AppMethodBeat.o(340059);
      return;
      l = this.EQe.QY(k).GLI;
      break;
      l = this.EQe.QY(k).GLJ;
      break;
      l = this.EQe.QY(k).GLK;
      break;
      if ((EQg != -1) && (l != 0L))
      {
        l = SystemClock.elapsedRealtime() - l;
        if (l < EQg)
        {
          Log.i(getTAG(), "isValidPreloadInterval return false for interval:" + l + " < PRELOAD_INTERVAL_MS:" + EQg);
          i = j;
          continue;
        }
      }
      i = 1;
    }
    label552:
    localObject = com.tencent.mm.plugin.finder.nearby.live.base.a.EJF;
    if (!com.tencent.mm.plugin.finder.nearby.live.base.a.a("startPreload first page", this.EIq))
    {
      Log.w(getTAG(), "startPreload return for hit nearby city tab.");
      AppMethodBeat.o(340059);
      return;
    }
    super.eGy();
    AppMethodBeat.o(340059);
  }
  
  public final i<IResponse<cc>> eGz()
  {
    AppMethodBeat.i(340064);
    i locali = super.eGz();
    if (locali != null) {
      new com.tencent.mm.plugin.finder.cgi.h(2, ((IResponse)locali.hKP).getLastBuffer()).bFJ();
    }
    AppMethodBeat.o(340064);
    return locali;
  }
  
  public final void pn(long paramLong)
  {
    AppMethodBeat.i(340074);
    if ((this.EPU != a.a.EQa) && (!b(eGw())))
    {
      Log.i(getTAG(), s.X("fetchRelatedRecommendList getLoadingState: ", this.EPU));
      AppMethodBeat.o(340074);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    int i = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(this.odF, this.EIq.ZVZ);
    int j = this.EIq.ZVZ;
    Object localObject2 = getTAG();
    StringBuilder localStringBuilder = new StringBuilder("fetchRelatedRecommendList relatedObjectId: ").append(paramLong).append(" lastBuffer = ");
    localObject1 = eGw();
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject2, localObject1);
      localObject2 = this.EIq;
      localObject1 = eGw();
      if (localObject1 != null) {
        break label228;
      }
      localObject1 = null;
    }
    for (;;)
    {
      a(new NearbyLiveFeedLoader.c(16, (bnn)localObject2, (com.tencent.mm.bx.b)localObject1, i, j + 1001, this.odF, null, 0, paramLong, 192));
      AppMethodBeat.o(340074);
      return;
      localObject1 = (IResponse)((i)localObject1).hKP;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((IResponse)localObject1).getLastBuffer();
      break;
      label228:
      localObject1 = (IResponse)((i)localObject1).hKP;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((IResponse)localObject1).getLastBuffer();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.firstpage.b
 * JD-Core Version:    0.7.0.1
 */