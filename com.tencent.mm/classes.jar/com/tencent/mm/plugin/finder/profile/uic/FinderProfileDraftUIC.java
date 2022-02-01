package com.tencent.mm.plugin.finder.profile.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileDraftLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "draftAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getDraftAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setDraftAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "draftLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "getDraftLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "draftLoader$delegate", "mainFlowLayout", "Landroid/widget/FrameLayout;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "getLayoutId", "", "initStatusView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchEnd", "onUserVisibleFocused", "showPopupMenu", "draftInfoData", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "anchor", "Landroid/view/View;", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class FinderProfileDraftUIC
  extends FinderProfileFragmentUIC
{
  public static final a vaK;
  private com.tencent.mm.ui.widget.b.a pqr;
  private final kotlin.f tSX;
  private FrameLayout vaG;
  private FrameLayout vaH;
  private WxRecyclerAdapter<bo> vaI;
  private final kotlin.f vaJ;
  private final kotlin.f vau;
  private final kotlin.f vaw;
  
  static
  {
    AppMethodBeat.i(250168);
    vaK = new a((byte)0);
    AppMethodBeat.o(250168);
  }
  
  public FinderProfileDraftUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(250167);
    this.tSX = kotlin.g.ah((kotlin.g.a.a)new k(paramFragment));
    this.vau = kotlin.g.ah((kotlin.g.a.a)new j(this));
    this.vaw = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.vaJ = kotlin.g.ah((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(250167);
  }
  
  private final b dmq()
  {
    AppMethodBeat.i(250162);
    b localb = (b)this.vaw.getValue();
    AppMethodBeat.o(250162);
    return localb;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(250161);
    RecyclerView localRecyclerView = (RecyclerView)this.vau.getValue();
    AppMethodBeat.o(250161);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(250160);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.tSX.getValue();
    AppMethodBeat.o(250160);
    return localRefreshLoadMoreLayout;
  }
  
  public final FinderProfileDraftLoader dmr()
  {
    AppMethodBeat.i(250163);
    FinderProfileDraftLoader localFinderProfileDraftLoader = (FinderProfileDraftLoader)this.vaJ.getValue();
    AppMethodBeat.o(250163);
    return localFinderProfileDraftLoader;
  }
  
  public final int getLayoutId()
  {
    return 2131494590;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250164);
    super.onCreate(paramBundle);
    dmr().register((j)dmq());
    this.vaG = ((FrameLayout)findViewById(2131304322));
    this.vaH = ((FrameLayout)findViewById(2131306216));
    paramBundle = this.vaH;
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(2131232704);
    }
    paramBundle = this.vaH;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    this.pqr = new com.tencent.mm.ui.widget.b.a((Context)getActivity());
    getRlLayout().setSuperNestedScroll(true);
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setEnableLoadMore(false);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new e(this));
    paramBundle = getRlLayout();
    View localView = aa.jQ((Context)getActivity()).inflate(2131494235, null);
    p.g(localView, "MMLayoutInflater.getInfl…inder_draft_footer, null)");
    paramBundle.setLoadMoreFooter(localView);
    paramBundle = getRecyclerView();
    getActivity();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.vaI = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new f(), (ArrayList)dmr().getDataListJustForAdapter(), true);
    getRecyclerView().setAdapter((RecyclerView.a)this.vaI);
    paramBundle = this.vaI;
    if (paramBundle != null) {
      paramBundle.RqP = ((g.c)new g(this));
    }
    paramBundle = this.vaI;
    if (paramBundle != null) {
      paramBundle.RqO = ((g.d)new h(this));
    }
    dmr().tTS = ((kotlin.g.a.a)new i(this));
    dmr().requestInit(false);
    AppMethodBeat.o(250164);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250166);
    super.onDestroy();
    dmr().unregister((j)dmq());
    AppMethodBeat.o(250166);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(250165);
    super.onUserVisibleFocused();
    AppMethodBeat.o(250165);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$Companion;", "", "()V", "MENU_ID_REMOVE_LIST", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(250144);
      AppMethodBeat.o(250144);
    }
    
    public final void dmp()
    {
      AppMethodBeat.i(250143);
      d.a(0L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(250143);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderProfileDraftUIC.b paramb)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FinderProfileDraftUIC.b>
  {
    c(FinderProfileDraftUIC paramFinderProfileDraftUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FinderProfileDraftLoader>
  {
    d(FinderProfileDraftUIC paramFinderProfileDraftUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(250147);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      this.vaL.dmr().requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(250147);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(250150);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(250150);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(250149);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      this.vaL.dmr().requestLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(250149);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(250148);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      paramc = FinderProfileDraftUIC.b(this.vaL).getRecyclerView();
      localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      paramc.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(250148);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(250151);
      if (paramInt == com.tencent.mm.plugin.finder.model.q.class.getName().hashCode())
      {
        com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.e();
        AppMethodBeat.o(250151);
        return locale;
      }
      p.hyc();
      AppMethodBeat.o(250151);
      return null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class g
    implements g.c<com.tencent.mm.view.recyclerview.h>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class h
    implements g.d<com.tencent.mm.view.recyclerview.h>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(FinderProfileDraftUIC paramFinderProfileDraftUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RecyclerView>
  {
    j(FinderProfileDraftUIC paramFinderProfileDraftUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    k(Fragment paramFragment)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class l
    implements View.OnCreateContextMenuListener
  {
    l(FinderProfileDraftUIC paramFinderProfileDraftUIC) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(250158);
      paramContextMenu.add(0, 1001, 0, (CharSequence)this.vaL.getString(2131759661));
      AppMethodBeat.o(250158);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class m
    implements o.g
  {
    m(FinderProfileDraftUIC paramFinderProfileDraftUIC, com.tencent.mm.plugin.finder.model.q paramq) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(250159);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(250159);
        return;
        long l = this.vaO.uNV.field_localId;
        paramMenuItem = com.tencent.mm.plugin.finder.storage.h.vDp;
        com.tencent.mm.plugin.finder.storage.h.Fx(l);
        paramMenuItem = d.zs(l);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        ((FinderProfileEduUIC)com.tencent.mm.ui.component.a.b(this.vaL.getActivity()).get(FinderProfileEduUIC.class)).gP("draftdelete", paramMenuItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileDraftUIC
 * JD-Core Version:    0.7.0.1
 */