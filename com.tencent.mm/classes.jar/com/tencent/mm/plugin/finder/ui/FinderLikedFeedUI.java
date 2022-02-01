package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelinePresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback.initView.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback.initView.2;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.e.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_WX_MSG", "", "TAG", "", "cacheId", "", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "initPos", "isOtherEnableFullScreenEnjoy", "", "()Z", "isOtherEnableFullScreenEnjoy$delegate", "Lkotlin/Lazy;", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "fixActionBarStatus", "", "getCommentScene", "getLayoutId", "getReportType", "goBack", "initView", "isHideStatusBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "overlayStatusBar", "plugin-finder_release"})
public final class FinderLikedFeedUI
  extends MMFinderUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private RefreshLoadMoreLayout tLS;
  private com.tencent.mm.plugin.finder.view.e tLT;
  public FinderLikeDrawer tLV;
  private long tZj;
  private int uCt;
  private final kotlin.f uXa;
  private FinderLikedFeedContract.LikedTimelineViewCallback uXf;
  private FinderLikedFeedContract.LikedTimelinePresenter uXl;
  private String username;
  private final int vKH;
  private final e vKI;
  
  public FinderLikedFeedUI()
  {
    AppMethodBeat.i(252447);
    this.TAG = "Finder.FinderLikedFeedUI";
    this.uXa = g.ah((kotlin.g.a.a)d.vKK);
    this.vKH = 1;
    this.vKI = new e();
    AppMethodBeat.o(252447);
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(167323);
    Object localObject = this.tLT;
    if (localObject == null) {
      p.btv("drawer");
    }
    if (((com.tencent.mm.plugin.finder.view.e)localObject).dGs())
    {
      localObject = this.tLT;
      if (localObject == null) {
        p.btv("drawer");
      }
      ((com.tencent.mm.plugin.finder.view.e)localObject).dGr();
      AppMethodBeat.o(167323);
      return;
    }
    localObject = this.tLV;
    if (localObject == null) {
      p.btv("friendLikeDrawer");
    }
    if (((FinderLikeDrawer)localObject).dGs())
    {
      localObject = this.tLV;
      if (localObject == null) {
        p.btv("friendLikeDrawer");
      }
      ((FinderLikeDrawer)localObject).dGr();
      AppMethodBeat.o(167323);
      return;
    }
    finish();
    AppMethodBeat.o(167323);
  }
  
  private final boolean isOtherEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(252443);
    boolean bool = ((Boolean)this.uXa.getValue()).booleanValue();
    AppMethodBeat.o(252443);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252450);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252450);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252449);
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
    AppMethodBeat.o(252449);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131494358;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167321);
    setMMTitle(2131760321);
    Object localObject1 = findViewById(2131307118);
    p.g(localObject1, "findViewById(R.id.rl_layout)");
    this.tLS = ((RefreshLoadMoreLayout)localObject1);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    this.tZj = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    this.uCt = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
    localObject1 = com.tencent.mm.plugin.finder.view.e.wky;
    localObject1 = (MMFragmentActivity)this;
    Object localObject2 = getWindow();
    p.g(localObject2, "window");
    localObject2 = ((Window)localObject2).getDecorView();
    p.g(localObject2, "window.decorView");
    this.tLT = e.a.a((MMFragmentActivity)localObject1, (View)localObject2, 2, false, 0, 24);
    localObject1 = FinderLikeDrawer.wnm;
    localObject1 = getContext();
    p.g(localObject1, "context");
    localObject1 = (Context)localObject1;
    localObject2 = getContext();
    p.g(localObject2, "context");
    localObject2 = ((AppCompatActivity)localObject2).getWindow();
    p.g(localObject2, "context.window");
    Object localObject3 = FinderLikeDrawer.wnm;
    this.tLV = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.dGP());
    localObject1 = this.tLS;
    if (localObject1 == null) {
      p.btv("rlLayout");
    }
    localObject2 = aa.jQ((Context)getContext()).inflate(2131495297, null);
    p.g(localObject2, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
    localObject1 = (MMActivity)this;
    localObject2 = this.tLT;
    if (localObject2 == null) {
      p.btv("drawer");
    }
    this.uXl = new FinderLikedFeedContract.LikedTimelinePresenter((MMActivity)localObject1, (com.tencent.mm.plugin.finder.view.e)localObject2);
    localObject1 = (MMActivity)this;
    localObject2 = this.uXl;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    this.uXf = new FinderLikedFeedContract.LikedTimelineViewCallback((MMActivity)localObject1, (FinderLikedFeedContract.LikedTimelinePresenter)localObject2);
    localObject1 = this.uXf;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).gte.findViewById(2131300111);
    p.g(localObject2, "context.findViewById(R.id.empty_view)");
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).GQ = ((View)localObject2);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).GQ;
    if (localObject2 == null) {
      p.btv("mEmptyView");
    }
    ((View)localObject2).setVisibility(8);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).gte.findViewById(2131307118);
    p.g(localObject2, "context.findViewById(R.id.rl_layout)");
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).tLS = ((RefreshLoadMoreLayout)localObject2);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).tLS;
    if (localObject2 == null) {
      p.btv("rlLayout");
    }
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).hak = ((RefreshLoadMoreLayout)localObject2).getRecyclerView();
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).hak;
    if (localObject2 == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).gte));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).hak;
    if (localObject2 == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject2).setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).uXl), (ArrayList)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).ddM().getDataList()));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).gte.findViewById(2131299227);
    localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).tLS;
    if (localObject3 == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject3).setActionCallback((RefreshLoadMoreLayout.a)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.1((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1, (View)localObject2));
    localObject2 = FinderLikedFeedContract.uXb;
    if (!FinderLikedFeedContract.dlU())
    {
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).hak;
      if (localObject2 == null) {
        p.btv("recyclerView");
      }
      ((RecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getColor(2131099648)), (int)c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getDimension(2131166341)));
    }
    for (;;)
    {
      d.a(d.aBx(), (kotlin.g.a.b)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.2((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1));
      localObject2 = com.tencent.mm.ui.component.a.PRN;
      localObject2 = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).gte).get(FinderReporterUIC.class));
      if (localObject2 != null)
      {
        localObject1 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).hak;
        if (localObject1 == null) {
          p.btv("recyclerView");
        }
        ((com.tencent.mm.plugin.finder.event.base.f)localObject2).m((RecyclerView)localObject1);
      }
      localObject2 = this.uXf;
      if (localObject2 == null) {
        p.btv("viewCallback");
      }
      localObject1 = (BaseFinderFeedLoader)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2).uXl.uXc;
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2).tLS;
      if (localObject2 == null) {
        p.btv("rlLayout");
      }
      ((BaseFinderFeedLoader)localObject1).register((j)localObject2);
      localObject1 = this.uXl;
      if (localObject1 == null) {
        p.btv("presenter");
      }
      localObject2 = this.uXf;
      if (localObject2 == null) {
        p.btv("viewCallback");
      }
      ((FinderLikedFeedContract.LikedTimelinePresenter)localObject1).a((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2);
      AppMethodBeat.o(167321);
      return;
      localObject2 = new e();
      localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).hak;
      if (localObject3 == null) {
        p.btv("recyclerView");
      }
      ((e)localObject2).f((RecyclerView)localObject3);
    }
  }
  
  public final boolean isHideStatusBar()
  {
    AppMethodBeat.i(252444);
    boolean bool = isOtherEnableFullScreenEnjoy();
    AppMethodBeat.o(252444);
    return bool;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252446);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.view.e locale = this.tLT;
    if (locale == null) {
      p.btv("drawer");
    }
    locale.d(paramInt1, paramIntent);
    AppMethodBeat.o(252446);
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
    this.username = z.aTY();
    Log.i(this.TAG, "username %s", new Object[] { this.username });
    initView();
    if (isOtherEnableFullScreenEnjoy())
    {
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.g(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      getController().p((Activity)this, getResources().getColor(2131101287));
      com.tencent.mm.ui.b.e((Activity)this, false);
      paramBundle = getSupportActionBar();
      if (paramBundle != null)
      {
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle.hide();
      }
      paramBundle = aa.jQ((Context)getContext());
      Object localObject = getBodyView();
      if (localObject == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(167320);
        throw paramBundle;
      }
      paramBundle.inflate(2131494330, (ViewGroup)localObject, true);
      int i = au.getStatusBarHeight((Context)this);
      paramBundle = (FrameLayout)_$_findCachedViewById(2131301815);
      p.g(paramBundle, "full_actionbar");
      paramBundle = paramBundle.getLayoutParams();
      paramBundle.height += i;
      localObject = (FrameLayout)_$_findCachedViewById(2131301815);
      p.g(localObject, "full_actionbar");
      ((FrameLayout)localObject).setLayoutParams(paramBundle);
      ((FrameLayout)_$_findCachedViewById(2131301815)).setPadding(0, i, 0, 0);
      ((LinearLayout)_$_findCachedViewById(2131297164)).setOnClickListener((View.OnClickListener)new a(this));
      ((FrameLayout)_$_findCachedViewById(2131301815)).setOnClickListener((View.OnClickListener)new b(this));
      paramBundle = (TextView)_$_findCachedViewById(2131301814);
      p.g(paramBundle, "full_action_bar_title");
      paramBundle.setVisibility(8);
      paramBundle = y.vXH;
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      y.b(paramBundle, false);
      setNavigationbarColor(getResources().getColor(2131100042));
      paramBundle = (FrameLayout)_$_findCachedViewById(2131301815);
      p.g(paramBundle, "full_actionbar");
      paramBundle.setVisibility(0);
    }
    paramBundle = this.uXf;
    if (paramBundle == null) {
      p.btv("viewCallback");
    }
    paramBundle.getRecyclerView().a((RecyclerView.l)this.vKI);
    AppMethodBeat.o(167320);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167322);
    Object localObject = this.tLT;
    if (localObject == null) {
      p.btv("drawer");
    }
    ((com.tencent.mm.plugin.finder.view.e)localObject).onDetach();
    super.onDestroy();
    localObject = this.uXf;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).getRecyclerView().b((RecyclerView.l)this.vKI);
    localObject = this.uXf;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = (BaseFinderFeedLoader)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).uXl.uXc;
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).tLS;
    if (localRefreshLoadMoreLayout == null) {
      p.btv("rlLayout");
    }
    localBaseFinderFeedLoader.unregister((j)localRefreshLoadMoreLayout);
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).uXl.onDetach();
    AppMethodBeat.o(167322);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(178433);
    super.onPause();
    if (this.tLT == null) {
      p.btv("drawer");
    }
    Object localObject = k.vkd;
    localObject = this.uXf;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    k.b(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).getRecyclerView(), s.p.voB, "2", com.tencent.mm.plugin.finder.report.live.c.vjg);
    AppMethodBeat.o(178433);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(178432);
    super.onResume();
    Object localObject = this.tLT;
    if (localObject == null) {
      p.btv("drawer");
    }
    ((com.tencent.mm.plugin.finder.view.e)localObject).onUIResume();
    localObject = k.vkd;
    localObject = this.uXf;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    k.b(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).getRecyclerView(), s.p.voB, "2", com.tencent.mm.plugin.finder.report.live.c.vjf);
    AppMethodBeat.o(178432);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(252445);
    super.onSaveInstanceState(paramBundle);
    paramBundle = this.uXl;
    if (paramBundle == null) {
      p.btv("presenter");
    }
    paramBundle = (BaseFinderFeedLoader)paramBundle.uXc;
    Intent localIntent = getIntent();
    p.g(localIntent, "intent");
    FinderLikedFeedContract.LikedTimelinePresenter localLikedTimelinePresenter = this.uXl;
    if (localLikedTimelinePresenter == null) {
      p.btv("presenter");
    }
    BaseFeedLoader.saveCache$default(paramBundle, localIntent, ((BaseFinderFeedLoader)localLikedTimelinePresenter.uXc).getInitPos(), null, 4, null);
    AppMethodBeat.o(252445);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderLikedFeedUI paramFinderLikedFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252437);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.vKJ.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252437);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderLikedFeedUI paramFinderLikedFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252438);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = FinderLikedFeedUI.b(this.vKJ).getRecyclerView();
      localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252438);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderLikedFeedUI paramFinderLikedFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167316);
      FinderLikedFeedUI.a(this.vKJ);
      AppMethodBeat.o(167316);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final d vKK;
    
    static
    {
      AppMethodBeat.i(252440);
      vKK = new d();
      AppMethodBeat.o(252440);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(252442);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(252442);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(252441);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.vkd;
      k.b(paramRecyclerView, s.p.voB, "2", com.tencent.mm.plugin.finder.report.live.c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(252441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI
 * JD-Core Version:    0.7.0.1
 */