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
import com.tencent.mm.g.b.a.hv;
import com.tencent.mm.plugin.finder.feed.ak;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "Landroid/widget/TextView;", "getHeaderTitleTv", "()Landroid/widget/TextView;", "setHeaderTitleTv", "(Landroid/widget/TextView;)V", "isReportExpose", "", "likeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "nothingView", "getNothingView", "setNothingView", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class b
  implements RecyclerViewDrawerSquares.c
{
  public static final a LgD;
  public FinderLikeDrawer KMO;
  public final ak LgC;
  public Context context;
  public View lZo;
  public TextView qYA;
  public FrameLayout qYD;
  public FrameLayout qYE;
  public View qYF;
  public View qYG;
  public RefreshLoadMoreLayout quj;
  private boolean rug;
  
  static
  {
    AppMethodBeat.i(200262);
    LgD = new a((byte)0);
    AppMethodBeat.o(200262);
  }
  
  public b(ak paramak)
  {
    AppMethodBeat.i(200261);
    this.LgC = paramak;
    AppMethodBeat.o(200261);
  }
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(200258);
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
      localObject1 = this.LgC;
      localObject2 = this.KMO;
      if (localObject2 == null) {
        k.aPZ("likeDrawer");
      }
      localObject2 = ((FinderLikeDrawer)localObject2).getFeedObj();
      if (localObject2 == null) {
        k.fvU();
      }
      ((ak)localObject1).a(this, (FinderItem)localObject2);
      if (paramBoolean1) {
        break label577;
      }
      i = this.LgC.getScene();
      localObject1 = FinderLikeDrawer.Lfb;
      if ((i != FinderLikeDrawer.fWQ()) || (this.rug)) {
        break label582;
      }
      this.rug = true;
      localObject1 = this.quj;
      if (localObject1 == null) {
        k.aPZ("rlLayout");
      }
      localObject2 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView().getAdapter();
      if (localObject2 == null) {
        break label571;
      }
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        break label553;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
      str = com.tencent.mm.plugin.finder.report.b.fTV();
      j = this.LgC.fTk();
      localObject1 = "";
      int k = ((WxRecyclerAdapter)localObject2).LEb.size();
      i = 0;
      if (i >= k) {
        break label310;
      }
      localObject3 = (h)((WxRecyclerAdapter)localObject2).LEb.valueAt(i);
      localObject4 = ((h)localObject3).LDU;
      if (!(localObject4 instanceof z)) {
        break label588;
      }
      localObject1 = (String)localObject1 + ((z)localObject4).KTs.hKD + ';' + ((h)localObject3).KMi + ';' + ((z)localObject4).KTs.likeFlag + '#';
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
      this.LgC.onDetach();
      break;
      localObject2 = i.qTa;
      localObject2 = FinderReporterUIC.Ljl;
      localObject2 = this.context;
      if (localObject2 == null) {
        k.aPZ("context");
      }
      localObject2 = FinderReporterUIC.a.lB((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((FinderReporterUIC)localObject2).fXs();
        localObject3 = this.KMO;
        if (localObject3 == null) {
          k.aPZ("likeDrawer");
        }
        localObject3 = ((FinderLikeDrawer)localObject3).getFeedObj();
        if ((localObject2 != null) && (localObject3 != null))
        {
          localObject4 = com.tencent.mm.plugin.finder.report.b.qFq;
          l = ((FinderItem)localObject3).getId();
          k.h(localObject2, "contextObj");
          k.h(localObject1, "exposeItems");
          k.h(str, "enterContextId");
          if (com.tencent.mm.plugin.finder.report.b.qh(l) != null)
          {
            localObject3 = new hv();
            ((hv)localObject3).zi(((dzp)localObject2).qqE);
            ((hv)localObject3).aSq(((dzp)localObject2).qwV);
            ((hv)localObject3).aSr(((dzp)localObject2).KHW);
            ((hv)localObject3).aSu(str);
            ((hv)localObject3).aSp(((dzp)localObject2).sessionId);
            ((hv)localObject3).aSt(c.ly(l));
            if (j <= 0) {
              break label565;
            }
          }
        }
      }
      for (long l = 1L;; l = 0L)
      {
        ((hv)localObject3).zh(l);
        ((hv)localObject3).aSs((String)localObject1);
        ((hv)localObject3).zj(j);
        ((hv)localObject3).aBj();
        com.tencent.mm.plugin.finder.report.b.a((com.tencent.mm.plugin.report.a)localObject3);
        AppMethodBeat.o(200258);
        return;
        localObject2 = null;
        break;
      }
      AppMethodBeat.o(200258);
      return;
      this.rug = false;
      AppMethodBeat.o(200258);
      return;
    }
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer)
  {
    AppMethodBeat.i(200256);
    k.h(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    k.g(localObject, "drawer.context");
    this.context = ((Context)localObject);
    int i = this.LgC.getScene();
    localObject = FinderLikeDrawer.Lfb;
    if (i == FinderLikeDrawer.fWQ()) {
      paramRecyclerViewDrawer.setId(2131307328);
    }
    for (;;)
    {
      this.KMO = ((FinderLikeDrawer)paramRecyclerViewDrawer);
      paramRecyclerViewDrawer.setSquaresBackgroundResource(2131234854);
      paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
      paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
      AppMethodBeat.o(200256);
      return;
      localObject = FinderLikeDrawer.Lfb;
      if (i == FinderLikeDrawer.fWR()) {
        paramRecyclerViewDrawer.setId(2131307327);
      }
    }
  }
  
  public final void aU(float paramFloat) {}
  
  public final RefreshLoadMoreLayout cny()
  {
    AppMethodBeat.i(200253);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.quj;
    if (localRefreshLoadMoreLayout == null) {
      k.aPZ("rlLayout");
    }
    AppMethodBeat.o(200253);
    return localRefreshLoadMoreLayout;
  }
  
  public final TextView csV()
  {
    AppMethodBeat.i(200252);
    TextView localTextView = this.qYA;
    if (localTextView == null) {
      k.aPZ("headerTitleTv");
    }
    AppMethodBeat.o(200252);
    return localTextView;
  }
  
  public final FinderLikeDrawer fSZ()
  {
    AppMethodBeat.i(200254);
    FinderLikeDrawer localFinderLikeDrawer = this.KMO;
    if (localFinderLikeDrawer == null) {
      k.aPZ("likeDrawer");
    }
    AppMethodBeat.o(200254);
    return localFinderLikeDrawer;
  }
  
  public final void fXa()
  {
    AppMethodBeat.i(200257);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.quj;
    if (localRefreshLoadMoreLayout == null) {
      k.aPZ("rlLayout");
    }
    localRefreshLoadMoreLayout.setEnableRefresh(false);
    AppMethodBeat.o(200257);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(200255);
    Context localContext = this.context;
    if (localContext == null) {
      k.aPZ("context");
    }
    AppMethodBeat.o(200255);
    return localContext;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(200260);
    Object localObject = this.qYE;
    if (localObject == null) {
      k.aPZ("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.qYG;
    if (localObject == null) {
      k.aPZ("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(200260);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(200259);
    Object localObject = this.qYE;
    if (localObject == null) {
      k.aPZ("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.lZo;
    if (localObject == null) {
      k.aPZ("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.qYF;
    if (localObject == null) {
      k.aPZ("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.qYG;
    if (localObject == null) {
      k.aPZ("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(200259);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200250);
      this.LgE.fSZ().csJ();
      AppMethodBeat.o(200250);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(d.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200251);
      this.qYM.invoke();
      AppMethodBeat.o(200251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.b
 * JD-Core Version:    0.7.0.1
 */