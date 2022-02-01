package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.anm;
import d.a.j;
import d.g.b.k;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "feedId", "", "nonceId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getNonceId", "setNonceId", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "onFetchDone", "response", "requestLoadMore", "requestRefresh", "Companion", "FinderFoldedListData", "FinderFoldedListInit", "FinderFoldedListResponse", "FinderFoldedRequest", "plugin-finder_release"})
public final class g
  extends BaseFinderFeedLoader
{
  private static final ConcurrentHashMap<Long, g.a.a> rmN;
  public static final a rmO;
  private String TAG;
  private final long dig;
  private com.tencent.mm.bw.b lastBuffer;
  private String qXC;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> rmE;
  private final String rmF;
  
  static
  {
    AppMethodBeat.i(202119);
    rmO = new a((byte)0);
    rmN = new ConcurrentHashMap();
    AppMethodBeat.o(202119);
  }
  
  public g(String paramString1, long paramLong, String paramString2, anm paramanm)
  {
    super(null, paramanm, 1, null);
    AppMethodBeat.i(202118);
    this.rmF = paramString1;
    this.dig = paramLong;
    this.qXC = paramString2;
    this.TAG = "Finder.FinderFriendFoldedFeedLoader";
    AppMethodBeat.o(202118);
  }
  
  public final e<Object, Object, h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(202112);
    paramanm = (e)new b(paramanm);
    AppMethodBeat.o(202112);
    return paramanm;
  }
  
  public final int findMergeIndex(ArrayList<BaseFinderFeed> paramArrayList, List<? extends BaseFinderFeed> paramList, int paramInt, i parami)
  {
    AppMethodBeat.i(202113);
    k.h(paramArrayList, "srcList");
    k.h(paramList, "newList");
    paramInt = getDataList().size();
    AppMethodBeat.o(202113);
    return paramInt;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(202117);
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
        AppMethodBeat.o(202117);
        return;
      }
    }
    AppMethodBeat.o(202117);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(202116);
    e locale = new e(this.rmF, this.dig, this.qXC, this.lastBuffer, 2);
    com.tencent.mm.sdk.platformtools.ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locale)));
    fetchData((i)locale);
    AppMethodBeat.o(202116);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202115);
    e locale = new e(this.rmF, this.dig, this.qXC, this.lastBuffer, 0);
    com.tencent.mm.sdk.platformtools.ac.i(getTAG(), "requestRefresh ".concat(String.valueOf(locale)));
    fetchData((i)locale);
    AppMethodBeat.o(202115);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(202114);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(202114);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$Companion;", "", "()V", "foldedDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$Companion$FoldedFeedCache;", "getFoldedDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "FoldedFeedCache", "plugin-finder_release"})
  public static final class a
  {
    public static void b(long paramLong, List<? extends BaseFinderFeed> paramList)
    {
      Object localObject2 = null;
      AppMethodBeat.i(202103);
      k.h(paramList, "dataList");
      StringBuilder localStringBuilder = new StringBuilder("putCache ").append(paramLong).append(", list size:").append(paramList.size()).append(' ');
      Object localObject1 = (BaseFinderFeed)j.C(paramList, 0);
      if (localObject1 != null) {}
      for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append("} ");
        Object localObject3 = (BaseFinderFeed)j.C(paramList, 0);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((BaseFinderFeed)localObject3).feedObject;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((FinderItem)localObject3).getDebugDescription();
          }
        }
        com.tencent.mm.sdk.platformtools.ac.i("Finder.FinderFriendFoldedFeedLoader", (String)localObject1 + '}');
        localObject1 = (List)new ArrayList();
        ((List)localObject1).addAll((Collection)paramList);
        g.cvB().put(Long.valueOf(paramLong), new g.a.a((List)localObject1));
        AppMethodBeat.o(202103);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene1", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    extends e<g.c, g.e, BaseFinderFeed>
    implements com.tencent.mm.ak.g
  {
    private final String TAG;
    private final Map<com.tencent.mm.plugin.finder.cgi.ac, d<BaseFinderFeed>> map;
    
    public b(anm paramanm)
    {
      super();
      AppMethodBeat.i(202109);
      this.TAG = "Finder.FinderFoldedListData";
      this.map = ((Map)new LinkedHashMap());
      AppMethodBeat.o(202109);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202105);
      com.tencent.mm.kernel.g.agi().a(3904, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202105);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202106);
      com.tencent.mm.kernel.g.agi().b(3904, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202106);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202107);
      d locald = (d)this.map.get(paramn);
      if (locald != null)
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFoldedList");
          AppMethodBeat.o(202107);
          throw paramString;
        }
        com.tencent.mm.plugin.finder.cgi.ac localac = (com.tencent.mm.plugin.finder.cgi.ac)paramn;
        this.map.remove(paramn);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramn = localac.rr.aBD();
          if (paramn == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
            AppMethodBeat.o(202107);
            throw paramString;
          }
          if (((akq)paramn).continueFlag != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          paramn = new g.d(paramInt1, paramInt2, paramString);
          localObject1 = (Iterable)localac.cst();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FinderObject)((Iterator)localObject1).next();
            Object localObject3 = FinderItem.rDA;
            localObject2 = FinderItem.a.a((FinderObject)localObject2, 256);
            localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
            paramString.add(b.a.i((FinderItem)localObject2));
          }
        }
        paramn.setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        b.a.a((List)localac.cst(), 1, false, null, true, this.contextObj, 40);
        Object localObject1 = this.TAG;
        Object localObject2 = new StringBuilder("incrementList size: ");
        paramString = paramn.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          com.tencent.mm.sdk.platformtools.ac.i((String)localObject1, paramString);
          paramn.setPullType(localac.pullType);
          paramString = localac.rr.aBD();
          if (paramString != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
          AppMethodBeat.o(202107);
          throw paramString;
        }
        paramn.setLastBuffer(((akq)paramString).lastBuffer);
        paramn.setHasMore(bool);
        locald.onFetchDone((IResponse)paramn);
        AppMethodBeat.o(202107);
        return;
      }
      AppMethodBeat.o(202107);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "cacheId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    final long rhr;
    
    public c(long paramLong, f paramf)
    {
      super();
      AppMethodBeat.i(202110);
      this.rhr = paramLong;
      AppMethodBeat.o(202110);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class d
    extends IResponse<BaseFinderFeed>
  {
    public d(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "finderUserName", "", "feedId", "", "nonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFeedId", "()J", "getFinderUserName", "()Ljava/lang/String;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getNonceId", "getPullType", "()I", "plugin-finder_release"})
  public static final class e
    implements i
  {
    final long dig;
    final com.tencent.mm.bw.b lastBuffer;
    final int pullType;
    final String qXC;
    final String rmF;
    
    public e(String paramString1, long paramLong, String paramString2, com.tencent.mm.bw.b paramb, int paramInt)
    {
      AppMethodBeat.i(202111);
      this.rmF = paramString1;
      this.dig = paramLong;
      this.qXC = paramString2;
      this.lastBuffer = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(202111);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.g
 * JD-Core Version:    0.7.0.1
 */