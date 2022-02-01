package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ar;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.State;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment;
import com.tencent.mm.plugin.finder.report.d.b;
import com.tencent.mm.plugin.finder.report.live.s.ab;
import com.tencent.mm.plugin.finder.report.live.s.az;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLivePostBtnUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.TouchableLayout;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.g.b.z.d;
import kotlin.g.b.z.f;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "MENU_ID_SET_NO_FOLLOW_CONFIRM", "", "MENU_ID_SET_NO_SEE_CONFIRM", "actionBarFollowContainer", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "getActionBarFollowContainer", "()Landroid/widget/FrameLayout;", "actionBarFollowContainer$delegate", "Lkotlin/Lazy;", "actionBarFollowTv", "Landroid/widget/TextView;", "getActionBarFollowTv", "()Landroid/widget/TextView;", "actionBarFollowTv$delegate", "actionBarFollowedIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getActionBarFollowedIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarFollowedIv$delegate", "applicationContext", "Landroid/content/Context;", "authArrowIv", "getAuthArrowIv", "authArrowIv$delegate", "authByTv", "getAuthByTv", "authByTv$delegate", "authGeneratorTv", "getAuthGeneratorTv", "authGeneratorTv$delegate", "authLayout", "Landroid/widget/LinearLayout;", "getAuthLayout", "()Landroid/widget/LinearLayout;", "authLayout$delegate", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "avatarIv$delegate", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "coordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "getCoordinatorLayout", "()Landroid/support/design/widget/CoordinatorLayout;", "coordinatorLayout$delegate", "countListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$countListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$countListener$1;", "descBackgroundColor", "descTv", "getDescTv", "descTv$delegate", "descTvArrow", "getDescTvArrow", "descTvArrow$delegate", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "editLayout", "Landroid/widget/RelativeLayout;", "getEditLayout", "()Landroid/widget/RelativeLayout;", "editLayout$delegate", "fansLayout", "getFansLayout", "fansLayout$delegate", "fansTv", "getFansTv", "fansTv$delegate", "finderBlockIcon", "getFinderBlockIcon", "finderBlockIcon$delegate", "finderLiveBookBtn", "getFinderLiveBookBtn", "finderLiveBookBtn$delegate", "finderLiveCount", "getFinderLiveCount", "finderLiveCount$delegate", "finderLiveTimeView", "getFinderLiveTimeView", "finderLiveTimeView$delegate", "finderLiveView", "getFinderLiveView", "finderLiveView$delegate", "finderMediaEntrance", "getFinderMediaEntrance", "finderMediaEntrance$delegate", "finderMediaName", "getFinderMediaName", "finderMediaName$delegate", "followConfirmSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "followIv", "getFollowIv", "followIv$delegate", "followListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FollowUserEvent;", "getFollowListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setFollowListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "friendFollowLayout", "getFriendFollowLayout", "friendFollowLayout$delegate", "friendFollowTv", "getFriendFollowTv", "friendFollowTv$delegate", "hasFinderEntry", "", "hasPrepared", "getHasPrepared", "()Z", "setHasPrepared", "(Z)V", "header", "Landroid/view/View;", "headerBgLayout", "getHeaderBgLayout", "headerBgLayout$delegate", "headerContainer", "getHeaderContainer", "headerContainer$delegate", "headerHelper", "Lcom/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper;", "isFirstResume", "isSelf", "isSelfFlag", "isSelfFlag$delegate", "labelLayout", "getLabelLayout", "labelLayout$delegate", "lastReportDescAt", "", "getLastReportDescAt", "()Ljava/lang/String;", "setLastReportDescAt", "(Ljava/lang/String;)V", "localNoticeAction", "localNoticeInitStatus", "myMiniShopEntrance", "getMyMiniShopEntrance", "myMiniShopEntrance$delegate", "myMiniShopEntranceTv", "getMyMiniShopEntranceTv", "myMiniShopEntranceTv$delegate", "nickNameContainer", "getNickNameContainer", "nickNameContainer$delegate", "nicknameTv", "getNicknameTv", "nicknameTv$delegate", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "userOriginalTag", "getUserOriginalTag", "userOriginalTag$delegate", "userTagLayout", "getUserTagLayout", "userTagLayout$delegate", "username", "checkLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "svrInfo", "confirmFollow", "", "contact", "doBlockOpLog", "blockStatus", "isManual", "doSceneForUserInfo", "getUserTagText", "handleAuthGenerator", "handleEditBtn", "handleFansLayout", "handleFinderLiveNoticeInfo", "source", "handleFollowAction", "handleFollowBtn", "handleFriendFollowLayout", "handleLabelLayout", "handleMeadiaEntrance", "handleMessageBtn", "handleNickname", "handleShopEntrance", "handleUserDesc", "handleUserTagLayout", "initData", "layoutHeader", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBlockMenuItemClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "refreshProfile", "reportDescAt", "nicknameList", "fromUsername", "setBlockStatus", "isBlock", "setFollowed", "setUnFollow", "setViewFollowed", "setViewUnFollowed", "setWaiting", "startCropImgForResult", "context", "Landroid/app/Activity;", "intent", "filePath", "resultFileName", "Companion", "UserExtInfo", "plugin-finder_release"})
public final class FinderProfileHeaderUIC
  extends UIComponent
  implements i
{
  private static final com.tencent.mm.b.h<String, b> userExtInfoCache;
  private static final int vbY = 1;
  public static final a vbZ;
  private final Context applicationContext;
  private final int tOR;
  private final kotlin.f tYU;
  private final kotlin.f tZl;
  private final kotlin.f uZQ;
  String username;
  private final kotlin.f uuj;
  private final kotlin.f vaa;
  private final boolean vah;
  private final kotlin.f vbA;
  private final kotlin.f vbB;
  private final kotlin.f vbC;
  private final kotlin.f vbD;
  private final kotlin.f vbE;
  private final kotlin.f vbF;
  private final kotlin.f vbG;
  private final kotlin.f vbH;
  private final kotlin.f vbI;
  private final kotlin.f vbJ;
  private final kotlin.f vbK;
  private final kotlin.f vbL;
  private final kotlin.f vbM;
  private final kotlin.f vbN;
  private com.tencent.mm.ui.widget.a.e vbO;
  private final com.tencent.mm.plugin.finder.profile.adapter.a vbP;
  private IListener<ik> vbQ;
  private boolean vbR;
  private final int vbS;
  private int vbT;
  private int vbU;
  boolean vbV;
  private String vbW;
  private final p vbX;
  private View vbj;
  private final kotlin.f vbk;
  private final kotlin.f vbl;
  private final kotlin.f vbm;
  private final kotlin.f vbn;
  private final kotlin.f vbo;
  private final kotlin.f vbp;
  private final kotlin.f vbq;
  private final kotlin.f vbr;
  private final kotlin.f vbs;
  private final kotlin.f vbt;
  private final kotlin.f vbu;
  private final kotlin.f vbv;
  private final kotlin.f vbw;
  private final kotlin.f vbx;
  private final kotlin.f vby;
  private final kotlin.f vbz;
  
  static
  {
    AppMethodBeat.i(250409);
    vbZ = new a((byte)0);
    userExtInfoCache = new com.tencent.mm.b.h(100);
    vbY = 1;
    AppMethodBeat.o(250409);
  }
  
  public FinderProfileHeaderUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250408);
    this.applicationContext = MMApplicationContext.getContext();
    this.vbj = aa.jQ((Context)paramAppCompatActivity).inflate(2131494601, null);
    this.vbk = kotlin.g.ah((kotlin.g.a.a)new ax(paramAppCompatActivity));
    this.vbl = kotlin.g.ah((kotlin.g.a.a)new aw(this));
    this.vbm = kotlin.g.ah((kotlin.g.a.a)new ad(this));
    this.uuj = kotlin.g.ah((kotlin.g.a.a)new bd(this));
    this.vbn = kotlin.g.ah((kotlin.g.a.a)new j(this));
    this.vbo = kotlin.g.ah((kotlin.g.a.a)new bm(this));
    this.vbp = kotlin.g.ah((kotlin.g.a.a)new bn(this));
    this.vbq = kotlin.g.ah((kotlin.g.a.a)new ae(this));
    this.vbr = kotlin.g.ah((kotlin.g.a.a)new af(this));
    this.vbs = kotlin.g.ah((kotlin.g.a.a)new u(this));
    this.vbt = kotlin.g.ah((kotlin.g.a.a)new az(this));
    this.vbu = kotlin.g.ah((kotlin.g.a.a)new v(this));
    this.vbv = kotlin.g.ah((kotlin.g.a.a)new q(this));
    this.vbw = kotlin.g.ah((kotlin.g.a.a)new r(this));
    this.vbx = kotlin.g.ah((kotlin.g.a.a)new i(this));
    this.vby = kotlin.g.ah((kotlin.g.a.a)new h(this));
    this.vbz = kotlin.g.ah((kotlin.g.a.a)new g(this));
    this.vbA = kotlin.g.ah((kotlin.g.a.a)new f(this));
    this.vbB = kotlin.g.ah((kotlin.g.a.a)new bc(this));
    this.vbC = kotlin.g.ah((kotlin.g.a.a)new t(this));
    this.vaa = kotlin.g.ah((kotlin.g.a.a)new o(paramAppCompatActivity));
    this.vbD = kotlin.g.ah((kotlin.g.a.a)new c(paramAppCompatActivity));
    this.uZQ = kotlin.g.ah((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.vbE = kotlin.g.ah((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.vbF = kotlin.g.ah((kotlin.g.a.a)new ba(this));
    this.vbG = kotlin.g.ah((kotlin.g.a.a)new bb(this));
    this.vbH = kotlin.g.ah((kotlin.g.a.a)new aa(this));
    this.vbI = kotlin.g.ah((kotlin.g.a.a)new z(this));
    this.vbJ = kotlin.g.ah((kotlin.g.a.a)new x(this));
    this.vbK = kotlin.g.ah((kotlin.g.a.a)new y(this));
    this.vbL = kotlin.g.ah((kotlin.g.a.a)new w(this));
    this.vbM = kotlin.g.ah((kotlin.g.a.a)new ab(this));
    this.vbN = kotlin.g.ah((kotlin.g.a.a)new ac(this));
    this.tZl = kotlin.g.ah((kotlin.g.a.a)new ay(this));
    this.username = "";
    this.tYU = kotlin.g.ah((kotlin.g.a.a)new n(paramAppCompatActivity));
    this.vah = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry();
    paramAppCompatActivity = this.vbj;
    if (paramAppCompatActivity == null)
    {
      paramAppCompatActivity = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(250408);
      throw paramAppCompatActivity;
    }
    this.vbP = new com.tencent.mm.plugin.finder.profile.adapter.a((ViewGroup)paramAppCompatActivity);
    this.vbR = true;
    this.vbS = 10011;
    this.tOR = 10021;
    this.vbT = -1;
    this.vbU = -1;
    this.vbW = "";
    this.vbX = new p(this);
    AppMethodBeat.o(250408);
  }
  
  private final void P(boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(250406);
    ((com.tencent.mm.plugin.i.a.r)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.r.class)).a(this.username, paramBoolean1, (ai)new s(this, paramBoolean2));
    AppMethodBeat.o(250406);
  }
  
  private final void auA(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(250395);
    Object localObject3 = getProfileContact();
    if (localObject3 == null)
    {
      AppMethodBeat.o(250395);
      return;
    }
    Object localObject1 = this.vbj;
    p.g(localObject1, "header");
    localObject1 = (FrameLayout)((View)localObject1).findViewById(2131301440);
    Object localObject2 = this.vbj;
    p.g(localObject2, "header");
    localObject2 = (TextView)((View)localObject2).findViewById(2131301441);
    dnj();
    y localy = y.vXH;
    final boolean bool = y.i((com.tencent.mm.plugin.finder.api.g)localObject3);
    int i;
    if (p.j(paramString, "onSceneEnd"))
    {
      paramString = com.tencent.mm.ui.component.a.PRN;
      paramString = ((FinderProfileTabUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderProfileTabUIC.class)).aN(FinderProfileFeedFragment.class);
      localObject3 = com.tencent.mm.ui.component.a.PRN;
      paramString = ((FinderProfileFeedUIC)com.tencent.mm.ui.component.a.of((Fragment)paramString).get(FinderProfileFeedUIC.class)).getState();
      localObject3 = com.tencent.mm.plugin.finder.report.k.vfA;
      localObject3 = this.username;
      int k = cl.aWB();
      if (bool)
      {
        i = 1;
        if (paramString != FinderProfileFeedLoader.State.PRIVATE_LOCK) {
          break label331;
        }
        label188:
        com.tencent.mm.plugin.finder.report.k.c((String)localObject3, 4, k, i, j);
      }
    }
    else
    {
      if (!bool) {
        break label336;
      }
      dmQ().setText(2131759775);
      ((TextView)localObject2).setText(2131759775);
    }
    for (;;)
    {
      dmO().setBackgroundResource(2131232702);
      dmQ().setTextColor(getResources().getColor(2131099844));
      ((TextView)localObject2).setTextColor(getResources().getColor(2131099844));
      ((FrameLayout)localObject1).setBackgroundResource(2131232702);
      paramString = (kotlin.g.a.b)new bk(this, bool);
      ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)new c(paramString));
      dmO().setOnClickListener((View.OnClickListener)new c(paramString));
      AppMethodBeat.o(250395);
      return;
      i = 0;
      break;
      label331:
      j = 0;
      break label188;
      label336:
      dmQ().setText(2131759774);
      ((TextView)localObject2).setText(2131759774);
    }
  }
  
  private final void auw(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(250381);
    long l = SystemClock.uptimeMillis();
    dnk();
    dnm();
    dnn();
    dnl();
    auz(paramString);
    dnf();
    dnc();
    dne();
    dnd();
    auy(paramString);
    aux(paramString);
    dnb();
    dna();
    Object localObject1 = y.vXH;
    localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
    x(y.j(c.a.asG(this.username)), paramString);
    Object localObject3 = this.vbP;
    localObject1 = this.vbj;
    p.g(localObject1, "header");
    Object localObject4 = ((View)localObject1).getContext();
    localObject1 = getProfileContact();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).getNickname();; localObject1 = null)
    {
      ((com.tencent.mm.plugin.finder.profile.adapter.a)localObject3).a(com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject4, (CharSequence)localObject1), dno(), p.j("onCreate", paramString));
      localObject3 = new StringBuilder("[refreshProfile] nickname:");
      localObject4 = getProfileContact();
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject4).getNickname();
      }
      Log.i("Finder.FinderProfileHeaderUIC", (String)localObject1 + " COST=" + (SystemClock.uptimeMillis() - l) + "ms source=" + paramString);
      AppMethodBeat.o(250381);
      return;
    }
  }
  
  private final void aux(final String paramString)
  {
    AppMethodBeat.i(250383);
    Log.i("Finder.FinderProfileHeaderUIC", "[handleFinderLiveNoticeInfo] source:".concat(String.valueOf(paramString)));
    paramString = (b)userExtInfoCache.get(this.username);
    Object localObject;
    int i;
    if (paramString != null)
    {
      paramString = paramString.vca;
      if (paramString == null) {
        break label455;
      }
      localObject = (CharSequence)paramString.dDJ;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label322;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = dmT();
        p.g(localObject, "finderLiveView");
        ((RelativeLayout)localObject).setVisibility(0);
        long l = paramString.dvv;
        localObject = dmU();
        p.g(localObject, "finderLiveTimeView");
        Resources localResources = getContext().getResources();
        y localy = y.vXH;
        ((TextView)localObject).setText((CharSequence)localResources.getString(2131759648, new Object[] { y.Gi(l * 1000L) }));
        if ((isSelf()) && (isSelfFlag()))
        {
          localObject = dmW();
          p.g(localObject, "finderLiveCount");
          ((TextView)localObject).setVisibility(0);
          localObject = dmW();
          p.g(localObject, "finderLiveCount");
          localResources = getContext().getResources();
          localy = y.vXH;
          ((TextView)localObject).setText((CharSequence)localResources.getString(2131759646, new Object[] { y.LT(paramString.LHw) }));
          localObject = dmV();
          p.g(localObject, "finderLiveBookBtn");
          ((TextView)localObject).setText((CharSequence)getContext().getResources().getString(2131759645));
          dmV().setOnClickListener((View.OnClickListener)new al(this, paramString));
          AppMethodBeat.o(250383);
          return;
          paramString = null;
          break;
          label322:
          i = 0;
          continue;
        }
        localObject = dmW();
        p.g(localObject, "finderLiveCount");
        ((TextView)localObject).setVisibility(8);
        if (paramString.status == 1)
        {
          localObject = dmV();
          p.g(localObject, "finderLiveBookBtn");
          ((TextView)localObject).setText((CharSequence)getContext().getResources().getString(2131759643));
        }
        for (;;)
        {
          dmV().setOnClickListener((View.OnClickListener)new am(this, paramString));
          AppMethodBeat.o(250383);
          return;
          localObject = dmV();
          p.g(localObject, "finderLiveBookBtn");
          ((TextView)localObject).setText((CharSequence)getContext().getResources().getString(2131759644));
        }
      }
    }
    label455:
    paramString = dmT();
    p.g(paramString, "finderLiveView");
    paramString.setVisibility(8);
    AppMethodBeat.o(250383);
  }
  
  private final void auy(String paramString)
  {
    AppMethodBeat.i(250386);
    if ((!isSelf()) && (!isSelfFlag()))
    {
      Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if ((((Number)com.tencent.mm.plugin.finder.storage.c.dtG().value()).intValue() > 0) && (this.vah))
      {
        localObject = this.vbj;
        p.g(localObject, "header");
        localObject = (FrameLayout)((View)localObject).findViewById(2131307600);
        p.g(localObject, "header.sendMsgBtn");
        ((FrameLayout)localObject).setVisibility(0);
        localObject = this.vbj;
        p.g(localObject, "header");
        localObject = (TextView)((View)localObject).findViewById(2131301455);
        p.g(localObject, "chatText");
        com.tencent.mm.ui.ao.a((Paint)((TextView)localObject).getPaint(), 0.8F);
        if (p.j(paramString, "onCreate"))
        {
          paramString = this.vbj;
          p.g(paramString, "header");
          paramString = (FrameLayout)paramString.findViewById(2131307600);
          p.g(paramString, "header.sendMsgBtn");
          com.tencent.mm.view.f.a((View)paramString, (com.tencent.mm.view.e.b)new ap(this));
        }
        paramString = this.vbj;
        p.g(paramString, "header");
        ((FrameLayout)paramString.findViewById(2131307600)).setOnClickListener((View.OnClickListener)new aq(this));
        AppMethodBeat.o(250386);
        return;
      }
    }
    paramString = this.vbj;
    p.g(paramString, "header");
    paramString = (FrameLayout)paramString.findViewById(2131307600);
    p.g(paramString, "header.sendMsgBtn");
    paramString.setVisibility(8);
    AppMethodBeat.o(250386);
  }
  
  private final void auz(String paramString)
  {
    AppMethodBeat.i(250390);
    Object localObject1 = this.vbj;
    p.g(localObject1, "header");
    localObject1 = (FrameLayout)((View)localObject1).findViewById(2131301440);
    if ((isSelf()) || (!this.vah))
    {
      p.g(localObject1, "followBtn");
      ((FrameLayout)localObject1).setVisibility(8);
      AppMethodBeat.o(250390);
      return;
    }
    Object localObject2 = this.vbj;
    p.g(localObject2, "header");
    localObject2 = (TextView)((View)localObject2).findViewById(2131301441);
    p.g(localObject2, "followBtnTv");
    com.tencent.mm.ui.ao.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
    p.g(localObject1, "followBtn");
    ((FrameLayout)localObject1).setVisibility(0);
    localObject1 = com.tencent.mm.plugin.finder.upload.action.g.vUn;
    if (com.tencent.mm.plugin.finder.upload.action.g.dBr().asJ(this.username))
    {
      dnh();
      AppMethodBeat.o(250390);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.upload.action.g.vUn;
    if (com.tencent.mm.plugin.finder.upload.action.g.dBr().asK(this.username))
    {
      dng();
      AppMethodBeat.o(250390);
      return;
    }
    auA(paramString);
    AppMethodBeat.o(250390);
  }
  
  private final TextView dmA()
  {
    AppMethodBeat.i(250347);
    TextView localTextView = (TextView)this.vbp.getValue();
    AppMethodBeat.o(250347);
    return localTextView;
  }
  
  private final LinearLayout dmB()
  {
    AppMethodBeat.i(250348);
    LinearLayout localLinearLayout = (LinearLayout)this.vbq.getValue();
    AppMethodBeat.o(250348);
    return localLinearLayout;
  }
  
  private final TextView dmC()
  {
    AppMethodBeat.i(250349);
    TextView localTextView = (TextView)this.vbr.getValue();
    AppMethodBeat.o(250349);
    return localTextView;
  }
  
  private final LinearLayout dmD()
  {
    AppMethodBeat.i(250350);
    LinearLayout localLinearLayout = (LinearLayout)this.vbs.getValue();
    AppMethodBeat.o(250350);
    return localLinearLayout;
  }
  
  private final LinearLayout dmE()
  {
    AppMethodBeat.i(250351);
    LinearLayout localLinearLayout = (LinearLayout)this.vbt.getValue();
    AppMethodBeat.o(250351);
    return localLinearLayout;
  }
  
  private final TextView dmF()
  {
    AppMethodBeat.i(250352);
    TextView localTextView = (TextView)this.vbu.getValue();
    AppMethodBeat.o(250352);
    return localTextView;
  }
  
  private final TextView dmG()
  {
    AppMethodBeat.i(250353);
    TextView localTextView = (TextView)this.vbv.getValue();
    AppMethodBeat.o(250353);
    return localTextView;
  }
  
  private final WeImageView dmH()
  {
    AppMethodBeat.i(250354);
    WeImageView localWeImageView = (WeImageView)this.vbw.getValue();
    AppMethodBeat.o(250354);
    return localWeImageView;
  }
  
  private final LinearLayout dmI()
  {
    AppMethodBeat.i(250355);
    LinearLayout localLinearLayout = (LinearLayout)this.vbx.getValue();
    AppMethodBeat.o(250355);
    return localLinearLayout;
  }
  
  private final TextView dmJ()
  {
    AppMethodBeat.i(250356);
    TextView localTextView = (TextView)this.vby.getValue();
    AppMethodBeat.o(250356);
    return localTextView;
  }
  
  private final TextView dmK()
  {
    AppMethodBeat.i(250357);
    TextView localTextView = (TextView)this.vbz.getValue();
    AppMethodBeat.o(250357);
    return localTextView;
  }
  
  private final WeImageView dmL()
  {
    AppMethodBeat.i(250358);
    WeImageView localWeImageView = (WeImageView)this.vbA.getValue();
    AppMethodBeat.o(250358);
    return localWeImageView;
  }
  
  private final LinearLayout dmM()
  {
    AppMethodBeat.i(250359);
    LinearLayout localLinearLayout = (LinearLayout)this.vbB.getValue();
    AppMethodBeat.o(250359);
    return localLinearLayout;
  }
  
  private final RelativeLayout dmN()
  {
    AppMethodBeat.i(250360);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.vbC.getValue();
    AppMethodBeat.o(250360);
    return localRelativeLayout;
  }
  
  private final FrameLayout dmO()
  {
    AppMethodBeat.i(250361);
    FrameLayout localFrameLayout = (FrameLayout)this.vbD.getValue();
    AppMethodBeat.o(250361);
    return localFrameLayout;
  }
  
  private final WeImageView dmP()
  {
    AppMethodBeat.i(250362);
    WeImageView localWeImageView = (WeImageView)this.uZQ.getValue();
    AppMethodBeat.o(250362);
    return localWeImageView;
  }
  
  private final TextView dmQ()
  {
    AppMethodBeat.i(250363);
    TextView localTextView = (TextView)this.vbE.getValue();
    AppMethodBeat.o(250363);
    return localTextView;
  }
  
  private final RelativeLayout dmR()
  {
    AppMethodBeat.i(250364);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.vbF.getValue();
    AppMethodBeat.o(250364);
    return localRelativeLayout;
  }
  
  private final TextView dmS()
  {
    AppMethodBeat.i(250365);
    TextView localTextView = (TextView)this.vbG.getValue();
    AppMethodBeat.o(250365);
    return localTextView;
  }
  
  private final RelativeLayout dmT()
  {
    AppMethodBeat.i(250366);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.vbH.getValue();
    AppMethodBeat.o(250366);
    return localRelativeLayout;
  }
  
  private final TextView dmU()
  {
    AppMethodBeat.i(250367);
    TextView localTextView = (TextView)this.vbI.getValue();
    AppMethodBeat.o(250367);
    return localTextView;
  }
  
  private final TextView dmV()
  {
    AppMethodBeat.i(250368);
    TextView localTextView = (TextView)this.vbJ.getValue();
    AppMethodBeat.o(250368);
    return localTextView;
  }
  
  private final TextView dmW()
  {
    AppMethodBeat.i(250369);
    TextView localTextView = (TextView)this.vbK.getValue();
    AppMethodBeat.o(250369);
    return localTextView;
  }
  
  private final WeImageView dmX()
  {
    AppMethodBeat.i(250370);
    WeImageView localWeImageView = (WeImageView)this.vbL.getValue();
    AppMethodBeat.o(250370);
    return localWeImageView;
  }
  
  private final RelativeLayout dmY()
  {
    AppMethodBeat.i(250371);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.vbM.getValue();
    AppMethodBeat.o(250371);
    return localRelativeLayout;
  }
  
  private final TextView dmZ()
  {
    AppMethodBeat.i(250372);
    TextView localTextView = (TextView)this.vbN.getValue();
    AppMethodBeat.o(250372);
    return localTextView;
  }
  
  private final FrameLayout dmv()
  {
    AppMethodBeat.i(250341);
    FrameLayout localFrameLayout = (FrameLayout)this.vbk.getValue();
    AppMethodBeat.o(250341);
    return localFrameLayout;
  }
  
  private final FrameLayout dmw()
  {
    AppMethodBeat.i(250342);
    FrameLayout localFrameLayout = (FrameLayout)this.vbl.getValue();
    AppMethodBeat.o(250342);
    return localFrameLayout;
  }
  
  private final WeImageView dmx()
  {
    AppMethodBeat.i(250343);
    WeImageView localWeImageView = (WeImageView)this.vbm.getValue();
    AppMethodBeat.o(250343);
    return localWeImageView;
  }
  
  private final TextView dmy()
  {
    AppMethodBeat.i(250344);
    TextView localTextView = (TextView)this.uuj.getValue();
    AppMethodBeat.o(250344);
    return localTextView;
  }
  
  private final TextView dmz()
  {
    AppMethodBeat.i(250346);
    TextView localTextView = (TextView)this.vbo.getValue();
    AppMethodBeat.o(250346);
    return localTextView;
  }
  
  private final void dna()
  {
    AppMethodBeat.i(250382);
    Object localObject2 = (b)userExtInfoCache.get(this.username);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new b();
    }
    localObject1 = ((b)localObject1).vcc;
    if (localObject1 != null)
    {
      localObject1 = ((aoy)localObject1).LAZ;
      if (localObject1 != null)
      {
        int i;
        if (!((Collection)localObject1).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label253;
          }
          label70:
          if (localObject1 == null) {
            break label273;
          }
          localObject2 = (CharSequence)((or)((LinkedList)localObject1).get(0)).KUC;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label258;
          }
          i = 1;
          label104:
          if (i != 0) {
            break label263;
          }
          i = 1;
          label110:
          if (i == 0) {
            break label268;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label273;
          }
          localObject1 = (or)((LinkedList)localObject1).get(0);
          if (localObject1 == null) {
            break label273;
          }
          localObject2 = dmY();
          p.g(localObject2, "finderMediaEntrance");
          com.tencent.mm.view.f.a((View)localObject2, (com.tencent.mm.view.e.b)new an((or)localObject1, this));
          localObject2 = dmY();
          p.g(localObject2, "finderMediaEntrance");
          ((RelativeLayout)localObject2).setVisibility(0);
          localObject2 = dmZ();
          p.g(localObject2, "finderMediaName");
          ((TextView)localObject2).setText((CharSequence)getActivity().getResources().getString(2131760451, new Object[] { ((or)localObject1).KUD }));
          dmY().setOnClickListener((View.OnClickListener)new ao((or)localObject1, this));
          AppMethodBeat.o(250382);
          return;
          i = 0;
          break;
          label253:
          localObject1 = null;
          break label70;
          label258:
          i = 0;
          break label104;
          label263:
          i = 0;
          break label110;
          label268:
          localObject1 = null;
        }
      }
    }
    label273:
    localObject1 = ((FinderProfileHeaderUIC)this).dmY();
    p.g(localObject1, "finderMediaEntrance");
    ((RelativeLayout)localObject1).setVisibility(8);
    AppMethodBeat.o(250382);
  }
  
  private final void dnb()
  {
    Object localObject2 = null;
    AppMethodBeat.i(250384);
    Object localObject3 = (b)userExtInfoCache.get(this.username);
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = new b();
    }
    bel localbel = ((b)localObject1).vcb;
    Object localObject4 = new z.f();
    ((z.f)localObject4).SYG = "";
    final z.f localf = new z.f();
    localf.SYG = "";
    localObject3 = new StringBuilder("[handleShopEntrance] anchor's shopAppInfo.appId:");
    if (localbel != null)
    {
      localObject1 = localbel.appId;
      localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append(",shopAppInfo.appUrl:");
      if (localbel == null) {
        break label293;
      }
    }
    label293:
    for (localObject1 = localbel.LOg;; localObject1 = null)
    {
      Log.i("Finder.FinderProfileHeaderUIC", (String)localObject1);
      if ((localbel == null) || (Util.isNullOrNil(localbel.appId))) {
        break label497;
      }
      localObject1 = dmR();
      p.g(localObject1, "myMiniShopEntrance");
      ((RelativeLayout)localObject1).setVisibility(0);
      localObject3 = localbel.appId;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      ((z.f)localObject4).SYG = localObject1;
      localObject3 = localbel.LOg;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      localf.SYG = localObject1;
      if ((!isSelf()) || (!isSelfFlag()) || (!Util.isNullOrNil((String)((z.f)localObject4).SYG))) {
        break label364;
      }
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Okb, "");
      if (localObject1 != null) {
        break label298;
      }
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(250384);
      throw ((Throwable)localObject1);
      localObject1 = null;
      break;
    }
    label298:
    ((z.f)localObject4).SYG = ((String)localObject1);
    localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Okc, "");
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(250384);
      throw ((Throwable)localObject1);
    }
    localf.SYG = ((String)localObject1);
    label364:
    dmR().setOnClickListener((View.OnClickListener)new as(this, (z.f)localObject4, localf));
    for (;;)
    {
      localObject3 = new StringBuilder("handleShopEntrance shop appId:").append((String)((z.f)localObject4).SYG).append(",path:").append((String)localf.SYG).append(",isSelf:").append(isSelf()).append(",isSelfFlag:").append(isSelfFlag()).append(",shop txt:");
      localObject4 = dmS();
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((TextView)localObject4).getText();
      }
      Log.i("Finder.FinderProfileHeaderUIC", (CharSequence)localObject1);
      AppMethodBeat.o(250384);
      return;
      label497:
      localObject1 = dmR();
      p.g(localObject1, "myMiniShopEntrance");
      ((RelativeLayout)localObject1).setVisibility(8);
    }
  }
  
  private final void dnc()
  {
    AppMethodBeat.i(250385);
    b localb = (b)userExtInfoCache.get(this.username);
    Object localObject = localb;
    if (localb == null) {
      localObject = new b();
    }
    if ((((b)localObject).fansCount > 0) && (isSelf()) && (isSelfFlag()))
    {
      localObject = dmE();
      p.g(localObject, "labelLayout");
      ((LinearLayout)localObject).setVisibility(0);
      AppMethodBeat.o(250385);
      return;
    }
    if (((!isSelf()) || (!isSelfFlag())) && (((b)localObject).friendFollowCount > 0) && (this.vah))
    {
      localObject = dmE();
      p.g(localObject, "labelLayout");
      ((LinearLayout)localObject).setVisibility(0);
      AppMethodBeat.o(250385);
      return;
    }
    localObject = dmE();
    p.g(localObject, "labelLayout");
    ((LinearLayout)localObject).setVisibility(8);
    AppMethodBeat.o(250385);
  }
  
  private final void dnd()
  {
    AppMethodBeat.i(250387);
    if ((isSelf()) && (isSelfFlag()))
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
      com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daP(), (LifecycleOwner)getActivity(), (Observer)new ai(this));
      localObject = dmN();
      p.g(localObject, "editLayout");
      ((RelativeLayout)localObject).setVisibility(0);
      dmN().setOnClickListener((View.OnClickListener)new aj(this));
      AppMethodBeat.o(250387);
      return;
    }
    Object localObject = dmN();
    p.g(localObject, "editLayout");
    ((RelativeLayout)localObject).setVisibility(8);
    AppMethodBeat.o(250387);
  }
  
  private final void dne()
  {
    AppMethodBeat.i(250388);
    Object localObject1 = dmI();
    p.g(localObject1, "authLayout");
    ((LinearLayout)localObject1).setVisibility(8);
    localObject1 = getProfileContact();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_authInfo;
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = (FinderProfileHeaderUIC)this;
      localObject2 = new StringBuilder("[handleAuthGenerator] profileContact=");
      if (((FinderProfileHeaderUIC)localObject1).getProfileContact() != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("Finder.FinderProfileHeaderUIC", bool);
        AppMethodBeat.o(250388);
        return;
      }
    }
    if (((FinderAuthInfo)localObject1).authIconType <= 0)
    {
      Log.w("Finder.FinderProfileHeaderUIC", "[handleAuthGenerator] authIconType<=0");
      AppMethodBeat.o(250388);
      return;
    }
    dmJ().setOnClickListener((View.OnClickListener)new ag(this, (FinderAuthInfo)localObject1));
    dmK().setOnClickListener((View.OnClickListener)new ah(this, (FinderAuthInfo)localObject1));
    Object localObject2 = dmL();
    p.g(localObject2, "authArrowIv");
    ((WeImageView)localObject2).setVisibility(4);
    localObject2 = y.vXH;
    localObject2 = this.vbj;
    p.g(localObject2, "header");
    localObject2 = (ImageView)((View)localObject2).findViewById(2131301415);
    p.g(localObject2, "header.finder_profile_auth_icon");
    y.a((ImageView)localObject2, (FinderAuthInfo)localObject1);
    switch (((FinderAuthInfo)localObject1).authIconType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(250388);
      return;
      localObject1 = ((FinderAuthInfo)localObject1).authProfession;
      if (localObject1 != null)
      {
        localObject2 = dmK();
        p.g(localObject2, "authByTv");
        ((TextView)localObject2).setVisibility(0);
        localObject2 = dmK();
        p.g(localObject2, "authByTv");
        ((TextView)localObject2).setText((CharSequence)getResources().getString(2131759608, new Object[] { localObject1 }));
        dmK().setOnClickListener(null);
      }
      localObject1 = dmI();
      p.g(localObject1, "authLayout");
      ((LinearLayout)localObject1).setVisibility(0);
      AppMethodBeat.o(250388);
      return;
      localObject2 = dmJ();
      p.g(localObject2, "authGeneratorTv");
      ((TextView)localObject2).setVisibility(8);
      localObject2 = dmI();
      p.g(localObject2, "authLayout");
      ((LinearLayout)localObject2).setVisibility(0);
      localObject2 = dmL();
      p.g(localObject2, "authArrowIv");
      ((WeImageView)localObject2).setVisibility(0);
      localObject1 = ((FinderAuthInfo)localObject1).authProfession;
      if (localObject1 != null)
      {
        localObject2 = dmK();
        p.g(localObject2, "authByTv");
        ((TextView)localObject2).setVisibility(0);
        localObject2 = dmK();
        p.g(localObject2, "authByTv");
        ((TextView)localObject2).setText((CharSequence)getResources().getString(2131759608, new Object[] { localObject1 }));
        AppMethodBeat.o(250388);
        return;
      }
      AppMethodBeat.o(250388);
      return;
      localObject1 = dmI();
      p.g(localObject1, "authLayout");
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = dmJ();
      p.g(localObject1, "authGeneratorTv");
      ((TextView)localObject1).setVisibility(8);
      localObject1 = dmL();
      p.g(localObject1, "authArrowIv");
      ((WeImageView)localObject1).setVisibility(8);
      dmK().setOnClickListener(null);
      dmK().setText(2131759811);
    }
  }
  
  private final void dnf()
  {
    AppMethodBeat.i(250389);
    if ((!isSelf()) || (!isSelfFlag()))
    {
      Object localObject2 = (b)userExtInfoCache.get(this.username);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new b();
      }
      if ((((b)localObject1).friendFollowCount > 0) && (this.vah))
      {
        localObject2 = dmB();
        p.g(localObject2, "friendFollowLayout");
        ((LinearLayout)localObject2).setVisibility(0);
        localObject2 = dmC();
        p.g(localObject2, "friendFollowTv");
        ((TextView)localObject2).setText((CharSequence)getContext().getResources().getString(2131759795, new Object[] { com.tencent.mm.plugin.finder.utils.k.Lv(((b)localObject1).friendFollowCount) }));
        AppMethodBeat.o(250389);
        return;
      }
    }
    Object localObject1 = dmB();
    p.g(localObject1, "friendFollowLayout");
    ((LinearLayout)localObject1).setVisibility(8);
    AppMethodBeat.o(250389);
  }
  
  private final void dng()
  {
    AppMethodBeat.i(250391);
    Object localObject1 = this.vbj;
    p.g(localObject1, "header");
    localObject1 = (FrameLayout)((View)localObject1).findViewById(2131301440);
    dnj();
    Object localObject2 = this.vbj;
    p.g(localObject2, "header");
    localObject2 = (TextView)((View)localObject2).findViewById(2131301441);
    dmQ().setText(2131759793);
    dmQ().setTextColor(getResources().getColor(2131099746));
    dmQ().setBackgroundResource(2131232703);
    ((TextView)localObject2).setText(2131759793);
    ((TextView)localObject2).setTextColor(getResources().getColor(2131099746));
    ((FrameLayout)localObject1).setBackgroundResource(2131232703);
    localObject2 = getProfileContact();
    if (localObject2 == null)
    {
      AppMethodBeat.o(250391);
      return;
    }
    ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)new c((kotlin.g.a.b)new bl(this, (com.tencent.mm.plugin.finder.api.g)localObject2)));
    dmO().setOnClickListener(null);
    AppMethodBeat.o(250391);
  }
  
  private final void dnh()
  {
    AppMethodBeat.i(250392);
    Object localObject1 = this.vbj;
    p.g(localObject1, "header");
    localObject1 = (FrameLayout)((View)localObject1).findViewById(2131301440);
    ((FrameLayout)localObject1).setBackgroundResource(2131232703);
    dmO().setBackgroundResource(2131232703);
    dni();
    Object localObject2 = getProfileContact();
    if (localObject2 == null)
    {
      AppMethodBeat.o(250392);
      return;
    }
    localObject2 = (kotlin.g.a.b)new bj(this, (com.tencent.mm.plugin.finder.api.g)localObject2);
    ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)new c((kotlin.g.a.b)localObject2));
    dmO().setOnClickListener((View.OnClickListener)new c((kotlin.g.a.b)localObject2));
    AppMethodBeat.o(250392);
  }
  
  private final void dni()
  {
    AppMethodBeat.i(250393);
    Object localObject = this.vbj;
    p.g(localObject, "header");
    localObject = (TextView)((View)localObject).findViewById(2131301441);
    WeImageView localWeImageView = dmx();
    p.g(localWeImageView, "followIv");
    localWeImageView.setVisibility(0);
    p.g(localObject, "followBtnTv");
    ((TextView)localObject).setVisibility(8);
    localObject = dmP();
    p.g(localObject, "actionBarFollowedIv");
    ((WeImageView)localObject).setVisibility(0);
    localObject = dmQ();
    p.g(localObject, "actionBarFollowTv");
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(250393);
  }
  
  private final void dnj()
  {
    AppMethodBeat.i(250394);
    Object localObject = this.vbj;
    p.g(localObject, "header");
    localObject = (TextView)((View)localObject).findViewById(2131301441);
    WeImageView localWeImageView = dmx();
    p.g(localWeImageView, "followIv");
    localWeImageView.setVisibility(8);
    p.g(localObject, "followBtnTv");
    ((TextView)localObject).setVisibility(0);
    localObject = dmP();
    p.g(localObject, "actionBarFollowedIv");
    ((WeImageView)localObject).setVisibility(8);
    localObject = dmQ();
    p.g(localObject, "actionBarFollowTv");
    ((TextView)localObject).setVisibility(0);
    AppMethodBeat.o(250394);
  }
  
  private final void dnk()
  {
    AppMethodBeat.i(250396);
    Object localObject3 = getProfileContact();
    if (localObject3 == null)
    {
      AppMethodBeat.o(250396);
      return;
    }
    Object localObject1 = getContext().findViewById(2131301431);
    Object localObject2 = (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject3).field_signature;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
      i = 1;
    }
    while (i != 0) {
      if (isSelf())
      {
        dmG().setText(2131759670);
        localObject2 = dmH();
        p.g(localObject2, "descTvArrow");
        ((WeImageView)localObject2).setVisibility(0);
        ((View)localObject1).setBackgroundResource(2131232698);
        i = (int)getActivity().getResources().getDimension(2131165314);
        ((View)localObject1).setPadding((int)getActivity().getResources().getDimension(2131165277), i, 0, i);
        ((View)localObject1).setOnClickListener((View.OnClickListener)new at(this));
        AppMethodBeat.o(250396);
        return;
        i = 0;
      }
      else
      {
        localObject1 = dmG();
        p.g(localObject1, "descTv");
        ((TextView)localObject1).setVisibility(8);
        AppMethodBeat.o(250396);
        return;
      }
    }
    localObject2 = dmH();
    p.g(localObject2, "descTvArrow");
    ((WeImageView)localObject2).setVisibility(8);
    String str = getContext().getResources().getString(2131759609, new Object[] { ((com.tencent.mm.plugin.finder.api.g)localObject3).field_signature });
    p.g(str, "context.resources.getStr… contact.field_signature)");
    localObject2 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)str);
    final StringBuilder localStringBuilder = new StringBuilder();
    final z.d locald = new z.d();
    Object localObject4 = com.tencent.mm.kernel.g.af(ad.class);
    p.g(localObject4, "MMKernel.service(IFinder…enModeConfig::class.java)");
    Object localObject5;
    if (((ad)localObject4).dxX())
    {
      localObject4 = MMApplicationContext.getContext();
      p.g(localObject4, "MMApplicationContext.getContext()");
      i = ((Context)localObject4).getResources().getColor(2131099746);
      locald.SYE = i;
      localObject4 = new z.d();
      localObject5 = com.tencent.mm.kernel.g.af(ad.class);
      p.g(localObject5, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ad)localObject5).dxX()) {
        break label612;
      }
      localObject5 = MMApplicationContext.getContext();
      p.g(localObject5, "MMApplicationContext.getContext()");
    }
    for (int i = ((Context)localObject5).getResources().getColor(2131101287);; i = ((Context)localObject5).getResources().getColor(2131099660))
    {
      ((z.d)localObject4).SYE = i;
      localObject5 = com.tencent.mm.plugin.finder.utils.d.vVg;
      com.tencent.mm.plugin.finder.utils.d.a(str, (kotlin.g.a.q)new au(this, (SpannableString)localObject2, locald, (z.d)localObject4, (com.tencent.mm.plugin.finder.api.g)localObject3, localStringBuilder));
      str = localStringBuilder.toString();
      p.g(str, "reportNickname.toString()");
      gQ(str, ((com.tencent.mm.plugin.finder.api.g)localObject3).getUsername());
      localObject3 = dmG();
      p.g(localObject3, "descTv");
      ((TextView)localObject3).setText((CharSequence)localObject2);
      localObject3 = y.vXH;
      localObject3 = dmG();
      p.g(localObject3, "descTv");
      p.g(localObject2, "signatureSpan");
      y.a((TextView)localObject3, (Spannable)localObject2);
      localObject2 = dmG();
      p.g(localObject2, "descTv");
      ((TextView)localObject2).setVisibility(0);
      ((View)localObject1).setBackgroundResource(0);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      ((View)localObject1).setOnClickListener(null);
      if (localObject1 == null) {
        break label640;
      }
      ((View)localObject1).setOnLongClickListener((View.OnLongClickListener)new av(this));
      AppMethodBeat.o(250396);
      return;
      localObject4 = MMApplicationContext.getContext();
      p.g(localObject4, "MMApplicationContext.getContext()");
      i = ((Context)localObject4).getResources().getColor(2131099787);
      break;
      label612:
      localObject5 = MMApplicationContext.getContext();
      p.g(localObject5, "MMApplicationContext.getContext()");
    }
    label640:
    AppMethodBeat.o(250396);
  }
  
  private final void dnl()
  {
    AppMethodBeat.i(250398);
    Object localObject1 = getProfileContact();
    if (localObject1 == null)
    {
      AppMethodBeat.o(250398);
      return;
    }
    Object localObject2 = dmM();
    p.g(localObject2, "nickNameContainer");
    localObject2 = ((LinearLayout)localObject2).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
      AppMethodBeat.o(250398);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ConstraintLayout.LayoutParams)localObject2;
    Object localObject3 = dmA();
    p.g(localObject3, "userTagLayout");
    if (((TextView)localObject3).getVisibility() == 4)
    {
      ((ConstraintLayout.LayoutParams)localObject2).bottomToTop = -1;
      ((ConstraintLayout.LayoutParams)localObject2).topToTop = 2131301418;
    }
    for (((ConstraintLayout.LayoutParams)localObject2).bottomToBottom = 2131301418;; ((ConstraintLayout.LayoutParams)localObject2).bottomToBottom = -1)
    {
      localObject3 = dmM();
      p.g(localObject3, "nickNameContainer");
      ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = dmy();
      p.g(localObject2, "nicknameTv");
      com.tencent.mm.ui.ao.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
      localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject2 = com.tencent.mm.plugin.finder.loader.m.dka();
      localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject1).field_avatarUrl);
      ImageView localImageView = getAvatarIv();
      p.g(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, localImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      getAvatarIv().setOnClickListener((View.OnClickListener)new ar(this, (com.tencent.mm.plugin.finder.api.g)localObject1));
      AppMethodBeat.o(250398);
      return;
      ((ConstraintLayout.LayoutParams)localObject2).bottomToTop = 2131301419;
      ((ConstraintLayout.LayoutParams)localObject2).topToTop = -1;
    }
  }
  
  private final void dnm()
  {
    AppMethodBeat.i(250399);
    Object localObject2 = (b)userExtInfoCache.get(this.username);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new b();
    }
    if ((((b)localObject1).fansCount > 0) && (isSelf()) && (isSelfFlag()))
    {
      localObject2 = dmD();
      p.g(localObject2, "fansLayout");
      ((LinearLayout)localObject2).setVisibility(0);
      localObject2 = dmF();
      p.g(localObject2, "fansTv");
      ((TextView)localObject2).setText((CharSequence)getContext().getResources().getString(2131759699, new Object[] { com.tencent.mm.plugin.finder.utils.k.Lv(((b)localObject1).fansCount) }));
      dmD().setOnClickListener((View.OnClickListener)new ak(this));
      AppMethodBeat.o(250399);
      return;
    }
    localObject1 = dmD();
    p.g(localObject1, "fansLayout");
    ((LinearLayout)localObject1).setVisibility(8);
    AppMethodBeat.o(250399);
  }
  
  private final void dnn()
  {
    AppMethodBeat.i(250400);
    Object localObject2 = (b)userExtInfoCache.get(this.username);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new b();
    }
    localObject2 = dmz();
    p.g(localObject2, "userOriginalTag");
    ((TextView)localObject2).setVisibility(8);
    if (((b)localObject1).userTags.isEmpty())
    {
      localObject1 = dmA();
      p.g(localObject1, "userTagLayout");
      ((TextView)localObject1).setVisibility(4);
      AppMethodBeat.o(250400);
      return;
    }
    localObject1 = dmA();
    p.g(localObject1, "userTagLayout");
    ((TextView)localObject1).setVisibility(0);
    AppMethodBeat.o(250400);
  }
  
  private final String dno()
  {
    AppMethodBeat.i(250401);
    Object localObject2 = (b)userExtInfoCache.get(this.username);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new b();
    }
    localObject2 = ((b)localObject1).userTags;
    if (!((LinkedList)localObject2).isEmpty())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(" ");
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)((StringBuilder)localObject1).toString());
      if (localObject1 != null)
      {
        localObject1 = ((SpannableString)localObject1).toString();
        p.g(localObject1, "this.toString()");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(250401);
      return localObject1;
      localObject1 = "";
    }
  }
  
  private final void gQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(250397);
    if (p.j(paramString1, this.vbW))
    {
      AppMethodBeat.o(250397);
      return;
    }
    this.vbW = paramString1;
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
    StringBuilder localStringBuilder = new StringBuilder("0,1,").append(paramString1).append(",0,");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localh.kvStat(21172, paramString1);
    AppMethodBeat.o(250397);
  }
  
  private final ImageView getAvatarIv()
  {
    AppMethodBeat.i(250345);
    ImageView localImageView = (ImageView)this.vbn.getValue();
    AppMethodBeat.o(250345);
    return localImageView;
  }
  
  private final bbn getContextObj()
  {
    AppMethodBeat.i(250376);
    bbn localbbn = (bbn)this.tYU.getValue();
    AppMethodBeat.o(250376);
    return localbbn;
  }
  
  private final com.tencent.mm.plugin.finder.api.g getProfileContact()
  {
    AppMethodBeat.i(250375);
    Object localObject = com.tencent.mm.plugin.finder.api.c.tsp;
    localObject = c.a.asG(this.username);
    AppMethodBeat.o(250375);
    return localObject;
  }
  
  private final boolean isSelf()
  {
    AppMethodBeat.i(250374);
    boolean bool = p.j(this.username, z.aUg());
    AppMethodBeat.o(250374);
    return bool;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(250373);
    boolean bool = ((Boolean)this.tZl.getValue()).booleanValue();
    AppMethodBeat.o(250373);
    return bool;
  }
  
  private final void x(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(250402);
    Object localObject;
    Context localContext;
    if (paramBoolean)
    {
      localObject = dmX();
      p.g(localObject, "finderBlockIcon");
      ((WeImageView)localObject).setVisibility(0);
      if ((p.j(paramString, "onCreate") ^ true))
      {
        localObject = this.vbP;
        paramString = this.vbj;
        p.g(paramString, "header");
        localContext = paramString.getContext();
        paramString = getProfileContact();
        if (paramString == null) {
          break label122;
        }
      }
    }
    label122:
    for (paramString = paramString.getNickname();; paramString = null)
    {
      ((com.tencent.mm.plugin.finder.profile.adapter.a)localObject).a(com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)paramString), dno(), false);
      AppMethodBeat.o(250402);
      return;
      localObject = dmX();
      p.g(localObject, "finderBlockIcon");
      ((WeImageView)localObject).setVisibility(8);
      break;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(250405);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      AppMethodBeat.o(250405);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(250405);
      return;
    case 10007: 
      Log.d("Finder.FinderProfileHeaderUIC", "onActivityResult MENU_ID_SET_HEADIMG_TAKEPHOTO");
      localObject1 = this.applicationContext;
      localObject2 = al.waC;
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.s.h((Context)localObject1, paramIntent, al.dEA());
      if (localObject1 == null)
      {
        Log.e("Finder.FinderProfileHeaderUIC", "filePath is null.");
        AppMethodBeat.o(250405);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 1);
      paramIntent.putExtra("CropImage_ImgPath", (String)localObject1);
      localObject1 = (String)localObject1 + System.currentTimeMillis();
      localObject2 = kotlin.n.d.UTF_8;
      if (localObject1 == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(250405);
        throw paramIntent;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      p.g(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
      localObject2 = new StringBuilder();
      localObject3 = al.waC;
      localObject2 = ((StringBuilder)localObject2).append(al.dEA());
      if (localObject1 == null) {
        p.hyc();
      }
      paramIntent.putExtra("CropImage_OutputPath", (String)localObject1);
      paramIntent.setClassName((Context)getActivity(), "com.tencent.mm.ui.tools.CropImageNewUI");
      getContext().startActivityForResult(paramIntent, 10008);
      AppMethodBeat.o(250405);
      return;
    case 10006: 
      Log.d("Finder.FinderProfileHeaderUIC", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
      localObject1 = paramIntent.getData();
      if (localObject1 != null)
      {
        localObject2 = ((Uri)localObject1).getPath();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      p.g(localObject1, "data.data?.path?:\"\"");
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0)
        {
          Log.w("Finder.FinderProfileHeaderUIC", "filePath is null.try to getResultPhotoPath.");
          localObject1 = this.applicationContext;
          localObject2 = al.waC;
          localObject1 = com.tencent.mm.pluginsdk.ui.tools.s.h((Context)localObject1, paramIntent, al.dEA());
          p.g(localObject1, "TakePhotoUtil.getResultP…PathRouter.finderTmpPath)");
        }
        Log.i("Finder.FinderProfileHeaderUIC", "filePath[" + (String)localObject1 + "] " + paramIntent);
        localObject2 = (CharSequence)localObject1;
        if (localObject2 != null)
        {
          paramInt1 = i;
          if (((CharSequence)localObject2).length() != 0) {}
        }
        else
        {
          paramInt1 = 1;
        }
        if (paramInt1 == 0) {
          break;
        }
        Log.e("Finder.FinderProfileHeaderUIC", "filePath is null.");
        AppMethodBeat.o(250405);
        return;
      }
      localObject2 = (Activity)getActivity();
      localObject3 = (String)localObject1 + System.currentTimeMillis();
      localObject4 = kotlin.n.d.UTF_8;
      if (localObject3 == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(250405);
        throw paramIntent;
      }
      localObject3 = ((String)localObject3).getBytes((Charset)localObject4);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      localObject3 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject3);
      p.g(localObject3, "MD5.getMessageDigest((fi…eMillis()).toByteArray())");
      paramIntent.setClass((Context)localObject2, FinderCropAvatarUI.class);
      paramIntent.putExtra("key_crop_style", 1);
      paramIntent.putExtra("key_crop_source", 2);
      paramIntent.putExtra("key_source_img_path", (String)localObject1);
      paramIntent.putExtra("key_result_file_name", (String)localObject3);
      ((Activity)localObject2).startActivityForResult(paramIntent, 10008);
      AppMethodBeat.o(250405);
      return;
    case 10008: 
      Log.d("Finder.FinderProfileHeaderUIC", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
      paramIntent = paramIntent.getStringExtra("key_result_img_path");
      if ((paramIntent == null) || (!com.tencent.mm.vfs.s.YS(paramIntent)))
      {
        Log.e("Finder.FinderProfileHeaderUIC", "ERROR! filePath=".concat(String.valueOf(paramIntent)));
        AppMethodBeat.o(250405);
        return;
      }
      Log.d("Finder.FinderProfileHeaderUIC", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM ".concat(String.valueOf(paramIntent)));
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.OjM, paramIntent);
      localObject1 = com.tencent.mm.plugin.finder.upload.g.vSJ;
      localObject1 = com.tencent.mm.plugin.finder.upload.g.dBa();
      localObject2 = this.username;
      localObject3 = (com.tencent.mm.loader.g.f)new be(this);
      p.h(paramIntent, "path");
      p.h(localObject2, "userName");
      p.h(localObject3, "callback");
      ((com.tencent.mm.plugin.finder.upload.g)localObject1).vSB.a((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.l(paramIntent, (String)localObject2), (com.tencent.mm.loader.g.f)localObject3);
      AppMethodBeat.o(250405);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
    Object localObject4 = c.a.asG(z.aUg());
    Object localObject2 = paramIntent.getStringExtra("Country");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramIntent.getStringExtra("Contact_Province");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    localObject3 = paramIntent.getStringExtra("Contact_City");
    paramIntent = (Intent)localObject3;
    if (localObject3 == null) {
      paramIntent = "";
    }
    Log.i("Finder.FinderProfileHeaderUIC", "countryCode " + (String)localObject1 + " provinceCode" + (String)localObject2 + " cityCode" + paramIntent);
    if (p.j(localObject1, "unshow"))
    {
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      paramInt1 = ((com.tencent.mm.kernel.e)localObject1).azQ().getInt(ar.a.Okw, 0);
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.Okw, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
      localObject1 = "";
    }
    for (paramInt1 = j;; paramInt1 = 0)
    {
      if (localObject4 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo;
        if (localObject3 == null) {
          break label1114;
        }
        ((app)localObject3).country = ((String)localObject1);
        ((app)localObject3).fuJ = ((String)localObject2);
      }
      for (((app)localObject3).fuK = paramIntent;; ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo.fuK = paramIntent)
      {
        localObject3 = com.tencent.mm.plugin.finder.api.c.tsp;
        c.a.c((com.tencent.mm.plugin.finder.api.g)localObject4);
        ((com.tencent.mm.plugin.i.a.x)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.x.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, null);
        break;
        label1114:
        ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo = new app();
        ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo.country = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo.fuJ = ((String)localObject2);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250377);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.azz().a(3736, (i)this);
    com.tencent.mm.kernel.g.azz().a(6653, (i)this);
    com.tencent.mm.kernel.g.azz().a(3761, (i)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(106, (com.tencent.mm.plugin.finder.api.f)this.vbX);
    paramBundle = getActivity().getIntent().getStringExtra("finder_username");
    p.g(paramBundle, "activity.intent.getStrin…leUI.KEY_FINDER_USERNAME)");
    this.username = paramBundle;
    paramBundle = getIntent().getByteArrayExtra("KEY_FINDER_LIVE_NOTICE_INFO");
    Object localObject;
    if (paramBundle != null)
    {
      localObject = (b)userExtInfoCache.get(this.username);
      if (localObject != null) {
        break label521;
      }
      localObject = new b();
      ((b)localObject).vca = new awt();
      awt localawt = ((b)localObject).vca;
      if (localawt != null) {
        localawt.parseFrom(paramBundle);
      }
      userExtInfoCache.put(this.username, localObject);
    }
    for (;;)
    {
      if (getIntent().hasExtra("key_extra_info"))
      {
        paramBundle = FinderReporterUIC.wzC;
        paramBundle = FinderReporterUIC.a.fH((Context)getContext());
        if (paramBundle != null) {
          paramBundle.s(0L, this.username);
        }
      }
      dmv().addView(this.vbj);
      paramBundle = dmw();
      p.g(paramBundle, "headerBgLayout");
      paramBundle = paramBundle.getLayoutParams();
      int i = com.tencent.mm.ui.au.getStatusBarHeight((Context)getActivity());
      float f = getActivity().getResources().getDimension(2131165256);
      paramBundle.height = kotlin.h.a.cR(i + f);
      localObject = dmw();
      p.g(localObject, "headerBgLayout");
      ((FrameLayout)localObject).setLayoutParams(paramBundle);
      paramBundle = dmv();
      p.g(paramBundle, "headerContainer");
      paramBundle.setMinimumHeight(kotlin.h.a.cR(i + f));
      auw("onCreate");
      this.vbQ = ((IListener)new bh(this));
      paramBundle = this.vbQ;
      if (paramBundle != null) {
        paramBundle.alive();
      }
      paramBundle = (b)userExtInfoCache.get(this.username);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.vca;
        if (paramBundle != null) {
          this.vbU = paramBundle.status;
        }
      }
      paramBundle = this.vbj;
      p.g(paramBundle, "header");
      paramBundle = (FrameLayout)paramBundle.findViewById(2131306216);
      p.g(paramBundle, "header.profile_loading_state_container");
      paramBundle.setVisibility(8);
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((FinderLivePostBtnUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderLivePostBtnUIC.class)).wyn = ((kotlin.g.a.r)new bi(this));
      if ((isSelf()) && (isSelfFlag()))
      {
        paramBundle = new cd(8);
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramBundle);
      }
      AppMethodBeat.o(250377);
      return;
      label521:
      ((b)localObject).vca = new awt();
      localObject = ((b)localObject).vca;
      if (localObject != null) {
        ((awt)localObject).parseFrom(paramBundle);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250380);
    super.onDestroy();
    IListener localIListener = this.vbQ;
    if (localIListener != null) {
      localIListener.dead();
    }
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(106, (com.tencent.mm.plugin.finder.api.f)this.vbX);
    com.tencent.mm.kernel.g.azz().b(3736, (i)this);
    com.tencent.mm.kernel.g.azz().b(6653, (i)this);
    com.tencent.mm.kernel.g.azz().b(3761, (i)this);
    AppMethodBeat.o(250380);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(250379);
    super.onResume();
    Object localObject = dmT();
    p.g(localObject, "finderLiveView");
    if (((RelativeLayout)localObject).getVisibility() == 0)
    {
      localObject = com.tencent.mm.plugin.finder.report.live.m.vli;
      com.tencent.mm.plugin.finder.report.live.m.a(s.az.vsS, this.username, 0L, s.j.vnR.scene);
    }
    AppMethodBeat.o(250379);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(250404);
    p.h(paramq, "scene");
    paramString = getFragment();
    if (((paramString != null) && (paramString.isDetached() == true)) || (getActivity().isFinishing()))
    {
      AppMethodBeat.o(250404);
      return;
    }
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof cn))
      {
        if (((cn)paramq).twp != 0L) {
          break label501;
        }
        localObject = new StringBuilder("username=").append(this.username).append(", scene username=");
        paramString = ((cn)paramq).cZk();
        if (paramString != null) {}
        for (paramString = paramString.username;; paramString = null)
        {
          Log.i("Finder.FinderProfileHeaderUIC", paramString);
          if (!(p.j(((cn)paramq).tuH, this.username) ^ true)) {
            break;
          }
          AppMethodBeat.o(250404);
          return;
        }
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
        paramString = (b)userExtInfoCache.get(this.username);
        if (paramString != null) {
          break label508;
        }
        paramString = new b();
      }
    }
    label501:
    label508:
    for (;;)
    {
      paramString.fansCount = ((cn)paramq).fansCount;
      paramString.friendFollowCount = ((cn)paramq).friendFollowCount;
      paramString.at(((cn)paramq).userTags);
      localObject = ((cn)paramq).rr.aYK();
      if (localObject == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(250404);
        throw paramString;
      }
      localObject = ((FinderUserPageResponse)localObject).liveNoticeInfo;
      if ((this.vbU != -1) && (this.vbT != -1) && (localObject != null) && (((awt)localObject).status == this.vbU))
      {
        Log.i("Finder.FinderProfileHeaderUIC", "[checkLiveNoticeInfo] notice action change before sceneEnd");
        ((awt)localObject).status = this.vbT;
      }
      paramString.vca = ((awt)localObject);
      paramString.vcb = ((cn)paramq).cZl();
      paramq = ((cn)paramq).rr.aYK();
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(250404);
        throw paramString;
      }
      paramString.vcc = ((FinderUserPageResponse)paramq).biz_info;
      userExtInfoCache.put(this.username, paramString);
      auw("onSceneEnd:[NetSceneFinderUserPage]");
      AppMethodBeat.o(250404);
      return;
      if ((paramq instanceof cd))
      {
        this.vbV = true;
        paramString = com.tencent.mm.ui.component.a.PRN;
        ((FinderLivePostBtnUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderLivePostBtnUIC.class)).dIm().a(((cd)paramq).cZc());
      }
      AppMethodBeat.o(250404);
      return;
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(250378);
    super.onStart();
    if (!this.vbR)
    {
      com.tencent.mm.ak.t localt = com.tencent.mm.kernel.g.azz();
      cn localcn = new cn(this.username, 0L, null, 0, getContextObj(), 0, 0L, 110);
      localcn.twC = true;
      localt.b((com.tencent.mm.ak.q)localcn);
    }
    this.vbR = false;
    AppMethodBeat.o(250378);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$Companion;", "", "()V", "FINDER_LIVE_NOTICE_CANCEL", "", "getFINDER_LIVE_NOTICE_CANCEL", "()I", "MENU_ID_SET_HEADER_ALBUM", "MENU_ID_SET_HEADER_TAKE_PHOTO", "REQUEST_CODE_DISTRICT", "REQUEST_CODE_IMAGE_BOUND_SEND_SURE", "TAG", "", "userExtInfoCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$UserExtInfo;", "getUserExtInfoCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RelativeLayout>
  {
    aa(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ab
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RelativeLayout>
  {
    ab(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ac
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    ac(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ad
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    ad(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ae
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    ae(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class af
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    af(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ag
    implements View.OnClickListener
  {
    ag(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, FinderAuthInfo paramFinderAuthInfo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250300);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleAuthGenerator$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if ((!Util.isNullOrNil(this.vcg.appName)) && (!Util.isNullOrNil(this.vcg.detailLink)))
      {
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        Context localContext = (Context)this.vcd.getActivity();
        localObject = this.vcg.appName;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        String str = this.vcg.detailLink;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        com.tencent.mm.plugin.finder.utils.a.y(localContext, paramView, (String)localObject);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleAuthGenerator$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(250300);
        return;
        if (!Util.isNullOrNil(this.vcg.detailLink))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", this.vcg.detailLink);
          com.tencent.mm.br.c.b((Context)this.vcd.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ah
    implements View.OnClickListener
  {
    ah(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, FinderAuthInfo paramFinderAuthInfo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250301);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleAuthGenerator$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if ((!Util.isNullOrNil(this.vcg.appName)) && (!Util.isNullOrNil(this.vcg.detailLink)))
      {
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        Context localContext = (Context)this.vcd.getActivity();
        localObject = this.vcg.appName;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        String str = this.vcg.detailLink;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        com.tencent.mm.plugin.finder.utils.a.y(localContext, paramView, (String)localObject);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleAuthGenerator$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(250301);
        return;
        if (!Util.isNullOrNil(this.vcg.detailLink))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", this.vcg.detailLink);
          com.tencent.mm.br.c.b((Context)this.vcd.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class ai<T>
    implements Observer<h.a>
  {
    ai(FinderProfileHeaderUIC paramFinderProfileHeaderUIC) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aj
    implements View.OnClickListener
  {
    aj(FinderProfileHeaderUIC paramFinderProfileHeaderUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250303);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleEditBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.ft((Context)this.vcd.getActivity());
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      paramView = ((PluginFinder)paramView).getRedDotManager().asW("FinderSetting");
      localObject = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().asX("FinderSetting");
      if ((localObject != null) && (paramView != null))
      {
        com.tencent.mm.plugin.finder.report.j localj = com.tencent.mm.plugin.finder.report.j.vft;
        com.tencent.mm.plugin.finder.report.j.a("3", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject, paramView, 2, FinderProfileHeaderUIC.c(this.vcd), 0, 0, 96);
      }
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramView).getRedDotManager().asV("FinderSetting");
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramView).getRedDotManager().e("ProfileEntrance", new int[] { 1000 });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleEditBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250303);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ak
    implements View.OnClickListener
  {
    ak(FinderProfileHeaderUIC paramFinderProfileHeaderUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250304);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFansLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.kernel.g.aAh();
      p.g(paramView, "MMKernel.storage()");
      int i = paramView.azQ().getInt(ar.a.OlD, 0);
      if (i > 0)
      {
        paramView = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a("3", 1, 2, 5, 3, i, null, null, 0L, FinderProfileHeaderUIC.c(this.vcd), 0, 0, 3520);
      }
      paramView = com.tencent.mm.kernel.g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OlD, Integer.valueOf(0));
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      paramView = ((PluginFinder)paramView).getRedDotManager().asW("AuthorProfileFans");
      localObject = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().asX("AuthorProfileFans");
      if ((localObject != null) && (paramView != null))
      {
        com.tencent.mm.plugin.finder.report.j localj = com.tencent.mm.plugin.finder.report.j.vft;
        com.tencent.mm.plugin.finder.report.j.a("3", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject, paramView, 2, FinderProfileHeaderUIC.c(this.vcd), 0, 0, 96);
        paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().asV("AuthorProfileFans");
      }
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.fz((Context)this.vcd.getActivity());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFansLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250304);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class al
    implements View.OnClickListener
  {
    al(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, awt paramawt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250307);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFinderLiveNoticeInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = new com.tencent.mm.ui.widget.a.e((Context)this.vcd.getContext(), 1, true);
      paramView.setTitleView(aa.jQ((Context)this.vcd.getContext()).inflate(2131494447, null));
      paramView.a((o.f)new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(250305);
          p.g(paramAnonymousm, "it");
          if (paramAnonymousm.gKQ())
          {
            FinderProfileHeaderUIC.a locala = FinderProfileHeaderUIC.vbZ;
            paramAnonymousm.a(FinderProfileHeaderUIC.dnp(), this.vci.vcd.getResources().getColor(2131099818), (CharSequence)this.vci.vcd.getResources().getString(2131760131));
          }
          AppMethodBeat.o(250305);
        }
      });
      paramView.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(250306);
          p.g(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          paramAnonymousMenuItem = FinderProfileHeaderUIC.vbZ;
          if (paramAnonymousInt == FinderProfileHeaderUIC.dnp())
          {
            awt localawt = this.vci.vch;
            if (localawt != null)
            {
              paramAnonymousMenuItem = com.tencent.mm.ui.component.a.PRN;
              paramAnonymousMenuItem = (FinderLivePostBtnUIC)com.tencent.mm.ui.component.a.b(this.vci.vcd.getActivity()).get(FinderLivePostBtnUIC.class);
              p.h(localawt, "liveNoticeInfo");
              String str = z.aUg();
              p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
              FinderReporterUIC.a locala = FinderReporterUIC.wzC;
              paramAnonymousMenuItem = FinderReporterUIC.a.fH((Context)paramAnonymousMenuItem.getActivity());
              if (paramAnonymousMenuItem != null) {}
              for (paramAnonymousMenuItem = paramAnonymousMenuItem.dIx();; paramAnonymousMenuItem = null)
              {
                paramAnonymousMenuItem = new com.tencent.mm.plugin.finder.cgi.au(str, localawt, 1, paramAnonymousMenuItem);
                com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramAnonymousMenuItem);
                paramAnonymousMenuItem = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.ab.vpW, "");
                AppMethodBeat.o(250306);
                return;
              }
            }
          }
          AppMethodBeat.o(250306);
        }
      });
      paramView.dGm();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFinderLiveNoticeInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250307);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class am
    implements View.OnClickListener
  {
    am(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, awt paramawt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250308);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFinderLiveNoticeInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (paramString.status == 1)
      {
        paramString.status = 0;
        paramView = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(s.az.vsT, FinderProfileHeaderUIC.a(this.vcd), 0L, s.j.vnR.scene);
      }
      for (int i = 1;; i = 2)
      {
        FinderProfileHeaderUIC.a(this.vcd, paramString.status);
        paramView = FinderProfileHeaderUIC.a(this.vcd);
        localObject = paramString.dDJ;
        if (localObject == null) {
          p.hyc();
        }
        p.g(localObject, "liveNoticeInfo.noticeId!!");
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        paramView = new ar(paramView, (String)localObject, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(this.vcd.getActivity()).get(FinderReporterUIC.class)).dIx());
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramView);
        paramView = com.tencent.mm.plugin.finder.feed.model.e.tUY;
        paramView = com.tencent.mm.plugin.finder.feed.model.e.ato(FinderProfileHeaderUIC.a(this.vcd));
        if (paramView != null) {
          paramView.status = paramString.status;
        }
        FinderProfileHeaderUIC.c(this.vcd, "handleFinderLiveNoticeInfo");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFinderLiveNoticeInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(250308);
        return;
        paramString.status = 1;
        paramView = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(s.az.vsU, FinderProfileHeaderUIC.a(this.vcd), 0L, s.j.vnR.scene);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMeadiaEntrance$3$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"})
  public static final class an
    extends com.tencent.mm.view.e.b
  {
    an(or paramor, FinderProfileHeaderUIC paramFinderProfileHeaderUIC) {}
    
    public final void p(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(250309);
      p.h(paramView, "view");
      if (paramBoolean)
      {
        paramView = com.tencent.mm.plugin.finder.report.k.vfA;
        paramView = FinderProfileHeaderUIC.b(jdField_this);
        if (paramView != null)
        {
          localObject = paramView.getUsername();
          paramView = (View)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramView = "";
        }
        String str = this.vcj.KUC;
        Object localObject = str;
        if (str == null) {
          localObject = "";
        }
        com.tencent.mm.plugin.finder.report.k.y(3, paramView, (String)localObject);
      }
      AppMethodBeat.o(250309);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMeadiaEntrance$3$2"})
  static final class ao
    implements View.OnClickListener
  {
    ao(or paramor, FinderProfileHeaderUIC paramFinderProfileHeaderUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250310);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMeadiaEntrance$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.report.k.vfA;
      paramView = FinderProfileHeaderUIC.b(jdField_this);
      if (paramView != null)
      {
        localObject = paramView.getUsername();
        paramView = (View)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramView = "";
      }
      String str = this.vcj.KUC;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.report.k.y(4, paramView, (String)localObject);
      paramView = new Intent();
      paramView.putExtra("Contact_User", this.vcj.KUC);
      paramView.putExtra("Contact_Scene", 183);
      paramView.putExtra("force_get_contact", true);
      paramView.putExtra("key_use_new_contact_profile", true);
      com.tencent.mm.br.c.b((Context)jdField_this.getActivity(), "profile", ".ui.ContactInfoUI", paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMeadiaEntrance$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250310);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMessageBtn$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"})
  public static final class ap
    extends com.tencent.mm.view.e.b
  {
    public final void p(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(250311);
      p.h(paramView, "view");
      if (paramBoolean)
      {
        paramView = com.tencent.mm.plugin.finder.report.d.vdp;
        paramView = com.tencent.mm.plugin.finder.report.d.dnK();
        String str = z.aUg();
        p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
        paramView.ah(str, "", FinderProfileHeaderUIC.a(this.vcd));
        paramView = com.tencent.mm.plugin.finder.report.d.vdp;
        com.tencent.mm.plugin.finder.report.d.dnK().a(FinderProfileHeaderUIC.c(this.vcd), 3L);
        paramView = FinderProfileHeaderUIC.d(this.vcd);
        p.g(paramView, "header");
        paramView = (FrameLayout)paramView.findViewById(2131307600);
        p.g(paramView, "header.sendMsgBtn");
        com.tencent.mm.view.f.a((View)paramView, null);
      }
      AppMethodBeat.o(250311);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aq
    implements View.OnClickListener
  {
    aq(FinderProfileHeaderUIC paramFinderProfileHeaderUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250312);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMessageBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = y.vXH;
      paramView = (Context)this.vcd.getContext();
      localObject = FinderProfileHeaderUIC.b(this.vcd);
      if (localObject != null) {}
      for (int i = ((com.tencent.mm.plugin.finder.api.g)localObject).field_extFlag;; i = 0)
      {
        if (!y.af(paramView, i))
        {
          paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
          com.tencent.mm.plugin.finder.utils.a.aD((Context)this.vcd.getContext(), FinderProfileHeaderUIC.a(this.vcd));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMessageBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(250312);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ar
    implements View.OnClickListener
  {
    ar(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250313);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleNickname$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new Intent();
      paramView.putStringArrayListExtra("key_url_list", new ArrayList((Collection)kotlin.a.j.listOf(this.tEr.cXH())));
      paramView.putExtra("key_preview_avatar", true);
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.M((Context)this.vcd.getActivity(), paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleNickname$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250313);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class as
    implements View.OnClickListener
  {
    as(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, z.f paramf1, z.f paramf2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250314);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleShopEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a(1L, (String)this.vck.SYG, Util.getUuidRandom().toString(), 1175L, String.valueOf(SystemClock.elapsedRealtimeNanos()), "", "");
      paramView = FinderProfileHeaderUIC.a(this.vcd) + ':' + Util.getUuidRandom();
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.a((Context)this.vcd.getContext(), (String)this.vck.SYG, (String)localf.SYG, 1175, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleShopEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250314);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class at
    implements View.OnClickListener
  {
    at(FinderProfileHeaderUIC paramFinderProfileHeaderUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250315);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleUserDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new Intent();
      paramView.putExtra("key_scene", 2);
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.N((Context)this.vcd.getContext(), paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleUserDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250315);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "start", "", "end", "nickname", "", "invoke"})
  static final class au
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, Integer, String, kotlin.x>
  {
    au(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, SpannableString paramSpannableString, z.d paramd1, z.d paramd2, com.tencent.mm.plugin.finder.api.g paramg, StringBuilder paramStringBuilder)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class av
    implements View.OnLongClickListener
  {
    av(FinderProfileHeaderUIC paramFinderProfileHeaderUIC) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(250320);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleUserDesc$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new com.tencent.mm.ui.widget.b.a((Context)this.vcd.getContext(), paramView);
      paramView.a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(250318);
          paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.vcr.vcd.getContext().getString(2131755772));
          AppMethodBeat.o(250318);
        }
      });
      paramView.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(250319);
          if (paramAnonymousInt == 0) {
            ClipboardHelper.setText(FinderProfileHeaderUIC.k(this.vcr.vcd).getText());
          }
          AppMethodBeat.o(250319);
        }
      });
      localObject = TouchableLayout.Rni;
      int i = TouchableLayout.hfC();
      localObject = TouchableLayout.Rni;
      boolean bool = paramView.ez(i, TouchableLayout.hfD());
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleUserDesc$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(250320);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aw
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
  {
    aw(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ax
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
  {
    ax(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ay
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    ay(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class az
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    az(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$UserExtInfo;", "", "friendFollowCount", "", "fansCount", "userTags", "Ljava/util/LinkedList;", "", "finderLiveNoticInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "shopInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;", "(IILjava/util/LinkedList;Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;)V", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;", "setBizInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;)V", "getFansCount", "()I", "setFansCount", "(I)V", "getFinderLiveNoticInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setFinderLiveNoticInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "getFriendFollowCount", "setFriendFollowCount", "getShopInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "setShopInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;)V", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    public int fansCount;
    public int friendFollowCount;
    public LinkedList<String> userTags;
    awt vca;
    public bel vcb;
    aoy vcc;
    
    private b(LinkedList<String> paramLinkedList)
    {
      AppMethodBeat.i(250265);
      this.friendFollowCount = -1;
      this.fansCount = -1;
      this.userTags = paramLinkedList;
      this.vca = null;
      this.vcb = null;
      this.vcc = null;
      AppMethodBeat.o(250265);
    }
    
    public final void at(LinkedList<String> paramLinkedList)
    {
      AppMethodBeat.i(250264);
      p.h(paramLinkedList, "<set-?>");
      this.userTags = paramLinkedList;
      AppMethodBeat.o(250264);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(250269);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.friendFollowCount != paramObject.friendFollowCount) || (this.fansCount != paramObject.fansCount) || (!p.j(this.userTags, paramObject.userTags)) || (!p.j(this.vca, paramObject.vca)) || (!p.j(this.vcb, paramObject.vcb)) || (!p.j(this.vcc, paramObject.vcc))) {}
        }
      }
      else
      {
        AppMethodBeat.o(250269);
        return true;
      }
      AppMethodBeat.o(250269);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(250268);
      int n = this.friendFollowCount;
      int i1 = this.fansCount;
      Object localObject = this.userTags;
      int i;
      int j;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.vca;
        if (localObject == null) {
          break label129;
        }
        j = localObject.hashCode();
        label54:
        localObject = this.vcb;
        if (localObject == null) {
          break label134;
        }
      }
      label129:
      label134:
      for (int k = localObject.hashCode();; k = 0)
      {
        localObject = this.vcc;
        if (localObject != null) {
          m = localObject.hashCode();
        }
        AppMethodBeat.o(250268);
        return (k + (j + (i + (n * 31 + i1) * 31) * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label54;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(250267);
      String str = "UserExtInfo(friendFollowCount=" + this.friendFollowCount + ", fansCount=" + this.fansCount + ", userTags=" + this.userTags + ", finderLiveNoticInfo=" + this.vca + ", shopInfo=" + this.vcb + ", bizInfo=" + this.vcc + ")";
      AppMethodBeat.o(250267);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ba
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RelativeLayout>
  {
    ba(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bb
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    bb(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bc
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    bc(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bd
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    bd(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$onActivityResult$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class be
    implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c>
  {
    public final void a(com.tencent.mm.loader.g.c paramc, com.tencent.mm.loader.g.j paramj)
    {
      AppMethodBeat.i(250329);
      p.h(paramc, "task");
      p.h(paramj, "status");
      if (paramj == com.tencent.mm.loader.g.j.ibx)
      {
        u.makeText((Context)this.vcd.getActivity(), (CharSequence)this.vcd.getString(2131760658), 0).show();
        AppMethodBeat.o(250329);
        return;
      }
      u.makeText((Context)this.vcd.getActivity(), (CharSequence)this.vcd.getString(2131760660), 0).show();
      AppMethodBeat.o(250329);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class bf
    implements o.f
  {
    bf(FinderProfileHeaderUIC paramFinderProfileHeaderUIC) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(250330);
      p.g(paramm, "it");
      if (paramm.gKQ()) {
        paramm.a(FinderProfileHeaderUIC.l(this.vcd), this.vcd.getResources().getColor(2131099818), (CharSequence)this.vcd.getResources().getString(2131760266));
      }
      AppMethodBeat.o(250330);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class bg
    implements o.g
  {
    bg(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, z.a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(250331);
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderProfileHeaderUIC.l(this.vcd))
      {
        paramMenuItem = this.vcd;
        if (this.vcs.SYB) {
          break label55;
        }
      }
      label55:
      for (boolean bool = true;; bool = false)
      {
        FinderProfileHeaderUIC.b(paramMenuItem, bool);
        AppMethodBeat.o(250331);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$onCreate$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FollowUserEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class bh
    extends IListener<ik>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(FinderProfileHeaderUIC.bh parambh)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice;", "invoke"})
  static final class bi
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, Integer, String, com.tencent.mm.plugin.finder.cgi.au, kotlin.x>
  {
    bi(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class bj
    extends kotlin.g.b.q
    implements kotlin.g.a.b<View, kotlin.x>
  {
    bj(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g paramg)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class bk
    extends kotlin.g.b.q
    implements kotlin.g.a.b<View, kotlin.x>
  {
    bk(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class bl
    extends kotlin.g.b.q
    implements kotlin.g.a.b<View, kotlin.x>
  {
    bl(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g paramg)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bm
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    bm(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bn
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    bn(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    f(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    g(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    h(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    i(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    j(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$confirmFollow$1$1"})
  static final class k
    implements o.f
  {
    k(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(250278);
      p.g(paramm, "it");
      if (paramm.gKQ()) {
        paramm.a(FinderProfileHeaderUIC.e(this.vcd), this.vcd.getResources().getColor(2131099818), (CharSequence)this.vcd.getResources().getString(2131759572));
      }
      AppMethodBeat.o(250278);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$confirmFollow$1$2"})
  static final class l
    implements o.g
  {
    l(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(250279);
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderProfileHeaderUIC.e(this.vcd))
      {
        FinderProfileHeaderUIC.a(this.vcd, this.vce);
        FinderProfileHeaderUIC.f(this.vcd);
      }
      AppMethodBeat.o(250279);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$confirmFollow$1$3"})
  static final class m
    implements com.tencent.mm.ui.widget.a.e.b
  {
    m(FinderProfileHeaderUIC paramFinderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(250280);
      FinderProfileHeaderUIC.f(this.vcd);
      AppMethodBeat.o(250280);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<bbn>
  {
    n(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/design/widget/CoordinatorLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<CoordinatorLayout>
  {
    o(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$countListener$1", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "", "scene", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.plugin.finder.api.f
  {
    public final void a(apf paramapf, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(250283);
      p.h(paramapf, "cmdItem");
      if ((!FinderProfileHeaderUIC.m(this.vcd)) || (!FinderProfileHeaderUIC.n(this.vcd)))
      {
        AppMethodBeat.o(250283);
        return;
      }
      switch (paramapf.cmdId)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(250283);
        return;
        FinderProfileHeaderUIC.b(this.vcd, "handleCmd");
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    q(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    r(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$doBlockOpLog$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class s
    implements ai<ayu>
  {
    s(boolean paramBoolean) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RelativeLayout>
  {
    t(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    u(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    v(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    w(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    x(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    y(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class z
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    z(FinderProfileHeaderUIC paramFinderProfileHeaderUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC
 * JD-Core Version:    0.7.0.1
 */