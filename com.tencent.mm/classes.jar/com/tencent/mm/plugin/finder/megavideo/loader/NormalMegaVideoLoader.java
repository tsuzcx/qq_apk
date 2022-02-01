package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.bo;>;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/ui/MMFragmentActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMFragmentActivity;", "firstFeedId", "", "getFirstFeedId", "()J", "setFirstFeedId", "(J)V", "firstNonceId", "", "getFirstNonceId", "()Ljava/lang/String;", "setFirstNonceId", "(Ljava/lang/String;)V", "firstUserName", "getFirstUserName", "setFirstUserName", "needGetDetail", "", "getNeedGetDetail", "()Z", "setNeedGetDetail", "(Z)V", "showErrUi", "Lkotlin/Function2;", "", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "MegaVideoGetDetailResponse", "MegaVideoListResponse", "NormalMegaVideoDataFetcher", "plugin-finder_release"})
public final class NormalMegaVideoLoader
  extends BaseMegaVideoLoader
{
  public m<? super Integer, ? super String, x> tNM;
  public kotlin.g.a.b<? super bm, x> tNN;
  private String uKW;
  public boolean uKX;
  public long uLp;
  public String uLq;
  final MMFragmentActivity uLr;
  
  public NormalMegaVideoLoader(bbn parambbn, MMFragmentActivity paramMMFragmentActivity)
  {
    super(parambbn);
    AppMethodBeat.i(248442);
    this.uLr = paramMMFragmentActivity;
    this.uKW = "";
    this.uLq = "";
    AppMethodBeat.o(248442);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(248439);
    g localg = (g)new c();
    AppMethodBeat.o(248439);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(248440);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(248440);
    return localb;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(248441);
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
          AppMethodBeat.o(248441);
          throw paramIResponse;
          i = 0;
        }
        else
        {
          bm localbm = (bm)paramIResponse;
          paramIResponse = localbm.contact;
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
          this.uLp = localbm.dkW();
          this.uLq = localbm.dkX();
        }
      }
      AppMethodBeat.o(248441);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    Object localObject = this.fetchEndCallback;
    if (localObject != null)
    {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
      AppMethodBeat.o(248441);
      return;
    }
    AppMethodBeat.o(248441);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$MegaVideoGetDetailResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<bo>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$MegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    public b(String paramString)
    {
      super(0, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$NormalMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> callInit()
    {
      AppMethodBeat.i(248436);
      NormalMegaVideoLoader.b localb = new NormalMegaVideoLoader.b("");
      localb.setPullType(1000);
      Object localObject1 = this.uLs.getCache();
      label115:
      long l;
      label166:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((h)localObject1).kgc;
        if (localObject1 != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject1).size());
          localb.setIncrementList((List)localObject1);
          localObject1 = this.uLs.getCache();
          if (localObject1 != null)
          {
            localObject1 = ((h)localObject1).lastBuffer;
            localb.setLastBuffer((com.tencent.mm.bw.b)localObject1);
            if ((this.uLs.uKX) && (this.uLs.uLp != 0L))
            {
              localObject1 = (CharSequence)this.uLs.uLq;
              if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                break label362;
              }
              i = 1;
              if (i == 0)
              {
                l = this.uLs.uLp;
                localObject1 = this.uLs.uLq;
                localObject2 = this.uLs.getContextObj();
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
      for (int i = ((bbn)localObject2).tCE;; i = 0)
      {
        new af(l, (String)localObject1, i, 2, "", true, null, null, 0L, null, false, false, null, this.uLs.getContextObj(), 0, 24512).aYI().b((com.tencent.mm.vending.c.a)new a(this)).a((com.tencent.mm.vending.e.b)this.uLs.uLr);
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(248436);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = (c)this;
        if (this.uLs.uLp == 0L) {
          break label115;
        }
        localObject2 = e.vFX;
        localObject2 = e.a.FD(this.uLs.uLp);
        if (localObject2 == null) {
          break label115;
        }
        Log.i(((c)localObject1).getTAG(), "fetchInit: use finder cache data");
        localb.setIncrementList(j.listOf(new bm((FinderObject)localObject2)));
        break label115;
        i = 0;
        break label166;
      }
    }
    
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(248435);
      p.h(paramq, "scene");
      AppMethodBeat.o(248435);
      return null;
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
      AppMethodBeat.i(248434);
      List localList = j.listOf(Integer.valueOf(4195));
      AppMethodBeat.o(248434);
      return localList;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      a(NormalMegaVideoLoader.c paramc) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeInit", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bo>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeInit(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(248438);
      p.h(paramIResponse, "response");
      if ((paramIResponse instanceof NormalMegaVideoLoader.a))
      {
        if (paramIResponse.getIncrementList() == null) {
          paramIResponse.setIncrementList((List)v.SXr);
        }
        d.h((kotlin.g.a.a)new a(this, paramIResponse, paramb));
        AppMethodBeat.o(248438);
        return;
      }
      super.mergeInit(paramIResponse, paramb);
      AppMethodBeat.o(248438);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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