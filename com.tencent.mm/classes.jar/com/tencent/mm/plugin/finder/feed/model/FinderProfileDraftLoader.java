package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ie;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderUserName", "", "objectType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;)V", "draftAddListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1;", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUserName", "()Ljava/lang/String;", "isLoadingMore", "", "getObjectType", "()I", "state", "getState", "setState", "addDraft", "localId", "", "checkEmpty", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "mergeLocalData", "", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "curList", "Ljava/util/LinkedList;", "username", "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "removeDraft", "notify", "requestLoadMore", "transformDraftInfo", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "draftItem", "CacheState", "DraftFetcher", "DraftResponse", "State", "plugin-finder_release"})
public final class FinderProfileDraftLoader
  extends BaseFeedLoader<bu>
{
  private boolean isLoadingMore;
  final int objectType;
  final String whH;
  public kotlin.g.a.a<x> xEI;
  public a xID;
  public volatile a xIE;
  private final e xIF;
  
  public FinderProfileDraftLoader(String paramString, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(292289);
    this.whH = paramString;
    this.objectType = 2;
    this.xID = a.xIG;
    this.xIE = a.xIG;
    this.xIF = new e(this);
    AppMethodBeat.o(292289);
  }
  
  public final int KY(long paramLong)
  {
    AppMethodBeat.i(292284);
    Object localObject = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((bu)((Iterator)localObject).next()).mf() == paramLong)
      {
        j = 1;
        label54:
        if (j == 0) {
          break label133;
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        p.j(getDataList().remove(i), "dataList.removeAt(index)");
        dispatcher().onChanged();
        if (getDataList().size() == 0)
        {
          this.xIE = a.xIH;
          localObject = this.xEI;
          if (localObject != null) {
            ((kotlin.g.a.a)localObject).invoke();
          }
        }
      }
      AppMethodBeat.o(292284);
      return i;
      j = 0;
      break label54;
      label133:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(292285);
    i locali = (i)new b();
    AppMethodBeat.o(292285);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(292286);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(292286);
    return locald;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(292282);
    super.onAlive();
    this.xIF.alive();
    AppMethodBeat.o(292282);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(292283);
    super.onDead();
    this.xIF.dead();
    AppMethodBeat.o(292283);
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(292287);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    p.k(paramIResponse, "response");
    if (2 == paramIResponse.getPullType()) {
      this.isLoadingMore = false;
    }
    super.onFetchDone(paramIResponse);
    localObject = paramIResponse.getIncrementList();
    int i;
    if (localObject != null)
    {
      i = ((List)localObject).size();
      if (i <= 0) {
        break label171;
      }
    }
    label171:
    for (localObject = a.xII;; localObject = a.xIH)
    {
      this.xIE = ((a)localObject);
      Log.i(getTAG(), "onFetchDone cachedState :" + this.xIE);
      if (!paramIResponse.getHasMore())
      {
        paramIResponse = this.xEI;
        if (paramIResponse != null) {
          paramIResponse.invoke();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(292287);
      return;
      i = 0;
      break;
    }
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(292288);
    if (this.isLoadingMore)
    {
      Log.i(getTAG(), "isLoadingMore return");
      AppMethodBeat.o(292288);
      return;
    }
    this.isLoadingMore = true;
    super.requestLoadMore();
    AppMethodBeat.o(292288);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(230752);
      a locala1 = new a("INIT", 0);
      xIG = locala1;
      a locala2 = new a("NO_CACHE", 1);
      xIH = locala2;
      a locala3 = new a("WITH_CACHED", 2);
      xII = locala3;
      xIJ = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(230752);
    }
    
    private a() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$DraftFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends c
  {
    public final IResponse<bu> callInit()
    {
      AppMethodBeat.i(286684);
      Object localObject3 = new LinkedList();
      Object localObject2 = this.xIK.whH;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = FinderProfileDraftLoader.h((LinkedList)localObject3, (String)localObject1);
      localObject1 = new FinderProfileDraftLoader.c("");
      ((FinderProfileDraftLoader.c)localObject1).setHasMore(false);
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(new com.tencent.mm.plugin.finder.model.q((h)((Iterator)localObject3).next()));
      }
      ((FinderProfileDraftLoader.c)localObject1).setIncrementList((List)localObject2);
      ((FinderProfileDraftLoader.c)localObject1).setLastBuffer(null);
      ((FinderProfileDraftLoader.c)localObject1).setHasMore(false);
      localObject1 = (IResponse)localObject1;
      AppMethodBeat.o(286684);
      return localObject1;
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(286685);
      p.k(paramq, "scene");
      paramString = (bi)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.lKU.bhY() == null))
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetDraftResponse");
        AppMethodBeat.o(286685);
        throw paramString;
      }
      paramString = new FinderProfileDraftLoader.c("");
      paramString.setIncrementList((List)v.aaAd);
      paramString.setLastBuffer(null);
      paramString = (IResponse)paramString;
      AppMethodBeat.o(286685);
      return paramString;
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(286683);
      com.tencent.mm.an.q localq = (com.tencent.mm.an.q)new bi(this.xIK.whH, this.xIK.objectType, this.xIK.getLastBuffer(), 2, this.xIK.getContextObj());
      AppMethodBeat.o(286683);
      return localq;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(286681);
      com.tencent.mm.an.q localq = (com.tencent.mm.an.q)new bi(this.xIK.whH, this.xIK.objectType, null, 1, this.xIK.getContextObj());
      AppMethodBeat.o(286681);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(286680);
      List localList = j.listOf(Integer.valueOf(5801));
      AppMethodBeat.o(286680);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$DraftResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bu>
  {
    public c(String paramString)
    {
      super(0, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bu>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(279270);
      p.k(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.YNO;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihs());
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(279270);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderProfileDraftLoader.d paramd, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderDraftOpEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<ie>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderProfileDraftLoader.e parame, ie paramie)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<h, Boolean>
  {
    f(LinkedList paramLinkedList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileDraftLoader
 * JD-Core Version:    0.7.0.1
 */