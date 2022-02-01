package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.State;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bl;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.profile.FinderTopicFilterView;
import com.tencent.mm.plugin.finder.profile.FinderTopicFilterView.a;
import com.tencent.mm.plugin.finder.profile.FinderTopicFilterView.c;
import com.tencent.mm.plugin.finder.profile.FlowLayoutManager;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "FILTER_VIEW_TYPE", "", "getFILTER_VIEW_TYPE", "()I", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "feedProgressListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1;", "filterContract", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "layoutConfig", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "layoutConfig$delegate", "mHellOnScrollListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1;", "mainFlowLayout", "Landroid/widget/FrameLayout;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "stateLayout", "getLayoutId", "jumpProfileTimeline", "", "pos", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "jumpToLive", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class FinderProfileFeedUIC
  extends FinderProfileFragmentUIC
{
  public static final a vba;
  private final kotlin.f tPy;
  private final kotlin.f tSX;
  private FrameLayout vaG;
  private FrameLayout vaH;
  private com.tencent.mm.plugin.finder.profile.b vaW;
  private final int vaX;
  private final e vaY;
  private final g vaZ;
  private final kotlin.f vas;
  private final kotlin.f vau;
  private final kotlin.f vaw;
  
  static
  {
    AppMethodBeat.i(250240);
    vba = new a((byte)0);
    AppMethodBeat.o(250240);
  }
  
  public FinderProfileFeedUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(250239);
    this.tPy = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.vas = kotlin.g.ah((kotlin.g.a.a)new f(this));
    this.tSX = kotlin.g.ah((kotlin.g.a.a)new q(paramFragment));
    this.vau = kotlin.g.ah((kotlin.g.a.a)new p(this));
    this.vaw = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.vaX = 10000001;
    this.vaY = new e(this);
    this.vaZ = new g();
    AppMethodBeat.o(250239);
  }
  
  private final b getActionCallback()
  {
    AppMethodBeat.i(250231);
    b localb = (b)this.vaw.getValue();
    AppMethodBeat.o(250231);
    return localb;
  }
  
  private final FinderProfileFeedLoader getFeedLoader()
  {
    AppMethodBeat.i(250227);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.tPy.getValue();
    AppMethodBeat.o(250227);
    return localFinderProfileFeedLoader;
  }
  
  private final com.tencent.mm.plugin.finder.profile.a getLayoutConfig()
  {
    AppMethodBeat.i(250228);
    com.tencent.mm.plugin.finder.profile.a locala = (com.tencent.mm.plugin.finder.profile.a)this.vas.getValue();
    AppMethodBeat.o(250228);
    return locala;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(250230);
    RecyclerView localRecyclerView = (RecyclerView)this.vau.getValue();
    AppMethodBeat.o(250230);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(250229);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.tSX.getValue();
    AppMethodBeat.o(250229);
    return localRefreshLoadMoreLayout;
  }
  
  private final void jumpProfileTimeline(int paramInt, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(250234);
    Intent localIntent = new Intent();
    BaseFeedLoader.saveCache$default(getFeedLoader(), localIntent, paramInt, null, 4, null);
    localIntent.putExtra("KEY_FROM_TOPIC_ID", getFeedLoader().getCurTopicId());
    localIntent.putExtra("finder_username", getUsername());
    localIntent.putExtra("KEY_FINDER_SELF_FLAG", isSelfFlag());
    Object localObject = getFragment();
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getActivity();
      if (localObject != null)
      {
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        p.g(localObject, "it");
      }
    }
    for (localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.ko((Context)localObject).get(FinderReporterUIC.class)).sGE;; localObject = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
        localIntent.putExtra("key_click_tab_context_id", com.tencent.mm.plugin.finder.nearby.report.d.dlA());
      }
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a((Context)getActivity(), localIntent, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.y((Context)getActivity(), localIntent);
      localObject = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.J(paramBaseFinderFeed.lT(), 1);
      AppMethodBeat.o(250234);
      return;
    }
  }
  
  private final void jumpToLive(BaseFinderFeed paramBaseFinderFeed, int paramInt)
  {
    AppMethodBeat.i(250235);
    Object localObject2;
    Object localObject3;
    if (Util.isEqual(paramBaseFinderFeed.feedObject.getFeedObject().username, z.aUg()))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localContext = (Context)getActivity();
      l1 = paramBaseFinderFeed.feedObject.getFeedObject().id;
      localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new awe();
      }
      com.tencent.mm.plugin.finder.utils.a.a(localContext, l1, (String)localObject1, (awe)localObject2, false, null, null, null, null, null, paramBaseFinderFeed.getSessionBuffer(), null, 6128);
      AppMethodBeat.o(250235);
      return;
    }
    com.tencent.mm.plugin.finder.report.live.k.vkd.a(paramBaseFinderFeed, paramInt, s.p.voF, s.j.vnR.scene);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
    Context localContext = (Context)getActivity();
    long l2 = paramBaseFinderFeed.feedObject.getFeedObject().id;
    localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
    if (localObject1 != null) {}
    for (long l1 = ((awe)localObject1).liveId;; l1 = 0L)
    {
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
      com.tencent.mm.plugin.finder.utils.a.a(localContext, l2, l1, (String)localObject1, (String)localObject2, "", "", paramBaseFinderFeed.getSessionBuffer());
      AppMethodBeat.o(250235);
      return;
    }
  }
  
  public final int getFILTER_VIEW_TYPE()
  {
    return this.vaX;
  }
  
  public final int getLayoutId()
  {
    return 2131494586;
  }
  
  public final FinderProfileFeedLoader.State getState()
  {
    AppMethodBeat.i(250232);
    FinderProfileFeedLoader.State localState = getFeedLoader().getState();
    AppMethodBeat.o(250232);
    return localState;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250233);
    super.onCreate(paramBundle);
    this.vaY.alive();
    getFeedLoader().setReadFeedId(Long.valueOf(getIntent().getLongExtra("finder_read_feed_id", -1L)));
    getFeedLoader().register((com.tencent.mm.view.j)getActionCallback());
    paramBundle = getFragment();
    if (paramBundle != null)
    {
      paramBundle = (FrameLayout)paramBundle.getView().findViewById(2131306216);
      this.vaH = paramBundle;
      paramBundle = getFragment();
      if (paramBundle == null) {
        break label301;
      }
    }
    label301:
    for (paramBundle = (FrameLayout)paramBundle.getView().findViewById(2131304322);; paramBundle = null)
    {
      this.vaG = paramBundle;
      getRlLayout().setEnableRefresh(false);
      getRlLayout().setSuperNestedScroll(true);
      getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new i(this));
      paramBundle = getRlLayout();
      localObject1 = aa.jQ((Context)getActivity()).inflate(2131495297, null);
      p.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = (Activity)getActivity();
      localObject1 = getFeedLoader().getTopicFilterList();
      localObject2 = getUsername();
      p.g(localObject2, "username");
      this.vaW = new com.tencent.mm.plugin.finder.profile.b(paramBundle, (ArrayList)localObject1, (String)localObject2);
      getRecyclerView().setLayoutManager(getLayoutConfig().eS((Context)getActivity()));
      getRecyclerView().b(getLayoutConfig().getItemDecoration());
      paramBundle = getRecyclerView();
      localObject1 = getLayoutConfig();
      localObject2 = getActivity();
      if (localObject2 != null) {
        break label306;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(250233);
      throw paramBundle;
      paramBundle = null;
      break;
    }
    label306:
    paramBundle.setRecycledViewPool(((com.tencent.mm.plugin.finder.profile.a)localObject1).f((MMActivity)localObject2));
    paramBundle = getRecyclerView();
    Object localObject1 = new j(this, getLayoutConfig().dcK(), (ArrayList)getFeedLoader().getDataList());
    ((com.tencent.mm.view.recyclerview.g)localObject1).RqP = ((g.c)new h((j)localObject1, this));
    Object localObject2 = this.vaW;
    if (localObject2 == null) {
      p.btv("filterContract");
    }
    ((com.tencent.mm.plugin.finder.profile.b)localObject2).kgc.clear();
    Object localObject3 = ((com.tencent.mm.plugin.finder.profile.b)localObject2).kgc;
    Object localObject5 = (Iterable)((com.tencent.mm.plugin.finder.profile.b)localObject2).uZp;
    Object localObject4 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject5, 10));
    localObject5 = ((Iterable)localObject5).iterator();
    while (((Iterator)localObject5).hasNext()) {
      ((Collection)localObject4).add(new bl((bds)((Iterator)localObject5).next()));
    }
    ((ArrayList)localObject3).addAll((Collection)localObject4);
    localObject3 = new FinderTopicFilterView((Context)((com.tencent.mm.plugin.finder.profile.b)localObject2).dKq);
    p.h(localObject2, "presenter");
    ((FinderTopicFilterView)localObject3).uZq = ((com.tencent.mm.plugin.finder.profile.b)localObject2);
    LayoutInflater.from(((FinderTopicFilterView)localObject3).getContext()).inflate(2131494599, (ViewGroup)localObject3, true);
    ((FinderTopicFilterView)localObject3).ufR = ((WxRecyclerView)((FinderTopicFilterView)localObject3).findViewById(2131300717));
    localObject4 = ((FinderTopicFilterView)localObject3).ufR;
    if (localObject4 != null) {
      ((WxRecyclerView)localObject4).b(((FinderTopicFilterView)localObject3).getItemDecoration());
    }
    localObject4 = new FlowLayoutManager();
    localObject5 = ((FinderTopicFilterView)localObject3).ufR;
    if (localObject5 != null) {
      ((WxRecyclerView)localObject5).setLayoutManager((RecyclerView.LayoutManager)localObject4);
    }
    localObject4 = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new FinderTopicFilterView.a((FinderTopicFilterView)localObject3), ((com.tencent.mm.plugin.finder.profile.b)localObject2).kgc, false);
    ((com.tencent.mm.view.recyclerview.g)localObject4).RqP = ((g.c)new FinderTopicFilterView.c((WxRecyclerAdapter)localObject4, (FinderTopicFilterView)localObject3, (com.tencent.mm.plugin.finder.profile.b)localObject2));
    localObject5 = ((FinderTopicFilterView)localObject3).ufR;
    if (localObject5 != null) {
      ((WxRecyclerView)localObject5).setAdapter((RecyclerView.a)localObject4);
    }
    ((FinderTopicFilterView)localObject3).refresh();
    if (((com.tencent.mm.plugin.finder.profile.b)localObject2).kgc.isEmpty())
    {
      localObject4 = ((com.tencent.mm.plugin.finder.profile.b)localObject2).uZn;
      if (localObject4 != null) {
        ((FinderTopicFilterView)localObject4).setVisibility(8);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.profile.b)localObject2).uZn = ((FinderTopicFilterView)localObject3);
      com.tencent.mm.view.recyclerview.g.a((com.tencent.mm.view.recyclerview.g)localObject1, (View)localObject3, this.vaX);
      paramBundle.setAdapter((RecyclerView.a)localObject1);
      paramBundle = this.vaW;
      if (paramBundle == null) {
        p.btv("filterContract");
      }
      paramBundle.uZo = ((m)new k(this));
      getFeedLoader().setOnFilterDataChanged((kotlin.g.a.a)new l(this));
      paramBundle = this.vaH;
      if (paramBundle != null) {
        paramBundle.setBackgroundResource(2131232704);
      }
      getFeedLoader().setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new m(this));
      getFeedLoader().setFetchEndCallback((kotlin.g.a.b)new n(this));
      getFeedLoader().setHandleStickyEvent((kotlin.g.a.b)new o(this));
      BaseFeedLoader.requestInit$default(getFeedLoader(), false, 1, null);
      getFeedLoader().requestRefresh();
      getRecyclerView().a((RecyclerView.l)this.vaZ);
      AppMethodBeat.o(250233);
      return;
      localObject4 = ((com.tencent.mm.plugin.finder.profile.b)localObject2).uZn;
      if (localObject4 != null) {
        ((FinderTopicFilterView)localObject4).setVisibility(0);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250236);
    super.onDestroy();
    getFeedLoader().unregister((com.tencent.mm.view.j)getActionCallback());
    this.vaY.dead();
    getRecyclerView().b((RecyclerView.l)this.vaZ);
    AppMethodBeat.o(250236);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(250238);
    super.onPause();
    com.tencent.mm.plugin.finder.report.live.k localk = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.b(getRlLayout().getRecyclerView(), s.p.voA, s.j.vnR.scene, com.tencent.mm.plugin.finder.report.live.c.vjg);
    AppMethodBeat.o(250238);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(250237);
    super.onResume();
    com.tencent.mm.plugin.finder.report.live.k localk = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.b(getRlLayout().getRecyclerView(), s.p.voA, s.j.vnR.scene, com.tencent.mm.plugin.finder.report.live.c.vjf);
    AppMethodBeat.o(250237);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getHeaderCount", "", "updateState", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(250206);
      AppMethodBeat.o(250206);
    }
    
    public final void dmp()
    {
      AppMethodBeat.i(250204);
      com.tencent.mm.ac.d.a(0L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(250204);
    }
    
    public final int getHeaderCount()
    {
      AppMethodBeat.i(250205);
      RecyclerView.a locala = FinderProfileFeedUIC.access$getRecyclerView$p(FinderProfileFeedUIC.this).getAdapter();
      Object localObject = locala;
      if (!(locala instanceof WxRecyclerAdapter)) {
        localObject = null;
      }
      localObject = (WxRecyclerAdapter)localObject;
      if (localObject != null)
      {
        int i = ((com.tencent.mm.view.recyclerview.g)localObject).RqM.size();
        AppMethodBeat.o(250205);
        return i;
      }
      AppMethodBeat.o(250205);
      return 0;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderProfileFeedUIC.b paramb)
      {
        super();
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1$4$1"})
      static final class a
        implements View.OnClickListener
      {
        a(FinderProfileFeedUIC.b.a parama) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(250202);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RefreshLoadMoreLayout.d(FinderProfileFeedUIC.access$getRlLayout$p(this.vbd.vbc.vbb));
          this.vbd.vbc.dmp();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(250202);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<FinderProfileFeedUIC.b>
  {
    c(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<FinderProfileFeedLoader>
  {
    d(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<hk>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.profile.a>
  {
    f(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class g
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(250212);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(250212);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(250211);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
      com.tencent.mm.plugin.finder.report.live.k.b(paramRecyclerView, s.p.voA, s.j.vnR.scene, com.tencent.mm.plugin.finder.report.live.c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(250211);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$3$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "pos", "", "holder", "plugin-finder_release"})
  public static final class h
    implements g.c<com.tencent.mm.view.recyclerview.h>
  {
    h(FinderProfileFeedUIC.j paramj, FinderProfileFeedUIC paramFinderProfileFeedUIC) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(250214);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(250214);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(250217);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(250217);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(250216);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      FinderProfileFeedUIC.access$getFeedLoader$p(this.vbb).requestLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(250216);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(250215);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      paramc = FinderProfileFeedUIC.access$getRlLayout$p(this.vbb).getRecyclerView();
      localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      paramc.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(250215);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$2", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class j
    extends WxRecyclerAdapter<bo>
  {
    j(com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList)
    {
      super(localArrayList);
    }
    
    public final void n(com.tencent.mm.view.recyclerview.h paramh)
    {
      AppMethodBeat.i(250218);
      p.h(paramh, "holder");
      super.n(paramh);
      Object localObject = paramh.aus;
      p.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if (paramh.lU() != this.vbb.getFILTER_VIEW_TYPE()) {
          break label75;
        }
      }
      label75:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aC(bool);
        AppMethodBeat.o(250218);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "selected", "", "invoke"})
  static final class k
    extends q
    implements m<bds, Boolean, x>
  {
    k(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$6", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(250222);
      FinderProfileFeedUIC.access$getActionCallback$p(this.vbb).dmp();
      AppMethodBeat.o(250222);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    n(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.b<hm, x>
  {
    o(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    p(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
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