package com.tencent.mm.plugin.finder.view.builder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.aq;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "Landroid/widget/TextView;", "getHeaderTitleTv", "()Landroid/widget/TextView;", "setHeaderTitleTv", "(Landroid/widget/TextView;)V", "isReportExpose", "", "likeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "nothingView", "getNothingView", "setNothingView", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class a
  implements RecyclerViewDrawerSquares.c
{
  public static final a tiZ;
  public Context context;
  public View gZB;
  public RefreshLoadMoreLayout scj;
  public FinderLikeDrawer scl;
  public TextView tiS;
  public FrameLayout tiT;
  public FrameLayout tiU;
  public View tiV;
  public View tiW;
  private boolean tiX;
  public final aq tiY;
  
  static
  {
    AppMethodBeat.i(205981);
    tiZ = new a((byte)0);
    AppMethodBeat.o(205981);
  }
  
  public a(aq paramaq)
  {
    AppMethodBeat.i(205980);
    this.tiY = paramaq;
    AppMethodBeat.o(205980);
  }
  
  public final void P(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(205976);
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
      localObject1 = this.tiY;
      localObject2 = this.scl;
      if (localObject2 == null) {
        d.g.b.p.bdF("likeDrawer");
      }
      localObject2 = ((FinderLikeDrawer)localObject2).getFeedObj();
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      localObject3 = this.scl;
      if (localObject3 == null) {
        d.g.b.p.bdF("likeDrawer");
      }
      ((aq)localObject1).a(this, (FinderItem)localObject2, ((FinderLikeDrawer)localObject3).getLikeBuffer());
      if (paramBoolean1) {
        break label598;
      }
      i = this.tiY.getScene();
      localObject1 = FinderLikeDrawer.tgd;
      if ((i != FinderLikeDrawer.cQd()) || (this.tiX)) {
        break label603;
      }
      this.tiX = true;
      localObject1 = this.scj;
      if (localObject1 == null) {
        d.g.b.p.bdF("rlLayout");
      }
      localObject2 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView().getAdapter();
      if (localObject2 == null) {
        break label592;
      }
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        break label574;
      }
      localObject1 = i.syT;
      localObject3 = i.cFt();
      j = this.tiY.cCW();
      localObject1 = "";
      int k = ((WxRecyclerAdapter)localObject2).LSF.size();
      i = 0;
      if (i >= k) {
        break label331;
      }
      localObject4 = (h)((WxRecyclerAdapter)localObject2).LSF.valueAt(i);
      localObject5 = ((h)localObject4).LSx;
      if (!(localObject5 instanceof com.tencent.mm.plugin.finder.model.p)) {
        break label609;
      }
      localObject1 = (String)localObject1 + ((com.tencent.mm.plugin.finder.model.p)localObject5).sti.dvq + ';' + ((h)localObject4).rZC + ';' + ((com.tencent.mm.plugin.finder.model.p)localObject5).sti.likeFlag + '#';
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
      this.tiY.onDetach();
      break;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject2 = FinderReporterUIC.tnG;
      localObject2 = this.context;
      if (localObject2 == null) {
        d.g.b.p.bdF("context");
      }
      localObject2 = FinderReporterUIC.a.fc((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((FinderReporterUIC)localObject2).cQZ();
        localObject4 = this.scl;
        if (localObject4 == null) {
          d.g.b.p.bdF("likeDrawer");
        }
        localObject4 = ((FinderLikeDrawer)localObject4).getFeedObj();
        if ((localObject2 != null) && (localObject4 != null))
        {
          localObject5 = i.syT;
          l = ((FinderItem)localObject4).getId();
          d.g.b.p.h(localObject2, "contextObj");
          d.g.b.p.h(localObject1, "exposeItems");
          d.g.b.p.h(localObject3, "enterContextId");
          if (i.wJ(l) != null)
          {
            localObject4 = new bm();
            ((bm)localObject4).fZ(((arn)localObject2).sch);
            ((bm)localObject4).kq(((arn)localObject2).rfA);
            ((bm)localObject4).kr(((arn)localObject2).rfo);
            ((bm)localObject4).ku((String)localObject3);
            ((bm)localObject4).kp(((arn)localObject2).sessionId);
            ((bm)localObject4).kt(c.rp(l));
            if (j <= 0) {
              break label586;
            }
          }
        }
      }
      for (long l = 1L;; l = 0L)
      {
        ((bm)localObject4).fY(l);
        ((bm)localObject4).ks((String)localObject1);
        ((bm)localObject4).ga(j);
        ((bm)localObject4).aLH();
        i.a((com.tencent.mm.plugin.report.a)localObject4);
        AppMethodBeat.o(205976);
        return;
        localObject2 = null;
        break;
      }
      AppMethodBeat.o(205976);
      return;
      this.tiX = false;
      AppMethodBeat.o(205976);
      return;
    }
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer)
  {
    AppMethodBeat.i(205974);
    d.g.b.p.h(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    d.g.b.p.g(localObject, "drawer.context");
    this.context = ((Context)localObject);
    int i = this.tiY.getScene();
    localObject = FinderLikeDrawer.tgd;
    if (i == FinderLikeDrawer.cQd()) {
      paramRecyclerViewDrawer.setId(2131307397);
    }
    for (;;)
    {
      this.scl = ((FinderLikeDrawer)paramRecyclerViewDrawer);
      paramRecyclerViewDrawer.setSquaresBackgroundResource(2131234858);
      paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
      paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
      AppMethodBeat.o(205974);
      return;
      localObject = FinderLikeDrawer.tgd;
      if (i == FinderLikeDrawer.cQe()) {
        paramRecyclerViewDrawer.setId(2131307396);
      }
    }
  }
  
  public final void be(float paramFloat) {}
  
  public final FinderLikeDrawer cCy()
  {
    AppMethodBeat.i(205972);
    FinderLikeDrawer localFinderLikeDrawer = this.scl;
    if (localFinderLikeDrawer == null) {
      d.g.b.p.bdF("likeDrawer");
    }
    AppMethodBeat.o(205972);
    return localFinderLikeDrawer;
  }
  
  public final RefreshLoadMoreLayout cEX()
  {
    AppMethodBeat.i(205971);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.scj;
    if (localRefreshLoadMoreLayout == null) {
      d.g.b.p.bdF("rlLayout");
    }
    AppMethodBeat.o(205971);
    return localRefreshLoadMoreLayout;
  }
  
  public final TextView cQs()
  {
    AppMethodBeat.i(205970);
    TextView localTextView = this.tiS;
    if (localTextView == null) {
      d.g.b.p.bdF("headerTitleTv");
    }
    AppMethodBeat.o(205970);
    return localTextView;
  }
  
  public final void cQt()
  {
    AppMethodBeat.i(205975);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.scj;
    if (localRefreshLoadMoreLayout == null) {
      d.g.b.p.bdF("rlLayout");
    }
    localRefreshLoadMoreLayout.setEnableRefresh(false);
    AppMethodBeat.o(205975);
  }
  
  public final void cQu()
  {
    AppMethodBeat.i(205977);
    this.tiY.onDetach();
    AppMethodBeat.o(205977);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(205973);
    Context localContext = this.context;
    if (localContext == null) {
      d.g.b.p.bdF("context");
    }
    AppMethodBeat.o(205973);
    return localContext;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(205979);
    Object localObject = this.tiU;
    if (localObject == null) {
      d.g.b.p.bdF("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.tiW;
    if (localObject == null) {
      d.g.b.p.bdF("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(205979);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(205978);
    Object localObject = this.tiU;
    if (localObject == null) {
      d.g.b.p.bdF("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.gZB;
    if (localObject == null) {
      d.g.b.p.bdF("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.tiV;
    if (localObject == null) {
      d.g.b.p.bdF("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.tiW;
    if (localObject == null) {
      d.g.b.p.bdF("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(205978);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205968);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.tja.cCy().cPH();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205968);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(d.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205969);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.sXV.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205969);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.a
 * JD-Core Version:    0.7.0.1
 */