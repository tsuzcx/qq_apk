package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.aj;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "nonceId", "", "tabType", "", "category", "relatedListScene", "hasMoreAfterInit", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILjava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getHasMoreAfterInit", "()Z", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderRelStreamInterceptor;", "getNonceId", "refreshCallback", "getRefreshCallback", "setRefreshCallback", "getRelatedListScene", "()I", "setRelatedListScene", "(I)V", "getTabType", "addInterceptor", "interceptor", "order", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "interceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelResponse;", "", "interceptBeforeStore", "isObservePostEvent", "onFetchDone", "response", "onFetchInitDone", "initResponse", "onFetchRefreshDone", "removeInterceptor", "FeedRelDataFetcher", "FinderFeedRelResponse", "plugin-finder_release"})
public final class FinderFeedRelTimelineLoader
  extends BaseFinderFeedLoader
{
  public String category;
  final long duw;
  final int dvm;
  public d.g.a.b<? super IResponse<am>, z> fetchEndCallback;
  final String rPZ;
  public int rQa;
  private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.cgi.interceptor.g<com.tencent.mm.plugin.finder.cgi.interceptor.e>> rQt;
  public d.g.a.b<? super IResponse<am>, z> skd;
  final boolean ske;
  
  private FinderFeedRelTimelineLoader(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202818);
    this.duw = paramLong;
    this.rPZ = paramString1;
    this.dvm = paramInt1;
    this.category = paramString2;
    this.rQa = paramInt2;
    this.ske = paramBoolean;
    this.rQt = new ConcurrentLinkedQueue();
    AppMethodBeat.o(202818);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<am> createDataFetch()
  {
    AppMethodBeat.i(202814);
    com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new a();
    AppMethodBeat.o(202814);
    return localg;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202815);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202815);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202815);
        return;
      }
    }
    AppMethodBeat.o(202815);
  }
  
  public final void onFetchInitDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202816);
    p.h(paramIResponse, "initResponse");
    super.onFetchInitDone(paramIResponse);
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202816);
        return;
      }
    }
    AppMethodBeat.o(202816);
  }
  
  public final void onFetchRefreshDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202817);
    p.h(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    d.g.a.b localb = this.skd;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(202817);
      return;
    }
    AppMethodBeat.o(202817);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FeedRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<am> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(202812);
      FinderFeedRelTimelineLoader.b localb = new FinderFeedRelTimelineLoader.b("", 0, 0, "");
      Object localObject1 = this.skf.getCache();
      if (localObject1 != null) {}
      for (localObject1 = ((e)localObject1).jhZ;; localObject1 = null)
      {
        localb.setIncrementList((List)localObject1);
        e locale = this.skf.getCache();
        localObject1 = localObject2;
        if (locale != null) {
          localObject1 = locale.lastBuffer;
        }
        localb.setLastBuffer((com.tencent.mm.bw.b)localObject1);
        localb.setHasMore(this.skf.ske);
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(202812);
        return localObject1;
      }
    }
    
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202811);
      p.h(paramn, "scene");
      if ((paramn instanceof aj))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (boolean bool = ((aj)paramn).czK();; bool = true)
        {
          localObject1 = (a)this;
          localObject3 = (Iterable)j.a((Iterable)FinderFeedRelTimelineLoader.a(this.skf), (Comparator)new a());
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add((com.tencent.mm.plugin.finder.cgi.interceptor.e)((com.tencent.mm.plugin.finder.cgi.interceptor.g)((Iterator)localObject3).next()).rTp);
          }
        }
        Object localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.finder.cgi.interceptor.e)((Iterator)localObject2).next();
          if (((aj)paramn).rr.aEV() == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(202811);
            throw paramString;
          }
          if (((com.tencent.mm.plugin.finder.cgi.interceptor.e)localObject3).cAt()) {
            ae.w(((a)localObject1).getTAG(), "[onCgiBack] Interceptor is interrupted by ".concat(String.valueOf(localObject3)));
          }
        }
        localObject2 = ((aj)paramn).getWording();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject1 = new FinderFeedRelTimelineLoader.b((String)localObject1, paramInt1, paramInt2, paramString);
        localObject2 = (Iterable)((aj)paramn).czJ();
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.sJb;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          paramString.add(b.a.j((FinderItem)localObject3));
        }
        ((FinderFeedRelTimelineLoader.b)localObject1).setIncrementList((List)paramString);
        localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderFeedRelTimelineLoader.b)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ae.i((String)localObject2, paramString);
          ((FinderFeedRelTimelineLoader.b)localObject1).setPullType(((aj)paramn).pullType);
          ((FinderFeedRelTimelineLoader.b)localObject1).setLastBuffer(((aj)paramn).czI());
          ((FinderFeedRelTimelineLoader.b)localObject1).setHasMore(bool);
          paramString = this.skf;
          localObject3 = (Iterable)j.a((Iterable)FinderFeedRelTimelineLoader.a(this.skf), (Comparator)new b());
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add((com.tencent.mm.plugin.finder.cgi.interceptor.e)((com.tencent.mm.plugin.finder.cgi.interceptor.g)((Iterator)localObject3).next()).rTp);
          }
        }
        FinderFeedRelTimelineLoader.a(paramString, j.l((Iterable)localObject2));
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        b.a.a((List)((aj)paramn).czJ(), 1, this.skf.getContextObj(), 4);
        paramString = this.skf;
        localObject2 = (Iterable)j.a((Iterable)FinderFeedRelTimelineLoader.a(this.skf), (Comparator)new c());
        paramn = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramn.add((com.tencent.mm.plugin.finder.cgi.interceptor.e)((com.tencent.mm.plugin.finder.cgi.interceptor.g)((Iterator)localObject2).next()).rTp);
        }
        FinderFeedRelTimelineLoader.b(paramString, j.l((Iterable)paramn));
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(202811);
        return paramString;
      }
      AppMethodBeat.o(202811);
      return null;
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202810);
      Object localObject = new aj(this.skf.duw, this.skf.rPZ, this.skf.dvm, this.skf.getLastBuffer(), this.skf.category, this.skf.rQa, this.skf.getContextObj());
      ((aj)localObject).pullType = 2;
      localObject = (n)localObject;
      AppMethodBeat.o(202810);
      return localObject;
    }
    
    public final n genRefreshNetScene()
    {
      AppMethodBeat.i(202809);
      Object localObject = new aj(this.skf.duw, this.skf.rPZ, this.skf.dvm, this.skf.getLastBuffer(), this.skf.category, this.skf.rQa, this.skf.getContextObj());
      ((aj)localObject).pullType = 0;
      localObject = (n)localObject;
      AppMethodBeat.o(202809);
      return localObject;
    }
    
    public final int getCmdId()
    {
      return 3688;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(202806);
        int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.g)paramT1).order), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.g)paramT2).order));
        AppMethodBeat.o(202806);
        return i;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class b<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(202807);
        int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.g)paramT1).order), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.g)paramT2).order));
        AppMethodBeat.o(202807);
        return i;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class c<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(202808);
        int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.g)paramT1).order), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.g)paramT2).order));
        AppMethodBeat.o(202808);
        return i;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "title", "", "errType", "", "errCode", "errMsg", "(Ljava/lang/String;IILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class b
    extends IResponse<am>
  {
    public final String title;
    
    public b(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      super(paramInt2, paramString2);
      AppMethodBeat.i(202813);
      this.title = paramString1;
      AppMethodBeat.o(202813);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader
 * JD-Core Version:    0.7.0.1
 */