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
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "commentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getCommentDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setCommentDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "drawerFooter", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getDrawerFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setDrawerFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "headerErrTip", "Landroid/view/View;", "getHeaderErrTip", "()Landroid/view/View;", "setHeaderErrTip", "(Landroid/view/View;)V", "headerErrTv", "Landroid/widget/TextView;", "getHeaderErrTv", "()Landroid/widget/TextView;", "setHeaderErrTv", "(Landroid/widget/TextView;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "getHeaderTitleTv", "setHeaderTitleTv", "lastHideVKBTime", "", "getLastHideVKBTime", "()I", "setLastHideVKBTime", "(I)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "getLoadingView", "setLoadingView", "nothingView", "getNothingView", "setNothingView", "onBackPressed", "Lkotlin/Function0;", "", "getOnBackPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackPressed", "(Lkotlin/jvm/functions/Function0;)V", "onCloseBtnClick", "Lkotlin/Function1;", "getOnCloseBtnClick", "()Lkotlin/jvm/functions/Function1;", "setOnCloseBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "enable", "", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerFooter", "footerLayout", "fullScreen", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "scene", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Companion", "plugin-finder_release"})
public class b
  implements FinderCommentDrawer.a, RecyclerViewDrawerSquares.c
{
  public static final a tjh;
  public Context context;
  public View gZB;
  public final CommentDrawerContract.NPresenter rUq;
  public RefreshLoadMoreLayout scj;
  public TextView tiS;
  public FrameLayout tiT;
  public FrameLayout tiU;
  public View tiV;
  public View tiW;
  public FinderCommentFooter tjb;
  public FinderCommentDrawer tjc;
  public View tjd;
  public TextView tje;
  d.g.a.b<? super View, d.z> tjf;
  d.g.a.a<d.z> tjg;
  
  static
  {
    AppMethodBeat.i(168495);
    tjh = new a((byte)0);
    AppMethodBeat.o(168495);
  }
  
  public b(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(168494);
    this.rUq = paramNPresenter;
    this.tjf = ((d.g.a.b)new h(this));
    this.tjg = ((d.g.a.a)new b(this));
    AppMethodBeat.o(168494);
  }
  
  public final void P(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168490);
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject1 = this.tjc;
      if (localObject1 == null) {
        p.bdF("commentDrawer");
      }
      if (((FinderCommentDrawer)localObject1).getShowFooter())
      {
        localObject1 = this.tjb;
        if (localObject1 == null) {
          p.bdF("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(0);
        localObject1 = this.tiT;
        if (localObject1 == null) {
          p.bdF("headerLayout");
        }
        localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      for (;;)
      {
        localObject1 = this.rUq;
        FinderCommentDrawer localFinderCommentDrawer1 = this.tjc;
        if (localFinderCommentDrawer1 == null) {
          p.bdF("commentDrawer");
        }
        Object localObject2 = this.tjc;
        if (localObject2 == null) {
          p.bdF("commentDrawer");
        }
        localObject2 = ((FinderCommentDrawer)localObject2).getFeedObj();
        if (localObject2 == null) {
          p.gkB();
        }
        Object localObject3 = this.tjc;
        if (localObject3 == null) {
          p.bdF("commentDrawer");
        }
        localObject3 = ((FinderCommentDrawer)localObject3).getOnCloseDrawerCallback();
        Object localObject4 = this.tjc;
        if (localObject4 == null) {
          p.bdF("commentDrawer");
        }
        int i = ((FinderCommentDrawer)localObject4).getScene();
        localObject4 = this.tjc;
        if (localObject4 == null) {
          p.bdF("commentDrawer");
        }
        paramBoolean1 = ((FinderCommentDrawer)localObject4).sdo;
        localObject4 = this.tjc;
        if (localObject4 == null) {
          p.bdF("commentDrawer");
        }
        long l = ((FinderCommentDrawer)localObject4).getRefCommentId();
        localObject4 = this.tjc;
        if (localObject4 == null) {
          p.bdF("commentDrawer");
        }
        localObject4 = ((FinderCommentDrawer)localObject4).getReplyCommentObj();
        FinderCommentDrawer localFinderCommentDrawer2 = this.tjc;
        if (localFinderCommentDrawer2 == null) {
          p.bdF("commentDrawer");
        }
        paramBoolean2 = localFinderCommentDrawer2.getUseCache();
        localFinderCommentDrawer2 = this.tjc;
        if (localFinderCommentDrawer2 == null) {
          p.bdF("commentDrawer");
        }
        boolean bool1 = localFinderCommentDrawer2.getBlinkRefComment();
        localFinderCommentDrawer2 = this.tjc;
        if (localFinderCommentDrawer2 == null) {
          p.bdF("commentDrawer");
        }
        boolean bool2 = localFinderCommentDrawer2.getCloseComment();
        localFinderCommentDrawer2 = this.tjc;
        if (localFinderCommentDrawer2 == null) {
          p.bdF("commentDrawer");
        }
        ((CommentDrawerContract.NPresenter)localObject1).a(localFinderCommentDrawer1, this, (FinderItem)localObject2, (CommentDrawerContract.CloseDrawerCallback)localObject3, i, paramBoolean1, l, (ab)localObject4, paramBoolean2, bool1, bool2, localFinderCommentDrawer2.getOldVersion());
        AppMethodBeat.o(168490);
        return;
        localObject1 = this.tjb;
        if (localObject1 == null) {
          p.bdF("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(8);
        localObject1 = this.tjc;
        if (localObject1 == null) {
          p.bdF("commentDrawer");
        }
        if (((FinderCommentDrawer)localObject1).getCloseComment())
        {
          localObject1 = this.tiT;
          if (localObject1 == null) {
            p.bdF("headerLayout");
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
        }
        else
        {
          localObject1 = this.tiT;
          if (localObject1 == null) {
            p.bdF("headerLayout");
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(2131299977);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
        }
      }
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      this.rUq.onDetach();
    }
    AppMethodBeat.o(168490);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(205986);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "headerLayout");
    this.tiT = paramFrameLayout;
    if (paramBoolean) {}
    for (paramContext = com.tencent.mm.ui.z.jV(paramContext).inflate(2131496166, (ViewGroup)paramFrameLayout);; paramContext = com.tencent.mm.ui.z.jV(paramContext).inflate(2131493575, (ViewGroup)paramFrameLayout))
    {
      paramFrameLayout = paramContext.findViewById(2131299237);
      p.g(paramFrameLayout, "header.findViewById(R.id.drawer_header_tv)");
      this.tiS = ((TextView)paramFrameLayout);
      paramFrameLayout = paramContext.findViewById(2131299982);
      p.g(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_tip)");
      this.tjd = paramFrameLayout;
      paramFrameLayout = paramContext.findViewById(2131299980);
      p.g(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_msg)");
      this.tje = ((TextView)paramFrameLayout);
      paramFrameLayout = this.tiS;
      if (paramFrameLayout == null) {
        p.bdF("headerTitleTv");
      }
      al.a((Paint)paramFrameLayout.getPaint(), 0.8F);
      paramContext = paramContext.findViewById(2131298369);
      paramContext.setOnClickListener((View.OnClickListener)new g(this));
      paramFrameLayout = this.tjc;
      if (paramFrameLayout == null) {
        p.bdF("commentDrawer");
      }
      p.g(paramContext, "closeBtn");
      paramFrameLayout.hp(paramContext);
      AppMethodBeat.o(205986);
      return;
    }
  }
  
  public final void a(final Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(168487);
    p.h(paramContext, "context");
    p.h(paramRefreshLoadMoreLayout, "rlLayout");
    this.scj = paramRefreshLoadMoreLayout;
    Object localObject1 = com.tencent.mm.ui.z.jV(paramContext).inflate(2131494590, null);
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
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.rUq.eQ(paramContext));
    localObject2 = com.tencent.mm.ui.component.a.KEX;
    ((RecyclerView)localObject1).setRecycledViewPool(((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderRecyclerViewPool.class)).tkU);
    ((RecyclerView)localObject1).a((RecyclerView.m)new c(this, paramContext));
    ((RecyclerView)localObject1).b(this.rUq.eO(paramContext));
    paramContext = paramRefreshLoadMoreLayout.getParent();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(168487);
      throw paramContext;
    }
    paramContext = (View)paramContext;
    paramRefreshLoadMoreLayout = this.tjc;
    if (paramRefreshLoadMoreLayout == null) {
      p.bdF("commentDrawer");
    }
    paramRefreshLoadMoreLayout.getFooterLayout().addOnLayoutChangeListener((View.OnLayoutChangeListener)new d(this, paramContext));
    AppMethodBeat.o(168487);
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt)
  {
    AppMethodBeat.i(205985);
    p.h(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    p.g(localObject, "drawer.context");
    this.context = ((Context)localObject);
    paramRecyclerViewDrawer.setId(2131299978);
    this.tjc = ((FinderCommentDrawer)paramRecyclerViewDrawer);
    paramRecyclerViewDrawer.setSquaresBackgroundResource(2131234858);
    paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
    paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    paramRecyclerViewDrawer = this.tjc;
    if (paramRecyclerViewDrawer == null) {
      p.bdF("commentDrawer");
    }
    paramRecyclerViewDrawer.setScene(paramInt);
    paramRecyclerViewDrawer = this.tjc;
    if (paramRecyclerViewDrawer == null) {
      p.bdF("commentDrawer");
    }
    localObject = this.tjc;
    if (localObject == null) {
      p.bdF("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).getScene() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecyclerViewDrawer.setSelfProfile(bool);
      AppMethodBeat.o(205985);
      return;
    }
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(168489);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "loadingLayout");
    this.tiU = paramFrameLayout;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494015, (ViewGroup)paramFrameLayout, true);
    paramFrameLayout = paramContext.findViewById(2131298527);
    p.g(paramFrameLayout, "loadingContentLayout.fin…R.id.comment_loading_bar)");
    this.gZB = paramFrameLayout;
    paramFrameLayout = paramContext.findViewById(2131302874);
    p.g(paramFrameLayout, "loadingContentLayout.fin…yId(R.id.no_comment_hint)");
    this.tiV = paramFrameLayout;
    paramContext = paramContext.findViewById(2131304147);
    p.g(paramContext, "loadingContentLayout.fin….id.retry_comment_layout)");
    this.tiW = paramContext;
    paramContext = this.gZB;
    if (paramContext == null) {
      p.bdF("loadingView");
    }
    paramContext.setVisibility(0);
    paramContext = this.tiV;
    if (paramContext == null) {
      p.bdF("nothingView");
    }
    paramContext.setVisibility(8);
    paramContext = this.tiW;
    if (paramContext == null) {
      p.bdF("retryView");
    }
    paramContext.setVisibility(8);
    AppMethodBeat.o(168489);
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout, final boolean paramBoolean)
  {
    AppMethodBeat.i(205987);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "footerLayout");
    paramContext = com.tencent.mm.ui.z.jV(paramContext).inflate(2131493574, (ViewGroup)paramFrameLayout).findViewById(2131299983);
    p.g(paramContext, "view.findViewById(R.id.finder_comment_footer)");
    this.tjb = ((FinderCommentFooter)paramContext);
    paramContext = this.tjb;
    if (paramContext == null) {
      p.bdF("drawerFooter");
    }
    paramContext.setBackClickListener((d.g.a.a)new e(this, paramBoolean));
    paramContext = this.tjb;
    if (paramContext == null) {
      p.bdF("drawerFooter");
    }
    paramContext.setSwitchSceneListener((d.g.a.a)new f(this));
    paramContext = this.tjb;
    if (paramContext == null) {
      p.bdF("drawerFooter");
    }
    paramFrameLayout = this.tjc;
    if (paramFrameLayout == null) {
      p.bdF("commentDrawer");
    }
    paramContext.setSelfProfile(paramFrameLayout.tdQ);
    paramContext = this.tjb;
    if (paramContext == null) {
      p.bdF("drawerFooter");
    }
    paramFrameLayout = this.tjc;
    if (paramFrameLayout == null) {
      p.bdF("commentDrawer");
    }
    paramContext.setScene(paramFrameLayout.getSceneForReply());
    paramContext = this.tjb;
    if (paramContext == null) {
      p.bdF("drawerFooter");
    }
    paramFrameLayout = this.tjc;
    if (paramFrameLayout == null) {
      p.bdF("commentDrawer");
    }
    paramContext.setBanSwitchScene(paramFrameLayout.getBanSwitch());
    paramContext = new StringBuilder("drawerFooter.scene ");
    paramFrameLayout = this.tjb;
    if (paramFrameLayout == null) {
      p.bdF("drawerFooter");
    }
    ae.i("Finder.TimelineDrawerBuilder", paramFrameLayout.getScene());
    paramContext = this.tjb;
    if (paramContext == null) {
      p.bdF("drawerFooter");
    }
    paramContext.cPN();
    paramContext = this.tjb;
    if (paramContext == null) {
      p.bdF("drawerFooter");
    }
    paramContext.cPO();
    paramContext = this.tjc;
    if (paramContext == null) {
      p.bdF("commentDrawer");
    }
    paramFrameLayout = this.tjb;
    if (paramFrameLayout == null) {
      p.bdF("drawerFooter");
    }
    paramContext.setKeyboardHeightObserver((g)paramFrameLayout);
    paramContext = this.tjc;
    if (paramContext == null) {
      p.bdF("commentDrawer");
    }
    paramFrameLayout = this.tjb;
    if (paramFrameLayout == null) {
      p.bdF("drawerFooter");
    }
    paramContext.setFooter(paramFrameLayout);
    AppMethodBeat.o(205987);
  }
  
  public final void be(float paramFloat)
  {
    AppMethodBeat.i(168491);
    Object localObject = this.tjc;
    if (localObject == null) {
      p.bdF("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).sdo)
    {
      localObject = this.tjb;
      if (localObject == null) {
        p.bdF("drawerFooter");
      }
      if (((FinderCommentFooter)localObject).getFooterMode() == 2)
      {
        localObject = this.context;
        if (localObject == null) {
          p.bdF("context");
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
  
  public final RefreshLoadMoreLayout cEX()
  {
    AppMethodBeat.i(168478);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.scj;
    if (localRefreshLoadMoreLayout == null) {
      p.bdF("rlLayout");
    }
    AppMethodBeat.o(168478);
    return localRefreshLoadMoreLayout;
  }
  
  public final TextView cQs()
  {
    AppMethodBeat.i(168477);
    TextView localTextView = this.tiS;
    if (localTextView == null) {
      p.bdF("headerTitleTv");
    }
    AppMethodBeat.o(168477);
    return localTextView;
  }
  
  public final void cQu()
  {
    AppMethodBeat.i(205988);
    this.rUq.onDetach();
    AppMethodBeat.o(205988);
  }
  
  public final FinderCommentFooter cQv()
  {
    AppMethodBeat.i(168479);
    FinderCommentFooter localFinderCommentFooter = this.tjb;
    if (localFinderCommentFooter == null) {
      p.bdF("drawerFooter");
    }
    AppMethodBeat.o(168479);
    return localFinderCommentFooter;
  }
  
  public final FinderCommentDrawer cQw()
  {
    AppMethodBeat.i(168480);
    FinderCommentDrawer localFinderCommentDrawer = this.tjc;
    if (localFinderCommentDrawer == null) {
      p.bdF("commentDrawer");
    }
    AppMethodBeat.o(168480);
    return localFinderCommentDrawer;
  }
  
  public final View cQx()
  {
    AppMethodBeat.i(168483);
    View localView = this.tjd;
    if (localView == null) {
      p.bdF("headerErrTip");
    }
    AppMethodBeat.o(168483);
    return localView;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(168482);
    Context localContext = this.context;
    if (localContext == null) {
      p.bdF("context");
    }
    AppMethodBeat.o(168482);
    return localContext;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(168481);
    FrameLayout localFrameLayout = this.tiT;
    if (localFrameLayout == null) {
      p.bdF("headerLayout");
    }
    AppMethodBeat.o(168481);
    return localFrameLayout;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(168493);
    Object localObject = this.tiU;
    if (localObject == null) {
      p.bdF("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.tiW;
    if (localObject == null) {
      p.bdF("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(168493);
  }
  
  public final void my(boolean paramBoolean)
  {
    AppMethodBeat.i(168486);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout;
    if (paramBoolean)
    {
      localRefreshLoadMoreLayout = this.scj;
      if (localRefreshLoadMoreLayout == null) {
        p.bdF("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(true);
      localRefreshLoadMoreLayout = this.scj;
      if (localRefreshLoadMoreLayout == null) {
        p.bdF("rlLayout");
      }
      if (localRefreshLoadMoreLayout.getRefreshHeader() == null)
      {
        localRefreshLoadMoreLayout = this.scj;
        if (localRefreshLoadMoreLayout == null) {
          p.bdF("rlLayout");
        }
        Object localObject = this.context;
        if (localObject == null) {
          p.bdF("context");
        }
        localObject = com.tencent.mm.ui.z.jV((Context)localObject).inflate(2131495234, null);
        p.g(localObject, "MMLayoutInflater.getInfl…out.refresh_header, null)");
        localRefreshLoadMoreLayout.setRefreshHeaderView((View)localObject);
        AppMethodBeat.o(168486);
      }
    }
    else
    {
      localRefreshLoadMoreLayout = this.scj;
      if (localRefreshLoadMoreLayout == null) {
        p.bdF("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(false);
    }
    AppMethodBeat.o(168486);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(168492);
    Object localObject = this.tiU;
    if (localObject == null) {
      p.bdF("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.gZB;
    if (localObject == null) {
      p.bdF("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.tiV;
    if (localObject == null) {
      p.bdF("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.tiW;
    if (localObject == null) {
      p.bdF("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168492);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<d.z>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "lastState", "", "getLastState", "()I", "setLastState", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {
    private int rZr;
    
    c(Context paramContext) {}
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205983);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(205983);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(178494);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.rZr = paramInt;
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
        this.tji.rUq.EL(paramRecyclerView.ko());
        continue;
        if (this.rZr != 3)
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$3", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class d
    implements View.OnLayoutChangeListener
  {
    d(View paramView) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(178495);
      this.tji.cQw().getFooterLayout().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      paramContext.setPadding(paramContext.getPaddingLeft(), paramContext.getPaddingTop(), paramContext.getPaddingRight(), this.tji.cQv().getCommentEditTextLayout().getHeight());
      paramContext.requestLayout();
      ae.i("Finder.TimelineDrawerBuilder", "bottomMargin=" + this.tji.cQv().getCommentEditTextLayout().getHeight() + " paddingBottom=" + paramContext.getPaddingBottom());
      AppMethodBeat.o(178495);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<d.z>
  {
    e(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<d.z>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168475);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = this.tji.tjf;
      p.g(paramView, "it");
      ((d.g.a.b)localObject).invoke(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168475);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class h
    extends q
    implements d.g.a.b<View, d.z>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class i
    implements View.OnClickListener
  {
    public i(d.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168476);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.sXV.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168476);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.b
 * JD-Core Version:    0.7.0.1
 */