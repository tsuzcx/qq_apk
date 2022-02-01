package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.a.no;
import com.tencent.mm.f.a.np;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.convert.ce;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileMusicLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bi;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "layoutConfig", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "layoutConfig$delegate", "mainFlowLayout", "Landroid/widget/FrameLayout;", "musicAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "musicCheckErrorListener", "Lcom/tencent/mm/sdk/event/IListener;", "musicLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "getMusicLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "musicLoader$delegate", "musicPlayEventListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$musicPlayEventListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$musicPlayEventListener$1;", "musicSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicThumbUrl", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "getLayoutId", "", "initLayout", "", "initLoading", "initPlayParam", "musicObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchEnd", "onPause", "onResume", "processPlayError", "errMsg", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class l
  extends i
{
  public static final a zTh;
  private final IListener<?> wNM;
  private final kotlin.f xDO;
  private final kotlin.f zQB;
  private final kotlin.f zQD;
  private final kotlin.f zQF;
  private FrameLayout zQO;
  private FrameLayout zQP;
  private WxRecyclerAdapter<bu> zTc;
  private final kotlin.f zTd;
  private String zTe;
  private bds zTf;
  private final k zTg;
  
  static
  {
    AppMethodBeat.i(278856);
    zTh = new a((byte)0);
    AppMethodBeat.o(278856);
  }
  
  public l(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(278854);
    this.zQB = g.ar((kotlin.g.a.a)new h(this));
    this.xDO = g.ar((kotlin.g.a.a)new m(paramFragment));
    this.zQD = g.ar((kotlin.g.a.a)new l(this));
    this.zTd = g.ar((kotlin.g.a.a)new j(this));
    this.zQF = g.ar((kotlin.g.a.a)new c(this));
    this.zTg = new k(this);
    this.wNM = ((IListener)new i(this));
    AppMethodBeat.o(278854);
  }
  
  private final FinderProfileMusicLoader dOH()
  {
    AppMethodBeat.i(278843);
    FinderProfileMusicLoader localFinderProfileMusicLoader = (FinderProfileMusicLoader)this.zTd.getValue();
    AppMethodBeat.o(278843);
    return localFinderProfileMusicLoader;
  }
  
  private final b dOI()
  {
    AppMethodBeat.i(278844);
    b localb = (b)this.zQF.getValue();
    AppMethodBeat.o(278844);
    return localb;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(278842);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.xDO.getValue();
    AppMethodBeat.o(278842);
    return localRefreshLoadMoreLayout;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_profile_music_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278846);
    super.onCreate(paramBundle);
    paramBundle = aa.Amg;
    aa.dYQ();
    dOH().register((j)dOI());
    this.zQO = ((FrameLayout)findViewById(b.f.main_flow_layout));
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setSuperNestedScroll(true);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new e(this));
    paramBundle = getRlLayout();
    View localView = ad.kS((Context)getActivity()).inflate(b.g.load_more_footer, null);
    p.j(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter(localView);
    paramBundle = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new f(this), (ArrayList)dOH().getDataListJustForAdapter(), true);
    paramBundle.YSn = ((h.c)new d(paramBundle, this));
    this.zTc = paramBundle;
    paramBundle = (RecyclerView)this.zQD.getValue();
    getActivity();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.setAdapter((RecyclerView.a)this.zTc);
    dOH().xEI = ((kotlin.g.a.a)new g(this));
    this.zQP = ((FrameLayout)findViewById(b.f.profile_loading_state_container));
    paramBundle = this.zQP;
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(b.e.finder_profile_gradient_bg);
    }
    paramBundle = this.zQP;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    BaseFeedLoader.requestInit$default(dOH(), false, 1, null);
    dOH().requestRefresh();
    AppMethodBeat.o(278846);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(278848);
    super.onDestroy();
    dOH().unregister((j)dOI());
    AppMethodBeat.o(278848);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(278851);
    super.onPause();
    this.zTg.dead();
    this.wNM.dead();
    AppMethodBeat.o(278851);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(278849);
    super.onResume();
    this.zTg.alive();
    this.wNM.alive();
    AppMethodBeat.o(278849);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(279797);
      AppMethodBeat.o(279797);
    }
    
    public final void dFf()
    {
      AppMethodBeat.i(279795);
      d.a(0L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(279795);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(l.b paramb)
      {
        super();
      }
      
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1$4$1"})
      static final class a
        implements View.OnClickListener
      {
        a(l.b.a parama) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(271611);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          RefreshLoadMoreLayout.d(l.c(this.zTk.zTj.zTi));
          this.zTk.zTj.dFf();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(271611);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<l.b>
  {
    c(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$3$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class d
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {
    d(WxRecyclerAdapter paramWxRecyclerAdapter, l paraml) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(283768);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(283768);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(283772);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(283772);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(283771);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      l.a(this.zTi).requestLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(283771);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(283769);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(283769);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(282299);
      if (paramInt == bi.class.getName().hashCode())
      {
        Object localObject = new ce();
        ((ce)localObject).xor = Boolean.valueOf(this.zTi.isSelfFlag());
        localObject = (e)localObject;
        AppMethodBeat.o(282299);
        return localObject;
      }
      p.iCn();
      AppMethodBeat.o(282299);
      return null;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.profile.a>
  {
    h(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$musicCheckErrorListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicCheckErrorEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends IListener<no>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<FinderProfileMusicLoader>
  {
    j(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$musicPlayEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class k
    extends IListener<np>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    l(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    m(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.l
 * JD-Core Version:    0.7.0.1
 */