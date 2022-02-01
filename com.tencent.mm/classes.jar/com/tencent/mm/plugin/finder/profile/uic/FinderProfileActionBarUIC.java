package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.b;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.report.live.s.ao;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLivePostBtnUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import java.util.HashMap;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.z.a;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionBarAvatarIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getActionBarAvatarIv", "()Landroid/widget/ImageView;", "actionBarAvatarIv$delegate", "Lkotlin/Lazy;", "actionBarFollowText", "Landroid/widget/TextView;", "getActionBarFollowText", "()Landroid/widget/TextView;", "actionBarFollowText$delegate", "actionBarFollowedIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getActionBarFollowedIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarFollowedIv$delegate", "actionBarNicknameTv", "getActionBarNicknameTv", "actionBarNicknameTv$delegate", "actionBarRedPackClose", "getActionBarRedPackClose", "actionBarRedPackClose$delegate", "actionBarRedPackLayout", "Landroid/widget/LinearLayout;", "getActionBarRedPackLayout", "()Landroid/widget/LinearLayout;", "actionBarRedPackLayout$delegate", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "getAppBarLayout", "()Landroid/support/design/widget/AppBarLayout;", "appBarLayout$delegate", "appBarLayoutOffset", "", "backBtn", "getBackBtn", "backBtn$delegate", "backBtnIv", "getBackBtnIv", "backBtnIv$delegate", "contentLayout", "Lcom/tencent/mm/view/HardTouchableLayout;", "getContentLayout", "()Lcom/tencent/mm/view/HardTouchableLayout;", "contentLayout$delegate", "coordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "getCoordinatorLayout", "()Landroid/support/design/widget/CoordinatorLayout;", "coordinatorLayout$delegate", "followContainer", "Landroid/widget/FrameLayout;", "getFollowContainer", "()Landroid/widget/FrameLayout;", "followContainer$delegate", "hasFinderEntry", "", "isSelf", "()Z", "isSelf$delegate", "isSelfFlag", "isSelfFlag$delegate", "lastActionBarProgress", "", "livePostUic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "getLivePostUic", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "livePostUic$delegate", "moreBtn", "getMoreBtn", "moreBtn$delegate", "moreBtnIv", "getMoreBtnIv", "moreBtnIv$delegate", "myActionBar", "getMyActionBar", "myActionBar$delegate", "normalActionBarColor", "postBtn", "getPostBtn", "postBtn$delegate", "postBtnIv", "getPostBtnIv", "postBtnIv$delegate", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "Lkotlin/collections/HashMap;", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "userInfoLayout", "getUserInfoLayout", "userInfoLayout$delegate", "username", "", "changeFollowView", "", "progress", "alpha", "doClickMoreAction", "doClickPostAction", "doClickPostLiveAction", "doShowPostBottomSheet", "fixActionBarStatus", "hasSetCoverImg", "hideActionBar", "initCustomActionBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshRadPack", "setVisibleStats", "view", "Landroid/view/View;", "visibleStat", "Companion", "OnOffsetChangedListener", "OverScrollListener", "plugin-finder_release"})
public final class FinderProfileActionBarUIC
  extends UIComponent
  implements com.tencent.mm.ak.i
{
  public static final a vam;
  private final f tZl;
  private final f uZN;
  private final f uZO;
  private final f uZP;
  final f uZQ;
  final f uZR;
  private final f uZS;
  private final f uZT;
  private final f uZU;
  private final f uZV;
  private final f uZW;
  private final f uZX;
  private final f uZY;
  private final f uZZ;
  private HashMap<Integer, ddk> udg;
  private String username;
  private final f vaa;
  private final f vab;
  private final f vac;
  private final f vad;
  private final f vae;
  private final int vaf;
  private final f vag;
  private final boolean vah;
  private float vai;
  private final f vaj;
  private int vak;
  
  static
  {
    AppMethodBeat.i(250079);
    vam = new a((byte)0);
    AppMethodBeat.o(250079);
  }
  
  public FinderProfileActionBarUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250078);
    this.uZN = kotlin.g.ah((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.uZO = kotlin.g.ah((kotlin.g.a.a)new ah(paramAppCompatActivity));
    this.uZP = kotlin.g.ah((kotlin.g.a.a)new v(paramAppCompatActivity));
    this.uZQ = kotlin.g.ah((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.uZR = kotlin.g.ah((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.uZS = kotlin.g.ah((kotlin.g.a.a)new i(paramAppCompatActivity));
    this.uZT = kotlin.g.ah((kotlin.g.a.a)new k(paramAppCompatActivity));
    this.uZU = kotlin.g.ah((kotlin.g.a.a)new ai(paramAppCompatActivity));
    this.uZV = kotlin.g.ah((kotlin.g.a.a)new ab(paramAppCompatActivity));
    this.uZW = kotlin.g.ah((kotlin.g.a.a)new z(paramAppCompatActivity));
    this.uZX = kotlin.g.ah((kotlin.g.a.a)new aa(paramAppCompatActivity));
    this.uZY = kotlin.g.ah((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.uZZ = kotlin.g.ah((kotlin.g.a.a)new al(paramAppCompatActivity));
    this.vaa = kotlin.g.ah((kotlin.g.a.a)new m(paramAppCompatActivity));
    this.vab = kotlin.g.ah((kotlin.g.a.a)new c(paramAppCompatActivity));
    this.vac = kotlin.g.ah((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.vad = kotlin.g.ah((kotlin.g.a.a)new h(paramAppCompatActivity));
    this.vae = kotlin.g.ah((kotlin.g.a.a)new g(paramAppCompatActivity));
    this.vaf = paramAppCompatActivity.getResources().getColor(2131099650);
    this.username = "";
    this.tZl = kotlin.g.ah((kotlin.g.a.a)new x(this));
    this.vag = kotlin.g.ah((kotlin.g.a.a)new w(this));
    this.vah = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry();
    this.udg = new HashMap();
    this.vaj = kotlin.g.ah((kotlin.g.a.a)new y(paramAppCompatActivity));
    AppMethodBeat.o(250078);
  }
  
  private static void ah(View paramView, int paramInt)
  {
    AppMethodBeat.i(250076);
    if (paramView.getVisibility() != paramInt) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(250076);
  }
  
  private final LinearLayout dmd()
  {
    AppMethodBeat.i(250062);
    LinearLayout localLinearLayout = (LinearLayout)this.uZO.getValue();
    AppMethodBeat.o(250062);
    return localLinearLayout;
  }
  
  private final AppBarLayout dmf()
  {
    AppMethodBeat.i(250064);
    AppBarLayout localAppBarLayout = (AppBarLayout)this.uZS.getValue();
    AppMethodBeat.o(250064);
    return localAppBarLayout;
  }
  
  private final LinearLayout dmh()
  {
    AppMethodBeat.i(250066);
    LinearLayout localLinearLayout = (LinearLayout)this.uZW.getValue();
    AppMethodBeat.o(250066);
    return localLinearLayout;
  }
  
  private final LinearLayout dmi()
  {
    AppMethodBeat.i(250067);
    LinearLayout localLinearLayout = (LinearLayout)this.uZZ.getValue();
    AppMethodBeat.o(250067);
    return localLinearLayout;
  }
  
  private final ImageView dmj()
  {
    AppMethodBeat.i(250068);
    ImageView localImageView = (ImageView)this.vab.getValue();
    AppMethodBeat.o(250068);
    return localImageView;
  }
  
  private final TextView dmk()
  {
    AppMethodBeat.i(250069);
    TextView localTextView = (TextView)this.vac.getValue();
    AppMethodBeat.o(250069);
    return localTextView;
  }
  
  private final LinearLayout dml()
  {
    AppMethodBeat.i(250070);
    LinearLayout localLinearLayout = (LinearLayout)this.vad.getValue();
    AppMethodBeat.o(250070);
    return localLinearLayout;
  }
  
  private final com.tencent.mm.plugin.finder.api.g getProfileContact()
  {
    AppMethodBeat.i(250073);
    Object localObject = com.tencent.mm.plugin.finder.api.c.tsp;
    localObject = c.a.asG(this.username);
    AppMethodBeat.o(250073);
    return localObject;
  }
  
  private final boolean isSelf()
  {
    AppMethodBeat.i(250072);
    boolean bool = ((Boolean)this.vag.getValue()).booleanValue();
    AppMethodBeat.o(250072);
    return bool;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(250071);
    boolean bool = ((Boolean)this.tZl.getValue()).booleanValue();
    AppMethodBeat.o(250071);
    return bool;
  }
  
  public final FrameLayout dme()
  {
    AppMethodBeat.i(250063);
    FrameLayout localFrameLayout = (FrameLayout)this.uZP.getValue();
    AppMethodBeat.o(250063);
    return localFrameLayout;
  }
  
  public final LinearLayout dmg()
  {
    AppMethodBeat.i(250065);
    LinearLayout localLinearLayout = (LinearLayout)this.uZV.getValue();
    AppMethodBeat.o(250065);
    return localLinearLayout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250074);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getStringExtra("finder_username");
    p.g(paramBundle, "activity.intent.getStrin…leUI.KEY_FINDER_USERNAME)");
    this.username = paramBundle;
    com.tencent.mm.kernel.g.azz().a(3736, (com.tencent.mm.ak.i)this);
    paramBundle = getActivity().getWindow();
    p.g(paramBundle, "activity.window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "activity.window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    com.tencent.mm.ui.b.e((Activity)getActivity(), false);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    int i = au.getStatusBarHeight((Context)getActivity());
    paramBundle = dmg();
    p.g(paramBundle, "myActionBar");
    paramBundle = paramBundle.getLayoutParams();
    paramBundle.height += i;
    Object localObject1 = dmg();
    p.g(localObject1, "myActionBar");
    ((LinearLayout)localObject1).setLayoutParams(paramBundle);
    dmg().setPadding(0, i, 0, 0);
    paramBundle = dmi();
    p.g(paramBundle, "userInfoLayout");
    paramBundle.setAlpha(0.0F);
    localObject1 = getProfileContact();
    Object localObject2;
    if (localObject1 == null)
    {
      paramBundle = dmf();
      localObject1 = new b();
      localObject2 = dmf();
      p.g(localObject2, "appBarLayout");
      ((b)localObject1).c((AppBarLayout)localObject2, 0);
      paramBundle.a((AppBarLayout.b)localObject1);
      ((LinearLayout)this.uZN.getValue()).setOnClickListener((View.OnClickListener)new ac(this));
      paramBundle = dmd();
      p.g(paramBundle, "postBtn");
      paramBundle.setVisibility(8);
      paramBundle = dmh();
      p.g(paramBundle, "moreBtn");
      paramBundle.setVisibility(8);
      if ((!isSelf()) || (!isSelfFlag())) {
        break label583;
      }
      paramBundle = dmd();
      p.g(paramBundle, "postBtn");
      paramBundle.setVisibility(0);
      dmd().setOnClickListener((View.OnClickListener)new ad(this));
      paramBundle = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.f((Context)getActivity(), 1, 1);
      label388:
      paramBundle = dml();
      p.g(paramBundle, "actionBarRedPackLayout");
      if ((!isSelf()) || (!isSelfFlag())) {
        break label723;
      }
      localObject1 = y.vXH;
      if (!y.dCY()) {
        break label723;
      }
      localObject1 = y.vXH;
      if (y.dCZ()) {
        break label723;
      }
    }
    label583:
    label723:
    for (i = 0;; i = 8)
    {
      paramBundle.setVisibility(i);
      dml().setOnClickListener((View.OnClickListener)new aj(this));
      ((WeImageView)this.vae.getValue()).setOnClickListener((View.OnClickListener)new ak(this));
      AppMethodBeat.o(250074);
      return;
      paramBundle = dmk();
      p.g(paramBundle, "actionBarNicknameTv");
      paramBundle.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject1).getNickname()));
      paramBundle = com.tencent.mm.plugin.finder.loader.m.uJa;
      paramBundle = com.tencent.mm.plugin.finder.loader.m.dka();
      localObject1 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject1).field_avatarUrl);
      localObject2 = dmj();
      p.g(localObject2, "actionBarAvatarIv");
      com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      paramBundle.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      break;
      if (this.vah)
      {
        paramBundle = dme();
        p.g(paramBundle, "followContainer");
        ah((View)paramBundle, 8);
        paramBundle = dmh();
        p.g(paramBundle, "moreBtn");
        paramBundle.setVisibility(0);
        dmh().setOnClickListener((View.OnClickListener)new ae(this));
        if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED)) {
          break label388;
        }
        dmh().setOnLongClickListener((View.OnLongClickListener)new af(this));
        break label388;
      }
      paramBundle = dmh();
      p.g(paramBundle, "moreBtn");
      paramBundle.setVisibility(0);
      dmh().setOnClickListener((View.OnClickListener)new ag(this));
      break label388;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250075);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(3736, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(250075);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(250077);
    p.h(paramq, "scene");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof cn)))
    {
      Object localObject = new StringBuilder("username=").append(this.username).append(", scene username=");
      paramString = ((cn)paramq).cZk();
      if (paramString != null) {}
      for (paramString = paramString.username;; paramString = null)
      {
        Log.i("Finder.SelfProfileActionBarUIC", paramString);
        paramString = ((cn)paramq).cZk();
        if (paramString != null)
        {
          paramString = paramString.username;
          if (paramString != null)
          {
            p.g(paramString, "it");
            this.username = paramString;
          }
        }
        paramq = getProfileContact();
        if (paramq != null) {
          break;
        }
        AppMethodBeat.o(250077);
        return;
      }
      paramString = dmk();
      p.g(paramString, "actionBarNicknameTv");
      paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)paramq.getNickname()));
      paramString = com.tencent.mm.plugin.finder.loader.m.uJa;
      paramString = com.tencent.mm.plugin.finder.loader.m.dka();
      paramq = new com.tencent.mm.plugin.finder.loader.a(paramq.field_avatarUrl);
      localObject = dmj();
      p.g(localObject, "actionBarAvatarIv");
      com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      paramString.a(paramq, (ImageView)localObject, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
    }
    AppMethodBeat.o(250077);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$Companion;", "", "()V", "MENU_ID_ACCOUNT_DETAIL", "", "MENU_ID_CREATE_NOTICE", "MENU_ID_EXPOSE", "MENU_ID_OPEN_LIVE", "MENU_ID_POST_FEED", "MENU_ID_POST_LIVE", "MENU_ID_RECOMMEND", "MENU_ID_SET_NO_SEE", "REQUEST_CODE_POST_ACTIONSHEET", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    aa(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ab
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    ab(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ac
    implements View.OnClickListener
  {
    ac(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250052);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.ui.component.a.PRN;
      ((FinderProfileFloatBallUIC)com.tencent.mm.ui.component.a.b(this.van.getActivity()).get(FinderProfileFloatBallUIC.class)).vbf = true;
      this.van.getActivity().finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250052);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ad
    implements View.OnClickListener
  {
    ad(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250053);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderProfileActionBarUIC.g(this.van);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250053);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ae
    implements View.OnClickListener
  {
    ae(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250054);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderProfileActionBarUIC.h(this.van);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250054);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class af
    implements View.OnLongClickListener
  {
    af(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final boolean onLongClick(View paramView)
    {
      String str = null;
      AppMethodBeat.i(250055);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = new StringBuilder();
      paramView = FinderProfileHeaderUIC.vbZ;
      paramView = (FinderProfileHeaderUIC.b)FinderProfileHeaderUIC.access$getUserExtInfoCache$cp().get(FinderProfileActionBarUIC.i(this.van));
      if (paramView != null) {}
      for (paramView = paramView.vca;; paramView = null)
      {
        ((StringBuilder)localObject).append("finderUsername:" + FinderProfileActionBarUIC.i(this.van) + '\n');
        StringBuilder localStringBuilder = new StringBuilder("noticeId:");
        if (paramView != null) {
          str = paramView.dDJ;
        }
        ((StringBuilder)localObject).append(str);
        paramView = FinderDebugUIC.wvw;
        paramView = (Context)this.van.getActivity();
        str = ((StringBuilder)localObject).toString();
        p.g(str, "sb.toString()");
        FinderDebugUIC.a.aG(paramView, str);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(250055);
        return true;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ag
    implements View.OnClickListener
  {
    ag(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250056);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderProfileActionBarUIC.h(this.van);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250056);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ah
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    ah(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ai
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    ai(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aj
    implements View.OnClickListener
  {
    aj(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250059);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$refreshRadPack$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.kernel.g.ah(aj.class);
      p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
      ((aj)paramView).getRedDotManager().asV("FinderSelfRedPack");
      paramView = com.tencent.mm.kernel.g.ah(aj.class);
      p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
      ((aj)paramView).getRedDotManager().asV("FinderMyTabRedPack");
      paramView = com.tencent.mm.kernel.g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OmY, Boolean.TRUE);
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.z((Context)this.van.getContext(), "wxb8f2d39684e3fe62", "");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$refreshRadPack$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250059);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ak
    implements View.OnClickListener
  {
    ak(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250060);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$refreshRadPack$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.kernel.g.ah(aj.class);
      p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
      ((aj)paramView).getRedDotManager().asV("FinderSelfRedPack");
      paramView = com.tencent.mm.kernel.g.ah(aj.class);
      p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
      ((aj)paramView).getRedDotManager().asV("FinderMyTabRedPack");
      paramView = com.tencent.mm.kernel.g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OmX, Boolean.TRUE);
      paramView = FinderProfileActionBarUIC.c(this.van);
      p.g(paramView, "actionBarRedPackLayout");
      paramView.setVisibility(8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$refreshRadPack$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250060);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class al
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    al(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$OnOffsetChangedListener;", "Landroid/support/design/widget/AppBarLayout$OnOffsetChangedListener;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC;)V", "onOffsetChanged", "", "view", "Landroid/support/design/widget/AppBarLayout;", "offset", "", "plugin-finder_release"})
  public final class b
    implements AppBarLayout.b
  {
    public final void c(AppBarLayout paramAppBarLayout, int paramInt)
    {
      AppMethodBeat.i(250024);
      p.h(paramAppBarLayout, "view");
      FinderProfileActionBarUIC.a(this.van, paramInt);
      float f2 = Math.abs(paramInt) * 1.0F / paramAppBarLayout.getTotalScrollRange();
      if (f2 == FinderProfileActionBarUIC.a(this.van))
      {
        AppMethodBeat.o(250024);
        return;
      }
      FinderProfileActionBarUIC.a(this.van, f2);
      float f1;
      if (f2 < 0.5F)
      {
        f1 = (0.5F - f2) / 0.5F;
        this.van.dmg().setBackgroundColor(this.van.getResources().getColor(2131101287));
        paramAppBarLayout = this.van.getActivity();
        if (paramAppBarLayout == null)
        {
          paramAppBarLayout = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(250024);
          throw paramAppBarLayout;
        }
        ((MMActivity)paramAppBarLayout).getController().updataStatusBarIcon(com.tencent.mm.ui.ao.isDarkMode());
        paramAppBarLayout = this.van.getActivity();
        if (paramAppBarLayout == null)
        {
          paramAppBarLayout = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(250024);
          throw paramAppBarLayout;
        }
        ((MMActivity)paramAppBarLayout).getController().p((Activity)this.van.getActivity(), this.van.getResources().getColor(2131101287));
        paramAppBarLayout = FinderProfileActionBarUIC.b(this.van);
        p.g(paramAppBarLayout, "userInfoLayout");
        paramAppBarLayout.setAlpha(0.0F);
        paramAppBarLayout = FinderProfileActionBarUIC.c(this.van);
        p.g(paramAppBarLayout, "actionBarRedPackLayout");
        paramAppBarLayout.setAlpha(f1);
        FinderProfileActionBarUIC.a(this.van, f2, f1);
      }
      for (;;)
      {
        paramAppBarLayout = FinderProfileActionBarUIC.e(this.van);
        p.g(paramAppBarLayout, "backBtnIv");
        paramAppBarLayout.setAlpha(f1);
        paramAppBarLayout = FinderProfileActionBarUIC.f(this.van);
        p.g(paramAppBarLayout, "postBtnIv");
        paramAppBarLayout.setAlpha(f1);
        AppMethodBeat.o(250024);
        return;
        f1 = (f2 - 0.5F) / 0.5F;
        paramInt = (int)(255.0F * f1);
        this.van.dmg().setBackgroundColor(ar.fj(FinderProfileActionBarUIC.d(this.van), paramInt));
        paramAppBarLayout = this.van.getActivity();
        if (paramAppBarLayout == null)
        {
          paramAppBarLayout = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(250024);
          throw paramAppBarLayout;
        }
        ((MMActivity)paramAppBarLayout).getController().setStatusBarColor(ar.fj(FinderProfileActionBarUIC.d(this.van), paramInt));
        paramAppBarLayout = FinderProfileActionBarUIC.b(this.van);
        p.g(paramAppBarLayout, "userInfoLayout");
        paramAppBarLayout.setAlpha(f1);
        paramAppBarLayout = FinderProfileActionBarUIC.c(this.van);
        p.g(paramAppBarLayout, "actionBarRedPackLayout");
        paramAppBarLayout.setAlpha(0.0F);
        FinderProfileActionBarUIC.a(this.van, f2, f1);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    g(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    h(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/design/widget/AppBarLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<AppBarLayout>
  {
    i(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    j(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    k(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/HardTouchableLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<HardTouchableLayout>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/design/widget/CoordinatorLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<CoordinatorLayout>
  {
    m(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class n
    implements o.f
  {
    n(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(250036);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(10002, 2131760481);
        Object localObject;
        if ((FinderProfileActionBarUIC.j(this.van)) && ((p.j(FinderProfileActionBarUIC.i(this.van), com.tencent.mm.model.z.aUg()) ^ true)))
        {
          localObject = y.vXH;
          localObject = com.tencent.mm.plugin.finder.api.c.tsp;
          if (!y.j(c.a.asG(FinderProfileActionBarUIC.i(this.van)))) {
            break label134;
          }
          paramm.kV(10010, 2131760648);
        }
        for (;;)
        {
          localObject = com.tencent.mm.kernel.g.aAh();
          p.g(localObject, "MMKernel.storage()");
          localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.Ong, "");
          if (localObject != null) {
            break;
          }
          paramm = new kotlin.t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(250036);
          throw paramm;
          label134:
          paramm.kV(10010, 2131759561);
        }
        if (((CharSequence)localObject).length() <= 0) {
          break label194;
        }
      }
      label194:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          paramm.kV(10011, 2131759482);
        }
        paramm.kV(10004, 2131760462);
        AppMethodBeat.o(250036);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class o
    implements o.g
  {
    o(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(250037);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(250037);
        return;
        paramMenuItem = FinderProfileActionBarUIC.k(this.van);
        if (paramMenuItem != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.s.vWt;
          localObject2 = this.van.getActivity();
          if (localObject2 == null)
          {
            paramMenuItem = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(250037);
            throw paramMenuItem;
          }
          com.tencent.mm.plugin.finder.utils.s.a.a((com.tencent.mm.plugin.finder.utils.s.a)localObject1, (MMActivity)localObject2, paramMenuItem);
          AppMethodBeat.o(250037);
          return;
        }
        AppMethodBeat.o(250037);
        return;
        paramMenuItem = this.van.getActivity().getString(2131759692, new Object[] { LocaleUtil.getApplicationLanguage(), FinderProfileActionBarUIC.i(this.van) });
        p.g(paramMenuItem, "activity.getString(R.str…tionLanguage(), username)");
        Object localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramMenuItem);
        com.tencent.mm.br.c.b((Context)this.van.getActivity(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        AppMethodBeat.o(250037);
        return;
        paramMenuItem = com.tencent.mm.ui.component.a.PRN;
        paramMenuItem = (FinderProfileHeaderUIC)com.tencent.mm.ui.component.a.b(this.van.getActivity()).get(FinderProfileHeaderUIC.class);
        localObject1 = new z.a();
        Object localObject2 = y.vXH;
        localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
        ((z.a)localObject1).SYB = y.j(c.a.asG(paramMenuItem.username));
        if (!((z.a)localObject1).SYB)
        {
          localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
          if (c.a.asJ(paramMenuItem.username))
          {
            localObject2 = new com.tencent.mm.ui.widget.a.e((Context)paramMenuItem.getContext(), 1, true);
            ((com.tencent.mm.ui.widget.a.e)localObject2).o((CharSequence)paramMenuItem.getContext().getResources().getString(2131760267), 17);
            ((com.tencent.mm.ui.widget.a.e)localObject2).a((o.f)new FinderProfileHeaderUIC.bf(paramMenuItem));
            ((com.tencent.mm.ui.widget.a.e)localObject2).a((o.g)new FinderProfileHeaderUIC.bg(paramMenuItem, (z.a)localObject1));
            ((com.tencent.mm.ui.widget.a.e)localObject2).dGm();
            AppMethodBeat.o(250037);
            return;
          }
        }
        if (!((z.a)localObject1).SYB) {
          bool = true;
        }
        FinderProfileHeaderUIC.b(paramMenuItem, bool);
        AppMethodBeat.o(250037);
        return;
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.fE((Context)this.van.getActivity());
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class p
    implements o.f
  {
    p(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(250038);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(1, 2131755822);
        paramm.kV(2, 2131755831);
        r localr = r.vWn;
        r.a(FinderProfileActionBarUIC.n(this.van), paramm);
      }
      AppMethodBeat.o(250038);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class q
    implements o.g
  {
    q(FinderProfileActionBarUIC paramFinderProfileActionBarUIC, String paramString, AppCompatActivity paramAppCompatActivity) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(250039);
      Intent localIntent = new Intent();
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1) {
        p.g(localIntent.putExtra("key_finder_post_router", 2), "intent.putExtra(Constant…uterUI.ROUTER_TAKE_PHOTO)");
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 1);
        localIntent.putExtra("key_finder_post_id", this.uPz);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.vao, localIntent);
        AppMethodBeat.o(250039);
        return;
        if (paramMenuItem.getItemId() == 2)
        {
          p.g(localIntent.putExtra("key_finder_post_router", 3), "intent.putExtra(Constant…erUI.ROUTER_SELECT_PHOTO)");
        }
        else if (FinderProfileActionBarUIC.n(this.van).containsKey(Integer.valueOf(paramMenuItem.getItemId())))
        {
          r localr = r.vWn;
          r.a((Context)this.van.getActivity(), (ddk)FinderProfileActionBarUIC.n(this.van).get(Integer.valueOf(paramMenuItem.getItemId())));
          paramMenuItem = com.tencent.mm.plugin.finder.report.i.vfo;
          com.tencent.mm.plugin.finder.report.i.as(2, false);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class r
    implements e.b
  {
    public static final r vap;
    
    static
    {
      AppMethodBeat.i(250041);
      vap = new r();
      AppMethodBeat.o(250041);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(250040);
      com.tencent.mm.plugin.finder.report.i locali = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.Ks(6);
      AppMethodBeat.o(250040);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class s
    implements o.f
  {
    s(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(250042);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(10012, 2131760417);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        if (((FinderProfileHeaderUIC)com.tencent.mm.ui.component.a.b(this.van.getActivity()).get(FinderProfileHeaderUIC.class)).vbV) {
          paramm.kV(10013, 2131760478);
        }
      }
      AppMethodBeat.o(250042);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class t
    implements o.g
  {
    t(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(250043);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(250043);
        return;
        paramMenuItem = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.f((Context)this.van.getActivity(), 2, 2);
        FinderProfileActionBarUIC.l(this.van);
        AppMethodBeat.o(250043);
        return;
        paramMenuItem = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.f((Context)this.van.getActivity(), 2, 3);
        paramMenuItem = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.dpl().a(s.ao.vqZ);
        paramMenuItem = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.q(com.tencent.mm.plugin.finder.report.live.s.a.vmv.hlf, "");
        FinderProfileActionBarUIC.m(this.van);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class u
    implements e.b
  {
    u(FinderProfileActionBarUIC paramFinderProfileActionBarUIC) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(250044);
      com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.f((Context)this.van.getActivity(), 2, 4);
      AppMethodBeat.o(250044);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
  {
    v(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    w(FinderProfileActionBarUIC paramFinderProfileActionBarUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    x(FinderProfileActionBarUIC paramFinderProfileActionBarUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FinderLivePostBtnUIC>
  {
    y(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
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
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileActionBarUIC
 * JD-Core Version:    0.7.0.1
 */