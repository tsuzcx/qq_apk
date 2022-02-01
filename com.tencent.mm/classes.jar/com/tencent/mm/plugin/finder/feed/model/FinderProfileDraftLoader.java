package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.plugin.finder.cgi.bf;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bbn;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderUserName", "", "objectType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;)V", "draftAddListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1;", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUserName", "()Ljava/lang/String;", "isLoadingMore", "", "getObjectType", "()I", "state", "getState", "setState", "addDraft", "localId", "", "checkEmpty", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "mergeLocalData", "", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "curList", "Ljava/util/LinkedList;", "username", "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "removeDraft", "notify", "requestLoadMore", "transformDraftInfo", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "draftItem", "CacheState", "DraftFetcher", "DraftResponse", "State", "plugin-finder_release"})
public final class FinderProfileDraftLoader
  extends BaseFeedLoader<bo>
{
  private boolean isLoadingMore;
  final int objectType;
  final String sBN;
  public kotlin.g.a.a<x> tTS;
  public a tWG;
  public volatile a tWH;
  private final e tWI;
  
  public FinderProfileDraftLoader(String paramString, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244780);
    this.sBN = paramString;
    this.objectType = 2;
    this.tWG = a.tWJ;
    this.tWH = a.tWJ;
    this.tWI = new e(this);
    AppMethodBeat.o(244780);
  }
  
  public final int EF(long paramLong)
  {
    AppMethodBeat.i(244775);
    Object localObject = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((bo)((Iterator)localObject).next()).lT() == paramLong)
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
        p.g(getDataList().remove(i), "dataList.removeAt(index)");
        dispatcher().onChanged();
        if (getDataList().size() == 0)
        {
          this.tWH = a.tWK;
          localObject = this.tTS;
          if (localObject != null) {
            ((kotlin.g.a.a)localObject).invoke();
          }
        }
      }
      AppMethodBeat.o(244775);
      return i;
      j = 0;
      break label54;
      label133:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<bo> createDataFetch()
  {
    AppMethodBeat.i(244776);
    com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new b();
    AppMethodBeat.o(244776);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(244777);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(244777);
    return localb;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(244773);
    super.onAlive();
    this.tWI.alive();
    AppMethodBeat.o(244773);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(244774);
    super.onDead();
    this.tWI.dead();
    AppMethodBeat.o(244774);
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244778);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    p.h(paramIResponse, "response");
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
    for (localObject = a.tWL;; localObject = a.tWK)
    {
      this.tWH = ((a)localObject);
      Log.i(getTAG(), "onFetchDone cachedState :" + this.tWH);
      if (!paramIResponse.getHasMore())
      {
        paramIResponse = this.tTS;
        if (paramIResponse != null) {
          paramIResponse.invoke();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(244778);
      return;
      i = 0;
      break;
    }
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(244779);
    if (this.isLoadingMore)
    {
      Log.i(getTAG(), "isLoadingMore return");
      AppMethodBeat.o(244779);
      return;
    }
    this.isLoadingMore = true;
    super.requestLoadMore();
    AppMethodBeat.o(244779);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(244760);
      a locala1 = new a("INIT", 0);
      tWJ = locala1;
      a locala2 = new a("NO_CACHE", 1);
      tWK = locala2;
      a locala3 = new a("WITH_CACHED", 2);
      tWL = locala3;
      tWM = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(244760);
    }
    
    private a() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$DraftFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> callInit()
    {
      AppMethodBeat.i(244766);
      Object localObject3 = new LinkedList();
      Object localObject2 = this.tWN.sBN;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = FinderProfileDraftLoader.g((LinkedList)localObject3, (String)localObject1);
      localObject1 = new FinderProfileDraftLoader.c("");
      ((FinderProfileDraftLoader.c)localObject1).setHasMore(false);
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(new com.tencent.mm.plugin.finder.model.q((com.tencent.mm.plugin.finder.storage.g)((Iterator)localObject3).next()));
      }
      ((FinderProfileDraftLoader.c)localObject1).setIncrementList((List)localObject2);
      ((FinderProfileDraftLoader.c)localObject1).setLastBuffer(null);
      ((FinderProfileDraftLoader.c)localObject1).setHasMore(false);
      localObject1 = (IResponse)localObject1;
      AppMethodBeat.o(244766);
      return localObject1;
    }
    
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(244767);
      p.h(paramq, "scene");
      paramString = (bf)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.iUB.aYK() == null))
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetDraftResponse");
        AppMethodBeat.o(244767);
        throw paramString;
      }
      paramString = new FinderProfileDraftLoader.c("");
      paramString.setIncrementList((List)v.SXr);
      paramString.setLastBuffer(null);
      paramString = (IResponse)paramString;
      AppMethodBeat.o(244767);
      return paramString;
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244765);
      com.tencent.mm.ak.q localq = (com.tencent.mm.ak.q)new bf(this.tWN.sBN, this.tWN.objectType, this.tWN.getLastBuffer(), 2, this.tWN.getContextObj());
      AppMethodBeat.o(244765);
      return localq;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(244764);
      com.tencent.mm.ak.q localq = (com.tencent.mm.ak.q)new bf(this.tWN.sBN, this.tWN.objectType, null, 1, this.tWN.getContextObj());
      AppMethodBeat.o(244764);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244763);
      List localList = j.listOf(Integer.valueOf(5801));
      AppMethodBeat.o(244763);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$DraftResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bo>
  {
    public c(String paramString)
    {
      super(0, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bo>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(244769);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Rms;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfT());
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, new n(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(244769);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderProfileDraftLoader.d paramd, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderDraftOpEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<hu>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderProfileDraftLoader.e parame, hu paramhu)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.storage.g, Boolean>
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