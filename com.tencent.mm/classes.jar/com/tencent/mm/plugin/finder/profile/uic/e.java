package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileDraftLoader;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "draftAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getDraftAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setDraftAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "draftLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "getDraftLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "draftLoader$delegate", "mainFlowLayout", "Landroid/widget/FrameLayout;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "getLayoutId", "", "initStatusView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchEnd", "onResume", "onUserVisibleFocused", "showFooter", "showPopupMenu", "draftInfoData", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "anchor", "Landroid/view/View;", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class e
  extends i
{
  public static final a zQS;
  private com.tencent.mm.ui.widget.b.a szq;
  private final kotlin.f xDO;
  private final kotlin.f zQD;
  private final kotlin.f zQF;
  private FrameLayout zQO;
  private FrameLayout zQP;
  private WxRecyclerAdapter<bu> zQQ;
  private final kotlin.f zQR;
  
  static
  {
    AppMethodBeat.i(284746);
    zQS = new a((byte)0);
    AppMethodBeat.o(284746);
  }
  
  public e(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(284745);
    this.xDO = kotlin.g.ar((kotlin.g.a.a)new k(paramFragment));
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.zQF = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.zQR = kotlin.g.ar((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(284745);
  }
  
  private final b dNr()
  {
    AppMethodBeat.i(284737);
    b localb = (b)this.zQF.getValue();
    AppMethodBeat.o(284737);
    return localb;
  }
  
  private final void dNt()
  {
    AppMethodBeat.i(284744);
    View localView = getRlLayout().getLoadMoreFooter();
    if (localView != null)
    {
      localView.setVisibility(0);
      localView.setBackgroundColor(localView.getResources().getColor(b.c.white));
      Object localObject = localView.findViewById(b.f.load_more_footer_tip_tv);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = (TextView)localView.findViewById(b.f.draft_center_text);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)localView.getResources().getString(b.j.finder_draft_footer));
      }
      localView = localView.findViewById(b.f.load_more_footer_end_layout);
      if (localView != null)
      {
        localView.setVisibility(0);
        AppMethodBeat.o(284744);
        return;
      }
      AppMethodBeat.o(284744);
      return;
    }
    AppMethodBeat.o(284744);
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(284736);
    RecyclerView localRecyclerView = (RecyclerView)this.zQD.getValue();
    AppMethodBeat.o(284736);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(284735);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.xDO.getValue();
    AppMethodBeat.o(284735);
    return localRefreshLoadMoreLayout;
  }
  
  public final FinderProfileDraftLoader dNs()
  {
    AppMethodBeat.i(284738);
    FinderProfileDraftLoader localFinderProfileDraftLoader = (FinderProfileDraftLoader)this.zQR.getValue();
    AppMethodBeat.o(284738);
    return localFinderProfileDraftLoader;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_profile_music_draft_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(284740);
    super.onCreate(paramBundle);
    dNs().register((j)dNr());
    this.zQO = ((FrameLayout)findViewById(b.f.main_flow_layout));
    this.zQP = ((FrameLayout)findViewById(b.f.profile_loading_state_container));
    paramBundle = this.zQP;
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(b.e.finder_profile_gradient_bg);
    }
    paramBundle = this.zQP;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    this.szq = new com.tencent.mm.ui.widget.b.a((Context)getActivity());
    getRlLayout().setSuperNestedScroll(true);
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setEnableLoadMore(false);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new e(this));
    paramBundle = getRlLayout();
    View localView = ad.kS((Context)getActivity()).inflate(b.g.finder_draft_footer, null);
    p.j(localView, "MMLayoutInflater.getInfl…inder_draft_footer, null)");
    paramBundle.setLoadMoreFooter(localView);
    paramBundle = getRecyclerView();
    getActivity();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.zQQ = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new f(), (ArrayList)dNs().getDataListJustForAdapter(), true);
    getRecyclerView().setAdapter((RecyclerView.a)this.zQQ);
    paramBundle = this.zQQ;
    if (paramBundle != null) {
      paramBundle.YSn = ((h.c)new g(this));
    }
    paramBundle = this.zQQ;
    if (paramBundle != null) {
      paramBundle.YSm = ((h.d)new h(this));
    }
    dNs().xEI = ((kotlin.g.a.a)new i(this));
    AppMethodBeat.o(284740);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(284743);
    super.onDestroy();
    dNs().unregister((j)dNr());
    AppMethodBeat.o(284743);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(284741);
    super.onResume();
    dNs().requestInit(false);
    AppMethodBeat.o(284741);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(284742);
    super.onUserVisibleFocused();
    AppMethodBeat.o(284742);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$Companion;", "", "()V", "MENU_ID_REMOVE_LIST", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(281961);
      AppMethodBeat.o(281961);
    }
    
    public final void dFf()
    {
      AppMethodBeat.i(281959);
      d.a(0L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(281959);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(e.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<e.b>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FinderProfileDraftLoader>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(288735);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      this.zQT.dNs().requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(288735);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(288739);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(288739);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(288738);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      this.zQT.dNs().requestLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(288738);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(288736);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      paramc = e.b(this.zQT).getRecyclerView();
      localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramc, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      paramc.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(288736);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(282713);
      if (paramInt == com.tencent.mm.plugin.finder.model.q.class.getName().hashCode())
      {
        com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.e();
        AppMethodBeat.o(282713);
        return locale;
      }
      p.iCn();
      AppMethodBeat.o(282713);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class g
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class h
    implements h.d<com.tencent.mm.view.recyclerview.i>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RecyclerView>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    k(Fragment paramFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class l
    implements View.OnCreateContextMenuListener
  {
    l(e parame) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(286579);
      paramContextMenu.add(0, 1001, 0, (CharSequence)this.zQT.getString(b.j.finder_del_fans));
      AppMethodBeat.o(286579);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class m
    implements q.g
  {
    m(e parame, com.tencent.mm.plugin.finder.model.q paramq) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(284591);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(284591);
        return;
        long l = this.zQW.zAj.field_localId;
        paramMenuItem = com.tencent.mm.plugin.finder.storage.i.AkK;
        com.tencent.mm.plugin.finder.storage.i.MG(l);
        paramMenuItem = d.Fw(l);
        com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
        ((f)com.tencent.mm.ui.component.g.b(this.zQT.getActivity()).i(f.class)).M("draftdelete", 1, paramMenuItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.e
 * JD-Core Version:    0.7.0.1
 */