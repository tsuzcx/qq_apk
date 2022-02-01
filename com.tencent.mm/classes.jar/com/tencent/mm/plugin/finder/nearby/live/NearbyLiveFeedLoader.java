package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.nearby.preload.firstpage.a.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b<-Lcom.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.bu;>;Lkotlin.x;>;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "commentScene", "", "tabType", "localTypeFlag", "by_pass", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IIILjava/lang/String;)V", "getBy_pass", "()Ljava/lang/String;", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fileCacheFlag", "initForceRequestSever", "", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lastResponseBuffer", "memoryCacheFlag", "refreshPullType", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "requestInit", "requestLoadMore", "requestRefresh", "pullType", "lastBuffer", "forceRequestSever", "CgiConsumeCallback", "FinderLiveFriendsRequest", "FinderLiveFriendsResponse", "LbsDataFetcher", "plugin-finder-nearby_release"})
public class NearbyLiveFeedLoader
  extends BaseFinderFeedLoader
{
  final int fEH;
  kotlin.g.a.b<? super IResponse<bu>, x> fetchEndCallback;
  private com.tencent.mm.cd.b xJg;
  final int xkX;
  private int zDT;
  private bcz zDU;
  private int zDV;
  private int zDW;
  private com.tencent.mm.cd.b zDX;
  private boolean zDY;
  final String zDZ;
  
  public NearbyLiveFeedLoader(bid parambid, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(parambid);
    AppMethodBeat.i(200819);
    this.xkX = paramInt1;
    this.fEH = paramInt2;
    this.zDZ = paramString;
    this.zDT = 1;
    this.zDV = this.fEH;
    this.zDW = paramInt3;
    AppMethodBeat.o(200819);
  }
  
  public final void a(int paramInt1, int paramInt2, bcz parambcz)
  {
    AppMethodBeat.i(200816);
    this.zDV = paramInt1;
    this.zDW = paramInt2;
    this.zDU = parambcz;
    super.requestInit(true);
    AppMethodBeat.o(200816);
  }
  
  public final void a(bcz parambcz)
  {
    AppMethodBeat.i(200818);
    this.zDU = parambcz;
    super.requestLoadMore();
    AppMethodBeat.o(200818);
  }
  
  public final void a(bcz parambcz, int paramInt, com.tencent.mm.cd.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(200817);
    com.tencent.mm.plugin.finder.nearby.trace.b.a locala = com.tencent.mm.plugin.finder.nearby.trace.b.zJB;
    com.tencent.mm.plugin.finder.nearby.trace.b.a.OL(this.zDV).zJu = System.currentTimeMillis();
    this.zDU = parambcz;
    this.zDT = paramInt;
    this.xJg = paramb;
    this.zDY = paramBoolean;
    super.requestRefresh();
    AppMethodBeat.o(200817);
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.i<bu> createDataFetch()
  {
    AppMethodBeat.i(200812);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new d();
    AppMethodBeat.o(200812);
    return locali;
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(200814);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new e(this);
    AppMethodBeat.o(200814);
    return locald;
  }
  
  public void onFetchDone(final IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(200815);
    p.k(paramIResponse, "response");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramIResponse));
    super.onFetchDone(paramIResponse);
    Object localObject = com.tencent.mm.plugin.finder.nearby.trace.b.zJB;
    com.tencent.mm.plugin.finder.nearby.trace.b.a.OL(this.zDV).zJx = System.currentTimeMillis();
    localObject = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
    com.tencent.mm.plugin.finder.nearby.trace.c.dMD().aGV("fetchLivesDone");
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(200815);
      return;
    }
    AppMethodBeat.o(200815);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$CgiConsumeCallback;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;Lcom/tencent/mm/loader/loader/SingleTask;)V", "getTask", "()Lcom/tencent/mm/loader/loader/SingleTask;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder-nearby_release"})
  static final class a
    implements ab.c
  {
    private final com.tencent.mm.loader.g.h xHa;
    private final com.tencent.mm.loader.g.i xeM;
    
    public a(com.tencent.mm.loader.g.i parami, com.tencent.mm.loader.g.h paramh)
    {
      AppMethodBeat.i(203996);
      this.xeM = parami;
      this.xHa = paramh;
      AppMethodBeat.o(203996);
    }
    
    public final boolean b(dyy paramdyy)
    {
      AppMethodBeat.i(203995);
      p.k(paramdyy, "resp");
      if ((this.xeM != null) && (this.xeM.kPS != this.xHa.kPS))
      {
        this.xHa.a(com.tencent.mm.loader.g.j.kQd);
        Log.w("CgiConsumeCallback", "[isFetchConsume] executorToken=" + this.xeM.kPS + " taskToken=" + this.xHa.kPS);
        AppMethodBeat.o(203995);
        return true;
      }
      AppMethodBeat.o(203995);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "", "pullType", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "memoryCacheFlag", "tabType", "commentScene", "by_pass", "", "(ILcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;Lcom/tencent/mm/protobuf/ByteString;IIILjava/lang/String;)V", "getBy_pass", "()Ljava/lang/String;", "setBy_pass", "(Ljava/lang/String;)V", "getCommentScene", "()I", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getMemoryCacheFlag", "getPullType", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabType", "toString", "plugin-finder-nearby_release"})
  public static final class b
  {
    final int fEH;
    com.tencent.mm.cd.b lastBuffer;
    final int pullType;
    final int xkX;
    final bcz zDU;
    public final int zDV;
    String zDZ;
    
    public b(int paramInt1, bcz parambcz, com.tencent.mm.cd.b paramb, int paramInt2, int paramInt3, int paramInt4, String paramString)
    {
      AppMethodBeat.i(199375);
      this.pullType = paramInt1;
      this.zDU = parambcz;
      this.lastBuffer = paramb;
      this.zDV = paramInt2;
      this.fEH = paramInt3;
      this.xkX = paramInt4;
      this.zDZ = paramString;
      AppMethodBeat.o(199375);
    }
    
    public final String toString()
    {
      Object localObject2 = null;
      AppMethodBeat.i(199374);
      StringBuilder localStringBuilder = new StringBuilder("pullType:").append(this.pullType).append(" tabId:");
      Object localObject1 = this.zDU;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((bcz)localObject1).SOa);; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append(" tabName:");
        bcz localbcz = this.zDU;
        localObject1 = localObject2;
        if (localbcz != null) {
          localObject1 = localbcz.SOb;
        }
        localObject1 = (String)localObject1 + ' ' + "lastBuffer:" + this.lastBuffer + " memoryCacheFlag:" + this.zDV + " tabType:" + this.fEH + " commentScene:" + this.xkX;
        AppMethodBeat.o(199374);
        return localObject1;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "jumpLiveTab", "Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;", "prefetchMinInterval", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;I)V", "getJumpLiveTab", "()Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;", "setJumpLiveTab", "(Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;)V", "getPrefetchMinInterval", "()I", "setPrefetchMinInterval", "(I)V", "plugin-finder-nearby_release"})
  public static final class c
    extends IResponse<bu>
  {
    awn zEa = null;
    public int zEb = -1;
    
    private c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$LbsDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder-nearby_release"})
  public final class d
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<bu>
  {
    private com.tencent.mm.loader.g.i xeM;
    private c zEc;
    
    public final void alive()
    {
      AppMethodBeat.i(200004);
      super.alive();
      this.zEc = new c(this.zEd.getContextObj());
      com.tencent.mm.loader.g.i locali = new com.tencent.mm.loader.g.i("FinderFollowTlSingleExecutor");
      locali.start();
      this.xeM = locali;
      AppMethodBeat.o(200004);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(200006);
      super.dead();
      Object localObject = this.zEc;
      if (localObject != null)
      {
        localObject = ((c)localObject).xbq;
        if (localObject != null) {
          ((com.tencent.mm.vending.e.c)localObject).dead();
        }
      }
      localObject = this.xeM;
      if (localObject != null) {
        ((com.tencent.mm.loader.g.i)localObject).reset();
      }
      this.xeM = null;
      AppMethodBeat.o(200006);
    }
    
    public final void fetch(final Object paramObject, final com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(200002);
      p.k(paramh, "callback");
      if ((paramObject instanceof NearbyLiveFeedLoader.b))
      {
        com.tencent.mm.loader.g.i locali = this.xeM;
        if (locali != null)
        {
          locali.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new a(this, paramObject, paramh)));
          AppMethodBeat.o(200002);
          return;
        }
      }
      AppMethodBeat.o(200002);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(200001);
      p.k(paramh, "callback");
      LinkedList localLinkedList = new LinkedList();
      try
      {
        Object localObject = g.Xox;
        localObject = ((com.tencent.mm.plugin.finder.viewmodel.b)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RI(NearbyLiveFeedLoader.f(this.zEd));
        if (((com.tencent.mm.plugin.finder.viewmodel.b.a)localObject).Bgw.isEmpty())
        {
          localLinkedList.addAll((Collection)k.a.a(com.tencent.mm.plugin.finder.storage.data.k.Anu, NearbyLiveFeedLoader.h(this.zEd)));
          Log.i(getTAG(), "load init data from FirstPage, size:" + localLinkedList.size() + ", memoryCacheFlag:" + NearbyLiveFeedLoader.f(this.zEd) + ", fileCacheFlag:" + NearbyLiveFeedLoader.h(this.zEd));
        }
        for (;;)
        {
          localObject = ((Iterable)localLinkedList).iterator();
          while (((Iterator)localObject).hasNext())
          {
            bu localbu = (bu)((Iterator)localObject).next();
            if ((localbu instanceof BaseFinderFeed))
            {
              bid localbid = this.zEd.getContextObj();
              if (localbid != null)
              {
                n localn = n.zWF;
                n.a(((BaseFinderFeed)localbu).feedObject.getFeedObject(), localbid.xkX);
              }
            }
          }
          NearbyLiveFeedLoader.a(this.zEd, ((com.tencent.mm.plugin.finder.viewmodel.b.a)localObject).lastBuffer);
          localLinkedList.addAll((Collection)((com.tencent.mm.plugin.finder.viewmodel.b.a)localObject).Bgw);
          if (((com.tencent.mm.plugin.finder.viewmodel.b.a)localObject).BgC) {
            new com.tencent.mm.plugin.finder.cgi.h(2, ((com.tencent.mm.plugin.finder.viewmodel.b.a)localObject).lastBuffer).bhW();
          }
          Log.i(getTAG(), "load init data from cache, size:" + localLinkedList.size() + ", memoryCacheFlag:" + NearbyLiveFeedLoader.f(this.zEd) + ", fileCacheFlag:" + NearbyLiveFeedLoader.h(this.zEd) + " lastBuffer:" + NearbyLiveFeedLoader.g(this.zEd));
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.printErrStackTrace(getTAG(), localThrowable, "load init data exception", new Object[0]);
        }
        NearbyLiveFeedLoader.c localc = new NearbyLiveFeedLoader.c(0, 0, "", (byte)0);
        localc.setPullType(1000);
        localc.setIncrementList((List)localLinkedList);
        localc.setLastBuffer(NearbyLiveFeedLoader.g(this.zEd));
        paramh.onFetchDone((IResponse)localc);
        AppMethodBeat.o(200001);
      }
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(199999);
      p.k(paramh, "callback");
      fetch(new NearbyLiveFeedLoader.b(2, NearbyLiveFeedLoader.b(this.zEd), NearbyLiveFeedLoader.g(this.zEd), NearbyLiveFeedLoader.f(this.zEd), this.zEd.fEH, this.zEd.xkX, this.zEd.zDZ), paramh);
      AppMethodBeat.o(199999);
    }
    
    public final void fetchRefresh(final com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(199990);
      p.k(paramh, "callback");
      int i = NearbyLiveFeedLoader.a(this.zEd);
      Object localObject2 = NearbyLiveFeedLoader.b(this.zEd);
      Object localObject1;
      if ((NearbyLiveFeedLoader.c(this.zEd) != null) && (NearbyLiveFeedLoader.d(this.zEd)) && (NearbyLiveFeedLoader.a(this.zEd) == 0))
      {
        localObject1 = NearbyLiveFeedLoader.c(this.zEd);
        localObject1 = new NearbyLiveFeedLoader.b(i, (bcz)localObject2, (com.tencent.mm.cd.b)localObject1, NearbyLiveFeedLoader.f(this.zEd), this.zEd.fEH, this.zEd.xkX, this.zEd.zDZ);
        if ((NearbyLiveFeedLoader.a(this.zEd) == 0) && (NearbyLiveFeedLoader.b(this.zEd) != null) && (!NearbyLiveFeedLoader.d(this.zEd)))
        {
          localObject2 = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
          localObject2 = NearbyLiveFeedLoader.b(this.zEd);
          if (localObject2 == null) {
            p.iCn();
          }
          localObject2 = com.tencent.mm.plugin.finder.nearby.preload.a.b((bcz)localObject2);
          if (localObject2 != null)
          {
            a.a locala = ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.a)localObject2).zIC;
            switch (d.$EnumSwitchMapping$0[locala.ordinal()])
            {
            }
          }
        }
      }
      do
      {
        NearbyLiveFeedLoader.a(this.zEd, null);
        NearbyLiveFeedLoader.e(this.zEd);
        fetch(localObject1, paramh);
        AppMethodBeat.o(199990);
        return;
        if (NearbyLiveFeedLoader.a(this.zEd) != 2)
        {
          localObject1 = null;
          break;
        }
        localObject1 = this.zEd.getLastBuffer();
        break;
        ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject2).N((kotlin.g.a.b)new b(this, paramh, (NearbyLiveFeedLoader.b)localObject1));
        AppMethodBeat.o(199990);
        return;
        localObject2 = ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject2).dMt();
      } while (localObject2 == null);
      paramh.onFetchDone((IResponse)((com.tencent.mm.plugin.findersdk.b.h)localObject2).BvG);
      AppMethodBeat.o(199990);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
    {
      a(NearbyLiveFeedLoader.d paramd, Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h paramh)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$LbsDataFetcher$fetchRefresh$1$1"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.plugin.findersdk.b.h<IResponse<bu>>, x>
    {
      b(NearbyLiveFeedLoader.d paramd, com.tencent.mm.plugin.finder.feed.model.internal.h paramh, NearbyLiveFeedLoader.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder-nearby_release"})
  public static final class e
    extends BaseFeedLoader<bu>.a
  {
    e()
    {
      super();
    }
    
    public final void mergeRefresh(IResponse<bu> paramIResponse, kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(201373);
      p.k(paramIResponse, "response");
      paramb = RefreshLoadMoreLayout.c.YNO;
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihs());
      localc.YNF = paramIResponse.getHasMore();
      localc.lCh = ((NearbyLiveFeedLoader.c)paramIResponse).zEa;
      int m = this.zEd.getDataList().size();
      Object localObject1 = paramIResponse.getIncrementList();
      paramb = (kotlin.g.a.b<? super IResponse<bu>, x>)localObject1;
      if (localObject1 == null) {
        paramb = (List)new LinkedList();
      }
      localObject1 = new LinkedList();
      Object localObject2 = (bu)kotlin.a.j.lp((List)this.zEd.getDataList());
      if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.plugin.finder.model.z))) {
        ((LinkedList)localObject1).add(this.zEd.getDataList().get(0));
      }
      ((LinkedList)localObject1).addAll((Collection)paramb);
      paramb = ((Iterable)localObject1).iterator();
      int i = 0;
      int j = 0;
      for (;;)
      {
        Object localObject3;
        int k;
        if (paramb.hasNext())
        {
          localObject2 = paramb.next();
          if (i < 0) {
            kotlin.a.j.iBO();
          }
          localObject2 = (bu)localObject2;
          localObject3 = ((List)this.zEd.getDataList()).iterator();
          j = 0;
          if (((Iterator)localObject3).hasNext())
          {
            bu localbu = (bu)((Iterator)localObject3).next();
            if ((localbu.a((com.tencent.mm.plugin.finder.feed.model.internal.k)localObject2) == 0) && ((localbu instanceof w)))
            {
              bac localbac = ((w)localbu).feedObject.getLiveInfo();
              if ((localbac != null) && (localbac.liveStatus == 1)) {}
            }
            else
            {
              if ((i != 0) || (!(localObject2 instanceof com.tencent.mm.plugin.finder.model.z)) || (!(localbu instanceof com.tencent.mm.plugin.finder.model.z))) {
                break label568;
              }
            }
            k = 1;
            label314:
            if (k != 0)
            {
              label319:
              if ((j != -1) && (j == i)) {
                break label841;
              }
              i -= 1;
            }
          }
        }
        for (;;)
        {
          paramb = new LinkedList();
          paramb.addAll((Collection)this.zEd.getDataList());
          this.zEd.getDataList().clear();
          this.zEd.getDataList().addAll((Collection)localObject1);
          j = ((LinkedList)localObject1).size();
          if (j > 0) {
            if (i + 1 == j)
            {
              i += 1;
              j = m - j;
              this.zEd.dispatcher().onItemRangeRemoved(i, j);
              localObject2 = this.zEd.getTAG();
              paramIResponse = new StringBuilder("mergeRefresh() hasMore:").append(paramIResponse.getHasMore()).append(' ').append("removeIndex:").append(i).append("  removeSize:").append(j).append(' ').append("newList:");
              localObject3 = am.xch;
              paramIResponse = paramIResponse.append(am.dX((List)localObject1)).append(' ').append("oldList:");
              localObject1 = am.xch;
              Log.i((String)localObject2, am.dX((List)paramb));
            }
          }
          for (;;)
          {
            localc.YNG = 0;
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, localc));
            AppMethodBeat.o(201373);
            return;
            label568:
            k = 0;
            break label314;
            j += 1;
            break;
            j = -1;
            break label319;
            if (i + 1 > j)
            {
              Log.w(this.zEd.getTAG(), "数据出错，需要检查.");
            }
            else
            {
              k = i + 1;
              int n = m - k;
              if ((m > 0) && (n > 0)) {
                this.zEd.dispatcher().onItemRangeRemoved(k, n);
              }
              i += 1;
              j -= i;
              if (j > 0) {
                this.zEd.dispatcher().onItemRangeInserted(i, j);
              }
              localObject2 = this.zEd.getTAG();
              paramIResponse = new StringBuilder("mergeRefresh() hasMore:").append(paramIResponse.getHasMore()).append(' ').append("removeIndex:").append(k).append("  removeSize:").append(n).append(' ').append("insertIndex:").append(i).append("  insertSize:").append(j).append(' ').append("newList:");
              localObject3 = am.xch;
              paramIResponse = paramIResponse.append(am.dX((List)localObject1)).append(' ').append("oldList:");
              localObject1 = am.xch;
              Log.i((String)localObject2, am.dX((List)paramb));
              continue;
              Log.w(this.zEd.getTAG(), "没有新的数据.");
            }
          }
          i = j;
        }
        label841:
        j = i;
        i += 1;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(NearbyLiveFeedLoader.e parame, RefreshLoadMoreLayout.c paramc)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(NearbyLiveFeedLoader paramNearbyLiveFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader
 * JD-Core Version:    0.7.0.1
 */