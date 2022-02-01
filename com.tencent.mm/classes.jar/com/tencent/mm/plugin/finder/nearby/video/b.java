package com.tencent.mm.plugin.finder.nearby.video;

import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.cgi.aa.b;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.interceptor.d;
import com.tencent.mm.plugin.finder.cgi.interceptor.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.finder.model.BaseFinderFeed;>;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "isGetHistory", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "pageDataBuffer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "getPageDataBuffer", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "getTabType", "()I", "fetch", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "fetchHotRelatedList", "feedId", "", "nonceId", "", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "innerFetch", "lb", "uniqueId", "Companion", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final a uTr;
  final int dLS;
  com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> ttK;
  private final bbn ttO;
  private volatile boolean twZ;
  private final com.tencent.mm.plugin.finder.feed.model.internal.l<bo, com.tencent.mm.plugin.finder.feed.model.b> txr;
  
  static
  {
    AppMethodBeat.i(249365);
    uTr = new a((byte)0);
    AppMethodBeat.o(249365);
  }
  
  public b(int paramInt, bbn parambbn)
  {
    AppMethodBeat.i(249364);
    this.dLS = paramInt;
    this.ttO = parambbn;
    this.ttK = new com.tencent.mm.vending.e.c();
    this.txr = new com.tencent.mm.plugin.finder.feed.model.internal.l(null, String.valueOf(this.dLS), 1);
    AppMethodBeat.o(249364);
  }
  
  private final void a(final ab.a parama, final int paramInt, final ab.c paramc, List<? extends BaseFinderFeed> paramList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(249363);
    if ((paramInt == 0) || (paramInt == 1)) {
      this.twZ = false;
    }
    Log.i("Finder.NearbyVideoFeedFetcher", "[innerFetch] use tabType=" + this.dLS + " GlobalLastBuffer");
    if (paramInt == 0)
    {
      localObject2 = g.aAh();
      p.g(localObject2, "MMKernel.storage()");
      localObject2 = ((e)localObject2).azQ();
      localObject3 = y.vXH;
      ((ao)localObject2).set(y.LK(this.dLS), null);
    }
    Object localObject2 = g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((e)localObject2).azQ();
    Object localObject3 = y.vXH;
    localObject2 = ((ao)localObject2).get(y.LK(this.dLS), "");
    if (localObject2 == null)
    {
      parama = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(249363);
      throw parama;
    }
    localObject2 = com.tencent.mm.bw.b.cD(Util.decodeHexString((String)localObject2));
    int i = this.dLS;
    localObject3 = this.ttO;
    if (paramList != null)
    {
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramList.add(((BaseFinderFeed)((Iterator)localObject1).next()).feedObject.getFeedObject());
      }
    }
    for (paramList = (List)paramList;; paramList = (List<? extends BaseFinderFeed>)localObject1)
    {
      new aa(i, paramInt, (com.tencent.mm.bw.b)localObject2, (bbn)localObject3, paramList).a((f)new com.tencent.mm.plugin.finder.cgi.interceptor.a(), 0).a((f)new d(), 1).a((f)new com.tencent.mm.plugin.finder.cgi.interceptor.c(), 2).a((f)new com.tencent.mm.plugin.finder.cgi.interceptor.b(), 3).a(this.ttK, (aa.b)new c(this, paramc, paramInt, true, parama));
      AppMethodBeat.o(249363);
      return;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class b
    implements ab.a
  {
    b(ab.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(249357);
      p.h(paramb, "info");
      this.txo.a(paramb, paramInt);
      AppMethodBeat.o(249357);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$innerFetch$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static final class c
    implements aa.b
  {
    c(ab.c paramc, int paramInt, boolean paramBoolean, ab.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aa.f paramf, List<? extends f> paramList)
    {
      AppMethodBeat.i(249361);
      p.h(paramf, "resp");
      p.h(paramList, "interceptors");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramInt == 0)
        {
          Log.i("Finder.NearbyVideoFeedFetcher", "tabType=" + this.uTs.dLS + " headWording=" + paramf.LME + " endWording=" + paramf.LMF + " prefetch_last_feed_count=" + paramf.LMI + " continueFlag:" + paramf.continueFlag);
          paramList = g.aAh();
          p.g(paramList, "MMKernel.storage()");
          paramList.azQ().set(ar.a.Olb, paramf.LME);
          paramList = g.aAh();
          p.g(paramList, "MMKernel.storage()");
          paramList.azQ().set(ar.a.Olc, paramf.LMF);
          paramList = g.aAh();
          p.g(paramList, "MMKernel.storage()");
          paramList.azQ().set(ar.a.Olf, Integer.valueOf(paramf.LMI));
        }
        if (paramf.LMO != null)
        {
          paramList = g.aAh();
          p.g(paramList, "MMKernel.storage()");
          localObject1 = paramList.azQ();
          localObject2 = ar.a.Old;
          paramList = paramf.LMO;
          if (paramList == null) {
            break label357;
          }
        }
        label357:
        for (paramList = paramList.toByteArray();; paramList = null)
        {
          ((ao)localObject1).set((ar.a)localObject2, Util.encodeHexString(paramList));
          paramList = com.tencent.mm.ui.component.a.PRN;
          ((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).JM(this.uTs.dLS);
          paramList = MMApplicationContext.getResources().getString(2131760625);
          p.g(paramList, "MMApplicationContext.get…eline_history_header_tip)");
          localObject1 = g.aAh();
          p.g(localObject1, "MMKernel.storage()");
          paramList = ((e)localObject1).azQ().get(ar.a.Olb, paramList);
          if (paramList != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(249361);
          throw paramString;
        }
        paramList = (String)paramList;
        Object localObject1 = MMApplicationContext.getResources().getString(2131760624);
        p.g(localObject1, "MMApplicationContext.get…eline_history_footer_tip)");
        Object localObject2 = g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        localObject1 = ((e)localObject2).azQ().get(ar.a.Olc, localObject1);
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(249361);
          throw paramString;
        }
        localObject1 = (String)localObject1;
        localObject2 = paramf.object;
        p.g(localObject2, "resp.`object`");
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        Object localObject5;
        Object localObject6;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          localObject5 = (FinderObject)localObject4;
          localObject6 = y.vXH;
          p.g(localObject5, "it");
          if (y.s((FinderObject)localObject5)) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        localObject3 = (List)localObject2;
        if (((List)localObject3).size() < paramf.object.size()) {
          Log.e("Finder.NearbyVideoFeedFetcher", "[onCgiBack] has filter some feed. valid=" + ((List)localObject3).size() + " raw=" + paramf.object.size());
        }
        if (paramf.LMG > 0) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
          localObject2 = y.vXH;
          localObject4 = (Iterable)c.a.a((List)localObject3, y.LL(this.uTs.dLS), b.a(this.uTs));
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (FinderItem)((Iterator)localObject4).next();
            localObject6 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            ((Collection)localObject2).add(c.a.s((FinderItem)localObject5));
          }
        }
        Object localObject4 = new LinkedList((Collection)localObject2);
        localObject2 = new com.tencent.mm.plugin.finder.feed.model.b((List)localObject4, paramInt1, paramInt2, paramString);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).dLS = this.uTs.dLS;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).ttV = paramf.ttV;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).kxF = paramf.kxF;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).ttW = paramf.ttW;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).pullType = paramInt;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).tUI = paramList;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).tQU = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).tUC = paramf.continueFlag;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).tUA = ((List)localObject3);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).tUD = paramf.ttX;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).twZ = b.b(this.uTs);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).lastBuffer = paramf.lastBuffer;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).preloadInfo = paramf.preloadInfo;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).tUF = paramf.LMM;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).tUB = paramf.tUB;
        if (paramf.LMG != 0) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).isNeedClear = bool2;
          ((com.tencent.mm.plugin.finder.feed.model.b)localObject2).tUH = paramf.tUH;
          if (paramInt != 2)
          {
            paramString = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            paramString = (List)localObject4;
            paramList = y.vXH;
            c.a.b(paramString, y.LL(this.uTs.dLS), bool1);
          }
          if ((paramInt == 0) || (paramInt == 1))
          {
            paramString = as.uOL;
            as.h(this.uTs.dLS, (List)localObject3);
          }
          if (this.txw)
          {
            paramString = g.aAh();
            p.g(paramString, "MMKernel.storage()");
            paramList = paramString.azQ();
            paramString = y.vXH;
            localObject1 = y.LK(this.uTs.dLS);
            if (paramf.lastBuffer != null) {
              break;
            }
            paramString = null;
            paramList.set((ar.a)localObject1, paramString);
          }
          b.a(this.uTs, paramf.ttX);
          parama.a((com.tencent.mm.plugin.finder.feed.model.b)localObject2, paramInt);
          AppMethodBeat.o(249361);
          return;
        }
        paramString = paramf.lastBuffer;
        if (paramString != null) {}
        for (paramString = paramString.toByteArray();; paramString = null)
        {
          paramString = Util.encodeHexString(paramString);
          break;
        }
      }
      paramString = new com.tencent.mm.plugin.finder.feed.model.b((List)new LinkedList(), paramInt1, paramInt2, paramString);
      paramString.dLS = this.uTs.dLS;
      paramString.pullType = paramInt;
      paramString.tUC = 1;
      paramString.tUD = paramf.ttX;
      paramString.lastBuffer = paramf.lastBuffer;
      parama.a(paramString, paramInt);
      AppMethodBeat.o(249361);
    }
    
    public final void a(bcz parambcz)
    {
      AppMethodBeat.i(249360);
      p.h(parambcz, "request");
      AppMethodBeat.o(249360);
    }
    
    public final boolean a(dpc paramdpc)
    {
      AppMethodBeat.i(249359);
      p.h(paramdpc, "resp");
      ab.c localc = paramc;
      if (localc != null)
      {
        boolean bool = localc.b(paramdpc);
        AppMethodBeat.o(249359);
        return bool;
      }
      AppMethodBeat.o(249359);
      return false;
    }
    
    public final boolean cXU()
    {
      AppMethodBeat.i(249358);
      boolean bool = b.b(this.uTs);
      AppMethodBeat.o(249358);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.b
 * JD-Core Version:    0.7.0.1
 */