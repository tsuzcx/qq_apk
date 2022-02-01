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
import com.tencent.mm.ak.n;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.x.b;
import com.tencent.mm.plugin.finder.feed.x.c;
import com.tencent.mm.plugin.finder.feed.x.c.b;
import com.tencent.mm.plugin.finder.feed.x.c.c;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_UNFOLLOW", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "isSelf", "", "likeDrawer", "nickTv", "Landroid/widget/TextView;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "signatureTv", "subscribeBtn", "Landroid/widget/Button;", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "getCommentScene", "getLayoutId", "getReportType", "goBack", "", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshProfile", "plugin-finder_release"})
public final class FinderProfileTimeLineUI
  extends MMFinderUI
  implements com.tencent.mm.ak.f
{
  private final String TAG = "Finder.FinderProfileTimeLineUI";
  private HashMap _$_findViewCache;
  private boolean dsB;
  private ImageView fTj;
  private TextView jjZ;
  private final int oyw = 10004;
  private final int rUN = 10001;
  private RefreshLoadMoreLayout scj;
  private e sck;
  private FinderLikeDrawer scl;
  private FinderLikeDrawer scm;
  private x.b sfC;
  private x.c sfm;
  private boolean sft;
  private final int soA = 10003;
  private TextView sow;
  private Button sox;
  private final int soy = 10000;
  private final int soz = 10002;
  private String username;
  
  private final void goBack()
  {
    AppMethodBeat.i(166145);
    Object localObject = this.sck;
    if (localObject == null) {
      p.bdF("drawer");
    }
    if (((e)localObject).cPI())
    {
      localObject = this.sck;
      if (localObject == null) {
        p.bdF("drawer");
      }
      ((e)localObject).cPH();
      AppMethodBeat.o(166145);
      return;
    }
    localObject = this.scl;
    if (localObject == null) {
      p.bdF("likeDrawer");
    }
    if (((FinderLikeDrawer)localObject).cPI())
    {
      localObject = this.scl;
      if (localObject == null) {
        p.bdF("likeDrawer");
      }
      ((FinderLikeDrawer)localObject).cPH();
      AppMethodBeat.o(166145);
      return;
    }
    localObject = this.scm;
    if (localObject == null) {
      p.bdF("friendLikeDrawer");
    }
    if (((FinderLikeDrawer)localObject).cPI())
    {
      localObject = this.scm;
      if (localObject == null) {
        p.bdF("friendLikeDrawer");
      }
      ((FinderLikeDrawer)localObject).cPH();
      AppMethodBeat.o(166145);
      return;
    }
    finish();
    AppMethodBeat.o(166145);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203295);
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
    AppMethodBeat.o(203295);
    return localView1;
  }
  
  public final int cCL()
  {
    int j = 0;
    AppMethodBeat.i(203294);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (p.i(str, com.tencent.mm.model.v.aAK()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(203294);
      return 8;
    }
    AppMethodBeat.o(203294);
    return 1;
  }
  
  public final int cDL()
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
    Object localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
    localObject1 = this.username;
    if (localObject1 == null) {
      p.gkB();
    }
    Object localObject3 = com.tencent.mm.plugin.finder.api.c.a.ahT((String)localObject1);
    if (localObject3 != null)
    {
      localObject2 = ((g)localObject3).VK();
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
    p.g(localObject2, "header.findViewById(R.id.avatar_iv)");
    this.fTj = ((ImageView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131302861);
    p.g(localObject2, "header.findViewById(R.id.nick_tv)");
    this.jjZ = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131304823);
    p.g(localObject2, "header.findViewById(R.id.signature_tv)");
    this.sow = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131305519);
    p.g(localObject2, "header.findViewById(R.id.subscribe_btn)");
    this.sox = ((Button)localObject2);
    localObject2 = findViewById(2131304203);
    p.g(localObject2, "findViewById(R.id.rl_layout)");
    this.scj = ((RefreshLoadMoreLayout)localObject2);
    localObject1 = ((View)localObject1).findViewById(2131299162);
    p.g(localObject1, "header.findViewById<ImageView>(R.id.divider_item)");
    ((ImageView)localObject1).setVisibility(0);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    localObject1 = i.srW;
    d locald = i.cEo();
    if (localObject3 != null)
    {
      localObject2 = ((g)localObject3).czm();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
    localObject2 = this.fTj;
    if (localObject2 == null) {
      p.bdF("avatarIv");
    }
    localObject3 = i.srW;
    locald.a(localObject1, (ImageView)localObject2, i.a(i.a.srZ));
    localObject1 = e.tdM;
    localObject1 = (MMActivity)this;
    localObject2 = getWindow();
    p.g(localObject2, "window");
    localObject2 = ((Window)localObject2).getDecorView();
    p.g(localObject2, "window.decorView");
    if (this.dsB) {}
    for (int i = 1;; i = 2)
    {
      this.sck = e.a.a((MMActivity)localObject1, (View)localObject2, i, false);
      localObject1 = (MMActivity)this;
      localObject2 = this.sck;
      if (localObject2 == null) {
        p.bdF("drawer");
      }
      localObject3 = this.username;
      if (localObject3 == null) {
        p.gkB();
      }
      this.sfC = new x.b((MMActivity)localObject1, (e)localObject2, (String)localObject3, this.sft);
      localObject1 = (MMActivity)this;
      localObject2 = this.sfC;
      if (localObject2 == null) {
        p.bdF("presenter");
      }
      localObject1 = new x.c((MMActivity)localObject1, (x.b)localObject2);
      localObject2 = this.sfC;
      if (localObject2 == null) {
        p.bdF("presenter");
      }
      ((x.b)localObject2).a((x.c)localObject1);
      localObject2 = ((x.c)localObject1).scj;
      if (localObject2 == null) {
        p.bdF("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject2).setActionCallback((RefreshLoadMoreLayout.a)new x.c.b((x.c)localObject1));
      localObject2 = ((x.c)localObject1).gpr;
      if (localObject2 == null) {
        p.bdF("recyclerView");
      }
      ((RecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(com.tencent.mm.plugin.finder.presenter.base.c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getColor(2131099679)), (int)com.tencent.mm.plugin.finder.presenter.base.c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getDimension(2131166294)));
      com.tencent.mm.ac.c.a(com.tencent.mm.ac.c.ale(), (d.g.a.b)new x.c.c((x.c)localObject1));
      localObject2 = com.tencent.mm.ui.component.a.KEX;
      localObject2 = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(((x.c)localObject1).fNT).get(FinderReporterUIC.class));
      if (localObject2 != null)
      {
        localObject3 = ((x.c)localObject1).gpr;
        if (localObject3 == null) {
          p.bdF("recyclerView");
        }
        ((com.tencent.mm.plugin.finder.event.base.f)localObject2).s((RecyclerView)localObject3);
      }
      ((BaseFinderFeedLoader)((x.c)localObject1).sfC.cCY()).register(((x.c)localObject1).scv);
      this.sfm = ((x.c)localObject1);
      localObject1 = FinderLikeDrawer.tgd;
      localObject1 = (Context)this;
      localObject2 = getWindow();
      p.g(localObject2, "window");
      localObject3 = FinderLikeDrawer.tgd;
      this.scl = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cQe());
      localObject1 = FinderLikeDrawer.tgd;
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = (Context)localObject1;
      localObject2 = getWindow();
      p.g(localObject2, "this@FinderProfileTimeLineUI.window");
      localObject3 = FinderLikeDrawer.tgd;
      this.scm = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cQd());
      localObject1 = getBaseContext();
      p.g(localObject1, "baseContext");
      localObject1 = new TouchMediaPreviewLayout((Context)localObject1);
      ((TouchMediaPreviewLayout)localObject1).setId(2131306046);
      localObject2 = getContext();
      p.g(localObject2, "context");
      localObject2 = ((AppCompatActivity)localObject2).getWindow();
      p.g(localObject2, "context.window");
      localObject2 = ((Window)localObject2).getDecorView();
      p.g(localObject2, "context.window.decorView");
      ((TouchMediaPreviewLayout)localObject1).hc((View)localObject2);
      ((TouchMediaPreviewLayout)localObject1).setScaleListener((TouchMediaPreviewLayout.b)new b(this, (TouchMediaPreviewLayout)localObject1));
      AppMethodBeat.o(166143);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(203293);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    e locale = this.sck;
    if (locale == null) {
      p.bdF("drawer");
    }
    locale.d(paramInt1, paramIntent);
    AppMethodBeat.o(203293);
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
    this.sft = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    ae.i(this.TAG, "username " + this.username);
    if (bu.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(166142);
      return;
    }
    paramBundle = this.username;
    if (paramBundle != null) {}
    for (boolean bool1 = paramBundle.equals(com.tencent.mm.model.v.aAK());; bool1 = false)
    {
      boolean bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (this.sft) {
          bool2 = true;
        }
      }
      this.dsB = bool2;
      initView();
      AppMethodBeat.o(166142);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166150);
    Object localObject = this.sck;
    if (localObject == null) {
      p.bdF("drawer");
    }
    ((e)localObject).onDetach();
    super.onDestroy();
    localObject = this.sfm;
    if (localObject != null)
    {
      ((BaseFinderFeedLoader)((x.c)localObject).sfC.cCY()).unregister(((x.c)localObject).scv);
      ((x.c)localObject).sfC.onDetach();
      ((x.c)localObject).getRecyclerView().setAdapter(null);
      AppMethodBeat.o(166150);
      return;
    }
    AppMethodBeat.o(166150);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166149);
    super.onPause();
    if (this.sck == null) {
      p.bdF("drawer");
    }
    AppMethodBeat.o(166149);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166148);
    super.onResume();
    Object localObject1 = com.tencent.mm.plugin.finder.convert.a.rUe;
    Object localObject2 = this.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    com.tencent.mm.plugin.finder.convert.a.aic((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
    localObject1 = this.username;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = com.tencent.mm.plugin.finder.api.c.a.ahT((String)localObject1);
    if (localObject1 != null)
    {
      localObject2 = this.jjZ;
      if (localObject2 == null) {
        p.bdF("nickTv");
      }
      ((TextView)localObject2).setText((CharSequence)k.c((Context)this, (CharSequence)((g)localObject1).VK()));
      localObject2 = this.sow;
      if (localObject2 == null) {
        p.bdF("signatureTv");
      }
      ((TextView)localObject2).setText((CharSequence)k.c((Context)this, (CharSequence)((g)localObject1).field_signature));
      localObject2 = com.tencent.mm.plugin.finder.api.c.rPy;
      if (!com.tencent.mm.plugin.finder.api.c.a.ahW(((g)localObject1).getUsername())) {
        break label266;
      }
      localObject1 = this.sox;
      if (localObject1 == null) {
        p.bdF("subscribeBtn");
      }
      ((Button)localObject1).setText(2131760230);
      localObject1 = this.sox;
      if (localObject1 == null) {
        p.bdF("subscribeBtn");
      }
      ((Button)localObject1).setBackgroundResource(2131234429);
      localObject1 = this.sox;
      if (localObject1 == null) {
        p.bdF("subscribeBtn");
      }
      ((Button)localObject1).setTextColor(getResources().getColor(2131100549));
      localObject1 = this.sox;
      if (localObject1 == null) {
        p.bdF("subscribeBtn");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)FinderProfileTimeLineUI.c.soD);
    }
    for (;;)
    {
      localObject1 = this.sck;
      if (localObject1 == null) {
        p.bdF("drawer");
      }
      ((e)localObject1).onUIResume();
      AppMethodBeat.o(166148);
      return;
      label266:
      localObject1 = this.sox;
      if (localObject1 == null) {
        p.bdF("subscribeBtn");
      }
      ((Button)localObject1).setText(2131759228);
      localObject1 = this.sox;
      if (localObject1 == null) {
        p.bdF("subscribeBtn");
      }
      ((Button)localObject1).setTextColor(getResources().getColor(2131101182));
      localObject1 = this.sox;
      if (localObject1 == null) {
        p.bdF("subscribeBtn");
      }
      ((Button)localObject1).setBackgroundResource(2131231366);
      localObject1 = this.sox;
      if (localObject1 == null) {
        p.bdF("subscribeBtn");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)FinderProfileTimeLineUI.d.soE);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166147);
    ae.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(166147);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderProfileTimeLineUI paramFinderProfileTimeLineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166131);
      FinderProfileTimeLineUI.a(this.soB);
      AppMethodBeat.o(166131);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$initView$3", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "focusBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getFocusBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setFocusBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private final RecyclerView gpr;
    private FinderMediaBanner sct;
    
    b(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      AppMethodBeat.i(203288);
      paramTouchMediaPreviewLayout = FinderProfileTimeLineUI.b(paramTouchMediaPreviewLayout);
      if (paramTouchMediaPreviewLayout != null) {}
      for (paramTouchMediaPreviewLayout = paramTouchMediaPreviewLayout.getRecyclerView();; paramTouchMediaPreviewLayout = null)
      {
        this.gpr = paramTouchMediaPreviewLayout;
        AppMethodBeat.o(203288);
        return;
      }
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(203287);
      p.h(paramScaleGestureDetector, "detector");
      AppMethodBeat.o(203287);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(203285);
      p.h(paramScaleGestureDetector, "detector");
      Object localObject = this.gpr;
      if (localObject != null)
      {
        paramScaleGestureDetector = ((RecyclerView)localObject).o(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        if (paramScaleGestureDetector == null) {}
      }
      for (paramScaleGestureDetector = (FinderMediaBanner)paramScaleGestureDetector.findViewById(2131302203);; paramScaleGestureDetector = null)
      {
        this.sct = paramScaleGestureDetector;
        paramScaleGestureDetector = this.sct;
        if (paramScaleGestureDetector == null) {
          break label268;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.getPagerView();
        if (paramScaleGestureDetector == null) {
          break label268;
        }
        localObject = this.sct;
        if (localObject == null) {
          p.gkB();
        }
        paramScaleGestureDetector = paramScaleGestureDetector.ci(((FinderMediaBanner)localObject).getFocusPosition());
        if ((paramScaleGestureDetector == null) || (paramScaleGestureDetector.lQ() != 2)) {
          break label154;
        }
        localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (!com.tencent.mm.plugin.finder.storage.b.cHQ()) {
          break;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.auu.findViewById(2131299974);
        if (paramScaleGestureDetector == null) {
          break label268;
        }
        this.soC.hb(paramScaleGestureDetector);
        AppMethodBeat.o(203285);
        return true;
      }
      AppMethodBeat.o(203285);
      return false;
      label154:
      if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lQ() == 4))
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (com.tencent.mm.plugin.finder.storage.b.cHR())
        {
          paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.auu.findViewById(2131299975);
          if (paramScaleGestureDetector != null)
          {
            localObject = paramScaleGestureDetector.getVideoView();
            if ((localObject != null) && (!((o)localObject).isPlaying()))
            {
              AppMethodBeat.o(203285);
              return false;
            }
            paramScaleGestureDetector = paramScaleGestureDetector.getVideoView();
            if (paramScaleGestureDetector != null)
            {
              paramScaleGestureDetector.setPreview(true);
              paramScaleGestureDetector.setInterceptDetach(true);
              this.soC.hb(paramScaleGestureDetector.getVideoView());
              AppMethodBeat.o(203285);
              return true;
            }
          }
        }
        else
        {
          AppMethodBeat.o(203285);
          return false;
        }
      }
      label268:
      AppMethodBeat.o(203285);
      return false;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(203286);
      p.h(paramScaleGestureDetector, "detector");
      if ((this.soC.getTouchView() instanceof o))
      {
        paramScaleGestureDetector = this.soC.getTouchView();
        if (paramScaleGestureDetector == null)
        {
          paramScaleGestureDetector = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.IFinderVideoView");
          AppMethodBeat.o(203286);
          throw paramScaleGestureDetector;
        }
        paramScaleGestureDetector = (o)paramScaleGestureDetector;
        paramScaleGestureDetector.setInterceptDetach(false);
        paramScaleGestureDetector.setPreview(false);
      }
      AppMethodBeat.o(203286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI
 * JD-Core Version:    0.7.0.1
 */