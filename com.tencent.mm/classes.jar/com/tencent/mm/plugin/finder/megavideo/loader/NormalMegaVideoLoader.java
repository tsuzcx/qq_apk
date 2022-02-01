package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.bu;>;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/ui/MMFragmentActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMFragmentActivity;", "firstFeedId", "", "getFirstFeedId", "()J", "setFirstFeedId", "(J)V", "firstNonceId", "", "getFirstNonceId", "()Ljava/lang/String;", "setFirstNonceId", "(Ljava/lang/String;)V", "firstUserName", "getFirstUserName", "setFirstUserName", "needGetDetail", "", "getNeedGetDetail", "()Z", "setNeedGetDetail", "(Z)V", "showErrUi", "Lkotlin/Function2;", "", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "MegaVideoGetDetailResponse", "MegaVideoListResponse", "NormalMegaVideoDataFetcher", "plugin-finder_release"})
public final class NormalMegaVideoLoader
  extends BaseMegaVideoLoader
{
  public long xHm;
  public String xHn;
  public m<? super Integer, ? super String, x> xxM;
  public kotlin.g.a.b<? super bs, x> xxN;
  private String zwQ;
  public boolean zwR;
  final MMFragmentActivity zwS;
  
  public NormalMegaVideoLoader(bid parambid, MMFragmentActivity paramMMFragmentActivity)
  {
    super(parambid);
    AppMethodBeat.i(243984);
    this.zwS = paramMMFragmentActivity;
    this.zwQ = "";
    this.xHn = "";
    AppMethodBeat.o(243984);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(243981);
    i locali = (i)new c();
    AppMethodBeat.o(243981);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(243982);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(243982);
    return locald;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(243983);
    p.k(paramIResponse, "response");
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
          p.iCn();
        }
        paramIResponse = paramIResponse.get(0);
        if (paramIResponse == null)
        {
          paramIResponse = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
          AppMethodBeat.o(243983);
          throw paramIResponse;
          i = 0;
        }
        else
        {
          bs localbs = (bs)paramIResponse;
          paramIResponse = localbs.contact;
          if (paramIResponse != null)
          {
            localObject = paramIResponse.username;
            paramIResponse = (IResponse<bu>)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramIResponse = "";
          }
          this.zwQ = paramIResponse;
          this.xHm = localbs.dKW();
          this.xHn = localbs.dKX();
        }
      }
      AppMethodBeat.o(243983);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    Object localObject = this.fetchEndCallback;
    if (localObject != null)
    {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
      AppMethodBeat.o(243983);
      return;
    }
    AppMethodBeat.o(243983);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$MegaVideoGetDetailResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<bu>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$MegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bu>
  {
    public b(String paramString)
    {
      super(0, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$NormalMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class c
    extends c
  {
    public final IResponse<bu> callInit()
    {
      AppMethodBeat.i(288491);
      NormalMegaVideoLoader.b localb = new NormalMegaVideoLoader.b("");
      localb.setPullType(1000);
      Object localObject1 = this.zwT.getCache();
      label115:
      long l;
      label166:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.q)localObject1).mXB;
        if (localObject1 != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject1).size());
          localb.setIncrementList((List)localObject1);
          localObject1 = this.zwT.getCache();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.feed.model.q)localObject1).lastBuffer;
            localb.setLastBuffer((com.tencent.mm.cd.b)localObject1);
            if ((this.zwT.zwR) && (this.zwT.xHm != 0L))
            {
              localObject1 = (CharSequence)this.zwT.xHn;
              if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                break label362;
              }
              i = 1;
              if (i == 0)
              {
                l = this.zwT.xHm;
                localObject1 = this.zwT.xHn;
                localObject2 = this.zwT.getContextObj();
                if (localObject2 == null) {
                  break label367;
                }
              }
            }
          }
        }
      }
      label362:
      label367:
      for (int i = ((bid)localObject2).xkX;; i = 0)
      {
        new ag(l, (String)localObject1, i, 2, "", true, null, null, 0L, null, false, false, null, this.zwT.getContextObj(), 0, null, 57280).bhW().b((com.tencent.mm.vending.c.a)new a(this)).a((com.tencent.mm.vending.e.b)this.zwT.zwS);
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(288491);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = (c)this;
        if (this.zwT.xHm == 0L) {
          break label115;
        }
        localObject2 = e.AmW;
        localObject2 = e.a.MM(this.zwT.xHm);
        if (localObject2 == null) {
          break label115;
        }
        Log.i(((c)localObject1).getTAG(), "fetchInit: use finder cache data");
        localb.setIncrementList(j.listOf(new bs((FinderObject)localObject2)));
        break label115;
        i = 0;
        break label166;
      }
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(288489);
      p.k(paramq, "scene");
      AppMethodBeat.o(288489);
      return null;
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      return null;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      return null;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(288487);
      List localList = j.listOf(Integer.valueOf(4195));
      AppMethodBeat.o(288487);
      return localList;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      a(NormalMegaVideoLoader.c paramc) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeInit", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bu>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeInit(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(291492);
      p.k(paramIResponse, "response");
      if ((paramIResponse instanceof NormalMegaVideoLoader.a))
      {
        if (paramIResponse.getIncrementList() == null) {
          paramIResponse.setIncrementList((List)v.aaAd);
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramIResponse, paramb));
        AppMethodBeat.o(291492);
        return;
      }
      super.mergeInit(paramIResponse, paramb);
      AppMethodBeat.o(291492);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(NormalMegaVideoLoader.d paramd, IResponse paramIResponse, kotlin.g.a.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.NormalMegaVideoLoader
 * JD-Core Version:    0.7.0.1
 */