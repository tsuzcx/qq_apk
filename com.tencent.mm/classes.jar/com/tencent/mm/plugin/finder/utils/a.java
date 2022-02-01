package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.d.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.f.b.a.cf;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.activity.FinderActivityProfileUI;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.d.a.a;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ai;
import com.tencent.mm.plugin.finder.cgi.ai.a;
import com.tencent.mm.plugin.finder.edit.FinderFixRatioPhoneEditPluginLayout;
import com.tencent.mm.plugin.finder.edit.FinderPhotoEditPluginLayout;
import com.tencent.mm.plugin.finder.edit.FinderVideoEditPluginLayout;
import com.tencent.mm.plugin.finder.feed.ui.FinderAccountManagent;
import com.tencent.mm.plugin.finder.feed.ui.FinderAlbumTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtFeedManageUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelatedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFloatBallDetailUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFriendFoldedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGallerySearchUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGalleryUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveAuthUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveFinishUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameLivePostUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameLivePostVerifyUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameSearchUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameSelectUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveNoticeQRCodeUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveNoticeUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoDetailUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoPreviewUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderMultiTaskUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPostPreviewUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRelatedFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRelatedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRetransmitSourceUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderSharePostUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI4;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.t.h;
import com.tencent.mm.plugin.finder.live.model.t.i;
import com.tencent.mm.plugin.finder.live.model.t.j;
import com.tencent.mm.plugin.finder.live.model.t.k;
import com.tencent.mm.plugin.finder.live.model.t.l;
import com.tencent.mm.plugin.finder.live.model.t.m;
import com.tencent.mm.plugin.finder.live.model.t.n;
import com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI;
import com.tencent.mm.plugin.finder.search.FinderFansSearchUI;
import com.tencent.mm.plugin.finder.search.FinderFeedSearchUI;
import com.tencent.mm.plugin.finder.search.FinderMixSearchUI;
import com.tencent.mm.plugin.finder.storage.ah;
import com.tencent.mm.plugin.finder.storage.ah.a;
import com.tencent.mm.plugin.finder.ui.FinderActivityDescUI;
import com.tencent.mm.plugin.finder.ui.FinderActivityPostUI;
import com.tencent.mm.plugin.finder.ui.FinderBlockListSearchUI;
import com.tencent.mm.plugin.finder.ui.FinderBlockListUI;
import com.tencent.mm.plugin.finder.ui.FinderCreateContactUI;
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
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.findersdk.a.ab.a;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ae.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ai.f;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/ActivityRouter;", "", "()V", "TAG", "", "enterAccountManagementUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterActivityDescUI", "activity", "Lcom/tencent/mm/ui/MMActivity;", "requestCode", "", "enterActivityProfileUI", "enterAlbumRelatedTimelineUI", "enterAtFeedManageUI", "Landroid/app/Activity;", "enterAtTimelineUI", "enterAuthInfoWeApp", "appId", "enterPath", "enterChattingUIFromComment", "sessionId", "username", "feedId", "", "commentId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "enterChattingUIFromFans", "fansId", "enterChattingUIFromLive", "fromUsername", "toUser", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "scene", "enterChattingUIFromLottery", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "lotteryId", "objectId", "isAnchorToVisitor", "", "enterChattingUIFromProfile", "enterCropAvatarUI", "rc", "enterFavFeedUI", "reqCode", "enterFavTimelineUI", "enterFeedRelatedTimelineUI", "enterFinderAccountDetailUI", "enterFinderAliasConversationUI", "enterFinderAnchorVerifyWebviewUI", "enterFinderBlackConversationUI", "convType", "enterFinderBlockListSearchUI", "type", "enterFinderBlockListUi", "enterFinderCommentUI", "Lcom/tencent/mm/ui/MMFragmentActivity;", "enterFinderContactSearchIncludeFollowUI", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "enterFinderContactSearchIncludeFollowUIForResult", "enterFinderContactSearchUI", "enterFinderConversationUI", "enterFinderCreateContactUI", "enterFinderCreateContactUIForResult", "enterFinderCreateLotteryUI", "enterFinderEditTextUI", "enterFinderFansListUI", "enterFinderFansSearchUI", "intent", "enterFinderFeedLbsUI", "enterFinderFeedRelUI", "enterFinderFeedSearchUI", "enterFinderFinderMsgUI", "enterFinderFinderSysMsgUI", "enterFinderFixRatioEditUI", "inputPath", "outputPath", "ratio", "", "color", "enterFinderFollowListUI", "enterFinderGallerySearchUI", "enterFinderGalleryUI", "enterFinderGameLiveAuthUI", "enterFinderGameLiveFinishUI", "enterFinderGameLivePostUI", "enterFinderGameLivePostVerifyUI", "enterFinderGameSearchUI", "enterFinderGameSelectUI", "enterFinderHelloConversationUI", "enterFinderHotSearchUI", "enterFinderImagePreviewUI", "enterFinderLikedFeedUI", "enterFinderLiveAnchorUI", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "contextId", "nonceId", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInviteInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LinkInviteInfo;", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "desc", "tagInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "chosenTagInfo", "sessionBuffer", "visitorWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "liveId", "redPacketId", "enterFinderLiveCountDownUI", "enterFinderLiveCreateVisitorRoleUI", "enterFinderLiveFansListUI", "enterFinderLiveInvitedUI", "nickname", "avatar", "enterFinderLiveNoticeQrCodeUI", "enterFinderLiveNoticeUI", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "enterFinderLivePrecheckLicenseUI", "enterFinderLivePrepareUI", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "enterFinderLiveVisitorRoleUI", "fromUserGuide", "enterFinderLiveVisitorUI", "clickTabContextId", "anchorUserName", "extFlag", "streamUrl", "audienMode", "commentScene", "(Landroid/content/Intent;Landroid/content/Context;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "enterFinderLiveVisitorWhiteListUI", "enterFinderLiveWeCoinHotUI", "enterFinderLogOutUI", "userName", "enterFinderLotteryHistoryDetailUI", "enterFinderLotteryHistoryUI", "isFromSetting", "enterFinderLotteryWinnerListUI", "enterFinderManagementUi", "sourceType", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "enterFinderMediaEditUI", "rawPath", "matrix", "Landroid/graphics/Matrix;", "cropRect", "Landroid/graphics/Rect;", "offset", "", "isVlogMode", "enterFinderMediaPreviewUI", "viewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isLongVideoPreview", "showSeekBar", "enterFinderMixSearchUI", "enterFinderMsgFeedDetailUI", "enterFinderNotifyMsgUI", "enterFinderPostAlbumUI", "forResult", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "mediaType", "maxCount", "(Landroid/content/Context;Landroid/content/Intent;IILjava/lang/Boolean;Ljava/lang/Integer;)V", "enterFinderPostRouterUI", "enterFinderPostUI", "enterFinderPrivacyBlockListNewUi", "enterFinderProfileTimelineUI", "enterFinderProfileUI", "enterFinderRetransmitSourceUI", "enterFinderSelfUI", "enterFinderSettingInfoUI", "enterFinderShareFeedDetailUI", "enterFinderShareFeedDetailUI2", "enterFinderSharePostUI", "enterFinderSnsGridFeedUI", "enterFinderTimelineUI", "enterFinderTopicSearchUI", "enterFinderWxConversationUI", "enterFinderWxMsgUI", "enterFinderWxSettingUI", "enterFloatBallDetailUI", "isFromFloatBall", "enterFriendBlackListUI", "enterFriendContactUI", "enterFriendFoldedTimelineUI", "enterFriendLikeFeedUI", "enterFriendLikeTimelineUI", "enterFriendRecommendUI", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "totalCount", "isPosterView", "enterLbsStreamFeedUI", "enterLbsStreamListUI", "enterLiveTaskH5", "sourceSync", "forceUrl", "enterMegaVideoTimelineUI", "enterModifyNameUI", "enterMusicMvMainUI", "enterMusicMvMakerUI", "enterMusicMvPostUI", "enterMusicMvPreviewUI", "enterOriginalRequestUI", "enterOriginalUI", "enterPoiFeedUI", "enterPoiTimelineUI", "enterPostActivityUI", "enterPostAtUI", "enterPreviewAtTimelineUI", "enterRealnameVerifyUI", "fromActivity", "enterRelatedFeedUI", "enterRelatedTimelineUI", "enterSelectActivityUI", "enterSelectCoverUI", "postLongVideo", "enterSelectDistrictUI", "enterSelectSexUI", "enterSelfQRCodeUI", "enterShoppingWeApp", "sceneNote", "enterTopicFeedUI", "enterTopicTimelineUI", "enterUnOpenUI", "enterWeApp", "enterWeAppByName", "appName", "isTrial", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "enterWeAppForRedDot", "enterWebViewForRedDot", "url", "fillPostFromRoute", "curIntent", "goDraftInternal", "intentString", "extra", "openImagePreviewGallery", "path", "args", "", "realEnterRealnameVerifyUI", "tryGoPostUIIfDraftExist", "routeFrom", "plugin-finder_release"})
public final class a
{
  public static final a ACH;
  
