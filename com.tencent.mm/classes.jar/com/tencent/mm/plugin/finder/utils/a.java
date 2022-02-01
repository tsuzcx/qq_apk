package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.b.a.bp;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.activity.FinderActivityProfileUI;
import com.tencent.mm.plugin.finder.edit.FinderPhotoEditPluginLayout;
import com.tencent.mm.plugin.finder.edit.FinderVideoEditPluginLayout;
import com.tencent.mm.plugin.finder.feed.ui.FinderAlbumTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelatedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFriendFoldedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveFansListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveInvitedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveMsgUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoDetailUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoPreviewUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRelatedFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRelatedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRetransmitSourceUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI1;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI11;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI12;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI14;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI16;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI3;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI4;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI9;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.h.g;
import com.tencent.mm.plugin.finder.live.model.h.h;
import com.tencent.mm.plugin.finder.live.model.h.i;
import com.tencent.mm.plugin.finder.live.model.h.j;
import com.tencent.mm.plugin.finder.live.model.h.k;
import com.tencent.mm.plugin.finder.live.model.h.l;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI;
import com.tencent.mm.plugin.finder.search.FinderFeedSearchUI;
import com.tencent.mm.plugin.finder.search.FinderMixSearchUI;
import com.tencent.mm.plugin.finder.search.FinderTopicSearchUI;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.storage.ai;
import com.tencent.mm.plugin.finder.ui.FinderActivityDescUI;
import com.tencent.mm.plugin.finder.ui.FinderActivityPostUI;
import com.tencent.mm.plugin.finder.ui.FinderBlockListSearchUI;
import com.tencent.mm.plugin.finder.ui.FinderBlockListUI;
import com.tencent.mm.plugin.finder.ui.FinderCreateContactUI;
import com.tencent.mm.plugin.finder.ui.FinderCreateGuideUI;
import com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI;
import com.tencent.mm.plugin.finder.ui.FinderEditTextUI;
import com.tencent.mm.plugin.finder.ui.FinderFansListUI;
import com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI;
import com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI;
import com.tencent.mm.plugin.finder.ui.FinderFollowListUI;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI;
import com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI;
import com.tencent.mm.plugin.finder.ui.FinderModifyNameUI;
import com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.ui.FinderPostRouterUI;
import com.tencent.mm.plugin.finder.ui.FinderPostUI;
import com.tencent.mm.plugin.finder.ui.FinderSelectActivityUI;
import com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI;
import com.tencent.mm.plugin.finder.ui.FinderSelectSexUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.FinderUnOpenUI;
import com.tencent.mm.plugin.finder.ui.FinderWxMsgUI;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.aa.a;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.ad.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/ActivityRouter;", "", "()V", "TAG", "", "enterAccountManagementUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterActivityDescUI", "activity", "Lcom/tencent/mm/ui/MMActivity;", "requestCode", "", "enterActivityProfileUI", "enterAlbumRelatedTimelineUI", "enterAtTimelineUI", "enterAuthInfoWeApp", "appId", "enterPath", "enterChattingUIFromComment", "sessionId", "username", "feedId", "", "commentId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "enterChattingUIFromFans", "fansId", "enterChattingUIFromLottery", "scene", "lotteryId", "objectId", "enterChattingUIFromProfile", "enterCropAvatarUI", "Landroid/app/Activity;", "rc", "enterFavFeedUI", "reqCode", "enterFavTimelineUI", "enterFeedRelatedTimelineUI", "enterFinderAccountDetailUI", "enterFinderBlackConversationUI", "convType", "enterFinderBlockListSearchUI", "type", "enterFinderBlockListUi", "enterFinderCommentUI", "Lcom/tencent/mm/ui/MMFragmentActivity;", "enterFinderContactSearchIncludeFollowUI", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "enterFinderContactSearchIncludeFollowUIForResult", "enterFinderContactSearchUI", "enterFinderConversationUI", "enterFinderCreateContactUI", "enterFinderCreateContactUIForResult", "enterFinderCreateLotteryUI", "enterFinderEditTextUI", "enterFinderFansListUI", "enterFinderFansSearchUI", "intent", "enterFinderFeedLbsUI", "enterFinderFeedRelUI", "enterFinderFeedSearchUI", "enterFinderFinderMsgUI", "enterFinderFinderSysMsgUI", "enterFinderFixRatioEditUI", "inputPath", "outputPath", "enterFinderFollowListUI", "enterFinderHelloConversationUI", "enterFinderHotSearchUI", "enterFinderImagePreviewUI", "enterFinderLbsLiveFriendsUI", "enterFinderLikedFeedUI", "enterFinderLiveAnchorUI", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "contextId", "liveId", "nonceId", "bindShop", "", "desc", "sessionBuffer", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInviteInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LinkInviteInfo;", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "tagInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "chosenTagInfo", "visitorWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "enterFinderLiveFansListUI", "enterFinderLiveInvitedUI", "nickname", "avatar", "enterFinderLiveVisitorUI", "clickTabContextId", "anchorUserName", "enterFinderLiveVisitorWhiteListUI", "enterFinderLiveWeCoinHotUI", "enterFinderLotteryHistoryDetailUI", "enterFinderLotteryHistoryUI", "isFromSetting", "enterFinderLotteryWinnerListUI", "enterFinderManagementUi", "enterFinderMediaEditUI", "rawPath", "matrix", "Landroid/graphics/Matrix;", "cropRect", "Landroid/graphics/Rect;", "offset", "", "isVlogMode", "enterFinderMediaPreviewUI", "viewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isLongVideoPreview", "enterFinderMixSearchUI", "enterFinderMsgFeedDetailUI", "enterFinderNotifyMsgUI", "enterFinderPostAlbumUI", "forResult", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "mediaType", "maxCount", "(Landroid/content/Context;Landroid/content/Intent;IILjava/lang/Boolean;Ljava/lang/Integer;)V", "enterFinderPostRouterUI", "enterFinderPostUI", "enterFinderProfileTimelineUI", "enterFinderProfileUI", "enterFinderRetransmitSourceUI", "enterFinderSelfUI", "enterFinderSettingInfoUI", "enterFinderShareFeedDetailUI", "enterFinderShareFeedDetailUI2", "enterFinderSharePostUI", "enterFinderSnsGridFeedUI", "enterFinderTimelineUI", "enterFinderTopicSearchUI", "enterFinderWxConversationUI", "enterFinderWxMsgUI", "enterFinderWxSettingUI", "enterFriendBlackListUI", "enterFriendContactUI", "enterFriendFoldedTimelineUI", "enterFriendLikeFeedUI", "enterFriendLikeTimelineUI", "enterFriendRecommendUI", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "totalCount", "isPosterView", "enterLbsStreamFeedUI", "enterLbsStreamListUI", "enterMegaVideoTimelineUI", "isFromFloatBall", "enterModifyNameUI", "enterMusicMvMainUI", "enterMusicMvMakerUI", "enterNearbyLiveMoreUI", "enterOriginalRequestUI", "enterOriginalUI", "enterPoiFeedUI", "enterPostActivityUI", "enterPostAtUI", "enterPreviewAtTimelineUI", "enterRealnameVerifyUI", "fromActivity", "enterRelatedFeedUI", "enterRelatedTimelineUI", "enterSelectActivityUI", "enterSelectCoverUI", "postLongVideo", "enterSelectDistrictUI", "enterSelectSexUI", "enterSelfQRCodeUI", "enterTopicFeedUI", "enterTopicTimelineUI", "enterUnOpenUI", "enterWeApp", "sceneNote", "fillPostFromRoute", "curIntent", "goDraftInternal", "intentString", "extra", "openImagePreviewGallery", "path", "args", "", "realEnterRealnameVerifyUI", "tryGoPostUIIfDraftExist", "routeFrom", "plugin-finder_release"})
public final class a
{
  public static final a vUU;
  
