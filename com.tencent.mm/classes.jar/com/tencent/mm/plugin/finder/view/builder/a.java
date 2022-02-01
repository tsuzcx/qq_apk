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
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.plugin.finder.feed.ak;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "Landroid/widget/TextView;", "getHeaderTitleTv", "()Landroid/widget/TextView;", "setHeaderTitleTv", "(Landroid/widget/TextView;)V", "isReportExpose", "", "likeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "nothingView", "getNothingView", "setNothingView", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class a
  implements RecyclerViewDrawerSquares.c
{
  public static final a.a saw;
  public Context context;
  public View gDe;
  public RefreshLoadMoreLayout rfT;
  public FinderLikeDrawer rfV;
  public TextView sap;
  public FrameLayout saq;
  public FrameLayout sar;
  public View sas;
  public View sat;
  private boolean sau;
  public final ak sav;
  
  static
  {
    AppMethodBeat.i(204332);
    saw = new a.a((byte)0);
    AppMethodBeat.o(204332);
  }
  
  public a(ak paramak)
  {
    AppMethodBeat.i(204331);
    this.sav = paramak;
    AppMethodBeat.o(204331);
  }
  
  public final void O(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(204328);
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    int j;
    label177:
    Object localObject3;
    Object localObject4;
    if ((paramBoolean1) && (paramBoolean2))
    {
      localObject1 = this.sav;
      localObject2 = this.rfV;
      if (localObject2 == null) {
        k.aVY("likeDrawer");
      }
      localObject2 = ((FinderLikeDrawer)localObject2).getFeedObj();
      if (localObject2 == null) {
        k.fOy();
      }
      ((ak)localObject1).a(this, (FinderItem)localObject2);
      if (paramBoolean1) {
        break label577;
      }
      i = this.sav.getScene();
      localObject1 = FinderLikeDrawer.rXU;
      if ((i != FinderLikeDrawer.cEZ()) || (this.sau)) {
        break label582;
      }
      this.sau = true;
      localObject1 = this.rfT;
      if (localObject1 == null) {
        k.aVY("rlLayout");
      }
      localObject2 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView().getAdapter();
      if (localObject2 == null) {
        break label571;
      }
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        break label553;
      }
      localObject1 = d.rxr;
      str = d.cwT();
      j = this.sav.cuT();
      localObject1 = "";
      int k = ((WxRecyclerAdapter)localObject2).JCM.size();
      i = 0;
      if (i >= k) {
        break label310;
      }
      localObject3 = (h)((WxRecyclerAdapter)localObject2).JCM.valueAt(i);
      localObject4 = ((h)localObject3).JCE;
      if (!(localObject4 instanceof com.tencent.mm.plugin.finder.model.n)) {
        break label588;
      }
      localObject1 = (String)localObject1 + ((com.tencent.mm.plugin.finder.model.n)localObject4).ruS.diA + ';' + ((h)localObject3).rdE + ';' + ((com.tencent.mm.plugin.finder.model.n)localObject4).ruS.likeFlag + '#';
    }
    label310:
    label571:
    label577:
    label582:
    label588:
    for (;;)
    {
      i += 1;
      break label177;
      if ((paramBoolean1) || (!paramBoolean2)) {
        break;
      }
      this.sav.onDetach();
      break;
      localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
      localObject2 = FinderReporterUIC.seQ;
      localObject2 = this.context;
      if (localObject2 == null) {
        k.aVY("context");
      }
      localObject2 = FinderReporterUIC.a.eV((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((FinderReporterUIC)localObject2).cGb();
        localObject3 = this.rfV;
        if (localObject3 == null) {
          k.aVY("likeDrawer");
        }
        localObject3 = ((FinderLikeDrawer)localObject3).getFeedObj();
        if ((localObject2 != null) && (localObject3 != null))
        {
          localObject4 = d.rxr;
          l = ((FinderItem)localObject3).getId();
          k.h(localObject2, "contextObj");
          k.h(localObject1, "exposeItems");
          k.h(str, "enterContextId");
          if (d.ur(l) != null)
          {
            localObject3 = new ba();
            ((ba)localObject3).eT(((anm)localObject2).rfR);
            ((ba)localObject3).iF(((anm)localObject2).qox);
            ((ba)localObject3).iG(((anm)localObject2).qom);
            ((ba)localObject3).iJ(str);
            ((ba)localObject3).iE(((anm)localObject2).sessionId);
            ((ba)localObject3).iI(c.pb(l));
            if (j <= 0) {
              break label565;
            }
          }
        }
      }
      for (long l = 1L;; l = 0L)
      {
        ((ba)localObject3).eS(l);
        ((ba)localObject3).iH((String)localObject1);
        ((ba)localObject3).eU(j);
        ((ba)localObject3).aHZ();
        d.a((com.tencent.mm.plugin.report.a)localObject3);
        AppMethodBeat.o(204328);
        return;
        localObject2 = null;
        break;
      }
      AppMethodBeat.o(204328);
      return;
      this.sau = false;
      AppMethodBeat.o(204328);
      return;
    }
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer)
  {
    AppMethodBeat.i(204326);
    k.h(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    k.g(localObject, "drawer.context");
    this.context = ((Context)localObject);
    int i = this.sav.getScene();
    localObject = FinderLikeDrawer.rXU;
    if (i == FinderLikeDrawer.cEZ()) {
      paramRecyclerViewDrawer.setId(2131307397);
    }
    for (;;)
    {
      this.rfV = ((FinderLikeDrawer)paramRecyclerViewDrawer);
      paramRecyclerViewDrawer.setSquaresBackgroundResource(2131234858);
      paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
      paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
      AppMethodBeat.o(204326);
      return;
      localObject = FinderLikeDrawer.rXU;
      if (i == FinderLikeDrawer.cFa()) {
        paramRecyclerViewDrawer.setId(2131307396);
      }
    }
  }
  
  public final void bb(float paramFloat) {}
  
  public final TextView cFm()
  {
    AppMethodBeat.i(204322);
    TextView localTextView = this.sap;
    if (localTextView == null) {
      k.aVY("headerTitleTv");
    }
    AppMethodBeat.o(204322);
    return localTextView;
  }
  
  public final void cFn()
  {
    AppMethodBeat.i(204327);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rfT;
    if (localRefreshLoadMoreLayout == null) {
      k.aVY("rlLayout");
    }
    localRefreshLoadMoreLayout.setEnableRefresh(false);
    AppMethodBeat.o(204327);
  }
  
  public final void cMT() {}
  
  public final FinderLikeDrawer cuA()
  {
    AppMethodBeat.i(204324);
    FinderLikeDrawer localFinderLikeDrawer = this.rfV;
    if (localFinderLikeDrawer == null) {
      k.aVY("likeDrawer");
    }
    AppMethodBeat.o(204324);
    return localFinderLikeDrawer;
  }
  
  public final RefreshLoadMoreLayout cwM()
  {
    AppMethodBeat.i(204323);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rfT;
    if (localRefreshLoadMoreLayout == null) {
      k.aVY("rlLayout");
    }
    AppMethodBeat.o(204323);
    return localRefreshLoadMoreLayout;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(204325);
    Context localContext = this.context;
    if (localContext == null) {
      k.aVY("context");
    }
    AppMethodBeat.o(204325);
    return localContext;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(204330);
    Object localObject = this.sar;
    if (localObject == null) {
      k.aVY("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.sat;
    if (localObject == null) {
      k.aVY("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(204330);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(204329);
    Object localObject = this.sar;
    if (localObject == null) {
      k.aVY("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.gDe;
    if (localObject == null) {
      k.aVY("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.sas;
    if (localObject == null) {
      k.aVY("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.sat;
    if (localObject == null) {
      k.aVY("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(204329);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(d.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204321);
      this.rQf.invoke();
      AppMethodBeat.o(204321);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.a
 * JD-Core Version:    0.7.0.1
 */