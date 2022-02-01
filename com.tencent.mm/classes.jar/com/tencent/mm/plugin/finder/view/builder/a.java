package com.tencent.mm.plugin.finder.view.builder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.dq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.aw;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "Landroid/widget/TextView;", "getHeaderTitleTv", "()Landroid/widget/TextView;", "setHeaderTitleTv", "(Landroid/widget/TextView;)V", "isReportExpose", "", "likeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "nothingView", "getNothingView", "setNothingView", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class a
  implements RecyclerViewDrawerSquares.c
{
  public static final a wrY;
  public Context context;
  public View hSw;
  public RefreshLoadMoreLayout tLS;
  public FinderLikeDrawer tLU;
  public TextView wrR;
  public FrameLayout wrS;
  public FrameLayout wrT;
  public View wrU;
  public View wrV;
  private boolean wrW;
  public final aw wrX;
  
  static
  {
    AppMethodBeat.i(255202);
    wrY = new a((byte)0);
    AppMethodBeat.o(255202);
  }
  
  public a(aw paramaw)
  {
    AppMethodBeat.i(255201);
    this.wrX = paramaw;
    AppMethodBeat.o(255201);
  }
  
  public final void S(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(255197);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    int j;
    label198:
    Object localObject4;
    Object localObject5;
    if ((paramBoolean1) && (paramBoolean2))
    {
      localObject1 = this.wrX;
      localObject2 = this.tLU;
      if (localObject2 == null) {
        p.btv("likeDrawer");
      }
      localObject2 = ((FinderLikeDrawer)localObject2).getFeedObj();
      if (localObject2 == null) {
        p.hyc();
      }
      localObject3 = this.tLU;
      if (localObject3 == null) {
        p.btv("likeDrawer");
      }
      ((aw)localObject1).a(this, (FinderItem)localObject2, ((FinderLikeDrawer)localObject3).getLikeBuffer());
      if (paramBoolean1) {
        break label598;
      }
      i = this.wrX.getScene();
      localObject1 = FinderLikeDrawer.wnm;
      if ((i != FinderLikeDrawer.dGP()) || (this.wrW)) {
        break label603;
      }
      this.wrW = true;
      localObject1 = this.tLS;
      if (localObject1 == null) {
        p.btv("rlLayout");
      }
      localObject2 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView().getAdapter();
      if (localObject2 == null) {
        break label592;
      }
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        break label574;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
      localObject3 = com.tencent.mm.plugin.finder.report.k.doc();
      j = this.wrX.dcL();
      localObject1 = "";
      int k = ((WxRecyclerAdapter)localObject2).Rrx.size();
      i = 0;
      if (i >= k) {
        break label331;
      }
      localObject4 = (com.tencent.mm.view.recyclerview.k)((WxRecyclerAdapter)localObject2).Rrx.valueAt(i);
      localObject5 = ((com.tencent.mm.view.recyclerview.k)localObject4).Rrp;
      if (!(localObject5 instanceof v)) {
        break label609;
      }
      localObject1 = (String)localObject1 + ((v)localObject5).uOk.dMW + ';' + ((com.tencent.mm.view.recyclerview.k)localObject4).tIv + ';' + ((v)localObject5).uOk.likeFlag + '#';
    }
    label331:
    label592:
    label598:
    label603:
    label609:
    for (;;)
    {
      i += 1;
      break label198;
      if ((paramBoolean1) || (!paramBoolean2)) {
        break;
      }
      this.wrX.onDetach();
      break;
      localObject2 = y.vXH;
      localObject2 = FinderReporterUIC.wzC;
      localObject2 = this.context;
      if (localObject2 == null) {
        p.btv("context");
      }
      localObject2 = FinderReporterUIC.a.fH((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((FinderReporterUIC)localObject2).dIx();
        localObject4 = this.tLU;
        if (localObject4 == null) {
          p.btv("likeDrawer");
        }
        localObject4 = ((FinderLikeDrawer)localObject4).getFeedObj();
        if ((localObject2 != null) && (localObject4 != null))
        {
          localObject5 = com.tencent.mm.plugin.finder.report.k.vfA;
          l = ((FinderItem)localObject4).getId();
          p.h(localObject2, "contextObj");
          p.h(localObject1, "exposeItems");
          p.h(localObject3, "enterContextId");
          if (com.tencent.mm.plugin.finder.report.k.Fc(l) != null)
          {
            localObject4 = new dq();
            ((dq)localObject4).ks(((bbn)localObject2).tCE);
            ((dq)localObject4).pv(((bbn)localObject2).sGQ);
            ((dq)localObject4).pw(((bbn)localObject2).sGE);
            ((dq)localObject4).pz((String)localObject3);
            ((dq)localObject4).pu(((bbn)localObject2).sessionId);
            ((dq)localObject4).py(d.zs(l));
            if (j <= 0) {
              break label586;
            }
          }
        }
      }
      for (long l = 1L;; l = 0L)
      {
        ((dq)localObject4).kr(l);
        ((dq)localObject4).px((String)localObject1);
        ((dq)localObject4).kt(j);
        ((dq)localObject4).bfK();
        com.tencent.mm.plugin.finder.report.k.a((com.tencent.mm.plugin.report.a)localObject4);
        AppMethodBeat.o(255197);
        return;
        localObject2 = null;
        break;
      }
      AppMethodBeat.o(255197);
      return;
      this.wrW = false;
      AppMethodBeat.o(255197);
      return;
    }
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer)
  {
    AppMethodBeat.i(255195);
    p.h(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    p.g(localObject, "drawer.context");
    this.context = ((Context)localObject);
    int i = this.wrX.getScene();
    localObject = FinderLikeDrawer.wnm;
    if (i == FinderLikeDrawer.dGP()) {
      paramRecyclerViewDrawer.setId(2131300826);
    }
    for (;;)
    {
      this.tLU = ((FinderLikeDrawer)paramRecyclerViewDrawer);
      paramRecyclerViewDrawer.setSquaresBackgroundResource(2131232477);
      paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
      paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
      AppMethodBeat.o(255195);
      return;
      localObject = FinderLikeDrawer.wnm;
      if (i == FinderLikeDrawer.dGQ()) {
        paramRecyclerViewDrawer.setId(2131300823);
      }
    }
  }
  
  public final void bo(float paramFloat) {}
  
  public final TextView dHs()
  {
    AppMethodBeat.i(255191);
    TextView localTextView = this.wrR;
    if (localTextView == null) {
      p.btv("headerTitleTv");
    }
    AppMethodBeat.o(255191);
    return localTextView;
  }
  
  public final void dHt()
  {
    AppMethodBeat.i(255196);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tLS;
    if (localRefreshLoadMoreLayout == null) {
      p.btv("rlLayout");
    }
    localRefreshLoadMoreLayout.setEnableRefresh(false);
    AppMethodBeat.o(255196);
  }
  
  public final void dHu()
  {
    AppMethodBeat.i(255198);
    this.wrX.onDetach();
    AppMethodBeat.o(255198);
  }
  
  public final FinderLikeDrawer dcn()
  {
    AppMethodBeat.i(255193);
    FinderLikeDrawer localFinderLikeDrawer = this.tLU;
    if (localFinderLikeDrawer == null) {
      p.btv("likeDrawer");
    }
    AppMethodBeat.o(255193);
    return localFinderLikeDrawer;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(255194);
    Context localContext = this.context;
    if (localContext == null) {
      p.btv("context");
    }
    AppMethodBeat.o(255194);
    return localContext;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(255192);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tLS;
    if (localRefreshLoadMoreLayout == null) {
      p.btv("rlLayout");
    }
    AppMethodBeat.o(255192);
    return localRefreshLoadMoreLayout;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(255200);
    Object localObject = this.wrT;
    if (localObject == null) {
      p.btv("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.wrV;
    if (localObject == null) {
      p.btv("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(255200);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(255199);
    Object localObject = this.wrT;
    if (localObject == null) {
      p.btv("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.hSw;
    if (localObject == null) {
      p.btv("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.wrU;
    if (localObject == null) {
      p.btv("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.wrV;
    if (localObject == null) {
      p.btv("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(255199);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255189);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.wrZ.dcn().dGr();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255189);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(kotlin.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255190);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tPo.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255190);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.a
 * JD-Core Version:    0.7.0.1
 */