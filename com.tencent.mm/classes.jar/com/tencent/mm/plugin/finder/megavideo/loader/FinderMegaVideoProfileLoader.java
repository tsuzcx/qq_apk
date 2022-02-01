package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cvy;
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
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "initRemoveItemCount", "", "getInitRemoveItemCount", "()I", "setInitRemoveItemCount", "(I)V", "needMergeLocalData", "", "getNeedMergeLocalData", "()Z", "setNeedMergeLocalData", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "", "isObservePostEvent", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "MegaVideoProfileDataFetcher", "MegaVideoProfileResponse", "plugin-finder_release"})
public final class FinderMegaVideoProfileLoader
  extends BaseMegaVideoLoader
{
  public final String xcW;
  public boolean zwH;
  public int zwI;
  
  public FinderMegaVideoProfileLoader(String paramString, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(230740);
    this.xcW = paramString;
    AppMethodBeat.o(230740);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(230737);
    i locali = (i)new a();
    AppMethodBeat.o(230737);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(230738);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(230738);
    return locald;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(230739);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(230739);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(230739);
      return;
    }
    AppMethodBeat.o(230739);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "getCmdIds", "", "mergeLocalData", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "nowList", "username", "start", "end", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    private final List<bs> k(List<bs> paramList, String paramString)
    {
      AppMethodBeat.i(281533);
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; (i != 0) || ((p.h(paramString, z.bdh()) ^ true)) || (!this.zwJ.zwH); i = 0)
      {
        AppMethodBeat.o(281533);
        return paramList;
      }
      Log.i(getTAG(), "mergeLocalData start 0 end 2147483647");
      LinkedList localLinkedList = new LinkedList();
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
      paramString = c.a.ai(paramString, 0, 2147483647);
      localLinkedList.addAll((Collection)paramList);
      localObject = (List)localLinkedList;
      if (((List)localObject).size() > 1) {
        j.a((List)localObject, (Comparator)new b());
      }
      com.tencent.mm.ae.d.a(paramString, (kotlin.g.a.b)new c(paramList));
      localObject = (Iterable)paramString;
      paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
        bs localbs = new bs(localFinderItem.getFeedObject());
        localbs.zBs = localFinderItem;
        paramList.add(localbs);
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
      AppMethodBeat.o(281533);
      return paramList;
    }
    
    public final IResponse<bu> callInit()
    {
      AppMethodBeat.i(281532);
      Log.i(getTAG(), "fetchInit");
      final FinderMegaVideoProfileLoader.b localb = new FinderMegaVideoProfileLoader.b(0, 0, "");
      localb.setPullType(1000);
      Object localObject1 = this.zwJ.getCache();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.q)localObject1).mXB;
        if (localObject1 != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject1).size());
          if (!this.zwJ.zwH) {
            com.tencent.mm.ae.d.a((ArrayList)localObject1, (kotlin.g.a.b)new a(this, localb));
          }
          localb.setIncrementList((List)localObject1);
          localObject1 = this.zwJ.getCache();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.feed.model.q)localObject1).lastBuffer;
            localb.setLastBuffer((com.tencent.mm.cd.b)localObject1);
          }
        }
      }
      for (;;)
      {
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(281532);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = k.Anu.bc(13, this.zwJ.xcW);
        Log.i(getTAG(), "fetchInit: use first page data list, size: " + ((List)localObject1).size());
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bu localbu = (bu)((Iterator)localObject2).next();
          if (localbu == null)
          {
            localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
            AppMethodBeat.o(281532);
            throw ((Throwable)localObject1);
          }
          ((Collection)localObject1).add((bs)localbu);
        }
        localb.setIncrementList(k((List)localObject1, this.zwJ.xcW));
      }
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(281531);
      p.k(paramq, "scene");
      if ((paramq instanceof cr))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        FinderMegaVideoProfileLoader.b localb;
        for (boolean bool = ((cr)paramq).xcp;; bool = true)
        {
          localb = new FinderMegaVideoProfileLoader.b(paramInt1, paramInt2, paramString);
          localb.setPullType(((cr)paramq).pullType);
          localObject1 = ((cr)paramq).xcV;
          paramString = (String)localObject1;
          if (localObject1 == null) {
            paramString = (List)new LinkedList();
          }
          Object localObject2 = (Iterable)paramString;
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(new bs(((FinderItem)((Iterator)localObject2).next()).getFeedObject()));
          }
        }
        localb.setIncrementList(k((List)localObject1, this.zwJ.xcW));
        localb.setLastBuffer(((cr)paramq).getLastBuffer());
        localb.setHasMore(bool);
        paramq = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        paramq = (Iterable)paramString;
        paramString = (Collection)new ArrayList(j.a(paramq, 10));
        paramq = paramq.iterator();
        while (paramq.hasNext()) {
          paramString.add(((FinderItem)paramq.next()).getFeedObject());
        }
        c.a.b((List)paramString, this.zwJ.getContextObj());
        paramq = getTAG();
        Object localObject1 = new StringBuilder("incrementList size: ");
        paramString = localb.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i(paramq, paramString);
          paramString = (IResponse)localb;
          AppMethodBeat.o(281531);
          return paramString;
        }
      }
      AppMethodBeat.o(281531);
      return null;
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(281530);
      Object localObject = this.zwJ;
      int i = ((FinderMegaVideoProfileLoader)localObject).getDataList().size() - 1;
      bu localbu;
      if (i >= 0)
      {
        localbu = (bu)((FinderMegaVideoProfileLoader)localObject).getDataList().get(i);
        if ((!(localbu instanceof bs)) || (((bs)localbu).getFeedObject().id == 0L)) {}
      }
      for (long l = ((bs)localbu).getFeedObject().id;; l = 0L)
      {
        localObject = (com.tencent.mm.an.q)new cr(this.zwJ.xcW, l, this.zwJ.getLastBuffer(), 2, this.zwJ.getContextObj(), 1, 0L, 64);
        AppMethodBeat.o(281530);
        return localObject;
        i -= 1;
        break;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(281527);
      List localList = j.listOf(Integer.valueOf(3736));
      AppMethodBeat.o(281527);
      return localList;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileDataFetcher$callInit$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<bu, Boolean>
    {
      a(FinderMegaVideoProfileLoader.a parama, FinderMegaVideoProfileLoader.b paramb)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class b<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        int j = 0;
        AppMethodBeat.i(281603);
        paramT2 = ((bs)paramT2).xcy;
        if (paramT2 != null) {}
        for (int i = paramT2.createTime;; i = 0)
        {
          paramT2 = (Comparable)Integer.valueOf(i);
          paramT1 = ((bs)paramT1).xcy;
          i = j;
          if (paramT1 != null) {
            i = paramT1.createTime;
          }
          i = kotlin.b.a.a(paramT2, (Comparable)Integer.valueOf(i));
          AppMethodBeat.o(281603);
          return i;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "invoke"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bu>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bu>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(285107);
      p.k(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.YNO;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihs());
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(285107);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderMegaVideoProfileLoader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
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