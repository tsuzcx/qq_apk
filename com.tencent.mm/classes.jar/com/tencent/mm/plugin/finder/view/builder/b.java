package com.tencent.mm.plugin.finder.view.builder;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "commentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getCommentDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setCommentDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "drawerFooter", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getDrawerFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setDrawerFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "headerErrTip", "Landroid/view/View;", "getHeaderErrTip", "()Landroid/view/View;", "setHeaderErrTip", "(Landroid/view/View;)V", "headerErrTv", "Landroid/widget/TextView;", "getHeaderErrTv", "()Landroid/widget/TextView;", "setHeaderErrTv", "(Landroid/widget/TextView;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "getHeaderTitleTv", "setHeaderTitleTv", "lastHideVKBTime", "", "getLastHideVKBTime", "()I", "setLastHideVKBTime", "(I)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "getLoadingView", "setLoadingView", "nothingView", "getNothingView", "setNothingView", "onBackPressed", "Lkotlin/Function0;", "", "getOnBackPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackPressed", "(Lkotlin/jvm/functions/Function0;)V", "onCloseBtnClick", "Lkotlin/Function1;", "getOnCloseBtnClick", "()Lkotlin/jvm/functions/Function1;", "setOnCloseBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "enable", "", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerFooter", "footerLayout", "fullScreen", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "scene", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Companion", "plugin-finder_release"})
public class b
  implements FinderCommentDrawer.a, RecyclerViewDrawerSquares.c
{
  public static final b.a saE;
  public Context context;
  public View gDe;
  public final CommentDrawerContract.NPresenter qZO;
  public RefreshLoadMoreLayout rfT;
  public View saA;
  public TextView saB;
  d.g.a.b<? super View, y> saC;
  d.g.a.a<y> saD;
  public TextView sap;
  public FrameLayout saq;
  public FrameLayout sar;
  public View sas;
  public View sat;
  public FinderCommentFooter say;
  public FinderCommentDrawer saz;
  
  static
  {
    AppMethodBeat.i(168495);
    saE = new b.a((byte)0);
    AppMethodBeat.o(168495);
  }
  
  public b(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(168494);
    this.qZO = paramNPresenter;
    this.saC = ((d.g.a.b)new h(this));
    this.saD = ((d.g.a.a)new b.b(this));
    AppMethodBeat.o(168494);
  }
  
  public final void O(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168490);
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject1 = this.saz;
      if (localObject1 == null) {
        k.aVY("commentDrawer");
      }
      if (((FinderCommentDrawer)localObject1).getShowFooter())
      {
        localObject1 = this.say;
        if (localObject1 == null) {
          k.aVY("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(0);
        localObject1 = this.saq;
        if (localObject1 == null) {
          k.aVY("headerLayout");
        }
        localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      for (;;)
      {
        localObject1 = this.qZO;
        Object localObject2 = this.saz;
        if (localObject2 == null) {
          k.aVY("commentDrawer");
        }
        localObject2 = ((FinderCommentDrawer)localObject2).getFeedObj();
        if (localObject2 == null) {
          k.fOy();
        }
        Object localObject3 = this.saz;
        if (localObject3 == null) {
          k.aVY("commentDrawer");
        }
        localObject3 = ((FinderCommentDrawer)localObject3).getOnCloseDrawerCallback();
        Object localObject4 = this.saz;
        if (localObject4 == null) {
          k.aVY("commentDrawer");
        }
        int i = ((FinderCommentDrawer)localObject4).getScene();
        localObject4 = this.saz;
        if (localObject4 == null) {
          k.aVY("commentDrawer");
        }
        paramBoolean1 = ((FinderCommentDrawer)localObject4).rgD;
        localObject4 = this.saz;
        if (localObject4 == null) {
          k.aVY("commentDrawer");
        }
        long l = ((FinderCommentDrawer)localObject4).getRefCommentId();
        localObject4 = this.saz;
        if (localObject4 == null) {
          k.aVY("commentDrawer");
        }
        localObject4 = ((FinderCommentDrawer)localObject4).getReplyCommentObj();
        FinderCommentDrawer localFinderCommentDrawer = this.saz;
        if (localFinderCommentDrawer == null) {
          k.aVY("commentDrawer");
        }
        paramBoolean2 = localFinderCommentDrawer.getUseCache();
        localFinderCommentDrawer = this.saz;
        if (localFinderCommentDrawer == null) {
          k.aVY("commentDrawer");
        }
        boolean bool1 = localFinderCommentDrawer.getBlinkRefComment();
        localFinderCommentDrawer = this.saz;
        if (localFinderCommentDrawer == null) {
          k.aVY("commentDrawer");
        }
        boolean bool2 = localFinderCommentDrawer.getCloseComment();
        localFinderCommentDrawer = this.saz;
        if (localFinderCommentDrawer == null) {
          k.aVY("commentDrawer");
        }
        ((CommentDrawerContract.NPresenter)localObject1).a(this, (FinderItem)localObject2, (CommentDrawerContract.CloseDrawerCallback)localObject3, i, paramBoolean1, l, (t)localObject4, paramBoolean2, bool1, bool2, localFinderCommentDrawer.getOldVersion());
        AppMethodBeat.o(168490);
        return;
        localObject1 = this.say;
        if (localObject1 == null) {
          k.aVY("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(8);
        localObject1 = this.saz;
        if (localObject1 == null) {
          k.aVY("commentDrawer");
        }
        if (((FinderCommentDrawer)localObject1).getCloseComment())
        {
          localObject1 = this.saq;
          if (localObject1 == null) {
            k.aVY("headerLayout");
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
        }
        else
        {
          localObject1 = this.saq;
          if (localObject1 == null) {
            k.aVY("headerLayout");
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
        }
      }
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      this.qZO.onDetach();
    }
    AppMethodBeat.o(168490);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(204337);
    k.h(paramContext, "context");
    k.h(paramFrameLayout, "headerLayout");
    this.saq = paramFrameLayout;
    if (paramBoolean) {}
    for (paramContext = z.jD(paramContext).inflate(2131496166, (ViewGroup)paramFrameLayout);; paramContext = z.jD(paramContext).inflate(2131493575, (ViewGroup)paramFrameLayout))
    {
      paramFrameLayout = paramContext.findViewById(2131299237);
      k.g(paramFrameLayout, "header.findViewById(R.id.drawer_header_tv)");
      this.sap = ((TextView)paramFrameLayout);
      paramFrameLayout = paramContext.findViewById(2131299982);
      k.g(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_tip)");
      this.saA = paramFrameLayout;
      paramFrameLayout = paramContext.findViewById(2131299980);
      k.g(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_msg)");
      this.saB = ((TextView)paramFrameLayout);
      paramFrameLayout = this.sap;
      if (paramFrameLayout == null) {
        k.aVY("headerTitleTv");
      }
      aj.a((Paint)paramFrameLayout.getPaint(), 0.8F);
      paramContext = paramContext.findViewById(2131298369);
      paramContext.setOnClickListener((View.OnClickListener)new g(this));
      paramFrameLayout = this.saz;
      if (paramFrameLayout == null) {
        k.aVY("commentDrawer");
      }
      k.g(paramContext, "closeBtn");
      paramFrameLayout.gT(paramContext);
      AppMethodBeat.o(204337);
      return;
    }
  }
  
  public final void a(Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(168487);
    k.h(paramContext, "context");
    k.h(paramRefreshLoadMoreLayout, "rlLayout");
    this.rfT = paramRefreshLoadMoreLayout;
    Object localObject1 = z.jD(paramContext).inflate(2131494590, null);
    k.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramRefreshLoadMoreLayout.setLoadMoreFooter((View)localObject1);
    localObject1 = paramRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    Object localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).lb();
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.qZO.eM(paramContext));
    localObject2 = com.tencent.mm.ui.component.a.IrY;
    ((RecyclerView)localObject1).setRecycledViewPool(((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderRecyclerViewPool.class)).scn);
    ((RecyclerView)localObject1).a((RecyclerView.m)new b.c(this, paramContext));
    ((RecyclerView)localObject1).b(this.qZO.eK(paramContext));
    paramContext = paramRefreshLoadMoreLayout.getParent();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(168487);
      throw paramContext;
    }
    paramContext = (View)paramContext;
    paramRefreshLoadMoreLayout = this.saz;
    if (paramRefreshLoadMoreLayout == null) {
      k.aVY("commentDrawer");
    }
    paramRefreshLoadMoreLayout.getFooterLayout().addOnLayoutChangeListener((View.OnLayoutChangeListener)new b.d(this, paramContext));
    AppMethodBeat.o(168487);
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt)
  {
    AppMethodBeat.i(204336);
    k.h(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    k.g(localObject, "drawer.context");
    this.context = ((Context)localObject);
    paramRecyclerViewDrawer.setId(2131299978);
    this.saz = ((FinderCommentDrawer)paramRecyclerViewDrawer);
    paramRecyclerViewDrawer.setSquaresBackgroundResource(2131234858);
    paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
    paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    paramRecyclerViewDrawer = this.saz;
    if (paramRecyclerViewDrawer == null) {
      k.aVY("commentDrawer");
    }
    paramRecyclerViewDrawer.setScene(paramInt);
    paramRecyclerViewDrawer = this.saz;
    if (paramRecyclerViewDrawer == null) {
      k.aVY("commentDrawer");
    }
    localObject = this.saz;
    if (localObject == null) {
      k.aVY("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).getScene() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecyclerViewDrawer.setSelfProfile(bool);
      AppMethodBeat.o(204336);
      return;
    }
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(168489);
    k.h(paramContext, "context");
    k.h(paramFrameLayout, "loadingLayout");
    this.sar = paramFrameLayout;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494015, (ViewGroup)paramFrameLayout, true);
    paramFrameLayout = paramContext.findViewById(2131298527);
    k.g(paramFrameLayout, "loadingContentLayout.fin…R.id.comment_loading_bar)");
    this.gDe = paramFrameLayout;
    paramFrameLayout = paramContext.findViewById(2131302874);
    k.g(paramFrameLayout, "loadingContentLayout.fin…yId(R.id.no_comment_hint)");
    this.sas = paramFrameLayout;
    paramContext = paramContext.findViewById(2131304147);
    k.g(paramContext, "loadingContentLayout.fin….id.retry_comment_layout)");
    this.sat = paramContext;
    paramContext = this.gDe;
    if (paramContext == null) {
      k.aVY("loadingView");
    }
    paramContext.setVisibility(0);
    paramContext = this.sas;
    if (paramContext == null) {
      k.aVY("nothingView");
    }
    paramContext.setVisibility(8);
    paramContext = this.sat;
    if (paramContext == null) {
      k.aVY("retryView");
    }
    paramContext.setVisibility(8);
    AppMethodBeat.o(168489);
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout, final boolean paramBoolean)
  {
    AppMethodBeat.i(204338);
    k.h(paramContext, "context");
    k.h(paramFrameLayout, "footerLayout");
    paramContext = z.jD(paramContext).inflate(2131493574, (ViewGroup)paramFrameLayout).findViewById(2131299983);
    k.g(paramContext, "view.findViewById(R.id.finder_comment_footer)");
    this.say = ((FinderCommentFooter)paramContext);
    paramContext = this.say;
    if (paramContext == null) {
      k.aVY("drawerFooter");
    }
    paramContext.setBackClickListener((d.g.a.a)new e(this, paramBoolean));
    paramContext = this.say;
    if (paramContext == null) {
      k.aVY("drawerFooter");
    }
    paramContext.setSwitchSceneListener((d.g.a.a)new f(this));
    paramContext = this.say;
    if (paramContext == null) {
      k.aVY("drawerFooter");
    }
    paramFrameLayout = this.saz;
    if (paramFrameLayout == null) {
      k.aVY("commentDrawer");
    }
    paramContext.setSelfProfile(paramFrameLayout.rVV);
    paramContext = this.say;
    if (paramContext == null) {
      k.aVY("drawerFooter");
    }
    paramFrameLayout = this.saz;
    if (paramFrameLayout == null) {
      k.aVY("commentDrawer");
    }
    paramContext.setScene(paramFrameLayout.getSceneForReply());
    paramContext = new StringBuilder("drawerFooter.scene ");
    paramFrameLayout = this.say;
    if (paramFrameLayout == null) {
      k.aVY("drawerFooter");
    }
    ac.i("Finder.TimelineDrawerBuilder", paramFrameLayout.getScene());
    paramContext = this.say;
    if (paramContext == null) {
      k.aVY("drawerFooter");
    }
    paramContext.cEL();
    paramContext = this.say;
    if (paramContext == null) {
      k.aVY("drawerFooter");
    }
    paramContext.cEM();
    paramContext = this.saz;
    if (paramContext == null) {
      k.aVY("commentDrawer");
    }
    paramFrameLayout = this.say;
    if (paramFrameLayout == null) {
      k.aVY("drawerFooter");
    }
    paramContext.setKeyboardHeightObserver((g)paramFrameLayout);
    paramContext = this.saz;
    if (paramContext == null) {
      k.aVY("commentDrawer");
    }
    paramFrameLayout = this.say;
    if (paramFrameLayout == null) {
      k.aVY("drawerFooter");
    }
    paramContext.setFooter(paramFrameLayout);
    AppMethodBeat.o(204338);
  }
  
  public final void bb(float paramFloat)
  {
    AppMethodBeat.i(168491);
    Object localObject = this.saz;
    if (localObject == null) {
      k.aVY("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).rgD)
    {
      localObject = this.say;
      if (localObject == null) {
        k.aVY("drawerFooter");
      }
      if (((FinderCommentFooter)localObject).getFooterMode() == 2)
      {
        localObject = this.context;
        if (localObject == null) {
          k.aVY("context");
        }
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168491);
          throw ((Throwable)localObject);
        }
        ((MMActivity)localObject).hideVKB();
      }
    }
    AppMethodBeat.o(168491);
  }
  
  public final TextView cFm()
  {
    AppMethodBeat.i(168477);
    TextView localTextView = this.sap;
    if (localTextView == null) {
      k.aVY("headerTitleTv");
    }
    AppMethodBeat.o(168477);
    return localTextView;
  }
  
  public final FinderCommentFooter cFo()
  {
    AppMethodBeat.i(168479);
    FinderCommentFooter localFinderCommentFooter = this.say;
    if (localFinderCommentFooter == null) {
      k.aVY("drawerFooter");
    }
    AppMethodBeat.o(168479);
    return localFinderCommentFooter;
  }
  
  public final FinderCommentDrawer cFp()
  {
    AppMethodBeat.i(168480);
    FinderCommentDrawer localFinderCommentDrawer = this.saz;
    if (localFinderCommentDrawer == null) {
      k.aVY("commentDrawer");
    }
    AppMethodBeat.o(168480);
    return localFinderCommentDrawer;
  }
  
  public final View cFq()
  {
    AppMethodBeat.i(168483);
    View localView = this.saA;
    if (localView == null) {
      k.aVY("headerErrTip");
    }
    AppMethodBeat.o(168483);
    return localView;
  }
  
  public final void cMT()
  {
    AppMethodBeat.i(210213);
    this.qZO.onDetach();
    AppMethodBeat.o(210213);
  }
  
  public final RefreshLoadMoreLayout cwM()
  {
    AppMethodBeat.i(168478);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rfT;
    if (localRefreshLoadMoreLayout == null) {
      k.aVY("rlLayout");
    }
    AppMethodBeat.o(168478);
    return localRefreshLoadMoreLayout;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(168482);
    Context localContext = this.context;
    if (localContext == null) {
      k.aVY("context");
    }
    AppMethodBeat.o(168482);
    return localContext;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(168481);
    FrameLayout localFrameLayout = this.saq;
    if (localFrameLayout == null) {
      k.aVY("headerLayout");
    }
    AppMethodBeat.o(168481);
    return localFrameLayout;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(168493);
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
    AppMethodBeat.o(168493);
  }
  
  public final void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(168486);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout;
    if (paramBoolean)
    {
      localRefreshLoadMoreLayout = this.rfT;
      if (localRefreshLoadMoreLayout == null) {
        k.aVY("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(true);
      localRefreshLoadMoreLayout = this.rfT;
      if (localRefreshLoadMoreLayout == null) {
        k.aVY("rlLayout");
      }
      if (localRefreshLoadMoreLayout.getRefreshHeader() == null)
      {
        localRefreshLoadMoreLayout = this.rfT;
        if (localRefreshLoadMoreLayout == null) {
          k.aVY("rlLayout");
        }
        Object localObject = this.context;
        if (localObject == null) {
          k.aVY("context");
        }
        localObject = z.jD((Context)localObject).inflate(2131495234, null);
        k.g(localObject, "MMLayoutInflater.getInfl…out.refresh_header, null)");
        localRefreshLoadMoreLayout.setRefreshHeaderView((View)localObject);
        AppMethodBeat.o(168486);
      }
    }
    else
    {
      localRefreshLoadMoreLayout = this.rfT;
      if (localRefreshLoadMoreLayout == null) {
        k.aVY("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(false);
    }
    AppMethodBeat.o(168486);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(168492);
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
    AppMethodBeat.o(168492);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168475);
      d.g.a.b localb = this.saF.saC;
      k.g(paramView, "it");
      localb.ay(paramView);
      AppMethodBeat.o(168475);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<View, y>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class i
    implements View.OnClickListener
  {
    public i(d.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168476);
      this.rQf.invoke();
      AppMethodBeat.o(168476);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.b
 * JD-Core Version:    0.7.0.1
 */