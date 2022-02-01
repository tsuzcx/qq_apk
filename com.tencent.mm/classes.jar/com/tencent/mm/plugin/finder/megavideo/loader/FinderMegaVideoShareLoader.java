package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.bo;>;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "feedId", "", "nonceId", "", "fromUsername", "toUserName", "sessionId", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "firstUserName", "getFirstUserName", "()Ljava/lang/String;", "setFirstUserName", "(Ljava/lang/String;)V", "getFromUsername", "needGetDetail", "", "getNeedGetDetail", "()Z", "setNeedGetDetail", "(Z)V", "getNonceId", "getSessionBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getSessionId", "showErrUi", "Lkotlin/Function2;", "", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function0;", "getSuccessNext", "()Lkotlin/jvm/functions/Function0;", "setSuccessNext", "(Lkotlin/jvm/functions/Function0;)V", "getToUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "requestRefresh", "MegaVideoGetDetailResponse", "MegaVideoListResponse", "RelatedMegaVideoDataFetcher", "plugin-finder_release"})
public final class FinderMegaVideoShareLoader
  extends BaseMegaVideoLoader
{
  private final String dJw;
  private final String dkU;
  final long feedId;
  final String hwg;
  private final String sessionId;
  public m<? super Integer, ? super String, x> tNM;
  private final com.tencent.mm.bw.b tvj;
  public String uKW;
  boolean uKX;
  public kotlin.g.a.a<x> uLa;
  
  private FinderMegaVideoShareLoader(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(248428);
    this.feedId = paramLong;
    this.hwg = paramString1;
    this.dkU = paramString2;
    this.dJw = paramString3;
    this.sessionId = paramString4;
    this.tvj = null;
    this.uKW = "";
    this.uKX = true;
    AppMethodBeat.o(248428);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(248424);
    g localg = (g)new c();
    AppMethodBeat.o(248424);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(248425);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(248425);
    return localb;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(248426);
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
        paramIResponse = paramIResponse.getIncrementList();
        if (paramIResponse == null) {
          p.hyc();
        }
        paramIResponse = paramIResponse.get(0);
        if (paramIResponse == null)
        {
          paramIResponse = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
          AppMethodBeat.o(248426);
          throw paramIResponse;
          i = 0;
        }
        else
        {
          paramIResponse = ((bm)paramIResponse).contact;
          if (paramIResponse != null)
          {
            localObject = paramIResponse.username;
            paramIResponse = (IResponse<bo>)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramIResponse = "";
          }
          this.uKW = paramIResponse;
        }
      }
      AppMethodBeat.o(248426);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    Object localObject = this.fetchEndCallback;
    if (localObject != null)
    {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
      AppMethodBeat.o(248426);
      return;
    }
    AppMethodBeat.o(248426);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(248427);
    requestLoadMore();
    AppMethodBeat.o(248427);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader$MegaVideoGetDetailResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<bo>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader$MegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    public b(String paramString)
    {
      super(0, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader$RelatedMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetchInit", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> callInit()
    {
      AppMethodBeat.i(248420);
      FinderMegaVideoShareLoader.b localb = new FinderMegaVideoShareLoader.b("");
      localb.setPullType(1000);
      Object localObject = this.uLb.getCache();
      if (localObject != null)
      {
        localObject = ((h)localObject).kgc;
        if (localObject != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject).size());
          localb.setIncrementList((List)localObject);
          localObject = this.uLb.getCache();
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
        AppMethodBeat.o(248420);
        return localObject;
      }
    }
    
    public final IResponse<bo> dealOnSceneEnd(final int paramInt1, final int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(248419);
      p.h(paramq, "scene");
      if ((paramq instanceof cu))
      {
        final bm localbm = new bm(((cu)paramq).cZr());
        Log.i(getTAG(), "NetSceneMegaVideoGetDetail errType = " + paramInt1 + ", errCode = " + paramInt2);
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          d.h((kotlin.g.a.a)new b(this, paramInt2, paramString));
        }
        do
        {
          do
          {
            AppMethodBeat.o(248419);
            return null;
            paramq = localbm.tuP;
          } while (paramq == null);
          paramq = paramq.MtI;
        } while (paramq == null);
        long l = paramq.hFK;
        paramq = localbm.tuP;
        if (paramq != null)
        {
          paramq = paramq.MtI;
          if (paramq != null)
          {
            localObject = paramq.objectNonceId;
            paramq = (com.tencent.mm.ak.q)localObject;
            if (localObject != null) {
              break label175;
            }
          }
        }
        paramq = "";
        label175:
        Object localObject = this.uLb.getContextObj();
        if (localObject != null) {}
        for (int i = ((bbn)localObject).tCE;; i = 0)
        {
          new af(l, paramq, i, 2, "", true, null, null, 0L, null, false, false, null, this.uLb.getContextObj(), 0, 24512).aYI().b((com.tencent.mm.vending.c.a)new a(l, this, localbm, paramInt2, paramString, paramInt1));
          break;
        }
      }
      AppMethodBeat.o(248419);
      return null;
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.f<bo> paramf)
    {
      AppMethodBeat.i(248421);
      p.h(paramf, "callback");
      super.fetchInit(paramf);
      if ((this.uLb.feedId != 0L) && (this.uLb.uKX)) {
        fetch(new cu(this.uLb.feedId, this.uLb.uKW, this.uLb.hwg, 1, this.uLb.getContextObj()), paramf);
      }
      AppMethodBeat.o(248421);
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      return null;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      return null;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(248418);
      List localList = j.listOf(Integer.valueOf(4195));
      AppMethodBeat.o(248418);
      return localList;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader$RelatedMegaVideoDataFetcher$dealOnSceneEnd$2$1"})
    static final class a<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      a(long paramLong, FinderMegaVideoShareLoader.c paramc, bm parambm, int paramInt1, String paramString, int paramInt2) {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(FinderMegaVideoShareLoader.c paramc, int paramInt, String paramString)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeInit", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bo>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeInit(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(248423);
      p.h(paramIResponse, "response");
      if ((paramIResponse instanceof FinderMegaVideoShareLoader.a))
      {
        if (paramIResponse.getIncrementList() == null) {
          paramIResponse.setIncrementList((List)v.SXr);
        }
        d.h((kotlin.g.a.a)new a(this, paramIResponse, paramb));
        AppMethodBeat.o(248423);
        return;
      }
      super.mergeInit(paramIResponse, paramb);
      AppMethodBeat.o(248423);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderMegaVideoShareLoader.d paramd, IResponse paramIResponse, kotlin.g.a.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoShareLoader
 * JD-Core Version:    0.7.0.1
 */