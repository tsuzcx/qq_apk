package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.ar.a;
import com.tencent.mm.plugin.finder.cgi.ar.c;
import com.tencent.mm.plugin.finder.cgi.w.a;
import com.tencent.mm.plugin.finder.feed.af;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cgiSwitcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "getCgiSwitcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "isGetHistory", "", "isHistoryFirstPage", "()Z", "setHistoryFirstPage", "(Z)V", "isShowHistoryTip", "setShowHistoryTip", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "check", "", "isNeedClear", "incrementSize", "retFlag", "pullType", "fetch", "request", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "getHistory", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "isFirstHistoryPage", "extraList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getStream", "originPullType", "showErrorToast", "tip", "", "Callback", "CgiSwitcher", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final c AEg;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> AAh;
  public final b AEh;
  private volatile boolean AEi;
  public boolean AEj;
  public boolean AEk;
  public final bui Auc;
  public final int hJx;
  
  static
  {
    AppMethodBeat.i(336854);
    AEg = new c((byte)0);
    AppMethodBeat.o(336854);
  }
  
  public c(bui parambui)
  {
    AppMethodBeat.i(336818);
    this.hJx = 2;
    this.Auc = parambui;
    this.AEh = new b(this.hJx);
    this.AAh = new com.tencent.mm.vending.e.c();
    this.AEj = true;
    this.AEk = true;
    AppMethodBeat.o(336818);
  }
  
  private static void avd(String paramString)
  {
    AppMethodBeat.i(336829);
    Log.e("Finder.FinderLbsFeedFetcher", paramString);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(paramString));
    }
    AppMethodBeat.o(336829);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(FinderLbsLoader.a parama);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "", "tabType", "", "(I)V", "curCgi", "getCurCgi", "()I", "setCurCgi", "lbsLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLbsLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLbsLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "remainLbsData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getRemainLbsData", "()Ljava/util/LinkedList;", "setRemainLbsData", "(Ljava/util/LinkedList;)V", "streamLastBuffer", "getStreamLastBuffer", "setStreamLastBuffer", "getTabType", "switchToHistory", "", "switchToStream", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public int AEl;
    public b AEm;
    public b AEn;
    LinkedList<com.tencent.mm.plugin.finder.model.c> AEo;
    private final int hJx;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(336840);
      this.hJx = paramInt;
      this.AEl = 1;
      this.AEo = new LinkedList();
      AppMethodBeat.o(336840);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements w.a
  {
    public d(c paramc, c.a parama, ar.c paramc1) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bap parambap, int paramInt3)
    {
      AppMethodBeat.i(336843);
      kotlin.g.b.s.u(parambap, "resp");
      FinderLbsLoader.a locala = new FinderLbsLoader.a(paramInt1, paramInt2, paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.AEp.AEh.AEm = parambap.lastBuffer;
        paramString = parambap.ZLv;
        Object localObject;
        if (paramString == null)
        {
          paramString = null;
          localObject = paramString;
          if (paramString == null) {
            localObject = (List)ab.aivy;
          }
          paramString = com.tencent.mm.plugin.finder.report.s.Fqv;
          com.tencent.mm.plugin.finder.report.s.jdMethod_if(c.a(this.AEp), ((List)localObject).size());
          paramString = locala.getIncrementList();
          if (paramString != null) {
            break label268;
          }
          paramString = null;
          label107:
          Log.i("Finder.FinderLbsFeedFetcher", kotlin.g.b.s.X("incrementList size: ", paramString));
          locala.setIncrementList((List)localObject);
          locala.setPullType(paramInt3);
          locala.setLastBuffer(parambap.lastBuffer);
          if (parambap.continueFlag != 1) {
            break label281;
          }
        }
        label268:
        label281:
        for (boolean bool = true;; bool = false)
        {
          locala.setHasMore(bool);
          this.AEq.a(locala);
          AppMethodBeat.o(336843);
          return;
          localObject = (Iterable)paramString;
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            bqs localbqs = (bqs)((Iterator)localObject).next();
            af localaf = af.AWY;
            kotlin.g.b.s.s(localbqs, "section");
            paramString.add(af.a(localbqs));
          }
          paramString = (List)paramString;
          break;
          paramString = Integer.valueOf(paramString.size());
          break label107;
        }
      }
      locala.setHasMore(true);
      AppMethodBeat.o(336843);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.s<Integer, Integer, String, azd, com.tencent.mm.am.p, ah>
  {
    e(List<? extends FinderObject> paramList, c paramc, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ar.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements ar.a
  {
    public f(c paramc, c.g paramg) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
    {
      AppMethodBeat.i(336844);
      kotlin.g.b.s.u(paramd, "info");
      c localc = this.AEp;
      if (paramd.Bez > 0)
      {
        bool1 = true;
        c.a(localc, bool1);
        localc = this.AEp;
        if (paramd.Bez != 1) {
          break label368;
        }
      }
      label368:
      for (boolean bool1 = true;; bool1 = false)
      {
        localc.AEk = bool1;
        bool1 = paramd.BeB;
        boolean bool2 = paramd.isNeedClear;
        Log.i("Finder.FinderLbsFeedFetcher", "[getStream] tabType=" + c.a(this.AEp) + " isGetHistory=" + c.b(this.AEp) + " isShowHistoryTip=" + this.AEp.AEk + " ret_flag=" + paramd.Bez + " pullType=" + paramInt + " isNeedClear=" + bool2 + " isFetchHistoryNow=" + paramd.BeB + " size=" + paramd.Bex.size() + " errorType=" + paramd.errType + " errorCode=" + paramd.errCode);
        c.b(paramd.isNeedClear, paramd.Bex.size(), paramd.Bez, paramInt);
        if ((paramd.errType != 0) || (paramd.errCode != 0) || (!c.b(this.AEp)) || (!bool1)) {
          break label373;
        }
        this.AEp.AEj = true;
        this.AEp.AEh.AEl = 3;
        c.a(this.AEp, (ar.a)this.AEx, this.AEp.AEj, paramInt, paramd.Bey, bool2);
        Log.i("Finder.FinderLbsFeedFetcher", "get history to fill... tabType=" + c.a(this.AEp) + " pullType=" + paramInt + " isHistoryFirstPage=" + this.AEp.AEj);
        this.AEp.AEj = false;
        AppMethodBeat.o(336844);
        return;
        bool1 = false;
        break;
      }
      label373:
      if ((paramd.errType == 0) && (paramd.errCode == 0))
      {
        f.Ozc.idkeyStat(1279L, 1L, 1L, false);
        if ((paramd.Bex.isEmpty()) && (!c.b(this.AEp)))
        {
          paramd.BeA = 1;
          c.ave("[finderstream]tabType=" + c.a(this.AEp) + " server error[list=0:ret_flag=0]");
          Log.i("Finder.FinderLbsFeedFetcher", "tabType=" + c.a(this.AEp) + " this time get finderstream return list=" + paramd.Bex.size() + " continue_flag=" + paramd.BeA + " pullType=" + paramInt);
        }
      }
      for (;;)
      {
        this.AEx.a(paramd, paramInt);
        AppMethodBeat.o(336844);
        return;
        ((Collection)paramd.Bex).isEmpty();
        paramd.BeA = 1;
        break;
        f.Ozc.idkeyStat(1279L, 2L, 1L, false);
        paramd.BeA = 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$streamCgiCallback$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements ar.a
  {
    public g(c paramc, int paramInt, c.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
    {
      AppMethodBeat.i(336839);
      kotlin.g.b.s.u(paramd, "info");
      if ((paramd.errType == 0) && (paramd.errCode == 0)) {
        this.AEp.AEh.AEn = paramd.lastBuffer;
      }
      Log.i("Finder.FinderLbsFeedFetcher", kotlin.g.b.s.X("[call] onFetchDone... pullType=", Integer.valueOf(paramInt)));
      if (paramd.BeA != 0) {}
      FinderLbsLoader.a locala;
      for (boolean bool = true;; bool = false)
      {
        locala = new FinderLbsLoader.a(paramd.errType, paramd.errCode, paramd.errMsg);
        localObject = new LinkedList();
        if (!Util.isNullOrNil((List)this.AEp.AEh.AEo))
        {
          ((LinkedList)localObject).addAll((Collection)this.AEp.AEh.AEo);
          this.AEp.AEh.AEo.clear();
        }
        Iterator localIterator = ((Iterable)paramd.Bex).iterator();
        while (localIterator.hasNext())
        {
          cc localcc = (cc)localIterator.next();
          if ((localcc instanceof BaseFinderFeed))
          {
            af localaf = af.AWY;
            ((LinkedList)localObject).add(af.i((BaseFinderFeed)localcc));
          }
        }
      }
      locala.setIncrementList((List)localObject);
      Object localObject = locala.getIncrementList();
      if (localObject == null) {}
      for (localObject = null;; localObject = Integer.valueOf(((List)localObject).size()))
      {
        Log.i("Finder.FinderLbsFeedFetcher", kotlin.g.b.s.X("incrementList size: ", localObject));
        locala.setPullType(this.AEy);
        locala.setLastBuffer(paramd.lastBuffer);
        locala.setHasMore(bool);
        this.AEq.a(locala);
        AppMethodBeat.o(336839);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.c
 * JD-Core Version:    0.7.0.1
 */