package com.tencent.mm.plugin.finder.view.builder;

import android.content.Context;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.ej;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.bc;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "Landroid/widget/TextView;", "getHeaderTitleTv", "()Landroid/widget/TextView;", "setHeaderTitleTv", "(Landroid/widget/TextView;)V", "isReportExpose", "", "likeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "nothingView", "getNothingView", "setNothingView", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class a
  implements RecyclerViewDrawerSquares.c
{
  public static final a Bem;
  public View Aol;
  public TextView Beg;
  public FrameLayout Beh;
  public FrameLayout Bei;
  public View Bej;
  private boolean Bek;
  public final bc Bel;
  public Context context;
  public View kGT;
  public RefreshLoadMoreLayout xvJ;
  public FinderLikeDrawer xvL;
  
  static
  {
    AppMethodBeat.i(284578);
    Bem = new a((byte)0);
    AppMethodBeat.o(284578);
  }
  
  public a(bc parambc)
  {
    AppMethodBeat.i(284577);
    this.Bel = parambc;
    AppMethodBeat.o(284577);
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer)
  {
    AppMethodBeat.i(284571);
    p.k(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    p.j(localObject, "drawer.context");
    this.context = ((Context)localObject);
    int i = this.Bel.getScene();
    localObject = FinderLikeDrawer.AYs;
    if (i == FinderLikeDrawer.eiO()) {
      paramRecyclerViewDrawer.setId(b.f.finder_feed_friend_like_drawer);
    }
    for (;;)
    {
      this.xvL = ((FinderLikeDrawer)paramRecyclerViewDrawer);
      paramRecyclerViewDrawer.setSquaresBackgroundResource(b.e.finder_bottom_corner_shape);
      paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
      paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
      AppMethodBeat.o(284571);
      return;
      localObject = FinderLikeDrawer.AYs;
      if (i == FinderLikeDrawer.eiP()) {
        paramRecyclerViewDrawer.setId(b.f.finder_feed_all_like_drawer);
      }
    }
  }
  
  public final void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(284573);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    int j;
    label199:
    Object localObject4;
    Object localObject5;
    if ((paramBoolean1) && (paramBoolean2))
    {
      localObject1 = this.Bel;
      localObject2 = this.xvL;
      if (localObject2 == null) {
        p.bGy("likeDrawer");
      }
      localObject2 = ((FinderLikeDrawer)localObject2).getFeedObj();
      if (localObject2 == null) {
        p.iCn();
      }
      localObject3 = this.xvL;
      if (localObject3 == null) {
        p.bGy("likeDrawer");
      }
      ((bc)localObject1).a(this, (FinderItem)localObject2, ((FinderLikeDrawer)localObject3).getLikeBuffer());
      if (paramBoolean1) {
        break label599;
      }
      i = this.Bel.getScene();
      localObject1 = FinderLikeDrawer.AYs;
      if ((i != FinderLikeDrawer.eiO()) || (this.Bek)) {
        break label604;
      }
      this.Bek = true;
      localObject1 = this.xvJ;
      if (localObject1 == null) {
        p.bGy("rlLayout");
      }
      localObject2 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView().getAdapter();
      if (localObject2 == null) {
        break label593;
      }
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        break label575;
      }
      localObject1 = n.zWF;
      localObject3 = n.dPD();
      j = this.Bel.dth();
      localObject1 = "";
      int k = ((WxRecyclerAdapter)localObject2).YSX.size();
      i = 0;
      if (i >= k) {
        break label332;
      }
      localObject4 = (com.tencent.mm.view.recyclerview.l)((WxRecyclerAdapter)localObject2).YSX.valueAt(i);
      localObject5 = ((com.tencent.mm.view.recyclerview.l)localObject4).YSP;
      if (!(localObject5 instanceof v)) {
        break label610;
      }
      localObject1 = (String)localObject1 + ((v)localObject5).zAz.fGe + ';' + ((com.tencent.mm.view.recyclerview.l)localObject4).xre + ';' + ((v)localObject5).zAz.likeFlag + '#';
    }
    label332:
    label593:
    label599:
    label604:
    label610:
    for (;;)
    {
      i += 1;
      break label199;
      if ((paramBoolean1) || (!paramBoolean2)) {
        break;
      }
      this.Bel.onDetach();
      break;
      localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject2 = this.context;
      if (localObject2 == null) {
        p.bGy("context");
      }
      localObject2 = aj.a.fZ((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).ekY();
        localObject4 = this.xvL;
        if (localObject4 == null) {
          p.bGy("likeDrawer");
        }
        localObject4 = ((FinderLikeDrawer)localObject4).getFeedObj();
        if ((localObject2 != null) && (localObject4 != null))
        {
          localObject5 = n.zWF;
          l = ((FinderItem)localObject4).getId();
          p.k(localObject2, "contextObj");
          p.k(localObject1, "exposeItems");
          p.k(localObject3, "enterContextId");
          if (n.Hc(l) != null)
          {
            localObject4 = new ej();
            ((ej)localObject4).lu(((bid)localObject2).xkX);
            ((ej)localObject4).sg(((bid)localObject2).wmL);
            ((ej)localObject4).sh(((bid)localObject2).wmz);
            ((ej)localObject4).sk((String)localObject3);
            ((ej)localObject4).sf(((bid)localObject2).sessionId);
            ((ej)localObject4).sj(d.Fw(l));
            if (j <= 0) {
              break label587;
            }
          }
        }
      }
      for (long l = 1L;; l = 0L)
      {
        ((ej)localObject4).lt(l);
        ((ej)localObject4).si((String)localObject1);
        ((ej)localObject4).lv(j);
        ((ej)localObject4).bpa();
        n.a((com.tencent.mm.plugin.report.a)localObject4);
        AppMethodBeat.o(284573);
        return;
        localObject2 = null;
        break;
      }
      AppMethodBeat.o(284573);
      return;
      this.Bek = false;
      AppMethodBeat.o(284573);
      return;
    }
  }
  
  public final void bm(float paramFloat) {}
  
  public final FinderLikeDrawer dsD()
  {
    AppMethodBeat.i(284569);
    FinderLikeDrawer localFinderLikeDrawer = this.xvL;
    if (localFinderLikeDrawer == null) {
      p.bGy("likeDrawer");
    }
    AppMethodBeat.o(284569);
    return localFinderLikeDrawer;
  }
  
  public final TextView ejD()
  {
    AppMethodBeat.i(284567);
    TextView localTextView = this.Beg;
    if (localTextView == null) {
      p.bGy("headerTitleTv");
    }
    AppMethodBeat.o(284567);
    return localTextView;
  }
  
  public final void ejE()
  {
    AppMethodBeat.i(284572);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xvJ;
    if (localRefreshLoadMoreLayout == null) {
      p.bGy("rlLayout");
    }
    localRefreshLoadMoreLayout.setEnableRefresh(false);
    AppMethodBeat.o(284572);
  }
  
  public final void ejF()
  {
    AppMethodBeat.i(284574);
    this.Bel.onDetach();
    AppMethodBeat.o(284574);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(284570);
    Context localContext = this.context;
    if (localContext == null) {
      p.bGy("context");
    }
    AppMethodBeat.o(284570);
    return localContext;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(284568);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xvJ;
    if (localRefreshLoadMoreLayout == null) {
      p.bGy("rlLayout");
    }
    AppMethodBeat.o(284568);
    return localRefreshLoadMoreLayout;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(284576);
    Object localObject = this.Bei;
    if (localObject == null) {
      p.bGy("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.Aol;
    if (localObject == null) {
      p.bGy("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(284576);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(284575);
    Object localObject = this.Bei;
    if (localObject == null) {
      p.bGy("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.kGT;
    if (localObject == null) {
      p.bGy("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.Bej;
    if (localObject == null) {
      p.bGy("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.Aol;
    if (localObject == null) {
      p.bGy("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(284575);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(266831);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Ben.dsD().eir();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(266831);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(kotlin.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278885);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xAe.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278885);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.a
 * JD-Core Version:    0.7.0.1
 */