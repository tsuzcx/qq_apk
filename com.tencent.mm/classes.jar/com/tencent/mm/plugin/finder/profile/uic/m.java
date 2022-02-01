package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileShopLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bw;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.b;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.f;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/view/BaseViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/BaseViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader;", "feedLoader$delegate", "layoutConfig", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "layoutConfig$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "addInitData", "", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/FinderShopFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLayoutId", "", "jumpToShop", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends g
{
  private final kotlin.j AYa;
  private final kotlin.j BaO;
  private final kotlin.j CNQ;
  private final kotlin.j FcO;
  private final kotlin.j FcQ;
  
  public m(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(348826);
    this.BaO = kotlin.k.cm((kotlin.g.a.a)new i(paramFragment));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.AYa = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.FcO = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.FcQ = kotlin.k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(348826);
  }
  
  private final b eKe()
  {
    AppMethodBeat.i(348857);
    b localb = (b)this.FcQ.getValue();
    AppMethodBeat.o(348857);
    return localb;
  }
  
  private final com.tencent.mm.plugin.finder.profile.a getLayoutConfig()
  {
    AppMethodBeat.i(348848);
    com.tencent.mm.plugin.finder.profile.a locala = (com.tencent.mm.plugin.finder.profile.a)this.FcO.getValue();
    AppMethodBeat.o(348848);
    return locala;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(348839);
    RecyclerView localRecyclerView = (RecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(348839);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(348831);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.BaO.getValue();
    AppMethodBeat.o(348831);
    return localRefreshLoadMoreLayout;
  }
  
  public final FinderProfileShopLoader eKi()
  {
    AppMethodBeat.i(348883);
    FinderProfileShopLoader localFinderProfileShopLoader = (FinderProfileShopLoader)this.AYa.getValue();
    AppMethodBeat.o(348883);
    return localFinderProfileShopLoader;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348897);
    super.onCreate(paramBundle);
    paramBundle = getFragment();
    if (paramBundle == null)
    {
      paramBundle = null;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      eKi().register((com.tencent.mm.view.k)eKe());
      getRlLayout().setEnableRefresh(false);
      getRlLayout().setSuperNestedScroll(true);
      getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new d(this));
      paramBundle = getRlLayout();
      Object localObject = af.mU((Context)getActivity()).inflate(e.f.load_more_footer, null);
      kotlin.g.b.s.s(localObject, "getInflater(activity).in…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject);
      getRecyclerView().setLayoutManager(getLayoutConfig().fT((Context)getActivity()));
      getRecyclerView().a(getLayoutConfig().getItemDecoration());
      getRecyclerView().setRecycledViewPool(getLayoutConfig().j((MMActivity)getActivity()));
      paramBundle = getRecyclerView();
      localObject = new WxRecyclerAdapter(getLayoutConfig().ech(), (ArrayList)eKi().getDataListJustForAdapter());
      ((com.tencent.mm.view.recyclerview.i)localObject).agOe = ((i.c)new e(this));
      ah localah = ah.aiuX;
      paramBundle.setAdapter((RecyclerView.a)localObject);
      f.a(getRecyclerView(), (e.a)new f(this));
      eKi().BbB = ((kotlin.g.a.a)new g(this));
      AppMethodBeat.o(348897);
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
    AppMethodBeat.i(348901);
    super.onDestroy();
    eKi().unregister((com.tencent.mm.view.k)eKe());
    AppMethodBeat.o(348901);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/BaseViewActionCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<b>
  {
    a(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<FinderProfileShopLoader>
  {
    b(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.profile.a>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RefreshLoadMoreLayout.b
  {
    d(m paramm) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(349084);
      super.IH(paramInt);
      m.a(this.Ffs).requestRefresh();
      AppMethodBeat.o(349084);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(349092);
      kotlin.g.b.s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      paramd = m.b(this.Ffs).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramd, locala.aYi(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      paramd.scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramd, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(349092);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(349099);
      super.qI(paramInt);
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)m.a(this.Ffs), false, 1, null);
      AppMethodBeat.o(349099);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "pos", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    e(m paramm) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "isLiving", "isProductInLivingRoom", "requestId", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.s<Integer, Integer, Integer, Integer, String, ah>
    {
      a(m paramm, cc paramcc, com.tencent.mm.view.recyclerview.j paramj, String paramString1, String paramString2, String paramString3, bth parambth)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileShopUIC$onCreate$3", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends e.a
  {
    private final HashSet<Long> AKl;
    
    f(m paramm)
    {
      AppMethodBeat.i(349068);
      this.AKl = new HashSet();
      AppMethodBeat.o(349068);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(349078);
      kotlin.g.b.s.u(paramView, "parent");
      kotlin.g.b.s.u(paramList, "exposedHolders");
      paramView = (Iterable)paramList;
      paramList = this.Ffs;
      Iterator localIterator = paramView.iterator();
      label65:
      label201:
      label203:
      label206:
      while (localIterator.hasNext())
      {
        paramView = (RecyclerView.v)localIterator.next();
        if ((paramView instanceof com.tencent.mm.view.recyclerview.j))
        {
          paramView = (com.tencent.mm.view.recyclerview.j)paramView;
          if (paramView == null) {
            break label201;
          }
          paramView = paramView.CSA;
          if (!(paramView instanceof bw)) {
            break label203;
          }
        }
        for (paramView = (bw)paramView;; paramView = null)
        {
          if ((paramView == null) || (this.AKl.contains(Long.valueOf(paramView.DOS.DVk)))) {
            break label206;
          }
          this.AKl.add(Long.valueOf(paramView.DOS.DVk));
          Object localObject = bb.FuK;
          localObject = paramList.getContextObj();
          com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
          locali.m("finderusername", paramList.getUsername());
          locali.m("productid", d.hF(paramView.DOS.DVk));
          paramView = ah.aiuX;
          bb.a((bui)localObject, "poster_prod", false, (JSONObject)locali);
          break;
          paramView = null;
          break label65;
          break;
        }
      }
      AppMethodBeat.o(349078);
    }
    
    public final boolean dXG()
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    h(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    i(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.m
 * JD-Core Version:    0.7.0.1
 */