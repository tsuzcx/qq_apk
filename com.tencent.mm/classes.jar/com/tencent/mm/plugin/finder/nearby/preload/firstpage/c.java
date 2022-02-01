package com.tencent.mm.plugin.finder.nearby.preload.firstpage;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.nearby.live.square.tab.e;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.plugin.findersdk.b.g;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/NearbySquareTabsPreload;", "Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/FirstPagePreload;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "enterType", "", "netSceneFetchSquareTabs", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NetSceneFetchSquareTabs;", "preloadCacheManager", "Lcom/tencent/mm/plugin/finder/nearby/preload/cache/PreloadCacheManager;", "checkIfStartPreload", "", "fetchInternal", "", "fetchLiveSquareTabs", "fetchTabsInternal", "initFinderReportContextObj", "intent", "Landroid/content/Intent;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "startPreload", "stopPreload", "plugin-finder-nearby_release"})
public final class c
  extends a<com.tencent.mm.an.q>
  implements i
{
  public bid xbu;
  private e zGI;
  private com.tencent.mm.plugin.finder.nearby.preload.cache.a zIL;
  public String zIP;
  
  public c()
  {
    AppMethodBeat.i(200888);
    this.zIP = "12";
    this.zIL = new com.tencent.mm.plugin.finder.nearby.preload.cache.a();
    AppMethodBeat.o(200888);
  }
  
  public final void dMs()
  {
    AppMethodBeat.i(200874);
    Object localObject2 = this.zIL;
    Object localObject1 = this.zIP;
    p.k(localObject1, "memoryCacheFlag");
    Log.i("PreloadCacheManager", "getPreloadSquareTabsCache memoryCacheFlag:".concat(String.valueOf(localObject1)));
    localObject2 = ((com.tencent.mm.plugin.finder.nearby.preload.cache.a)localObject2).tlCache;
    p.k(localObject1, "memoryCacheFlag");
    localObject1 = (com.tencent.mm.plugin.findersdk.b.h)((b)localObject2).Bgo.get(localObject1);
    int i;
    if (localObject1 == null) {
      i = 1;
    }
    while (i == 0)
    {
      Log.i(getTAG(), "startPreload return for use cache tabs.");
      AppMethodBeat.o(200874);
      return;
      if (b((com.tencent.mm.plugin.findersdk.b.h)localObject1))
      {
        i = 1;
      }
      else
      {
        a((com.tencent.mm.plugin.findersdk.b.h)localObject1);
        a(dMq(), (kotlin.g.a.a)a.zIQ);
        i = 0;
      }
    }
    super.dMs();
    AppMethodBeat.o(200874);
  }
  
  public final void dMu()
  {
    AppMethodBeat.i(200876);
    Object localObject = this.xbu;
    if (localObject == null) {
      p.bGy("contextObj");
    }
    Log.i(getTAG(), "fetchLiveSquareTabs, contextObj:".concat(String.valueOf(localObject)));
    dMr().aGV("doScene");
    this.zGI = new e((bid)localObject);
    localObject = this.zGI;
    if (localObject != null)
    {
      Context localContext1 = MMApplicationContext.getContext();
      p.j(localContext1, "MMApplicationContext.getContext()");
      Context localContext2 = MMApplicationContext.getContext();
      p.j(localContext2, "MMApplicationContext.getContext()");
      g.a((g)localObject, localContext1, localContext2.getResources().getString(b.j.finder_waiting));
    }
    com.tencent.mm.kernel.h.aGY().a(4210, (i)this);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)this.zGI);
    AppMethodBeat.o(200876);
  }
  
  public final void dMv()
  {
    AppMethodBeat.i(200879);
    com.tencent.mm.kernel.h.aGY().b(4210, (i)this);
    super.dMv();
    AppMethodBeat.o(200879);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(200884);
    p.k(paramq, "scene");
    Log.i(getTAG(), "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scene:" + paramq);
    dMr().aGV("onSceneEnd");
    a(new com.tencent.mm.plugin.findersdk.b.h(paramInt1, paramInt2, paramString, paramq, SystemClock.elapsedRealtime()));
    Object localObject = this.zIL;
    paramString = this.zIP;
    paramq = dMq();
    p.k(paramString, "memoryCacheFlag");
    if (paramq == null) {
      Log.w("PreloadCacheManager", "storePreloadSquareTabsCache memoryCacheFlag:" + paramString + " return for null.");
    }
    for (;;)
    {
      a(dMq(), (kotlin.g.a.a)new b(this));
      AppMethodBeat.o(200884);
      return;
      Log.i("PreloadCacheManager", "storePreloadSquareTabsCache memoryCacheFlag:".concat(String.valueOf(paramString)));
      localObject = ((com.tencent.mm.plugin.finder.nearby.preload.cache.a)localObject).tlCache;
      p.k(paramString, "memoryCacheFlag");
      p.k(paramq, "response");
      ((Map)((b)localObject).Bgo).put(paramString, paramq);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final a zIQ;
    
    static
    {
      AppMethodBeat.i(200999);
      zIQ = new a();
      AppMethodBeat.o(200999);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.firstpage.c
 * JD-Core Version:    0.7.0.1
 */