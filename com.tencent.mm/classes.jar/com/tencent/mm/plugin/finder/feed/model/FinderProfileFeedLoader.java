package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "username", "", "oldDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getOldDataList", "()Ljava/util/ArrayList;", "onFetchCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/ProfileResponse;", "getOnFetchCallback", "()Lkotlin/jvm/functions/Function1;", "setOnFetchCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getLastItem", "", "isObservePostEvent", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onFetchRefreshDone", "requestLoadMore", "requestRefresh", "sort", "plugin-finder_release"})
public final class FinderProfileFeedLoader
  extends BaseFinderFeedLoader
{
  private String TAG;
  private d.g.a.a<y> fetchEndCallback;
  private boolean isLoadingMore;
  private com.tencent.mm.bx.b lastBuffer;
  private final ArrayList<BaseFinderFeed> oldDataList;
  private d.g.a.b<? super q, y> onFetchCallback;
  
  public FinderProfileFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.b paramb, String paramString, ArrayList<BaseFinderFeed> paramArrayList, dzp paramdzp)
  {
    super(paramString, paramdzp);
    AppMethodBeat.i(198274);
    this.oldDataList = paramArrayList;
    this.TAG = "Finder.FinderProfileFeedLoader";
    AppMethodBeat.o(198274);
  }
  
  private final void sort()
  {
    AppMethodBeat.i(198273);
    List localList = (List)getDataList();
    if (localList.size() > 1) {
      d.a.j.a(localList, (Comparator)new Comparator()
      {
        public final int compare(T paramAnonymousT1, T paramAnonymousT2)
        {
          AppMethodBeat.i(198271);
          int i = d.b.a.a((Comparable)Integer.valueOf(((BaseFinderFeed)paramAnonymousT2).feedObject.getCreateTime()), (Comparable)Integer.valueOf(((BaseFinderFeed)paramAnonymousT1).feedObject.getCreateTime()));
          AppMethodBeat.o(198271);
          return i;
        }
      });
    }
    AppMethodBeat.o(198273);
  }
  
  public final f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198272);
    paramdzp = (f)new n(paramdzp);
    AppMethodBeat.o(198272);
    return paramdzp;
  }
  
  public final d.g.a.a<y> getFetchEndCallback()
  {
    return this.fetchEndCallback;
  }
  
  public final com.tencent.mm.bx.b getLastBuffer()
  {
    return this.lastBuffer;
  }
  
  public final long getLastItem()
  {
    AppMethodBeat.i(166044);
    int i = getDataList().size() - 1;
    while (i >= 0)
    {
      if (((BaseFinderFeed)getDataList().get(i)).feedObject.getId() != 0L)
      {
        long l = ((BaseFinderFeed)getDataList().get(i)).feedObject.getId();
        AppMethodBeat.o(166044);
        return l;
      }
      i -= 1;
    }
    AppMethodBeat.o(166044);
    return 0L;
  }
  
  public final ArrayList<BaseFinderFeed> getOldDataList()
  {
    return this.oldDataList;
  }
  
  public final d.g.a.b<q, y> getOnFetchCallback()
  {
    return this.onFetchCallback;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean isLoadingMore()
  {
    return this.isLoadingMore;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(166046);
    k.h(paramIResponse, "response");
    d.g.a.b localb = this.onFetchCallback;
    if (localb != null) {
      localb.aA((q)paramIResponse);
    }
    if (2 == paramIResponse.getPullType()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.isLoadingMore = false;
      }
      this.lastBuffer = paramIResponse.getLastBuffer();
      super.onFetchDone(paramIResponse);
      if ((i == 0) || (paramIResponse.getHasMore())) {
        break;
      }
      paramIResponse = this.fetchEndCallback;
      if (paramIResponse == null) {
        break;
      }
      paramIResponse.invoke();
      AppMethodBeat.o(166046);
      return;
    }
    AppMethodBeat.o(166046);
  }
  
  public final void onFetchRefreshDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(166047);
    k.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.HXu;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fiH());
    paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.l(7, paramIResponse.getIncrementList(), false, 12);
    dispatcher().a(paramIResponse, (RefreshLoadMoreLayout.c)localObject);
    AppMethodBeat.o(166047);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(166045);
    if (this.isLoadingMore)
    {
      ad.i(getTAG(), "isLoadingMore return");
      AppMethodBeat.o(166045);
      return;
    }
    this.isLoadingMore = true;
    long l = getLastItem();
    p localp = new p(getUsername(), l, 2, this.lastBuffer, getContextObj());
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(localp)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)localp);
    AppMethodBeat.o(166045);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(166043);
    p localp = new p(getUsername(), 0L, 1, null, getContextObj());
    ad.i(getTAG(), "111 requestRefresh ".concat(String.valueOf(localp)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)localp);
    AppMethodBeat.o(166043);
  }
  
  public final void setFetchEndCallback(d.g.a.a<y> parama)
  {
    this.fetchEndCallback = parama;
  }
  
  public final void setLastBuffer(com.tencent.mm.bx.b paramb)
  {
    this.lastBuffer = paramb;
  }
  
  public final void setLoadingMore(boolean paramBoolean)
  {
    this.isLoadingMore = paramBoolean;
  }
  
  public final void setOnFetchCallback(d.g.a.b<? super q, y> paramb)
  {
    this.onFetchCallback = paramb;
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(166042);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(166042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader
 * JD-Core Version:    0.7.0.1
 */