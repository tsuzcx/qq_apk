package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.cgi.cv;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "feedId", "", "nonceId", "", "sessionId", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "firstUserName", "getFirstUserName", "()Ljava/lang/String;", "setFirstUserName", "(Ljava/lang/String;)V", "needGetDetail", "", "getNeedGetDetail", "()Z", "setNeedGetDetail", "(Z)V", "getNonceId", "getSessionBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getSessionId", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "requestRefresh", "MegaVideoGetDetailResponse", "MegaVideoListResponse", "RelatedMegaVideoDataFetcher", "plugin-finder_release"})
public final class FinderMegaVideoRelatedLoader
  extends BaseMegaVideoLoader
{
  final long feedId;
  final String hwg;
  final String sessionId;
  final com.tencent.mm.bw.b tvj;
  String uKW;
  boolean uKX;
  
  private FinderMegaVideoRelatedLoader(long paramLong, String paramString1, String paramString2, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(248414);
    this.feedId = paramLong;
    this.hwg = paramString1;
    this.sessionId = paramString2;
    this.tvj = null;
    this.uKW = "";
    this.uKX = true;
    AppMethodBeat.o(248414);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(248410);
    g localg = (g)new c();
    AppMethodBeat.o(248410);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(248411);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(248411);
    return localb;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(248412);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      localObject = paramIResponse.getIncrementList();
      int i;
      if (localObject != null) {
        i = ((List)localObject).size();
      }
      while ((i > 0) && ((paramIResponse instanceof b)))
      {
        localObject = paramIResponse.getIncrementList();
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((List)localObject).get(0);
        if (localObject == null)
        {
          paramIResponse = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
          AppMethodBeat.o(248412);
          throw paramIResponse;
          i = 0;
        }
        else
        {
          localObject = ((bm)localObject).contact;
          if (localObject != null)
          {
            String str = ((FinderContact)localObject).username;
            localObject = str;
            if (str != null) {}
          }
          else
          {
            localObject = "";
          }
          this.uKW = ((String)localObject);
          paramIResponse.setHasMore(true);
          localObject = this.fetchEndCallback;
          if (localObject != null)
          {
            ((kotlin.g.a.b)localObject).invoke(paramIResponse);
            AppMethodBeat.o(248412);
            return;
          }
        }
      }
      AppMethodBeat.o(248412);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    Object localObject = this.fetchEndCallback;
    if (localObject != null)
    {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
      AppMethodBeat.o(248412);
      return;
    }
    AppMethodBeat.o(248412);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(248413);
    requestLoadMore();
    AppMethodBeat.o(248413);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader$MegaVideoGetDetailResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<bo>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader$MegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    public b(String paramString)
    {
      super(0, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader$RelatedMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetchInit", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> callInit()
    {
      AppMethodBeat.i(248406);
      FinderMegaVideoRelatedLoader.b localb = new FinderMegaVideoRelatedLoader.b("");
      localb.setPullType(1000);
      Object localObject = this.uKY.getCache();
      if (localObject != null)
      {
        localObject = ((h)localObject).kgc;
        if (localObject != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject).size());
          localb.setIncrementList((List)localObject);
          localObject = this.uKY.getCache();
          if (localObject == null) {
            break label111;
          }
        }
      }
      label111:
      for (localObject = ((h)localObject).lastBuffer;; localObject = null)
      {
        localb.setLastBuffer((com.tencent.mm.bw.b)localObject);
        localObject = (IResponse)localb;
        AppMethodBeat.o(248406);
        return localObject;
      }
    }
    
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      Object localObject1 = null;
      AppMethodBeat.i(248405);
      p.h(paramq, "scene");
      if ((paramq instanceof cu))
      {
        Object localObject2 = ((cu)paramq).cZr();
        paramq = new FinderMegaVideoRelatedLoader.a(paramInt1, paramInt2, paramString);
        paramq.setIncrementList(j.listOf(new bm((ayj)localObject2)));
        paramq.setPullType(1000);
        localObject2 = getTAG();
        StringBuilder localStringBuilder = new StringBuilder("NetSceneMegaVideoGetDetail errType = ").append(paramInt1).append(", errCode = ").append(paramInt2).append(", size = ");
        List localList = paramq.getIncrementList();
        paramString = localObject1;
        if (localList != null) {
          paramString = Integer.valueOf(localList.size());
        }
        Log.i((String)localObject2, paramString);
        paramString = (IResponse)paramq;
        AppMethodBeat.o(248405);
        return paramString;
      }
      AppMethodBeat.o(248405);
      return null;
    }
    
    public final void fetchInit(f<bo> paramf)
    {
      AppMethodBeat.i(248407);
      p.h(paramf, "callback");
      super.fetchInit(paramf);
      if ((this.uKY.feedId != 0L) && (this.uKY.uKX)) {
        fetch(new cu(this.uKY.feedId, this.uKY.uKW, this.uKY.hwg, this.uKY.getContextObj()), paramf);
      }
      AppMethodBeat.o(248407);
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(248404);
      Object localObject = new cv(this.uKY.feedId, this.uKY.hwg, this.uKY.getLastBuffer(), this.uKY.sessionId, this.uKY.tvj, this.uKY.getContextObj());
      ((cv)localObject).pullType = 2;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(248404);
      return localObject;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      return null;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(248403);
      List localList = j.listOf(new Integer[] { Integer.valueOf(4195), Integer.valueOf(6432) });
      AppMethodBeat.o(248403);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeInit", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bo>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeInit(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(248409);
      p.h(paramIResponse, "response");
      if ((paramIResponse instanceof FinderMegaVideoRelatedLoader.a))
      {
        if (paramIResponse.getIncrementList() == null) {
          paramIResponse.setIncrementList((List)v.SXr);
        }
        d.h((kotlin.g.a.a)new a(this, paramIResponse, paramb));
        AppMethodBeat.o(248409);
        return;
      }
      super.mergeInit(paramIResponse, paramb);
      AppMethodBeat.o(248409);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderMegaVideoRelatedLoader.d paramd, IResponse paramIResponse, kotlin.g.a.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoRelatedLoader
 * JD-Core Version:    0.7.0.1
 */