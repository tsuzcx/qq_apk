package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "feedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "feedLoader$delegate", "layoutConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "layoutConfig$delegate", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/RecyclerView$LayoutManager;", "layoutManager$delegate", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "removeFeedEventListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "Landroid/widget/FrameLayout;", "getStateLayout", "()Landroid/widget/FrameLayout;", "stateLayout$delegate", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onUserVisibleFocused", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class FinderProfileAtFeedUIC
  extends FinderProfileFragmentUIC
{
  public static final a vay;
  private final f tPy;
  private final f tSX;
  private final f vas;
  private final f vat;
  private final f vau;
  private final f vav;
  private final f vaw;
  private final k vax;
  
  static
  {
    AppMethodBeat.i(250124);
    vay = new a((byte)0);
    AppMethodBeat.o(250124);
  }
  
  public FinderProfileAtFeedUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(250123);
    this.tPy = g.ah((kotlin.g.a.a)new d(this));
    this.vas = g.ah((kotlin.g.a.a)new e(this));
    this.vat = g.ah((kotlin.g.a.a)new f(this));
    this.tSX = g.ah((kotlin.g.a.a)new l(paramFragment));
    this.vau = g.ah((kotlin.g.a.a)new j(this));
    this.vav = g.ah((kotlin.g.a.a)new m(paramFragment));
    this.vaw = g.ah((kotlin.g.a.a)new c(this));
    this.vax = new k(this);
    AppMethodBeat.o(250123);
  }
  
  private final FinderAtFeedLoader dmm()
  {
    AppMethodBeat.i(250115);
    FinderAtFeedLoader localFinderAtFeedLoader = (FinderAtFeedLoader)this.tPy.getValue();
    AppMethodBeat.o(250115);
    return localFinderAtFeedLoader;
  }
  
  private final af dmn()
  {
    AppMethodBeat.i(250116);
    af localaf = (af)this.vas.getValue();
    AppMethodBeat.o(250116);
    return localaf;
  }
  
  private final b dmo()
  {
    AppMethodBeat.i(250119);
    b localb = (b)this.vaw.getValue();
    AppMethodBeat.o(250119);
    return localb;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(250118);
    RecyclerView localRecyclerView = (RecyclerView)this.vau.getValue();
    AppMethodBeat.o(250118);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(250117);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.tSX.getValue();
    AppMethodBeat.o(250117);
    return localRefreshLoadMoreLayout;
  }
  
  public final int getLayoutId()
  {
    return 2131494586;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250120);
    super.onCreate(paramBundle);
    dmm().register((j)dmo());
    getRlLayout().setSuperNestedScroll(true);
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    paramBundle = getRlLayout();
    Object localObject = aa.jQ((Context)getActivity()).inflate(2131495297, null);
    p.g(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject);
    getRecyclerView().setLayoutManager((RecyclerView.LayoutManager)this.vat.getValue());
    getRecyclerView().b(dmn().getItemDecoration());
    paramBundle = getRecyclerView();
    localObject = dmn();
    AppCompatActivity localAppCompatActivity = getActivity();
    if (localAppCompatActivity == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(250120);
      throw paramBundle;
    }
    paramBundle.setRecycledViewPool(((af)localObject).f((MMActivity)localAppCompatActivity));
    getRecyclerView().setAdapter((RecyclerView.a)new WxRecyclerAdapter(dmn().dcK(), (ArrayList)dmm().getDataListJustForAdapter()));
    dmm().setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new h(this));
    dmm().tTS = ((kotlin.g.a.a)new i(this));
    BaseFeedLoader.requestInit$default(dmm(), false, 1, null);
    dmm().requestRefresh();
    this.vax.alive();
    AppMethodBeat.o(250120);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250122);
    super.onDestroy();
    dmm().unregister((j)dmo());
    dmm().onDead();
    this.vax.dead();
    AppMethodBeat.o(250122);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(250121);
    super.onUserVisibleFocused();
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
    if (p.j(getUsername(), z.aUg())) {}
    for (int i = 1;; i = 0)
    {
      localh.a(21206, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      AppMethodBeat.o(250121);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(250100);
      AppMethodBeat.o(250100);
    }
    
    public final void dmp()
    {
      AppMethodBeat.i(250099);
      d.a(0L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(250099);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderProfileAtFeedUIC.b paramb)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<FinderProfileAtFeedUIC.b>
  {
    c(FinderProfileAtFeedUIC paramFinderProfileAtFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<FinderAtFeedLoader>
  {
    d(FinderProfileAtFeedUIC paramFinderProfileAtFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<af>
  {
    e(FinderProfileAtFeedUIC paramFinderProfileAtFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<RecyclerView.LayoutManager>
  {
    f(FinderProfileAtFeedUIC paramFinderProfileAtFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "plugin-finder_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(250105);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      FinderProfileAtFeedUIC.b(this.vaz).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(250105);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(250108);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(250108);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(250106);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      FinderProfileAtFeedUIC.b(this.vaz).requestLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(250106);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(250107);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(250107);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(250109);
      FinderProfileAtFeedUIC.d(this.vaz).dmp();
      AppMethodBeat.o(250109);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(FinderProfileAtFeedUIC paramFinderProfileAtFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    j(FinderProfileAtFeedUIC paramFinderProfileAtFeedUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class k
    extends IListener<hl>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    l(Fragment paramFragment)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<FrameLayout>
  {
    m(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileAtFeedUIC
 * JD-Core Version:    0.7.0.1
 */