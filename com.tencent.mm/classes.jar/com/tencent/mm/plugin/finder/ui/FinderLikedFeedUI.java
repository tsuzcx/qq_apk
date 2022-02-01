package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelinePresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback.initView.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback.initView.3;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.ae;
import com.tencent.mm.plugin.finder.viewmodel.component.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.az;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderFeedDetailUI;", "()V", "MENU_ID_WX_MSG", "", "TAG", "", "cacheId", "", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "initPos", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "fixActionBarStatus", "", "getCommentScene", "getLayoutId", "getReportType", "goBack", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "isHideStatusBar", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "overlayStatusBar", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLikedFeedUI
  extends MMFinderFeedDetailUI
{
  public FinderLikeDrawer ATA;
  private RefreshLoadMoreLayout ATx;
  private com.tencent.mm.plugin.finder.view.f ATy;
  private long BjP;
  private FinderLikedFeedContract.LikedTimelineViewCallback EYa;
  private FinderLikedFeedContract.LikedTimelinePresenter EYf;
  private final int FRc;
  private final a FRd;
  private int FuA;
  private final String TAG;
  private String username;
  
  public FinderLikedFeedUI()
  {
    AppMethodBeat.i(347777);
    this.TAG = "Finder.FinderLikedFeedUI";
    this.FRc = 1;
    this.FRd = new a();
    AppMethodBeat.o(347777);
  }
  
  private static final void a(FinderLikedFeedUI paramFinderLikedFeedUI, View paramView)
  {
    AppMethodBeat.i(347821);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLikedFeedUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLikedFeedUI, "this$0");
    paramFinderLikedFeedUI.onBackPressed();
    a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347821);
  }
  
  private static final boolean a(FinderLikedFeedUI paramFinderLikedFeedUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347808);
    s.u(paramFinderLikedFeedUI, "this$0");
    paramFinderLikedFeedUI.goBack();
    AppMethodBeat.o(347808);
    return true;
  }
  
  private FinderLikeDrawer ebF()
  {
    AppMethodBeat.i(347788);
    FinderLikeDrawer localFinderLikeDrawer = this.ATA;
    if (localFinderLikeDrawer != null)
    {
      AppMethodBeat.o(347788);
      return localFinderLikeDrawer;
    }
    s.bIx("friendLikeDrawer");
    AppMethodBeat.o(347788);
    return null;
  }
  
  private final void goBack()
  {
    Object localObject2 = null;
    AppMethodBeat.i(167323);
    com.tencent.mm.plugin.finder.view.f localf = this.ATy;
    Object localObject1 = localf;
    if (localf == null)
    {
      s.bIx("drawer");
      localObject1 = null;
    }
    if (((com.tencent.mm.plugin.finder.view.f)localObject1).fkp())
    {
      localObject1 = this.ATy;
      if (localObject1 == null)
      {
        s.bIx("drawer");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.finder.view.f)localObject1).fdh();
        AppMethodBeat.o(167323);
        return;
      }
    }
    if (ebF().fkp())
    {
      ebF().fdh();
      AppMethodBeat.o(167323);
      return;
    }
    finish();
    AppMethodBeat.o(167323);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_liked_feed_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347865);
    Set localSet = ar.setOf(new Class[] { az.class, ag.class, com.tencent.mm.plugin.finder.viewmodel.component.av.class, com.tencent.mm.plugin.finder.viewmodel.component.f.class, com.tencent.mm.plugin.finder.viewmodel.component.c.class, com.tencent.mm.plugin.finder.viewmodel.teenmode.b.class, ae.class });
    AppMethodBeat.o(347865);
    return localSet;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(167321);
    setMMTitle(e.h.finder_my_inactive_feed);
    Object localObject1 = findViewById(e.e.rl_layout);
    s.s(localObject1, "findViewById(R.id.rl_layout)");
    this.ATx = ((RefreshLoadMoreLayout)localObject1);
    setBackBtn(new FinderLikedFeedUI..ExternalSyntheticLambda0(this));
    this.BjP = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    this.FuA = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
    localObject1 = com.tencent.mm.plugin.finder.view.f.GxF;
    localObject1 = (MMFragmentActivity)this;
    Object localObject2 = getWindow().getDecorView();
    s.s(localObject2, "window.decorView");
    this.ATy = f.a.a((MMFragmentActivity)localObject1, (View)localObject2, 2, false, 0, 24);
    localObject1 = FinderLikeDrawer.GAf;
    localObject1 = getContext();
    s.s(localObject1, "context");
    localObject1 = (Context)localObject1;
    localObject2 = getContext().getWindow();
    s.s(localObject2, "context.window");
    Object localObject4 = FinderLikeDrawer.GAf;
    localObject1 = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fkM());
    s.u(localObject1, "<set-?>");
    this.ATA = ((FinderLikeDrawer)localObject1);
    localObject1 = this.ATx;
    label319:
    Object localObject5;
    if (localObject1 == null)
    {
      s.bIx("rlLayout");
      localObject1 = null;
      localObject2 = af.mU((Context)getContext()).inflate(e.f.load_more_footer_dark, null);
      s.s(localObject2, "getInflater(context).inf…d_more_footer_dark, null)");
      ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
      localObject4 = (MMActivity)this;
      localObject2 = this.ATy;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("drawer");
        localObject1 = null;
      }
      this.EYf = new FinderLikedFeedContract.LikedTimelinePresenter((MMActivity)localObject4, (com.tencent.mm.plugin.finder.view.f)localObject1);
      localObject4 = (MMActivity)this;
      localObject2 = this.EYf;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      this.EYa = new FinderLikedFeedContract.LikedTimelineViewCallback((MMActivity)localObject4, (FinderLikedFeedContract.LikedTimelinePresenter)localObject1);
      localObject1 = this.EYa;
      if (localObject1 != null) {
        break label814;
      }
      s.bIx("viewCallback");
      localObject1 = null;
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).lzt.findViewById(e.e.empty_view);
      s.s(localObject2, "context.findViewById(R.id.empty_view)");
      s.u(localObject2, "<set-?>");
      ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).bEx = ((View)localObject2);
      ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).epE().setVisibility(8);
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).lzt.findViewById(e.e.rl_layout);
      s.s(localObject2, "context.findViewById(R.id.rl_layout)");
      localObject2 = (RefreshLoadMoreLayout)localObject2;
      s.u(localObject2, "<set-?>");
      ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).ATx = ((RefreshLoadMoreLayout)localObject2);
      ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).mkw = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).getRlLayout().getRecyclerView();
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).mkw;
      if (localObject2 != null) {
        break label817;
      }
      s.bIx("recyclerView");
      localObject2 = null;
      label421:
      localObject4 = new FinderLinearLayoutManager((Context)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).lzt);
      ((FinderLinearLayoutManager)localObject4).GGx = 25.0F;
      ((FinderLinearLayoutManager)localObject4).xwJ = 100;
      localObject5 = ah.aiuX;
      ((RecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject4);
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).mkw;
      if (localObject2 != null) {
        break label820;
      }
      s.bIx("recyclerView");
      localObject2 = null;
    }
    label814:
    label817:
    label820:
    for (;;)
    {
      ((RecyclerView)localObject2).setAdapter((RecyclerView.a)new WxRecyclerAdapter((g)new FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).EYf), (ArrayList)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).eeh().getDataList()));
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).lzt.findViewById(e.e.content_view);
      ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.2((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1, (View)localObject2));
      localObject5 = new e();
      localObject4 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).mkw;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("recyclerView");
        localObject2 = null;
      }
      ((e)localObject5).a((RecyclerView)localObject2);
      com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.3((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1));
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = com.tencent.mm.ui.component.k.d((AppCompatActivity)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).lzt).q(as.class);
      s.s(localObject2, "UICProvider.of(context).…rReporterUIC::class.java)");
      localObject5 = as.b((as)localObject2);
      if (localObject5 != null)
      {
        localObject4 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).mkw;
        localObject2 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("recyclerView");
          localObject2 = null;
        }
        ((com.tencent.mm.plugin.finder.event.base.f)localObject5).o((RecyclerView)localObject2);
      }
      localObject4 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).mkw;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("recyclerView");
        localObject2 = null;
      }
      if (!(localObject2 instanceof FinderRecyclerView)) {
        break label832;
      }
      localObject4 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).mkw;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("recyclerView");
        localObject2 = null;
      }
      if (!(((RecyclerView)localObject2).getLayoutManager() instanceof LinearLayoutManager)) {
        break label832;
      }
      localObject4 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).mkw;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("recyclerView");
        localObject2 = null;
      }
      localObject4 = (FinderRecyclerView)localObject2;
      localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).mkw;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("recyclerView");
        localObject1 = null;
      }
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      if (localObject1 != null) {
        break label823;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(167321);
      throw ((Throwable)localObject1);
      break;
      break label319;
      break label421;
    }
    label823:
    ((FinderRecyclerView)localObject4).a((LinearLayoutManager)localObject1);
    label832:
    localObject1 = this.EYa;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
      ((BaseFinderFeedLoader)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).EYf.EXX).register((com.tencent.mm.view.k)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).getRlLayout());
      localObject2 = this.EYf;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      localObject2 = this.EYa;
      if (localObject2 != null) {
        break label919;
      }
      s.bIx("viewCallback");
      localObject2 = localObject3;
    }
    label919:
    for (;;)
    {
      ((FinderLikedFeedContract.LikedTimelinePresenter)localObject1).a((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2);
      AppMethodBeat.o(167321);
      return;
      break;
    }
  }
  
  public final boolean isHideStatusBar()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(347999);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.view.f localf2 = this.ATy;
    com.tencent.mm.plugin.finder.view.f localf1 = localf2;
    if (localf2 == null)
    {
      s.bIx("drawer");
      localf1 = null;
    }
    localf1.g(paramInt1, paramIntent);
    AppMethodBeat.o(347999);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167324);
    goBack();
    AppMethodBeat.o(167324);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(167320);
    super.onCreate(paramBundle);
    this.username = z.bAM();
    Log.i(this.TAG, "username %s", new Object[] { this.username });
    initView();
    paramBundle = getWindow().getDecorView();
    s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
    getWindow().setStatusBarColor(0);
    getController().s((Activity)this, getResources().getColor(e.b.transparent));
    com.tencent.mm.ui.c.h((Activity)this, false);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    paramBundle = af.mU((Context)getContext());
    int i = e.f.finder_full_action_bar_layout;
    Object localObject2 = getBodyView();
    if (localObject2 == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(167320);
      throw paramBundle;
    }
    paramBundle.inflate(i, (ViewGroup)localObject2, true);
    i = bf.getStatusBarHeight((Context)this);
    ((FrameLayout)findViewById(e.e.full_actionbar)).setPadding(0, i, 0, 0);
    ((LinearLayout)findViewById(e.e.back_button)).setOnClickListener(new FinderLikedFeedUI..ExternalSyntheticLambda1(this));
    ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(8);
    paramBundle = com.tencent.mm.plugin.finder.utils.av.GiL;
    paramBundle = getWindow();
    s.s(paramBundle, "window");
    com.tencent.mm.plugin.finder.utils.av.d(paramBundle);
    setNavigationbarColor(getResources().getColor(e.b.black));
    ((FrameLayout)findViewById(e.e.full_actionbar)).setVisibility(0);
    localObject2 = this.ATx;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("rlLayout");
      paramBundle = null;
    }
    paramBundle.setBackgroundColor(getResources().getColor(e.b.full_black));
    paramBundle = this.EYa;
    if (paramBundle == null)
    {
      s.bIx("viewCallback");
      paramBundle = localObject1;
    }
    for (;;)
    {
      paramBundle.getRecyclerView().a((RecyclerView.l)this.FRd);
      paramBundle = (WeImageView)findViewById(e.e.backBtnIv);
      if (paramBundle != null) {
        paramBundle.setIconColor(getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_5));
      }
      AppMethodBeat.o(167320);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167322);
    Object localObject2 = this.ATy;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("drawer");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.view.f)localObject1).onDetach();
    super.onDestroy();
    localObject2 = this.EYa;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).getRecyclerView().b((RecyclerView.l)this.FRd);
    localObject1 = this.EYa;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    for (;;)
    {
      ((BaseFinderFeedLoader)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).EYf.EXX).unregister((com.tencent.mm.view.k)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).getRlLayout());
      ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).EYf.onDetach();
      AppMethodBeat.o(167322);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(178433);
    super.onPause();
    if (this.ATy == null) {
      s.bIx("drawer");
    }
    ce localce = (ce)h.ax(ce.class);
    FinderLikedFeedContract.LikedTimelineViewCallback localLikedTimelineViewCallback2 = this.EYa;
    FinderLikedFeedContract.LikedTimelineViewCallback localLikedTimelineViewCallback1 = localLikedTimelineViewCallback2;
    if (localLikedTimelineViewCallback2 == null)
    {
      s.bIx("viewCallback");
      localLikedTimelineViewCallback1 = null;
    }
    localce.b(localLikedTimelineViewCallback1.getRecyclerView(), q.w.DwQ, "2", com.tencent.mm.plugin.finder.live.report.d.Dng);
    AppMethodBeat.o(178433);
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(178432);
    super.onResume();
    Object localObject3 = this.ATy;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("drawer");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.view.f)localObject1).onUIResume();
    localObject3 = (ce)h.ax(ce.class);
    localObject1 = this.EYa;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ce)localObject3).b(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).getRecyclerView(), q.w.DwQ, "2", com.tencent.mm.plugin.finder.live.report.d.Dnf);
      AppMethodBeat.o(178432);
      return;
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(347947);
    s.u(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    FinderLikedFeedContract.LikedTimelinePresenter localLikedTimelinePresenter = this.EYf;
    paramBundle = localLikedTimelinePresenter;
    if (localLikedTimelinePresenter == null)
    {
      s.bIx("presenter");
      paramBundle = null;
    }
    BaseFeedLoader localBaseFeedLoader = (BaseFeedLoader)paramBundle.EXX;
    Intent localIntent = getIntent();
    s.s(localIntent, "intent");
    localLikedTimelinePresenter = this.EYf;
    paramBundle = localLikedTimelinePresenter;
    if (localLikedTimelinePresenter == null)
    {
      s.bIx("presenter");
      paramBundle = null;
    }
    BaseFeedLoader.saveCache$default(localBaseFeedLoader, localIntent, ((BaseFinderFeedLoader)paramBundle.EXX).getInitPos(), null, 4, null);
    AppMethodBeat.o(347947);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(346650);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      a.c("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(346650);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(346645);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      a.c("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ((ce)h.ax(ce.class)).b(paramRecyclerView, q.w.DwQ, "2", com.tencent.mm.plugin.finder.live.report.d.Dne);
      a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(346645);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI
 * JD-Core Version:    0.7.0.1
 */