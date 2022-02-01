package com.tencent.mm.plugin.finder.nearby.video;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aq.a;
import com.tencent.mm.plugin.finder.cgi.aq.c;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.cgi.aq.e;
import com.tencent.mm.plugin.finder.cgi.ar.a;
import com.tencent.mm.plugin.finder.cgi.ar.c;
import com.tencent.mm.plugin.finder.cgi.interceptor.e;
import com.tencent.mm.plugin.finder.cgi.interceptor.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.finder.model.BaseFinderFeed;>;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "isGetHistory", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "getTabType", "()I", "fetch", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "innerFetch", "lb", "uniqueId", "", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final a ERF;
  com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> AAh;
  private volatile boolean AEi;
  private final bui Auc;
  final int hJx;
  
  static
  {
    AppMethodBeat.i(340227);
    ERF = new a((byte)0);
    AppMethodBeat.o(340227);
  }
  
  public b(int paramInt, bui parambui)
  {
    AppMethodBeat.i(340150);
    this.hJx = paramInt;
    this.Auc = parambui;
    this.AAh = new com.tencent.mm.vending.e.c();
    AppMethodBeat.o(340150);
  }
  
  private final void a(final ar.a parama, int paramInt, final ar.c paramc, List<? extends BaseFinderFeed> paramList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(340191);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        localObject2 = h.baE().ban();
        localObject3 = av.GiL;
        ((com.tencent.mm.storage.aq)localObject2).set(av.Uh(this.hJx), null);
      }
      localObject2 = h.baE().ban();
      localObject3 = av.GiL;
      localObject2 = ((com.tencent.mm.storage.aq)localObject2).get(av.Uh(this.hJx), "");
      if (localObject2 != null) {
        break;
      }
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(340191);
      throw parama;
      this.AEi = false;
    }
    Object localObject2 = com.tencent.mm.bx.b.cX(Util.decodeHexString((String)localObject2));
    Log.i("Finder.NearbyVideoFeedFetcher", "[innerFetch] use tabType=" + this.hJx + " lastBuffer:" + localObject2);
    int i = this.hJx;
    Object localObject3 = this.Auc;
    if (paramList == null) {}
    for (paramList = (List<? extends BaseFinderFeed>)localObject1;; paramList = (List)paramList)
    {
      new com.tencent.mm.plugin.finder.cgi.aq(i, paramInt, (com.tencent.mm.bx.b)localObject2, (bui)localObject3, paramList, false, 480).a((g)new com.tencent.mm.plugin.finder.cgi.interceptor.a(), 0).a((g)new e(), 1).a((g)new com.tencent.mm.plugin.finder.cgi.interceptor.d(), 2).a(this.AAh).a((aq.e)new c(this, paramc)).a((aq.a)new d(paramInt, this, true, parama)).run();
      AppMethodBeat.o(340191);
      return;
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramList.add(((BaseFinderFeed)((Iterator)localObject1).next()).feedObject.getFeedObject());
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ar.a
  {
    b(ar.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
    {
      AppMethodBeat.i(340215);
      s.u(paramd, "info");
      this.AEw.a(paramd, paramInt);
      AppMethodBeat.o(340215);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$innerFetch$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$IConfig;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "onLoadFinish", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements aq.e
  {
    c(b paramb, ar.c paramc) {}
    
    public final boolean a(esc paramesc)
    {
      AppMethodBeat.i(340228);
      s.u(paramesc, "resp");
      ar.c localc = paramc;
      if (localc == null)
      {
        AppMethodBeat.o(340228);
        return false;
      }
      boolean bool = localc.b(paramesc);
      AppMethodBeat.o(340228);
      return bool;
    }
    
    public final void b(aq.c paramc)
    {
      AppMethodBeat.i(340233);
      s.u(paramc, "request");
      AppMethodBeat.o(340233);
    }
    
    public final boolean dVn()
    {
      AppMethodBeat.i(340221);
      boolean bool = b.a(this.ERG);
      AppMethodBeat.o(340221);
      return bool;
    }
    
    public final void dVo() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$innerFetch$3", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements aq.a
  {
    d(int paramInt, b paramb, boolean paramBoolean, ar.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aq.d paramd, List<? extends g> paramList)
    {
      AppMethodBeat.i(340209);
      s.u(paramd, "resp");
      s.u(paramList, "interceptors");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.AEt == 0)
        {
          Log.i("Finder.NearbyVideoFeedFetcher", "tabType=" + jdField_this.hJx + " headWording=" + paramd.aafa + " endWording=" + paramd.aafb + " prefetch_last_feed_count=" + paramd.aafe + " continueFlag:" + paramd.continueFlag);
          h.baE().ban().set(at.a.adcl, paramd.aafa);
          h.baE().ban().set(at.a.adcm, paramd.aafb);
          h.baE().ban().set(at.a.adcp, Integer.valueOf(paramd.aafe));
        }
        if (paramd.aafk != null)
        {
          localObject1 = h.baE().ban();
          localObject2 = at.a.adcn;
          paramList = paramd.aafk;
          if (paramList != null) {
            break label299;
          }
        }
        label299:
        for (paramList = null;; paramList = paramList.toByteArray())
        {
          ((com.tencent.mm.storage.aq)localObject1).set((at.a)localObject2, Util.encodeHexString(paramList));
          paramList = k.aeZF;
          ((com.tencent.mm.plugin.finder.preload.tabPreload.c)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).Ro(jdField_this.hJx);
          paramList = MMApplicationContext.getResources().getString(e.h.finder_timeline_history_header_tip);
          s.s(paramList, "getResources().getString…eline_history_header_tip)");
          paramList = h.baE().ban().get(at.a.adcl, paramList);
          if (paramList != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(340209);
          throw paramString;
        }
        paramList = (String)paramList;
        Object localObject1 = MMApplicationContext.getResources().getString(e.h.finder_timeline_history_footer_tip);
        s.s(localObject1, "getResources().getString…eline_history_footer_tip)");
        localObject1 = h.baE().ban().get(at.a.adcm, localObject1);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(340209);
          throw paramString;
        }
        localObject1 = (String)localObject1;
        Object localObject2 = paramd.object;
        s.s(localObject2, "resp.`object`");
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        Object localObject5;
        Object localObject6;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          localObject5 = (FinderObject)localObject4;
          localObject6 = av.GiL;
          s.s(localObject5, "it");
          if (av.z((FinderObject)localObject5)) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        localObject3 = (List)localObject2;
        if (((List)localObject3).size() < paramd.object.size()) {
          Log.e("Finder.NearbyVideoFeedFetcher", "[onCgiBack] has filter some feed. valid=" + ((List)localObject3).size() + " raw=" + paramd.object.size());
        }
        if (paramd.aafc > 0) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          localObject2 = av.GiL;
          localObject4 = (Iterable)d.a.a((List)localObject3, av.Ui(jdField_this.hJx), b.b(jdField_this));
          localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (FinderItem)((Iterator)localObject4).next();
            localObject6 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            ((Collection)localObject2).add(d.a.a((FinderItem)localObject5));
          }
        }
        Object localObject4 = new LinkedList((Collection)localObject2);
        localObject2 = new com.tencent.mm.plugin.finder.feed.model.d((List)localObject4, paramInt1, paramInt2, paramString);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).hJx = jdField_this.hJx;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).AAs = paramd.AAs;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).qpb = paramd.qpb;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).AAt = paramd.AAt;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).pullType = this.AEt;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).BeH = paramList;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).AZa = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).BeA = paramd.continueFlag;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).Bey = ((List)localObject3);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).BeB = paramd.AAu;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).AEi = b.a(jdField_this);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).lastBuffer = paramd.lastBuffer;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).preloadInfo = paramd.preloadInfo;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).BeD = paramd.aafi;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).Bez = paramd.Bez;
        if (paramd.aafc != 0) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).isNeedClear = bool2;
          ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).BeF = paramd.BeF;
          if (this.AEt != 2)
          {
            paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            paramString = (List)localObject4;
            paramList = av.GiL;
            d.a.c(paramString, av.Ui(jdField_this.hJx), bool1);
          }
          if ((this.AEt == 0) || (this.AEt == 1))
          {
            paramString = ay.EDk;
            ay.D(jdField_this.hJx, (List)localObject3);
          }
          if (this.AEO)
          {
            paramList = h.baE().ban();
            paramString = av.GiL;
            localObject1 = av.Uh(jdField_this.hJx);
            if (paramd.lastBuffer != null) {
              break;
            }
            paramString = null;
            paramList.set((at.a)localObject1, paramString);
          }
          b.a(jdField_this, paramd.AAu);
          parama.a((com.tencent.mm.plugin.finder.feed.model.d)localObject2, this.AEt);
          AppMethodBeat.o(340209);
          return;
        }
        paramString = paramd.lastBuffer;
        if (paramString == null) {}
        for (paramString = null;; paramString = paramString.toByteArray())
        {
          paramString = Util.encodeHexString(paramString);
          break;
        }
      }
      paramString = new com.tencent.mm.plugin.finder.feed.model.d((List)new LinkedList(), paramInt1, paramInt2, paramString);
      paramString.hJx = jdField_this.hJx;
      paramString.pullType = this.AEt;
      paramString.BeA = 1;
      paramString.BeB = paramd.AAu;
      paramString.lastBuffer = paramd.lastBuffer;
      parama.a(paramString, this.AEt);
      AppMethodBeat.o(340209);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.b
 * JD-Core Version:    0.7.0.1
 */