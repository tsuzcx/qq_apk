package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.live.model.cgi.z;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "liveId", "", "objectId", "objectNonceId", "", "(JJLjava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LiveWecoinHotFetcher", "LiveWecoinHotResponse", "plugin-finder_release"})
public final class FinderLiveWecoinHotLoader
  extends BaseFeedLoader<bo>
{
  public static final a tWt;
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  final long hFK;
  final long liveId;
  final String objectNonceId;
  
  static
  {
    AppMethodBeat.i(244749);
    tWt = new a((byte)0);
    AppMethodBeat.o(244749);
  }
  
  public FinderLiveWecoinHotLoader(long paramLong1, long paramLong2, String paramString)
  {
    super(null);
    AppMethodBeat.i(244748);
    this.liveId = paramLong1;
    this.hFK = paramLong2;
    this.objectNonceId = paramString;
    AppMethodBeat.o(244748);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244746);
    g localg = (g)new b();
    AppMethodBeat.o(244746);
    return localg;
  }
  
  public final void onFetchDone(final IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244747);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.axR());
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(244747);
      return;
    }
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(244747);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(244742);
      p.h(paramq, "scene");
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      Object localObject2 = new FinderLiveWecoinHotLoader.c(paramInt1, paramInt2, paramString);
      Object localObject1 = localObject2;
      if ((paramq instanceof z))
      {
        localObject1 = localObject2;
        if (paramInt1 == 0)
        {
          localObject1 = localObject2;
          if (paramInt2 == 0)
          {
            localObject1 = ((Iterable)((z)paramq).dgH()).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (axa)((Iterator)localObject1).next();
              this.tWu.getDataList().add(new am(((z)paramq).dgH().size(), (axa)localObject2));
            }
            localObject1 = ((z)paramq).dgH();
            paramq = ((z)paramq).rr.aYK();
            if (paramq == null)
            {
              paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
              AppMethodBeat.o(244742);
              throw paramString;
            }
            localObject1 = new FinderLiveWecoinHotLoader.c(paramInt1, paramInt2, paramString, (LinkedList)localObject1, ((asy)paramq).LDN);
          }
        }
      }
      paramString = (IResponse)localObject1;
      AppMethodBeat.o(244742);
      return paramString;
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244741);
      com.tencent.mm.ak.q localq = (com.tencent.mm.ak.q)new z(this.tWu.liveId, this.tWu.hFK, this.tWu.objectNonceId, this.tWu.getLastBuffer());
      AppMethodBeat.o(244741);
      return localq;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(244740);
      com.tencent.mm.ak.q localq = (com.tencent.mm.ak.q)new z(this.tWu.liveId, this.tWu.hFK, this.tWu.objectNonceId, this.tWu.getLastBuffer());
      AppMethodBeat.o(244740);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244739);
      List localList = j.listOf(Integer.valueOf(4168));
      AppMethodBeat.o(244739);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "wecoinHotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "totalWecoinHot", "", "(IILjava/lang/String;Ljava/util/LinkedList;J)V", "getTotalWecoinHot", "()J", "getWecoinHotList", "()Ljava/util/LinkedList;", "plugin-finder_release"})
  public static final class c
    extends IResponse<bo>
  {
    public final LinkedList<axa> tWv;
    public final long tWw;
    
    public c(int paramInt1, int paramInt2, String paramString, LinkedList<axa> paramLinkedList, long paramLong)
    {
      super(paramInt2, paramString);
      AppMethodBeat.i(244743);
      this.tWv = paramLinkedList;
      this.tWw = paramLong;
      AppMethodBeat.o(244743);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(FinderLiveWecoinHotLoader paramFinderLiveWecoinHotLoader, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader
 * JD-Core Version:    0.7.0.1
 */