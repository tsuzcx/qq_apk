package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.s.a;
import com.tencent.mm.plugin.finder.live.report.s.bc;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.utils.ab;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.m;
import com.tencent.mm.plugin.finder.viewmodel.component.m.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import java.util.HashMap;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionBarAvatarIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getActionBarAvatarIv", "()Landroid/widget/ImageView;", "actionBarAvatarIv$delegate", "Lkotlin/Lazy;", "actionBarFollowText", "Landroid/widget/TextView;", "getActionBarFollowText", "()Landroid/widget/TextView;", "actionBarFollowText$delegate", "actionBarFollowedIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getActionBarFollowedIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarFollowedIv$delegate", "actionBarNicknameTv", "getActionBarNicknameTv", "actionBarNicknameTv$delegate", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "getAppBarLayout", "()Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout$delegate", "appBarLayoutOffset", "", "backBtn", "Landroid/widget/LinearLayout;", "getBackBtn", "()Landroid/widget/LinearLayout;", "backBtn$delegate", "backBtnIv", "getBackBtnIv", "backBtnIv$delegate", "contentLayout", "Lcom/tencent/mm/view/HardTouchableLayout;", "getContentLayout", "()Lcom/tencent/mm/view/HardTouchableLayout;", "contentLayout$delegate", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "getCoordinatorLayout", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout$delegate", "followContainer", "Landroid/widget/FrameLayout;", "getFollowContainer", "()Landroid/widget/FrameLayout;", "followContainer$delegate", "hasFinderEntry", "", "isSelf", "()Z", "isSelf$delegate", "isSelfFlag", "isSelfFlag$delegate", "lastActionBarProgress", "", "livePostUic", "Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLivePostBtnUIC;", "getLivePostUic", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLivePostBtnUIC;", "livePostUic$delegate", "moreBtn", "getMoreBtn", "moreBtn$delegate", "moreBtnIv", "getMoreBtnIv", "moreBtnIv$delegate", "myActionBar", "getMyActionBar", "myActionBar$delegate", "normalActionBarColor", "postBtn", "getPostBtn", "postBtn$delegate", "postBtnIv", "getPostBtnIv", "postBtnIv$delegate", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "Lkotlin/collections/HashMap;", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "userInfoLayout", "getUserInfoLayout", "userInfoLayout$delegate", "username", "", "changeFollowView", "", "progress", "alpha", "doClickMoreAction", "doClickPostAction", "doClickPostLiveAction", "doShowPostBottomSheet", "fixActionBarStatus", "hasSetCoverImg", "hideActionBar", "initCustomActionBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisibleStats", "view", "Landroid/view/View;", "visibleStat", "Companion", "OnOffsetChangedListener", "OverScrollListener", "plugin-finder_release"})
public final class a
  extends UIComponent
  implements com.tencent.mm.an.i
{
  public static final a zQs;
  private String username;
  private final kotlin.f wYL;
  private final kotlin.f wYM;
  private final kotlin.f wYN;
  private final kotlin.f wYO;
  private final kotlin.f wYP;
  private final kotlin.f wYQ;
  private final kotlin.f wYR;
  private final int wYT;
  private float wYW;
  private int wYX;
  private HashMap<Integer, dna> xSN;
  private final kotlin.f xjx;
  private final kotlin.f yOZ;
  private final kotlin.f zQh;
  private final kotlin.f zQi;
  final kotlin.f zQj;
  final kotlin.f zQk;
  private final kotlin.f zQl;
  private final kotlin.f zQm;
  private final kotlin.f zQn;
  private final kotlin.f zQo;
  private final kotlin.f zQp;
  private final boolean zQq;
  private final kotlin.f zQr;
  
  static
  {
    AppMethodBeat.i(255571);
    zQs = new a((byte)0);
    AppMethodBeat.o(255571);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255568);
    this.yOZ = kotlin.g.ar((kotlin.g.a.a)new h(paramAppCompatActivity));
    this.zQh = kotlin.g.ar((kotlin.g.a.a)new ah(paramAppCompatActivity));
    this.zQi = kotlin.g.ar((kotlin.g.a.a)new v(paramAppCompatActivity));
    this.zQj = kotlin.g.ar((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.zQk = kotlin.g.ar((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.wYL = kotlin.g.ar((kotlin.g.a.a)new g(paramAppCompatActivity));
    this.wYP = kotlin.g.ar((kotlin.g.a.a)new i(paramAppCompatActivity));
    this.zQl = kotlin.g.ar((kotlin.g.a.a)new ai(paramAppCompatActivity));
    this.wYR = kotlin.g.ar((kotlin.g.a.a)new ab(paramAppCompatActivity));
    this.wYQ = kotlin.g.ar((kotlin.g.a.a)new z(paramAppCompatActivity));
    this.zQm = kotlin.g.ar((kotlin.g.a.a)new aa(paramAppCompatActivity));
    this.zQn = kotlin.g.ar((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.wYO = kotlin.g.ar((kotlin.g.a.a)new aj(paramAppCompatActivity));
    this.wYM = kotlin.g.ar((kotlin.g.a.a)new k(paramAppCompatActivity));
    this.zQo = kotlin.g.ar((kotlin.g.a.a)new c(paramAppCompatActivity));
    this.wYN = kotlin.g.ar((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.wYT = paramAppCompatActivity.getResources().getColor(b.c.BG_2);
    this.username = "";
    this.xjx = kotlin.g.ar((kotlin.g.a.a)new x(this));
    this.zQp = kotlin.g.ar((kotlin.g.a.a)new w(this));
    this.zQq = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry();
    this.xSN = new HashMap();
    this.zQr = kotlin.g.ar((kotlin.g.a.a)new y(paramAppCompatActivity));
    AppMethodBeat.o(255568);
  }
  
  private static void ah(View paramView, int paramInt)
  {
    AppMethodBeat.i(255561);
    if (paramView.getVisibility() != paramInt) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(255561);
  }
  
  private final LinearLayout dNi()
  {
    AppMethodBeat.i(255530);
    LinearLayout localLinearLayout = (LinearLayout)this.zQh.getValue();
    AppMethodBeat.o(255530);
    return localLinearLayout;
  }
  
  private final LinearLayout dNk()
  {
    AppMethodBeat.i(255539);
    LinearLayout localLinearLayout = (LinearLayout)this.wYQ.getValue();
    AppMethodBeat.o(255539);
    return localLinearLayout;
  }
  
  private final ImageView dNl()
  {
    AppMethodBeat.i(255545);
    ImageView localImageView = (ImageView)this.zQo.getValue();
    AppMethodBeat.o(255545);
    return localImageView;
  }
  
  private final AppBarLayout dmO()
  {
    AppMethodBeat.i(255534);
    AppBarLayout localAppBarLayout = (AppBarLayout)this.wYL.getValue();
    AppMethodBeat.o(255534);
    return localAppBarLayout;
  }
  
  private final TextView dmP()
  {
    AppMethodBeat.i(255547);
    TextView localTextView = (TextView)this.wYN.getValue();
    AppMethodBeat.o(255547);
    return localTextView;
  }
  
  private final LinearLayout dmQ()
  {
    AppMethodBeat.i(255543);
    LinearLayout localLinearLayout = (LinearLayout)this.wYO.getValue();
    AppMethodBeat.o(255543);
    return localLinearLayout;
  }
  
  private final com.tencent.mm.plugin.finder.api.i getProfileContact()
  {
    AppMethodBeat.i(255551);
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject = d.a.aAK(this.username);
    AppMethodBeat.o(255551);
    return localObject;
  }
  
  private final boolean isSelf()
  {
    AppMethodBeat.i(255549);
    boolean bool = ((Boolean)this.zQp.getValue()).booleanValue();
    AppMethodBeat.o(255549);
    return bool;
  }
  
  public final FrameLayout dNj()
  {
    AppMethodBeat.i(255532);
    FrameLayout localFrameLayout = (FrameLayout)this.zQi.getValue();
    AppMethodBeat.o(255532);
    return localFrameLayout;
  }
  
  public final LinearLayout dmR()
  {
    AppMethodBeat.i(255538);
    LinearLayout localLinearLayout = (LinearLayout)this.wYR.getValue();
    AppMethodBeat.o(255538);
    return localLinearLayout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255556);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getStringExtra("finder_username");
    p.j(paramBundle, "activity.intent.getStrin…leUI.KEY_FINDER_USERNAME)");
    this.username = paramBundle;
    com.tencent.mm.kernel.h.aGY().a(3736, (com.tencent.mm.an.i)this);
    paramBundle = getActivity().getWindow();
    p.j(paramBundle, "activity.window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "activity.window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    com.tencent.mm.ui.c.f((Activity)getActivity(), false);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    int i = ax.getStatusBarHeight((Context)getActivity());
    paramBundle = dmR();
    p.j(paramBundle, "myActionBar");
    paramBundle = paramBundle.getLayoutParams();
    paramBundle.height += i;
    Object localObject1 = dmR();
    p.j(localObject1, "myActionBar");
    ((LinearLayout)localObject1).setLayoutParams(paramBundle);
    dmR().setPadding(0, i, 0, 0);
    paramBundle = dmQ();
    p.j(paramBundle, "userInfoLayout");
    paramBundle.setAlpha(0.0F);
    localObject1 = getProfileContact();
    if (localObject1 == null) {}
    for (;;)
    {
      paramBundle = dmO();
      localObject1 = new b();
      Object localObject2 = dmO();
      p.j(localObject2, "appBarLayout");
      ((b)localObject1).c((AppBarLayout)localObject2, 0);
      paramBundle.a((AppBarLayout.b)localObject1);
      ((LinearLayout)this.yOZ.getValue()).setOnClickListener((View.OnClickListener)new ac(this));
      paramBundle = dNi();
      p.j(paramBundle, "postBtn");
      paramBundle.setVisibility(8);
      paramBundle = dNk();
      p.j(paramBundle, "moreBtn");
      paramBundle.setVisibility(8);
      if ((!isSelf()) || (!((Boolean)this.xjx.getValue()).booleanValue())) {
        break;
      }
      paramBundle = dNi();
      p.j(paramBundle, "postBtn");
      paramBundle.setVisibility(0);
      dNi().setOnClickListener((View.OnClickListener)new ad(this));
      paramBundle = n.zWF;
      n.f((Context)getActivity(), 1, 1);
      AppMethodBeat.o(255556);
      return;
      paramBundle = dmP();
      p.j(paramBundle, "actionBarNicknameTv");
      paramBundle.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)((com.tencent.mm.plugin.finder.api.i)localObject1).getNickname()));
      paramBundle = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramBundle = com.tencent.mm.plugin.finder.loader.t.dJh();
      localObject1 = new com.tencent.mm.plugin.finder.loader.e(((com.tencent.mm.plugin.finder.api.i)localObject1).field_avatarUrl);
      localObject2 = dNl();
      p.j(localObject2, "actionBarAvatarIv");
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramBundle.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
    }
    if (this.zQq)
    {
      paramBundle = dNj();
      p.j(paramBundle, "followContainer");
      ah((View)paramBundle, 8);
      paramBundle = dNk();
      p.j(paramBundle, "moreBtn");
      paramBundle.setVisibility(0);
      dNk().setOnClickListener((View.OnClickListener)new ae(this));
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
      {
        dNk().setOnLongClickListener((View.OnLongClickListener)new af(this));
        AppMethodBeat.o(255556);
      }
    }
    else
    {
      paramBundle = dNk();
      p.j(paramBundle, "moreBtn");
      paramBundle.setVisibility(0);
      dNk().setOnClickListener((View.OnClickListener)new ag(this));
    }
    AppMethodBeat.o(255556);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255560);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(3736, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(255560);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255558);
    super.onResume();
    AppMethodBeat.o(255558);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(255565);
    p.k(paramq, "scene");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof cr)))
    {
      Object localObject = new StringBuilder("username=").append(this.username).append(", scene username=");
      paramString = ((cr)paramq).dpc();
      if (paramString != null) {}
      for (paramString = paramString.username;; paramString = null)
      {
        Log.i("Finder.SelfProfileActionBarUIC", paramString);
        paramString = ((cr)paramq).dpc();
        if (paramString != null)
        {
          paramString = paramString.username;
          if (paramString != null)
          {
            p.j(paramString, "it");
            this.username = paramString;
          }
        }
        paramq = getProfileContact();
        if (paramq != null) {
          break;
        }
        AppMethodBeat.o(255565);
        return;
      }
      paramString = dmP();
      p.j(paramString, "actionBarNicknameTv");
      paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)paramq.getNickname()));
      paramString = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramString = com.tencent.mm.plugin.finder.loader.t.dJh();
      paramq = new com.tencent.mm.plugin.finder.loader.e(paramq.field_avatarUrl);
      localObject = dNl();
      p.j(localObject, "actionBarAvatarIv");
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramString.a(paramq, (ImageView)localObject, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
    }
    AppMethodBeat.o(255565);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$Companion;", "", "()V", "MENU_ID_ACCOUNT_DETAIL", "", "MENU_ID_CREATE_NOTICE", "MENU_ID_EXPOSE", "MENU_ID_OPEN_LIVE", "MENU_ID_POST_FEED", "MENU_ID_POST_LIVE", "MENU_ID_RECOMMEND", "MENU_ID_SET_NO_SEE", "REQUEST_CODE_POST_ACTIONSHEET", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    aa(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ab
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    ab(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ac
    implements View.OnClickListener
  {
    ac(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(265134);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.ui.component.g.Xox;
      ((h)com.tencent.mm.ui.component.g.b(this.zQt.getActivity()).i(h.class)).zRk = true;
      this.zQt.getActivity().finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265134);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ad
    implements View.OnClickListener
  {
    ad(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291196);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.f(this.zQt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291196);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ae
    implements View.OnClickListener
  {
    ae(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(225150);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.g(this.zQt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(225150);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class af
    implements View.OnLongClickListener
  {
    af(a parama) {}
    
    public final boolean onLongClick(View paramView)
    {
      String str = null;
      AppMethodBeat.i(274740);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
      localObject = new StringBuilder();
      paramView = j.zSy;
      paramView = (j.b)j.access$getUserExtInfoCache$cp().get(a.h(this.zQt));
      if (paramView != null) {}
      for (paramView = paramView.zSz;; paramView = null)
      {
        ((StringBuilder)localObject).append("finderUsername:" + a.h(this.zQt) + '\n');
        StringBuilder localStringBuilder = new StringBuilder("noticeId:");
        if (paramView != null) {
          str = paramView.fwt;
        }
        ((StringBuilder)localObject).append(str);
        paramView = m.BiL;
        paramView = (Context)this.zQt.getActivity();
        str = ((StringBuilder)localObject).toString();
        p.j(str, "sb.toString()");
        m.a.aN(paramView, str);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(274740);
        return true;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ag
    implements View.OnClickListener
  {
    ag(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(287249);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.g(this.zQt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287249);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ah
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    ah(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ai
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    ai(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aj
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    aj(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$OnOffsetChangedListener;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC;)V", "onOffsetChanged", "", "view", "Lcom/google/android/material/appbar/AppBarLayout;", "offset", "", "plugin-finder_release"})
  public final class b
    implements AppBarLayout.b
  {
    public final void c(AppBarLayout paramAppBarLayout, int paramInt)
    {
      AppMethodBeat.i(268378);
      p.k(paramAppBarLayout, "view");
      a.a(this.zQt, paramInt);
      float f2 = Math.abs(paramInt) * 1.0F / paramAppBarLayout.getTotalScrollRange();
      if (f2 == a.a(this.zQt))
      {
        AppMethodBeat.o(268378);
        return;
      }
      a.a(this.zQt, f2);
      float f1;
      if (f2 < 0.5F)
      {
        f1 = (0.5F - f2) / 0.5F;
        this.zQt.dmR().setBackgroundColor(this.zQt.getResources().getColor(b.c.transparent));
        paramAppBarLayout = this.zQt.getActivity();
        if (paramAppBarLayout == null)
        {
          paramAppBarLayout = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(268378);
          throw paramAppBarLayout;
        }
        ((MMActivity)paramAppBarLayout).getController().updataStatusBarIcon(ar.isDarkMode());
        paramAppBarLayout = this.zQt.getActivity();
        if (paramAppBarLayout == null)
        {
          paramAppBarLayout = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(268378);
          throw paramAppBarLayout;
        }
        ((MMActivity)paramAppBarLayout).getController().q((Activity)this.zQt.getActivity(), this.zQt.getResources().getColor(b.c.transparent));
        paramAppBarLayout = a.b(this.zQt);
        p.j(paramAppBarLayout, "userInfoLayout");
        paramAppBarLayout.setAlpha(0.0F);
        a.a(this.zQt, f2, f1);
      }
      for (;;)
      {
        paramAppBarLayout = a.d(this.zQt);
        p.j(paramAppBarLayout, "backBtnIv");
        paramAppBarLayout.setAlpha(f1);
        paramAppBarLayout = a.e(this.zQt);
        p.j(paramAppBarLayout, "postBtnIv");
        paramAppBarLayout.setAlpha(f1);
        AppMethodBeat.o(268378);
        return;
        f1 = (f2 - 0.5F) / 0.5F;
        paramInt = (int)(255.0F * f1);
        this.zQt.dmR().setBackgroundColor(au.fG(a.c(this.zQt), paramInt));
        paramAppBarLayout = this.zQt.getActivity();
        if (paramAppBarLayout == null)
        {
          paramAppBarLayout = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(268378);
          throw paramAppBarLayout;
        }
        ((MMActivity)paramAppBarLayout).getController().setStatusBarColor(au.fG(a.c(this.zQt), paramInt));
        paramAppBarLayout = a.b(this.zQt);
        p.j(paramAppBarLayout, "userInfoLayout");
        paramAppBarLayout.setAlpha(f1);
        a.a(this.zQt, f2, f1);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<AppBarLayout>
  {
    g(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    h(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    i(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/HardTouchableLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<HardTouchableLayout>
  {
    j(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<CoordinatorLayout>
  {
    k(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class l
    implements q.f
  {
    l(a parama) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(270688);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        Object localObject = a.i(this.zQt);
        if (localObject != null)
        {
          i = ((com.tencent.mm.plugin.finder.api.i)localObject).field_extFlag;
          if ((i & 0x100000) == 0) {
            paramo.mn(10002, b.j.finder_profile_recommend);
          }
          if ((a.j(this.zQt)) && ((p.h(a.h(this.zQt), z.bdh()) ^ true)))
          {
            localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
            localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
            if (!com.tencent.mm.plugin.finder.utils.aj.k(d.a.aAK(a.h(this.zQt)))) {
              break label165;
            }
            paramo.mn(10010, b.j.finder_unblock_his_feed);
          }
        }
        for (;;)
        {
          localObject = com.tencent.mm.kernel.h.aHG();
          p.j(localObject, "MMKernel.storage()");
          localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VCn, "");
          if (localObject != null) {
            break label179;
          }
          paramo = new kotlin.t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(270688);
          throw paramo;
          i = 0;
          break;
          label165:
          paramo.mn(10010, b.j.finder_block_his_feed);
        }
        label179:
        if (((CharSequence)localObject).length() <= 0) {
          break label228;
        }
      }
      label228:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          paramo.mn(10011, b.j.finder_account_detail);
        }
        paramo.mn(10004, b.j.finder_profile_expose);
        AppMethodBeat.o(270688);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class m
    implements q.g
  {
    m(a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(272852);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(272852);
        return;
        paramMenuItem = a.i(this.zQt);
        if (paramMenuItem != null)
        {
          localObject1 = ac.AEJ;
          localObject2 = this.zQt.getActivity();
          if (localObject2 == null)
          {
            paramMenuItem = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(272852);
            throw paramMenuItem;
          }
          ac.a.a((ac.a)localObject1, (MMActivity)localObject2, paramMenuItem);
          AppMethodBeat.o(272852);
          return;
        }
        AppMethodBeat.o(272852);
        return;
        paramMenuItem = this.zQt.getActivity().getString(b.j.finder_expose_url, new Object[] { LocaleUtil.getApplicationLanguage(), a.h(this.zQt) });
        p.j(paramMenuItem, "activity.getString(R.str…tionLanguage(), username)");
        Object localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramMenuItem);
        com.tencent.mm.by.c.b((Context)this.zQt.getActivity(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        AppMethodBeat.o(272852);
        return;
        paramMenuItem = com.tencent.mm.ui.component.g.Xox;
        paramMenuItem = (j)com.tencent.mm.ui.component.g.b(this.zQt.getActivity()).i(j.class);
        localObject1 = new aa.a();
        Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
        ((aa.a)localObject1).aaBx = com.tencent.mm.plugin.finder.utils.aj.k(d.a.aAK(paramMenuItem.username));
        localObject2 = com.tencent.mm.plugin.finder.upload.action.f.ABS;
        localObject2 = paramMenuItem.username;
        if (!((aa.a)localObject1).aaBx) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          com.tencent.mm.plugin.finder.upload.action.f.e(2, (String)localObject2, bool1);
          if (((aa.a)localObject1).aaBx) {
            break;
          }
          localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
          if (!d.a.aAN(paramMenuItem.username)) {
            break;
          }
          localObject2 = new com.tencent.mm.ui.widget.a.e((Context)paramMenuItem.getContext(), 1, true);
          ((com.tencent.mm.ui.widget.a.e)localObject2).q((CharSequence)paramMenuItem.getContext().getResources().getString(b.j.finder_mod_block_bottom_sheet_title), 17);
          ((com.tencent.mm.ui.widget.a.e)localObject2).a((q.f)new j.by(paramMenuItem));
          ((com.tencent.mm.ui.widget.a.e)localObject2).a((q.g)new j.bz(paramMenuItem, (aa.a)localObject1));
          ((com.tencent.mm.ui.widget.a.e)localObject2).eik();
          AppMethodBeat.o(272852);
          return;
        }
        if (!((aa.a)localObject1).aaBx) {}
        for (bool1 = bool2;; bool1 = false)
        {
          j.b(paramMenuItem, bool1);
          AppMethodBeat.o(272852);
          return;
        }
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.fR((Context)this.zQt.getActivity());
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    n(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    o(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class p
    implements q.f
  {
    p(a parama, AppCompatActivity paramAppCompatActivity) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      Object localObject1 = null;
      AppMethodBeat.i(272598);
      p.j(paramo, "it");
      Object localObject2;
      if (paramo.hJO())
      {
        paramo.mn(1, b.j.app_field_mmsight);
        paramo.mn(2, b.j.app_field_select_new_pic);
        localObject2 = ab.AEA;
        ab.a(a.m(this.zQt), paramo, (Activity)this.zQu);
      }
      paramo = n.zWF;
      paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramo = aj.a.fZ((Context)this.zQu);
      if (paramo != null) {}
      for (paramo = paramo.ekY();; paramo = null)
      {
        n.b(0, "post_acionsheet_camera", "", paramo);
        paramo = n.zWF;
        paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject2 = aj.a.fZ((Context)this.zQu);
        paramo = localObject1;
        if (localObject2 != null) {
          paramo = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).ekY();
        }
        n.b(0, "post_actionsheet_album", "", paramo);
        AppMethodBeat.o(272598);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class q
    implements q.g
  {
    q(a parama, AppCompatActivity paramAppCompatActivity, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      ab localab = null;
      AppMethodBeat.i(272565);
      Intent localIntent = new Intent();
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1)
      {
        localIntent.putExtra("key_finder_post_router", 2);
        paramMenuItem = n.zWF;
        paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramMenuItem = aj.a.fZ((Context)this.zQu);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.ekY();
          n.b(1, "post_acionsheet_camera", "", paramMenuItem);
        }
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 1);
        localIntent.putExtra("key_finder_post_id", this.xNP);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.zQu, localIntent);
        AppMethodBeat.o(272565);
        return;
        paramMenuItem = null;
        break;
        if (paramMenuItem.getItemId() == 2)
        {
          localIntent.putExtra("key_finder_post_router", 3);
          paramMenuItem = n.zWF;
          paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          com.tencent.mm.plugin.finder.viewmodel.component.aj localaj = aj.a.fZ((Context)this.zQu);
          paramMenuItem = localab;
          if (localaj != null) {
            paramMenuItem = localaj.ekY();
          }
          n.b(1, "post_actionsheet_album", "", paramMenuItem);
        }
        else if (a.m(this.zQt).containsKey(Integer.valueOf(paramMenuItem.getItemId())))
        {
          localab = ab.AEA;
          ab.a((Context)this.zQt.getActivity(), (dna)a.m(this.zQt).get(Integer.valueOf(paramMenuItem.getItemId())));
          paramMenuItem = com.tencent.mm.plugin.finder.report.k.zWs;
          com.tencent.mm.plugin.finder.report.k.av(2, false);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class r
    implements e.b
  {
    public static final r zQv;
    
    static
    {
      AppMethodBeat.i(245225);
      zQv = new r();
      AppMethodBeat.o(245225);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(245223);
      com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.zWs;
      com.tencent.mm.plugin.finder.report.k.Pw(6);
      AppMethodBeat.o(245223);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class s
    implements q.f
  {
    s(a parama) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(282892);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.mn(10012, b.j.finder_post_new);
        com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
        if (((j)com.tencent.mm.ui.component.g.b(this.zQt.getActivity()).i(j.class)).zSl) {
          paramo.mn(10013, b.j.finder_profile_post_live);
        }
      }
      AppMethodBeat.o(282892);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class t
    implements q.g
  {
    t(a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(279697);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(279697);
        return;
        paramMenuItem = n.zWF;
        n.f((Context)this.zQt.getActivity(), 2, 2);
        a.k(this.zQt);
        AppMethodBeat.o(279697);
        return;
        paramMenuItem = n.zWF;
        n.f((Context)this.zQt.getActivity(), 2, 3);
        paramMenuItem = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.dDm().a(s.bc.yKP);
        paramMenuItem = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDK.jWO, "");
        a.l(this.zQt);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class u
    implements e.b
  {
    u(a parama) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(285707);
      n localn = n.zWF;
      n.f((Context)this.zQt.getActivity(), 2, 4);
      AppMethodBeat.o(285707);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
  {
    v(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    w(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    x(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLivePostBtnUIC;", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.viewmodel.component.d>
  {
    y(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class z
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    z(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.a
 * JD-Core Version:    0.7.0.1
 */