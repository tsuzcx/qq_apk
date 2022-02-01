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
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "commentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getCommentDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setCommentDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "drawerFooter", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getDrawerFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setDrawerFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "headerErrTip", "Landroid/view/View;", "getHeaderErrTip", "()Landroid/view/View;", "setHeaderErrTip", "(Landroid/view/View;)V", "headerErrTv", "Landroid/widget/TextView;", "getHeaderErrTv", "()Landroid/widget/TextView;", "setHeaderErrTv", "(Landroid/widget/TextView;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "getHeaderTitleTv", "setHeaderTitleTv", "lastHideVKBTime", "", "getLastHideVKBTime", "()I", "setLastHideVKBTime", "(I)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "getLoadingView", "setLoadingView", "nothingView", "getNothingView", "setNothingView", "onBackPressed", "Lkotlin/Function0;", "", "getOnBackPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackPressed", "(Lkotlin/jvm/functions/Function0;)V", "onCloseBtnClick", "Lkotlin/Function1;", "getOnCloseBtnClick", "()Lkotlin/jvm/functions/Function1;", "setOnCloseBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "enable", "", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerFooter", "footerLayout", "fullScreen", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "scene", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Companion", "plugin-finder_release"})
public class a
  implements FinderCommentDrawer.a, RecyclerViewDrawerSquares.c
{
  public static final a qYJ;
  d.g.a.b<? super View, d.y> LgF;
  d.g.a.a<d.y> LgG;
  public Context context;
  public View lZo;
  public TextView qYA;
  public FinderCommentFooter qYB;
  public FinderCommentDrawer qYC;
  public FrameLayout qYD;
  public FrameLayout qYE;
  public View qYF;
  public View qYG;
  public View qYH;
  public TextView qYI;
  public final CommentDrawerContract.NPresenter qqh;
  public RefreshLoadMoreLayout quj;
  
  static
  {
    AppMethodBeat.i(168495);
    qYJ = new a((byte)0);
    AppMethodBeat.o(168495);
  }
  
  public a(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(168494);
    this.qqh = paramNPresenter;
    this.LgF = ((d.g.a.b)new i(this));
    this.LgG = ((d.g.a.a)new h(this));
    AppMethodBeat.o(168494);
  }
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168490);
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject1 = this.qYC;
      if (localObject1 == null) {
        d.g.b.k.aPZ("commentDrawer");
      }
      if (((FinderCommentDrawer)localObject1).getShowFooter())
      {
        localObject1 = this.qYB;
        if (localObject1 == null) {
          d.g.b.k.aPZ("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(0);
        localObject1 = this.qYD;
        if (localObject1 == null) {
          d.g.b.k.aPZ("headerLayout");
        }
        localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      for (;;)
      {
        localObject1 = this.qqh;
        Object localObject2 = this.qYC;
        if (localObject2 == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        localObject2 = ((FinderCommentDrawer)localObject2).getFeedObj();
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        Object localObject3 = this.qYC;
        if (localObject3 == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        localObject3 = ((FinderCommentDrawer)localObject3).getOnCloseDrawerCallback();
        Object localObject4 = this.qYC;
        if (localObject4 == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        int i = ((FinderCommentDrawer)localObject4).getScene();
        localObject4 = this.qYC;
        if (localObject4 == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        paramBoolean1 = ((FinderCommentDrawer)localObject4).quB;
        localObject4 = this.qYC;
        if (localObject4 == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        long l = ((FinderCommentDrawer)localObject4).getRefCommentId();
        localObject4 = this.qYC;
        if (localObject4 == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        localObject4 = ((FinderCommentDrawer)localObject4).getReplyCommentObj();
        FinderCommentDrawer localFinderCommentDrawer = this.qYC;
        if (localFinderCommentDrawer == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        paramBoolean2 = localFinderCommentDrawer.getUseCache();
        localFinderCommentDrawer = this.qYC;
        if (localFinderCommentDrawer == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        boolean bool1 = localFinderCommentDrawer.getBlinkRefComment();
        localFinderCommentDrawer = this.qYC;
        if (localFinderCommentDrawer == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        boolean bool2 = localFinderCommentDrawer.getCloseComment();
        localFinderCommentDrawer = this.qYC;
        if (localFinderCommentDrawer == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        ((CommentDrawerContract.NPresenter)localObject1).a(this, (FinderItem)localObject2, (CommentDrawerContract.CloseDrawerCallback)localObject3, i, paramBoolean1, l, (com.tencent.mm.plugin.finder.storage.k)localObject4, paramBoolean2, bool1, bool2, localFinderCommentDrawer.getOldVersion());
        AppMethodBeat.o(168490);
        return;
        localObject1 = this.qYB;
        if (localObject1 == null) {
          d.g.b.k.aPZ("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(8);
        localObject1 = this.qYC;
        if (localObject1 == null) {
          d.g.b.k.aPZ("commentDrawer");
        }
        if (((FinderCommentDrawer)localObject1).getCloseComment())
        {
          localObject1 = this.qYD;
          if (localObject1 == null) {
            d.g.b.k.aPZ("headerLayout");
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
        }
        else
        {
          localObject1 = this.qYD;
          if (localObject1 == null) {
            d.g.b.k.aPZ("headerLayout");
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
        }
      }
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      this.qqh.onDetach();
    }
    AppMethodBeat.o(168490);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(200267);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramFrameLayout, "headerLayout");
    this.qYD = paramFrameLayout;
    if (paramBoolean) {}
    for (paramContext = com.tencent.mm.ui.y.js(paramContext).inflate(2131496165, (ViewGroup)paramFrameLayout);; paramContext = com.tencent.mm.ui.y.js(paramContext).inflate(2131493575, (ViewGroup)paramFrameLayout))
    {
      paramFrameLayout = paramContext.findViewById(2131299237);
      d.g.b.k.g(paramFrameLayout, "header.findViewById(R.id.drawer_header_tv)");
      this.qYA = ((TextView)paramFrameLayout);
      paramFrameLayout = paramContext.findViewById(2131299982);
      d.g.b.k.g(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_tip)");
      this.qYH = paramFrameLayout;
      paramFrameLayout = paramContext.findViewById(2131299980);
      d.g.b.k.g(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_msg)");
      this.qYI = ((TextView)paramFrameLayout);
      paramFrameLayout = this.qYA;
      if (paramFrameLayout == null) {
        d.g.b.k.aPZ("headerTitleTv");
      }
      ai.a((Paint)paramFrameLayout.getPaint(), 0.8F);
      paramContext = paramContext.findViewById(2131298369);
      paramContext.setOnClickListener((View.OnClickListener)new f(this));
      paramFrameLayout = this.qYC;
      if (paramFrameLayout == null) {
        d.g.b.k.aPZ("commentDrawer");
      }
      d.g.b.k.g(paramContext, "closeBtn");
      paramFrameLayout.gV(paramContext);
      AppMethodBeat.o(200267);
      return;
    }
  }
  
  public final void a(final Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(168487);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramRefreshLoadMoreLayout, "rlLayout");
    this.quj = paramRefreshLoadMoreLayout;
    Object localObject1 = com.tencent.mm.ui.y.js(paramContext).inflate(2131494590, null);
    d.g.b.k.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramRefreshLoadMoreLayout.setLoadMoreFooter((View)localObject1);
    localObject1 = paramRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    Object localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).kT();
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.qqh.eD(paramContext));
    localObject2 = com.tencent.mm.ui.component.a.LCX;
    ((RecyclerView)localObject1).setRecycledViewPool(((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderRecyclerViewPool.class)).Lhr);
    ((RecyclerView)localObject1).a((RecyclerView.m)new b(this, paramContext));
    ((RecyclerView)localObject1).b(this.qqh.eC(paramContext));
    paramContext = paramRefreshLoadMoreLayout.getParent();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(168487);
      throw paramContext;
    }
    paramContext = (View)paramContext;
    paramRefreshLoadMoreLayout = this.qYC;
    if (paramRefreshLoadMoreLayout == null) {
      d.g.b.k.aPZ("commentDrawer");
    }
    paramRefreshLoadMoreLayout.getFooterLayout().addOnLayoutChangeListener((View.OnLayoutChangeListener)new c(this, paramContext));
    AppMethodBeat.o(168487);
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt)
  {
    AppMethodBeat.i(200266);
    d.g.b.k.h(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    d.g.b.k.g(localObject, "drawer.context");
    this.context = ((Context)localObject);
    paramRecyclerViewDrawer.setId(2131299978);
    this.qYC = ((FinderCommentDrawer)paramRecyclerViewDrawer);
    paramRecyclerViewDrawer.setSquaresBackgroundResource(2131234854);
    paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
    paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    paramRecyclerViewDrawer = this.qYC;
    if (paramRecyclerViewDrawer == null) {
      d.g.b.k.aPZ("commentDrawer");
    }
    paramRecyclerViewDrawer.setScene(paramInt);
    paramRecyclerViewDrawer = this.qYC;
    if (paramRecyclerViewDrawer == null) {
      d.g.b.k.aPZ("commentDrawer");
    }
    localObject = this.qYC;
    if (localObject == null) {
      d.g.b.k.aPZ("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).getScene() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecyclerViewDrawer.setSelfProfile(bool);
      AppMethodBeat.o(200266);
      return;
    }
  }
  
  public final void aU(float paramFloat)
  {
    AppMethodBeat.i(168491);
    Object localObject = this.qYC;
    if (localObject == null) {
      d.g.b.k.aPZ("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).quB)
    {
      localObject = this.qYB;
      if (localObject == null) {
        d.g.b.k.aPZ("drawerFooter");
      }
      if (((FinderCommentFooter)localObject).getFooterMode() == 2)
      {
        localObject = this.context;
        if (localObject == null) {
          d.g.b.k.aPZ("context");
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
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout, final boolean paramBoolean)
  {
    AppMethodBeat.i(200268);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramFrameLayout, "footerLayout");
    paramContext = com.tencent.mm.ui.y.js(paramContext).inflate(2131493574, (ViewGroup)paramFrameLayout).findViewById(2131299983);
    d.g.b.k.g(paramContext, "view.findViewById(R.id.finder_comment_footer)");
    this.qYB = ((FinderCommentFooter)paramContext);
    paramContext = this.qYB;
    if (paramContext == null) {
      d.g.b.k.aPZ("drawerFooter");
    }
    paramContext.setBackClickListener((d.g.a.a)new d(this, paramBoolean));
    paramContext = this.qYB;
    if (paramContext == null) {
      d.g.b.k.aPZ("drawerFooter");
    }
    paramContext.setSwitchSceneListener((d.g.a.a)new e(this));
    paramContext = this.qYB;
    if (paramContext == null) {
      d.g.b.k.aPZ("drawerFooter");
    }
    paramFrameLayout = this.qYC;
    if (paramFrameLayout == null) {
      d.g.b.k.aPZ("commentDrawer");
    }
    paramContext.setSelfProfile(paramFrameLayout.qVE);
    paramContext = this.qYB;
    if (paramContext == null) {
      d.g.b.k.aPZ("drawerFooter");
    }
    paramFrameLayout = this.qYC;
    if (paramFrameLayout == null) {
      d.g.b.k.aPZ("commentDrawer");
    }
    paramContext.setScene(paramFrameLayout.getSceneForReply());
    paramContext = new StringBuilder("drawerFooter.scene ");
    paramFrameLayout = this.qYB;
    if (paramFrameLayout == null) {
      d.g.b.k.aPZ("drawerFooter");
    }
    ad.i("Finder.TimelineDrawerBuilder", paramFrameLayout.getScene());
    paramContext = this.qYB;
    if (paramContext == null) {
      d.g.b.k.aPZ("drawerFooter");
    }
    paramContext.csK();
    paramContext = this.qYB;
    if (paramContext == null) {
      d.g.b.k.aPZ("drawerFooter");
    }
    paramContext.csL();
    paramContext = this.qYC;
    if (paramContext == null) {
      d.g.b.k.aPZ("commentDrawer");
    }
    paramFrameLayout = this.qYB;
    if (paramFrameLayout == null) {
      d.g.b.k.aPZ("drawerFooter");
    }
    paramContext.setKeyboardHeightObserver((g)paramFrameLayout);
    paramContext = this.qYC;
    if (paramContext == null) {
      d.g.b.k.aPZ("commentDrawer");
    }
    paramFrameLayout = this.qYB;
    if (paramFrameLayout == null) {
      d.g.b.k.aPZ("drawerFooter");
    }
    paramContext.setFooter(paramFrameLayout);
    AppMethodBeat.o(200268);
  }
  
  public final void c(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(168489);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramFrameLayout, "loadingLayout");
    this.qYE = paramFrameLayout;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494015, (ViewGroup)paramFrameLayout, true);
    paramFrameLayout = paramContext.findViewById(2131298527);
    d.g.b.k.g(paramFrameLayout, "loadingContentLayout.fin…R.id.comment_loading_bar)");
    this.lZo = paramFrameLayout;
    paramFrameLayout = paramContext.findViewById(2131302874);
    d.g.b.k.g(paramFrameLayout, "loadingContentLayout.fin…yId(R.id.no_comment_hint)");
    this.qYF = paramFrameLayout;
    paramContext = paramContext.findViewById(2131304147);
    d.g.b.k.g(paramContext, "loadingContentLayout.fin….id.retry_comment_layout)");
    this.qYG = paramContext;
    paramContext = this.lZo;
    if (paramContext == null) {
      d.g.b.k.aPZ("loadingView");
    }
    paramContext.setVisibility(0);
    paramContext = this.qYF;
    if (paramContext == null) {
      d.g.b.k.aPZ("nothingView");
    }
    paramContext.setVisibility(8);
    paramContext = this.qYG;
    if (paramContext == null) {
      d.g.b.k.aPZ("retryView");
    }
    paramContext.setVisibility(8);
    AppMethodBeat.o(168489);
  }
  
  public final RefreshLoadMoreLayout cny()
  {
    AppMethodBeat.i(168478);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.quj;
    if (localRefreshLoadMoreLayout == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    AppMethodBeat.o(168478);
    return localRefreshLoadMoreLayout;
  }
  
  public final TextView csV()
  {
    AppMethodBeat.i(168477);
    TextView localTextView = this.qYA;
    if (localTextView == null) {
      d.g.b.k.aPZ("headerTitleTv");
    }
    AppMethodBeat.o(168477);
    return localTextView;
  }
  
  public final FinderCommentFooter csW()
  {
    AppMethodBeat.i(168479);
    FinderCommentFooter localFinderCommentFooter = this.qYB;
    if (localFinderCommentFooter == null) {
      d.g.b.k.aPZ("drawerFooter");
    }
    AppMethodBeat.o(168479);
    return localFinderCommentFooter;
  }
  
  public final FinderCommentDrawer csX()
  {
    AppMethodBeat.i(168480);
    FinderCommentDrawer localFinderCommentDrawer = this.qYC;
    if (localFinderCommentDrawer == null) {
      d.g.b.k.aPZ("commentDrawer");
    }
    AppMethodBeat.o(168480);
    return localFinderCommentDrawer;
  }
  
  public final View csY()
  {
    AppMethodBeat.i(168483);
    View localView = this.qYH;
    if (localView == null) {
      d.g.b.k.aPZ("headerErrTip");
    }
    AppMethodBeat.o(168483);
    return localView;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(168482);
    Context localContext = this.context;
    if (localContext == null) {
      d.g.b.k.aPZ("context");
    }
    AppMethodBeat.o(168482);
    return localContext;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(168481);
    FrameLayout localFrameLayout = this.qYD;
    if (localFrameLayout == null) {
      d.g.b.k.aPZ("headerLayout");
    }
    AppMethodBeat.o(168481);
    return localFrameLayout;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(168493);
    Object localObject = this.qYE;
    if (localObject == null) {
      d.g.b.k.aPZ("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.qYG;
    if (localObject == null) {
      d.g.b.k.aPZ("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(168493);
  }
  
  public final void ln(boolean paramBoolean)
  {
    AppMethodBeat.i(168486);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout;
    if (paramBoolean)
    {
      localRefreshLoadMoreLayout = this.quj;
      if (localRefreshLoadMoreLayout == null) {
        d.g.b.k.aPZ("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(true);
      localRefreshLoadMoreLayout = this.quj;
      if (localRefreshLoadMoreLayout == null) {
        d.g.b.k.aPZ("rlLayout");
      }
      if (localRefreshLoadMoreLayout.getRefreshHeader() == null)
      {
        localRefreshLoadMoreLayout = this.quj;
        if (localRefreshLoadMoreLayout == null) {
          d.g.b.k.aPZ("rlLayout");
        }
        Object localObject = this.context;
        if (localObject == null) {
          d.g.b.k.aPZ("context");
        }
        localObject = com.tencent.mm.ui.y.js((Context)localObject).inflate(2131495234, null);
        d.g.b.k.g(localObject, "MMLayoutInflater.getInfl…out.refresh_header, null)");
        localRefreshLoadMoreLayout.setRefreshHeaderView((View)localObject);
        AppMethodBeat.o(168486);
      }
    }
    else
    {
      localRefreshLoadMoreLayout = this.quj;
      if (localRefreshLoadMoreLayout == null) {
        d.g.b.k.aPZ("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(false);
    }
    AppMethodBeat.o(168486);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(168492);
    Object localObject = this.qYE;
    if (localObject == null) {
      d.g.b.k.aPZ("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.lZo;
    if (localObject == null) {
      d.g.b.k.aPZ("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.qYF;
    if (localObject == null) {
      d.g.b.k.aPZ("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.qYG;
    if (localObject == null) {
      d.g.b.k.aPZ("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168492);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "lastState", "", "getLastState", "()I", "setLastState", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.m
  {
    private int qsI;
    
    b(Context paramContext) {}
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200264);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(200264);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(178494);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.qsI = paramInt;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(178494);
        return;
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(178494);
          throw paramRecyclerView;
        }
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        this.qYK.qqh.CD(paramRecyclerView.jQ());
        continue;
        if (this.qsI != 3)
        {
          paramRecyclerView = paramContext;
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(178494);
            throw paramRecyclerView;
          }
          ((MMActivity)paramRecyclerView).hideVKB();
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$3", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class c
    implements View.OnLayoutChangeListener
  {
    c(View paramView) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(178495);
      this.qYK.csX().getFooterLayout().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      paramView = paramContext.getLayoutParams();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(178495);
        throw paramView;
      }
      paramView = (FrameLayout.LayoutParams)paramView;
      paramView.height = (paramContext.getHeight() - this.qYK.csW().getCommentEditTextLayout().getHeight());
      paramContext.requestLayout();
      ad.i("Finder.TimelineDrawerBuilder", "bottomMargin=" + this.qYK.csW().getCommentEditTextLayout().getHeight() + " BodyHeight=" + paramView.height);
      AppMethodBeat.o(178495);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    d(a parama, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168475);
      d.g.a.b localb = this.qYK.LgF;
      d.g.b.k.g(paramView, "it");
      localb.aA(paramView);
      AppMethodBeat.o(168475);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class g
    implements View.OnClickListener
  {
    public g(d.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168476);
      this.qYM.invoke();
      AppMethodBeat.o(168476);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<View, d.y>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.a
 * JD-Core Version:    0.7.0.1
 */