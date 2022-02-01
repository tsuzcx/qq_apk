package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.bp;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "encryptedFeedId", "", "nonceId", "tabType", "", "isFromAd", "", "shareScene", "sessionId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPostingScene", "(JLjava/lang/String;Ljava/lang/String;IZILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getEncryptedFeedId", "()Ljava/lang/String;", "getFeedId", "()J", "setFeedId", "(J)V", "fetchCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchCallback", "(Lkotlin/jvm/functions/Function1;)V", "fetchEndCallback", "getFetchEndCallback", "setFetchEndCallback", "finderUserName", "getFinderUserName", "setFinderUserName", "(Ljava/lang/String;)V", "fromUserName", "getFromUserName", "setFromUserName", "hasRefreshFinish", "getHasRefreshFinish", "()Z", "setHasRefreshFinish", "(Z)V", "isOpenEntranceTipShown", "setOpenEntranceTipShown", "getNonceId", "getSessionId", "getShareScene", "()I", "getTabType", "toUserName", "getToUserName", "setToUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "isObservePostEvent", "onFetchDone", "response", "FeedShareRelDataFetcher", "FinderShareRelativeListResponse", "UserPageDataFetcher", "plugin-finder_release"})
public final class FinderFeedShareRelativeListLoader
  extends BaseFinderFeedLoader
{
  public String dJw;
  final int dLS;
  public String dYs;
  public long feedId;
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  final String hwg;
  public String sBN;
  final String sessionId;
  final int shareScene;
  final boolean tNP;
  public boolean tVj;
  public kotlin.g.a.b<? super IResponse<bo>, x> tVk;
  private boolean tVl;
  private final boolean tVm;
  final String tuI;
  
  public FinderFeedShareRelativeListLoader(long paramLong, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString3, bbn parambbn, boolean paramBoolean2)
  {
    super(parambbn);
    AppMethodBeat.i(244628);
    this.feedId = paramLong;
    this.tuI = paramString1;
    this.hwg = paramString2;
    this.dLS = paramInt1;
    this.tVm = paramBoolean1;
    this.shareScene = paramInt2;
    this.sessionId = paramString3;
    this.tNP = paramBoolean2;
    this.sBN = "";
    this.dYs = "";
    this.dJw = "";
    AppMethodBeat.o(244628);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244625);
    if (this.tVm)
    {
      localg = (g)new c();
      AppMethodBeat.o(244625);
      return localg;
    }
    g localg = (g)new a();
    AppMethodBeat.o(244625);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(244626);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(244626);
    return localb;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244627);
    p.h(paramIResponse, "response");
    if (paramIResponse.getPullType() == 0)
    {
      this.tVl = true;
      Log.d(getTAG(), "refresh finish");
    }
    if ((paramIResponse.getPullType() == 2) && (!this.tVl))
    {
      Log.d(getTAG(), "loadmore before refresh");
      AppMethodBeat.o(244627);
      return;
    }
    if (!isInitOperation(paramIResponse))
    {
      localb = this.tVk;
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
      AppMethodBeat.o(244627);
      return;
    }
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(244627);
      return;
    }
    AppMethodBeat.o(244627);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "TaskDataCallbackWrapper", "plugin-finder_release"})
  public final class a
    extends a
  {
    private final i tMX;
    
    public a()
    {
      AppMethodBeat.i(244616);
      this.tMX = new i("FeedShareRelData");
      AppMethodBeat.o(244616);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(244611);
      super.alive();
      this.tMX.start();
      AppMethodBeat.o(244611);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(244612);
      super.dead();
      this.tMX.stop();
      AppMethodBeat.o(244612);
    }
    
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(244615);
      p.h(paramq, "scene");
      if ((paramq instanceof bh))
      {
        final z.a locala = new z.a();
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        Object localObject1;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        for (boolean bool = ((bh)paramq).cYp();; bool = true)
        {
          locala.SYB = bool;
          localObject1 = new FinderFeedShareRelativeListLoader.b(paramInt1, paramInt2, paramString, "");
          localObject2 = ((bh)paramq).cYr();
          localObject3 = (List)new ArrayList();
          localObject4 = (Iterable)localObject2;
          paramString = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (FinderObject)((Iterator)localObject4).next();
            localObject6 = FinderItem.Companion;
            localObject5 = FinderItem.a.a((FinderObject)localObject5, 256);
            localObject6 = c.vGN;
            paramString.add(c.a.s((FinderItem)localObject5));
          }
          localObject1 = com.tencent.mm.plugin.finder.report.h.veu;
          com.tencent.mm.plugin.finder.report.h.d(this.tVn.dLS, this.tVn.getContextObj());
        }
        ((List)localObject3).addAll((Collection)paramString);
        if (((bh)paramq).pullType == 0)
        {
          localObject4 = ((bh)paramq).cYq().LEA;
          localObject5 = ((Iterable)localObject3).iterator();
          if (((Iterator)localObject5).hasNext())
          {
            paramString = ((Iterator)localObject5).next();
            localObject6 = (bo)paramString;
            if (((localObject6 instanceof BaseFinderFeed)) && (((bo)localObject6).lT() != ((bh)paramq).feedId))
            {
              paramInt1 = 1;
              label313:
              if (paramInt1 == 0) {
                break label536;
              }
              label317:
              paramString = (bo)paramString;
              if ((paramString != null) && (((List)localObject3).indexOf(paramString) > 0))
              {
                localObject5 = y.vXH;
                paramInt2 = this.tVn.dLS;
                localObject5 = this.tVn.getContextObj();
                if (localObject5 == null) {
                  break label543;
                }
                paramInt1 = ((bbn)localObject5).tCE;
                label370:
                if (!y.gr(paramInt2, paramInt1))
                {
                  localObject5 = bp.uOZ;
                  ((List)localObject3).add(1, bp.Ju(2001));
                }
              }
              localObject5 = y.vXH;
              paramInt2 = this.tVn.dLS;
              localObject5 = this.tVn.getContextObj();
              if (localObject5 == null) {
                break label548;
              }
              paramInt1 = ((bbn)localObject5).tCE;
              label430:
              if ((y.gr(paramInt2, paramInt1)) || (localObject4 == null)) {
                break label840;
              }
              localObject5 = ((bcx)localObject4).LLI;
              if (localObject5 == null) {
                break label840;
              }
              localObject6 = (Iterable)localObject5;
              localObject5 = (Collection)new ArrayList();
              localObject6 = ((Iterable)localObject6).iterator();
            }
          }
          label483:
          Object localObject7;
          label536:
          label543:
          label548:
          label556:
          for (;;)
          {
            if (!((Iterator)localObject6).hasNext()) {
              break label558;
            }
            localObject7 = ((Iterator)localObject6).next();
            if (((bcw)localObject7).LLE == 3) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label556;
              }
              ((Collection)localObject5).add(localObject7);
              break label483;
              paramInt1 = 0;
              break label313;
              break;
              paramString = null;
              break label317;
              paramInt1 = 0;
              break label370;
              paramInt1 = 0;
              break label430;
            }
          }
          label558:
          localObject5 = ((Iterable)localObject5).iterator();
          if (((Iterator)localObject5).hasNext())
          {
            localObject7 = (bcw)((Iterator)localObject5).next();
            localObject6 = new z.d();
            Object localObject8 = ((bcx)localObject4).LMe;
            p.g(localObject8, "layoutInfo.layoutIds");
            localObject8 = (List)localObject8;
            paramInt1 = 0;
            localObject8 = ((List)localObject8).iterator();
            label637:
            Long localLong;
            long l;
            if (((Iterator)localObject8).hasNext())
            {
              localLong = (Long)((Iterator)localObject8).next();
              l = ((bcw)localObject7).uOx;
              if (localLong == null)
              {
                label671:
                paramInt2 = 0;
                label673:
                if (paramInt2 == 0) {
                  break label828;
                }
              }
            }
            for (;;)
            {
              ((z.d)localObject6).SYE = paramInt1;
              if (((z.d)localObject6).SYE > ((List)localObject3).size()) {
                ((z.d)localObject6).SYE = ((List)localObject3).size();
              }
              if ((paramString == null) || (((z.d)localObject6).SYE <= 0) || (((z.d)localObject6).SYE > ((List)localObject3).size())) {
                break;
              }
              paramInt1 = ((z.d)localObject6).SYE;
              localObject7 = bp.uOZ;
              ((List)localObject3).add(paramInt1, bp.Ju(2016));
              kotlin.a.j.c((List)localObject3, (kotlin.g.a.b)new b((z.d)localObject6, this, (bcx)localObject4, (List)localObject3, paramString, locala));
              this.tMX.clean();
              this.tVn.tVj = true;
              locala.SYB = false;
              break;
              if (localLong.longValue() != l) {
                break label671;
              }
              paramInt2 = 1;
              break label673;
              label828:
              paramInt1 += 1;
              break label637;
              paramInt1 = -1;
            }
          }
        }
        label840:
        ((FinderFeedShareRelativeListLoader.b)localObject1).setIncrementList((List)localObject3);
        paramString = c.vGN;
        c.a.s((List)localObject2, 1);
        Object localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderFeedShareRelativeListLoader.b)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i((String)localObject2, paramString);
          ((FinderFeedShareRelativeListLoader.b)localObject1).setPullType(((bh)paramq).pullType);
          ((FinderFeedShareRelativeListLoader.b)localObject1).setLastBuffer(((bh)paramq).cYm());
          ((FinderFeedShareRelativeListLoader.b)localObject1).setHasMore(locala.SYB);
          paramq = ((bh)paramq).getWording();
          paramString = paramq;
          if (paramq == null) {
            paramString = "";
          }
          ((FinderFeedShareRelativeListLoader.b)localObject1).atp(paramString);
          paramString = (IResponse)localObject1;
          AppMethodBeat.o(244615);
          return paramString;
        }
      }
      AppMethodBeat.o(244615);
      return null;
    }
    
    public final void fetch(final Object paramObject, final f<bo> paramf)
    {
      AppMethodBeat.i(244613);
      p.h(paramf, "callback");
      this.tMX.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new c(this, paramObject, paramf)));
      AppMethodBeat.o(244613);
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244614);
      if (this.tVn.tNP)
      {
        AppMethodBeat.o(244614);
        return null;
      }
      Object localObject = new bh(this.tVn.feedId, this.tVn.hwg, this.tVn.dLS, this.tVn.getLastBuffer(), null, this.tVn.shareScene, this.tVn.dYs, this.tVn.dJw, this.tVn.sessionId, this.tVn.getContextObj(), 512);
      ((bh)localObject).pullType = 2;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(244614);
      return localObject;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(244610);
      if (this.tVn.tNP)
      {
        AppMethodBeat.o(244610);
        return null;
      }
      Object localObject = new bh(this.tVn.feedId, this.tVn.hwg, this.tVn.dLS, this.tVn.getLastBuffer(), null, this.tVn.shareScene, this.tVn.dYs, this.tVn.dJw, this.tVn.sessionId, this.tVn.getContextObj(), 512);
      ((bh)localObject).pullType = 0;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(244610);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244609);
      List localList = kotlin.a.j.listOf(Integer.valueOf(3688));
      AppMethodBeat.o(244609);
      return localList;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher$TaskDataCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "callback", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher;Lcom/tencent/mm/loader/loader/SingleTask;Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getTask", "()Lcom/tencent/mm/loader/loader/SingleTask;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "plugin-finder_release"})
    public final class a
      implements f<bo>
    {
      private final com.tencent.mm.loader.g.h tVo;
      private final f<bo> tVp;
      
      public a(f<bo> paramf)
      {
        AppMethodBeat.i(244606);
        this.tVo = paramf;
        this.tVp = localObject;
        AppMethodBeat.o(244606);
      }
      
      public final void onFetchDone(IResponse<bo> paramIResponse)
      {
        AppMethodBeat.i(244605);
        p.h(paramIResponse, "response");
        this.tVp.onFetchDone(paramIResponse);
        this.tVo.a(com.tencent.mm.loader.g.j.ibw);
        AppMethodBeat.o(244605);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher$dealOnSceneEnd$2$1"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<bo, Boolean>
    {
      b(z.d paramd, FinderFeedShareRelativeListLoader.a parama, bcx parambcx, List paramList, bo parambo, z.a parama1)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
    {
      c(FinderFeedShareRelativeListLoader.a parama, Object paramObject, f paramf)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "tipsWording", "(IILjava/lang/String;Ljava/lang/String;)V", "getTipsWording", "()Ljava/lang/String;", "setTipsWording", "(Ljava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    public String tipsWording;
    
    public b(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      super(paramInt2, paramString1);
      AppMethodBeat.i(244619);
      this.tipsWording = paramString2;
      AppMethodBeat.o(244619);
    }
    
    public final void atp(String paramString)
    {
      AppMethodBeat.i(244618);
      p.h(paramString, "<set-?>");
      this.tipsWording = paramString;
      AppMethodBeat.o(244618);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$UserPageDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList;", "getCmdIds", "", "plugin-finder_release"})
  public final class c
    extends a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      int j = 1;
      AppMethodBeat.i(244623);
      p.h(paramq, "scene");
      if ((paramq instanceof aq))
      {
        Object localObject1 = ((aq)paramq).rr.aYK();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(244623);
          throw paramString;
        }
        int i;
        FinderFeedShareRelativeListLoader.b localb;
        if (((aom)localObject1).privateLock == 1)
        {
          i = 1;
          if (i != 0) {
            break label495;
          }
          localb = new FinderFeedShareRelativeListLoader.b(paramInt1, paramInt2, paramString, "");
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label162;
          }
        }
        label162:
        for (boolean bool = ((aq)paramq).tuG;; bool = true)
        {
          localb.setPullType(((aq)paramq).pullType);
          paramString = ((aq)paramq).rr.aYK();
          if (paramString != null) {
            break label168;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(244623);
          throw paramString;
          i = 0;
          break;
        }
        label168:
        localb.setLastBuffer(((aom)paramString).lastBuffer);
        localb.setHasMore(bool);
        paramString = ((aq)paramq).rr.aYK();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(244623);
          throw paramString;
        }
        localObject1 = ((aom)paramString).LAH;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        localb.atp(paramString);
        paramString = ((aq)paramq).rr.aYK();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(244623);
          throw paramString;
        }
        localObject1 = ((aom)paramString).object;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = new LinkedList();
        }
        localObject1 = (List)new ArrayList();
        Object localObject2 = (Iterable)paramString;
        paramString = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.Companion;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
          localObject4 = c.vGN;
          paramString.add(c.a.s((FinderItem)localObject3));
        }
        ((List)localObject1).addAll((Collection)paramString);
        if (((aq)paramq).pullType == 0) {
          if (!((Collection)localObject1).isEmpty()) {
            break label490;
          }
        }
        label490:
        for (paramInt1 = j;; paramInt1 = 0)
        {
          if (paramInt1 == 0)
          {
            paramString = bp.uOZ;
            ((List)localObject1).add(0, bp.Ju(2001));
          }
          localb.setIncrementList((List)localObject1);
          paramString = (IResponse)localb;
          AppMethodBeat.o(244623);
          return paramString;
        }
      }
      label495:
      AppMethodBeat.o(244623);
      return null;
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      long l2 = 0L;
      AppMethodBeat.i(244622);
      Object localObject = this.tVn;
      int i = ((FinderFeedShareRelativeListLoader)localObject).getDataList().size() - 1;
      for (;;)
      {
        long l1 = l2;
        if (i >= 0)
        {
          bo localbo = (bo)((FinderFeedShareRelativeListLoader)localObject).getDataList().get(i);
          if (((localbo instanceof BaseFinderFeed)) && (((BaseFinderFeed)localbo).feedObject.getId() != 0L)) {
            l1 = ((BaseFinderFeed)localbo).feedObject.getId();
          }
        }
        else
        {
          localObject = (com.tencent.mm.ak.q)new aq(this.tVn.sBN, this.tVn.feedId, this.tVn.tuI, l1, this.tVn.getLastBuffer(), 2, this.tVn.getContextObj());
          AppMethodBeat.o(244622);
          return localObject;
        }
        i -= 1;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244620);
      List localList = kotlin.a.j.listOf(Integer.valueOf(6692));
      AppMethodBeat.o(244620);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newList", "", "cmd", "request", "", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bo>.a
  {
    d()
    {
      super();
    }
    
    public final int findMergeIndex(ArrayList<bo> paramArrayList, List<? extends bo> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(244624);
      p.h(paramArrayList, "srcList");
      p.h(paramList, "newList");
      paramInt = this.tVn.getDataList().size();
      AppMethodBeat.o(244624);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader
 * JD-Core Version:    0.7.0.1
 */