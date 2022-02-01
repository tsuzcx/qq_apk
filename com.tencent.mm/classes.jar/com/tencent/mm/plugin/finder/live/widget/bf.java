package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.f;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.h;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.cgi.ai;
import com.tencent.mm.plugin.finder.cgi.aw;
import com.tencent.mm.plugin.finder.live.cgi.m;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ak;
import com.tencent.mm.plugin.finder.live.model.ak.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.l;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.fhh;
import com.tencent.mm.protocal.protobuf.gfi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.h.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONException;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "FLAG_FROM_SHOW_GUIDE_LOGIC", "", "getFLAG_FROM_SHOW_GUIDE_LOGIC", "()I", "FLAG_FROM_SHOW_INVITE_LOGIC", "getFLAG_FROM_SHOW_INVITE_LOGIC", "FLAG_SHOW_GAME_BOTTOM_SHEET_INIVTE", "getFLAG_SHOW_GAME_BOTTOM_SHEET_INIVTE", "FLAG_SHOW_GAME_BOTTOM_SHEET_JOIN", "getFLAG_SHOW_GAME_BOTTOM_SHEET_JOIN", "FLAG_SHOW_GAME_BOTTOM_SHEET_JOIN_NEXT", "getFLAG_SHOW_GAME_BOTTOM_SHEET_JOIN_NEXT", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "bottomNotes", "Landroid/widget/TextView;", "getBottomNotes", "()Landroid/widget/TextView;", "setBottomNotes", "(Landroid/widget/TextView;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "setBottomSheet", "(Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;)V", "btn", "getBtn", "setBtn", "gameInfoBg", "Landroid/view/View;", "getGameInfoBg", "()Landroid/view/View;", "setGameInfoBg", "(Landroid/view/View;)V", "gameInfoContainer", "getGameInfoContainer", "setGameInfoContainer", "giftArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getGiftArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setGiftArrow", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "giftDes", "getGiftDes", "setGiftDes", "giftIcon", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getGiftIcon", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "setGiftIcon", "(Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;)V", "giftInnerContainer", "Landroid/widget/LinearLayout;", "getGiftInnerContainer", "()Landroid/widget/LinearLayout;", "setGiftInnerContainer", "(Landroid/widget/LinearLayout;)V", "giftInnerContainerBg", "Landroid/graphics/drawable/GradientDrawable;", "getGiftInnerContainerBg", "()Landroid/graphics/drawable/GradientDrawable;", "setGiftInnerContainerBg", "(Landroid/graphics/drawable/GradientDrawable;)V", "giftOuterContainer", "Landroid/widget/FrameLayout;", "getGiftOuterContainer", "()Landroid/widget/FrameLayout;", "setGiftOuterContainer", "(Landroid/widget/FrameLayout;)V", "giftReddot", "getGiftReddot", "setGiftReddot", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "isDoingPreloadCgiFinderLiveGetGameTeamInfo", "", "()Z", "setDoingPreloadCgiFinderLiveGetGameTeamInfo", "(Z)V", "isHighlightStatus", "setHighlightStatus", "lastClickTime", "", "lastGameInvitation", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgGameInvitationInfo;", "getLastGameInvitation", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgGameInvitationInfo;", "setLastGameInvitation", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgGameInvitationInfo;)V", "lastGameInvitationSeq", "getLastGameInvitationSeq", "()J", "setLastGameInvitationSeq", "(J)V", "lastPayJumpGameTeamId", "", "getLastPayJumpGameTeamId", "()Ljava/lang/String;", "setLastPayJumpGameTeamId", "(Ljava/lang/String;)V", "line1Tv", "getLine1Tv", "setLine1Tv", "line2Tv", "getLine2Tv", "setLine2Tv", "line3Tv", "getLine3Tv", "setLine3Tv", "mainContainer", "getMainContainer", "()Landroid/view/ViewGroup;", "setMainContainer", "(Landroid/view/ViewGroup;)V", "note", "getNote", "setNote", "payGameTeamLogic", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$PayGameTeamLogic;", "getPayGameTeamLogic", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$PayGameTeamLogic;", "rankDesc", "getRankDesc", "setRankDesc", "rankLabels", "getRankLabels", "setRankLabels", "reddotId", "getReddotId", "setReddotId", "getRoot", "sessionId", "getSessionId", "setSessionId", "showGameBottomSheetType", "getShowGameBottomSheetType", "setShowGameBottomSheetType", "(I)V", "showGameInvitationInfoBottomSheet", "getShowGameInvitationInfoBottomSheet", "setShowGameInvitationInfoBottomSheet", "showGameJoinGuide", "getShowGameJoinGuide", "setShowGameJoinGuide", "showJumpGameInviteDialog", "getShowJumpGameInviteDialog", "setShowJumpGameInviteDialog", "showJumpGameTeamDialog", "getShowJumpGameTeamDialog", "setShowJumpGameTeamDialog", "showNewGuide", "getShowNewGuide", "setShowNewGuide", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "weAppOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "getWeAppOpenBundle", "()Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "setWeAppOpenBundle", "(Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "checkCanJumpGame", "", "curMode", "checkGameInvitation", "checkHighlightBtnAndToast", "from", "checkLiveRoom", "checkShowGuide", "checkVisible", "doCgiFinderLiveGetGameTeamInfo", "gameInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;", "doFinderLiveGetTeamupGiftPrepare", "doFinderLiveRespondGameInvitation", "opType", "doPreloadCgiFinderLiveGetGameTeamInfo", "flag_from", "getColorValue", "color", "defColor", "getGiftReddotReportJson", "reddot", "actionType", "getGiftReportJson", "gift", "getWeAppOpenUICallback", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "goMiniApp", "hideBubble", "highlightBtn", "invokeUI", "teamMode", "isPayGameTeam", "gameTeamInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;", "isVisible", "isWeChatUser", "jumpGameFromInviteSheet", "jumpHalfScreenGameInfo", "notifySendMsgResult", "bundle", "Landroid/os/Bundle;", "onFinishLive", "onMount", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "refreshBottomSheet", "refreshBottomSheetText", "refreshBtnStateForNormalGameTeam", "reportBtnClick", "mode", "reportBtnExpose", "resetBottomSheet", "context", "Landroid/content/Context;", "resetBottomSheetFlag", "resetBtn", "resetBubbleFlag", "setGameInvitationSeqToNew", "setupBottomSheetForNormalGameTeam", "showBottomSheet", "showJoinGameGuide", "preGameTeamInfo", "showOverseaForbiddenDialog", "stop", "updateBottomSheet", "updateBubbleText", "updateJoinGameGuide", "Companion", "GameTeamGiftExtraData", "OnDialogClickListener", "PayGameTeamLogic", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bf
{
  private static long EvP;
  private static int EvQ;
  private static String EvR;
  private static bha EvS;
  public static final a Evf;
  public static final String TAG;
  private String AAN;
  public g Beb;
  public final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  public com.tencent.mm.ui.widget.a.h Epc;
  public boolean EvA;
  public boolean EvB;
  private boolean EvC;
  private int EvD;
  private final int EvE;
  private final int EvF;
  private final int EvG;
  private bee EvH;
  private long EvI;
  public boolean EvJ;
  public boolean EvK;
  boolean EvL;
  private final int EvM;
  private final int EvN;
  public String EvO;
  TextView Evg;
  private TextView Evh;
  private TextView Evi;
  TextView Evj;
  private ViewGroup Evk;
  TextView Evl;
  private TextView Evm;
  private TextView Evn;
  private TextView Evo;
  private View Evp;
  private View Evq;
  private FrameLayout Evr;
  private LinearLayout Evs;
  private GradientDrawable Evt;
  private FrameLayout Evu;
  private MMRoundCornerImageView Evv;
  private TextView Evw;
  private WeImageView Evx;
  private final d Evy;
  private boolean Evz;
  private ImageView dpM;
  private long lastClickTime;
  public final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  private long sessionId;
  
  static
  {
    AppMethodBeat.i(361883);
    Evf = new a((byte)0);
    TAG = "Finder.FinderLiveVisitorGameTeamWidget";
    EvR = "";
    AppMethodBeat.o(361883);
  }
  
  public bf(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361374);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.mJe.setVisibility(8);
    this.Evy = new d();
    this.EvD = -1;
    this.EvF = 1;
    this.EvG = 2;
    this.EvN = 1;
    AppMethodBeat.o(361374);
  }
  
  private final void Qm(int paramInt)
  {
    AppMethodBeat.i(361434);
    if (this.Evz)
    {
      Log.i(TAG, "doing preload CgiFinderLiveGetGameTeamInfo");
      AppMethodBeat.o(361434);
      return;
    }
    if ((this.EvB) && (paramInt == this.EvM))
    {
      Log.i(TAG, "is showing join game guide");
      AppMethodBeat.o(361434);
      return;
    }
    this.Evz = true;
    bha localbha = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFy;
    if (localbha == null)
    {
      AppMethodBeat.o(361434);
      return;
    }
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    com.tencent.mm.bx.b localb = com.tencent.mm.bx.b.cX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp);
    kotlin.g.b.s.s(localb, "copyFrom(basePlugin.busi…:class.java).liveCookies)");
    new m(l1, l2, localb, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId).bFJ().g(new bf..ExternalSyntheticLambda15(this, paramInt, localbha));
    AppMethodBeat.o(361434);
  }
  
  private static final ah a(bf parambf, int paramInt, bha parambha, b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(361646);
    kotlin.g.b.s.u(parambf, "this$0");
    kotlin.g.b.s.u(parambha, "$gameInfo");
    parambf.Evz = false;
    bhf localbhf;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localbhf = ((bht)parama.ott).ZQZ;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).b(localbhf);
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("click gameTeamInfo status:");
      if (localbhf == null)
      {
        parama = null;
        localStringBuilder = localStringBuilder.append(parama).append(", in_teaming_up:");
        if (localbhf != null) {
          break label196;
        }
        parama = localObject;
        label118:
        Log.i(str, parama);
        if (localbhf == null) {
          break label238;
        }
        if (paramInt != parambf.EvM) {
          break label218;
        }
        switch (localbhf.status)
        {
        }
      }
    }
    for (;;)
    {
      parambf = ah.aiuX;
      AppMethodBeat.o(361646);
      return parambf;
      parama = Integer.valueOf(localbhf.status);
      break;
      label196:
      parama = Integer.valueOf(localbhf.ZOK);
      break label118;
      parambf.d(parambha, localbhf);
      continue;
      label218:
      if (paramInt == parambf.EvN)
      {
        Log.i(TAG, "update gameTeamInfo from show invite");
        continue;
        label238:
        Log.i(TAG, "resp.game_team_info null");
        continue;
        Log.e(TAG, "ljd do CgiFinderLiveGetGameTeamInfo fail errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg });
      }
    }
  }
  
  private static final ah a(bf parambf, b.a parama)
  {
    AppMethodBeat.i(361791);
    kotlin.g.b.s.u(parambf, "this$0");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edi;
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("onResume ").append(bool).append(' ');
      bhf localbhf2 = ((bht)parama.ott).ZQZ;
      bhf localbhf1 = localbhf2;
      if (localbhf2 == null) {
        localbhf1 = new bhf();
      }
      Log.i(str, com.tencent.mm.ae.f.dg(localbhf1));
      parama = ((bht)parama.ott).ZQZ;
      if (parama != null)
      {
        parama = parama.ZQG;
        if ((parama != null) && (kotlin.g.b.s.p(parama.ZUh, parambf.EvO)) && (parama.aakP > 0) && (parama.aakQ == 0) && (bool)) {
          aa.dc(parambf.mJe.getContext(), parambf.mJe.getContext().getString(p.h.Chb));
        }
      }
      parambf.EvO = null;
    }
    for (;;)
    {
      parambf = ah.aiuX;
      AppMethodBeat.o(361791);
      return parambf;
      Log.w(TAG, "CgiFinderLiveGetGameTeamInfo failed " + parama.errCode + ' ' + parama.errType);
    }
  }
  
  private static final ah a(bf parambf, bha parambha, b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(361580);
    kotlin.g.b.s.u(parambf, "this$0");
    kotlin.g.b.s.u(parambha, "$gameInfo");
    bhf localbhf;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localbhf = ((bht)parama.ott).ZQZ;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).b(localbhf);
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("click gameTeamInfo status:");
      if (localbhf == null)
      {
        parama = null;
        localStringBuilder = localStringBuilder.append(parama).append(", in_teaming_up:");
        if (localbhf != null) {
          break label161;
        }
        parama = localObject;
        label111:
        Log.i(str, parama);
        if (localbhf == null) {
          break label173;
        }
        parambf.a(parambha, localbhf);
      }
    }
    for (;;)
    {
      parambf = ah.aiuX;
      AppMethodBeat.o(361580);
      return parambf;
      parama = Integer.valueOf(localbhf.status);
      break;
      label161:
      parama = Integer.valueOf(localbhf.ZOK);
      break label111;
      label173:
      Log.i(TAG, "resp.game_team_info null");
      continue;
      aa.makeText(parambf.mJe.getContext(), (CharSequence)parambf.mJe.getContext().getString(p.h.finder_live_game_prepare_error), 0).show();
    }
  }
  
  private static final void a(bf parambf)
  {
    AppMethodBeat.i(361693);
    kotlin.g.b.s.u(parambf, "this$0");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
    parambf.nfT.statusChange(b.c.ncO, localBundle);
    AppMethodBeat.o(361693);
  }
  
  private static final void a(bf parambf, int paramInt1, int paramInt2, bha parambha, bhf parambhf, View paramView)
  {
    AppMethodBeat.i(361601);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt2);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambha);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambhf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parambf, "this$0");
    kotlin.g.b.s.u(parambha, "$gameInfo");
    kotlin.g.b.s.u(parambhf, "$gameTeamInfo");
    parambf.Qo(paramInt1);
    parambf.EvD = -1;
    if (paramInt2 == 1)
    {
      parambf.EvL = true;
      com.tencent.mm.plugin.finder.live.plugin.b localb = parambf.CwG;
      Context localContext = parambf.mJe.getContext();
      kotlin.g.b.s.s(localContext, "root.context");
      paramView = parambhf.ZQE;
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = "";
      }
      paramView = com.tencent.mm.plugin.finder.utils.t.GgN;
      boolean bool = a.g(parambhf);
      if (a.g(parambhf))
      {
        paramView = parambhf.ZQP;
        if (paramView == null)
        {
          paramView = "";
          localObject2 = parambf.mJe.getContext();
          kotlin.g.b.s.s(localObject2, "root.context");
          a.a(localb, localContext, parambha, parambhf, (String)localObject1, com.tencent.mm.plugin.finder.utils.t.a(bool, paramInt1, paramView, (Context)localObject2), (c)new i(parambf));
        }
      }
    }
    for (;;)
    {
      parambf = parambf.Epc;
      if (parambf != null) {
        parambf.cyW();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361601);
      return;
      localObject2 = paramView.xlJ;
      paramView = (View)localObject2;
      if (localObject2 != null) {
        break;
      }
      paramView = "";
      break;
      localObject2 = parambha.Idi;
      paramView = (View)localObject2;
      if (localObject2 != null) {
        break;
      }
      paramView = "";
      break;
      long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      paramView = parambhf.ZQE;
      parambhf = paramView;
      if (paramView == null) {
        parambhf = "";
      }
      kotlin.g.b.s.u(parambhf, "launchParams");
      kotlin.g.b.s.u(parambha, "gameInfo");
      EvP = l;
      EvQ = paramInt1;
      EvR = parambhf;
      EvS = parambha;
      Log.i(TAG, "refreshLastGameTeamClick, liveId:" + l + ", teamMode:" + paramInt1 + ", launchParams:" + parambhf + ", gameInfo:" + parambha.Idi + ", " + parambha.Idh + ", " + parambha.xlr);
      Log.i(TAG, kotlin.g.b.s.X("gameteam invokeUI ", Integer.valueOf(paramInt1)));
      switch (paramInt1)
      {
      default: 
        break;
      case 2: 
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyr()) {
          b.b.a(parambf.nfT, b.c.ndq);
        } else {
          aa.y(parambf.mJe.getContext(), parambf.mJe.getContext().getString(p.h.finder_live_gift_disable_msg_tip), p.g.icons_filled_error);
        }
        break;
      case 3: 
        parambha = ak.CHI;
        parambhf = parambf.nfT;
        parambha = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
        if (parambha == null) {}
        for (parambha = null;; parambha = Long.valueOf(parambha.liveId))
        {
          ak.a(parambhf, parambha.longValue(), ak.b.CHR);
          break;
        }
      case 4: 
        parambf.mJe.postDelayed(new bf..ExternalSyntheticLambda21(parambf), 100L);
        break;
      case 5: 
        parambf.mJe.postDelayed(new bf..ExternalSyntheticLambda20(parambf), 100L);
      }
    }
  }
  
  private static final void a(bf parambf, int paramInt, bhf parambhf, View paramView)
  {
    AppMethodBeat.i(361624);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambf);
    localb.sc(paramInt);
    localb.cH(parambhf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambf, "this$0");
    kotlin.g.b.s.u(parambhf, "$gameTeamInfo");
    parambf.Qo(paramInt);
    com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 22, 0, l.a(parambhf), 6);
    parambf.EvD = -1;
    paramView = parambf.Epc;
    if (paramView != null) {
      paramView.cyW();
    }
    parambf.mJe.postDelayed(new bf..ExternalSyntheticLambda22(parambhf, parambf), 100L);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361624);
  }
  
  private static final void a(bf parambf, View paramView)
  {
    AppMethodBeat.i(361688);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parambf, "this$0");
    com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 15, 0, null, 14);
    parambf.EvD = -1;
    paramView = parambf.Epc;
    if (paramView != null) {
      paramView.cyW();
    }
    parambf.EvJ = false;
    paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFy;
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
    bha localbha;
    bhf localbhf;
    int i;
    if ((paramView != null) && (localObject1 != null))
    {
      localbha = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFy;
      localbhf = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
      if ((localbha != null) && (localbhf != null))
      {
        i = localbhf.status;
        if ((i != 3) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edi)) {
          break label275;
        }
        aa.y(parambf.mJe.getContext(), parambf.mJe.getContext().getString(p.h.Chd), p.g.icons_filled_error);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361688);
      return;
      label275:
      if (i != 4) {
        if (localbhf.ZOK != 0) {
          break label323;
        }
      }
      label323:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label328;
        }
        aa.y(parambf.mJe.getContext(), parambf.mJe.getContext().getString(p.h.Che), p.g.icons_filled_error);
        break;
      }
      label328:
      parambf.EvK = true;
      com.tencent.mm.plugin.finder.live.plugin.b localb = parambf.CwG;
      Context localContext = parambf.mJe.getContext();
      kotlin.g.b.s.s(localContext, "root.context");
      paramView = localbhf.ZQE;
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = "";
      }
      paramView = com.tencent.mm.plugin.finder.utils.t.GgN;
      boolean bool = a.g(localbhf);
      if (a.g(localbhf))
      {
        paramView = localbhf.ZQP;
        if (paramView == null) {
          paramView = "";
        }
      }
      for (;;)
      {
        localObject2 = parambf.mJe.getContext();
        kotlin.g.b.s.s(localObject2, "root.context");
        a.a(localb, localContext, localbha, localbhf, (String)localObject1, com.tencent.mm.plugin.finder.utils.t.a(bool, 6, paramView, (Context)localObject2), (c)new g(parambf));
        break;
        localObject2 = paramView.xlJ;
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          paramView = "";
          continue;
          localObject2 = localbha.Idi;
          paramView = (View)localObject2;
          if (localObject2 == null) {
            paramView = "";
          }
        }
      }
      if (localObject1 == null) {
        Log.e(TAG, "lastGameTeamInfo is null");
      }
    }
  }
  
  private static final void a(bf parambf, bha parambha, bhf parambhf, View paramView)
  {
    AppMethodBeat.i(361666);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambf);
    localb.cH(parambha);
    localb.cH(parambhf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambf, "this$0");
    kotlin.g.b.s.u(parambha, "$preGameTeamInfo");
    kotlin.g.b.s.u(parambhf, "$gameTeamInfo");
    paramView = (com.tencent.mm.plugin.finder.live.plugin.aq)parambf.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
    if (paramView != null)
    {
      paramView = paramView.CZo;
      if (paramView != null) {
        paramView.eAP();
      }
    }
    parambf.eBN();
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFy != null) {
      parambf.a(parambha, parambhf);
    }
    com.tencent.mm.plugin.finder.live.report.k.Doi.axu(hR(parambhf.Edd, 18));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361666);
  }
  
  private static final void a(bf parambf, bhf parambhf, View paramView)
  {
    AppMethodBeat.i(361653);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambf);
    localb.cH(parambhf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambf, "this$0");
    paramView = (com.tencent.mm.plugin.finder.live.plugin.aq)parambf.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
    if (paramView != null)
    {
      paramView = paramView.CZo;
      if (paramView != null) {
        paramView.eAP();
      }
    }
    parambf.eBN();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adeG, Boolean.TRUE);
    paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFy;
    if (paramView != null) {
      parambf.a(paramView);
    }
    parambf = com.tencent.mm.plugin.finder.live.report.k.Doi;
    if (parambhf == null) {}
    for (int i = 0;; i = parambhf.Edd)
    {
      parambf.axu(hR(i, 18));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361653);
      return;
    }
  }
  
  private final void a(bha parambha)
  {
    AppMethodBeat.i(361386);
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    Object localObject = com.tencent.mm.bx.b.cX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp);
    kotlin.g.b.s.s(localObject, "copyFrom(basePlugin.busi…:class.java).liveCookies)");
    localObject = new m(l1, l2, (com.tencent.mm.bx.b)localObject, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId);
    Context localContext = this.mJe.getContext();
    kotlin.g.b.s.s(localContext, "root.context");
    ((m)localObject).e(localContext, this.mJe.getContext().getResources().getString(p.h.finder_waiting), 500L).bFJ().g(new bf..ExternalSyntheticLambda16(this, parambha));
    AppMethodBeat.o(361386);
  }
  
  private final void a(bha parambha, bhf parambhf)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    AppMethodBeat.i(361398);
    Log.i(TAG, "showBottomSheet");
    Context localContext = this.mJe.getContext();
    kotlin.g.b.s.s(localContext, "root.context");
    gI(localContext);
    b(parambha, parambhf);
    parambhf = this.Epc;
    if (parambhf != null) {
      parambhf.dDn();
    }
    int i = parambha.ZQz;
    parambha = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
    switch (i)
    {
    default: 
      AppMethodBeat.o(361398);
      return;
    case 7: 
      parambhf = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (parambha == null) {}
      for (parambha = null;; parambha = l.a(parambha))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(parambhf, 23, 0, parambha, 6);
        AppMethodBeat.o(361398);
        return;
      }
    case 2: 
      parambhf = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (parambha == null) {}
      for (parambha = localObject1;; parambha = l.a(parambha))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(parambhf, 9, 0, parambha, 6);
        AppMethodBeat.o(361398);
        return;
      }
    case 3: 
      parambhf = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (parambha == null) {}
      for (parambha = localObject2;; parambha = l.a(parambha))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(parambhf, 11, 0, parambha, 6);
        AppMethodBeat.o(361398);
        return;
      }
    case 4: 
      parambhf = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (parambha == null) {}
      for (parambha = localObject3;; parambha = l.a(parambha))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(parambhf, 7, 0, parambha, 6);
        AppMethodBeat.o(361398);
        return;
      }
    case 5: 
      parambhf = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (parambha == null) {}
      for (parambha = localObject4;; parambha = l.a(parambha))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(parambhf, 5, 0, parambha, 6);
        AppMethodBeat.o(361398);
        return;
      }
    }
    parambhf = com.tencent.mm.plugin.finder.live.report.k.Doi;
    if (parambha == null) {}
    for (parambha = localObject5;; parambha = l.a(parambha))
    {
      com.tencent.mm.plugin.finder.live.report.k.a(parambhf, 3, 0, parambha, 6);
      break;
    }
  }
  
  private static final void a(bhf parambhf, bf parambf)
  {
    AppMethodBeat.i(361614);
    kotlin.g.b.s.u(parambhf, "$gameTeamInfo");
    kotlin.g.b.s.u(parambf, "this$0");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
    if (!TextUtils.isEmpty((CharSequence)parambhf.ZQF)) {
      localBundle.putString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG", parambhf.ZQF);
    }
    localBundle.putBoolean("PARAM_FINDER_LIVE_NEED_NOTIFY_SEND_MSG_RESULT", true);
    parambf.sessionId = System.currentTimeMillis();
    localBundle.putLong("PARAM_FINDER_LIVE_SEND_MSG_SESSION_ID", parambf.sessionId);
    parambf.nfT.statusChange(b.c.ncO, localBundle);
    AppMethodBeat.o(361614);
  }
  
  private static final void a(bhf parambhf, bf parambf, bha parambha, View paramView)
  {
    AppMethodBeat.i(361561);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambhf);
    localb.cH(parambf);
    localb.cH(parambha);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambf, "this$0");
    paramView = com.tencent.mm.plugin.finder.live.report.k.Doi;
    if (parambhf == null) {}
    for (parambhf = null;; parambhf = l.a(parambhf))
    {
      com.tencent.mm.plugin.finder.live.report.k.a(paramView, 2, 0, parambhf, 6);
      a.ayG("IconClick");
      parambf.a(parambha);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361561);
      return;
    }
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.h paramh, bf parambf, View paramView)
  {
    AppMethodBeat.i(361743);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(parambf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "$this_apply");
    kotlin.g.b.s.u(parambf, "this$0");
    paramh.cyW();
    parambf.EvJ = false;
    if (parambf.EvD == parambf.EvG) {
      parambf.eBO();
    }
    parambf.EvD = -1;
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361743);
  }
  
  private static final boolean a(bf parambf, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(361710);
    kotlin.g.b.s.u(parambf, "this$0");
    if (kotlin.g.b.s.p(paramView, parambf.Evp)) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(361710);
      return false;
      paramView.setAlpha(0.3F);
      continue;
      paramView.performClick();
      paramView.setAlpha(1.0F);
    }
  }
  
  private static final void b(bf parambf)
  {
    AppMethodBeat.i(361700);
    kotlin.g.b.s.u(parambf, "this$0");
    b.b.a(parambf.nfT, b.c.ner);
    AppMethodBeat.o(361700);
  }
  
  private static final void b(bf parambf, View paramView)
  {
    AppMethodBeat.i(361774);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parambf, "this$0");
    paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
    int i;
    label108:
    bhf localbhf;
    if (paramView != null)
    {
      if (paramView.ZQH == 0)
      {
        i = 1;
        if (i == 0) {
          break label242;
        }
        Log.i(TAG, "teamup_gift_reddot is 0");
      }
    }
    else
    {
      paramView = parambf.Evu;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (paramView != null) {
        break label481;
      }
      i = 0;
      label151:
      ((com.tencent.mm.plugin.finder.live.report.k)localObject1).axu(hS(i, 20));
      localbhf = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
      if (localbhf != null)
      {
        if (localbhf.Edd != 0) {
          break label489;
        }
        i = 1;
        label195:
        if (i == 0) {
          break label494;
        }
        Log.i(TAG, "goMiniApp teamup_gift_status is 0");
      }
    }
    label242:
    long l1;
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361774);
      return;
      i = 0;
      break;
      Log.i(TAG, "gameTeamInfo?.reddot_id is %s", new Object[] { paramView.ZQJ });
      if ((!TextUtils.isEmpty((CharSequence)paramView.ZQJ)) && (parambf.AAN != null) && (n.T(parambf.AAN, paramView.ZQJ, false)))
      {
        Log.i(TAG, "reddot_id is removed");
        break label108;
      }
      if (TextUtils.isEmpty((CharSequence)paramView.ZQJ))
      {
        Log.i(TAG, "reddot_id is empty");
        break label108;
      }
      parambf.AAN = paramView.ZQJ;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adeJ, paramView.ZQJ);
      Log.i(TAG, "doFinderLiveGetTeamupGiftPrepare");
      l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      localObject1 = com.tencent.mm.bx.b.cX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp);
      kotlin.g.b.s.s(localObject1, "copyFrom(basePlugin.busi…:class.java).liveCookies)");
      new aw(l1, l2, (com.tencent.mm.bx.b)localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId, paramView.ZQJ).bFJ().g(bf..ExternalSyntheticLambda19.INSTANCE);
      break label108;
      label481:
      i = paramView.ZQH;
      break label151;
      label489:
      i = 0;
      break label195;
      label494:
      if (localbhf.ZQI == null)
      {
        Log.i(TAG, "goMiniApp teamup_gift_jump_info is null");
      }
      else
      {
        l1 = System.currentTimeMillis();
        if (l1 - parambf.lastClickTime >= 200L) {
          break label545;
        }
        Log.i(TAG, "don't click again in 200ms");
      }
    }
    label545:
    parambf.lastClickTime = l1;
    Object localObject3 = Util.getUuidRandom().toString();
    localObject2 = new g();
    paramView = localbhf.ZQI;
    label582:
    label602:
    label631:
    int j;
    if (paramView == null)
    {
      paramView = "";
      ((g)localObject2).appId = paramView;
      paramView = localbhf.ZQI;
      if (paramView != null) {
        break label1218;
      }
      paramView = "";
      ((g)localObject2).qAF = paramView;
      Object localObject4 = new b();
      paramView = localbhf.ZQI;
      if (paramView != null) {
        break label1239;
      }
      paramView = "";
      ((b)localObject4).EvU = paramView;
      paramView = ah.aiuX;
      ((g)localObject2).qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
      ((g)localObject2).scene = 1177;
      paramView = localbhf.ZQI;
      if (paramView != null) {
        break label1276;
      }
      i = 0;
      label671:
      ((g)localObject2).euz = i;
      paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.euO() != 0)
      {
        paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        ((g)localObject2).euz = com.tencent.mm.plugin.finder.live.utils.a.euO();
      }
      ((g)localObject2).hzx = (":" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC + "::" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).sessionId + ':' + (String)localObject3 + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).hOG + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambf.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edo);
      paramView = parambf.Epc;
      if (paramView != null) {
        break label1284;
      }
      i = -1;
      label857:
      paramView = parambf.Epc;
      if (paramView != null) {
        break label1306;
      }
      j = -1;
      label868:
      localObject1 = HalfScreenConfig.a.raf;
      localObject3 = new HalfScreenConfig.BackgroundShapeConfig(com.tencent.mm.cd.a.bs(parambf.mJe.getContext(), p.c.Edge_1_5_A), true, true, 24);
      localObject4 = parambf.mJe.getContext().getClass().getName();
      kotlin.g.b.s.s(localObject4, "root.context.javaClass.name");
      if (!parambf.CwG.isLandscape()) {
        break label1328;
      }
      paramView = HalfScreenConfig.a.raf;
      label937:
      ((g)localObject2).qAT = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, true, (HalfScreenConfig.BackgroundShapeConfig)localObject3, false, new HalfScreenConfig.CloseWhenClickEmptyAreaConfig((String)localObject4, paramView), HalfScreenConfig.c.rap, false, false, null, HalfScreenConfig.h.raF, false, true, HalfScreenConfig.f.rax, false, null, 0, i, j, false, false, false, null, 11764768);
      ((g)localObject2).qAU = parambf.eBP();
      localObject1 = TAG;
      localObject3 = new StringBuilder("appId:");
      paramView = localbhf.ZQI;
      if (paramView != null) {
        break label1335;
      }
      paramView = null;
      label1031:
      localObject3 = ((StringBuilder)localObject3).append(paramView).append(", path:");
      paramView = localbhf.ZQI;
      if (paramView != null) {
        break label1343;
      }
      paramView = null;
      label1057:
      localObject3 = ((StringBuilder)localObject3).append(paramView).append(", extraData:");
      paramView = localbhf.ZQI;
      if (paramView != null) {
        break label1351;
      }
      paramView = null;
      label1083:
      localObject3 = ((StringBuilder)localObject3).append(paramView).append(", version:");
      paramView = localbhf.ZQI;
      if (paramView != null) {
        break label1373;
      }
      paramView = null;
      label1109:
      Log.i((String)localObject1, paramView);
      localObject1 = TAG;
      paramView = ((g)localObject2).qAG;
      if (paramView != null) {
        break label1384;
      }
    }
    label1218:
    label1239:
    label1373:
    label1384:
    for (paramView = null;; paramView = paramView.toString())
    {
      Log.i((String)localObject1, "open half openHalfScreenMiniProgram nativeExtraData:%s", new Object[] { paramView });
      ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(parambf.mJe.getContext(), (g)localObject2);
      Log.i(TAG, "open half openHalfScreenMiniProgram by launchCommon2");
      parambf.Beb = ((g)localObject2);
      break;
      localObject1 = paramView.appid;
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break label582;
      }
      paramView = "";
      break label582;
      localObject1 = paramView.path;
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break label602;
      }
      paramView = "";
      break label602;
      paramView = paramView.ZIZ;
      if (paramView == null)
      {
        paramView = "";
        break label631;
      }
      localObject1 = paramView.ZV();
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break label631;
      }
      paramView = "";
      break label631;
      label1276:
      i = paramView.version;
      break label671;
      paramView = paramView.rootView;
      if (paramView == null)
      {
        i = -1;
        break label857;
      }
      i = paramView.getHeight();
      break label857;
      paramView = paramView.Gxa;
      if (paramView == null)
      {
        j = -1;
        break label868;
      }
      j = paramView.getWidth();
      break label868;
      paramView = HalfScreenConfig.a.rae;
      break label937;
      paramView = paramView.appid;
      break label1031;
      paramView = paramView.path;
      break label1057;
      paramView = paramView.ZIZ;
      if (paramView == null)
      {
        paramView = null;
        break label1083;
      }
      paramView = paramView.ZV();
      break label1083;
      paramView = Integer.valueOf(paramView.version);
      break label1109;
    }
  }
  
  private static final void b(bf parambf, bhf parambhf, View paramView)
  {
    AppMethodBeat.i(361662);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambf);
    localb.cH(parambhf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambf, "this$0");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adeG, Boolean.TRUE);
    parambf.eBN();
    parambf = com.tencent.mm.plugin.finder.live.report.k.Doi;
    if (parambhf == null) {}
    for (int i = 0;; i = parambhf.Edd)
    {
      parambf.axu(hR(i, 18));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361662);
      return;
    }
  }
  
  private final void b(bha parambha, bhf parambhf)
  {
    AppMethodBeat.i(361406);
    Log.i(TAG, kotlin.g.b.s.X("refreshBottomSheet ", com.tencent.mm.ae.f.dg(parambhf)));
    c(parambhf);
    if (!e(parambhf))
    {
      c(parambha, parambhf);
      AppMethodBeat.o(361406);
      return;
    }
    this.Evy.e(parambha, parambhf);
    AppMethodBeat.o(361406);
  }
  
  private static final boolean b(bf parambf, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(361782);
    kotlin.g.b.s.u(parambf, "this$0");
    if (kotlin.g.b.s.p(paramView, parambf.Evr)) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(361782);
      return false;
      paramView.setAlpha(0.3F);
      continue;
      paramView.performClick();
      paramView.setAlpha(1.0F);
    }
  }
  
  private static final void c(bf parambf, bhf parambhf, View paramView)
  {
    AppMethodBeat.i(361675);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambf);
    localb.cH(parambhf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambf, "this$0");
    kotlin.g.b.s.u(parambhf, "$gameTeamInfo");
    parambf.eBN();
    com.tencent.mm.plugin.finder.live.report.k.Doi.axu(hR(parambhf.Edd, 18));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361675);
  }
  
  private final void c(bha parambha, bhf parambhf)
  {
    Object localObject1 = null;
    AppMethodBeat.i(361426);
    int i = parambha.ZQz;
    int j = parambhf.status;
    TextView localTextView = this.Evj;
    if (localTextView != null) {
      localTextView.setWidth(this.mJe.getContext().getResources().getDimensionPixelOffset(p.c.Edge_23A));
    }
    localTextView = this.Evj;
    if (localTextView != null)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.t.GgN;
      localObject2 = this.mJe.getContext();
      kotlin.g.b.s.s(localObject2, "root.context");
      localTextView.setText((CharSequence)com.tencent.mm.plugin.finder.utils.t.a(parambhf, i, (Context)localObject2));
    }
    localTextView = this.Evj;
    if (localTextView != null) {
      localTextView.setTag(Integer.valueOf(i));
    }
    this.EvD = this.EvE;
    switch (j)
    {
    default: 
      parambha = this.Evj;
      if (parambha != null) {
        parambha.setBackgroundResource(p.d.BzP);
      }
      parambha = this.Evj;
      if (parambha != null) {
        parambha.setOnClickListener(bf..ExternalSyntheticLambda11.INSTANCE);
      }
      d(parambhf);
      AppMethodBeat.o(361426);
      return;
    case 1: 
    case 2: 
      localTextView = this.Evj;
      if (localTextView == null) {}
      for (;;)
      {
        if (localObject1 != null) {
          ((ViewGroup.LayoutParams)localObject1).width = -2;
        }
        localTextView = this.Evj;
        if (localTextView != null) {
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        localObject1 = this.Evj;
        if (localObject1 != null) {
          ((TextView)localObject1).setBackgroundResource(p.d.BzN);
        }
        localObject1 = this.Evj;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(this.mJe.getContext().getResources().getColor(p.b.White));
        }
        localObject1 = this.Evj;
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setOnClickListener(new bf..ExternalSyntheticLambda2(this, i, j, parambha, parambhf));
        break;
        localObject1 = localTextView.getLayoutParams();
      }
    }
    localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
    if (parambhf == null)
    {
      parambha = null;
      label349:
      com.tencent.mm.plugin.finder.live.report.k.a((com.tencent.mm.plugin.finder.live.report.k)localObject1, 21, 0, parambha, 6);
      this.EvD = this.EvF;
      localObject1 = this.Evj;
      if (localObject1 != null)
      {
        if (!a.g(parambhf)) {
          break label529;
        }
        parambha = (CharSequence)parambhf.ZQR;
        label394:
        ((TextView)localObject1).setText(parambha);
      }
      parambha = this.Evj;
      if (parambha != null) {
        parambha.setTextColor(this.mJe.getContext().getResources().getColor(p.b.Bzg));
      }
      parambha = this.Evj;
      if (parambha != null) {
        break label549;
      }
    }
    label529:
    label549:
    for (parambha = null;; parambha = parambha.getLayoutParams())
    {
      if (parambha != null) {
        parambha.width = this.mJe.getContext().getResources().getDimensionPixelOffset(p.c.Edge_30A);
      }
      localObject1 = this.Evj;
      if (localObject1 != null) {
        ((TextView)localObject1).setLayoutParams(parambha);
      }
      parambha = this.Evj;
      if (parambha != null) {
        parambha.setBackground(null);
      }
      parambha = this.Evj;
      if (parambha == null) {
        break;
      }
      parambha.setOnClickListener(new bf..ExternalSyntheticLambda3(this, i, parambhf));
      break;
      parambha = l.a(parambhf);
      break label349;
      parambha = (CharSequence)this.mJe.getContext().getString(p.h.Chi);
      break label394;
    }
  }
  
  private final void c(bhf parambhf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(361484);
    Log.i(TAG, "refreshBottomSheetText gameteam bottomSheet: status:" + parambhf.status + ", title:" + parambhf.title + ", rank:" + parambhf.ZOJ + ", member:" + parambhf.ZQD);
    Object localObject3 = this.Evg;
    Object localObject1;
    label134:
    label167:
    label184:
    int i;
    if (localObject3 != null)
    {
      localObject1 = parambhf.title;
      if (localObject1 == null)
      {
        localObject1 = (CharSequence)"";
        ((TextView)localObject3).setText((CharSequence)localObject1);
      }
    }
    else
    {
      localObject3 = this.Evh;
      if (localObject3 != null)
      {
        localObject1 = parambhf.ZOJ;
        if (localObject1 != null) {
          break label753;
        }
        localObject1 = (CharSequence)"";
        ((TextView)localObject3).setText((CharSequence)localObject1);
      }
      localObject3 = this.Evi;
      if (localObject3 != null)
      {
        localObject1 = parambhf.ZQD;
        if (localObject1 != null) {
          break label761;
        }
        localObject1 = (CharSequence)"";
        ((TextView)localObject3).setText((CharSequence)localObject1);
      }
      localObject1 = this.Evh;
      if (localObject1 != null) {
        break label769;
      }
      localObject1 = null;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label777;
      }
      i = 1;
      label199:
      if (i == 0) {
        break label782;
      }
      localObject1 = this.Evh;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      label218:
      localObject1 = this.Evi;
      if (localObject1 != null) {
        break label799;
      }
      localObject1 = null;
      label229:
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label807;
      }
      i = 1;
      label244:
      if (i == 0) {
        break label812;
      }
      localObject1 = this.Evi;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      label263:
      localObject3 = parambhf.ZQG;
      if (localObject3 != null) {
        break label829;
      }
      localObject1 = null;
      label276:
      if (localObject1 == null)
      {
        localObject1 = this.Evq;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      if (a.g(parambhf))
      {
        localObject1 = this.Evm;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)parambhf.ZQO);
        }
      }
      if (parambhf.Edd != 1) {
        break label1785;
      }
      Log.i(TAG, "show gameteam gift: teamup_gift_desc:" + parambhf.Ede + ", teamup_gift_icon:" + parambhf.ZQK + ", teamup_gift_reddot:" + parambhf.ZQH);
      localObject1 = this.Evr;
      if ((localObject1 == null) || (((FrameLayout)localObject1).getVisibility() != 8)) {
        break label1430;
      }
      i = 1;
      label410:
      if (i != 0) {
        com.tencent.mm.plugin.finder.live.report.k.Doi.axu(hS(parambhf.ZQH, 19));
      }
      localObject1 = this.Evr;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setVisibility(0);
      }
      localObject3 = this.Evw;
      if (localObject3 != null)
      {
        localObject1 = parambhf.Ede;
        if (localObject1 != null) {
          break label1435;
        }
        localObject1 = (CharSequence)"";
        label470:
        ((TextView)localObject3).setText((CharSequence)localObject1);
      }
      localObject1 = this.Evw;
      if (localObject1 != null)
      {
        ((TextView)localObject1).setTextColor(eD(parambhf.ZQL, this.mJe.getContext().getResources().getColor(p.b.ByX)));
        localObject1 = ah.aiuX;
      }
      localObject1 = this.Evx;
      if (localObject1 != null)
      {
        ((WeImageView)localObject1).setIconColor(eD(parambhf.ZQL, this.mJe.getContext().getResources().getColor(p.b.ByX)));
        localObject1 = ah.aiuX;
      }
      localObject1 = this.Evx;
      if (localObject1 != null)
      {
        ((WeImageView)localObject1).setEnableColorFilter(true);
        localObject1 = ah.aiuX;
      }
      if (!TextUtils.isEmpty((CharSequence)parambhf.ZQM)) {
        break label1443;
      }
      localObject1 = this.Evs;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setBackground(this.mJe.getContext().getDrawable(p.d.BAd));
      }
    }
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      Log.i(TAG, "teamup_gift_wording_color:" + parambhf.ZQL + ", teamup_gift_background_color:" + parambhf.ZQM);
      if (TextUtils.isEmpty((CharSequence)parambhf.ZQK)) {
        break label1589;
      }
      localObject3 = parambhf.ZQK;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM);
      localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject4 = com.tencent.mm.plugin.finder.loader.p.eCo();
      localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
      localObject5 = this.Evv;
      if (localObject5 != null) {
        break label1576;
      }
      parambhf = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(361484);
      throw parambhf;
      localObject1 = (CharSequence)localObject1;
      break;
      label753:
      localObject1 = (CharSequence)localObject1;
      break label134;
      label761:
      localObject1 = (CharSequence)localObject1;
      break label167;
      label769:
      localObject1 = ((TextView)localObject1).getText();
      break label184;
      label777:
      i = 0;
      break label199;
      label782:
      localObject1 = this.Evh;
      if (localObject1 == null) {
        break label218;
      }
      ((TextView)localObject1).setVisibility(0);
      break label218;
      label799:
      localObject1 = ((TextView)localObject1).getText();
      break label229;
      label807:
      i = 0;
      break label244;
      label812:
      localObject1 = this.Evi;
      if (localObject1 == null) {
        break label263;
      }
      ((TextView)localObject1).setVisibility(0);
      break label263;
      label829:
      localObject1 = (CharSequence)((cbo)localObject3).icon_url;
      label897:
      label917:
      label933:
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        label853:
        if (i == 0)
        {
          localObject1 = (CharSequence)((cbo)localObject3).aakU;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label991;
          }
          i = 1;
          label881:
          if (i == 0)
          {
            localObject1 = ((cbo)localObject3).aakW;
            if (localObject1 != null) {
              break label996;
            }
            localObject1 = null;
            localObject1 = (CharSequence)localObject1;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label1004;
            }
            i = 1;
            if (i == 0)
            {
              localObject1 = ((cbo)localObject3).aakW;
              if (localObject1 != null) {
                break label1009;
              }
              localObject1 = null;
              localObject1 = (CharSequence)localObject1;
              if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                break label1017;
              }
            }
          }
        }
      }
      label991:
      label996:
      label1004:
      label1009:
      label1017:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1022;
        }
        localObject1 = this.Evq;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = this.Evm;
        if (localObject1 != null) {
          break label1351;
        }
        localObject1 = null;
        break;
        i = 0;
        break label853;
        i = 0;
        break label881;
        localObject1 = ((cbt)localObject1).appid;
        break label897;
        i = 0;
        break label917;
        localObject1 = ((cbt)localObject1).path;
        break label933;
      }
      label1022:
      localObject1 = this.dpM;
      if (localObject1 != null)
      {
        localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject4 = com.tencent.mm.plugin.finder.loader.p.eCl();
        localObject5 = new com.tencent.mm.plugin.finder.loader.s(((cbo)localObject3).icon_url, v.FKY);
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject4).a(localObject5, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExS));
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      localObject1 = this.Evn;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)((cbo)localObject3).aakU);
      }
      localObject1 = this.Evo;
      if (localObject1 != null)
      {
        localObject4 = new StringBuilder();
        localObject5 = ((cbo)localObject3).aakV;
        if (localObject5 != null)
        {
          localObject5 = ((Iterable)localObject5).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((StringBuilder)localObject4).append((String)((Iterator)localObject5).next()).append(" ");
          }
          localObject5 = ah.aiuX;
        }
        localObject5 = ah.aiuX;
        ((TextView)localObject1).setText((CharSequence)((StringBuilder)localObject4).toString());
      }
      localObject1 = this.Evo;
      if (localObject1 != null)
      {
        localObject4 = this.Evo;
        if (localObject4 == null) {
          break label1340;
        }
        localObject4 = ((TextView)localObject4).getText();
        if (localObject4 == null) {
          break label1340;
        }
        if (((CharSequence)localObject4).length() <= 0) {
          break label1335;
        }
        i = 1;
        label1249:
        if (i != 1) {
          break label1340;
        }
        i = 1;
        label1256:
        if (i == 0) {
          break label1345;
        }
      }
      label1335:
      label1340:
      label1345:
      for (i = 0;; i = 8)
      {
        ((TextView)localObject1).setVisibility(i);
        localObject1 = this.Evp;
        if (localObject1 != null)
        {
          ((View)localObject1).setOnTouchListener(new bf..ExternalSyntheticLambda12(this));
          localObject1 = ah.aiuX;
        }
        localObject1 = this.Evp;
        if (localObject1 != null)
        {
          ((View)localObject1).setOnClickListener(new bf..ExternalSyntheticLambda8(this, parambhf));
          localObject1 = ah.aiuX;
        }
        localObject1 = this.Evq;
        if (localObject1 == null) {
          break;
        }
        ((View)localObject1).setVisibility(0);
        break;
        i = 0;
        break label1249;
        i = 0;
        break label1256;
      }
      label1351:
      localObject4 = ((TextView)localObject1).getContext().getString(p.h.Chg);
      kotlin.g.b.s.s(localObject4, "context.getString(R.stri…team_join_desc_with_link)");
      localObject5 = ((TextView)localObject1).getContext().getString(p.h.Chf);
      kotlin.g.b.s.s(localObject5, "context.getString(R.stri…live_team_join_desc_link)");
      com.tencent.mm.pluginsdk.ui.span.p.a(((TextView)localObject1).getContext(), kotlin.a.p.listOf(((cbo)localObject3).aakO), kotlin.g.b.s.X((String)localObject4, localObject5), kotlin.a.p.listOf(localObject5), Boolean.FALSE, (TextView)localObject1);
      localObject3 = ah.aiuX;
      break label276;
      label1430:
      i = 0;
      break label410;
      label1435:
      localObject1 = (CharSequence)localObject1;
      break label470;
      label1443:
      if (this.Evt == null)
      {
        this.Evt = new GradientDrawable();
        localObject1 = this.Evt;
        if (localObject1 != null)
        {
          ((GradientDrawable)localObject1).setShape(0);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.Evt;
        if (localObject1 != null)
        {
          ((GradientDrawable)localObject1).setCornerRadius(this.mJe.getContext().getResources().getDimensionPixelOffset(p.c.Bzl));
          localObject1 = ah.aiuX;
        }
        localObject1 = this.Evt;
        if (localObject1 != null)
        {
          ((GradientDrawable)localObject1).setColor(eD(parambhf.ZQM, this.mJe.getContext().getResources().getColor(p.b.Red_Alpha_0_2)));
          localObject1 = ah.aiuX;
        }
      }
      localObject1 = this.Evs;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setBackground((Drawable)this.Evt);
      }
    }
    label1576:
    ((com.tencent.mm.loader.d)localObject4).a(localObject1, (ImageView)localObject5, (com.tencent.mm.loader.b.e)localObject3);
    label1589:
    if (parambhf.ZQH == 1)
    {
      if (this.AAN == null)
      {
        localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adeJ, "");
        if (localObject1 == null)
        {
          parambhf = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(361484);
          throw parambhf;
        }
        this.AAN = ((String)localObject1);
      }
      if (parambhf == null)
      {
        localObject1 = null;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (this.AAN == null)) {
          break label1742;
        }
        localObject1 = this.AAN;
        if (parambhf != null) {
          break label1734;
        }
      }
      label1734:
      for (parambhf = localObject2;; parambhf = parambhf.ZQJ)
      {
        if (!n.T((String)localObject1, parambhf, false)) {
          break label1742;
        }
        Log.i(TAG, "reddotId is removed");
        parambhf = this.Evu;
        if (parambhf == null) {
          break label1809;
        }
        parambhf.setVisibility(8);
        AppMethodBeat.o(361484);
        return;
        localObject1 = parambhf.ZQJ;
        break;
      }
      label1742:
      parambhf = this.Evu;
      if (parambhf != null)
      {
        parambhf.setVisibility(0);
        AppMethodBeat.o(361484);
      }
    }
    else
    {
      parambhf = this.Evu;
      if (parambhf != null)
      {
        parambhf.setVisibility(8);
        AppMethodBeat.o(361484);
        return;
        label1785:
        Log.i(TAG, "hide gift container");
        parambhf = this.Evr;
        if (parambhf != null) {
          parambhf.setVisibility(8);
        }
      }
    }
    label1809:
    AppMethodBeat.o(361484);
  }
  
  private static final void d(bf parambf, bhf parambhf, View paramView)
  {
    AppMethodBeat.i(361732);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambhf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parambf, "this$0");
    kotlin.g.b.s.u(parambhf, "$gameTeamInfo");
    paramView = parambhf.ZQG;
    label113:
    int i;
    label130:
    label169:
    label210:
    int j;
    label222:
    String str;
    if (paramView == null)
    {
      paramView = null;
      if (paramView != null)
      {
        localObject1 = new g();
        paramView = parambhf.ZQG;
        if (paramView != null) {
          break label435;
        }
        paramView = null;
        ((g)localObject1).appId = paramView;
        paramView = parambhf.ZQG;
        if (paramView != null) {
          break label457;
        }
        i = 0;
        ((g)localObject1).euz = i;
        paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.euO() != 0)
        {
          paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          ((g)localObject1).euz = com.tencent.mm.plugin.finder.live.utils.a.euO();
        }
        paramView = parambhf.ZQG;
        if (paramView != null) {
          break label479;
        }
        paramView = null;
        ((g)localObject1).qAF = paramView;
        ((g)localObject1).scene = 1205;
        ((g)localObject1).qAG = ((com.tencent.mm.plugin.appbrand.api.d)new h(parambhf));
        parambhf = parambf.Epc;
        if (parambhf != null) {
          break label501;
        }
        i = -1;
        parambhf = parambf.Epc;
        if (parambhf != null) {
          break label523;
        }
        j = -1;
        paramView = HalfScreenConfig.a.raf;
        localObject2 = new HalfScreenConfig.BackgroundShapeConfig(com.tencent.mm.cd.a.bs(parambf.mJe.getContext(), p.c.Edge_1_5_A), true, true, 24);
        str = parambf.mJe.getContext().getClass().getName();
        kotlin.g.b.s.s(str, "root.context.javaClass.name");
        if (!parambf.CwG.isLandscape()) {
          break label547;
        }
      }
    }
    label523:
    label547:
    for (parambhf = HalfScreenConfig.a.raf;; parambhf = HalfScreenConfig.a.rae)
    {
      ((g)localObject1).qAT = new HalfScreenConfig(true, i, paramView, true, (HalfScreenConfig.BackgroundShapeConfig)localObject2, false, new HalfScreenConfig.CloseWhenClickEmptyAreaConfig(str, parambhf), HalfScreenConfig.c.rap, false, false, null, HalfScreenConfig.h.raF, false, true, HalfScreenConfig.f.rax, false, null, 0, i, j, false, false, false, null, 11764768);
      ((g)localObject1).qAU = parambf.eBP();
      ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(parambf.mJe.getContext(), (g)localObject1);
      parambf.Beb = ((g)localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361732);
      return;
      paramView = paramView.aakW;
      if (paramView == null)
      {
        paramView = null;
        break;
      }
      paramView = paramView.appid;
      break;
      label435:
      paramView = paramView.aakW;
      if (paramView == null)
      {
        paramView = null;
        break label113;
      }
      paramView = paramView.appid;
      break label113;
      label457:
      paramView = paramView.aakW;
      if (paramView == null)
      {
        i = 0;
        break label130;
      }
      i = paramView.Tqb;
      break label130;
      label479:
      paramView = paramView.aakW;
      if (paramView == null)
      {
        paramView = null;
        break label169;
      }
      paramView = paramView.path;
      break label169;
      label501:
      parambhf = parambhf.rootView;
      if (parambhf == null)
      {
        i = -1;
        break label210;
      }
      i = parambhf.getHeight();
      break label210;
      parambhf = parambhf.Gxa;
      if (parambhf == null)
      {
        j = -1;
        break label222;
      }
      j = parambhf.getWidth();
      break label222;
    }
  }
  
  private final void d(bhf parambhf)
  {
    AppMethodBeat.i(361497);
    Log.i(TAG, "gameteam refreshBtnState " + parambhf.ZOK + ", " + parambhf.status + ", " + e(parambhf));
    if ((e(parambhf)) || ((parambhf.status != 1) && (parambhf.status != 2)))
    {
      AppMethodBeat.o(361497);
      return;
    }
    if (parambhf.ZOK == 1)
    {
      parambhf = this.Evj;
      if (parambhf != null) {
        parambhf.setBackgroundResource(p.d.BzN);
      }
      parambhf = this.Evj;
      if (parambhf != null)
      {
        parambhf.setClickable(true);
        AppMethodBeat.o(361497);
      }
    }
    else
    {
      parambhf = this.Evj;
      if (parambhf != null) {
        parambhf.setBackgroundResource(p.d.BzP);
      }
      parambhf = this.Evj;
      if (parambhf != null) {
        parambhf.setClickable(false);
      }
    }
    AppMethodBeat.o(361497);
  }
  
  private static boolean e(bhf parambhf)
  {
    if (parambhf.ZQG != null)
    {
      Object localObject = parambhf.ZQG;
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label55;
        }
        parambhf = parambhf.ZQG;
        if (parambhf != null) {
          break label47;
        }
      }
      label47:
      for (int i = -1;; i = parambhf.aakX)
      {
        if (i <= 0) {
          break label55;
        }
        return true;
        localObject = ((cbo)localObject).ZUh;
        break;
      }
    }
    label55:
    return false;
  }
  
  private final boolean eBK()
  {
    AppMethodBeat.i(361437);
    if ((EvP != 0L) && (EvP == ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId))
    {
      AppMethodBeat.o(361437);
      return true;
    }
    AppMethodBeat.o(361437);
    return false;
  }
  
  private final void eBL()
  {
    AppMethodBeat.i(361444);
    View localView = this.mJe.findViewById(p.e.BVr);
    WeImageView localWeImageView = (WeImageView)this.mJe.findViewById(p.e.BVs);
    if (localWeImageView != null) {
      localWeImageView.setIconColor(this.mJe.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_9));
    }
    if (localView != null) {
      localView.setBackground(this.mJe.getContext().getResources().getDrawable(p.d.BAm));
    }
    AppMethodBeat.o(361444);
  }
  
  private final void eBM()
  {
    AppMethodBeat.i(361449);
    View localView = this.mJe.findViewById(p.e.BVr);
    WeImageView localWeImageView = (WeImageView)this.mJe.findViewById(p.e.BVs);
    if (localWeImageView != null) {
      localWeImageView.setIconColor(this.mJe.getContext().getResources().getColor(p.b.white_text_color));
    }
    if (localView != null) {
      localView.setBackground(this.mJe.getContext().getResources().getDrawable(p.d.BAl));
    }
    AppMethodBeat.o(361449);
  }
  
  private final void eBN()
  {
    AppMethodBeat.i(361454);
    this.EvA = false;
    this.EvB = false;
    b.b.a(this.nfT, b.c.nfj);
    AppMethodBeat.o(361454);
  }
  
  private final void eBO()
  {
    AppMethodBeat.i(361456);
    this.EvI = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edl;
    Log.i(TAG, "set lastGameInvitationSeq to :%d", new Object[] { Long.valueOf(this.EvI) });
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edm = this.EvI;
    AppMethodBeat.o(361456);
  }
  
  private final com.tencent.mm.plugin.appbrand.api.i eBP()
  {
    AppMethodBeat.i(361532);
    com.tencent.mm.plugin.appbrand.api.i locali = (com.tencent.mm.plugin.appbrand.api.i)new f(this);
    AppMethodBeat.o(361532);
    return locali;
  }
  
  private static int eD(String paramString, int paramInt)
  {
    AppMethodBeat.i(361553);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(361553);
      return paramInt;
    }
    paramInt = com.tencent.mm.plugin.appbrand.af.i.dq(paramString, paramInt);
    AppMethodBeat.o(361553);
    return paramInt;
  }
  
  private final void gI(Context paramContext)
  {
    AppMethodBeat.i(361515);
    this.Epc = new com.tencent.mm.ui.widget.a.h(paramContext, 0, true, true);
    com.tencent.mm.ui.widget.a.h localh = this.Epc;
    if (localh != null)
    {
      localh = localh.aFa(p.f.CdQ);
      if (localh != null)
      {
        localh.rootView.findViewById(p.e.BLc).setOnClickListener(new bf..ExternalSyntheticLambda10(localh, this));
        this.Evg = ((TextView)localh.rootView.findViewById(p.e.BLd));
        this.Evh = ((TextView)localh.rootView.findViewById(p.e.BLe));
        this.Evi = ((TextView)localh.rootView.findViewById(p.e.BLf));
        this.Evj = ((TextView)localh.rootView.findViewById(p.e.BKV));
        Object localObject = com.tencent.mm.plugin.finder.accessibility.a.Ate;
        float f = com.tencent.mm.plugin.finder.accessibility.a.g(paramContext, 17.0F);
        paramContext = this.Evj;
        if (paramContext != null) {
          paramContext.setTextSize(1, f);
        }
        this.Evk = ((ViewGroup)localh.rootView.findViewById(p.e.BXT));
        paramContext = localh.rootView.findViewById(p.e.BBQ);
        localObject = ah.aiuX;
        this.Evm = ((TextView)paramContext);
        this.Evn = ((TextView)localh.rootView.findViewById(p.e.BQw));
        this.Evo = ((TextView)localh.rootView.findViewById(p.e.BQy));
        this.dpM = ((ImageView)localh.rootView.findViewById(p.e.BQx));
        this.Evl = ((TextView)localh.rootView.findViewById(p.e.BLg));
        this.Evp = localh.rootView.findViewById(p.e.BVx);
        this.Evq = localh.rootView.findViewById(p.e.BVw);
        localh.rootView.setBackground(null);
        this.Evr = ((FrameLayout)localh.rootView.findViewById(p.e.BKZ));
        this.Evs = ((LinearLayout)localh.rootView.findViewById(p.e.BKY));
        this.Evu = ((FrameLayout)localh.rootView.findViewById(p.e.BLa));
        this.Evv = ((MMRoundCornerImageView)localh.rootView.findViewById(p.e.BKX));
        this.Evw = ((TextView)localh.rootView.findViewById(p.e.BLb));
        this.Evx = ((WeImageView)localh.rootView.findViewById(p.e.BKW));
        paramContext = this.Evr;
        if (paramContext != null) {
          paramContext.setVisibility(8);
        }
        paramContext = this.Evr;
        if (paramContext != null) {
          paramContext.setOnClickListener(new bf..ExternalSyntheticLambda1(this));
        }
        paramContext = this.Evr;
        if (paramContext != null) {
          paramContext.setOnTouchListener(new bf..ExternalSyntheticLambda13(this));
        }
        paramContext = this.Evu;
        if (paramContext != null) {
          paramContext.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(361515);
  }
  
  private static final void gt(View paramView)
  {
    AppMethodBeat.i(361636);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361636);
  }
  
  private static final ah h(b.a parama)
  {
    AppMethodBeat.i(361799);
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      Log.i(TAG, "ljd do CgiAudienceSendCommentToReserveGame success");
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(361799);
      return parama;
      Log.e(TAG, "ljd do CgiAudienceSendCommentToReserveGame fail errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg });
    }
  }
  
  private static String hR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(361538);
    Object localObject = new com.tencent.mm.ad.i();
    ((com.tencent.mm.ad.i)localObject).n("gift", Integer.valueOf(paramInt1));
    ((com.tencent.mm.ad.i)localObject).n("type", Integer.valueOf(paramInt2));
    localObject = ((com.tencent.mm.ad.i)localObject).toString();
    kotlin.g.b.s.s(localObject, "obj.toString()");
    AppMethodBeat.o(361538);
    return localObject;
  }
  
  private static String hS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(361542);
    Object localObject = new com.tencent.mm.ad.i();
    ((com.tencent.mm.ad.i)localObject).n("reddot", Integer.valueOf(paramInt1));
    ((com.tencent.mm.ad.i)localObject).n("type", Integer.valueOf(paramInt2));
    localObject = ((com.tencent.mm.ad.i)localObject).toString();
    kotlin.g.b.s.s(localObject, "obj.toString()");
    AppMethodBeat.o(361542);
    return localObject;
  }
  
  private static final ah i(b.a parama)
  {
    AppMethodBeat.i(361808);
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      Log.i(TAG, "ljd do CgiFinderLiveRespondGameInvitation success");
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(361808);
      return parama;
      Log.e(TAG, "ljd do CgiFinderLiveRespondGameInvitation fail errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg });
    }
  }
  
  private static final ah j(b.a parama)
  {
    AppMethodBeat.i(361817);
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      Log.i(TAG, "ljd do doFinderLiveGetTeamupGiftPrepare success");
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(361817);
      return parama;
      Log.e(TAG, "ljd do doFinderLiveGetTeamupGiftPrepare fail errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg });
    }
  }
  
  public final void Qn(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(362080);
    bhf localbhf;
    bha localbha;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    label179:
    label191:
    String str;
    boolean bool;
    if (eBK())
    {
      localbhf = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
      localbha = EvS;
      localObject3 = TAG;
      localObject4 = new StringBuilder("checkCanJumpGame lastLiveId:").append(EvP).append(", curMode:").append(paramInt).append(", lastClickGameTeamMode:").append(EvQ).append(", lastClickGameInfo:");
      if (localbha == null)
      {
        localObject1 = null;
        localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", gameTeamInfo:");
        if (localbhf != null) {
          break label179;
        }
      }
      for (localObject1 = localObject2;; localObject1 = Integer.valueOf(localbhf.ZOK))
      {
        Log.i((String)localObject3, localObject1);
        if ((paramInt == EvQ) && (EvQ != 0) && (EvQ != 1) && (localbha != null) && (localbhf != null)) {
          break label191;
        }
        AppMethodBeat.o(362080);
        return;
        localObject1 = localbha.Idi;
        break;
      }
      this.EvL = true;
      localObject3 = this.CwG;
      localObject4 = this.mJe.getContext();
      kotlin.g.b.s.s(localObject4, "root.context");
      str = EvR;
      localObject1 = com.tencent.mm.plugin.finder.utils.t.GgN;
      bool = a.g(localbhf);
      paramInt = EvQ;
      if (!a.g(localbhf)) {
        break label337;
      }
      localObject1 = localbhf.ZQP;
      if (localObject1 != null) {
        break label316;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localObject2 = this.mJe.getContext();
      kotlin.g.b.s.s(localObject2, "root.context");
      a.a((com.tencent.mm.plugin.finder.live.plugin.b)localObject3, (Context)localObject4, localbha, localbhf, str, com.tencent.mm.plugin.finder.utils.t.a(bool, paramInt, (String)localObject1, (Context)localObject2), (c)new e(this));
      AppMethodBeat.o(362080);
      return;
      label316:
      localObject2 = ((gfi)localObject1).xlJ;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = "";
        continue;
        label337:
        localObject2 = localbha.Idi;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  public final void Qo(int paramInt)
  {
    com.tencent.mm.plugin.finder.live.report.k localk1 = null;
    com.tencent.mm.plugin.finder.live.report.k localk2 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(362116);
    bhf localbhf = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(362116);
      return;
    case 7: 
      localk1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (localbhf == null) {}
      for (localObject1 = null;; localObject1 = l.a(localbhf))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(localk1, 24, 0, (String)localObject1, 6);
        AppMethodBeat.o(362116);
        return;
      }
    case 2: 
      localk1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (localbhf == null) {}
      for (;;)
      {
        com.tencent.mm.plugin.finder.live.report.k.a(localk1, 10, 0, (String)localObject1, 6);
        AppMethodBeat.o(362116);
        return;
        localObject1 = l.a(localbhf);
      }
    case 3: 
      localk2 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (localbhf == null) {}
      for (localObject1 = localk1;; localObject1 = l.a(localbhf))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(localk2, 12, 0, (String)localObject1, 6);
        AppMethodBeat.o(362116);
        return;
      }
    case 4: 
      localk1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (localbhf == null) {}
      for (localObject1 = localk2;; localObject1 = l.a(localbhf))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(localk1, 8, 0, (String)localObject1, 6);
        AppMethodBeat.o(362116);
        return;
      }
    case 5: 
      localk1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (localbhf == null) {}
      for (localObject1 = localObject2;; localObject1 = l.a(localbhf))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(localk1, 6, 0, (String)localObject1, 6);
        AppMethodBeat.o(362116);
        return;
      }
    }
    localk1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
    if (localbhf == null) {}
    for (localObject1 = localObject3;; localObject1 = l.a(localbhf))
    {
      com.tencent.mm.plugin.finder.live.report.k.a(localk1, 4, 0, (String)localObject1, 6);
      break;
    }
  }
  
  public final void Qp(int paramInt)
  {
    AppMethodBeat.i(362127);
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edk;
    if (localObject == null)
    {
      AppMethodBeat.o(362127);
      return;
    }
    Log.i(TAG, "doFinderLiveRespondGameInvitation");
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    String str2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
    String str1 = ((bee)localObject).AzS;
    localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    new ai(l1, l2, str2, (String)localObject, paramInt).bFJ().g(bf..ExternalSyntheticLambda17.INSTANCE);
    AppMethodBeat.o(362127);
  }
  
  public final void at(Bundle paramBundle)
  {
    AppMethodBeat.i(362121);
    Object localObject;
    long l1;
    if (paramBundle == null)
    {
      localObject = null;
      Log.i(TAG, "ljd notifySendMsgResult sessionId:%d", new Object[] { localObject });
      l1 = this.sessionId;
      if (localObject != null) {
        break label87;
      }
    }
    label87:
    while (((Long)localObject).longValue() != l1)
    {
      Log.e(TAG, "sessionId error, not match, current sessionId:%s", new Object[] { Long.valueOf(this.sessionId) });
      AppMethodBeat.o(362121);
      return;
      localObject = Long.valueOf(paramBundle.getLong("PARAM_FINDER_LIVE_SEND_MSG_SESSION_ID", 0L));
      break;
    }
    this.sessionId = 0L;
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      localObject = com.tencent.mm.bx.b.cX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp);
      kotlin.g.b.s.s(localObject, "copyFrom(basePlugin.busi…:class.java).liveCookies)");
      new com.tencent.mm.plugin.finder.cgi.a(l1, l2, (com.tencent.mm.bx.b)localObject, paramBundle, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC).bFJ().g(bf..ExternalSyntheticLambda18.INSTANCE);
      AppMethodBeat.o(362121);
      return;
      localObject = paramBundle.getString("PARAM_FINDER_LIVE_NOTIFY_SEND_MSG_CONTENT");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
    }
  }
  
  public final void ayE(String paramString)
  {
    AppMethodBeat.i(362087);
    Log.i(TAG, kotlin.g.b.s.X("checkHighlightBtn, from:", paramString));
    paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
    this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if ((paramString != null) && (paramString.ZOK == 1)) {}
    for (int i = 1; (i != 0) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edi); i = 0)
    {
      eBL();
      AppMethodBeat.o(362087);
      return;
    }
    eBM();
    AppMethodBeat.o(362087);
  }
  
  public final void d(bha parambha, bhf parambhf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(362100);
    Object localObject1 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
    label72:
    cbo localcbo;
    int i;
    label177:
    int j;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((ae)localObject1).setMListener(new bf..ExternalSyntheticLambda4(this, parambha, parambhf));
      }
      parambha = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
      if (parambha != null) {
        break label427;
      }
      parambha = null;
      if (parambha != null) {
        parambha.setMCloseListener(new bf..ExternalSyntheticLambda6(this, parambhf));
      }
      parambha = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
      if (parambha != null)
      {
        parambha = parambha.CZo;
        if (parambha != null) {
          parambha.bE(parambhf.title, false);
        }
      }
      parambha = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
      if (parambha != null)
      {
        parambha = parambha.CZo;
        if (parambha != null)
        {
          localObject1 = parambhf.ZQD;
          String str = parambhf.ZQQ;
          localcbo = parambhf.ZQG;
          if (localcbo != null) {
            break label435;
          }
          i = 0;
          parambha.Z((String)localObject1, str, i);
        }
      }
      j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edd;
      parambha = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ede;
      if (j != 0) {
        break label505;
      }
      if ((parambhf == null) || (parambhf.Edd != 1)) {
        break label444;
      }
      i = 1;
      label240:
      if (i == 0) {
        break label505;
      }
      if (parambhf != null) {
        break label449;
      }
      parambha = null;
      label250:
      i = parambha.intValue();
      if (parambhf != null) {
        break label460;
      }
      parambha = localObject2;
    }
    for (;;)
    {
      label262:
      Log.i(TAG, "show guide, " + parambhf.title + ' ' + parambhf.ZQD + " teamup_gift_status:" + i);
      if (i == 1)
      {
        parambhf = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (parambhf != null)
        {
          parambhf = parambhf.CZo;
          if (parambhf != null) {
            parambhf.setGiftTitle(parambha);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.finder.live.report.k.Doi.axu(hR(i, 17));
        this.EvB = true;
        this.EvA = false;
        parambha = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (parambha != null)
        {
          parambha = parambha.CZo;
          if (parambha != null) {
            parambha.eAO();
          }
        }
        b.b.a(this.nfT, b.c.nfi);
        AppMethodBeat.o(362100);
        return;
        localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).CZo;
        break;
        label427:
        parambha = parambha.CZo;
        break label72;
        label435:
        i = localcbo.aakX;
        break label177;
        label444:
        i = 0;
        break label240;
        label449:
        parambha = Integer.valueOf(parambhf.Edd);
        break label250;
        label460:
        parambha = parambhf.Ede;
        break label262;
        parambha = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (parambha != null)
        {
          parambha = parambha.CZo;
          if (parambha != null) {
            parambha.setGiftTitle("");
          }
        }
      }
      label505:
      i = j;
    }
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(362069);
    Object localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFy;
    Object localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
    Object localObject4 = TAG;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject1 = null;
      Log.i((String)localObject4, kotlin.g.b.s.X("checkVisible gameInfo last:", localObject1));
      if ((localObject2 != null) && (((bha)localObject2).ZQz != 0) && (((bha)localObject2).ZQz != 1) && (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())) {
        break label432;
      }
      this.mJe.setVisibility(8);
      this.EvC = false;
      localObject1 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
      if (localObject1 != null) {
        break label393;
      }
      bool1 = false;
      label144:
      if (bool1)
      {
        localObject1 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).CZo;
          if (localObject1 != null) {
            ((ae)localObject1).eAP();
          }
        }
        eBN();
      }
      localObject1 = this.Epc;
      if ((localObject1 == null) || (((com.tencent.mm.ui.widget.a.h)localObject1).isShowing() != true)) {
        break label427;
      }
    }
    long l;
    label393:
    label427:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = this.Epc;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.h)localObject1).cyW();
        }
        aa.dc(this.mJe.getContext(), com.tencent.mm.cd.a.bt(this.mJe.getContext(), p.h.finder_game_live_team_join_off));
      }
      a.ayG("CheckVisibleGone");
      if ((localObject2 == null) || (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())) {
        break label2402;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edk;
      l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edl;
      if (this.EvI == 0L) {
        this.EvI = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edm;
      }
      Log.i(TAG, "checkGameInvitation");
      if (!this.EvL) {
        break label1583;
      }
      Log.i(TAG, "showing jump game team dialog");
      AppMethodBeat.o(362069);
      return;
      localObject1 = Integer.valueOf(((bha)localObject2).ZQz);
      break;
      localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).CZo;
      if (localObject1 == null)
      {
        bool1 = false;
        break label144;
      }
      bool1 = kotlin.g.b.s.p(((ae)localObject1).eAN(), Boolean.TRUE);
      break label144;
    }
    label432:
    label455:
    int j;
    label580:
    label600:
    int k;
    if (this.mJe.getVisibility() != 0)
    {
      localObject4 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (localObject3 == null)
      {
        localObject1 = null;
        com.tencent.mm.plugin.finder.live.report.k.a((com.tencent.mm.plugin.finder.live.report.k)localObject4, 1, 0, (String)localObject1, 6);
      }
    }
    else
    {
      ayE("checkVisible");
      com.tencent.mm.pluginsdk.model.app.h.a(((bha)localObject2).Idh, ((bha)localObject2).xlr, null);
      this.mJe.setVisibility(0);
      if (this.mJe.getVisibility() == 0)
      {
        Log.i(TAG, "checkShowGuide");
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
        if (localObject1 != null)
        {
          j = ((bhf)localObject1).status;
          boolean bool2 = this.EvC;
          if ((((bhf)localObject1).ZOK != 1) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edi)) {
            break label722;
          }
          bool1 = true;
          this.EvC = bool1;
          if ((bool2) || (!this.EvC)) {
            break label728;
          }
          i = 1;
          k = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edd;
          localObject4 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adeG, Boolean.FALSE);
          if ((((bhf)localObject1).ZOK != 1) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edi) || (this.EvB) || (i == 0)) {
            break label733;
          }
          Log.i(TAG, "do preload CgiFinderLiveGetGameTeamInfo");
          Qm(this.EvM);
        }
      }
    }
    label722:
    label728:
    label733:
    do
    {
      do
      {
        for (;;)
        {
          this.mJe.setOnClickListener(new bf..ExternalSyntheticLambda9((bhf)localObject3, this, (bha)localObject2));
          break;
          localObject1 = l.a((bhf)localObject3);
          break label455;
          bool1 = false;
          break label580;
          i = 0;
          break label600;
          if (((j != 3) && (j != 4) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edi) && (((bhf)localObject1).ZOK != 0)) || (!this.EvB)) {
            break label831;
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).CZo;
            if (localObject1 != null) {
              ((ae)localObject1).eAP();
            }
          }
          this.EvB = false;
          Log.i(TAG, "status is Team_Full or Not_In_Team_Up, hide join game guide");
        }
        if (!this.EvB) {
          break label1002;
        }
        Log.i(TAG, "showing join game guide， title:%s, info teamup_gift_status:%d, msg teamup_gift_status:%d", new Object[] { ((bhf)localObject1).title, Integer.valueOf(((bhf)localObject1).Edd), Integer.valueOf(k) });
        localObject4 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject4).CZo;
          if (localObject4 != null) {
            ((ae)localObject4).bE(((bhf)localObject1).title, false);
          }
        }
        localObject4 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
      } while (localObject4 == null);
      localObject4 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject4).CZo;
    } while (localObject4 == null);
    label831:
    Object localObject5 = ((bhf)localObject1).ZQD;
    String str = ((bhf)localObject1).ZQQ;
    Object localObject1 = ((bhf)localObject1).ZQG;
    if (localObject1 == null) {}
    for (i = 0;; i = ((cbo)localObject1).aakX)
    {
      ((ae)localObject4).Z((String)localObject5, str, i);
      break;
    }
    label1002:
    if (localObject4 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(362069);
      throw ((Throwable)localObject1);
    }
    if ((!((Boolean)localObject4).booleanValue()) && (!this.EvA) && (!this.EvC))
    {
      Log.i(TAG, "show new guide");
      localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
      localObject1 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        label1103:
        if (localObject1 != null) {
          ((ae)localObject1).setMListener(new bf..ExternalSyntheticLambda7(this, (bhf)localObject4));
        }
        localObject1 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (localObject1 != null) {
          break label1487;
        }
        localObject1 = null;
        label1146:
        if (localObject1 != null) {
          ((ae)localObject1).setMCloseListener(new bf..ExternalSyntheticLambda5(this, (bhf)localObject4));
        }
        localObject1 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).CZo;
          if (localObject1 != null)
          {
            localObject5 = this.mJe.getContext();
            if (!a.g((bhf)localObject4)) {
              break label1497;
            }
            i = p.h.Chx;
            label1219:
            ((ae)localObject1).bE(((Context)localObject5).getString(i), true);
          }
        }
        localObject1 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).CZo;
          if (localObject1 != null) {
            ((ae)localObject1).Z("", null, 0);
          }
        }
        j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edd;
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ede;
        if (j != 0) {
          break label2418;
        }
        if ((localObject4 == null) || (((bhf)localObject4).Edd != 1)) {
          break label1504;
        }
        i = 1;
        label1328:
        if (i == 0) {
          break label2418;
        }
        i = ((bhf)localObject4).Edd;
        localObject1 = ((bhf)localObject4).Ede;
      }
    }
    for (;;)
    {
      Log.i(TAG, kotlin.g.b.s.X("teamup_gift_status:", Integer.valueOf(i)));
      if (i == 1)
      {
        localObject4 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject4).CZo;
          if (localObject4 != null) {
            ((ae)localObject4).setGiftTitle((String)localObject1);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.finder.live.report.k.Doi.axu(hR(i, 17));
        this.EvA = true;
        this.EvB = false;
        localObject1 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).CZo;
          if (localObject1 != null) {
            ((ae)localObject1).eAO();
          }
        }
        b.b.a(this.nfT, b.c.nfi);
        break;
        localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).CZo;
        break label1103;
        label1487:
        localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).CZo;
        break label1146;
        label1497:
        i = p.h.Chh;
        break label1219;
        label1504:
        i = 0;
        break label1328;
        localObject1 = (com.tencent.mm.plugin.finder.live.plugin.aq)this.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aq.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).CZo;
          if (localObject1 != null) {
            ((ae)localObject1).setGiftTitle("");
          }
        }
      }
      if (this.EvA)
      {
        Log.i(TAG, "showing new guide");
        break;
      }
      Log.i(TAG, "checkShowGuide, do nothing");
      break;
      label1583:
      if (this.EvK)
      {
        Log.i(TAG, "showing jump game invitation dialog");
        AppMethodBeat.o(362069);
        return;
      }
      if (localObject2 == null)
      {
        Log.i(TAG, "game invitation is null");
        AppMethodBeat.o(362069);
        return;
      }
      if ((this.EvJ) && (this.EvH != null) && (this.EvI == l))
      {
        Log.i(TAG, "showing the same game invitation");
        AppMethodBeat.o(362069);
        return;
      }
      if ((this.EvJ) && (this.EvH != null) && (this.EvI != l))
      {
        Log.i(TAG, "showing game invitation, but info diff");
        localObject1 = this.Epc;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.h)localObject1).cyW();
        }
        localObject1 = this.mJe.getContext();
        kotlin.g.b.s.s(localObject1, "root.context");
        gI((Context)localObject1);
        Log.i(TAG, "checkGameInvitation gameInvitation bottomSheet: invitation_id:" + ((bee)localObject2).AzS + ", title:" + ((bee)localObject2).title + ", sub_title:" + ((bee)localObject2).wsz + ", wording:" + ((bee)localObject2).wording);
        localObject3 = this.Evg;
        if (localObject3 != null)
        {
          localObject1 = ((bee)localObject2).title;
          if (localObject1 != null) {
            break label2337;
          }
          localObject1 = (CharSequence)"";
          label1839:
          ((TextView)localObject3).setText((CharSequence)localObject1);
        }
        localObject3 = this.Evh;
        if (localObject3 != null)
        {
          localObject1 = ((bee)localObject2).wsz;
          if (localObject1 != null) {
            break label2347;
          }
          localObject1 = (CharSequence)"";
          label1877:
          ((TextView)localObject3).setText((CharSequence)localObject1);
        }
        localObject3 = this.Evi;
        if (localObject3 != null)
        {
          localObject1 = ((bee)localObject2).wording;
          if (localObject1 != null) {
            break label2357;
          }
          localObject1 = (CharSequence)"";
          label1915:
          ((TextView)localObject3).setText((CharSequence)localObject1);
        }
        localObject1 = this.Evh;
        if (localObject1 != null) {
          break label2367;
        }
        localObject1 = null;
        label1936:
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label2377;
        }
        i = 1;
        label1953:
        if (i == 0) {
          break label2382;
        }
        localObject1 = this.Evh;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
      for (;;)
      {
        localObject1 = this.Evq;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        this.EvD = this.EvG;
        localObject1 = this.Evj;
        if (localObject1 != null) {
          ((TextView)localObject1).setBackgroundResource(p.d.BzN);
        }
        localObject1 = this.Evj;
        if (localObject1 != null) {
          ((TextView)localObject1).setClickable(true);
        }
        localObject1 = this.Evj;
        if (localObject1 != null) {
          ((TextView)localObject1).setWidth(this.mJe.getContext().getResources().getDimensionPixelOffset(p.c.Edge_23A));
        }
        localObject1 = this.Evj;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)this.mJe.getContext().getString(p.h.CgO));
        }
        localObject1 = this.Evj;
        if (localObject1 != null) {
          ((TextView)localObject1).setBackgroundResource(p.d.BzN);
        }
        localObject1 = this.Evj;
        if (localObject1 != null) {
          ((TextView)localObject1).setOnClickListener(new bf..ExternalSyntheticLambda0(this));
        }
        this.EvH = ((bee)localObject2);
        this.EvI = l;
        localObject1 = this.Epc;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.h)localObject1).dDn();
        }
        this.EvJ = true;
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 14, 0, null, 14);
        AppMethodBeat.o(362069);
        return;
        if (((this.EvH != null) && (this.EvI == l)) || ((this.EvH == null) && (this.EvI == l) && (this.EvI > 0L)))
        {
          Log.i(TAG, "don't show same game invitation again");
          Log.i(TAG, "lastGameInvitationSeq:%d, gameInvitationInfoSeq:%d", new Object[] { Long.valueOf(this.EvI), Long.valueOf(l) });
          AppMethodBeat.o(362069);
          return;
        }
        Log.i(TAG, "show game invitation");
        Log.i(TAG, "lastGameInvitationSeq:%d, gameInvitationInfoSeq:%d", new Object[] { Long.valueOf(this.EvI), Long.valueOf(l) });
        Qm(this.EvN);
        break;
        label2337:
        localObject1 = (CharSequence)localObject1;
        break label1839;
        label2347:
        localObject1 = (CharSequence)localObject1;
        break label1877;
        label2357:
        localObject1 = (CharSequence)localObject1;
        break label1915;
        label2367:
        localObject1 = ((TextView)localObject1).getText();
        break label1936;
        label2377:
        i = 0;
        break label1953;
        label2382:
        localObject1 = this.Evh;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
      }
      label2402:
      Log.e(TAG, "gameInfo is null or is isTeenMode");
      AppMethodBeat.o(362069);
      return;
      label2418:
      i = j;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(362106);
    Log.i(TAG, kotlin.g.b.s.X("onResume ", this.EvO));
    Object localObject = this.EvO;
    if (localObject != null) {
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label181;
        }
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
        long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
        localObject = com.tencent.mm.bx.b.cX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp);
        kotlin.g.b.s.s(localObject, "copyFrom(basePlugin.busi…:class.java).liveCookies)");
        new m(l1, l2, (com.tencent.mm.bx.b)localObject, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId).bFJ().g(new bf..ExternalSyntheticLambda14(this));
      }
      AppMethodBeat.o(362106);
      return;
      i = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lastClickGameInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;", "lastClickGameTeamLaunchParams", "lastClickGameTeamMode", "", "lastLiveId", "", "isWAGameTeam", "", "gameTeamInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;", "jumpGame", "", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "context", "Landroid/content/Context;", "gameInfo", "launchParams", "wording", "clickListener", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$OnDialogClickListener;", "refreshLastGameTeamClick", "liveId", "teamMode", "resetLastGameTeamClick", "from", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final void a(CheckBox paramCheckBox, View paramView)
    {
      AppMethodBeat.i(362047);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramCheckBox);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 28, 0, null, 14);
      if (!paramCheckBox.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramCheckBox.setChecked(bool);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(362047);
        return;
      }
    }
    
    public static void a(com.tencent.mm.plugin.finder.live.plugin.b paramb, Context paramContext, bha parambha, bhf parambhf, String paramString1, String paramString2, bf.c paramc)
    {
      AppMethodBeat.i(362006);
      kotlin.g.b.s.u(paramb, "basePlugin");
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(parambha, "gameInfo");
      kotlin.g.b.s.u(parambhf, "gameTeamInfo");
      kotlin.g.b.s.u(paramString1, "launchParams");
      kotlin.g.b.s.u(paramString2, "wording");
      if (g(parambhf))
      {
        localObject1 = bf.access$getTAG$cp();
        paramString1 = parambhf.ZQP;
        parambha = paramString1;
        if (paramString1 == null) {
          parambha = "";
        }
        Log.i((String)localObject1, kotlin.g.b.s.X("mini game team, jump weapp ", com.tencent.mm.ae.f.dg(parambha)));
        com.tencent.mm.ui.base.k.b(paramContext, paramString2, "", paramContext.getString(p.h.app_open), paramContext.getString(p.h.app_cancel), new bf.a..ExternalSyntheticLambda3(parambhf, paramb, paramContext, paramc), new bf.a..ExternalSyntheticLambda2(paramc));
      }
      for (;;)
      {
        ayG("jumpGame");
        AppMethodBeat.o(362006);
        return;
        parambhf = com.tencent.mm.plugin.finder.utils.t.GgN;
        localObject1 = parambha.xlr;
        parambhf = (bhf)localObject1;
        if (localObject1 == null) {
          parambhf = "";
        }
        bool = com.tencent.mm.plugin.finder.utils.t.aN(paramContext, parambhf);
        Log.i(bf.access$getTAG$cp(), "game installed: " + bool + ", packagename:" + parambha.xlr + ", gameName:" + parambha.Idi + ", gameAppId:" + parambha.Idh + ", gameUrl:" + parambha.ZQA);
        if (bool) {
          break;
        }
        com.tencent.mm.ui.base.k.b(paramContext, paramContext.getString(p.h.finder_secondcut_install_tip, new Object[] { parambha.Idi }), "", paramContext.getString(p.h.CgJ), paramContext.getString(p.h.app_cancel), new bf.a..ExternalSyntheticLambda5(bool, paramContext, parambha, paramc), new bf.a..ExternalSyntheticLambda1(paramc));
      }
      parambhf = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edg;
      Object localObject1 = new e.a(paramContext);
      ((e.a)localObject1).bDv("");
      ((e.a)localObject1).bDw(paramString2);
      paramString2 = View.inflate(paramContext, p.f.Cee, null);
      CheckBox localCheckBox = (CheckBox)paramString2.findViewById(p.e.checkbox);
      localCheckBox.setChecked(com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adeH, false));
      int i;
      if (parambhf != null)
      {
        Object localObject2 = parambhf.ZQN;
        if ((localObject2 != null) && (((fhh)localObject2).enable == true))
        {
          i = 1;
          label421:
          if (i == 0) {
            break label627;
          }
          localObject2 = parambhf.ZQN;
          if (localObject2 == null) {
            break label621;
          }
          localObject2 = ((fhh)localObject2).ZQE;
          if (localObject2 == null) {
            break label621;
          }
          if (((CharSequence)localObject2).length() <= 0) {
            break label615;
          }
          i = 1;
          label465:
          if (i != 1) {
            break label621;
          }
          i = 1;
          label474:
          if (i == 0) {
            break label627;
          }
        }
      }
      label615:
      label621:
      label627:
      for (boolean bool = true;; bool = false)
      {
        Log.i(bf.access$getTAG$cp(), kotlin.g.b.s.X("start_live_guide ", Boolean.valueOf(bool)));
        if (bool)
        {
          paramString2.setOnClickListener(new bf.a..ExternalSyntheticLambda6(localCheckBox));
          ((e.a)localObject1).md(paramString2);
          com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 27, 0, null, 14);
        }
        ((e.a)localObject1).bDC(paramContext.getString(p.h.CgJ)).c(new bf.a..ExternalSyntheticLambda4(parambhf, paramc, paramString1, bool, localCheckBox, parambha, paramb, paramContext));
        ((e.a)localObject1).bDD(paramContext.getString(p.h.app_cancel)).d(new bf.a..ExternalSyntheticLambda0(paramc));
        ((e.a)localObject1).jHH().show();
        break;
        i = 0;
        break label421;
        i = 0;
        break label465;
        i = 0;
        break label474;
      }
    }
    
    private static final void a(bf.c paramc, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(362024);
      paramDialogInterface.dismiss();
      if (paramc != null) {
        paramc.sK(false);
      }
      AppMethodBeat.o(362024);
    }
    
    private static final void a(bhf parambhf, com.tencent.mm.plugin.finder.live.plugin.b paramb, Context paramContext, bf.c paramc, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(362017);
      kotlin.g.b.s.u(parambhf, "$gameTeamInfo");
      kotlin.g.b.s.u(paramb, "$basePlugin");
      kotlin.g.b.s.u(paramContext, "$context");
      paramDialogInterface.dismiss();
      gfi localgfi = parambhf.ZQP;
      AppBrandLaunchReferrer localAppBrandLaunchReferrer;
      if (localgfi != null)
      {
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 13, 0, l.a(parambhf), 6);
        long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
        long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
        parambhf = com.tencent.mm.bx.b.cX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp);
        kotlin.g.b.s.s(parambhf, "copyFrom(basePlugin.busi…:class.java).liveCookies)");
        new ag(l1, l2, parambhf, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId).bFJ();
        paramDialogInterface = new g();
        paramDialogInterface.appId = localgfi.appid;
        paramDialogInterface.qAF = localgfi.path;
        paramDialogInterface.euz = localgfi.version;
        localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        parambhf = localgfi.ZIZ;
        if (parambhf != null) {
          break label267;
        }
        parambhf = "";
      }
      for (;;)
      {
        localAppBrandLaunchReferrer.qYJ = parambhf;
        parambhf = ah.aiuX;
        paramDialogInterface.qAO = localAppBrandLaunchReferrer;
        paramDialogInterface.scene = 1177;
        ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(paramContext, paramDialogInterface);
        if (paramc != null) {
          paramc.sK(true);
        }
        AppMethodBeat.o(362017);
        return;
        label267:
        paramb = parambhf.ZV();
        parambhf = paramb;
        if (paramb == null) {
          parambhf = "";
        }
      }
    }
    
    private static final void a(bhf parambhf, bf.c paramc, String paramString, boolean paramBoolean, CheckBox paramCheckBox, bha parambha, final com.tencent.mm.plugin.finder.live.plugin.b paramb, final Context paramContext, final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(362055);
      kotlin.g.b.s.u(paramString, "$launchParams");
      kotlin.g.b.s.u(parambha, "$gameInfo");
      kotlin.g.b.s.u(paramb, "$basePlugin");
      kotlin.g.b.s.u(paramContext, "$context");
      com.tencent.mm.plugin.finder.live.report.k localk = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (parambhf == null)
      {
        paramDialogInterface = null;
        com.tencent.mm.plugin.finder.live.report.k.a(localk, 13, 0, paramDialogInterface, 6);
        if (paramc != null) {
          paramc.sK(true);
        }
        paramDialogInterface = new ah.f();
        paramDialogInterface.aqH = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adeH, Boolean.valueOf(paramCheckBox.isChecked()));
          if (paramCheckBox.isChecked())
          {
            if (parambhf != null) {
              break label231;
            }
            parambhf = "";
          }
        }
      }
      for (;;)
      {
        paramDialogInterface.aqH = parambhf;
        parambhf = bf.Evf;
        Log.i(bf.access$getTAG$cp(), "jumpGame " + parambha.xlr + ", " + parambha.Idh + ", launchParams:" + (String)paramDialogInterface.aqH);
        com.tencent.mm.ae.d.B((kotlin.g.a.a)new a(parambha, paramDialogInterface, paramb, paramContext));
        AppMethodBeat.o(362055);
        return;
        paramDialogInterface = l.a(parambhf);
        break;
        label231:
        parambhf = parambhf.ZQN;
        if (parambhf == null)
        {
          parambhf = "";
        }
        else
        {
          paramc = parambhf.ZQE;
          parambhf = paramc;
          if (paramc == null) {
            parambhf = "";
          }
        }
      }
    }
    
    private static final void a(boolean paramBoolean, Context paramContext, bha parambha, bf.c paramc, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(362034);
      kotlin.g.b.s.u(paramContext, "$context");
      kotlin.g.b.s.u(parambha, "$gameInfo");
      paramDialogInterface.dismiss();
      paramDialogInterface = bf.Evf;
      Log.i(bf.access$getTAG$cp(), kotlin.g.b.s.X("download game dialog ok isInstall:", Boolean.valueOf(paramBoolean)));
      paramDialogInterface = com.tencent.mm.plugin.finder.utils.t.GgN;
      paramDialogInterface = parambha.ZQA;
      parambha = paramDialogInterface;
      if (paramDialogInterface == null) {
        parambha = "";
      }
      com.tencent.mm.plugin.finder.utils.t.aL(paramContext, parambha);
      if (paramc != null) {
        paramc.sK(true);
      }
      AppMethodBeat.o(362034);
    }
    
    public static void ayG(String paramString)
    {
      AppMethodBeat.i(361986);
      kotlin.g.b.s.u(paramString, "from");
      bf.eBR();
      bf.eBS();
      bf.ayF("");
      bf.eBT();
      Log.i(bf.access$getTAG$cp(), kotlin.g.b.s.X("resetLastGameTeamClick, from:", paramString));
      AppMethodBeat.o(361986);
    }
    
    private static final void b(bf.c paramc, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(362040);
      a locala = bf.Evf;
      Log.i(bf.access$getTAG$cp(), "download game dialog cancel");
      paramDialogInterface.dismiss();
      if (paramc != null) {
        paramc.sK(false);
      }
      AppMethodBeat.o(362040);
    }
    
    private static final void c(bf.c paramc, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(362063);
      a locala = bf.Evf;
      Log.i(bf.access$getTAG$cp(), "jumpGame dialog cancel");
      paramDialogInterface.dismiss();
      if (paramc != null) {
        paramc.sK(false);
      }
      AppMethodBeat.o(362063);
    }
    
    public static boolean g(bhf parambhf)
    {
      AppMethodBeat.i(361977);
      if (parambhf != null)
      {
        parambhf = parambhf.ZQP;
        if (parambhf != null)
        {
          parambhf = parambhf.appid;
          if (parambhf != null)
          {
            if (((CharSequence)parambhf).length() > 0) {}
            for (int i = 1; i == 1; i = 0)
            {
              AppMethodBeat.o(361977);
              return true;
            }
          }
        }
      }
      AppMethodBeat.o(361977);
      return false;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(bha parambha, ah.f<String> paramf, com.tencent.mm.plugin.finder.live.plugin.b paramb, Context paramContext)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$GameTeamGiftExtraData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "extranData", "", "getExtranData", "()Ljava/lang/String;", "setExtranData", "(Ljava/lang/String;)V", "toJsonString", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.appbrand.api.d
  {
    String EvU;
    
    public final String toJsonString()
    {
      AppMethodBeat.i(361965);
      try
      {
        Object localObject = new com.tencent.mm.ad.i(this.EvU);
        ((com.tencent.mm.ad.i)localObject).A("usePushAnimation", true);
        localObject = ((com.tencent.mm.ad.i)localObject).toString();
        kotlin.g.b.s.s(localObject, "{\n                val ob….toString()\n            }");
        AppMethodBeat.o(361965);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          bf.a locala = bf.Evf;
          Log.printErrStackTrace(bf.access$getTAG$cp(), (Throwable)localJSONException, "extraData toJsonString", new Object[0]);
          String str = "{}";
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(361969);
      String str = toJsonString();
      AppMethodBeat.o(361969);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$OnDialogClickListener;", "", "onClick", "", "clickOK", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void sK(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$PayGameTeamLogic;", "", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget;)V", "paymentBottomPage", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage;", "getCoinSpanString", "", "stringRes", "", "value", "setupBottomSheetForPayGameTeam", "", "gameInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;", "gameTeamInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;", "setupForNeedPayStatus", "panelInfo", "Lcom/tencent/mm/protocal/protobuf/GameLiveEnablePaymentPanelInfo;", "jumpAction", "Ljava/lang/Runnable;", "forNext", "", "setupForNotJoinStatus", "paid", "setupForPaidAndJoinStatus", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
  {
    private final be EvV;
    
    public d()
    {
      AppMethodBeat.i(362009);
      this.EvV = new be();
      AppMethodBeat.o(362009);
    }
    
    private static final void a(bf parambf, d paramd, cbo paramcbo, final boolean paramBoolean, final Runnable paramRunnable)
    {
      AppMethodBeat.i(362060);
      kotlin.g.b.s.u(parambf, "this$0");
      kotlin.g.b.s.u(paramd, "this$1");
      kotlin.g.b.s.u(paramcbo, "$panelInfo");
      kotlin.g.b.s.u(paramRunnable, "$jumpAction");
      if (com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant() != null)
      {
        be localbe = paramd.EvV;
        int i = paramcbo.aakX;
        paramcbo = parambf.CwG;
        paramRunnable = (be.a)new b(parambf, paramBoolean, paramRunnable);
        kotlin.g.b.s.u(paramcbo, "basePlugin");
        kotlin.g.b.s.u(paramRunnable, "callback");
        localbe.Eva = i;
        localbe.Evb = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
        localbe.CwG = paramcbo;
        localbe.EuZ = paramBoolean;
        localbe.EuY = paramRunnable;
      }
      parambf = parambf.Epc;
      if (parambf != null) {
        parambf.a((h.b)paramd.EvV);
      }
      AppMethodBeat.o(362060);
    }
    
    private static final void a(final bf parambf, bha parambha, bhf parambhf, cbo paramcbo)
    {
      AppMethodBeat.i(362082);
      kotlin.g.b.s.u(parambf, "this$0");
      kotlin.g.b.s.u(parambha, "$gameInfo");
      kotlin.g.b.s.u(parambhf, "$gameTeamInfo");
      kotlin.g.b.s.u(paramcbo, "$panelInfo");
      parambf.EvL = true;
      Object localObject1 = bf.Evf;
      com.tencent.mm.plugin.finder.live.plugin.b localb = parambf.CwG;
      Context localContext = parambf.mJe.getContext();
      kotlin.g.b.s.s(localContext, "root.context");
      localObject1 = parambhf.ZQE;
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.t.GgN;
      localObject1 = bf.Evf;
      boolean bool = bf.a.g(parambhf);
      localObject1 = bf.Evf;
      if (bf.a.g(parambhf))
      {
        localObject1 = parambhf.ZQP;
        if (localObject1 == null) {
          localObject1 = "";
        }
      }
      for (;;)
      {
        Object localObject3 = parambf.mJe.getContext();
        kotlin.g.b.s.s(localObject3, "root.context");
        bf.a.a(localb, localContext, parambha, parambhf, (String)localObject2, com.tencent.mm.plugin.finder.utils.t.a(bool, 7, (String)localObject1, (Context)localObject3), (bf.c)new a(paramcbo, parambf));
        AppMethodBeat.o(362082);
        return;
        localObject3 = ((gfi)localObject1).xlJ;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = "";
          continue;
          localObject3 = parambha.Idi;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
        }
      }
    }
    
    private static final void a(bf parambf, cbo paramcbo, Runnable paramRunnable, View paramView)
    {
      AppMethodBeat.i(362076);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parambf);
      localb.cH(paramcbo);
      localb.cH(paramRunnable);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$PayGameTeamLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(parambf, "this$0");
      kotlin.g.b.s.u(paramcbo, "$panelInfo");
      kotlin.g.b.s.u(paramRunnable, "$goPayAction");
      parambf.Qo(7);
      if (paramcbo.aakS > 0) {
        new g.a(paramView.getContext()).bDE(paramView.getContext().getResources().getString(p.h.Chc)).bDI(paramView.getContext().getResources().getString(p.h.app_continue)).bDJ(paramView.getContext().getResources().getString(p.h.app_cancel)).b(new bf.d..ExternalSyntheticLambda2(paramRunnable)).show();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$PayGameTeamLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(362076);
        return;
        if (bf.eBQ())
        {
          paramcbo = bf.Evf;
          Log.i(bf.access$getTAG$cp(), "is Wechat user");
          bf.d(parambf);
        }
        else
        {
          paramRunnable.run();
        }
      }
    }
    
    private static final void a(bf parambf, Runnable paramRunnable, View paramView)
    {
      AppMethodBeat.i(362053);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parambf);
      localb.cH(paramRunnable);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$PayGameTeamLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(parambf, "this$0");
      kotlin.g.b.s.u(paramRunnable, "$jumpAction");
      parambf.Qo(7);
      parambf = parambf.Epc;
      if (parambf != null) {
        parambf.cyW();
      }
      paramRunnable.run();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$PayGameTeamLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362053);
    }
    
    private final void a(cbo paramcbo, Runnable paramRunnable)
    {
      AppMethodBeat.i(362028);
      TextView localTextView = this.EvW.Evj;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      localTextView = this.EvW.Evl;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      localTextView = this.EvW.Evj;
      if (localTextView != null) {
        localTextView.setText((CharSequence)this.EvW.mJe.getContext().getString(p.h.Chk));
      }
      localTextView = this.EvW.Evg;
      if (localTextView != null) {
        localTextView.setText(hT(p.h.Chp, paramcbo.aakX));
      }
      paramcbo = this.EvW.Evj;
      if (paramcbo != null) {
        paramcbo.setOnClickListener(new bf.d..ExternalSyntheticLambda1(this.EvW, paramRunnable));
      }
      AppMethodBeat.o(362028);
    }
    
    private final void a(cbo paramcbo, Runnable paramRunnable, boolean paramBoolean)
    {
      AppMethodBeat.i(362044);
      TextView localTextView = this.EvW.Evj;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      localTextView = this.EvW.Evl;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      localTextView = this.EvW.Evj;
      if (localTextView != null) {
        localTextView.setText((CharSequence)this.EvW.mJe.getContext().getString(p.h.Chn));
      }
      localTextView = this.EvW.Evg;
      if (localTextView != null) {
        if (!paramBoolean) {
          break label178;
        }
      }
      label178:
      for (int i = p.h.Cho;; i = p.h.Chp)
      {
        localTextView.setText(hT(i, paramcbo.aakX));
        paramRunnable = new bf.d..ExternalSyntheticLambda3(this.EvW, this, paramcbo, paramBoolean, paramRunnable);
        localTextView = this.EvW.Evj;
        if (localTextView != null) {
          localTextView.setOnClickListener(new bf.d..ExternalSyntheticLambda0(this.EvW, paramcbo, paramRunnable));
        }
        AppMethodBeat.o(362044);
        return;
      }
    }
    
    private static final void a(Runnable paramRunnable, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(362067);
      kotlin.g.b.s.u(paramRunnable, "$goPayAction");
      paramRunnable.run();
      AppMethodBeat.o(362067);
    }
    
    private final void a(boolean paramBoolean, cbo paramcbo)
    {
      TextView localTextView1 = null;
      AppMethodBeat.i(362035);
      TextView localTextView2 = this.EvW.Evj;
      if (localTextView2 != null) {
        localTextView2.setVisibility(8);
      }
      localTextView2 = this.EvW.Evl;
      if (localTextView2 != null) {
        localTextView2.setVisibility(0);
      }
      if (!paramBoolean)
      {
        localTextView2 = this.EvW.Evg;
        if (localTextView2 != null) {
          localTextView2.setText(hT(p.h.Cho, paramcbo.aakX));
        }
        localTextView2 = this.EvW.Evl;
        if (localTextView2 != null)
        {
          paramcbo = this.EvW.Evl;
          if (paramcbo == null) {
            paramcbo = localTextView1;
          }
          for (;;)
          {
            localTextView2.setText((CharSequence)paramcbo);
            AppMethodBeat.o(362035);
            return;
            Context localContext = paramcbo.getContext();
            paramcbo = localTextView1;
            if (localContext != null) {
              paramcbo = localContext.getString(p.h.CgZ);
            }
          }
        }
      }
      else
      {
        localTextView1 = this.EvW.Evg;
        if (localTextView1 != null) {
          localTextView1.setText(hT(p.h.Chp, paramcbo.aakX));
        }
      }
      AppMethodBeat.o(362035);
    }
    
    private final CharSequence hT(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362016);
      Object localObject3 = this.EvW.mJe.getContext().getString(paramInt1, new Object[] { Integer.valueOf(paramInt2) });
      kotlin.g.b.s.s(localObject3, "root.context.getString(stringRes, value)");
      paramInt1 = n.a((CharSequence)localObject3, String.valueOf(paramInt2), 0, false, 6);
      Object localObject1 = this.EvW.mJe.getContext();
      Object localObject2 = ((String)localObject3).substring(0, paramInt1);
      kotlin.g.b.s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject2 = (CharSequence)localObject2;
      localObject3 = ((String)localObject3).substring(paramInt1, ((String)localObject3).length());
      kotlin.g.b.s.s(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject3 = (CharSequence)localObject3;
      Object localObject4 = this.EvW.Evg;
      float f;
      Object localObject5;
      if (localObject4 == null)
      {
        f = 0.0F;
        localObject4 = this.EvW.mJe.getContext();
        paramInt2 = p.g.coin_icon;
        localObject5 = this.EvW.Evg;
        if (localObject5 != null) {
          break label273;
        }
      }
      label273:
      for (paramInt1 = -1;; paramInt1 = ((TextView)localObject5).getCurrentTextColor())
      {
        localObject4 = bb.m((Context)localObject4, paramInt2, paramInt1);
        localObject5 = this.EvW;
        ((Drawable)localObject4).setBounds(0, 0, com.tencent.mm.cd.a.bs(((bf)localObject5).mJe.getContext(), p.c.Edge_2A), com.tencent.mm.cd.a.bs(((bf)localObject5).mJe.getContext(), p.c.Edge_2A));
        localObject5 = ah.aiuX;
        localObject1 = com.tencent.mm.pluginsdk.ui.span.p.a((Context)localObject1, (CharSequence)localObject2, (CharSequence)localObject3, f, (Drawable)localObject4, false);
        kotlin.g.b.s.s(localObject1, "insertSpanIconAtMedium(\n…true, false\n            )");
        localObject1 = (CharSequence)localObject1;
        AppMethodBeat.o(362016);
        return localObject1;
        f = ((TextView)localObject4).getTextSize();
        break;
      }
    }
    
    public final void e(bha parambha, bhf parambhf)
    {
      AppMethodBeat.i(362119);
      kotlin.g.b.s.u(parambha, "gameInfo");
      kotlin.g.b.s.u(parambhf, "gameTeamInfo");
      cbo localcbo = parambhf.ZQG;
      if (localcbo == null)
      {
        AppMethodBeat.o(362119);
        return;
      }
      if (!bf.f(parambhf))
      {
        AppMethodBeat.o(362119);
        return;
      }
      Object localObject = bf.Evf;
      Log.i(bf.access$getTAG$cp(), "pay game showBottomSheet");
      localObject = this.EvW.Evj;
      if (localObject != null) {
        ((TextView)localObject).setTag(Integer.valueOf(7));
      }
      parambha = new bf.d..ExternalSyntheticLambda4(this.EvW, parambha, parambhf, localcbo);
      switch (parambhf.status)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(362119);
        return;
        a(localcbo, parambha);
        AppMethodBeat.o(362119);
        return;
        a(localcbo, parambha, false);
        AppMethodBeat.o(362119);
        return;
        if (localcbo.aakP > 0)
        {
          if ((localcbo.aakQ > 0) && (parambhf.status == 3))
          {
            a(localcbo, parambha);
            AppMethodBeat.o(362119);
            return;
          }
          a(true, localcbo);
          AppMethodBeat.o(362119);
          return;
        }
        if (localcbo.aakR > 0)
        {
          a(false, localcbo);
          AppMethodBeat.o(362119);
          return;
        }
        a(localcbo, parambha, true);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$PayGameTeamLogic$setupBottomSheetForPayGameTeam$jumpGameAction$1$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$OnDialogClickListener;", "onClick", "", "clickOK", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements bf.c
    {
      a(cbo paramcbo, bf parambf) {}
      
      public final void sK(boolean paramBoolean)
      {
        AppMethodBeat.i(361859);
        if (paramBoolean)
        {
          bf.a locala = bf.Evf;
          Log.i(bf.access$getTAG$cp(), kotlin.g.b.s.X("jump game ", this.EvX.ZUh));
          parambf.EvO = this.EvX.ZUh;
        }
        parambf.EvL = false;
        bf.c(parambf);
        AppMethodBeat.o(361859);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$PayGameTeamLogic$setupForNeedPayStatus$goPayAction$1$1$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage$Callback;", "onPaid", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements be.a
    {
      b(bf parambf, boolean paramBoolean, Runnable paramRunnable) {}
      
      public final void eBJ()
      {
        String str = null;
        AppMethodBeat.i(361876);
        Object localObject1 = this.EvW.Epc;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.h)localObject1).cyW();
        }
        if (paramBoolean)
        {
          localObject1 = this.EvW.Evj;
          Object localObject2;
          if (localObject1 == null)
          {
            localObject1 = null;
            localObject2 = this.EvW.Evj;
            if (localObject2 != null) {
              break label75;
            }
          }
          for (;;)
          {
            aa.db((Context)localObject1, str);
            AppMethodBeat.o(361876);
            return;
            localObject1 = ((TextView)localObject1).getContext();
            break;
            label75:
            localObject2 = ((TextView)localObject2).getContext();
            if (localObject2 != null) {
              str = ((Context)localObject2).getString(p.h.Chj);
            }
          }
        }
        paramRunnable.run();
        AppMethodBeat.o(361876);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$checkCanJumpGame$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$OnDialogClickListener;", "onClick", "", "clickOK", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements bf.c
  {
    e(bf parambf) {}
    
    public final void sK(boolean paramBoolean)
    {
      AppMethodBeat.i(361995);
      this.EvW.EvL = false;
      bf.c(this.EvW);
      AppMethodBeat.o(361995);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$getWeAppOpenUICallback$1", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "onAppBrandPreconditionError", "", "onAppBrandProcessDied", "onAppBrandUIEnter", "onAppBrandUIExit", "isFinish", "", "onTriggerHalfScreenShare", "token", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.plugin.appbrand.api.i
  {
    f(bf parambf) {}
    
    public final void UP(String paramString)
    {
      AppMethodBeat.i(362046);
      paramString = bf.Evf;
      Log.i(bf.access$getTAG$cp(), "onTriggerHalfScreenShare");
      AppMethodBeat.o(362046);
    }
    
    public final void ceq()
    {
      AppMethodBeat.i(362004);
      Object localObject = bf.Evf;
      Log.i(bf.access$getTAG$cp(), "onAppBrandPreconditionErrors");
      localObject = this.EvW.CwG;
      if (localObject == null) {}
      for (localObject = null;; localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.plugin.b)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))
      {
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Edf = false;
        }
        AppMethodBeat.o(362004);
        return;
      }
    }
    
    public final void cer()
    {
      AppMethodBeat.i(362015);
      Object localObject = bf.Evf;
      Log.i(bf.access$getTAG$cp(), "onAppBrandUIEnter");
      localObject = this.EvW.CwG;
      if (localObject == null) {}
      for (localObject = null;; localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.plugin.b)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))
      {
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Edf = true;
        }
        localObject = aj.CGT;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).EcI = true;
        }
        localObject = aj.CGT;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Eda = false;
        }
        AppMethodBeat.o(362015);
        return;
      }
    }
    
    public final void ces()
    {
      AppMethodBeat.i(362036);
      Object localObject = bf.Evf;
      Log.i(bf.access$getTAG$cp(), "onAppBrandProcessDied");
      localObject = this.EvW.CwG;
      if (localObject == null) {}
      for (localObject = null;; localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.plugin.b)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))
      {
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Edf = false;
        }
        AppMethodBeat.o(362036);
        return;
      }
    }
    
    public final void ie(boolean paramBoolean)
    {
      AppMethodBeat.i(362025);
      Object localObject = bf.Evf;
      Log.i(bf.access$getTAG$cp(), "onAppBrandUIExit:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      localObject = this.EvW.CwG;
      if (localObject == null) {}
      for (localObject = null;; localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.plugin.b)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))
      {
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Edf = false;
        }
        this.EvW.Beb = null;
        AppMethodBeat.o(362025);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$jumpGameFromInviteSheet$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$OnDialogClickListener;", "onClick", "", "clickOK", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements bf.c
  {
    g(bf parambf) {}
    
    public final void sK(boolean paramBoolean)
    {
      AppMethodBeat.i(361983);
      this.EvW.EvK = false;
      if (paramBoolean) {
        this.EvW.Qp(0);
      }
      for (;;)
      {
        bf.c(this.EvW);
        AppMethodBeat.o(361983);
        return;
        this.EvW.Qp(1);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$jumpHalfScreenGameInfo$bundle$1$1", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "toJsonString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.plugin.appbrand.api.d
  {
    h(bhf parambhf) {}
    
    public final String toJsonString()
    {
      AppMethodBeat.i(361958);
      Object localObject = this.Ewa.ZQG;
      if (localObject == null)
      {
        AppMethodBeat.o(361958);
        return "";
      }
      localObject = ((cbo)localObject).aakW;
      if (localObject == null)
      {
        AppMethodBeat.o(361958);
        return "";
      }
      localObject = ((cbt)localObject).aalc;
      if (localObject == null)
      {
        AppMethodBeat.o(361958);
        return "";
      }
      localObject = ((com.tencent.mm.bx.b)localObject).ZV();
      if (localObject == null)
      {
        AppMethodBeat.o(361958);
        return "";
      }
      try
      {
        localObject = new com.tencent.mm.ad.i((String)localObject);
        ((com.tencent.mm.ad.i)localObject).A("usePushAnimation", true);
        localObject = ((com.tencent.mm.ad.i)localObject).toString();
        if (localObject == null)
        {
          AppMethodBeat.o(361958);
          return "";
        }
      }
      catch (Exception localException)
      {
        bf.a locala = bf.Evf;
        Log.printErrStackTrace(bf.access$getTAG$cp(), (Throwable)localException, "extraData error", new Object[0]);
        AppMethodBeat.o(361958);
        return "";
      }
      AppMethodBeat.o(361958);
      return localException;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$setupBottomSheetForNormalGameTeam$1$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$OnDialogClickListener;", "onClick", "", "clickOK", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements bf.c
  {
    i(bf parambf) {}
    
    public final void sK(boolean paramBoolean)
    {
      AppMethodBeat.i(361932);
      this.EvW.EvL = false;
      bf.c(this.EvW);
      AppMethodBeat.o(361932);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(bf parambf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetGameTeamInfoResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class k
    extends u
    implements kotlin.g.a.b<b.a<bht>, ah>
  {
    public k(bf parambf, bha parambha)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bf
 * JD-Core Version:    0.7.0.1
 */