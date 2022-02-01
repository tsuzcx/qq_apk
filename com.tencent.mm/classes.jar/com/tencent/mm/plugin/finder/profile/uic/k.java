package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.loader.FinderProfileLiveUserPageLoader;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileReplayLiveUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "actionCallback", "Lcom/tencent/mm/view/BaseViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/BaseViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "continueFlag", "", "getContinueFlag", "()I", "setContinueFlag", "(I)V", "feedChangeListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileReplayLiveUIC$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileReplayLiveUIC$feedChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/live/loader/FinderProfileLiveUserPageLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/live/loader/FinderProfileLiveUserPageLoader;", "feedLoader$delegate", "layoutConfig", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "layoutConfig$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "addInitData", "", "feedList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLayoutId", "jumpToReplayLive", "dataList", "Lcom/tencent/mm/plugin/finder/model/FinderLiveReplayFeed;", "selectFeed", "pos", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends g
{
  private final kotlin.j AYa;
  private final kotlin.j BaO;
  private final kotlin.j CNQ;
  private final kotlin.j FcO;
  private final kotlin.j FcQ;
  private final FinderProfileReplayLiveUIC.feedChangeListener.1 Ffl;
  final String TAG;
  int continueFlag;
  
  public k(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(348830);
    this.TAG = "FinderProfileReplayLiveUIC";
    this.BaO = kotlin.k.cm((kotlin.g.a.a)new h(paramFragment));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.AYa = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.FcO = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.FcQ = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.continueFlag = 1;
    this.Ffl = new FinderProfileReplayLiveUIC.feedChangeListener.1(this, f.hfK);
    AppMethodBeat.o(348830);
  }
  
  private final com.tencent.mm.view.b eKe()
  {
    AppMethodBeat.i(348864);
    com.tencent.mm.view.b localb = (com.tencent.mm.view.b)this.FcQ.getValue();
    AppMethodBeat.o(348864);
    return localb;
  }
  
  private final com.tencent.mm.plugin.finder.profile.a getLayoutConfig()
  {
    AppMethodBeat.i(348854);
    com.tencent.mm.plugin.finder.profile.a locala = (com.tencent.mm.plugin.finder.profile.a)this.FcO.getValue();
    AppMethodBeat.o(348854);
    return locala;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(348846);
    RecyclerView localRecyclerView = (RecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(348846);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(348837);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.BaO.getValue();
    AppMethodBeat.o(348837);
    return localRefreshLoadMoreLayout;
  }
  
  final FinderProfileLiveUserPageLoader eKd()
  {
    AppMethodBeat.i(348898);
    FinderProfileLiveUserPageLoader localFinderProfileLiveUserPageLoader = (FinderProfileLiveUserPageLoader)this.AYa.getValue();
    AppMethodBeat.o(348898);
    return localFinderProfileLiveUserPageLoader;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348911);
    super.onCreate(paramBundle);
    paramBundle = getFragment();
    if (paramBundle == null)
    {
      paramBundle = null;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      eKd().register((com.tencent.mm.view.k)eKe());
      this.Ffl.alive();
      getRlLayout().setEnableRefresh(false);
      getRlLayout().setSuperNestedScroll(true);
      getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new d(this));
      paramBundle = getRlLayout();
      Object localObject = af.mU((Context)getActivity()).inflate(e.f.load_more_footer, null);
      s.s(localObject, "getInflater(activity).in…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject);
      getRecyclerView().setLayoutManager(getLayoutConfig().fT((Context)getActivity()));
      getRecyclerView().a(getLayoutConfig().getItemDecoration());
      getRecyclerView().setRecycledViewPool(getLayoutConfig().j((MMActivity)getActivity()));
      paramBundle = getRecyclerView();
      localObject = new WxRecyclerAdapter(getLayoutConfig().ech(), (ArrayList)eKd().getDataListJustForAdapter());
      ((i)localObject).agOe = ((i.c)new e(this));
      ah localah = ah.aiuX;
      paramBundle.setAdapter((RecyclerView.a)localObject);
      eKd().fetchEndCallback = ((kotlin.g.a.b)new f(this));
      AppMethodBeat.o(348911);
      return;
    }
    paramBundle = paramBundle.getView();
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.findViewById(e.e.profile_loading_state_container))
    {
      paramBundle = (FrameLayout)paramBundle;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(348923);
    super.onDestroy();
    this.Ffl.dead();
    eKd().unregister((com.tencent.mm.view.k)eKe());
    AppMethodBeat.o(348923);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/BaseViewActionCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.view.b>
  {
    a(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/loader/FinderProfileLiveUserPageLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<FinderProfileLiveUserPageLoader>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.profile.a>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileReplayLiveUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RefreshLoadMoreLayout.b
  {
    d(k paramk) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(348986);
      super.IH(paramInt);
      k.a(this.Ffm).requestRefresh();
      AppMethodBeat.o(348986);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(348996);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      paramd = k.b(this.Ffm).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramd, locala.aYi(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileReplayLiveUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      paramd.scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramd, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileReplayLiveUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(348996);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(349007);
      super.qI(paramInt);
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)k.a(this.Ffm), false, 1, null);
      AppMethodBeat.o(349007);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileReplayLiveUIC$onCreate$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "pos", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    e(k paramk) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    f(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    g(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    h(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.k
 * JD-Core Version:    0.7.0.1
 */