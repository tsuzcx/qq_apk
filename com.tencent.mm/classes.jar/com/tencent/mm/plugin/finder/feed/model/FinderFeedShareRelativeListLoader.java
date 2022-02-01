package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.bk;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.bv;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "encryptedFeedId", "", "nonceId", "tabType", "", "isFromAd", "", "shareScene", "sessionId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPostingScene", "(JLjava/lang/String;Ljava/lang/String;IZILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getEncryptedFeedId", "()Ljava/lang/String;", "getFeedId", "()J", "setFeedId", "(J)V", "fetchCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchCallback", "(Lkotlin/jvm/functions/Function1;)V", "fetchEndCallback", "getFetchEndCallback", "setFetchEndCallback", "finderUserName", "getFinderUserName", "setFinderUserName", "(Ljava/lang/String;)V", "fromUserName", "getFromUserName", "setFromUserName", "hasRefreshFinish", "getHasRefreshFinish", "()Z", "setHasRefreshFinish", "(Z)V", "isOpenEntranceTipShown", "setOpenEntranceTipShown", "getNonceId", "getSessionId", "getShareScene", "()I", "getTabType", "toUserName", "getToUserName", "setToUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "isObservePostEvent", "onFetchDone", "response", "Companion", "FeedShareRelDataFetcher", "FinderShareRelativeListResponse", "UserPageDataFetcher", "plugin-finder_release"})
public final class FinderFeedShareRelativeListLoader
  extends BaseFinderFeedLoader
{
  public static final a xGY;
  public String fCl;
  final int fEH;
  public String fSj;
  public long feedId;
  public b<? super IResponse<bu>, x> fetchEndCallback;
  final String nonceId;
  final String sessionId;
  final int shareScene;
  public String whH;
  public boolean xGU;
  public b<? super IResponse<bu>, x> xGV;
  private boolean xGW;
  private final boolean xGX;
  final String xcr;
  final boolean xxP;
  
  static
  {
    AppMethodBeat.i(275501);
    xGY = new a((byte)0);
    AppMethodBeat.o(275501);
  }
  
  public FinderFeedShareRelativeListLoader(long paramLong, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString3, bid parambid, boolean paramBoolean2)
  {
    super(parambid);
    AppMethodBeat.i(275500);
    this.feedId = paramLong;
    this.xcr = paramString1;
    this.nonceId = paramString2;
    this.fEH = paramInt1;
    this.xGX = paramBoolean1;
    this.shareScene = paramInt2;
    this.sessionId = paramString3;
    this.xxP = paramBoolean2;
    this.whH = "";
    this.fSj = "";
    this.fCl = "";
    AppMethodBeat.o(275500);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<bu> createDataFetch()
  {
    AppMethodBeat.i(275497);
    if (this.xGX)
    {
      locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new d();
      AppMethodBeat.o(275497);
      return locali;
    }
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new b();
    AppMethodBeat.o(275497);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(275498);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new e(this);
    AppMethodBeat.o(275498);
    return locald;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(275499);
    p.k(paramIResponse, "response");
    if (paramIResponse.getPullType() == 0)
    {
      this.xGW = true;
      Log.d(getTAG(), "refresh finish");
    }
    if ((paramIResponse.getPullType() == 2) && (!this.xGW))
    {
      Log.d(getTAG(), "loadmore before refresh");
      AppMethodBeat.o(275499);
      return;
    }
    if (!isInitOperation(paramIResponse))
    {
      localb = this.xGV;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    if (paramIResponse.getPullType() == 0) {
      paramIResponse.setPullType(2);
    }
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(275499);
      return;
    }
    b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(275499);
      return;
    }
    AppMethodBeat.o(275499);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$Companion;", "", "()V", "TYPE_GUIDE", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "TaskDataCallbackWrapper", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    private final com.tencent.mm.loader.g.i xeM;
    
    public b()
    {
      AppMethodBeat.i(287773);
      this.xeM = new com.tencent.mm.loader.g.i("FeedShareRelData");
      AppMethodBeat.o(287773);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(287768);
      super.alive();
      this.xeM.start();
      AppMethodBeat.o(287768);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(287769);
      super.dead();
      this.xeM.stop();
      AppMethodBeat.o(287769);
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(287772);
      p.k(paramq, "scene");
      if ((paramq instanceof bk))
      {
        final aa.a locala = new aa.a();
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        FinderFeedShareRelativeListLoader.c localc;
        Object localObject4;
        for (boolean bool = ((bk)paramq).dod();; bool = true)
        {
          locala.aaBx = bool;
          localc = new FinderFeedShareRelativeListLoader.c(paramInt1, paramInt2, paramString, "");
          localObject2 = ((bk)paramq).dof();
          paramString = this.xGZ.getContextObj();
          if (paramString == null) {
            break;
          }
          localObject1 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject1).next();
            localObject4 = n.zWF;
            n.a((FinderObject)localObject3, paramString.xkX);
          }
          localObject1 = com.tencent.mm.plugin.finder.report.j.zVy;
          com.tencent.mm.plugin.finder.report.j.d(this.xGZ.fEH, this.xGZ.getContextObj());
        }
        Object localObject1 = kotlin.a.j.lp((List)this.xGZ.getDataList());
        paramString = (String)localObject1;
        if (!(localObject1 instanceof BaseFinderFeed)) {
          paramString = null;
        }
        paramString = (BaseFinderFeed)paramString;
        if ((((bk)paramq).pullType == 0) && (paramString != null)) {
          kotlin.a.j.c((List)localObject2, (b)new c(paramString));
        }
        localObject1 = (List)new ArrayList();
        Object localObject3 = (Iterable)localObject2;
        paramString = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        Object localObject5;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderObject)((Iterator)localObject3).next();
          localObject5 = FinderItem.Companion;
          localObject4 = FinderItem.a.b((FinderObject)localObject4, 256);
          localObject5 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          paramString.add(c.a.a((FinderItem)localObject4));
        }
        ((List)localObject1).addAll((Collection)paramString);
        paramString = ((bk)paramq).doe().SIi;
        if (paramString != null)
        {
          paramString = paramString.SDp;
          if (paramString != null)
          {
            paramString = ((Iterable)paramString).iterator();
            while (paramString.hasNext())
            {
              localObject3 = (aqd)paramString.next();
              if (((aqd)localObject3).type == 1) {
                localc.xHl = ((aqd)localObject3).SDq;
              }
            }
          }
        }
        if (((bk)paramq).pullType == 0)
        {
          localObject3 = ((bk)paramq).doe().SIh;
          localObject4 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            paramString = ((Iterator)localObject4).next();
            localObject5 = (bu)paramString;
            if (((localObject5 instanceof BaseFinderFeed)) && (((bu)localObject5).mf() != ((bk)paramq).feedId))
            {
              paramInt1 = 1;
              label521:
              if (paramInt1 == 0) {
                break label744;
              }
              label525:
              paramString = (bu)paramString;
              if ((paramString != null) && (((List)localObject1).indexOf(paramString) > 0))
              {
                localObject4 = aj.AGc;
                paramInt2 = this.xGZ.fEH;
                localObject4 = this.xGZ.getContextObj();
                if (localObject4 == null) {
                  break label751;
                }
                paramInt1 = ((bid)localObject4).xkX;
                label578:
                if (!aj.hd(paramInt2, paramInt1))
                {
                  localObject4 = bv.zBv;
                  ((List)localObject1).add(1, bv.Oh(2001));
                }
              }
              localObject4 = aj.AGc;
              paramInt2 = this.xGZ.fEH;
              localObject4 = this.xGZ.getContextObj();
              if (localObject4 == null) {
                break label756;
              }
              paramInt1 = ((bid)localObject4).xkX;
              label638:
              if ((aj.hd(paramInt2, paramInt1)) || (localObject3 == null)) {
                break label1048;
              }
              localObject4 = ((bjt)localObject3).STB;
              if (localObject4 == null) {
                break label1048;
              }
              localObject5 = (Iterable)localObject4;
              localObject4 = (Collection)new ArrayList();
              localObject5 = ((Iterable)localObject5).iterator();
            }
          }
          label691:
          Object localObject6;
          label744:
          label751:
          label756:
          label764:
          for (;;)
          {
            if (!((Iterator)localObject5).hasNext()) {
              break label766;
            }
            localObject6 = ((Iterator)localObject5).next();
            if (((bjr)localObject6).STx == 3) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label764;
              }
              ((Collection)localObject4).add(localObject6);
              break label691;
              paramInt1 = 0;
              break label521;
              break;
              paramString = null;
              break label525;
              paramInt1 = 0;
              break label578;
              paramInt1 = 0;
              break label638;
            }
          }
          label766:
          localObject4 = ((Iterable)localObject4).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject6 = (bjr)((Iterator)localObject4).next();
            localObject5 = new aa.d();
            Object localObject7 = ((bjt)localObject3).SUa;
            p.j(localObject7, "layoutInfo.layoutIds");
            localObject7 = (List)localObject7;
            paramInt1 = 0;
            localObject7 = ((List)localObject7).iterator();
            label845:
            Long localLong;
            long l;
            if (((Iterator)localObject7).hasNext())
            {
              localLong = (Long)((Iterator)localObject7).next();
              l = ((bjr)localObject6).zAO;
              if (localLong == null)
              {
                label879:
                paramInt2 = 0;
                label881:
                if (paramInt2 == 0) {
                  break label1036;
                }
              }
            }
            for (;;)
            {
              ((aa.d)localObject5).aaBA = paramInt1;
              if (((aa.d)localObject5).aaBA > ((List)localObject1).size()) {
                ((aa.d)localObject5).aaBA = ((List)localObject1).size();
              }
              if ((paramString == null) || (((aa.d)localObject5).aaBA <= 0) || (((aa.d)localObject5).aaBA > ((List)localObject1).size())) {
                break;
              }
              paramInt1 = ((aa.d)localObject5).aaBA;
              localObject6 = bv.zBv;
              ((List)localObject1).add(paramInt1, bv.Oh(2016));
              kotlin.a.j.c((List)localObject1, (b)new b((aa.d)localObject5, this, (bjt)localObject3, (List)localObject1, paramString, locala));
              this.xeM.clean();
              this.xGZ.xGU = true;
              locala.aaBx = false;
              break;
              if (localLong.longValue() != l) {
                break label879;
              }
              paramInt2 = 1;
              break label881;
              label1036:
              paramInt1 += 1;
              break label845;
              paramInt1 = -1;
            }
          }
        }
        label1048:
        localc.setIncrementList((List)localObject1);
        paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        c.a.r((List)localObject2, 1);
        localObject1 = getTAG();
        Object localObject2 = new StringBuilder("incrementList size: ");
        paramString = localc.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i((String)localObject1, paramString);
          localc.setPullType(((bk)paramq).pullType);
          localc.setLastBuffer(((bk)paramq).doa());
          localc.setHasMore(locala.aaBx);
          paramq = ((bk)paramq).getWording();
          paramString = paramq;
          if (paramq == null) {
            paramString = "";
          }
          localc.aBG(paramString);
          paramString = (IResponse)localc;
          AppMethodBeat.o(287772);
          return paramString;
        }
      }
      AppMethodBeat.o(287772);
      return null;
    }
    
    public final void fetch(final Object paramObject, final com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(287770);
      p.k(paramh, "callback");
      this.xeM.a(new com.tencent.mm.loader.g.h((b)new d(this, paramObject, paramh)));
      AppMethodBeat.o(287770);
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(287771);
      if (this.xGZ.xxP)
      {
        AppMethodBeat.o(287771);
        return null;
      }
      Object localObject = new bk(this.xGZ.feedId, this.xGZ.nonceId, this.xGZ.fEH, this.xGZ.getLastBuffer(), null, this.xGZ.shareScene, this.xGZ.fSj, this.xGZ.fCl, this.xGZ.sessionId, this.xGZ.getContextObj(), 0.0F, 0.0F, 6656);
      ((bk)localObject).pullType = 2;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(287771);
      return localObject;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(287767);
      if (this.xGZ.xxP)
      {
        AppMethodBeat.o(287767);
        return null;
      }
      Object localObject = new bk(this.xGZ.feedId, this.xGZ.nonceId, this.xGZ.fEH, this.xGZ.getLastBuffer(), null, this.xGZ.shareScene, this.xGZ.fSj, this.xGZ.fCl, this.xGZ.sessionId, this.xGZ.getContextObj(), 0.0F, 0.0F, 6656);
      ((bk)localObject).pullType = 0;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(287767);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(287765);
      List localList = kotlin.a.j.listOf(Integer.valueOf(3688));
      AppMethodBeat.o(287765);
      return localList;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher$TaskDataCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "callback", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher;Lcom/tencent/mm/loader/loader/SingleTask;Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getTask", "()Lcom/tencent/mm/loader/loader/SingleTask;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "plugin-finder_release"})
    public final class a
      implements com.tencent.mm.plugin.finder.feed.model.internal.h<bu>
    {
      private final com.tencent.mm.loader.g.h xHa;
      private final com.tencent.mm.plugin.finder.feed.model.internal.h<bu> xHb;
      
      public a(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
      {
        AppMethodBeat.i(285507);
        this.xHa = paramh;
        this.xHb = localObject;
        AppMethodBeat.o(285507);
      }
      
      public final void onFetchDone(IResponse<bu> paramIResponse)
      {
        AppMethodBeat.i(285506);
        p.k(paramIResponse, "response");
        this.xHb.onFetchDone(paramIResponse);
        this.xHa.a(com.tencent.mm.loader.g.j.kQd);
        AppMethodBeat.o(285506);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher$dealOnSceneEnd$5$1"})
    static final class b
      extends kotlin.g.b.q
      implements b<bu, Boolean>
    {
      b(aa.d paramd, FinderFeedShareRelativeListLoader.b paramb, bjt parambjt, List paramList, bu parambu, aa.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements b<FinderObject, Boolean>
    {
      c(BaseFinderFeed paramBaseFinderFeed)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements b<com.tencent.mm.loader.g.h, x>
    {
      d(FinderFeedShareRelativeListLoader.b paramb, Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h paramh)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "tipsWording", "guideBarItem", "Lcom/tencent/mm/protocal/protobuf/FinderGuideBarItem;", "(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderGuideBarItem;)V", "getGuideBarItem", "()Lcom/tencent/mm/protocal/protobuf/FinderGuideBarItem;", "setGuideBarItem", "(Lcom/tencent/mm/protocal/protobuf/FinderGuideBarItem;)V", "getTipsWording", "()Ljava/lang/String;", "setTipsWording", "(Ljava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bu>
  {
    public String tipsWording;
    public awb xHl;
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      super(paramInt2, paramString1);
      AppMethodBeat.i(277120);
      this.tipsWording = paramString2;
      this.xHl = null;
      AppMethodBeat.o(277120);
    }
    
    public final void aBG(String paramString)
    {
      AppMethodBeat.i(277119);
      p.k(paramString, "<set-?>");
      this.tipsWording = paramString;
      AppMethodBeat.o(277119);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$UserPageDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList;", "getCmdIds", "", "replace", "", "feedFromDetail", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "relFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
  public final class d
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(277174);
      p.k(paramq, "scene");
      if ((paramq instanceof at))
      {
        Object localObject1 = ((at)paramq).rr.bhY();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(277174);
          throw paramString;
        }
        int i;
        FinderFeedShareRelativeListLoader.c localc;
        if (((apr)localObject1).privateLock == 1)
        {
          i = 1;
          if (i != 0) {
            break label825;
          }
          localc = new FinderFeedShareRelativeListLoader.c(paramInt1, paramInt2, paramString, "", (byte)0);
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label160;
          }
        }
        label160:
        for (boolean bool = ((at)paramq).xcp;; bool = true)
        {
          localc.setPullType(((at)paramq).pullType);
          paramString = ((at)paramq).rr.bhY();
          if (paramString != null) {
            break label166;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(277174);
          throw paramString;
          i = 0;
          break;
        }
        label166:
        localc.setLastBuffer(((apr)paramString).lastBuffer);
        localc.setHasMore(bool);
        paramString = ((at)paramq).rr.bhY();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(277174);
          throw paramString;
        }
        localObject1 = ((apr)paramString).SDh;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        localc.aBG(paramString);
        paramString = ((at)paramq).rr.bhY();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(277174);
          throw paramString;
        }
        localObject1 = ((apr)paramString).object;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = new LinkedList();
        }
        localObject1 = this.xGZ.getContextObj();
        Object localObject4;
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)paramString).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            localObject4 = n.zWF;
            n.a((FinderObject)localObject3, ((bid)localObject1).xkX);
          }
        }
        Object localObject2 = (List)new ArrayList();
        Object localObject3 = (Iterable)paramString;
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderObject)((Iterator)localObject3).next();
          Object localObject5 = FinderItem.Companion;
          localObject4 = FinderItem.a.b((FinderObject)localObject4, 256);
          localObject5 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          ((Collection)localObject1).add(c.a.a((FinderItem)localObject4));
        }
        ((List)localObject2).addAll((Collection)localObject1);
        if (((at)paramq).pullType == 0)
        {
          paramq = aj.AGc;
          paramInt2 = this.xGZ.fEH;
          paramq = this.xGZ.getContextObj();
          if (paramq == null) {
            break label815;
          }
          paramInt1 = paramq.xkX;
          if (!aj.hd(paramInt2, paramInt1)) {
            if (!((Collection)localObject2).isEmpty()) {
              break label820;
            }
          }
        }
        label815:
        label820:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0)
          {
            paramq = bv.zBv;
            ((List)localObject2).add(0, bv.Oh(2001));
          }
          if ((this.xGZ.getDataList().size() == 1) && ((this.xGZ.getDataList().get(0) instanceof BaseFinderFeed)) && (paramString.size() > 0))
          {
            localObject1 = this.xGZ.getDataList().get(0);
            paramq = (com.tencent.mm.an.q)localObject1;
            if (!(localObject1 instanceof BaseFinderFeed)) {
              paramq = null;
            }
            paramq = (BaseFinderFeed)paramq;
            paramString = (FinderObject)paramString.get(0);
            if ((paramq != null) && (paramString != null) && (paramq.feedObject.getId() == paramString.id))
            {
              paramq = paramq.feedObject.getFeedObject();
              if (paramq.adFlag != paramString.adFlag)
              {
                Log.i(getTAG(), "replace adFlag " + paramq.adFlag);
                paramString.adFlag = paramq.adFlag;
              }
              if ((paramString.hotWordInfo == null) && (paramq.hotWordInfo != null))
              {
                paramString.hotWordInfo = paramq.hotWordInfo;
                Log.i(getTAG(), "replace hotWordInfo " + paramq.hotWordInfo);
              }
            }
          }
          localc.setIncrementList((List)localObject2);
          paramString = (IResponse)localc;
          AppMethodBeat.o(277174);
          return paramString;
          paramInt1 = 0;
          break;
        }
      }
      label825:
      AppMethodBeat.o(277174);
      return null;
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      long l2 = 0L;
      AppMethodBeat.i(277173);
      Object localObject = this.xGZ;
      int i = ((FinderFeedShareRelativeListLoader)localObject).getDataList().size() - 1;
      for (;;)
      {
        long l1 = l2;
        if (i >= 0)
        {
          bu localbu = (bu)((FinderFeedShareRelativeListLoader)localObject).getDataList().get(i);
          if (((localbu instanceof BaseFinderFeed)) && (((BaseFinderFeed)localbu).feedObject.getId() != 0L)) {
            l1 = ((BaseFinderFeed)localbu).feedObject.getId();
          }
        }
        else
        {
          localObject = (com.tencent.mm.an.q)new at(this.xGZ.whH, this.xGZ.feedId, this.xGZ.xcr, l1, this.xGZ.getLastBuffer(), 2, this.xGZ.getContextObj());
          AppMethodBeat.o(277173);
          return localObject;
        }
        i -= 1;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(277171);
      List localList = kotlin.a.j.listOf(Integer.valueOf(6692));
      AppMethodBeat.o(277171);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newList", "", "cmd", "request", "", "plugin-finder_release"})
  public static final class e
    extends BaseFeedLoader<bu>.a
  {
    e()
    {
      super();
    }
    
    public final int findMergeIndex(ArrayList<bu> paramArrayList, List<? extends bu> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(225665);
      p.k(paramArrayList, "srcList");
      p.k(paramList, "newList");
      paramInt = this.xGZ.getDataList().size();
      AppMethodBeat.o(225665);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader
 * JD-Core Version:    0.7.0.1
 */