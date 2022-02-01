package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.js;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.convert.ac;
import com.tencent.mm.plugin.finder.convert.ae;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.f;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.al;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.RefreshLoadMoreLayout.d<Ljava.lang.Object;>;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "TAB_TYPE", "getTAB_TYPE", "()I", "setTAB_TYPE", "(I)V", "TAG", "", "autoPlayManager", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardAutoPlayManager;)V", "bgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "setBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;)V", "disableFlag", "getDisableFlag", "setDisableFlag", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "extraType", "getExtraType", "setExtraType", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1;", "flag", "getFlag", "setFlag", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "onRequestFinished", "Lkotlin/Function0;", "", "getOnRequestFinished", "()Lkotlin/jvm/functions/Function0;", "setOnRequestFinished", "(Lkotlin/jvm/functions/Function0;)V", "removeEvent", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "getRemoveEvent", "setRemoveEvent", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getSelectedTag", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCacheVM;", "topic", "getTopic", "setTopic", "(Ljava/lang/String;)V", "topicId", "", "getTopicId", "()J", "setTopicId", "(J)V", "topicInfo", "getTopicInfo", "setTopicInfo", "topicRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getTopicRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setTopicRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "totalCount", "getTotalCount", "setTotalCount", "totalDy", "type", "getType", "setType", "wrapper", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "getWrapper", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "buildCampaignConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "buildItemCoverts", "dealFirstRsp", "rsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getIViewActionCallback", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "ifDummyTag", "", "tag", "initViewCallback", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "scrollToTop", "endCallBack", "setNoMoreForActivity", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "size", "showNoMoreView", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bi$c
  extends c.a
{
  public long ADo;
  final bi.a AKz;
  private com.tencent.mm.view.k AWa;
  ak AXh;
  bxv AZG;
  public int BaZ;
  public int Bba;
  public long Bbb;
  int Bbc;
  private IListener<com.tencent.mm.autogen.a.g> Bbd;
  private final com.tencent.mm.plugin.finder.viewmodel.k Bbe;
  private final FinderTopicFeedUIContract.TopicFeedPresenter.feedProgressListener.1 Bbf;
  private final String TAG;
  public bxt bgmInfo;
  int eQp;
  bxv hLt;
  bqj musicInfo;
  private IListener<js> qmO;
  public String topic;
  private int totalDy;
  public int type;
  
  public bi$c(final MMActivity paramMMActivity, int paramInt, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramInt, paramBaseFinderFeedLoader);
    AppMethodBeat.i(363962);
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedPresenter";
    this.topic = "";
    paramBaseFinderFeedLoader = new bxv();
    Object localObject = FinderTagView.GCE;
    paramBaseFinderFeedLoader.ADo = FinderTagView.flp();
    localObject = kotlin.ah.aiuX;
    this.AZG = paramBaseFinderFeedLoader;
    this.AKz = new bi.a((byte)0);
    paramBaseFinderFeedLoader = com.tencent.mm.ui.component.k.aeZF;
    paramBaseFinderFeedLoader = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.k.class);
    s.s(paramBaseFinderFeedLoader, "UICProvider.of(PluginFin…cFeedCacheVM::class.java)");
    this.Bbe = ((com.tencent.mm.plugin.finder.viewmodel.k)paramBaseFinderFeedLoader);
    this.Bbf = new FinderTopicFeedUIContract.TopicFeedPresenter.feedProgressListener.1(this, com.tencent.mm.app.f.hfK);
    this.AWa = ((com.tencent.mm.view.k)new com.tencent.mm.view.k()
    {
      public final void onChanged()
      {
        Object localObject2 = null;
        AppMethodBeat.i(363446);
        String str = bi.c.a(this.Bbg);
        Object localObject1 = this.Bbg.ATE;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (!(localObject1 instanceof RefreshLoadMoreLayout)) {
            break label104;
          }
          localObject1 = (RefreshLoadMoreLayout)localObject1;
          label41:
          if (localObject1 != null) {
            break label109;
          }
        }
        label104:
        label109:
        for (localObject1 = localObject2;; localObject1 = Integer.valueOf(((RefreshLoadMoreLayout)localObject1).getVisibility()))
        {
          Log.i(str, s.X("onChanged ", localObject1));
          localObject1 = this.Bbg.ATE;
          if (localObject1 != null)
          {
            localObject1 = (com.tencent.mm.view.k)((c.b)localObject1).ATx;
            if (localObject1 != null) {
              ((com.tencent.mm.view.k)localObject1).onChanged();
            }
          }
          AppMethodBeat.o(363446);
          return;
          localObject1 = (com.tencent.mm.view.k)((c.b)localObject1).ATx;
          break;
          localObject1 = null;
          break label41;
        }
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 0;
        AppMethodBeat.i(363449);
        Object localObject1 = this.Bbg.ATE;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.k)((c.b)localObject1).ATx;
          if (localObject1 != null)
          {
            localObject2 = this.Bbg.ATE;
            if (localObject2 != null) {
              break label67;
            }
          }
        }
        for (;;)
        {
          ((com.tencent.mm.view.k)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(363449);
          return;
          label67:
          localObject2 = ((c.b)localObject2).getAdapter();
          if (localObject2 != null) {
            i = ((i)localObject2).agOb.size();
          }
        }
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        int i = 0;
        AppMethodBeat.i(363454);
        Object localObject1 = this.Bbg.ATE;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.k)((c.b)localObject1).ATx;
          if (localObject1 != null)
          {
            localObject2 = this.Bbg.ATE;
            if (localObject2 != null) {
              break label70;
            }
          }
        }
        for (;;)
        {
          ((com.tencent.mm.view.k)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
          AppMethodBeat.o(363454);
          return;
          label70:
          localObject2 = ((c.b)localObject2).getAdapter();
          if (localObject2 != null) {
            i = ((i)localObject2).agOb.size();
          }
        }
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 0;
        AppMethodBeat.i(363461);
        Object localObject1 = this.Bbg.ATE;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.k)((c.b)localObject1).ATx;
          if (localObject1 != null)
          {
            localObject2 = this.Bbg.ATE;
            if (localObject2 != null) {
              break label67;
            }
          }
        }
        for (;;)
        {
          ((com.tencent.mm.view.k)localObject1).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(363461);
          return;
          label67:
          localObject2 = ((c.b)localObject2).getAdapter();
          if (localObject2 != null) {
            i = ((i)localObject2).agOb.size();
          }
        }
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 0;
        AppMethodBeat.i(363468);
        Object localObject1 = this.Bbg.ATE;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.k)((c.b)localObject1).ATx;
          if (localObject1 != null)
          {
            localObject2 = this.Bbg.ATE;
            if (localObject2 != null) {
              break label86;
            }
          }
        }
        for (;;)
        {
          ((com.tencent.mm.view.k)localObject1).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.Bbg.ATE;
          if (localObject1 != null) {
            ((c.b)localObject1).dUO();
          }
          AppMethodBeat.o(363468);
          return;
          label86:
          localObject2 = ((c.b)localObject2).getAdapter();
          if (localObject2 != null) {
            i = ((i)localObject2).agOb.size();
          }
        }
      }
      
      public final void onPreFinishLoadMore(final RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(363437);
        s.u(paramAnonymousd, "reason");
        Object localObject = this.Bbg.ATE;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.k)((c.b)localObject).ATx;
          if (localObject != null) {
            ((com.tencent.mm.view.k)localObject).onPreFinishLoadMore(paramAnonymousd);
          }
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.Bbg, paramAnonymousd));
        AppMethodBeat.o(363437);
      }
      
      public final void onPreFinishLoadMoreSmooth(final RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(363444);
        s.u(paramAnonymousd, "reason");
        Object localObject = this.Bbg.ATE;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.k)((c.b)localObject).ATx;
          if (localObject != null) {
            ((com.tencent.mm.view.k)localObject).onPreFinishLoadMoreSmooth(paramAnonymousd);
          }
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this.Bbg, paramAnonymousd));
        AppMethodBeat.o(363444);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(363430);
        s.u(paramAnonymousd, "reason");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramAnonymousd, this.Bbg, paramMMActivity));
        AppMethodBeat.o(363430);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends kotlin.g.b.u
        implements kotlin.g.a.a<kotlin.ah>
      {
        a(bi.c paramc, RefreshLoadMoreLayout.d<Object> paramd)
        {
          super();
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class b
        extends kotlin.g.b.u
        implements kotlin.g.a.a<kotlin.ah>
      {
        b(bi.c paramc, RefreshLoadMoreLayout.d<Object> paramd)
        {
          super();
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class c
        extends kotlin.g.b.u
        implements kotlin.g.a.a<kotlin.ah>
      {
        c(RefreshLoadMoreLayout.d<Object> paramd, bi.c paramc, MMActivity paramMMActivity)
        {
          super();
        }
      }
    });
    AppMethodBeat.o(363962);
  }
  
  private static final void aS(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(363976);
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(363976);
  }
  
  public static boolean f(bxv parambxv)
  {
    AppMethodBeat.i(363968);
    s.u(parambxv, "tag");
    long l = parambxv.ADo;
    parambxv = FinderTagView.GCE;
    if (l == FinderTagView.flp())
    {
      AppMethodBeat.o(363968);
      return true;
    }
    AppMethodBeat.o(363968);
    return false;
  }
  
  public final void a(final c.b paramb)
  {
    AppMethodBeat.i(364043);
    s.u(paramb, "callback");
    super.a(paramb);
    this.Bbf.alive();
    paramb = this.ATE;
    Object localObject1;
    Object localObject2;
    if (paramb != null)
    {
      localObject1 = paramb.dUP().getIntent().getByteArrayExtra("key_topic_poi_location");
      if (localObject1 != null)
      {
        localObject2 = new boi();
        ((boi)localObject2).parseFrom((byte[])localObject1);
        ((FinderTopicFeedLoader)this.ALH).Bjw = ((boi)localObject2);
      }
      long l = paramb.dUP().getIntent().getLongExtra("key_ref_object_id", 0L);
      if (this.type != 7) {
        ((FinderTopicFeedLoader)this.ALH).Bjx = Long.valueOf(l);
      }
      if (this.type == 4) {
        paramb.ATx.getRecyclerView().a((RecyclerView.l)new e(this, paramb));
      }
      if (this.type == 7)
      {
        this.Bbd = ((IListener)new FinderTopicFeedUIContract.TopicFeedPresenter.onAttach.1.3(this, com.tencent.mm.app.f.hfK));
        paramb = this.Bbd;
        if (paramb != null) {
          paramb.alive();
        }
      }
    }
    ((FinderTopicFeedLoader)this.ALH).BgD = ((kotlin.g.a.a)new f(this));
    paramb = this.ATE;
    if (paramb != null)
    {
      paramb = paramb.ATx.getRecyclerView();
      if (paramb != null)
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        ((al)com.tencent.mm.ui.component.k.cn(PluginFinder.class).cq(al.class)).a((AppCompatActivity)this.lzt);
        localObject1 = (com.tencent.mm.plugin.g)h.ax(com.tencent.mm.plugin.g.class);
        localObject2 = (Context)this.lzt;
        ArrayList localArrayList = (ArrayList)this.ALH.getDataListJustForAdapter();
        c.b localb = this.ATE;
        s.checkNotNull(localb);
        this.AXh = ((com.tencent.mm.plugin.g)localObject1).a((Context)localObject2, paramb, localArrayList, localb.getAdapter());
      }
    }
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(364043);
  }
  
  public final void aR(kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(364048);
    Object localObject = this.ATE;
    if (localObject != null)
    {
      localObject = ((c.b)localObject).ATx.getRecyclerView();
      if (localObject != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    localObject = this.ATE;
    if (localObject != null)
    {
      localObject = ((c.b)localObject).ATx.getRecyclerView();
      if (localObject != null) {
        ((RecyclerView)localObject).post(new bi.c..ExternalSyntheticLambda0(parama));
      }
    }
    AppMethodBeat.o(364048);
  }
  
  public final void avQ(String paramString)
  {
    AppMethodBeat.i(364004);
    s.u(paramString, "<set-?>");
    this.topic = paramString;
    AppMethodBeat.o(364004);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(364087);
    if (f(this.AZG))
    {
      FinderTopicFeedLoader.b((FinderTopicFeedLoader)this.ALH, this.Bba);
      AppMethodBeat.o(364087);
      return;
    }
    epc localepc = new epc();
    localepc.abtn = new LinkedList();
    localepc.abtn.add(this.AZG);
    ((FinderTopicFeedLoader)this.ALH).a(this.Bba, localepc);
    AppMethodBeat.o(364087);
  }
  
  public final com.tencent.mm.view.recyclerview.g dUK()
  {
    AppMethodBeat.i(364065);
    if (this.type == 7)
    {
      localg = (com.tencent.mm.view.recyclerview.g)new a(this);
      AppMethodBeat.o(364065);
      return localg;
    }
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new b(this, (kotlin.g.a.b)new c(this), (q)new d(this));
    AppMethodBeat.o(364065);
    return localg;
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(364070);
    Object localObject = this.ATE;
    if (localObject != null) {
      ((c.b)localObject).ae((ArrayList)this.ALH.getDataListJustForAdapter());
    }
    this.qmO = ((IListener)new FinderTopicFeedUIContract.TopicFeedPresenter.initViewCallback.1(this, com.tencent.mm.app.f.hfK));
    localObject = this.qmO;
    if (localObject != null) {
      ((IListener)localObject).alive();
    }
    AppMethodBeat.o(364070);
  }
  
  public final void e(bxv parambxv)
  {
    AppMethodBeat.i(364011);
    s.u(parambxv, "<set-?>");
    this.AZG = parambxv;
    AppMethodBeat.o(364011);
  }
  
  public final com.tencent.mm.view.k ebJ()
  {
    return this.AWa;
  }
  
  public final String getIconUrl()
  {
    AppMethodBeat.i(165953);
    Object localObject = this.ALH.getListOfType(BaseFinderFeed.class);
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = (dji)p.ae((List)((BaseFinderFeed)((List)localObject).get(0)).feedObject.getMediaList(), 0);
      if (localObject == null) {
        break;
      }
      localObject = s.X(((dji)localObject).thumbUrl, ((dji)localObject).thumb_url_token);
      AppMethodBeat.o(165953);
      return localObject;
    }
    AppMethodBeat.o(165953);
    return "";
  }
  
  public final void i(RefreshLoadMoreLayout.d<Object> paramd)
  {
    int i = 1;
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(364103);
    s.u(paramd, "reason");
    Object localObject3 = paramd.extraData;
    if (localObject3 == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicResponse");
      AppMethodBeat.o(364103);
      throw paramd;
    }
    localObject3 = (FinderTopicFeedLoader.f)localObject3;
    if (!((FinderTopicFeedLoader.f)localObject3).getHasMore())
    {
      if (this.type == 7)
      {
        int j = this.ALH.getSize();
        Log.i(this.TAG, "setNoMoreForActivity :" + paramd + " response:" + ((FinderTopicFeedLoader.f)localObject3).Bbb + " size:" + this.ALH.getDataList().size() + " size11: " + j);
        paramd = this.ATE;
        if (paramd != null)
        {
          paramd = paramd.ATx;
          if (paramd != null)
          {
            localObject3 = paramd.getLoadMoreFooter();
            if (localObject3 != null)
            {
              paramd = com.tencent.mm.ui.component.k.aeZF;
              paramd = ((View)localObject3).getContext();
              s.s(paramd, "context");
              paramd = ((com.tencent.mm.plugin.finder.activity.uic.c)com.tencent.mm.ui.component.k.nq(paramd).q(com.tencent.mm.plugin.finder.activity.uic.c.class)).AuO;
              if ((paramd != null) && (!Util.isNullOrNil(paramd.coverUrl)))
              {
                paramd = this.ATE;
                if (!(paramd instanceof bi.d)) {
                  break label421;
                }
                paramd = (bi.d)paramd;
                label243:
                if (paramd != null) {
                  break label426;
                }
              }
              label421:
              label426:
              for (paramd = null;; paramd = paramd.Bbw)
              {
                Log.i(this.TAG, s.X("setNoMoreForActivity size:", Integer.valueOf(j)));
                if (j <= 0) {
                  break label517;
                }
                ((View)localObject3).setVisibility(0);
                localObject1 = ((View)localObject3).findViewById(e.e.load_more_footer_tip_tv);
                if (localObject1 != null) {
                  ((View)localObject1).setVisibility(8);
                }
                localObject1 = ((View)localObject3).findViewById(e.e.load_more_footer_end_layout);
                if (localObject1 != null) {
                  ((View)localObject1).setVisibility(0);
                }
                if (paramd != null) {
                  paramd.setVisibility(8);
                }
                if (i == 0) {
                  break label434;
                }
                i = ((View)localObject3).getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_100_Alpha_0_3);
                paramd = ((View)localObject3).findViewById(e.e.center_icon);
                if (paramd != null) {
                  paramd.setBackground(((View)localObject3).getResources().getDrawable(e.d.finder_footer_covered_center_dot));
                }
                paramd = ((View)localObject3).findViewById(e.e.left_icon);
                if (paramd != null) {
                  paramd.setBackgroundColor(i);
                }
                paramd = ((View)localObject3).findViewById(e.e.right_icon);
                if (paramd == null) {
                  break label705;
                }
                paramd.setBackgroundColor(i);
                AppMethodBeat.o(364103);
                return;
                i = 0;
                break;
                paramd = null;
                break label243;
              }
              label434:
              i = ((View)localObject3).getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_2);
              paramd = ((View)localObject3).findViewById(e.e.center_icon);
              if (paramd != null) {
                paramd.setBackground(((View)localObject3).getResources().getDrawable(e.d.finder_footer_normal_center_dot));
              }
              paramd = ((View)localObject3).findViewById(e.e.left_icon);
              if (paramd != null) {
                paramd.setBackgroundColor(i);
              }
              paramd = ((View)localObject3).findViewById(e.e.right_icon);
              if (paramd != null)
              {
                paramd.setBackgroundColor(i);
                AppMethodBeat.o(364103);
                return;
                label517:
                ((View)localObject3).setVisibility(8);
                if (paramd != null) {
                  paramd.setVisibility(0);
                }
                if (paramd == null)
                {
                  localObject1 = null;
                  if (localObject1 != null) {
                    ((View)localObject1).setVisibility(0);
                  }
                  if (paramd != null) {
                    break label647;
                  }
                  localObject1 = null;
                  label558:
                  if (localObject1 != null) {
                    ((View)localObject1).setVisibility(8);
                  }
                  if (paramd != null) {
                    break label659;
                  }
                }
                label647:
                label659:
                for (localObject1 = localObject2;; localObject1 = paramd.findViewById(e.e.progress))
                {
                  if (localObject1 != null) {
                    ((View)localObject1).setVisibility(8);
                  }
                  if (i == 0) {
                    break label671;
                  }
                  if (paramd == null) {
                    break label705;
                  }
                  paramd = (TextView)paramd.findViewById(e.e.empty_tip);
                  if (paramd == null) {
                    break label705;
                  }
                  paramd.setTextColor(((View)localObject3).getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_100_Alpha_0_3));
                  AppMethodBeat.o(364103);
                  return;
                  localObject1 = paramd.findViewById(e.e.empty_tip);
                  break;
                  localObject1 = paramd.findViewById(e.e.retry_tip);
                  break label558;
                }
                label671:
                if (paramd != null)
                {
                  paramd = (TextView)paramd.findViewById(e.e.empty_tip);
                  if (paramd != null) {
                    paramd.setTextColor(((View)localObject3).getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_2));
                  }
                }
              }
            }
          }
        }
        label705:
        AppMethodBeat.o(364103);
        return;
      }
      paramd = this.ATE;
      if (paramd != null)
      {
        paramd = paramd.ATx;
        if (paramd != null)
        {
          paramd = paramd.getLoadMoreFooter();
          if (paramd != null)
          {
            paramd = (TextView)paramd.findViewById(e.e.load_more_footer_tip_tv);
            if (paramd != null) {
              paramd.setText(e.h.finder_load_more_no_result_tip);
            }
          }
        }
      }
      paramd = this.ATE;
      if (paramd != null)
      {
        paramd = paramd.ATx;
        if (paramd != null)
        {
          paramd = paramd.getLoadMoreFooter();
          if (paramd != null)
          {
            paramd = (TextView)paramd.findViewById(e.e.load_more_footer_tip_tv);
            if (paramd != null)
            {
              paramd.setTextColor(this.lzt.getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_2));
              AppMethodBeat.o(364103);
            }
          }
        }
      }
    }
    else
    {
      paramd = this.ATE;
      if (paramd != null) {
        break label855;
      }
    }
    label855:
    for (paramd = (RefreshLoadMoreLayout.d<Object>)localObject1;; paramd = paramd.ATx)
    {
      if (paramd != null) {
        paramd.setEnableLoadMore(true);
      }
      AppMethodBeat.o(364103);
      return;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165956);
    super.onDetach();
    Object localObject = this.Bbe.GLx;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = this.ATE;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
      AppMethodBeat.o(165956);
      throw ((Throwable)localObject);
    }
    ((bi.d)localObject).onDetach();
    localObject = this.Bbd;
    if (localObject != null) {
      ((IListener)localObject).dead();
    }
    localObject = this.qmO;
    if (localObject != null) {
      ((IListener)localObject).dead();
    }
    this.Bbf.dead();
    localObject = this.AXh;
    if (localObject != null) {
      ((ak)localObject).detach();
    }
    AppMethodBeat.o(165956);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(364029);
    super.onUIPause();
    ak localak = this.AXh;
    if (localak != null) {
      localak.eET();
    }
    AppMethodBeat.o(364029);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(364023);
    super.onUIResume();
    Object localObject = this.ATE;
    if ((localObject instanceof bi.d))
    {
      localObject = (bi.d)localObject;
      if (localObject != null) {
        break label82;
      }
      localObject = null;
      label33:
      if (!(localObject instanceof com.tencent.mm.plugin.finder.music.d)) {
        break label90;
      }
    }
    label82:
    label90:
    for (localObject = (com.tencent.mm.plugin.finder.music.d)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.music.d)localObject).onResume();
      }
      localObject = this.AXh;
      if (localObject != null) {
        ((ak)localObject).eES();
      }
      AppMethodBeat.o(364023);
      return;
      localObject = null;
      break;
      localObject = ((bi.d)localObject).AXg;
      break label33;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165957);
    if (f(this.AZG))
    {
      FinderTopicFeedLoader.a((FinderTopicFeedLoader)this.ALH, this.Bba);
      AppMethodBeat.o(165957);
      return;
    }
    epc localepc = new epc();
    localepc.abtn = new LinkedList();
    localepc.abtn.add(this.AZG);
    ((FinderTopicFeedLoader)this.ALH).a(this.Bba, localepc, 4);
    AppMethodBeat.o(165957);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$buildCampaignConvert$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(bi.c paramc) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(363033);
      switch (paramInt)
      {
      default: 
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(363033);
        return localObject;
      case 4: 
      case 9: 
      case 3002: 
        localObject = new com.tencent.mm.plugin.finder.convert.ah();
        ((ac)localObject).AKz = this.Bbg.AKz;
        localObject = (com.tencent.mm.view.recyclerview.f)localObject;
        AppMethodBeat.o(363033);
        return localObject;
      case 2: 
      case 3001: 
        localObject = new com.tencent.mm.plugin.finder.convert.u();
        ((ac)localObject).AKz = this.Bbg.AKz;
        localObject = (com.tencent.mm.view.recyclerview.f)localObject;
        AppMethodBeat.o(363033);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.f)new ae();
        AppMethodBeat.o(363033);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.f)new z();
      AppMethodBeat.o(363033);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    b(bi.c paramc, kotlin.g.a.b<? super Integer, ? extends com.tencent.mm.view.recyclerview.f<?>> paramb, q<? super j, ? super BaseFinderFeed, ? super Integer, kotlin.ah> paramq) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(363023);
      com.tencent.mm.view.recyclerview.f localf = new e((Context)this.Bbg.lzt, this.Bbg.AJo).a(paramInt, this.Bbh, this.Bbi);
      AppMethodBeat.o(363023);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, com.tencent.mm.view.recyclerview.f<?>>
  {
    c(bi.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements q<j, BaseFinderFeed, Integer, kotlin.ah>
  {
    d(bi.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    e(bi.c paramc, c.b paramb) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(362999);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(362999);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362992);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.Bbg;
      bi.c.a(paramRecyclerView, bi.c.c(paramRecyclerView) + paramInt2);
      paramRecyclerView = this.Bbg;
      float f;
      if (bi.c.c(this.Bbg) < 0)
      {
        paramInt1 = 0;
        bi.c.a(paramRecyclerView, paramInt1);
        paramInt1 = this.Bbg.lzt.getResources().getDimensionPixelOffset(e.c.Edge_14A);
        f = bi.c.c(this.Bbg) / paramInt1;
        if (f != 0.0F) {
          break label200;
        }
        paramInt1 = 1;
        label138:
        if (paramInt1 == 0) {
          break label205;
        }
        ((bi.d)paramb).eda().setVisibility(4);
      }
      for (;;)
      {
        ((bi.d)paramb).eda().setAlpha(f);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(362992);
        return;
        paramInt1 = bi.c.c(this.Bbg);
        break;
        label200:
        paramInt1 = 0;
        break label138;
        label205:
        if (((bi.d)paramb).eda().getVisibility() == 4)
        {
          paramRecyclerView = v.FrN;
          v.T(true, 6);
        }
        ((bi.d)paramb).eda().setVisibility(0);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(bi.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bi.c
 * JD-Core Version:    0.7.0.1
 */