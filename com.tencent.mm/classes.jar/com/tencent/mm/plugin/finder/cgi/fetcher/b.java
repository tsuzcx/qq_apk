package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader.a;
import com.tencent.mm.plugin.finder.feed.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cgiSwitcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "getCgiSwitcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "isGetHistory", "", "isHistoryFirstPage", "()Z", "setHistoryFirstPage", "(Z)V", "isShowHistoryTip", "setShowHistoryTip", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "check", "", "isNeedClear", "incrementSize", "retFlag", "pullType", "fetch", "request", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "getHistory", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "isFirstHistoryPage", "extraList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getStream", "originPullType", "showErrorToast", "tip", "", "Callback", "CgiSwitcher", "Companion", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final c txc;
  public final int dLS;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> ttK;
  public final bbn ttO;
  public final b twY;
  private volatile boolean twZ;
  public boolean txa;
  public boolean txb;
  
  static
  {
    AppMethodBeat.i(242595);
    txc = new c((byte)0);
    AppMethodBeat.o(242595);
  }
  
  public b(bbn parambbn)
  {
    AppMethodBeat.i(242594);
    this.dLS = 2;
    this.ttO = parambbn;
    this.twY = new b(this.dLS);
    this.ttK = new com.tencent.mm.vending.e.c();
    this.txa = true;
    this.txb = true;
    AppMethodBeat.o(242594);
  }
  
  private static void asN(String paramString)
  {
    AppMethodBeat.i(242593);
    Log.e("Finder.FinderLbsFeedFetcher", paramString);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)) {
      d.h((kotlin.g.a.a)new h(paramString));
    }
    AppMethodBeat.o(242593);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(FinderLbsLoader.a parama);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "", "tabType", "", "(I)V", "curCgi", "getCurCgi", "()I", "setCurCgi", "lbsLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLbsLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLbsLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "remainLbsData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getRemainLbsData", "()Ljava/util/LinkedList;", "setRemainLbsData", "(Ljava/util/LinkedList;)V", "streamLastBuffer", "getStreamLastBuffer", "setStreamLastBuffer", "getTabType", "switchToHistory", "", "switchToStream", "plugin-finder_release"})
  public static final class b
  {
    private final int dLS;
    public int txd;
    public com.tencent.mm.bw.b txe;
    public com.tencent.mm.bw.b txf;
    LinkedList<com.tencent.mm.plugin.finder.model.c> txg;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(242586);
      this.dLS = paramInt;
      this.txd = 1;
      this.txg = new LinkedList();
      AppMethodBeat.o(242586);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static final class d
    implements n.a
  {
    public d(b.a parama, ab.c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, atm paramatm, int paramInt3)
    {
      AppMethodBeat.i(242587);
      p.h(paramatm, "resp");
      FinderLbsLoader.a locala = new FinderLbsLoader.a(paramInt1, paramInt2, paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.txh.twY.txe = paramatm.lastBuffer;
        paramString = paramatm.LEm;
        Object localObject1;
        if (paramString != null)
        {
          localObject1 = (Iterable)paramString;
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (azm)((Iterator)localObject1).next();
            w localw = w.tOM;
            p.g(localObject2, "section");
            paramString.add(w.a((azm)localObject2));
          }
          paramString = (List)paramString;
          localObject1 = h.veu;
          h.gd(b.a(this.txh), paramString.size());
          Object localObject2 = new StringBuilder("incrementList size: ");
          localObject1 = locala.getIncrementList();
          if (localObject1 == null) {
            break label284;
          }
          localObject1 = Integer.valueOf(((List)localObject1).size());
          label200:
          Log.i("Finder.FinderLbsFeedFetcher", localObject1);
          locala.setIncrementList(paramString);
          locala.setPullType(paramInt3);
          locala.setLastBuffer(paramatm.lastBuffer);
          if (paramatm.continueFlag != 1) {
            break label290;
          }
        }
        label284:
        label290:
        for (boolean bool = true;; bool = false)
        {
          locala.setHasMore(bool);
          this.txi.a(locala);
          AppMethodBeat.o(242587);
          return;
          paramString = (List)v.SXr;
          break;
          localObject1 = null;
          break label200;
        }
      }
      locala.setHasMore(true);
      AppMethodBeat.o(242587);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements s<Integer, Integer, String, ask, com.tencent.mm.ak.q, x>
  {
    e(b paramb, List paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ab.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class f
    implements ab.a
  {
    public f(b.g paramg) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(242589);
      p.h(paramb, "info");
      b localb = this.txh;
      if (paramb.tUB > 0)
      {
        bool1 = true;
        b.a(localb, bool1);
        localb = this.txh;
        if (paramb.tUB != 1) {
          break label378;
        }
      }
      label378:
      for (boolean bool1 = true;; bool1 = false)
      {
        localb.txb = bool1;
        bool1 = paramb.tUD;
        boolean bool2 = paramb.isNeedClear;
        Log.i("Finder.FinderLbsFeedFetcher", "[getStream] tabType=" + b.a(this.txh) + " isGetHistory=" + b.b(this.txh) + " isShowHistoryTip=" + this.txh.txb + " ret_flag=" + paramb.tUB + ' ' + "pullType=" + paramInt + " isNeedClear=" + bool2 + " isFetchHistoryNow=" + paramb.tUD + ' ' + "size=" + paramb.tUz.size() + " errorType=" + paramb.errType + " errorCode=" + paramb.errCode);
        b.b(paramb.isNeedClear, paramb.tUz.size(), paramb.tUB, paramInt);
        if ((paramb.errType != 0) || (paramb.errCode != 0) || (!b.b(this.txh)) || (!bool1)) {
          break label383;
        }
        this.txh.txa = true;
        this.txh.twY.txd = 3;
        b.a(this.txh, (ab.a)this.txp, this.txh.txa, paramInt, paramb.tUA, bool2);
        Log.i("Finder.FinderLbsFeedFetcher", "get history to fill... tabType=" + b.a(this.txh) + " pullType=" + paramInt + " isHistoryFirstPage=" + this.txh.txa);
        this.txh.txa = false;
        AppMethodBeat.o(242589);
        return;
        bool1 = false;
        break;
      }
      label383:
      if ((paramb.errType == 0) && (paramb.errCode == 0))
      {
        e.Cxv.idkeyStat(1279L, 1L, 1L, false);
        if ((paramb.tUz.isEmpty()) && (!b.b(this.txh)))
        {
          paramb.tUC = 1;
          b.asO("[finderstream]tabType=" + b.a(this.txh) + " server error[list=0:ret_flag=0]");
          Log.i("Finder.FinderLbsFeedFetcher", "tabType=" + b.a(this.txh) + " this time get finderstream return list=" + paramb.tUz.size() + " continue_flag=" + paramb.tUC + " pullType=" + paramInt);
        }
      }
      for (;;)
      {
        this.txp.a(paramb, paramInt);
        AppMethodBeat.o(242589);
        return;
        ((Collection)paramb.tUz).isEmpty();
        paramb.tUC = 1;
        break;
        e.Cxv.idkeyStat(1279L, 2L, 1L, false);
        paramb.tUC = 1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$streamCgiCallback$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class g
    implements ab.a
  {
    public g(int paramInt, b.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(242590);
      p.h(paramb, "info");
      if ((paramb.errType == 0) && (paramb.errCode == 0)) {
        this.txh.twY.txf = paramb.lastBuffer;
      }
      Log.i("Finder.FinderLbsFeedFetcher", "[call] onFetchDone... pullType=".concat(String.valueOf(paramInt)));
      if (paramb.tUC != 0) {}
      FinderLbsLoader.a locala;
      for (boolean bool = true;; bool = false)
      {
        locala = new FinderLbsLoader.a(paramb.errType, paramb.errCode, paramb.errMsg);
        localObject1 = new LinkedList();
        if (!Util.isNullOrNil((List)this.txh.twY.txg))
        {
          ((LinkedList)localObject1).addAll((Collection)this.txh.twY.txg);
          this.txh.twY.txg.clear();
        }
        localObject2 = ((Iterable)paramb.tUz).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bo localbo = (bo)((Iterator)localObject2).next();
          if ((localbo instanceof BaseFinderFeed))
          {
            w localw = w.tOM;
            ((LinkedList)localObject1).add(w.m((BaseFinderFeed)localbo));
          }
        }
      }
      locala.setIncrementList((List)localObject1);
      Object localObject2 = new StringBuilder("incrementList size: ");
      Object localObject1 = locala.getIncrementList();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((List)localObject1).size());; localObject1 = null)
      {
        Log.i("Finder.FinderLbsFeedFetcher", localObject1);
        locala.setPullType(this.txq);
        locala.setLastBuffer(paramb.lastBuffer);
        locala.setHasMore(bool);
        this.txi.a(locala);
        AppMethodBeat.o(242590);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.b
 * JD-Core Version:    0.7.0.1
 */