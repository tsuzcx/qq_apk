package com.tencent.mm.plugin.finder.view.builder;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.l;
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
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "closeCommentView", "Landroid/view/View;", "getCloseCommentView", "()Landroid/view/View;", "setCloseCommentView", "(Landroid/view/View;)V", "commentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getCommentDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setCommentDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "drawerFooter", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getDrawerFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setDrawerFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "headerErrTip", "getHeaderErrTip", "setHeaderErrTip", "headerErrTv", "Landroid/widget/TextView;", "getHeaderErrTv", "()Landroid/widget/TextView;", "setHeaderErrTv", "(Landroid/widget/TextView;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "getHeaderTitleTv", "setHeaderTitleTv", "isEnableFullScreenEnjoy", "", "()Z", "setEnableFullScreenEnjoy", "(Z)V", "lastHideVKBTime", "", "getLastHideVKBTime", "()I", "setLastHideVKBTime", "(I)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "getLoadingView", "setLoadingView", "nothingView", "getNothingView", "setNothingView", "onBackPressed", "Lkotlin/Function0;", "", "getOnBackPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackPressed", "(Lkotlin/jvm/functions/Function0;)V", "onCloseBtnClick", "Lkotlin/Function1;", "getOnCloseBtnClick", "()Lkotlin/jvm/functions/Function1;", "setOnCloseBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerFooter", "footerLayout", "fullScreen", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "scene", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showCommentClose", "showLoading", "showNothingTips", "showRetryView", "onClick", "Companion", "plugin-finder_release"})
public class b
  implements FinderCommentDrawer.a, RecyclerViewDrawerSquares.c
{
  public static final a wsh;
  public Context context;
  public View hSw;
  public RefreshLoadMoreLayout tLS;
  public final CommentDrawerContract.NPresenter tzm;
  private boolean wfg;
  public TextView wrR;
  public FrameLayout wrS;
  public FrameLayout wrT;
  public View wrU;
  public View wrV;
  public FinderCommentFooter wsa;
  public FinderCommentDrawer wsb;
  public View wsc;
  public View wsd;
  public TextView wse;
  kotlin.g.a.b<? super View, x> wsf;
  kotlin.g.a.a<x> wsg;
  
  static
  {
    AppMethodBeat.i(168495);
    wsh = new a((byte)0);
    AppMethodBeat.o(168495);
  }
  
  public b(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(168494);
    this.tzm = paramNPresenter;
    this.wsf = ((kotlin.g.a.b)new h(this));
    this.wsg = ((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(168494);
  }
  
  public final void S(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168490);
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject1 = this.wsb;
      if (localObject1 == null) {
        p.btv("commentDrawer");
      }
      if (((FinderCommentDrawer)localObject1).getShowFooter())
      {
        localObject1 = this.wsa;
        if (localObject1 == null) {
          p.btv("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(0);
        localObject1 = this.wrS;
        if (localObject1 == null) {
          p.btv("headerLayout");
        }
        localObject1 = ((FrameLayout)localObject1).findViewById(2131300789);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      for (;;)
      {
        localObject1 = this.tzm;
        FinderCommentDrawer localFinderCommentDrawer1 = this.wsb;
        if (localFinderCommentDrawer1 == null) {
          p.btv("commentDrawer");
        }
        Object localObject2 = this.wsb;
        if (localObject2 == null) {
          p.btv("commentDrawer");
        }
        localObject2 = ((FinderCommentDrawer)localObject2).getFeedObj();
        if (localObject2 == null) {
          p.hyc();
        }
        Object localObject3 = this.wsb;
        if (localObject3 == null) {
          p.btv("commentDrawer");
        }
        localObject3 = ((FinderCommentDrawer)localObject3).getOnCloseDrawerCallback();
        Object localObject4 = this.wsb;
        if (localObject4 == null) {
          p.btv("commentDrawer");
        }
        int i = ((FinderCommentDrawer)localObject4).getScene();
        localObject4 = this.wsb;
        if (localObject4 == null) {
          p.btv("commentDrawer");
        }
        paramBoolean1 = ((FinderCommentDrawer)localObject4).tMV;
        localObject4 = this.wsb;
        if (localObject4 == null) {
          p.btv("commentDrawer");
        }
        long l = ((FinderCommentDrawer)localObject4).getRefCommentId();
        localObject4 = this.wsb;
        if (localObject4 == null) {
          p.btv("commentDrawer");
        }
        localObject4 = ((FinderCommentDrawer)localObject4).getReplyCommentObj();
        FinderCommentDrawer localFinderCommentDrawer2 = this.wsb;
        if (localFinderCommentDrawer2 == null) {
          p.btv("commentDrawer");
        }
        paramBoolean2 = localFinderCommentDrawer2.getUseCache();
        localFinderCommentDrawer2 = this.wsb;
        if (localFinderCommentDrawer2 == null) {
          p.btv("commentDrawer");
        }
        boolean bool1 = localFinderCommentDrawer2.getBlinkRefComment();
        localFinderCommentDrawer2 = this.wsb;
        if (localFinderCommentDrawer2 == null) {
          p.btv("commentDrawer");
        }
        boolean bool2 = localFinderCommentDrawer2.getCloseComment();
        localFinderCommentDrawer2 = this.wsb;
        if (localFinderCommentDrawer2 == null) {
          p.btv("commentDrawer");
        }
        ((CommentDrawerContract.NPresenter)localObject1).a(localFinderCommentDrawer1, this, (FinderItem)localObject2, (CommentDrawerContract.CloseDrawerCallback)localObject3, i, paramBoolean1, l, (an)localObject4, paramBoolean2, bool1, bool2, localFinderCommentDrawer2.getOldVersion());
        AppMethodBeat.o(168490);
        return;
        localObject1 = this.wsa;
        if (localObject1 == null) {
          p.btv("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(8);
        localObject1 = this.wsb;
        if (localObject1 == null) {
          p.btv("commentDrawer");
        }
        if (((FinderCommentDrawer)localObject1).getCloseComment())
        {
          if (!this.wfg)
          {
            localObject1 = this.wrS;
            if (localObject1 == null) {
              p.btv("headerLayout");
            }
            localObject1 = ((FrameLayout)localObject1).findViewById(2131300789);
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(0);
            }
          }
          for (;;)
          {
            localObject1 = this.wrU;
            if (localObject1 == null) {
              p.btv("nothingView");
            }
            ((View)localObject1).setVisibility(8);
            localObject1 = this.wrV;
            if (localObject1 == null) {
              p.btv("retryView");
            }
            ((View)localObject1).setVisibility(8);
            localObject1 = this.wrT;
            if (localObject1 == null) {
              p.btv("loadingLayout");
            }
            ((FrameLayout)localObject1).setVisibility(0);
            localObject1 = this.wsc;
            if (localObject1 == null) {
              p.btv("closeCommentView");
            }
            ((View)localObject1).setVisibility(0);
            break;
            localObject1 = this.wrS;
            if (localObject1 == null) {
              p.btv("headerLayout");
            }
            localObject1 = ((FrameLayout)localObject1).findViewById(2131300789);
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(8);
            }
          }
        }
        localObject1 = this.wsc;
        if (localObject1 == null) {
          p.btv("closeCommentView");
        }
        ((View)localObject1).setVisibility(8);
        localObject1 = this.wrS;
        if (localObject1 == null) {
          p.btv("headerLayout");
        }
        localObject1 = ((FrameLayout)localObject1).findViewById(2131300789);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      this.tzm.onDetach();
    }
    AppMethodBeat.o(168490);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(255208);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "headerLayout");
    this.wrS = paramFrameLayout;
    this.wfg = y.a(y.vXH, 0, this.tzm.getCommentScene(), 1);
    if (paramBoolean) {}
    for (paramContext = aa.jQ(paramContext).inflate(2131493692, (ViewGroup)paramFrameLayout);; paramContext = aa.jQ(paramContext).inflate(2131493691, (ViewGroup)paramFrameLayout))
    {
      paramFrameLayout = paramContext.findViewById(2131299803);
      p.g(paramFrameLayout, "header.findViewById(R.id.drawer_header_tv)");
      this.wrR = ((TextView)paramFrameLayout);
      paramFrameLayout = paramContext.findViewById(2131300794);
      p.g(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_tip)");
      this.wsd = paramFrameLayout;
      paramFrameLayout = paramContext.findViewById(2131300792);
      p.g(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_msg)");
      this.wse = ((TextView)paramFrameLayout);
      paramFrameLayout = this.wrR;
      if (paramFrameLayout == null) {
        p.btv("headerTitleTv");
      }
      ao.a((Paint)paramFrameLayout.getPaint(), 0.8F);
      paramContext = paramContext.findViewById(2131298777);
      paramContext.setOnClickListener((View.OnClickListener)new g(this));
      paramFrameLayout = this.wsb;
      if (paramFrameLayout == null) {
        p.btv("commentDrawer");
      }
      p.g(paramContext, "closeBtn");
      paramFrameLayout.hH(paramContext);
      AppMethodBeat.o(255208);
      return;
    }
  }
  
  public final void a(final Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(168487);
    p.h(paramContext, "context");
    p.h(paramRefreshLoadMoreLayout, "rlLayout");
    this.tLS = paramRefreshLoadMoreLayout;
    Object localObject1 = aa.jQ(paramContext).inflate(2131495297, null);
    p.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramRefreshLoadMoreLayout.setLoadMoreFooter((View)localObject1);
    localObject1 = paramRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    Object localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).lB();
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.tzm.fm(paramContext));
    localObject2 = com.tencent.mm.ui.component.a.PRN;
    ((RecyclerView)localObject1).setRecycledViewPool(((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderRecyclerViewPool.class)).wuy);
    ((RecyclerView)localObject1).a((RecyclerView.l)new c(this, paramContext));
    ((RecyclerView)localObject1).b(this.tzm.fi(paramContext));
    paramContext = paramRefreshLoadMoreLayout.getParent();
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(168487);
      throw paramContext;
    }
    paramContext = (View)paramContext;
    paramRefreshLoadMoreLayout = this.wsb;
    if (paramRefreshLoadMoreLayout == null) {
      p.btv("commentDrawer");
    }
    paramRefreshLoadMoreLayout.getFooterLayout().addOnLayoutChangeListener((View.OnLayoutChangeListener)new d(this, paramContext));
    AppMethodBeat.o(168487);
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt)
  {
    AppMethodBeat.i(255207);
    p.h(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    p.g(localObject, "drawer.context");
    this.context = ((Context)localObject);
    paramRecyclerViewDrawer.setId(2131300790);
    this.wsb = ((FinderCommentDrawer)paramRecyclerViewDrawer);
    paramRecyclerViewDrawer.setSquaresBackgroundResource(2131232477);
    paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
    paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    paramRecyclerViewDrawer = this.wsb;
    if (paramRecyclerViewDrawer == null) {
      p.btv("commentDrawer");
    }
    paramRecyclerViewDrawer.setScene(paramInt);
    paramRecyclerViewDrawer = this.wsb;
    if (paramRecyclerViewDrawer == null) {
      p.btv("commentDrawer");
    }
    localObject = this.wsb;
    if (localObject == null) {
      p.btv("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).getScene() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecyclerViewDrawer.setSelfProfile(bool);
      AppMethodBeat.o(255207);
      return;
    }
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(168489);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "loadingLayout");
    this.wrT = paramFrameLayout;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494219, (ViewGroup)paramFrameLayout, true);
    paramFrameLayout = paramContext.findViewById(2131298955);
    p.g(paramFrameLayout, "loadingContentLayout.fin…R.id.comment_loading_bar)");
    this.hSw = paramFrameLayout;
    paramFrameLayout = paramContext.findViewById(2131305447);
    p.g(paramFrameLayout, "loadingContentLayout.fin…yId(R.id.no_comment_hint)");
    this.wrU = paramFrameLayout;
    paramFrameLayout = paramContext.findViewById(2131307043);
    p.g(paramFrameLayout, "loadingContentLayout.fin….id.retry_comment_layout)");
    this.wrV = paramFrameLayout;
    paramContext = paramContext.findViewById(2131300789);
    p.g(paramContext, "loadingContentLayout.fin…nder_comment_closed_tips)");
    this.wsc = paramContext;
    paramContext = this.hSw;
    if (paramContext == null) {
      p.btv("loadingView");
    }
    paramContext.setVisibility(0);
    paramContext = this.wrU;
    if (paramContext == null) {
      p.btv("nothingView");
    }
    paramContext.setVisibility(8);
    paramContext = this.wrV;
    if (paramContext == null) {
      p.btv("retryView");
    }
    paramContext.setVisibility(8);
    paramContext = this.wsc;
    if (paramContext == null) {
      p.btv("closeCommentView");
    }
    paramContext.setVisibility(8);
    AppMethodBeat.o(168489);
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout, final boolean paramBoolean)
  {
    AppMethodBeat.i(255209);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "footerLayout");
    paramContext = aa.jQ(paramContext).inflate(2131493690, (ViewGroup)paramFrameLayout).findViewById(2131300795);
    p.g(paramContext, "view.findViewById(R.id.finder_comment_footer)");
    this.wsa = ((FinderCommentFooter)paramContext);
    paramContext = this.wsa;
    if (paramContext == null) {
      p.btv("drawerFooter");
    }
    paramContext.setBackClickListener((kotlin.g.a.a)new e(this, paramBoolean));
    paramContext = this.wsa;
    if (paramContext == null) {
      p.btv("drawerFooter");
    }
    paramContext.setSwitchSceneListener((kotlin.g.a.a)new f(this));
    paramContext = this.wsa;
    if (paramContext == null) {
      p.btv("drawerFooter");
    }
    paramFrameLayout = this.wsb;
    if (paramFrameLayout == null) {
      p.btv("commentDrawer");
    }
    paramContext.setSelfProfile(paramFrameLayout.uLZ);
    paramContext = this.wsa;
    if (paramContext == null) {
      p.btv("drawerFooter");
    }
    paramFrameLayout = this.wsb;
    if (paramFrameLayout == null) {
      p.btv("commentDrawer");
    }
    paramContext.setScene(paramFrameLayout.getSceneForReply());
    paramContext = this.wsa;
    if (paramContext == null) {
      p.btv("drawerFooter");
    }
    paramFrameLayout = this.wsb;
    if (paramFrameLayout == null) {
      p.btv("commentDrawer");
    }
    paramContext.setBanSwitchScene(paramFrameLayout.getBanSwitch());
    paramContext = new StringBuilder("drawerFooter.scene ");
    paramFrameLayout = this.wsa;
    if (paramFrameLayout == null) {
      p.btv("drawerFooter");
    }
    Log.i("Finder.TimelineDrawerBuilder", paramFrameLayout.getScene());
    paramContext = this.wsa;
    if (paramContext == null) {
      p.btv("drawerFooter");
    }
    paramContext.dGx();
    paramContext = this.wsa;
    if (paramContext == null) {
      p.btv("drawerFooter");
    }
    paramContext.dGy();
    paramContext = this.wsb;
    if (paramContext == null) {
      p.btv("commentDrawer");
    }
    paramFrameLayout = this.wsa;
    if (paramFrameLayout == null) {
      p.btv("drawerFooter");
    }
    paramContext.setKeyboardHeightObserver((g)paramFrameLayout);
    paramContext = this.wsb;
    if (paramContext == null) {
      p.btv("commentDrawer");
    }
    paramFrameLayout = this.wsa;
    if (paramFrameLayout == null) {
      p.btv("drawerFooter");
    }
    paramContext.setFooter(paramFrameLayout);
    AppMethodBeat.o(255209);
  }
  
  public final void bo(float paramFloat)
  {
    AppMethodBeat.i(168491);
    Object localObject = this.wsb;
    if (localObject == null) {
      p.btv("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).tMV)
    {
      localObject = this.wsa;
      if (localObject == null) {
        p.btv("drawerFooter");
      }
      if (((FinderCommentFooter)localObject).getFooterMode() == 2)
      {
        localObject = this.context;
        if (localObject == null) {
          p.btv("context");
        }
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
          AppMethodBeat.o(168491);
          throw ((Throwable)localObject);
        }
        ((MMFragmentActivity)localObject).hideVKB();
      }
    }
    AppMethodBeat.o(168491);
  }
  
  public final TextView dHs()
  {
    AppMethodBeat.i(168477);
    TextView localTextView = this.wrR;
    if (localTextView == null) {
      p.btv("headerTitleTv");
    }
    AppMethodBeat.o(168477);
    return localTextView;
  }
  
  public final void dHu()
  {
    AppMethodBeat.i(255210);
    this.tzm.onDetach();
    AppMethodBeat.o(255210);
  }
  
  public final FinderCommentFooter dHv()
  {
    AppMethodBeat.i(168479);
    FinderCommentFooter localFinderCommentFooter = this.wsa;
    if (localFinderCommentFooter == null) {
      p.btv("drawerFooter");
    }
    AppMethodBeat.o(168479);
    return localFinderCommentFooter;
  }
  
  public final FinderCommentDrawer dHw()
  {
    AppMethodBeat.i(168480);
    FinderCommentDrawer localFinderCommentDrawer = this.wsb;
    if (localFinderCommentDrawer == null) {
      p.btv("commentDrawer");
    }
    AppMethodBeat.o(168480);
    return localFinderCommentDrawer;
  }
  
  public final View dHx()
  {
    AppMethodBeat.i(168483);
    View localView = this.wsd;
    if (localView == null) {
      p.btv("headerErrTip");
    }
    AppMethodBeat.o(168483);
    return localView;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(168482);
    Context localContext = this.context;
    if (localContext == null) {
      p.btv("context");
    }
    AppMethodBeat.o(168482);
    return localContext;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(168481);
    FrameLayout localFrameLayout = this.wrS;
    if (localFrameLayout == null) {
      p.btv("headerLayout");
    }
    AppMethodBeat.o(168481);
    return localFrameLayout;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(255206);
    FrameLayout localFrameLayout = this.wrT;
    if (localFrameLayout == null) {
      p.btv("loadingLayout");
    }
    AppMethodBeat.o(255206);
    return localFrameLayout;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(168478);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tLS;
    if (localRefreshLoadMoreLayout == null) {
      p.btv("rlLayout");
    }
    AppMethodBeat.o(168478);
    return localRefreshLoadMoreLayout;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(168493);
    Object localObject = this.wrT;
    if (localObject == null) {
      p.btv("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.wrV;
    if (localObject == null) {
      p.btv("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(168493);
  }
  
  public final void pb(boolean paramBoolean)
  {
    AppMethodBeat.i(168486);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout;
    if (paramBoolean)
    {
      localRefreshLoadMoreLayout = this.tLS;
      if (localRefreshLoadMoreLayout == null) {
        p.btv("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(true);
      localRefreshLoadMoreLayout = this.tLS;
      if (localRefreshLoadMoreLayout == null) {
        p.btv("rlLayout");
      }
      if (localRefreshLoadMoreLayout.getRefreshHeader() == null)
      {
        localRefreshLoadMoreLayout = this.tLS;
        if (localRefreshLoadMoreLayout == null) {
          p.btv("rlLayout");
        }
        Object localObject = this.context;
        if (localObject == null) {
          p.btv("context");
        }
        localObject = aa.jQ((Context)localObject).inflate(2131496080, null);
        p.g(localObject, "MMLayoutInflater.getInfl…out.refresh_header, null)");
        localRefreshLoadMoreLayout.setRefreshHeaderView((View)localObject);
        AppMethodBeat.o(168486);
      }
    }
    else
    {
      localRefreshLoadMoreLayout = this.tLS;
      if (localRefreshLoadMoreLayout == null) {
        p.btv("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(false);
    }
    AppMethodBeat.o(168486);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(168492);
    Object localObject = this.wrT;
    if (localObject == null) {
      p.btv("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.hSw;
    if (localObject == null) {
      p.btv("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.wrU;
    if (localObject == null) {
      p.btv("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.wrV;
    if (localObject == null) {
      p.btv("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168492);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "lastState", "", "getLastState", "()I", "setLastState", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    private int tIj;
    
    c(Context paramContext) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(178494);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.tIj = paramInt;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(178494);
        return;
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(178494);
          throw paramRecyclerView;
        }
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        this.wsi.tzm.IG(paramRecyclerView.ku());
        continue;
        if (this.tIj != 3)
        {
          paramRecyclerView = paramContext;
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(178494);
            throw paramRecyclerView;
          }
          ((MMFragmentActivity)paramRecyclerView).hideVKB();
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(255204);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(255204);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$3", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class d
    implements View.OnLayoutChangeListener
  {
    d(View paramView) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(178495);
      this.wsi.dHw().getFooterLayout().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      paramContext.setPadding(paramContext.getPaddingLeft(), paramContext.getPaddingTop(), paramContext.getPaddingRight(), this.wsi.dHv().getCommentEditTextLayout().getHeight());
      paramContext.requestLayout();
      Log.i("Finder.TimelineDrawerBuilder", "bottomMargin=" + this.wsi.dHv().getCommentEditTextLayout().getHeight() + " paddingBottom=" + paramContext.getPaddingBottom());
      AppMethodBeat.o(178495);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168475);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.wsi.wsf;
      p.g(paramView, "it");
      ((kotlin.g.a.b)localObject).invoke(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168475);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<View, x>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class i
    implements View.OnClickListener
  {
    public i(kotlin.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168476);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tPo.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168476);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.b
 * JD-Core Version:    0.7.0.1
 */