package com.tencent.mm.plugin.finder.view.builder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.aq;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "Landroid/widget/TextView;", "getHeaderTitleTv", "()Landroid/widget/TextView;", "setHeaderTitleTv", "(Landroid/widget/TextView;)V", "isReportExpose", "", "likeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "nothingView", "getNothingView", "setNothingView", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class a
  implements RecyclerViewDrawerSquares.c
{
  public static final a sXL;
  public Context context;
  public View gWO;
  public RefreshLoadMoreLayout rTF;
  public FinderLikeDrawer rTH;
  public TextView sXE;
  public FrameLayout sXF;
  public FrameLayout sXG;
  public View sXH;
  public View sXI;
  private boolean sXJ;
  public final aq sXK;
  
  static
  {
    AppMethodBeat.i(205338);
    sXL = new a((byte)0);
    AppMethodBeat.o(205338);
  }
  
  public a(aq paramaq)
  {
    AppMethodBeat.i(205337);
    this.sXK = paramaq;
    AppMethodBeat.o(205337);
  }
  
  public final void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(205333);
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
      localObject1 = this.sXK;
      localObject2 = this.rTH;
      if (localObject2 == null) {
        d.g.b.p.bcb("likeDrawer");
      }
      localObject2 = ((FinderLikeDrawer)localObject2).getFeedObj();
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      localObject3 = this.rTH;
      if (localObject3 == null) {
        d.g.b.p.bcb("likeDrawer");
      }
      ((aq)localObject1).a(this, (FinderItem)localObject2, ((FinderLikeDrawer)localObject3).getLikeBuffer());
      if (paramBoolean1) {
        break label598;
      }
      i = this.sXK.getScene();
      localObject1 = FinderLikeDrawer.sUO;
      if ((i != FinderLikeDrawer.cNt()) || (this.sXJ)) {
        break label603;
      }
      this.sXJ = true;
      localObject1 = this.rTF;
      if (localObject1 == null) {
        d.g.b.p.bcb("rlLayout");
      }
      localObject2 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView().getAdapter();
      if (localObject2 == null) {
        break label592;
      }
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        break label574;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
      localObject3 = com.tencent.mm.plugin.finder.report.h.cDy();
      j = this.sXK.cBk();
      localObject1 = "";
      int k = ((WxRecyclerAdapter)localObject2).LvS.size();
      i = 0;
      if (i >= k) {
        break label331;
      }
      localObject4 = (com.tencent.mm.view.recyclerview.h)((WxRecyclerAdapter)localObject2).LvS.valueAt(i);
      localObject5 = ((com.tencent.mm.view.recyclerview.h)localObject4).LvK;
      if (!(localObject5 instanceof o)) {
        break label609;
      }
      localObject1 = (String)localObject1 + ((o)localObject5).skl.dul + ';' + ((com.tencent.mm.view.recyclerview.h)localObject4).rRa + ';' + ((o)localObject5).skl.likeFlag + '#';
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
      this.sXK.onDetach();
      break;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject2 = FinderReporterUIC.tcM;
      localObject2 = this.context;
      if (localObject2 == null) {
        d.g.b.p.bcb("context");
      }
      localObject2 = FinderReporterUIC.a.eY((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((FinderReporterUIC)localObject2).cOu();
        localObject4 = this.rTH;
        if (localObject4 == null) {
          d.g.b.p.bcb("likeDrawer");
        }
        localObject4 = ((FinderLikeDrawer)localObject4).getFeedObj();
        if ((localObject2 != null) && (localObject4 != null))
        {
          localObject5 = com.tencent.mm.plugin.finder.report.h.soM;
          l = ((FinderItem)localObject4).getId();
          d.g.b.p.h(localObject2, "contextObj");
          d.g.b.p.h(localObject1, "exposeItems");
          d.g.b.p.h(localObject3, "enterContextId");
          if (com.tencent.mm.plugin.finder.report.h.ws(l) != null)
          {
            localObject4 = new bm();
            ((bm)localObject4).fW(((aqy)localObject2).rTD);
            ((bm)localObject4).kd(((aqy)localObject2).qXu);
            ((bm)localObject4).ke(((aqy)localObject2).qXj);
            ((bm)localObject4).kh((String)localObject3);
            ((bm)localObject4).kc(((aqy)localObject2).sessionId);
            ((bm)localObject4).kg(c.rc(l));
            if (j <= 0) {
              break label586;
            }
          }
        }
      }
      for (long l = 1L;; l = 0L)
      {
        ((bm)localObject4).fV(l);
        ((bm)localObject4).kf((String)localObject1);
        ((bm)localObject4).fX(j);
        ((bm)localObject4).aLk();
        com.tencent.mm.plugin.finder.report.h.a((com.tencent.mm.plugin.report.a)localObject4);
        AppMethodBeat.o(205333);
        return;
        localObject2 = null;
        break;
      }
      AppMethodBeat.o(205333);
      return;
      this.sXJ = false;
      AppMethodBeat.o(205333);
      return;
    }
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer)
  {
    AppMethodBeat.i(205331);
    d.g.b.p.h(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    d.g.b.p.g(localObject, "drawer.context");
    this.context = ((Context)localObject);
    int i = this.sXK.getScene();
    localObject = FinderLikeDrawer.sUO;
    if (i == FinderLikeDrawer.cNt()) {
      paramRecyclerViewDrawer.setId(2131307397);
    }
    for (;;)
    {
      this.rTH = ((FinderLikeDrawer)paramRecyclerViewDrawer);
      paramRecyclerViewDrawer.setSquaresBackgroundResource(2131234858);
      paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
      paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
      AppMethodBeat.o(205331);
      return;
      localObject = FinderLikeDrawer.sUO;
      if (i == FinderLikeDrawer.cNu()) {
        paramRecyclerViewDrawer.setId(2131307396);
      }
    }
  }
  
  public final void be(float paramFloat) {}
  
  public final FinderLikeDrawer cAM()
  {
    AppMethodBeat.i(205329);
    FinderLikeDrawer localFinderLikeDrawer = this.rTH;
    if (localFinderLikeDrawer == null) {
      d.g.b.p.bcb("likeDrawer");
    }
    AppMethodBeat.o(205329);
    return localFinderLikeDrawer;
  }
  
  public final RefreshLoadMoreLayout cDf()
  {
    AppMethodBeat.i(205328);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rTF;
    if (localRefreshLoadMoreLayout == null) {
      d.g.b.p.bcb("rlLayout");
    }
    AppMethodBeat.o(205328);
    return localRefreshLoadMoreLayout;
  }
  
  public final TextView cNI()
  {
    AppMethodBeat.i(205327);
    TextView localTextView = this.sXE;
    if (localTextView == null) {
      d.g.b.p.bcb("headerTitleTv");
    }
    AppMethodBeat.o(205327);
    return localTextView;
  }
  
  public final void cNJ()
  {
    AppMethodBeat.i(205332);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rTF;
    if (localRefreshLoadMoreLayout == null) {
      d.g.b.p.bcb("rlLayout");
    }
    localRefreshLoadMoreLayout.setEnableRefresh(false);
    AppMethodBeat.o(205332);
  }
  
  public final void cNK()
  {
    AppMethodBeat.i(205334);
    this.sXK.onDetach();
    AppMethodBeat.o(205334);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(205330);
    Context localContext = this.context;
    if (localContext == null) {
      d.g.b.p.bcb("context");
    }
    AppMethodBeat.o(205330);
    return localContext;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(205336);
    Object localObject = this.sXG;
    if (localObject == null) {
      d.g.b.p.bcb("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.sXI;
    if (localObject == null) {
      d.g.b.p.bcb("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(205336);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(205335);
    Object localObject = this.sXG;
    if (localObject == null) {
      d.g.b.p.bcb("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.gWO;
    if (localObject == null) {
      d.g.b.p.bcb("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.sXH;
    if (localObject == null) {
      d.g.b.p.bcb("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.sXI;
    if (localObject == null) {
      d.g.b.p.bcb("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(205335);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205325);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sXM.cAM().cMY();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205325);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(d.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205326);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sMK.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205326);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.a
 * JD-Core Version:    0.7.0.1
 */