package com.tencent.mm.plugin.finder.nearby.live;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.nearby.base.d.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.data.r;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b<-Lcom.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.bo;>;Lkotlin.x;>;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "commentScene", "", "firstLoad", "tabType", "localTypeFlag", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IIII)V", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fileCacheFlag", "getFirstLoad", "setFirstLoad", "(I)V", "memoryCacheFlag", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "requestInit", "requestLoadMore", "requestRefresh", "FinderLiveFriendsRequest", "FinderLiveFriendsResponse", "LbsDataFetcher", "plugin-finder_release"})
public class NearbyLiveFeedLoader
  extends BaseFinderFeedLoader
{
  final int dLS;
  kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  final int tCE;
  int tXs;
  private axj uQK;
  private int uQL;
  private int uQM;
  
  public NearbyLiveFeedLoader(bbn parambbn, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(parambbn);
    AppMethodBeat.i(249050);
    this.tCE = paramInt1;
    this.tXs = paramInt2;
    this.dLS = paramInt3;
    this.uQL = this.dLS;
    this.uQM = paramInt4;
    AppMethodBeat.o(249050);
  }
  
  public final void a(int paramInt1, int paramInt2, axj paramaxj)
  {
    AppMethodBeat.i(249047);
    this.uQL = paramInt1;
    this.uQM = paramInt2;
    this.uQK = paramaxj;
    super.requestInit(true);
    AppMethodBeat.o(249047);
  }
  
  public final void a(axj paramaxj)
  {
    AppMethodBeat.i(249048);
    d.a locala = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
    d.a.JA(this.uQL).uQn = System.currentTimeMillis();
    this.uQK = paramaxj;
    super.requestRefresh();
    AppMethodBeat.o(249048);
  }
  
  public final void b(axj paramaxj)
  {
    AppMethodBeat.i(249049);
    this.uQK = paramaxj;
    super.requestLoadMore();
    AppMethodBeat.o(249049);
  }
  
  public g<bo> createDataFetch()
  {
    AppMethodBeat.i(249044);
    g localg = (g)new c();
    AppMethodBeat.o(249044);
    return localg;
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(249045);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(249045);
    return localb;
  }
  
  public void onFetchDone(final IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(249046);
    p.h(paramIResponse, "response");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new e(this, paramIResponse));
    super.onFetchDone(paramIResponse);
    d.a locala = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
    d.a.JA(this.uQL).uQq = System.currentTimeMillis();
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(249046);
      return;
    }
    AppMethodBeat.o(249046);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "", "pullType", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getPullType", "()I", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "plugin-finder_release"})
  public static final class a
  {
    final int pullType;
    final axj uQK;
    
    public a(int paramInt, axj paramaxj)
    {
      this.pullType = paramInt;
      this.uQK = paramaxj;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "jumpLiveTab", "Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;)V", "getJumpLiveTab", "()Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;", "setJumpLiveTab", "(Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    auh uQN = null;
    
    private b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$LbsDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public final class c
    extends g<bo>
  {
    com.tencent.mm.loader.g.i tMX;
    c uQO;
    
    public final void alive()
    {
      AppMethodBeat.i(249039);
      super.alive();
      this.uQO = new c(this.uQP.dLS, this.uQP.tCE, this.uQP.getContextObj());
      com.tencent.mm.loader.g.i locali = new com.tencent.mm.loader.g.i("FinderFollowTlSingleExecutor");
      locali.start();
      this.tMX = locali;
      AppMethodBeat.o(249039);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(249040);
      super.dead();
      Object localObject = this.uQO;
      if (localObject != null)
      {
        localObject = ((c)localObject).ttK;
        if (localObject != null) {
          ((com.tencent.mm.vending.e.c)localObject).dead();
        }
      }
      localObject = this.tMX;
      if (localObject != null) {
        ((com.tencent.mm.loader.g.i)localObject).reset();
      }
      this.tMX = null;
      AppMethodBeat.o(249040);
    }
    
    public final void fetch(final Object paramObject, final f<bo> paramf)
    {
      AppMethodBeat.i(249038);
      p.h(paramf, "callback");
      if ((paramObject instanceof NearbyLiveFeedLoader.a))
      {
        com.tencent.mm.loader.g.i locali = this.tMX;
        if (locali != null)
        {
          locali.a(new h((kotlin.g.a.b)new a(this, paramObject, paramf)));
          AppMethodBeat.o(249038);
          return;
        }
      }
      AppMethodBeat.o(249038);
    }
    
    public final void fetchInit(f<bo> paramf)
    {
      AppMethodBeat.i(249037);
      p.h(paramf, "callback");
      LinkedList localLinkedList = new LinkedList();
      try
      {
        Object localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mq(NearbyLiveFeedLoader.b(this.uQP));
        if (((FinderHomeTabStateVM.a)localObject).wuc.isEmpty())
        {
          localLinkedList.addAll((Collection)l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, NearbyLiveFeedLoader.c(this.uQP)));
          Log.i(getTAG(), "load init data from FirstPage, size:" + localLinkedList.size() + ", memoryCacheFlag:" + NearbyLiveFeedLoader.b(this.uQP) + ", fileCacheFlag:" + NearbyLiveFeedLoader.c(this.uQP));
        }
        for (;;)
        {
          localObject = ((Iterable)localLinkedList).iterator();
          while (((Iterator)localObject).hasNext())
          {
            bo localbo = (bo)((Iterator)localObject).next();
            if ((localbo instanceof BaseFinderFeed))
            {
              bbn localbbn = this.uQP.getContextObj();
              if (localbbn != null)
              {
                k localk = k.vfA;
                k.e(localbo.lT(), localbbn.tCE, ((BaseFinderFeed)localbo).feedObject.getFeedObject().sessionBuffer);
              }
            }
          }
          localLinkedList.addAll((Collection)((FinderHomeTabStateVM.a)localObject).wuc);
          Log.i(getTAG(), "load init data from cache, size:" + localLinkedList.size() + ", memoryCacheFlag:" + NearbyLiveFeedLoader.b(this.uQP) + ", fileCacheFlag:" + NearbyLiveFeedLoader.c(this.uQP));
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.printErrStackTrace(getTAG(), localThrowable, "load init data exception", new Object[0]);
        }
        NearbyLiveFeedLoader.b localb = new NearbyLiveFeedLoader.b(0, 0, "", (byte)0);
        localb.setPullType(1000);
        localb.setIncrementList((List)localLinkedList);
        paramf.onFetchDone((IResponse)localb);
        AppMethodBeat.o(249037);
      }
    }
    
    public final void fetchLoadMore(f<bo> paramf)
    {
      AppMethodBeat.i(249036);
      p.h(paramf, "callback");
      fetch(new NearbyLiveFeedLoader.a(2, NearbyLiveFeedLoader.a(this.uQP)), paramf);
      AppMethodBeat.o(249036);
    }
    
    public final void fetchRefresh(f<bo> paramf)
    {
      AppMethodBeat.i(249035);
      p.h(paramf, "callback");
      fetch(new NearbyLiveFeedLoader.a(this.uQP.tXs, NearbyLiveFeedLoader.a(this.uQP)), paramf);
      if (this.uQP.tXs == 0) {
        this.uQP.tXs = 1;
      }
      AppMethodBeat.o(249035);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<h, x>
    {
      a(NearbyLiveFeedLoader.c paramc, Object paramObject, f paramf)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bo>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(IResponse<bo> paramIResponse, kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(249042);
      p.h(paramIResponse, "response");
      paramb = RefreshLoadMoreLayout.c.Rms;
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfT());
      localc.Rmj = paramIResponse.getHasMore();
      localc.iMa = ((NearbyLiveFeedLoader.b)paramIResponse).uQN;
      int m = this.uQP.getDataList().size();
      Object localObject1 = paramIResponse.getIncrementList();
      paramb = (kotlin.g.a.b<? super IResponse<bo>, x>)localObject1;
      if (localObject1 == null) {
        paramb = (List)new LinkedList();
      }
      localObject1 = new LinkedList();
      Object localObject2 = (bo)kotlin.a.j.kt((List)this.uQP.getDataList());
      if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.plugin.finder.model.z))) {
        ((LinkedList)localObject1).add(this.uQP.getDataList().get(0));
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
            kotlin.a.j.hxH();
          }
          localObject2 = (bo)localObject2;
          localObject3 = ((List)this.uQP.getDataList()).iterator();
          j = 0;
          if (((Iterator)localObject3).hasNext())
          {
            bo localbo = (bo)((Iterator)localObject3).next();
            if ((localbo.a((com.tencent.mm.plugin.finder.feed.model.internal.i)localObject2) == 0) && ((localbo instanceof w)))
            {
              awe localawe = ((w)localbo).feedObject.getLiveInfo();
              if ((localawe != null) && (localawe.liveStatus == 1)) {}
            }
            else
            {
              if ((i != 0) || (!(localObject2 instanceof com.tencent.mm.plugin.finder.model.z)) || (!(localbo instanceof com.tencent.mm.plugin.finder.model.z))) {
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
          paramb.addAll((Collection)this.uQP.getDataList());
          this.uQP.getDataList().clear();
          this.uQP.getDataList().addAll((Collection)localObject1);
          j = ((LinkedList)localObject1).size();
          if (j > 0) {
            if (i + 1 == j)
            {
              i += 1;
              j = m - j;
              this.uQP.dispatcher().onItemRangeRemoved(i, j);
              localObject2 = this.uQP.getTAG();
              paramIResponse = new StringBuilder("mergeRefresh() hasMore:").append(paramIResponse.getHasMore()).append(' ').append("removeIndex:").append(i).append("  removeSize:").append(j).append(' ').append("newList:");
              localObject3 = al.tuv;
              paramIResponse = paramIResponse.append(al.dP((List)localObject1)).append(' ').append("oldList:");
              localObject1 = al.tuv;
              Log.i((String)localObject2, al.dP((List)paramb));
            }
          }
          for (;;)
          {
            localc.Rmk = 0;
            com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, localc));
            AppMethodBeat.o(249042);
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
              Log.w(this.uQP.getTAG(), "数据出错，需要检查.");
            }
            else
            {
              k = i + 1;
              int n = m - k;
              if ((m > 0) && (n > 0)) {
                this.uQP.dispatcher().onItemRangeRemoved(k, n);
              }
              i += 1;
              j -= i;
              if (j > 0) {
                this.uQP.dispatcher().onItemRangeInserted(i, j);
              }
              localObject2 = this.uQP.getTAG();
              paramIResponse = new StringBuilder("mergeRefresh() hasMore:").append(paramIResponse.getHasMore()).append(' ').append("removeIndex:").append(k).append("  removeSize:").append(n).append(' ').append("insertIndex:").append(i).append("  insertSize:").append(j).append(' ').append("newList:");
              localObject3 = al.tuv;
              paramIResponse = paramIResponse.append(al.dP((List)localObject1)).append(' ').append("oldList:");
              localObject1 = al.tuv;
              Log.i((String)localObject2, al.dP((List)paramb));
              continue;
              Log.w(this.uQP.getTAG(), "没有新的数据.");
            }
          }
          i = j;
        }
        label841:
        j = i;
        i += 1;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(NearbyLiveFeedLoader.d paramd, RefreshLoadMoreLayout.c paramc)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(NearbyLiveFeedLoader paramNearbyLiveFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader
 * JD-Core Version:    0.7.0.1
 */