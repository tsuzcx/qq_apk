package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.tencent.d.a.a.a.b.b.e;
import com.tencent.d.a.a.a.b.b.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.kb;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a.a;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.cgi.dt;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.State;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment;
import com.tencent.mm.plugin.finder.profile.FinderProfilePoiDrawer;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.report.f.b;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.view.CollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cf.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.plugin.findersdk.a.cl;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.NativeInfo;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;
import kotlin.v;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionBarFollowContainer", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "getActionBarFollowContainer", "()Landroid/widget/FrameLayout;", "actionBarFollowContainer$delegate", "Lkotlin/Lazy;", "actionBarFollowTv", "Landroid/widget/TextView;", "getActionBarFollowTv", "()Landroid/widget/TextView;", "actionBarFollowTv$delegate", "actionBarFollowedIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getActionBarFollowedIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarFollowedIv$delegate", "activityWidget", "Lcom/tencent/mm/plugin/finder/profile/widget/HeaderActivityWidget;", "authAccContainer", "Landroid/widget/LinearLayout;", "getAuthAccContainer", "()Landroid/widget/LinearLayout;", "authAccContainer$delegate", "authByTv", "getAuthByTv", "authByTv$delegate", "authGenerator", "getAuthGenerator", "authGenerator$delegate", "authGeneratorTv", "getAuthGeneratorTv", "authGeneratorTv$delegate", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "avatarIv$delegate", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "countListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$countListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$countListener$1;", "descCoveredInfoPair", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$DescSpanInfo;", "descInfoPair", "descTv", "Lcom/tencent/mm/plugin/finder/view/CollapsibleTextView;", "getDescTv", "()Lcom/tencent/mm/plugin/finder/view/CollapsibleTextView;", "descTv$delegate", "descTvArrow", "getDescTvArrow", "descTvArrow$delegate", "editLayout", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "getEditLayout", "()Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "editLayout$delegate", "enterpriseAdd", "Lcom/tencent/mm/plugin/finder/profile/widget/HeaderEnterpriseAddWidget;", "fansLayout", "getFansLayout", "fansLayout$delegate", "fansTv", "getFansTv", "fansTv$delegate", "finderBlockIcon", "getFinderBlockIcon", "finderBlockIcon$delegate", "firstReceivedScene", "", "getFirstReceivedScene", "()Z", "setFirstReceivedScene", "(Z)V", "followConfirmSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "followIv", "getFollowIv", "followIv$delegate", "followListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FollowUserEvent;", "getFollowListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setFollowListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "forbiddenShowLuckMoneyCover", "getForbiddenShowLuckMoneyCover", "forbiddenShowLuckMoneyCover$delegate", "friendFollowLayout", "getFriendFollowLayout", "friendFollowLayout$delegate", "friendFollowTv", "getFriendFollowTv", "friendFollowTv$delegate", "hasFinderEntry", "hasPrepared", "getHasPrepared", "setHasPrepared", "header", "Landroid/view/View;", "headerBgLayout", "getHeaderBgLayout", "headerBgLayout$delegate", "headerContainer", "getHeaderContainer", "headerContainer$delegate", "headerHelper", "Lcom/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper;", "isFirstResume", "isSelf", "isSelfFlag", "isSelfFlag$delegate", "isShowNoticeListAfterTurnOn", "labelLayout", "getLabelLayout", "labelLayout$delegate", "lastReportDescAt", "", "getLastReportDescAt", "()Ljava/lang/String;", "setLastReportDescAt", "(Ljava/lang/String;)V", "liveWidget", "Lcom/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget;", "logoutPage", "getLogoutPage", "()Landroid/view/View;", "logoutPage$delegate", "mediaEntrance", "Lcom/tencent/mm/plugin/finder/profile/widget/HeaderMediaEntranceWidget;", "miniProgram", "Lcom/tencent/mm/plugin/finder/profile/widget/HeaderMiniProgramWidget;", "moreBtn", "getMoreBtn", "moreBtn$delegate", "moreLiveListWidget", "Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget;", "nickNameContainer", "getNickNameContainer", "nickNameContainer$delegate", "nicknameTv", "getNicknameTv", "nicknameTv$delegate", "oplogCallback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "poiHandler", "Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiHandler;", "postBtn", "getPostBtn", "postBtn$delegate", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "redPackWidget", "Lcom/tencent/mm/plugin/finder/profile/widget/HeaderRedPackWidget;", "requestListStartPositionNoticeId", "userOriginalTag", "getUserOriginalTag", "userOriginalTag$delegate", "userTagLayout", "getUserTagLayout", "userTagLayout$delegate", "username", "confirmFollow", "", "contact", "doBlockOpLog", "blockStatus", "isManual", "doSceneForUserInfo", "isOnlyFetchUserInfo", "enableShowMessageBtn", "getLastDescSpan", "isCovered", "signature", "getPoiHandler", "getUserTagText", "handleAuthGenerator", "handleEditBtn", "handleFansLayout", "handleFollowAction", "handleFollowBtn", "source", "handleFriendFollowLayout", "handleLabelLayout", "handleLogOut", "handleLuckMoneyCoverLayout", "handleMessageBtn", "handleNickname", "handleOlyJumpInfo", "handleProfilePoi", "snsPoiDetail", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "handleUserDesc", "handleUserTagLayout", "ifShowFansCount", "initData", "initWidget", "isLogOutVisible", "isTeenMode", "layoutHeader", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBlockMenuItemClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "refreshDescSpanStyle", "atTextColor", "refreshProfile", "report21875OlympicsJumper", "context", "Landroid/content/Context;", "eid", "eventCode", "info", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "reportDescAt", "nicknameList", "fromUsername", "setBlockStatus", "isBlock", "setDescWithSpan", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "setFollowed", "setUnFollow", "setViewFollowed", "setViewUnFollowed", "setWaiting", "startCropImgForResult", "Landroid/app/Activity;", "intent", "filePath", "resultFileName", "storeLastDescSpan", "descSpanInfo", "Companion", "DescSpanInfo", "UserExtInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends UIComponent
  implements com.tencent.mm.am.h
{
  public static final a FdM;
  private static final com.tencent.mm.b.h<String, c> userExtInfoCache;
  private final kotlin.j AIq;
  private boolean AuP;
  private final kotlin.j AvY;
  private final kotlin.j Bld;
  private ck<bpq> CYX;
  private final kotlin.j DkO;
  private IListener<kb> ErY;
  private View Fag;
  private com.tencent.mm.plugin.finder.profile.c Faw;
  private final boolean FcD;
  private final kotlin.j Fcu;
  private final kotlin.j Fcw;
  private final kotlin.j FdN;
  private final kotlin.j FdO;
  private final kotlin.j FdP;
  private final kotlin.j FdQ;
  private final kotlin.j FdR;
  private final kotlin.j FdS;
  private final kotlin.j FdT;
  private final kotlin.j FdU;
  private final kotlin.j FdV;
  private final kotlin.j FdW;
  private final kotlin.j FdX;
  private final kotlin.j FdY;
  private final kotlin.j FdZ;
  private String FeA;
  private final m FeB;
  private final kotlin.j Fea;
  private final kotlin.j Feb;
  private final kotlin.j Fec;
  private final kotlin.j Fed;
  private final kotlin.j Fee;
  private final kotlin.j Fef;
  private final kotlin.j Feg;
  private final kotlin.j Feh;
  private final kotlin.j Fei;
  private final kotlin.j Fej;
  private com.tencent.mm.plugin.finder.profile.widget.b Fek;
  private com.tencent.mm.plugin.finder.profile.widget.d Fel;
  private com.tencent.mm.plugin.finder.profile.widget.e Fem;
  private com.tencent.mm.plugin.finder.profile.widget.a Fen;
  private com.tencent.mm.plugin.finder.profile.widget.c Feo;
  private com.tencent.mm.plugin.finder.profile.widget.g Fep;
  private com.tencent.mm.plugin.finder.profile.widget.f Feq;
  private boolean Fer;
  private String Fes;
  private h.b Fet;
  private h.b Feu;
  private com.tencent.mm.ui.widget.a.f Fev;
  private final com.tencent.mm.plugin.finder.profile.adapter.a Few;
  private final kotlin.j Fex;
  boolean Fey;
  private boolean Fez;
  private String username;
  
  static
  {
    AppMethodBeat.i(349840);
    FdM = new a((byte)0);
    userExtInfoCache = new com.tencent.mm.b.h(100);
    AppMethodBeat.o(349840);
  }
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348945);
    this.Fag = af.mU((Context)paramAppCompatActivity).inflate(e.f.finder_profile_ui_header, null);
    this.FdN = kotlin.k.cm((kotlin.g.a.a)new af(paramAppCompatActivity));
    this.FdO = kotlin.k.cm((kotlin.g.a.a)new ae(this));
    this.FdP = kotlin.k.cm((kotlin.g.a.a)new u(this));
    this.DkO = kotlin.k.cm((kotlin.g.a.a)new am(this));
    this.FdQ = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.FdR = kotlin.k.cm((kotlin.g.a.a)new av(this));
    this.FdS = kotlin.k.cm((kotlin.g.a.a)new aw(this));
    this.FdT = kotlin.k.cm((kotlin.g.a.a)new w(this));
    this.FdU = kotlin.k.cm((kotlin.g.a.a)new x(this));
    this.FdV = kotlin.k.cm((kotlin.g.a.a)new r(this));
    this.FdW = kotlin.k.cm((kotlin.g.a.a)new ai(this));
    this.FdX = kotlin.k.cm((kotlin.g.a.a)new s(this));
    this.FdY = kotlin.k.cm((kotlin.g.a.a)new n(this));
    this.FdZ = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.Fea = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.Feb = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.Fec = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.Fed = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.Fee = kotlin.k.cm((kotlin.g.a.a)new al(this));
    this.Fef = kotlin.k.cm((kotlin.g.a.a)new q(this));
    this.Feg = kotlin.k.cm((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.Fcw = kotlin.k.cm((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.Feh = kotlin.k.cm((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.Fei = kotlin.k.cm((kotlin.g.a.a)new t(this));
    this.Fej = kotlin.k.cm((kotlin.g.a.a)new aj(paramAppCompatActivity));
    this.Fcu = kotlin.k.cm((kotlin.g.a.a)new aq(paramAppCompatActivity));
    this.AvY = kotlin.k.cm((kotlin.g.a.a)new ak(paramAppCompatActivity));
    this.AIq = kotlin.k.cm((kotlin.g.a.a)new ah(this));
    this.Fes = "";
    this.username = "";
    this.Bld = kotlin.k.cm((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.FcD = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry();
    paramAppCompatActivity = this.Fag;
    if (paramAppCompatActivity == null)
    {
      paramAppCompatActivity = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(348945);
      throw paramAppCompatActivity;
    }
    this.Few = new com.tencent.mm.plugin.finder.profile.adapter.a((ViewGroup)paramAppCompatActivity);
    this.Fex = kotlin.k.cm((kotlin.g.a.a)v.FeO);
    this.AuP = true;
    this.Fez = true;
    this.FeA = "";
    this.FeB = new m(this);
    AppMethodBeat.o(348945);
  }
  
  private final h.b Z(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(349404);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.Feu;
      if (localObject == null) {}
      for (localObject = null; kotlin.g.b.s.p(localObject, paramString); localObject = ((h.b)localObject).signature)
      {
        paramString = this.Feu;
        AppMethodBeat.o(349404);
        return paramString;
      }
    }
    if (!paramBoolean)
    {
      localObject = this.Fet;
      if (localObject == null) {}
      for (localObject = null; kotlin.g.b.s.p(localObject, paramString); localObject = ((h.b)localObject).signature)
      {
        paramString = this.Fet;
        AppMethodBeat.o(349404);
        return paramString;
      }
    }
    AppMethodBeat.o(349404);
    return null;
  }
  
  private final StringBuilder a(final com.tencent.mm.plugin.finder.api.m paramm, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(349425);
    Object localObject2 = paramm.field_signature;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject1 = Z(paramBoolean, (String)localObject1);
    if (localObject1 != null)
    {
      paramm = ((h.b)localObject1).FeC;
      if (paramm == null) {}
      for (paramm = null;; paramm = ah.aiuX)
      {
        if (paramm == null) {
          eJq().setText((CharSequence)"");
        }
        paramm = ((h.b)localObject1).FeD;
        AppMethodBeat.o(349425);
        return paramm;
        eJq().setText((CharSequence)paramm);
        localObject2 = com.tencent.mm.plugin.finder.utils.av.GiL;
        com.tencent.mm.plugin.finder.utils.av.a((TextView)eJq().getContentTextView(), (Spannable)paramm);
      }
    }
    Object localObject3 = getContext().getResources().getString(e.h.finder_contact_desc, new Object[] { paramm.field_signature });
    kotlin.g.b.s.s(localObject3, "context.resources.getStr… contact.field_signature)");
    localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d((Context)getContext(), (CharSequence)localObject3, 0.0F);
    localObject2 = new StringBuilder();
    if (aBu()) {}
    for (final int i = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.transparent);; i = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_0_Alpha_0_2))
    {
      com.tencent.mm.plugin.finder.utils.h localh = com.tencent.mm.plugin.finder.utils.h.Gga;
      com.tencent.mm.plugin.finder.utils.h.a((String)localObject3, (kotlin.g.a.q)new ar((SpannableString)localObject1, paramInt, i, (StringBuilder)localObject2, this, paramm));
      eJq().setText((CharSequence)localObject1);
      localObject3 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject3 = (TextView)eJq().getContentTextView();
      kotlin.g.b.s.s(localObject1, "signatureSpan");
      com.tencent.mm.plugin.finder.utils.av.a((TextView)localObject3, (Spannable)localObject1);
      paramm = paramm.field_signature;
      kotlin.g.b.s.s(paramm, "contact.field_signature");
      a(paramBoolean, new h.b(paramm, (SpannableString)localObject1, (StringBuilder)localObject2));
      AppMethodBeat.o(349425);
      return localObject2;
    }
  }
  
  private static final Map a(h paramh, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(349625);
    kotlin.g.b.s.u(paramh, "this$0");
    paramString = as.GSQ;
    paramString = as.a.hu((Context)paramh.getActivity());
    kotlin.r localr;
    if (paramString == null)
    {
      paramString = null;
      localr = v.Y("session_id", paramString);
      paramString = as.GSQ;
      paramString = as.a.hu((Context)paramh.getActivity());
      if (paramString != null) {
        break label137;
      }
      paramString = null;
      label65:
      paramString = v.Y("finder_context_id", paramString);
      as.a locala = as.GSQ;
      paramh = as.a.hu((Context)paramh.getActivity());
      if (paramh != null) {
        break label145;
      }
    }
    label137:
    label145:
    for (paramh = localObject;; paramh = paramh.zIB)
    {
      paramh = kotlin.a.ak.e(new kotlin.r[] { localr, paramString, v.Y("finder_tab_context_id", paramh) });
      AppMethodBeat.o(349625);
      return paramh;
      paramString = paramString.sessionId;
      break;
      paramString = paramString.zIO;
      break label65;
    }
  }
  
  private static void a(Context paramContext, String paramString, int paramInt, FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(349280);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedid", com.tencent.mm.ae.d.hF(0L));
      localJSONObject.put("jump_info", com.tencent.mm.ae.f.dg(paramFinderJumpInfo));
      localJSONObject.put("scene", 3);
      localJSONObject.put("type", 0);
      label61:
      paramFinderJumpInfo = bb.FuK;
      paramFinderJumpInfo = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext == null) {}
      for (paramContext = null;; paramContext = paramContext.fou())
      {
        bb.a(paramContext, paramString, paramInt, localJSONObject);
        AppMethodBeat.o(349280);
        return;
      }
    }
    catch (JSONException paramFinderJumpInfo)
    {
      break label61;
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.api.m paramm, h paramh, View paramView)
  {
    AppMethodBeat.i(349690);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramm, "$contact");
    kotlin.g.b.s.u(paramh, "this$0");
    paramView = new Intent();
    paramView.putStringArrayListExtra("key_url_list", new ArrayList((Collection)kotlin.a.p.listOf(paramm.dUs())));
    paramView.putExtra("key_preview_avatar", true);
    com.tencent.mm.plugin.finder.utils.a.GfO.v((Context)paramh.getActivity(), paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349690);
  }
  
  private static final void a(h paramh)
  {
    AppMethodBeat.i(349524);
    paramh.eJC().setVisibility(8);
    if ((paramh.isSelf()) && (paramh.isSelfFlag()))
    {
      paramh.eIF().setVisibility(0);
      paramh.eIH().setVisibility(8);
      AppMethodBeat.o(349524);
      return;
    }
    paramh.eIF().setVisibility(8);
    paramh.eIH().setVisibility(0);
    AppMethodBeat.o(349524);
  }
  
  private static final void a(h paramh, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(349671);
    kotlin.g.b.s.u(paramh, "this$0");
    paramContextMenu.add(0, 0, 0, (CharSequence)paramh.getContext().getString(e.h.app_copy));
    AppMethodBeat.o(349671);
  }
  
  private static final void a(h paramh, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(349677);
    kotlin.g.b.s.u(paramh, "this$0");
    if (paramInt == 0) {
      ClipboardHelper.setText(paramh.eJq().getText());
    }
    AppMethodBeat.o(349677);
  }
  
  private static final void a(h paramh, View paramView)
  {
    AppMethodBeat.i(349532);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.av.GiL;
    paramView = (Context)paramh.getContext();
    localObject = paramh.getProfileContact();
    if (localObject == null) {}
    for (int i = 0;; i = ((com.tencent.mm.plugin.finder.api.m)localObject).field_extFlag)
    {
      if (!com.tencent.mm.plugin.finder.utils.av.aF(paramView, i))
      {
        paramView = com.tencent.mm.plugin.finder.report.f.FnM;
        paramView = com.tencent.mm.plugin.finder.report.f.eMn();
        localObject = com.tencent.mm.model.z.bAW();
        kotlin.g.b.s.s(localObject, "getMyFinderUsername()");
        paramView.ak((String)localObject, "", paramh.username);
        paramView = com.tencent.mm.plugin.finder.report.f.FnM;
        f.b.a(com.tencent.mm.plugin.finder.report.f.eMn(), paramh.getContextObj(), 3L, 2L);
        paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.aH((Context)paramh.getContext(), paramh.username);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349532);
      return;
    }
  }
  
  private static final void a(h paramh, com.tencent.mm.plugin.finder.api.m paramm, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(349596);
    kotlin.g.b.s.u(paramh, "this$0");
    kotlin.g.b.s.u(paramm, "$contact");
    if (paramMenuItem.getItemId() == 10021)
    {
      paramh.h(paramm);
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("view_clk", (FrameLayout)paramh.Fag.findViewById(e.e.finder_profile_follow_btn), kotlin.a.ak.l(v.Y("action_type", "profile_unfollow_click")), 24617);
      paramh.Fev = null;
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("un_follow_click", null, null, 24617);
    }
    AppMethodBeat.o(349596);
  }
  
  private static final void a(final h paramh, l.a parama)
  {
    int j = 0;
    AppMethodBeat.i(349559);
    kotlin.g.b.s.u(paramh, "this$0");
    View localView = paramh.Fag.findViewById(e.e.finder_profile_edit_btn_dot);
    if ((parama != null) && (parama.hBY == true))
    {
      i = 1;
      if (i == 0) {
        break label120;
      }
    }
    label120:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      i = j;
      if (parama != null)
      {
        i = j;
        if (parama.hBY == true) {
          i = 1;
        }
      }
      if ((i != 0) && (localView.getVisibility() == 0))
      {
        kotlin.g.b.s.s(localView, "dotView");
        com.tencent.mm.view.f.a(localView, (com.tencent.mm.view.e.b)new y(parama, paramh));
      }
      AppMethodBeat.o(349559);
      return;
      i = 0;
      break;
    }
  }
  
  private static final void a(h paramh, FinderJumpInfo paramFinderJumpInfo, String paramString1, int paramInt, String paramString2, ah.f paramf, String paramString3, View paramView)
  {
    AppMethodBeat.i(349550);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramFinderJumpInfo);
    localb.cH(paramString1);
    localb.sc(paramInt);
    localb.cH(paramString2);
    localb.cH(paramf);
    localb.cH(paramString3);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    kotlin.g.b.s.u(paramFinderJumpInfo, "$jumpInfo");
    kotlin.g.b.s.u(paramf, "$avatarUrl");
    kotlin.g.b.s.u(paramString3, "$nickname");
    a((Context)paramh.getContext(), "feed_jumpicon", 1, paramFinderJumpInfo);
    paramFinderJumpInfo = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
    paramView = (Context)paramh.getContext();
    localObject = new brs();
    ((brs)localObject).ZVq = String.valueOf(paramInt);
    ((brs)localObject).ZVp = paramString2;
    ((brs)localObject).ZVs = ((String)paramf.aqH);
    ((brs)localObject).ZVr = paramString3;
    ((brs)localObject).finderUsername = paramh.username;
    paramString2 = ah.aiuX;
    paramString2 = new dwa();
    paramf = b.e.ahon;
    paramString2.abbK = b.e.a.jVY();
    paramString2.finderUsername = paramh.username;
    paramh = ah.aiuX;
    paramFinderJumpInfo.gotoLive(paramView, paramString1, (brs)localObject, paramString2);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349550);
  }
  
  private static final void a(h paramh, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(349588);
    kotlin.g.b.s.u(paramh, "this$0");
    if (params.jmw()) {
      params.a(10021, paramh.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red), (CharSequence)paramh.getResources().getString(e.h.finder_cancel_follow_title));
    }
    AppMethodBeat.o(349588);
  }
  
  private static final void a(h paramh, boolean paramBoolean, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(349711);
    kotlin.g.b.s.u(paramh, "this$0");
    if (paramMenuItem.getItemId() == 10011) {
      if (paramBoolean) {
        break label44;
      }
    }
    label44:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramh.am(paramBoolean, true);
      AppMethodBeat.o(349711);
      return;
    }
  }
  
  private static final void a(FinderAuthInfo paramFinderAuthInfo, h paramh, View paramView)
  {
    AppMethodBeat.i(349576);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderAuthInfo);
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderAuthInfo, "$authInfo");
    kotlin.g.b.s.u(paramh, "this$0");
    paramView = paramFinderAuthInfo.authGenerator;
    int i;
    if (paramView != null)
    {
      localObject = paramView.username;
      if (localObject == null) {
        break label213;
      }
      if (((CharSequence)localObject).length() <= 0) {
        break label208;
      }
      i = 1;
      if (i != 1) {
        break label213;
      }
      i = 1;
      label120:
      if ((i == 0) || (paramFinderAuthInfo.verify_status == 12)) {
        break label218;
      }
      i = 1;
      label135:
      if (i == 0) {
        break label223;
      }
    }
    label208:
    label213:
    label218:
    label223:
    for (paramFinderAuthInfo = paramView;; paramFinderAuthInfo = null)
    {
      if (paramFinderAuthInfo != null)
      {
        paramView = new Intent();
        paramView.putExtra("finder_username", paramFinderAuthInfo.username);
        com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI((Context)paramh.getActivity(), paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349576);
      return;
      i = 0;
      break;
      i = 0;
      break label120;
      i = 0;
      break label135;
    }
  }
  
  private static final void a(String paramString, h paramh, JSONObject paramJSONObject, View paramView)
  {
    AppMethodBeat.i(349543);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramString);
    localb.cH(paramh);
    localb.cH(paramJSONObject);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    kotlin.g.b.s.u(paramJSONObject, "$reportJson");
    paramView = new Intent();
    paramView.putExtra("rawUrl", paramString);
    com.tencent.mm.br.c.b((Context)paramh.getActivity(), "webview", ".ui.tools.WebViewUI", paramView);
    paramString = bb.FuK;
    paramString = as.GSQ;
    paramString = as.a.hu((Context)paramh.getContext());
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.fou())
    {
      bb.a(paramString, "get_red_cover_panel", 1, paramJSONObject);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349543);
      return;
    }
  }
  
  private final void a(boolean paramBoolean, h.b paramb)
  {
    if (paramBoolean)
    {
      this.Feu = paramb;
      return;
    }
    this.Fet = paramb;
  }
  
  private static boolean aBu()
  {
    AppMethodBeat.i(349512);
    boolean bool = ((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu();
    AppMethodBeat.o(349512);
    return bool;
  }
  
  private final void aa(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(349496);
    com.tencent.mm.plugin.finder.profile.adapter.a locala;
    Context localContext;
    if (paramBoolean)
    {
      eJB().setVisibility(0);
      if (!kotlin.g.b.s.p(paramString, "onCreate"))
      {
        locala = this.Few;
        localContext = this.Fag.getContext();
        paramString = getProfileContact();
        if (paramString != null) {
          break label90;
        }
      }
    }
    label90:
    for (paramString = null;; paramString = paramString.dUr())
    {
      locala.a(com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)paramString), eJV(), false);
      AppMethodBeat.o(349496);
      return;
      eJB().setVisibility(8);
      break;
    }
  }
  
  private final void am(boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(349518);
    this.CYX = ((ck)new p(this, paramBoolean2));
    ((com.tencent.mm.plugin.finder.service.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.n.class)).a(this.username, paramBoolean1, this.CYX);
    AppMethodBeat.o(349518);
  }
  
  private final void azq(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(349187);
    long l = SystemClock.uptimeMillis();
    azr(paramString);
    eJK();
    eJT();
    eJQ();
    eJU();
    eJR();
    azt(paramString);
    eJL();
    eJF();
    eJJ();
    azs(paramString);
    eJH();
    eJI();
    Object localObject3 = this.Feo;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("liveWidget");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.profile.widget.c)localObject1).a(paramString, this.username, isSelf(), isSelfFlag(), getProfileContact());
    localObject3 = this.Fel;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mediaEntrance");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.profile.widget.d)localObject1).c(this.username, getProfileContact());
    localObject3 = this.Fem;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("miniProgram");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.profile.widget.e)localObject1).a(paramString, this.username, getProfileContact());
    localObject3 = this.Fen;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("activityWidget");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.profile.widget.a)localObject1).y(paramString, this.username, this.Fez);
    eJW();
    localObject3 = this.Fek;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("enterpriseAdd");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.profile.widget.b)localObject1).b(this.username, getProfileContact());
    localObject1 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    aa(com.tencent.mm.plugin.finder.utils.aw.o(com.tencent.mm.plugin.finder.api.d.a.auT(this.username)), paramString);
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    ((l)com.tencent.mm.ui.component.k.d(getActivity()).q(l.class)).i(getProfileContact());
    localObject3 = this.Few;
    Context localContext = this.Fag.getContext();
    localObject1 = getProfileContact();
    if (localObject1 == null)
    {
      localObject1 = null;
      ((com.tencent.mm.plugin.finder.profile.adapter.a)localObject3).a(com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)localObject1), eJV(), kotlin.g.b.s.p("onCreate", paramString));
      localObject3 = new StringBuilder("[refreshProfile] nickname:");
      localObject1 = getProfileContact();
      if (localObject1 != null) {
        break label460;
      }
    }
    label460:
    for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.finder.api.m)localObject1).dUr())
    {
      Log.i("Finder.FinderProfileHeaderUIC", localObject1 + " COST=" + (SystemClock.uptimeMillis() - l) + "ms source=" + paramString);
      AppMethodBeat.o(349187);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.api.m)localObject1).dUr();
      break;
    }
  }
  
  private final void azr(String paramString)
  {
    AppMethodBeat.i(349197);
    Object localObject = (c)userExtInfoCache.get(this.username);
    if (localObject == null) {
      paramString = null;
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString == null)
      {
        a(this);
        localObject = Boolean.FALSE;
      }
      Log.i("Finder.FinderProfileHeaderUIC", kotlin.g.b.s.X("[handleLogOut] logout = ", localObject));
      AppMethodBeat.o(349197);
      return;
      localObject = ((c)localObject).FeH;
      if (localObject == null)
      {
        paramString = null;
      }
      else
      {
        if (!((d.a.a)localObject).Axe)
        {
          com.tencent.mm.plugin.finder.api.m localm = getProfileContact();
          if ((localm == null) || (localm.isBlock() != true)) {
            break label175;
          }
        }
        label175:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label180;
          }
          eIF().setVisibility(8);
          eIH().setVisibility(8);
          eJC().setVisibility(0);
          paramString = (TextView)eJC().findViewById(e.e.text);
          if (paramString != null) {
            paramString.setText((CharSequence)getActivity().getString(e.h.finder_account_logout_tips));
          }
          paramString = ah.aiuX;
          break;
        }
        label180:
        if (((d.a.a)localObject).Axb == 1)
        {
          if ((isSelf()) && (isSelfFlag())) {
            if (kotlin.g.b.s.p(paramString, "onSceneEnd:[NetSceneFinderUserPage]"))
            {
              getActivity().finish();
              paramString = com.tencent.mm.plugin.finder.utils.a.GfO;
              com.tencent.mm.plugin.finder.utils.a.aG((Context)getActivity(), this.username);
            }
          }
          for (;;)
          {
            eIF().setVisibility(8);
            eIH().setVisibility(8);
            paramString = Boolean.TRUE;
            break;
            eJC().setVisibility(0);
          }
        }
        a(this);
        paramString = Boolean.FALSE;
      }
    }
  }
  
  private final void azs(String paramString)
  {
    AppMethodBeat.i(349232);
    if (eJG())
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eUx().bmg()).intValue() == 1) {
        ((FrameLayout)this.Fag.findViewById(e.e.sendMsgBtn)).setVisibility(8);
      }
      for (;;)
      {
        com.tencent.mm.ui.aw.a((Paint)((TextView)this.Fag.findViewById(e.e.finder_profile_send_msg_btn_tv)).getPaint(), 0.8F);
        if (kotlin.g.b.s.p(paramString, "onCreate"))
        {
          paramString = (FrameLayout)this.Fag.findViewById(e.e.sendMsgBtn);
          kotlin.g.b.s.s(paramString, "header.sendMsgBtn");
          com.tencent.mm.view.f.a((View)paramString, (com.tencent.mm.view.e.b)new aa(this));
        }
        ((FrameLayout)this.Fag.findViewById(e.e.sendMsgBtn)).setOnClickListener(new h..ExternalSyntheticLambda4(this));
        AppMethodBeat.o(349232);
        return;
        ((FrameLayout)this.Fag.findViewById(e.e.sendMsgBtn)).setVisibility(0);
      }
    }
    ((FrameLayout)this.Fag.findViewById(e.e.sendMsgBtn)).setVisibility(8);
    AppMethodBeat.o(349232);
  }
  
  private final void azt(String paramString)
  {
    AppMethodBeat.i(349328);
    Object localObject = (FrameLayout)this.Fag.findViewById(e.e.finder_profile_follow_btn);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eUx().bmg()).intValue() == 1)
    {
      Log.i("Finder.FinderProfileHeaderUIC", "handleFollowBtn return for FINDER_PROFILE_COVER_TEST_ENABLE");
      ((FrameLayout)localObject).setVisibility(8);
      AppMethodBeat.o(349328);
      return;
    }
    if ((isSelf()) || (!this.FcD))
    {
      ((FrameLayout)localObject).setVisibility(8);
      AppMethodBeat.o(349328);
      return;
    }
    com.tencent.mm.ui.aw.a((Paint)((TextView)this.Fag.findViewById(e.e.finder_profile_follow_btn_tv)).getPaint(), 0.8F);
    ((FrameLayout)localObject).setVisibility(0);
    localObject = com.tencent.mm.plugin.finder.upload.action.i.Gde;
    if (com.tencent.mm.plugin.finder.upload.action.i.a(com.tencent.mm.plugin.finder.upload.action.i.fej(), this.username, true, false, 4))
    {
      eJN();
      AppMethodBeat.o(349328);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.upload.action.i.Gde;
    if (com.tencent.mm.plugin.finder.upload.action.i.fej().St(this.username))
    {
      eJM();
      AppMethodBeat.o(349328);
      return;
    }
    azu(paramString);
    AppMethodBeat.o(349328);
  }
  
  private final void azu(String paramString)
  {
    AppMethodBeat.i(349388);
    Object localObject = getProfileContact();
    if (localObject == null)
    {
      AppMethodBeat.o(349388);
      return;
    }
    FrameLayout localFrameLayout = (FrameLayout)this.Fag.findViewById(e.e.finder_profile_follow_btn);
    TextView localTextView = (TextView)this.Fag.findViewById(e.e.finder_profile_follow_btn_tv);
    eJP();
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(localFrameLayout, "finder_profile_follow");
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).f(localFrameLayout, 8, 24617);
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(localFrameLayout, new h..ExternalSyntheticLambda19(this));
    com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    final boolean bool = com.tencent.mm.plugin.finder.utils.aw.n((com.tencent.mm.plugin.finder.api.m)localObject);
    int i;
    int j;
    if (kotlin.g.b.s.p(paramString, "onSceneEnd"))
    {
      paramString = com.tencent.mm.ui.component.k.aeZF;
      paramString = ((FinderProfileTabUIC)com.tencent.mm.ui.component.k.d(getActivity()).q(FinderProfileTabUIC.class)).be(FinderProfileFeedFragment.class);
      localObject = com.tencent.mm.ui.component.k.aeZF;
      paramString = ((FinderProfileFeedUIC)com.tencent.mm.ui.component.k.y((Fragment)paramString).q(FinderProfileFeedUIC.class)).getState();
      localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject = this.username;
      int k = com.tencent.mm.model.cn.getSyncServerTimeSecond();
      if (bool)
      {
        i = 1;
        if (paramString != FinderProfileFeedLoader.State.PRIVATE_LOCK) {
          break label414;
        }
        j = 1;
        label228:
        com.tencent.mm.plugin.finder.report.z.c((String)localObject, 4, k, i, j);
      }
    }
    else
    {
      if (!bool) {
        break label419;
      }
      eJA().setText(e.h.finder_follow_apply);
      localTextView.setText(e.h.finder_follow_apply);
    }
    for (;;)
    {
      eJy().setBackgroundResource(e.d.finder_profile_follow_btn_bg);
      eJA().setTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.White));
      localTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.White));
      localFrameLayout.setBackgroundResource(e.d.finder_profile_follow_btn_bg);
      paramString = new boolean[1];
      paramString[0] = 0;
      localFrameLayout.setOnTouchListener(new h..ExternalSyntheticLambda17(paramString));
      paramString = (kotlin.g.a.b)new at(paramString, this, bool);
      localFrameLayout.setOnClickListener(new h..ExternalSyntheticLambda14(paramString));
      eJy().setOnClickListener(new h..ExternalSyntheticLambda10(paramString));
      localFrameLayout.setTag(e.e.finder_accessibility_profile_follow_tag, localTextView.getText());
      localFrameLayout.post(new h..ExternalSyntheticLambda26(this));
      AppMethodBeat.o(349388);
      return;
      i = 0;
      break;
      label414:
      j = 0;
      break label228;
      label419:
      eJA().setText(e.h.finder_follow);
      localTextView.setText(e.h.finder_follow);
    }
  }
  
  private static final void b(h paramh)
  {
    AppMethodBeat.i(349599);
    kotlin.g.b.s.u(paramh, "this$0");
    paramh.Fev = null;
    AppMethodBeat.o(349599);
  }
  
  private static final void b(h paramh, View paramView)
  {
    AppMethodBeat.i(349569);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    paramView = as.GSQ;
    as.a.a((Context)paramh.getActivity(), paramh.getIntent(), 0L, null, 0, 0, false);
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.n((Activity)paramh.getActivity(), paramh.getIntent());
    paramView = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("FinderSetting");
    localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderSetting");
    if ((localObject != null) && (paramView != null)) {
      com.tencent.mm.plugin.finder.report.w.a(com.tencent.mm.plugin.finder.report.w.FrV, "3", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject, paramView, 2, paramh.getContextObj(), 0, null, 0, 480);
    }
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("FinderSetting");
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().d("ProfileEntrance", new int[] { 1000 });
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349569);
  }
  
  private static final void b(h paramh, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(349704);
    kotlin.g.b.s.u(paramh, "this$0");
    if (params.jmw()) {
      params.a(10011, paramh.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red), (CharSequence)paramh.getResources().getString(e.h.finder_mod_block_bottom_sheet_desc));
    }
    AppMethodBeat.o(349704);
  }
  
  private static final void b(FinderAuthInfo paramFinderAuthInfo, h paramh, View paramView)
  {
    AppMethodBeat.i(349583);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderAuthInfo);
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderAuthInfo, "$authInfo");
    kotlin.g.b.s.u(paramh, "this$0");
    if ((!Util.isNullOrNil(paramFinderAuthInfo.appName)) && (!Util.isNullOrNil(paramFinderAuthInfo.detailLink)))
    {
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject = (Context)paramh.getActivity();
      paramView = paramFinderAuthInfo.appName;
      paramh = paramView;
      if (paramView == null) {
        paramh = "";
      }
      paramView = paramFinderAuthInfo.detailLink;
      paramFinderAuthInfo = paramView;
      if (paramView == null) {
        paramFinderAuthInfo = "";
      }
      com.tencent.mm.plugin.finder.utils.a.C((Context)localObject, paramh, paramFinderAuthInfo);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349583);
      return;
      if (!Util.isNullOrNil(paramFinderAuthInfo.detailLink))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", paramFinderAuthInfo.detailLink);
        com.tencent.mm.br.c.b((Context)paramh.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
  }
  
  private static final void c(h paramh)
  {
    AppMethodBeat.i(349648);
    kotlin.g.b.s.u(paramh, "this$0");
    try
    {
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      ((n)com.tencent.mm.ui.component.k.d(paramh.getActivity()).q(n.class)).azv(paramh.username);
      AppMethodBeat.o(349648);
      return;
    }
    catch (Exception paramh)
    {
      Log.printErrStackTrace("Finder.FinderProfileHeaderUIC", (Throwable)paramh, "", new Object[0]);
      AppMethodBeat.o(349648);
    }
  }
  
  private static final void c(h paramh, View paramView)
  {
    AppMethodBeat.i(349653);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    paramView = new Intent();
    paramView.putExtra("key_scene", 2);
    localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.ag((Context)paramh.getContext(), paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349653);
  }
  
  private static final void d(h paramh, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(349663);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    if (paramh.eJq().fke())
    {
      if (!paramh.eJq().Gwx) {
        break label179;
      }
      paramView = bb.FuK;
      paramView = as.GSQ;
      paramView = as.a.hu((Context)paramh.getContext());
      if (paramView != null) {
        break label171;
      }
      paramView = null;
      bb.a(paramView, "description_fold", 1);
      paramView = paramh.eJq();
      if (paramh.eJq().Gwx) {
        break label223;
      }
    }
    label171:
    label179:
    label223:
    for (boolean bool = true;; bool = false)
    {
      paramView.setExpand(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349663);
      return;
      paramView = paramView.fou();
      break;
      paramView = bb.FuK;
      paramView = as.GSQ;
      paramView = as.a.hu((Context)paramh.getContext());
      if (paramView == null) {}
      for (paramView = localObject1;; paramView = paramView.fou())
      {
        bb.a(paramView, "description_unfold", 1);
        break;
      }
    }
  }
  
  private static final boolean d(boolean[] paramArrayOfBoolean, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(349631);
    kotlin.g.b.s.u(paramArrayOfBoolean, "$followOnTouchDownCalled");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(349631);
      return false;
      paramArrayOfBoolean[0] = true;
      com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_follow", "<FeedFollow>");
      continue;
      com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_follow", paramMotionEvent);
      com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_follow");
    }
  }
  
  private static final boolean e(h paramh, View paramView)
  {
    AppMethodBeat.i(349682);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    paramView = new com.tencent.mm.ui.widget.b.a((Context)paramh.getContext(), paramView);
    paramView.agjt = new h..ExternalSyntheticLambda15(paramh);
    paramView.GAC = new h..ExternalSyntheticLambda22(paramh);
    paramh = TouchableLayout.agKp;
    int i = TouchableLayout.jMn();
    paramh = TouchableLayout.agKp;
    boolean bool = paramView.fQ(i, TouchableLayout.jMo());
    com.tencent.mm.hellhoundlib.a.a.a(bool, new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(349682);
    return bool;
  }
  
  private final LinearLayout eIF()
  {
    AppMethodBeat.i(349133);
    LinearLayout localLinearLayout = (LinearLayout)this.Fcu.getValue();
    AppMethodBeat.o(349133);
    return localLinearLayout;
  }
  
  private final LinearLayout eIH()
  {
    AppMethodBeat.i(349139);
    LinearLayout localLinearLayout = (LinearLayout)this.AvY.getValue();
    AppMethodBeat.o(349139);
    return localLinearLayout;
  }
  
  private final TextView eJA()
  {
    AppMethodBeat.i(349115);
    TextView localTextView = (TextView)this.Feh.getValue();
    AppMethodBeat.o(349115);
    return localTextView;
  }
  
  private final WeImageView eJB()
  {
    AppMethodBeat.i(349120);
    WeImageView localWeImageView = (WeImageView)this.Fei.getValue();
    AppMethodBeat.o(349120);
    return localWeImageView;
  }
  
  private final View eJC()
  {
    AppMethodBeat.i(349129);
    View localView = (View)this.Fej.getValue();
    AppMethodBeat.o(349129);
    return localView;
  }
  
  private final boolean eJD()
  {
    AppMethodBeat.i(349174);
    boolean bool = ((Boolean)this.Fex.getValue()).booleanValue();
    AppMethodBeat.o(349174);
    return bool;
  }
  
  private final void eJF()
  {
    AppMethodBeat.i(349206);
    c localc2 = (c)userExtInfoCache.get(this.username);
    c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new c();
    }
    if ((localc1.fansCount > 0) && (eJS()))
    {
      eJo().setVisibility(0);
      AppMethodBeat.o(349206);
      return;
    }
    if (((!isSelf()) || (!isSelfFlag())) && (localc1.friendFollowCount > 0) && (this.FcD))
    {
      eJo().setVisibility(0);
      AppMethodBeat.o(349206);
      return;
    }
    eJo().setVisibility(8);
    AppMethodBeat.o(349206);
  }
  
  private final void eJH()
  {
    AppMethodBeat.i(349253);
    View localView = this.Fag.findViewById(e.e.profile_lucky_money_cover_layout);
    String str = getIntent().getStringExtra("key_same_receive_link");
    Object localObject1 = (CharSequence)str;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; (i != 0) || (eJD()); i = 0)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(349253);
      return;
    }
    boolean bool = getIntent().getBooleanExtra("key_enter_from_story", false);
    Object localObject2 = getIntent().getStringExtra("key_packet_id");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("red_cover_id", localObject1);
    ((JSONObject)localObject2).put("finderusername", this.username);
    ((JSONObject)localObject2).put("red_cover_type", 1);
    if (bool) {}
    for (i = 2;; i = 1)
    {
      ((JSONObject)localObject2).put("red_entrance_type", i);
      localView.setVisibility(0);
      localView.setOnClickListener(new h..ExternalSyntheticLambda9(str, this, (JSONObject)localObject2));
      kotlin.g.b.s.s(localView, "layout");
      com.tencent.mm.view.f.a(localView, (com.tencent.mm.view.e.b)new z(this, (JSONObject)localObject2));
      AppMethodBeat.o(349253);
      return;
    }
  }
  
  private final void eJI()
  {
    String str = null;
    AppMethodBeat.i(349271);
    View localView = this.Fag.findViewById(e.e.profile_oly_jumper_layout);
    Object localObject1 = (CharSequence)getIntent().getStringExtra("key_same_receive_link");
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (eJD())) {
        break label90;
      }
      localView.setVisibility(8);
      AppMethodBeat.o(349271);
      return;
      i = 0;
      break;
    }
    label90:
    localObject1 = (c)userExtInfoCache.get(this.username);
    if (localObject1 != null)
    {
      localObject1 = ((c)localObject1).FeL;
      if (localObject1 != null)
      {
        Object localObject2 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (((FinderJumpInfo)localObject1).business_type == 16) {
            i = 1;
          }
        }
        while (i != 0)
        {
          label164:
          final FinderJumpInfo localFinderJumpInfo = (FinderJumpInfo)localObject1;
          if (localFinderJumpInfo != null)
          {
            kotlin.g.b.s.s(localView, "olyLayout");
            com.tencent.mm.view.f.a(localView, (com.tencent.mm.view.e.b)new ab(this, localFinderJumpInfo));
            localView.setVisibility(0);
            localObject2 = (TextView)localView.findViewById(e.e.profile_oly_title);
            kotlin.g.b.s.s(localObject2, "titleTv");
            com.tencent.mm.plugin.finder.utils.i.setTextBold((TextView)localObject2);
            Object localObject3 = (TextView)localView.findViewById(e.e.profile_oly_desc);
            localObject1 = localFinderJumpInfo.recommend_reason;
            if (localObject1 == null)
            {
              localObject1 = (CharSequence)"";
              label263:
              ((TextView)localObject2).setText((CharSequence)localObject1);
              localObject2 = localFinderJumpInfo.wording;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              ((TextView)localObject3).setText((CharSequence)localObject1);
              if (((CharSequence)localObject1).length() != 0) {
                break label507;
              }
              i = 1;
              label311:
              if (i != 0) {
                ((TextView)localObject3).setVisibility(8);
              }
              localObject1 = (ImageView)localView.findViewById(e.e.oly_profile_bg_iv);
              if (!com.tencent.mm.ui.aw.isDarkMode()) {
                break label512;
              }
              ((ImageView)localObject1).setImageResource(e.d.olympics_profile_entrance_bg_dark);
            }
            try
            {
              label347:
              localObject1 = localFinderJumpInfo.native_info;
              label359:
              ah.f localf;
              if (localObject1 == null)
              {
                localObject1 = str;
                Log.i("Finder.FinderProfileHeaderUIC", kotlin.g.b.s.X("oly bindview, json:", localObject1));
                localObject1 = new JSONObject((String)localObject1);
                ((JSONObject)localObject1).getString("live_nickname");
                localObject2 = ((JSONObject)localObject1).getString("live_username");
                localObject3 = ((JSONObject)localObject1).optString("by_pass_info_string", "");
                i = ((JSONObject)localObject1).getInt("relay_index");
                localf = new ah.f();
                localObject1 = getProfileContact();
                if (localObject1 != null) {
                  break label530;
                }
                localObject1 = "";
                label440:
                localf.aqH = localObject1;
                localObject1 = getProfileContact();
                if (localObject1 != null) {
                  break label548;
                }
                localObject1 = "";
              }
              for (;;)
              {
                localView.setOnClickListener(new h..ExternalSyntheticLambda6(this, localFinderJumpInfo, (String)localObject2, i, (String)localObject3, localf, (String)localObject1));
                AppMethodBeat.o(349271);
                return;
                i = 0;
                break;
                localObject1 = null;
                break label164;
                localObject1 = (CharSequence)localObject1;
                break label263;
                label507:
                i = 0;
                break label311;
                label512:
                ((ImageView)localObject1).setImageResource(e.d.olympics_profile_entrance_bg);
                break label347;
                localObject1 = ((NativeInfo)localObject1).necessary_params;
                break label359;
                label530:
                str = ((com.tencent.mm.plugin.finder.api.m)localObject1).dUs();
                localObject1 = str;
                if (str != null) {
                  break label440;
                }
                localObject1 = "";
                break label440;
                label548:
                str = ((com.tencent.mm.plugin.finder.api.m)localObject1).dUr();
                localObject1 = str;
                if (str == null) {
                  localObject1 = "";
                }
              }
              AppMethodBeat.o(349271);
            }
            finally
            {
              Log.printErrStackTrace("Finder.FinderProfileHeaderUIC", localThrowable, "oly bindview error", new Object[0]);
              localView.setVisibility(8);
            }
          }
        }
      }
    }
  }
  
  private final void eJJ()
  {
    AppMethodBeat.i(349286);
    Object localObject;
    if ((!isSelf()) || (!isSelfFlag()))
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eUx().bmg()).intValue() != 1) {}
    }
    else
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.l.ARA;
      com.tencent.mm.ae.d.a((LiveData)com.tencent.mm.plugin.finder.extension.reddot.l.dZH(), (androidx.lifecycle.q)getActivity(), new h..ExternalSyntheticLambda18(this));
      eJx().setVisibility(0);
      eJx().setOnClickListener(new h..ExternalSyntheticLambda5(this));
      AppMethodBeat.o(349286);
      return;
    }
    eJx().setVisibility(8);
    AppMethodBeat.o(349286);
  }
  
  private final void eJK()
  {
    Object localObject4 = null;
    int k = 1;
    boolean bool = false;
    AppMethodBeat.i(349307);
    eJs().setVisibility(8);
    Object localObject1 = getProfileContact();
    if (localObject1 == null) {}
    for (Object localObject3 = null; localObject3 == null; localObject3 = ((com.tencent.mm.plugin.finder.api.m)localObject1).field_authInfo)
    {
      if (((h)this).getProfileContact() != null) {
        bool = true;
      }
      Log.w("Finder.FinderProfileHeaderUIC", kotlin.g.b.s.X("[handleAuthGenerator] profileContact=", Boolean.valueOf(bool)));
      AppMethodBeat.o(349307);
      return;
    }
    if (((FinderAuthInfo)localObject3).authIconType <= 0)
    {
      Log.w("Finder.FinderProfileHeaderUIC", "[handleAuthGenerator] authIconType<=0");
      AppMethodBeat.o(349307);
      return;
    }
    if (((FinderAuthInfo)localObject3).authGenerator != null)
    {
      localObject1 = (CharSequence)((FinderAuthInfo)localObject3).realName;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label437;
      }
    }
    Object localObject2;
    label437:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Boolean)com.tencent.mm.plugin.finder.storage.d.eWO().bmg()).booleanValue())
        {
          localObject1 = new FinderContact();
          ((FinderContact)localObject1).nickname = "test auth";
          ((FinderContact)localObject1).headUrl = "http://wx.qlogo.cn/finderhead/Q3auHgzwzM5ibPQZNRq2SprG986yC2zMUjSVXgN7CV2hbm0QUjOcAnA/0";
          ((FinderContact)localObject1).username = "v2_060000231003b20faec8c5e18f1cc4d7ca00ee33b07704a3d9a508fb83cdb3ecb0f31f019ec2@finder";
          localObject2 = ah.aiuX;
          ((FinderAuthInfo)localObject3).authGenerator = ((FinderContact)localObject1);
        }
      }
      eJt().setOnClickListener(new h..ExternalSyntheticLambda8((FinderAuthInfo)localObject3, this));
      eJv().setOnClickListener(new h..ExternalSyntheticLambda7((FinderAuthInfo)localObject3, this));
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject1, "service(IFinderCommonService::class.java)");
      localObject1 = (com.tencent.mm.plugin.h)localObject1;
      localObject2 = (ImageView)this.Fag.findViewById(e.e.finder_profile_auth_icon);
      kotlin.g.b.s.s(localObject2, "header.finder_profile_auth_icon");
      com.tencent.mm.plugin.h.a.a((com.tencent.mm.plugin.h)localObject1, (ImageView)localObject2, (FinderAuthInfo)localObject3, 0, null, 12);
      localObject1 = "";
      switch (((FinderAuthInfo)localObject3).authIconType)
      {
      default: 
        localObject2 = "";
        label361:
        localObject4 = eJs();
        if (localObject4 != null) {
          ((LinearLayout)localObject4).setTag(e.e.finder_accessibility_auth_icon_type_tag, Integer.valueOf(((FinderAuthInfo)localObject3).authIconType));
        }
        localObject3 = eJs();
        if (localObject3 != null) {
          ((LinearLayout)localObject3).setTag(e.e.finder_accessibility_auth_info_tag, localObject1);
        }
        localObject1 = eJs();
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setTag(e.e.finder_accessibility_auth_generator_tag, localObject2);
        }
        AppMethodBeat.o(349307);
        return;
      }
    }
    localObject1 = ((FinderAuthInfo)localObject3).authProfession;
    if (localObject1 != null)
    {
      eJv().setVisibility(0);
      eJv().setText((CharSequence)getResources().getString(e.h.finder_contact_auth, new Object[] { localObject1 }));
    }
    for (;;)
    {
      localObject2 = ((FinderAuthInfo)localObject3).authGenerator;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        if (localObject4 == null) {
          ((h)this).eJt().setVisibility(8);
        }
        eJs().setVisibility(0);
        break;
        Object localObject5 = ((FinderContact)localObject2).username;
        label563:
        label570:
        int j;
        if (localObject5 != null) {
          if (((CharSequence)localObject5).length() > 0)
          {
            i = 1;
            if (i != 1) {
              break label610;
            }
            i = 1;
            j = k;
            if (i == 0)
            {
              if (((FinderAuthInfo)localObject3).verify_status != 12) {
                break label615;
              }
              j = k;
            }
            label588:
            if (j == 0) {
              break label620;
            }
          }
        }
        for (;;)
        {
          if (localObject2 != null) {
            break label626;
          }
          localObject2 = "";
          break;
          i = 0;
          break label563;
          label610:
          i = 0;
          break label570;
          label615:
          j = 0;
          break label588;
          label620:
          localObject2 = null;
        }
        label626:
        eJt().setVisibility(0);
        localObject5 = (Context)getContext();
        localObject4 = ((FinderContact)localObject2).nickname;
        localObject2 = localObject4;
        if (localObject4 == null) {
          localObject2 = "";
        }
        localObject2 = com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject5, (CharSequence)localObject2);
        eJu().setText((CharSequence)localObject2);
        kotlin.g.b.s.s(localObject2, "ss");
        localObject4 = ah.aiuX;
      }
      eJt().setVisibility(8);
      eJs().setVisibility(0);
      localObject2 = ((FinderAuthInfo)localObject3).authProfession;
      if (localObject2 == null) {
        break;
      }
      eJv().setVisibility(0);
      eJv().setText((CharSequence)getResources().getString(e.h.finder_contact_auth, new Object[] { localObject2 }));
      localObject1 = localObject2;
      localObject2 = "";
      break label361;
      eJs().setVisibility(0);
      eJt().setVisibility(8);
      eJv().setOnClickListener(null);
      eJv().setText(e.h.finder_has_real_name);
      localObject1 = getContext().getString(e.h.finder_has_real_name);
      kotlin.g.b.s.s(localObject1, "context.getString(R.string.finder_has_real_name)");
      localObject2 = "";
      break label361;
      localObject1 = "";
    }
  }
  
  private final void eJL()
  {
    AppMethodBeat.i(349317);
    if ((!isSelf()) || (!isSelfFlag()))
    {
      c localc2 = (c)userExtInfoCache.get(this.username);
      c localc1 = localc2;
      if (localc2 == null) {
        localc1 = new c();
      }
      if ((localc1.friendFollowCount > 0) && (this.FcD))
      {
        eJl().setVisibility(0);
        eJm().setText((CharSequence)getContext().getResources().getString(e.h.finder_friend_follow, new Object[] { com.tencent.mm.plugin.finder.utils.r.TP(localc1.friendFollowCount) }));
        AppMethodBeat.o(349317);
        return;
      }
    }
    eJl().setVisibility(8);
    AppMethodBeat.o(349317);
  }
  
  private final void eJM()
  {
    AppMethodBeat.i(349341);
    FrameLayout localFrameLayout = (FrameLayout)this.Fag.findViewById(e.e.finder_profile_follow_btn);
    eJP();
    TextView localTextView = (TextView)this.Fag.findViewById(e.e.finder_profile_follow_btn_tv);
    eJA().setText(e.h.finder_follow_waiting);
    eJA().setTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_0));
    eJA().setBackgroundResource(e.d.finder_profile_followed_btn_bg);
    localTextView.setText(e.h.finder_follow_waiting);
    localTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_0));
    localFrameLayout.setBackgroundResource(e.d.finder_profile_followed_btn_bg);
    final com.tencent.mm.plugin.finder.api.m localm = getProfileContact();
    if (localm == null)
    {
      AppMethodBeat.o(349341);
      return;
    }
    localFrameLayout.setOnClickListener(new h..ExternalSyntheticLambda11((kotlin.g.a.b)new au(this, localm)));
    eJy().setOnClickListener(null);
    localFrameLayout.setTag(e.e.finder_accessibility_profile_follow_tag, localTextView.getText());
    AppMethodBeat.o(349341);
  }
  
  private final void eJN()
  {
    AppMethodBeat.i(349348);
    FrameLayout localFrameLayout = (FrameLayout)this.Fag.findViewById(e.e.finder_profile_follow_btn);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    if (((n)com.tencent.mm.ui.component.k.d(getActivity()).q(n.class)).eKv())
    {
      localFrameLayout.setBackgroundResource(e.d.finder_profile_covered_followed_btn_bg);
      eJy().setBackgroundResource(e.d.finder_profile_covered_followed_btn_bg);
      eJi().setIconColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_0_Alpha_0_9));
    }
    for (;;)
    {
      eJO();
      localObject = getProfileContact();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(349348);
      return;
      localFrameLayout.setBackgroundResource(e.d.finder_profile_followed_btn_bg);
      eJy().setBackgroundResource(e.d.finder_profile_followed_btn_bg);
      eJi().setIconColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_0_5));
    }
    localObject = (kotlin.g.a.b)new as(this, (com.tencent.mm.plugin.finder.api.m)localObject);
    localFrameLayout.setOnClickListener(new h..ExternalSyntheticLambda12((kotlin.g.a.b)localObject));
    eJy().setOnClickListener(new h..ExternalSyntheticLambda13((kotlin.g.a.b)localObject));
    localFrameLayout.setTag(e.e.finder_accessibility_profile_follow_tag, getContext().getString(e.h.finder_profile_cancel_follow_desc));
    AppMethodBeat.o(349348);
  }
  
  private final void eJO()
  {
    AppMethodBeat.i(349369);
    TextView localTextView = (TextView)this.Fag.findViewById(e.e.finder_profile_follow_btn_tv);
    eJi().setVisibility(0);
    localTextView.setVisibility(8);
    eJz().setVisibility(0);
    eJA().setVisibility(8);
    AppMethodBeat.o(349369);
  }
  
  private final void eJP()
  {
    AppMethodBeat.i(349375);
    TextView localTextView = (TextView)this.Fag.findViewById(e.e.finder_profile_follow_btn_tv);
    eJi().setVisibility(8);
    localTextView.setVisibility(0);
    eJz().setVisibility(8);
    eJA().setVisibility(0);
    AppMethodBeat.o(349375);
  }
  
  private final void eJQ()
  {
    AppMethodBeat.i(349400);
    Object localObject2 = getProfileContact();
    if (localObject2 == null)
    {
      AppMethodBeat.o(349400);
      return;
    }
    Object localObject1 = getContext().findViewById(e.e.finder_profile_desc_layout);
    if ((!aBu()) && (localObject1 != null)) {
      ((View)localObject1).setVisibility(0);
    }
    Object localObject3 = (CharSequence)((com.tencent.mm.plugin.finder.api.m)localObject2).field_signature;
    if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {
      i = 1;
    }
    while (i != 0) {
      if (isSelf())
      {
        localObject2 = getContext().getString(e.h.finder_desc_guide);
        kotlin.g.b.s.s(localObject2, "context.getString(R.string.finder_desc_guide)");
        eJq().setText((CharSequence)localObject2);
        i = eJq().aCB((String)localObject2);
        eJr().setVisibility(0);
        localObject2 = eJr().getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(349400);
          throw ((Throwable)localObject1);
          i = 0;
        }
        else
        {
          localObject2 = (FrameLayout.LayoutParams)localObject2;
          ((FrameLayout.LayoutParams)localObject2).setMarginStart(i + (int)getActivity().getResources().getDimension(e.c.Edge_0_5_A));
          eJr().setLayoutParams((ViewGroup.LayoutParams)localObject2);
          i = (int)getActivity().getResources().getDimension(e.c.Edge_0_5_A);
          localObject2 = ((View)localObject1).getLayoutParams();
          if (localObject2 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(349400);
            throw ((Throwable)localObject1);
          }
          localObject2 = (LinearLayout.LayoutParams)localObject2;
          ((LinearLayout.LayoutParams)localObject2).topMargin = 0;
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((View)localObject1).setPadding(0, i, 0, i);
          ((View)localObject1).setOnClickListener(new h..ExternalSyntheticLambda2(this));
          AppMethodBeat.o(349400);
        }
      }
      else
      {
        eJq().setVisibility(8);
        AppMethodBeat.o(349400);
        return;
      }
    }
    eJr().setVisibility(8);
    if (aBu()) {}
    for (int i = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_0);; i = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.Link_100))
    {
      localObject3 = ((View)localObject1).getLayoutParams();
      if (localObject3 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(349400);
      throw ((Throwable)localObject1);
    }
    localObject3 = (LinearLayout.LayoutParams)localObject3;
    int j = (int)getActivity().getResources().getDimension(e.c.Edge_0_5_A);
    ((LinearLayout.LayoutParams)localObject3).topMargin = j;
    ((LinearLayout.LayoutParams)localObject3).bottomMargin = j;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject3 = a((com.tencent.mm.plugin.finder.api.m)localObject2, i, false).toString();
    kotlin.g.b.s.s(localObject3, "reportNickname.toString()");
    hY((String)localObject3, ((com.tencent.mm.plugin.finder.api.m)localObject2).getUsername());
    eJq().setVisibility(0);
    ((View)localObject1).setBackgroundResource(0);
    ((View)localObject1).setPadding(0, 0, 0, 0);
    eJq().setOnExpandBtnClickListener((kotlin.g.a.a)new ac(this));
    eJq().setOnExpandStateChangeListener((kotlin.g.a.m)new ad(this));
    eJq().setOnClickListener(new h..ExternalSyntheticLambda3(this));
    eJq().setOnLongClickListener(new h..ExternalSyntheticLambda16(this));
    AppMethodBeat.o(349400);
  }
  
  private final void eJR()
  {
    AppMethodBeat.i(349443);
    Object localObject1 = getProfileContact();
    if (localObject1 == null)
    {
      AppMethodBeat.o(349443);
      return;
    }
    Object localObject2 = eJw().getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
      AppMethodBeat.o(349443);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ConstraintLayout.LayoutParams)localObject2;
    if (eJk().getVisibility() == 4)
    {
      ((ConstraintLayout.LayoutParams)localObject2).blm = -1;
      ((ConstraintLayout.LayoutParams)localObject2).blk = e.e.finder_profile_avatar_container;
    }
    for (((ConstraintLayout.LayoutParams)localObject2).bln = e.e.finder_profile_avatar_container;; ((ConstraintLayout.LayoutParams)localObject2).bln = -1)
    {
      eJw().setLayoutParams((ViewGroup.LayoutParams)localObject2);
      com.tencent.mm.ui.aw.a((Paint)getNicknameTv().getPaint(), 0.8F);
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.plugin.finder.api.m)localObject1).dUs());
      ImageView localImageView = getAvatarIv();
      kotlin.g.b.s.s(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject2).a(localb, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      getAvatarIv().setOnClickListener(new h..ExternalSyntheticLambda0((com.tencent.mm.plugin.finder.api.m)localObject1, this));
      AppMethodBeat.o(349443);
      return;
      ((ConstraintLayout.LayoutParams)localObject2).blm = e.e.finder_profile_avatar_guideline;
      ((ConstraintLayout.LayoutParams)localObject2).blk = -1;
    }
  }
  
  private final boolean eJS()
  {
    AppMethodBeat.i(349452);
    if ((!isSelf()) || (!isSelfFlag()))
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.eWc().bmg()).booleanValue()) {}
    }
    else
    {
      AppMethodBeat.o(349452);
      return true;
    }
    AppMethodBeat.o(349452);
    return false;
  }
  
  private final void eJT()
  {
    int j = 0;
    AppMethodBeat.i(349461);
    c localc = (c)userExtInfoCache.get(this.username);
    Object localObject = localc;
    if (localc == null) {
      localObject = new c();
    }
    int i;
    if ((((c)localObject).fansCount > 0) && (eJS())) {
      if ((isSelf()) && (isSelfFlag()))
      {
        i = 1;
        eJn().setVisibility(0);
        if (i == 0) {
          break label199;
        }
        eJp().setText((CharSequence)getContext().getResources().getString(e.h.finder_fans, new Object[] { com.tencent.mm.plugin.finder.utils.r.TQ(((c)localObject).fansCount) }));
        eJn().setOnClickListener(new h..ExternalSyntheticLambda1(this));
        localObject = (WeImageView)this.Fag.findViewById(e.e.finder_profile_fans_arrow);
        i = j;
        if (eJl().getVisibility() == 0) {
          i = 8;
        }
        ((WeImageView)localObject).setVisibility(i);
      }
    }
    for (;;)
    {
      this.Fag.findViewById(e.e.line).setVisibility(eJl().getVisibility());
      AppMethodBeat.o(349461);
      return;
      i = 0;
      break;
      label199:
      eJp().setText((CharSequence)getContext().getResources().getString(e.h.finder_fans_count, new Object[] { com.tencent.mm.plugin.finder.utils.r.TQ(((c)localObject).fansCount) }));
      continue;
      eJn().setVisibility(8);
    }
  }
  
  private final void eJU()
  {
    AppMethodBeat.i(349467);
    c localc2 = (c)userExtInfoCache.get(this.username);
    c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new c();
    }
    eJj().setVisibility(8);
    if (localc1.userTags.isEmpty())
    {
      eJk().setVisibility(4);
      AppMethodBeat.o(349467);
      return;
    }
    eJk().setVisibility(0);
    AppMethodBeat.o(349467);
  }
  
  private final String eJV()
  {
    AppMethodBeat.i(349478);
    Object localObject2 = (c)userExtInfoCache.get(this.username);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new c();
    }
    localObject2 = ((c)localObject1).userTags;
    if (!((LinkedList)localObject2).isEmpty())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(" ");
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.p.b((Context)getContext(), (CharSequence)((StringBuilder)localObject1).toString());
      if (localObject1 != null)
      {
        localObject1 = ((SpannableString)localObject1).toString();
        kotlin.g.b.s.s(localObject1, "this.toString()");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(349478);
      return localObject1;
      localObject1 = "";
    }
  }
  
  private final void eJW()
  {
    AppMethodBeat.i(349488);
    if (this.Faw == null)
    {
      localObject1 = getContext();
      Object localObject2 = this.Fag;
      kotlin.g.b.s.s(localObject2, "header");
      this.Faw = new com.tencent.mm.plugin.finder.profile.c((Activity)localObject1, (View)localObject2);
      localObject1 = this.Faw;
      if (localObject1 != null)
      {
        localObject2 = this.username;
        kotlin.g.b.s.u(localObject2, "userName");
        ((com.tencent.mm.plugin.finder.profile.c)localObject1).userName = ((String)localObject2);
      }
    }
    Object localObject1 = this.Faw;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.profile.c)localObject1).a(null);
    }
    AppMethodBeat.o(349488);
  }
  
  private final FrameLayout eJg()
  {
    AppMethodBeat.i(348954);
    FrameLayout localFrameLayout = (FrameLayout)this.FdN.getValue();
    AppMethodBeat.o(348954);
    return localFrameLayout;
  }
  
  private final FrameLayout eJh()
  {
    AppMethodBeat.i(348961);
    FrameLayout localFrameLayout = (FrameLayout)this.FdO.getValue();
    AppMethodBeat.o(348961);
    return localFrameLayout;
  }
  
  private final WeImageView eJi()
  {
    AppMethodBeat.i(348968);
    WeImageView localWeImageView = (WeImageView)this.FdP.getValue();
    AppMethodBeat.o(348968);
    return localWeImageView;
  }
  
  private final TextView eJj()
  {
    AppMethodBeat.i(348992);
    TextView localTextView = (TextView)this.FdR.getValue();
    AppMethodBeat.o(348992);
    return localTextView;
  }
  
  private final TextView eJk()
  {
    AppMethodBeat.i(348999);
    TextView localTextView = (TextView)this.FdS.getValue();
    AppMethodBeat.o(348999);
    return localTextView;
  }
  
  private final LinearLayout eJl()
  {
    AppMethodBeat.i(349008);
    LinearLayout localLinearLayout = (LinearLayout)this.FdT.getValue();
    AppMethodBeat.o(349008);
    return localLinearLayout;
  }
  
  private final TextView eJm()
  {
    AppMethodBeat.i(349013);
    TextView localTextView = (TextView)this.FdU.getValue();
    AppMethodBeat.o(349013);
    return localTextView;
  }
  
  private final LinearLayout eJn()
  {
    AppMethodBeat.i(349022);
    LinearLayout localLinearLayout = (LinearLayout)this.FdV.getValue();
    AppMethodBeat.o(349022);
    return localLinearLayout;
  }
  
  private final LinearLayout eJo()
  {
    AppMethodBeat.i(349027);
    LinearLayout localLinearLayout = (LinearLayout)this.FdW.getValue();
    AppMethodBeat.o(349027);
    return localLinearLayout;
  }
  
  private final TextView eJp()
  {
    AppMethodBeat.i(349039);
    TextView localTextView = (TextView)this.FdX.getValue();
    AppMethodBeat.o(349039);
    return localTextView;
  }
  
  private final CollapsibleTextView eJq()
  {
    AppMethodBeat.i(349049);
    CollapsibleTextView localCollapsibleTextView = (CollapsibleTextView)this.FdY.getValue();
    AppMethodBeat.o(349049);
    return localCollapsibleTextView;
  }
  
  private final WeImageView eJr()
  {
    AppMethodBeat.i(349055);
    WeImageView localWeImageView = (WeImageView)this.FdZ.getValue();
    AppMethodBeat.o(349055);
    return localWeImageView;
  }
  
  private final LinearLayout eJs()
  {
    AppMethodBeat.i(349064);
    LinearLayout localLinearLayout = (LinearLayout)this.Fea.getValue();
    AppMethodBeat.o(349064);
    return localLinearLayout;
  }
  
  private final LinearLayout eJt()
  {
    AppMethodBeat.i(349071);
    LinearLayout localLinearLayout = (LinearLayout)this.Feb.getValue();
    AppMethodBeat.o(349071);
    return localLinearLayout;
  }
  
  private final TextView eJu()
  {
    AppMethodBeat.i(349075);
    TextView localTextView = (TextView)this.Fec.getValue();
    AppMethodBeat.o(349075);
    return localTextView;
  }
  
  private final TextView eJv()
  {
    AppMethodBeat.i(349083);
    TextView localTextView = (TextView)this.Fed.getValue();
    AppMethodBeat.o(349083);
    return localTextView;
  }
  
  private final LinearLayout eJw()
  {
    AppMethodBeat.i(349089);
    LinearLayout localLinearLayout = (LinearLayout)this.Fee.getValue();
    AppMethodBeat.o(349089);
    return localLinearLayout;
  }
  
  private final RoundCornerRelativeLayout eJx()
  {
    AppMethodBeat.i(349097);
    RoundCornerRelativeLayout localRoundCornerRelativeLayout = (RoundCornerRelativeLayout)this.Fef.getValue();
    AppMethodBeat.o(349097);
    return localRoundCornerRelativeLayout;
  }
  
  private final FrameLayout eJy()
  {
    AppMethodBeat.i(349103);
    FrameLayout localFrameLayout = (FrameLayout)this.Feg.getValue();
    AppMethodBeat.o(349103);
    return localFrameLayout;
  }
  
  private final WeImageView eJz()
  {
    AppMethodBeat.i(349108);
    WeImageView localWeImageView = (WeImageView)this.Fcw.getValue();
    AppMethodBeat.o(349108);
    return localWeImageView;
  }
  
  private static final void f(h paramh, View paramView)
  {
    AppMethodBeat.i(349698);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcQ, 0);
    if (i > 0)
    {
      paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.a("3", 1, 2, 5, 3, i, null, null, 0L, paramh.getContextObj(), 0, 0, 3520);
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adcQ, Integer.valueOf(0));
    paramView = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("AuthorProfileFans");
    localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("AuthorProfileFans");
    if ((localObject != null) && (paramView != null))
    {
      com.tencent.mm.plugin.finder.report.w.a(com.tencent.mm.plugin.finder.report.w.FrV, "3", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject, paramView, 2, paramh.getContextObj(), 0, null, 0, 480);
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("AuthorProfileFans");
    }
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.hf((Context)paramh.getActivity());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349698);
  }
  
  private final ImageView getAvatarIv()
  {
    AppMethodBeat.i(348982);
    ImageView localImageView = (ImageView)this.FdQ.getValue();
    AppMethodBeat.o(348982);
    return localImageView;
  }
  
  private final bui getContextObj()
  {
    AppMethodBeat.i(349166);
    bui localbui = (bui)this.Bld.getValue();
    AppMethodBeat.o(349166);
    return localbui;
  }
  
  private final TextView getNicknameTv()
  {
    AppMethodBeat.i(348975);
    TextView localTextView = (TextView)this.DkO.getValue();
    AppMethodBeat.o(348975);
    return localTextView;
  }
  
  private final com.tencent.mm.plugin.finder.api.m getProfileContact()
  {
    AppMethodBeat.i(349159);
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject = com.tencent.mm.plugin.finder.api.d.a.auT(this.username);
    AppMethodBeat.o(349159);
    return localObject;
  }
  
  private final void h(com.tencent.mm.plugin.finder.api.m paramm)
  {
    int j = 1;
    AppMethodBeat.i(349361);
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((FinderProfileTabUIC)com.tencent.mm.ui.component.k.d(getActivity()).q(FinderProfileTabUIC.class)).be(FinderProfileFeedFragment.class);
    Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((FinderProfileFeedUIC)com.tencent.mm.ui.component.k.y((Fragment)localObject1).q(FinderProfileFeedUIC.class)).getState();
    localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
    localObject2 = this.username;
    int k = com.tencent.mm.model.cn.getSyncServerTimeSecond();
    com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    int i;
    if (com.tencent.mm.plugin.finder.utils.aw.n(paramm))
    {
      i = 1;
      if (localObject1 != FinderProfileFeedLoader.State.PRIVATE_LOCK) {
        break label227;
      }
      label102:
      com.tencent.mm.plugin.finder.report.z.c((String)localObject2, 3, k, i, j);
      long l = getIntent().getLongExtra("finder_read_feed_id", 0L);
      paramm = com.tencent.mm.plugin.finder.model.ak.ECS;
      paramm = getContextObj();
      localObject1 = this.username;
      localObject2 = com.tencent.mm.plugin.finder.cgi.p.AyV;
      com.tencent.mm.plugin.finder.model.ak.a(paramm, (String)localObject1, com.tencent.mm.plugin.finder.cgi.p.dVe(), l, false, null, 112);
      eJR();
      azt("setFollowed");
      localObject1 = this.Few;
      localObject2 = this.Fag.getContext();
      paramm = getProfileContact();
      if (paramm != null) {
        break label232;
      }
    }
    label227:
    label232:
    for (paramm = null;; paramm = paramm.dUr())
    {
      ((com.tencent.mm.plugin.finder.profile.adapter.a)localObject1).a(com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)paramm), eJV());
      AppMethodBeat.o(349361);
      return;
      i = 0;
      break;
      j = 0;
      break label102;
    }
  }
  
  private final void hY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(349435);
    if (kotlin.g.b.s.p(paramString1, this.FeA))
    {
      AppMethodBeat.o(349435);
      return;
    }
    this.FeA = paramString1;
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    StringBuilder localStringBuilder = new StringBuilder("0,1,").append(paramString1).append(",0,");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localh.kvStat(21172, paramString1);
    AppMethodBeat.o(349435);
  }
  
  private final boolean isSelf()
  {
    AppMethodBeat.i(349152);
    boolean bool = kotlin.g.b.s.p(this.username, com.tencent.mm.model.z.bAW());
    AppMethodBeat.o(349152);
    return bool;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(349144);
    boolean bool = ((Boolean)this.AIq.getValue()).booleanValue();
    AppMethodBeat.o(349144);
    return bool;
  }
  
  private static final void k(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(349604);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$tmp0");
    paramb.invoke(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349604);
  }
  
  private static final void l(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(349613);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$tmp0");
    paramb.invoke(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349613);
  }
  
  private static final void m(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(349619);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$tmp0");
    paramb.invoke(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349619);
  }
  
  private static final void n(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(349637);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$tmp0");
    paramb.invoke(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349637);
  }
  
  private static final void o(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(349641);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$tmp0");
    paramb.invoke(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349641);
  }
  
  private final void ti(boolean paramBoolean)
  {
    AppMethodBeat.i(349242);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.aZW();
    dt localdt = new dt(this.username, 0L, null, 0, getContextObj(), 0, 0L, false, null, 0L, null, null, null, 8174);
    localdt.ADC = paramBoolean;
    ah localah = ah.aiuX;
    locals.a((com.tencent.mm.am.p)localdt, 0);
    AppMethodBeat.o(349242);
  }
  
  public final void S(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(350057);
    Object localObject = getProfileContact();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.api.m)localObject).field_signature;
      if (localObject != null) {
        if (((CharSequence)localObject).length() == 0)
        {
          i = 1;
          if (i != 0) {
            break label86;
          }
        }
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = getProfileContact();
        kotlin.g.b.s.checkNotNull(localObject);
        a((com.tencent.mm.plugin.finder.api.m)localObject, paramInt, paramBoolean);
      }
      AppMethodBeat.o(350057);
      return;
      i = 0;
      break;
    }
  }
  
  public final boolean eJE()
  {
    AppMethodBeat.i(350045);
    if (eJC().getVisibility() == 0)
    {
      AppMethodBeat.o(350045);
      return true;
    }
    AppMethodBeat.o(350045);
    return false;
  }
  
  public final boolean eJG()
  {
    AppMethodBeat.i(350053);
    if ((!isSelf()) && (!isSelfFlag()))
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.eTo().bmg()).intValue() > 0) && (this.FcD) && (!aBu()))
      {
        AppMethodBeat.o(350053);
        return true;
      }
    }
    AppMethodBeat.o(350053);
    return false;
  }
  
  public final void eJX()
  {
    boolean bool2 = false;
    AppMethodBeat.i(350109);
    Object localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    boolean bool3 = com.tencent.mm.plugin.finder.utils.aw.o(com.tencent.mm.plugin.finder.api.d.a.auT(this.username));
    localObject = com.tencent.mm.plugin.finder.upload.action.f.GcR;
    localObject = this.username;
    if (!bool3) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.plugin.finder.upload.action.f.e(2, (String)localObject, bool1);
      if (bool3) {
        break;
      }
      localObject = com.tencent.mm.plugin.finder.api.d.AwY;
      if (!com.tencent.mm.plugin.finder.api.d.a.a(this.username, null, true, false, 10)) {
        break;
      }
      localObject = new com.tencent.mm.ui.widget.a.f((Context)getContext(), 1, true);
      ((com.tencent.mm.ui.widget.a.f)localObject).h((CharSequence)getContext().getResources().getString(e.h.finder_mod_block_bottom_sheet_title), 17, 0);
      ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new h..ExternalSyntheticLambda20(this);
      ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new h..ExternalSyntheticLambda24(this, bool3);
      ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
      AppMethodBeat.o(350109);
      return;
    }
    bool1 = bool2;
    if (!bool3) {
      bool1 = true;
    }
    am(bool1, true);
    AppMethodBeat.o(350109);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    int j = 1;
    int i = 1;
    AppMethodBeat.i(350104);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      AppMethodBeat.o(350104);
      return;
    }
    Object localObject2;
    label393:
    label533:
    label538:
    label543:
    Object localObject3;
    Object localObject4;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(350104);
      return;
    case 10007: 
      Log.d("Finder.FinderProfileHeaderUIC", "onActivityResult MENU_ID_SET_HEADIMG_TAKEPHOTO");
      localObject1 = getActivity().getApplicationContext();
      localObject2 = bm.GlZ;
      localObject1 = t.g((Context)localObject1, paramIntent, bm.fil());
      if (localObject1 == null)
      {
        Log.e("Finder.FinderProfileHeaderUIC", "filePath is null.");
        AppMethodBeat.o(350104);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 1);
      paramIntent.putExtra("CropImage_ImgPath", (String)localObject1);
      localObject1 = kotlin.g.b.s.X((String)localObject1, Long.valueOf(System.currentTimeMillis()));
      localObject2 = kotlin.n.d.UTF_8;
      if (localObject1 == null)
      {
        paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(350104);
        throw paramIntent;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      kotlin.g.b.s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
      localObject2 = bm.GlZ;
      localObject2 = bm.fil();
      kotlin.g.b.s.checkNotNull(localObject1);
      paramIntent.putExtra("CropImage_OutputPath", kotlin.g.b.s.X((String)localObject2, localObject1));
      paramIntent.setClassName((Context)getActivity(), "com.tencent.mm.ui.tools.CropImageNewUI");
      com.tencent.mm.hellhoundlib.a.a.a(getContext(), com.tencent.mm.hellhoundlib.b.c.a(10008, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC", "onActivityResult", "(IILandroid/content/Intent;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(350104);
      return;
    case 10006: 
      Log.d("Finder.FinderProfileHeaderUIC", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
      localObject1 = paramIntent.getData();
      if (localObject1 == null)
      {
        localObject1 = "";
        if (((CharSequence)localObject1).length() != 0) {
          break label533;
        }
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          Log.w("Finder.FinderProfileHeaderUIC", "filePath is null.try to getResultPhotoPath.");
          localObject1 = getActivity().getApplicationContext();
          localObject2 = bm.GlZ;
          localObject1 = t.g((Context)localObject1, paramIntent, bm.fil());
          kotlin.g.b.s.s(localObject1, "getResultPhotoPath(activ…PathRouter.finderTmpPath)");
        }
        Log.i("Finder.FinderProfileHeaderUIC", "filePath[" + (String)localObject1 + "] " + paramIntent);
        if (((CharSequence)localObject1).length() != 0) {
          break label538;
        }
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label543;
        }
        Log.e("Finder.FinderProfileHeaderUIC", "filePath is null.");
        AppMethodBeat.o(350104);
        return;
        localObject2 = ((Uri)localObject1).getPath();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "";
        break;
        paramInt1 = 0;
        break label393;
      }
      localObject2 = (Activity)getActivity();
      localObject3 = kotlin.g.b.s.X((String)localObject1, Long.valueOf(System.currentTimeMillis()));
      localObject4 = kotlin.n.d.UTF_8;
      if (localObject3 == null)
      {
        paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(350104);
        throw paramIntent;
      }
      localObject3 = ((String)localObject3).getBytes((Charset)localObject4);
      kotlin.g.b.s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
      localObject3 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject3);
      kotlin.g.b.s.s(localObject3, "getMessageDigest((filePa…eMillis()).toByteArray())");
      ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi().a((Activity)localObject2, paramIntent, (String)localObject1, (String)localObject3);
      AppMethodBeat.o(350104);
      return;
    case 10008: 
      Log.d("Finder.FinderProfileHeaderUIC", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
      paramIntent = paramIntent.getStringExtra("key_result_img_path");
      if ((paramIntent == null) || (!y.ZC(paramIntent)))
      {
        Log.e("Finder.FinderProfileHeaderUIC", kotlin.g.b.s.X("ERROR! filePath=", paramIntent));
        AppMethodBeat.o(350104);
        return;
      }
      Log.d("Finder.FinderProfileHeaderUIC", kotlin.g.b.s.X("REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM ", paramIntent));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adab, paramIntent);
      ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().g(paramIntent, this.username, new an(this));
      AppMethodBeat.o(350104);
      return;
    case 10009: 
      localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject4 = com.tencent.mm.plugin.finder.api.d.a.auT(com.tencent.mm.model.z.bAW());
      localObject2 = paramIntent.getStringExtra("Country");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = paramIntent.getStringExtra("Contact_Province");
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
      if (kotlin.g.b.s.p(localObject1, "unshow"))
      {
        paramInt1 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adbs, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
        localObject1 = "";
      }
      break;
    }
    for (paramInt1 = j;; paramInt1 = 0)
    {
      if (localObject4 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.api.m)localObject4).field_extInfo;
        if (localObject3 != null) {
          break label1054;
        }
      }
      for (localObject3 = null;; localObject3 = ah.aiuX)
      {
        if (localObject3 == null)
        {
          ((com.tencent.mm.plugin.finder.api.m)localObject4).field_extInfo = new avl();
          ((com.tencent.mm.plugin.finder.api.m)localObject4).field_extInfo.country = ((String)localObject1);
          ((com.tencent.mm.plugin.finder.api.m)localObject4).field_extInfo.province = ((String)localObject2);
          ((com.tencent.mm.plugin.finder.api.m)localObject4).field_extInfo.city = paramIntent;
        }
        localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
        com.tencent.mm.plugin.finder.api.d.a.d((com.tencent.mm.plugin.finder.api.m)localObject4);
        ((com.tencent.mm.plugin.finder.service.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.r.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, null);
        AppMethodBeat.o(350104);
        return;
        label1054:
        ((avl)localObject3).country = ((String)localObject1);
        ((avl)localObject3).province = ((String)localObject2);
        ((avl)localObject3).city = paramIntent;
      }
      localObject2 = (c)userExtInfoCache.get(this.username);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new c();
      }
      localObject2 = paramIntent.getByteArrayExtra("KEY_FINDER_LIVE_NOTICE_INFO");
      if (localObject2 != null)
      {
        paramIntent = new bkk();
        paramIntent.parseFrom((byte[])localObject2);
        localObject2 = ((c)localObject1).FeE;
        if (localObject2 != null) {
          break label1201;
        }
      }
      label1201:
      for (paramInt1 = 2147483647;; paramInt1 = ((bkk)localObject2).startTime)
      {
        if (paramInt1 > paramIntent.startTime) {
          ((c)localObject1).FeE = paramIntent;
        }
        userExtInfoCache.put(this.username, localObject1);
        azq("onSceneEnd:[NetSceneCreateLiveNotice]");
        AppMethodBeat.o(350104);
        return;
      }
      if (paramInt2 != 1000) {
        break;
      }
      paramIntent = paramIntent.getStringExtra("ACTIVITY_RESULT_REMOVE_NOTICE_KEY");
      if (paramIntent == null) {
        break;
      }
      if (((CharSequence)paramIntent).length() > 0)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1291;
        }
        label1247:
        if (paramIntent == null) {
          break;
        }
        localObject2 = this.Fep;
        if (localObject2 != null) {
          break label1296;
        }
        kotlin.g.b.s.bIx("moreLiveListWidget");
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.finder.profile.widget.g)localObject1).azy(paramIntent);
        ti(false);
        AppMethodBeat.o(350104);
        return;
        paramInt1 = 0;
        break;
        label1291:
        paramIntent = null;
        break label1247;
        label1296:
        localObject1 = localObject2;
      }
      if (!paramIntent.getBooleanExtra("NEED_REFRESH_CONTACT", false)) {
        break;
      }
      ti(true);
      break;
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(350041);
    Object localObject = this.Faw;
    if (localObject != null)
    {
      FinderProfilePoiDrawer localFinderProfilePoiDrawer = ((com.tencent.mm.plugin.finder.profile.c)localObject).Fal;
      if ((localFinderProfilePoiDrawer != null) && (localFinderProfilePoiDrawer.fkp() == true))
      {
        i = 1;
        if (i == 0) {
          break label83;
        }
        localObject = ((com.tencent.mm.plugin.finder.profile.c)localObject).Fal;
        if (localObject != null) {
          RecyclerViewDrawer.b((RecyclerViewDrawer)localObject);
        }
        i = 1;
        label59:
        if (i != 1) {
          break label88;
        }
      }
    }
    label83:
    label88:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label93;
      }
      AppMethodBeat.o(350041);
      return true;
      i = 0;
      break;
      i = 0;
      break label59;
    }
    label93:
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(350041);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(350023);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3736, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(6653, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(372, (com.tencent.mm.am.h)this);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().a(106, (com.tencent.mm.plugin.finder.api.k)this.FeB);
    paramBundle = getActivity().getIntent().getStringExtra("finder_username");
    kotlin.g.b.s.checkNotNull(paramBundle);
    kotlin.g.b.s.s(paramBundle, "activity.intent.getStrin…UI.KEY_FINDER_USERNAME)!!");
    this.username = paramBundle;
    paramBundle = getIntent().getByteArrayExtra("KEY_FINDER_LIVE_NOTICE_INFO");
    Object localObject4;
    Object localObject1;
    Object localObject3;
    label566:
    int i;
    if (paramBundle != null)
    {
      localObject4 = (c)userExtInfoCache.get(this.username);
      if (localObject4 == null)
      {
        localObject1 = new c();
        ((c)localObject1).FeE = new bkk();
        localObject3 = ((c)localObject1).FeE;
        if (localObject3 != null) {
          ((bkk)localObject3).parseFrom(paramBundle);
        }
        userExtInfoCache.put(this.username, localObject1);
      }
    }
    else
    {
      if ((getIntent().hasExtra("key_extra_info")) && (!getIntent().hasExtra("key_enter_source_info")))
      {
        paramBundle = as.GSQ;
        paramBundle = as.a.hu((Context)getContext());
        if (paramBundle != null) {
          paramBundle.K(0L, this.username);
        }
      }
      this.Fer = getIntent().getBooleanExtra("KEY_FINDER_PROFILE_UI_AFTER_SHOW_NOTICE_LIST", false);
      localObject1 = getIntent().getStringExtra("KEY_FINDER_PROFILE_UI_REQUEST_LIST_POSITION");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.Fes = paramBundle;
      paramBundle = this.Fag;
      kotlin.g.b.s.s(paramBundle, "header");
      this.Fek = new com.tencent.mm.plugin.finder.profile.widget.b(paramBundle, getActivity(), getContextObj());
      paramBundle = this.Fag;
      kotlin.g.b.s.s(paramBundle, "header");
      this.Fel = new com.tencent.mm.plugin.finder.profile.widget.d(paramBundle, getActivity());
      paramBundle = this.Fag;
      kotlin.g.b.s.s(paramBundle, "header");
      this.Fem = new com.tencent.mm.plugin.finder.profile.widget.e(paramBundle, getActivity());
      paramBundle = this.Fag;
      kotlin.g.b.s.s(paramBundle, "header");
      this.Fen = new com.tencent.mm.plugin.finder.profile.widget.a(paramBundle, getActivity());
      this.Fep = new com.tencent.mm.plugin.finder.profile.widget.g(this.username, (Context)getActivity(), isSelf());
      paramBundle = this.Fag;
      kotlin.g.b.s.s(paramBundle, "header");
      paramBundle = new com.tencent.mm.plugin.finder.profile.widget.c(paramBundle, getActivity());
      paramBundle.FgV = ((kotlin.g.a.a)new ag(this));
      localObject1 = ah.aiuX;
      this.Feo = paramBundle;
      paramBundle = this.Fag;
      kotlin.g.b.s.s(paramBundle, "header");
      this.Feq = new com.tencent.mm.plugin.finder.profile.widget.f(paramBundle, getActivity(), getContextObj());
      label652:
      label668:
      label672:
      if (!getIntent().getBooleanExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", false))
      {
        localObject1 = this.Fel;
        if (localObject1 != null) {
          break label1346;
        }
        kotlin.g.b.s.bIx("mediaEntrance");
        localObject1 = null;
        localObject4 = getProfileContact();
        localObject3 = ((com.tencent.mm.plugin.finder.profile.widget.d)localObject1).activity.getIntent().getStringExtra("key_biz_username");
        paramBundle = (CharSequence)localObject3;
        if ((paramBundle != null) && (paramBundle.length() != 0)) {
          break label1349;
        }
        i = 1;
        label609:
        if (i == 0)
        {
          paramBundle = (Bundle)localObject3;
          if (!kotlin.g.b.s.p("null", localObject3)) {}
        }
        else
        {
          if (localObject4 != null) {
            break label1354;
          }
          paramBundle = null;
        }
        label634:
        if (paramBundle != null)
        {
          if (((CharSequence)paramBundle).length() <= 0) {
            break label1377;
          }
          i = 1;
          if ((i == 0) || (kotlin.g.b.s.p("null", paramBundle))) {
            break label1382;
          }
          i = 1;
          if (i == 0) {
            break label1387;
          }
          if (paramBundle != null)
          {
            localObject3 = new Intent();
            localObject4 = as.GSQ;
            as.a.a((Context)((com.tencent.mm.plugin.finder.profile.widget.d)localObject1).activity, (Intent)localObject3, 0L, 0, false, 124);
            ((Intent)localObject3).putExtra("Contact_User", paramBundle);
            ((Intent)localObject3).putExtra("Contact_Scene", 213);
            ((Intent)localObject3).putExtra("force_get_contact", true);
            ((Intent)localObject3).putExtra("key_use_new_contact_profile", true);
            ((Intent)localObject3).putExtra("biz_profile_tab_type", 1);
            com.tencent.mm.br.c.b((Context)((com.tencent.mm.plugin.finder.profile.widget.d)localObject1).activity, "profile", ".ui.ContactInfoUI", (Intent)localObject3);
            com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new com.tencent.mm.plugin.finder.profile.widget.d.a((com.tencent.mm.plugin.finder.profile.widget.d)localObject1));
          }
        }
      }
      eJg().addView(this.Fag);
      paramBundle = eJh().getLayoutParams();
      i = bf.getStatusBarHeight((Context)getActivity());
      float f = getActivity().getResources().getDimension(e.c.DefaultActionbarHeightPort);
      paramBundle.height = kotlin.h.a.eH(i + f);
      eJh().setLayoutParams(paramBundle);
      eJg().setMinimumHeight(kotlin.h.a.eH(i + f));
      azq("onCreate");
      this.ErY = ((IListener)new FinderProfileHeaderUIC.onCreate.1(this, com.tencent.mm.app.f.hfK));
      paramBundle = this.ErY;
      if (paramBundle != null) {
        paramBundle.alive();
      }
      paramBundle = this.Feo;
      if (paramBundle != null) {
        break label1392;
      }
      kotlin.g.b.s.bIx("liveWidget");
      paramBundle = null;
      label927:
      localObject1 = this.username;
      kotlin.g.b.s.u(localObject1, "username");
      localObject1 = (c)userExtInfoCache.get(localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((c)localObject1).FeE;
        if (localObject1 != null) {
          paramBundle.Fhe = ((bkk)localObject1).status;
        }
      }
      com.tencent.mm.ui.aw.a((Paint)paramBundle.eKH().getPaint(), 0.8F);
      if (!com.tencent.mm.ui.aw.isDarkMode()) {
        break label1395;
      }
      paramBundle.eKD().setBackgroundResource(e.d.finder_live_notice_bg_shape_dark);
      label1012:
      localObject1 = this.Fen;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("activityWidget");
        paramBundle = null;
      }
      kotlin.g.b.s.u(this.username, "username");
      if (!com.tencent.mm.ui.aw.isDarkMode()) {
        break label1408;
      }
      paramBundle.eKz().setBackgroundResource(e.d.finder_live_notice_bg_shape_dark);
      label1060:
      ((FrameLayout)this.Fag.findViewById(e.e.profile_loading_state_container)).setVisibility(8);
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.findersdk.a.av)com.tencent.mm.ui.component.k.d(getActivity()).cq(com.tencent.mm.plugin.findersdk.a.av.class)).bo((kotlin.g.a.a)new ao(this));
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.findersdk.a.av)com.tencent.mm.ui.component.k.d(getActivity()).cq(com.tencent.mm.plugin.findersdk.a.av.class)).e((kotlin.g.a.r)new ap(this));
      localObject1 = this.Fen;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("activityWidget");
        paramBundle = null;
      }
      paramBundle.azx(this.username);
      paramBundle = this.Feq;
      if (paramBundle != null) {
        break label1421;
      }
      kotlin.g.b.s.bIx("redPackWidget");
      paramBundle = localObject2;
    }
    label1408:
    label1421:
    for (;;)
    {
      paramBundle.an(isSelf(), isSelfFlag());
      AppMethodBeat.o(350023);
      return;
      localObject1 = new bkk();
      ((bkk)localObject1).parseFrom(paramBundle);
      paramBundle = ((c)localObject4).FeE;
      if (paramBundle == null) {}
      for (i = 2147483647;; i = paramBundle.startTime)
      {
        if (i <= ((bkk)localObject1).startTime) {
          break label1274;
        }
        ((c)localObject4).FeE = ((bkk)localObject1);
        break;
      }
      label1274:
      localObject3 = new StringBuilder("use existInfo.finderLiveNoticInfo. [");
      paramBundle = ((c)localObject4).FeE;
      if (paramBundle == null) {}
      for (paramBundle = null;; paramBundle = Integer.valueOf(paramBundle.startTime))
      {
        Log.i("Finder.FinderProfileHeaderUIC", paramBundle + ", " + ((bkk)localObject1).startTime + ']');
        break;
      }
      label1346:
      break label566;
      label1349:
      i = 0;
      break label609;
      label1354:
      paramBundle = com.tencent.mm.plugin.finder.api.c.b((com.tencent.mm.plugin.finder.api.m)localObject4);
      if (paramBundle == null)
      {
        paramBundle = null;
        break label634;
      }
      paramBundle = paramBundle.ADE;
      break label634;
      label1377:
      i = 0;
      break label652;
      label1382:
      i = 0;
      break label668;
      label1387:
      paramBundle = null;
      break label672;
      label1392:
      break label927;
      label1395:
      paramBundle.eKD().setBackgroundResource(e.d.finder_live_notice_bg_shape);
      break label1012;
      paramBundle.eKz().setBackgroundResource(e.d.finder_live_notice_bg_shape);
      break label1060;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(350039);
    super.onDestroy();
    IListener localIListener = this.ErY;
    if (localIListener != null) {
      localIListener.dead();
    }
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().b(106, (com.tencent.mm.plugin.finder.api.k)this.FeB);
    com.tencent.mm.kernel.h.aZW().b(3736, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(6653, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(372, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(350039);
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(350035);
    super.onResume();
    Object localObject3 = this.Feo;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("liveWidget");
      localObject1 = null;
    }
    String str = this.username;
    kotlin.g.b.s.u(str, "username");
    if (((com.tencent.mm.plugin.finder.profile.widget.c)localObject1).eKD().getVisibility() == 0)
    {
      localObject1 = (c)userExtInfoCache.get(str);
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject3 = com.tencent.mm.kernel.h.ax(cf.class);
        kotlin.g.b.s.s(localObject3, "service(IHellLiveVisitorReoprter::class.java)");
        cf.a.a((cf)localObject3, q.cg.DFr, str, 0L, q.n.Dtx.scene, null, null, null, null, (String)localObject1, null, 1504);
      }
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.l.ARA;
      com.tencent.mm.plugin.finder.extension.reddot.l.avu("FinderProfileBanner");
      localObject1 = this.Fen;
      if (localObject1 != null) {
        break label269;
      }
      kotlin.g.b.s.bIx("activityWidget");
      localObject1 = localObject2;
    }
    label269:
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.profile.widget.a)localObject1).y("onResume", this.username, this.Fez);
      if ((isSelf()) && (isSelfFlag()))
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        if (((com.tencent.mm.plugin.findersdk.a.av)com.tencent.mm.ui.component.k.d(getActivity()).cq(com.tencent.mm.plugin.findersdk.a.av.class)).exM().euk() == null)
        {
          localObject1 = new di(8);
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
        }
      }
      AppMethodBeat.o(350035);
      return;
      localObject1 = ((c)localObject1).FeE;
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject3 = ((bkk)localObject1).YSR;
      localObject1 = localObject3;
      if (localObject3 != null) {
        break;
      }
      localObject1 = "";
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int j = 1;
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(350082);
    kotlin.g.b.s.u(paramp, "scene");
    Object localObject3 = getFragment();
    if ((localObject3 != null) && (((Fragment)localObject3).isDetached() == true)) {}
    for (int i = 1; (i != 0) || (getActivity().isFinishing()); i = 0)
    {
      AppMethodBeat.o(350082);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof dt))
      {
        if (((dt)paramp).ADo == 0L)
        {
          localObject1 = new StringBuilder("username=").append(this.username).append(", scene username=");
          paramString = ((dt)paramp).caK();
          if (paramString == null) {}
          for (paramString = null;; paramString = paramString.username)
          {
            Log.i("Finder.FinderProfileHeaderUIC", paramString);
            if (kotlin.g.b.s.p(((dt)paramp).ABB, this.username)) {
              break;
            }
            AppMethodBeat.o(350082);
            return;
          }
          if (((dt)paramp).getMaxId() != 0L)
          {
            AppMethodBeat.o(350082);
            return;
          }
          paramString = ((dt)paramp).caK();
          if (paramString != null)
          {
            paramString = paramString.username;
            if (paramString != null) {
              this.username = paramString;
            }
          }
          paramString = (c)userExtInfoCache.get(this.username);
          if (paramString == null)
          {
            paramString = new c();
            paramString.fansCount = ((dt)paramp).fansCount;
            paramString.friendFollowCount = ((dt)paramp).friendFollowCount;
            paramString.aS(((dt)paramp).userTags);
            localObject1 = this.Feo;
            if (localObject1 != null) {
              break label363;
            }
            kotlin.g.b.s.bIx("liveWidget");
            localObject1 = null;
          }
          label363:
          for (;;)
          {
            localObject3 = c.c.b(((dt)paramp).rr.otC);
            if (localObject3 != null) {
              break label366;
            }
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
            AppMethodBeat.o(350082);
            throw paramString;
            break;
          }
          label366:
          localObject3 = ((FinderUserPageResponse)localObject3).liveNoticeInfo;
          if ((((com.tencent.mm.plugin.finder.profile.widget.c)localObject1).Fhe != -1) && (((com.tencent.mm.plugin.finder.profile.widget.c)localObject1).Fhd != -1)) {
            if ((localObject3 == null) || (((bkk)localObject3).status != ((com.tencent.mm.plugin.finder.profile.widget.c)localObject1).Fhe)) {
              break label496;
            }
          }
          label496:
          for (paramInt1 = j;; paramInt1 = 0)
          {
            if (paramInt1 != 0)
            {
              Log.i("Finder.FinderProfileHeaderUIC", "[checkLiveNoticeInfo] notice action change before sceneEnd");
              ((bkk)localObject3).status = ((com.tencent.mm.plugin.finder.profile.widget.c)localObject1).Fhd;
            }
            paramString.FeE = ((bkk)localObject3);
            paramString.FeF = ((dt)paramp).dWB();
            localObject1 = c.c.b(((dt)paramp).rr.otC);
            if (localObject1 != null) {
              break;
            }
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
            AppMethodBeat.o(350082);
            throw paramString;
          }
          paramString.FeG = ((FinderUserPageResponse)localObject1).biz_info;
          localObject1 = c.c.b(((dt)paramp).rr.otC);
          if (localObject1 == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
            AppMethodBeat.o(350082);
            throw paramString;
          }
          localObject1 = ((FinderUserPageResponse)localObject1).eventInfoList;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = (awt)kotlin.a.p.oL((List)localObject1))
          {
            paramString.AtP = ((awt)localObject1);
            localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
            paramString.FeH = com.tencent.mm.plugin.finder.api.d.a.auW(this.username);
            localObject1 = c.c.b(((dt)paramp).rr.otC);
            if (localObject1 != null) {
              break;
            }
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
            AppMethodBeat.o(350082);
            throw paramString;
          }
          paramString.FeI = ((FinderUserPageResponse)localObject1).poi_info;
          paramString.FeJ = ((dt)paramp).dWE();
          paramString.FeK = ((dt)paramp).dWC();
          paramString.FeL = ((dt)paramp).dWD();
          userExtInfoCache.put(this.username, paramString);
          azq("onSceneEnd:[NetSceneFinderUserPage]");
          localObject1 = (com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
          paramString = ((dt)paramp).dWC();
          if (paramString == null)
          {
            paramString = null;
            ((com.tencent.mm.plugin.g)localObject1).t(paramString);
            paramString = com.tencent.mm.ui.component.k.aeZF;
            ((n)com.tencent.mm.ui.component.k.d(getActivity()).q(n.class)).azv(this.username);
            if (this.Fez) {
              this.Fez = false;
            }
            if (!this.Fer) {
              break label1355;
            }
            this.Fer = false;
            paramString = this.Fep;
            if (paramString != null) {
              break label863;
            }
            kotlin.g.b.s.bIx("moreLiveListWidget");
            paramString = null;
            label818:
            paramp = (c)userExtInfoCache.get(this.username);
            if (paramp != null) {
              break label866;
            }
          }
          label863:
          label866:
          for (paramp = (com.tencent.mm.am.p)localObject2;; paramp = paramp.FeK)
          {
            paramString.a(paramp);
            AppMethodBeat.o(350082);
            return;
            paramString = paramString.ZTJ;
            break;
            break label818;
          }
        }
      }
      else
      {
        if ((paramp instanceof di))
        {
          this.Fey = true;
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          ((com.tencent.mm.plugin.findersdk.a.av)com.tencent.mm.ui.component.k.d(getActivity()).cq(com.tencent.mm.plugin.findersdk.a.av.class)).exM().a(((di)paramp).dVy());
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          ((n)com.tencent.mm.ui.component.k.d(getActivity()).q(n.class)).azv(this.username);
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          ((com.tencent.mm.plugin.finder.post.g)com.tencent.mm.ui.component.k.d(getActivity()).q(com.tencent.mm.plugin.finder.post.g.class)).onSceneEnd(paramInt1, paramInt2, paramString, paramp);
          AppMethodBeat.o(350082);
          return;
        }
        if ((paramp instanceof com.tencent.mm.openim.model.q))
        {
          paramString = this.Fek;
          if (paramString == null)
          {
            kotlin.g.b.s.bIx("enterpriseAdd");
            paramString = (String)localObject1;
            paramp = (com.tencent.mm.openim.model.q)paramp;
            kotlin.g.b.s.u(paramp, "scene");
            paramp = paramp.psC;
            if (paramp != null)
            {
              localObject1 = paramp.UserName;
              localObject2 = Util.nullAsNil((String)localObject1);
              kotlin.g.b.s.s(localObject2, "nullAsNil(userName)");
              if (((CharSequence)localObject2).length() <= 0) {
                break label1203;
              }
              paramInt1 = 1;
              label1082:
              if (paramInt1 == 0) {
                break label1208;
              }
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject1);
              localObject2 = new Intent();
              com.tencent.mm.api.d.a((Intent)localObject2, paramp, 161);
              if ((localObject1 != null) && (!com.tencent.mm.contact.d.rs(((az)localObject1).field_type))) {
                ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
              }
              com.tencent.mm.br.c.b((Context)paramString.activity, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
            }
          }
          for (;;)
          {
            paramp = paramString.rYw;
            if (paramp != null) {
              paramp.dismiss();
            }
            paramString.FgT = false;
            AppMethodBeat.o(350082);
            return;
            break;
            label1203:
            paramInt1 = 0;
            break label1082;
            label1208:
            Toast.makeText(paramString.activity.getApplicationContext(), e.h.finder_profile_wecom_add_failed_text, 0).show();
          }
        }
      }
    }
    else
    {
      if (!(paramp instanceof di)) {
        break label1362;
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.post.g)com.tencent.mm.ui.component.k.d(getActivity()).q(com.tencent.mm.plugin.finder.post.g.class)).onSceneEnd(paramInt1, paramInt2, paramString, paramp);
      if (paramInt2 == -5900)
      {
        paramp = (c)userExtInfoCache.get(this.username);
        paramString = paramp;
        if (paramp == null) {
          paramString = new c();
        }
        paramp = com.tencent.mm.plugin.finder.api.d.AwY;
        paramp = com.tencent.mm.plugin.finder.api.d.a.auW(this.username);
        if (paramp != null) {
          break label1439;
        }
        paramp = new d.a.a(0, null, 0, 15);
      }
    }
    label1439:
    for (;;)
    {
      paramp.Axe = true;
      paramString.FeH = paramp;
      azq("onSceneEnd:[NetSceneFinderUserPage]");
      label1355:
      AppMethodBeat.o(350082);
      return;
      label1362:
      if (!(paramp instanceof com.tencent.mm.openim.model.q)) {
        break;
      }
      paramp = this.Fek;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("enterpriseAdd");
        paramString = null;
      }
      paramp = paramString.rYw;
      if (paramp != null) {
        paramp.dismiss();
      }
      paramString.FgT = false;
      aa.showTextToast(getActivity().getApplicationContext(), getActivity().getResources().getString(e.h.finder_cgi_failed));
      break;
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(350028);
    super.onStart();
    if (!this.AuP) {
      ti(true);
    }
    this.AuP = false;
    AppMethodBeat.o(350028);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$Companion;", "", "()V", "MENU_ID_SET_HEADER_ALBUM", "", "MENU_ID_SET_HEADER_TAKE_PHOTO", "MENU_ID_SET_NO_FOLLOW_CONFIRM", "MENU_ID_SET_NO_SEE_CONFIRM", "REQUEST_CODE_DISTRICT", "REQUEST_CODE_GO_TO_QR_CODE_UI", "REQUEST_CODE_IMAGE_BOUND_SEND_SURE", "REQUEST_CODE_SETTING", "SOURCE_USER_PAGE", "", "TAG", "userExtInfoCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$UserExtInfo;", "getUserExtInfoCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMessageBtn$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class aa
    extends com.tencent.mm.view.e.b
  {
    aa(h paramh) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(348595);
      kotlin.g.b.s.u(paramView, "view");
      if (paramBoolean)
      {
        paramView = com.tencent.mm.plugin.finder.report.f.FnM;
        paramView = com.tencent.mm.plugin.finder.report.f.eMn();
        String str = com.tencent.mm.model.z.bAW();
        kotlin.g.b.s.s(str, "getMyFinderUsername()");
        paramView.ak(str, "", h.d(this.FeM));
        paramView = com.tencent.mm.plugin.finder.report.f.FnM;
        f.b.a(com.tencent.mm.plugin.finder.report.f.eMn(), h.f(this.FeM), 3L);
        paramView = (FrameLayout)h.g(this.FeM).findViewById(e.e.sendMsgBtn);
        kotlin.g.b.s.s(paramView, "header.sendMsgBtn");
        com.tencent.mm.view.f.a((View)paramView, null);
      }
      AppMethodBeat.o(348595);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleOlyJumpInfo$2$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ab
    extends com.tencent.mm.view.e.b
  {
    ab(h paramh, FinderJumpInfo paramFinderJumpInfo) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(348579);
      kotlin.g.b.s.u(paramView, "view");
      if (paramBoolean) {
        h.a((Context)this.FeM.getContext(), "feed_jumpicon", localFinderJumpInfo);
      }
      AppMethodBeat.o(348579);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends u
    implements kotlin.g.a.a<ah>
  {
    ac(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isExpand", "", "isBtnVisible"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ad
    extends u
    implements kotlin.g.a.m<Boolean, Boolean, ah>
  {
    ad(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ae
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    ae(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class af
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    af(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ag
    extends u
    implements kotlin.g.a.a<ah>
  {
    ag(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ah
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    ah(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ai
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    ai(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aj
    extends u
    implements kotlin.g.a.a<View>
  {
    aj(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ak
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    ak(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class al
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    al(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class am
    extends u
    implements kotlin.g.a.a<TextView>
  {
    am(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$onActivityResult$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class an
    implements com.tencent.mm.loader.f.e<com.tencent.mm.loader.f.c>
  {
    an(h paramh) {}
    
    public final void a(com.tencent.mm.loader.f.c paramc, com.tencent.mm.loader.f.i parami)
    {
      AppMethodBeat.i(348607);
      kotlin.g.b.s.u(paramc, "task");
      kotlin.g.b.s.u(parami, "status");
      if (parami == com.tencent.mm.loader.f.i.nrH)
      {
        aa.makeText((Context)this.FeM.getActivity(), (CharSequence)this.FeM.getString(e.h.finder_update_failed), 0).show();
        AppMethodBeat.o(348607);
        return;
      }
      aa.makeText((Context)this.FeM.getActivity(), (CharSequence)this.FeM.getString(e.h.finder_update_success), 0).show();
      AppMethodBeat.o(348607);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ao
    extends u
    implements kotlin.g.a.a<ah>
  {
    ao(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "scene", "Lcom/tencent/mm/plugin/findersdk/api/INetSceneCreateLiveNotice;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ap
    extends u
    implements kotlin.g.a.r<Integer, Integer, String, cl, ah>
  {
    ap(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aq
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    aq(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "start", "", "end", "nickname", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ar
    extends u
    implements kotlin.g.a.q<Integer, Integer, String, ah>
  {
    ar(SpannableString paramSpannableString, int paramInt1, int paramInt2, StringBuilder paramStringBuilder, h paramh, com.tencent.mm.plugin.finder.api.m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class as
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    as(h paramh, com.tencent.mm.plugin.finder.api.m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class at
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    at(boolean[] paramArrayOfBoolean, h paramh, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class au
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    au(h paramh, com.tencent.mm.plugin.finder.api.m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class av
    extends u
    implements kotlin.g.a.a<TextView>
  {
    av(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aw
    extends u
    implements kotlin.g.a.a<TextView>
  {
    aw(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$UserExtInfo;", "", "friendFollowCount", "", "fansCount", "userTags", "Ljava/util/LinkedList;", "", "finderLiveNoticInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "shopInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "logOutInfo", "Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;", "poiInfo", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePoi;", "weComInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWeComInfo;", "finderLiveNoticeListInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeListInfo;", "jumpInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "(IILjava/util/LinkedList;Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;Lcom/tencent/mm/protocal/protobuf/FinderUserPagePoi;Lcom/tencent/mm/protocal/protobuf/FinderWeComInfo;Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeListInfo;Ljava/util/List;)V", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;", "setBizInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;)V", "getEventInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "setEventInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;)V", "getFansCount", "()I", "setFansCount", "(I)V", "getFinderLiveNoticInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setFinderLiveNoticInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "getFinderLiveNoticeListInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeListInfo;", "setFinderLiveNoticeListInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeListInfo;)V", "getFriendFollowCount", "setFriendFollowCount", "getJumpInfo", "()Ljava/util/List;", "setJumpInfo", "(Ljava/util/List;)V", "getLogOutInfo", "()Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;", "setLogOutInfo", "(Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;)V", "getPoiInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderUserPagePoi;", "setPoiInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderUserPagePoi;)V", "getShopInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "setShopInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;)V", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "getWeComInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWeComInfo;", "setWeComInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderWeComInfo;)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public awt AtP;
    public bkk FeE;
    public bzd FeF;
    public auh FeG;
    public d.a.a FeH;
    public byk FeI;
    public bzb FeJ;
    public bkl FeK;
    public List<? extends FinderJumpInfo> FeL;
    public int fansCount;
    public int friendFollowCount;
    public LinkedList<String> userTags;
    
    private c(LinkedList<String> paramLinkedList)
    {
      AppMethodBeat.i(348656);
      this.friendFollowCount = -1;
      this.fansCount = -1;
      this.userTags = paramLinkedList;
      this.FeE = null;
      this.FeF = null;
      this.FeG = null;
      this.AtP = null;
      this.FeH = null;
      this.FeI = null;
      this.FeJ = null;
      this.FeK = null;
      this.FeL = null;
      AppMethodBeat.o(348656);
    }
    
    public final void aS(LinkedList<String> paramLinkedList)
    {
      AppMethodBeat.i(348671);
      kotlin.g.b.s.u(paramLinkedList, "<set-?>");
      this.userTags = paramLinkedList;
      AppMethodBeat.o(348671);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(348707);
      if (this == paramObject)
      {
        AppMethodBeat.o(348707);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      paramObject = (c)paramObject;
      if (this.friendFollowCount != paramObject.friendFollowCount)
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (this.fansCount != paramObject.fansCount)
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (!kotlin.g.b.s.p(this.userTags, paramObject.userTags))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (!kotlin.g.b.s.p(this.FeE, paramObject.FeE))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (!kotlin.g.b.s.p(this.FeF, paramObject.FeF))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (!kotlin.g.b.s.p(this.FeG, paramObject.FeG))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (!kotlin.g.b.s.p(this.AtP, paramObject.AtP))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (!kotlin.g.b.s.p(this.FeH, paramObject.FeH))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (!kotlin.g.b.s.p(this.FeI, paramObject.FeI))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (!kotlin.g.b.s.p(this.FeJ, paramObject.FeJ))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (!kotlin.g.b.s.p(this.FeK, paramObject.FeK))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      if (!kotlin.g.b.s.p(this.FeL, paramObject.FeL))
      {
        AppMethodBeat.o(348707);
        return false;
      }
      AppMethodBeat.o(348707);
      return true;
    }
    
    public final int hashCode()
    {
      int i4 = 0;
      AppMethodBeat.i(348700);
      int i5 = this.friendFollowCount;
      int i6 = this.fansCount;
      int i7 = this.userTags.hashCode();
      int i;
      int j;
      label47:
      int k;
      label56:
      int m;
      label66:
      int n;
      label76:
      int i1;
      label86:
      int i2;
      label96:
      int i3;
      if (this.FeE == null)
      {
        i = 0;
        if (this.FeF != null) {
          break label195;
        }
        j = 0;
        if (this.FeG != null) {
          break label206;
        }
        k = 0;
        if (this.AtP != null) {
          break label217;
        }
        m = 0;
        if (this.FeH != null) {
          break label229;
        }
        n = 0;
        if (this.FeI != null) {
          break label241;
        }
        i1 = 0;
        if (this.FeJ != null) {
          break label253;
        }
        i2 = 0;
        if (this.FeK != null) {
          break label265;
        }
        i3 = 0;
        label106:
        if (this.FeL != null) {
          break label277;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(348700);
        return (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + ((i5 * 31 + i6) * 31 + i7) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
        i = this.FeE.hashCode();
        break;
        label195:
        j = this.FeF.hashCode();
        break label47;
        label206:
        k = this.FeG.hashCode();
        break label56;
        label217:
        m = this.AtP.hashCode();
        break label66;
        label229:
        n = this.FeH.hashCode();
        break label76;
        label241:
        i1 = this.FeI.hashCode();
        break label86;
        label253:
        i2 = this.FeJ.hashCode();
        break label96;
        label265:
        i3 = this.FeK.hashCode();
        break label106;
        label277:
        i4 = this.FeL.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(348686);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("UserExtInfo(friendFollowCount=").append(this.friendFollowCount).append(", fansCount=").append(this.fansCount).append(", userTags=").append(this.userTags).append(", finderLiveNoticInfo=").append(this.FeE).append(", shopInfo=").append(this.FeF).append(", bizInfo=").append(this.FeG).append(", eventInfo=").append(this.AtP).append(", logOutInfo=").append(this.FeH).append(", poiInfo=").append(this.FeI).append(", weComInfo=").append(this.FeJ).append(", finderLiveNoticeListInfo=").append(this.FeK).append(", jumpInfo=");
      ((StringBuilder)localObject).append(this.FeL).append(')');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(348686);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextView>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    g(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TextView>
  {
    h(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    i(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<TextView>
  {
    j(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    k(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<bui>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$countListener$1", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "", "scene", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements com.tencent.mm.plugin.finder.api.k
  {
    m(h paramh) {}
    
    public final void a(auw paramauw, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(348658);
      kotlin.g.b.s.u(paramauw, "cmdItem");
      if ((!h.n(this.FeM)) || (!h.o(this.FeM)))
      {
        AppMethodBeat.o(348658);
        return;
      }
      if (paramauw.cmdId == 106) {
        h.c(this.FeM, "handleCmd");
      }
      AppMethodBeat.o(348658);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/CollapsibleTextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<CollapsibleTextView>
  {
    n(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    o(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$doBlockOpLog$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements ck<bpq>
  {
    p(h paramh, boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<RoundCornerRelativeLayout>
  {
    q(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    r(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.a<TextView>
  {
    s(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    t(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    u(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final v FeO;
    
    static
    {
      AppMethodBeat.i(348681);
      FeO = new v();
      AppMethodBeat.o(348681);
    }
    
    v()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    w(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends u
    implements kotlin.g.a.a<TextView>
  {
    x(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleEditBtn$1$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class y
    extends com.tencent.mm.view.e.b
  {
    y(l.a parama, h paramh) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(348711);
      kotlin.g.b.s.u(paramView, "view");
      if (paramBoolean)
      {
        paramView = this.FeP.ASh;
        bxq localbxq = this.FeP.ASg;
        h localh = paramh;
        if ((paramView != null) && (localbxq != null)) {
          com.tencent.mm.plugin.finder.report.w.a(com.tencent.mm.plugin.finder.report.w.FrV, "3", paramView, localbxq, 1, h.f(localh), 0, null, 0, 480);
        }
      }
      AppMethodBeat.o(348711);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleLuckMoneyCoverLayout$2", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class z
    extends com.tencent.mm.view.e.b
  {
    z(h paramh, JSONObject paramJSONObject) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(348704);
      kotlin.g.b.s.u(paramView, "view");
      if (paramBoolean)
      {
        paramView = bb.FuK;
        paramView = as.GSQ;
        paramView = as.a.hu((Context)this.FeM.getContext());
        if (paramView != null) {
          break label61;
        }
      }
      label61:
      for (paramView = null;; paramView = paramView.fou())
      {
        bb.a(paramView, "get_red_cover_panel", 0, this.FeQ);
        AppMethodBeat.o(348704);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.h
 * JD-Core Version:    0.7.0.1
 */