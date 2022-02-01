package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.ab.b;
import com.tencent.mm.plugin.finder.feed.ab.c;
import com.tencent.mm.plugin.finder.feed.ab.c.b;
import com.tencent.mm.plugin.finder.feed.ab.c.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.t;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_UNFOLLOW", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "isSelf", "", "likeDrawer", "mHellOnScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1;", "nickTv", "Landroid/widget/TextView;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "signatureTv", "subscribeBtn", "Landroid/widget/Button;", "topicId", "", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "fixActionBarStatus", "", "getCommentScene", "getLayoutId", "getReportType", "goBack", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "isHideStatusBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "overlayStatusBar", "refreshProfile", "plugin-finder_release"})
public final class FinderProfileTimeLineUI
  extends MMFinderUI
  implements i
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean dJM;
  private ImageView gyr;
  private TextView kib;
  private final int pMa;
  private RefreshLoadMoreLayout tLS;
  private e tLT;
  private FinderLikeDrawer tLU;
  private FinderLikeDrawer tLV;
  private boolean tPH;
  private ab.b tPU;
  private ab.c tPx;
  private long twp;
  private final int tzW;
  private TextView ucr;
  private Button ucs;
  private final int uct;
  private final int ucu;
  private final int ucv;
  private final c ucw;
  private String username;
  
  public FinderProfileTimeLineUI()
  {
    AppMethodBeat.i(245486);
    this.TAG = "Finder.FinderProfileTimeLineUI";
    this.uct = 10000;
    this.tzW = 10001;
    this.ucu = 10002;
    this.ucv = 10003;
    this.pMa = 10004;
    this.ucw = new c();
    AppMethodBeat.o(245486);
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(166145);
    Object localObject = this.tLT;
    if (localObject == null) {
      p.btv("drawer");
    }
    if (((e)localObject).dGs())
    {
      localObject = this.tLT;
      if (localObject == null) {
        p.btv("drawer");
      }
      ((e)localObject).dGr();
      AppMethodBeat.o(166145);
      return;
    }
    localObject = this.tLU;
    if (localObject == null) {
      p.btv("likeDrawer");
    }
    if (((FinderLikeDrawer)localObject).dGs())
    {
      localObject = this.tLU;
      if (localObject == null) {
        p.btv("likeDrawer");
      }
      ((FinderLikeDrawer)localObject).dGr();
      AppMethodBeat.o(166145);
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
      AppMethodBeat.o(166145);
      return;
    }
    finish();
    AppMethodBeat.o(166145);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245488);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245488);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245487);
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
    AppMethodBeat.o(245487);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    int j = 0;
    AppMethodBeat.i(245485);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (p.j(str, z.aUg()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(245485);
      return 8;
    }
    AppMethodBeat.o(245485);
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131494598;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245482);
    Object localObject = y.vXH;
    if (y.isOtherEnableFullScreenEnjoy())
    {
      localObject = ak.setOf(FinderHorizontalVideoPreviewUIC.class);
      AppMethodBeat.o(245482);
      return localObject;
    }
    AppMethodBeat.o(245482);
    return null;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(166143);
    Object localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
    localObject1 = this.username;
    if (localObject1 == null) {
      p.hyc();
    }
    g localg = com.tencent.mm.plugin.finder.api.c.a.asG((String)localObject1);
    if (localg != null)
    {
      localObject2 = localg.getNickname();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    setMMTitle((String)localObject1);
    localObject1 = getLayoutInflater().inflate(2131494668, null);
    Object localObject2 = ((View)localObject1).findViewById(2131297134);
    p.g(localObject2, "header.findViewById(R.id.avatar_iv)");
    this.gyr = ((ImageView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131305434);
    p.g(localObject2, "header.findViewById(R.id.nick_tv)");
    this.kib = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131307906);
    p.g(localObject2, "header.findViewById(R.id.signature_tv)");
    this.ucr = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131308736);
    p.g(localObject2, "header.findViewById(R.id.subscribe_btn)");
    this.ucs = ((Button)localObject2);
    localObject2 = findViewById(2131307118);
    p.g(localObject2, "findViewById(R.id.rl_layout)");
    this.tLS = ((RefreshLoadMoreLayout)localObject2);
    localObject1 = ((View)localObject1).findViewById(2131299706);
    p.g(localObject1, "header.findViewById<ImageView>(R.id.divider_item)");
    ((ImageView)localObject1).setVisibility(0);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    localObject1 = m.uJa;
    Object localObject3 = m.dka();
    if (localg != null)
    {
      localObject2 = localg.cXH();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
    localObject2 = this.gyr;
    if (localObject2 == null) {
      p.btv("avatarIv");
    }
    m localm = m.uJa;
    ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject2, m.a(m.a.uJe));
    localObject1 = e.wky;
    localObject1 = (MMFragmentActivity)this;
    localObject2 = getWindow();
    p.g(localObject2, "window");
    localObject2 = ((Window)localObject2).getDecorView();
    p.g(localObject2, "window.decorView");
    int i;
    if (this.dJM)
    {
      i = 1;
      this.tLT = e.a.a((MMFragmentActivity)localObject1, (View)localObject2, i, false, 0, 24);
      localObject1 = (MMActivity)this;
      localObject2 = this.tLT;
      if (localObject2 == null) {
        p.btv("drawer");
      }
      localObject3 = this.username;
      if (localObject3 == null) {
        p.hyc();
      }
      this.tPU = new ab.b((MMActivity)localObject1, (e)localObject2, (String)localObject3, this.tPH, this.twp);
      localObject1 = (MMActivity)this;
      localObject2 = this.tPU;
      if (localObject2 == null) {
        p.btv("presenter");
      }
      localObject1 = new ab.c((MMActivity)localObject1, (ab.b)localObject2);
      localObject2 = this.tPU;
      if (localObject2 == null) {
        p.btv("presenter");
      }
      ((ab.b)localObject2).a((ab.c)localObject1);
      localObject2 = ((ab.c)localObject1).tLS;
      if (localObject2 == null) {
        p.btv("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject2).setActionCallback((RefreshLoadMoreLayout.a)new ab.c.b((ab.c)localObject1));
      if (!((ab.c)localObject1).tPW)
      {
        localObject2 = ((ab.c)localObject1).hak;
        if (localObject2 == null) {
          p.btv("recyclerView");
        }
        ((RecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(com.tencent.mm.plugin.finder.presenter.base.c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getColor(2131099689)), (int)com.tencent.mm.plugin.finder.presenter.base.c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getDimension(2131166341)));
      }
      com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), (kotlin.g.a.b)new ab.c.c((ab.c)localObject1));
      localObject2 = com.tencent.mm.ui.component.a.PRN;
      localObject2 = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)((ab.c)localObject1).gte).get(FinderReporterUIC.class));
      if (localObject2 != null)
      {
        localObject3 = ((ab.c)localObject1).hak;
        if (localObject3 == null) {
          p.btv("recyclerView");
        }
        ((f)localObject2).m((RecyclerView)localObject3);
      }
      ((BaseFinderFeedLoader)((ab.c)localObject1).tPU.getFeedLoader()).register(((ab.c)localObject1).tMe);
      this.tPx = ((ab.c)localObject1);
      localObject1 = FinderLikeDrawer.wnm;
      localObject1 = (Context)this;
      localObject2 = getWindow();
      p.g(localObject2, "window");
      localObject3 = FinderLikeDrawer.wnm;
      this.tLU = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.dGQ());
      localObject1 = FinderLikeDrawer.wnm;
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = (Context)localObject1;
      localObject2 = getWindow();
      p.g(localObject2, "this@FinderProfileTimeLineUI.window");
      localObject3 = FinderLikeDrawer.wnm;
      this.tLV = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.dGP());
      localObject1 = y.vXH;
      if (y.isOtherEnableFullScreenEnjoy())
      {
        localObject1 = (FrameLayout)_$_findCachedViewById(2131301815);
        p.g(localObject1, "full_actionbar");
        ((FrameLayout)localObject1).setVisibility(0);
        ((LinearLayout)_$_findCachedViewById(2131297164)).setOnClickListener((View.OnClickListener)new b(this));
        localObject2 = (TextView)_$_findCachedViewById(2131301814);
        p.g(localObject2, "full_action_bar_title");
        localObject3 = (Context)getContext();
        if (localg == null) {
          break label1094;
        }
        localObject1 = localg.getNickname();
        if (localObject1 == null) {
          break label1094;
        }
      }
    }
    label1094:
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)localObject1));
      localObject1 = getWindow();
      p.g(localObject1, "window");
      localObject1 = ((Window)localObject1).getDecorView();
      p.g(localObject1, "window.decorView");
      ((View)localObject1).setSystemUiVisibility(((View)localObject1).getSystemUiVisibility() | 0x400 | 0x100);
      localObject1 = getWindow();
      p.g(localObject1, "window");
      ((Window)localObject1).setStatusBarColor(0);
      getController().p((Activity)this, getResources().getColor(2131101287));
      com.tencent.mm.ui.b.e((Activity)this, false);
      localObject1 = getSupportActionBar();
      if (localObject1 != null)
      {
        ((ActionBar)localObject1).setBackgroundDrawable((Drawable)new ColorDrawable(0));
        ((ActionBar)localObject1).hide();
      }
      i = au.getStatusBarHeight((Context)this);
      localObject1 = (FrameLayout)_$_findCachedViewById(2131301815);
      p.g(localObject1, "full_actionbar");
      localObject1 = ((FrameLayout)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height += i;
      localObject2 = (FrameLayout)_$_findCachedViewById(2131301815);
      p.g(localObject2, "full_actionbar");
      ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((FrameLayout)_$_findCachedViewById(2131301815)).setPadding(0, i, 0, 0);
      getController().updataStatusBarIcon(true);
      setNavigationbarColor(-16777216);
      ((CoordinatorLayout)_$_findCachedViewById(2131307117)).setBackgroundColor(getResources().getColor(2131100495));
      AppMethodBeat.o(166143);
      return;
      i = 2;
      break;
    }
  }
  
  public final boolean isHideStatusBar()
  {
    AppMethodBeat.i(245483);
    y localy = y.vXH;
    boolean bool = y.isOtherEnableFullScreenEnjoy();
    AppMethodBeat.o(245483);
    return bool;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(245484);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    e locale = this.tLT;
    if (locale == null) {
      p.btv("drawer");
    }
    locale.d(paramInt1, paramIntent);
    AppMethodBeat.o(245484);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(166146);
    goBack();
    AppMethodBeat.o(166146);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    boolean bool3 = false;
    AppMethodBeat.i(166142);
    super.onCreate(paramBundle);
    this.username = getIntent().getStringExtra("finder_username");
    this.tPH = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    this.twp = getIntent().getLongExtra("KEY_FROM_TOPIC_ID", 0L);
    Log.i(this.TAG, "username " + this.username + ", selfFlag " + this.tPH + ", topicId " + this.twp);
    if (Util.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(166142);
      return;
    }
    paramBundle = this.username;
    if (paramBundle != null) {}
    for (boolean bool1 = paramBundle.equals(z.aUg());; bool1 = false)
    {
      boolean bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (this.tPH) {
          bool2 = true;
        }
      }
      this.dJM = bool2;
      initView();
      paramBundle = this.tPx;
      if (paramBundle == null) {
        break;
      }
      paramBundle = paramBundle.getRecyclerView();
      if (paramBundle == null) {
        break;
      }
      paramBundle.a((RecyclerView.l)this.ucw);
      AppMethodBeat.o(166142);
      return;
    }
    AppMethodBeat.o(166142);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166150);
    Object localObject = this.tPx;
    if (localObject != null)
    {
      localObject = ((ab.c)localObject).getRecyclerView();
      if (localObject != null) {
        ((RecyclerView)localObject).b((RecyclerView.l)this.ucw);
      }
    }
    if (((FinderProfileTimeLineUI)this).tLT != null)
    {
      localObject = this.tLT;
      if (localObject == null) {
        p.btv("drawer");
      }
      ((e)localObject).onDetach();
    }
    super.onDestroy();
    localObject = this.tPx;
    if (localObject != null)
    {
      ((BaseFinderFeedLoader)((ab.c)localObject).tPU.getFeedLoader()).unregister(((ab.c)localObject).tMe);
      ((ab.c)localObject).tPU.onDetach();
      ((ab.c)localObject).getRecyclerView().setAdapter(null);
      AppMethodBeat.o(166150);
      return;
    }
    AppMethodBeat.o(166150);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166149);
    super.onPause();
    Object localObject = k.vkd;
    localObject = this.tPx;
    if (localObject != null) {}
    for (localObject = ((ab.c)localObject).getRecyclerView();; localObject = null)
    {
      k.b((RecyclerView)localObject, s.p.voA, "1", com.tencent.mm.plugin.finder.report.live.c.vjg);
      if (this.tLT == null) {
        p.btv("drawer");
      }
      AppMethodBeat.o(166149);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166148);
    super.onResume();
    Object localObject1 = com.tencent.mm.plugin.finder.convert.d.tyZ;
    Object localObject2 = this.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    com.tencent.mm.plugin.finder.convert.d.asR((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
    localObject1 = this.username;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = com.tencent.mm.plugin.finder.api.c.a.asG((String)localObject1);
    if (localObject1 != null)
    {
      localObject2 = this.kib;
      if (localObject2 == null) {
        p.btv("nickTv");
      }
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this, (CharSequence)((g)localObject1).getNickname()));
      localObject2 = this.ucr;
      if (localObject2 == null) {
        p.btv("signatureTv");
      }
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this, (CharSequence)((g)localObject1).field_signature));
      localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
      if (com.tencent.mm.plugin.finder.api.c.a.asJ(((g)localObject1).getUsername()))
      {
        localObject1 = this.ucs;
        if (localObject1 == null) {
          p.btv("subscribeBtn");
        }
        ((Button)localObject1).setText(2131761616);
        localObject1 = this.ucs;
        if (localObject1 == null) {
          p.btv("subscribeBtn");
        }
        ((Button)localObject1).setBackgroundResource(2131235359);
        localObject1 = this.ucs;
        if (localObject1 == null) {
          p.btv("subscribeBtn");
        }
        ((Button)localObject1).setTextColor(getResources().getColor(2131100688));
        localObject1 = this.ucs;
        if (localObject1 == null) {
          p.btv("subscribeBtn");
        }
        ((Button)localObject1).setOnClickListener((View.OnClickListener)FinderProfileTimeLineUI.d.ucy);
      }
    }
    else
    {
      localObject1 = this.tLT;
      if (localObject1 == null) {
        p.btv("drawer");
      }
      ((e)localObject1).onUIResume();
      localObject1 = k.vkd;
      localObject1 = this.tPx;
      if (localObject1 == null) {
        break label399;
      }
    }
    label399:
    for (localObject1 = ((ab.c)localObject1).getRecyclerView();; localObject1 = null)
    {
      k.b((RecyclerView)localObject1, s.p.voA, "1", com.tencent.mm.plugin.finder.report.live.c.vjf);
      AppMethodBeat.o(166148);
      return;
      localObject1 = this.ucs;
      if (localObject1 == null) {
        p.btv("subscribeBtn");
      }
      ((Button)localObject1).setText(2131759774);
      localObject1 = this.ucs;
      if (localObject1 == null) {
        p.btv("subscribeBtn");
      }
      ((Button)localObject1).setTextColor(getResources().getColor(2131101427));
      localObject1 = this.ucs;
      if (localObject1 == null) {
        p.btv("subscribeBtn");
      }
      ((Button)localObject1).setBackgroundResource(2131231430);
      localObject1 = this.ucs;
      if (localObject1 == null) {
        p.btv("subscribeBtn");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)FinderProfileTimeLineUI.e.ucz);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(166147);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(166147);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderProfileTimeLineUI paramFinderProfileTimeLineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166131);
      FinderProfileTimeLineUI.a(this.ucx);
      AppMethodBeat.o(166131);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderProfileTimeLineUI paramFinderProfileTimeLineUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245475);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.ucx.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245475);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(245477);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(245477);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(245476);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.vkd;
      k.b(paramRecyclerView, s.p.voA, "1", com.tencent.mm.plugin.finder.report.live.c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(245476);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI
 * JD-Core Version:    0.7.0.1
 */