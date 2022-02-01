package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.h.a;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.cgi.n.c;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.s;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cgiSwitcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "getCgiSwitcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "isGetHistory", "", "isHistoryFirstPage", "()Z", "setHistoryFirstPage", "(Z)V", "isShowHistoryTip", "setShowHistoryTip", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "check", "", "isNeedClear", "incrementSize", "retFlag", "pullType", "fetch", "request", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "getHistory", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "isFirstHistoryPage", "extraList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getStream", "originPullType", "showErrorToast", "tip", "", "Callback", "CgiSwitcher", "Companion", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final c rSL;
  public final int dvm;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> rQs;
  public final arn rQw;
  public final b rSH;
  private volatile boolean rSI;
  public boolean rSJ;
  public boolean rSK;
  
  static
  {
    AppMethodBeat.i(201622);
    rSL = new c((byte)0);
    AppMethodBeat.o(201622);
  }
  
  public b(arn paramarn)
  {
    AppMethodBeat.i(201621);
    this.dvm = 2;
    this.rQw = paramarn;
    this.rSH = new b(this.dvm);
    this.rQs = new com.tencent.mm.vending.e.c();
    this.rSJ = true;
    this.rSK = true;
    AppMethodBeat.o(201621);
  }
  
  private static void aia(String paramString)
  {
    AppMethodBeat.i(201620);
    ae.e("Finder.FinderLbsFeedFetcher", paramString);
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.DEBUG)) {
      com.tencent.mm.ac.c.h((d.g.a.a)new h(paramString));
    }
    AppMethodBeat.o(201620);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(FinderLbsLoader.a parama);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "", "tabType", "", "(I)V", "curCgi", "getCurCgi", "()I", "setCurCgi", "lbsLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLbsLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLbsLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "remainLbsData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getRemainLbsData", "()Ljava/util/LinkedList;", "setRemainLbsData", "(Ljava/util/LinkedList;)V", "streamLastBuffer", "getStreamLastBuffer", "setStreamLastBuffer", "getTabType", "switchToHistory", "", "switchToStream", "plugin-finder_release"})
  public static final class b
  {
    private final int dvm;
    public int rSM;
    public com.tencent.mm.bw.b rSN;
    public com.tencent.mm.bw.b rSO;
    LinkedList<com.tencent.mm.plugin.finder.model.c> rSP;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(201613);
      this.dvm = paramInt;
      this.rSM = 1;
      this.rSP = new LinkedList();
      AppMethodBeat.o(201613);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static final class d
    implements h.a
  {
    public d(b.a parama, n.c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aou paramaou, int paramInt3)
    {
      AppMethodBeat.i(201614);
      p.h(paramaou, "resp");
      FinderLbsLoader.a locala = new FinderLbsLoader.a(paramInt1, paramInt2, paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.rSQ.rSH.rSN = paramaou.lastBuffer;
        paramString = paramaou.GGb;
        Object localObject1;
        if (paramString != null)
        {
          localObject1 = (Iterable)paramString;
          paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aqj)((Iterator)localObject1).next();
            com.tencent.mm.plugin.finder.feed.v localv = com.tencent.mm.plugin.finder.feed.v.sff;
            p.g(localObject2, "section");
            paramString.add(com.tencent.mm.plugin.finder.feed.v.a((aqj)localObject2));
          }
          paramString = (List)paramString;
          localObject1 = f.syc;
          f.fJ(b.a(this.rSQ), paramString.size());
          Object localObject2 = new StringBuilder("incrementList size: ");
          localObject1 = locala.getIncrementList();
          if (localObject1 == null) {
            break label284;
          }
          localObject1 = Integer.valueOf(((List)localObject1).size());
          label200:
          ae.i("Finder.FinderLbsFeedFetcher", localObject1);
          locala.setIncrementList(paramString);
          locala.setPullType(paramInt3);
          locala.setLastBuffer(paramaou.lastBuffer);
          if (paramaou.continueFlag != 1) {
            break label290;
          }
        }
        label284:
        label290:
        for (boolean bool = true;; bool = false)
        {
          locala.setHasMore(bool);
          this.rSR.a(locala);
          AppMethodBeat.o(201614);
          return;
          paramString = (List)d.a.v.NhH;
          break;
          localObject1 = null;
          break label200;
        }
      }
      locala.setHasMore(true);
      AppMethodBeat.o(201614);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "invoke"})
  static final class e
    extends q
    implements s<Integer, Integer, String, aoi, n, z>
  {
    e(b paramb, List paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, n.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class f
    implements n.a
  {
    public f(b.g paramg) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(201616);
      p.h(paramb, "info");
      b localb = this.rSQ;
      if (paramb.sjJ > 0)
      {
        bool1 = true;
        b.a(localb, bool1);
        localb = this.rSQ;
        if (paramb.sjJ != 1) {
          break label378;
        }
      }
      label378:
      for (boolean bool1 = true;; bool1 = false)
      {
        localb.rSK = bool1;
        bool1 = paramb.sjL;
        boolean bool2 = paramb.isNeedClear;
        ae.i("Finder.FinderLbsFeedFetcher", "[getStream] tabType=" + b.a(this.rSQ) + " isGetHistory=" + b.b(this.rSQ) + " isShowHistoryTip=" + this.rSQ.rSK + " ret_flag=" + paramb.sjJ + ' ' + "pullType=" + paramInt + " isNeedClear=" + bool2 + " isFetchHistoryNow=" + paramb.sjL + ' ' + "size=" + paramb.sjH.size() + " errorType=" + paramb.errType + " errorCode=" + paramb.errCode);
        b.b(paramb.isNeedClear, paramb.sjH.size(), paramb.sjJ, paramInt);
        if ((paramb.errType != 0) || (paramb.errCode != 0) || (!b.b(this.rSQ)) || (!bool1)) {
          break label383;
        }
        this.rSQ.rSJ = true;
        this.rSQ.rSH.rSM = 3;
        b.a(this.rSQ, (n.a)this.rSY, this.rSQ.rSJ, paramInt, paramb.sjI, bool2);
        ae.i("Finder.FinderLbsFeedFetcher", "get history to fill... tabType=" + b.a(this.rSQ) + " pullType=" + paramInt + " isHistoryFirstPage=" + this.rSQ.rSJ);
        this.rSQ.rSJ = false;
        AppMethodBeat.o(201616);
        return;
        bool1 = false;
        break;
      }
      label383:
      if ((paramb.errType == 0) && (paramb.errCode == 0))
      {
        e.ywz.idkeyStat(1279L, 1L, 1L, false);
        if ((paramb.sjH.isEmpty()) && (!b.b(this.rSQ)))
        {
          paramb.sjK = 1;
          b.aib("[finderstream]tabType=" + b.a(this.rSQ) + " server error[list=0:ret_flag=0]");
          ae.i("Finder.FinderLbsFeedFetcher", "tabType=" + b.a(this.rSQ) + " this time get finderstream return list=" + paramb.sjH.size() + " continue_flag=" + paramb.sjK + " pullType=" + paramInt);
        }
      }
      for (;;)
      {
        this.rSY.a(paramb, paramInt);
        AppMethodBeat.o(201616);
        return;
        ((Collection)paramb.sjH).isEmpty();
        paramb.sjK = 1;
        break;
        e.ywz.idkeyStat(1279L, 2L, 1L, false);
        paramb.sjK = 1;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$streamCgiCallback$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class g
    implements n.a
  {
    public g(int paramInt, b.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(201617);
      p.h(paramb, "info");
      if ((paramb.errType == 0) && (paramb.errCode == 0)) {
        this.rSQ.rSH.rSO = paramb.lastBuffer;
      }
      ae.i("Finder.FinderLbsFeedFetcher", "[call] onFetchDone... pullType=".concat(String.valueOf(paramInt)));
      if (paramb.sjK != 0) {}
      FinderLbsLoader.a locala;
      for (boolean bool = true;; bool = false)
      {
        locala = new FinderLbsLoader.a(paramb.errType, paramb.errCode, paramb.errMsg);
        localObject1 = new LinkedList();
        if (!bu.ht((List)this.rSQ.rSH.rSP))
        {
          ((LinkedList)localObject1).addAll((Collection)this.rSQ.rSH.rSP);
          this.rSQ.rSH.rSP.clear();
        }
        localObject2 = ((Iterable)paramb.sjH).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          am localam = (am)((Iterator)localObject2).next();
          if ((localam instanceof BaseFinderFeed))
          {
            com.tencent.mm.plugin.finder.feed.v localv = com.tencent.mm.plugin.finder.feed.v.sff;
            ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.feed.v.i((BaseFinderFeed)localam));
          }
        }
      }
      locala.setIncrementList((List)localObject1);
      Object localObject2 = new StringBuilder("incrementList size: ");
      Object localObject1 = locala.getIncrementList();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((List)localObject1).size());; localObject1 = null)
      {
        ae.i("Finder.FinderLbsFeedFetcher", localObject1);
        locala.setPullType(this.rSZ);
        locala.setLastBuffer(paramb.lastBuffer);
        locala.setHasMore(bool);
        this.rSR.a(locala);
        AppMethodBeat.o(201617);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.b
 * JD-Core Version:    0.7.0.1
 */