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
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.feed.an.b;
import com.tencent.mm.plugin.finder.feed.an.c;
import com.tencent.mm.plugin.finder.feed.an.c.b;
import com.tencent.mm.plugin.finder.feed.an.c.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.ui.MMFinderFeedDetailUI;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.viewmodel.component.ae;
import com.tencent.mm.plugin.finder.viewmodel.component.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.av;
import com.tencent.mm.plugin.finder.viewmodel.component.az;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderFeedDetailUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_UNFOLLOW", "TAG", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "avatarIv", "Landroid/widget/ImageView;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "isSelf", "", "likeDrawer", "mHellOnScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1;", "nickTv", "Landroid/widget/TextView;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "signatureTv", "subscribeBtn", "Landroid/widget/Button;", "topicId", "", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "fixActionBarStatus", "", "getCommentScene", "getLayoutId", "getReportType", "goBack", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "isHideStatusBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "overlayStatusBar", "refreshProfile", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileTimeLineUI
  extends MMFinderFeedDetailUI
  implements com.tencent.mm.am.h
{
  private long ADo;
  private final int ASU;
  private final int ASV;
  private FinderLikeDrawer ATA;
  private RefreshLoadMoreLayout ATx;
  private com.tencent.mm.plugin.finder.view.f ATy;
  private FinderLikeDrawer ATz;
  private boolean AXX;
  private an.c AXZ;
  private an.b AYo;
  private TextView Brh;
  private Button Bri;
  private final int Brj;
  private final int Brk;
  private final int Brl;
  private final a Brm;
  private final String TAG;
  private boolean hHq;
  private ImageView lKK;
  private final com.tencent.mm.model.d nmW;
  private TextView pWj;
  private String username;
  
  public FinderProfileTimeLineUI()
  {
    AppMethodBeat.i(365571);
    this.TAG = "Finder.FinderProfileTimeLineUI";
    this.nmW = new com.tencent.mm.model.d();
    this.Brj = 10000;
    this.ASU = 10001;
    this.Brk = 10002;
    this.Brl = 10003;
    this.ASV = 10004;
    this.Brm = new a();
    AppMethodBeat.o(365571);
  }
  
  private static final Map a(FinderProfileTimeLineUI paramFinderProfileTimeLineUI, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(365589);
    s.u(paramFinderProfileTimeLineUI, "this$0");
    paramString = paramFinderProfileTimeLineUI.getIntent();
    if (paramString == null)
    {
      paramString = null;
      paramString = String.valueOf(paramString);
      if (!i.hm(paramString)) {
        break label210;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
    }
    label210:
    for (;;)
    {
      String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr1 = v.Y("session_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr2 = v.Y("finder_context_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = v.Y("finder_tab_context_id", localObject1);
      paramString = v.Y("extra_info", paramString);
      paramFinderProfileTimeLineUI = paramFinderProfileTimeLineUI.getIntent();
      if (paramFinderProfileTimeLineUI == null) {}
      for (paramFinderProfileTimeLineUI = localObject2;; paramFinderProfileTimeLineUI = paramFinderProfileTimeLineUI.getStringExtra("key_enter_source_info"))
      {
        paramFinderProfileTimeLineUI = ak.e(new r[] { localr1, localr2, localObject1, paramString, v.Y("enter_source_info", String.valueOf(paramFinderProfileTimeLineUI)) });
        AppMethodBeat.o(365589);
        return paramFinderProfileTimeLineUI;
        paramString = paramString.getStringExtra("key_extra_info");
        break;
      }
    }
  }
  
  private static final void a(FinderProfileTimeLineUI paramFinderProfileTimeLineUI, View paramView)
  {
    AppMethodBeat.i(365602);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderProfileTimeLineUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderProfileTimeLineUI, "this$0");
    paramFinderProfileTimeLineUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365602);
  }
  
  private static final boolean a(FinderProfileTimeLineUI paramFinderProfileTimeLineUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365595);
    s.u(paramFinderProfileTimeLineUI, "this$0");
    paramFinderProfileTimeLineUI.goBack();
    AppMethodBeat.o(365595);
    return true;
  }
  
  private static final void fJ(View paramView)
  {
    AppMethodBeat.i(365607);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365607);
  }
  
  private static final void fK(View paramView)
  {
    AppMethodBeat.i(365613);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365613);
  }
  
  private final void goBack()
  {
    FinderLikeDrawer localFinderLikeDrawer1 = null;
    Object localObject2 = null;
    FinderLikeDrawer localFinderLikeDrawer2 = null;
    AppMethodBeat.i(166145);
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
        localObject1 = localFinderLikeDrawer2;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.finder.view.f)localObject1).fdh();
        AppMethodBeat.o(166145);
        return;
      }
    }
    localFinderLikeDrawer2 = this.ATz;
    localObject1 = localFinderLikeDrawer2;
    if (localFinderLikeDrawer2 == null)
    {
      s.bIx("likeDrawer");
      localObject1 = null;
    }
    if (((FinderLikeDrawer)localObject1).fkp())
    {
      localObject1 = this.ATz;
      if (localObject1 == null)
      {
        s.bIx("likeDrawer");
        localObject1 = localFinderLikeDrawer1;
      }
      for (;;)
      {
        ((FinderLikeDrawer)localObject1).fdh();
        AppMethodBeat.o(166145);
        return;
      }
    }
    localFinderLikeDrawer1 = this.ATA;
    localObject1 = localFinderLikeDrawer1;
    if (localFinderLikeDrawer1 == null)
    {
      s.bIx("friendLikeDrawer");
      localObject1 = null;
    }
    if (((FinderLikeDrawer)localObject1).fkp())
    {
      localObject1 = this.ATA;
      if (localObject1 == null)
      {
        s.bIx("friendLikeDrawer");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((FinderLikeDrawer)localObject1).fdh();
        AppMethodBeat.o(166145);
        return;
      }
    }
    finish();
    AppMethodBeat.o(166145);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    int j = 0;
    AppMethodBeat.i(365771);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (s.p(str, z.bAW()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(365771);
      return 8;
    }
    AppMethodBeat.o(365771);
    return 1;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_timeline_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365709);
    Set localSet = ar.setOf(new Class[] { ag.class, ae.class, az.class, av.class, com.tencent.mm.plugin.finder.viewmodel.component.f.class, com.tencent.mm.plugin.finder.viewmodel.component.c.class, com.tencent.mm.plugin.finder.viewmodel.teenmode.b.class });
    AppMethodBeat.o(365709);
    return localSet;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(166143);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject1 = this.username;
    s.checkNotNull(localObject1);
    m localm = d.a.auT((String)localObject1);
    label208:
    int i;
    if (localm == null)
    {
      localObject1 = "";
      setMMTitle((String)localObject1);
      localObject1 = getLayoutInflater().inflate(e.f.finder_user_header, null);
      localObject2 = ((View)localObject1).findViewById(e.e.avatar_iv);
      s.s(localObject2, "header.findViewById(R.id.avatar_iv)");
      this.lKK = ((ImageView)localObject2);
      localObject2 = ((View)localObject1).findViewById(e.e.nick_tv);
      s.s(localObject2, "header.findViewById(R.id.nick_tv)");
      this.pWj = ((TextView)localObject2);
      localObject2 = ((View)localObject1).findViewById(e.e.signature_tv);
      s.s(localObject2, "header.findViewById(R.id.signature_tv)");
      this.Brh = ((TextView)localObject2);
      localObject2 = ((View)localObject1).findViewById(e.e.subscribe_btn);
      s.s(localObject2, "header.findViewById(R.id.subscribe_btn)");
      this.Bri = ((Button)localObject2);
      localObject2 = findViewById(e.e.rl_layout);
      s.s(localObject2, "findViewById(R.id.rl_layout)");
      this.ATx = ((RefreshLoadMoreLayout)localObject2);
      ((ImageView)((View)localObject1).findViewById(e.e.divider_item)).setVisibility(0);
      setBackBtn(new FinderProfileTimeLineUI..ExternalSyntheticLambda0(this));
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.eCp();
      if (localm != null) {
        break label692;
      }
      localObject1 = "";
      localObject4 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
      localObject2 = this.lKK;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("avatarIv");
        localObject1 = null;
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(localObject4, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject1 = com.tencent.mm.plugin.finder.view.f.GxF;
      localObject1 = (MMFragmentActivity)this;
      localObject2 = getWindow().getDecorView();
      s.s(localObject2, "window.decorView");
      if (!this.hHq) {
        break label710;
      }
      i = 1;
      label288:
      this.ATy = f.a.a((MMFragmentActivity)localObject1, (View)localObject2, i, false, 0, 24);
      localObject3 = (MMActivity)this;
      localObject2 = this.ATy;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("drawer");
        localObject1 = null;
      }
      localObject2 = this.username;
      s.checkNotNull(localObject2);
      this.AYo = new an.b((MMActivity)localObject3, (com.tencent.mm.plugin.finder.view.f)localObject1, (String)localObject2, this.AXX, this.ADo);
      localObject3 = (MMActivity)this;
      localObject2 = this.AYo;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      localObject3 = new an.c((MMActivity)localObject3, (an.b)localObject1);
      localObject2 = this.AYo;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      ((an.b)localObject1).a((an.c)localObject3);
      localObject1 = ((an.c)localObject3).ATx;
      if (localObject1 != null) {
        break label715;
      }
      s.bIx("rlLayout");
      localObject1 = null;
    }
    label692:
    label710:
    label715:
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.b)new an.c.b((an.c)localObject3));
      com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new an.c.c((an.c)localObject3));
      localObject1 = k.aeZF;
      localObject1 = k.d((AppCompatActivity)((an.c)localObject3).lzt).q(as.class);
      s.s(localObject1, "UICProvider.of(context).…rReporterUIC::class.java)");
      localObject4 = as.b((as)localObject1);
      if (localObject4 != null)
      {
        localObject2 = ((an.c)localObject3).mkw;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("recyclerView");
          localObject1 = null;
        }
        ((com.tencent.mm.plugin.finder.event.base.f)localObject4).o((RecyclerView)localObject1);
      }
      localObject2 = ((an.c)localObject3).mkw;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("recyclerView");
        localObject1 = null;
      }
      if (!(localObject1 instanceof FinderRecyclerView)) {
        break label727;
      }
      localObject2 = ((an.c)localObject3).mkw;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("recyclerView");
        localObject1 = null;
      }
      if (!(((RecyclerView)localObject1).getLayoutManager() instanceof LinearLayoutManager)) {
        break label727;
      }
      localObject2 = ((an.c)localObject3).mkw;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("recyclerView");
        localObject1 = null;
      }
      localObject4 = (FinderRecyclerView)localObject1;
      localObject2 = ((an.c)localObject3).mkw;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("recyclerView");
        localObject1 = null;
      }
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      if (localObject1 != null) {
        break label718;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(166143);
      throw ((Throwable)localObject1);
      localObject2 = localm.getNickname();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject2 = localm.amx();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label208;
      }
      localObject1 = "";
      break label208;
      i = 2;
      break label288;
    }
    label718:
    ((FinderRecyclerView)localObject4).a((LinearLayoutManager)localObject1);
    label727:
    ((BaseFinderFeedLoader)((an.c)localObject3).AYo.getFeedLoader()).register(((an.c)localObject3).ATF);
    localObject1 = ah.aiuX;
    this.AXZ = ((an.c)localObject3);
    localObject1 = FinderLikeDrawer.GAf;
    localObject1 = (Context)this;
    Object localObject2 = getWindow();
    s.s(localObject2, "window");
    Object localObject3 = FinderLikeDrawer.GAf;
    this.ATz = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fkN());
    localObject1 = FinderLikeDrawer.GAf;
    localObject1 = getContext();
    s.s(localObject1, "context");
    localObject1 = (Context)localObject1;
    localObject2 = getWindow();
    s.s(localObject2, "this@FinderProfileTimeLineUI.window");
    localObject3 = FinderLikeDrawer.GAf;
    this.ATA = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fkM());
    ((FrameLayout)findViewById(e.e.full_actionbar)).setVisibility(0);
    ((LinearLayout)findViewById(e.e.back_button)).setOnClickListener(new FinderProfileTimeLineUI..ExternalSyntheticLambda1(this));
    localObject3 = (TextView)findViewById(e.e.full_action_bar_title);
    Object localObject4 = (Context)getContext();
    if (localm == null)
    {
      localObject1 = "";
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject4, (CharSequence)localObject1));
      localObject1 = getWindow().getDecorView();
      s.s(localObject1, "window.decorView");
      ((View)localObject1).setSystemUiVisibility(((View)localObject1).getSystemUiVisibility() | 0x400 | 0x100);
      getWindow().setStatusBarColor(0);
      getController().s((Activity)this, getResources().getColor(e.b.transparent));
      com.tencent.mm.ui.c.h((Activity)this, false);
      localObject1 = getSupportActionBar();
      if (localObject1 != null)
      {
        ((ActionBar)localObject1).setBackgroundDrawable((Drawable)new ColorDrawable(0));
        ((ActionBar)localObject1).hide();
      }
      i = bf.getStatusBarHeight((Context)this);
      ((FrameLayout)findViewById(e.e.full_actionbar)).setPadding(0, i, 0, 0);
      getController().updataStatusBarIcon(true);
      setNavigationbarColor(-16777216);
      ((CoordinatorLayout)findViewById(e.e.rl_container)).setBackgroundColor(getResources().getColor(e.b.full_black));
      localObject1 = this.ATx;
      if (localObject1 != null) {
        break label1185;
      }
      s.bIx("rlLayout");
      localObject1 = null;
    }
    label1185:
    for (;;)
    {
      localObject2 = af.mU((Context)getContext()).inflate(e.f.load_more_footer_dark, null);
      s.s(localObject2, "getInflater(context).inf…d_more_footer_dark, null)");
      ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
      localObject1 = (WeImageView)findViewById(e.e.backBtnIv);
      if (localObject1 != null) {
        ((WeImageView)localObject1).setIconColor(getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_5));
      }
      AppMethodBeat.o(166143);
      return;
      localObject2 = localm.getNickname();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
    }
  }
  
  public final boolean isHideStatusBar()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(365759);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.view.f localf2 = this.ATy;
    com.tencent.mm.plugin.finder.view.f localf1 = localf2;
    if (localf2 == null)
    {
      s.bIx("drawer");
      localf1 = null;
    }
    localf1.g(paramInt1, paramIntent);
    AppMethodBeat.o(365759);
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
    this.AXX = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    this.ADo = getIntent().getLongExtra("KEY_FROM_TOPIC_ID", 0L);
    Log.i(this.TAG, "username " + this.username + ", selfFlag " + this.AXX + ", topicId " + this.ADo);
    if (Util.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(166142);
      return;
    }
    paramBundle = this.username;
    if (paramBundle == null) {}
    for (boolean bool1 = false;; bool1 = paramBundle.equals(z.bAW()))
    {
      boolean bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (this.AXX) {
          bool2 = true;
        }
      }
      this.hHq = bool2;
      initView();
      paramBundle = this.AXZ;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getRecyclerView();
        if (paramBundle != null) {
          paramBundle.a((RecyclerView.l)this.Brm);
        }
      }
      if (getIntent().hasExtra("key_extra_info"))
      {
        long l = getIntent().getLongExtra("KEY_FINDER_FEEDID", 0L);
        paramBundle = as.GSQ;
        paramBundle = getContext();
        s.s(paramBundle, "context");
        paramBundle = as.a.hu((Context)paramBundle);
        if (paramBundle != null) {
          paramBundle.K(l, this.username);
        }
      }
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, com.tencent.mm.plugin.datareport.a.a.a.xgx);
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).g(this, getClass().getSimpleName());
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, new FinderProfileTimeLineUI..ExternalSyntheticLambda4(this));
      AppMethodBeat.o(166142);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166150);
    Object localObject = this.AXZ;
    if (localObject != null)
    {
      localObject = ((an.c)localObject).getRecyclerView();
      if (localObject != null) {
        ((RecyclerView)localObject).b((RecyclerView.l)this.Brm);
      }
    }
    if (this.ATy != null)
    {
      com.tencent.mm.plugin.finder.view.f localf = this.ATy;
      localObject = localf;
      if (localf == null)
      {
        s.bIx("drawer");
        localObject = null;
      }
      ((com.tencent.mm.plugin.finder.view.f)localObject).onDetach();
    }
    super.onDestroy();
    localObject = this.AXZ;
    if (localObject != null)
    {
      ((BaseFinderFeedLoader)((an.c)localObject).AYo.getFeedLoader()).unregister(((an.c)localObject).ATF);
      ((an.c)localObject).AYo.onDetach();
      ((an.c)localObject).getRecyclerView().setAdapter(null);
    }
    AppMethodBeat.o(166150);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166149);
    super.onPause();
    Object localObject2 = (ce)com.tencent.mm.kernel.h.ax(ce.class);
    Object localObject1 = this.AXZ;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((an.c)localObject1).getRecyclerView())
    {
      ((ce)localObject2).b((RecyclerView)localObject1, q.w.DwP, "1", com.tencent.mm.plugin.finder.live.report.d.Dng);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
      localObject2 = getClass().getSimpleName();
      long l1 = System.currentTimeMillis();
      Object localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      long l2 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.dKU();
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      long l3 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.dKU();
      long l4 = System.currentTimeMillis();
      localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.dIY();
      String str1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      int i = c.b.zHb.value;
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      Object localObject4 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      localObject4 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
      s.s(str2, "getFinderContextId()");
      a.a.a(new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b((String)localObject1, (String)localObject2, l1 - l2, l3, l4, (String)localObject3, str1, i, (String)localObject4, str2, 1280));
      if (this.ATy == null) {
        s.bIx("drawer");
      }
      this.nmW.gR(false);
      AppMethodBeat.o(166149);
      return;
    }
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(166148);
    super.onResume();
    Object localObject1 = com.tencent.mm.plugin.finder.convert.d.AHD;
    Object localObject3 = this.username;
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    com.tencent.mm.plugin.finder.convert.d.avl((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject1 = this.username;
    s.checkNotNull(localObject1);
    localObject3 = d.a.auT((String)localObject1);
    if (localObject3 != null)
    {
      localObject1 = this.pWj;
      if (localObject1 == null)
      {
        s.bIx("nickTv");
        localObject1 = null;
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)this, (CharSequence)((m)localObject3).getNickname()));
        localObject1 = this.Brh;
        if (localObject1 != null) {
          break label369;
        }
        s.bIx("signatureTv");
        localObject1 = null;
        label111:
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)this, (CharSequence)((m)localObject3).field_signature));
        localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
        if (!d.a.a(((m)localObject3).getUsername(), null, false, false, 14)) {
          break label372;
        }
        localObject3 = this.Bri;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("subscribeBtn");
          localObject1 = null;
        }
        ((Button)localObject1).setText(e.h.has_follow_tip);
        localObject3 = this.Bri;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("subscribeBtn");
          localObject1 = null;
        }
        ((Button)localObject1).setBackgroundResource(e.d.transparent_background);
        localObject3 = this.Bri;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("subscribeBtn");
          localObject1 = null;
        }
        ((Button)localObject1).setTextColor(getResources().getColor(e.b.link_color_selector));
        localObject3 = this.Bri;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("subscribeBtn");
          localObject1 = null;
        }
        ((Button)localObject1).setOnClickListener(FinderProfileTimeLineUI..ExternalSyntheticLambda3.INSTANCE);
      }
    }
    else
    {
      label262:
      localObject1 = this.AXZ;
      if (localObject1 != null) {
        ((an.c)localObject1).AYo.onUIResume();
      }
      localObject3 = this.ATy;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("drawer");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.finder.view.f)localObject1).onUIResume();
      localObject3 = (ce)com.tencent.mm.kernel.h.ax(ce.class);
      localObject1 = this.AXZ;
      if (localObject1 != null) {
        break label486;
      }
    }
    label486:
    for (localObject1 = localObject2;; localObject1 = ((an.c)localObject1).getRecyclerView())
    {
      ((ce)localObject3).b((RecyclerView)localObject1, q.w.DwP, "1", com.tencent.mm.plugin.finder.live.report.d.Dnf);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.lY(System.currentTimeMillis());
      com.tencent.mm.model.d.a(this.nmW, this.TAG);
      AppMethodBeat.o(166148);
      return;
      break;
      label369:
      break label111;
      label372:
      localObject3 = this.Bri;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("subscribeBtn");
        localObject1 = null;
      }
      ((Button)localObject1).setText(e.h.finder_follow);
      localObject3 = this.Bri;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("subscribeBtn");
        localObject1 = null;
      }
      ((Button)localObject1).setTextColor(getResources().getColor(e.b.white_text_color));
      localObject3 = this.Bri;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("subscribeBtn");
        localObject1 = null;
      }
      ((Button)localObject1).setBackgroundResource(e.d.btn_solid_green_small);
      localObject3 = this.Bri;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("subscribeBtn");
        localObject1 = null;
      }
      ((Button)localObject1).setOnClickListener(FinderProfileTimeLineUI..ExternalSyntheticLambda2.INSTANCE);
      break label262;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(365043);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(365043);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(365034);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(paramRecyclerView, q.w.DwP, "1", com.tencent.mm.plugin.finder.live.report.d.Dne);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(365034);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI
 * JD-Core Version:    0.7.0.1
 */