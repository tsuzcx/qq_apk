package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.dt;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "initRemoveItemCount", "", "getInitRemoveItemCount", "()I", "setInitRemoveItemCount", "(I)V", "needMergeLocalData", "", "getNeedMergeLocalData", "()Z", "setNeedMergeLocalData", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "", "isObservePostEvent", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "MegaVideoProfileDataFetcher", "MegaVideoProfileResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMegaVideoProfileLoader
  extends BaseMegaVideoLoader
{
  public final String ACm;
  public boolean EzN;
  public int EzO;
  
  public FinderMegaVideoProfileLoader(String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(342180);
    this.ACm = paramString;
    AppMethodBeat.o(342180);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(342189);
    i locali = (i)new a();
    AppMethodBeat.o(342189);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(342192);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(342192);
    return locald;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(342198);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(342198);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    AppMethodBeat.o(342198);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "getCmdIds", "", "mergeLocalData", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "nowList", "username", "start", "end", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends c
  {
    public a()
    {
      AppMethodBeat.i(342169);
      AppMethodBeat.o(342169);
    }
    
    private final List<ca> p(List<ca> paramList, String paramString)
    {
      AppMethodBeat.i(342181);
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; (i != 0) || (!kotlin.g.b.s.p(paramString, z.bAW())) || (!this.EzP.EzN); i = 0)
      {
        AppMethodBeat.o(342181);
        return paramList;
      }
      Log.i(getTAG(), "mergeLocalData start 0 end 2147483647");
      LinkedList localLinkedList = new LinkedList();
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      paramString = d.a.an(paramString, 0, 2147483647);
      localLinkedList.addAll((Collection)paramList);
      localObject = (List)localLinkedList;
      if (((List)localObject).size() > 1) {
        kotlin.a.p.a((List)localObject, (Comparator)new b());
      }
      com.tencent.mm.ae.d.a(paramString, (kotlin.g.a.b)new c(paramList));
      localObject = (Iterable)paramString;
      paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
        ca localca = new ca(localFinderItem.getFeedObject());
        localca.EDG = localFinderItem;
        paramList.add(localca);
      }
      localLinkedList.addAll(0, (Collection)paramList);
      Log.i(getTAG(), kotlin.g.b.s.X("mergeLocalData: databaseList size:", Integer.valueOf(paramString.size())));
      paramList = ((Iterable)paramString).iterator();
      while (paramList.hasNext())
      {
        paramString = (FinderItem)paramList.next();
        Log.i(getTAG(), "mergeLocalData: databaseList item, localId:" + paramString.getLocalId() + ", id:" + paramString.getId());
      }
      paramList = (List)localLinkedList;
      AppMethodBeat.o(342181);
      return paramList;
    }
    
    public final IResponse<cc> callInit()
    {
      Object localObject1 = null;
      AppMethodBeat.i(342216);
      Log.i(getTAG(), "fetchInit");
      FinderMegaVideoProfileLoader.b localb = new FinderMegaVideoProfileLoader.b(0, 0, "");
      localb.setPullType(1000);
      Object localObject2 = this.EzP.getCache();
      if (localObject2 == null) {}
      while (localObject1 == null)
      {
        localObject1 = this.EzP;
        localObject2 = k.FNg.bE(13, ((FinderMegaVideoProfileLoader)localObject1).ACm);
        Log.i(getTAG(), kotlin.g.b.s.X("fetchInit: use first page data list, size: ", Integer.valueOf(((List)localObject2).size())));
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((Collection)localObject2).add((ca)((Iterator)localObject3).next());
            continue;
            localObject2 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject2).pUj;
            if (localObject2 == null) {
              break;
            }
            localObject1 = this.EzP;
            Log.i(getTAG(), kotlin.g.b.s.X("fetchInit: use old data list, size: ", Integer.valueOf(((ArrayList)localObject2).size())));
            if (!((FinderMegaVideoProfileLoader)localObject1).EzN) {
              com.tencent.mm.ae.d.a((ArrayList)localObject2, (kotlin.g.a.b)new a((FinderMegaVideoProfileLoader)localObject1));
            }
            localb.setIncrementList((List)localObject2);
            localObject1 = ((FinderMegaVideoProfileLoader)localObject1).getCache();
            if (localObject1 == null) {}
            for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).lastBuffer)
            {
              localb.setLastBuffer((com.tencent.mm.bx.b)localObject1);
              localObject1 = ah.aiuX;
              break;
            }
          }
        }
        localb.setIncrementList(p((List)localObject2, ((FinderMegaVideoProfileLoader)localObject1).ACm));
      }
      localObject1 = (IResponse)localb;
      AppMethodBeat.o(342216);
      return localObject1;
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(342207);
      kotlin.g.b.s.u(paramp, "scene");
      if ((paramp instanceof dt))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        FinderMegaVideoProfileLoader.b localb;
        Object localObject1;
        for (boolean bool = ((dt)paramp).ABD;; bool = true)
        {
          localb = new FinderMegaVideoProfileLoader.b(paramInt1, paramInt2, paramString);
          localb.setPullType(((dt)paramp).pullType);
          localObject1 = ((dt)paramp).ACl;
          paramString = (String)localObject1;
          if (localObject1 == null) {
            paramString = (List)new LinkedList();
          }
          Object localObject2 = (Iterable)paramString;
          localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(new ca(((FinderItem)((Iterator)localObject2).next()).getFeedObject()));
          }
        }
        localb.setIncrementList(p((List)localObject1, this.EzP.ACm));
        localb.setLastBuffer(((dt)paramp).getLastBuffer());
        localb.setHasMore(bool);
        paramp = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        paramp = (Iterable)paramString;
        paramString = (Collection)new ArrayList(kotlin.a.p.a(paramp, 10));
        paramp = paramp.iterator();
        while (paramp.hasNext()) {
          paramString.add(((FinderItem)paramp.next()).getFeedObject());
        }
        d.a.d((List)paramString, this.EzP.getContextObj());
        paramp = getTAG();
        paramString = localb.getIncrementList();
        if (paramString == null) {}
        for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
        {
          Log.i(paramp, kotlin.g.b.s.X("incrementList size: ", paramString));
          paramString = (IResponse)localb;
          AppMethodBeat.o(342207);
          return paramString;
        }
      }
      AppMethodBeat.o(342207);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(342194);
      Object localObject = this.EzP;
      int i = ((FinderMegaVideoProfileLoader)localObject).getDataList().size() - 1;
      if (i >= 0) {}
      for (;;)
      {
        int j = i - 1;
        cc localcc = (cc)((FinderMegaVideoProfileLoader)localObject).getDataList().get(i);
        if (((localcc instanceof ca)) && (((ca)localcc).getFeedObject().id != 0L)) {}
        for (long l = ((ca)localcc).getFeedObject().id;; l = 0L)
        {
          localObject = (com.tencent.mm.am.p)new dt(this.EzP.ACm, l, this.EzP.getLastBuffer(), 2, this.EzP.getContextObj(), 1, 0L, false, null, 0L, null, null, null, 8128);
          AppMethodBeat.o(342194);
          return localObject;
          if (j >= 0) {
            break;
          }
        }
        i = j;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(342188);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3736));
      AppMethodBeat.o(342188);
      return localList;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<cc, Boolean>
    {
      a(FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
    public static final class b<T>
      implements Comparator
    {
      public final int compare(T paramT1, T paramT2)
      {
        int j = 0;
        AppMethodBeat.i(342184);
        paramT2 = ((ca)paramT2).ABK;
        if (paramT2 == null)
        {
          i = 0;
          paramT2 = (Comparable)Integer.valueOf(i);
          paramT1 = ((ca)paramT1).ABK;
          if (paramT1 != null) {
            break label72;
          }
        }
        label72:
        for (int i = j;; i = paramT1.createTime)
        {
          i = kotlin.b.a.b(paramT2, (Comparable)Integer.valueOf(i));
          AppMethodBeat.o(342184);
          return i;
          i = paramT2.createTime;
          break;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.b<FinderItem, Boolean>
    {
      c(List<ca> paramList)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends BaseFeedLoader<cc>.a
  {
    c(FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(342174);
      AppMethodBeat.o(342174);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(342178);
      kotlin.g.b.s.u(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMG());
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, new r(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.d)localObject, this.EzP, paramb, paramIResponse));
      AppMethodBeat.o(342178);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderMegaVideoProfileLoader.c paramc, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
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