  static
  {
    AppMethodBeat.i(167872);
    ACH = new a();
    AppMethodBeat.o(167872);
  }
  
  public static void A(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274063);
    p.k(paramContext, "context");
    p.k(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.j localj = com.tencent.mm.plugin.finder.search.j.Acs;
    com.tencent.mm.plugin.finder.search.j.a(null);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchIncludeFollowUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274063);
  }
  
  public static void B(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274066);
    p.k(paramContext, "context");
    com.tencent.mm.plugin.findersdk.c.a locala = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGQ("search") != 0)
    {
      paramIntent = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      com.tencent.mm.ui.base.h.a(paramContext, com.tencent.mm.plugin.findersdk.c.a.aGR("search"), "", paramContext.getString(ai.f.welcome_i_know), null);
      AppMethodBeat.o(274066);
      return;
    }
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1265L, 0L, 1L, false);
    paramIntent.setClass(paramContext, FinderMixSearchUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274066);
  }
  
  public static void C(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274067);
    p.k(paramContext, "context");
    com.tencent.mm.plugin.findersdk.c.a locala = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGQ("search") != 0)
    {
      paramIntent = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      com.tencent.mm.ui.base.h.a(paramContext, com.tencent.mm.plugin.findersdk.c.a.aGR("search"), "", paramContext.getString(ai.f.welcome_i_know), null);
      AppMethodBeat.o(274067);
      return;
    }
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1265L, 0L, 1L, false);
    paramIntent.setClass(paramContext, FinderLongVideoPreviewUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderHotSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderHotSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274067);
  }
  
  public static void C(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(167868);
    p.k(paramContext, "context");
    p.k(paramString1, "appId");
    p.k(paramString2, "enterPath");
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Boolean)com.tencent.mm.plugin.finder.storage.d.dXI().aSr()).booleanValue()) {
      localg.cBU = 2;
    }
    localg.username = paramString1;
    localg.nBq = Util.nullAs(paramString2, "");
    localg.scene = 1201;
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramContext, localg);
    AppMethodBeat.o(167868);
  }
  
  public static void D(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167851);
    p.k(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167851);
      return;
    }
  }
  
  public static void E(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167852);
    p.k(paramContext, "context");
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
      paramIntent = com.tencent.mm.plugin.finder.report.j.zVy;
      com.tencent.mm.plugin.finder.report.j.dPt();
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167852);
      return;
    }
  }
  
  public static void F(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274068);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderShareFeedDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274068);
      return;
    }
  }
  
  public static void G(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167853);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderRetransmitSourceUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167853);
      return;
    }
  }
  
  public static void H(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167854);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderMsgFeedDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167854);
      return;
    }
  }
  
  public static void J(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274070);
    p.k(paramContext, "context");
    if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).canEnterMvAndShowToast())
    {
      AppMethodBeat.o(274070);
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
        p.j(localObject, "Class.forName(\"com.tence…gin.mv.ui.MusicMvMainUI\")");
        paramIntent.setClass(paramContext, (Class)localObject);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMainUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMainUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(274070);
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        Log.e("Finder.ActivityRouter", "enterMusicMvMainUI : ".concat(String.valueOf(paramContext)));
        AppMethodBeat.o(274070);
      }
    }
  }
  
  public static void K(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274071);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      try
      {
        localObject = Class.forName("com.tencent.mm.plugin.mv.ui.MusicMvRouterUI");
        p.j(localObject, "Class.forName(\"com.tence…n.mv.ui.MusicMvRouterUI\")");
        paramIntent.putExtra("KEY_MUSIC_ROUTER", 3);
        paramIntent.setClass(paramContext, (Class)localObject);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMakerUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMakerUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(274071);
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        Log.e("Finder.ActivityRouter", "enterMusicMvMakerUI : ".concat(String.valueOf(paramContext)));
        AppMethodBeat.o(274071);
      }
    }
  }
  
  public static void L(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274072);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      try
      {
        localObject = Class.forName("com.tencent.mm.plugin.mv.ui.MusicMvRouterUI");
        p.j(localObject, "Class.forName(\"com.tence…n.mv.ui.MusicMvRouterUI\")");
        paramIntent.putExtra("KEY_MUSIC_ROUTER", 7);
        paramIntent.setClass(paramContext, (Class)localObject);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(274072);
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        Log.e("Finder.ActivityRouter", "enterMusicMvPostUI : ".concat(String.valueOf(paramContext)));
        AppMethodBeat.o(274072);
      }
    }
  }
  
  public static void M(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167860);
    p.k(paramContext, "context");
    paramIntent.setClass(paramContext, FinderImagePreviewUI.class);
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167860);
      return;
    }
  }
  
  public static void N(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167862);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderModifyNameUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167862);
      return;
    }
  }
  
  public static void O(final Context paramContext, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(167870);
    p.k(paramContext, "context");
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      if (paramIntent != null) {}
      for (Object localObject1 = Boolean.valueOf(paramIntent.getBooleanExtra("key_finder_teen_mode_check", false)); ((Boolean)localObject1).booleanValue(); localObject1 = null)
      {
        localObject1 = ah.AmB;
        ah.a.a(paramContext, paramIntent, (ae.a)new g(paramIntent, paramContext));
        AppMethodBeat.o(167870);
        return;
      }
      localObject1 = localObject2;
      if (!(paramContext instanceof Activity)) {
        localObject1 = paramIntent;
      }
      if (localObject1 != null) {
        ((Intent)localObject1).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderTopicFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167870);
      return;
    }
  }
  
  public static void P(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167871);
    p.k(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167871);
      return;
    }
  }
  
  public static void Q(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274085);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderLbsStreamListUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274085);
      return;
    }
  }
  
  public static void R(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274087);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderRelatedFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274087);
      return;
    }
  }
  
  public static void S(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274088);
    p.k(paramContext, "context");
    paramIntent.setClass(paramContext, FinderRelatedTimelineUI.class);
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramIntent, 501);
      AppMethodBeat.o(274088);
      return;
    }
    paramIntent.addFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274088);
  }
  
  public static void T(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274089);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFriendLikeTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274089);
      return;
    }
  }
  
  public static void U(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274090);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderLikedFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLikedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLikedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274090);
      return;
    }
  }
  
  public static void V(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274092);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFriendFoldedTimelineUI.class);
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      aj.a.a(paramContext, paramIntent, 0L, 0, false, 124);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274092);
      return;
    }
  }
  
  public static void W(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274093);
    p.k(paramContext, "context");
    paramIntent.setClass(paramContext, FinderFeedRelatedTimelineUI.class);
    aj.a locala = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    aj.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFeedRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFeedRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274093);
  }
  
  public static void X(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274095);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFeedRelTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274095);
      return;
    }
  }
  
  public static void Y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274098);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.addFlags(67108864);
      paramIntent.setClass(paramContext, FinderFinderMsgUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderNotifyMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderNotifyMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274098);
      return;
    }
  }
  
  public static void Z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274105);
    p.k(paramContext, "context");
    paramIntent.putExtra("SOURCE_REQUEST_CODE", 20000);
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderGallerySearchUI.class);
      if (!(paramContext instanceof Activity)) {
        break;
      }
      ((Activity)paramContext).startActivityForResult(paramIntent, 20000);
      AppMethodBeat.o(274105);
      return;
    }
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGallerySearchUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGallerySearchUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274105);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(274164);
    p.k(paramActivity, "context");
    paramIntent.putExtra("KEY_IS_FROM_SETTING", paramBoolean);
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.enN());
    paramActivity.startActivityForResult(paramIntent, paramInt);
    paramActivity.overridePendingTransition(b.a.sight_slide_bottom_in, b.a.anim_not_change);
    AppMethodBeat.o(274164);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, FinderContact paramFinderContact, int paramInt)
  {
    AppMethodBeat.i(274174);
    p.k(paramActivity, "activity");
    p.k(paramFinderContact, "contact");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = com.tencent.mm.plugin.finder.live.viewmodel.component.c.zdR;
    localIntent.putExtra(com.tencent.mm.plugin.finder.live.viewmodel.component.c.dGt(), paramFinderContact.toByteArray());
    localIntent.setClass((Context)paramActivity, FinderLiveNoticeUI.class);
    paramActivity.startActivityForResult(localIntent, paramInt);
    paramActivity.overridePendingTransition(b.a.sight_slide_bottom_in, b.a.anim_not_change);
    AppMethodBeat.o(274174);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(274158);
    p.k(paramActivity, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramBoolean) {
      localIntent.putExtra("KEY_IS_FROM_SETTING", true);
    }
    paramIntent = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    localIntent.setClass(paramIntent, com.tencent.mm.plugin.findersdk.e.a.enO());
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryUI", "(Landroid/app/Activity;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryUI", "(Landroid/app/Activity;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274158);
  }
  
  public static void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, csf paramcsf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(274096);
    p.k(paramActivity, "context");
    p.k(paramViewInfo, "viewInfo");
    p.k(paramcsf, "localContent");
    Intent localIntent = new Intent();
    localIntent.setClass((Context)paramActivity, FinderSelectCoverUI.class);
    localIntent.putExtra("media_list_", paramcsf.toByteArray());
    localIntent.putExtra("crop_info", (Parcelable)paramViewInfo);
    localIntent.putExtra("media_list_count", paramcsf.mediaList.size());
    localIntent.putExtra("isLongVideoPost", paramBoolean);
    paramActivity.startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(274096);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, Matrix paramMatrix, Rect paramRect, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(274073);
    p.k(paramActivity, "context");
    p.k(paramString, "rawPath");
    p.k(paramMatrix, "matrix");
    p.k(paramRect, "cropRect");
    UICustomParam.a locala = new UICustomParam.a();
    locala.avX();
    locala.avW();
    locala.dZ(false);
    locala.avY();
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    paramMatrix = new Bundle();
    paramMatrix.putParcelable("cropRect", (Parcelable)paramRect);
    paramMatrix.putFloatArray("matrix", arrayOfFloat);
    paramMatrix.putFloatArray("offset", paramArrayOfFloat);
    if (paramInt == 2)
    {
      paramString = RecordConfigProvider.ay(paramString, "", "");
      paramString.scene = 11;
      paramString.HKT = locala.avZ();
      paramRect = com.tencent.mm.plugin.finder.storage.d.AjH;
      paramString.mfk = com.tencent.mm.plugin.finder.storage.d.dRJ();
      paramString.remuxType = 2;
      paramString.HKV = 3;
      paramString.HLb = (paramString.mfk.duration * 1000);
      locala.dY(false);
      paramString.mab = paramMatrix;
      paramString.G(2, FinderVideoEditPluginLayout.class.getName());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
      paramActivity = (Context)paramActivity;
      paramInt = b.a.anim_not_change;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(paramActivity, 1, paramInt, paramInt, paramString, 2, 0);
      AppMethodBeat.o(274073);
      return;
    }
    if (paramInt == 1)
    {
      locala.avV();
      paramString = RecordConfigProvider.jO(paramString, "");
      paramString.scene = 11;
      paramString.HKT = locala.avZ();
      paramString.mab = paramMatrix;
      paramString.G(1, FinderPhotoEditPluginLayout.class.getName());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
      paramActivity = (Context)paramActivity;
      paramInt = b.a.anim_not_change;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(paramActivity, 1, paramInt, paramInt, paramString, 1, 1);
    }
    AppMethodBeat.o(274073);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(274076);
    p.k(paramActivity, "context");
    p.k(paramString1, "inputPath");
    p.k(paramString2, "outputPath");
    paramString1 = RecordConfigProvider.jO(paramString1, paramString2);
    paramString1.scene = 11;
    paramString2 = new Bundle();
    paramString2.putFloat("crop_fix_ratio", 0.75F);
    paramString2.putInt("button_custom_color", paramInt2);
    paramString1.mab = paramString2;
    paramString1.G(1, FinderFixRatioPhoneEditPluginLayout.class.getName());
    CaptureDataManager.HKJ.a(null);
    paramString2 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
    paramActivity = (Context)paramActivity;
    paramInt2 = b.a.anim_not_change;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(paramActivity, paramInt1, paramInt2, paramInt2, paramString1, 1, 1);
    AppMethodBeat.o(274076);
  }
  
  public static void a(Context paramContext, final int paramInt, bak parambak, String paramString, long paramLong, final bid parambid, boolean paramBoolean)
  {
    AppMethodBeat.i(274123);
    p.k(paramContext, "context");
    p.k(parambak, "toUser");
    p.k(paramString, "lotteryId");
    if (parambak.SKV)
    {
      w.makeText(paramContext, b.j.finder_message_live_user_account_deleted, 0).show();
      AppMethodBeat.o(274123);
      return;
    }
    String str = parambak.username;
    parambak = str;
    if (str == null) {
      parambak = "";
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      ((ab)com.tencent.mm.kernel.h.ae(ab.class)).a(paramContext, paramInt, parambak, paramString, Long.valueOf(paramLong), i, (ab.a)new e(paramContext, parambid, paramInt));
      AppMethodBeat.o(274123);
      return;
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167836);
    p.k(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("FROM_SCENE_KEY", paramInt);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    localIntent.setClass(paramContext, FinderHomeUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167836);
  }
  
  public static void a(Context paramContext, arr paramarr, Intent paramIntent)
  {
    AppMethodBeat.i(274128);
    p.k(paramContext, "context");
    Object localObject1;
    if (paramarr != null)
    {
      localObject1 = paramarr.SEM;
      if (localObject1 != null)
      {
        localbac = ((FinderObject)localObject1).liveInfo;
        if (localbac != null) {
          break label618;
        }
      }
    }
    bac localbac = new bac();
    label77:
    label87:
    label97:
    label230:
    label615:
    label618:
    for (;;)
    {
      p.j(localbac, "prepareResp?.recover_liv…iveInfo?:FinderLiveInfo()");
      bbh localbbh;
      LinkedList localLinkedList1;
      bda localbda;
      LinkedList localLinkedList2;
      Integer localInteger;
      label110:
      Object localObject2;
      label123:
      bai localbai;
      Object localObject3;
      if (paramarr != null)
      {
        localbbh = paramarr.live_notice_info;
        if (paramarr == null) {
          break label542;
        }
        localLinkedList1 = paramarr.SEN;
        if (paramarr == null) {
          break label548;
        }
        localbda = paramarr.SEO;
        if (paramarr == null) {
          break label554;
        }
        localLinkedList2 = paramarr.SEP;
        if (paramarr == null) {
          break label560;
        }
        localInteger = Integer.valueOf(paramarr.SEQ);
        if (paramarr == null) {
          break label566;
        }
        localObject2 = Integer.valueOf(paramarr.SET);
        if (paramarr == null) {
          break label572;
        }
        localObject1 = paramarr.SEV;
        localbai = new bai();
        if (paramarr == null) {
          break label578;
        }
        localObject3 = paramarr.SEY;
        localbai.SEY = ((LinkedList)localObject3);
        localObject3 = com.tencent.c.a.a.a.a.a.Zlt;
        if (((Number)com.tencent.c.a.a.a.a.a.inb().aSr()).intValue() <= 0) {
          break label615;
        }
        localObject2 = com.tencent.c.a.a.a.a.a.Zlt;
        localObject2 = (Integer)com.tencent.c.a.a.a.a.a.inb().aSr();
        Log.i("Finder.ActivityRouter", "debug enterFinderLivePrepareUI maxUserCount ".concat(String.valueOf(localObject2)));
      }
      for (;;)
      {
        localObject3 = new bap();
        int i;
        label245:
        LiveConfig localLiveConfig;
        Object localObject4;
        if (paramarr != null)
        {
          i = paramarr.SER;
          ((bap)localObject3).SER = i;
          if (paramarr == null) {
            break label589;
          }
          i = paramarr.SES;
          ((bap)localObject3).SES = i;
          localLiveConfig = new LiveConfig.a().sP(LiveConfig.khW).Fx(localbac.liveId).Ni(z.bdh()).aJw();
          p.j(localLiveConfig, "builder.toWhere(LiveConf…e())\n            .build()");
          localObject4 = new StringBuilder("enterFinderLiveAnchorUI ").append(localLiveConfig.info()).append(", bgMusicInfo:");
          if (localObject1 != null) {
            break label609;
          }
        }
        for (paramarr = "";; paramarr = (arr)localObject1)
        {
          Log.i("Finder.ActivityRouter", com.tencent.mm.ae.g.bN(paramarr));
          localObject4 = new FinderLiveBundle();
          ((FinderLiveBundle)localObject4).yeC.add(localLiveConfig);
          ((FinderLiveBundle)localObject4).xPy = localbbh;
          ((FinderLiveBundle)localObject4).yeD = localbai;
          ((FinderLiveBundle)localObject4).yeE = localbac.SLU;
          ((FinderLiveBundle)localObject4).yeF = localLinkedList1;
          ((FinderLiveBundle)localObject4).yeG = localbda;
          ((FinderLiveBundle)localObject4).xQn = localLinkedList2;
          if (localInteger != null)
          {
            i = localInteger.intValue();
            ((FinderLiveBundle)localObject4).yeI = i;
            if (localObject2 == null) {
              break label599;
            }
            i = ((Integer)localObject2).intValue();
            ((FinderLiveBundle)localObject4).yeJ = i;
            ((FinderLiveBundle)localObject4).yeK = ((bap)localObject3).toByteArray();
            ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).cleatLiveStatusCache(localbac.liveId);
            paramarr = paramIntent;
            if (paramIntent == null) {
              paramarr = new Intent();
            }
            if (localObject1 == null) {
              break label604;
            }
          }
          for (paramIntent = ((ayk)localObject1).toByteArray();; paramIntent = null)
          {
            paramarr.putExtra("KEY_PARAMS_BG_MUSIC_ID_LIST", paramIntent);
            paramarr.putExtra("KEY_PARAMS_SOURCE_TYPE", localbac.SEl);
            c(paramContext, (FinderLiveBundle)localObject4, "", paramarr);
            AppMethodBeat.o(274128);
            return;
            localbbh = null;
            break;
            localLinkedList1 = null;
            break label77;
            localbda = null;
            break label87;
            localLinkedList2 = null;
            break label97;
            localInteger = null;
            break label110;
            localObject2 = null;
            break label123;
            localObject1 = null;
            break label133;
            localObject3 = null;
            break label152;
            i = 0;
            break label230;
            i = 0;
            break label245;
            i = 0;
            break label420;
            i = 0;
            break label437;
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, ass paramass, Intent paramIntent)
  {
    AppMethodBeat.i(167847);
    p.k(paramContext, "context");
    p.k(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.j localj = com.tencent.mm.plugin.finder.search.j.Acs;
    com.tencent.mm.plugin.finder.search.j.a(paramass);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchUI.class);
    paramass = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramass.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramass.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167847);
  }
  
  public static void a(final Context paramContext, final String paramString, aza paramaza)
  {
    AppMethodBeat.i(274120);
    p.k(paramContext, "context");
    p.k(paramString, "fromUsername");
    p.k(paramaza, "toUser");
    if (paramaza.SKV)
    {
      w.makeText(paramContext, b.j.finder_message_live_user_account_deleted, 0).show();
      AppMethodBeat.o(274120);
      return;
    }
    Object localObject = paramaza.contact;
    if (localObject != null)
    {
      localObject = ((FinderContact)localObject).username;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      p.j(localObject, "toUser.contact?.username?:\"\"");
      Log.i("Finder.ActivityRouter", "[enterChattingUIFromLive] fromUsername=" + paramString + " toUsername=" + (String)localObject + " scene=1");
      ai.a locala = ai.xca;
      ai.b(paramaza.SHN);
      ((ab)com.tencent.mm.kernel.h.ae(ab.class)).a(paramContext, (String)localObject, (ab.a)new d((String)localObject, paramContext, paramString));
      AppMethodBeat.o(274120);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(274080);
    p.k(paramContext, "context");
    p.k(paramString1, "appId");
    p.k(paramString2, "enterPath");
    p.k(paramString3, "sceneNote");
    Log.i("Finder.ActivityRouter", "enter we app appId:" + paramString1 + ",enterPath:" + paramString2 + ",scene:" + paramInt + ",sceneNote:" + paramString3);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(274080);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramString1;
    localg.nBq = paramString2;
    localg.scene = paramInt;
    localg.fvd = paramString3;
    paramString1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    localg.cBU = com.tencent.mm.plugin.finder.live.utils.a.dEO();
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramContext, localg);
    AppMethodBeat.o(274080);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, Boolean paramBoolean)
  {
    AppMethodBeat.i(274082);
    p.k(paramContext, "context");
    p.k(paramString1, "appName");
    p.k(paramString2, "enterPath");
    p.k(paramString3, "sceneNote");
    Log.i("Finder.ActivityRouter", "enter we app appId:" + paramString1 + ",enterPath:" + paramString2 + ",scene:" + paramInt + ",sceneNote:" + paramString3);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(274082);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.username = paramString1;
    localg.nBq = paramString2;
    localg.scene = paramInt;
    localg.fvd = paramString3;
    if (p.h(paramBoolean, Boolean.TRUE)) {
      localg.cBU = 2;
    }
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramContext, localg);
    AppMethodBeat.o(274082);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, final bid parambid)
  {
    AppMethodBeat.i(274122);
    p.k(paramContext, "context");
    p.k(paramString1, "sessionId");
    p.k(paramString2, "username");
    ((ab)com.tencent.mm.kernel.h.ae(ab.class)).a(paramContext, paramString1, paramString2, Long.valueOf(paramLong1), Long.valueOf(paramLong2), (ab.a)new b(paramContext, parambid));
    AppMethodBeat.o(274122);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, final bid parambid)
  {
    AppMethodBeat.i(274121);
    p.k(paramContext, "context");
    p.k(paramString1, "sessionId");
    p.k(paramString2, "fansId");
    ((ab)com.tencent.mm.kernel.h.ae(ab.class)).a(paramContext, paramString1, paramString2, (ab.a)new c(paramContext, parambid));
    AppMethodBeat.o(274121);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(274132);
    p.k(paramContext, "context");
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
    ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).cleatLiveStatusCache(paramLong2);
    paramString1 = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    localIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.enQ());
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveInvitedUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveInvitedUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274132);
  }
  
  public static void a(Intent paramIntent, Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, Integer paramInteger, int paramInt2)
  {
    AppMethodBeat.i(274124);
    p.k(paramContext, "context");
    p.k(paramString1, "anchorUserName");
    p.k(paramString2, "nonceId");
    p.k(paramString3, "desc");
    p.k(paramString4, "contextId");
    paramString2 = new LiveConfig.a().sP(LiveConfig.khX).Fx(paramLong2).Nf(paramString2).Nj(paramString7);
    int i;
    if (paramInteger != null)
    {
      i = paramInteger.intValue();
      paramString3 = paramString2.sQ(i).Fy(paramLong1).Ni(paramString1).Nk(paramString3).No(paramString5).Np(paramString6);
      if (paramIntent != null)
      {
        paramString2 = paramIntent.getStringExtra("Contact_Scene_Note");
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      paramString1 = paramString3.Nq(paramString1).aJw();
      p.j(paramString1, "builder.toWhere(LiveConf… \"\")\n            .build()");
      paramString2 = new FinderLiveBundle();
      paramString2.yeC.add(paramString1);
      paramString2.extFlag = paramInt1;
      paramString2.xkX = paramInt2;
      if (paramIntent == null) {
        break label287;
      }
      paramInt1 = paramIntent.getIntExtra("key_enter_live_param_visitor_enter_scene", 0);
      label215:
      switch (paramInt1)
      {
      }
    }
    for (paramInt1 = paramString2.yeH;; paramInt1 = 1)
    {
      paramString2.yeH = paramInt1;
      a(paramContext, paramString2, paramString4, null, paramIntent, 8);
      AppMethodBeat.o(274124);
      return;
      paramString7 = e.b.kjz;
      i = e.b.aJK();
      break;
      label287:
      paramInt1 = 0;
      break label215;
    }
  }
  
  public static void a(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274064);
    p.k(paramMMActivity, "activity");
    p.k(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.j localj = com.tencent.mm.plugin.finder.search.j.Acs;
    com.tencent.mm.plugin.finder.search.j.a(null);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass((Context)paramMMActivity, FinderContactSearchIncludeFollowUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20000);
    AppMethodBeat.o(274064);
  }
  
  public static void a(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167869);
    p.k(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderSelectSexUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(167869);
  }
  
  public static void a(MMFragmentActivity paramMMFragmentActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274106);
    p.k(paramMMFragmentActivity, "context");
    paramIntent.setClass((Context)paramMMFragmentActivity, FinderCommentUI.class);
    paramMMFragmentActivity.startActivityForResult(paramIntent, 500);
    paramMMFragmentActivity.overridePendingTransition(0, 0);
    AppMethodBeat.o(274106);
  }
  
  public static boolean aE(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(274060);
    p.k(paramContext, "context");
    p.k(paramString, "userName");
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    paramString = d.a.aAP(paramString);
    if (paramString != null)
    {
      if (paramString.wZR == 1)
      {
        localObject = paramString.wZS;
        if (localObject != null)
        {
          if (((CharSequence)localObject).length() > 0) {
            i = 1;
          }
          if (i == 1)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramString.wZS);
            com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          }
        }
        AppMethodBeat.o(274060);
        return true;
      }
      AppMethodBeat.o(274060);
      return false;
    }
    AppMethodBeat.o(274060);
    return false;
  }
  
  public static void aF(final Context paramContext, String paramString)
  {
    AppMethodBeat.i(274119);
    p.k(paramContext, "context");
    p.k(paramString, "username");
    Log.i("Finder.ActivityRouter", "[startChattingUI] username=" + paramString + " scene=2");
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VyS, 1);
    localObject = (ab)com.tencent.mm.kernel.h.ae(ab.class);
    aj localaj = aj.AGc;
    ((ab)localObject).a(paramContext, aj.eey(), paramString, i, (ab.a)new f(paramString, paramContext));
    AppMethodBeat.o(274119);
  }
  
  public static void aG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(274152);
    p.k(paramContext, "context");
    p.k(paramString, "type");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderBlockListSearchUI.class);
      localObject = FinderBlockListSearchUI.Aos;
      localIntent.putExtra(FinderBlockListSearchUI.dZN(), paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListSearchUI", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListSearchUI", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274152);
      return;
    }
  }
  
  public static void aa(final Context paramContext, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(274111);
    p.k(paramContext, "context");
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      if (paramIntent != null) {}
      for (Object localObject1 = Boolean.valueOf(paramIntent.getBooleanExtra("key_finder_teen_mode_check", false)); ((Boolean)localObject1).booleanValue(); localObject1 = null)
      {
        localObject1 = ah.AmB;
        ah.a.a(paramContext, paramIntent, (ae.a)new a(paramIntent, paramContext));
        AppMethodBeat.o(274111);
        return;
      }
      localObject1 = localObject2;
      if (!(paramContext instanceof Activity)) {
        localObject1 = paramIntent;
      }
      if (localObject1 != null) {
        ((Intent)localObject1).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderActivityProfileUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterActivityProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterActivityProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274111);
      return;
    }
  }
  
  public static void ab(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274112);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderAtTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext = com.tencent.mm.plugin.finder.report.n.zWF;
      paramContext = new cf();
      paramContext.fd(cm.bfD());
      paramContext.lX(z.bdh());
      paramContext.lY(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr());
      paramContext.bpa();
      com.tencent.mm.plugin.finder.report.n.a((com.tencent.mm.plugin.report.a)paramContext);
      AppMethodBeat.o(274112);
      return;
    }
  }
  
  public static void ac(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274114);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderPostPreviewUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPreviewAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPreviewAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274114);
      return;
    }
  }
  
  public static void ad(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274133);
    p.k(paramContext, "context");
    paramIntent.setClass(paramContext, FinderSnsGridFeedUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSnsGridFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSnsGridFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274133);
  }
  
  public static void ae(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274135);
    p.k(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderLiveFansListUI");
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.enP());
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274135);
  }
  
  public static void af(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274136);
    p.k(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderGameLivePostUI");
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
      localIntent.setClass(paramContext, FinderGameLivePostUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLivePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLivePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274136);
      return;
    }
  }
  
  public static void ag(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274138);
    p.k(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderGameSelectUI");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderGameSelectUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameSelectUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameSelectUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274138);
      return;
    }
  }
  
  public static void ah(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274140);
    p.k(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderGameLiveFinishUI");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderGameLiveFinishUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLiveFinishUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLiveFinishUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274140);
      return;
    }
  }
  
  public static void ai(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274141);
    p.k(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderGameLiveSearchUI");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderGameSearchUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274141);
      return;
    }
  }
  
  public static void aj(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274142);
    p.k(paramContext, "context");
    Log.i("Finder.ActivityRouter", "FinderGameLivePostVerifyUI");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderGameLivePostVerifyUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLivePostVerifyUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLivePostVerifyUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274142);
      return;
    }
  }
  
  public static void ak(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274143);
    p.k(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderLiveCountDownUI");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localObject = com.tencent.mm.plugin.findersdk.e.a.Bxf;
      paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.enT());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveCountDownUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveCountDownUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274143);
      return;
    }
  }
  
  public static void al(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274144);
    p.k(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderLiveWeCoinHotUI");
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.enU());
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveWeCoinHotUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveWeCoinHotUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274144);
  }
  
  private static void am(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(274150);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderBlockListUI.class);
      localIntent.putExtra("BLOCK_LIST_TYPE", paramInt);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListUi", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListUi", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274150);
      return;
    }
  }
  
  public static void ao(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274154);
    p.k(paramContext, "context");
    paramIntent.setClass(paramContext, FinderAccountManagent.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAccountManagementUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAccountManagementUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274154);
  }
  
  public static void ap(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274157);
    p.k(paramContext, "context");
    p.k(paramIntent, "intent");
    com.tencent.mm.plugin.finder.search.j localj = com.tencent.mm.plugin.finder.search.j.Acs;
    com.tencent.mm.plugin.finder.search.j.a(null);
    paramIntent.setClass(paramContext, FinderFansSearchUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274157);
  }
  
  public static void aq(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274162);
    p.k(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274162);
      return;
    }
  }
  
  public static void ar(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274163);
    p.k(paramContext, "context");
    paramIntent.setClass(paramContext, FinderPoiTimelineUI.class);
    aj.a locala = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    aj.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274163);
  }
  
  public static void as(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274176);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderLiveNoticeQRCodeUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveNoticeQrCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveNoticeQrCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274176);
      return;
    }
  }
  
  public static void b(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274084);
    p.k(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderFavTimelineUI.class);
    aj.a locala = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    aj.a.a((Context)paramActivity, paramIntent, 0L, 0, false, 124);
    paramActivity.startActivityForResult(paramIntent, 10001);
    AppMethodBeat.o(274084);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(274053);
    p.k(paramActivity, "activity");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(67108864);
    localIntent.setClass((Context)paramActivity, FinderCreateContactUI.class);
    paramActivity.startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(274053);
  }
  
  public static void b(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(274104);
    p.k(paramContext, "context");
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
      localIntent.setClass(paramContext, FinderGalleryUI.class);
      if (!(paramContext instanceof Activity)) {
        break;
      }
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      AppMethodBeat.o(274104);
      return;
    }
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGalleryUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGalleryUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274104);
  }
  
  public static void b(Context paramContext, ass paramass, Intent paramIntent)
  {
    AppMethodBeat.i(274065);
    p.k(paramContext, "context");
    p.k(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.j localj = com.tencent.mm.plugin.finder.search.j.Acs;
    com.tencent.mm.plugin.finder.search.j.a(paramass);
    paramIntent.setClass(paramContext, FinderFeedSearchUI.class);
    paramass = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramass.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramass.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1265L, 1L, 1L, false);
    AppMethodBeat.o(274065);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(274172);
    p.k(paramContext, "context");
    p.k(paramString1, "appId");
    p.k(paramString2, "enterPath");
    Log.i("Finder.ActivityRouter", "[enterWeAppForRedDot] appId=" + paramString1 + " enterPath=" + paramString2 + " scene=" + paramInt);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.username = paramString1;
    localg.nBq = Util.nullAs(paramString2, "");
    localg.scene = paramInt;
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramContext, localg);
    AppMethodBeat.o(274172);
  }
  
  public static void b(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(167842);
    p.k(paramIntent1, "intent");
    p.k(paramIntent2, "curIntent");
    paramIntent1.putExtra("key_finder_post_from", paramIntent2.getIntExtra("key_finder_post_from", -1));
    AppMethodBeat.o(167842);
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274103);
    p.k(paramMMActivity, "context");
    if (!(paramMMActivity instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass((Context)paramMMActivity, FinderTimelineLbsUI.class);
      paramMMActivity.startActivityForResult(paramIntent, 19999);
      AppMethodBeat.o(274103);
      return;
    }
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(274083);
    p.k(paramMMActivity, "context");
    paramIntent.setClass((Context)paramMMActivity, FinderFavFeedUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(274083);
  }
  
  public static int c(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(274126);
    p.k(paramContext, "context");
    p.k(paramFinderLiveBundle, "config");
    p.k(paramString1, "contextId");
    p.k(paramString2, "clickTabContextId");
    Log.i("Finder.ActivityRouter", "[enterFinderLiveVisitorUI] " + paramFinderLiveBundle + ",contextId:" + paramString1 + ",clickTabContextId:" + paramString2);
    Object localObject1 = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
    Object localObject2 = paramFinderLiveBundle.dyk();
    if (localObject2 != null) {}
    for (long l = ((LiveConfig)localObject2).getLiveId();; l = 0L)
    {
      ((com.tencent.c.a.a.a.b)localObject1).cleatLiveStatusCache(l);
      if ((paramFinderLiveBundle.extFlag & 0x4) <= 0) {
        break;
      }
      ((com.tencent.mm.plugin.festival.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.festival.a.a.class)).fp(paramContext);
      AppMethodBeat.o(274126);
      return 0;
    }
    localObject2 = com.tencent.mm.plugin.finder.live.model.t.yga;
    p.k(paramContext, "context");
    p.k(paramFinderLiveBundle, "config");
    p.k(paramString1, "contextId");
    p.k(paramString2, "clickTabContextId");
    localObject1 = com.tencent.mm.plugin.findersdk.f.b.Bxg;
    com.tencent.mm.plugin.findersdk.f.b.hA("goVisitorUIWithCheck", "init goVisitorUIWithCheck contextId:" + paramString1 + ' ' + paramFinderLiveBundle + ' ');
    if (paramIntent != null)
    {
      localObject1 = paramIntent.getStringExtra("key_enter_live_param_share_username");
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      if (paramIntent != null)
      {
        i = paramIntent.getIntExtra("key_enter_live_param_from_share_scene", 0);
        localObject3 = paramFinderLiveBundle.dyk();
        if (localObject3 != null) {
          ((LiveConfig)localObject3).Nd((String)localObject1);
        }
        localObject1 = paramFinderLiveBundle.dyk();
        if (localObject1 != null) {
          ((LiveConfig)localObject1).sO(i);
        }
        localObject1 = paramFinderLiveBundle.dyk();
        if (localObject1 != null)
        {
          l = ((LiveConfig)localObject1).getLiveId();
          localObject1 = ar.AIS;
          localObject3 = new StringBuilder();
          localObject4 = ar.AIS;
          localObject3 = ar.efV() + l;
          p.k(localObject3, "id");
          ar.AIP.clear();
          ((Map)ar.AIP).put(localObject3, new aw(cm.bfC(), 0));
          localObject4 = ap.AIh;
          ar.a((ar)localObject1, (String)localObject3, ap.efr().name, null, true, false, false, 52);
        }
        com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.festival.a.a.class);
        localObject3 = new aa.d();
        ((aa.d)localObject3).aaBA = 0;
        localObject4 = new aa.f();
        ((aa.f)localObject4).aaBC = paramString1;
        paramString1 = (CharSequence)((aa.f)localObject4).aaBC;
        if ((paramString1 != null) && (paramString1.length() != 0)) {
          break label787;
        }
      }
      label787:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramString1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramString1 = aj.a.fZ(paramContext);
          if (paramString1 != null)
          {
            localObject1 = paramString1.wmL;
            paramString1 = (String)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramString1 = "";
          }
          ((aa.f)localObject4).aaBC = paramString1;
          Log.i("Finder.LiveJumpChecker", "goVisitorUIWithCheck locContextId:" + (String)((aa.f)localObject4).aaBC);
        }
        paramString1 = new aa.f();
        localObject1 = paramContext.getResources().getString(b.j.app_i_know);
        p.j(localObject1, "context.resources.getString(R.string.app_i_know)");
        paramString1.aaBC = localObject1;
        paramString1 = ((com.tencent.mm.plugin.finder.live.model.t)localObject2).I((kotlin.g.a.a)new t.h(paramContext, paramString1, (aa.d)localObject3));
        if (paramString1 != null)
        {
          paramString1 = paramString1.L((kotlin.g.a.a)new t.i(paramContext, (aa.d)localObject3));
          if (paramString1 != null)
          {
            paramString1 = paramString1.J((kotlin.g.a.a)new t.j(paramContext, (aa.d)localObject3));
            if (paramString1 != null)
            {
              paramString1 = paramString1.b(false, (kotlin.g.a.b)new t.k(paramFinderLiveBundle, paramContext, (aa.f)localObject4, paramIntent, (aa.d)localObject3));
              if (paramString1 != null)
              {
                paramString1 = paramString1.a(paramContext, (kotlin.g.a.a)new t.l(paramContext, (aa.d)localObject3));
                if (paramString1 != null)
                {
                  paramString1 = paramString1.K((kotlin.g.a.a)new t.m(paramContext, (aa.d)localObject3));
                  if ((paramString1 != null) && (paramString1.b(false, (kotlin.g.a.a)t.n.ygg) != null)) {
                    com.tencent.mm.plugin.finder.live.model.t.a(paramContext, paramFinderLiveBundle, (String)((aa.f)localObject4).aaBC, paramString2, paramIntent);
                  }
                }
              }
            }
          }
        }
        i = ((aa.d)localObject3).aaBA;
        AppMethodBeat.o(274126);
        return i;
        i = 0;
        break;
      }
    }
  }
  
  public static void c(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274086);
    p.k(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderLbsStreamListUI.class);
    paramActivity.startActivityForResult(paramIntent, 501);
    AppMethodBeat.o(274086);
  }
  
  public static void c(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167863);
    p.k(paramActivity, "context");
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
  
  public static void c(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(274168);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i;
    int j;
    if (!localf.aHp().getBoolean(ar.a.Vyj, false))
    {
      i = 1;
      if (paramString == null) {
        break label207;
      }
      if (((CharSequence)paramString).length() <= 0) {
        break label201;
      }
      j = 1;
      label71:
      if (j != 1) {
        break label207;
      }
    }
    for (;;)
    {
      paramString = Uri.parse(paramString).buildUpon();
      p.j(paramString, "Uri.parse(urlStr).buildUpon()");
      paramString.appendQueryParameter("SourceScene", String.valueOf(paramInt));
      paramString = paramString.build().toString();
      p.j(paramString, "builder.build().toString()");
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("KRightBtn", true);
      localIntent.putExtra("rawUrl", paramString);
      com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      if (i != 0)
      {
        paramContext = com.tencent.mm.kernel.h.aHG();
        p.j(paramContext, "MMKernel.storage()");
        paramContext.aHp().set(ar.a.Vyj, Boolean.TRUE);
      }
      AppMethodBeat.o(274168);
      return;
      i = 0;
      break;
      label201:
      j = 0;
      break label71;
      label207:
      if (i != 0) {
        paramString = "https://channels.weixin.qq.com/mobile-support/pages/anchor-tasks/whatsnew";
      } else {
        paramString = "https://channels.weixin.qq.com/mobile-support/pages/anchor-tasks/tasks";
      }
    }
  }
  
  public static void c(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(274131);
    p.k(paramContext, "context");
    p.k(paramFinderLiveBundle, "config");
    p.k(paramString, "contextId");
    Log.i("Finder.ActivityRouter", "[enterFinderLiveAnchorUI] ".concat(String.valueOf(paramFinderLiveBundle)));
    com.tencent.mm.plugin.finder.live.model.t.a(com.tencent.mm.plugin.finder.live.model.t.yga, paramContext, paramFinderLiveBundle, paramString, paramIntent);
    AppMethodBeat.o(274131);
  }
  
  public static void c(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274108);
    p.k(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderActivityPostUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20002);
    AppMethodBeat.o(274108);
  }
  
  public static void c(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(274107);
    p.k(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderPostAtUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(274107);
  }
  
  public static boolean c(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(274058);
    p.k(paramContext, "context");
    p.k(paramString, "intentString");
    p.k(paramIntent, "extra");
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = e.bCW(paramString);
        Parcel localParcel = Parcel.obtain();
        p.j(localParcel, "Parcel.obtain()");
        localParcel.unmarshall(paramString, 0, paramString.length);
        localParcel.setDataPosition(0);
        paramString = (Intent)Intent.CREATOR.createFromParcel(localParcel);
        paramString.setExtrasClassLoader(LocalVideoCropInfoParcelable.CREATOR.getClass().getClassLoader());
        paramString.putExtras(paramIntent);
        if (!Util.isNullOrNil(paramString.getStringExtra("saveText"))) {
          D(paramContext, paramString);
        }
        for (;;)
        {
          AppMethodBeat.o(274058);
          return true;
          enterFinderPostUI(paramContext, paramString);
        }
        AppMethodBeat.o(274058);
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
    AppMethodBeat.i(274155);
    p.k(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.enV());
    paramActivity.startActivityForResult(paramIntent, 1002);
    AppMethodBeat.o(274155);
  }
  
  public static void d(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(274166);
    p.k(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.enG());
    paramActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(274166);
  }
  
  public static void d(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(274075);
    p.k(paramActivity, "context");
    p.k(paramString1, "inputPath");
    p.k(paramString2, "outputPath");
    paramString1 = RecordConfigProvider.jO(paramString1, paramString2);
    paramString1.scene = 11;
    paramString2 = new Bundle();
    paramString2.putFloat("crop_fix_ratio", 0.75F);
    paramString1.mab = paramString2;
    paramString1.G(1, FinderFixRatioPhoneEditPluginLayout.class.getName());
    CaptureDataManager.HKJ.a(null);
    paramString2 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
    paramActivity = (Context)paramActivity;
    int i = b.a.anim_not_change;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(paramActivity, 20002, i, i, paramString1, 1, 1);
    AppMethodBeat.o(274075);
  }
  
  public static void d(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(274145);
    p.k(paramContext, "context");
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
        break label90;
      }
      localIntent.setClass(paramContext, FinderLongVideoDetailUI.class);
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {
        break label102;
      }
      ((Activity)paramContext).startActivityForResult(localIntent, 101);
      AppMethodBeat.o(274145);
      return;
      paramIntent = null;
      break;
      label90:
      localIntent.setClass(paramContext, FinderLongVideoTimelineUI.class);
    }
    label102:
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMegaVideoTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMegaVideoTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274145);
  }
  
  public static void d(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274110);
    p.k(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderActivityDescUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20002);
    AppMethodBeat.o(274110);
  }
  
  public static void e(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274156);
    p.k(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.enK());
    paramActivity.startActivityForResult(paramIntent, 1001);
    AppMethodBeat.o(274156);
  }
  
  public static void e(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(274147);
    p.k(paramContext, "context");
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
        break label147;
      }
    }
    label147:
    for (paramIntent = FinderFloatBallDetailUI.class;; paramIntent = FinderMultiTaskUI.class)
    {
      localIntent.setClass(paramContext, paramIntent);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFloatBallDetailUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFloatBallDetailUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274147);
      return;
      paramIntent = null;
      break;
    }
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(274081);
    p.k(paramContext, "context");
    p.k(paramString1, "appId");
    p.k(paramString2, "enterPath");
    p.k(paramString3, "sceneNote");
    Log.i("Finder.ActivityRouter", "enterShoppingWeApp appId:" + paramString1 + ",enterPath:" + paramString2 + ",scene:1195,sceneNote:" + paramString3);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(274081);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramString1;
    localg.nBq = paramString2;
    localg.scene = 1195;
    localg.fvd = paramString3;
    paramString1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    localg.cBU = com.tencent.mm.plugin.finder.live.utils.a.dEO();
    localg.nBE = new HalfScreenConfig(true, 0, null, false, null, false, null, HalfScreenConfig.c.nZV, false, true, null, null, false, 7550);
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramContext, localg);
    AppMethodBeat.o(274081);
  }
  
  public static void e(String paramString, Context paramContext)
  {
    AppMethodBeat.i(167867);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localIntent.putExtra("Contact_User", str);
    com.tencent.mm.by.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(167867);
  }
  
  public static void enterAlbumRelatedTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274094);
    p.k(paramContext, "context");
    Object localObject = com.tencent.mm.kernel.h.ae(ae.class);
    p.j(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ae)localObject).dYT())
    {
      ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(paramContext);
      Log.w("Finder.ActivityRouter", "青少年模式只看关注时，禁止进入专辑.");
      AppMethodBeat.o(274094);
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
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        aj.a.a(paramContext, paramIntent, 0L, 0, false, 124);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAlbumRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAlbumRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(274094);
        return;
      }
    }
  }
  
  public static void enterFinderFollowListUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274054);
    p.k(paramContext, "context");
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
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        aj.a.a(paramContext, paramIntent, 0L, 0, false, 124);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFollowListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFollowListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(274054);
        return;
      }
    }
  }
  
  public static void enterFinderGameLiveAuthUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274139);
    p.k(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderGameLiveAuthUI");
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
      localIntent.setClass(paramContext, FinderGameLiveAuthUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLiveAuthUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLiveAuthUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274139);
      return;
    }
  }
  
  public static void enterFinderPostRouterUI(Context paramContext, Intent paramIntent)
  {
    Object localObject3 = null;
    AppMethodBeat.i(167841);
    p.k(paramContext, "context");
    Object localObject1 = com.tencent.mm.plugin.finder.upload.d.AzT;
    if (!com.tencent.mm.plugin.finder.upload.d.cameraCheck(paramContext))
    {
      Log.i("Finder.ActivityRouter", "enterFinderPostRouterUI cameraCheck false!");
      AppMethodBeat.o(167841);
      return;
    }
    localObject1 = paramIntent;
    if (paramIntent == null) {
      localObject1 = new Intent();
    }
    if (!(paramContext instanceof AppCompatActivity)) {}
    for (paramIntent = null;; paramIntent = paramContext)
    {
      if ((AppCompatActivity)paramIntent != null)
      {
        paramIntent = com.tencent.mm.ui.component.g.Xox;
        paramIntent = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).wmL;
        if (paramIntent != null) {
          break label300;
        }
        paramIntent = "";
      }
      label300:
      for (;;)
      {
        Object localObject2 = com.tencent.mm.ui.component.g.Xox;
        String str = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).sessionId;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        ((Intent)localObject1).putExtra("key_finder_context_id", paramIntent);
        ((Intent)localObject1).putExtra("key_finder_session_id", (String)localObject2);
        paramIntent = localObject3;
        if (!(paramContext instanceof Activity)) {
          paramIntent = (Intent)localObject1;
        }
        if (paramIntent != null) {
          paramIntent.addFlags(268435456);
        }
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).setClass(paramContext, FinderPostRouterUI.class);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
        }
        AppMethodBeat.o(167841);
        return;
      }
    }
  }
  
  public static void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167840);
    p.k(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167840);
      return;
    }
  }
  
  public static void enterFinderProfileUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167843);
    p.k(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.getStringExtra("finder_username");
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderProfileUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167843);
      return;
    }
  }
  
  public static void enterFinderSelfUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274062);
    p.k(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274062);
      return;
    }
  }
  
  public static boolean fE(Context paramContext)
  {
    AppMethodBeat.i(274055);
    p.k(paramContext, "context");
    AppMethodBeat.o(274055);
    return false;
  }
  
  public static void fG(Context paramContext)
  {
    AppMethodBeat.i(167859);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      aj.a.a(paramContext, localIntent, 0L, 0, false, 124);
      localIntent.setClass(paramContext, FinderWxMsgUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167859);
      return;
    }
  }
  
  public static void fH(Context paramContext)
  {
    AppMethodBeat.i(167861);
    p.k(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramContext, FinderSelfQRCodeUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167861);
  }
  
  public static void fI(Context paramContext)
  {
    AppMethodBeat.i(167866);
    p.k(paramContext, "context");
    Object localObject = new Intent(paramContext, FinderUnOpenUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167866);
  }
  
  public static void fJ(Context paramContext)
  {
    AppMethodBeat.i(274091);
    p.k(paramContext, "context");
    am(paramContext, 1);
    AppMethodBeat.o(274091);
  }
  
  public static void fK(Context paramContext)
  {
    AppMethodBeat.i(274100);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderFinderSysMsgUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274100);
      return;
    }
  }
  
  public static void fL(Context paramContext)
  {
    AppMethodBeat.i(274102);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderFansListUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274102);
      return;
    }
  }
  
  public static void fR(Context paramContext)
  {
    AppMethodBeat.i(274153);
    p.k(paramContext, "context");
    Object localObject1 = af.aaBG;
    localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.VCn, "");
    if (localObject2 == null)
    {
      paramContext = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(274153);
      throw paramContext;
    }
    localObject1 = String.format((String)localObject2 + "?wechat_real_lang=%s&username=%s", Arrays.copyOf(new Object[] { LocaleUtil.getApplicationLanguage(), z.bdh() }, 2));
    p.j(localObject1, "java.lang.String.format(format, *args)");
    localObject2 = aj.AGc;
    if (aj.eej()) {
      w.makeText(paramContext, (CharSequence)"url:".concat(String.valueOf(localObject1)), 1).show();
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
    localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
    com.tencent.mm.plugin.finder.report.n.b(paramContext, 9L, 1L);
    AppMethodBeat.o(274153);
  }
  
  public static void g(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274160);
    p.k(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.enS());
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryDetailUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryDetailUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274160);
  }
  
  public static void g(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(274078);
    p.k(paramActivity, "context");
    Bundle localBundle = new Bundle();
    String str;
    if (Util.isNullOrNil(paramString))
    {
      paramString = paramActivity.getComponentName();
      p.j(paramString, "context.componentName");
      str = paramString.getClassName();
      p.j(str, "context.componentName.className");
      paramString = MMApplicationContext.getSourcePackageName() + ".plugin.finder";
      if (!kotlin.n.n.M(str, paramString, false)) {
        break label215;
      }
      int i = paramString.length();
      if (str == null)
      {
        paramActivity = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(274078);
        throw paramActivity;
      }
      paramString = str.substring(i);
      p.j(paramString, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      Log.i("Finder.ActivityRouter", "fullActivity " + str + ", fromActivity " + paramString);
      localBundle.putString("realname_verify_process_jump_activity", paramString);
      for (;;)
      {
        localBundle.putString("realname_verify_process_jump_plugin", "finder");
        ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wxpaysdk.api.c.class)).h(paramActivity, localBundle);
        AppMethodBeat.o(274078);
        return;
        localBundle.putString("realname_verify_process_jump_activity", paramString);
      }
      label215:
      paramString = str;
    }
  }
  
  public static void h(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274161);
    p.k(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.enR());
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryWinnerListUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryWinnerListUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274161);
  }
  
  public static void h(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(167864);
    p.k(paramActivity, "context");
    if ((Util.isNullOrNil(paramString)) && (!(paramActivity instanceof FinderHomeUI)) && (!(paramActivity instanceof FinderTimelineUI)) && (!(paramActivity instanceof FinderSelfUI)))
    {
      paramString = new Intent();
      paramString.setClass((Context)paramActivity, OccupyFinderUI5.class);
      paramString.putExtra("enterRealnameVerifyUI", true);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRealnameVerifyUI", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRealnameVerifyUI", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167864);
      return;
    }
    g(paramActivity, paramString);
    AppMethodBeat.o(167864);
  }
  
  public static void i(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274165);
    p.k(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.enI());
    paramActivity.startActivityForResult(paramIntent, 1);
    AppMethodBeat.o(274165);
  }
  
  public static void j(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274167);
    p.k(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderAtFeedManageUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtFeedManageUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtFeedManageUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274167);
  }
  
  public static void k(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(274175);
    p.k(paramActivity, "activity");
    paramIntent.setClass((Context)paramActivity, OccupyFinderUI4.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderAnchorVerifyWebviewUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderAnchorVerifyWebviewUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(274175);
  }
  
  public static void w(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167838);
    p.k(paramContext, "context");
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
      localIntent.setClass(paramContext, FinderCreateContactUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167838);
      return;
    }
  }
  
  public static void x(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274059);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.addFlags(67108864);
      paramIntent.setClass(paramContext, FinderSharePostUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSharePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSharePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274059);
      return;
    }
  }
  
  public static void y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167844);
    p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderProfileTimeLineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167844);
      return;
    }
  }
  
  public static void z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(274061);
    p.k(paramContext, "context");
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
      localIntent.setClass(paramContext, FinderSettingInfoUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(274061);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "canGotoFinderPage", "", "onDone"})
  static final class a
    implements ae.a
  {
    a(Intent paramIntent, Context paramContext) {}
    
    public final void oa(boolean paramBoolean)
    {
      AppMethodBeat.i(278888);
      if (paramBoolean)
      {
        Object localObject = this.$intent;
        if (localObject == null) {
          p.iCn();
        }
        ((Intent)localObject).putExtra("key_finder_teen_mode_check", false);
        localObject = a.ACH;
        a.aa(paramContext, this.$intent);
      }
      AppMethodBeat.o(278888);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class b
    implements ab.a
  {
    b(Context paramContext, bid parambid) {}
    
    public final void l(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(284539);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(284539);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class c
    implements ab.a
  {
    c(Context paramContext, bid parambid) {}
    
    public final void l(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(278588);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(278588);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class d
    implements ab.a
  {
    d(String paramString1, Context paramContext, String paramString2) {}
    
    public final void l(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(282135);
      Log.i("Finder.ActivityRouter", "[enterChattingUIFromLive] toUsername=" + this.ACK + " sessionId=" + paramString1);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(282135);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class e
    implements ab.a
  {
    e(Context paramContext, bid parambid, int paramInt) {}
    
    public final void l(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(290264);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(290264);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class f
    implements ab.a
  {
    f(String paramString, Context paramContext) {}
    
    public final void l(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(223213);
      Log.i("Finder.ActivityRouter", "[enterChattingUI] ]username=" + this.kyF + " sessionId=" + paramString1);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(223213);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "canGotoFinderPage", "", "onDone"})
  static final class g
    implements ae.a
  {
    g(Intent paramIntent, Context paramContext) {}
    
    public final void oa(boolean paramBoolean)
    {
      AppMethodBeat.i(290043);
      if (paramBoolean)
      {
        Object localObject = this.$intent;
        if (localObject == null) {
          p.iCn();
        }
        ((Intent)localObject).putExtra("key_finder_teen_mode_check", false);
        localObject = a.ACH;
        a.O(paramContext, this.$intent);
      }
      AppMethodBeat.o(290043);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.a
 * JD-Core Version:    0.7.0.1
 */