package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bs;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract;", "", "()V", "Companion", "Loader", "Presenter", "TopicCustomData", "ViewCallback", "plugin-finder_release"})
public final class FinderTopicTimelineUIContract
{
  public static final a tTP;
  
  static
  {
    AppMethodBeat.i(166004);
    tTP = new a((byte)0);
    AppMethodBeat.o(166004);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "topicId", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;JLcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "encryptedTopicId", "getEncryptedTopicId", "setEncryptedTopicId", "eventTopicId", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "groupId", "getGroupId", "setGroupId", "hotTopicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getHotTopicBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setHotTopicBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "innerTabType", "getInnerTabType", "()I", "setInnerTabType", "(I)V", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedTopic", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getRelatedTopic", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setRelatedTopic", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTopic", "getTopicId", "getType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FinderTopicTimelineResponse", "TopicTimelineDataFetcher", "plugin-finder_release"})
  public static final class Loader
    extends BaseFinderFeedLoader
  {
    private String TAG;
    final String dST;
    public String groupId;
    final axt location;
    public long refObjectId;
    public int tTH;
    String tTQ;
    public com.tencent.mm.bw.b tTR;
    public kotlin.g.a.a<x> tTS;
    public dmk tTT;
    final bcc tvs;
    public long twd;
    final long twp;
    public final int type;
    
    public Loader(int paramInt, String paramString, long paramLong, axt paramaxt, e parame, bcc parambcc, bbn parambbn)
    {
      super();
      AppMethodBeat.i(244497);
      this.type = paramInt;
      this.dST = paramString;
      this.twp = paramLong;
      this.location = paramaxt;
      this.tvs = parambcc;
      this.tTQ = "";
      this.TAG = "Finder.FinderTopicTimelineLoader";
      AppMethodBeat.o(244497);
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.g<bo> createDataFetch()
    {
      AppMethodBeat.i(244495);
      com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new b();
      AppMethodBeat.o(244495);
      return localg;
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
    {
      AppMethodBeat.i(244496);
      com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
      AppMethodBeat.o(244496);
      return localb;
    }
    
    public final String getTAG()
    {
      return this.TAG;
    }
    
    public final void onFetchDone(IResponse<bo> paramIResponse)
    {
      AppMethodBeat.i(165995);
      p.h(paramIResponse, "response");
      super.onFetchDone(paramIResponse);
      if (isInitOperation(paramIResponse))
      {
        AppMethodBeat.o(165995);
        return;
      }
      if (!paramIResponse.getHasMore())
      {
        paramIResponse = this.tTS;
        if (paramIResponse != null)
        {
          paramIResponse.invoke();
          AppMethodBeat.o(165995);
          return;
        }
      }
      AppMethodBeat.o(165995);
    }
    
    public final void setTAG(String paramString)
    {
      AppMethodBeat.i(165993);
      p.h(paramString, "<set-?>");
      this.TAG = paramString;
      AppMethodBeat.o(165993);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$FinderTopicTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "totalCount", "", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "errType", "", "errCode", "errMsg", "", "(JLcom/tencent/mm/protocal/protobuf/FinderTopicInfo;IILjava/lang/String;)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTotalCount", "()J", "plugin-finder_release"})
    public static final class a
      extends IResponse<bo>
    {
      final bds dMU;
      private final long tTn;
      
      public a(long paramLong, bds parambds, int paramInt1, int paramInt2, String paramString)
      {
        super(paramInt2, paramString);
        this.tTn = paramLong;
        this.dMU = parambds;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$TopicTimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$FinderTopicTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b
      extends com.tencent.mm.plugin.finder.feed.model.internal.a
    {
      public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
      {
        AppMethodBeat.i(244491);
        p.h(paramq, "scene");
        bs localbs = (bs)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0) && (localbs.cYA() == 0)) {}
        FinderTopicTimelineUIContract.Loader.a locala;
        for (boolean bool = false;; bool = true)
        {
          locala = new FinderTopicTimelineUIContract.Loader.a(localbs.cYI(), localbs.cYJ(), paramInt1, paramInt2, paramString);
          paramq = (Iterable)((bs)paramq).cYH();
          paramString = (Collection)new ArrayList(j.a(paramq, 10));
          paramq = paramq.iterator();
          while (paramq.hasNext())
          {
            localObject1 = (FinderObject)paramq.next();
            Object localObject2 = FinderItem.Companion;
            localObject1 = FinderItem.a.a((FinderObject)localObject1, 64);
            localObject2 = FinderTopicFeedUI.udw;
            ((Map)FinderTopicFeedUI.ddO()).put(Long.valueOf(((FinderItem)localObject1).getId()), localObject1);
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            paramString.add(com.tencent.mm.plugin.finder.storage.logic.c.a.s((FinderItem)localObject1));
          }
        }
        locala.setIncrementList((List)paramString);
        paramq = getTAG();
        Object localObject1 = new StringBuilder("incrementList size: ");
        paramString = locala.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i(paramq, paramString);
          locala.setPullType(localbs.pullType);
          locala.setLastBuffer(localbs.cYz());
          locala.setHasMore(bool);
          paramString = (IResponse)locala;
          AppMethodBeat.o(244491);
          return paramString;
        }
      }
      
      public final com.tencent.mm.ak.q genLoadMoreNetScene()
      {
        AppMethodBeat.i(244490);
        Object localObject;
        switch (this.tTU.type)
        {
        case 3: 
        case 6: 
        default: 
          localObject = null;
        }
        for (;;)
        {
          localObject = (com.tencent.mm.ak.q)localObject;
          AppMethodBeat.o(244490);
          return localObject;
          localObject = new bs(this.tTU.dST, Long.valueOf(this.tTU.refObjectId), this.tTU.getLastBuffer(), this.tTU.tvs, this.tTU.getContextObj(), (byte)0);
          ((bs)localObject).pullType = 2;
          continue;
          String str = this.tTU.location.LIb;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localObject = new bs((String)localObject, this.tTU.location.dTj, this.tTU.location.latitude, Long.valueOf(this.tTU.refObjectId), this.tTU.getLastBuffer(), this.tTU.tTT, this.tTU.tvs, this.tTU.getContextObj());
          ((bs)localObject).pullType = 2;
          continue;
          str = this.tTU.groupId;
          localObject = str;
          if (str == null) {
            localObject = com.tencent.mm.ac.d.zs(this.tTU.refObjectId);
          }
          localObject = new bs((String)localObject, Long.valueOf(this.tTU.refObjectId), this.tTU.getLastBuffer(), this.tTU.tvs, this.tTU.getContextObj());
          ((bs)localObject).pullType = 2;
          continue;
          localObject = new bs(this.tTU.twd, Long.valueOf(this.tTU.refObjectId), this.tTU.tTQ, this.tTU.tTH, this.tTU.getLastBuffer(), this.tTU.getContextObj());
          continue;
          localObject = new bs(this.tTU.dST, this.tTU.twp, this.tTU.tTR, Long.valueOf(this.tTU.refObjectId), this.tTU.getLastBuffer(), this.tTU.tvs, this.tTU.getContextObj());
          ((bs)localObject).pullType = 2;
        }
      }
      
      public final com.tencent.mm.ak.q genRefreshNetScene()
      {
        AppMethodBeat.i(244489);
        if (this.tTU.type == 5)
        {
          com.tencent.mm.ak.q localq = (com.tencent.mm.ak.q)new bs(this.tTU.dST, this.tTU.twp, this.tTU.tTR, Long.valueOf(this.tTU.refObjectId), this.tTU.type, this.tTU.getContextObj());
          AppMethodBeat.o(244489);
          return localq;
        }
        AppMethodBeat.o(244489);
        return null;
      }
      
      public final List<Integer> getCmdIds()
      {
        AppMethodBeat.i(244488);
        List localList = j.listOf(Integer.valueOf(817));
        AppMethodBeat.o(244488);
        return localList;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class c
      extends BaseFeedLoader<bo>.a
    {
      c()
      {
        super();
      }
      
      public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
      {
        AppMethodBeat.i(244494);
        p.h(paramIResponse, "response");
        Object localObject = RefreshLoadMoreLayout.c.Rms;
        localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfT());
        if (((paramIResponse instanceof FinderTopicTimelineUIContract.Loader.a)) && (this.tTU.type == 5)) {
          ((RefreshLoadMoreLayout.c)localObject).tXF = ((FinderTopicTimelineUIContract.Loader.a)paramIResponse).dMU;
        }
        if (paramIResponse.getHasMore()) {}
        for (int i = 2;; i = 6)
        {
          com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, new n(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
          AppMethodBeat.o(244494);
          return;
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<x>
      {
        a(FinderTopicTimelineUIContract.Loader.c paramc, n paramn, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
        {
          super();
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion;", "", "()V", "getActionScene", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "", "type", "", "plugin-finder_release"})
  public static final class a
  {
    public static com.tencent.mm.vending.j.c<s.p, String> IK(int paramInt)
    {
      AppMethodBeat.i(244487);
      s.p localp = s.p.voA;
      Object localObject = "27";
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.me(true);
      if (2 == paramInt)
      {
        localp = s.p.voA;
        localObject = "27";
        locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.me(true);
      }
      for (;;)
      {
        localObject = com.tencent.mm.vending.j.a.Q(localp, localObject);
        p.g(localObject, "Tuple.make(action, scene)");
        AppMethodBeat.o(244487);
        return localObject;
        if (1 == paramInt)
        {
          localp = s.p.voB;
          localObject = "9";
          locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.me(false);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "type", "(Lcom/tencent/mm/ui/MMActivity;II)V", "activityCreatorFinderName", "", "getActivityCreatorFinderName", "()Ljava/lang/String;", "setActivityCreatorFinderName", "(Ljava/lang/String;)V", "activityFeedHandler", "Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "removeEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "getRemoveEvent", "()Lcom/tencent/mm/sdk/event/IListener;", "setRemoveEvent", "(Lcom/tencent/mm/sdk/event/IListener;)V", "getScene", "()I", "getType", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "isCreator", "", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onRefreshEnd", "requestRefresh", "Companion", "plugin-finder_release"})
  public static final class b
    extends v.a
  {
    public static final a tTY;
    private final int scene;
    private final com.tencent.mm.plugin.finder.feed.model.d tLy;
    private final com.tencent.mm.plugin.finder.feed.model.f tLz;
    private final com.tencent.mm.plugin.finder.feed.component.a tTW;
    private String tTX;
    private IListener<com.tencent.mm.g.a.f> tTp;
    private final int type;
    
    static
    {
      AppMethodBeat.i(244505);
      tTY = new a((byte)0);
      AppMethodBeat.o(244505);
    }
    
    public b(MMActivity paramMMActivity, int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(244504);
      this.scene = paramInt1;
      this.type = paramInt2;
      this.tTW = new com.tencent.mm.plugin.finder.feed.component.a();
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      this.tLy = ((FinderCommentPreloaderUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramMMActivity).get(FinderCommentPreloaderUIC.class)).tLy;
      locala = com.tencent.mm.ui.component.a.PRN;
      this.tLz = ((FinderLiveNoticePreLoadUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramMMActivity).get(FinderLiveNoticePreLoadUIC.class)).wyi;
      AppMethodBeat.o(244504);
    }
    
    public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, v.b paramb)
    {
      AppMethodBeat.i(178281);
      p.h(paramBaseFinderFeedLoader, "model");
      p.h(paramb, "callback");
      super.a(paramBaseFinderFeedLoader, paramb);
      this.tLy.a(this.scene, this.tCE, (kotlin.g.a.b)new b(this));
      paramBaseFinderFeedLoader = FinderReporterUIC.wzC;
      paramBaseFinderFeedLoader = FinderReporterUIC.a.fH((Context)this.gte);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
        if (paramBaseFinderFeedLoader != null) {
          paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
        }
      }
      paramBaseFinderFeedLoader = this.tTW;
      com.tencent.mm.kernel.g.azz().a(5909, (i)paramBaseFinderFeedLoader);
      this.tLz.e((kotlin.g.a.m)new c(this));
      if (this.type == 7)
      {
        this.tTW.tUe = this.gte.getIntent().getIntExtra("key_activity_max_top_count", 2);
        this.tTX = this.gte.getIntent().getStringExtra("key_creator_finder_name");
        this.tTp = ((IListener)new d(this));
        paramBaseFinderFeedLoader = this.tTp;
        if (paramBaseFinderFeedLoader != null) {
          paramBaseFinderFeedLoader.alive();
        }
      }
      paramBaseFinderFeedLoader = FinderReporterUIC.wzC;
      paramBaseFinderFeedLoader = FinderReporterUIC.a.fH((Context)this.gte);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
        if (paramBaseFinderFeedLoader != null)
        {
          paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
          AppMethodBeat.o(178281);
          return;
        }
      }
      AppMethodBeat.o(178281);
    }
    
    public final void a(BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(244503);
      p.h(paramBaseFinderFeed, "feed");
      p.h(paramMenuItem, "menuItem");
      int i = paramMenuItem.getItemId();
      if (i == 5001)
      {
        com.tencent.mm.plugin.finder.feed.component.a.a((Context)this.gte, paramBaseFinderFeed);
        AppMethodBeat.o(244503);
        return;
      }
      if (i == 5002)
      {
        this.tTW.a((Context)this.gte, true, paramBaseFinderFeed);
        AppMethodBeat.o(244503);
        return;
      }
      if (i == 5003)
      {
        this.tTW.a((Context)this.gte, false, paramBaseFinderFeed);
        AppMethodBeat.o(244503);
        return;
      }
      if (i == this.pMa)
      {
        if (this.type == 7)
        {
          paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (paramBaseFinderFeed != null)
          {
            paramBaseFinderFeed = paramBaseFinderFeed.event;
            if (paramBaseFinderFeed == null) {}
          }
          for (long l = paramBaseFinderFeed.twd;; l = 0L)
          {
            paramBaseFinderFeed = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
            com.tencent.mm.plugin.finder.feed.logic.a.i((Context)this.gte, l);
            AppMethodBeat.o(244503);
            return;
          }
        }
        super.a(paramBaseFinderFeed, paramMenuItem, paramInt);
        AppMethodBeat.o(244503);
        return;
      }
      super.a(paramBaseFinderFeed, paramMenuItem, paramInt);
      AppMethodBeat.o(244503);
    }
    
    public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(244502);
      p.h(paramBaseFinderFeed, "feed");
      p.h(paramm, "menu");
      if (this.type == 7)
      {
        if ((!Util.isNullOrNil(this.tTX)) && (p.j(this.tTX, z.aUg()))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            if (paramBaseFinderFeed.feedObject.isPostFinish()) {
              paramm.b(5001, (CharSequence)this.gte.getString(2131759516), 2131690897);
            }
            com.tencent.mm.plugin.finder.feed.component.a.a((Context)this.gte, paramBaseFinderFeed, paramm);
          }
          com.tencent.mm.plugin.finder.utils.y localy = com.tencent.mm.plugin.finder.utils.y.vXH;
          if (com.tencent.mm.plugin.finder.utils.y.h(paramBaseFinderFeed)) {
            break;
          }
          paramm.b(this.pMa, (CharSequence)this.gte.getString(2131763159), 2131690898);
          AppMethodBeat.o(244502);
          return;
        }
      }
      super.a(paramBaseFinderFeed, paramm);
      AppMethodBeat.o(244502);
    }
    
    public final void boE()
    {
      AppMethodBeat.i(166000);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestLoadMore();
        AppMethodBeat.o(166000);
        return;
      }
      AppMethodBeat.o(166000);
    }
    
    public final void dcd()
    {
      AppMethodBeat.i(244501);
      super.dcd();
      Object localObject1 = FinderTopicTimelineUIContract.tTP;
      Object localObject2 = FinderTopicTimelineUIContract.a.IK(this.type);
      localObject1 = k.vkd;
      localObject1 = this.tLN;
      if (localObject1 != null) {}
      for (localObject1 = ((b.b)localObject1).tLS.getRecyclerView();; localObject1 = null)
      {
        Object localObject3 = ((com.tencent.mm.vending.j.c)localObject2).hdM();
        p.g(localObject3, "tuple2.`$1`()");
        localObject3 = (s.p)localObject3;
        localObject2 = ((com.tencent.mm.vending.j.c)localObject2).hdN();
        p.g(localObject2, "tuple2.`$2`()");
        k.b((RecyclerView)localObject1, (s.p)localObject3, (String)localObject2, com.tencent.mm.plugin.finder.report.live.c.vjh);
        AppMethodBeat.o(244501);
        return;
      }
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(178282);
      this.tLy.onDetach();
      Object localObject = FinderReporterUIC.wzC;
      localObject = FinderReporterUIC.a.fH((Context)this.gte);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
        }
      }
      localObject = this.tTW;
      com.tencent.mm.kernel.g.azz().b(5909, (i)localObject);
      this.tLz.onDetach();
      localObject = this.tTp;
      if (localObject != null) {
        ((IListener)localObject).dead();
      }
      localObject = FinderReporterUIC.wzC;
      localObject = FinderReporterUIC.a.fH((Context)this.gte);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
        }
      }
      super.onDetach();
      AppMethodBeat.o(178282);
    }
    
    public final void requestRefresh()
    {
      AppMethodBeat.i(165999);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestRefresh();
        AppMethodBeat.o(165999);
        return;
      }
      AppMethodBeat.o(165999);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$Companion;", "", "()V", "CANCEL_TOP_PLACE_ACTIVITY", "", "REMOVE_FROM_ACTIVITY", "TOP_PLACE_ACTIVITY", "plugin-finder_release"})
    public static final class a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Integer, bo>
    {
      b(FinderTopicTimelineUIContract.b paramb)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.m<Integer, Integer, LinkedList<bo>>
    {
      c(FinderTopicTimelineUIContract.b paramb)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$onAttach$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class d
      extends IListener<com.tencent.mm.g.a.f>
    {
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$onAttach$3$callback$1$1"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<x>
      {
        a(FinderTopicTimelineUIContract.b.d paramd, com.tencent.mm.g.a.f paramf)
        {
          super();
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$TopicCustomData;", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "tagLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protobuf/ByteString;)V", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.feed.model.a
  {
    public final dmk tUb;
    final com.tencent.mm.bw.b tUc;
    
    public c(dmk paramdmk, com.tencent.mm.bw.b paramb)
    {
      this.tUb = paramdmk;
      this.tUc = paramb;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;II)V", "topicHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "type", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewCallPreFinishRefresh", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class d
    extends v.b
  {
    private y tTC;
    private int type;
    
    public d(MMActivity paramMMActivity, FinderTopicTimelineUIContract.b paramb, int paramInt1, int paramInt2)
    {
      super((v.a)paramb, paramInt1, paramInt2);
      AppMethodBeat.i(166003);
      AppMethodBeat.o(166003);
    }
    
    public final void aa(ArrayList<bo> paramArrayList)
    {
      AppMethodBeat.i(166002);
      p.h(paramArrayList, "data");
      super.aa(paramArrayList);
      paramArrayList = this.tLS;
      View localView = aa.jQ((Context)this.gte).inflate(2131495297, null);
      p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramArrayList.setLoadMoreFooter(localView);
      this.type = this.gte.getIntent().getIntExtra("key_topic_type", 0);
      if (this.type == 5)
      {
        this.tTC = new y(this.gte, this.tLS);
        paramArrayList = this.gte.findViewById(2131300111);
        p.g(paramArrayList, "context.findViewById<FrameLayout>(R.id.empty_view)");
        ((FrameLayout)paramArrayList).setVisibility(0);
        paramArrayList = this.gte.findViewById(2131306281);
        p.g(paramArrayList, "context.findViewById<ProgressBar>(R.id.progress)");
        ((ProgressBar)paramArrayList).setVisibility(0);
      }
      AppMethodBeat.o(166002);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244506);
      p.h(paramc, "reason");
      super.d(paramc);
      if ((this.type == 5) && ((paramc.tXF instanceof bds)) && (paramc.Rmh != -1))
      {
        if (paramc.tXF == null)
        {
          paramc = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderTopicInfo");
          AppMethodBeat.o(244506);
          throw paramc;
        }
        paramc = this.gte.findViewById(2131300111);
        p.g(paramc, "context.findViewById<FrameLayout>(R.id.empty_view)");
        ((FrameLayout)paramc).setVisibility(8);
        paramc = this.gte.findViewById(2131306281);
        p.g(paramc, "context.findViewById<ProgressBar>(R.id.progress)");
        ((ProgressBar)paramc).setVisibility(8);
      }
      AppMethodBeat.o(244506);
    }
    
    public final View getEmptyView()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract
 * JD-Core Version:    0.7.0.1
 */