package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.ah.b;
import com.tencent.mm.plugin.finder.feed.ah.c;
import com.tencent.mm.plugin.finder.feed.ah.c.b;
import com.tencent.mm.plugin.finder.feed.ah.c.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.viewmodel.component.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.al;
import com.tencent.mm.plugin.finder.viewmodel.component.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_UNFOLLOW", "TAG", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "avatarIv", "Landroid/widget/ImageView;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "isSelf", "", "likeDrawer", "mHellOnScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1;", "nickTv", "Landroid/widget/TextView;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "signatureTv", "subscribeBtn", "Landroid/widget/Button;", "topicId", "", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "fixActionBarStatus", "", "getCommentScene", "getLayoutId", "getReportType", "goBack", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "isHideStatusBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "overlayStatusBar", "refreshProfile", "plugin-finder_release"})
public final class FinderProfileTimeLineUI
  extends MMFinderUI
  implements com.tencent.mm.an.i
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean fCB;
  private ImageView jiu;
  private final com.tencent.mm.model.d kKI;
  private TextView mZA;
  private String username;
  private ah.b xAK;
  private ah.c xAo;
  private boolean xAy;
  private TextView xRH;
  private Button xRI;
  private final int xRJ;
  private final int xRK;
  private final int xRL;
  private final c xRM;
  private long xee;
  private final int xhI;
  private RefreshLoadMoreLayout xvJ;
  private com.tencent.mm.plugin.finder.view.f xvK;
  private FinderLikeDrawer xvL;
  private FinderLikeDrawer xvM;
  private final int xvk;
  
  public FinderProfileTimeLineUI()
  {
    AppMethodBeat.i(273285);
    this.TAG = "Finder.FinderProfileTimeLineUI";
    this.kKI = com.tencent.mm.model.d.bcs();
    this.xRJ = 10000;
    this.xhI = 10001;
    this.xRK = 10002;
    this.xRL = 10003;
    this.xvk = 10004;
    this.xRM = new c();
    AppMethodBeat.o(273285);
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(166145);
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
      AppMethodBeat.o(166145);
      return;
    }
    localObject = this.xvL;
    if (localObject == null) {
      p.bGy("likeDrawer");
    }
    if (((FinderLikeDrawer)localObject).eis())
    {
      localObject = this.xvL;
      if (localObject == null) {
        p.bGy("likeDrawer");
      }
      ((FinderLikeDrawer)localObject).eir();
      AppMethodBeat.o(166145);
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
      AppMethodBeat.o(166145);
      return;
    }
    finish();
    AppMethodBeat.o(166145);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(273289);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(273289);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(273288);
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
    AppMethodBeat.o(273288);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    int j = 0;
    AppMethodBeat.i(273283);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (p.h(str, z.bdh()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(273283);
      return 8;
    }
    AppMethodBeat.o(273283);
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_profile_timeline_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(273279);
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy())
    {
      localObject = ak.setOf(new Class[] { ab.class, an.class, al.class });
      AppMethodBeat.o(273279);
      return localObject;
    }
    AppMethodBeat.o(273279);
    return null;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(166143);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject1 = this.username;
    if (localObject1 == null) {
      p.iCn();
    }
    com.tencent.mm.plugin.finder.api.i locali = d.a.aAK((String)localObject1);
    if (locali != null)
    {
      localObject2 = locali.getNickname();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    setMMTitle((String)localObject1);
    localObject1 = getLayoutInflater().inflate(b.g.finder_user_header, null);
    Object localObject2 = ((View)localObject1).findViewById(b.f.avatar_iv);
    p.j(localObject2, "header.findViewById(R.id.avatar_iv)");
    this.jiu = ((ImageView)localObject2);
    localObject2 = ((View)localObject1).findViewById(b.f.nick_tv);
    p.j(localObject2, "header.findViewById(R.id.nick_tv)");
    this.mZA = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(b.f.signature_tv);
    p.j(localObject2, "header.findViewById(R.id.signature_tv)");
    this.xRH = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(b.f.subscribe_btn);
    p.j(localObject2, "header.findViewById(R.id.subscribe_btn)");
    this.xRI = ((Button)localObject2);
    localObject2 = findViewById(b.f.rl_layout);
    p.j(localObject2, "findViewById(R.id.rl_layout)");
    this.xvJ = ((RefreshLoadMoreLayout)localObject2);
    localObject1 = ((View)localObject1).findViewById(b.f.divider_item);
    p.j(localObject1, "header.findViewById<ImageView>(R.id.divider_item)");
    ((ImageView)localObject1).setVisibility(0);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    localObject1 = t.ztT;
    Object localObject3 = t.dJh();
    if (locali != null)
    {
      localObject2 = locali.Mm();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localObject1 = new e((String)localObject1);
    localObject2 = this.jiu;
    if (localObject2 == null) {
      p.bGy("avatarIv");
    }
    t localt = t.ztT;
    ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject2, t.a(t.a.ztX));
    localObject1 = com.tencent.mm.plugin.finder.view.f.AVu;
    localObject1 = (MMFragmentActivity)this;
    localObject2 = getWindow();
    p.j(localObject2, "window");
    localObject2 = ((Window)localObject2).getDecorView();
    p.j(localObject2, "window.decorView");
    int i;
    if (this.fCB)
    {
      i = 1;
      this.xvK = f.a.a((MMFragmentActivity)localObject1, (View)localObject2, i, false, 0, 24);
      localObject1 = (MMActivity)this;
      localObject2 = this.xvK;
      if (localObject2 == null) {
        p.bGy("drawer");
      }
      localObject3 = this.username;
      if (localObject3 == null) {
        p.iCn();
      }
      this.xAK = new ah.b((MMActivity)localObject1, (com.tencent.mm.plugin.finder.view.f)localObject2, (String)localObject3, this.xAy, this.xee);
      localObject1 = (MMActivity)this;
      localObject2 = this.xAK;
      if (localObject2 == null) {
        p.bGy("presenter");
      }
      localObject1 = new ah.c((MMActivity)localObject1, (ah.b)localObject2);
      localObject2 = this.xAK;
      if (localObject2 == null) {
        p.bGy("presenter");
      }
      ((ah.b)localObject2).a((ah.c)localObject1);
      localObject2 = ((ah.c)localObject1).xvJ;
      if (localObject2 == null) {
        p.bGy("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject2).setActionCallback((RefreshLoadMoreLayout.a)new ah.c.b((ah.c)localObject1));
      if (!((ah.c)localObject1).xAM)
      {
        localObject2 = ((ah.c)localObject1).jLl;
        if (localObject2 == null) {
          p.bGy("recyclerView");
        }
        ((RecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getColor(b.c.BW_93)), (int)c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getDimension(b.d.feed_divider)));
      }
      com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (kotlin.g.a.b)new ah.c.c((ah.c)localObject1));
      localObject2 = g.Xox;
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.d((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)((ah.c)localObject1).iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class));
      if (localObject2 != null)
      {
        localObject3 = ((ah.c)localObject1).jLl;
        if (localObject3 == null) {
          p.bGy("recyclerView");
        }
        ((com.tencent.mm.plugin.finder.event.base.f)localObject2).k((RecyclerView)localObject3);
      }
      ((BaseFinderFeedLoader)((ah.c)localObject1).xAK.getFeedLoader()).register(((ah.c)localObject1).xvV);
      this.xAo = ((ah.c)localObject1);
      localObject1 = FinderLikeDrawer.AYs;
      localObject1 = (Context)this;
      localObject2 = getWindow();
      p.j(localObject2, "window");
      localObject3 = FinderLikeDrawer.AYs;
      this.xvL = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.eiP());
      localObject1 = FinderLikeDrawer.AYs;
      localObject1 = getContext();
      p.j(localObject1, "context");
      localObject1 = (Context)localObject1;
      localObject2 = getWindow();
      p.j(localObject2, "this@FinderProfileTimeLineUI.window");
      localObject3 = FinderLikeDrawer.AYs;
      this.xvM = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.eiO());
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy())
      {
        localObject1 = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
        p.j(localObject1, "full_actionbar");
        ((FrameLayout)localObject1).setVisibility(0);
        ((LinearLayout)_$_findCachedViewById(b.f.back_button)).setOnClickListener((View.OnClickListener)new b(this));
        localObject2 = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
        p.j(localObject2, "full_action_bar_title");
        localObject3 = (Context)getContext();
        if (locali == null) {
          break label1168;
        }
        localObject1 = locali.getNickname();
        if (localObject1 == null) {
          break label1168;
        }
      }
    }
    label1168:
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)localObject1));
      localObject1 = getWindow();
      p.j(localObject1, "window");
      localObject1 = ((Window)localObject1).getDecorView();
      p.j(localObject1, "window.decorView");
      ((View)localObject1).setSystemUiVisibility(((View)localObject1).getSystemUiVisibility() | 0x400 | 0x100);
      localObject1 = getWindow();
      p.j(localObject1, "window");
      ((Window)localObject1).setStatusBarColor(0);
      getController().q((Activity)this, getResources().getColor(b.c.transparent));
      com.tencent.mm.ui.c.f((Activity)this, false);
      localObject1 = getSupportActionBar();
      if (localObject1 != null)
      {
        ((ActionBar)localObject1).setBackgroundDrawable((Drawable)new ColorDrawable(0));
        ((ActionBar)localObject1).hide();
      }
      i = ax.getStatusBarHeight((Context)this);
      localObject1 = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
      p.j(localObject1, "full_actionbar");
      localObject1 = ((FrameLayout)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height += i;
      localObject2 = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
      p.j(localObject2, "full_actionbar");
      ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((FrameLayout)_$_findCachedViewById(b.f.full_actionbar)).setPadding(0, i, 0, 0);
      getController().updataStatusBarIcon(true);
      setNavigationbarColor(-16777216);
      ((CoordinatorLayout)_$_findCachedViewById(b.f.rl_container)).setBackgroundColor(getResources().getColor(b.c.full_black));
      localObject1 = this.xvJ;
      if (localObject1 == null) {
        p.bGy("rlLayout");
      }
      localObject2 = ad.kS((Context)getContext()).inflate(b.g.load_more_footer_dark, null);
      p.j(localObject2, "MMLayoutInflater.getInfl…d_more_footer_dark, null)");
      ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
      localObject1 = (WeImageView)findViewById(b.f.backBtnIv);
      if (localObject1 == null) {
        break label1178;
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_5));
      AppMethodBeat.o(166143);
      return;
      i = 2;
      break;
    }
    label1178:
    AppMethodBeat.o(166143);
  }
  
  public final boolean isHideStatusBar()
  {
    AppMethodBeat.i(273280);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy();
    AppMethodBeat.o(273280);
    return bool;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(273282);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.view.f localf = this.xvK;
    if (localf == null) {
      p.bGy("drawer");
    }
    localf.d(paramInt1, paramIntent);
    AppMethodBeat.o(273282);
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
    this.xAy = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    this.xee = getIntent().getLongExtra("KEY_FROM_TOPIC_ID", 0L);
    Log.i(this.TAG, "username " + this.username + ", selfFlag " + this.xAy + ", topicId " + this.xee);
    if (Util.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(166142);
      return;
    }
    paramBundle = this.username;
    if (paramBundle != null) {}
    for (boolean bool1 = paramBundle.equals(z.bdh());; bool1 = false)
    {
      boolean bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (this.xAy) {
          bool2 = true;
        }
      }
      this.fCB = bool2;
      initView();
      paramBundle = this.xAo;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getRecyclerView();
        if (paramBundle != null) {
          paramBundle.a((RecyclerView.l)this.xRM);
        }
      }
      if (!getIntent().hasExtra("key_extra_info")) {
        break;
      }
      long l = getIntent().getLongExtra("KEY_FINDER_FEEDID", 0L);
      paramBundle = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle = aj.a.fZ((Context)paramBundle);
      if (paramBundle == null) {
        break;
      }
      paramBundle.z(l, this.username);
      AppMethodBeat.o(166142);
      return;
    }
    AppMethodBeat.o(166142);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166150);
    Object localObject = this.xAo;
    if (localObject != null)
    {
      localObject = ((ah.c)localObject).getRecyclerView();
      if (localObject != null) {
        ((RecyclerView)localObject).b((RecyclerView.l)this.xRM);
      }
    }
    if (((FinderProfileTimeLineUI)this).xvK != null)
    {
      localObject = this.xvK;
      if (localObject == null) {
        p.bGy("drawer");
      }
      ((com.tencent.mm.plugin.finder.view.f)localObject).onDetach();
    }
    super.onDestroy();
    localObject = this.xAo;
    if (localObject != null)
    {
      ((BaseFinderFeedLoader)((ah.c)localObject).xAK.getFeedLoader()).unregister(((ah.c)localObject).xvV);
      ((ah.c)localObject).xAK.onDetach();
      ((ah.c)localObject).getRecyclerView().setAdapter(null);
      AppMethodBeat.o(166150);
      return;
    }
    AppMethodBeat.o(166150);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166149);
    super.onPause();
    Object localObject = k.yBj;
    localObject = this.xAo;
    if (localObject != null) {}
    for (localObject = ((ah.c)localObject).getRecyclerView();; localObject = null)
    {
      k.b((RecyclerView)localObject, s.t.yGN, "1", com.tencent.mm.plugin.finder.live.report.c.yAj);
      if (this.xvK == null) {
        p.bGy("drawer");
      }
      this.kKI.avz();
      AppMethodBeat.o(166149);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166148);
    super.onResume();
    Object localObject1 = com.tencent.mm.plugin.finder.convert.d.xgJ;
    Object localObject2 = this.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    com.tencent.mm.plugin.finder.convert.d.aAZ((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject1 = this.username;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = d.a.aAK((String)localObject1);
    if (localObject1 != null)
    {
      localObject2 = this.mZA;
      if (localObject2 == null) {
        p.bGy("nickTv");
      }
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.i)localObject1).getNickname()));
      localObject2 = this.xRH;
      if (localObject2 == null) {
        p.bGy("signatureTv");
      }
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.i)localObject1).field_signature));
      localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
      if (d.a.aAN(((com.tencent.mm.plugin.finder.api.i)localObject1).getUsername()))
      {
        localObject1 = this.xRI;
        if (localObject1 == null) {
          p.bGy("subscribeBtn");
        }
        ((Button)localObject1).setText(b.j.has_follow_tip);
        localObject1 = this.xRI;
        if (localObject1 == null) {
          p.bGy("subscribeBtn");
        }
        ((Button)localObject1).setBackgroundResource(b.e.transparent_background);
        localObject1 = this.xRI;
        if (localObject1 == null) {
          p.bGy("subscribeBtn");
        }
        ((Button)localObject1).setTextColor(getResources().getColor(b.c.link_color_selector));
        localObject1 = this.xRI;
        if (localObject1 == null) {
          p.bGy("subscribeBtn");
        }
        ((Button)localObject1).setOnClickListener((View.OnClickListener)FinderProfileTimeLineUI.d.xRO);
      }
    }
    else
    {
      localObject1 = this.xvK;
      if (localObject1 == null) {
        p.bGy("drawer");
      }
      ((com.tencent.mm.plugin.finder.view.f)localObject1).onUIResume();
      localObject1 = k.yBj;
      localObject1 = this.xAo;
      if (localObject1 == null) {
        break label410;
      }
    }
    label410:
    for (localObject1 = ((ah.c)localObject1).getRecyclerView();; localObject1 = null)
    {
      k.b((RecyclerView)localObject1, s.t.yGN, "1", com.tencent.mm.plugin.finder.live.report.c.yAi);
      com.tencent.mm.model.d.a(this.kKI, this.TAG);
      AppMethodBeat.o(166148);
      return;
      localObject1 = this.xRI;
      if (localObject1 == null) {
        p.bGy("subscribeBtn");
      }
      ((Button)localObject1).setText(b.j.finder_follow);
      localObject1 = this.xRI;
      if (localObject1 == null) {
        p.bGy("subscribeBtn");
      }
      ((Button)localObject1).setTextColor(getResources().getColor(b.c.white_text_color));
      localObject1 = this.xRI;
      if (localObject1 == null) {
        p.bGy("subscribeBtn");
      }
      ((Button)localObject1).setBackgroundResource(b.e.btn_solid_green_small);
      localObject1 = this.xRI;
      if (localObject1 == null) {
        p.bGy("subscribeBtn");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)FinderProfileTimeLineUI.e.xRP);
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderProfileTimeLineUI paramFinderProfileTimeLineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166131);
      FinderProfileTimeLineUI.a(this.xRN);
      AppMethodBeat.o(166131);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderProfileTimeLineUI paramFinderProfileTimeLineUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291387);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xRN.onBackPressed();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291387);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(266588);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(266588);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(266587);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGN, "1", com.tencent.mm.plugin.finder.live.report.c.yAh);
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(266587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI
 * JD-Core Version:    0.7.0.1
 */