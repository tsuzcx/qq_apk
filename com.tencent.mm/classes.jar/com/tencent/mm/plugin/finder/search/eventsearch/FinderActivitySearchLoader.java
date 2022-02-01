package com.tencent.mm.plugin.finder.search.eventsearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.feed.model.internal.o;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchLoader;", "Lcom/tencent/mm/plugin/finder/search/ui/IFinderSearchLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "continueFlag", "", "getContinueFlag", "()I", "setContinueFlag", "(I)V", "fetchRefreshCallback", "Lkotlin/Function1;", "", "getFetchRefreshCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchRefreshCallback", "(Lkotlin/jvm/functions/Function1;)V", "query", "", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "reqId", "getReqId", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getSearchDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "hasMore", "", "startSearch", "startSearchNextPage", "ActivitySearchResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderActivitySearchLoader
  extends BaseFeedLoader<cc>
  implements com.tencent.mm.plugin.finder.search.ui.a
{
  public kotlin.g.a.b<? super Integer, ah> BgZ;
  int continueFlag;
  final String hVo;
  public String query;
  
  public FinderActivitySearchLoader()
  {
    super(null, 1, null);
    AppMethodBeat.i(342655);
    this.query = "";
    this.hVo = String.valueOf(cn.bDw());
    AppMethodBeat.o(342655);
  }
  
  public final boolean aWl()
  {
    return this.continueFlag == 1;
  }
  
  public final void awg(String paramString)
  {
    AppMethodBeat.i(342672);
    s.u(paramString, "query");
    this.query = paramString;
    if (getLastBuffer() != null) {
      setLastBuffer(null);
    }
    if (!getDataList().isEmpty())
    {
      paramString = getDataList();
      if (paramString != null) {
        paramString.clear();
      }
    }
    requestRefresh();
    AppMethodBeat.o(342672);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(342695);
    i locali = (i)new b(this);
    AppMethodBeat.o(342695);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(342662);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(342662);
    return locald;
  }
  
  public final void ePm()
  {
    AppMethodBeat.i(342681);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this, false, 1, null);
    AppMethodBeat.o(342681);
  }
  
  public final ArrayList<cc> ePn()
  {
    AppMethodBeat.i(370405);
    ArrayList localArrayList = (ArrayList)getDataList();
    AppMethodBeat.o(370405);
    return localArrayList;
  }
  
  public final void onFetchDone(IResponse paramIResponse)
  {
    AppMethodBeat.i(342701);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aYj());
    super.onFetchDone(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(342701);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchLoader$ActivitySearchResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends IResponse<cc>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchLoader$createDataFetch$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchCgi;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "requestCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "resp", "genLoadMoreCgi", "genRefreshCgi", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.b
  {
    b(FinderActivitySearchLoader paramFinderActivitySearchLoader) {}
    
    public final IResponse<cc> a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.b<? extends esc> paramb, esc paramesc)
    {
      AppMethodBeat.i(342667);
      FinderActivitySearchLoader.a locala = new FinderActivitySearchLoader.a(paramInt1, paramInt2, paramString);
      locala.setLastBuffer(this.FyG.getLastBuffer());
      boolean bool;
      if (((paramesc instanceof buq)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        ArrayList localArrayList = new ArrayList();
        paramString = ((buq)paramesc).aabt;
        if (paramString != null)
        {
          paramString = ((Iterable)paramString).iterator();
          while (paramString.hasNext())
          {
            awt localawt = (awt)paramString.next();
            Log.i("karlDebug", s.X("eventList Message: ", Integer.valueOf(localawt.EOg)));
            s.s(localawt, "it");
            localArrayList.add(new m(localawt));
          }
        }
        paramString = locala.getIncrementList();
        if (paramString != null) {
          break label283;
        }
        paramString = null;
        Log.i("karlDebug", s.X("eventList size: ", paramString));
        locala.setIncrementList((List)localArrayList);
        locala.setLastBuffer(((buq)paramesc).aacl);
        if (((buq)paramesc).BeA != 1) {
          break label296;
        }
        bool = true;
        label201:
        locala.setHasMore(bool);
        this.FyG.continueFlag = ((buq)paramesc).BeA;
        Log.i("karlDebug", s.X("response continueFlag: ", Integer.valueOf(((buq)paramesc).BeA)));
        if (!(paramb instanceof ao)) {
          break label302;
        }
        paramString = (ao)paramb;
        label258:
        if (paramString != null) {
          break label307;
        }
      }
      label283:
      label296:
      label302:
      label307:
      for (paramInt1 = 0;; paramInt1 = paramString.pullType)
      {
        locala.setPullType(paramInt1);
        paramString = (IResponse)locala;
        AppMethodBeat.o(342667);
        return paramString;
        paramString = Integer.valueOf(paramString.size());
        break;
        bool = false;
        break label201;
        paramString = null;
        break label258;
      }
    }
    
    public final com.tencent.mm.am.b<? extends esc> edO()
    {
      AppMethodBeat.i(342641);
      Object localObject = new ao("", "", this.FyG.query, null, this.FyG.hVo);
      ((ao)localObject).pullType = 4;
      localObject = (com.tencent.mm.am.b)localObject;
      AppMethodBeat.o(342641);
      return localObject;
    }
    
    public final com.tencent.mm.am.b<? extends esc> edP()
    {
      AppMethodBeat.i(342651);
      Object localObject = new ao("", "", this.FyG.query, this.FyG.getLastBuffer(), this.FyG.hVo);
      ((ao)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.b)localObject;
      AppMethodBeat.o(342651);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getListUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "cmd", "", "insList", "", "isNeedClear", "", "request", "", "mergeInit", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeInsert", "mergeInsertSpecifiedLocation", "objectId", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeInsertData;", "mergeLoadMore", "mergeRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.d<cc>
  {
    c(FinderActivitySearchLoader paramFinderActivitySearchLoader) {}
    
    public final androidx.recyclerview.widget.q getListUpdateCallback()
    {
      AppMethodBeat.i(342685);
      androidx.recyclerview.widget.q localq = (androidx.recyclerview.widget.q)new a();
      AppMethodBeat.o(342685);
      return localq;
    }
    
    public final o mergeDataAndNotify(int paramInt, List<? extends cc> paramList, boolean paramBoolean, Object paramObject)
    {
      AppMethodBeat.i(342680);
      paramList = new o(new LinkedList());
      AppMethodBeat.o(342680);
      return paramList;
    }
    
    public final void mergeInit(IResponse<cc> paramIResponse, kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(342654);
      s.u(paramIResponse, "response");
      AppMethodBeat.o(342654);
    }
    
    public final void mergeInsert(IResponse<cc> paramIResponse, kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(342670);
      s.u(paramIResponse, "response");
      AppMethodBeat.o(342670);
    }
    
    public final void mergeInsertSpecifiedLocation(IResponse<cc> paramIResponse, n paramn, kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(342691);
      s.u(paramIResponse, "response");
      s.u(paramn, "objectId");
      AppMethodBeat.o(342691);
    }
    
    public final void mergeLoadMore(IResponse<cc> paramIResponse, kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(342663);
      s.u(paramIResponse, "response");
      int i = this.FyG.getDataList().size();
      if ((paramIResponse instanceof FinderActivitySearchLoader.a))
      {
        paramIResponse = (FinderActivitySearchLoader.a)paramIResponse;
        if (paramIResponse != null)
        {
          paramIResponse = paramIResponse.getIncrementList();
          if (paramIResponse != null)
          {
            paramb = this.FyG.getDataList();
            if (paramb != null) {
              break label100;
            }
          }
        }
      }
      label100:
      for (paramIResponse = null;; paramIResponse = Boolean.valueOf(paramb.addAll((Collection)paramIResponse)))
      {
        paramIResponse.booleanValue();
        paramIResponse = this.FyG.BgZ;
        if (paramIResponse != null) {
          paramIResponse.invoke(Integer.valueOf(i));
        }
        AppMethodBeat.o(342663);
        return;
        paramIResponse = null;
        break;
      }
    }
    
    public final void mergeRefresh(IResponse<cc> paramIResponse, kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(342644);
      s.u(paramIResponse, "response");
      final int i = this.FyG.getDataList().size();
      if ((paramIResponse instanceof FinderActivitySearchLoader.a))
      {
        paramIResponse = (FinderActivitySearchLoader.a)paramIResponse;
        if (paramIResponse != null)
        {
          paramIResponse = paramIResponse.getIncrementList();
          if (paramIResponse != null)
          {
            paramb = this.FyG.getDataList();
            if (paramb != null) {
              break label118;
            }
          }
        }
      }
      label118:
      for (paramIResponse = null;; paramIResponse = Boolean.valueOf(paramb.addAll((Collection)paramIResponse)))
      {
        paramIResponse.booleanValue();
        Log.i("karlDebug", s.X("dataList size when merge ", Integer.valueOf(this.FyG.getDataList().size())));
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this.FyG, i));
        AppMethodBeat.o(342644);
        return;
        paramIResponse = null;
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchLoader$createDataMerger$1$getListUpdateCallback$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements androidx.recyclerview.widget.q
    {
      public final void aR(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(342634);
        Throwable localThrowable = (Throwable)new kotlin.q("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(342634);
        throw localThrowable;
      }
      
      public final void aS(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(342637);
        Throwable localThrowable = (Throwable)new kotlin.q("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(342637);
        throw localThrowable;
      }
      
      public final void aW(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(342645);
        Throwable localThrowable = (Throwable)new kotlin.q("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(342645);
        throw localThrowable;
      }
      
      public final void c(int paramInt1, int paramInt2, Object paramObject)
      {
        AppMethodBeat.i(342656);
        paramObject = (Throwable)new kotlin.q("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(342656);
        throw paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(FinderActivitySearchLoader paramFinderActivitySearchLoader, int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.eventsearch.FinderActivitySearchLoader
 * JD-Core Version:    0.7.0.1
 */