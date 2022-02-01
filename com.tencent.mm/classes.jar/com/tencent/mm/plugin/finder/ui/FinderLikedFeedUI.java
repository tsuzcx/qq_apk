package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelinePresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback.initView.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback.initView.3;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.al;
import com.tencent.mm.plugin.finder.viewmodel.component.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_WX_MSG", "", "TAG", "", "cacheId", "", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "initPos", "isOtherEnableFullScreenEnjoy", "", "()Z", "isOtherEnableFullScreenEnjoy$delegate", "Lkotlin/Lazy;", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "fixActionBarStatus", "", "getCommentScene", "getLayoutId", "getReportType", "goBack", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "isHideStatusBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "overlayStatusBar", "plugin-finder_release"})
public final class FinderLikedFeedUI
  extends MMFinderUI
{
  private final int ArA;
  private final d ArB;
  private final String TAG;
  private HashMap _$_findViewCache;
  private String username;
  private long xKc;
  private RefreshLoadMoreLayout xvJ;
  private com.tencent.mm.plugin.finder.view.f xvK;
  public FinderLikeDrawer xvM;
  private FinderLikedFeedContract.LikedTimelinePresenter zNA;
  private final kotlin.f zNp;
  private FinderLikedFeedContract.LikedTimelineViewCallback zNu;
  private int zZD;
  
  public FinderLikedFeedUI()
  {
    AppMethodBeat.i(278729);
    this.TAG = "Finder.FinderLikedFeedUI";
    this.zNp = kotlin.g.ar((kotlin.g.a.a)c.ArD);
    this.ArA = 1;
    this.ArB = new d();
    AppMethodBeat.o(278729);
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(167323);
    Object localObject = this.xvK;
    if (localObject == null) {
      p.bGy("drawer");
    }
    if (((com.tencent.mm.plugin.finder.view.f)localObject).eis())
    {
      localObject = this.xvK;
      if (localObject == null) {
        p.bGy("drawer");
      }
      ((com.tencent.mm.plugin.finder.view.f)localObject).eir();
      AppMethodBeat.o(167323);
      return;
    }
    localObject = this.xvM;
    if (localObject == null) {
      p.bGy("friendLikeDrawer");
    }
    if (((FinderLikeDrawer)localObject).eis())
    {
      localObject = this.xvM;
      if (localObject == null) {
        p.bGy("friendLikeDrawer");
      }
      ((FinderLikeDrawer)localObject).eir();
      AppMethodBeat.o(167323);
      return;
    }
    finish();
    AppMethodBeat.o(167323);
  }
  
  private final boolean isOtherEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(278724);
    boolean bool = ((Boolean)this.zNp.getValue()).booleanValue();
    AppMethodBeat.o(278724);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(278731);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(278731);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(278730);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(278730);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_liked_feed_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(278725);
    if (isOtherEnableFullScreenEnjoy())
    {
      Set localSet = ak.setOf(new Class[] { an.class, ab.class, al.class });
      AppMethodBeat.o(278725);
      return localSet;
    }
    AppMethodBeat.o(278725);
    return null;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167321);
    setMMTitle(b.j.finder_my_inactive_feed);
    Object localObject1 = findViewById(b.f.rl_layout);
    p.j(localObject1, "findViewById(R.id.rl_layout)");
    this.xvJ = ((RefreshLoadMoreLayout)localObject1);
    setBackBtn((MenuItem.OnMenuItemClickListener)new FinderLikedFeedUI.b(this));
    this.xKc = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    this.zZD = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
    localObject1 = com.tencent.mm.plugin.finder.view.f.AVu;
    localObject1 = (MMFragmentActivity)this;
    Object localObject2 = getWindow();
    p.j(localObject2, "window");
    localObject2 = ((Window)localObject2).getDecorView();
    p.j(localObject2, "window.decorView");
    this.xvK = f.a.a((MMFragmentActivity)localObject1, (View)localObject2, 2, false, 0, 24);
    localObject1 = FinderLikeDrawer.AYs;
    localObject1 = getContext();
    p.j(localObject1, "context");
    localObject1 = (Context)localObject1;
    localObject2 = getContext();
    p.j(localObject2, "context");
    localObject2 = ((AppCompatActivity)localObject2).getWindow();
    p.j(localObject2, "context.window");
    Object localObject3 = FinderLikeDrawer.AYs;
    this.xvM = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.eiO());
    localObject1 = this.xvJ;
    if (localObject1 == null) {
      p.bGy("rlLayout");
    }
    localObject2 = ad.kS((Context)getContext());
    int i;
    if (isOtherEnableFullScreenEnjoy())
    {
      i = b.g.load_more_footer_dark;
      localObject2 = ((LayoutInflater)localObject2).inflate(i, null);
      p.j(localObject2, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
      localObject1 = (MMActivity)this;
      localObject2 = this.xvK;
      if (localObject2 == null) {
        p.bGy("drawer");
      }
      this.zNA = new FinderLikedFeedContract.LikedTimelinePresenter((MMActivity)localObject1, (com.tencent.mm.plugin.finder.view.f)localObject2);
      localObject1 = (MMActivity)this;
      localObject2 = this.zNA;
      if (localObject2 == null) {
        p.bGy("presenter");
      }
      this.zNu = new FinderLikedFeedContract.LikedTimelineViewCallback((MMActivity)localObject1, (FinderLikedFeedContract.LikedTimelinePresenter)localObject2);
      localObject1 = this.zNu;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iXq.findViewById(b.f.empty_view);
      p.j(localObject2, "context.findViewById(R.id.empty_view)");
      ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).Xd = ((View)localObject2);
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).Xd;
      if (localObject2 == null) {
        p.bGy("mEmptyView");
      }
      ((View)localObject2).setVisibility(8);
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iXq.findViewById(b.f.rl_layout);
      p.j(localObject2, "context.findViewById(R.id.rl_layout)");
      ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).xvJ = ((RefreshLoadMoreLayout)localObject2);
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).xvJ;
      if (localObject2 == null) {
        p.bGy("rlLayout");
      }
      ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).jLl = ((RefreshLoadMoreLayout)localObject2).getRecyclerView();
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).jLl;
      if (localObject2 == null) {
        p.bGy("recyclerView");
      }
      localObject3 = new FinderLinearLayoutManager((Context)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iXq);
      FinderLikedFeedContract localFinderLikedFeedContract = FinderLikedFeedContract.zNq;
      if (FinderLikedFeedContract.dMY())
      {
        ((FinderLinearLayoutManager)localObject3).BdV = 25.0F;
        ((FinderLinearLayoutManager)localObject3).uqm = 100;
      }
      ((RecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject3);
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).jLl;
      if (localObject2 == null) {
        p.bGy("recyclerView");
      }
      ((RecyclerView)localObject2).setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).zNA), (ArrayList)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).duQ().getDataList()));
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iXq.findViewById(b.f.content_view);
      localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).xvJ;
      if (localObject3 == null) {
        p.bGy("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject3).setActionCallback((RefreshLoadMoreLayout.a)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.2((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1, (View)localObject2));
      localObject2 = FinderLikedFeedContract.zNq;
      if (FinderLikedFeedContract.dMY()) {
        break label817;
      }
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).jLl;
      if (localObject2 == null) {
        p.bGy("recyclerView");
      }
      ((RecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getColor(b.c.BG_0)), (int)c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getDimension(b.d.feed_divider)));
    }
    for (;;)
    {
      d.a(d.aJa(), (kotlin.g.a.b)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.3((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1));
      localObject2 = com.tencent.mm.ui.component.g.Xox;
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.d((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class));
      if (localObject2 != null)
      {
        localObject1 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).jLl;
        if (localObject1 == null) {
          p.bGy("recyclerView");
        }
        ((com.tencent.mm.plugin.finder.event.base.f)localObject2).k((RecyclerView)localObject1);
      }
      localObject2 = this.zNu;
      if (localObject2 == null) {
        p.bGy("viewCallback");
      }
      localObject1 = (BaseFinderFeedLoader)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2).zNA.zNr;
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2).xvJ;
      if (localObject2 == null) {
        p.bGy("rlLayout");
      }
      ((BaseFinderFeedLoader)localObject1).register((j)localObject2);
      localObject1 = this.zNA;
      if (localObject1 == null) {
        p.bGy("presenter");
      }
      localObject2 = this.zNu;
      if (localObject2 == null) {
        p.bGy("viewCallback");
      }
      ((FinderLikedFeedContract.LikedTimelinePresenter)localObject1).a((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2);
      AppMethodBeat.o(167321);
      return;
      i = b.g.load_more_footer;
      break;
      label817:
      localObject2 = new e();
      localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).jLl;
      if (localObject3 == null) {
        p.bGy("recyclerView");
      }
      ((e)localObject2).a((RecyclerView)localObject3);
    }
  }
  
  public final boolean isHideStatusBar()
  {
    AppMethodBeat.i(278726);
    boolean bool = isOtherEnableFullScreenEnjoy();
    AppMethodBeat.o(278726);
    return bool;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(278728);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.view.f localf = this.xvK;
    if (localf == null) {
      p.bGy("drawer");
    }
    localf.d(paramInt1, paramIntent);
    AppMethodBeat.o(278728);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167324);
    goBack();
    AppMethodBeat.o(167324);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167320);
    super.onCreate(paramBundle);
    this.username = z.bcZ();
    Log.i(this.TAG, "username %s", new Object[] { this.username });
    initView();
    if (isOtherEnableFullScreenEnjoy())
    {
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      getController().q((Activity)this, getResources().getColor(b.c.transparent));
      com.tencent.mm.ui.c.f((Activity)this, false);
      paramBundle = getSupportActionBar();
      if (paramBundle != null)
      {
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle.hide();
      }
      paramBundle = ad.kS((Context)getContext());
      int i = b.g.finder_full_action_bar_layout;
      Object localObject = getBodyView();
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(167320);
        throw paramBundle;
      }
      paramBundle.inflate(i, (ViewGroup)localObject, true);
      i = ax.getStatusBarHeight((Context)this);
      paramBundle = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
      p.j(paramBundle, "full_actionbar");
      paramBundle = paramBundle.getLayoutParams();
      paramBundle.height += i;
      localObject = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
      p.j(localObject, "full_actionbar");
      ((FrameLayout)localObject).setLayoutParams(paramBundle);
      ((FrameLayout)_$_findCachedViewById(b.f.full_actionbar)).setPadding(0, i, 0, 0);
      ((LinearLayout)_$_findCachedViewById(b.f.back_button)).setOnClickListener((View.OnClickListener)new FinderLikedFeedUI.a(this));
      paramBundle = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
      p.j(paramBundle, "full_action_bar_title");
      paramBundle.setVisibility(8);
      paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      com.tencent.mm.plugin.finder.utils.aj.b(paramBundle, false);
      setNavigationbarColor(getResources().getColor(b.c.black));
      paramBundle = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
      p.j(paramBundle, "full_actionbar");
      paramBundle.setVisibility(0);
      paramBundle = this.xvJ;
      if (paramBundle == null) {
        p.bGy("rlLayout");
      }
      paramBundle.setBackgroundColor(getResources().getColor(b.c.full_black));
    }
    paramBundle = this.zNu;
    if (paramBundle == null) {
      p.bGy("viewCallback");
    }
    paramBundle.getRecyclerView().a((RecyclerView.l)this.ArB);
    paramBundle = (WeImageView)findViewById(b.f.backBtnIv);
    if (paramBundle != null)
    {
      paramBundle.setIconColor(getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_5));
      AppMethodBeat.o(167320);
      return;
    }
    AppMethodBeat.o(167320);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167322);
    Object localObject = this.xvK;
    if (localObject == null) {
      p.bGy("drawer");
    }
    ((com.tencent.mm.plugin.finder.view.f)localObject).onDetach();
    super.onDestroy();
    localObject = this.zNu;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).getRecyclerView().b((RecyclerView.l)this.ArB);
    localObject = this.zNu;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = (BaseFinderFeedLoader)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).zNA.zNr;
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).xvJ;
    if (localRefreshLoadMoreLayout == null) {
      p.bGy("rlLayout");
    }
    localBaseFinderFeedLoader.unregister((j)localRefreshLoadMoreLayout);
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).zNA.onDetach();
    AppMethodBeat.o(167322);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(178433);
    super.onPause();
    if (this.xvK == null) {
      p.bGy("drawer");
    }
    Object localObject = k.yBj;
    localObject = this.zNu;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    k.b(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).getRecyclerView(), s.t.yGO, "2", com.tencent.mm.plugin.finder.live.report.c.yAj);
    AppMethodBeat.o(178433);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(178432);
    super.onResume();
    Object localObject = this.xvK;
    if (localObject == null) {
      p.bGy("drawer");
    }
    ((com.tencent.mm.plugin.finder.view.f)localObject).onUIResume();
    localObject = k.yBj;
    localObject = this.zNu;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    k.b(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).getRecyclerView(), s.t.yGO, "2", com.tencent.mm.plugin.finder.live.report.c.yAi);
    AppMethodBeat.o(178432);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(278727);
    p.k(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    paramBundle = this.zNA;
    if (paramBundle == null) {
      p.bGy("presenter");
    }
    paramBundle = (BaseFinderFeedLoader)paramBundle.zNr;
    Intent localIntent = getIntent();
    p.j(localIntent, "intent");
    FinderLikedFeedContract.LikedTimelinePresenter localLikedTimelinePresenter = this.zNA;
    if (localLikedTimelinePresenter == null) {
      p.bGy("presenter");
    }
    BaseFeedLoader.saveCache$default(paramBundle, localIntent, ((BaseFinderFeedLoader)localLikedTimelinePresenter.zNr).getInitPos(), null, 4, null);
    AppMethodBeat.o(278727);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final c ArD;
    
    static
    {
      AppMethodBeat.i(237085);
      ArD = new c();
      AppMethodBeat.o(237085);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(285458);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(285458);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(285457);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGO, "2", com.tencent.mm.plugin.finder.live.report.c.yAh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(285457);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI
 * JD-Core Version:    0.7.0.1
 */