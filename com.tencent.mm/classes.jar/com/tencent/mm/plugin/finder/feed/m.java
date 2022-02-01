package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.t;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.a;
import d.g.b.k;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract;", "", "()V", "Companion", "FinderTopicTimelineData", "FinderTopicTimelineInit", "FinderTopicTimelineRequest", "FinderTopicTimelineResponse", "Loader", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class m
{
  private static final String TAG = "Finder.FinderTopicTimelineUIContract";
  private static final ConcurrentHashMap<Long, m.a.a> qxR;
  public static final a qxS;
  
  static
  {
    AppMethodBeat.i(166004);
    qxS = new a((byte)0);
    TAG = "Finder.FinderTopicTimelineUIContract";
    qxR = new ConcurrentHashMap();
    AppMethodBeat.o(166004);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion;", "", "()V", "TAG", "", "topicDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion$TopicTimelineCache;", "getTopicDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "getCache", "id", "putCache", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "removeCache", "TopicTimelineCache", "plugin-finder_release"})
  public static final class a
  {
    public static void BI(long paramLong)
    {
      AppMethodBeat.i(198118);
      ad.i(m.access$getTAG$cp(), "removeCache ".concat(String.valueOf(paramLong)));
      if (m.cmu().containsKey(Long.valueOf(paramLong))) {
        m.cmu().remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(198118);
    }
    
    public static void a(long paramLong, List<? extends BaseFinderFeed> paramList, com.tencent.mm.bx.b paramb, ebq paramebq)
    {
      AppMethodBeat.i(198117);
      k.h(paramList, "dataList");
      ad.i(m.access$getTAG$cp(), "putCache " + paramLong + ", list size:" + paramList.size());
      List localList = (List)new ArrayList();
      localList.addAll((Collection)paramList);
      m.cmu().put(Long.valueOf(paramLong), new a(localList, paramb, paramebq));
      AppMethodBeat.o(198117);
    }
    
    public static a qb(long paramLong)
    {
      AppMethodBeat.i(165984);
      ad.i(m.access$getTAG$cp(), "getCache " + paramLong + ", exist:" + m.cmu().containsKey(Long.valueOf(paramLong)));
      a locala2 = (a)m.cmu().get(Long.valueOf(paramLong));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a((List)new ArrayList());
      }
      AppMethodBeat.o(165984);
      return locala1;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion$TopicTimelineCache;", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getDataList", "()Ljava/util/List;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      final ebq KPD;
      public final List<BaseFinderFeed> dataList;
      public final com.tencent.mm.bx.b lastBuffer;
      
      public a(List<? extends BaseFinderFeed> paramList, com.tencent.mm.bx.b paramb, ebq paramebq)
      {
        AppMethodBeat.i(198116);
        this.dataList = paramList;
        this.lastBuffer = paramb;
        this.KPD = paramebq;
        AppMethodBeat.o(198116);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(165983);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!k.g(this.dataList, paramObject.dataList)) || (!k.g(this.lastBuffer, paramObject.lastBuffer)) || (!k.g(this.KPD, paramObject.KPD))) {}
          }
        }
        else
        {
          AppMethodBeat.o(165983);
          return true;
        }
        AppMethodBeat.o(165983);
        return false;
      }
      
      public final int hashCode()
      {
        int k = 0;
        AppMethodBeat.i(165982);
        Object localObject = this.dataList;
        int i;
        if (localObject != null)
        {
          i = localObject.hashCode();
          localObject = this.lastBuffer;
          if (localObject == null) {
            break label80;
          }
        }
        label80:
        for (int j = localObject.hashCode();; j = 0)
        {
          localObject = this.KPD;
          if (localObject != null) {
            k = localObject.hashCode();
          }
          AppMethodBeat.o(165982);
          return (j + i * 31) * 31 + k;
          i = 0;
          break;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(165981);
        String str = "TopicTimelineCache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ", tag=" + this.KPD + ")";
        AppMethodBeat.o(165981);
        return str;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineInit;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.f<m.c, m.d, BaseFinderFeed>
    implements com.tencent.mm.al.g
  {
    private final String TAG;
    private final Map<t, com.tencent.mm.plugin.finder.feed.model.internal.e<BaseFinderFeed>> map;
    
    public b(dzp paramdzp)
    {
      super();
      AppMethodBeat.i(198119);
      this.TAG = "Finder.FinderTopicTimelineData";
      this.map = ((Map)new LinkedHashMap());
      AppMethodBeat.o(198119);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(165986);
      com.tencent.mm.kernel.g.aeS().a(817, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(165986);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(165987);
      com.tencent.mm.kernel.g.aeS().a(817, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(165987);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(165988);
      com.tencent.mm.plugin.finder.feed.model.internal.e locale = (com.tencent.mm.plugin.finder.feed.model.internal.e)this.map.get(paramn);
      if (locale != null)
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetTopicFeed");
          AppMethodBeat.o(165988);
          throw paramString;
        }
        t localt = (t)paramn;
        this.map.remove(paramn);
        if ((paramInt1 == 0) && (paramInt2 == 0) && (localt.ckO() == 0)) {}
        m.e locale1;
        for (boolean bool = false;; bool = true)
        {
          locale1 = new m.e(localt.ckM(), paramInt1, paramInt2, paramString);
          paramn = (Iterable)((t)paramn).fSe();
          paramString = (Collection)new ArrayList(d.a.j.a(paramn, 10));
          paramn = paramn.iterator();
          while (paramn.hasNext())
          {
            localObject1 = (FinderObject)paramn.next();
            Object localObject2 = FinderItem.qJU;
            localObject1 = FinderItem.a.a((FinderObject)localObject1, 64);
            localObject2 = FinderTopicFeedUI.qBH;
            ((Map)FinderTopicFeedUI.cmQ()).put(Long.valueOf(((FinderItem)localObject1).getId()), localObject1);
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
            paramString.add(b.a.h((FinderItem)localObject1));
          }
        }
        locale1.setIncrementList((List)paramString);
        paramn = this.TAG;
        Object localObject1 = new StringBuilder("incrementList size: ");
        paramString = locale1.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ad.i(paramn, paramString);
          locale1.setPullType(localt.pullType);
          locale1.setLastBuffer(localt.ckN());
          locale1.setHasMore(bool);
          locale.onFetchDone((IResponse)locale1);
          AppMethodBeat.o(165988);
          return;
        }
      }
      AppMethodBeat.o(165988);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "cacheId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "plugin-finder_release"})
  public static final class c
    extends h
  {
    final long qxT;
    
    public c(long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      super();
      AppMethodBeat.i(165991);
      this.qxT = paramLong;
      AppMethodBeat.o(165991);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPullType", "()I", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "()Ljava/lang/String;", "getType", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    final dzq KJJ;
    final ebq KPD;
    final String dqA;
    final com.tencent.mm.bx.b lastBuffer;
    final ajq location;
    final int pullType;
    final Long qxU;
    final int type;
    
    public d(int paramInt, String paramString, ajq paramajq, Long paramLong, com.tencent.mm.bx.b paramb, dzq paramdzq, ebq paramebq)
    {
      AppMethodBeat.i(198120);
      this.type = paramInt;
      this.dqA = paramString;
      this.location = paramajq;
      this.qxU = paramLong;
      this.lastBuffer = paramb;
      this.pullType = 2;
      this.KJJ = paramdzq;
      this.KPD = paramebq;
      AppMethodBeat.o(198120);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "totalCount", "", "errType", "", "errCode", "errMsg", "", "(JIILjava/lang/String;)V", "getTotalCount", "()J", "plugin-finder_release"})
  public static final class e
    extends IResponse<BaseFinderFeed>
  {
    private final long qxB;
    
    public e(long paramLong, int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
      this.qxB = paramLong;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "relatedTopic", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getRelatedTopic", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setRelatedTopic", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTopic", "getType", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
  public static final class f
    extends BaseFinderFeedLoader
  {
    private final dzq KJJ;
    ebq KPE;
    private String TAG;
    private final String dqA;
    public a<d.y> fetchEndCallback;
    com.tencent.mm.bx.b lastBuffer;
    private final ajq location;
    public long refObjectId;
    private final int type;
    
    public f(int paramInt, String paramString, ajq paramajq, com.tencent.mm.plugin.finder.feed.model.internal.b paramb, dzq paramdzq, dzp paramdzp)
    {
      super(paramdzp, 1, null);
      AppMethodBeat.i(198122);
      this.type = paramInt;
      this.dqA = paramString;
      this.location = paramajq;
      this.KJJ = paramdzq;
      this.TAG = "Finder.FinderTopicTimelineLoader";
      AppMethodBeat.o(198122);
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.f<Object, Object, i> createDataFetch(dzp paramdzp)
    {
      AppMethodBeat.i(198121);
      paramdzp = (com.tencent.mm.plugin.finder.feed.model.internal.f)new m.b(paramdzp);
      AppMethodBeat.o(198121);
      return paramdzp;
    }
    
    public final String getTAG()
    {
      return this.TAG;
    }
    
    public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
    {
      AppMethodBeat.i(165995);
      k.h(paramIResponse, "response");
      super.onFetchDone(paramIResponse);
      paramIResponse.getPullType();
      if ((paramIResponse instanceof m.e)) {
        this.lastBuffer = paramIResponse.getLastBuffer();
      }
      if (!paramIResponse.getHasMore())
      {
        paramIResponse = this.fetchEndCallback;
        if (paramIResponse != null)
        {
          paramIResponse.invoke();
          AppMethodBeat.o(165995);
          return;
        }
      }
      AppMethodBeat.o(165995);
    }
    
    public final void requestLoadMore()
    {
      AppMethodBeat.i(165994);
      m.d locald = new m.d(this.type, this.dqA, this.location, Long.valueOf(this.refObjectId), this.lastBuffer, this.KJJ, this.KPE);
      ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
      fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locald);
      AppMethodBeat.o(165994);
    }
    
    public final void requestRefresh() {}
    
    public final void setTAG(String paramString)
    {
      AppMethodBeat.i(165993);
      k.h(paramString, "<set-?>");
      this.TAG = paramString;
      AppMethodBeat.o(165993);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "cacheId", "", "initPos", "", "scene", "(Lcom/tencent/mm/ui/MMActivity;JII)V", "getCacheId", "()J", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getInitPos", "()I", "getScene", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
  public static final class g
    extends e.a
  {
    final int qvB;
    private final com.tencent.mm.plugin.finder.feed.model.e qvy;
    final long qxT;
    private final int scene;
    
    public g(MMActivity paramMMActivity, long paramLong, int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(198123);
      this.qxT = paramLong;
      this.qvB = paramInt1;
      this.scene = paramInt2;
      this.qvy = new com.tencent.mm.plugin.finder.feed.model.e(paramMMActivity);
      AppMethodBeat.o(198123);
    }
    
    public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, e.b paramb)
    {
      AppMethodBeat.i(178281);
      k.h(paramBaseFinderFeedLoader, "model");
      k.h(paramb, "callback");
      super.a(paramBaseFinderFeedLoader, paramb);
      this.qvy.a(this.scene, this.qqE, (d.g.a.b)new b(this));
      paramBaseFinderFeedLoader = FinderReporterUIC.Ljl;
      paramBaseFinderFeedLoader = FinderReporterUIC.a.lB((Context)this.imP);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
        if (paramBaseFinderFeedLoader != null)
        {
          paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.f)this.qvy);
          AppMethodBeat.o(178281);
          return;
        }
      }
      AppMethodBeat.o(178281);
    }
    
    public final void aJq()
    {
      AppMethodBeat.i(166000);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestLoadMore();
        AppMethodBeat.o(166000);
        return;
      }
      AppMethodBeat.o(166000);
    }
    
    public final h clZ()
    {
      AppMethodBeat.i(165998);
      h localh = (h)new m.c(this.qxT, (com.tencent.mm.plugin.finder.feed.model.internal.g)new a(this));
      AppMethodBeat.o(165998);
      return localh;
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(178282);
      this.qvy.onDetach();
      Object localObject = FinderReporterUIC.Ljl;
      localObject = FinderReporterUIC.a.lB((Context)this.imP);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null) {
          ((d)localObject).b((com.tencent.mm.plugin.finder.event.base.f)this.qvy);
        }
      }
      super.onDetach();
      AppMethodBeat.o(178282);
    }
    
    public final void requestRefresh()
    {
      AppMethodBeat.i(165999);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestRefresh();
        AppMethodBeat.o(165999);
        return;
      }
      AppMethodBeat.o(165999);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.finder.feed.model.internal.g
    {
      public final void call(int paramInt)
      {
        AppMethodBeat.i(165997);
        Object localObject = this.qxW.qtZ;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).quj.getRecyclerView();
          if (localObject != null)
          {
            localObject = ((RecyclerView)localObject).getLayoutManager();
            if (localObject != null)
            {
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
                AppMethodBeat.o(165997);
                throw ((Throwable)localObject);
              }
              ((FinderLayoutManager)localObject).af(this.qxW.qvB, 0);
            }
          }
        }
        localObject = this.qxW.qvo;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader");
          AppMethodBeat.o(165997);
          throw ((Throwable)localObject);
        }
        localObject = (m.f)localObject;
        m.a locala = m.qxS;
        ((m.f)localObject).lastBuffer = m.a.qb(this.qxW.qxT).lastBuffer;
        localObject = this.qxW.qvo;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader");
          AppMethodBeat.o(165997);
          throw ((Throwable)localObject);
        }
        localObject = (m.f)localObject;
        locala = m.qxS;
        ((m.f)localObject).KPE = m.a.qb(this.qxW.qxT).KPD;
        AppMethodBeat.o(165997);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<Integer, BaseFinderFeed>
    {
      b(m.g paramg)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
  public static final class h
    extends e.b
  {
    public h(MMActivity paramMMActivity, m.g paramg, int paramInt1, int paramInt2)
    {
      super((e.a)paramg, paramInt1, paramInt2);
      AppMethodBeat.i(166003);
      AppMethodBeat.o(166003);
    }
    
    public final void O(ArrayList<BaseFinderFeed> paramArrayList)
    {
      AppMethodBeat.i(166002);
      k.h(paramArrayList, "data");
      super.O(paramArrayList);
      paramArrayList = this.quj;
      View localView = com.tencent.mm.ui.y.js((Context)this.imP).inflate(2131494590, null);
      k.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramArrayList.setLoadMoreFooter(localView);
      AppMethodBeat.o(166002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.m
 * JD-Core Version:    0.7.0.1
 */