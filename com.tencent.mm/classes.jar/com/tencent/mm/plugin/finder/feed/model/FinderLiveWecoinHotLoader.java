package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.live.model.cgi.ap;
import com.tencent.mm.plugin.finder.model.ao;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "liveId", "", "objectId", "objectNonceId", "", "(JJLjava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LiveWecoinHotFetcher", "LiveWecoinHotResponse", "plugin-finder_release"})
public final class FinderLiveWecoinHotLoader
  extends BaseFeedLoader<bu>
{
  public static final a xIm;
  public kotlin.g.a.b<? super IResponse<bu>, x> fetchEndCallback;
  final long liveId;
  final String objectNonceId;
  final long xbk;
  
  static
  {
    AppMethodBeat.i(282169);
    xIm = new a((byte)0);
    AppMethodBeat.o(282169);
  }
  
  public FinderLiveWecoinHotLoader(long paramLong1, long paramLong2, String paramString)
  {
    super(null);
    AppMethodBeat.i(282167);
    this.liveId = paramLong1;
    this.xbk = paramLong2;
    this.objectNonceId = paramString;
    AppMethodBeat.o(282167);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(282164);
    i locali = (i)new b();
    AppMethodBeat.o(282164);
    return locali;
  }
  
  public final void onFetchDone(final IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(282165);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aFi());
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(282165);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(282165);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends c
  {
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(284309);
      p.k(paramq, "scene");
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      Object localObject = new FinderLiveWecoinHotLoader.c(paramInt1, paramInt2, paramString);
      if (((paramq instanceof ap)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = ((Iterable)((ap)paramq).dzZ()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          bcc localbcc = (bcc)((Iterator)localObject).next();
          this.xIn.getDataList().add(new ao(((ap)paramq).dzZ().size(), ((ap)paramq).dAa(), localbcc));
        }
        localObject = com.tencent.c.a.a.a.a.a.Zlt;
        if (((Number)com.tencent.c.a.a.a.a.a.ilj().aSr()).intValue() == 1)
        {
          localObject = ((ap)paramq).dzZ();
          paramq = ((ap)paramq).rr.bhY();
          if (paramq == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
            AppMethodBeat.o(284309);
            throw paramString;
          }
          paramString = new FinderLiveWecoinHotLoader.c(paramInt1, paramInt2, paramString, (LinkedList)localObject, ((avb)paramq).SHu);
        }
      }
      for (;;)
      {
        paramString = (IResponse)paramString;
        AppMethodBeat.o(284309);
        return paramString;
        paramString = new FinderLiveWecoinHotLoader.c(paramInt1, paramInt2, paramString, ((ap)paramq).dzZ(), ((ap)paramq).dAa());
        continue;
        paramString = (String)localObject;
      }
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(284306);
      com.tencent.mm.an.q localq = (com.tencent.mm.an.q)new ap(this.xIn.liveId, this.xIn.xbk, this.xIn.objectNonceId, this.xIn.getLastBuffer());
      AppMethodBeat.o(284306);
      return localq;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(284305);
      com.tencent.mm.an.q localq = (com.tencent.mm.an.q)new ap(this.xIn.liveId, this.xIn.xbk, this.xIn.objectNonceId, this.xIn.getLastBuffer());
      AppMethodBeat.o(284305);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(284304);
      List localList = j.listOf(Integer.valueOf(4168));
      AppMethodBeat.o(284304);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "wecoinHotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "totalWecoinHot", "", "(IILjava/lang/String;Ljava/util/LinkedList;J)V", "getTotalWecoinHot", "()J", "getWecoinHotList", "()Ljava/util/LinkedList;", "plugin-finder_release"})
  public static final class c
    extends IResponse<bu>
  {
    public final LinkedList<bcc> xIo;
    public final long xIp;
    
    public c(int paramInt1, int paramInt2, String paramString, LinkedList<bcc> paramLinkedList, long paramLong)
    {
      super(paramInt2, paramString);
      AppMethodBeat.i(288114);
      this.xIo = paramLinkedList;
      this.xIp = paramLong;
      AppMethodBeat.o(288114);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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