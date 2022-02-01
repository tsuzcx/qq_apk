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
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "commentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getCommentDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setCommentDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "drawerFooter", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getDrawerFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setDrawerFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "headerErrTip", "Landroid/view/View;", "getHeaderErrTip", "()Landroid/view/View;", "setHeaderErrTip", "(Landroid/view/View;)V", "headerErrTv", "Landroid/widget/TextView;", "getHeaderErrTv", "()Landroid/widget/TextView;", "setHeaderErrTv", "(Landroid/widget/TextView;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "getHeaderTitleTv", "setHeaderTitleTv", "lastHideVKBTime", "", "getLastHideVKBTime", "()I", "setLastHideVKBTime", "(I)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "getLoadingView", "setLoadingView", "nothingView", "getNothingView", "setNothingView", "onBackPressed", "Lkotlin/Function0;", "", "getOnBackPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackPressed", "(Lkotlin/jvm/functions/Function0;)V", "onCloseBtnClick", "Lkotlin/Function1;", "getOnCloseBtnClick", "()Lkotlin/jvm/functions/Function1;", "setOnCloseBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "enable", "", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerFooter", "footerLayout", "fullScreen", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "scene", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Companion", "plugin-finder_release"})
public class b
  implements FinderCommentDrawer.a, RecyclerViewDrawerSquares.c
{
  public static final a sXT;
  public Context context;
  public View gWO;
  public final CommentDrawerContract.NPresenter rMd;
  public RefreshLoadMoreLayout rTF;
  public TextView sXE;
  public FrameLayout sXF;
  public FrameLayout sXG;
  public View sXH;
  public View sXI;
  public FinderCommentFooter sXN;
  public FinderCommentDrawer sXO;
  public View sXP;
  public TextView sXQ;
  d.g.a.b<? super View, d.z> sXR;
  d.g.a.a<d.z> sXS;
  
  static
  {
    AppMethodBeat.i(168495);
    sXT = new a((byte)0);
    AppMethodBeat.o(168495);
  }
  
  public b(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(168494);
    this.rMd = paramNPresenter;
    this.sXR = ((d.g.a.b)new h(this));
    this.sXS = ((d.g.a.a)new b(this));
    AppMethodBeat.o(168494);
  }
  
  public final void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168490);
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject1 = this.sXO;
      if (localObject1 == null) {
        p.bcb("commentDrawer");
      }
      if (((FinderCommentDrawer)localObject1).getShowFooter())
      {
        localObject1 = this.sXN;
        if (localObject1 == null) {
          p.bcb("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(0);
        localObject1 = this.sXF;
        if (localObject1 == null) {
          p.bcb("headerLayout");
        }
        localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      for (;;)
      {
        localObject1 = this.rMd;
        FinderCommentDrawer localFinderCommentDrawer1 = this.sXO;
        if (localFinderCommentDrawer1 == null) {
          p.bcb("commentDrawer");
        }
        Object localObject2 = this.sXO;
        if (localObject2 == null) {
          p.bcb("commentDrawer");
        }
        localObject2 = ((FinderCommentDrawer)localObject2).getFeedObj();
        if (localObject2 == null) {
          p.gfZ();
        }
        Object localObject3 = this.sXO;
        if (localObject3 == null) {
          p.bcb("commentDrawer");
        }
        localObject3 = ((FinderCommentDrawer)localObject3).getOnCloseDrawerCallback();
        Object localObject4 = this.sXO;
        if (localObject4 == null) {
          p.bcb("commentDrawer");
        }
        int i = ((FinderCommentDrawer)localObject4).getScene();
        localObject4 = this.sXO;
        if (localObject4 == null) {
          p.bcb("commentDrawer");
        }
        paramBoolean1 = ((FinderCommentDrawer)localObject4).rUK;
        localObject4 = this.sXO;
        if (localObject4 == null) {
          p.bcb("commentDrawer");
        }
        long l = ((FinderCommentDrawer)localObject4).getRefCommentId();
        localObject4 = this.sXO;
        if (localObject4 == null) {
          p.bcb("commentDrawer");
        }
        localObject4 = ((FinderCommentDrawer)localObject4).getReplyCommentObj();
        FinderCommentDrawer localFinderCommentDrawer2 = this.sXO;
        if (localFinderCommentDrawer2 == null) {
          p.bcb("commentDrawer");
        }
        paramBoolean2 = localFinderCommentDrawer2.getUseCache();
        localFinderCommentDrawer2 = this.sXO;
        if (localFinderCommentDrawer2 == null) {
          p.bcb("commentDrawer");
        }
        boolean bool1 = localFinderCommentDrawer2.getBlinkRefComment();
        localFinderCommentDrawer2 = this.sXO;
        if (localFinderCommentDrawer2 == null) {
          p.bcb("commentDrawer");
        }
        boolean bool2 = localFinderCommentDrawer2.getCloseComment();
        localFinderCommentDrawer2 = this.sXO;
        if (localFinderCommentDrawer2 == null) {
          p.bcb("commentDrawer");
        }
        ((CommentDrawerContract.NPresenter)localObject1).a(localFinderCommentDrawer1, this, (FinderItem)localObject2, (CommentDrawerContract.CloseDrawerCallback)localObject3, i, paramBoolean1, l, (ab)localObject4, paramBoolean2, bool1, bool2, localFinderCommentDrawer2.getOldVersion());
        AppMethodBeat.o(168490);
        return;
        localObject1 = this.sXN;
        if (localObject1 == null) {
          p.bcb("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(8);
        localObject1 = this.sXO;
        if (localObject1 == null) {
          p.bcb("commentDrawer");
        }
        if (((FinderCommentDrawer)localObject1).getCloseComment())
        {
          localObject1 = this.sXF;
          if (localObject1 == null) {
            p.bcb("headerLayout");
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
        }
        else
        {
          localObject1 = this.sXF;
          if (localObject1 == null) {
            p.bcb("headerLayout");
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
        }
      }
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      this.rMd.onDetach();
    }
    AppMethodBeat.o(168490);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(205343);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "headerLayout");
    this.sXF = paramFrameLayout;
    if (paramBoolean) {}
    for (paramContext = com.tencent.mm.ui.z.jO(paramContext).inflate(2131496166, (ViewGroup)paramFrameLayout);; paramContext = com.tencent.mm.ui.z.jO(paramContext).inflate(2131493575, (ViewGroup)paramFrameLayout))
    {
      paramFrameLayout = paramContext.findViewById(2131299237);
      p.g(paramFrameLayout, "header.findViewById(R.id.drawer_header_tv)");
      this.sXE = ((TextView)paramFrameLayout);
      paramFrameLayout = paramContext.findViewById(2131299982);
      p.g(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_tip)");
      this.sXP = paramFrameLayout;
      paramFrameLayout = paramContext.findViewById(2131299980);
      p.g(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_msg)");
      this.sXQ = ((TextView)paramFrameLayout);
      paramFrameLayout = this.sXE;
      if (paramFrameLayout == null) {
        p.bcb("headerTitleTv");
      }
      al.a((Paint)paramFrameLayout.getPaint(), 0.8F);
      paramContext = paramContext.findViewById(2131298369);
      paramContext.setOnClickListener((View.OnClickListener)new g(this));
      paramFrameLayout = this.sXO;
      if (paramFrameLayout == null) {
        p.bcb("commentDrawer");
      }
      p.g(paramContext, "closeBtn");
      paramFrameLayout.hk(paramContext);
      AppMethodBeat.o(205343);
      return;
    }
  }
  
  public final void a(final Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(168487);
    p.h(paramContext, "context");
    p.h(paramRefreshLoadMoreLayout, "rlLayout");
    this.rTF = paramRefreshLoadMoreLayout;
    Object localObject1 = com.tencent.mm.ui.z.jO(paramContext).inflate(2131494590, null);
    p.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramRefreshLoadMoreLayout.setLoadMoreFooter((View)localObject1);
    localObject1 = paramRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    Object localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).lt();
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.rMd.eM(paramContext));
    localObject2 = com.tencent.mm.ui.component.a.KiD;
    ((RecyclerView)localObject1).setRecycledViewPool(((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderRecyclerViewPool.class)).sZG);
    ((RecyclerView)localObject1).a((RecyclerView.m)new c(this, paramContext));
    ((RecyclerView)localObject1).b(this.rMd.eK(paramContext));
    paramContext = paramRefreshLoadMoreLayout.getParent();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(168487);
      throw paramContext;
    }
    paramContext = (View)paramContext;
    paramRefreshLoadMoreLayout = this.sXO;
    if (paramRefreshLoadMoreLayout == null) {
      p.bcb("commentDrawer");
    }
    paramRefreshLoadMoreLayout.getFooterLayout().addOnLayoutChangeListener((View.OnLayoutChangeListener)new d(this, paramContext));
    AppMethodBeat.o(168487);
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt)
  {
    AppMethodBeat.i(205342);
    p.h(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    p.g(localObject, "drawer.context");
    this.context = ((Context)localObject);
    paramRecyclerViewDrawer.setId(2131299978);
    this.sXO = ((FinderCommentDrawer)paramRecyclerViewDrawer);
    paramRecyclerViewDrawer.setSquaresBackgroundResource(2131234858);
    paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
    paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    paramRecyclerViewDrawer = this.sXO;
    if (paramRecyclerViewDrawer == null) {
      p.bcb("commentDrawer");
    }
    paramRecyclerViewDrawer.setScene(paramInt);
    paramRecyclerViewDrawer = this.sXO;
    if (paramRecyclerViewDrawer == null) {
      p.bcb("commentDrawer");
    }
    localObject = this.sXO;
    if (localObject == null) {
      p.bcb("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).getScene() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecyclerViewDrawer.setSelfProfile(bool);
      AppMethodBeat.o(205342);
      return;
    }
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(168489);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "loadingLayout");
    this.sXG = paramFrameLayout;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494015, (ViewGroup)paramFrameLayout, true);
    paramFrameLayout = paramContext.findViewById(2131298527);
    p.g(paramFrameLayout, "loadingContentLayout.fin…R.id.comment_loading_bar)");
    this.gWO = paramFrameLayout;
    paramFrameLayout = paramContext.findViewById(2131302874);
    p.g(paramFrameLayout, "loadingContentLayout.fin…yId(R.id.no_comment_hint)");
    this.sXH = paramFrameLayout;
    paramContext = paramContext.findViewById(2131304147);
    p.g(paramContext, "loadingContentLayout.fin….id.retry_comment_layout)");
    this.sXI = paramContext;
    paramContext = this.gWO;
    if (paramContext == null) {
      p.bcb("loadingView");
    }
    paramContext.setVisibility(0);
    paramContext = this.sXH;
    if (paramContext == null) {
      p.bcb("nothingView");
    }
    paramContext.setVisibility(8);
    paramContext = this.sXI;
    if (paramContext == null) {
      p.bcb("retryView");
    }
    paramContext.setVisibility(8);
    AppMethodBeat.o(168489);
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout, final boolean paramBoolean)
  {
    AppMethodBeat.i(205344);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "footerLayout");
    paramContext = com.tencent.mm.ui.z.jO(paramContext).inflate(2131493574, (ViewGroup)paramFrameLayout).findViewById(2131299983);
    p.g(paramContext, "view.findViewById(R.id.finder_comment_footer)");
    this.sXN = ((FinderCommentFooter)paramContext);
    paramContext = this.sXN;
    if (paramContext == null) {
      p.bcb("drawerFooter");
    }
    paramContext.setBackClickListener((d.g.a.a)new e(this, paramBoolean));
    paramContext = this.sXN;
    if (paramContext == null) {
      p.bcb("drawerFooter");
    }
    paramContext.setSwitchSceneListener((d.g.a.a)new f(this));
    paramContext = this.sXN;
    if (paramContext == null) {
      p.bcb("drawerFooter");
    }
    paramFrameLayout = this.sXO;
    if (paramFrameLayout == null) {
      p.bcb("commentDrawer");
    }
    paramContext.setSelfProfile(paramFrameLayout.sSE);
    paramContext = this.sXN;
    if (paramContext == null) {
      p.bcb("drawerFooter");
    }
    paramFrameLayout = this.sXO;
    if (paramFrameLayout == null) {
      p.bcb("commentDrawer");
    }
    paramContext.setScene(paramFrameLayout.getSceneForReply());
    paramContext = this.sXN;
    if (paramContext == null) {
      p.bcb("drawerFooter");
    }
    paramFrameLayout = this.sXO;
    if (paramFrameLayout == null) {
      p.bcb("commentDrawer");
    }
    paramContext.setBanSwitchScene(paramFrameLayout.getBanSwitch());
    paramContext = new StringBuilder("drawerFooter.scene ");
    paramFrameLayout = this.sXN;
    if (paramFrameLayout == null) {
      p.bcb("drawerFooter");
    }
    ad.i("Finder.TimelineDrawerBuilder", paramFrameLayout.getScene());
    paramContext = this.sXN;
    if (paramContext == null) {
      p.bcb("drawerFooter");
    }
    paramContext.cNe();
    paramContext = this.sXN;
    if (paramContext == null) {
      p.bcb("drawerFooter");
    }
    paramContext.cNf();
    paramContext = this.sXO;
    if (paramContext == null) {
      p.bcb("commentDrawer");
    }
    paramFrameLayout = this.sXN;
    if (paramFrameLayout == null) {
      p.bcb("drawerFooter");
    }
    paramContext.setKeyboardHeightObserver((g)paramFrameLayout);
    paramContext = this.sXO;
    if (paramContext == null) {
      p.bcb("commentDrawer");
    }
    paramFrameLayout = this.sXN;
    if (paramFrameLayout == null) {
      p.bcb("drawerFooter");
    }
    paramContext.setFooter(paramFrameLayout);
    AppMethodBeat.o(205344);
  }
  
  public final void be(float paramFloat)
  {
    AppMethodBeat.i(168491);
    Object localObject = this.sXO;
    if (localObject == null) {
      p.bcb("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).rUK)
    {
      localObject = this.sXN;
      if (localObject == null) {
        p.bcb("drawerFooter");
      }
      if (((FinderCommentFooter)localObject).getFooterMode() == 2)
      {
        localObject = this.context;
        if (localObject == null) {
          p.bcb("context");
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
  
  public final RefreshLoadMoreLayout cDf()
  {
    AppMethodBeat.i(168478);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rTF;
    if (localRefreshLoadMoreLayout == null) {
      p.bcb("rlLayout");
    }
    AppMethodBeat.o(168478);
    return localRefreshLoadMoreLayout;
  }
  
  public final TextView cNI()
  {
    AppMethodBeat.i(168477);
    TextView localTextView = this.sXE;
    if (localTextView == null) {
      p.bcb("headerTitleTv");
    }
    AppMethodBeat.o(168477);
    return localTextView;
  }
  
  public final void cNK()
  {
    AppMethodBeat.i(205345);
    this.rMd.onDetach();
    AppMethodBeat.o(205345);
  }
  
  public final FinderCommentFooter cNL()
  {
    AppMethodBeat.i(168479);
    FinderCommentFooter localFinderCommentFooter = this.sXN;
    if (localFinderCommentFooter == null) {
      p.bcb("drawerFooter");
    }
    AppMethodBeat.o(168479);
    return localFinderCommentFooter;
  }
  
  public final FinderCommentDrawer cNM()
  {
    AppMethodBeat.i(168480);
    FinderCommentDrawer localFinderCommentDrawer = this.sXO;
    if (localFinderCommentDrawer == null) {
      p.bcb("commentDrawer");
    }
    AppMethodBeat.o(168480);
    return localFinderCommentDrawer;
  }
  
  public final View cNN()
  {
    AppMethodBeat.i(168483);
    View localView = this.sXP;
    if (localView == null) {
      p.bcb("headerErrTip");
    }
    AppMethodBeat.o(168483);
    return localView;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(168482);
    Context localContext = this.context;
    if (localContext == null) {
      p.bcb("context");
    }
    AppMethodBeat.o(168482);
    return localContext;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(168481);
    FrameLayout localFrameLayout = this.sXF;
    if (localFrameLayout == null) {
      p.bcb("headerLayout");
    }
    AppMethodBeat.o(168481);
    return localFrameLayout;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(168493);
    Object localObject = this.sXG;
    if (localObject == null) {
      p.bcb("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.sXI;
    if (localObject == null) {
      p.bcb("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(168493);
  }
  
  public final void mt(boolean paramBoolean)
  {
    AppMethodBeat.i(168486);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout;
    if (paramBoolean)
    {
      localRefreshLoadMoreLayout = this.rTF;
      if (localRefreshLoadMoreLayout == null) {
        p.bcb("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(true);
      localRefreshLoadMoreLayout = this.rTF;
      if (localRefreshLoadMoreLayout == null) {
        p.bcb("rlLayout");
      }
      if (localRefreshLoadMoreLayout.getRefreshHeader() == null)
      {
        localRefreshLoadMoreLayout = this.rTF;
        if (localRefreshLoadMoreLayout == null) {
          p.bcb("rlLayout");
        }
        Object localObject = this.context;
        if (localObject == null) {
          p.bcb("context");
        }
        localObject = com.tencent.mm.ui.z.jO((Context)localObject).inflate(2131495234, null);
        p.g(localObject, "MMLayoutInflater.getInfl…out.refresh_header, null)");
        localRefreshLoadMoreLayout.setRefreshHeaderView((View)localObject);
        AppMethodBeat.o(168486);
      }
    }
    else
    {
      localRefreshLoadMoreLayout = this.rTF;
      if (localRefreshLoadMoreLayout == null) {
        p.bcb("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(false);
    }
    AppMethodBeat.o(168486);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(168492);
    Object localObject = this.sXG;
    if (localObject == null) {
      p.bcb("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.gWO;
    if (localObject == null) {
      p.bcb("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.sXH;
    if (localObject == null) {
      p.bcb("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.sXI;
    if (localObject == null) {
      p.bcb("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168492);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<d.z>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "lastState", "", "getLastState", "()I", "setLastState", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {
    private int rQP;
    
    c(Context paramContext) {}
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205340);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(205340);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(178494);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.rQP = paramInt;
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
        this.sXU.rMd.Ey(paramRecyclerView.ko());
        continue;
        if (this.rQP != 3)
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$3", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class d
    implements View.OnLayoutChangeListener
  {
    d(View paramView) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(178495);
      this.sXU.cNM().getFooterLayout().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      paramContext.setPadding(paramContext.getPaddingLeft(), paramContext.getPaddingTop(), paramContext.getPaddingRight(), this.sXU.cNL().getCommentEditTextLayout().getHeight());
      paramContext.requestLayout();
      ad.i("Finder.TimelineDrawerBuilder", "bottomMargin=" + this.sXU.cNL().getCommentEditTextLayout().getHeight() + " paddingBottom=" + paramContext.getPaddingBottom());
      AppMethodBeat.o(178495);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<d.z>
  {
    e(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<d.z>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168475);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = this.sXU.sXR;
      p.g(paramView, "it");
      ((d.g.a.b)localObject).invoke(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168475);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class h
    extends q
    implements d.g.a.b<View, d.z>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class i
    implements View.OnClickListener
  {
    public i(d.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168476);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sMK.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168476);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.b
 * JD-Core Version:    0.7.0.1
 */