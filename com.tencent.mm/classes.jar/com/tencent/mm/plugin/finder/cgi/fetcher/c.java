package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.q.a;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cgiSwitcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "getCgiSwitcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "isGetHistory", "", "isHistoryFirstPage", "()Z", "setHistoryFirstPage", "(Z)V", "isShowHistoryTip", "setShowHistoryTip", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "check", "", "isNeedClear", "incrementSize", "retFlag", "pullType", "fetch", "request", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "getHistory", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "isFirstHistoryPage", "extraList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getStream", "originPullType", "showErrorToast", "tip", "", "Callback", "CgiSwitcher", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final c xfc;
  public final int fEH;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> xbq;
  public final bid xbu;
  public final b xeY;
  private volatile boolean xeZ;
  public boolean xfa;
  public boolean xfb;
  
  static
  {
    AppMethodBeat.i(266664);
    xfc = new c((byte)0);
    AppMethodBeat.o(266664);
  }
  
  public c(bid parambid)
  {
    AppMethodBeat.i(266663);
    this.fEH = 2;
    this.xbu = parambid;
    this.xeY = new b(this.fEH);
    this.xbq = new com.tencent.mm.vending.e.c();
    this.xfa = true;
    this.xfb = true;
    AppMethodBeat.o(266663);
  }
  
  private static void aAU(String paramString)
  {
    AppMethodBeat.i(266659);
    Log.e("Finder.FinderLbsFeedFetcher", paramString);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(paramString));
    }
    AppMethodBeat.o(266659);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(FinderLbsLoader.a parama);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "", "tabType", "", "(I)V", "curCgi", "getCurCgi", "()I", "setCurCgi", "lbsLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLbsLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLbsLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "remainLbsData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getRemainLbsData", "()Ljava/util/LinkedList;", "setRemainLbsData", "(Ljava/util/LinkedList;)V", "streamLastBuffer", "getStreamLastBuffer", "setStreamLastBuffer", "getTabType", "switchToHistory", "", "switchToStream", "plugin-finder_release"})
  public static final class b
  {
    private final int fEH;
    public int xfd;
    public b xfe;
    public b xff;
    LinkedList<com.tencent.mm.plugin.finder.model.c> xfg;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(291753);
      this.fEH = paramInt;
      this.xfd = 1;
      this.xfg = new LinkedList();
      AppMethodBeat.o(291753);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static final class d
    implements q.a
  {
    public d(c.a parama, ab.c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, avp paramavp, int paramInt3)
    {
      AppMethodBeat.i(291246);
      p.k(paramavp, "resp");
      FinderLbsLoader.a locala = new FinderLbsLoader.a(paramInt1, paramInt2, paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.xfh.xeY.xfe = paramavp.lastBuffer;
        paramString = paramavp.SHU;
        Object localObject1;
        if (paramString != null)
        {
          localObject1 = (Iterable)paramString;
          paramString = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bfl)((Iterator)localObject1).next();
            ab localab = ab.xzy;
            p.j(localObject2, "section");
            paramString.add(ab.a((bfl)localObject2));
          }
          paramString = (List)paramString;
          localObject1 = com.tencent.mm.plugin.finder.report.j.zVy;
          com.tencent.mm.plugin.finder.report.j.gP(c.a(this.xfh), paramString.size());
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
          locala.setLastBuffer(paramavp.lastBuffer);
          if (paramavp.continueFlag != 1) {
            break label290;
          }
        }
        label284:
        label290:
        for (boolean bool = true;; bool = false)
        {
          locala.setHasMore(bool);
          this.xfi.a(locala);
          AppMethodBeat.o(291246);
          return;
          paramString = (List)v.aaAd;
          break;
          localObject1 = null;
          break label200;
        }
      }
      locala.setHasMore(true);
      AppMethodBeat.o(291246);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements s<Integer, Integer, String, aul, com.tencent.mm.an.q, x>
  {
    e(c paramc, List paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ab.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class f
    implements ab.a
  {
    public f(c.g paramg) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
    {
      AppMethodBeat.i(286717);
      p.k(paramd, "info");
      c localc = this.xfh;
      if (paramd.xFH > 0)
      {
        bool1 = true;
        c.a(localc, bool1);
        localc = this.xfh;
        if (paramd.xFH != 1) {
          break label378;
        }
      }
      label378:
      for (boolean bool1 = true;; bool1 = false)
      {
        localc.xfb = bool1;
        bool1 = paramd.xFJ;
        boolean bool2 = paramd.isNeedClear;
        Log.i("Finder.FinderLbsFeedFetcher", "[getStream] tabType=" + c.a(this.xfh) + " isGetHistory=" + c.b(this.xfh) + " isShowHistoryTip=" + this.xfh.xfb + " ret_flag=" + paramd.xFH + ' ' + "pullType=" + paramInt + " isNeedClear=" + bool2 + " isFetchHistoryNow=" + paramd.xFJ + ' ' + "size=" + paramd.xFF.size() + " errorType=" + paramd.errType + " errorCode=" + paramd.errCode);
        c.b(paramd.isNeedClear, paramd.xFF.size(), paramd.xFH, paramInt);
        if ((paramd.errType != 0) || (paramd.errCode != 0) || (!c.b(this.xfh)) || (!bool1)) {
          break label383;
        }
        this.xfh.xfa = true;
        this.xfh.xeY.xfd = 3;
        c.a(this.xfh, (ab.a)this.xfp, this.xfh.xfa, paramInt, paramd.xFG, bool2);
        Log.i("Finder.FinderLbsFeedFetcher", "get history to fill... tabType=" + c.a(this.xfh) + " pullType=" + paramInt + " isHistoryFirstPage=" + this.xfh.xfa);
        this.xfh.xfa = false;
        AppMethodBeat.o(286717);
        return;
        bool1 = false;
        break;
      }
      label383:
      if ((paramd.errType == 0) && (paramd.errCode == 0))
      {
        f.Iyx.idkeyStat(1279L, 1L, 1L, false);
        if ((paramd.xFF.isEmpty()) && (!c.b(this.xfh)))
        {
          paramd.xFI = 1;
          c.aAV("[finderstream]tabType=" + c.a(this.xfh) + " server error[list=0:ret_flag=0]");
          Log.i("Finder.FinderLbsFeedFetcher", "tabType=" + c.a(this.xfh) + " this time get finderstream return list=" + paramd.xFF.size() + " continue_flag=" + paramd.xFI + " pullType=" + paramInt);
        }
      }
      for (;;)
      {
        this.xfp.a(paramd, paramInt);
        AppMethodBeat.o(286717);
        return;
        ((Collection)paramd.xFF).isEmpty();
        paramd.xFI = 1;
        break;
        f.Iyx.idkeyStat(1279L, 2L, 1L, false);
        paramd.xFI = 1;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$streamCgiCallback$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class g
    implements ab.a
  {
    public g(int paramInt, c.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
    {
      AppMethodBeat.i(266118);
      p.k(paramd, "info");
      if ((paramd.errType == 0) && (paramd.errCode == 0)) {
        this.xfh.xeY.xff = paramd.lastBuffer;
      }
      Log.i("Finder.FinderLbsFeedFetcher", "[call] onFetchDone... pullType=".concat(String.valueOf(paramInt)));
      if (paramd.xFI != 0) {}
      FinderLbsLoader.a locala;
      for (boolean bool = true;; bool = false)
      {
        locala = new FinderLbsLoader.a(paramd.errType, paramd.errCode, paramd.errMsg);
        localObject1 = new LinkedList();
        if (!Util.isNullOrNil((List)this.xfh.xeY.xfg))
        {
          ((LinkedList)localObject1).addAll((Collection)this.xfh.xeY.xfg);
          this.xfh.xeY.xfg.clear();
        }
        localObject2 = ((Iterable)paramd.xFF).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bu localbu = (bu)((Iterator)localObject2).next();
          if ((localbu instanceof BaseFinderFeed))
          {
            ab localab = ab.xzy;
            ((LinkedList)localObject1).add(ab.n((BaseFinderFeed)localbu));
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
        locala.setPullType(this.xfq);
        locala.setLastBuffer(paramd.lastBuffer);
        locala.setHasMore(bool);
        this.xfi.a(locala);
        AppMethodBeat.o(266118);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.c
 * JD-Core Version:    0.7.0.1
 */