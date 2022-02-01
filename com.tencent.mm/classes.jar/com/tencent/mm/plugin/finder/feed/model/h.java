package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "onFetchRefreshDone", "requestLoadMore", "requestRefresh", "Companion", "LikedTimeLineData", "LikedTimeLineInit", "LikedTimeLineRequest", "LikedTimelineResponse", "plugin-finder_release"})
public final class h
  extends BaseFinderFeedLoader
{
  private static final String TAG = "Finder.FinderFriendLikeLoader";
  private static final ConcurrentHashMap<Long, h.a.a> rmP;
  public static final a rmQ;
  private boolean hasMore;
  public com.tencent.mm.bw.b lastBuffer;
  private final String qYd;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> rmE;
  
  static
  {
    AppMethodBeat.i(202139);
    rmQ = new a((byte)0);
    TAG = "Finder.FinderFriendLikeLoader";
    rmP = new ConcurrentHashMap();
    AppMethodBeat.o(202139);
  }
  
  public h(String paramString, anm paramanm)
  {
    super(null, paramanm, 1, null);
    AppMethodBeat.i(202138);
    this.qYd = paramString;
    AppMethodBeat.o(202138);
  }
  
  public final e<Object, Object, com.tencent.mm.plugin.finder.feed.model.internal.h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(202133);
    paramanm = (e)new b(paramanm);
    AppMethodBeat.o(202133);
    return paramanm;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(202136);
    d.g.b.k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof e)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!this.hasMore)
    {
      d.g.a.b localb = this.rmE;
      if (localb != null)
      {
        localb.ay(paramIResponse);
        AppMethodBeat.o(202136);
        return;
      }
    }
    AppMethodBeat.o(202136);
  }
  
  public final void onFetchRefreshDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(202137);
    d.g.b.k.h(paramIResponse, "response");
    RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    Context localContext;
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      localContext = ai.getContext();
      d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
      localc.Jya = ((CharSequence)localContext.getResources().getString(2131759373));
      localc.JxZ = 1;
      if (paramIResponse.getPullType() == 0) {
        break label230;
      }
      bool = true;
      label83:
      localc.isT = bool;
      localc.Jyb = paramIResponse.getHasMore();
      if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Jyc > 0)) {
        localc.Jya = null;
      }
      ac.i(getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label235;
      }
    }
    label230:
    label235:
    for (int i = 4;; i = 6)
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.k(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8);
      dispatcher().a(paramIResponse, localc);
      AppMethodBeat.o(202137);
      return;
      localContext = ai.getContext();
      d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
      localc.Jya = ((CharSequence)localContext.getResources().getString(2131759383));
      localc.JxZ = -1;
      break;
      bool = false;
      break label83;
    }
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(202135);
    d locald = new d(this.qYd, this.lastBuffer, 2);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((i)locald);
    AppMethodBeat.o(202135);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202134);
    d locald = new d(this.qYd, this.lastBuffer, 0);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((i)locald);
    AppMethodBeat.o(202134);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$Companion;", "", "()V", "TAG", "", "friendLikeDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$Companion$FriendLikeFeedCache;", "getFriendLikeDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "FriendLikeFeedCache", "plugin-finder_release"})
  public static final class a
  {
    public static h.a.a um(long paramLong)
    {
      AppMethodBeat.i(202124);
      ac.i(h.access$getTAG$cp(), "getCache " + paramLong + ", exist:" + h.cvC().containsKey(Long.valueOf(paramLong)));
      h.a.a locala2 = (h.a.a)h.cvC().get(Long.valueOf(paramLong));
      h.a.a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new h.a.a((List)new ArrayList(), null);
      }
      AppMethodBeat.o(202124);
      return locala1;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimeLineData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimeLineInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimeLineRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    extends e<h.c, h.d, BaseFinderFeed>
    implements com.tencent.mm.ak.g
  {
    private final Map<af, d<BaseFinderFeed>> map;
    
    public b(anm paramanm)
    {
      super();
      AppMethodBeat.i(202130);
      this.map = ((Map)new LinkedHashMap());
      AppMethodBeat.o(202130);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202126);
      com.tencent.mm.kernel.g.agi().a(3965, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202126);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202127);
      com.tencent.mm.kernel.g.agi().b(3965, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202127);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202128);
      d locald = (d)this.map.get(paramn);
      if (locald != null)
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetLikedList");
          AppMethodBeat.o(202128);
          throw paramString;
        }
        af localaf = (af)paramn;
        this.map.remove(paramn);
        if ((paramInt1 == 0) && (paramInt2 == 0) && (localaf.csz() != 1)) {}
        for (boolean bool = false;; bool = true)
        {
          paramn = new h.e(paramInt1, paramInt2, paramString);
          paramString = localaf.qYc;
          if (paramString == null) {
            break label246;
          }
          Object localObject = (Iterable)paramString;
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
            com.tencent.mm.plugin.finder.storage.logic.b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
            paramString.add(com.tencent.mm.plugin.finder.storage.logic.b.a.i(localFinderItem));
          }
        }
        label246:
        for (paramString = (List)paramString;; paramString = null)
        {
          paramn.setIncrementList(paramString);
          paramn.setPullType(localaf.pullType);
          paramn.setLastBuffer(localaf.csy());
          paramn.setHasMore(bool);
          locald.onFetchDone((IResponse)paramn);
          AppMethodBeat.o(202128);
          return;
        }
      }
      AppMethodBeat.o(202128);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimeLineInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "cacheId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    final long rhr;
    
    public c(long paramLong, f paramf)
    {
      super();
      AppMethodBeat.i(202131);
      this.rhr = paramLong;
      AppMethodBeat.o(202131);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimeLineRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "targetUsername", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "getTargetUsername", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class d
    implements i
  {
    final com.tencent.mm.bw.b lastBuffer;
    final int pullType;
    final String qYd;
    
    public d(String paramString, com.tencent.mm.bw.b paramb, int paramInt)
    {
      AppMethodBeat.i(202132);
      this.qYd = paramString;
      this.lastBuffer = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(202132);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<BaseFinderFeed>
  {
    public e(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.h
 * JD-Core Version:    0.7.0.1
 */