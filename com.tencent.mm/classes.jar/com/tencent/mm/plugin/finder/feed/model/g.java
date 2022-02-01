package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ar;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.component.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasRefreshFinish", "", "getHasRefreshFinish", "()Z", "setHasRefreshFinish", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getTabType", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "findMergeIndex", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "onFetchDone", "response", "requestLoadMore", "requestRefresh", "FinderFeedRelListData", "FinderShareRelativeListInit", "FinderShareRelativeListRequest", "FinderShareRelativeListResponse", "plugin-finder_release"})
public final class g
  extends BaseFinderFeedLoader
{
  private final int IoU;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> KPL;
  private boolean KPS;
  private String TAG;
  public final long feedId;
  private com.tencent.mm.bx.b lastBuffer;
  
  public g(long paramLong, int paramInt, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    this.feedId = paramLong;
    this.IoU = paramInt;
    this.TAG = "Finder.FinderFeedShareRelativeListLoader";
  }
  
  public final f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198183);
    paramdzp = (f)new a(paramdzp);
    AppMethodBeat.o(198183);
    return paramdzp;
  }
  
  public final int findMergeIndex(ArrayList<BaseFinderFeed> paramArrayList, List<? extends BaseFinderFeed> paramList, int paramInt, com.tencent.mm.plugin.finder.feed.model.internal.j paramj)
  {
    AppMethodBeat.i(198188);
    k.h(paramArrayList, "srcList");
    k.h(paramList, "newList");
    paramInt = getDataList().size();
    AppMethodBeat.o(198188);
    return paramInt;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(198187);
    k.h(paramIResponse, "response");
    Object localObject = paramIResponse.getIncrementList();
    int i;
    label85:
    label126:
    long l;
    if (localObject != null)
    {
      i = ((List)localObject).size();
      if (i <= 0) {
        break label172;
      }
      localObject = paramIResponse.getIncrementList();
      if (localObject == null) {
        break label156;
      }
      localObject = (BaseFinderFeed)((List)localObject).get(0);
      if (localObject == null) {
        break label156;
      }
      localObject = ((BaseFinderFeed)localObject).feedObject;
      if (localObject == null) {
        break label156;
      }
      localObject = Long.valueOf(((FinderItem)localObject).field_id);
      ad.d(getTAG(), "response id:" + localObject + ",requese id:" + this.feedId);
      if (localObject != null) {
        break label162;
      }
      l = this.feedId;
      if (localObject != null) {
        break label223;
      }
    }
    for (;;)
    {
      ad.d(getTAG(), "not belong to this feed，return");
      AppMethodBeat.o(198187);
      return;
      i = 0;
      break;
      label156:
      localObject = null;
      break label85;
      label162:
      if (((Long)localObject).longValue() != 0L) {
        break label126;
      }
      label172:
      label223:
      do
      {
        if (paramIResponse.getPullType() == 0)
        {
          this.KPS = true;
          ad.d(getTAG(), "refresh finish");
        }
        if ((paramIResponse.getPullType() != 2) || (this.KPS)) {
          break;
        }
        ad.d(getTAG(), "loadmore before refresh");
        AppMethodBeat.o(198187);
        return;
      } while (l == ((Long)localObject).longValue());
    }
    if (paramIResponse.getPullType() == 0) {
      paramIResponse.setPullType(2);
    }
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof d)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    localObject = this.KPL;
    if (localObject != null)
    {
      ((d.g.a.b)localObject).aA(paramIResponse);
      AppMethodBeat.o(198187);
      return;
    }
    AppMethodBeat.o(198187);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(198186);
    c localc = new c(this.feedId, this.IoU, this.lastBuffer, 2);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(localc)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)localc);
    AppMethodBeat.o(198186);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(198185);
    c localc = new c(this.feedId, this.IoU, this.lastBuffer, 0);
    ad.i(getTAG(), "requestRefresh ".concat(String.valueOf(localc)));
    this.KPS = false;
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)localc);
    AppMethodBeat.o(198185);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(198184);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(198184);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderFeedRelListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    extends f<g.b, g.c, BaseFinderFeed>
    implements com.tencent.mm.al.g
  {
    private final FinderTimelineRefCacheVM KNr;
    private e<BaseFinderFeed> KPR;
    private final String TAG;
    
    public a(dzp paramdzp)
    {
      super();
      AppMethodBeat.i(198181);
      this.TAG = "Finder.FinderFeedRelListData";
      paramdzp = a.LCX;
      paramdzp = a.bE(PluginFinder.class).get(FinderTimelineRefCacheVM.class);
      k.g(paramdzp, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
      this.KNr = ((FinderTimelineRefCacheVM)paramdzp);
      AppMethodBeat.o(198181);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(198177);
      com.tencent.mm.kernel.g.aeS().a(3688, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198177);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(198178);
      com.tencent.mm.kernel.g.aeS().b(3688, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198178);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      Object localObject1 = null;
      AppMethodBeat.i(198179);
      if ((paramn instanceof ar))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        g.d locald;
        for (boolean bool = ((ar)paramn).fRW();; bool = true)
        {
          locald = new g.d(paramInt1, paramInt2, paramString);
          paramString = ((ar)paramn).fRV();
          if (((ar)paramn).pullType == 0)
          {
            localObject2 = new FinderObject();
            localObject3 = new FinderObjectDesc();
            ((FinderObjectDesc)localObject3).mediaType = 10001;
            ((FinderObject)localObject2).contact = new FinderContact();
            localObject4 = new FinderMedia();
            ((FinderMedia)localObject4).mediaType = 10001;
            new LinkedList().add(localObject4);
            ((FinderObject)localObject2).objectDesc = ((FinderObjectDesc)localObject3);
            if (paramString.size() > 1) {
              paramString.add(1, localObject2);
            }
          }
          localObject3 = (Iterable)paramString;
          localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (FinderObject)((Iterator)localObject3).next();
            Object localObject5 = FinderItem.qJU;
            localObject4 = FinderItem.a.a((FinderObject)localObject4, 256);
            localObject5 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
            ((Collection)localObject2).add(b.a.h((FinderItem)localObject4));
          }
        }
        locald.setIncrementList((List)localObject2);
        Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        b.a.a((List)paramString, 1, false, null, true, null, 104);
        localObject2 = this.TAG;
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
          AppMethodBeat.o(198179);
          return;
        }
      }
      AppMethodBeat.o(198179);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "feedId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getFeedId", "()J", "plugin-finder_release"})
  public static final class b
    extends h
  {
    private final long feedId;
    
    public b(long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      super();
      AppMethodBeat.i(198182);
      this.feedId = paramLong;
      AppMethodBeat.o(198182);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "feedId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "scene", "(JILcom/tencent/mm/protobuf/ByteString;II)V", "getFeedId", "()J", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "getScene", "setScene", "(I)V", "getTabType", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    final int IoU;
    final long feedId;
    final com.tencent.mm.bx.b lastBuffer;
    final int pullType;
    int scene;
    
    public c(long paramLong, int paramInt1, com.tencent.mm.bx.b paramb, int paramInt2)
    {
      this.feedId = paramLong;
      this.IoU = paramInt1;
      this.lastBuffer = paramb;
      this.pullType = paramInt2;
      this.scene = 3;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
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
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.g
 * JD-Core Version:    0.7.0.1
 */