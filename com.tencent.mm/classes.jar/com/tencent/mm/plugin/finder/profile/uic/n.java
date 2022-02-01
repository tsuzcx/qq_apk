package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileShopLoader;
import com.tencent.mm.plugin.finder.model.bp;
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/view/BaseViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/BaseViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader;", "feedLoader$delegate", "layoutConfig", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "layoutConfig$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "addInitData", "", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/FinderShopFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLayoutId", "", "jumpToShop", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class n
  extends i
{
  private final kotlin.f xAp;
  private final kotlin.f xDO;
  private final kotlin.f zQB;
  private final kotlin.f zQD;
  private final kotlin.f zQF;
  
  public n(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(288300);
    this.xDO = g.ar((kotlin.g.a.a)new i(paramFragment));
    this.zQD = g.ar((kotlin.g.a.a)new h(this));
    this.xAp = g.ar((kotlin.g.a.a)new b(this));
    this.zQB = g.ar((kotlin.g.a.a)new c(this));
    this.zQF = g.ar((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(288300);
  }
  
  private final com.tencent.mm.view.b dOK()
  {
    AppMethodBeat.i(288297);
    com.tencent.mm.view.b localb = (com.tencent.mm.view.b)this.zQF.getValue();
    AppMethodBeat.o(288297);
    return localb;
  }
  
  private final com.tencent.mm.plugin.finder.profile.a getLayoutConfig()
  {
    AppMethodBeat.i(288296);
    com.tencent.mm.plugin.finder.profile.a locala = (com.tencent.mm.plugin.finder.profile.a)this.zQB.getValue();
    AppMethodBeat.o(288296);
    return locala;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(288294);
    RecyclerView localRecyclerView = (RecyclerView)this.zQD.getValue();
    AppMethodBeat.o(288294);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(288293);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.xDO.getValue();
    AppMethodBeat.o(288293);
    return localRefreshLoadMoreLayout;
  }
  
  public final FinderProfileShopLoader dOJ()
  {
    AppMethodBeat.i(288295);
    FinderProfileShopLoader localFinderProfileShopLoader = (FinderProfileShopLoader)this.xAp.getValue();
    AppMethodBeat.o(288295);
    return localFinderProfileShopLoader;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_profile_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(288298);
    super.onCreate(paramBundle);
    paramBundle = getFragment();
    if (paramBundle != null)
    {
      paramBundle = (FrameLayout)paramBundle.getView().findViewById(b.f.profile_loading_state_container);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    dOJ().register((j)dOK());
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setSuperNestedScroll(true);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new e(this));
    paramBundle = getRlLayout();
    Object localObject = ad.kS((Context)getActivity()).inflate(b.g.load_more_footer, null);
    p.j(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject);
    getRecyclerView().setLayoutManager(getLayoutConfig().eW((Context)getActivity()));
    getRecyclerView().b(getLayoutConfig().getItemDecoration());
    paramBundle = getRecyclerView();
    localObject = getLayoutConfig();
    AppCompatActivity localAppCompatActivity = getActivity();
    if (localAppCompatActivity == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(288298);
      throw paramBundle;
    }
    paramBundle.setRecycledViewPool(((com.tencent.mm.plugin.finder.profile.a)localObject).g((MMActivity)localAppCompatActivity));
    paramBundle = getRecyclerView();
    localObject = new WxRecyclerAdapter(getLayoutConfig().dtg(), (ArrayList)dOJ().getDataListJustForAdapter());
    ((h)localObject).YSn = ((h.c)new d(this));
    paramBundle.setAdapter((RecyclerView.a)localObject);
    com.tencent.mm.view.f.a(getRecyclerView(), (e.a)new f(this));
    dOJ().xEI = ((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(288298);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(288299);
    super.onDestroy();
    dOJ().unregister((j)dOK());
    AppMethodBeat.o(288299);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/BaseViewActionCallback;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<com.tencent.mm.view.b>
  {
    a(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<FinderProfileShopLoader>
  {
    b(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.profile.a>
  {
    c(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "pos", "", "holder", "plugin-finder_release"})
  public static final class d
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {
    d(n paramn) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(276096);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      n.a(this.zTm).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(276096);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(276101);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(276101);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(276099);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      n.a(this.zTm).requestLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(276099);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(276097);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      paramc = n.b(this.zTm).getRecyclerView();
      localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramc, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      paramc.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(276097);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$3", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public static final class f
    extends e.a
  {
    private final HashSet<Long> xlV;
    
    f()
    {
      AppMethodBeat.i(291405);
      this.xlV = new HashSet();
      AppMethodBeat.o(291405);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(291404);
      p.k(paramView, "parent");
      p.k(paramList, "exposedHolders");
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        paramList = (RecyclerView.v)localIterator.next();
        paramView = paramList;
        if (!(paramList instanceof com.tencent.mm.view.recyclerview.i)) {
          paramView = null;
        }
        paramView = (com.tencent.mm.view.recyclerview.i)paramView;
        if (paramView != null)
        {
          paramList = paramView.ihX();
          paramView = paramList;
          if (!(paramList instanceof bp)) {
            paramView = null;
          }
          paramView = (bp)paramView;
          if ((paramView != null) && (!this.xlV.contains(Long.valueOf(paramView.zBn.zaO))))
          {
            this.xlV.add(Long.valueOf(paramView.zBn.zaO));
            paramList = am.zZN;
            paramList = this.zTm.getContextObj();
            com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
            locali.g("finderusername", this.zTm.getUsername());
            locali.g("productid", d.Fw(paramView.zBn.zaO));
            am.a(paramList, "poster_prod", false, (JSONObject)locali);
          }
        }
      }
      AppMethodBeat.o(291404);
    }
    
    public final boolean dpC()
    {
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    h(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    i(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.n
 * JD-Core Version:    0.7.0.1
 */