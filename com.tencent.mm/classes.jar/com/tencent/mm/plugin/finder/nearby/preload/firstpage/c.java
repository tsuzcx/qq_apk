package com.tencent.mm.plugin.finder.nearby.preload.firstpage;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.nearby.report.b;
import com.tencent.mm.plugin.finder.viewmodel.n;
import com.tencent.mm.plugin.findersdk.b.i;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/NearbySquareTabsPreload;", "Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/FirstPagePreload;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "enterType", "", "netSceneFetchSquareTabs", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NetSceneFetchSquareTabs;", "preloadCacheManager", "Lcom/tencent/mm/plugin/finder/nearby/preload/cache/PreloadCacheManager;", "scene", "", "checkIfStartPreload", "", "fetchInternal", "", "fetchLiveSquareTabs", "fetchTabsInternal", "initFinderReportContextObj", "intent", "Landroid/content/Intent;", "onSceneEnd", "errType", "errCode", "errMsg", "startPreload", "stopPreload", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a<p>
  implements com.tencent.mm.am.h
{
  public bui Auc;
  private com.tencent.mm.plugin.finder.nearby.live.square.tab.c EMe;
  private com.tencent.mm.plugin.finder.nearby.preload.cache.a EQe;
  public String EQi;
  public int scene;
  
  public c()
  {
    AppMethodBeat.i(339992);
    this.EQi = "12";
    this.EQe = new com.tencent.mm.plugin.finder.nearby.preload.cache.a();
    AppMethodBeat.o(339992);
  }
  
  public final void eGA()
  {
    AppMethodBeat.i(340010);
    Object localObject2 = this.Auc;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("contextObj");
      localObject1 = null;
    }
    Log.i(getTAG(), kotlin.g.b.s.X("fetchLiveSquareTabs, contextObj:", localObject1));
    eGx().aDn("doScene");
    localObject2 = b.EQs;
    b.eGF();
    this.EMe = new com.tencent.mm.plugin.finder.nearby.live.square.tab.c((bui)localObject1, this.scene);
    localObject1 = this.EMe;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.plugin.findersdk.b.h)localObject1;
      localObject2 = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localObject2, "getContext()");
      com.tencent.mm.plugin.findersdk.b.h.a((com.tencent.mm.plugin.findersdk.b.h)localObject1, (Context)localObject2, MMApplicationContext.getContext().getResources().getString(e.h.finder_waiting));
    }
    com.tencent.mm.kernel.h.aZW().a(4210, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a((p)this.EMe, 0);
    AppMethodBeat.o(340010);
  }
  
  public final void eGB()
  {
    AppMethodBeat.i(340013);
    com.tencent.mm.kernel.h.aZW().b(4210, (com.tencent.mm.am.h)this);
    super.eGB();
    AppMethodBeat.o(340013);
  }
  
  public final void eGy()
  {
    AppMethodBeat.i(339998);
    Object localObject2 = this.EQe;
    Object localObject1 = this.EQi;
    kotlin.g.b.s.u(localObject1, "memoryCacheFlag");
    Log.i("PreloadCacheManager", kotlin.g.b.s.X("getPreloadSquareTabsCache memoryCacheFlag:", localObject1));
    localObject2 = ((com.tencent.mm.plugin.finder.nearby.preload.cache.a)localObject2).tlCache;
    kotlin.g.b.s.u(localObject1, "memoryCacheFlag");
    localObject1 = (i)((n)localObject2).GKn.get(localObject1);
    int i;
    if (localObject1 == null) {
      i = 1;
    }
    while (i == 0)
    {
      Log.i(getTAG(), "startPreload return for use cache tabs.");
      AppMethodBeat.o(339998);
      return;
      if (c((i)localObject1))
      {
        i = 1;
      }
      else
      {
        a((i)localObject1);
        a(eGw(), (kotlin.g.a.a)a.EQj);
        i = 0;
      }
    }
    super.eGy();
    AppMethodBeat.o(339998);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(340021);
    kotlin.g.b.s.u(paramp, "scene");
    Log.i(getTAG(), "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scene:" + paramp);
    eGx().aDn("onSceneEnd");
    Object localObject = b.EQs;
    b.eGG();
    a(new i(paramInt1, paramInt2, paramString, paramp, SystemClock.elapsedRealtime()));
    localObject = this.EQe;
    paramString = this.EQi;
    paramp = eGw();
    kotlin.g.b.s.u(paramString, "memoryCacheFlag");
    if (paramp == null) {
      Log.w("PreloadCacheManager", "storePreloadSquareTabsCache memoryCacheFlag:" + paramString + " return for null.");
    }
    for (;;)
    {
      a(eGw(), (kotlin.g.a.a)new b(this));
      AppMethodBeat.o(340021);
      return;
      Log.i("PreloadCacheManager", kotlin.g.b.s.X("storePreloadSquareTabsCache memoryCacheFlag:", paramString));
      localObject = ((com.tencent.mm.plugin.finder.nearby.preload.cache.a)localObject).tlCache;
      kotlin.g.b.s.u(paramString, "memoryCacheFlag");
      kotlin.g.b.s.u(paramp, "response");
      ((Map)((n)localObject).GKn).put(paramString, paramp);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final a EQj;
    
    static
    {
      AppMethodBeat.i(339987);
      EQj = new a();
      AppMethodBeat.o(339987);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.firstpage.c
 * JD-Core Version:    0.7.0.1
 */