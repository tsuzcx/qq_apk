package com.tencent.mm.plugin.finder.nearby.video;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.cgi.aa.b;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.finder.model.BaseFinderFeed;>;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "isGetHistory", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "getTabType", "()I", "fetch", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "innerFetch", "lb", "uniqueId", "", "Companion", "plugin-finder-nearby_release"})
public final class b
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final a zJE;
  final int fEH;
  com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> xbq;
  private final bid xbu;
  private volatile boolean xeZ;
  
  static
  {
    AppMethodBeat.i(201256);
    zJE = new a((byte)0);
    AppMethodBeat.o(201256);
  }
  
  public b(int paramInt, bid parambid)
  {
    AppMethodBeat.i(201255);
    this.fEH = paramInt;
    this.xbu = parambid;
    this.xbq = new com.tencent.mm.vending.e.c();
    AppMethodBeat.o(201255);
  }
  
  private final void a(final ab.a parama, final int paramInt, final ab.c paramc, List<? extends BaseFinderFeed> paramList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(201253);
    if ((paramInt == 0) || (paramInt == 1)) {
      this.xeZ = false;
    }
    if (paramInt == 0)
    {
      localObject2 = h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp();
      localObject3 = aj.AGc;
      ((ao)localObject2).set(aj.QX(this.fEH), null);
    }
    Object localObject2 = h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp();
    Object localObject3 = aj.AGc;
    localObject2 = ((ao)localObject2).get(aj.QX(this.fEH), "");
    if (localObject2 == null)
    {
      parama = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(201253);
      throw parama;
    }
    localObject2 = com.tencent.mm.cd.b.cU(Util.decodeHexString((String)localObject2));
    Log.i("Finder.NearbyVideoFeedFetcher", "[innerFetch] use tabType=" + this.fEH + " lastBuffer:" + localObject2);
    int i = this.fEH;
    localObject3 = this.xbu;
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
      new aa(i, paramInt, (com.tencent.mm.cd.b)localObject2, (bid)localObject3, paramList).a((com.tencent.mm.plugin.finder.cgi.interceptor.f)new com.tencent.mm.plugin.finder.cgi.interceptor.a(), 0).a((com.tencent.mm.plugin.finder.cgi.interceptor.f)new com.tencent.mm.plugin.finder.cgi.interceptor.d(), 1).a((com.tencent.mm.plugin.finder.cgi.interceptor.f)new com.tencent.mm.plugin.finder.cgi.interceptor.c(), 2).a((com.tencent.mm.plugin.finder.cgi.interceptor.f)new com.tencent.mm.plugin.finder.cgi.interceptor.b(), 3).a(this.xbq, (aa.b)new c(this, paramc, paramInt, true, parama));
      AppMethodBeat.o(201253);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder-nearby_release"})
  public static final class b
    implements ab.a
  {
    b(ab.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
    {
      AppMethodBeat.i(201392);
      p.k(paramd, "info");
      this.xfo.a(paramd, paramInt);
      AppMethodBeat.o(201392);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$innerFetch$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder-nearby_release"})
  public static final class c
    implements aa.b
  {
    c(ab.c paramc, int paramInt, boolean paramBoolean, ab.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aa.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.f> paramList)
    {
      AppMethodBeat.i(200968);
      p.k(paramf, "resp");
      p.k(paramList, "interceptors");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramInt == 0)
        {
          Log.i("Finder.NearbyVideoFeedFetcher", "tabType=" + this.zJF.fEH + " headWording=" + paramf.SUH + " endWording=" + paramf.SUI + " prefetch_last_feed_count=" + paramf.SUL + " continueFlag:" + paramf.continueFlag);
          paramList = h.aHG();
          p.j(paramList, "MMKernel.storage()");
          paramList.aHp().set(ar.a.VzW, paramf.SUH);
          paramList = h.aHG();
          p.j(paramList, "MMKernel.storage()");
          paramList.aHp().set(ar.a.VzX, paramf.SUI);
          paramList = h.aHG();
          p.j(paramList, "MMKernel.storage()");
          paramList.aHp().set(ar.a.VAa, Integer.valueOf(paramf.SUL));
        }
        if (paramf.SUR != null)
        {
          paramList = h.aHG();
          p.j(paramList, "MMKernel.storage()");
          localObject1 = paramList.aHp();
          localObject2 = ar.a.VzY;
          paramList = paramf.SUR;
          if (paramList == null) {
            break label358;
          }
        }
        label358:
        for (paramList = paramList.toByteArray();; paramList = null)
        {
          ((ao)localObject1).set((ar.a)localObject2, Util.encodeHexString(paramList));
          paramList = g.Xox;
          ((com.tencent.mm.plugin.finder.preload.tabPreload.c)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).ON(this.zJF.fEH);
          paramList = MMApplicationContext.getResources().getString(b.j.finder_timeline_history_header_tip);
          p.j(paramList, "MMApplicationContext.get…eline_history_header_tip)");
          localObject1 = h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          paramList = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.VzW, paramList);
          if (paramList != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(200968);
          throw paramString;
        }
        paramList = (String)paramList;
        Object localObject1 = MMApplicationContext.getResources().getString(b.j.finder_timeline_history_footer_tip);
        p.j(localObject1, "MMApplicationContext.get…eline_history_footer_tip)");
        Object localObject2 = h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject1 = ((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.VzX, localObject1);
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(200968);
          throw paramString;
        }
        localObject1 = (String)localObject1;
        localObject2 = paramf.object;
        p.j(localObject2, "resp.`object`");
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        Object localObject5;
        Object localObject6;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          localObject5 = (FinderObject)localObject4;
          localObject6 = aj.AGc;
          p.j(localObject5, "it");
          if (aj.x((FinderObject)localObject5)) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        localObject3 = (List)localObject2;
        if (((List)localObject3).size() < paramf.object.size()) {
          Log.e("Finder.NearbyVideoFeedFetcher", "[onCgiBack] has filter some feed. valid=" + ((List)localObject3).size() + " raw=" + paramf.object.size());
        }
        if (paramf.SUJ > 0) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          localObject2 = aj.AGc;
          localObject4 = (Iterable)c.a.a((List)localObject3, aj.QY(this.zJF.fEH), b.b(this.zJF));
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (FinderItem)((Iterator)localObject4).next();
            localObject6 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            ((Collection)localObject2).add(c.a.a((FinderItem)localObject5));
          }
        }
        Object localObject4 = new LinkedList((Collection)localObject2);
        localObject2 = new com.tencent.mm.plugin.finder.feed.model.d((List)localObject4, paramInt1, paramInt2, paramString);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).fEH = this.zJF.fEH;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xbB = paramf.xbB;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).nqx = paramf.nqx;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xbC = paramf.xbC;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).pullType = paramInt;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xFO = paramList;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xBL = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xFI = paramf.continueFlag;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xFG = ((List)localObject3);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xFJ = paramf.xbD;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xeZ = b.a(this.zJF);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).lastBuffer = paramf.lastBuffer;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).preloadInfo = paramf.preloadInfo;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xFL = paramf.SUP;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xFH = paramf.xFH;
        if (paramf.SUJ != 0) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).isNeedClear = bool2;
          ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).xFN = paramf.xFN;
          if (paramInt != 2)
          {
            paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            paramString = (List)localObject4;
            paramList = aj.AGc;
            c.a.b(paramString, aj.QY(this.zJF.fEH), bool1);
          }
          if ((paramInt == 0) || (paramInt == 1))
          {
            paramString = au.zBf;
            au.j(this.zJF.fEH, (List)localObject3);
          }
          if (this.xfv)
          {
            paramString = h.aHG();
            p.j(paramString, "MMKernel.storage()");
            paramList = paramString.aHp();
            paramString = aj.AGc;
            localObject1 = aj.QX(this.zJF.fEH);
            if (paramf.lastBuffer != null) {
              break;
            }
            paramString = null;
            paramList.set((ar.a)localObject1, paramString);
          }
          b.a(this.zJF, paramf.xbD);
          parama.a((com.tencent.mm.plugin.finder.feed.model.d)localObject2, paramInt);
          AppMethodBeat.o(200968);
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
      paramString = new com.tencent.mm.plugin.finder.feed.model.d((List)new LinkedList(), paramInt1, paramInt2, paramString);
      paramString.fEH = this.zJF.fEH;
      paramString.pullType = paramInt;
      paramString.xFI = 1;
      paramString.xFJ = paramf.xbD;
      paramString.lastBuffer = paramf.lastBuffer;
      parama.a(paramString, paramInt);
      AppMethodBeat.o(200968);
    }
    
    public final void a(bjv parambjv)
    {
      AppMethodBeat.i(200951);
      p.k(parambjv, "request");
      AppMethodBeat.o(200951);
    }
    
    public final boolean a(dyy paramdyy)
    {
      AppMethodBeat.i(200950);
      p.k(paramdyy, "resp");
      ab.c localc = paramc;
      if (localc != null)
      {
        boolean bool = localc.b(paramdyy);
        AppMethodBeat.o(200950);
        return bool;
      }
      AppMethodBeat.o(200950);
      return false;
    }
    
    public final boolean dnH()
    {
      AppMethodBeat.i(200948);
      boolean bool = b.a(this.zJF);
      AppMethodBeat.o(200948);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.b
 * JD-Core Version:    0.7.0.1
 */