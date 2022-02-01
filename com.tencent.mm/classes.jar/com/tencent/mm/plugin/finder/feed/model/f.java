package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
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
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fromUserName", "getFromUserName", "setFromUserName", "hasRefreshFinish", "", "getHasRefreshFinish", "()Z", "setHasRefreshFinish", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getTabType", "()I", "toUserName", "getToUserName", "setToUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "findMergeIndex", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "onFetchDone", "response", "requestLoadMore", "requestRefresh", "FinderFeedRelListData", "FinderShareRelativeListInit", "FinderShareRelativeListRequest", "FinderShareRelativeListResponse", "plugin-finder_release"})
public final class f
  extends BaseFinderFeedLoader
{
  private String TAG;
  public String dfJ;
  public final long dig;
  private final int diw;
  public String dtD;
  private com.tencent.mm.bw.b lastBuffer;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> rmE;
  private boolean rmM;
  
  public f(long paramLong, int paramInt, anm paramanm)
  {
    super(null, paramanm, 1, null);
    this.dig = paramLong;
    this.diw = paramInt;
    this.TAG = "Finder.FinderFeedShareRelativeListLoader";
    this.dtD = "";
    this.dfJ = "";
  }
  
  public final e<Object, Object, h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(202093);
    paramanm = (e)new a(paramanm);
    AppMethodBeat.o(202093);
    return paramanm;
  }
  
  public final int findMergeIndex(ArrayList<BaseFinderFeed> paramArrayList, List<? extends BaseFinderFeed> paramList, int paramInt, i parami)
  {
    AppMethodBeat.i(202098);
    k.h(paramArrayList, "srcList");
    k.h(paramList, "newList");
    paramInt = getDataList().size();
    AppMethodBeat.o(202098);
    return paramInt;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(202097);
    k.h(paramIResponse, "response");
    Object localObject = paramIResponse.getIncrementList();
    int i;
    label85:
    long l;
    if (localObject != null)
    {
      i = ((List)localObject).size();
      if (i <= 0) {
        break label179;
      }
      localObject = paramIResponse.getIncrementList();
      if (localObject == null) {
        break label163;
      }
      localObject = (BaseFinderFeed)((List)localObject).get(0);
      if (localObject == null) {
        break label163;
      }
      localObject = ((BaseFinderFeed)localObject).feedObject;
      if (localObject == null) {
        break label163;
      }
      localObject = Long.valueOf(((FinderItem)localObject).field_id);
      ac.i(getTAG(), "response id:" + localObject + ",requese id:" + this.dig);
      if (paramIResponse.getPullType() != 0) {
        break label179;
      }
      if (localObject != null) {
        break label169;
      }
      label133:
      l = this.dig;
      if (localObject != null) {
        break label230;
      }
    }
    for (;;)
    {
      ac.i(getTAG(), "not belong to this feed，return");
      AppMethodBeat.o(202097);
      return;
      i = 0;
      break;
      label163:
      localObject = null;
      break label85;
      label169:
      if (((Long)localObject).longValue() != 0L) {
        break label133;
      }
      label179:
      label230:
      do
      {
        if (paramIResponse.getPullType() == 0)
        {
          this.rmM = true;
          ac.d(getTAG(), "refresh finish");
        }
        if ((paramIResponse.getPullType() != 2) || (this.rmM)) {
          break;
        }
        ac.d(getTAG(), "loadmore before refresh");
        AppMethodBeat.o(202097);
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
    localObject = this.rmE;
    if (localObject != null)
    {
      ((d.g.a.b)localObject).ay(paramIResponse);
      AppMethodBeat.o(202097);
      return;
    }
    AppMethodBeat.o(202097);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(202096);
    c localc = new c(this.dig, this.diw, this.lastBuffer, 2, this.dtD, this.dfJ);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(localc)));
    fetchData((i)localc);
    AppMethodBeat.o(202096);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202095);
    c localc = new c(this.dig, this.diw, this.lastBuffer, 0, this.dtD, this.dfJ);
    ac.i(getTAG(), "requestRefresh ".concat(String.valueOf(localc)));
    this.rmM = false;
    fetchData((i)localc);
    AppMethodBeat.o(202095);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(202094);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(202094);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderFeedRelListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    extends e<f.b, f.c, BaseFinderFeed>
    implements com.tencent.mm.ak.g
  {
    private final String TAG;
    private final FinderTimelineRefCacheVM rhJ;
    private d<BaseFinderFeed> rmL;
    
    public a(anm paramanm)
    {
      super();
      AppMethodBeat.i(202090);
      this.TAG = "Finder.FinderFeedRelListData";
      paramanm = a.IrY;
      paramanm = a.bg(PluginFinder.class).get(FinderTimelineRefCacheVM.class);
      k.g(paramanm, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
      this.rhJ = ((FinderTimelineRefCacheVM)paramanm);
      AppMethodBeat.o(202090);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202086);
      com.tencent.mm.kernel.g.agi().a(3688, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202086);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202087);
      com.tencent.mm.kernel.g.agi().b(3688, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202087);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      Object localObject1 = null;
      AppMethodBeat.i(202088);
      if ((paramn instanceof ab))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        f.d locald;
        for (boolean bool = ((ab)paramn).css();; bool = true)
        {
          locald = new f.d(paramInt1, paramInt2, paramString);
          paramString = ((ab)paramn).csr();
          if (((ab)paramn).pullType == 0)
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
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (FinderObject)((Iterator)localObject3).next();
            Object localObject5 = FinderItem.rDA;
            localObject4 = FinderItem.a.a((FinderObject)localObject4, 256);
            localObject5 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
            ((Collection)localObject2).add(b.a.i((FinderItem)localObject4));
          }
        }
        locald.setIncrementList((List)localObject2);
        Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        b.a.a((List)paramString, 1, false, null, true, null, 104);
        localObject2 = this.TAG;
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
          AppMethodBeat.o(202088);
          return;
        }
      }
      AppMethodBeat.o(202088);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "feedId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getFeedId", "()J", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    private final long dig;
    
    public b(long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.f paramf)
    {
      super();
      AppMethodBeat.i(202091);
      this.dig = paramLong;
      AppMethodBeat.o(202091);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "feedId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "scene", "fromUserName", "", "toUserName", "(JILcom/tencent/mm/protobuf/ByteString;IILjava/lang/String;Ljava/lang/String;)V", "getFeedId", "()J", "getFromUserName", "()Ljava/lang/String;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "getScene", "setScene", "(I)V", "getTabType", "getToUserName", "plugin-finder_release"})
  public static final class c
    implements i
  {
    final String dfJ;
    final long dig;
    final int diw;
    final String dtD;
    final com.tencent.mm.bw.b lastBuffer;
    final int pullType;
    int scene;
    
    public c(long paramLong, int paramInt1, com.tencent.mm.bw.b paramb, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(202092);
      this.dig = paramLong;
      this.diw = paramInt1;
      this.lastBuffer = paramb;
      this.pullType = paramInt2;
      this.scene = 3;
      this.dtD = paramString1;
      this.dfJ = paramString2;
      AppMethodBeat.o(202092);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
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
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.f
 * JD-Core Version:    0.7.0.1
 */