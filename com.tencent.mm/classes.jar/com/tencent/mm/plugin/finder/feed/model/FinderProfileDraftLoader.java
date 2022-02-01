package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.autogen.a.ir;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.ayp;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;)V", "draftAddListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1;", "draftPostStatusListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftPostStatusListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftPostStatusListener$1;", "draftProgressListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftProgressListener$1;", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUserName", "()Ljava/lang/String;", "isLoadingMore", "", "addDraft", "localId", "", "checkEmpty", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "mergeLocalData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "Lkotlin/collections/ArrayList;", "curList", "username", "mergeOriginalDrafts", "hasMore", "nowList", "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "removeDraft", "", "notify", "requestLoadMore", "isAuto", "transformDraftInfo", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "draftItem", "updateDraft", "refreshAll", "CacheState", "DraftFetcher", "DraftResponse", "State", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileDraftLoader
  extends BaseFeedLoader<cc>
{
  public kotlin.g.a.a<ah> BbB;
  public volatile a BhY;
  private final draftAddListener.1 BhZ;
  private final draftProgressListener.1 Bia;
  private final e Bib;
  private boolean isLoadingMore;
  final String zDJ;
  
  public FinderProfileDraftLoader(String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366184);
    this.zDJ = paramString;
    this.BhY = a.Bic;
    this.BhZ = new IListener(com.tencent.mm.app.f.hfK)
    {
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(ir paramir, FinderProfileDraftLoader paramFinderProfileDraftLoader)
        {
          super();
        }
      }
    };
    this.Bia = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Bib = new e(this);
    AppMethodBeat.o(366184);
  }
  
  static com.tencent.mm.plugin.finder.model.q a(com.tencent.mm.plugin.finder.storage.i parami)
  {
    AppMethodBeat.i(366205);
    parami = new com.tencent.mm.plugin.finder.model.q(parami);
    AppMethodBeat.o(366205);
    return parami;
  }
  
  private final void z(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(366193);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramLong, paramBoolean));
    AppMethodBeat.o(366193);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<cc> createDataFetch()
  {
    AppMethodBeat.i(366268);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new b();
    AppMethodBeat.o(366268);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366271);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(366271);
    return locald;
  }
  
  public final int nH(long paramLong)
  {
    AppMethodBeat.i(366261);
    Object localObject = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((cc)((Iterator)localObject).next()).bZA() == paramLong)
      {
        j = 1;
        label55:
        if (j == 0) {
          break label136;
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        s.s(getDataList().remove(i), "dataList.removeAt(index)");
        dispatcher().onChanged();
        if (getDataList().size() == 0)
        {
          this.BhY = a.Bid;
          localObject = this.BbB;
          if (localObject != null) {
            ((kotlin.g.a.a)localObject).invoke();
          }
        }
      }
      AppMethodBeat.o(366261);
      return i;
      j = 0;
      break label55;
      label136:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(366247);
    super.onAlive();
    this.BhZ.alive();
    this.Bia.alive();
    ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().a((com.tencent.mm.plugin.finder.upload.q)this.Bib);
    AppMethodBeat.o(366247);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(366255);
    super.onDead();
    this.BhZ.dead();
    this.Bia.dead();
    ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().b((com.tencent.mm.plugin.finder.upload.q)this.Bib);
    AppMethodBeat.o(366255);
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366279);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    s.u(paramIResponse, "response");
    if (2 == paramIResponse.getPullType()) {
      this.isLoadingMore = false;
    }
    super.onFetchDone(paramIResponse);
    int i;
    if ((2 != paramIResponse.getPullType()) && (this.BhY != a.Bie))
    {
      localObject = paramIResponse.getIncrementList();
      if (localObject != null) {
        break label169;
      }
      i = 0;
      if (i <= 0) {
        break label179;
      }
    }
    label169:
    label179:
    for (localObject = a.Bie;; localObject = a.Bid)
    {
      this.BhY = ((a)localObject);
      Log.i(getTAG(), s.X("onFetchDone cachedState :", this.BhY));
      if (!paramIResponse.getHasMore())
      {
        paramIResponse = this.BbB;
        if (paramIResponse != null) {
          paramIResponse.invoke();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(366279);
      return;
      i = ((List)localObject).size();
      break;
    }
  }
  
  public final void requestLoadMore(boolean paramBoolean)
  {
    AppMethodBeat.i(366283);
    if (this.isLoadingMore)
    {
      Log.i(getTAG(), "isLoadingMore return");
      AppMethodBeat.o(366283);
      return;
    }
    this.isLoadingMore = true;
    super.requestLoadMore(paramBoolean);
    AppMethodBeat.o(366283);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(365992);
      Bic = new a("INIT", 0);
      Bid = new a("NO_CACHE", 1);
      Bie = new a("WITH_CACHED", 2);
      Bif = new a[] { Bic, Bid, Bie };
      AppMethodBeat.o(365992);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$DraftFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public b()
    {
      AppMethodBeat.i(365984);
      AppMethodBeat.o(365984);
    }
    
    public final IResponse<cc> callInit()
    {
      AppMethodBeat.i(366019);
      Object localObject3 = this.Big;
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = this.Big.zDJ;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = FinderProfileDraftLoader.a((FinderProfileDraftLoader)localObject3, localArrayList, (String)localObject1);
      Log.i(getTAG(), s.X("callInit size:", Integer.valueOf(((ArrayList)localObject2).size())));
      localObject1 = new FinderProfileDraftLoader.c(0, 0, "");
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(new com.tencent.mm.plugin.finder.model.q((com.tencent.mm.plugin.finder.storage.i)((Iterator)localObject3).next()));
      }
      ((FinderProfileDraftLoader.c)localObject1).setIncrementList((List)localObject2);
      ((FinderProfileDraftLoader.c)localObject1).setLastBuffer(null);
      ((FinderProfileDraftLoader.c)localObject1).setHasMore(true);
      localObject1 = (IResponse)localObject1;
      AppMethodBeat.o(366019);
      return localObject1;
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      boolean bool2 = false;
      AppMethodBeat.i(366037);
      s.u(paramp, "scene");
      Object localObject = (cf)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = c.c.b(((cf)localObject).oDw.otC);
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetDraftResponse");
          AppMethodBeat.o(366037);
          throw paramString;
        }
        if (((ayp)paramp).continueFlag > 0) {}
      }
      FinderProfileDraftLoader.c localc;
      for (boolean bool1 = false;; bool1 = true)
      {
        localc = new FinderProfileDraftLoader.c(paramInt1, paramInt2, paramString);
        localc.setHasMore(bool1);
        paramString = c.c.b(((cf)localObject).oDw.otC);
        if (paramString != null) {
          break;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetDraftResponse");
        AppMethodBeat.o(366037);
        throw paramString;
      }
      localc.setLastBuffer(((ayp)paramString).lastBuffer);
      localc.setPullType(((cf)localObject).pullType);
      paramString = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eQC().bmg()).intValue() == 0)
      {
        localc.setHasMore(false);
        paramString = new ArrayList();
        bool1 = bool2;
      }
      for (;;)
      {
        paramp = paramString;
        if (((cf)localObject).pullType == 1)
        {
          FinderProfileDraftLoader localFinderProfileDraftLoader = this.Big;
          localObject = this.Big.zDJ;
          paramp = (com.tencent.mm.am.p)localObject;
          if (localObject == null) {
            paramp = "";
          }
          paramp = FinderProfileDraftLoader.a(localFinderProfileDraftLoader, paramString, paramp);
        }
        FinderProfileDraftLoader.a(this.Big, bool1, paramp);
        paramp = (Iterable)paramp;
        paramString = (Collection)new ArrayList(kotlin.a.p.a(paramp, 10));
        paramp = paramp.iterator();
        while (paramp.hasNext()) {
          paramString.add(new com.tencent.mm.plugin.finder.model.q((com.tencent.mm.plugin.finder.storage.i)paramp.next()));
        }
        paramString = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
        paramString = com.tencent.mm.plugin.finder.storage.logic.c.hC(((cf)localObject).dVK());
      }
      localc.setIncrementList((List)paramString);
      paramp = getTAG();
      paramString = localc.getIncrementList();
      if (paramString == null) {}
      for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
      {
        Log.i(paramp, s.X("response.incrementList size:", paramString));
        paramString = (IResponse)localc;
        AppMethodBeat.o(366037);
        return paramString;
      }
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366003);
      if (s.p(z.bAW(), this.Big.zDJ))
      {
        com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new cf(this.Big.zDJ, this.Big.getLastBuffer(), 2, this.Big.getContextObj());
        AppMethodBeat.o(366003);
        return localp;
      }
      AppMethodBeat.o(366003);
      return null;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(365996);
      if (s.p(z.bAW(), this.Big.zDJ))
      {
        com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new cf(this.Big.zDJ, null, 1, this.Big.getContextObj());
        AppMethodBeat.o(365996);
        return localp;
      }
      AppMethodBeat.o(365996);
      return null;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(365993);
      List localList = kotlin.a.p.listOf(Integer.valueOf(5801));
      AppMethodBeat.o(365993);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$DraftResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends BaseFeedLoader<cc>.a
  {
    d(FinderProfileDraftLoader paramFinderProfileDraftLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(365816);
      AppMethodBeat.o(365816);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(365824);
      s.u(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMG());
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, new r(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.d)localObject, this.Big, paramb, paramIResponse));
      AppMethodBeat.o(365824);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderProfileDraftLoader.d paramd, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd1, FinderProfileDraftLoader paramFinderProfileDraftLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class draftAddListener$1$a
    extends u
    implements kotlin.g.a.a<ah>
  {
    draftAddListener$1$a(ir paramir, FinderProfileDraftLoader paramFinderProfileDraftLoader)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftPostStatusListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostDraftListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.finder.upload.q
  {
    e(FinderProfileDraftLoader paramFinderProfileDraftLoader) {}
    
    public final void nI(long paramLong)
    {
      AppMethodBeat.i(365826);
      FinderProfileDraftLoader.a(this.Big, paramLong);
      AppMethodBeat.o(365826);
    }
    
    public final void nJ(long paramLong)
    {
      AppMethodBeat.i(365832);
      FinderProfileDraftLoader.a(this.Big, paramLong);
      AppMethodBeat.o(365832);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(FinderProfileDraftLoader paramFinderProfileDraftLoader, long paramLong, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileDraftLoader
 * JD-Core Version:    0.7.0.1
 */