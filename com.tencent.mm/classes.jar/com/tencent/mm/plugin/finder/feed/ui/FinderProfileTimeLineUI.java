package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.feed.f.b;
import com.tencent.mm.plugin.finder.feed.f.c;
import com.tencent.mm.plugin.finder.feed.f.c.b;
import com.tencent.mm.plugin.finder.feed.f.c.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader.Companion;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import d.l;
import d.v;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_UNFOLLOW", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "cacheKey", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "isSelf", "", "jumpPosition", "likeDrawer", "nickTv", "Landroid/widget/TextView;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "signatureTv", "subscribeBtn", "Landroid/widget/Button;", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "getCommentScene", "getLayoutId", "getReportType", "goBack", "", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshProfile", "plugin-finder_release"})
public final class FinderProfileTimeLineUI
  extends MMFinderUI
  implements g
{
  private com.tencent.mm.plugin.finder.view.f KMN;
  private FinderLikeDrawer KMO;
  private FinderLikeDrawer KMP;
  private final String TAG = "Finder.FinderProfileTimeLineUI";
  private HashMap _$_findViewCache;
  private String cacheKey = "";
  private boolean diE;
  private ImageView fuj;
  private TextView inR;
  private final int nmp = 10004;
  private final int qqA = 10001;
  private RefreshLoadMoreLayout quj;
  private boolean qvC;
  private f.b qvM;
  private f.c qvw;
  private TextView qzF;
  private Button qzG;
  private int qzH;
  private final int qzI = 10000;
  private final int qzJ = 10002;
  private final int qzK = 10003;
  private String username;
  
  private final void goBack()
  {
    AppMethodBeat.i(166145);
    Object localObject = this.KMN;
    if (localObject == null) {
      d.g.b.k.aPZ("drawer");
    }
    if (((com.tencent.mm.plugin.finder.view.f)localObject).fiQ())
    {
      localObject = this.KMN;
      if (localObject == null) {
        d.g.b.k.aPZ("drawer");
      }
      ((com.tencent.mm.plugin.finder.view.f)localObject).csJ();
      AppMethodBeat.o(166145);
      return;
    }
    localObject = this.KMO;
    if (localObject == null) {
      d.g.b.k.aPZ("likeDrawer");
    }
    if (((FinderLikeDrawer)localObject).fiQ())
    {
      localObject = this.KMO;
      if (localObject == null) {
        d.g.b.k.aPZ("likeDrawer");
      }
      ((FinderLikeDrawer)localObject).csJ();
      AppMethodBeat.o(166145);
      return;
    }
    localObject = this.KMP;
    if (localObject == null) {
      d.g.b.k.aPZ("friendLikeDrawer");
    }
    if (((FinderLikeDrawer)localObject).fiQ())
    {
      localObject = this.KMP;
      if (localObject == null) {
        d.g.b.k.aPZ("friendLikeDrawer");
      }
      ((FinderLikeDrawer)localObject).csJ();
      AppMethodBeat.o(166145);
      return;
    }
    finish();
    AppMethodBeat.o(166145);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198533);
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
    AppMethodBeat.o(198533);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    int j = 0;
    AppMethodBeat.i(198532);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (d.g.b.k.g(str, u.aqO()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(198532);
      return 8;
    }
    AppMethodBeat.o(198532);
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131494099;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(166143);
    Object localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.k.fvU();
    }
    Object localObject3 = com.tencent.mm.plugin.finder.api.b.a.YL((String)localObject1);
    if (localObject3 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.api.f)localObject3).Su();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    setMMTitle((String)localObject1);
    localObject1 = getLayoutInflater().inflate(2131494124, null);
    Object localObject2 = ((View)localObject1).findViewById(2131297008);
    d.g.b.k.g(localObject2, "header.findViewById(R.id.avatar_iv)");
    this.fuj = ((ImageView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131302861);
    d.g.b.k.g(localObject2, "header.findViewById(R.id.nick_tv)");
    this.inR = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131304823);
    d.g.b.k.g(localObject2, "header.findViewById(R.id.signature_tv)");
    this.qzF = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131305519);
    d.g.b.k.g(localObject2, "header.findViewById(R.id.subscribe_btn)");
    this.qzG = ((Button)localObject2);
    localObject2 = findViewById(2131304203);
    d.g.b.k.g(localObject2, "findViewById(R.id.rl_layout)");
    this.quj = ((RefreshLoadMoreLayout)localObject2);
    localObject1 = ((View)localObject1).findViewById(2131299162);
    d.g.b.k.g(localObject1, "header.findViewById<ImageView>(R.id.divider_item)");
    ((ImageView)localObject1).setVisibility(0);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    localObject1 = h.qCF;
    d locald = h.cmV();
    if (localObject3 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.api.f)localObject3).cks();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
    localObject2 = this.fuj;
    if (localObject2 == null) {
      d.g.b.k.aPZ("avatarIv");
    }
    localObject3 = h.qCF;
    locald.a(localObject1, (ImageView)localObject2, h.a(h.a.qCI));
    localObject1 = com.tencent.mm.plugin.finder.view.f.LeE;
    localObject1 = (MMActivity)this;
    localObject2 = getWindow();
    d.g.b.k.g(localObject2, "window");
    localObject2 = ((Window)localObject2).getDecorView();
    d.g.b.k.g(localObject2, "window.decorView");
    if (this.diE) {}
    for (int i = 1;; i = 2)
    {
      this.KMN = f.a.a((MMActivity)localObject1, (View)localObject2, i, false);
      localObject1 = (MMActivity)this;
      localObject2 = this.KMN;
      if (localObject2 == null) {
        d.g.b.k.aPZ("drawer");
      }
      localObject3 = this.username;
      if (localObject3 == null) {
        d.g.b.k.fvU();
      }
      this.qvM = new f.b((MMActivity)localObject1, (com.tencent.mm.plugin.finder.view.f)localObject2, (String)localObject3, this.qzH, this.qvC, this.cacheKey);
      localObject1 = (MMActivity)this;
      localObject2 = this.qvM;
      if (localObject2 == null) {
        d.g.b.k.aPZ("presenter");
      }
      this.qvw = new f.c((MMActivity)localObject1, (f.b)localObject2, this.qzH);
      localObject1 = this.qvM;
      if (localObject1 == null) {
        d.g.b.k.aPZ("presenter");
      }
      localObject2 = this.qvw;
      if (localObject2 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      ((f.b)localObject1).a((f.c)localObject2);
      localObject1 = this.qvw;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject2 = ((f.c)localObject1).quj;
      if (localObject2 == null) {
        d.g.b.k.aPZ("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject2).setActionCallback((RefreshLoadMoreLayout.a)new f.c.b((f.c)localObject1));
      localObject2 = ((f.c)localObject1).fPw;
      if (localObject2 == null) {
        d.g.b.k.aPZ("recyclerView");
      }
      ((RecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(com.tencent.mm.plugin.finder.presenter.base.b.a.a((com.tencent.mm.plugin.finder.presenter.base.b)localObject1).getColor(2131099679)), (int)com.tencent.mm.plugin.finder.presenter.base.b.a.a((com.tencent.mm.plugin.finder.presenter.base.b)localObject1).getDimension(2131166294)));
      c.a(c.agM(), (d.g.a.b)new f.c.c((f.c)localObject1));
      localObject2 = com.tencent.mm.ui.component.a.LCX;
      localObject2 = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(((f.c)localObject1).imP).get(FinderReporterUIC.class));
      if (localObject2 != null)
      {
        localObject1 = ((f.c)localObject1).fPw;
        if (localObject1 == null) {
          d.g.b.k.aPZ("recyclerView");
        }
        ((RecyclerView)localObject1).a(((e)localObject2).fSD());
      }
      localObject1 = this.qvw;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      ((BaseFinderFeedLoader)((f.c)localObject1).qvM.fTm()).register(((f.c)localObject1).qvO, ((f.c)localObject1).imP);
      localObject1 = FinderLikeDrawer.Lfb;
      localObject1 = (Context)this;
      localObject2 = getWindow();
      d.g.b.k.g(localObject2, "window");
      localObject3 = FinderLikeDrawer.Lfb;
      this.KMO = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fWR());
      localObject1 = FinderLikeDrawer.Lfb;
      localObject1 = getContext();
      d.g.b.k.g(localObject1, "context");
      localObject1 = (Context)localObject1;
      localObject2 = getWindow();
      d.g.b.k.g(localObject2, "this@FinderProfileTimeLineUI.window");
      localObject3 = FinderLikeDrawer.Lfb;
      this.KMP = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fWQ());
      localObject1 = getBaseContext();
      d.g.b.k.g(localObject1, "baseContext");
      localObject1 = new TouchMediaPreviewLayout((Context)localObject1);
      ((TouchMediaPreviewLayout)localObject1).setId(2131306046);
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      localObject2 = ((AppCompatActivity)localObject2).getWindow();
      d.g.b.k.g(localObject2, "context.window");
      localObject2 = ((Window)localObject2).getDecorView();
      d.g.b.k.g(localObject2, "context.window.decorView");
      ((TouchMediaPreviewLayout)localObject1).gr((View)localObject2);
      ((TouchMediaPreviewLayout)localObject1).setScaleListener((TouchMediaPreviewLayout.b)new b(this, (TouchMediaPreviewLayout)localObject1));
      AppMethodBeat.o(166143);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(198531);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.view.f localf = this.KMN;
    if (localf == null) {
      d.g.b.k.aPZ("drawer");
    }
    localf.r(paramInt1, paramIntent);
    AppMethodBeat.o(198531);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(166146);
    goBack();
    AppMethodBeat.o(166146);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166142);
    super.onCreate(paramBundle);
    this.username = getIntent().getStringExtra("finder_username");
    this.qvC = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    this.qzH = getIntent().getIntExtra("KEY_FINDER_JUMP_POS", 0);
    String str = getIntent().getStringExtra("key_finder_cache_key");
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    this.cacheKey = paramBundle;
    ad.i(this.TAG, "username " + this.username + " jumpPosition " + this.qzH);
    if (this.qzH < 0) {
      this.qzH = 0;
    }
    if (bt.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(166142);
      return;
    }
    paramBundle = this.username;
    if (paramBundle != null)
    {
      bool = paramBundle.equals(u.aqO());
      if ((!bool) || (!this.qvC)) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      this.diE = bool;
      initView();
      AppMethodBeat.o(166142);
      return;
      bool = false;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166150);
    super.onDestroy();
    f.c localc = this.qvw;
    if (localc == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    ((BaseFinderFeedLoader)localc.qvM.fTm()).unregister(localc.qvO, localc.imP);
    localc.qvM.onDetach();
    BaseFinderFeedLoader.Companion.removeCache(this.cacheKey);
    AppMethodBeat.o(166150);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166149);
    super.onPause();
    if (this.qvw == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    if (this.KMN == null) {
      d.g.b.k.aPZ("drawer");
    }
    AppMethodBeat.o(166149);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166148);
    super.onResume();
    Object localObject1 = com.tencent.mm.plugin.finder.convert.a.qpY;
    Object localObject2 = this.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    com.tencent.mm.plugin.finder.convert.a.YT((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.k.fvU();
    }
    localObject1 = com.tencent.mm.plugin.finder.api.b.a.YL((String)localObject1);
    if (localObject1 != null)
    {
      localObject2 = this.inR;
      if (localObject2 == null) {
        d.g.b.k.aPZ("nickTv");
      }
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject1).Su()));
      localObject2 = this.qzF;
      if (localObject2 == null) {
        d.g.b.k.aPZ("signatureTv");
      }
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject1).field_signature));
      localObject2 = com.tencent.mm.plugin.finder.api.b.qnX;
      if (!com.tencent.mm.plugin.finder.api.b.a.YO(((com.tencent.mm.plugin.finder.api.f)localObject1).getUsername())) {
        break label278;
      }
      localObject1 = this.qzG;
      if (localObject1 == null) {
        d.g.b.k.aPZ("subscribeBtn");
      }
      ((Button)localObject1).setText(2131760230);
      localObject1 = this.qzG;
      if (localObject1 == null) {
        d.g.b.k.aPZ("subscribeBtn");
      }
      ((Button)localObject1).setBackgroundResource(2131234429);
      localObject1 = this.qzG;
      if (localObject1 == null) {
        d.g.b.k.aPZ("subscribeBtn");
      }
      ((Button)localObject1).setTextColor(getResources().getColor(2131100549));
      localObject1 = this.qzG;
      if (localObject1 == null) {
        d.g.b.k.aPZ("subscribeBtn");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)c.KSG);
    }
    for (;;)
    {
      if (this.qvw == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject1 = this.KMN;
      if (localObject1 == null) {
        d.g.b.k.aPZ("drawer");
      }
      ((com.tencent.mm.plugin.finder.view.f)localObject1).onUIResume();
      AppMethodBeat.o(166148);
      return;
      label278:
      localObject1 = this.qzG;
      if (localObject1 == null) {
        d.g.b.k.aPZ("subscribeBtn");
      }
      ((Button)localObject1).setText(2131759228);
      localObject1 = this.qzG;
      if (localObject1 == null) {
        d.g.b.k.aPZ("subscribeBtn");
      }
      ((Button)localObject1).setTextColor(getResources().getColor(2131101182));
      localObject1 = this.qzG;
      if (localObject1 == null) {
        d.g.b.k.aPZ("subscribeBtn");
      }
      ((Button)localObject1).setBackgroundResource(2131231366);
      localObject1 = this.qzG;
      if (localObject1 == null) {
        d.g.b.k.aPZ("subscribeBtn");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)d.KSH);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166147);
    ad.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(166147);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderProfileTimeLineUI paramFinderProfileTimeLineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166131);
      FinderProfileTimeLineUI.a(this.qzL);
      AppMethodBeat.o(166131);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$initView$2", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "focusBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getFocusBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setFocusBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private final RecyclerView fPw;
    private FinderMediaBanner qus;
    
    b(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      AppMethodBeat.i(166135);
      this.fPw = FinderProfileTimeLineUI.b(paramTouchMediaPreviewLayout).getRecyclerView();
      AppMethodBeat.o(166135);
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(166134);
      d.g.b.k.h(paramScaleGestureDetector, "detector");
      AppMethodBeat.o(166134);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(166132);
      d.g.b.k.h(paramScaleGestureDetector, "detector");
      paramScaleGestureDetector = this.fPw.o(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      if (paramScaleGestureDetector != null) {}
      Object localObject;
      for (paramScaleGestureDetector = (FinderMediaBanner)paramScaleGestureDetector.findViewById(2131302203);; paramScaleGestureDetector = null)
      {
        this.qus = paramScaleGestureDetector;
        paramScaleGestureDetector = this.qus;
        if (paramScaleGestureDetector == null) {
          break label262;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.getPagerView();
        if (paramScaleGestureDetector == null) {
          break label262;
        }
        localObject = this.qus;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        paramScaleGestureDetector = paramScaleGestureDetector.cj(((FinderMediaBanner)localObject).getFocusPosition());
        if ((paramScaleGestureDetector == null) || (paramScaleGestureDetector.lp() != 2)) {
          break label148;
        }
        localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (!com.tencent.mm.plugin.finder.storage.b.cpB()) {
          break;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.arI.findViewById(2131299974);
        if (paramScaleGestureDetector == null) {
          break label262;
        }
        this.qzM.gq(paramScaleGestureDetector);
        AppMethodBeat.o(166132);
        return true;
      }
      AppMethodBeat.o(166132);
      return false;
      label148:
      if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lp() == 4))
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.cpC())
        {
          paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.arI.findViewById(2131299975);
          if (paramScaleGestureDetector != null)
          {
            localObject = paramScaleGestureDetector.getVideoView();
            if ((localObject != null) && (!((o)localObject).isPlaying()))
            {
              AppMethodBeat.o(166132);
              return false;
            }
            paramScaleGestureDetector = paramScaleGestureDetector.getVideoView();
            if (paramScaleGestureDetector != null)
            {
              paramScaleGestureDetector.setPreview(true);
              paramScaleGestureDetector.setInterceptDetach(true);
              this.qzM.gq(paramScaleGestureDetector.getVideoView());
              AppMethodBeat.o(166132);
              return true;
            }
          }
        }
        else
        {
          AppMethodBeat.o(166132);
          return false;
        }
      }
      label262:
      AppMethodBeat.o(166132);
      return false;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(166133);
      d.g.b.k.h(paramScaleGestureDetector, "detector");
      if ((this.qzM.getTouchView() instanceof o))
      {
        paramScaleGestureDetector = this.qzM.getTouchView();
        if (paramScaleGestureDetector == null)
        {
          paramScaleGestureDetector = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.IFinderVideoView");
          AppMethodBeat.o(166133);
          throw paramScaleGestureDetector;
        }
        paramScaleGestureDetector = (o)paramScaleGestureDetector;
        paramScaleGestureDetector.setInterceptDetach(false);
        paramScaleGestureDetector.setPreview(false);
      }
      AppMethodBeat.o(166133);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    public static final c KSG;
    
    static
    {
      AppMethodBeat.i(198529);
      KSG = new c();
      AppMethodBeat.o(198529);
    }
    
    public final void onClick(View paramView) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    public static final d KSH;
    
    static
    {
      AppMethodBeat.i(198530);
      KSH = new d();
      AppMethodBeat.o(198530);
    }
    
    public final void onClick(View paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI
 * JD-Core Version:    0.7.0.1
 */