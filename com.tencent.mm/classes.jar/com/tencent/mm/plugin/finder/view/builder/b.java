package com.tencent.mm.plugin.finder.view.builder;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.viewmodel.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "commentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getCommentDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setCommentDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "drawerFooter", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getDrawerFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setDrawerFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "headerErrTip", "Landroid/view/View;", "getHeaderErrTip", "()Landroid/view/View;", "setHeaderErrTip", "(Landroid/view/View;)V", "headerErrTv", "Landroid/widget/TextView;", "getHeaderErrTv", "()Landroid/widget/TextView;", "setHeaderErrTv", "(Landroid/widget/TextView;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "getHeaderTitleTv", "setHeaderTitleTv", "isEnableFullScreenEnjoy", "", "()Z", "setEnableFullScreenEnjoy", "(Z)V", "lastHideVKBTime", "", "getLastHideVKBTime", "()I", "setLastHideVKBTime", "(I)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "getLoadingView", "setLoadingView", "nothingView", "getNothingView", "setNothingView", "onBackPressed", "Lkotlin/Function0;", "", "getOnBackPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackPressed", "(Lkotlin/jvm/functions/Function0;)V", "onCloseBtnClick", "Lkotlin/Function1;", "getOnCloseBtnClick", "()Lkotlin/jvm/functions/Function1;", "setOnCloseBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerFooter", "footerLayout", "fullScreen", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "scene", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showCommentClose", "showLoading", "showNothingTips", "showRetryView", "onClick", "Companion", "plugin-finder_release"})
public class b
  implements FinderCommentDrawer.a, RecyclerViewDrawerSquares.c
{
  public static final a Beu;
  private boolean ANP;
  public View Aol;
  public TextView Beg;
  public FrameLayout Beh;
  public FrameLayout Bei;
  public View Bej;
  public FinderCommentFooter Beo;
  public FinderCommentDrawer Bep;
  public View Beq;
  public TextView Ber;
  kotlin.g.a.b<? super View, x> Bes;
  kotlin.g.a.a<x> Bet;
  public Context context;
  public View kGT;
  public final CommentDrawerContract.NPresenter xgX;
  public RefreshLoadMoreLayout xvJ;
  
  static
  {
    AppMethodBeat.i(168495);
    Beu = new a((byte)0);
    AppMethodBeat.o(168495);
  }
  
  public b(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(168494);
    this.xgX = paramNPresenter;
    this.Bes = ((kotlin.g.a.b)new h(this));
    this.Bet = ((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(168494);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(278691);
    p.k(paramContext, "context");
    p.k(paramFrameLayout, "headerLayout");
    this.Beh = paramFrameLayout;
    this.ANP = aj.a(aj.AGc, 0, this.xgX.getCommentScene(), 1);
    if (paramBoolean) {}
    for (paramContext = ad.kS(paramContext).inflate(com.tencent.mm.plugin.finder.b.g.comment_drawer_header_fullscreen, (ViewGroup)paramFrameLayout);; paramContext = ad.kS(paramContext).inflate(com.tencent.mm.plugin.finder.b.g.comment_drawer_header, (ViewGroup)paramFrameLayout))
    {
      paramFrameLayout = paramContext.findViewById(com.tencent.mm.plugin.finder.b.f.drawer_header_tv);
      p.j(paramFrameLayout, "header.findViewById(R.id.drawer_header_tv)");
      this.Beg = ((TextView)paramFrameLayout);
      paramFrameLayout = paramContext.findViewById(com.tencent.mm.plugin.finder.b.f.finder_comment_error_tip);
      p.j(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_tip)");
      this.Beq = paramFrameLayout;
      paramFrameLayout = paramContext.findViewById(com.tencent.mm.plugin.finder.b.f.finder_comment_error_msg);
      p.j(paramFrameLayout, "header.findViewById(R.id.finder_comment_error_msg)");
      this.Ber = ((TextView)paramFrameLayout);
      paramFrameLayout = this.Beg;
      if (paramFrameLayout == null) {
        p.bGy("headerTitleTv");
      }
      ar.a((Paint)paramFrameLayout.getPaint(), 0.8F);
      paramContext = paramContext.findViewById(com.tencent.mm.plugin.finder.b.f.close_drawer_layout);
      if (paramContext != null) {
        paramContext.setOnClickListener((View.OnClickListener)new g(this));
      }
      if (paramContext != null)
      {
        paramFrameLayout = this.Bep;
        if (paramFrameLayout == null) {
          p.bGy("commentDrawer");
        }
        paramFrameLayout.jc(paramContext);
      }
      AppMethodBeat.o(278691);
      return;
    }
  }
  
  public final void a(final Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(168487);
    p.k(paramContext, "context");
    p.k(paramRefreshLoadMoreLayout, "rlLayout");
    this.xvJ = paramRefreshLoadMoreLayout;
    Object localObject1 = ad.kS(paramContext).inflate(com.tencent.mm.plugin.finder.b.g.load_more_footer, null);
    p.j(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramRefreshLoadMoreLayout.setLoadMoreFooter((View)localObject1);
    localObject1 = paramRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    Object localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).n(0L);
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.xgX.fs(paramContext));
    localObject2 = g.Xox;
    ((RecyclerView)localObject1).setRecycledViewPool(((c)g.b((AppCompatActivity)paramContext).i(c.class)).BgX);
    ((RecyclerView)localObject1).a((RecyclerView.l)new c(this, paramContext));
    ((RecyclerView)localObject1).b(this.xgX.fn(paramContext));
    paramContext = paramRefreshLoadMoreLayout.getParent();
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(168487);
      throw paramContext;
    }
    paramContext = (View)paramContext;
    paramRefreshLoadMoreLayout = this.Bep;
    if (paramRefreshLoadMoreLayout == null) {
      p.bGy("commentDrawer");
    }
    paramRefreshLoadMoreLayout.getFooterLayout().addOnLayoutChangeListener((View.OnLayoutChangeListener)new d(this, paramContext));
    AppMethodBeat.o(168487);
  }
  
  public final void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt)
  {
    AppMethodBeat.i(278690);
    p.k(paramRecyclerViewDrawer, "drawer");
    Object localObject = paramRecyclerViewDrawer.getContext();
    p.j(localObject, "drawer.context");
    this.context = ((Context)localObject);
    paramRecyclerViewDrawer.setId(com.tencent.mm.plugin.finder.b.f.finder_comment_drawer);
    this.Bep = ((FinderCommentDrawer)paramRecyclerViewDrawer);
    paramRecyclerViewDrawer.setSquaresBackgroundResource(com.tencent.mm.plugin.finder.b.e.finder_bottom_corner_shape);
    paramRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
    paramRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    paramRecyclerViewDrawer = this.Bep;
    if (paramRecyclerViewDrawer == null) {
      p.bGy("commentDrawer");
    }
    paramRecyclerViewDrawer.setScene(paramInt);
    paramRecyclerViewDrawer = this.Bep;
    if (paramRecyclerViewDrawer == null) {
      p.bGy("commentDrawer");
    }
    localObject = this.Bep;
    if (localObject == null) {
      p.bGy("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).getScene() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecyclerViewDrawer.setSelfProfile(bool);
      AppMethodBeat.o(278690);
      return;
    }
  }
  
  public final void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168490);
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject1 = this.Bep;
      if (localObject1 == null) {
        p.bGy("commentDrawer");
      }
      if (((FinderCommentDrawer)localObject1).getShowFooter())
      {
        localObject1 = this.Beo;
        if (localObject1 == null) {
          p.bGy("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(0);
        localObject1 = this.Beh;
        if (localObject1 == null) {
          p.bGy("headerLayout");
        }
        localObject1 = ((FrameLayout)localObject1).findViewById(com.tencent.mm.plugin.finder.b.f.finder_comment_closed_tips);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      for (;;)
      {
        localObject1 = this.xgX;
        FinderCommentDrawer localFinderCommentDrawer1 = this.Bep;
        if (localFinderCommentDrawer1 == null) {
          p.bGy("commentDrawer");
        }
        Object localObject2 = this.Bep;
        if (localObject2 == null) {
          p.bGy("commentDrawer");
        }
        localObject2 = ((FinderCommentDrawer)localObject2).getFeedObj();
        if (localObject2 == null) {
          p.iCn();
        }
        Object localObject3 = this.Bep;
        if (localObject3 == null) {
          p.bGy("commentDrawer");
        }
        localObject3 = ((FinderCommentDrawer)localObject3).getOnCloseDrawerCallback();
        Object localObject4 = this.Bep;
        if (localObject4 == null) {
          p.bGy("commentDrawer");
        }
        int i = ((FinderCommentDrawer)localObject4).getScene();
        localObject4 = this.Bep;
        if (localObject4 == null) {
          p.bGy("commentDrawer");
        }
        paramBoolean1 = ((FinderCommentDrawer)localObject4).mss;
        localObject4 = this.Bep;
        if (localObject4 == null) {
          p.bGy("commentDrawer");
        }
        long l = ((FinderCommentDrawer)localObject4).getRefCommentId();
        localObject4 = this.Bep;
        if (localObject4 == null) {
          p.bGy("commentDrawer");
        }
        localObject4 = ((FinderCommentDrawer)localObject4).getReplyCommentObj();
        FinderCommentDrawer localFinderCommentDrawer2 = this.Bep;
        if (localFinderCommentDrawer2 == null) {
          p.bGy("commentDrawer");
        }
        paramBoolean2 = localFinderCommentDrawer2.getUseCache();
        localFinderCommentDrawer2 = this.Bep;
        if (localFinderCommentDrawer2 == null) {
          p.bGy("commentDrawer");
        }
        boolean bool1 = localFinderCommentDrawer2.getBlinkRefComment();
        localFinderCommentDrawer2 = this.Bep;
        if (localFinderCommentDrawer2 == null) {
          p.bGy("commentDrawer");
        }
        boolean bool2 = localFinderCommentDrawer2.getCloseComment();
        localFinderCommentDrawer2 = this.Bep;
        if (localFinderCommentDrawer2 == null) {
          p.bGy("commentDrawer");
        }
        ((CommentDrawerContract.NPresenter)localObject1).a(localFinderCommentDrawer1, this, (FinderItem)localObject2, (CommentDrawerContract.CloseDrawerCallback)localObject3, i, paramBoolean1, l, (am)localObject4, paramBoolean2, bool1, bool2, localFinderCommentDrawer2.getOldVersion());
        AppMethodBeat.o(168490);
        return;
        localObject1 = this.Beo;
        if (localObject1 == null) {
          p.bGy("drawerFooter");
        }
        ((FinderCommentFooter)localObject1).setVisibility(8);
        localObject1 = this.Bep;
        if (localObject1 == null) {
          p.bGy("commentDrawer");
        }
        if (((FinderCommentDrawer)localObject1).getCloseComment())
        {
          localObject1 = this.Beh;
          if (localObject1 == null) {
            p.bGy("headerLayout");
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(com.tencent.mm.plugin.finder.b.f.finder_comment_closed_tips);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          localObject1 = this.Bej;
          if (localObject1 == null) {
            p.bGy("nothingView");
          }
          ((View)localObject1).setVisibility(8);
          localObject1 = this.Aol;
          if (localObject1 == null) {
            p.bGy("retryView");
          }
          ((View)localObject1).setVisibility(8);
          localObject1 = this.Bei;
          if (localObject1 == null) {
            p.bGy("loadingLayout");
          }
          ((FrameLayout)localObject1).setVisibility(0);
        }
        else
        {
          localObject1 = this.Beh;
          if (localObject1 == null) {
            p.bGy("headerLayout");
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(com.tencent.mm.plugin.finder.b.f.finder_comment_closed_tips);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
        }
      }
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      this.xgX.onDetach();
    }
    AppMethodBeat.o(168490);
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(168489);
    p.k(paramContext, "context");
    p.k(paramFrameLayout, "loadingLayout");
    this.Bei = paramFrameLayout;
    paramContext = LayoutInflater.from(paramContext).inflate(com.tencent.mm.plugin.finder.b.g.finder_comment_loading_tips_layout, (ViewGroup)paramFrameLayout, true);
    paramFrameLayout = paramContext.findViewById(com.tencent.mm.plugin.finder.b.f.comment_loading_bar);
    p.j(paramFrameLayout, "loadingContentLayout.fin…R.id.comment_loading_bar)");
    this.kGT = paramFrameLayout;
    paramFrameLayout = paramContext.findViewById(com.tencent.mm.plugin.finder.b.f.no_comment_hint);
    p.j(paramFrameLayout, "loadingContentLayout.fin…yId(R.id.no_comment_hint)");
    this.Bej = paramFrameLayout;
    paramContext = paramContext.findViewById(com.tencent.mm.plugin.finder.b.f.retry_comment_layout);
    p.j(paramContext, "loadingContentLayout.fin….id.retry_comment_layout)");
    this.Aol = paramContext;
    paramContext = this.kGT;
    if (paramContext == null) {
      p.bGy("loadingView");
    }
    paramContext.setVisibility(0);
    paramContext = this.Bej;
    if (paramContext == null) {
      p.bGy("nothingView");
    }
    paramContext.setVisibility(8);
    paramContext = this.Aol;
    if (paramContext == null) {
      p.bGy("retryView");
    }
    paramContext.setVisibility(8);
    AppMethodBeat.o(168489);
  }
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout, final boolean paramBoolean)
  {
    AppMethodBeat.i(278692);
    p.k(paramContext, "context");
    p.k(paramFrameLayout, "footerLayout");
    paramContext = ad.kS(paramContext).inflate(com.tencent.mm.plugin.finder.b.g.comment_drawer_footer, (ViewGroup)paramFrameLayout).findViewById(com.tencent.mm.plugin.finder.b.f.finder_comment_footer);
    p.j(paramContext, "view.findViewById(R.id.finder_comment_footer)");
    this.Beo = ((FinderCommentFooter)paramContext);
    paramContext = this.Beo;
    if (paramContext == null) {
      p.bGy("drawerFooter");
    }
    paramContext.setBackClickListener((kotlin.g.a.a)new e(this, paramBoolean));
    paramContext = this.Beo;
    if (paramContext == null) {
      p.bGy("drawerFooter");
    }
    paramContext.setSwitchSceneListener((kotlin.g.a.a)new f(this));
    paramContext = this.Beo;
    if (paramContext == null) {
      p.bGy("drawerFooter");
    }
    paramFrameLayout = this.Bep;
    if (paramFrameLayout == null) {
      p.bGy("commentDrawer");
    }
    paramContext.setSelfProfile(paramFrameLayout.zxL);
    paramContext = this.Beo;
    if (paramContext == null) {
      p.bGy("drawerFooter");
    }
    paramFrameLayout = this.Bep;
    if (paramFrameLayout == null) {
      p.bGy("commentDrawer");
    }
    paramContext.setScene(paramFrameLayout.getSceneForReply());
    paramContext = this.Beo;
    if (paramContext == null) {
      p.bGy("drawerFooter");
    }
    paramFrameLayout = this.Bep;
    if (paramFrameLayout == null) {
      p.bGy("commentDrawer");
    }
    paramContext.setBanSwitchScene(paramFrameLayout.getBanSwitch());
    paramContext = new StringBuilder("drawerFooter.scene ");
    paramFrameLayout = this.Beo;
    if (paramFrameLayout == null) {
      p.bGy("drawerFooter");
    }
    Log.i("Finder.TimelineDrawerBuilder", paramFrameLayout.getScene());
    paramContext = this.Beo;
    if (paramContext == null) {
      p.bGy("drawerFooter");
    }
    paramContext.eix();
    paramContext = this.Beo;
    if (paramContext == null) {
      p.bGy("drawerFooter");
    }
    paramContext.eiy();
    paramContext = this.Bep;
    if (paramContext == null) {
      p.bGy("commentDrawer");
    }
    paramFrameLayout = this.Beo;
    if (paramFrameLayout == null) {
      p.bGy("drawerFooter");
    }
    paramContext.setKeyboardHeightObserver((h)paramFrameLayout);
    paramContext = this.Bep;
    if (paramContext == null) {
      p.bGy("commentDrawer");
    }
    paramFrameLayout = this.Beo;
    if (paramFrameLayout == null) {
      p.bGy("drawerFooter");
    }
    paramContext.setFooter(paramFrameLayout);
    AppMethodBeat.o(278692);
  }
  
  public final void bm(float paramFloat)
  {
    AppMethodBeat.i(168491);
    Object localObject = this.Bep;
    if (localObject == null) {
      p.bGy("commentDrawer");
    }
    if (((FinderCommentDrawer)localObject).mss)
    {
      localObject = this.Beo;
      if (localObject == null) {
        p.bGy("drawerFooter");
      }
      if (((FinderCommentFooter)localObject).getFooterMode() == 2)
      {
        localObject = this.context;
        if (localObject == null) {
          p.bGy("context");
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
  
  public final TextView ejD()
  {
    AppMethodBeat.i(168477);
    TextView localTextView = this.Beg;
    if (localTextView == null) {
      p.bGy("headerTitleTv");
    }
    AppMethodBeat.o(168477);
    return localTextView;
  }
  
  public final void ejF()
  {
    AppMethodBeat.i(278693);
    this.xgX.onDetach();
    AppMethodBeat.o(278693);
  }
  
  public final FinderCommentFooter ejG()
  {
    AppMethodBeat.i(168479);
    FinderCommentFooter localFinderCommentFooter = this.Beo;
    if (localFinderCommentFooter == null) {
      p.bGy("drawerFooter");
    }
    AppMethodBeat.o(168479);
    return localFinderCommentFooter;
  }
  
  public final FinderCommentDrawer ejH()
  {
    AppMethodBeat.i(168480);
    FinderCommentDrawer localFinderCommentDrawer = this.Bep;
    if (localFinderCommentDrawer == null) {
      p.bGy("commentDrawer");
    }
    AppMethodBeat.o(168480);
    return localFinderCommentDrawer;
  }
  
  public final View ejI()
  {
    AppMethodBeat.i(168483);
    View localView = this.Beq;
    if (localView == null) {
      p.bGy("headerErrTip");
    }
    AppMethodBeat.o(168483);
    return localView;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(168482);
    Context localContext = this.context;
    if (localContext == null) {
      p.bGy("context");
    }
    AppMethodBeat.o(168482);
    return localContext;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(168481);
    FrameLayout localFrameLayout = this.Beh;
    if (localFrameLayout == null) {
      p.bGy("headerLayout");
    }
    AppMethodBeat.o(168481);
    return localFrameLayout;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(278688);
    FrameLayout localFrameLayout = this.Bei;
    if (localFrameLayout == null) {
      p.bGy("loadingLayout");
    }
    AppMethodBeat.o(278688);
    return localFrameLayout;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(168478);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xvJ;
    if (localRefreshLoadMoreLayout == null) {
      p.bGy("rlLayout");
    }
    AppMethodBeat.o(168478);
    return localRefreshLoadMoreLayout;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(168493);
    Object localObject = this.Bei;
    if (localObject == null) {
      p.bGy("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(8);
    localObject = this.Aol;
    if (localObject == null) {
      p.bGy("retryView");
    }
    ((View)localObject).setOnClickListener(null);
    AppMethodBeat.o(168493);
  }
  
  public final void rv(boolean paramBoolean)
  {
    AppMethodBeat.i(168486);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout;
    if (paramBoolean)
    {
      localRefreshLoadMoreLayout = this.xvJ;
      if (localRefreshLoadMoreLayout == null) {
        p.bGy("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(true);
      localRefreshLoadMoreLayout = this.xvJ;
      if (localRefreshLoadMoreLayout == null) {
        p.bGy("rlLayout");
      }
      if (localRefreshLoadMoreLayout.getRefreshHeader() == null)
      {
        localRefreshLoadMoreLayout = this.xvJ;
        if (localRefreshLoadMoreLayout == null) {
          p.bGy("rlLayout");
        }
        Object localObject = this.context;
        if (localObject == null) {
          p.bGy("context");
        }
        localObject = ad.kS((Context)localObject).inflate(com.tencent.mm.plugin.finder.b.g.refresh_header, null);
        p.j(localObject, "MMLayoutInflater.getInfl…out.refresh_header, null)");
        localRefreshLoadMoreLayout.setRefreshHeaderView((View)localObject);
        AppMethodBeat.o(168486);
      }
    }
    else
    {
      localRefreshLoadMoreLayout = this.xvJ;
      if (localRefreshLoadMoreLayout == null) {
        p.bGy("rlLayout");
      }
      localRefreshLoadMoreLayout.setEnableRefresh(false);
    }
    AppMethodBeat.o(168486);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(168492);
    Object localObject = this.Bei;
    if (localObject == null) {
      p.bGy("loadingLayout");
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = this.kGT;
    if (localObject == null) {
      p.bGy("loadingView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.Bej;
    if (localObject == null) {
      p.bGy("nothingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.Aol;
    if (localObject == null) {
      p.bGy("retryView");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168492);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "lastState", "", "getLastState", "()I", "setLastState", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    private int xqS;
    
    c(Context paramContext) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(270242);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.xqS = paramInt;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(270242);
        return;
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(270242);
          throw paramRecyclerView;
        }
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        this.Bev.xgX.Mx(paramRecyclerView.kL());
        continue;
        if (this.xqS != 3)
        {
          paramRecyclerView = paramContext;
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(270242);
            throw paramRecyclerView;
          }
          ((MMFragmentActivity)paramRecyclerView).hideVKB();
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(270243);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(270243);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$3", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class d
    implements View.OnLayoutChangeListener
  {
    d(View paramView) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(178495);
      this.Bev.ejH().getFooterLayout().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      paramContext.setPadding(paramContext.getPaddingLeft(), paramContext.getPaddingTop(), paramContext.getPaddingRight(), this.Bev.ejG().getCommentEditTextLayout().getHeight());
      paramContext.requestLayout();
      Log.i("Finder.TimelineDrawerBuilder", "bottomMargin=" + this.Bev.ejG().getCommentEditTextLayout().getHeight() + " paddingBottom=" + paramContext.getPaddingBottom());
      AppMethodBeat.o(178495);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168475);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.Bev.Bes;
      p.j(paramView, "it");
      ((kotlin.g.a.b)localObject).invoke(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168475);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<View, x>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class i
    implements View.OnClickListener
  {
    public i(kotlin.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168476);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xAe.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168476);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.b
 * JD-Core Version:    0.7.0.1
 */