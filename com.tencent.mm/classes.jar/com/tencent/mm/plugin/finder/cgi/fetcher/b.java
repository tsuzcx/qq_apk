package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.h.a;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.cgi.n.c;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import d.a.j;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cgiSwitcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "getCgiSwitcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "isGetHistory", "", "isHistoryFirstPage", "()Z", "setHistoryFirstPage", "(Z)V", "isShowHistoryTip", "setShowHistoryTip", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "check", "", "isNeedClear", "incrementSize", "retFlag", "pullType", "fetch", "request", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "getHistory", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "isFirstHistoryPage", "extraList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getStream", "originPullType", "showErrorToast", "tip", "", "Callback", "CgiSwitcher", "Companion", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final c rKz;
  public final int duh;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> rIh;
  public final aqy rIl;
  public final b rKv;
  private volatile boolean rKw;
  public boolean rKx;
  public boolean rKy;
  
  static
  {
    AppMethodBeat.i(201198);
    rKz = new c((byte)0);
    AppMethodBeat.o(201198);
  }
  
  public b(aqy paramaqy)
  {
    AppMethodBeat.i(201197);
    this.duh = 2;
    this.rIl = paramaqy;
    this.rKv = new b(this.duh);
    this.rIh = new com.tencent.mm.vending.e.c();
    this.rKx = true;
    this.rKy = true;
    AppMethodBeat.o(201197);
  }
  
  private static void ahd(String paramString)
  {
    AppMethodBeat.i(201196);
    ad.e("Finder.FinderLbsFeedFetcher", paramString);
    if ((i.IS_FLAVOR_PURPLE) || (i.DEBUG)) {
      com.tencent.mm.ad.c.g((d.g.a.a)new h(paramString));
    }
    AppMethodBeat.o(201196);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(FinderLbsLoader.a parama);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "", "tabType", "", "(I)V", "curCgi", "getCurCgi", "()I", "setCurCgi", "lbsLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLbsLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLbsLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "remainLbsData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getRemainLbsData", "()Ljava/util/LinkedList;", "setRemainLbsData", "(Ljava/util/LinkedList;)V", "streamLastBuffer", "getStreamLastBuffer", "setStreamLastBuffer", "getTabType", "switchToHistory", "", "switchToStream", "plugin-finder_release"})
  public static final class b
  {
    private final int duh;
    public int rKA;
    public com.tencent.mm.bx.b rKB;
    public com.tencent.mm.bx.b rKC;
    LinkedList<com.tencent.mm.plugin.finder.model.c> rKD;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(201189);
      this.duh = paramInt;
      this.rKA = 1;
      this.rKD = new LinkedList();
      AppMethodBeat.o(201189);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static final class d
    implements h.a
  {
    public d(b.a parama, n.c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aoh paramaoh, int paramInt3)
    {
      AppMethodBeat.i(201190);
      p.h(paramaoh, "resp");
      FinderLbsLoader.a locala = new FinderLbsLoader.a(paramInt1, paramInt2, paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.rKE.rKv.rKB = paramaoh.lastBuffer;
        paramString = paramaoh.GmU;
        Object localObject1;
        if (paramString != null)
        {
          localObject1 = (Iterable)paramString;
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (apw)((Iterator)localObject1).next();
            com.tencent.mm.plugin.finder.feed.v localv = com.tencent.mm.plugin.finder.feed.v.rWu;
            p.g(localObject2, "section");
            paramString.add(com.tencent.mm.plugin.finder.feed.v.a((apw)localObject2));
          }
          paramString = (List)paramString;
          localObject1 = com.tencent.mm.plugin.finder.report.e.snY;
          com.tencent.mm.plugin.finder.report.e.jz(b.b(this.rKE), paramString.size());
          Object localObject2 = new StringBuilder("incrementList size: ");
          localObject1 = locala.getIncrementList();
          if (localObject1 == null) {
            break label284;
          }
          localObject1 = Integer.valueOf(((List)localObject1).size());
          label200:
          ad.i("Finder.FinderLbsFeedFetcher", localObject1);
          locala.setIncrementList(paramString);
          locala.setPullType(paramInt3);
          locala.setLastBuffer(paramaoh.lastBuffer);
          if (paramaoh.continueFlag != 1) {
            break label290;
          }
        }
        label284:
        label290:
        for (boolean bool = true;; bool = false)
        {
          locala.setHasMore(bool);
          this.rKF.a(locala);
          AppMethodBeat.o(201190);
          return;
          paramString = (List)d.a.v.MKE;
          break;
          localObject1 = null;
          break label200;
        }
      }
      locala.setHasMore(true);
      AppMethodBeat.o(201190);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "invoke"})
  static final class e
    extends q
    implements s<Integer, Integer, String, anv, n, z>
  {
    e(b paramb, List paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, n.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class f
    implements n.a
  {
    public f(b.g paramg) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(201192);
      p.h(paramb, "info");
      b localb = this.rKE;
      if (paramb.saT > 0)
      {
        bool1 = true;
        b.a(localb, bool1);
        localb = this.rKE;
        if (paramb.saT != 1) {
          break label378;
        }
      }
      label378:
      for (boolean bool1 = true;; bool1 = false)
      {
        localb.rKy = bool1;
        bool1 = paramb.saV;
        boolean bool2 = paramb.isNeedClear;
        ad.i("Finder.FinderLbsFeedFetcher", "[getStream] tabType=" + b.b(this.rKE) + " isGetHistory=" + b.a(this.rKE) + " isShowHistoryTip=" + this.rKE.rKy + " ret_flag=" + paramb.saT + ' ' + "pullType=" + paramInt + " isNeedClear=" + bool2 + " isFetchHistoryNow=" + paramb.saV + ' ' + "size=" + paramb.saR.size() + " errorType=" + paramb.errType + " errorCode=" + paramb.errCode);
        b.b(paramb.isNeedClear, paramb.saR.size(), paramb.saT, paramInt);
        if ((paramb.errType != 0) || (paramb.errCode != 0) || (!b.a(this.rKE)) || (!bool1)) {
          break label383;
        }
        this.rKE.rKx = true;
        this.rKE.rKv.rKA = 3;
        b.a(this.rKE, (n.a)this.rKM, this.rKE.rKx, paramInt, paramb.saS, bool2);
        ad.i("Finder.FinderLbsFeedFetcher", "get history to fill... tabType=" + b.b(this.rKE) + " pullType=" + paramInt + " isHistoryFirstPage=" + this.rKE.rKx);
        this.rKE.rKx = false;
        AppMethodBeat.o(201192);
        return;
        bool1 = false;
        break;
      }
      label383:
      if ((paramb.errType == 0) && (paramb.errCode == 0))
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 1L, 1L, false);
        if ((paramb.saR.isEmpty()) && (!b.a(this.rKE)))
        {
          paramb.saU = 1;
          b.ahe("[finderstream]tabType=" + b.b(this.rKE) + " server error[list=0:ret_flag=0]");
          ad.i("Finder.FinderLbsFeedFetcher", "tabType=" + b.b(this.rKE) + " this time get finderstream return list=" + paramb.saR.size() + " continue_flag=" + paramb.saU + " pullType=" + paramInt);
        }
      }
      for (;;)
      {
        this.rKM.a(paramb, paramInt);
        AppMethodBeat.o(201192);
        return;
        ((Collection)paramb.saR).isEmpty();
        paramb.saU = 1;
        break;
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 2L, 1L, false);
        paramb.saU = 1;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$streamCgiCallback$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class g
    implements n.a
  {
    public g(int paramInt, b.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(201193);
      p.h(paramb, "info");
      if ((paramb.errType == 0) && (paramb.errCode == 0)) {
        this.rKE.rKv.rKC = paramb.lastBuffer;
      }
      ad.i("Finder.FinderLbsFeedFetcher", "[call] onFetchDone... pullType=".concat(String.valueOf(paramInt)));
      if (paramb.saU != 0) {}
      FinderLbsLoader.a locala;
      for (boolean bool = true;; bool = false)
      {
        locala = new FinderLbsLoader.a(paramb.errType, paramb.errCode, paramb.errMsg);
        localObject1 = new LinkedList();
        if (!bt.hj((List)this.rKE.rKv.rKD))
        {
          ((LinkedList)localObject1).addAll((Collection)this.rKE.rKv.rKD);
          this.rKE.rKv.rKD.clear();
        }
        localObject2 = ((Iterable)paramb.saR).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          al localal = (al)((Iterator)localObject2).next();
          if ((localal instanceof BaseFinderFeed))
          {
            com.tencent.mm.plugin.finder.feed.v localv = com.tencent.mm.plugin.finder.feed.v.rWu;
            ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.feed.v.i((BaseFinderFeed)localal));
          }
        }
      }
      locala.setIncrementList((List)localObject1);
      Object localObject2 = new StringBuilder("incrementList size: ");
      Object localObject1 = locala.getIncrementList();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((List)localObject1).size());; localObject1 = null)
      {
        ad.i("Finder.FinderLbsFeedFetcher", localObject1);
        locala.setPullType(this.rKN);
        locala.setLastBuffer(paramb.lastBuffer);
        locala.setHasMore(bool);
        this.rKF.a(locala);
        AppMethodBeat.o(201193);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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