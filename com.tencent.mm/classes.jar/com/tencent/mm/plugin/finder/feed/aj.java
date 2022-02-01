package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.ak;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.a.j;
import d.g.a.a;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract;", "", "()V", "Companion", "FinderTopicTimelineData", "FinderTopicTimelineInit", "FinderTopicTimelineRequest", "FinderTopicTimelineResponse", "Loader", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class aj
{
  private static final String TAG = "Finder.FinderTopicTimelineUIContract";
  private static final ConcurrentHashMap<Long, aj.a.a> rmf;
  public static final a rmg;
  
  static
  {
    AppMethodBeat.i(166004);
    rmg = new a((byte)0);
    TAG = "Finder.FinderTopicTimelineUIContract";
    rmf = new ConcurrentHashMap();
    AppMethodBeat.o(166004);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion;", "", "()V", "TAG", "", "topicDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion$TopicTimelineCache;", "getTopicDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "getCache", "id", "putCache", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "removeCache", "TopicTimelineCache", "plugin-finder_release"})
  public static final class a
  {
    public static void a(long paramLong, List<? extends BaseFinderFeed> paramList, com.tencent.mm.bw.b paramb, cnx paramcnx)
    {
      AppMethodBeat.i(202025);
      k.h(paramList, "dataList");
      ac.i(aj.access$getTAG$cp(), "putCache " + paramLong + ", list size:" + paramList.size());
      List localList = (List)new ArrayList();
      localList.addAll((Collection)paramList);
      aj.cvy().put(Long.valueOf(paramLong), new a(localList, paramb, paramcnx));
      AppMethodBeat.o(202025);
    }
    
    public static void ui(long paramLong)
    {
      AppMethodBeat.i(202026);
      ac.i(aj.access$getTAG$cp(), "removeCache ".concat(String.valueOf(paramLong)));
      if (aj.cvy().containsKey(Long.valueOf(paramLong))) {
        aj.cvy().remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(202026);
    }
    
    public static a uj(long paramLong)
    {
      AppMethodBeat.i(165984);
      ac.i(aj.access$getTAG$cp(), "getCache " + paramLong + ", exist:" + aj.cvy().containsKey(Long.valueOf(paramLong)));
      a locala2 = (a)aj.cvy().get(Long.valueOf(paramLong));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a((List)new ArrayList());
      }
      AppMethodBeat.o(165984);
      return locala1;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion$TopicTimelineCache;", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getDataList", "()Ljava/util/List;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      public final List<BaseFinderFeed> dataList;
      public final com.tencent.mm.bw.b lastBuffer;
      final cnx rmh;
      
      public a(List<? extends BaseFinderFeed> paramList, com.tencent.mm.bw.b paramb, cnx paramcnx)
      {
        AppMethodBeat.i(202024);
        this.dataList = paramList;
        this.lastBuffer = paramb;
        this.rmh = paramcnx;
        AppMethodBeat.o(202024);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(165983);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!k.g(this.dataList, paramObject.dataList)) || (!k.g(this.lastBuffer, paramObject.lastBuffer)) || (!k.g(this.rmh, paramObject.rmh))) {}
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
          localObject = this.rmh;
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
        String str = "TopicTimelineCache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ", tag=" + this.rmh + ")";
        AppMethodBeat.o(165981);
        return str;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineInit;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    extends e<aj.c, aj.d, BaseFinderFeed>
    implements com.tencent.mm.ak.g
  {
    private final String TAG;
    private final Map<ak, com.tencent.mm.plugin.finder.feed.model.internal.d<BaseFinderFeed>> map;
    
    public b(anm paramanm)
    {
      super();
      AppMethodBeat.i(202027);
      this.TAG = "Finder.FinderTopicTimelineData";
      this.map = ((Map)new LinkedHashMap());
      AppMethodBeat.o(202027);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(165986);
      com.tencent.mm.kernel.g.agi().a(817, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(165986);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(165987);
      com.tencent.mm.kernel.g.agi().a(817, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(165987);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(165988);
      com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)this.map.get(paramn);
      if (locald != null)
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetTopicFeed");
          AppMethodBeat.o(165988);
          throw paramString;
        }
        ak localak = (ak)paramn;
        this.map.remove(paramn);
        if ((paramInt1 == 0) && (paramInt2 == 0) && (localak.csz() == 0)) {}
        aj.e locale;
        for (boolean bool = false;; bool = true)
        {
          locale = new aj.e(localak.csF(), paramInt1, paramInt2, paramString);
          paramn = (Iterable)((ak)paramn).csE();
          paramString = (Collection)new ArrayList(j.a(paramn, 10));
          paramn = paramn.iterator();
          while (paramn.hasNext())
          {
            localObject1 = (FinderObject)paramn.next();
            Object localObject2 = FinderItem.rDA;
            localObject1 = FinderItem.a.a((FinderObject)localObject1, 64);
            localObject2 = FinderTopicFeedUI.rsI;
            ((Map)FinderTopicFeedUI.cvK()).put(Long.valueOf(((FinderItem)localObject1).getId()), localObject1);
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
            paramString.add(com.tencent.mm.plugin.finder.storage.logic.b.a.i((FinderItem)localObject1));
          }
        }
        locale.setIncrementList((List)paramString);
        paramn = this.TAG;
        Object localObject1 = new StringBuilder("incrementList size: ");
        paramString = locale.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ac.i(paramn, paramString);
          locale.setPullType(localak.pullType);
          locale.setLastBuffer(localak.csy());
          locale.setHasMore(bool);
          locald.onFetchDone((IResponse)locale);
          AppMethodBeat.o(165988);
          return;
        }
      }
      AppMethodBeat.o(165988);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "cacheId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    final long rhr;
    
    public c(long paramLong, f paramf)
    {
      super();
      AppMethodBeat.i(165991);
      this.rhr = paramLong;
      AppMethodBeat.o(165991);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPullType", "()I", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "()Ljava/lang/String;", "getType", "plugin-finder_release"})
  public static final class d
    implements i
  {
    final String dol;
    final com.tencent.mm.bw.b lastBuffer;
    final alt location;
    final int pullType;
    final anu qYj;
    final cnx rmh;
    final Long rmi;
    final int type;
    
    public d(int paramInt, String paramString, alt paramalt, Long paramLong, com.tencent.mm.bw.b paramb, anu paramanu, cnx paramcnx)
    {
      AppMethodBeat.i(202028);
      this.type = paramInt;
      this.dol = paramString;
      this.location = paramalt;
      this.rmi = paramLong;
      this.lastBuffer = paramb;
      this.pullType = 2;
      this.qYj = paramanu;
      this.rmh = paramcnx;
      AppMethodBeat.o(202028);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$FinderTopicTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "totalCount", "", "errType", "", "errCode", "errMsg", "", "(JIILjava/lang/String;)V", "getTotalCount", "()J", "plugin-finder_release"})
  public static final class e
    extends IResponse<BaseFinderFeed>
  {
    private final long rfD;
    
    public e(long paramLong, int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
      this.rfD = paramLong;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "relatedTopic", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getRelatedTopic", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setRelatedTopic", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTopic", "getType", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
  public static final class f
    extends BaseFinderFeedLoader
  {
    private String TAG;
    private final String dol;
    public a<y> fetchEndCallback;
    com.tencent.mm.bw.b lastBuffer;
    private final alt location;
    private final anu qYj;
    public long refObjectId;
    cnx rmj;
    private final int type;
    
    public f(int paramInt, String paramString, alt paramalt, com.tencent.mm.plugin.finder.feed.model.internal.c paramc, anu paramanu, anm paramanm)
    {
      super(paramanm, 1, null);
      AppMethodBeat.i(202030);
      this.type = paramInt;
      this.dol = paramString;
      this.location = paramalt;
      this.qYj = paramanu;
      this.TAG = "Finder.FinderTopicTimelineLoader";
      AppMethodBeat.o(202030);
    }
    
    public final e<Object, Object, h> createDataFetch(anm paramanm)
    {
      AppMethodBeat.i(202029);
      paramanm = (e)new aj.b(paramanm);
      AppMethodBeat.o(202029);
      return paramanm;
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
      if ((paramIResponse instanceof aj.e)) {
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
      aj.d locald = new aj.d(this.type, this.dol, this.location, Long.valueOf(this.refObjectId), this.lastBuffer, this.qYj, this.rmj);
      ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
      fetchData((i)locald);
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "cacheId", "", "initPos", "", "scene", "(Lcom/tencent/mm/ui/MMActivity;JII)V", "getCacheId", "()J", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getInitPos", "()I", "getScene", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
  public static final class g
    extends r.a
  {
    private final com.tencent.mm.plugin.finder.feed.model.c rfE;
    final long rhr;
    final int rht;
    private final int scene;
    
    public g(MMActivity paramMMActivity, long paramLong, int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(202031);
      this.rhr = paramLong;
      this.rht = paramInt1;
      this.scene = paramInt2;
      this.rfE = new com.tencent.mm.plugin.finder.feed.model.c(paramMMActivity);
      AppMethodBeat.o(202031);
    }
    
    public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, r.b paramb)
    {
      AppMethodBeat.i(178281);
      k.h(paramBaseFinderFeedLoader, "model");
      k.h(paramb, "callback");
      super.a(paramBaseFinderFeedLoader, paramb);
      this.rfE.a(this.scene, this.rfR, (d.g.a.b)new b(this));
      paramBaseFinderFeedLoader = FinderReporterUIC.seQ;
      paramBaseFinderFeedLoader = FinderReporterUIC.a.eV((Context)this.iMV);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
        if (paramBaseFinderFeedLoader != null)
        {
          paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.rfE);
          AppMethodBeat.o(178281);
          return;
        }
      }
      AppMethodBeat.o(178281);
    }
    
    public final void aQh()
    {
      AppMethodBeat.i(166000);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestLoadMore();
        AppMethodBeat.o(166000);
        return;
      }
      AppMethodBeat.o(166000);
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.g cup()
    {
      AppMethodBeat.i(165998);
      com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new aj.c(this.rhr, (f)new a(this));
      AppMethodBeat.o(165998);
      return localg;
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(178282);
      this.rfE.onDetach();
      Object localObject = FinderReporterUIC.seQ;
      localObject = FinderReporterUIC.a.eV((Context)this.iMV);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.rfE);
        }
      }
      super.onDetach();
      AppMethodBeat.o(178282);
    }
    
    public final void requestRefresh()
    {
      AppMethodBeat.i(165999);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestRefresh();
        AppMethodBeat.o(165999);
        return;
      }
      AppMethodBeat.o(165999);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a
      implements f
    {
      public final void call(int paramInt)
      {
        AppMethodBeat.i(165997);
        Object localObject = this.rmk.rfN;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).rfT.getRecyclerView();
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
              ((FinderLayoutManager)localObject).af(this.rmk.rht, 0);
            }
          }
        }
        localObject = this.rmk.rgh;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader");
          AppMethodBeat.o(165997);
          throw ((Throwable)localObject);
        }
        localObject = (aj.f)localObject;
        aj.a locala = aj.rmg;
        ((aj.f)localObject).lastBuffer = aj.a.uj(this.rmk.rhr).lastBuffer;
        localObject = this.rmk.rgh;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader");
          AppMethodBeat.o(165997);
          throw ((Throwable)localObject);
        }
        localObject = (aj.f)localObject;
        locala = aj.rmg;
        ((aj.f)localObject).rmj = aj.a.uj(this.rmk.rhr).rmh;
        AppMethodBeat.o(165997);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<Integer, BaseFinderFeed>
    {
      b(aj.g paramg)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
  public static final class h
    extends r.b
  {
    public h(MMActivity paramMMActivity, aj.g paramg, int paramInt1, int paramInt2)
    {
      super((r.a)paramg, paramInt1, paramInt2);
      AppMethodBeat.i(166003);
      AppMethodBeat.o(166003);
    }
    
    public final void T(ArrayList<BaseFinderFeed> paramArrayList)
    {
      AppMethodBeat.i(166002);
      k.h(paramArrayList, "data");
      super.T(paramArrayList);
      paramArrayList = this.rfT;
      View localView = z.jD((Context)this.iMV).inflate(2131494590, null);
      k.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramArrayList.setLoadMoreFooter(localView);
      AppMethodBeat.o(166002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aj
 * JD-Core Version:    0.7.0.1
 */