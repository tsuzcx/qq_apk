package com.tencent.mm.plugin.finder.view.builder;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.viewmodel.e;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "commentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getCommentDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setCommentDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "drawerFooter", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getDrawerFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setDrawerFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "headerErrTip", "Landroid/view/View;", "getHeaderErrTip", "()Landroid/view/View;", "setHeaderErrTip", "(Landroid/view/View;)V", "headerErrTv", "Landroid/widget/TextView;", "getHeaderErrTv", "()Landroid/widget/TextView;", "setHeaderErrTv", "(Landroid/widget/TextView;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "getHeaderTitleTv", "setHeaderTitleTv", "lastHideVKBTime", "", "getLastHideVKBTime", "()I", "setLastHideVKBTime", "(I)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "getLoadingView", "setLoadingView", "nothingView", "getNothingView", "setNothingView", "onBackPressed", "Lkotlin/Function0;", "", "getOnBackPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackPressed", "(Lkotlin/jvm/functions/Function0;)V", "onCloseBtnClick", "Lkotlin/Function1;", "getOnCloseBtnClick", "()Lkotlin/jvm/functions/Function1;", "setOnCloseBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "enable", "", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerFooter", "footerLayout", "fullScreen", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "scene", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showCommentClose", "showLoading", "showNothingTips", "showRetryView", "onClick", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  implements FinderCommentDrawer.a, RecyclerViewDrawerSquares.c
{
  public static final a GGI;
  public final CommentDrawerContract.NPresenter AHK;
  public RefreshLoadMoreLayout ATx;
  public View BsS;
  public TextView FZP;
  public FrameLayout FZS;
  public FrameLayout FZT;
  public View FZU;
  public View FZV;
  public TextView FZW;
  private kotlin.g.a.b<? super View, ah> FZX;
  kotlin.g.a.a<ah> FZY;
  public FinderCommentFooter GGJ;
  public FinderCommentDrawer GGK;
  public Context context;
  public View njN;
  
  static
  {
    AppMethodBeat.i(168495);
    GGI = new a((byte)0);
    AppMethodBeat.o(168495);
  }
  
  public b(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(168494);
    this.AHK = paramNPresenter;
    this.FZX = ((kotlin.g.a.b)new g(this));
    this.FZY = ((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(168494);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(345074);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.FZX;
    s.s(paramView, "it");
    paramb.invoke(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345074);
  }
  
  private static final void k(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(345082);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$onClick");
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345082);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(345208);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "headerLayout");
    s.u(paramFrameLayout, "<set-?>");
    this.FZS = paramFrameLayout;
    if (paramBoolean) {}
    for (paramContext = af.mU(paramContext).inflate(e.f.comment_drawer_header_fullscreen, (ViewGroup)paramFrameLayout);; paramContext = af.mU(paramContext).inflate(e.f.comment_drawer_header, (ViewGroup)paramFrameLayout))
    {
      paramFrameLayout = paramContext.findViewById(e.e.drawer_header_tv);
      s.s(paramFrameLayout, "header.findViewById(R.id.drawer_header_tv)");
      paramFrameLayout = (TextView)paramFrameLayout;
      s.u(paramFrameLayout, "<set-?>");
      this.FZP = paramFrameLayout;
      paramFrameLayout = paramContext.findViewById(e.e.finder_comment_error_tip);
      s.s(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_tip)");
      s.u(paramFrameLayout, "<set-?>");
      this.FZV = paramFrameLayout;
      paramFrameLayout = paramContext.findViewById(e.e.finder_comment_error_msg);
      s.s(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_msg)");
      paramFrameLayout = (TextView)paramFrameLayout;
      s.u(paramFrameLayout, "<set-?>");
      this.FZW = paramFrameLayout;
      aw.a((Paint)fdt().getPaint(), 0.8F);
      paramContext = paramContext.findViewById(e.e.close_area_layout);
      if (paramContext != null) {
        paramContext.setOnClickListener(new b..ExternalSyntheticLambda0(this));
      }
      if (paramContext != null) {
        flR().mA(paramContext);
      }
      AppMethodBeat.o(345208);
      return;
    }
  }
  
  public final void a(final Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(168487);
    s.u(paramContext, "context");
    s.u(paramRefreshLoadMoreLayout, "rlLayout");
    s.u(paramRefreshLoadMoreLayout, "<set-?>");
    this.ATx = paramRefreshLoadMoreLayout;
    Object localObject1 = af.mU(paramContext).inflate(e.f.load_more_footer, null);
    s.s(localObject1, "getInflater(context).inf…t.load_more_footer, null)");
    paramRefreshLoadMoreLayout.setLoadMoreFooter((View)localObject1);
    localObject1 = paramRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    Object localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).bZL = 0L;
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.AHK.gr(paramContext));
    if (aw.isDarkMode())
    {
      localObject2 = k.aeZF;
      ((RecyclerView)localObject1).setRecycledViewPool(((e)k.d((AppCompatActivity)paramContext).q(e.class)).GKY);
    }
    for (;;)
    {
      ((RecyclerView)localObject1).a((RecyclerView.l)new c(this, paramContext));
      paramContext = this.AHK.gl(paramContext);
      if (paramContext != null) {
        ((RecyclerView)localObject1).a(paramContext);
      }
      paramContext = paramRefreshLoadMoreLayout.getParent();
      if (paramContext != null) {
        break;
      }
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(168487);
      throw paramContext;
      localObject2 = k.aeZF;
      ((RecyclerView)localObject1).setRecycledViewPool(((e)k.d((AppCompatActivity)paramContext).q(e.class)).GKX);
    }
    paramContext = (View)paramContext;
    flR().getFooterLayout().addOnLayoutChangeListener((View.OnLayoutChangeListener)new b.d(this, paramContext));
    AppMethodBeat.o(168487);
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt)
  {
    AppMethodBeat.i(345197);
    s.u(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    s.s(localObject, "drawer.context");
    s.u(localObject, "<set-?>");
    this.context = ((Context)localObject);
    paramRecyclerViewDrawer.setId(e.e.finder_comment_drawer);
    localObject = (FinderCommentDrawer)paramRecyclerViewDrawer;
    s.u(localObject, "<set-?>");
    this.GGK = ((FinderCommentDrawer)localObject);
    paramRecyclerViewDrawer.setSquaresBackgroundResource(e.d.finder_bottom_corner_shape);
    paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
    paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    flR().setScene(paramInt);
    paramRecyclerViewDrawer = flR();
    if (flR().getScene() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecyclerViewDrawer.setSelfProfile(bool);
      AppMethodBeat.o(345197);
      return;
    }
  }
  
  public final void ak(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168490);
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject;
      if (flR().getShowFooter())
      {
        flQ().setVisibility(0);
        localObject = getHeaderLayout().findViewById(e.e.finder_comment_closed_tips);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      for (;;)
      {
        localObject = this.AHK;
        FinderCommentDrawer localFinderCommentDrawer = flR();
        FinderItem localFinderItem = flR().getFeedObj();
        s.checkNotNull(localFinderItem);
        ((CommentDrawerContract.NPresenter)localObject).a(localFinderCommentDrawer, this, localFinderItem, flR().getOnCloseDrawerCallback(), flR().getScene(), flR().plm, flR().getRefCommentId(), flR().getReplyCommentObj(), flR().getUseCache(), flR().getBlinkRefComment(), flR().getBlinkDuration(), flR().getCloseComment(), flR().getOldVersion(), flR().AHQ);
        AppMethodBeat.o(168490);
        return;
        flQ().setVisibility(8);
        if (flR().getCloseComment())
        {
          localObject = getHeaderLayout().findViewById(e.e.finder_comment_closed_tips);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          fdw().setVisibility(8);
          fdx().setVisibility(8);
          getLoadingLayout().setVisibility(0);
        }
        else
        {
          localObject = getHeaderLayout().findViewById(e.e.finder_comment_closed_tips);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
      }
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      this.AHK.onDetach();
    }
    AppMethodBeat.o(168490);
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(345243);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "footerLayout");
    paramContext = af.mU(paramContext).inflate(e.f.comment_drawer_footer, (ViewGroup)paramFrameLayout).findViewById(e.e.finder_comment_footer);
    s.s(paramContext, "view.findViewById(R.id.finder_comment_footer)");
    paramContext = (FinderCommentFooter)paramContext;
    s.u(paramContext, "<set-?>");
    this.GGJ = paramContext;
    flQ().setBackClickListener((kotlin.g.a.a)new e(paramBoolean, this));
    flQ().setSwitchSceneListener((kotlin.g.a.a)new f(this));
    flQ().setSelfProfile(flR().EAO);
    flQ().setScene(flR().getSceneForReply());
    flQ().setBanSwitchScene(flR().getBanSwitch());
    Log.i("Finder.TimelineDrawerBuilder", s.X("drawerFooter.scene ", Integer.valueOf(flQ().getScene())));
    flQ().up(false);
    flQ().uq(false);
    flR().setKeyboardHeightObserver((com.tencent.mm.ui.tools.h)flQ());
    flR().setFooter(flQ());
    AppMethodBeat.o(345243);
  }
  
  public final void bv(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(345283);
    s.u(parama, "onClick");
    getLoadingLayout().setVisibility(0);
    getLoadingView().setVisibility(8);
    fdw().setVisibility(8);
    fdx().setVisibility(0);
    fdx().setOnClickListener(new b..ExternalSyntheticLambda1(parama));
    AppMethodBeat.o(345283);
  }
  
  public final void c(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(168489);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "loadingLayout");
    s.u(paramFrameLayout, "<set-?>");
    this.FZT = paramFrameLayout;
    paramContext = LayoutInflater.from(paramContext).inflate(e.f.finder_comment_loading_tips_layout, (ViewGroup)paramFrameLayout, true);
    paramFrameLayout = paramContext.findViewById(e.e.comment_loading_bar);
    s.s(paramFrameLayout, "loadingContentLayout.fin…R.id.comment_loading_bar)");
    s.u(paramFrameLayout, "<set-?>");
    this.njN = paramFrameLayout;
    paramFrameLayout = paramContext.findViewById(e.e.no_comment_hint);
    s.s(paramFrameLayout, "loadingContentLayout.fin…yId(R.id.no_comment_hint)");
    s.u(paramFrameLayout, "<set-?>");
    this.FZU = paramFrameLayout;
    paramContext = paramContext.findViewById(e.e.retry_comment_layout);
    s.s(paramContext, "loadingContentLayout.fin….id.retry_comment_layout)");
    s.u(paramContext, "<set-?>");
    this.BsS = paramContext;
    getLoadingView().setVisibility(0);
    fdw().setVisibility(8);
    fdx().setVisibility(8);
    AppMethodBeat.o(168489);
  }
  
  public final void cm(float paramFloat)
  {
    AppMethodBeat.i(168491);
    if ((flR().plm) && (flQ().getFooterMode() == 2)) {
      ((MMFragmentActivity)getContext()).hideVKB();
    }
    AppMethodBeat.o(168491);
  }
  
  public final void eIv()
  {
    AppMethodBeat.i(345289);
    this.AHK.onDetach();
    AppMethodBeat.o(345289);
  }
  
  public final TextView fdt()
  {
    AppMethodBeat.i(168477);
    TextView localTextView = this.FZP;
    if (localTextView != null)
    {
      AppMethodBeat.o(168477);
      return localTextView;
    }
    s.bIx("headerTitleTv");
    AppMethodBeat.o(168477);
    return null;
  }
  
  public final View fdw()
  {
    AppMethodBeat.i(345148);
    View localView = this.FZU;
    if (localView != null)
    {
      AppMethodBeat.o(345148);
      return localView;
    }
    s.bIx("nothingView");
    AppMethodBeat.o(345148);
    return null;
  }
  
  public final View fdx()
  {
    AppMethodBeat.i(345152);
    View localView = this.BsS;
    if (localView != null)
    {
      AppMethodBeat.o(345152);
      return localView;
    }
    s.bIx("retryView");
    AppMethodBeat.o(345152);
    return null;
  }
  
  public final FinderCommentFooter flQ()
  {
    AppMethodBeat.i(168479);
    FinderCommentFooter localFinderCommentFooter = this.GGJ;
    if (localFinderCommentFooter != null)
    {
      AppMethodBeat.o(168479);
      return localFinderCommentFooter;
    }
    s.bIx("drawerFooter");
    AppMethodBeat.o(168479);
    return null;
  }
  
  public final FinderCommentDrawer flR()
  {
    AppMethodBeat.i(168480);
    FinderCommentDrawer localFinderCommentDrawer = this.GGK;
    if (localFinderCommentDrawer != null)
    {
      AppMethodBeat.o(168480);
      return localFinderCommentDrawer;
    }
    s.bIx("commentDrawer");
    AppMethodBeat.o(168480);
    return null;
  }
  
  public final View flS()
  {
    AppMethodBeat.i(168483);
    View localView = this.FZV;
    if (localView != null)
    {
      AppMethodBeat.o(168483);
      return localView;
    }
    s.bIx("headerErrTip");
    AppMethodBeat.o(168483);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(168482);
    Context localContext = this.context;
    if (localContext != null)
    {
      AppMethodBeat.o(168482);
      return localContext;
    }
    s.bIx("context");
    AppMethodBeat.o(168482);
    return null;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(168481);
    FrameLayout localFrameLayout = this.FZS;
    if (localFrameLayout != null)
    {
      AppMethodBeat.o(168481);
      return localFrameLayout;
    }
    s.bIx("headerLayout");
    AppMethodBeat.o(168481);
    return null;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(345134);
    FrameLayout localFrameLayout = this.FZT;
    if (localFrameLayout != null)
    {
      AppMethodBeat.o(345134);
      return localFrameLayout;
    }
    s.bIx("loadingLayout");
    AppMethodBeat.o(345134);
    return null;
  }
  
  public final View getLoadingView()
  {
    AppMethodBeat.i(345141);
    View localView = this.njN;
    if (localView != null)
    {
      AppMethodBeat.o(345141);
      return localView;
    }
    s.bIx("loadingView");
    AppMethodBeat.o(345141);
    return null;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(168478);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    if (localRefreshLoadMoreLayout != null)
    {
      AppMethodBeat.o(168478);
      return localRefreshLoadMoreLayout;
    }
    s.bIx("rlLayout");
    AppMethodBeat.o(168478);
    return null;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(168493);
    getLoadingLayout().setVisibility(8);
    fdx().setOnClickListener(null);
    AppMethodBeat.o(168493);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(168492);
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      Log.i("Finder.TimelineDrawerBuilder", "showLoading return for teen mode.");
      AppMethodBeat.o(168492);
      return;
    }
    getLoadingLayout().setVisibility(0);
    getLoadingView().setVisibility(0);
    fdw().setVisibility(8);
    fdx().setVisibility(8);
    AppMethodBeat.o(168492);
  }
  
  public final void us(boolean paramBoolean)
  {
    AppMethodBeat.i(168486);
    if ((!flR().AHQ) && (paramBoolean))
    {
      getRlLayout().setEnableRefresh(true);
      if (getRlLayout().getRefreshHeader() == null)
      {
        RefreshLoadMoreLayout localRefreshLoadMoreLayout = getRlLayout();
        View localView = af.mU(getContext()).inflate(e.f.refresh_header, null);
        s.s(localView, "getInflater(context).inf…out.refresh_header, null)");
        localRefreshLoadMoreLayout.setRefreshHeaderView(localView);
        AppMethodBeat.o(168486);
      }
    }
    else
    {
      getRlLayout().setEnableRefresh(false);
    }
    AppMethodBeat.o(168486);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "lastState", "", "getLastState", "()I", "setLastState", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    private int AOc;
    
    c(b paramb, Context paramContext) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(345077);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.AOc = paramInt;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(345077);
        return;
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(345077);
          throw paramRecyclerView;
        }
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        this.GGL.AHK.NE(paramRecyclerView.Jw());
        continue;
        if (this.AOc != 3) {
          ((MMFragmentActivity)paramContext).hideVKB();
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(345086);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(345086);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(boolean paramBoolean, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    g(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.b
 * JD-Core Version:    0.7.0.1
 */