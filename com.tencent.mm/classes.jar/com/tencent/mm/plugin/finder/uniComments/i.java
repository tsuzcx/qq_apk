package com.tencent.mm.plugin.finder.uniComments;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$NPresenter;)V", "commentDrawer", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer;", "getCommentDrawer", "()Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer;", "setCommentDrawer", "(Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "drawerFooter", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter;", "getDrawerFooter", "()Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter;", "setDrawerFooter", "(Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter;)V", "headerErrTip", "Landroid/view/View;", "getHeaderErrTip", "()Landroid/view/View;", "setHeaderErrTip", "(Landroid/view/View;)V", "headerErrTv", "Landroid/widget/TextView;", "getHeaderErrTv", "()Landroid/widget/TextView;", "setHeaderErrTv", "(Landroid/widget/TextView;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "getHeaderTitleTv", "setHeaderTitleTv", "lastHideVKBTime", "", "getLastHideVKBTime", "()I", "setLastHideVKBTime", "(I)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "getLoadingView", "setLoadingView", "nothingView", "getNothingView", "setNothingView", "onBackPressed", "Lkotlin/Function0;", "", "getOnBackPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackPressed", "(Lkotlin/jvm/functions/Function0;)V", "onCloseBtnClick", "Lkotlin/Function1;", "getOnCloseBtnClick", "()Lkotlin/jvm/functions/Function1;", "setOnCloseBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$NPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "enable", "", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerFooter", "footerLayout", "fullScreen", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "scene", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showCommentClose", "showLoading", "showNothingTips", "showRetryView", "onClick", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements UniCommentDrawer.a, RecyclerViewDrawerSquares.c
{
  public static final a FZN;
  public RefreshLoadMoreLayout ATx;
  public View BsS;
  final e.b FZO;
  public TextView FZP;
  public UniCommentFooter FZQ;
  public UniCommentDrawer FZR;
  public FrameLayout FZS;
  public FrameLayout FZT;
  public View FZU;
  public View FZV;
  public TextView FZW;
  private kotlin.g.a.b<? super View, ah> FZX;
  kotlin.g.a.a<ah> FZY;
  public Context context;
  public View njN;
  
  static
  {
    AppMethodBeat.i(341445);
    FZN = new a((byte)0);
    AppMethodBeat.o(341445);
  }
  
  public i(e.b paramb)
  {
    AppMethodBeat.i(341428);
    this.FZO = paramb;
    this.FZX = ((kotlin.g.a.b)new g(this));
    this.FZY = ((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(341428);
  }
  
  private static final void a(i parami, View paramView)
  {
    AppMethodBeat.i(341435);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    parami = parami.FZX;
    s.s(paramView, "it");
    parami.invoke(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341435);
  }
  
  private static final void k(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(341439);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$onClick");
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341439);
  }
  
  public final void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(341529);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "headerLayout");
    s.u(paramFrameLayout, "<set-?>");
    this.FZS = paramFrameLayout;
    if (paramBoolean) {}
    for (paramContext = af.mU(paramContext).inflate(e.f.uni_comment_drawer_header_fullscreen, (ViewGroup)paramFrameLayout);; paramContext = af.mU(paramContext).inflate(e.f.uni_comment_drawer_header, (ViewGroup)paramFrameLayout))
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
        paramContext.setOnClickListener(new i..ExternalSyntheticLambda0(this));
      }
      if (paramContext != null) {
        fdv().mA(paramContext);
      }
      AppMethodBeat.o(341529);
      return;
    }
  }
  
  public final void a(final Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(341545);
    s.u(paramContext, "context");
    s.u(paramRefreshLoadMoreLayout, "rlLayout");
    s.u(paramRefreshLoadMoreLayout, "<set-?>");
    this.ATx = paramRefreshLoadMoreLayout;
    Object localObject1 = af.mU(paramContext).inflate(e.f.uni_load_more_footer, null);
    s.s(localObject1, "getInflater(context).inf…i_load_more_footer, null)");
    paramRefreshLoadMoreLayout.setLoadMoreFooter((View)localObject1);
    localObject1 = paramRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    Object localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).bZL = 0L;
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.FZO.gr(paramContext));
    if (aw.isDarkMode())
    {
      localObject2 = k.aeZF;
      ((RecyclerView)localObject1).setRecycledViewPool(((e)k.d((AppCompatActivity)paramContext).q(e.class)).GKY);
    }
    for (;;)
    {
      ((RecyclerView)localObject1).a((RecyclerView.l)new c(this, paramContext));
      paramContext = this.FZO.gl(paramContext);
      if (paramContext != null) {
        ((RecyclerView)localObject1).a(paramContext);
      }
      paramContext = paramRefreshLoadMoreLayout.getParent();
      if (paramContext != null) {
        break;
      }
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(341545);
      throw paramContext;
      localObject2 = k.aeZF;
      ((RecyclerView)localObject1).setRecycledViewPool(((e)k.d((AppCompatActivity)paramContext).q(e.class)).GKX);
    }
    paramContext = (View)paramContext;
    fdv().getFooterLayout().addOnLayoutChangeListener((View.OnLayoutChangeListener)new d(this, paramContext));
    AppMethodBeat.o(341545);
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt)
  {
    AppMethodBeat.i(341517);
    s.u(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    s.s(localObject, "drawer.context");
    s.u(localObject, "<set-?>");
    this.context = ((Context)localObject);
    paramRecyclerViewDrawer.setId(e.e.finder_comment_drawer);
    localObject = (UniCommentDrawer)paramRecyclerViewDrawer;
    s.u(localObject, "<set-?>");
    this.FZR = ((UniCommentDrawer)localObject);
    paramRecyclerViewDrawer.setSquaresBackgroundResource(e.d.finder_bottom_corner_shape);
    paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
    paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    fdv().setScene(2);
    paramRecyclerViewDrawer = fdv();
    if (fdv().getScene() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecyclerViewDrawer.setSelfProfile(bool);
      AppMethodBeat.o(341517);
      return;
    }
  }
  
  public final void ak(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(341567);
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject;
      if (fdv().getShowFooter())
      {
        fdu().setVisibility(0);
        localObject = getHeaderLayout().findViewById(e.e.finder_comment_closed_tips);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      for (;;)
      {
        localObject = this.FZO;
        UniCommentDrawer localUniCommentDrawer = fdv();
        com.tencent.mm.plugin.finder.uniComments.model.b localb = fdv().getFeedObj();
        s.checkNotNull(localb);
        e.a locala = fdv().getOnCloseDrawerCallback();
        int i = fdv().getScene();
        paramBoolean1 = fdv().plm;
        long l = fdv().getRefCommentId();
        com.tencent.mm.plugin.finder.uniComments.storge.b localb1 = fdv().getReplyCommentObj();
        paramBoolean2 = fdv().getUseCache();
        boolean bool1 = fdv().getBlinkRefComment();
        boolean bool2 = fdv().getCloseComment();
        fdv().getOldVersion();
        ((e.b)localObject).a(localUniCommentDrawer, this, localb, locala, i, paramBoolean1, l, localb1, paramBoolean2, bool1, bool2, fdv().AHQ);
        AppMethodBeat.o(341567);
        return;
        fdu().setVisibility(8);
        if (fdv().getCloseComment())
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
      this.FZO.onDetach();
    }
    AppMethodBeat.o(341567);
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(341553);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "footerLayout");
    paramContext = af.mU(paramContext).inflate(e.f.uni_comment_drawer_footer, (ViewGroup)paramFrameLayout).findViewById(e.e.finder_comment_footer);
    s.s(paramContext, "view.findViewById(R.id.finder_comment_footer)");
    paramContext = (UniCommentFooter)paramContext;
    s.u(paramContext, "<set-?>");
    this.FZQ = paramContext;
    fdu().setBackClickListener((kotlin.g.a.a)new e(paramBoolean, this));
    fdu().setSwitchSceneListener((kotlin.g.a.a)new f(this));
    fdu().setSelfProfile(fdv().EAO);
    fdu().setScene(fdv().getSceneForReply());
    fdu().setBanSwitchScene(fdv().getBanSwitch());
    Log.i("MicroMsg.MusicUni.TimelineDrawerBuilder", s.X("drawerFooter.scene ", Integer.valueOf(fdu().getScene())));
    fdu().up(false);
    fdu().uq(false);
    fdv().setKeyboardHeightObserver((com.tencent.mm.ui.tools.h)fdu());
    fdv().setFooter(fdu());
    AppMethodBeat.o(341553);
  }
  
  public final void bv(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(341583);
    s.u(parama, "onClick");
    getLoadingLayout().setVisibility(0);
    getLoadingView().setVisibility(8);
    fdw().setVisibility(8);
    fdx().setVisibility(0);
    fdx().setOnClickListener(new i..ExternalSyntheticLambda1(parama));
    AppMethodBeat.o(341583);
  }
  
  public final void c(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(341561);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "loadingLayout");
    s.u(paramFrameLayout, "<set-?>");
    this.FZT = paramFrameLayout;
    paramContext = LayoutInflater.from(paramContext).inflate(e.f.uni_comment_loading_tips_layout, (ViewGroup)paramFrameLayout, true);
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
    AppMethodBeat.o(341561);
  }
  
  public final void cm(float paramFloat)
  {
    AppMethodBeat.i(341572);
    if ((fdv().plm) && (fdu().getFooterMode() == 2)) {
      ((MMFragmentActivity)getContext()).hideVKB();
    }
    AppMethodBeat.o(341572);
  }
  
  public final void eIv()
  {
    AppMethodBeat.i(341589);
    this.FZO.onDetach();
    AppMethodBeat.o(341589);
  }
  
  public final TextView fdt()
  {
    AppMethodBeat.i(341463);
    TextView localTextView = this.FZP;
    if (localTextView != null)
    {
      AppMethodBeat.o(341463);
      return localTextView;
    }
    s.bIx("headerTitleTv");
    AppMethodBeat.o(341463);
    return null;
  }
  
  public final UniCommentFooter fdu()
  {
    AppMethodBeat.i(341475);
    UniCommentFooter localUniCommentFooter = this.FZQ;
    if (localUniCommentFooter != null)
    {
      AppMethodBeat.o(341475);
      return localUniCommentFooter;
    }
    s.bIx("drawerFooter");
    AppMethodBeat.o(341475);
    return null;
  }
  
  public final UniCommentDrawer fdv()
  {
    AppMethodBeat.i(341478);
    UniCommentDrawer localUniCommentDrawer = this.FZR;
    if (localUniCommentDrawer != null)
    {
      AppMethodBeat.o(341478);
      return localUniCommentDrawer;
    }
    s.bIx("commentDrawer");
    AppMethodBeat.o(341478);
    return null;
  }
  
  public final View fdw()
  {
    AppMethodBeat.i(341498);
    View localView = this.FZU;
    if (localView != null)
    {
      AppMethodBeat.o(341498);
      return localView;
    }
    s.bIx("nothingView");
    AppMethodBeat.o(341498);
    return null;
  }
  
  public final View fdx()
  {
    AppMethodBeat.i(341505);
    View localView = this.BsS;
    if (localView != null)
    {
      AppMethodBeat.o(341505);
      return localView;
    }
    s.bIx("retryView");
    AppMethodBeat.o(341505);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(341511);
    Context localContext = this.context;
    if (localContext != null)
    {
      AppMethodBeat.o(341511);
      return localContext;
    }
    s.bIx("context");
    AppMethodBeat.o(341511);
    return null;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(341484);
    FrameLayout localFrameLayout = this.FZS;
    if (localFrameLayout != null)
    {
      AppMethodBeat.o(341484);
      return localFrameLayout;
    }
    s.bIx("headerLayout");
    AppMethodBeat.o(341484);
    return null;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(341488);
    FrameLayout localFrameLayout = this.FZT;
    if (localFrameLayout != null)
    {
      AppMethodBeat.o(341488);
      return localFrameLayout;
    }
    s.bIx("loadingLayout");
    AppMethodBeat.o(341488);
    return null;
  }
  
  public final View getLoadingView()
  {
    AppMethodBeat.i(341491);
    View localView = this.njN;
    if (localView != null)
    {
      AppMethodBeat.o(341491);
      return localView;
    }
    s.bIx("loadingView");
    AppMethodBeat.o(341491);
    return null;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(341467);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    if (localRefreshLoadMoreLayout != null)
    {
      AppMethodBeat.o(341467);
      return localRefreshLoadMoreLayout;
    }
    s.bIx("rlLayout");
    AppMethodBeat.o(341467);
    return null;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(341579);
    getLoadingLayout().setVisibility(8);
    fdx().setOnClickListener(null);
    AppMethodBeat.o(341579);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(341575);
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      Log.i("MicroMsg.MusicUni.TimelineDrawerBuilder", "showLoading return for teen mode.");
      AppMethodBeat.o(341575);
      return;
    }
    getLoadingLayout().setVisibility(0);
    getLoadingView().setVisibility(0);
    fdw().setVisibility(8);
    fdx().setVisibility(8);
    AppMethodBeat.o(341575);
  }
  
  public final void us(boolean paramBoolean)
  {
    AppMethodBeat.i(341535);
    if ((!fdv().AHQ) && (paramBoolean))
    {
      getRlLayout().setEnableRefresh(true);
      if (getRlLayout().getRefreshHeader() == null)
      {
        RefreshLoadMoreLayout localRefreshLoadMoreLayout = getRlLayout();
        View localView = af.mU(getContext()).inflate(e.f.uni_refresh_header, null);
        s.s(localView, "getInflater(context).inf…uni_refresh_header, null)");
        localRefreshLoadMoreLayout.setRefreshHeaderView(localView);
        AppMethodBeat.o(341535);
      }
    }
    else
    {
      getRlLayout().setEnableRefresh(false);
    }
    AppMethodBeat.o(341535);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder$onBuildDrawerBody$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "lastState", "", "getLastState", "()I", "setLastState", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    private int AOc;
    
    c(i parami, Context paramContext) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(341348);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.AOc = paramInt;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(341348);
        return;
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(341348);
          throw paramRecyclerView;
        }
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        this.FZZ.FZO.NE(paramRecyclerView.Jw());
        continue;
        if (this.AOc != 3) {
          ((MMFragmentActivity)paramContext).hideVKB();
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(341359);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(341359);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder$onBuildDrawerBody$3", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements View.OnLayoutChangeListener
  {
    d(i parami, View paramView) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(341392);
      this.FZZ.fdv().getFooterLayout().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      paramContext.setPadding(paramContext.getPaddingLeft(), paramContext.getPaddingTop(), paramContext.getPaddingRight(), this.FZZ.fdu().getCommentEditTextLayout().getHeight());
      paramContext.requestLayout();
      Log.i("MicroMsg.MusicUni.TimelineDrawerBuilder", "bottomMargin=" + this.FZZ.fdu().getCommentEditTextLayout().getHeight() + " paddingBottom=" + paramContext.getPaddingBottom());
      AppMethodBeat.o(341392);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(boolean paramBoolean, i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    g(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.i
 * JD-Core Version:    0.7.0.1
 */