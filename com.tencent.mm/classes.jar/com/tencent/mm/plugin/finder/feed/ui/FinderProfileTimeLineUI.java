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
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader.Companion;
import com.tencent.mm.plugin.finder.feed.t.b;
import com.tencent.mm.plugin.finder.feed.t.c;
import com.tencent.mm.plugin.finder.feed.t.c.b;
import com.tencent.mm.plugin.finder.feed.t.c.c;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.d.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import d.l;
import d.v;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_UNFOLLOW", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "cacheKey", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "isSelf", "", "jumpPosition", "likeDrawer", "nickTv", "Landroid/widget/TextView;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "signatureTv", "subscribeBtn", "Landroid/widget/Button;", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "getCommentScene", "getLayoutId", "getReportType", "goBack", "", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshProfile", "plugin-finder_release"})
public final class FinderProfileTimeLineUI
  extends MMFinderUI
  implements g
{
  private final String TAG = "Finder.FinderProfileTimeLineUI";
  private HashMap _$_findViewCache;
  private String cacheKey = "";
  private boolean dfZ;
  private ImageView fxQ;
  private TextView iNX;
  private final int nPp = 10004;
  private final int raj = 10001;
  private RefreshLoadMoreLayout rfT;
  private com.tencent.mm.plugin.finder.view.d rfU;
  private FinderLikeDrawer rfV;
  private FinderLikeDrawer rfW;
  private t.b riE;
  private t.c rir;
  private boolean riv;
  private Button rqA;
  private int rqB;
  private final int rqC = 10000;
  private final int rqD = 10002;
  private final int rqE = 10003;
  private TextView rqz;
  private String username;
  
  private final void goBack()
  {
    AppMethodBeat.i(166145);
    Object localObject = this.rfU;
    if (localObject == null) {
      d.g.b.k.aVY("drawer");
    }
    if (((com.tencent.mm.plugin.finder.view.d)localObject).cEG())
    {
      localObject = this.rfU;
      if (localObject == null) {
        d.g.b.k.aVY("drawer");
      }
      ((com.tencent.mm.plugin.finder.view.d)localObject).cEF();
      AppMethodBeat.o(166145);
      return;
    }
    localObject = this.rfV;
    if (localObject == null) {
      d.g.b.k.aVY("likeDrawer");
    }
    if (((FinderLikeDrawer)localObject).cEG())
    {
      localObject = this.rfV;
      if (localObject == null) {
        d.g.b.k.aVY("likeDrawer");
      }
      ((FinderLikeDrawer)localObject).cEF();
      AppMethodBeat.o(166145);
      return;
    }
    localObject = this.rfW;
    if (localObject == null) {
      d.g.b.k.aVY("friendLikeDrawer");
    }
    if (((FinderLikeDrawer)localObject).cEG())
    {
      localObject = this.rfW;
      if (localObject == null) {
        d.g.b.k.aVY("friendLikeDrawer");
      }
      ((FinderLikeDrawer)localObject).cEF();
      AppMethodBeat.o(166145);
      return;
    }
    finish();
    AppMethodBeat.o(166145);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202451);
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
    AppMethodBeat.o(202451);
    return localView1;
  }
  
  public final int cuI()
  {
    int j = 0;
    AppMethodBeat.i(202450);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (d.g.b.k.g(str, u.axE()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(202450);
      return 8;
    }
    AppMethodBeat.o(202450);
    return 1;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131494099;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(166143);
    Object localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.k.fOy();
    }
    Object localObject3 = b.a.adh((String)localObject1);
    if (localObject3 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.api.f)localObject3).Tn();
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
    this.fxQ = ((ImageView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131302861);
    d.g.b.k.g(localObject2, "header.findViewById(R.id.nick_tv)");
    this.iNX = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131304823);
    d.g.b.k.g(localObject2, "header.findViewById(R.id.signature_tv)");
    this.rqz = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131305519);
    d.g.b.k.g(localObject2, "header.findViewById(R.id.subscribe_btn)");
    this.rqA = ((Button)localObject2);
    localObject2 = findViewById(2131304203);
    d.g.b.k.g(localObject2, "findViewById(R.id.rl_layout)");
    this.rfT = ((RefreshLoadMoreLayout)localObject2);
    localObject1 = ((View)localObject1).findViewById(2131299162);
    d.g.b.k.g(localObject1, "header.findViewById<ImageView>(R.id.divider_item)");
    ((ImageView)localObject1).setVisibility(0);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    localObject1 = h.rtK;
    com.tencent.mm.loader.d locald = h.cwo();
    if (localObject3 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.api.f)localObject3).crZ();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
    localObject2 = this.fxQ;
    if (localObject2 == null) {
      d.g.b.k.aVY("avatarIv");
    }
    localObject3 = h.rtK;
    locald.a(localObject1, (ImageView)localObject2, h.a(h.a.rtN));
    localObject1 = com.tencent.mm.plugin.finder.view.d.rVR;
    localObject1 = (MMActivity)this;
    localObject2 = getWindow();
    d.g.b.k.g(localObject2, "window");
    localObject2 = ((Window)localObject2).getDecorView();
    d.g.b.k.g(localObject2, "window.decorView");
    if (this.dfZ) {}
    for (int i = 1;; i = 2)
    {
      this.rfU = d.a.a((MMActivity)localObject1, (View)localObject2, i, false);
      localObject1 = (MMActivity)this;
      localObject2 = this.rfU;
      if (localObject2 == null) {
        d.g.b.k.aVY("drawer");
      }
      localObject3 = this.username;
      if (localObject3 == null) {
        d.g.b.k.fOy();
      }
      this.riE = new t.b((MMActivity)localObject1, (com.tencent.mm.plugin.finder.view.d)localObject2, (String)localObject3, this.rqB, this.riv, this.cacheKey);
      localObject1 = (MMActivity)this;
      localObject2 = this.riE;
      if (localObject2 == null) {
        d.g.b.k.aVY("presenter");
      }
      localObject1 = new t.c((MMActivity)localObject1, (t.b)localObject2, this.rqB);
      localObject2 = this.riE;
      if (localObject2 == null) {
        d.g.b.k.aVY("presenter");
      }
      ((t.b)localObject2).a((t.c)localObject1);
      localObject2 = ((t.c)localObject1).rfT;
      if (localObject2 == null) {
        d.g.b.k.aVY("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject2).setActionCallback((RefreshLoadMoreLayout.a)new t.c.b((t.c)localObject1));
      localObject2 = ((t.c)localObject1).fTr;
      if (localObject2 == null) {
        d.g.b.k.aVY("recyclerView");
      }
      ((RecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getColor(2131099679)), (int)c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getDimension(2131166294)));
      com.tencent.mm.ac.c.a(com.tencent.mm.ac.c.aid(), (d.g.a.b)new t.c.c((t.c)localObject1));
      localObject2 = com.tencent.mm.ui.component.a.IrY;
      localObject2 = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.q(((t.c)localObject1).iMV).get(FinderReporterUIC.class));
      if (localObject2 != null)
      {
        localObject3 = ((t.c)localObject1).fTr;
        if (localObject3 == null) {
          d.g.b.k.aVY("recyclerView");
        }
        ((RecyclerView)localObject3).a(((com.tencent.mm.plugin.finder.event.base.f)localObject2).ctt());
      }
      ((BaseFinderFeedLoader)((t.c)localObject1).riE.cuV()).register(((t.c)localObject1).rgg, ((t.c)localObject1).iMV);
      this.rir = ((t.c)localObject1);
      localObject1 = FinderLikeDrawer.rXU;
      localObject1 = (Context)this;
      localObject2 = getWindow();
      d.g.b.k.g(localObject2, "window");
      localObject3 = FinderLikeDrawer.rXU;
      this.rfV = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cFa());
      localObject1 = FinderLikeDrawer.rXU;
      localObject1 = getContext();
      d.g.b.k.g(localObject1, "context");
      localObject1 = (Context)localObject1;
      localObject2 = getWindow();
      d.g.b.k.g(localObject2, "this@FinderProfileTimeLineUI.window");
      localObject3 = FinderLikeDrawer.rXU;
      this.rfW = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cEZ());
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
      ((TouchMediaPreviewLayout)localObject1).gG((View)localObject2);
      ((TouchMediaPreviewLayout)localObject1).setScaleListener((TouchMediaPreviewLayout.b)new b(this, (TouchMediaPreviewLayout)localObject1));
      AppMethodBeat.o(166143);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(202449);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.view.d locald = this.rfU;
    if (locald == null) {
      d.g.b.k.aVY("drawer");
    }
    locald.d(paramInt1, paramIntent);
    AppMethodBeat.o(202449);
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
    this.riv = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    this.rqB = getIntent().getIntExtra("KEY_FINDER_JUMP_POS", 0);
    String str = getIntent().getStringExtra("key_finder_cache_key");
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    this.cacheKey = paramBundle;
    ac.i(this.TAG, "username " + this.username + " jumpPosition " + this.rqB);
    if (this.rqB < 0) {
      this.rqB = 0;
    }
    if (bs.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(166142);
      return;
    }
    paramBundle = this.username;
    if (paramBundle != null)
    {
      bool = paramBundle.equals(u.axE());
      if ((!bool) || (!this.riv)) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      this.dfZ = bool;
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
    Object localObject = this.rfU;
    if (localObject == null) {
      d.g.b.k.aVY("drawer");
    }
    ((com.tencent.mm.plugin.finder.view.d)localObject).onDetach();
    super.onDestroy();
    localObject = this.rir;
    if (localObject != null)
    {
      ((BaseFinderFeedLoader)((t.c)localObject).riE.cuV()).unregister(((t.c)localObject).rgg, ((t.c)localObject).iMV);
      ((t.c)localObject).riE.onDetach();
    }
    BaseFinderFeedLoader.Companion.removeCache(this.cacheKey);
    AppMethodBeat.o(166150);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166149);
    super.onPause();
    if (this.rfU == null) {
      d.g.b.k.aVY("drawer");
    }
    AppMethodBeat.o(166149);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166148);
    super.onResume();
    Object localObject1 = com.tencent.mm.plugin.finder.convert.a.qZF;
    Object localObject2 = this.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    com.tencent.mm.plugin.finder.convert.a.adp((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.k.fOy();
    }
    localObject1 = b.a.adh((String)localObject1);
    if (localObject1 != null)
    {
      localObject2 = this.iNX;
      if (localObject2 == null) {
        d.g.b.k.aVY("nickTv");
      }
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject1).Tn()));
      localObject2 = this.rqz;
      if (localObject2 == null) {
        d.g.b.k.aVY("signatureTv");
      }
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject1).field_signature));
      localObject2 = com.tencent.mm.plugin.finder.api.b.qWt;
      if (!b.a.adk(((com.tencent.mm.plugin.finder.api.f)localObject1).getUsername())) {
        break label266;
      }
      localObject1 = this.rqA;
      if (localObject1 == null) {
        d.g.b.k.aVY("subscribeBtn");
      }
      ((Button)localObject1).setText(2131760230);
      localObject1 = this.rqA;
      if (localObject1 == null) {
        d.g.b.k.aVY("subscribeBtn");
      }
      ((Button)localObject1).setBackgroundResource(2131234429);
      localObject1 = this.rqA;
      if (localObject1 == null) {
        d.g.b.k.aVY("subscribeBtn");
      }
      ((Button)localObject1).setTextColor(getResources().getColor(2131100549));
      localObject1 = this.rqA;
      if (localObject1 == null) {
        d.g.b.k.aVY("subscribeBtn");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)FinderProfileTimeLineUI.c.rqH);
    }
    for (;;)
    {
      localObject1 = this.rfU;
      if (localObject1 == null) {
        d.g.b.k.aVY("drawer");
      }
      ((com.tencent.mm.plugin.finder.view.d)localObject1).onUIResume();
      AppMethodBeat.o(166148);
      return;
      label266:
      localObject1 = this.rqA;
      if (localObject1 == null) {
        d.g.b.k.aVY("subscribeBtn");
      }
      ((Button)localObject1).setText(2131759228);
      localObject1 = this.rqA;
      if (localObject1 == null) {
        d.g.b.k.aVY("subscribeBtn");
      }
      ((Button)localObject1).setTextColor(getResources().getColor(2131101182));
      localObject1 = this.rqA;
      if (localObject1 == null) {
        d.g.b.k.aVY("subscribeBtn");
      }
      ((Button)localObject1).setBackgroundResource(2131231366);
      localObject1 = this.rqA;
      if (localObject1 == null) {
        d.g.b.k.aVY("subscribeBtn");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)FinderProfileTimeLineUI.d.rqI);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166147);
    ac.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(166147);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderProfileTimeLineUI paramFinderProfileTimeLineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166131);
      FinderProfileTimeLineUI.a(this.rqF);
      AppMethodBeat.o(166131);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$initView$3", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "focusBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getFocusBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setFocusBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private final RecyclerView fTr;
    private FinderMediaBanner rge;
    
    b(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      AppMethodBeat.i(202446);
      paramTouchMediaPreviewLayout = FinderProfileTimeLineUI.b(paramTouchMediaPreviewLayout);
      if (paramTouchMediaPreviewLayout != null) {}
      for (paramTouchMediaPreviewLayout = paramTouchMediaPreviewLayout.getRecyclerView();; paramTouchMediaPreviewLayout = null)
      {
        this.fTr = paramTouchMediaPreviewLayout;
        AppMethodBeat.o(202446);
        return;
      }
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(202445);
      d.g.b.k.h(paramScaleGestureDetector, "detector");
      AppMethodBeat.o(202445);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(202443);
      d.g.b.k.h(paramScaleGestureDetector, "detector");
      Object localObject = this.fTr;
      if (localObject != null)
      {
        paramScaleGestureDetector = ((RecyclerView)localObject).o(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        if (paramScaleGestureDetector == null) {}
      }
      for (paramScaleGestureDetector = (FinderMediaBanner)paramScaleGestureDetector.findViewById(2131302203);; paramScaleGestureDetector = null)
      {
        this.rge = paramScaleGestureDetector;
        paramScaleGestureDetector = this.rge;
        if (paramScaleGestureDetector == null) {
          break label268;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.getPagerView();
        if (paramScaleGestureDetector == null) {
          break label268;
        }
        localObject = this.rge;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        paramScaleGestureDetector = paramScaleGestureDetector.ci(((FinderMediaBanner)localObject).getFocusPosition());
        if ((paramScaleGestureDetector == null) || (paramScaleGestureDetector.ly() != 2)) {
          break label154;
        }
        localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (!com.tencent.mm.plugin.finder.storage.b.cyY()) {
          break;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.asD.findViewById(2131299974);
        if (paramScaleGestureDetector == null) {
          break label268;
        }
        this.rqG.gF(paramScaleGestureDetector);
        AppMethodBeat.o(202443);
        return true;
      }
      AppMethodBeat.o(202443);
      return false;
      label154:
      if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.ly() == 4))
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.cyZ())
        {
          paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.asD.findViewById(2131299975);
          if (paramScaleGestureDetector != null)
          {
            localObject = paramScaleGestureDetector.getVideoView();
            if ((localObject != null) && (!((o)localObject).isPlaying()))
            {
              AppMethodBeat.o(202443);
              return false;
            }
            paramScaleGestureDetector = paramScaleGestureDetector.getVideoView();
            if (paramScaleGestureDetector != null)
            {
              paramScaleGestureDetector.setPreview(true);
              paramScaleGestureDetector.setInterceptDetach(true);
              this.rqG.gF(paramScaleGestureDetector.getVideoView());
              AppMethodBeat.o(202443);
              return true;
            }
          }
        }
        else
        {
          AppMethodBeat.o(202443);
          return false;
        }
      }
      label268:
      AppMethodBeat.o(202443);
      return false;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(202444);
      d.g.b.k.h(paramScaleGestureDetector, "detector");
      if ((this.rqG.getTouchView() instanceof o))
      {
        paramScaleGestureDetector = this.rqG.getTouchView();
        if (paramScaleGestureDetector == null)
        {
          paramScaleGestureDetector = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.IFinderVideoView");
          AppMethodBeat.o(202444);
          throw paramScaleGestureDetector;
        }
        paramScaleGestureDetector = (o)paramScaleGestureDetector;
        paramScaleGestureDetector.setInterceptDetach(false);
        paramScaleGestureDetector.setPreview(false);
      }
      AppMethodBeat.o(202444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI
 * JD-Core Version:    0.7.0.1
 */