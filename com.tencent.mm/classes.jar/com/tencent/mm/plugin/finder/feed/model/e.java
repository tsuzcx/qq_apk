package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.component.a;
import d.a.j;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "tabType", "", "category", "", "relatedListScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JILjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getCategory", "setCategory", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getRelatedListScene", "()I", "setRelatedListScene", "(I)V", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "isObservePostEvent", "", "onFetchDone", "response", "requestLoadMore", "requestRefresh", "FinderFeedRelInit", "FinderFeedRelListData", "FinderFeedRelRequest", "FinderFeedRelResponse", "plugin-finder_release"})
public final class e
  extends BaseFinderFeedLoader
{
  private String TAG;
  public String category;
  private final long dig;
  private final int diw;
  private com.tencent.mm.bw.b lastBuffer;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> rmE;
  public int rmK;
  
  private e(long paramLong, int paramInt1, String paramString, int paramInt2, anm paramanm)
  {
    super(null, paramanm, 1, null);
    this.dig = paramLong;
    this.diw = paramInt1;
    this.category = paramString;
    this.rmK = paramInt2;
    this.TAG = "Finder.FinderFeedRelTimelineLoader";
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.e<Object, Object, h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(202079);
    paramanm = (com.tencent.mm.plugin.finder.feed.model.internal.e)new b(paramanm);
    AppMethodBeat.o(202079);
    return paramanm;
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
    AppMethodBeat.i(202083);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof d)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.rmE;
      if (localb != null)
      {
        localb.ay(paramIResponse);
        AppMethodBeat.o(202083);
        return;
      }
    }
    AppMethodBeat.o(202083);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(202082);
    c localc = new c(this.dig, this.diw, this.lastBuffer, 2, getContextObj(), this.category, this.rmK);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(localc)));
    fetchData((i)localc);
    AppMethodBeat.o(202082);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202081);
    c localc = new c(this.dig, this.diw, this.lastBuffer, 0, getContextObj(), this.category, this.rmK);
    ac.i(getTAG(), "requestRefresh ".concat(String.valueOf(localc)));
    fetchData((i)localc);
    AppMethodBeat.o(202081);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(202080);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(202080);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "feedId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getFeedId", "()J", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    private final long dig;
    
    public a(long paramLong, f paramf)
    {
      super();
      AppMethodBeat.i(202072);
      this.dig = paramLong;
      AppMethodBeat.o(202072);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.e<e.a, e.c, BaseFinderFeed>
    implements com.tencent.mm.ak.g
  {
    private final String TAG;
    private final FinderTimelineRefCacheVM rhJ;
    private d<BaseFinderFeed> rmL;
    
    public b(anm paramanm)
    {
      super();
      AppMethodBeat.i(202078);
      this.TAG = "Finder.FinderFeedRelListData";
      paramanm = a.IrY;
      paramanm = a.bg(PluginFinder.class).get(FinderTimelineRefCacheVM.class);
      k.g(paramanm, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
      this.rhJ = ((FinderTimelineRefCacheVM)paramanm);
      AppMethodBeat.o(202078);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202074);
      com.tencent.mm.kernel.g.agi().a(3688, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202074);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202075);
      com.tencent.mm.kernel.g.agi().b(3688, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202075);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      Object localObject1 = null;
      AppMethodBeat.i(202076);
      if ((paramn instanceof ab))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        e.d locald;
        for (boolean bool = ((ab)paramn).css();; bool = true)
        {
          locald = new e.d(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((ab)paramn).csr();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            localObject4 = FinderItem.rDA;
            localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
            paramString.add(b.a.i((FinderItem)localObject3));
          }
        }
        locald.setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        b.a.a((List)((ab)paramn).csr(), 1, false, null, true, this.contextObj, 40);
        Object localObject2 = this.TAG;
        Object localObject3 = new StringBuilder("incrementList size: ");
        Object localObject4 = locald.getIncrementList();
        paramString = localObject1;
        if (localObject4 != null) {
          paramString = Integer.valueOf(((List)localObject4).size());
        }
        ac.i((String)localObject2, paramString);
        locald.setPullType(((ab)paramn).pullType);
        locald.setLastBuffer(((ab)paramn).csq());
        locald.setHasMore(bool);
        paramString = this.rmL;
        if (paramString != null)
        {
          paramString.onFetchDone((IResponse)locald);
          AppMethodBeat.o(202076);
          return;
        }
      }
      AppMethodBeat.o(202076);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "feedId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "category", "", "scene", "(JILcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;I)V", "getCategory", "()Ljava/lang/String;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "getScene", "setScene", "(I)V", "getTabType", "plugin-finder_release"})
  public static final class c
    implements i
  {
    final String category;
    final anm contextObj;
    final long dig;
    final int diw;
    final com.tencent.mm.bw.b lastBuffer;
    final int pullType;
    int scene;
    
    public c(long paramLong, int paramInt1, com.tencent.mm.bw.b paramb, int paramInt2, anm paramanm, String paramString, int paramInt3)
    {
      this.dig = paramLong;
      this.diw = paramInt1;
      this.lastBuffer = paramb;
      this.pullType = paramInt2;
      this.contextObj = paramanm;
      this.category = paramString;
      this.scene = paramInt3;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class d
    extends IResponse<BaseFinderFeed>
  {
    public d(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.e
 * JD-Core Version:    0.7.0.1
 */