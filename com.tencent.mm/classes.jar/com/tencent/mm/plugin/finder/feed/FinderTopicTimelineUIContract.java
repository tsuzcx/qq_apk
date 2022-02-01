package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bv;
import com.tencent.mm.plugin.finder.feed.component.a.f;
import com.tencent.mm.plugin.finder.feed.component.a.g;
import com.tencent.mm.plugin.finder.feed.component.a.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.live.component.y;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract;", "", "()V", "Companion", "Loader", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class FinderTopicTimelineUIContract
{
  public static final a xEF;
  
  static
  {
    AppMethodBeat.i(166004);
    xEF = new a((byte)0);
    AppMethodBeat.o(166004);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "topicId", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;JLcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "encryptedTopicId", "getEncryptedTopicId", "setEncryptedTopicId", "eventTopicId", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "groupId", "getGroupId", "setGroupId", "hotTopicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getHotTopicBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setHotTopicBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "innerTabType", "getInnerTabType", "()I", "setInnerTabType", "(I)V", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedTopic", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getRelatedTopic", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setRelatedTopic", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTopic", "getTopicId", "getType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FinderTopicTimelineResponse", "TopicTimelineDataFetcher", "plugin-finder_release"})
  public static final class Loader
    extends BaseFinderFeedLoader
  {
    private String TAG;
    public String groupId;
    final bdm location;
    public long refObjectId;
    final String topic;
    public final int type;
    String xEG;
    public com.tencent.mm.cd.b xEH;
    public kotlin.g.a.a<x> xEI;
    public dwb xEJ;
    public int xEw;
    final biv xcZ;
    public long xdR;
    final long xee;
    
    public Loader(int paramInt, String paramString, long paramLong, bdm parambdm, com.tencent.mm.plugin.finder.feed.model.internal.g paramg, biv parambiv, bid parambid)
    {
      super();
      AppMethodBeat.i(290166);
      this.type = paramInt;
      this.topic = paramString;
      this.xee = paramLong;
      this.location = parambdm;
      this.xcZ = parambiv;
      this.xEG = "";
      this.TAG = "Finder.FinderTopicTimelineLoader";
      AppMethodBeat.o(290166);
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.i<bu> createDataFetch()
    {
      AppMethodBeat.i(290159);
      com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new b();
      AppMethodBeat.o(290159);
      return locali;
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
    {
      AppMethodBeat.i(290161);
      com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
      AppMethodBeat.o(290161);
      return locald;
    }
    
    public final String getTAG()
    {
      return this.TAG;
    }
    
    public final void onFetchDone(IResponse<bu> paramIResponse)
    {
      AppMethodBeat.i(165995);
      p.k(paramIResponse, "response");
      super.onFetchDone(paramIResponse);
      if (isInitOperation(paramIResponse))
      {
        AppMethodBeat.o(165995);
        return;
      }
      if (!paramIResponse.getHasMore())
      {
        paramIResponse = this.xEI;
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
      p.k(paramString, "<set-?>");
      this.TAG = paramString;
      AppMethodBeat.o(165993);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$FinderTopicTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "totalCount", "", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "errType", "", "errCode", "errMsg", "", "(JLcom/tencent/mm/protocal/protobuf/FinderTopicInfo;IILjava/lang/String;)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTotalCount", "()J", "plugin-finder_release"})
    public static final class a
      extends IResponse<bu>
    {
      final bkr fGc;
      private final long xEc;
      
      public a(long paramLong, bkr parambkr, int paramInt1, int paramInt2, String paramString)
      {
        super(paramInt2, paramString);
        this.xEc = paramLong;
        this.fGc = parambkr;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$TopicTimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$FinderTopicTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b
      extends com.tencent.mm.plugin.finder.feed.model.internal.c
    {
      public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
      {
        AppMethodBeat.i(280889);
        p.k(paramq, "scene");
        bv localbv = (bv)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0) && (localbv.doo() == 0)) {}
        FinderTopicTimelineUIContract.Loader.a locala;
        for (boolean bool = false;; bool = true)
        {
          locala = new FinderTopicTimelineUIContract.Loader.a(localbv.dox(), localbv.doy(), paramInt1, paramInt2, paramString);
          paramq = (Iterable)((bv)paramq).dow();
          paramString = (Collection)new ArrayList(j.a(paramq, 10));
          paramq = paramq.iterator();
          while (paramq.hasNext())
          {
            localObject1 = (FinderObject)paramq.next();
            Object localObject2 = FinderItem.Companion;
            localObject1 = FinderItem.a.b((FinderObject)localObject1, 64);
            localObject2 = FinderTopicFeedUI.xTd;
            ((Map)FinderTopicFeedUI.duS()).put(Long.valueOf(((FinderItem)localObject1).getId()), localObject1);
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            paramString.add(com.tencent.mm.plugin.finder.storage.logic.c.a.a((FinderItem)localObject1));
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
          locala.setPullType(localbv.pullType);
          locala.setLastBuffer(localbv.don());
          locala.setHasMore(bool);
          paramString = (IResponse)locala;
          AppMethodBeat.o(280889);
          return paramString;
        }
      }
      
      public final com.tencent.mm.an.q genLoadMoreNetScene()
      {
        AppMethodBeat.i(280888);
        Object localObject;
        switch (this.xEK.type)
        {
        case 3: 
        case 6: 
        default: 
          localObject = null;
        }
        for (;;)
        {
          localObject = (com.tencent.mm.an.q)localObject;
          AppMethodBeat.o(280888);
          return localObject;
          localObject = new bv(this.xEK.topic, Long.valueOf(this.xEK.refObjectId), this.xEK.getLastBuffer(), this.xEK.xcZ, this.xEK.getContextObj(), (byte)0);
          ((bv)localObject).pullType = 2;
          continue;
          String str = this.xEK.location.SOz;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localObject = new bv((String)localObject, this.xEK.location.longitude, this.xEK.location.latitude, Long.valueOf(this.xEK.refObjectId), this.xEK.getLastBuffer(), this.xEK.xEJ, this.xEK.xcZ, this.xEK.getContextObj());
          ((bv)localObject).pullType = 2;
          continue;
          str = this.xEK.groupId;
          localObject = str;
          if (str == null) {
            localObject = com.tencent.mm.ae.d.Fw(this.xEK.refObjectId);
          }
          localObject = new bv((String)localObject, Long.valueOf(this.xEK.refObjectId), this.xEK.getLastBuffer(), this.xEK.xcZ, this.xEK.getContextObj());
          ((bv)localObject).pullType = 2;
          continue;
          localObject = new bv(this.xEK.xdR, Long.valueOf(this.xEK.refObjectId), this.xEK.xEG, this.xEK.xEw, this.xEK.getLastBuffer(), this.xEK.getContextObj());
          ((bv)localObject).pullType = 2;
          continue;
          localObject = new bv(this.xEK.topic, this.xEK.xee, this.xEK.xEH, Long.valueOf(this.xEK.refObjectId), this.xEK.getLastBuffer(), this.xEK.xcZ, this.xEK.getContextObj());
          ((bv)localObject).pullType = 2;
        }
      }
      
      public final com.tencent.mm.an.q genRefreshNetScene()
      {
        AppMethodBeat.i(280887);
        if (this.xEK.type == 5)
        {
          com.tencent.mm.an.q localq = (com.tencent.mm.an.q)new bv(this.xEK.topic, this.xEK.xee, this.xEK.xEH, Long.valueOf(this.xEK.refObjectId), this.xEK.type, this.xEK.getContextObj());
          AppMethodBeat.o(280887);
          return localq;
        }
        AppMethodBeat.o(280887);
        return null;
      }
      
      public final List<Integer> getCmdIds()
      {
        AppMethodBeat.i(280886);
        List localList = j.listOf(Integer.valueOf(817));
        AppMethodBeat.o(280886);
        return localList;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class c
      extends BaseFeedLoader<bu>.a
    {
      c()
      {
        super();
      }
      
      public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
      {
        AppMethodBeat.i(279102);
        p.k(paramIResponse, "response");
        Object localObject = RefreshLoadMoreLayout.c.YNO;
        localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihs());
        if (((paramIResponse instanceof FinderTopicTimelineUIContract.Loader.a)) && (this.xEK.type == 5)) {
          ((RefreshLoadMoreLayout.c)localObject).xJA = ((FinderTopicTimelineUIContract.Loader.a)paramIResponse).fGc;
        }
        if (paramIResponse.getHasMore()) {}
        for (int i = 2;; i = 6)
        {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
          AppMethodBeat.o(279102);
          return;
        }
      }
      
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<x>
      {
        a(FinderTopicTimelineUIContract.Loader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
        {
          super();
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion;", "", "()V", "getActionScene", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "", "type", "", "plugin-finder_release"})
  public static final class a
  {
    public static com.tencent.mm.vending.j.c<s.t, String> MC(int paramInt)
    {
      AppMethodBeat.i(288219);
      s.t localt = s.t.yGN;
      Object localObject = "27";
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.nr(true);
      if (2 == paramInt)
      {
        localt = s.t.yGN;
        localObject = "27";
        locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.nr(true);
      }
      for (;;)
      {
        localObject = com.tencent.mm.vending.j.a.J(localt, localObject);
        p.j(localObject, "Tuple.make(action, scene)");
        AppMethodBeat.o(288219);
        return localObject;
        if (1 == paramInt)
        {
          localt = s.t.yGO;
          localObject = "9";
          locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.nr(false);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "type", "(Lcom/tencent/mm/ui/MMActivity;II)V", "activityCreatorFinderName", "", "getActivityCreatorFinderName", "()Ljava/lang/String;", "setActivityCreatorFinderName", "(Ljava/lang/String;)V", "activityFeedHandler", "Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "removeEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "getRemoveEvent", "()Lcom/tencent/mm/sdk/event/IListener;", "setRemoveEvent", "(Lcom/tencent/mm/sdk/event/IListener;)V", "getScene", "()I", "getType", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "from", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isCreator", "", "isFinderSelfScene", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "requestRefresh", "Companion", "plugin-finder_release"})
  public static final class b
    extends aa.a
  {
    public static final a xEO;
    private final int scene;
    private final int type;
    private final com.tencent.mm.plugin.finder.feed.component.a xEM;
    private String xEN;
    private IListener<f> xEe;
    private final com.tencent.mm.plugin.finder.feed.model.i xve;
    private final com.tencent.mm.plugin.finder.feed.model.k xvf;
    
    static
    {
      AppMethodBeat.i(263774);
      xEO = new a((byte)0);
      AppMethodBeat.o(263774);
    }
    
    public b(MMActivity paramMMActivity, int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(263773);
      this.scene = paramInt1;
      this.type = paramInt2;
      this.xEM = new com.tencent.mm.plugin.finder.feed.component.a();
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      this.xve = ((com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramMMActivity).i(com.tencent.mm.plugin.finder.viewmodel.component.l.class)).xve;
      localg = com.tencent.mm.ui.component.g.Xox;
      this.xvf = ((y)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramMMActivity).i(y.class)).yci;
      AppMethodBeat.o(263773);
    }
    
    private final boolean due()
    {
      AppMethodBeat.i(263771);
      if ((!Util.isNullOrNil(this.xEN)) && (p.h(this.xEN, z.bdh())))
      {
        AppMethodBeat.o(263771);
        return true;
      }
      AppMethodBeat.o(263771);
      return false;
    }
    
    public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, aa.b paramb)
    {
      AppMethodBeat.i(178281);
      p.k(paramBaseFinderFeedLoader, "model");
      p.k(paramb, "callback");
      super.a(paramBaseFinderFeedLoader, paramb);
      this.xve.a(this.scene, this.xkX, (kotlin.g.a.b)new b(this));
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.a(paramBaseFinderFeedLoader);
        if (paramBaseFinderFeedLoader != null) {
          paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.xve);
        }
      }
      paramBaseFinderFeedLoader = this.xEM;
      h.aGY().a(5909, (com.tencent.mm.an.i)paramBaseFinderFeedLoader);
      this.xEM.xnX = this.xnX;
      paramb = this.xvf;
      m localm = (m)new c(this);
      paramBaseFinderFeedLoader = this.xvC;
      if (paramBaseFinderFeedLoader != null) {}
      for (paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.xvJ.getRecyclerView();; paramBaseFinderFeedLoader = null)
      {
        paramb.a(localm, paramBaseFinderFeedLoader);
        if (this.type == 7)
        {
          this.xEM.xEZ = this.iXq.getIntent().getIntExtra("key_activity_max_top_count", 3);
          this.xEN = this.iXq.getIntent().getStringExtra("key_creator_finder_name");
          this.xEe = ((IListener)new d(this));
          paramBaseFinderFeedLoader = this.xEe;
          if (paramBaseFinderFeedLoader != null) {
            paramBaseFinderFeedLoader.alive();
          }
        }
        paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
        if (paramBaseFinderFeedLoader == null) {
          break;
        }
        paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.a(paramBaseFinderFeedLoader);
        if (paramBaseFinderFeedLoader == null) {
          break;
        }
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.xvf);
        AppMethodBeat.o(178281);
        return;
      }
      AppMethodBeat.o(178281);
    }
    
    public final void a(BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.i parami)
    {
      AppMethodBeat.i(263772);
      p.k(paramBaseFinderFeed, "feed");
      p.k(paramMenuItem, "menuItem");
      p.k(parami, "holder");
      int i = paramMenuItem.getItemId();
      if (i == 5001)
      {
        paramMenuItem = this.xEM;
        parami = (Context)this.iXq;
        p.k(parami, "context");
        p.k(paramBaseFinderFeed, "feed");
        if (paramMenuItem.wXa == null)
        {
          e locale = new e(parami, 1, true);
          locale.j((CharSequence)parami.getResources().getString(b.j.finder_activity_remove_feed_hint), 17, parami.getResources().getDimensionPixelSize(b.d.SmallestTextSize));
          locale.a((q.f)new a.f(paramMenuItem, parami, paramBaseFinderFeed));
          locale.a((q.g)new a.g(paramMenuItem, parami, paramBaseFinderFeed));
          locale.b((e.b)new a.h(paramMenuItem, parami, paramBaseFinderFeed));
          paramMenuItem.wXa = locale;
        }
        paramBaseFinderFeed = paramMenuItem.wXa;
        if (paramBaseFinderFeed != null)
        {
          if (!paramBaseFinderFeed.isShowing()) {
            paramBaseFinderFeed.eik();
          }
          AppMethodBeat.o(263772);
          return;
        }
        AppMethodBeat.o(263772);
        return;
      }
      if (i == 5002)
      {
        this.xEM.a((Context)this.iXq, true, paramBaseFinderFeed);
        AppMethodBeat.o(263772);
        return;
      }
      if (i == 5003)
      {
        this.xEM.a((Context)this.iXq, false, paramBaseFinderFeed);
        AppMethodBeat.o(263772);
        return;
      }
      if (i == this.xvk)
      {
        if (this.type == 7)
        {
          paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (paramBaseFinderFeed != null)
          {
            paramBaseFinderFeed = paramBaseFinderFeed.event;
            if (paramBaseFinderFeed == null) {}
          }
          for (long l = paramBaseFinderFeed.xdR;; l = 0L)
          {
            paramBaseFinderFeed = com.tencent.mm.plugin.finder.feed.logic.a.xFq;
            com.tencent.mm.plugin.finder.feed.logic.a.i((Context)this.iXq, l);
            AppMethodBeat.o(263772);
            return;
          }
        }
        super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, parami);
        AppMethodBeat.o(263772);
        return;
      }
      super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, parami);
      AppMethodBeat.o(263772);
    }
    
    public final void a(BaseFinderFeed paramBaseFinderFeed, o paramo, e parame)
    {
      AppMethodBeat.i(263770);
      p.k(paramBaseFinderFeed, "feed");
      p.k(paramo, "menu");
      p.k(parame, "sheet");
      if (this.type == 7)
      {
        if (due())
        {
          if (paramBaseFinderFeed.feedObject.isPostFinish()) {
            paramo.b(5001, (CharSequence)this.iXq.getString(b.j.finder_activity_remove_feed), b.i.icons_outlined_remove_from_list);
          }
          parame = this.xnX;
          if (parame == null)
          {
            paramBaseFinderFeed = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader");
            AppMethodBeat.o(263770);
            throw paramBaseFinderFeed;
          }
          if (((FinderTopicTimelineUIContract.Loader)parame).xEw == 1) {
            com.tencent.mm.plugin.finder.feed.component.a.a((Context)this.iXq, paramBaseFinderFeed, paramo);
          }
        }
        parame = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (!com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed))
        {
          paramo.b(this.xvk, (CharSequence)this.iXq.getString(b.j.more_menu_back), b.i.icons_outlined_report_problem);
          AppMethodBeat.o(263770);
        }
      }
      else
      {
        super.a(paramBaseFinderFeed, paramo, parame);
      }
      AppMethodBeat.o(263770);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(263768);
      p.k(paramc, "reason");
      super.a(paramc);
      if ((this.xvC instanceof FinderTopicTimelineUIContract.c))
      {
        Object localObject = this.xvC;
        if (localObject == null)
        {
          paramc = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.ViewCallback");
          AppMethodBeat.o(263768);
          throw paramc;
        }
        localObject = (FinderTopicTimelineUIContract.c)localObject;
        p.k(paramc, "reason");
        if ((((FinderTopicTimelineUIContract.c)localObject).dsA()) && (paramc.YNF))
        {
          paramc = ((b.b)localObject).xvJ.getRecyclerView();
          if (((FinderTopicTimelineUIContract.c)localObject).dsA())
          {
            RecyclerView.LayoutManager localLayoutManager = paramc.getLayoutManager();
            if (localLayoutManager == null)
            {
              paramc = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
              AppMethodBeat.o(263768);
              throw paramc;
            }
            int i = ((FinderLinearLayoutManager)localLayoutManager).kJ() + 1;
            if (i < ((List)((FinderTopicTimelineUIContract.c)localObject).getAdapter().data).size()) {
              paramc.post((Runnable)new FinderTopicTimelineUIContract.c.a(paramc, i));
            }
          }
        }
      }
      AppMethodBeat.o(263768);
    }
    
    public final void byN()
    {
      AppMethodBeat.i(166000);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestLoadMore();
        AppMethodBeat.o(166000);
        return;
      }
      AppMethodBeat.o(166000);
    }
    
    public final boolean dsp()
    {
      AppMethodBeat.i(263764);
      if (this.type == 7)
      {
        bool = due();
        AppMethodBeat.o(263764);
        return bool;
      }
      boolean bool = super.dsp();
      AppMethodBeat.o(263764);
      return bool;
    }
    
    public final void dst()
    {
      AppMethodBeat.i(263767);
      super.dst();
      Object localObject1 = FinderTopicTimelineUIContract.xEF;
      Object localObject2 = FinderTopicTimelineUIContract.a.MC(this.type);
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
      localObject1 = this.xvC;
      if (localObject1 != null) {}
      for (localObject1 = ((b.b)localObject1).xvJ.getRecyclerView();; localObject1 = null)
      {
        Object localObject3 = ((com.tencent.mm.vending.j.c)localObject2).ieT();
        p.j(localObject3, "tuple2.`$1`()");
        localObject3 = (s.t)localObject3;
        localObject2 = ((com.tencent.mm.vending.j.c)localObject2).ieU();
        p.j(localObject2, "tuple2.`$2`()");
        com.tencent.mm.plugin.finder.live.report.k.b((RecyclerView)localObject1, (s.t)localObject3, (String)localObject2, com.tencent.mm.plugin.finder.live.report.c.yAk);
        AppMethodBeat.o(263767);
        return;
      }
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(178282);
      this.xve.onDetach();
      Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject = aj.a.fZ((Context)this.iXq);
      if (localObject != null)
      {
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.xve);
        }
      }
      localObject = this.xEM;
      h.aGY().b(5909, (com.tencent.mm.an.i)localObject);
      this.xvf.onDetach();
      localObject = this.xEe;
      if (localObject != null) {
        ((IListener)localObject).dead();
      }
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject = aj.a.fZ((Context)this.iXq);
      if (localObject != null)
      {
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.xvf);
        }
      }
      super.onDetach();
      AppMethodBeat.o(178282);
    }
    
    public final void requestRefresh()
    {
      AppMethodBeat.i(165999);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestRefresh();
        AppMethodBeat.o(165999);
        return;
      }
      AppMethodBeat.o(165999);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$Companion;", "", "()V", "CANCEL_TOP_PLACE_ACTIVITY", "", "REMOVE_FROM_ACTIVITY", "TOP_PLACE_ACTIVITY", "plugin-finder_release"})
    public static final class a {}
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Integer, bu>
    {
      b(FinderTopicTimelineUIContract.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements m<Integer, Integer, LinkedList<bu>>
    {
      c(FinderTopicTimelineUIContract.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$onAttach$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class d
      extends IListener<f>
    {
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$onAttach$3$callback$1$1"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<x>
      {
        a(FinderTopicTimelineUIContract.b.d paramd, f paramf)
        {
          super();
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;II)V", "topicHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "type", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onLoadMoreError", "onRefreshError", "onViewCallPreFinishRefresh", "smoothScrollToNextPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
  public static final class c
    extends aa.b
  {
    private int type;
    private ad xEr;
    
    public c(MMActivity paramMMActivity, FinderTopicTimelineUIContract.b paramb, int paramInt1, int paramInt2)
    {
      super((aa.a)paramb, paramInt1, paramInt2);
      AppMethodBeat.i(166003);
      AppMethodBeat.o(166003);
    }
    
    public final void aa(ArrayList<bu> paramArrayList)
    {
      AppMethodBeat.i(166002);
      p.k(paramArrayList, "data");
      super.aa(paramArrayList);
      paramArrayList = this.xvJ;
      Object localObject = com.tencent.mm.ui.ad.kS((Context)this.iXq).inflate(b.g.load_more_footer, null);
      p.j(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramArrayList.setLoadMoreFooter((View)localObject);
      if (dsA())
      {
        paramArrayList = this.xvJ.getLoadMoreFooter();
        if (paramArrayList != null)
        {
          localObject = paramArrayList.getContext();
          p.j(localObject, "context");
          int i = ((Context)localObject).getResources().getColor(b.c.White);
          localObject = (TextView)paramArrayList.findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setTextColor(i);
          }
          localObject = paramArrayList.findViewById(b.f.center_icon);
          if (localObject != null) {
            ((View)localObject).setBackgroundColor(i);
          }
          localObject = paramArrayList.findViewById(b.f.left_icon);
          if (localObject != null) {
            ((View)localObject).setBackgroundColor(i);
          }
          paramArrayList = paramArrayList.findViewById(b.f.right_icon);
          if (paramArrayList != null) {
            paramArrayList.setBackgroundColor(i);
          }
        }
      }
      this.type = this.iXq.getIntent().getIntExtra("key_topic_type", 0);
      if (this.type == 5)
      {
        this.xEr = new ad(this.iXq, this.xvJ);
        paramArrayList = this.iXq.findViewById(b.f.empty_view);
        p.j(paramArrayList, "context.findViewById<FrameLayout>(R.id.empty_view)");
        ((FrameLayout)paramArrayList).setVisibility(0);
        paramArrayList = this.iXq.findViewById(b.f.progress);
        p.j(paramArrayList, "context.findViewById<ProgressBar>(R.id.progress)");
        ((ProgressBar)paramArrayList).setVisibility(0);
      }
      AppMethodBeat.o(166002);
    }
    
    public final View getEmptyView()
    {
      return null;
    }
    
    public final void h(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(275753);
      p.k(paramc, "reason");
      super.h(paramc);
      if ((this.type == 5) && ((paramc.xJA instanceof bkr)) && (paramc.YND != -1))
      {
        if (paramc.xJA == null)
        {
          paramc = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderTopicInfo");
          AppMethodBeat.o(275753);
          throw paramc;
        }
        paramc = this.iXq.findViewById(b.f.empty_view);
        p.j(paramc, "context.findViewById<FrameLayout>(R.id.empty_view)");
        ((FrameLayout)paramc).setVisibility(8);
        paramc = this.iXq.findViewById(b.f.progress);
        p.j(paramc, "context.findViewById<ProgressBar>(R.id.progress)");
        ((ProgressBar)paramc).setVisibility(8);
      }
      AppMethodBeat.o(275753);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RecyclerView paramRecyclerView, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(287780);
        RecyclerView localRecyclerView = this.xmk;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.xAW, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        localRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        AppMethodBeat.o(287780);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract
 * JD-Core Version:    0.7.0.1
 */