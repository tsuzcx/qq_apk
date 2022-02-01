package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.c.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.f.a.ht;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.State;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "FILTER_VIEW_TYPE", "", "getFILTER_VIEW_TYPE", "()I", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "feedProgressListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1;", "filterContract", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "layoutConfig", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "layoutConfig$delegate", "mHellOnScrollListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1;", "mainFlowLayout", "Landroid/widget/FrameLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "stateLayout", "getLayoutId", "jumpProfileTimeline", "", "pos", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "jumpToLive", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class FinderProfileFeedUIC
  extends i
{
  public static final a zRf;
  private final kotlin.f xAp;
  private final kotlin.f xDO;
  private final int xxC;
  private com.tencent.mm.plugin.finder.profile.b xxF;
  private final kotlin.f zQB;
  private final kotlin.f zQD;
  private final kotlin.f zQF;
  private FrameLayout zQO;
  private FrameLayout zQP;
  private final e zRd;
  private final g zRe;
  
  static
  {
    AppMethodBeat.i(279422);
    zRf = new a((byte)0);
    AppMethodBeat.o(279422);
  }
  
  public FinderProfileFeedUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(279421);
    this.xAp = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.zQB = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.xDO = kotlin.g.ar((kotlin.g.a.a)new q(paramFragment));
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new p(this));
    this.zQF = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.xxC = 10000001;
    this.zRd = new e(this);
    this.zRe = new g();
    AppMethodBeat.o(279421);
  }
  
  private final b getActionCallback()
  {
    AppMethodBeat.i(279412);
    b localb = (b)this.zQF.getValue();
    AppMethodBeat.o(279412);
    return localb;
  }
  
  private final FinderProfileFeedLoader getFeedLoader()
  {
    AppMethodBeat.i(279405);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.xAp.getValue();
    AppMethodBeat.o(279405);
    return localFinderProfileFeedLoader;
  }
  
  private final com.tencent.mm.plugin.finder.profile.a getLayoutConfig()
  {
    AppMethodBeat.i(279406);
    com.tencent.mm.plugin.finder.profile.a locala = (com.tencent.mm.plugin.finder.profile.a)this.zQB.getValue();
    AppMethodBeat.o(279406);
    return locala;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(279411);
    RecyclerView localRecyclerView = (RecyclerView)this.zQD.getValue();
    AppMethodBeat.o(279411);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(279409);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.xDO.getValue();
    AppMethodBeat.o(279409);
    return localRefreshLoadMoreLayout;
  }
  
  private final void jumpProfileTimeline(int paramInt, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(279415);
    Intent localIntent = new Intent();
    Object localObject = aj.Bnu;
    BaseFeedLoader.saveCache$default(getFeedLoader(), localIntent, paramInt, null, 4, null);
    localIntent.putExtra("KEY_FROM_TOPIC_ID", getFeedLoader().getCurTopicId());
    localIntent.putExtra("finder_username", getUsername());
    localIntent.putExtra("KEY_FINDER_SELF_FLAG", isSelfFlag());
    localObject = getFragment();
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getActivity();
      if (localObject != null)
      {
        com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
        p.j(localObject, "it");
      }
    }
    for (localObject = ((aj)com.tencent.mm.ui.component.g.lm((Context)localObject).i(aj.class)).wmz;; localObject = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localIntent.putExtra("key_click_tab_context_id", ((e)com.tencent.mm.kernel.h.ag(e.class)).getNearbyTabLifecycleReporter().dMz());
      }
      localObject = aj.Bnu;
      aj.a.a((Context)getActivity(), localIntent, 0L, 0, false, 124);
      localIntent.putExtra("KEY_FINDER_FEEDID", paramBaseFinderFeed.feedObject.getId());
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.y((Context)getActivity(), localIntent);
      localObject = n.zWF;
      n.P(paramBaseFinderFeed.mf(), 1);
      AppMethodBeat.o(279415);
      return;
    }
  }
  
  private final void jumpToLive(BaseFinderFeed paramBaseFinderFeed, int paramInt)
  {
    AppMethodBeat.i(279416);
    long l1;
    Object localObject2;
    Object localObject3;
    if (Util.isEqual(paramBaseFinderFeed.feedObject.getFeedObject().username, z.bdh()))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject4 = (Context)getActivity();
      l1 = paramBaseFinderFeed.feedObject.getFeedObject().id;
      localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new bac();
      }
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject4, l1, (String)localObject1, (bac)localObject2, null, null, null, null, null, paramBaseFinderFeed.getSessionBuffer(), null, null, 7152);
      AppMethodBeat.o(279416);
      return;
    }
    k.yBj.a(paramBaseFinderFeed, paramInt, s.t.yGS, s.l.yFT.scene);
    Object localObject4 = com.tencent.mm.plugin.finder.utils.a.ACH;
    Context localContext = (Context)getActivity();
    long l2 = paramBaseFinderFeed.feedObject.getFeedObject().id;
    Object localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
    String str1;
    label285:
    String str2;
    if (localObject1 != null)
    {
      l1 = ((bac)localObject1).liveId;
      localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().username;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = paramBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      str1 = paramBaseFinderFeed.feedObject.getDescription();
      localObject3 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject3 == null) {
        break label407;
      }
      paramInt = ((bac)localObject3).SLO;
      str2 = paramBaseFinderFeed.getSessionBuffer();
      localObject3 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject3 == null) {
        break label412;
      }
      localObject3 = ((bac)localObject3).kih;
      label312:
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramBaseFinderFeed == null) {
        break label418;
      }
      paramBaseFinderFeed = paramBaseFinderFeed.SLN;
      if (paramBaseFinderFeed == null) {
        break label418;
      }
    }
    label407:
    label412:
    label418:
    for (paramBaseFinderFeed = Integer.valueOf(paramBaseFinderFeed.kmi);; paramBaseFinderFeed = null)
    {
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      com.tencent.mm.plugin.finder.utils.a.a((com.tencent.mm.plugin.finder.utils.a)localObject4, null, localContext, l2, l1, (String)localObject1, (String)localObject2, str1, "", paramInt, str2, null, (String)localObject3, paramBaseFinderFeed, ((aj)com.tencent.mm.ui.component.g.b(getActivity()).i(aj.class)).xkX, 1024);
      AppMethodBeat.o(279416);
      return;
      l1 = 0L;
      break;
      paramInt = 0;
      break label285;
      localObject3 = null;
      break label312;
    }
  }
  
  public final int getFILTER_VIEW_TYPE()
  {
    return this.xxC;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_profile_feed_ui;
  }
  
  public final FinderProfileFeedLoader.State getState()
  {
    AppMethodBeat.i(279413);
    FinderProfileFeedLoader.State localState = getFeedLoader().getState();
    AppMethodBeat.o(279413);
    return localState;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279414);
    super.onCreate(paramBundle);
    this.zRd.alive();
    getFeedLoader().setReadFeedId(Long.valueOf(getIntent().getLongExtra("finder_read_feed_id", -1L)));
    getFeedLoader().register((com.tencent.mm.view.j)getActionCallback());
    paramBundle = getFragment();
    if (paramBundle != null)
    {
      paramBundle = (FrameLayout)paramBundle.getView().findViewById(b.f.profile_loading_state_container);
      this.zQP = paramBundle;
      paramBundle = getFragment();
      if (paramBundle == null) {
        break label301;
      }
    }
    label301:
    for (paramBundle = (FrameLayout)paramBundle.getView().findViewById(b.f.main_flow_layout);; paramBundle = null)
    {
      this.zQO = paramBundle;
      getRlLayout().setEnableRefresh(false);
      getRlLayout().setSuperNestedScroll(true);
      getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new i(this));
      paramBundle = getRlLayout();
      localObject1 = ad.kS((Context)getActivity()).inflate(b.g.load_more_footer, null);
      p.j(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = (Activity)getActivity();
      localObject1 = getFeedLoader().getTopicFilterList();
      localObject2 = getUsername();
      p.j(localObject2, "username");
      this.xxF = new com.tencent.mm.plugin.finder.profile.b(paramBundle, (ArrayList)localObject1, (String)localObject2);
      getRecyclerView().setLayoutManager(getLayoutConfig().eW((Context)getActivity()));
      getRecyclerView().b(getLayoutConfig().getItemDecoration());
      paramBundle = getRecyclerView();
      localObject1 = getLayoutConfig();
      localObject2 = getActivity();
      if (localObject2 != null) {
        break label306;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(279414);
      throw paramBundle;
      paramBundle = null;
      break;
    }
    label306:
    paramBundle.setRecycledViewPool(((com.tencent.mm.plugin.finder.profile.a)localObject1).g((MMActivity)localObject2));
    paramBundle = getRecyclerView();
    Object localObject1 = new j(this, getLayoutConfig().dtg(), (ArrayList)getFeedLoader().getDataList());
    ((com.tencent.mm.view.recyclerview.h)localObject1).YSn = ((h.c)new h((j)localObject1, this));
    Object localObject2 = this.xxF;
    if (localObject2 == null) {
      p.bGy("filterContract");
    }
    com.tencent.mm.view.recyclerview.h.a((com.tencent.mm.view.recyclerview.h)localObject1, com.tencent.mm.plugin.finder.profile.b.a((com.tencent.mm.plugin.finder.profile.b)localObject2), this.xxC);
    paramBundle.setAdapter((RecyclerView.a)localObject1);
    paramBundle = this.xxF;
    if (paramBundle == null) {
      p.bGy("filterContract");
    }
    paramBundle.zPI = ((m)new k(this));
    getFeedLoader().setOnFilterDataChanged((kotlin.g.a.a)new l(this));
    paramBundle = this.zQP;
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(b.e.finder_profile_gradient_bg);
    }
    getFeedLoader().setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new m(this));
    getFeedLoader().setFetchEndCallback((kotlin.g.a.b)new n(this));
    getFeedLoader().setHandleStickyEvent((kotlin.g.a.b)new o(this));
    BaseFeedLoader.requestInit$default(getFeedLoader(), false, 1, null);
    getFeedLoader().requestRefresh();
    getRecyclerView().a((RecyclerView.l)this.zRe);
    AppMethodBeat.o(279414);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(279417);
    super.onDestroy();
    getFeedLoader().unregister((com.tencent.mm.view.j)getActionCallback());
    this.zRd.dead();
    getRecyclerView().b((RecyclerView.l)this.zRe);
    AppMethodBeat.o(279417);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(279420);
    super.onPause();
    k localk = k.yBj;
    k.b(getRlLayout().getRecyclerView(), s.t.yGN, s.l.yFT.scene, com.tencent.mm.plugin.finder.live.report.c.yAj);
    AppMethodBeat.o(279420);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(279418);
    super.onResume();
    k localk = k.yBj;
    k.b(getRlLayout().getRecyclerView(), s.t.yGN, s.l.yFT.scene, com.tencent.mm.plugin.finder.live.report.c.yAi);
    AppMethodBeat.o(279418);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getHeaderCount", "", "updateState", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(282792);
      AppMethodBeat.o(282792);
    }
    
    public final void dFf()
    {
      AppMethodBeat.i(282789);
      d.a(0L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(282789);
    }
    
    public final int getHeaderCount()
    {
      AppMethodBeat.i(282790);
      RecyclerView.a locala = FinderProfileFeedUIC.access$getRecyclerView$p(FinderProfileFeedUIC.this).getAdapter();
      Object localObject = locala;
      if (!(locala instanceof WxRecyclerAdapter)) {
        localObject = null;
      }
      localObject = (WxRecyclerAdapter)localObject;
      if (localObject != null)
      {
        int i = ((com.tencent.mm.view.recyclerview.h)localObject).YSk.size();
        AppMethodBeat.o(282790);
        return i;
      }
      AppMethodBeat.o(282790);
      return 0;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderProfileFeedUIC.b paramb)
      {
        super();
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1$4$1"})
      static final class a
        implements View.OnClickListener
      {
        a(FinderProfileFeedUIC.b.a parama) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(285871);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          RefreshLoadMoreLayout.d(FinderProfileFeedUIC.access$getRlLayout$p(this.zRi.zRh.zRg));
          this.zRi.zRh.dFf();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(285871);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<FinderProfileFeedUIC.b>
  {
    c(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<FinderProfileFeedLoader>
  {
    d(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<hr>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.profile.a>
  {
    f(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class g
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(286305);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(286305);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286304);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGN, s.l.yFT.scene, com.tencent.mm.plugin.finder.live.report.c.yAh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(286304);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$3$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "pos", "", "holder", "plugin-finder_release"})
  public static final class h
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {
    h(FinderProfileFeedUIC.j paramj, FinderProfileFeedUIC paramFinderProfileFeedUIC) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(286887);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      FinderProfileFeedUIC.access$getFeedLoader$p(this.zRg).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(286887);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(286890);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(286890);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(286889);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      FinderProfileFeedUIC.access$getFeedLoader$p(this.zRg).requestLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(286889);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(286888);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      paramc = FinderProfileFeedUIC.access$getRlLayout$p(this.zRg).getRecyclerView();
      localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramc, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      paramc.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(286888);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$2", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class j
    extends WxRecyclerAdapter<bu>
  {
    j(com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList)
    {
      super(localArrayList);
    }
    
    public final void p(com.tencent.mm.view.recyclerview.i parami)
    {
      AppMethodBeat.i(286222);
      p.k(parami, "holder");
      super.p(parami);
      Object localObject = parami.amk;
      p.j(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if (parami.mg() != this.zRg.getFILTER_VIEW_TYPE()) {
          break label75;
        }
      }
      label75:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aA(bool);
        AppMethodBeat.o(286222);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "selected", "", "invoke"})
  static final class k
    extends q
    implements m<bkr, Boolean, x>
  {
    k(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$6", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(286721);
      FinderProfileFeedUIC.access$getActionCallback$p(this.zRg).dFf();
      AppMethodBeat.o(286721);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    n(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.b<ht, x>
  {
    o(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    p(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    q(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileFeedUIC
 * JD-Core Version:    0.7.0.1
 */