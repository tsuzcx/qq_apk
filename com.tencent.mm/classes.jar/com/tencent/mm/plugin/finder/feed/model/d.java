package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "onFetchRefreshDone", "requestLoadMore", "requestRefresh", "Companion", "FinderFavListData", "FinderFavListInit", "FinderFavListRequest", "FinderFavListResponse", "plugin-finder_release"})
public final class d
  extends BaseFinderFeedLoader
{
  private static final String TAG = "Finder.FinderFavFeedLoader";
  private static final ConcurrentHashMap<Long, d.a.a> rmG;
  public static final a rmH;
  public int fAw;
  public boolean hasMore;
  public com.tencent.mm.bw.b lastBuffer;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> rmE;
  private final String rmF;
  
  static
  {
    AppMethodBeat.i(202071);
    rmH = new a((byte)0);
    TAG = "Finder.FinderFavFeedLoader";
    rmG = new ConcurrentHashMap();
    AppMethodBeat.o(202071);
  }
  
  public d(String paramString, anm paramanm)
  {
    super(null, paramanm, 1, null);
    AppMethodBeat.i(202070);
    this.rmF = paramString;
    AppMethodBeat.o(202070);
  }
  
  public final e<Object, Object, h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(202065);
    paramanm = (e)new b(paramanm);
    AppMethodBeat.o(202065);
    return paramanm;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(202068);
    d.g.b.k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof e)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof e))) {
      this.fAw = ((e)paramIResponse).fAw;
    }
    this.hasMore = paramIResponse.getHasMore();
    d.g.a.b localb = this.rmE;
    if (localb != null)
    {
      localb.ay(paramIResponse);
      AppMethodBeat.o(202068);
      return;
    }
    AppMethodBeat.o(202068);
  }
  
  public final void onFetchRefreshDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    int i = 0;
    AppMethodBeat.i(202069);
    d.g.b.k.h(paramIResponse, "response");
    RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    Object localObject;
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      localObject = ai.getContext();
      d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
      localc.Jya = ((CharSequence)((Context)localObject).getResources().getString(2131759373));
      localc.JxZ = 1;
      if (paramIResponse.getPullType() == 0) {
        break label266;
      }
      bool = true;
      label85:
      localc.isT = bool;
      localc.Jyb = paramIResponse.getHasMore();
      if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Jyc > 0)) {
        localc.Jya = null;
      }
      localc.hvK = Integer.valueOf(((e)paramIResponse).fAw);
      ac.i(getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      localObject = paramIResponse.getIncrementList();
      if (localObject != null) {
        i = ((List)localObject).size();
      }
      if (!paramIResponse.getHasMore()) {
        break label271;
      }
      i = 2;
    }
    for (;;)
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.k(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8);
      dispatcher().a(paramIResponse, localc);
      AppMethodBeat.o(202069);
      return;
      localObject = ai.getContext();
      d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
      localc.Jya = ((CharSequence)((Context)localObject).getResources().getString(2131759383));
      localc.JxZ = -1;
      break;
      label266:
      bool = false;
      break label85;
      label271:
      if ((getDataList().size() != 0) && (i != 0) && (getDataList().size() > i)) {
        i = 4;
      } else {
        i = 6;
      }
    }
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(202067);
    d locald = new d(this.rmF, this.lastBuffer, 2);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((i)locald);
    AppMethodBeat.o(202067);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202066);
    d locald = new d(this.rmF, this.lastBuffer, 0);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((i)locald);
    AppMethodBeat.o(202066);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$Companion;", "", "()V", "TAG", "", "favDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$Companion$FavFeedCache;", "getFavDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "FavFeedCache", "plugin-finder_release"})
  public static final class a
  {
    public static d.a.a ul(long paramLong)
    {
      AppMethodBeat.i(202057);
      ac.i(d.access$getTAG$cp(), "getCache " + paramLong + ", exist:" + d.cvA().containsKey(Long.valueOf(paramLong)));
      d.a.a locala2 = (d.a.a)d.cvA().get(Long.valueOf(paramLong));
      d.a.a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new d.a.a((List)new ArrayList(), null);
      }
      AppMethodBeat.o(202057);
      return locala1;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "favCallBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getFavCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setFavCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    extends e<d.c, d.d, BaseFinderFeed>
    implements com.tencent.mm.ak.g
  {
    private final String TAG = "Finder.FinderFavListData";
    private com.tencent.mm.plugin.finder.feed.model.internal.d<BaseFinderFeed> rmI;
    
    public b(anm paramanm)
    {
      super();
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202059);
      com.tencent.mm.kernel.g.agi().a(3966, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202059);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202060);
      com.tencent.mm.kernel.g.agi().b(3966, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202060);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      Object localObject1 = null;
      AppMethodBeat.i(202061);
      if ((paramn instanceof ax))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject2 = ((ax)paramn).rr.aBD();
          if (localObject2 == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(202061);
            throw paramString;
          }
          if (((akm)localObject2).continueFlag != 0) {}
        }
        for (boolean bool1 = false;; bool1 = true)
        {
          localObject2 = ((ax)paramn).rr.aBD();
          if (localObject2 != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(202061);
          throw paramString;
        }
        Object localObject2 = new d.e(paramInt1, paramInt2, paramString, ((akm)localObject2).fAw);
        Object localObject3 = (Iterable)((ax)paramn).csC();
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        Object localObject4;
        Object localObject5;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderObject)((Iterator)localObject3).next();
          localObject5 = FinderItem.rDA;
          localObject4 = FinderItem.a.a((FinderObject)localObject4, 256);
          localObject5 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
          paramString.add(com.tencent.mm.plugin.finder.storage.logic.b.a.i((FinderItem)localObject4));
        }
        ((d.e)localObject2).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        paramString = ((ax)paramn).csC();
        if (((ax)paramn).pullType != 2) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          com.tencent.mm.plugin.finder.storage.logic.b.a.a(paramString, 256, bool2, null, true, this.contextObj, 40);
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("incrementList size: ");
          localObject5 = ((d.e)localObject2).getIncrementList();
          paramString = localObject1;
          if (localObject5 != null) {
            paramString = Integer.valueOf(((List)localObject5).size());
          }
          ac.i((String)localObject3, paramString);
          ((d.e)localObject2).setPullType(((ax)paramn).pullType);
          paramString = ((ax)paramn).rr.aBD();
          if (paramString != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(202061);
          throw paramString;
        }
        ((d.e)localObject2).setLastBuffer(((akm)paramString).lastBuffer);
        ((d.e)localObject2).setHasMore(bool1);
        paramString = this.rmI;
        if (paramString != null)
        {
          paramString.onFetchDone((IResponse)localObject2);
          AppMethodBeat.o(202061);
          return;
        }
      }
      AppMethodBeat.o(202061);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "cacheId", "", "isTimeLine", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JZLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "()Z", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    final boolean hZi;
    final long rhr;
    
    public c(long paramLong, boolean paramBoolean, f paramf)
    {
      super();
      AppMethodBeat.i(202063);
      this.rhr = paramLong;
      this.hZi = paramBoolean;
      AppMethodBeat.o(202063);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "finderUserName", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUserName", "()Ljava/lang/String;", "getLastBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
  public static final class d
    implements i
  {
    final int pullType;
    final String rmF;
    final com.tencent.mm.bw.b rmJ;
    
    public d(String paramString, com.tencent.mm.bw.b paramb, int paramInt)
    {
      AppMethodBeat.i(202064);
      this.rmF = paramString;
      this.rmJ = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(202064);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<BaseFinderFeed>
  {
    int fAw;
    
    public e(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      super(paramInt2, paramString);
      this.fAw = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.d
 * JD-Core Version:    0.7.0.1
 */