package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ar;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.component.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "tabType", "", "category", "", "relatedListScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JILjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getCategory", "setCategory", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getRelatedListScene", "()I", "setRelatedListScene", "(I)V", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "isObservePostEvent", "", "onFetchDone", "response", "requestLoadMore", "requestRefresh", "FinderFeedRelInit", "FinderFeedRelListData", "FinderFeedRelRequest", "FinderFeedRelResponse", "plugin-finder_release"})
public final class b
  extends BaseFinderFeedLoader
{
  private final int IoU;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> KPL;
  public int KPQ;
  private String TAG;
  public String category;
  private final long feedId;
  private com.tencent.mm.bx.b lastBuffer;
  
  private b(long paramLong, int paramInt1, String paramString, int paramInt2, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    this.feedId = paramLong;
    this.IoU = paramInt1;
    this.category = paramString;
    this.KPQ = paramInt2;
    this.TAG = "Finder.FinderFeedRelTimelineLoader";
  }
  
  public final f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198170);
    paramdzp = (f)new b(paramdzp);
    AppMethodBeat.o(198170);
    return paramdzp;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(198174);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof d)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.KPL;
      if (localb != null)
      {
        localb.aA(paramIResponse);
        AppMethodBeat.o(198174);
        return;
      }
    }
    AppMethodBeat.o(198174);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(198173);
    c localc = new c(this.feedId, this.IoU, this.lastBuffer, 2, getContextObj(), this.category, this.KPQ);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(localc)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)localc);
    AppMethodBeat.o(198173);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(198172);
    c localc = new c(this.feedId, this.IoU, this.lastBuffer, 0, getContextObj(), this.category, this.KPQ);
    ad.i(getTAG(), "requestRefresh ".concat(String.valueOf(localc)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)localc);
    AppMethodBeat.o(198172);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(198171);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(198171);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "feedId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getFeedId", "()J", "plugin-finder_release"})
  public static final class a
    extends h
  {
    private final long feedId;
    
    public a(long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      super();
      AppMethodBeat.i(198163);
      this.feedId = paramLong;
      AppMethodBeat.o(198163);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    extends f<b.a, b.c, BaseFinderFeed>
    implements com.tencent.mm.al.g
  {
    private final FinderTimelineRefCacheVM KNr;
    private e<BaseFinderFeed> KPR;
    private final String TAG;
    
    public b(dzp paramdzp)
    {
      super();
      AppMethodBeat.i(198169);
      this.TAG = "Finder.FinderFeedRelListData";
      paramdzp = a.LCX;
      paramdzp = a.bE(PluginFinder.class).get(FinderTimelineRefCacheVM.class);
      k.g(paramdzp, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
      this.KNr = ((FinderTimelineRefCacheVM)paramdzp);
      AppMethodBeat.o(198169);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(198165);
      com.tencent.mm.kernel.g.aeS().a(3688, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198165);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(198166);
      com.tencent.mm.kernel.g.aeS().b(3688, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198166);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      Object localObject1 = null;
      AppMethodBeat.i(198167);
      if ((paramn instanceof ar))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        b.d locald;
        for (boolean bool = ((ar)paramn).fRW();; bool = true)
        {
          locald = new b.d(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((ar)paramn).fRV();
          paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            localObject4 = FinderItem.qJU;
            localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
            paramString.add(com.tencent.mm.plugin.finder.storage.logic.b.a.h((FinderItem)localObject3));
          }
        }
        locald.setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        com.tencent.mm.plugin.finder.storage.logic.b.a.a((List)((ar)paramn).fRV(), 1, false, null, true, this.contextObj, 40);
        Object localObject2 = this.TAG;
        Object localObject3 = new StringBuilder("incrementList size: ");
        Object localObject4 = locald.getIncrementList();
        paramString = localObject1;
        if (localObject4 != null) {
          paramString = Integer.valueOf(((List)localObject4).size());
        }
        ad.i((String)localObject2, paramString);
        locald.setPullType(((ar)paramn).pullType);
        locald.setLastBuffer(((ar)paramn).ckJ());
        locald.setHasMore(bool);
        paramString = this.KPR;
        if (paramString != null)
        {
          paramString.onFetchDone((IResponse)locald);
          AppMethodBeat.o(198167);
          return;
        }
      }
      AppMethodBeat.o(198167);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "feedId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "category", "", "scene", "(JILcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;I)V", "getCategory", "()Ljava/lang/String;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "getScene", "setScene", "(I)V", "getTabType", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    final int IoU;
    final String category;
    final dzp contextObj;
    final long feedId;
    final com.tencent.mm.bx.b lastBuffer;
    final int pullType;
    int scene;
    
    public c(long paramLong, int paramInt1, com.tencent.mm.bx.b paramb, int paramInt2, dzp paramdzp, String paramString, int paramInt3)
    {
      this.feedId = paramLong;
      this.IoU = paramInt1;
      this.lastBuffer = paramb;
      this.pullType = paramInt2;
      this.contextObj = paramdzp;
      this.category = paramString;
      this.scene = paramInt3;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class d
    extends IResponse<BaseFinderFeed>
  {
    public d(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.b
 * JD-Core Version:    0.7.0.1
 */