package com.tencent.mm.plugin.finder.nearby.live;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.cq;
import com.tencent.mm.autogen.mmdata.rpt.cr;
import com.tencent.mm.autogen.mmdata.rpt.cs;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.localcity.NearbyLiveLocalCityFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.nearby.report.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderRefreshLayout;
import com.tencent.mm.plugin.finder.view.FinderRefreshLayout.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Set<Lcom.tencent.mm.view.recyclerview.b<Lcom.tencent.mm.view.recyclerview.a;>;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "parent", "Landroid/view/View;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isForceNightMode", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;Landroid/view/View;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ZLcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "audience21053Report", "Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report;", "clLayout", "kotlin.jvm.PlatformType", "getClLayout", "()Landroid/view/View;", "clLayout$delegate", "Lkotlin/Lazy;", "nearbyLiveViewItemClick", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewItemClick;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "getRlLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "rlLayout$delegate", "rootScroll", "getRootScroll", "rootScroll$delegate", "scrollGuideIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getScrollGuideIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "scrollGuideIv$delegate", "scrollGuideTv", "Landroid/widget/TextView;", "getScrollGuideTv", "()Landroid/widget/TextView;", "scrollGuideTv$delegate", "subTabLayout", "Landroidx/recyclerview/widget/RecyclerView;", "getSubTabLayout", "()Landroidx/recyclerview/widget/RecyclerView;", "subTabLayout$delegate", "viewCallback", "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$viewCallback$1", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$viewCallback$1;", "adapteViewBackGroundColor", "", "getActivity", "getPresenter", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "getRootScrollParent", "getSourceList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSubTabContainer", "getViewCallBack", "Lcom/tencent/mm/view/IViewActionCallback;", "gotoMoreLivePage", "initRecyclerView", "data", "initRefreshLayout", "initSubTabPosition", "index", "", "initSubTabView", "initView", "isLocalCityPage", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "refreshSubTabByCache", "cacheData", "", "Companion", "NearbyLiveItemDecoration", "SubTabAdapter", "SubTabViewHolder", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public class f
  implements b.b<cc>
{
  public static final a EJk;
  private WxRecyclerAdapter<cc> ALE;
  private final boolean ALp;
  private final MMActivity AZo;
  private final bui Auc;
  private final kotlin.j BaO;
  private final kotlin.j CNQ;
  private final b.a<cc> EIR;
  private final bnn EIq;
  private final AbsNearByFragment EJl;
  private final kotlin.j EJm;
  private final kotlin.j EJn;
  private final kotlin.j EJo;
  private final kotlin.j EJp;
  private final kotlin.j EJq;
  private com.tencent.mm.plugin.finder.live.report.a EJr;
  private final g EJs;
  private final r EJt;
  private final View nma;
  
  static
  {
    AppMethodBeat.i(340748);
    EJk = new a((byte)0);
    AppMethodBeat.o(340748);
  }
  
  public f(MMActivity paramMMActivity, AbsNearByFragment paramAbsNearByFragment, b.a<cc> parama, View paramView, bui parambui, boolean paramBoolean, bnn parambnn)
  {
    AppMethodBeat.i(340674);
    this.AZo = paramMMActivity;
    this.EJl = paramAbsNearByFragment;
    this.EIR = parama;
    this.nma = paramView;
    this.Auc = parambui;
    this.ALp = paramBoolean;
    this.EIq = parambnn;
    Log.i("NearbyLiveViewCallback", "#init");
    this.BaO = kotlin.k.cm((kotlin.g.a.a)new m(this));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.EJm = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.EJn = kotlin.k.cm((kotlin.g.a.a)new n(this));
    this.EJo = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.EJp = kotlin.k.cm((kotlin.g.a.a)new p(this));
    this.EJq = kotlin.k.cm((kotlin.g.a.a)new q(this));
    this.EJr = new com.tencent.mm.plugin.finder.live.report.a();
    this.EJs = new g(this.Auc, this.AZo, this.EJl, this.EIR.getCommentScene(), this.EIR);
    this.EJt = new r(this, getRlLayout());
    AppMethodBeat.o(340674);
  }
  
  private final View eEJ()
  {
    AppMethodBeat.i(340686);
    View localView = (View)this.EJm.getValue();
    AppMethodBeat.o(340686);
    return localView;
  }
  
  private final WeImageView eEK()
  {
    AppMethodBeat.i(340692);
    WeImageView localWeImageView = (WeImageView)this.EJo.getValue();
    AppMethodBeat.o(340692);
    return localWeImageView;
  }
  
  private final TextView eEL()
  {
    AppMethodBeat.i(340697);
    TextView localTextView = (TextView)this.EJp.getValue();
    AppMethodBeat.o(340697);
    return localTextView;
  }
  
  private final RecyclerView eEM()
  {
    AppMethodBeat.i(340704);
    RecyclerView localRecyclerView = (RecyclerView)this.EJq.getValue();
    AppMethodBeat.o(340704);
    return localRecyclerView;
  }
  
  private final boolean eEN()
  {
    return this.Auc.AJo == 112;
  }
  
  private final FinderRefreshLayout getRlLayout()
  {
    AppMethodBeat.i(340682);
    FinderRefreshLayout localFinderRefreshLayout = (FinderRefreshLayout)this.BaO.getValue();
    AppMethodBeat.o(340682);
    return localFinderRefreshLayout;
  }
  
  public final void QB(int paramInt)
  {
    AppMethodBeat.i(340800);
    Object localObject = eEM().getAdapter();
    if ((localObject instanceof c)) {}
    for (localObject = (c)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((c)localObject).EJv = paramInt;
      }
      localObject = eEM().getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
      AppMethodBeat.o(340800);
      return;
    }
  }
  
  public final void ae(ArrayList<cc> paramArrayList)
  {
    RecyclerView localRecyclerView = null;
    AppMethodBeat.i(340770);
    s.u(paramArrayList, "data");
    Object localObject1 = this.EJs;
    s.u(paramArrayList, "list");
    ((g)localObject1).EJA = paramArrayList;
    if (this.ALp)
    {
      getRlLayout().setBackgroundColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.Dark_0));
      eEJ().setBackgroundColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.Dark_0));
      getRecyclerView().setBackgroundDrawable(this.nma.getResources().getDrawable(com.tencent.mm.plugin.finder.nearby.f.c.finder_live_square_rv_corner_bg));
      eEL().setTextColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_0_Alpha_0_5_Night_Mode));
      eEK().setIconColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_0_Alpha_0_5_Night_Mode));
      localObject1 = getRlLayout().getLoadMoreFooter();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.view.refreshLayout.b.b)localObject1).getView();
        if (localObject1 != null)
        {
          localObject1 = (TextView)((View)localObject1).findViewById(com.tencent.mm.plugin.finder.nearby.f.d.load_more_footer_tip_tv);
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_100_Alpha_0_3));
          }
        }
      }
    }
    Object localObject2;
    for (;;)
    {
      getRlLayout().setOnSimpleAction((com.tencent.mm.view.refreshLayout.d.b)new k(this));
      localObject1 = getRecyclerView();
      localObject2 = new NearbyLiveViewCallback.initRecyclerView.1();
      ((NearbyLiveViewCallback.initRecyclerView.1)localObject2).setItemPrefetchEnabled(true);
      ah localah = ah.aiuX;
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
      getRecyclerView().a((RecyclerView.h)new b(this.Auc.AJo));
      localObject1 = getRecyclerView().getItemAnimator();
      if (localObject1 != null) {
        ((RecyclerView.f)localObject1).bZL = 0L;
      }
      this.ALE = ((WxRecyclerAdapter)new f(paramArrayList, new d(this.AZo, this.EIR, this.ALp, eEN(), this.Auc.AJo)));
      localObject1 = this.ALE;
      if (localObject1 != null) {
        ((com.tencent.mm.view.recyclerview.i)localObject1).agOe = ((i.c)new g(paramArrayList, this));
      }
      localObject1 = this.ALE;
      if (localObject1 != null) {
        ((com.tencent.mm.view.recyclerview.i)localObject1).agOd = ((i.d)new h(paramArrayList, this));
      }
      getRecyclerView().setAdapter((RecyclerView.a)this.ALE);
      getRecyclerView().setHasFixedSize(true);
      getRecyclerView().setItemViewCacheSize(8);
      paramArrayList = getRecyclerView();
      if (paramArrayList != null) {
        break;
      }
      paramArrayList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(340770);
      throw paramArrayList;
      if (eEN())
      {
        getRlLayout().setBackgroundColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_93));
        eEJ().setBackgroundColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_93));
      }
      else
      {
        getRlLayout().setBackgroundColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_100));
        eEJ().setBackgroundColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_100));
        eEL().setTextColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_0_Alpha_0_5));
        eEK().setIconColor(this.nma.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_0_Alpha_0_5));
      }
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.d.eSQ().bmg()).intValue());
    paramArrayList = getRecyclerView();
    s.s(paramArrayList, "recyclerView");
    com.tencent.mm.view.recyclerview.c.a((RecyclerView)paramArrayList, (com.tencent.mm.view.recyclerview.d)new i(this), (kotlin.g.a.b)j.akht);
    localObject1 = new StringBuilder("initSubTabView tab:");
    paramArrayList = this.EIq;
    if (paramArrayList == null)
    {
      paramArrayList = null;
      localObject1 = ((StringBuilder)localObject1).append(paramArrayList).append(" subTabCount:");
      paramArrayList = this.EIq;
      if (paramArrayList != null) {
        break label828;
      }
      paramArrayList = localRecyclerView;
    }
    for (;;)
    {
      Log.i("NearbyLiveViewCallback", paramArrayList);
      paramArrayList = this.EIq;
      if (paramArrayList == null) {
        break label862;
      }
      localRecyclerView = eEM();
      eEM().getContext();
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
      eEM().setAdapter((RecyclerView.a)new c(paramArrayList));
      if (this.ALp) {
        eEM().setBackgroundColor(eEM().getContext().getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.Dark_0));
      }
      if (paramArrayList.ZWf.isEmpty()) {
        break label853;
      }
      paramArrayList = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jUc().bmg()).intValue() != 1) {
        break label853;
      }
      eEM().setVisibility(0);
      AppMethodBeat.o(340770);
      return;
      paramArrayList = paramArrayList.ZWa;
      break;
      label828:
      localObject2 = paramArrayList.ZWf;
      paramArrayList = localRecyclerView;
      if (localObject2 != null) {
        paramArrayList = Integer.valueOf(((LinkedList)localObject2).size());
      }
    }
    label853:
    eEM().setVisibility(8);
    label862:
    AppMethodBeat.o(340770);
  }
  
  public final RecyclerView eEA()
  {
    AppMethodBeat.i(340792);
    RecyclerView localRecyclerView = eEM();
    AppMethodBeat.o(340792);
    return localRecyclerView;
  }
  
  public final WxRefreshLayout eEy()
  {
    AppMethodBeat.i(340780);
    Object localObject = getRlLayout();
    s.s(localObject, "rlLayout");
    localObject = (WxRefreshLayout)localObject;
    AppMethodBeat.o(340780);
    return localObject;
  }
  
  public final com.tencent.mm.view.k eEz()
  {
    return (com.tencent.mm.view.k)this.EJt;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(340774);
    RecyclerView localRecyclerView = (RecyclerView)getRecyclerView();
    AppMethodBeat.o(340774);
    return localRecyclerView;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(340804);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(340804);
    return localWxRecyclerView;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(340808);
    s.u(paramConfiguration, "newConfig");
    this.EJt.onChanged();
    AppMethodBeat.o(340808);
  }
  
  public final void pq(List<? extends cc> paramList)
  {
    AppMethodBeat.i(370447);
    s.u(paramList, "cacheData");
    Object localObject = this.ALE;
    if (localObject != null)
    {
      localObject = (List)((WxRecyclerAdapter)localObject).data;
      if (localObject != null)
      {
        ((List)localObject).clear();
        ((List)localObject).addAll((Collection)paramList);
      }
    }
    paramList = this.ALE;
    if (paramList != null) {
      paramList.bZE.notifyChanged();
    }
    AppMethodBeat.o(370447);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "commentScene", "", "(I)V", "getCommentScene", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    private final int AJo;
    
    public b(int paramInt)
    {
      this.AJo = paramInt;
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(340848);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      params = com.tencent.mm.plugin.finder.nearby.live.base.a.EJF;
      int j = (int)com.tencent.mm.plugin.finder.nearby.live.base.a.eEP();
      params = com.tencent.mm.plugin.finder.nearby.live.base.a.EJF;
      int k = (int)com.tencent.mm.plugin.finder.nearby.live.base.a.eEP() / 2;
      params = paramView.getLayoutParams();
      if (params == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(340848);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)params).cbB)
      {
        paramView = paramRecyclerView.bj(paramView);
        int i;
        if ((paramView instanceof com.tencent.mm.view.recyclerview.j))
        {
          paramView = (com.tencent.mm.view.recyclerview.j)paramView;
          if (paramView != null) {
            break label289;
          }
          i = -1;
          label118:
          if (paramView != null) {
            break label298;
          }
          paramView = null;
          label124:
          if (!(paramView instanceof com.tencent.mm.view.recyclerview.a)) {
            break label309;
          }
        }
        int m;
        for (;;)
        {
          m = MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.nearby.f.b.finder_1_25_A);
          if (!(paramView instanceof bn)) {
            break label366;
          }
          paramView = ((bn)paramView).AWZ;
          Log.i("NearbyLiveViewCallback", "getItemOffsets divider:" + paramView.aadB + '-' + paramView.ECY + '-' + paramView.wording);
          if (paramView.aadB != 6) {
            break label502;
          }
          if (i != 0) {
            break label314;
          }
          paramRect.left = (MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.nearby.f.b.Edge_2A) + 1);
          paramRect.right = MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.nearby.f.b.Edge_2A);
          paramRect.bottom = k;
          paramRect.top = MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.nearby.f.b.Edge_0_5_A);
          AppMethodBeat.o(340848);
          return;
          paramView = null;
          break;
          label289:
          i = paramView.KJ();
          break label118;
          label298:
          paramView = (com.tencent.mm.view.recyclerview.a)paramView.CSA;
          break label124;
          label309:
          paramView = null;
        }
        label314:
        paramRect.left = (MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.nearby.f.b.Edge_2A) + 1);
        paramRect.right = MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.nearby.f.b.Edge_2A);
        paramRect.bottom = k;
        paramRect.top = m;
        AppMethodBeat.o(340848);
        return;
        label366:
        if (((paramView instanceof au)) || ((paramView instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.c)))
        {
          paramRect.left = j;
          paramRect.right = j;
          paramRect.bottom = k;
          paramRect.top = k;
          AppMethodBeat.o(340848);
        }
      }
      else
      {
        paramView = paramView.getLayoutParams();
        if (paramView == null)
        {
          paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
          AppMethodBeat.o(340848);
          throw paramRect;
        }
        if (((StaggeredGridLayoutManager.LayoutParams)paramView).Lh() % 2 == 0)
        {
          paramRect.left = j;
          paramRect.right = k;
          paramRect.bottom = k;
          paramRect.top = k;
          AppMethodBeat.o(340848);
          return;
        }
        paramRect.left = k;
        paramRect.right = j;
        paramRect.bottom = k;
        paramRect.top = k;
      }
      label502:
      AppMethodBeat.o(340848);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$SubTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$SubTabViewHolder;", "parentTab", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "curSelectedSubTabPos", "", "getCurSelectedSubTabPos", "()I", "setCurSelectedSubTabPos", "(I)V", "dataList", "Ljava/util/LinkedList;", "getParentTab", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class c
    extends RecyclerView.a<f.d>
  {
    private final bnn EJu;
    int EJv;
    private final LinkedList<bnn> vEn;
    
    public c()
    {
      AppMethodBeat.i(340838);
      this.EJu = ((bnn)localObject1);
      this.vEn = new LinkedList();
      if (!this.EJu.ZWf.isEmpty())
      {
        this.vEn.add(0, this.EJu);
        this$1 = this.vEn;
        localObject1 = this.EJu.ZWf;
        s.s(localObject1, "parentTab.sub_tab_list");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        label161:
        label188:
        label191:
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          CharSequence localCharSequence = (CharSequence)((bnn)localObject3).ZWa;
          if ((localCharSequence == null) || (localCharSequence.length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label188;
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label191;
            }
            ((Collection)localObject1).add(localObject3);
            break;
            i = 0;
            break label161;
          }
        }
        f.this.addAll((Collection)localObject1);
      }
      AppMethodBeat.o(340838);
    }
    
    private static final void a(c paramc, int paramInt, f paramf, bnn parambnn, View paramView)
    {
      AppMethodBeat.i(340846);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramc);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramf);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambnn);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$SubTabAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      s.u(paramc, "this$0");
      s.u(paramf, "this$1");
      s.u(parambnn, "$data");
      int i = paramc.EJv;
      paramc.EJv = paramInt;
      paramc.fV(i);
      paramc.fV(paramc.EJv);
      paramc = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = (com.tencent.mm.plugin.finder.nearby.report.f)com.tencent.mm.ui.component.k.d((AppCompatActivity)f.h(paramf)).q(com.tencent.mm.plugin.finder.nearby.report.f.class);
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = f.f(paramf);
        if (((com.tencent.mm.plugin.finder.nearby.report.f)localObject1).ELx) {
          Log.w("SimpleUIComponent", "liveTabPageOut return for isNeverPageIn");
        }
      }
      else
      {
        f.a(paramf).a(parambnn);
        paramc = com.tencent.mm.ui.component.k.aeZF;
        paramView = (com.tencent.mm.plugin.finder.nearby.report.f)com.tencent.mm.ui.component.k.d((AppCompatActivity)f.h(paramf)).q(com.tencent.mm.plugin.finder.nearby.report.f.class);
        if (paramView != null)
        {
          localObject1 = f.f(paramf);
          if ((localObject1 != null) && (((localObject1 instanceof NearbyLiveSquareTabFragment)) || ((localObject1 instanceof NearbyLiveLocalCityFragment))))
          {
            parambnn = ((AbsNearByFragment)localObject1).eEt();
            localObject2 = ((AbsNearByFragment)localObject1).eEu();
            if (!(localObject1 instanceof NearbyLiveSquareTabFragment)) {
              break label1046;
            }
            paramc = (NearbyLiveSquareTabFragment)localObject1;
            label258:
            if (paramc != null) {
              break label1051;
            }
            paramc = "";
            label265:
            localObject3 = "page_tab_" + parambnn + '_' + (String)localObject2 + '_' + paramc;
            paramc = com.tencent.mm.ui.component.k.aeZF;
            paramc = ((as)com.tencent.mm.ui.component.k.y((Fragment)localObject1).q(as.class)).zIB;
            if (paramc != null) {
              break label1089;
            }
            paramc = "";
          }
        }
      }
      label910:
      label951:
      label1089:
      for (;;)
      {
        Object localObject4 = ((AbsNearByFragment)localObject1).eEv();
        Object localObject5 = new cr();
        ((cr)localObject5).ixo = cn.bDw();
        ((cr)localObject5).mu((String)localObject3);
        ((cr)localObject5).mv(parambnn);
        ((cr)localObject5).mw((String)localObject2);
        parambnn = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
        paramf = parambnn;
        if (parambnn == null) {
          paramf = "";
        }
        ((cr)localObject5).mx(paramf);
        paramf = com.tencent.mm.ui.component.k.aeZF;
        parambnn = ((as)com.tencent.mm.ui.component.k.y((Fragment)localObject1).q(as.class)).zIO;
        paramf = parambnn;
        if (parambnn == null) {
          paramf = "";
        }
        ((cr)localObject5).my(paramf);
        ((cr)localObject5).mz(paramc);
        ((cr)localObject5).mA((String)localObject4);
        ((cr)localObject5).mB("");
        ((cr)localObject5).mC(paramView.ELv);
        ((cr)localObject5).mD(paramView.Dol);
        ((cr)localObject5).mB(com.tencent.mm.plugin.finder.nearby.report.f.eFz());
        ((cr)localObject5).bMH();
        paramView.ELv = ((String)localObject3);
        paramView.ELw = cn.bDw();
        paramView.ELx = false;
        Log.i("SimpleUIComponent", s.X("reportSubTabPageIn ", ((cr)localObject5).aIF()));
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$SubTabAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(340846);
        return;
        if ((!(localObject3 instanceof NearbyLiveSquareTabFragment)) && (!(localObject3 instanceof NearbyLiveLocalCityFragment))) {
          break;
        }
        String str1 = ((AbsNearByFragment)localObject3).eEt();
        String str2 = ((AbsNearByFragment)localObject3).eEu();
        if ((localObject3 instanceof NearbyLiveSquareTabFragment))
        {
          paramc = (NearbyLiveSquareTabFragment)localObject3;
          label618:
          if (paramc != null) {
            break label910;
          }
          paramc = "";
          label625:
          localObject2 = ((com.tencent.mm.plugin.finder.nearby.report.f)localObject1).Dol;
          paramc = "page_tab_" + str1 + '_' + str2 + '_' + paramc;
          localObject5 = ((AbsNearByFragment)localObject3).eEv();
          localObject4 = new cs();
          ((cs)localObject4).ixo = cn.bDw();
          ((cs)localObject4).mE(paramc);
          ((cs)localObject4).mF(str1);
          ((cs)localObject4).mG(str2);
          paramView = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
          paramc = paramView;
          if (paramView == null) {
            paramc = "";
          }
          ((cs)localObject4).mH(paramc);
          paramc = com.tencent.mm.ui.component.k.aeZF;
          paramView = ((as)com.tencent.mm.ui.component.k.y((Fragment)localObject3).q(as.class)).zIO;
          paramc = paramView;
          if (paramView == null) {
            paramc = "";
          }
          ((cs)localObject4).mI(paramc);
          paramc = com.tencent.mm.ui.component.k.aeZF;
          paramView = ((as)com.tencent.mm.ui.component.k.y((Fragment)localObject3).q(as.class)).zIB;
          paramc = paramView;
          if (paramView == null) {
            paramc = "";
          }
          ((cs)localObject4).mJ(paramc);
          ((cs)localObject4).mK((String)localObject5);
          if (((com.tencent.mm.plugin.finder.nearby.report.f)localObject1).ELw > 0L) {
            break label951;
          }
          paramc = "";
        }
        for (;;)
        {
          ((cs)localObject4).mL(paramc);
          ((cs)localObject4).mM((String)localObject2);
          ((cs)localObject4).bMH();
          ((com.tencent.mm.plugin.finder.nearby.report.f)localObject1).ELw = 0L;
          Log.i("SimpleUIComponent", s.X("reportSubTabPageOut ", ((cs)localObject4).aIF()));
          break;
          paramc = null;
          break label618;
          paramc = paramc.ELV;
          if (paramc == null)
          {
            paramc = "";
            break label625;
          }
          paramView = Integer.valueOf(paramc.ZVZ).toString();
          paramc = paramView;
          if (paramView != null) {
            break label625;
          }
          paramc = "";
          break label625;
          long l1 = cn.bDw();
          long l2 = ((com.tencent.mm.plugin.finder.nearby.report.f)localObject1).ELw;
          paramc = new com.tencent.mm.ad.i();
          paramc.t("staytime", l1 - l2);
          paramc.n("is_new_square", Integer.valueOf(1));
          paramc.n("enter_type", Integer.valueOf(3));
          paramc = paramc.toString();
          s.s(paramc, "pgUdfKv.toString()");
          paramView = n.bV(paramc, ",", ";");
          paramc = paramView;
          if (paramView == null) {
            paramc = "";
          }
        }
        paramc = null;
        break label258;
        paramc = paramc.ELV;
        if (paramc == null)
        {
          paramc = "";
          break label265;
        }
        paramf = Integer.valueOf(paramc.ZVZ).toString();
        paramc = paramf;
        if (paramf != null) {
          break label265;
        }
        paramc = "";
        break label265;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(340860);
      int i = this.vEn.size();
      AppMethodBeat.o(340860);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$SubTabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bg", "kotlin.jvm.PlatformType", "getBg", "()Landroid/view/View;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
    extends RecyclerView.v
  {
    final View EJx;
    final TextView mll;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(340815);
      this.mll = ((TextView)paramView.findViewById(com.tencent.mm.plugin.finder.nearby.f.d.EGB));
      this.EJx = paramView.findViewById(com.tencent.mm.plugin.finder.nearby.f.d.EGA);
      AppMethodBeat.o(340815);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<View>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$3", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends WxRecyclerAdapter<cc>
  {
    f(ArrayList<cc> paramArrayList, d paramd)
    {
      super(paramArrayList);
      AppMethodBeat.i(370438);
      AppMethodBeat.o(370438);
    }
    
    public final void v(com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(370439);
      s.u(paramj, "holder");
      super.v(paramj);
      Object localObject = paramj.caK.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if ((paramj.caO != -1) && (paramj.caO != -9) && (paramj.caO != -10) && (paramj.caO != 6) && (paramj.caO != 4) && (paramj.caO != 2022)) {
          break label106;
        }
      }
      label106:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).cbB = bool;
        AppMethodBeat.o(370439);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    g(ArrayList<cc> paramArrayList, f paramf) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$5", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements i.d<com.tencent.mm.view.recyclerview.j>
  {
    h(ArrayList<cc> paramArrayList, f paramf) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$6", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a>
  {
    i(f paramf) {}
    
    public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> paramb)
    {
      AppMethodBeat.i(370444);
      s.u(paramb, "item");
      if ((paramb.agNK instanceof x))
      {
        dmk localdmk = new dmk();
        x localx = (x)paramb.agNK;
        localdmk.hKN = localx.bZA();
        localdmk.aaSu = ((int)paramb.startTime);
        Object localObject = paramb.view;
        if (localObject != null) {
          ((View)localObject).setTag(com.tencent.mm.plugin.finder.nearby.f.d.nearby_live_card_is_mute_tag, Boolean.FALSE);
        }
        localObject = paramb.view;
        if (localObject != null) {
          ((View)localObject).setTag(com.tencent.mm.plugin.finder.nearby.f.d.nearby_live_card_auto_play_time_tag, Long.valueOf(0L));
        }
        localObject = ay.EDk;
        ay.a(localdmk, f.a(this.EJw).getCommentScene());
        localObject = e.EQU;
        e.a(f.a(this.EJw).getCommentScene(), localdmk);
        Log.d("NearbyLiveViewCallback", "onItemExposeStart pos:" + paramb.afqR + " id:" + localdmk.hKN + " nick:" + localx.feedObject.getFeedObject().nickname);
      }
      AppMethodBeat.o(370444);
    }
    
    public final void s(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(370441);
      s.u(paramSet, "recordsSet");
      Log.i("NearbyLiveViewCallback", s.X("onExposeTimeRecorded: size = ", Integer.valueOf(paramSet.size())));
      LinkedList localLinkedList = new LinkedList();
      paramSet = (Iterable)paramSet;
      f localf = this.EJw;
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (com.tencent.mm.view.recyclerview.b)localIterator.next();
        Object localObject3;
        label182:
        label197:
        label215:
        Object localObject1;
        if ((((com.tencent.mm.view.recyclerview.b)localObject2).agNK instanceof x))
        {
          localObject3 = new dmk();
          x localx = (x)((com.tencent.mm.view.recyclerview.b)localObject2).agNK;
          ((dmk)localObject3).hKN = localx.bZA();
          paramSet = ay.EDk;
          ay.a((dmk)localObject3, f.a(localf).getCommentScene());
          ((dmk)localObject3).aaSu = ((int)((com.tencent.mm.view.recyclerview.b)localObject2).HsA);
          ((dmk)localObject3).aaSv = ((com.tencent.mm.view.recyclerview.b)localObject2).afqR;
          ((dmk)localObject3).sessionBuffer = localx.getSessionBuffer();
          paramSet = ((com.tencent.mm.view.recyclerview.b)localObject2).view;
          int i;
          com.tencent.mm.plugin.finder.live.report.a locala;
          cc localcc;
          q.w localw;
          int j;
          if (paramSet == null)
          {
            paramSet = null;
            if (paramSet != null) {
              break label488;
            }
            i = ((Number)Integer.valueOf(0)).intValue();
            ((dmk)localObject3).aaSw = i;
            paramSet = ((com.tencent.mm.view.recyclerview.b)localObject2).view;
            if (paramSet != null) {
              break label496;
            }
            paramSet = null;
            localObject1 = paramSet;
            if (paramSet == null) {
              localObject1 = Boolean.FALSE;
            }
            ((dmk)localObject3).aaSx = ((Boolean)localObject1).booleanValue();
            localLinkedList.add(localObject3);
            locala = f.e(localf);
            localcc = (cc)localx;
            i = ((com.tencent.mm.view.recyclerview.b)localObject2).afqR;
            localw = q.w.DwP;
            j = f.a(localf).getCommentScene();
            paramSet = f.f(localf);
            if (paramSet != null) {
              break label527;
            }
            paramSet = "";
          }
          for (;;)
          {
            locala.a(localcc, i, localw, String.valueOf(j), paramSet, f.c(localf).a(((com.tencent.mm.view.recyclerview.b)localObject2).afqR, ((com.tencent.mm.view.recyclerview.b)localObject2).view, "onExpose"));
            Log.i("NearbyLiveViewCallback", "onExposeTimeRecorded pos:" + ((com.tencent.mm.view.recyclerview.b)localObject2).afqR + " auto_play_time_ms:" + ((dmk)localObject3).aaSw + " auto_play_with_sound:" + ((dmk)localObject3).aaSx + " exposeTime:" + ((com.tencent.mm.view.recyclerview.b)localObject2).HsA + " nick:" + localx.feedObject.getFeedObject().nickname);
            break;
            paramSet = paramSet.getTag(com.tencent.mm.plugin.finder.nearby.f.d.nearby_live_card_auto_play_time_tag);
            if (paramSet == null)
            {
              paramSet = null;
              break label182;
            }
            long l;
            if ((paramSet instanceof Long))
            {
              l = ((Long)paramSet).longValue();
              label454:
              if (l == 0L) {
                break label483;
              }
            }
            label483:
            for (i = (int)(SystemClock.elapsedRealtime() - l);; i = 0)
            {
              paramSet = Integer.valueOf(i);
              break;
              l = 0L;
              break label454;
            }
            label488:
            i = paramSet.intValue();
            break label197;
            label496:
            paramSet = paramSet.getTag(com.tencent.mm.plugin.finder.nearby.f.d.nearby_live_card_is_mute_tag);
            if (paramSet == null)
            {
              paramSet = null;
              break label215;
            }
            paramSet = Boolean.valueOf(((Boolean)paramSet).booleanValue());
            break label215;
            label527:
            localObject1 = paramSet.eEv();
            paramSet = (Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>>)localObject1;
            if (localObject1 == null) {
              paramSet = "";
            }
          }
        }
        if ((((com.tencent.mm.view.recyclerview.b)localObject2).agNK instanceof au))
        {
          localObject1 = f.b(localf).zIB;
          paramSet = (Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>>)localObject1;
          if (localObject1 == null) {
            paramSet = "";
          }
          localObject3 = new cq();
          ((cq)localObject3).ixo = Util.nowMilliSecond();
          ((cq)localObject3).mh("");
          ((cq)localObject3).mi(f.c(localf).a(((com.tencent.mm.view.recyclerview.b)localObject2).afqR, ((com.tencent.mm.view.recyclerview.b)localObject2).view, "onExpose"));
          ((cq)localObject3).mj("");
          ((cq)localObject3).mk("");
          localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((cq)localObject3).ml((String)localObject1);
          ((cq)localObject3).mm(f.b(localf).zIO);
          ((cq)localObject3).mn(String.valueOf(f.b(localf).AJo));
          ((cq)localObject3).mo(paramSet);
          ((cq)localObject3).mp("");
          ((cq)localObject3).mq("");
          ((cq)localObject3).mr("");
          ((cq)localObject3).ms("all_my_follow");
          ((cq)localObject3).mt("");
          ((cq)localObject3).bMH();
        }
        else
        {
          Log.d("NearbyLiveViewCallback", "onExposeTimeRecorded pos:" + ((com.tencent.mm.view.recyclerview.b)localObject2).afqR + " exposeTime:" + ((com.tencent.mm.view.recyclerview.b)localObject2).HsA);
        }
      }
      paramSet = e.EQU;
      e.F(f.a(this.EJw).getCommentScene(), (List)localLinkedList);
      paramSet = a.EIi;
      if (!a.kLo())
      {
        paramSet = ay.EDk;
        ay.aN(localLinkedList);
      }
      AppMethodBeat.o(370441);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<View, Boolean>
  {
    public static final j akht;
    
    static
    {
      AppMethodBeat.i(370433);
      akht = new j();
      AppMethodBeat.o(370433);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$1", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "onLoadMore", "", "onRefresh", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.view.refreshLayout.d.b
  {
    k(f paramf) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(340885);
      f.a(this.EJw).onLoadMore();
      AppMethodBeat.o(340885);
    }
    
    public final void onRefresh()
    {
      AppMethodBeat.i(340874);
      f.a(this.EJw).onRefresh();
      AppMethodBeat.o(340874);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<FinderRefreshLayout>
  {
    m(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<View>
  {
    n(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    o(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<TextView>
  {
    p(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    q(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$viewCallback$1", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout$BaseViewActionCallback;", "onPreFinishRefresh", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class r
    extends FinderRefreshLayout.b
  {
    r(f paramf, FinderRefreshLayout paramFinderRefreshLayout)
    {
      super();
      AppMethodBeat.i(340835);
      AppMethodBeat.o(340835);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(340840);
      s.u(paramd, "reason");
      super.onPreFinishRefresh(paramd);
      f.a(this.EJw).onRefreshEnd(paramd);
      AppMethodBeat.o(340840);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.f
 * JD-Core Version:    0.7.0.1
 */