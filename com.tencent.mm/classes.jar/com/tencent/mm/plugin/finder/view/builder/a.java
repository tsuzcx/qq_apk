package com.tencent.mm.plugin.finder.view.builder;

import android.content.Context;
import android.graphics.Paint;
import android.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.mmdata.rpt.fv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.bj;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.n;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "Landroid/widget/TextView;", "getHeaderTitleTv", "()Landroid/widget/TextView;", "setHeaderTitleTv", "(Landroid/widget/TextView;)V", "isReportExpose", "", "likeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "nothingView", "getNothingView", "setNothingView", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Lkotlin/Function0;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements RecyclerViewDrawerSquares.c
{
  public static final a GGF;
  public RefreshLoadMoreLayout ATx;
  public FinderLikeDrawer ATz;
  public View BsS;
  public TextView FZP;
  public FrameLayout FZS;
  public FrameLayout FZT;
  public View FZU;
  public final bj GGG;
  private boolean GGH;
  public Context context;
  public View njN;
  
  static
  {
    AppMethodBeat.i(345092);
    GGF = new a((byte)0);
    AppMethodBeat.o(345092);
  }
  
  public a(bj parambj)
  {
    AppMethodBeat.i(345069);
    this.GGG = parambj;
    AppMethodBeat.o(345069);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(345078);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.ebI().fdh();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345078);
  }
  
  private static final void l(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(345085);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$onClick");
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345085);
  }
  
  public final void ak(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    AppMethodBeat.i(345206);
    Object localObject1;
    Object localObject2;
    int j;
    String str;
    int k;
    int m;
    if ((paramBoolean1) && (paramBoolean2))
    {
      localObject1 = this.GGG;
      localObject2 = ebI().getFeedObj();
      s.checkNotNull(localObject2);
      ((bj)localObject1).a(this, (FinderItem)localObject2, ebI().getLikeBuffer());
      if (paramBoolean1) {
        break label583;
      }
      j = this.GGG.getScene();
      localObject1 = FinderLikeDrawer.GAf;
      if ((j != FinderLikeDrawer.fkM()) || (this.GGH)) {
        break label588;
      }
      this.GGH = true;
      localObject2 = getRlLayout().getRecyclerView().getAdapter();
      if (localObject2 == null) {
        break label588;
      }
      if ((localObject2 instanceof WxRecyclerAdapter))
      {
        localObject1 = z.FrZ;
        str = z.bUm();
        k = this.GGG.eci();
        localObject1 = "";
        m = ((WxRecyclerAdapter)localObject2).agOP.size();
        if (m > 0) {
          localObject1 = "";
        }
      }
    }
    for (;;)
    {
      j = i + 1;
      Object localObject3 = ((WxRecyclerAdapter)localObject2).agOP.valueAt(i);
      Object localObject4 = ((n)localObject3).agOG;
      if ((localObject4 instanceof w)) {
        localObject1 = (String)localObject1 + ((w)localObject4).ECH.hLv + ';' + ((n)localObject3).AOn + ';' + ((w)localObject4).ECH.likeFlag + '#';
      }
      for (;;)
      {
        if (j < m) {
          break label597;
        }
        localObject2 = av.GiL;
        localObject2 = as.GSQ;
        localObject2 = as.a.hu(getContext());
        if (localObject2 == null)
        {
          localObject2 = null;
          label308:
          localObject3 = ebI().getFeedObj();
          localObject4 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
          if ((localObject2 != null) && (localObject3 != null))
          {
            localObject4 = z.FrZ;
            l = ((FinderItem)localObject3).getId();
            s.u(localObject2, "contextObj");
            s.u(localObject1, "exposeItems");
            s.u(str, "enterContextId");
            if (z.jm(l) != null)
            {
              localObject3 = new fv();
              ((fv)localObject3).ipV = ((bui)localObject2).AJo;
              ((fv)localObject3).ipT = ((fv)localObject3).F("ContextId", ((bui)localObject2).zIO, true);
              ((fv)localObject3).ipU = ((fv)localObject3).F("ClickTabContextId", ((bui)localObject2).zIB, true);
              ((fv)localObject3).iJr = ((fv)localObject3).F("EnterContextId", str, true);
              ((fv)localObject3).ijk = ((fv)localObject3).F("SessionId", ((bui)localObject2).sessionId, true);
              ((fv)localObject3).ivZ = ((fv)localObject3).F("FeedId", d.hF(l), true);
              if (k <= 0) {
                break label577;
              }
            }
          }
        }
        label577:
        for (long l = 1L;; l = 0L)
        {
          ((fv)localObject3).izk = l;
          ((fv)localObject3).iJp = ((fv)localObject3).F("ExposeItems", (String)localObject1, true);
          ((fv)localObject3).iJq = k;
          ((fv)localObject3).bMH();
          z.a((com.tencent.mm.plugin.report.a)localObject3);
          AppMethodBeat.o(345206);
          return;
          if ((paramBoolean1) || (!paramBoolean2)) {
            break;
          }
          this.GGG.onDetach();
          break;
          localObject2 = ((as)localObject2).fou();
          break label308;
        }
        label583:
        this.GGH = false;
        label588:
        AppMethodBeat.o(345206);
        return;
      }
      label597:
      i = j;
    }
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(345172);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "headerLayout");
    s.u(paramFrameLayout, "<set-?>");
    this.FZS = paramFrameLayout;
    View localView = af.mU(paramContext).inflate(e.f.like_drawer_header, (ViewGroup)ebI().getHeaderLayout());
    Object localObject = localView.findViewById(e.e.drawer_header_tv);
    s.s(localObject, "header.findViewById(R.id.drawer_header_tv)");
    localObject = (TextView)localObject;
    s.u(localObject, "<set-?>");
    this.FZP = ((TextView)localObject);
    com.tencent.mm.ui.aw.a((Paint)fdt().getPaint(), 0.8F);
    localObject = localView.findViewById(e.e.close_drawer_layout);
    ViewGroup localViewGroup = (ViewGroup)localView.findViewById(e.e.close_area_layout);
    localView = localView.findViewById(e.e.drawer_more_op);
    if (com.tencent.mm.ui.aw.isDarkMode()) {
      ((View)localObject).setBackgroundResource(e.d.finder_tag_op_btn_dark_shape);
    }
    for (;;)
    {
      localViewGroup.setOnClickListener(new a..ExternalSyntheticLambda0(this));
      this.GGG.a(paramContext, paramFrameLayout);
      paramContext = ebI();
      s.s(localObject, "closeBtn");
      paramContext.mA((View)localObject);
      paramContext = ebI();
      s.s(localView, "moreBtn");
      paramContext.mA(localView);
      AppMethodBeat.o(345172);
      return;
      ((View)localObject).setBackgroundResource(e.d.finder_tag_op_btn_shape);
    }
  }
  
  public final void bv(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(345231);
    s.u(parama, "onClick");
    getLoadingLayout().setVisibility(0);
    getLoadingView().setVisibility(8);
    fdw().setVisibility(8);
    fdx().setVisibility(0);
    fdx().setOnClickListener(new a..ExternalSyntheticLambda1(parama));
    AppMethodBeat.o(345231);
  }
  
  public final void cm(float paramFloat) {}
  
  public final void eIv()
  {
    AppMethodBeat.i(345214);
    this.GGG.onDetach();
    AppMethodBeat.o(345214);
  }
  
  public final FinderLikeDrawer ebI()
  {
    AppMethodBeat.i(345116);
    FinderLikeDrawer localFinderLikeDrawer = this.ATz;
    if (localFinderLikeDrawer != null)
    {
      AppMethodBeat.o(345116);
      return localFinderLikeDrawer;
    }
    s.bIx("likeDrawer");
    AppMethodBeat.o(345116);
    return null;
  }
  
  public final TextView fdt()
  {
    AppMethodBeat.i(345109);
    TextView localTextView = this.FZP;
    if (localTextView != null)
    {
      AppMethodBeat.o(345109);
      return localTextView;
    }
    s.bIx("headerTitleTv");
    AppMethodBeat.o(345109);
    return null;
  }
  
  public final View fdw()
  {
    AppMethodBeat.i(345132);
    View localView = this.FZU;
    if (localView != null)
    {
      AppMethodBeat.o(345132);
      return localView;
    }
    s.bIx("nothingView");
    AppMethodBeat.o(345132);
    return null;
  }
  
  public final View fdx()
  {
    AppMethodBeat.i(345139);
    View localView = this.BsS;
    if (localView != null)
    {
      AppMethodBeat.o(345139);
      return localView;
    }
    s.bIx("retryView");
    AppMethodBeat.o(345139);
    return null;
  }
  
  public final void flP()
  {
    AppMethodBeat.i(345179);
    getRlLayout().setEnableRefresh(false);
    AppMethodBeat.o(345179);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(345145);
    Context localContext = this.context;
    if (localContext != null)
    {
      AppMethodBeat.o(345145);
      return localContext;
    }
    s.bIx("context");
    AppMethodBeat.o(345145);
    return null;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(345120);
    FrameLayout localFrameLayout = this.FZT;
    if (localFrameLayout != null)
    {
      AppMethodBeat.o(345120);
      return localFrameLayout;
    }
    s.bIx("loadingLayout");
    AppMethodBeat.o(345120);
    return null;
  }
  
  public final View getLoadingView()
  {
    AppMethodBeat.i(345127);
    View localView = this.njN;
    if (localView != null)
    {
      AppMethodBeat.o(345127);
      return localView;
    }
    s.bIx("loadingView");
    AppMethodBeat.o(345127);
    return null;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(345111);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    if (localRefreshLoadMoreLayout != null)
    {
      AppMethodBeat.o(345111);
      return localRefreshLoadMoreLayout;
    }
    s.bIx("rlLayout");
    AppMethodBeat.o(345111);
    return null;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(345223);
    getLoadingLayout().setVisibility(8);
    fdx().setOnClickListener(null);
    AppMethodBeat.o(345223);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(345220);
    getLoadingLayout().setVisibility(0);
    getLoadingView().setVisibility(0);
    fdw().setVisibility(8);
    fdx().setVisibility(8);
    AppMethodBeat.o(345220);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.a
 * JD-Core Version:    0.7.0.1
 */