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
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.finder.cgi.ct;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ar;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract;", "", "()V", "Companion", "Loader", "Presenter", "ViewCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTopicTimelineUIContract
{
  public static final a Bby;
  
  static
  {
    AppMethodBeat.i(166004);
    Bby = new a((byte)0);
    AppMethodBeat.o(166004);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "topicId", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;JLcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "encryptedTopicId", "getEncryptedTopicId", "setEncryptedTopicId", "eventTopicId", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "groupId", "getGroupId", "setGroupId", "hotTopicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getHotTopicBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setHotTopicBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "innerTabType", "getInnerTabType", "()I", "setInnerTabType", "(I)V", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedTopic", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getRelatedTopic", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setRelatedTopic", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTopic", "getTopicId", "getType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FinderTopicTimelineResponse", "TopicTimelineDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Loader
    extends BaseFinderFeedLoader
  {
    final bve ACr;
    final long ADo;
    public com.tencent.mm.bx.b BbA;
    public kotlin.g.a.a<kotlin.ah> BbB;
    public epc BbC;
    public int Bbt;
    String Bbz;
    private String TAG;
    public String groupId;
    final boi location;
    public long ocD;
    public long refObjectId;
    final String topic;
    public final int type;
    
    public Loader(int paramInt, String paramString, long paramLong, boi paramboi, com.tencent.mm.plugin.finder.feed.model.internal.g paramg, bve parambve, bui parambui)
    {
      super();
      AppMethodBeat.i(363912);
      this.type = paramInt;
      this.topic = paramString;
      this.ADo = paramLong;
      this.location = paramboi;
      this.ACr = parambve;
      this.Bbz = "";
      this.TAG = "Finder.FinderTopicTimelineLoader";
      AppMethodBeat.o(363912);
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.i<cc> createDataFetch()
    {
      AppMethodBeat.i(363916);
      com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new b();
      AppMethodBeat.o(363916);
      return locali;
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
    {
      AppMethodBeat.i(363920);
      com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
      AppMethodBeat.o(363920);
      return locald;
    }
    
    public final String getTAG()
    {
      return this.TAG;
    }
    
    public final void onFetchDone(IResponse<cc> paramIResponse)
    {
      AppMethodBeat.i(165995);
      kotlin.g.b.s.u(paramIResponse, "response");
      super.onFetchDone(paramIResponse);
      Object localObject = k.aeZF;
      localObject = (com.tencent.mm.plugin.finder.feed.jumper.i)k.cn(cn.class).q(com.tencent.mm.plugin.finder.feed.jumper.i.class);
      List localList = paramIResponse.getIncrementList();
      bui localbui = getContextObj();
      if (localbui == null) {}
      for (int i = 0;; i = localbui.AJo)
      {
        ((com.tencent.mm.plugin.finder.feed.jumper.i)localObject).D(localList, i);
        if (!isInitOperation(paramIResponse)) {
          break;
        }
        AppMethodBeat.o(165995);
        return;
      }
      if (!paramIResponse.getHasMore())
      {
        paramIResponse = this.BbB;
        if (paramIResponse != null) {
          paramIResponse.invoke();
        }
      }
      AppMethodBeat.o(165995);
    }
    
    public final void setTAG(String paramString)
    {
      AppMethodBeat.i(165993);
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.TAG = paramString;
      AppMethodBeat.o(165993);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$FinderTopicTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "totalCount", "", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "errType", "", "errCode", "errMsg", "", "(JLcom/tencent/mm/protocal/protobuf/FinderTopicInfo;IILjava/lang/String;)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTotalCount", "()J", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends IResponse<cc>
    {
      private final long Bbb;
      final bxv hLt;
      
      public a(long paramLong, bxv parambxv, int paramInt1, int paramInt2, String paramString)
      {
        super(paramInt2, paramString);
        this.Bbb = paramLong;
        this.hLt = parambxv;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$TopicTimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$FinderTopicTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class b
      extends com.tencent.mm.plugin.finder.feed.model.internal.c
    {
      public b()
      {
        AppMethodBeat.i(362855);
        AppMethodBeat.o(362855);
      }
      
      public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
      {
        AppMethodBeat.i(362898);
        kotlin.g.b.s.u(paramp, "scene");
        ct localct = (ct)paramp;
        if ((paramInt1 == 0) && (paramInt2 == 0) && (localct.dVZ() == 0)) {}
        FinderTopicTimelineUIContract.Loader.a locala;
        for (boolean bool = false;; bool = true)
        {
          locala = new FinderTopicTimelineUIContract.Loader.a(localct.dWi(), localct.dWj(), paramInt1, paramInt2, paramString);
          paramp = (Iterable)((ct)paramp).dVW();
          paramString = (Collection)new ArrayList(kotlin.a.p.a(paramp, 10));
          paramp = paramp.iterator();
          while (paramp.hasNext())
          {
            Object localObject1 = (FinderObject)paramp.next();
            Object localObject2 = FinderItem.Companion;
            localObject1 = FinderItem.a.e((FinderObject)localObject1, 64);
            localObject2 = FinderTopicFeedUI.Bst;
            ((Map)FinderTopicFeedUI.eeA()).put(Long.valueOf(((FinderItem)localObject1).getId()), localObject1);
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            paramString.add(d.a.a((FinderItem)localObject1));
          }
        }
        locala.setIncrementList((List)paramString);
        paramp = getTAG();
        paramString = locala.getIncrementList();
        if (paramString == null) {}
        for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
        {
          Log.i(paramp, kotlin.g.b.s.X("incrementList size: ", paramString));
          locala.setPullType(localct.pullType);
          locala.setLastBuffer(localct.dVY());
          locala.setHasMore(bool);
          paramString = (IResponse)locala;
          AppMethodBeat.o(362898);
          return paramString;
        }
      }
      
      public final com.tencent.mm.am.p genLoadMoreNetScene()
      {
        AppMethodBeat.i(362884);
        Object localObject;
        switch (this.BbD.type)
        {
        case 3: 
        case 6: 
        default: 
          localObject = null;
        }
        for (;;)
        {
          localObject = (com.tencent.mm.am.p)localObject;
          AppMethodBeat.o(362884);
          return localObject;
          localObject = new ct(this.BbD.topic, Long.valueOf(this.BbD.refObjectId), this.BbD.getLastBuffer(), this.BbD.ACr, this.BbD.getContextObj(), (byte)0);
          ((ct)localObject).pullType = 2;
          continue;
          String str = this.BbD.location.ZWG;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localObject = new ct((String)localObject, this.BbD.location.longitude, this.BbD.location.latitude, Long.valueOf(this.BbD.refObjectId), this.BbD.getLastBuffer(), this.BbD.BbC, this.BbD.ACr, this.BbD.getContextObj());
          ((ct)localObject).pullType = 2;
          continue;
          str = this.BbD.groupId;
          localObject = str;
          if (str == null) {
            localObject = com.tencent.mm.ae.d.hF(this.BbD.refObjectId);
          }
          localObject = new ct((String)localObject, Long.valueOf(this.BbD.refObjectId), this.BbD.getLastBuffer(), this.BbD.ACr, this.BbD.getContextObj());
          ((ct)localObject).pullType = 2;
          continue;
          localObject = new ct(this.BbD.ocD, Long.valueOf(this.BbD.refObjectId), this.BbD.Bbz, this.BbD.Bbt, this.BbD.getLastBuffer(), this.BbD.getContextObj());
          ((ct)localObject).pullType = 2;
          continue;
          localObject = new ct(this.BbD.topic, this.BbD.ADo, this.BbD.BbA, Long.valueOf(this.BbD.refObjectId), this.BbD.getLastBuffer(), this.BbD.ACr, this.BbD.getContextObj(), (byte)0);
          ((ct)localObject).pullType = 2;
        }
      }
      
      public final com.tencent.mm.am.p genRefreshNetScene()
      {
        AppMethodBeat.i(362870);
        if (this.BbD.type == 5)
        {
          com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new ct(this.BbD.topic, this.BbD.ADo, this.BbD.BbA, Long.valueOf(this.BbD.refObjectId), this.BbD.type, this.BbD.getContextObj(), (byte)0);
          AppMethodBeat.o(362870);
          return localp;
        }
        AppMethodBeat.o(362870);
        return null;
      }
      
      public final List<Integer> getCmdIds()
      {
        AppMethodBeat.i(362860);
        List localList = kotlin.a.p.listOf(Integer.valueOf(817));
        AppMethodBeat.o(362860);
        return localList;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      extends BaseFeedLoader<cc>.a
    {
      c(FinderTopicTimelineUIContract.Loader paramLoader)
      {
        super(false, 1, null);
        AppMethodBeat.i(362857);
        AppMethodBeat.o(362857);
      }
      
      public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, kotlin.ah> paramb)
      {
        AppMethodBeat.i(362871);
        kotlin.g.b.s.u(paramIResponse, "response");
        Object localObject = RefreshLoadMoreLayout.d.agJr;
        localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMG());
        if (((paramIResponse instanceof FinderTopicTimelineUIContract.Loader.a)) && (this.BbD.type == 5)) {
          ((RefreshLoadMoreLayout.d)localObject).extraData = ((FinderTopicTimelineUIContract.Loader.a)paramIResponse).hLt;
        }
        if (paramIResponse.getHasMore()) {}
        for (int i = 2;; i = 6)
        {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, new r(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.d)localObject, this.BbD, paramb, paramIResponse));
          AppMethodBeat.o(362871);
          return;
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<kotlin.ah>
      {
        a(FinderTopicTimelineUIContract.Loader.c paramc, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderTopicTimelineUIContract.Loader paramLoader, kotlin.g.a.b<? super IResponse<cc>, kotlin.ah> paramb, IResponse<cc> paramIResponse)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class Presenter$onAttach$3$a
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    Presenter$onAttach$3$a(com.tencent.mm.autogen.a.g paramg, FinderTopicTimelineUIContract.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion;", "", "()V", "getActionScene", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static com.tencent.mm.vending.j.c<q.w, String> NL(int paramInt)
    {
      AppMethodBeat.i(363268);
      q.w localw = q.w.DwP;
      Object localObject = "27";
      c.a locala = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.oR(true);
      if (2 == paramInt)
      {
        localw = q.w.DwP;
        localObject = "27";
        locala = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.oR(true);
      }
      for (;;)
      {
        localObject = com.tencent.mm.vending.j.a.U(localw, localObject);
        kotlin.g.b.s.s(localObject, "make(action, scene)");
        AppMethodBeat.o(363268);
        return localObject;
        if (1 == paramInt)
        {
          localw = q.w.DwQ;
          localObject = "9";
          locala = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.oR(false);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "type", "(Lcom/tencent/mm/ui/MMActivity;II)V", "activityCreatorFinderName", "", "getActivityCreatorFinderName", "()Ljava/lang/String;", "setActivityCreatorFinderName", "(Ljava/lang/String;)V", "activityFeedHandler", "Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "removeEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "getRemoveEvent", "()Lcom/tencent/mm/sdk/event/IListener;", "setRemoveEvent", "(Lcom/tencent/mm/sdk/event/IListener;)V", "getScene", "()I", "getType", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "from", "isCreator", "", "isFinderSelfScene", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "requestRefresh", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ae.a
  {
    public static final a BbG;
    private final com.tencent.mm.plugin.finder.feed.model.i Aye;
    private final com.tencent.mm.plugin.findersdk.a.as Ayf;
    private final com.tencent.mm.plugin.finder.feed.component.a BbH;
    private String BbI;
    private IListener<com.tencent.mm.autogen.a.g> Bbd;
    private final int scene;
    private final int type;
    
    static
    {
      AppMethodBeat.i(363279);
      BbG = new a((byte)0);
      AppMethodBeat.o(363279);
    }
    
    public b(MMActivity paramMMActivity, int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(363267);
      this.scene = paramInt1;
      this.type = paramInt2;
      this.BbH = new com.tencent.mm.plugin.finder.feed.component.a();
      k localk = k.aeZF;
      this.Aye = ((com.tencent.mm.plugin.finder.viewmodel.component.j)k.d((AppCompatActivity)paramMMActivity).q(com.tencent.mm.plugin.finder.viewmodel.component.j.class)).Aye;
      localk = k.aeZF;
      this.Ayf = ((ar)k.d((AppCompatActivity)paramMMActivity).cq(ar.class)).eiJ();
      AppMethodBeat.o(363267);
    }
    
    private final boolean ede()
    {
      AppMethodBeat.i(363273);
      if ((!Util.isNullOrNil(this.BbI)) && (kotlin.g.b.s.p(this.BbI, z.bAW())))
      {
        AppMethodBeat.o(363273);
        return true;
      }
      AppMethodBeat.o(363273);
      return false;
    }
    
    public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, ae.b paramb)
    {
      AppMethodBeat.i(178281);
      kotlin.g.b.s.u(paramBaseFinderFeedLoader, "model");
      kotlin.g.b.s.u(paramb, "callback");
      super.a(paramBaseFinderFeedLoader, paramb);
      this.Aye.a(this.scene, this.AJo, (kotlin.g.a.b)new b(this));
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
        if (paramBaseFinderFeedLoader != null) {
          paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
        }
      }
      paramBaseFinderFeedLoader = this.BbH;
      com.tencent.mm.kernel.h.aZW().a(5909, (com.tencent.mm.am.h)paramBaseFinderFeedLoader);
      this.BbH.ALH = this.ALH;
      paramb = this.Ayf;
      m localm = (m)new c(this);
      paramBaseFinderFeedLoader = this.ATo;
      if (paramBaseFinderFeedLoader == null) {}
      for (paramBaseFinderFeedLoader = null;; paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.ATx.getRecyclerView())
      {
        paramb.a(localm, paramBaseFinderFeedLoader);
        if (this.type == 7)
        {
          this.BbH.BbV = this.lzt.getIntent().getIntExtra("key_activity_max_top_count", 3);
          this.BbI = this.lzt.getIntent().getStringExtra("key_creator_finder_name");
          this.Bbd = ((IListener)new FinderTopicTimelineUIContract.Presenter.onAttach.3(this, com.tencent.mm.app.f.hfK));
          paramBaseFinderFeedLoader = this.Bbd;
          if (paramBaseFinderFeedLoader != null) {
            paramBaseFinderFeedLoader.alive();
          }
        }
        paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
        if (paramBaseFinderFeedLoader != null)
        {
          paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
          if (paramBaseFinderFeedLoader != null) {
            paramBaseFinderFeedLoader.a(this.Ayf.edV());
          }
        }
        AppMethodBeat.o(178281);
        return;
      }
    }
    
    public final void a(BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(363347);
      kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
      kotlin.g.b.s.u(paramMenuItem, "menuItem");
      kotlin.g.b.s.u(paramj, "holder");
      int i = paramMenuItem.getItemId();
      if (i == 5001)
      {
        this.BbH.a((Context)this.lzt, paramBaseFinderFeed);
        AppMethodBeat.o(363347);
        return;
      }
      if (i == 5002)
      {
        this.BbH.a((Context)this.lzt, true, paramBaseFinderFeed);
        AppMethodBeat.o(363347);
        return;
      }
      if (i == 5003)
      {
        this.BbH.a((Context)this.lzt, false, paramBaseFinderFeed);
        AppMethodBeat.o(363347);
        return;
      }
      if (i == ebk())
      {
        if (this.type == 7)
        {
          paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          long l;
          if (paramBaseFinderFeed == null) {
            l = 0L;
          }
          for (;;)
          {
            paramBaseFinderFeed = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
            com.tencent.mm.plugin.finder.feed.logic.a.i((Context)this.lzt, l);
            AppMethodBeat.o(363347);
            return;
            paramBaseFinderFeed = paramBaseFinderFeed.event;
            if (paramBaseFinderFeed == null) {
              l = 0L;
            } else {
              l = paramBaseFinderFeed.ocD;
            }
          }
        }
        super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, paramj);
        AppMethodBeat.o(363347);
        return;
      }
      super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, paramj);
      AppMethodBeat.o(363347);
    }
    
    public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(363337);
      kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
      kotlin.g.b.s.u(params, "menu");
      kotlin.g.b.s.u(paramf, "sheet");
      kotlin.g.b.s.u(paramj, "holder");
      if (this.type == 7)
      {
        if (ede())
        {
          if (paramBaseFinderFeed.feedObject.isPostFinish()) {
            params.a(5001, (CharSequence)this.lzt.getString(e.h.finder_activity_remove_feed), e.g.icons_outlined_remove_from_list);
          }
          paramf = this.ALH;
          if (paramf == null)
          {
            paramBaseFinderFeed = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader");
            AppMethodBeat.o(363337);
            throw paramBaseFinderFeed;
          }
          if (((FinderTopicTimelineUIContract.Loader)paramf).Bbt == 1) {
            com.tencent.mm.plugin.finder.feed.component.a.a((Context)this.lzt, paramBaseFinderFeed, params);
          }
        }
        paramf = av.GiL;
        if (!av.e(paramBaseFinderFeed))
        {
          params.a(ebk(), (CharSequence)this.lzt.getString(e.h.more_menu_back), e.g.icons_outlined_report_problem);
          AppMethodBeat.o(363337);
        }
      }
      else
      {
        super.a(paramBaseFinderFeed, params, paramf, paramj);
      }
      AppMethodBeat.o(363337);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363329);
      kotlin.g.b.s.u(paramd, "reason");
      super.a(paramd);
      if ((this.ATo instanceof FinderTopicTimelineUIContract.c))
      {
        Object localObject = this.ATo;
        if (localObject == null)
        {
          paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.ViewCallback");
          AppMethodBeat.o(363329);
          throw paramd;
        }
        localObject = (FinderTopicTimelineUIContract.c)localObject;
        kotlin.g.b.s.u(paramd, "reason");
        if (paramd.agJu) {
          ((FinderTopicTimelineUIContract.c)localObject).t(((b.b)localObject).ATx.getRecyclerView());
        }
      }
      AppMethodBeat.o(363329);
    }
    
    public final void bXB()
    {
      AppMethodBeat.i(166000);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
      if (localBaseFinderFeedLoader != null) {
        BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localBaseFinderFeedLoader, false, 1, null);
      }
      AppMethodBeat.o(166000);
    }
    
    public final boolean ebw()
    {
      AppMethodBeat.i(363295);
      if (this.type == 7)
      {
        bool = ede();
        AppMethodBeat.o(363295);
        return bool;
      }
      boolean bool = super.ebw();
      AppMethodBeat.o(363295);
      return bool;
    }
    
    public final void eby()
    {
      AppMethodBeat.i(363324);
      super.eby();
      Object localObject1 = FinderTopicTimelineUIContract.Bby;
      Object localObject2 = FinderTopicTimelineUIContract.a.NL(this.type);
      ce localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
      localObject1 = this.ATo;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((b.b)localObject1).ATx.getRecyclerView())
      {
        Object localObject3 = ((com.tencent.mm.vending.j.b)localObject2).get(0);
        kotlin.g.b.s.s(localObject3, "tuple2.`$1`()");
        localObject3 = (q.w)localObject3;
        localObject2 = ((com.tencent.mm.vending.j.c)localObject2).get(1);
        kotlin.g.b.s.s(localObject2, "tuple2.`$2`()");
        localce.b((RecyclerView)localObject1, (q.w)localObject3, (String)localObject2, com.tencent.mm.plugin.finder.live.report.d.Dnh);
        AppMethodBeat.o(363324);
        return;
      }
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(178282);
      this.Aye.onDetach();
      Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject = as.a.hu((Context)this.lzt);
      if (localObject != null)
      {
        localObject = ((bn)localObject).Vm(-1);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
        }
      }
      localObject = this.BbH;
      com.tencent.mm.kernel.h.aZW().b(5909, (com.tencent.mm.am.h)localObject);
      this.Ayf.onDetach();
      localObject = this.Bbd;
      if (localObject != null) {
        ((IListener)localObject).dead();
      }
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject = as.a.hu((Context)this.lzt);
      if (localObject != null)
      {
        localObject = ((bn)localObject).Vm(-1);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject).b(this.Ayf.edV());
        }
      }
      super.onDetach();
      AppMethodBeat.o(178282);
    }
    
    public final void requestRefresh()
    {
      AppMethodBeat.i(165999);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.requestRefresh();
      }
      AppMethodBeat.o(165999);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$Companion;", "", "()V", "CANCEL_TOP_PLACE_ACTIVITY", "", "REMOVE_FROM_ACTIVITY", "TOP_PLACE_ACTIVITY", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<Integer, cc>
    {
      b(FinderTopicTimelineUIContract.b paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements m<Integer, Integer, LinkedList<cc>>
    {
      c(FinderTopicTimelineUIContract.b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;II)V", "topicHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "type", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onLoadMoreError", "onRefreshError", "onViewCallPreFinishRefresh", "smoothScrollToNextPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends ae.b
  {
    private ah Bbn;
    private int type;
    
    public c(MMActivity paramMMActivity, FinderTopicTimelineUIContract.b paramb, int paramInt1, int paramInt2)
    {
      super((ae.a)paramb, paramInt1, paramInt2);
      AppMethodBeat.i(166003);
      AppMethodBeat.o(166003);
    }
    
    private static final void l(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(363244);
      kotlin.g.b.s.u(paramRecyclerView, "$recyclerView");
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback", "smoothScrollToNextPosition$lambda-2", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback", "smoothScrollToNextPosition$lambda-2", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(363244);
    }
    
    public final void af(ArrayList<cc> paramArrayList)
    {
      AppMethodBeat.i(166002);
      kotlin.g.b.s.u(paramArrayList, "data");
      super.af(paramArrayList);
      paramArrayList = this.ATx;
      Object localObject = af.mU((Context)this.lzt).inflate(e.f.load_more_footer, null);
      kotlin.g.b.s.s(localObject, "getInflater(context).inf…t.load_more_footer, null)");
      paramArrayList.setLoadMoreFooter((View)localObject);
      paramArrayList = this.ATx.getLoadMoreFooter();
      if (paramArrayList != null)
      {
        int i = paramArrayList.getContext().getResources().getColor(e.b.White);
        localObject = (TextView)paramArrayList.findViewById(e.e.load_more_footer_tip_tv);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(i);
        }
        localObject = paramArrayList.findViewById(e.e.center_icon);
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(i);
        }
        localObject = paramArrayList.findViewById(e.e.left_icon);
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(i);
        }
        paramArrayList = paramArrayList.findViewById(e.e.right_icon);
        if (paramArrayList != null) {
          paramArrayList.setBackgroundColor(i);
        }
      }
      this.type = this.lzt.getIntent().getIntExtra("key_topic_type", 0);
      if (this.type == 5)
      {
        this.Bbn = new ah(this.lzt, this.ATx);
        ((FrameLayout)this.lzt.findViewById(e.e.empty_view)).setVisibility(0);
        ((ProgressBar)this.lzt.findViewById(e.e.progress)).setVisibility(0);
      }
      AppMethodBeat.o(166002);
    }
    
    public final View getEmptyView()
    {
      return null;
    }
    
    public final void j(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363272);
      kotlin.g.b.s.u(paramd, "reason");
      super.j(paramd);
      if ((this.type == 5) && ((paramd.extraData instanceof bxv)) && (paramd.agJs != -1))
      {
        if (paramd.extraData == null)
        {
          paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderTopicInfo");
          AppMethodBeat.o(363272);
          throw paramd;
        }
        ((FrameLayout)this.lzt.findViewById(e.e.empty_view)).setVisibility(8);
        ((ProgressBar)this.lzt.findViewById(e.e.progress)).setVisibility(8);
      }
      AppMethodBeat.o(363272);
    }
    
    final void t(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(363280);
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
      if (localLayoutManager == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
        AppMethodBeat.o(363280);
        throw paramRecyclerView;
      }
      int i = ((FinderLinearLayoutManager)localLayoutManager).Ju() + 1;
      if (i < ((List)getAdapter().data).size()) {
        paramRecyclerView.post(new FinderTopicTimelineUIContract.c..ExternalSyntheticLambda0(paramRecyclerView, i));
      }
      AppMethodBeat.o(363280);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract
 * JD-Core Version:    0.7.0.1
 */