package com.tencent.mm.plugin.finder.live.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.live.cgi.z;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bny;
import com.tencent.mm.protocal.protobuf.bui;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/loader/FinderProfileLiveUserPageLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "targetUsername", "", "myUsername", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "initFeedData", "", "Lcom/tencent/mm/plugin/finder/model/FinderLiveReplayFeed;", "getInitFeedData", "()Ljava/util/List;", "setInitFeedData", "(Ljava/util/List;)V", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getInitLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setInitLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getMyUsername", "()Ljava/lang/String;", "getTargetUsername", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "ReplayLiveDataFetcher", "ReplayLiveResponse", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileLiveUserPageLoader
  extends BaseFeedLoader<cc>
{
  final String ACm;
  public List<ap> BiP;
  public com.tencent.mm.bx.b BiQ;
  final String CvR;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  
  public FinderProfileLiveUserPageLoader(String paramString1, String paramString2, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(351012);
    this.ACm = paramString1;
    this.CvR = paramString2;
    AppMethodBeat.o(351012);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(351025);
    i locali = (i)new a();
    AppMethodBeat.o(351025);
    return locali;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(351033);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramIResponse);
    a.c("com/tencent/mm/plugin/finder/live/loader/FinderProfileLiveUserPageLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      a.a(this, "com/tencent/mm/plugin/finder/live/loader/FinderProfileLiveUserPageLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(351033);
      return;
    }
    localObject = this.fetchEndCallback;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
    }
    a.a(this, "com/tencent/mm/plugin/finder/live/loader/FinderProfileLiveUserPageLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(351033);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/loader/FinderProfileLiveUserPageLoader$ReplayLiveDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/live/loader/FinderProfileLiveUserPageLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public a()
    {
      AppMethodBeat.i(350995);
      AppMethodBeat.o(350995);
    }
    
    public final IResponse<cc> callInit()
    {
      AppMethodBeat.i(351021);
      Object localObject = new FinderProfileLiveUserPageLoader.b(0, 0, "");
      FinderProfileLiveUserPageLoader localFinderProfileLiveUserPageLoader = this.CDu;
      ((FinderProfileLiveUserPageLoader.b)localObject).setIncrementList(localFinderProfileLiveUserPageLoader.BiP);
      ((FinderProfileLiveUserPageLoader.b)localObject).setLastBuffer(localFinderProfileLiveUserPageLoader.BiQ);
      localObject = (IResponse)localObject;
      AppMethodBeat.o(351021);
      return localObject;
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(351030);
      s.u(paramp, "scene");
      if ((paramp instanceof z))
      {
        paramString = new FinderProfileLiveUserPageLoader.b(paramInt1, paramInt2, paramString);
        Object localObject1 = c.c.b(((z)paramp).oDw.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveUserPageResponse");
          AppMethodBeat.o(351030);
          throw paramString;
        }
        if (((bny)localObject1).BeA == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.setHasMore(bool);
          Object localObject2 = (Iterable)((z)paramp).ehp();
          localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(new ap((FinderObject)((Iterator)localObject2).next()));
          }
        }
        paramString.setIncrementList((List)localObject1);
        paramString.setLastBuffer(((z)paramp).getLastBuffer());
        paramString.setPullType(((z)paramp).pullType);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(351030);
        return paramString;
      }
      AppMethodBeat.o(351030);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(351014);
      Object localObject = new z(this.CDu.ACm, this.CDu.CvR, this.CDu.getLastBuffer(), this.CDu.getContextObj());
      ((z)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(351014);
      return localObject;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(351008);
      Object localObject = new z(this.CDu.ACm, this.CDu.CvR, null, this.CDu.getContextObj());
      ((z)localObject).pullType = 0;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(351008);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(351000);
      List localList = kotlin.a.p.listOf(Integer.valueOf(5870));
      AppMethodBeat.o(351000);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/loader/FinderProfileLiveUserPageLoader$ReplayLiveResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.loader.FinderProfileLiveUserPageLoader
 * JD-Core Version:    0.7.0.1
 */