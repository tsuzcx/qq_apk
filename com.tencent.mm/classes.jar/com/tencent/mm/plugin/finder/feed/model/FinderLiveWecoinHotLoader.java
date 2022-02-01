package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.live.model.cgi.bd;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "liveId", "", "objectId", "objectNonceId", "", "rewardType", "", "ifUseNewHeat", "", "(JJLjava/lang/String;ILjava/lang/Boolean;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getIfUseNewHeat", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "()Ljava/lang/String;", "getRewardType", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LiveWecoinHotFetcher", "LiveWecoinHotResponse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveWecoinHotLoader
  extends BaseFeedLoader<cc>
{
  public static final a Bhz;
  final int BhA;
  public final Boolean BhB;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  final long hKN;
  final long liveId;
  final String objectNonceId;
  
  static
  {
    AppMethodBeat.i(366340);
    Bhz = new a((byte)0);
    AppMethodBeat.o(366340);
  }
  
  public FinderLiveWecoinHotLoader(long paramLong1, long paramLong2, String paramString, int paramInt, Boolean paramBoolean)
  {
    super(null);
    AppMethodBeat.i(366337);
    this.liveId = paramLong1;
    this.hKN = paramLong2;
    this.objectNonceId = paramString;
    this.BhA = paramInt;
    this.BhB = paramBoolean;
    AppMethodBeat.o(366337);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366346);
    i locali = (i)new b();
    AppMethodBeat.o(366346);
    return locali;
  }
  
  public final void onFetchDone(final IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366351);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aYj());
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(366351);
      return;
    }
    d.uiThread((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(366351);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends c
  {
    public b()
    {
      AppMethodBeat.i(366180);
      AppMethodBeat.o(366180);
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366229);
      s.u(paramp, "scene");
      Log.i("FinderLiveWecoinHotLoader", "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      Object localObject1 = new FinderLiveWecoinHotLoader.c(paramInt1, paramInt2, paramString);
      if (((paramp instanceof bd)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject2 = (Iterable)((bd)paramp).emF();
        localObject1 = this.BhC;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bmd localbmd = (bmd)((Iterator)localObject2).next();
          ((FinderLiveWecoinHotLoader)localObject1).getDataList().add(new as(((bd)paramp).emF().size(), ((bd)paramp).emG(), localbmd));
        }
        Log.i("FinderLiveWecoinHotLoader", "onSceneEnd:ifUseNewHeat:" + this.BhC.BhB + ", getNewTotalWecoinHot:" + ((bd)paramp).emH() + ",getTotalWecoinHot:" + ((bd)paramp).emG());
        if (s.p(this.BhC.BhB, Boolean.TRUE)) {
          paramString = new FinderLiveWecoinHotLoader.c(paramInt1, paramInt2, paramString, ((bd)paramp).emF(), ((bd)paramp).emH());
        }
      }
      for (;;)
      {
        paramString = (IResponse)paramString;
        AppMethodBeat.o(366229);
        return paramString;
        paramString = new FinderLiveWecoinHotLoader.c(paramInt1, paramInt2, paramString, ((bd)paramp).emF(), ((bd)paramp).emG());
        continue;
        paramString = (String)localObject1;
      }
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366211);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new bd(this.BhC.liveId, this.BhC.hKN, this.BhC.objectNonceId, this.BhC.getLastBuffer(), this.BhC.BhA);
      AppMethodBeat.o(366211);
      return localp;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(366195);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new bd(this.BhC.liveId, this.BhC.hKN, this.BhC.objectNonceId, this.BhC.getLastBuffer(), this.BhC.BhA);
      AppMethodBeat.o(366195);
      return localp;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366188);
      List localList = kotlin.a.p.listOf(Integer.valueOf(4168));
      AppMethodBeat.o(366188);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "wecoinHotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "totalWecoinHot", "", "(IILjava/lang/String;Ljava/util/LinkedList;J)V", "getTotalWecoinHot", "()J", "getWecoinHotList", "()Ljava/util/LinkedList;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public final LinkedList<bmd> BhD;
    public final long BhE;
    
    public c(int paramInt1, int paramInt2, String paramString, LinkedList<bmd> paramLinkedList, long paramLong)
    {
      super(paramInt2, paramString);
      AppMethodBeat.i(366196);
      this.BhD = paramLinkedList;
      this.BhE = paramLong;
      AppMethodBeat.o(366196);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(FinderLiveWecoinHotLoader paramFinderLiveWecoinHotLoader, IResponse<cc> paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader
 * JD-Core Version:    0.7.0.1
 */