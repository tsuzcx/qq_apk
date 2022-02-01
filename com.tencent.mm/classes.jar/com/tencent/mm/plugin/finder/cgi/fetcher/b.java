package com.tencent.mm.plugin.finder.cgi.fetcher;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.k.a;
import com.tencent.mm.plugin.finder.cgi.k.d;
import com.tencent.mm.plugin.finder.cgi.l.a;
import com.tencent.mm.plugin.finder.cgi.l.c;
import com.tencent.mm.plugin.finder.feed.model.internal.j.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.view.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vending.e.c;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "isGetHistory", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "pageDataBuffer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "getPageDataBuffer", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "getTabType", "()I", "fetch", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "fetchHotRelatedList", "feedId", "", "nonceId", "", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "innerFetch", "lb", "uniqueId", "Companion", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final a qZq;
  public final anm contextObj;
  public final int diw;
  public c<com.tencent.mm.vending.e.a> qXf;
  private volatile boolean qYX;
  public final com.tencent.mm.plugin.finder.feed.model.internal.j<BaseFinderFeed, com.tencent.mm.plugin.finder.feed.model.a> qZp;
  
  static
  {
    AppMethodBeat.i(201245);
    qZq = new a((byte)0);
    AppMethodBeat.o(201245);
  }
  
  public b(int paramInt, anm paramanm)
  {
    AppMethodBeat.i(201244);
    this.diw = paramInt;
    this.contextObj = paramanm;
    this.qXf = new c();
    this.qZp = new com.tencent.mm.plugin.finder.feed.model.internal.j(null, String.valueOf(this.diw), 1);
    AppMethodBeat.o(201244);
  }
  
  private final void a(final l.a parama, final int paramInt, final l.c paramc, com.tencent.mm.bw.b paramb)
  {
    final boolean bool = true;
    AppMethodBeat.i(201243);
    if ((paramInt == 0) || (paramInt == 1)) {
      this.qYX = false;
    }
    if (paramb == null) {}
    while (bool)
    {
      ac.i("Finder.TimelineFeedFetcher", "[innerFetch] use tabType=" + this.diw + " GlobalLastBuffer");
      if (paramInt == 0)
      {
        paramb = g.agR();
        d.g.b.k.g(paramb, "MMKernel.storage()");
        paramb = paramb.agA();
        localn = n.rPN;
        paramb.set(n.EI(this.diw), null);
      }
      paramb = g.agR();
      d.g.b.k.g(paramb, "MMKernel.storage()");
      paramb = paramb.agA();
      n localn = n.rPN;
      paramb = paramb.get(n.EI(this.diw), "");
      if (paramb == null)
      {
        parama = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201243);
        throw parama;
        bool = false;
      }
      else
      {
        paramb = com.tencent.mm.bw.b.cc(bs.aLu((String)paramb));
      }
    }
    com.tencent.mm.plugin.finder.cgi.k.a(new com.tencent.mm.plugin.finder.cgi.k(this.diw, paramInt, paramb, this.contextObj), this.qXf, (k.a)new g(this, paramc, paramInt, bool, parama));
    AppMethodBeat.o(201243);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class b
    implements l.a
  {
    b(l.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.a parama, int paramInt)
    {
      AppMethodBeat.i(201232);
      d.g.b.k.h(parama, "info");
      j.c localc = new j.c(new LinkedList((Collection)parama.incrementList));
      localc.rov = parama;
      this.qZr.qZp.a(localc);
      parama.rmw = this.qZr.qZp.cvG();
      this.qZm.a(parama, paramInt);
      parama = new vw();
      parama.dyL.diw = this.qZr.diw;
      parama.dyL.dyM = this.qZr.qZp.length;
      i.a(parama);
      AppMethodBeat.o(201232);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$innerFetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "plugin-finder_release"})
  public static final class g
    implements k.a
  {
    g(l.c paramc, int paramInt, boolean paramBoolean, l.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, k.d paramd)
    {
      AppMethodBeat.i(201241);
      d.g.b.k.h(paramd, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramInt == 0)
        {
          ac.i("Finder.TimelineFeedFetcher", "tabType=" + this.qZr.diw + " headWording=" + paramd.rmp + " endWording=" + paramd.rmq + " prefetch_last_feed_count=" + paramd.EHi + '}');
          localObject1 = g.agR();
          d.g.b.k.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).agA().set(ah.a.GUQ, paramd.rmp);
          localObject1 = g.agR();
          d.g.b.k.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).agA().set(ah.a.GUR, paramd.rmq);
          localObject1 = g.agR();
          d.g.b.k.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).agA().set(ah.a.GUU, Integer.valueOf(paramd.EHi));
        }
        if (paramd.EHp != null)
        {
          localObject1 = g.agR();
          d.g.b.k.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).agA().set(ah.a.GUS, bs.cx(paramd.EHp.toByteArray()));
        }
        Object localObject1 = ai.getResources().getString(2131759371);
        Object localObject2 = g.agR();
        d.g.b.k.g(localObject2, "MMKernel.storage()");
        localObject1 = ((e)localObject2).agA().get(ah.a.GUQ, localObject1);
        if (localObject1 == null)
        {
          paramString = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(201241);
          throw paramString;
        }
        localObject2 = (String)localObject1;
        localObject1 = ai.getResources().getString(2131759370);
        Object localObject3 = g.agR();
        d.g.b.k.g(localObject3, "MMKernel.storage()");
        localObject1 = ((e)localObject3).agA().get(ah.a.GUR, localObject1);
        if (localObject1 == null)
        {
          paramString = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(201241);
          throw paramString;
        }
        localObject3 = (String)localObject1;
        if ((!b.b(this.qZr)) && (paramd.qXo) && (paramd.qXn > 0) && (this.qZr.diw != 2) && (this.qZr.diw != 4) && ((paramInt == 2) || (((paramInt == 1) || (paramInt == 0)) && (paramd.qXm > 0))))
        {
          if (paramd.rmr != 1) {
            break label703;
          }
          i = 1;
          localObject4 = new FinderObject();
          ((FinderObject)localObject4).username = "";
          ((FinderObject)localObject4).objectDesc = new FinderObjectDesc();
          ((FinderObject)localObject4).objectDesc.mediaType = 9999;
          ((FinderObject)localObject4).objectDesc.description = ((String)localObject2);
          localObject5 = ((FinderObject)localObject4).objectDesc;
          if (i == 0) {
            break label709;
          }
        }
        Object localObject6;
        Object localObject7;
        label703:
        label709:
        for (localObject1 = "1";; localObject1 = "2")
        {
          ((FinderObjectDesc)localObject5).description = ((String)localObject1);
          ((FinderObject)localObject4).contact = new FinderContact();
          ((FinderObject)localObject4).contact.username = ((FinderObject)localObject4).username;
          paramd.object.add(paramd.qXm, localObject4);
          ac.i("Finder.TimelineFeedFetcher", "tabType=" + this.qZr.diw + " add history header[" + (String)localObject2);
          localObject1 = paramd.object;
          d.g.b.k.g(localObject1, "resp.`object`");
          localObject4 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = ((Iterator)localObject4).next();
            localObject6 = (FinderObject)localObject5;
            localObject7 = n.rPN;
            d.g.b.k.g(localObject6, "it");
            if (n.n((FinderObject)localObject6)) {
              ((Collection)localObject1).add(localObject5);
            }
          }
          i = 0;
          break;
        }
        Object localObject4 = (List)localObject1;
        if (((List)localObject4).size() < paramd.object.size()) {
          ac.e("Finder.TimelineFeedFetcher", "[onCgiBack] has filter some feed. valid=" + ((List)localObject4).size() + " raw=" + paramd.object.size());
        }
        if (paramd.EHg > 0)
        {
          bool1 = true;
          if (paramd.qXl != 0)
          {
            localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
            if (com.tencent.mm.plugin.finder.storage.b.czQ() != 1) {
              break label964;
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
          localObject1 = n.rPN;
          i = n.EJ(this.qZr.diw);
          if (paramInt == 2) {
            break label958;
          }
        }
        label958:
        for (boolean bool2 = true;; bool2 = false)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.a.a((List)localObject4, i, bool2, null, bool1, b.a(this.qZr), 40);
          localObject5 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject5, 10));
          localObject5 = ((Iterable)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (FinderItem)((Iterator)localObject5).next();
            localObject7 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
            ((Collection)localObject1).add(com.tencent.mm.plugin.finder.storage.logic.b.a.i((FinderItem)localObject6));
          }
          bool1 = false;
          break;
        }
        label964:
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        localObject1 = n.rPN;
        int i = n.EJ(this.qZr.diw);
        if (paramInt != 2) {}
        for (bool2 = true;; bool2 = false)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.a.a((List)localObject4, i, bool2, null, bool1, b.a(this.qZr), 40);
          break;
        }
        Object localObject5 = (List)localObject1;
        if ((paramInt == 0) || (paramInt == 1))
        {
          localObject1 = com.tencent.mm.plugin.finder.model.v.rve;
          com.tencent.mm.plugin.finder.model.v.h(this.qZr.diw, (List)localObject4);
        }
        b.a(this.qZr, paramd.qXo);
        if (bool)
        {
          localObject1 = g.agR();
          d.g.b.k.g(localObject1, "MMKernel.storage()");
          localObject6 = ((e)localObject1).agA();
          localObject1 = n.rPN;
          localObject7 = n.EI(this.qZr.diw);
          if (paramd.lastBuffer == null)
          {
            localObject1 = null;
            ((ae)localObject6).set((ah.a)localObject7, localObject1);
          }
        }
        else
        {
          paramString = new com.tencent.mm.plugin.finder.feed.model.a((List)localObject5, (String)localObject2, (String)localObject3, paramInt1, paramInt2, paramString);
          paramString.pullType = paramInt;
          paramString.qXl = paramd.qXl;
          paramString.rmo = ((List)localObject4);
          paramString.rms = paramd.qXo;
          paramString.lastBuffer = paramd.lastBuffer;
          paramString.rmt = paramd.rmt;
          paramString.rmv = paramd.EHn;
          paramString.rmr = paramd.rmr;
          if (paramd.EHg == 0) {
            break label1281;
          }
        }
        label1281:
        for (boolean bool1 = true;; bool1 = false)
        {
          paramString.isNeedClear = bool1;
          parama.a(paramString, paramInt);
          AppMethodBeat.o(201241);
          return;
          localObject1 = bs.cx(paramd.lastBuffer.toByteArray());
          break;
        }
      }
      paramString = new com.tencent.mm.plugin.finder.feed.model.a((List)new LinkedList(), "", "", paramInt1, paramInt2, paramString);
      paramString.pullType = paramInt;
      paramString.qXl = 1;
      paramString.rms = paramd.qXo;
      paramString.lastBuffer = paramd.lastBuffer;
      parama.a(paramString, paramInt);
      AppMethodBeat.o(201241);
    }
    
    public final void a(aod paramaod)
    {
      AppMethodBeat.i(201240);
      d.g.b.k.h(paramaod, "request");
      AppMethodBeat.o(201240);
    }
    
    public final boolean b(int paramInt1, int paramInt2, cqk paramcqk)
    {
      AppMethodBeat.i(201239);
      d.g.b.k.h(paramcqk, "resp");
      l.c localc = paramc;
      if (localc != null)
      {
        boolean bool = localc.c(paramInt1, paramInt2, paramcqk);
        AppMethodBeat.o(201239);
        return bool;
      }
      AppMethodBeat.o(201239);
      return false;
    }
    
    public final boolean csh()
    {
      AppMethodBeat.i(201238);
      boolean bool = b.b(this.qZr);
      AppMethodBeat.o(201238);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.b
 * JD-Core Version:    0.7.0.1
 */