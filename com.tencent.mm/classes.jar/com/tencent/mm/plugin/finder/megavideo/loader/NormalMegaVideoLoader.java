package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.cc;>;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/ui/MMFragmentActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMFragmentActivity;", "firstFeedId", "", "getFirstFeedId", "()J", "setFirstFeedId", "(J)V", "firstNonceId", "", "getFirstNonceId", "()Ljava/lang/String;", "setFirstNonceId", "(Ljava/lang/String;)V", "firstUserName", "getFirstUserName", "setFirstUserName", "needGetDetail", "", "getNeedGetDetail", "()Z", "setNeedGetDetail", "(Z)V", "showErrUi", "Lkotlin/Function2;", "", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "MegaVideoGetDetailResponse", "MegaVideoListResponse", "NormalMegaVideoDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NormalMegaVideoLoader
  extends BaseMegaVideoLoader
{
  public m<? super Integer, ? super String, ah> AUX;
  public kotlin.g.a.b<? super ca, ah> AUY;
  public long Bgq;
  public String Bgr;
  final MMFragmentActivity EzS;
  private String EzT;
  public boolean EzU;
  
  public NormalMegaVideoLoader(bui parambui, MMFragmentActivity paramMMFragmentActivity)
  {
    super(parambui);
    AppMethodBeat.i(342201);
    this.EzS = paramMMFragmentActivity;
    this.EzT = "";
    this.Bgr = "";
    AppMethodBeat.o(342201);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(342208);
    i locali = (i)new c();
    AppMethodBeat.o(342208);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(342211);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(342211);
    return locald;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(342221);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      localObject = paramIResponse.getIncrementList();
      int i;
      ca localca;
      if (localObject == null)
      {
        i = 0;
        if ((i > 0) && ((paramIResponse instanceof b)))
        {
          paramIResponse = paramIResponse.getIncrementList();
          kotlin.g.b.s.checkNotNull(paramIResponse);
          localca = (ca)paramIResponse.get(0);
          paramIResponse = localca.contact;
          if (paramIResponse != null) {
            break label119;
          }
          paramIResponse = "";
        }
      }
      for (;;)
      {
        this.EzT = paramIResponse;
        this.Bgq = localca.eDF();
        this.Bgr = localca.eDG();
        AppMethodBeat.o(342221);
        return;
        i = ((List)localObject).size();
        break;
        label119:
        localObject = paramIResponse.username;
        paramIResponse = (IResponse<cc>)localObject;
        if (localObject == null) {
          paramIResponse = "";
        }
      }
    }
    this.hasMore = paramIResponse.getHasMore();
    Object localObject = this.fetchEndCallback;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
    }
    AppMethodBeat.o(342221);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$MegaVideoGetDetailResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends IResponse<cc>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$MegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
  {
    public b(String paramString)
    {
      super(0, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$NormalMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends c
  {
    public c()
    {
      AppMethodBeat.i(342217);
      AppMethodBeat.o(342217);
    }
    
    private static final ah a(c paramc, NormalMegaVideoLoader paramNormalMegaVideoLoader, b.a parama)
    {
      AppMethodBeat.i(342229);
      kotlin.g.b.s.u(paramc, "this$0");
      kotlin.g.b.s.u(paramNormalMegaVideoLoader, "this$1");
      if (parama == null)
      {
        Log.i(paramc.getTAG(), kotlin.g.b.s.X("result == null finder id ", Long.valueOf(paramNormalMegaVideoLoader.Bgq)));
        paramc = paramNormalMegaVideoLoader.AUX;
        if (paramc != null) {
          paramc.invoke(Integer.valueOf(-1), null);
        }
        paramc = ah.aiuX;
        AppMethodBeat.o(342229);
        return paramc;
      }
      Log.i(paramc.getTAG(), "NormalMegaVideoLoader: CgiGetFinderFeedComment errType = " + parama.errType + ", errCode = " + parama.errCode);
      if ((parama.errType != 0) || (parama.errCode != 0))
      {
        paramc = aw.Gjk;
        if (!aw.iv(parama.errType, parama.errCode)) {}
      }
      else
      {
        paramc = ((ayl)parama.ott).feedObject;
        if (paramc != null)
        {
          NormalMegaVideoLoader.a locala = new NormalMegaVideoLoader.a(parama.errType, parama.errCode, parama.errMsg);
          parama = new ca(paramc);
          d.a locala1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          d.a.d(kotlin.a.p.listOf(paramc), paramNormalMegaVideoLoader.getContextObj());
          locala.setIncrementList(kotlin.a.p.listOf(parama));
          locala.setPullType(1000);
          paramNormalMegaVideoLoader.onFetchDone((IResponse)locala);
          paramc = paramNormalMegaVideoLoader.AUY;
          if (paramc != null) {
            paramc.invoke(parama);
          }
        }
      }
      for (;;)
      {
        paramc = ah.aiuX;
        AppMethodBeat.o(342229);
        return paramc;
        paramc = paramNormalMegaVideoLoader.AUX;
        if (paramc != null) {
          paramc.invoke(Integer.valueOf(parama.errCode), parama.errMsg);
        }
      }
    }
    
    public final IResponse<cc> callInit()
    {
      AppMethodBeat.i(342258);
      NormalMegaVideoLoader.b localb = new NormalMegaVideoLoader.b("");
      localb.setPullType(1000);
      Object localObject1 = this.EzV.getCache();
      Object localObject2;
      label166:
      long l;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null)
        {
          localObject2 = this.EzV;
          localObject1 = (c)this;
          if (((NormalMegaVideoLoader)localObject2).Bgq != 0L)
          {
            e.a locala = e.FMN;
            localObject2 = e.a.qh(((NormalMegaVideoLoader)localObject2).Bgq);
            if (localObject2 != null)
            {
              Log.i(((c)localObject1).getTAG(), "fetchInit: use finder cache data");
              localb.setIncrementList(kotlin.a.p.listOf(new ca((FinderObject)localObject2)));
            }
          }
        }
        if ((this.EzV.EzU) && (this.EzV.Bgq != 0L))
        {
          localObject1 = (CharSequence)this.EzV.Bgr;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label379;
          }
          i = 1;
          if (i == 0)
          {
            l = this.EzV.Bgq;
            localObject1 = this.EzV.Bgr;
            localObject2 = this.EzV.getContextObj();
            if (localObject2 != null) {
              break label384;
            }
          }
        }
      }
      label384:
      for (int i = 0;; i = ((bui)localObject2).AJo)
      {
        new az(l, (String)localObject1, i, 2, "", true, null, null, 0L, null, false, false, null, this.EzV.getContextObj(), 0, null, 57280).bFJ().b(new NormalMegaVideoLoader.c..ExternalSyntheticLambda0(this, this.EzV)).a((com.tencent.mm.vending.e.b)this.EzV.EzS);
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(342258);
        return localObject1;
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).pUj;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject2 = this.EzV;
        Log.i(getTAG(), kotlin.g.b.s.X("fetchInit: use old data list, size: ", Integer.valueOf(((ArrayList)localObject1).size())));
        localb.setIncrementList((List)localObject1);
        localObject1 = ((NormalMegaVideoLoader)localObject2).getCache();
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).lastBuffer)
        {
          localb.setLastBuffer((com.tencent.mm.bx.b)localObject1);
          localObject1 = ah.aiuX;
          break;
        }
        label379:
        i = 0;
        break label166;
      }
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(342247);
      kotlin.g.b.s.u(paramp, "scene");
      AppMethodBeat.o(342247);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      return null;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      return null;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(342241);
      List localList = kotlin.a.p.listOf(Integer.valueOf(4195));
      AppMethodBeat.o(342241);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeInit", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends BaseFeedLoader<cc>.a
  {
    d(NormalMegaVideoLoader paramNormalMegaVideoLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(342215);
      AppMethodBeat.o(342215);
    }
    
    public final void mergeInit(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(342224);
      kotlin.g.b.s.u(paramIResponse, "response");
      if ((paramIResponse instanceof NormalMegaVideoLoader.a))
      {
        if (paramIResponse.getIncrementList() == null) {
          paramIResponse.setIncrementList((List)ab.aivy);
        }
        com.tencent.mm.ae.d.uiThread((a)new a(this.EzV, paramIResponse, paramb));
        AppMethodBeat.o(342224);
        return;
      }
      super.mergeInit(paramIResponse, paramb);
      AppMethodBeat.o(342224);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(NormalMegaVideoLoader paramNormalMegaVideoLoader, IResponse<cc> paramIResponse, kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
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