package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.convert.cd;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileQQMusicLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bt;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "qqMusicAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "qqMusicLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader;", "getQqMusicLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader;", "qqMusicLoader$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "Landroid/widget/FrameLayout;", "getLayoutId", "", "initLayout", "", "initLoading", "jumpToMusic", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderQQMusicInfoData;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchEnd", "Companion", "ViewActionCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends g
{
  public static final a Ffg;
  private final kotlin.j BaO;
  private final kotlin.j CNQ;
  private final kotlin.j FcQ;
  private FrameLayout FcY;
  private WxRecyclerAdapter<cc> Ffh;
  private final kotlin.j Ffi;
  
  static
  {
    AppMethodBeat.i(348919);
    Ffg = new a((byte)0);
    AppMethodBeat.o(348919);
  }
  
  public j(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(348833);
    this.BaO = kotlin.k.cm((kotlin.g.a.a)new j(paramFragment));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.Ffi = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.FcQ = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(348833);
  }
  
  private final FinderProfileQQMusicLoader eKb()
  {
    AppMethodBeat.i(348851);
    FinderProfileQQMusicLoader localFinderProfileQQMusicLoader = (FinderProfileQQMusicLoader)this.Ffi.getValue();
    AppMethodBeat.o(348851);
    return localFinderProfileQQMusicLoader;
  }
  
  private final b eKc()
  {
    AppMethodBeat.i(348861);
    b localb = (b)this.FcQ.getValue();
    AppMethodBeat.o(348861);
    return localb;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(348843);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.BaO.getValue();
    AppMethodBeat.o(348843);
    return localRefreshLoadMoreLayout;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_qq_music_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348926);
    super.onCreate(paramBundle);
    eKb().register((com.tencent.mm.view.k)eKc());
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setSuperNestedScroll(true);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new d(this));
    paramBundle = getRlLayout();
    View localView = af.mU((Context)getActivity()).inflate(e.f.load_more_footer, null);
    s.s(localView, "getInflater(activity).in…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter(localView);
    this.Ffh = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new e(this), (ArrayList)eKb().getDataListJustForAdapter(), true);
    paramBundle = this.Ffh;
    if (paramBundle != null) {
      paramBundle.agOe = ((i.c)new f(this));
    }
    paramBundle = (RecyclerView)this.CNQ.getValue();
    getActivity();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.setAdapter((RecyclerView.a)this.Ffh);
    paramBundle = eKb();
    if (paramBundle != null) {
      paramBundle.BbB = ((kotlin.g.a.a)new g(this));
    }
    this.FcY = ((FrameLayout)findViewById(e.e.profile_loading_state_container));
    paramBundle = this.FcY;
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(e.d.finder_profile_gradient_bg);
    }
    paramBundle = this.FcY;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    eKb().onAlive();
    BaseFeedLoader.requestInit$default((BaseFeedLoader)eKb(), false, 1, null);
    eKb().requestRefresh();
    AppMethodBeat.o(348926);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(348930);
    super.onDestroy();
    eKb().onDead();
    eKb().unregister((com.tencent.mm.view.k)eKc());
    AppMethodBeat.o(348930);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(348643);
      AppMethodBeat.o(348643);
    }
    
    public final void evt()
    {
      AppMethodBeat.i(348647);
      d.a(0L, (kotlin.g.a.a)new a(j.this, this));
      AppMethodBeat.o(348647);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(j paramj, j.b paramb)
      {
        super();
      }
      
      private static final void a(j paramj, j.b paramb, View paramView)
      {
        AppMethodBeat.i(348669);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramj);
        localb.cH(paramb);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramj, "this$0");
        s.u(paramb, "this$1");
        paramj = j.b(paramj);
        s.s(paramj, "rlLayout");
        RefreshLoadMoreLayout.a(paramj, 0, 3);
        paramb.evt();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(348669);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<j.b>
  {
    c(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC$initLayout$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RefreshLoadMoreLayout.b
  {
    d(j paramj) {}
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(348695);
      super.qI(paramInt);
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)j.a(this.Ffj), false, 1, null);
      AppMethodBeat.o(348695);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC$initLayout$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.view.recyclerview.g
  {
    e(j paramj) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(348685);
      if (paramInt == bt.class.getName().hashCode())
      {
        localObject = new cd();
        ((cd)localObject).ALZ = Boolean.valueOf(this.Ffj.isSelfFlag());
        localObject = (com.tencent.mm.view.recyclerview.f)localObject;
        AppMethodBeat.o(348685);
        return localObject;
      }
      s.checkNotNull(null);
      Object localObject = new kotlin.f();
      AppMethodBeat.o(348685);
      throw ((Throwable)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileQQMusicUIC$initLayout$3$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    f(j paramj) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<FinderProfileQQMusicLoader>
  {
    h(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    i(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    j(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.j
 * JD-Core Version:    0.7.0.1
 */