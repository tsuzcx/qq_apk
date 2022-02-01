package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "initRemoveItemCount", "", "getInitRemoveItemCount", "()I", "setInitRemoveItemCount", "(I)V", "needMergeLocalData", "", "getNeedMergeLocalData", "()Z", "setNeedMergeLocalData", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "", "isObservePostEvent", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "MegaVideoProfileDataFetcher", "MegaVideoProfileResponse", "plugin-finder_release"})
public final class FinderMegaVideoProfileLoader
  extends BaseMegaVideoLoader
{
  public final String tvp;
  public boolean uKQ;
  public int uKR;
  
  public FinderMegaVideoProfileLoader(String paramString, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(248402);
    this.tvp = paramString;
    AppMethodBeat.o(248402);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(248399);
    g localg = (g)new a();
    AppMethodBeat.o(248399);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(248400);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(248400);
    return localb;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(248401);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(248401);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(248401);
      return;
    }
    AppMethodBeat.o(248401);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "getCmdIds", "", "mergeLocalData", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "nowList", "username", "start", "end", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    private final List<bm> i(List<bm> paramList, String paramString)
    {
      AppMethodBeat.i(248396);
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; (i != 0) || ((p.j(paramString, z.aUg()) ^ true)) || (!this.uKS.uKQ); i = 0)
      {
        AppMethodBeat.o(248396);
        return paramList;
      }
      Log.i(getTAG(), "mergeLocalData start 0 end 2147483647");
      LinkedList localLinkedList = new LinkedList();
      Object localObject = c.vGN;
      paramString = c.a.af(paramString, 0, 2147483647);
      localLinkedList.addAll((Collection)paramList);
      localObject = (List)localLinkedList;
      if (((List)localObject).size() > 1) {
        j.a((List)localObject, (Comparator)new b());
      }
      d.a(paramString, (kotlin.g.a.b)new c(paramList));
      localObject = (Iterable)paramString;
      paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
        bm localbm = new bm(localFinderItem.getFeedObject());
        localbm.uOW = localFinderItem;
        paramList.add(localbm);
      }
      localLinkedList.addAll(0, (Collection)paramList);
      Log.i(getTAG(), "mergeLocalData: databaseList size:" + paramString.size());
      paramList = ((Iterable)paramString).iterator();
      while (paramList.hasNext())
      {
        paramString = (FinderItem)paramList.next();
        Log.i(getTAG(), "mergeLocalData: databaseList item, localId:" + paramString.getLocalId() + ", id:" + paramString.getId());
      }
      paramList = (List)localLinkedList;
      AppMethodBeat.o(248396);
      return paramList;
    }
    
    public final IResponse<bo> callInit()
    {
      AppMethodBeat.i(248395);
      Log.i(getTAG(), "fetchInit");
      final FinderMegaVideoProfileLoader.b localb = new FinderMegaVideoProfileLoader.b(0, 0, "");
      localb.setPullType(1000);
      Object localObject1 = this.uKS.getCache();
      if (localObject1 != null)
      {
        localObject1 = ((h)localObject1).kgc;
        if (localObject1 != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject1).size());
          if (!this.uKS.uKQ) {
            d.a((ArrayList)localObject1, (kotlin.g.a.b)new a(this, localb));
          }
          localb.setIncrementList((List)localObject1);
          localObject1 = this.uKS.getCache();
          if (localObject1 != null)
          {
            localObject1 = ((h)localObject1).lastBuffer;
            localb.setLastBuffer((com.tencent.mm.bw.b)localObject1);
          }
        }
      }
      for (;;)
      {
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(248395);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = com.tencent.mm.plugin.finder.storage.data.l.vGw.bc(13, this.uKS.tvp);
        Log.i(getTAG(), "fetchInit: use first page data list, size: " + ((List)localObject1).size());
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bo localbo = (bo)((Iterator)localObject2).next();
          if (localbo == null)
          {
            localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
            AppMethodBeat.o(248395);
            throw ((Throwable)localObject1);
          }
          ((Collection)localObject1).add((bm)localbo);
        }
        localb.setIncrementList(i((List)localObject1, this.uKS.tvp));
      }
    }
    
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(248394);
      p.h(paramq, "scene");
      if ((paramq instanceof cn))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        FinderMegaVideoProfileLoader.b localb;
        for (boolean bool = ((cn)paramq).tuG;; bool = true)
        {
          localb = new FinderMegaVideoProfileLoader.b(paramInt1, paramInt2, paramString);
          localb.setPullType(((cn)paramq).pullType);
          localObject1 = ((cn)paramq).tvo;
          paramString = (String)localObject1;
          if (localObject1 == null) {
            paramString = (List)new LinkedList();
          }
          Object localObject2 = (Iterable)paramString;
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(new bm(((FinderItem)((Iterator)localObject2).next()).getFeedObject()));
          }
        }
        localb.setIncrementList(i((List)localObject1, this.uKS.tvp));
        localb.setLastBuffer(((cn)paramq).getLastBuffer());
        localb.setHasMore(bool);
        paramq = c.vGN;
        paramq = (Iterable)paramString;
        paramString = (Collection)new ArrayList(j.a(paramq, 10));
        paramq = paramq.iterator();
        while (paramq.hasNext()) {
          paramString.add(((FinderItem)paramq.next()).getFeedObject());
        }
        c.a.b((List)paramString, this.uKS.getContextObj());
        paramq = getTAG();
        Object localObject1 = new StringBuilder("incrementList size: ");
        paramString = localb.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i(paramq, paramString);
          paramString = (IResponse)localb;
          AppMethodBeat.o(248394);
          return paramString;
        }
      }
      AppMethodBeat.o(248394);
      return null;
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(248393);
      Object localObject = this.uKS;
      int i = ((FinderMegaVideoProfileLoader)localObject).getDataList().size() - 1;
      bo localbo;
      if (i >= 0)
      {
        localbo = (bo)((FinderMegaVideoProfileLoader)localObject).getDataList().get(i);
        if ((!(localbo instanceof bm)) || (((bm)localbo).getFeedObject().id == 0L)) {}
      }
      for (long l = ((bm)localbo).getFeedObject().id;; l = 0L)
      {
        localObject = (com.tencent.mm.ak.q)new cn(this.uKS.tvp, l, this.uKS.getLastBuffer(), 2, this.uKS.getContextObj(), 1, 0L, 64);
        AppMethodBeat.o(248393);
        return localObject;
        i -= 1;
        break;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(248391);
      List localList = j.listOf(Integer.valueOf(3736));
      AppMethodBeat.o(248391);
      return localList;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileDataFetcher$callInit$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<bo, Boolean>
    {
      a(FinderMegaVideoProfileLoader.a parama, FinderMegaVideoProfileLoader.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class b<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        int j = 0;
        AppMethodBeat.i(248389);
        paramT2 = ((bm)paramT2).tuP;
        if (paramT2 != null) {}
        for (int i = paramT2.iXu;; i = 0)
        {
          paramT2 = (Comparable)Integer.valueOf(i);
          paramT1 = ((bm)paramT1).tuP;
          i = j;
          if (paramT1 != null) {
            i = paramT1.iXu;
          }
          i = kotlin.b.a.a(paramT2, (Comparable)Integer.valueOf(i));
          AppMethodBeat.o(248389);
          return i;
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.b<FinderItem, Boolean>
    {
      c(List paramList)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bo>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(248398);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Rms;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfT());
      d.h((kotlin.g.a.a)new a(this, new n(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(248398);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderMegaVideoProfileLoader.c paramc, n paramn, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader
 * JD-Core Version:    0.7.0.1
 */