  static
  {
    AppMethodBeat.i(167872);
    vUU = new a();
    AppMethodBeat.o(167872);
  }
  
  public static void A(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253268);
    p.h(paramContext, "context");
    p.h(paramIntent, "i");
    i locali = i.vvu;
    i.a(null);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchIncludeFollowUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253268);
  }
  
  public static void B(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253269);
    p.h(paramContext, "context");
    p.h(paramIntent, "i");
    i locali = i.vvu;
    i.a(null);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderTopicSearchUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTopicSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTopicSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253269);
  }
  
  public static void C(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253272);
    p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.spam.a locala = com.tencent.mm.plugin.finder.spam.a.vwk;
    if (com.tencent.mm.plugin.finder.spam.a.avn("search") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.spam.a.vwk;
      com.tencent.mm.ui.base.h.a(paramContext, com.tencent.mm.plugin.finder.spam.a.avo("search"), "", paramContext.getString(2131768713), null);
      AppMethodBeat.o(253272);
      return;
    }
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1265L, 0L, 1L, false);
    paramIntent.setClass(paramContext, FinderMixSearchUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253272);
  }
  
  public static void D(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253273);
    p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.spam.a locala = com.tencent.mm.plugin.finder.spam.a.vwk;
    if (com.tencent.mm.plugin.finder.spam.a.avn("search") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.spam.a.vwk;
      com.tencent.mm.ui.base.h.a(paramContext, com.tencent.mm.plugin.finder.spam.a.avo("search"), "", paramContext.getString(2131768713), null);
      AppMethodBeat.o(253273);
      return;
    }
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1265L, 0L, 1L, false);
    paramIntent.setClass(paramContext, FinderLongVideoPreviewUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderHotSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderHotSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253273);
  }
  
  public static void E(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167851);
    p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderEditTextUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167851);
      return;
    }
  }
  
  public static void F(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167852);
    p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderShareFeedRelUI.class);
      paramIntent = com.tencent.mm.plugin.finder.report.h.veu;
      com.tencent.mm.plugin.finder.report.h.dnS();
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167852);
      return;
    }
  }
  
  public static void G(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253274);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderShareFeedDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253274);
      return;
    }
  }
  
  public static void H(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167853);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderRetransmitSourceUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167853);
      return;
    }
  }
  
  public static void I(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167854);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderMsgFeedDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167854);
      return;
    }
  }
  
  public static void K(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253276);
    p.h(paramContext, "context");
    if (!((aj)com.tencent.mm.kernel.g.ah(aj.class)).canEnterMvAndShowToast())
    {
      AppMethodBeat.o(253276);
      return;
    }
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      try
      {
        localObject = Class.forName("com.tencent.mm.plugin.mv.ui.MusicMvMainUI");
        p.g(localObject, "Class.forName(\"com.tence…gin.mv.ui.MusicMvMainUI\")");
        paramIntent.setClass(paramContext, (Class)localObject);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMainUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMainUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253276);
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        Log.e("Finder.ActivityRouter", "enterMusicMvMainUI : ".concat(String.valueOf(paramContext)));
        AppMethodBeat.o(253276);
      }
    }
  }
  
  public static void L(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253277);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      try
      {
        localObject = Class.forName("com.tencent.mm.plugin.mv.ui.MusicMvRouterUI");
        p.g(localObject, "Class.forName(\"com.tence…n.mv.ui.MusicMvRouterUI\")");
        paramIntent.putExtra("KEY_MUSIC_ROUTER", 3);
        paramIntent.setClass(paramContext, (Class)localObject);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMakerUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMakerUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253277);
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        Log.e("Finder.ActivityRouter", "enterMusicMvMakerUI : ".concat(String.valueOf(paramContext)));
        AppMethodBeat.o(253277);
      }
    }
  }
  
  public static void M(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167860);
    p.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderImagePreviewUI.class);
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167860);
      return;
    }
  }
  
  public static void N(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167862);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderModifyNameUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167862);
      return;
    }
  }
  
  public static void O(final Context paramContext, Intent paramIntent)
  {
    com.tencent.mm.kernel.c.a locala = null;
    AppMethodBeat.i(167870);
    p.h(paramContext, "context");
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        localObject = Boolean.valueOf(paramIntent.getBooleanExtra("key_finder_teen_mode_check", false));
        if (!((Boolean)localObject).booleanValue()) {
          break label229;
        }
        localObject = ai.vFj;
        localObject = (ad.a)new e(paramIntent, paramContext);
        p.h(paramContext, "context");
        if (paramIntent == null) {
          break label159;
        }
      }
      label159:
      for (paramIntent = Integer.valueOf(paramIntent.getIntExtra("key_finder_teen_mode_scene", 0));; paramIntent = null)
      {
        locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
        if (((com.tencent.mm.plugin.teenmode.a.b)locala).Vt())
        {
          locala = com.tencent.mm.kernel.g.af(ad.class);
          p.g(locala, "MMKernel.service(IFinder…enModeConfig::class.java)");
          if (!((ad)locala).dxY()) {
            break label164;
          }
        }
        ((ad.a)localObject).mM(true);
        AppMethodBeat.o(167870);
        return;
        localObject = null;
        break;
      }
      label164:
      ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(paramContext);
      com.tencent.mm.plugin.report.service.h.CyF.a(20912, new Object[] { Integer.valueOf(3), paramIntent, "", "" });
      ((ad.a)localObject).mM(false);
      AppMethodBeat.o(167870);
      return;
      label229:
      Object localObject = locala;
      if (!(paramContext instanceof Activity)) {
        localObject = paramIntent;
      }
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderTopicFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167870);
      return;
    }
  }
  
  public static void P(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167871);
    p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderTopicTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167871);
      return;
    }
  }
  
  public static void Q(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253287);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderLbsStreamListUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253287);
      return;
    }
  }
  
  public static void R(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253289);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderRelatedFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253289);
      return;
    }
  }
  
  public static void S(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253290);
    p.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderRelatedTimelineUI.class);
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramIntent, 501);
      AppMethodBeat.o(253290);
      return;
    }
    paramIntent.addFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253290);
  }
  
  public static void T(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253291);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFriendLikeTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253291);
      return;
    }
  }
  
  public static void U(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253292);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderLikedFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLikedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLikedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253292);
      return;
    }
  }
  
  public static void V(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253294);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFriendFoldedTimelineUI.class);
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253294);
      return;
    }
  }
  
  public static void W(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253295);
    p.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderFeedRelatedTimelineUI.class);
    FinderReporterUIC.a locala = FinderReporterUIC.wzC;
    FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFeedRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFeedRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253295);
  }
  
  public static void X(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253297);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFeedRelTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253297);
      return;
    }
  }
  
  public static void Y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253300);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.addFlags(67108864);
      paramIntent.setClass(paramContext, FinderFinderMsgUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderNotifyMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderNotifyMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253300);
      return;
    }
  }
  
  public static void Z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253305);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, OccupyFinderUI12.class);
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterNearbyLiveMoreUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterNearbyLiveMoreUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253305);
      return;
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(253343);
    p.h(paramActivity, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramBoolean) {
      localIntent.putExtra("KEY_IS_FROM_SETTING", true);
    }
    localIntent.setClass((Context)paramActivity, OccupyFinderUI1.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryUI", "(Landroid/app/Activity;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryUI", "(Landroid/app/Activity;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253343);
  }
  
  public static void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, cjk paramcjk, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(253298);
    p.h(paramActivity, "context");
    p.h(paramViewInfo, "viewInfo");
    p.h(paramcjk, "localContent");
    Intent localIntent = new Intent();
    localIntent.setClass((Context)paramActivity, FinderSelectCoverUI.class);
    localIntent.putExtra("media_list_", paramcjk.toByteArray());
    localIntent.putExtra("crop_info", (Parcelable)paramViewInfo);
    localIntent.putExtra("media_list_count", paramcjk.mediaList.size());
    localIntent.putExtra("isLongVideoPost", paramBoolean);
    paramActivity.startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(253298);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, Matrix paramMatrix, Rect paramRect, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(253278);
    p.h(paramActivity, "context");
    p.h(paramString, "rawPath");
    p.h(paramMatrix, "matrix");
    p.h(paramRect, "cropRect");
    UICustomParam.a locala = new UICustomParam.a();
    locala.apE();
    locala.apD();
    locala.dz(false);
    locala.apF();
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    paramMatrix = new Bundle();
    paramMatrix.putParcelable("cropRect", (Parcelable)paramRect);
    paramMatrix.putFloatArray("matrix", arrayOfFloat);
    paramMatrix.putFloatArray("offset", paramArrayOfFloat);
    if (paramInt == 2)
    {
      paramString = RecordConfigProvider.aD(paramString, "", "");
      paramString.scene = 11;
      paramString.BOn = locala.apG();
      paramRect = com.tencent.mm.plugin.finder.storage.c.vCb;
      paramString.BOm = com.tencent.mm.plugin.finder.storage.c.dqx();
      paramString.remuxType = 2;
      paramString.BOp = 3;
      paramString.BOv = (paramString.BOm.duration * 1000);
      locala.dy(false);
      paramString.jkf = paramMatrix;
      paramString.F(2, FinderVideoEditPluginLayout.class.getName());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)paramActivity, 1, 2130771986, 2130771986, paramString, 2, 0);
      AppMethodBeat.o(253278);
      return;
    }
    if (paramInt == 1)
    {
      locala.apC();
      paramString = RecordConfigProvider.jA(paramString, "");
      paramString.scene = 11;
      paramString.BOn = locala.apG();
      paramString.jkf = paramMatrix;
      paramString.F(1, FinderPhotoEditPluginLayout.class.getName());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)paramActivity, 1, 2130771986, 2130771986, paramString, 1, 1);
    }
    AppMethodBeat.o(253278);
  }
  
  public static void a(Context paramContext, final int paramInt, String paramString1, String paramString2, long paramLong, final bbn parambbn)
  {
    AppMethodBeat.i(253320);
    p.h(paramContext, "context");
    p.h(paramString2, "lotteryId");
    ((aa)com.tencent.mm.kernel.g.af(aa.class)).a(paramContext, paramInt, paramString1, paramString2, Long.valueOf(paramLong), (aa.a)new c(paramContext, parambbn, paramInt));
    AppMethodBeat.o(253320);
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(253322);
    p.h(paramContext, "context");
    p.h(paramString1, "anchorUserName");
    p.h(paramString2, "nonceId");
    p.h(paramString3, "desc");
    p.h(paramString4, "contextId");
    paramString1 = new LiveConfig.a().qo(LiveConfig.hvU).zt(paramLong2).Gd(paramString2).zu(paramLong1).Gg(paramString1).Gh(paramString3).Gl(paramString5).aBR();
    p.g(paramString1, "builder.toWhere(LiveConf…fer)\n            .build()");
    paramString2 = new FinderLiveConfig();
    paramString2.uiu.add(paramString1);
    a(paramContext, paramString2, paramString4, null, null, 24);
    AppMethodBeat.o(253322);
  }
  
  public static void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167836);
    p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("FROM_SCENE_KEY", paramInt);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    localIntent.setClass(paramContext, FinderHomeUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167836);
  }
  
  public static void a(Context paramContext, aqw paramaqw, Intent paramIntent)
  {
    AppMethodBeat.i(167847);
    p.h(paramContext, "context");
    p.h(paramIntent, "i");
    i locali = i.vvu;
    i.a(paramaqw);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchUI.class);
    paramaqw = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramaqw.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramaqw.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167847);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(253283);
    p.h(paramContext, "context");
    p.h(paramString1, "appId");
    p.h(paramString2, "enterPath");
    p.h(paramString3, "sceneNote");
    Log.i("Finder.ActivityRouter", "enter we app appId:" + paramString1 + ",enterPath:" + paramString2 + ",scene:" + paramInt + ",sceneNote:" + paramString3);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(253283);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramString1;
    localg.kHw = paramString2;
    localg.scene = paramInt;
    localg.dCw = paramString3;
    ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramContext, localg);
    AppMethodBeat.o(253283);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, final bbn parambbn)
  {
    AppMethodBeat.i(253319);
    p.h(paramContext, "context");
    p.h(paramString1, "sessionId");
    p.h(paramString2, "username");
    ((aa)com.tencent.mm.kernel.g.af(aa.class)).a(paramContext, paramString1, paramString2, Long.valueOf(paramLong1), Long.valueOf(paramLong2), (aa.a)new a(paramContext, parambbn));
    AppMethodBeat.o(253319);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, final bbn parambbn)
  {
    AppMethodBeat.i(253318);
    p.h(paramContext, "context");
    p.h(paramString1, "sessionId");
    p.h(paramString2, "fansId");
    ((aa)com.tencent.mm.kernel.g.af(aa.class)).a(paramContext, paramString1, paramString2, (aa.a)new b(paramContext, parambbn));
    AppMethodBeat.o(253318);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(253328);
    p.h(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localIntent.putExtra("key_anchor_finder_username", str);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("key_anchor_finder_nickname", paramString1);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("key_anchor_finder_avatar", paramString1);
    localIntent.putExtra("key_anchor_finder_object_id", paramLong1);
    localIntent.putExtra("key_anchor_finder_live_id", paramLong2);
    ((aj)com.tencent.mm.kernel.g.ah(aj.class)).cleatLiveStatusCache(Long.valueOf(paramLong2));
    localIntent.setClass(paramContext, FinderLiveInvitedUI.class);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveInvitedUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveInvitedUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253328);
  }
  
  public static void a(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253270);
    p.h(paramMMActivity, "activity");
    p.h(paramIntent, "i");
    i locali = i.vvu;
    i.a(null);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass((Context)paramMMActivity, FinderContactSearchIncludeFollowUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20000);
    AppMethodBeat.o(253270);
  }
  
  public static void a(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167869);
    p.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderSelectSexUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(167869);
  }
  
  public static void a(MMFragmentActivity paramMMFragmentActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253306);
    p.h(paramMMFragmentActivity, "context");
    paramIntent.setClass((Context)paramMMFragmentActivity, FinderCommentUI.class);
    paramMMFragmentActivity.startActivityForResult(paramIntent, 500);
    paramMMFragmentActivity.overridePendingTransition(0, 0);
    AppMethodBeat.o(253306);
  }
  
  public static void aD(final Context paramContext, String paramString)
  {
    AppMethodBeat.i(253317);
    p.h(paramContext, "context");
    p.h(paramString, "username");
    Log.i("Finder.ActivityRouter", "[startChattingUI] username=" + paramString + " scene=2");
    ((aa)com.tencent.mm.kernel.g.af(aa.class)).a(paramContext, paramString, (aa.a)new d(paramString, paramContext));
    AppMethodBeat.o(253317);
  }
  
  public static void aE(Context paramContext, String paramString)
  {
    AppMethodBeat.i(253337);
    p.h(paramContext, "context");
    p.h(paramString, "type");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderBlockListSearchUI.class);
      localObject = FinderBlockListSearchUI.vHv;
      localIntent.putExtra(FinderBlockListSearchUI.dyV(), paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListSearchUI", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListSearchUI", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253337);
      return;
    }
  }
  
  public static void aa(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253310);
    p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderActivityProfileUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterActivityProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterActivityProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253310);
      return;
    }
  }
  
  public static void ab(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253312);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderAtTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext = k.vfA;
      paramContext = new bp();
      paramContext.ep(cl.aWz());
      paramContext.jN(z.aUg());
      paramContext.jO(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD());
      paramContext.bfK();
      k.a((com.tencent.mm.plugin.report.a)paramContext);
      AppMethodBeat.o(253312);
      return;
    }
  }
  
  public static void ac(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253313);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, OccupyFinderUI10.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPreviewAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPreviewAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253313);
      return;
    }
  }
  
  private static void ad(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(253335);
    p.h(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderBlockListUI.class);
      localIntent.putExtra("BLOCK_LIST_TYPE", paramInt);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListUi", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListUi", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253335);
      return;
    }
  }
  
  public static void ad(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253329);
    p.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderSnsGridFeedUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSnsGridFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSnsGridFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253329);
  }
  
  public static void ae(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253330);
    p.h(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderLiveFansListUI");
    paramIntent.setClass(paramContext, FinderLiveFansListUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253330);
  }
  
  public static void af(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253331);
    p.h(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderLiveWeCoinHotUI");
    paramIntent.setClass(paramContext, OccupyFinderUI9.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveWeCoinHotUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveWeCoinHotUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253331);
  }
  
  public static void ah(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253339);
    p.h(paramContext, "context");
    paramIntent.setClass(paramContext, OccupyFinderUI16.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAccountManagementUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAccountManagementUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253339);
  }
  
  public static void ai(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253342);
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    i locali = i.vvu;
    i.a(null);
    paramIntent.setClass(paramContext, FinderCreateGuideUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253342);
  }
  
  public static void aj(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253347);
    p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, FinderPoiFeedUI.class);
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253347);
      return;
    }
  }
  
  public static void b(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253286);
    p.h(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderFavTimelineUI.class);
    FinderReporterUIC.a locala = FinderReporterUIC.wzC;
    FinderReporterUIC.a.a((Context)paramActivity, paramIntent, 0L, 0, false, 124);
    paramActivity.startActivityForResult(paramIntent, 10001);
    AppMethodBeat.o(253286);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167863);
    p.h(paramActivity, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass((Context)paramActivity, FinderCropAvatarUI.class);
    localIntent.putExtra("key_result_file_name", "finder_avatar.tmp");
    localIntent.putExtra("key_crop_source", 1);
    paramActivity.startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(167863);
  }
  
  private static void b(Context paramContext, FinderLiveConfig paramFinderLiveConfig, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(253323);
    p.h(paramContext, "context");
    p.h(paramFinderLiveConfig, "config");
    p.h(paramString1, "contextId");
    p.h(paramString2, "clickTabContextId");
    Log.i("Finder.ActivityRouter", "[enterFinderLiveVisitorUI] ".concat(String.valueOf(paramFinderLiveConfig)));
    Object localObject2 = (aj)com.tencent.mm.kernel.g.ah(aj.class);
    Object localObject1 = paramFinderLiveConfig.dfu();
    if (localObject1 != null) {}
    for (localObject1 = Long.valueOf(((LiveConfig)localObject1).getLiveId());; localObject1 = Long.valueOf(0L))
    {
      ((aj)localObject2).cleatLiveStatusCache((Long)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.model.h.uiL;
      p.h(paramContext, "context");
      p.h(paramFinderLiveConfig, "config");
      p.h(paramString1, "contextId");
      p.h(paramString2, "clickTabContextId");
      localObject2 = new z.f();
      String str = paramContext.getResources().getString(2131755873);
      p.g(str, "context.resources.getString(R.string.app_i_know)");
      ((z.f)localObject2).SYG = str;
      localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).J((kotlin.g.a.a)new h.g(paramContext, (z.f)localObject2));
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).M((kotlin.g.a.a)new h.h(paramContext));
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).K((kotlin.g.a.a)new h.i(paramContext));
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).b(false, (kotlin.g.a.b)new h.j(paramFinderLiveConfig, paramContext, paramString1));
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).a(paramContext, (kotlin.g.a.a)new h.k(paramContext));
      if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.model.h)localObject1).L((kotlin.g.a.a)new h.l(paramContext)) == null)) {
        break;
      }
      com.tencent.mm.plugin.finder.live.model.h.a(paramContext, paramFinderLiveConfig, paramString1, paramString2, paramIntent);
      AppMethodBeat.o(253323);
      return;
    }
    AppMethodBeat.o(253323);
  }
  
  public static void b(Context paramContext, aqw paramaqw, Intent paramIntent)
  {
    AppMethodBeat.i(253271);
    p.h(paramContext, "context");
    p.h(paramIntent, "i");
    i locali = i.vvu;
    i.a(paramaqw);
    paramIntent.setClass(paramContext, FinderFeedSearchUI.class);
    paramaqw = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramaqw.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramaqw.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1265L, 1L, 1L, false);
    AppMethodBeat.o(253271);
  }
  
  public static void b(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(167842);
    p.h(paramIntent1, "intent");
    p.h(paramIntent2, "curIntent");
    paramIntent1.putExtra("key_finder_post_from", paramIntent2.getIntExtra("key_finder_post_from", -1));
    AppMethodBeat.o(167842);
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253303);
    p.h(paramMMActivity, "context");
    if (!(paramMMActivity instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass((Context)paramMMActivity, FinderTimelineLbsUI.class);
      paramMMActivity.startActivityForResult(paramIntent, 19999);
      AppMethodBeat.o(253303);
      return;
    }
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(253285);
    p.h(paramMMActivity, "context");
    paramIntent.setClass((Context)paramMMActivity, FinderFavFeedUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(253285);
  }
  
  public static void c(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253288);
    p.h(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderLbsStreamListUI.class);
    paramActivity.startActivityForResult(paramIntent, 501);
    AppMethodBeat.o(253288);
  }
  
  private static void c(Context paramContext, FinderLiveConfig paramFinderLiveConfig, String paramString)
  {
    AppMethodBeat.i(253327);
    p.h(paramContext, "context");
    p.h(paramFinderLiveConfig, "config");
    p.h(paramString, "contextId");
    Log.i("Finder.ActivityRouter", "[enterFinderLiveAnchorUI] ".concat(String.valueOf(paramFinderLiveConfig)));
    com.tencent.mm.plugin.finder.live.model.h.a(com.tencent.mm.plugin.finder.live.model.h.uiL, paramContext, paramFinderLiveConfig, paramString);
    AppMethodBeat.o(253327);
  }
  
  public static void c(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253308);
    p.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderActivityPostUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20002);
    AppMethodBeat.o(253308);
  }
  
  public static void c(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(253307);
    p.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderPostAtUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(253307);
  }
  
  public static boolean c(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(253265);
    p.h(paramContext, "context");
    p.h(paramString, "intentString");
    p.h(paramIntent, "extra");
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = com.tencent.e.f.e.bqe(paramString);
        Parcel localParcel = Parcel.obtain();
        p.g(localParcel, "Parcel.obtain()");
        localParcel.unmarshall(paramString, 0, paramString.length);
        localParcel.setDataPosition(0);
        paramString = (Intent)Intent.CREATOR.createFromParcel(localParcel);
        paramString.setExtrasClassLoader(LocalVideoCropInfoParcelable.CREATOR.getClass().getClassLoader());
        paramString.putExtras(paramIntent);
        if (!Util.isNullOrNil(paramString.getStringExtra("saveText"))) {
          E(paramContext, paramString);
        }
        for (;;)
        {
          AppMethodBeat.o(253265);
          return true;
          enterFinderPostUI(paramContext, paramString);
        }
        AppMethodBeat.o(253265);
      }
      catch (Exception paramContext)
      {
        Log.e("Finder.ActivityRouter", "goDraft() ".concat(String.valueOf(paramContext)));
      }
    }
    return false;
  }
  
  public static void d(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253340);
    p.h(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderLiveMsgUI.class);
    paramActivity.startActivityForResult(paramIntent, 1002);
    AppMethodBeat.o(253340);
  }
  
  public static void d(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(253332);
    p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity))
    {
      paramIntent = localIntent;
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      if (!paramBoolean) {
        break label89;
      }
      localIntent.setClass(paramContext, FinderLongVideoDetailUI.class);
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {
        break label101;
      }
      ((Activity)paramContext).startActivityForResult(localIntent, 101);
      AppMethodBeat.o(253332);
      return;
      paramIntent = null;
      break;
      label89:
      localIntent.setClass(paramContext, FinderLongVideoTimelineUI.class);
    }
    label101:
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMegaVideoTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMegaVideoTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253332);
  }
  
  public static void d(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253309);
    p.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderActivityDescUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20002);
    AppMethodBeat.o(253309);
  }
  
  public static void d(String paramString, Context paramContext)
  {
    AppMethodBeat.i(167867);
    p.h(paramContext, "context");
    Intent localIntent = new Intent();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localIntent.putExtra("Contact_User", str);
    com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(167867);
  }
  
  public static void e(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253341);
    p.h(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, OccupyFinderUI14.class);
    paramActivity.startActivityForResult(paramIntent, 1001);
    AppMethodBeat.o(253341);
  }
  
  public static void e(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253311);
    p.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderSelectActivityUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20003);
    AppMethodBeat.o(253311);
  }
  
  public static void enterAlbumRelatedTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253296);
    p.h(paramContext, "context");
    Object localObject = com.tencent.mm.kernel.g.af(ad.class);
    p.g(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ad)localObject).dxX())
    {
      ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(paramContext);
      Log.w("Finder.ActivityRouter", "青少年模式只看关注时，禁止进入专辑.");
      AppMethodBeat.o(253296);
      return;
    }
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {}
      for (localObject = paramIntent;; localObject = null)
      {
        if (localObject != null) {
          ((Intent)localObject).addFlags(268435456);
        }
        paramIntent.setClass(paramContext, FinderAlbumTimelineUI.class);
        localObject = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAlbumRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAlbumRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253296);
        return;
      }
    }
  }
  
  public static void enterFinderFollowListUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253262);
    p.h(paramContext, "context");
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {}
      for (Object localObject = paramIntent;; localObject = null)
      {
        if (localObject != null) {
          ((Intent)localObject).addFlags(268435456);
        }
        paramIntent.addFlags(67108864);
        paramIntent.setClass(paramContext, FinderFollowListUI.class);
        localObject = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFollowListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFollowListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253262);
        return;
      }
    }
  }
  
  public static void enterFinderLbsLiveFriendsUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253304);
    p.h(paramContext, "context");
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {}
      for (Object localObject = paramIntent;; localObject = null)
      {
        if (localObject != null) {
          ((Intent)localObject).addFlags(268435456);
        }
        paramIntent.setClass(paramContext, OccupyFinderUI11.class);
        localObject = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLbsLiveFriendsUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLbsLiveFriendsUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253304);
        return;
      }
    }
  }
  
  public static void enterFinderPostRouterUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167841);
    p.h(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.upload.d.vSt;
    if (!com.tencent.mm.plugin.finder.upload.d.cameraCheck(paramContext))
    {
      Log.i("Finder.ActivityRouter", "enterFinderPostRouterUI cameraCheck false!");
      AppMethodBeat.o(167841);
      return;
    }
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = (Intent)localObject;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).setClass(paramContext, FinderPostRouterUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130772132, 2130771986);
      }
      AppMethodBeat.o(167841);
      return;
    }
  }
  
  public static void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167840);
    p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderPostUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167840);
      return;
    }
  }
  
  public static void enterFinderProfileUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167843);
    p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderProfileUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167843);
      return;
    }
  }
  
  public static void fE(Context paramContext)
  {
    AppMethodBeat.i(253338);
    p.h(paramContext, "context");
    Object localObject1 = ae.SYK;
    localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.e)localObject2).azQ().get(ar.a.Ong, "");
    if (localObject2 == null)
    {
      paramContext = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(253338);
      throw paramContext;
    }
    localObject1 = String.format((String)localObject2 + "?wechat_real_lang=%s&username=%s", Arrays.copyOf(new Object[] { LocaleUtil.getApplicationLanguage(), z.aUg() }, 2));
    p.g(localObject1, "java.lang.String.format(format, *args)");
    localObject2 = y.vXH;
    if (y.dCM()) {
      u.makeText(paramContext, (CharSequence)"url:".concat(String.valueOf(localObject1)), 1).show();
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
    localObject1 = k.vfA;
    k.b(paramContext, 9L, 1L);
    AppMethodBeat.o(253338);
  }
  
  public static boolean fr(Context paramContext)
  {
    AppMethodBeat.i(253263);
    p.h(paramContext, "context");
    AppMethodBeat.o(253263);
    return false;
  }
  
  public static void ft(Context paramContext)
  {
    AppMethodBeat.i(167845);
    p.h(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderSettingInfoUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167845);
      return;
    }
  }
  
  public static void fu(Context paramContext)
  {
    AppMethodBeat.i(167859);
    p.h(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a(paramContext, localIntent, 0L, 0, false, 124);
      localIntent.setClass(paramContext, FinderWxMsgUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167859);
      return;
    }
  }
  
  public static void fv(Context paramContext)
  {
    AppMethodBeat.i(167861);
    p.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramContext, FinderSelfQRCodeUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167861);
  }
  
  public static void fw(Context paramContext)
  {
    AppMethodBeat.i(167866);
    p.h(paramContext, "context");
    Object localObject = new Intent(paramContext, FinderUnOpenUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167866);
  }
  
  public static void fx(Context paramContext)
  {
    AppMethodBeat.i(253293);
    p.h(paramContext, "context");
    ad(paramContext, 1);
    AppMethodBeat.o(253293);
  }
  
  public static void fy(Context paramContext)
  {
    AppMethodBeat.i(253301);
    p.h(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderFinderSysMsgUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253301);
      return;
    }
  }
  
  public static void fz(Context paramContext)
  {
    AppMethodBeat.i(253302);
    p.h(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderFansListUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253302);
      return;
    }
  }
  
  public static void g(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253345);
    p.h(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, OccupyFinderUI2.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryDetailUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryDetailUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253345);
  }
  
  public static void g(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(253281);
    p.h(paramActivity, "context");
    Bundle localBundle = new Bundle();
    String str;
    if (Util.isNullOrNil(paramString))
    {
      paramString = paramActivity.getComponentName();
      p.g(paramString, "context.componentName");
      str = paramString.getClassName();
      p.g(str, "context.componentName.className");
      paramString = MMApplicationContext.getSourcePackageName() + ".plugin.finder";
      if (!n.J(str, paramString, false)) {
        break label214;
      }
      int i = paramString.length();
      if (str == null)
      {
        paramActivity = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(253281);
        throw paramActivity;
      }
      paramString = str.substring(i);
      p.g(paramString, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      Log.i("Finder.ActivityRouter", "fullActivity " + str + ", fromActivity " + paramString);
      localBundle.putString("realname_verify_process_jump_activity", paramString);
      for (;;)
      {
        localBundle.putString("realname_verify_process_jump_plugin", "finder");
        ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wxpaysdk.api.c.class)).h(paramActivity, localBundle);
        AppMethodBeat.o(253281);
        return;
        localBundle.putString("realname_verify_process_jump_activity", paramString);
      }
      label214:
      paramString = str;
    }
  }
  
  public static void h(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(253346);
    p.h(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, OccupyFinderUI3.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryWinnerListUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryWinnerListUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(253346);
  }
  
  public static void h(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(167864);
    p.h(paramActivity, "context");
    if ((Util.isNullOrNil(paramString)) && (!(paramActivity instanceof FinderHomeUI)) && (!(paramActivity instanceof FinderTimelineUI)) && (!(paramActivity instanceof FinderSelfUI)))
    {
      paramString = new Intent();
      paramString.setClass((Context)paramActivity, OccupyFinderUI5.class);
      paramString.putExtra("enterRealnameVerifyUI", true);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRealnameVerifyUI", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRealnameVerifyUI", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167864);
      return;
    }
    g(paramActivity, paramString);
    AppMethodBeat.o(167864);
  }
  
  public static void w(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167838);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.addFlags(67108864);
      paramIntent.setClass(paramContext, FinderCreateContactUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167838);
      return;
    }
  }
  
  public static void x(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253266);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.addFlags(67108864);
      paramIntent.setClass(paramContext, OccupyFinderUI4.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSharePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSharePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253266);
      return;
    }
  }
  
  public static void y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167844);
    p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderProfileTimeLineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167844);
      return;
    }
  }
  
  public static void y(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(167868);
    p.h(paramContext, "context");
    p.h(paramString1, "appId");
    p.h(paramString2, "enterPath");
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.username = paramString1;
    localg.kHw = Util.nullAs(paramString2, "");
    localg.scene = 1201;
    ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramContext, localg);
    AppMethodBeat.o(167868);
  }
  
  public static void z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(253267);
    p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderSelfUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253267);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class a
    implements aa.a
  {
    a(Context paramContext, bbn parambbn) {}
    
    public final void j(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(253254);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(253254);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class b
    implements aa.a
  {
    b(Context paramContext, bbn parambbn) {}
    
    public final void j(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(253256);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(253256);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class c
    implements aa.a
  {
    c(Context paramContext, bbn parambbn, int paramInt) {}
    
    public final void j(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(253258);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(253258);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class d
    implements aa.a
  {
    d(String paramString, Context paramContext) {}
    
    public final void j(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(253260);
      Log.i("Finder.ActivityRouter", "[enterChattingUI] ]username=" + this.hLl + " sessionId=" + paramString1);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(253260);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "canGotoFinderPage", "", "onDone"})
  static final class e
    implements ad.a
  {
    e(Intent paramIntent, Context paramContext) {}
    
    public final void mM(boolean paramBoolean)
    {
      AppMethodBeat.i(253261);
      if (paramBoolean)
      {
        Object localObject = this.gtH;
        if (localObject == null) {
          p.hyc();
        }
        ((Intent)localObject).putExtra("key_finder_teen_mode_check", false);
        localObject = a.vUU;
        a.O(paramContext, this.gtH);
      }
      AppMethodBeat.o(253261);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.a
 * JD-Core Version:    0.7.0.1
 */