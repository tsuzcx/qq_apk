package com.tencent.mm.plugin.finder.profile.uic;

import android.animation.ArgbEvaluator;
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
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.dt;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.br;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.post.g;
import com.tencent.mm.plugin.finder.report.ae;
import com.tencent.mm.plugin.finder.report.ae.a;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.j;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionBarAvatarIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getActionBarAvatarIv", "()Landroid/widget/ImageView;", "actionBarAvatarIv$delegate", "Lkotlin/Lazy;", "actionBarBg", "Landroid/widget/FrameLayout;", "getActionBarBg", "()Landroid/widget/FrameLayout;", "actionBarBg$delegate", "actionBarContainer", "getActionBarContainer", "actionBarContainer$delegate", "actionBarFollowText", "Landroid/widget/TextView;", "getActionBarFollowText", "()Landroid/widget/TextView;", "actionBarFollowText$delegate", "actionBarFollowedIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getActionBarFollowedIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarFollowedIv$delegate", "actionBarNicknameTv", "getActionBarNicknameTv", "actionBarNicknameTv$delegate", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "getAppBarLayout", "()Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout$delegate", "appBarLayoutOffset", "", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "backBtn", "Landroid/widget/LinearLayout;", "getBackBtn", "()Landroid/widget/LinearLayout;", "backBtn$delegate", "backBtnIv", "getBackBtnIv", "backBtnIv$delegate", "colorBg2", "getColorBg2", "()I", "setColorBg2", "(I)V", "coverInfo", "Lkotlin/Pair;", "", "getCoverInfo", "()Lkotlin/Pair;", "setCoverInfo", "(Lkotlin/Pair;)V", "endColor", "getEndColor", "setEndColor", "followContainer", "getFollowContainer", "followContainer$delegate", "hasFinderEntry", "isSelf", "()Z", "isSelf$delegate", "isSelfFlag", "isSelfFlag$delegate", "lastActionBarProgress", "", "livePostUic", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostBtnUIC;", "getLivePostUic", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostBtnUIC;", "livePostUic$delegate", "moreBtn", "getMoreBtn", "moreBtn$delegate", "myActionBar", "getMyActionBar", "myActionBar$delegate", "normalActionBarColor", "postBtn", "getPostBtn", "postBtn$delegate", "postBtnIv", "getPostBtnIv", "postBtnIv$delegate", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "Lkotlin/collections/HashMap;", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "startColor", "userInfoLayout", "getUserInfoLayout", "userInfoLayout$delegate", "username", "", "changeFollowView", "", "progress", "alpha", "doClickMoreAction", "doClickPostAction", "doClickPostLiveAction", "doShowPostBottomSheet", "fixActionBarStatus", "hideActionBar", "initCustomActionBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isHasCover", "coverColor", "setVisibleStats", "view", "Landroid/view/View;", "visibleStat", "Companion", "OnOffsetChangedListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
  implements com.tencent.mm.am.h
{
  public static final a Fct;
  private final j AIq;
  private final j AvT;
  private final j AvV;
  private final j AvW;
  private final j AvX;
  private final j AvY;
  private final j AvZ;
  private final int Awb;
  private float Awe;
  private int Awf;
  private HashMap<Integer, efo> Bsq;
  private int CRt;
  private final j ETF;
  private final j FcA;
  private final j FcB;
  private final j FcC;
  private final boolean FcD;
  private ArgbEvaluator FcE;
  r<Boolean, Integer> FcF;
  int FcG;
  private final j FcH;
  private final j Fcu;
  private final j Fcv;
  final j Fcw;
  final j Fcx;
  private final j Fcy;
  private final j Fcz;
  int endColor;
  private String username;
  
  static
  {
    AppMethodBeat.i(349304);
    Fct = new a((byte)0);
    AppMethodBeat.o(349304);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348957);
    this.ETF = kotlin.k.cm((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.Fcu = kotlin.k.cm((kotlin.g.a.a)new t(paramAppCompatActivity));
    this.Fcv = kotlin.k.cm((kotlin.g.a.a)new n(paramAppCompatActivity));
    this.Fcw = kotlin.k.cm((kotlin.g.a.a)new g(paramAppCompatActivity));
    this.Fcx = kotlin.k.cm((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.AvT = kotlin.k.cm((kotlin.g.a.a)new i(paramAppCompatActivity));
    this.AvX = kotlin.k.cm((kotlin.g.a.a)new k(paramAppCompatActivity));
    this.Fcy = kotlin.k.cm((kotlin.g.a.a)new u(paramAppCompatActivity));
    this.AvZ = kotlin.k.cm((kotlin.g.a.a)new s(paramAppCompatActivity));
    this.AvY = kotlin.k.cm((kotlin.g.a.a)new r(paramAppCompatActivity));
    this.AvW = kotlin.k.cm((kotlin.g.a.a)new v(paramAppCompatActivity));
    this.Fcz = kotlin.k.cm((kotlin.g.a.a)new c(paramAppCompatActivity));
    this.AvV = kotlin.k.cm((kotlin.g.a.a)new h(paramAppCompatActivity));
    this.FcA = kotlin.k.cm((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.FcB = kotlin.k.cm((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.Awb = paramAppCompatActivity.getResources().getColor(e.b.BG_2);
    this.username = "";
    this.AIq = kotlin.k.cm((kotlin.g.a.a)new p(this));
    this.FcC = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.FcD = ((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry();
    this.FcE = new ArgbEvaluator();
    this.CRt = this.Awb;
    this.FcG = paramAppCompatActivity.getResources().getColor(e.b.BG_2);
    this.endColor = this.FcG;
    this.Bsq = new HashMap();
    this.FcH = kotlin.k.cm((kotlin.g.a.a)new q(paramAppCompatActivity));
    AppMethodBeat.o(348957);
  }
  
  private static final void a(AppCompatActivity paramAppCompatActivity, a parama, String paramString, MenuItem paramMenuItem, int paramInt)
  {
    am localam = null;
    AppMethodBeat.i(349193);
    kotlin.g.b.s.u(paramAppCompatActivity, "$context");
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramString, "$postId");
    Intent localIntent = new Intent();
    if (paramMenuItem.getItemId() == 1)
    {
      localIntent.putExtra("key_finder_post_router", 2);
      parama = com.tencent.mm.plugin.finder.report.z.FrZ;
      parama = as.GSQ;
      parama = as.a.hu((Context)paramAppCompatActivity);
      if (parama == null)
      {
        parama = null;
        com.tencent.mm.plugin.finder.report.z.b(1, "post_acionsheet_camera", "", parama);
      }
    }
    for (;;)
    {
      localIntent.putExtra("key_finder_post_from", 1);
      localIntent.putExtra("key_finder_post_id", paramString);
      parama = com.tencent.mm.plugin.finder.utils.u.GgT;
      com.tencent.mm.plugin.finder.utils.u.a((Context)paramAppCompatActivity, localIntent, 132, 10);
      parama = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramAppCompatActivity, localIntent);
      AppMethodBeat.o(349193);
      return;
      parama = parama.fou();
      break;
      if (paramMenuItem.getItemId() == 2)
      {
        localIntent.putExtra("key_finder_post_router", 3);
        localIntent.putExtra("key_maas_entrance", 2);
        parama = com.tencent.mm.plugin.finder.report.z.FrZ;
        parama = as.GSQ;
        parama = as.a.hu((Context)paramAppCompatActivity);
        if (parama == null) {}
        for (parama = localam;; parama = parama.fou())
        {
          com.tencent.mm.plugin.finder.report.z.b(1, "post_actionsheet_album", "", parama);
          break;
        }
      }
      if (paramMenuItem.getItemId() == 4)
      {
        localIntent.putExtra("key_finder_post_router", 16);
      }
      else if (parama.Bsq.containsKey(Integer.valueOf(paramMenuItem.getItemId())))
      {
        localam = am.GhD;
        am.a((Context)parama.getActivity(), (efo)parama.Bsq.get(Integer.valueOf(paramMenuItem.getItemId())));
        parama = com.tencent.mm.plugin.finder.report.v.FrN;
        com.tencent.mm.plugin.finder.report.v.aP(2, false);
      }
    }
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(349175);
    kotlin.g.b.s.u(parama, "this$0");
    com.tencent.mm.plugin.finder.report.z localz = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.h((Context)parama.getActivity(), 2, 4);
    AppMethodBeat.o(349175);
  }
  
  private static final void a(a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(349145);
    kotlin.g.b.s.u(parama, "this$0");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(349145);
      return;
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
      com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999703);
      paramMenuItem = parama.getProfileContact();
      if (paramMenuItem != null)
      {
        Object localObject = an.GhR;
        an.a.a((MMActivity)parama.getActivity(), paramMenuItem);
        AppMethodBeat.o(349145);
        return;
        paramMenuItem = parama.getActivity().getString(e.h.finder_expose_url, new Object[] { LocaleUtil.getApplicationLanguage(), parama.username });
        kotlin.g.b.s.s(paramMenuItem, "activity.getString(R.str…tionLanguage(), username)");
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramMenuItem);
        com.tencent.mm.br.c.b((Context)parama.getActivity(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        long l1 = parama.getActivity().getIntent().getLongExtra("KEY_FINDER_FEEDID", 0L);
        long l2 = parama.getActivity().getIntent().getLongExtra("finder_read_feed_id", 0L);
        paramMenuItem = new aps();
        localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        paramMenuItem.ZwW = com.tencent.mm.plugin.finder.utils.aw.aj(ak.l(kotlin.v.Y("feedActionType", Integer.valueOf(14))));
        if (l1 != 0L)
        {
          paramMenuItem.hKN = l1;
          paramMenuItem.finderUsername = parama.getActivity().getIntent().getStringExtra("finder_username");
          localObject = ae.Fsm;
          localObject = as.GSQ;
          parama = as.a.hu((Context)parama.getContext());
          if (parama != null) {
            break label319;
          }
        }
        label319:
        for (parama = null;; parama = parama.fou())
        {
          ae.a.b(parama, paramMenuItem);
          AppMethodBeat.o(349145);
          return;
          l1 = l2;
          break;
        }
        paramMenuItem = com.tencent.mm.ui.component.k.aeZF;
        ((h)com.tencent.mm.ui.component.k.d(parama.getActivity()).q(h.class)).eJX();
        AppMethodBeat.o(349145);
        return;
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.hm((Context)parama.getActivity());
      }
    }
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(349088);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    paramView = com.tencent.mm.ui.component.k.aeZF;
    ((f)com.tencent.mm.ui.component.k.d(parama.getActivity()).q(f.class)).FdH = true;
    parama.getActivity().finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349088);
  }
  
  private static final void a(a parama, AppCompatActivity paramAppCompatActivity, com.tencent.mm.ui.base.s params)
  {
    Object localObject = null;
    AppMethodBeat.i(349185);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramAppCompatActivity, "$context");
    if (params.jmw())
    {
      params.oh(1, e.h.app_field_mmsight);
      params.oh(2, e.h.app_field_select_new_pic);
      if (((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig().bxg()) {
        params.oh(4, e.h.finder_video_template_post);
      }
      am localam = am.GhD;
      am.a(parama.Bsq, params, (Activity)paramAppCompatActivity);
    }
    parama = com.tencent.mm.plugin.finder.report.z.FrZ;
    parama = as.GSQ;
    parama = as.a.hu((Context)paramAppCompatActivity);
    if (parama == null)
    {
      parama = null;
      com.tencent.mm.plugin.finder.report.z.b(0, "post_acionsheet_camera", "", parama);
      parama = com.tencent.mm.plugin.finder.report.z.FrZ;
      parama = as.GSQ;
      parama = as.a.hu((Context)paramAppCompatActivity);
      if (parama != null) {
        break label176;
      }
    }
    label176:
    for (parama = localObject;; parama = parama.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(0, "post_actionsheet_album", "", parama);
      AppMethodBeat.o(349185);
      return;
      parama = parama.fou();
      break;
    }
  }
  
  private static final void a(a parama, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(349131);
    kotlin.g.b.s.u(parama, "this$0");
    if (params.jmw())
    {
      Object localObject = parama.getProfileContact();
      if (localObject == null)
      {
        i = 0;
        if ((i & 0x100000) == 0) {
          params.oh(10002, e.h.finder_profile_recommend);
        }
        if ((parama.FcD) && (!kotlin.g.b.s.p(parama.username, com.tencent.mm.model.z.bAW())))
        {
          localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
          localObject = com.tencent.mm.plugin.finder.api.d.AwY;
          if (!com.tencent.mm.plugin.finder.utils.aw.o(d.a.auT(parama.username))) {
            break label149;
          }
          params.oh(10010, e.h.finder_unblock_his_feed);
        }
      }
      for (;;)
      {
        parama = com.tencent.mm.kernel.h.baE().ban().get(at.a.adfc, "");
        if (parama != null) {
          break label163;
        }
        parama = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(349131);
        throw parama;
        i = ((m)localObject).field_extFlag;
        break;
        label149:
        params.oh(10010, e.h.finder_block_his_feed);
      }
      label163:
      if (((CharSequence)parama).length() <= 0) {
        break label213;
      }
    }
    label213:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        params.oh(10011, e.h.finder_account_detail);
      }
      params.oh(10004, e.h.finder_profile_expose);
      AppMethodBeat.o(349131);
      return;
    }
  }
  
  private static void ar(View paramView, int paramInt)
  {
    AppMethodBeat.i(349077);
    if (paramView.getVisibility() != paramInt) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(349077);
  }
  
  private static final void b(a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(349167);
    kotlin.g.b.s.u(parama, "this$0");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(349167);
      return;
      paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.h((Context)parama.getActivity(), 2, 2);
      parama.efU();
      AppMethodBeat.o(349167);
      return;
      paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.h((Context)parama.getActivity(), 2, 3);
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().a(q.br.DBY);
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).C(q.a.DqE.mwI, "");
      ((com.tencent.mm.plugin.findersdk.a.av)parama.FcH.getValue()).exO();
    }
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(349096);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    parama.eIL();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349096);
  }
  
  private static final void b(a parama, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(349158);
    kotlin.g.b.s.u(parama, "this$0");
    if (params.jmw())
    {
      params.oh(10012, e.h.finder_post_new);
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      if (((h)com.tencent.mm.ui.component.k.d(parama.getActivity()).q(h.class)).Fey) {
        params.oh(10013, e.h.finder_profile_post_live);
      }
    }
    AppMethodBeat.o(349158);
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(349102);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    parama.eIK();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349102);
  }
  
  private static final boolean d(a parama, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(349113);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject2, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    localObject2 = new StringBuilder();
    paramView = h.FdM;
    paramView = (h.c)h.access$getUserExtInfoCache$cp().get(parama.username);
    if (paramView == null)
    {
      paramView = null;
      ((StringBuilder)localObject2).append("finderUsername:" + parama.username + '\n');
      if (paramView != null) {
        break label213;
      }
    }
    label213:
    for (paramView = localObject1;; paramView = paramView.hAR)
    {
      ((StringBuilder)localObject2).append(kotlin.g.b.s.X("noticeId:", paramView));
      paramView = com.tencent.mm.plugin.finder.tools.a.FNQ;
      parama = (Context)parama.getActivity();
      paramView = ((StringBuilder)localObject2).toString();
      kotlin.g.b.s.s(paramView, "sb.toString()");
      com.tencent.mm.plugin.finder.tools.a.aF(parama, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(349113);
      return true;
      paramView = paramView.FeE;
      break;
    }
  }
  
  private final AppBarLayout dTJ()
  {
    AppMethodBeat.i(348972);
    AppBarLayout localAppBarLayout = (AppBarLayout)this.AvT.getValue();
    AppMethodBeat.o(348972);
    return localAppBarLayout;
  }
  
  private final TextView dTK()
  {
    AppMethodBeat.i(349010);
    TextView localTextView = (TextView)this.AvV.getValue();
    AppMethodBeat.o(349010);
    return localTextView;
  }
  
  private final LinearLayout dTL()
  {
    AppMethodBeat.i(348995);
    LinearLayout localLinearLayout = (LinearLayout)this.AvW.getValue();
    AppMethodBeat.o(348995);
    return localLinearLayout;
  }
  
  private LinearLayout dTM()
  {
    AppMethodBeat.i(348979);
    LinearLayout localLinearLayout = (LinearLayout)this.AvZ.getValue();
    AppMethodBeat.o(348979);
    return localLinearLayout;
  }
  
  private static final void e(a parama, View paramView)
  {
    AppMethodBeat.i(349119);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    parama.eIK();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349119);
  }
  
  private final LinearLayout eIF()
  {
    AppMethodBeat.i(348964);
    LinearLayout localLinearLayout = (LinearLayout)this.Fcu.getValue();
    AppMethodBeat.o(348964);
    return localLinearLayout;
  }
  
  private final LinearLayout eIH()
  {
    AppMethodBeat.i(348987);
    LinearLayout localLinearLayout = (LinearLayout)this.AvY.getValue();
    AppMethodBeat.o(348987);
    return localLinearLayout;
  }
  
  private final ImageView eII()
  {
    AppMethodBeat.i(349003);
    ImageView localImageView = (ImageView)this.Fcz.getValue();
    AppMethodBeat.o(349003);
    return localImageView;
  }
  
  private final FrameLayout eIJ()
  {
    AppMethodBeat.i(349015);
    FrameLayout localFrameLayout = (FrameLayout)this.FcA.getValue();
    AppMethodBeat.o(349015);
    return localFrameLayout;
  }
  
  private final void eIK()
  {
    AppMethodBeat.i(349042);
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)getActivity(), 1, false);
    localf.Vtg = new a..ExternalSyntheticLambda5(this);
    localf.GAC = new a..ExternalSyntheticLambda10(this);
    localf.dDn();
    AppMethodBeat.o(349042);
  }
  
  private final void eIL()
  {
    AppMethodBeat.i(349052);
    Object localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.h((Context)getActivity(), 1, 2);
    localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.h((Context)getActivity(), 1, 3);
    localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.h((Context)getActivity(), 2, 1);
    localObject = new com.tencent.mm.ui.widget.a.f((Context)getActivity(), 1, false);
    ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new a..ExternalSyntheticLambda6(this);
    ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new a..ExternalSyntheticLambda9(this);
    ((com.tencent.mm.ui.widget.a.f)localObject).aeLi = new a..ExternalSyntheticLambda11(this);
    ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
    AppMethodBeat.o(349052);
  }
  
  private static final void eIM()
  {
    AppMethodBeat.i(349201);
    com.tencent.mm.plugin.finder.report.v localv = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.SA(6);
    AppMethodBeat.o(349201);
  }
  
  private final void efU()
  {
    AppMethodBeat.i(349072);
    Object localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("post"))
    {
      AppMethodBeat.o(349072);
      return;
    }
    Object localObject2 = getActivity();
    localObject1 = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localObject1 = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
    Object localObject3 = com.tencent.mm.plugin.finder.activity.b.Aty;
    if (com.tencent.mm.plugin.finder.activity.b.c(null, 5)) {}
    for (int i = 9;; i = 2)
    {
      localObject3 = com.tencent.mm.plugin.finder.utils.a.GfO;
      if (!com.tencent.mm.plugin.finder.utils.a.gX((Context)localObject2)) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.aP(i, true);
      localObject2 = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.azR((String)localObject1);
      AppMethodBeat.o(349072);
      return;
    }
    localObject3 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.aP(i, false);
    localObject3 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.azR((String)localObject1);
    localObject3 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.T(false, i);
    localObject3 = com.tencent.mm.ui.component.k.aeZF;
    if (!((g)com.tencent.mm.ui.component.k.d(getActivity()).q(g.class)).a((kotlin.g.a.a)new l(this), (kotlin.g.a.a)new m(this)))
    {
      AppMethodBeat.o(349072);
      return;
    }
    localObject3 = new com.tencent.mm.ui.widget.a.f((Context)localObject2, 1, false);
    View localView = af.mU((Context)localObject2).inflate(e.f.finder_sheet_header, null);
    Object localObject6 = (TextView)localView.findViewById(e.e.nickname);
    Object localObject4 = (ImageView)localView.findViewById(e.e.avatar);
    Object localObject5 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject5 = d.a.auT(com.tencent.mm.model.z.bAW());
    if (localObject5 != null)
    {
      ((TextView)localObject6).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)((m)localObject5).getNickname()));
      localObject6 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject6 = com.tencent.mm.plugin.finder.loader.p.eCp();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((m)localObject5).field_avatarUrl);
      kotlin.g.b.s.s(localObject4, "avatarIv");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject6).a(localb, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject4 = com.tencent.mm.plugin.finder.utils.av.GiL;
      kotlin.g.b.s.s(localView, "headerView");
      com.tencent.mm.plugin.finder.utils.av.a((m)localObject5, localView);
    }
    localObject4 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.azP((String)localObject1);
    ((com.tencent.mm.ui.widget.a.f)localObject3).af(localView, true);
    ((com.tencent.mm.ui.widget.a.f)localObject3).Vtg = new a..ExternalSyntheticLambda7(this, (AppCompatActivity)localObject2);
    ((com.tencent.mm.ui.widget.a.f)localObject3).GAC = new a..ExternalSyntheticLambda8((AppCompatActivity)localObject2, this, (String)localObject1);
    ((com.tencent.mm.ui.widget.a.f)localObject3).aeLi = a..ExternalSyntheticLambda12.INSTANCE;
    ((com.tencent.mm.ui.widget.a.f)localObject3).dDn();
    AppMethodBeat.o(349072);
  }
  
  private final m getProfileContact()
  {
    AppMethodBeat.i(349032);
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject = d.a.auT(this.username);
    AppMethodBeat.o(349032);
    return localObject;
  }
  
  private final boolean isSelf()
  {
    AppMethodBeat.i(349024);
    boolean bool = ((Boolean)this.FcC.getValue()).booleanValue();
    AppMethodBeat.o(349024);
    return bool;
  }
  
  public final void R(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(349431);
    this.FcF = new r(Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt));
    if (paramBoolean)
    {
      eIJ().setBackground(null);
      AppMethodBeat.o(349431);
      return;
    }
    eIJ().setBackgroundColor(this.Awb);
    AppMethodBeat.o(349431);
  }
  
  public final FrameLayout eIG()
  {
    AppMethodBeat.i(349398);
    FrameLayout localFrameLayout = (FrameLayout)this.Fcv.getValue();
    AppMethodBeat.o(349398);
    return localFrameLayout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(349413);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getStringExtra("finder_username");
    kotlin.g.b.s.checkNotNull(paramBundle);
    kotlin.g.b.s.s(paramBundle, "activity.intent.getStrin…UI.KEY_FINDER_USERNAME)!!");
    this.username = paramBundle;
    com.tencent.mm.kernel.h.aZW().a(3736, (com.tencent.mm.am.h)this);
    paramBundle = getActivity().getWindow().getDecorView();
    kotlin.g.b.s.s(paramBundle, "activity.window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    com.tencent.mm.ui.c.h((Activity)getActivity(), false);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    int i = bf.getStatusBarHeight((Context)getActivity());
    paramBundle = eIJ().getLayoutParams();
    paramBundle.height += i;
    eIJ().setLayoutParams(paramBundle);
    paramBundle = dTM().getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(349413);
      throw paramBundle;
    }
    paramBundle = (FrameLayout.LayoutParams)paramBundle;
    paramBundle.topMargin = i;
    dTM().setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    dTL().setAlpha(0.0F);
    Object localObject1 = getProfileContact();
    if (localObject1 != null)
    {
      dTK().setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getActivity(), (CharSequence)((m)localObject1).dUr()));
      paramBundle = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramBundle = com.tencent.mm.plugin.finder.loader.p.eCp();
      localObject1 = new com.tencent.mm.plugin.finder.loader.b(((m)localObject1).dUs());
      localObject2 = eII();
      kotlin.g.b.s.s(localObject2, "actionBarAvatarIv");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramBundle.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
    }
    paramBundle = dTJ();
    localObject1 = new b();
    Object localObject2 = dTJ();
    kotlin.g.b.s.s(localObject2, "appBarLayout");
    ((b)localObject1).onOffsetChanged((AppBarLayout)localObject2, 0);
    localObject2 = ah.aiuX;
    paramBundle.a((AppBarLayout.b)localObject1);
    ((LinearLayout)this.ETF.getValue()).setOnClickListener(new a..ExternalSyntheticLambda0(this));
    eIF().setVisibility(8);
    eIH().setVisibility(8);
    if ((isSelf()) && (((Boolean)this.AIq.getValue()).booleanValue()))
    {
      eIF().setVisibility(0);
      eIF().setOnClickListener(new a..ExternalSyntheticLambda2(this));
      paramBundle = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.h((Context)getActivity(), 1, 1);
    }
    for (;;)
    {
      if ((getActivity() instanceof MMActivity)) {
        ((MMActivity)getActivity()).getController().s((Activity)getActivity(), getResources().getColor(e.b.transparent));
      }
      AppMethodBeat.o(349413);
      return;
      if (this.FcD)
      {
        paramBundle = eIG();
        kotlin.g.b.s.s(paramBundle, "followContainer");
        ar((View)paramBundle, 8);
        eIH().setVisibility(0);
        eIH().setOnClickListener(new a..ExternalSyntheticLambda1(this));
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
          eIH().setOnLongClickListener(new a..ExternalSyntheticLambda4(this));
        }
      }
      else
      {
        eIH().setVisibility(0);
        eIH().setOnClickListener(new a..ExternalSyntheticLambda3(this));
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(349419);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3736, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(349419);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(349439);
    kotlin.g.b.s.u(paramp, "scene");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof dt)))
    {
      Object localObject = new StringBuilder("username=").append(this.username).append(", scene username=");
      paramString = ((dt)paramp).caK();
      if (paramString == null) {}
      for (paramString = null;; paramString = paramString.username)
      {
        Log.i("Finder.SelfProfileActionBarUIC", paramString);
        paramString = ((dt)paramp).caK();
        if (paramString != null)
        {
          paramString = paramString.username;
          if (paramString != null) {
            this.username = paramString;
          }
        }
        paramp = getProfileContact();
        if (paramp != null) {
          break;
        }
        AppMethodBeat.o(349439);
        return;
      }
      dTK().setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getActivity(), (CharSequence)paramp.dUr()));
      paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramString = com.tencent.mm.plugin.finder.loader.p.eCp();
      paramp = new com.tencent.mm.plugin.finder.loader.b(paramp.dUs());
      localObject = eII();
      kotlin.g.b.s.s(localObject, "actionBarAvatarIv");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramString.a(paramp, (ImageView)localObject, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
    }
    AppMethodBeat.o(349439);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$Companion;", "", "()V", "MENU_ID_ACCOUNT_DETAIL", "", "MENU_ID_EXPOSE", "MENU_ID_POST_FEED", "MENU_ID_POST_LIVE", "MENU_ID_RECOMMEND", "MENU_ID_SET_NO_SEE", "REQUEST_CODE_POST_ACTIONSHEET", "REQUEST_CODE_POST_MJ_TEMPLATE", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_SELECT_SNS_ALBUM", "REQUEST_CODE_TAKE_PHOTO", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$OnOffsetChangedListener;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC;)V", "onOffsetChanged", "", "view", "Lcom/google/android/material/appbar/AppBarLayout;", "offset", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements AppBarLayout.b
  {
    public b()
    {
      AppMethodBeat.i(348511);
      AppMethodBeat.o(348511);
    }
    
    public final void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      AppMethodBeat.i(348528);
      kotlin.g.b.s.u(paramAppBarLayout, "view");
      a.a(this.FcI, paramInt);
      float f2 = Math.abs(paramInt) * 1.0F / paramAppBarLayout.getTotalScrollRange();
      if (f2 == a.c(this.FcI)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        AppMethodBeat.o(348528);
        return;
      }
      a.a(this.FcI, f2);
      float f1;
      if (f2 < 0.5F)
      {
        f1 = (0.5F - f2) / 0.5F;
        a.d(this.FcI).setBackgroundColor(this.FcI.getResources().getColor(e.b.transparent));
        ((MMActivity)this.FcI.getActivity()).getController().updataStatusBarIcon(com.tencent.mm.ui.aw.isDarkMode());
        a.e(this.FcI).setAlpha(0.0F);
        a.f(this.FcI).setVisibility(8);
        a.d(this.FcI).setAlpha(1.0F);
        a.a(this.FcI, f2, f1);
      }
      for (;;)
      {
        a.i(this.FcI).setAlpha(f1);
        a.j(this.FcI).setAlpha(f1);
        AppMethodBeat.o(348528);
        return;
        f1 = (f2 - 0.5F) / 0.5F;
        paramAppBarLayout = this.FcI.FcF;
        if (paramAppBarLayout == null)
        {
          paramAppBarLayout = null;
          if (paramAppBarLayout == null)
          {
            paramAppBarLayout = this.FcI;
            a.b(paramAppBarLayout, a.k(paramAppBarLayout));
            paramAppBarLayout.endColor = paramAppBarLayout.FcG;
            a.f(paramAppBarLayout).setVisibility(8);
          }
          paramAppBarLayout = a.g(this.FcI).evaluate(f1, Integer.valueOf(a.h(this.FcI)), Integer.valueOf(this.FcI.endColor));
          if (paramAppBarLayout == null)
          {
            paramAppBarLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(348528);
            throw paramAppBarLayout;
          }
        }
        else
        {
          a locala = this.FcI;
          if (((Boolean)paramAppBarLayout.bsC).booleanValue())
          {
            a.b(locala, ((Number)paramAppBarLayout.bsD).intValue());
            locala.endColor = ((Number)paramAppBarLayout.bsD).intValue();
            a.f(locala).setVisibility(0);
            a.f(locala).setAlpha(0.4F * f1);
          }
          for (;;)
          {
            break;
            a.b(locala, a.k(locala));
            locala.endColor = locala.FcG;
            a.f(locala).setVisibility(8);
          }
        }
        paramInt = ((Integer)paramAppBarLayout).intValue();
        a.d(this.FcI).setBackgroundColor(paramInt);
        ((MMActivity)this.FcI.getActivity()).getController().updataStatusBarIcon(com.tencent.mm.ui.aw.isDarkMode());
        a.e(this.FcI).setAlpha(f1);
        a.d(this.FcI).setAlpha(f1);
        a.a(this.FcI, f2, f1);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<FrameLayout>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<FrameLayout>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<WeImageView>
  {
    g(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    h(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<AppBarLayout>
  {
    i(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<LinearLayout>
  {
    j(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<WeImageView>
  {
    k(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    l(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    m(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<FrameLayout>
  {
    n(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    o(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    p(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostBtnUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.findersdk.a.av>
  {
    q(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<LinearLayout>
  {
    r(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.a<LinearLayout>
  {
    s(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.a<LinearLayout>
  {
    t(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.a<WeImageView>
  {
    u(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.a<LinearLayout>
  {
    v(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.a
 * JD-Core Version:    0.7.0.1
 */