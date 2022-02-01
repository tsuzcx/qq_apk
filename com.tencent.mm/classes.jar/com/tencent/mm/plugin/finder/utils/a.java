package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.dg;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.ShareActionConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.activity.FinderActivityProfileUI;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.d.a.a;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.bb.a;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ui.BizProfileTimelineUI;
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
import com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGallerySearchUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGalleryTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGalleryUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderHotWordFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoDetailUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoPreviewUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderMultiTaskUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiManageUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiRelateListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRealnameVerifyRouteUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRelatedFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRelatedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRetransmitSourceUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI26;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI;
import com.tencent.mm.plugin.finder.search.FinderFansSearchUI;
import com.tencent.mm.plugin.finder.search.FinderFeedSearchUI;
import com.tencent.mm.plugin.finder.search.FinderMixSearchUI;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderActivityDescUI;
import com.tencent.mm.plugin.finder.ui.FinderActivityPostUI;
import com.tencent.mm.plugin.finder.ui.FinderBlockListSearchUI;
import com.tencent.mm.plugin.finder.ui.FinderBlockListUI;
import com.tencent.mm.plugin.finder.ui.FinderCreateContactUI;
import com.tencent.mm.plugin.finder.ui.FinderEditTextUI;
import com.tencent.mm.plugin.finder.ui.FinderFansListUI;
import com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI;
import com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI;
import com.tencent.mm.plugin.finder.ui.FinderFollowListUI;
import com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI;
import com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI;
import com.tencent.mm.plugin.finder.ui.FinderModifyNameUI;
import com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderMultiTaskRouterUI;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.ui.FinderSelectSexUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.FinderUnOpenUI;
import com.tencent.mm.plugin.finder.ui.FinderWxMsgUI;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.plugin.l;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.am.g;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/ActivityRouter;", "Lcom/tencent/mm/plugin/IActivityRouter;", "()V", "TAG", "", "enterAccountManagementUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterActivityDescUI", "activity", "Lcom/tencent/mm/ui/MMActivity;", "requestCode", "", "enterActivityProfileUI", "isIgnoreReportInit", "", "enterAlbumRelatedTimelineUI", "enterAtFeedManageUI", "Landroid/app/Activity;", "enterAtTimelineUI", "enterAuthInfoWeApp", "appId", "enterPath", "enterBizProfileTimelineUI", "enterChattingUI", "wxUsername", "enterChattingUIFromApply", "sessionId", "username", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "enterChattingUIFromComment", "feedId", "", "commentId", "isCommentLike", "enterChattingUIFromFans", "fansId", "enterChattingUIFromLive", "fromUsername", "toUser", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "scene", "enterChattingUIFromLottery", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "lotteryId", "objectId", "isAnchorToVisitor", "enterChattingUIFromProfile", "enterCropAvatarUI", "rc", "enterCropProfileBgUI", "filePath", "resultFileName", "enterFavFeedUI", "reqCode", "enterFavTimelineUI", "enterFeedRelatedTimelineUI", "enterFinderAccountDetailUI", "enterFinderAliasConversationUI", "enterFinderAnchorVerifyWebviewUI", "enterFinderBlackConversationUI", "convType", "enterFinderBlockListSearchUI", "type", "enterFinderBlockListUi", "enterFinderCommentUI", "Lcom/tencent/mm/ui/MMFragmentActivity;", "enterFinderContactSearchIncludeFollowUI", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "enterFinderContactSearchIncludeFollowUIForResult", "enterFinderContactSearchUI", "enterFinderConversationUI", "enterFinderCreateContactUI", "enterFinderCreateContactUIForResult", "enterFinderCreateLotteryUI", "enterFinderEditTextUI", "enterFinderFansListUI", "enterFinderFansSearchUI", "intent", "enterFinderFeedLbsUI", "enterFinderFeedRelUI", "enterFinderFeedSearchUI", "enterFinderFinderSysMsgUI", "enterFinderFixRatioEditUI", "inputPath", "outputPath", "ratio", "", "color", "enterFinderFollowListUI", "enterFinderFriendTabUI", "options", "Landroidx/core/app/ActivityOptionsCompat;", "enterFinderGallerySearchUI", "enterFinderGalleryUI", "enterFinderGameLiveAuthUI", "enterFinderGameLiveFinishUI", "enterFinderGameLivePostUI", "enterFinderGameLivePostVerifyUI", "enterFinderGameSearchUI", "enterFinderGameSelectUI", "enterFinderHelloConversationUI", "enterFinderHotSearchUI", "enterFinderImagePreviewUI", "enterFinderLikedFeedUI", "enterFinderLiveAnchorUI", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "contextId", "nonceId", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInviteInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LinkInviteInfo;", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "desc", "tagInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "chosenTagInfo", "sessionBuffer", "visitorWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "liveId", "redPacketId", "enterFinderLiveChargeAnchorIncomeUI", "enterFinderLiveCountDownUI", "enterFinderLiveCreateVisitorRoleUI", "enterFinderLiveFansListUI", "enterFinderLiveInvitedUI", "nickname", "avatar", "enterFinderLiveNoticeQrCodeUI", "enterFinderLiveNoticeUI", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "isCanCreate", "enterFinderLivePrecheckLicenseUI", "enterFinderLivePrepareUI", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "isFromScan", "enterFinderLivePurchaseUI", "enterFinderLiveReplayUI", "enterFinderLiveShoppingManagerUIForResult", "enterFinderLiveVisitorRoleUI", "fromUserGuide", "enterFinderLiveVisitorUI", "clickTabContextId", "needAnim", "anchorUserName", "extFlag", "streamUrl", "audienMode", "commentScene", "liveSdkInfo", "", "(Landroid/content/Intent;Landroid/content/Context;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I[BZ)V", "enterFinderLiveVisitorWhiteListUI", "enterFinderLiveWeCoinHotUI", "enterFinderLogOutUI", "userName", "enterFinderLotteryHistoryDetailUI", "enterFinderLotteryHistoryUI", "isFromSetting", "enterFinderLotteryWinnerListUI", "enterFinderManagementUi", "sourceType", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "enterFinderMediaEditUI", "rawPath", "matrix", "Landroid/graphics/Matrix;", "cropRect", "Landroid/graphics/Rect;", "offset", "", "isVlogMode", "enterFinderMediaPreviewUI", "viewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isLongVideoPreview", "showSeekBar", "enterFinderMixSearchUI", "enterFinderMsgFeedDetailUI", "enterFinderMultiTaskRouterUI", "enterFinderNotifyMsgUI", "enterFinderPostAlbumUI", "forResult", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "mediaType", "maxCount", "(Landroid/content/Context;Landroid/content/Intent;IILjava/lang/Boolean;Ljava/lang/Integer;)V", "enterFinderPostRouterUI", "enterFinderPostUI", "enterFinderPrivacyBlockListNewUi", "enterFinderProfileTimelineUI", "enterFinderProfileUI", "enterFinderRetransmitSourceUI", "enterFinderSelfUI", "enterFinderSettingInfoUI", "enterFinderShareFeedDetailUI", "enterFinderShareFeedDetailUI2", "enterFinderSharePostUI", "enterFinderSnsGridFeedUI", "enterFinderTimelineUI", "needClear", "enterFinderTopicSearchUI", "enterFinderWxConversationUI", "enterFinderWxMsgUI", "enterFinderWxSettingUI", "enterFloatBallDetailUI", "isFromFloatBall", "enterFriendBlackListUI", "enterFriendContactUI", "enterFriendFoldedTimelineUI", "enterFriendLikeFeedUI", "enterFriendLikeTimelineUI", "enterFriendRecommendUI", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "totalCount", "isPosterView", "enterGalleryTimelineUI", "enterHotWordFeedUI", "enterLbsStreamFeedUI", "enterLbsStreamListUI", "enterLiveTaskH5", "sourceSync", "forceUrl", "enterMegaVideoTimelineUI", "enterModifyNameUI", "enterMusicMvMainUI", "enterMusicMvMakerUI", "enterMusicMvPostUI", "enterMusicMvPreviewUI", "enterOriginalRequestUI", "enterOriginalUI", "enterPoiAddGuide", "enterPoiFeedUI", "enterPoiManageUI", "enterPoiRelativeList", "enterPoiTimelineUI", "enterPostActivityUI", "enterPostAtUI", "enterPreviewAtTimelineUI", "enterRealnameVerifyUI", "fromActivity", "enterRelatedFeedUI", "enterRelatedTimelineUI", "enterSelectActivityUI", "enterSelectCoverUI", "postLongVideo", "enterSelectDistrictUI", "enterSelectSexUI", "enterSelfQRCodeUI", "enterShoppingWeApp", "sceneNote", "shareToken", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "enterSnsAlbumPickerUI", "enterTopicFeedUI", "enterTopicTimelineUI", "enterUnOpenUI", "enterWeApp", "enterWeAppByName", "appName", "isTrial", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "enterWeAppForRedDot", "enterWebViewForRedDot", "url", "fillPostFromRoute", "curIntent", "goDraftInternal", "goDraftInternalOld", "intentString", "extra", "jumpHotSearch", "necessaryParams", "Lorg/json/JSONObject;", "openImagePreviewGallery", "path", "args", "", "realEnterRealnameVerifyUI", "shareToConversation", "Landroidx/appcompat/app/AppCompatActivity;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "param", "Landroid/os/Bundle;", "shareType", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "toUsers", "shareToSnsTimeLine", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "postFromSnsType", "shareToStatusTimeLine", "shareWinterOlympicsLiveToStatus", "verifyInfo", "sourceName", "localPicPath", "tryGoPostUIIfDraftExist", "routeFrom", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.f
{
  public static final a GfO;
  
  static
  {
    AppMethodBeat.i(167872);
    GfO = new a();
    AppMethodBeat.o(167872);
  }
  
  public static void C(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(167868);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "enterPath");
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Boolean)com.tencent.mm.plugin.finder.storage.d.eWC().bmg()).booleanValue()) {
      localg.euz = 2;
    }
    localg.username = paramString1;
    localg.qAF = Util.nullAs(paramString2, "");
    localg.scene = 1201;
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramContext, localg);
    AppMethodBeat.o(167868);
  }
  
  public static void R(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(333906);
    kotlin.g.b.s.u(paramContext, "context");
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi().R(paramContext, paramIntent);
    AppMethodBeat.o(333906);
  }
  
  public static void S(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334428);
    kotlin.g.b.s.u(paramContext, "context");
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi().S(paramContext, paramIntent);
    AppMethodBeat.o(334428);
  }
  
  public static void T(Context paramContext, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(167844);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject1;
    if (!(paramContext instanceof Activity))
    {
      localObject1 = paramIntent;
      if (localObject1 != null) {
        ((Intent)localObject1).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderProfileTimeLineUI.class);
      localObject1 = localObject2;
      if ((paramContext instanceof Activity)) {
        localObject1 = (Activity)paramContext;
      }
      if (localObject1 == null) {
        break label185;
      }
      localObject1 = ((Activity)localObject1).getIntent();
      if ((localObject1 == null) || (((Intent)localObject1).getBooleanExtra("KEY_IS_FROM_FINDER_TASK", false) != true)) {
        break label185;
      }
    }
    label185:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramIntent.putExtra("KEY_IS_FROM_FINDER_TASK", true);
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167844);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static void U(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(333989);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.k localk = com.tencent.mm.plugin.finder.search.k.FxZ;
    com.tencent.mm.plugin.finder.search.k.a(null);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchIncludeFollowUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(333989);
  }
  
  public static void V(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334019);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDh("search") != 0)
    {
      paramIntent = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      com.tencent.mm.ui.base.k.a(paramContext, com.tencent.mm.plugin.findersdk.d.a.aDi("search"), "", paramContext.getString(am.g.welcome_i_know), null);
      AppMethodBeat.o(334019);
      return;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 0L, 1L, false);
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    ((Intent)localObject).setClass(paramContext, FinderMixSearchUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if ((paramContext instanceof Activity)) {}
    for (paramContext = (Activity)paramContext;; paramContext = null)
    {
      if (paramContext != null) {
        paramContext.overridePendingTransition(0, 0);
      }
      AppMethodBeat.o(334019);
      return;
    }
  }
  
  public static void W(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334028);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.findersdk.d.a locala = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDh("search") != 0)
    {
      paramIntent = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      com.tencent.mm.ui.base.k.a(paramContext, com.tencent.mm.plugin.findersdk.d.a.aDi("search"), "", paramContext.getString(am.g.welcome_i_know), null);
      AppMethodBeat.o(334028);
      return;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 0L, 1L, false);
    paramIntent.setClass(paramContext, FinderLongVideoPreviewUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderHotSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderHotSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334028);
  }
  
  public static void X(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167851);
    kotlin.g.b.s.u(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167851);
      return;
    }
  }
  
  public static void Y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167852);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = av.GiL;
    av.aP(localIntent);
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderShareFeedRelUI.class);
      paramIntent = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.eMN();
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167852);
      return;
    }
  }
  
  public static void Z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334051);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = av.GiL;
    av.aP(paramIntent);
    if (!(paramContext instanceof Activity)) {}
    for (localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderShareFeedDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334051);
      return;
    }
  }
  
  public static void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, djh paramdjh, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(334300);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(paramViewInfo, "viewInfo");
    kotlin.g.b.s.u(paramdjh, "localContent");
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi().a(paramActivity, paramViewInfo, paramdjh, paramInt, paramBoolean);
    AppMethodBeat.o(334300);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, Matrix paramMatrix, Rect paramRect, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(334092);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(paramString, "rawPath");
    kotlin.g.b.s.u(paramMatrix, "matrix");
    kotlin.g.b.s.u(paramRect, "cropRect");
    UICustomParam.a locala = new UICustomParam.a();
    locala.aQw();
    locala.aQv();
    locala.eL(false);
    locala.aQx();
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    paramMatrix = new Bundle();
    paramMatrix.putParcelable("cropRect", (Parcelable)paramRect);
    paramMatrix.putFloatArray("matrix", arrayOfFloat);
    paramMatrix.putFloatArray("offset", paramArrayOfFloat);
    if (paramInt == 2)
    {
      paramString = RecordConfigProvider.aM(paramString, "", "");
      paramString.scene = 11;
      paramString.NHR = locala.lZB;
      paramRect = com.tencent.mm.plugin.finder.storage.d.FAy;
      paramString.oXZ = com.tencent.mm.plugin.finder.storage.d.ePV();
      paramString.remuxType = 2;
      paramString.NHT = 3;
      paramString.NHZ = (paramString.oXZ.duration * 1000);
      locala.eK(false);
      paramString.oSS = paramMatrix;
      paramString.cD(2, ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishVlogApi().eLf());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      paramActivity = (Context)paramActivity;
      paramInt = com.tencent.mm.plugin.finder.e.a.anim_not_change;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(paramActivity, 1, paramInt, paramInt, paramString, 2, 0);
      AppMethodBeat.o(334092);
      return;
    }
    if (paramInt == 1)
    {
      locala.aQu();
      paramString = RecordConfigProvider.lj(paramString, "");
      paramString.scene = 11;
      paramString.NHR = locala.lZB;
      paramString.oSS = paramMatrix;
      paramString.cD(1, ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishVlogApi().eLe());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      paramActivity = (Context)paramActivity;
      paramInt = com.tencent.mm.plugin.finder.e.a.anim_not_change;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(paramActivity, 1, paramInt, paramInt, paramString, 1, 1);
    }
    AppMethodBeat.o(334092);
  }
  
  public static void a(Context paramContext, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(333846);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    boolean bool;
    if (!(paramContext instanceof Activity))
    {
      paramIntent = localIntent;
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.putExtra("FROM_SCENE_KEY", paramInt);
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      paramIntent = av.GiL;
      av.aP(localIntent);
      paramIntent = com.tencent.mm.plugin.finder.storage.d.FAy;
      bool = com.tencent.mm.plugin.finder.storage.d.eXD();
      paramIntent = (l)com.tencent.mm.kernel.h.ax(l.class);
      if (!bool) {
        break label405;
      }
      if (((!(paramContext instanceof Activity)) || (!paramIntent.D((Activity)paramContext))) && (!paramIntent.ep(paramContext))) {
        break label387;
      }
      bool = true;
      label145:
      if ((!bool) && (paramBoolean))
      {
        paramIntent = com.tencent.mm.kernel.h.ax(l.class);
        kotlin.g.b.s.s(paramIntent, "service(IFinderMultiTaskService::class.java)");
        ((l)paramIntent).hG(false);
      }
    }
    for (;;)
    {
      Log.i("Finder.ActivityRouter", "enterFinderTimelineUI: isEnterFinderTask = " + bool + ", fromUI = " + paramContext.getClass().getName() + ", scene = " + paramInt);
      paramIntent = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (com.tencent.mm.plugin.finder.storage.d.eXD())
      {
        paramIntent = FinderHomeAffinityUI.class;
        label242:
        localIntent.setClass(paramContext, paramIntent);
        if ((Build.VERSION.SDK_INT < 31) || (!(paramContext instanceof Activity)) || (!kotlin.g.b.s.p(paramIntent, FinderHomeAffinityUI.class))) {
          break label400;
        }
      }
      label387:
      label400:
      for (paramIntent = ActivityOptions.makeSceneTransitionAnimation((Activity)paramContext, new Pair[0]).toBundle();; paramIntent = null)
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent).cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;IZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        paramContext.startActivity((Intent)paramIntent.sb(0), (Bundle)paramIntent.sb(1));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;IZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(333846);
        return;
        paramIntent = null;
        break;
        bool = false;
        break label145;
        paramIntent = FinderHomeUI.class;
        break label242;
      }
      label405:
      bool = false;
    }
  }
  
  public static void a(Context paramContext, axg paramaxg, Intent paramIntent)
  {
    AppMethodBeat.i(167847);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.k localk = com.tencent.mm.plugin.finder.search.k.FxZ;
    com.tencent.mm.plugin.finder.search.k.a(paramaxg);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchUI.class);
    paramaxg = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramaxg.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramaxg.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167847);
  }
  
  private static final void a(Context paramContext, final bui parambui, final int paramInt1, final String paramString1, final int paramInt2, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(334701);
    kotlin.g.b.s.u(paramContext, "$context");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(paramContext, paramInt2, paramInt3, paramString2, paramString1, parambui, paramInt1));
    AppMethodBeat.o(334701);
  }
  
  private static final void a(Context paramContext, final bui parambui, final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(334681);
    kotlin.g.b.s.u(paramContext, "$context");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramContext, paramInt1, paramInt2, paramString2, paramString1, parambui));
    AppMethodBeat.o(334681);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, Boolean paramBoolean)
  {
    AppMethodBeat.i(334198);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appName");
    kotlin.g.b.s.u(paramString2, "enterPath");
    kotlin.g.b.s.u(paramString3, "sceneNote");
    Log.i("Finder.ActivityRouter", "enter we app appId:" + paramString1 + ",enterPath:" + paramString2 + ",scene:" + paramInt + ",sceneNote:" + paramString3);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(334198);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.username = paramString1;
    localg.qAF = paramString2;
    localg.scene = paramInt;
    localg.hzx = paramString3;
    if (kotlin.g.b.s.p(paramBoolean, Boolean.TRUE)) {
      localg.euz = 2;
    }
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramContext, localg);
    AppMethodBeat.o(334198);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean, bui parambui)
  {
    AppMethodBeat.i(334481);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "sessionId");
    kotlin.g.b.s.u(paramString2, "username");
    ((bp)com.tencent.mm.kernel.h.ax(bp.class)).a(paramContext, paramString1, paramString2, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramBoolean, new a..ExternalSyntheticLambda2(paramContext, parambui));
    AppMethodBeat.o(334481);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, bui parambui)
  {
    AppMethodBeat.i(334467);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "sessionId");
    kotlin.g.b.s.u(paramString2, "fansId");
    ((bp)com.tencent.mm.kernel.h.ax(bp.class)).a(paramContext, paramString1, paramString2, new a..ExternalSyntheticLambda1(paramContext, parambui));
    AppMethodBeat.o(334467);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(334190);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "enterPath");
    kotlin.g.b.s.u(paramString3, "sceneNote");
    kotlin.g.b.s.u(paramString4, "shareToken");
    Log.i("Finder.ActivityRouter", "enterShoppingWeApp appId:" + paramString1 + ",enterPath:" + paramString2 + ",scene:1195,sceneNote:" + paramString3);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(334190);
      return;
    }
    paramg.appId = paramString1;
    paramg.qAF = paramString2;
    paramg.scene = 1195;
    paramg.hzx = paramString3;
    paramg.euz = ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).bUq();
    paramg.qAT = new HalfScreenConfig(true, 0, null, false, null, false, null, HalfScreenConfig.c.rao, false, true, null, null, false, false, null, false, new HalfScreenConfig.ShareActionConfig(true, paramString4), 0, 0, 0, false, false, false, null, 16711038);
    paramg.qAU = ((i)new o(null, null));
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramContext, paramg);
    AppMethodBeat.o(334190);
  }
  
  public static void a(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(333997);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    kotlin.g.b.s.u(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.k localk = com.tencent.mm.plugin.finder.search.k.FxZ;
    com.tencent.mm.plugin.finder.search.k.a(null);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass((Context)paramMMActivity, FinderContactSearchIncludeFollowUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20000);
    AppMethodBeat.o(333997);
  }
  
  public static void a(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167869);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderSelectSexUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(167869);
  }
  
  public static void a(MMFragmentActivity paramMMFragmentActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334368);
    kotlin.g.b.s.u(paramMMFragmentActivity, "context");
    paramIntent.setClass((Context)paramMMFragmentActivity, FinderCommentUI.class);
    paramMMFragmentActivity.startActivityForResult(paramIntent, 500);
    paramMMFragmentActivity.overridePendingTransition(0, 0);
    AppMethodBeat.o(334368);
  }
  
  private static final void a(final String paramString1, Context paramContext, final int paramInt1, final String paramString2, final int paramInt2, final int paramInt3, final String paramString3)
  {
    AppMethodBeat.i(334667);
    kotlin.g.b.s.u(paramString1, "$username");
    kotlin.g.b.s.u(paramContext, "$context");
    Log.i("Finder.ActivityRouter", "[enterChattingUI] ]username=" + paramString1 + " sessionId=" + paramString2);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(paramContext, paramInt2, paramInt3, paramString3, paramString2, paramString1, paramInt1));
    AppMethodBeat.o(334667);
  }
  
  private static final void a(String paramString1, Context paramContext, final String paramString2, final String paramString3, final int paramInt1, final int paramInt2, final String paramString4)
  {
    AppMethodBeat.i(334677);
    kotlin.g.b.s.u(paramString1, "$toUsername");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramString2, "$fromUsername");
    Log.i("Finder.ActivityRouter", "[enterChattingUIFromLive] toUsername=" + paramString1 + " sessionId=" + paramString3);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramContext, paramInt1, paramInt2, paramString4, paramString3, paramString2));
    AppMethodBeat.o(334677);
  }
  
  public static boolean aG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(333925);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "userName");
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    paramString = d.a.auW(paramString);
    if (paramString == null)
    {
      paramContext = null;
      if (paramContext == null)
      {
        AppMethodBeat.o(333925);
        return false;
      }
    }
    else
    {
      int i;
      if (paramString.Axb == 1)
      {
        localObject = paramString.Axc;
        if (localObject != null) {
          if (((CharSequence)localObject).length() > 0)
          {
            i = 1;
            label82:
            if (i != 1) {
              break label142;
            }
            i = 1;
            label89:
            if (i != 0)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("rawUrl", paramString.Axc);
              com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            }
          }
        }
      }
      for (bool = true;; bool = false)
      {
        paramContext = Boolean.valueOf(bool);
        break;
        i = 0;
        break label82;
        label142:
        i = 0;
        break label89;
      }
    }
    boolean bool = paramContext.booleanValue();
    AppMethodBeat.o(333925);
    return bool;
  }
  
  public static void aH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(334456);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "username");
    Log.i("Finder.ActivityRouter", "[startChattingUI] username=" + paramString + " scene=2");
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaO, 1);
    bp localbp = (bp)com.tencent.mm.kernel.h.ax(bp.class);
    av localav = av.GiL;
    localbp.a(paramContext, av.fgo(), paramString, i, new a..ExternalSyntheticLambda4(paramString, paramContext, 2));
    AppMethodBeat.o(334456);
  }
  
  public static void aI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(334562);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "type");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderBlockListSearchUI.class);
      localObject = FinderBlockListSearchUI.FOH;
      localIntent.putExtra(FinderBlockListSearchUI.faL(), paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListSearchUI", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListSearchUI", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334562);
      return;
    }
  }
  
  public static void aK(Context paramContext, String paramString)
  {
    AppMethodBeat.i(334658);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "wxUsername");
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("Chat_Mode", 1);
    localIntent.setClassName(paramContext, "com.tencent.mm.ui.chatting.ChattingUI");
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterChattingUI", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterChattingUI", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334658);
  }
  
  public static void aa(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167853);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderRetransmitSourceUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167853);
      return;
    }
  }
  
  public static void ab(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167854);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderMsgFeedDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167854);
      return;
    }
  }
  
  public static void ad(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334071);
    kotlin.g.b.s.u(paramContext, "context");
    if (!((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).canEnterMvAndShowToast())
    {
      AppMethodBeat.o(334071);
      return;
    }
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      try
      {
        paramIntent.setClass(paramContext, Class.forName("com.tencent.mm.plugin.mv.ui.MusicMvMainUI"));
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMainUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMainUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(334071);
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        Log.e("Finder.ActivityRouter", kotlin.g.b.s.X("enterMusicMvMainUI : ", paramContext));
        AppMethodBeat.o(334071);
      }
    }
  }
  
  public static void ae(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334078);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      try
      {
        localObject = Class.forName("com.tencent.mm.plugin.mv.ui.MusicMvRouterUI");
        paramIntent.putExtra("KEY_MUSIC_ROUTER", 3);
        paramIntent.setClass(paramContext, (Class)localObject);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMakerUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMakerUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(334078);
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        Log.e("Finder.ActivityRouter", kotlin.g.b.s.X("enterMusicMvMakerUI : ", paramContext));
        AppMethodBeat.o(334078);
      }
    }
  }
  
  public static void af(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334083);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      try
      {
        localObject = Class.forName("com.tencent.mm.plugin.mv.ui.MusicMvRouterUI");
        paramIntent.putExtra("KEY_MUSIC_ROUTER", 7);
        paramIntent.setClass(paramContext, (Class)localObject);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(334083);
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        Log.e("Finder.ActivityRouter", kotlin.g.b.s.X("enterMusicMvPostUI : ", paramContext));
        AppMethodBeat.o(334083);
      }
    }
  }
  
  public static void ag(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167862);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderModifyNameUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167862);
      return;
    }
  }
  
  public static void ah(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334208);
    kotlin.g.b.s.u(paramContext, "context");
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
      localIntent.setClass(paramContext, FinderHotWordFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterHotWordFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterHotWordFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334208);
      return;
    }
  }
  
  public static void ai(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334236);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderLbsStreamListUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334236);
      return;
    }
  }
  
  public static void aj(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334243);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderRelatedFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334243);
      return;
    }
  }
  
  public static void ak(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334253);
    kotlin.g.b.s.u(paramContext, "context");
    paramIntent.setClass(paramContext, FinderRelatedTimelineUI.class);
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(501, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(334253);
      return;
    }
    paramIntent.addFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334253);
  }
  
  public static void al(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334260);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFriendLikeTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334260);
      return;
    }
  }
  
  public static void am(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334266);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderLikedFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLikedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLikedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334266);
      return;
    }
  }
  
  public static void an(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334291);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFeedRelTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334291);
      return;
    }
  }
  
  public static void ao(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334318);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.addFlags(67108864);
      paramIntent.setClass(paramContext, FinderFinderMsgUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderNotifyMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderNotifyMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334318);
      return;
    }
  }
  
  public static void ap(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334361);
    kotlin.g.b.s.u(paramContext, "context");
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
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(20000, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGallerySearchUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(334361);
      return;
    }
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGallerySearchUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGallerySearchUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334361);
  }
  
  public static void ar(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334422);
    kotlin.g.b.s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderAtTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramContext = new dg();
      paramContext.eH(com.tencent.mm.model.cn.bDv());
      paramContext.izf = paramContext.F("FinerUsername", com.tencent.mm.model.z.bAW(), true);
      paramContext.ijk = paramContext.F("SessionId", ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN(), true);
      paramContext.bMH();
      com.tencent.mm.plugin.finder.report.z.a((com.tencent.mm.plugin.report.a)paramContext);
      AppMethodBeat.o(334422);
      return;
    }
  }
  
  public static void as(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334495);
    kotlin.g.b.s.u(paramContext, "context");
    paramIntent.setClass(paramContext, FinderSnsGridFeedUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSnsGridFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSnsGridFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334495);
  }
  
  public static void av(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334588);
    kotlin.g.b.s.u(paramContext, "context");
    paramIntent.setClass(paramContext, FinderAccountManagent.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAccountManagementUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAccountManagementUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334588);
  }
  
  public static void aw(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334595);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "intent");
    com.tencent.mm.plugin.finder.search.k localk = com.tencent.mm.plugin.finder.search.k.FxZ;
    com.tencent.mm.plugin.finder.search.k.a(null);
    paramIntent.setClass(paramContext, FinderFansSearchUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334595);
  }
  
  private static void ax(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(334545);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderBlockListUI.class);
      localIntent.putExtra("BLOCK_LIST_TYPE", paramInt);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListUi", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListUi", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334545);
      return;
    }
  }
  
  public static void ay(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334634);
    kotlin.g.b.s.u(paramContext, "context");
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
      localIntent.setClassName(paramContext, "com.tencent.mm.plugin.sns.ui.picker.SnsAlbumPickerUI");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSnsAlbumPickerUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSnsAlbumPickerUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334634);
      return;
    }
  }
  
  public static void az(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334648);
    kotlin.g.b.s.u(paramContext, "context");
    paramIntent.setClass(paramContext, FinderMultiTaskRouterUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMultiTaskRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMultiTaskRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334648);
  }
  
  public static void b(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(334355);
    kotlin.g.b.s.u(paramContext, "context");
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
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGalleryUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(334355);
      return;
    }
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGalleryUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGalleryUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334355);
  }
  
  private static void b(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(334488);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFinderLiveBundle, "config");
    kotlin.g.b.s.u(paramString, "contextId");
    Log.i("Finder.ActivityRouter", kotlin.g.b.s.X("[enterFinderLiveAnchorUI] ", paramFinderLiveBundle));
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
    kotlin.g.b.s.s(locala, "service(IFinderCommonLiveService::class.java)");
    g.a.a((com.tencent.mm.plugin.g)locala, paramContext, paramFinderLiveBundle, paramString, paramIntent);
    AppMethodBeat.o(334488);
  }
  
  public static void b(Context paramContext, axg paramaxg, Intent paramIntent)
  {
    AppMethodBeat.i(334007);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.k localk = com.tencent.mm.plugin.finder.search.k.FxZ;
    com.tencent.mm.plugin.finder.search.k.a(paramaxg);
    paramIntent.setClass(paramContext, FinderFeedSearchUI.class);
    paramIntent.putExtra("key_to_comment_scene", 6);
    paramaxg = as.GSQ;
    as.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramaxg = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramaxg.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramaxg.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 1L, 1L, false);
    AppMethodBeat.o(334007);
  }
  
  private static final void b(Context paramContext, final bui parambui, final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(334684);
    kotlin.g.b.s.u(paramContext, "$context");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramContext, paramInt1, paramInt2, paramString2, paramString1, parambui));
    AppMethodBeat.o(334684);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, bui parambui)
  {
    AppMethodBeat.i(334472);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "sessionId");
    kotlin.g.b.s.u(paramString2, "username");
    ((bp)com.tencent.mm.kernel.h.ax(bp.class)).b(paramContext, paramString1, paramString2, new a..ExternalSyntheticLambda0(paramContext, parambui));
    AppMethodBeat.o(334472);
  }
  
  public static void b(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(167842);
    kotlin.g.b.s.u(paramIntent1, "intent");
    kotlin.g.b.s.u(paramIntent2, "curIntent");
    paramIntent1.putExtra("key_finder_post_from", paramIntent2.getIntExtra("key_finder_post_from", -1));
    paramIntent1.putExtra("KEY_POST_DIRECTLY_FROM_SNS", paramIntent2.getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false));
    paramIntent1.putExtra("key_context_id", paramIntent2.getStringExtra("key_context_id"));
    paramIntent1.putExtra("key_jump_id", paramIntent2.getStringExtra("key_jump_id"));
    paramIntent1.putExtra("key_click_tab_context_id", paramIntent2.getStringExtra("key_click_tab_id"));
    AppMethodBeat.o(167842);
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334216);
    kotlin.g.b.s.u(paramMMActivity, "context");
    paramIntent.setClass((Context)paramMMActivity, FinderFavFeedUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 1);
    AppMethodBeat.o(334216);
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(334373);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderPostAtUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(334373);
  }
  
  public static void c(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(334139);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(paramString1, "filePath");
    kotlin.g.b.s.u(paramString2, "resultFileName");
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi().c(paramActivity, paramString1, paramString2);
    AppMethodBeat.o(334139);
  }
  
  public static void c(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(334622);
    kotlin.g.b.s.u(paramContext, "context");
    if ((paramContext instanceof MMActivity))
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      paramIntent = com.tencent.mm.plugin.findersdk.e.a.HdV;
      localIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsV());
      ((MMActivity)paramContext).startActivityForResult(localIntent, paramInt);
    }
    AppMethodBeat.o(334622);
  }
  
  private static final void c(Context paramContext, final bui parambui, final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(334695);
    kotlin.g.b.s.u(paramContext, "$context");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramContext, paramInt1, paramInt2, paramString2, paramString1, parambui));
    AppMethodBeat.o(334695);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(334617);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "enterPath");
    Log.i("Finder.ActivityRouter", "[enterWeAppForRedDot] appId=" + paramString1 + " enterPath=" + paramString2 + " scene=" + paramInt);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.username = paramString1;
    localg.qAF = Util.nullAs(paramString2, "");
    localg.scene = paramInt;
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramContext, localg);
    AppMethodBeat.o(334617);
  }
  
  public static void c(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334347);
    kotlin.g.b.s.u(paramMMActivity, "context");
    if (!(paramMMActivity instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass((Context)paramMMActivity, FinderTimelineLbsUI.class);
      paramMMActivity.startActivityForResult(paramIntent, 19999);
      AppMethodBeat.o(334347);
      return;
    }
  }
  
  public static boolean c(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(333891);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "intentString");
    kotlin.g.b.s.u(paramIntent, "extra");
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = com.tencent.e.f.e.bFB(paramString);
        Parcel localParcel = Parcel.obtain();
        kotlin.g.b.s.s(localParcel, "obtain()");
        localParcel.unmarshall(paramString, 0, paramString.length);
        localParcel.setDataPosition(0);
        paramString = (Intent)Intent.CREATOR.createFromParcel(localParcel);
        paramString.setExtrasClassLoader(LocalVideoCropInfoParcelable.CREATOR.getClass().getClassLoader());
        paramString.putExtras(paramIntent);
        if (!Util.isNullOrNil(paramString.getStringExtra("saveText"))) {
          X(paramContext, paramString);
        }
        for (;;)
        {
          AppMethodBeat.o(333891);
          return true;
          enterFinderPostUI(paramContext, paramString);
        }
        AppMethodBeat.o(333891);
      }
      catch (Exception paramContext)
      {
        Log.e("Finder.ActivityRouter", kotlin.g.b.s.X("goDraft() ", paramContext));
      }
    }
    return false;
  }
  
  public static void d(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167863);
    kotlin.g.b.s.u(paramActivity, "context");
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi().d(paramActivity, paramIntent, paramInt);
    AppMethodBeat.o(167863);
  }
  
  public static void d(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(334105);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(paramString1, "inputPath");
    kotlin.g.b.s.u(paramString2, "outputPath");
    paramString1 = RecordConfigProvider.lj(paramString1, paramString2);
    paramString1.scene = 11;
    paramString2 = new Bundle();
    paramString2.putFloat("crop_fix_ratio", 0.75F);
    paramString1.oSS = paramString2;
    paramString1.cD(1, ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishVlogApi().eLg());
    CaptureDataManager.NHH.NHG = null;
    paramString2 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
    paramActivity = (Context)paramActivity;
    int i = com.tencent.mm.plugin.finder.e.a.anim_not_change;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(paramActivity, 20002, i, i, paramString1, 1, 1);
    AppMethodBeat.o(334105);
  }
  
  public static void d(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334380);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderActivityPostUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20002);
    AppMethodBeat.o(334380);
  }
  
  public static void e(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(333859);
    kotlin.g.b.s.u(paramActivity, "activity");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(67108864);
    localIntent.setClass((Context)paramActivity, FinderCreateContactUI.class);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUIForResult", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(333859);
  }
  
  public static void e(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334384);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderActivityDescUI.class);
    paramIntent.putExtra("key_activity_already_participate", false);
    paramMMActivity.startActivityForResult(paramIntent, 20002);
    AppMethodBeat.o(334384);
  }
  
  public static void e(String paramString, Context paramContext)
  {
    AppMethodBeat.i(167867);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = new Intent();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localIntent.putExtra("Contact_User", str);
    com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(167867);
  }
  
  public static void enterAlbumRelatedTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334283);
    kotlin.g.b.s.u(paramContext, "context");
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
      Log.w("Finder.ActivityRouter", "青少年模式只看关注时，禁止进入专辑.");
      AppMethodBeat.o(334283);
      return;
    }
    if (paramIntent == null)
    {
      paramIntent = new Intent();
      if ((paramContext instanceof Activity)) {
        break label199;
      }
    }
    label199:
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderAlbumTimelineUI.class);
      localObject = as.GSQ;
      as.a.a(paramContext, paramIntent, 0L, 0, false, 124);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAlbumRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAlbumRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334283);
      return;
      break;
    }
  }
  
  public static void enterFinderFollowListUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(333872);
    kotlin.g.b.s.u(paramContext, "context");
    if (paramIntent == null)
    {
      paramIntent = new Intent();
      if ((paramContext instanceof Activity)) {
        break label159;
      }
    }
    label159:
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramIntent.addFlags(67108864);
      paramIntent.setClass(paramContext, FinderFollowListUI.class);
      localObject = as.GSQ;
      as.a.a(paramContext, paramIntent, 0L, 0, false, 124);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFollowListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFollowListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(333872);
      return;
      break;
    }
  }
  
  public static void enterFinderPostRouterUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167841);
    kotlin.g.b.s.u(paramContext, "context");
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      as.a locala = as.GSQ;
      as.a.a(paramContext, paramIntent, 0L, 0, false, 124);
      ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi().enterFinderPostRouterUI(paramContext, paramIntent);
      AppMethodBeat.o(167841);
      return;
    }
  }
  
  public static void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167840);
    kotlin.g.b.s.u(paramContext, "context");
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi().enterFinderPostUI(paramContext, paramIntent);
    AppMethodBeat.o(167840);
  }
  
  public static void enterFinderSelfUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(333969);
    kotlin.g.b.s.u(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(333969);
      return;
    }
  }
  
  public static void f(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(334644);
    kotlin.g.b.s.u(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderGalleryTimelineUI.class);
    as.a locala = as.GSQ;
    as.a.a((Context)paramActivity, paramIntent, 0L, 0, false, 124);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterGalleryTimelineUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(334644);
  }
  
  public static void f(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(334396);
    kotlin.g.b.s.u(paramContext, "context");
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
      if (paramIntent == null) {
        paramContext = Integer.valueOf(5);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(20912, new Object[] { Integer.valueOf(3), paramContext, "", "" });
        AppMethodBeat.o(334396);
        return;
        paramIntent = paramIntent.getStringExtra("key_finder_teen_mode_scene");
        paramContext = paramIntent;
        if (paramIntent == null) {
          paramContext = Integer.valueOf(5);
        }
      }
    }
    if (paramIntent == null)
    {
      paramIntent = new Intent();
      if (!paramBoolean)
      {
        paramIntent.putExtra("key_to_comment_scene", 59);
        localObject = as.GSQ;
        as.a.a(paramContext, paramIntent, 0L, 0, false, 124);
      }
      if ((paramContext instanceof Activity)) {
        break label271;
      }
    }
    label271:
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderActivityProfileUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterActivityProfileUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterActivityProfileUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334396);
      return;
      break;
    }
  }
  
  public static void f(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334412);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, OccupyFinderUI26.class);
    paramMMActivity.startActivityForResult(paramIntent, 20003);
    AppMethodBeat.o(334412);
  }
  
  public static void g(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(334503);
    kotlin.g.b.s.u(paramContext, "context");
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
        break label125;
      }
      localIntent.setClass(paramContext, FinderLongVideoDetailUI.class);
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {
        break label137;
      }
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(101, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMegaVideoTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(334503);
      return;
      paramIntent = null;
      break;
      label125:
      localIntent.setClass(paramContext, FinderLongVideoTimelineUI.class);
    }
    label137:
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMegaVideoTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMegaVideoTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334503);
  }
  
  public static boolean gW(Context paramContext)
  {
    AppMethodBeat.i(333881);
    kotlin.g.b.s.u(paramContext, "context");
    AppMethodBeat.o(333881);
    return false;
  }
  
  public static void gZ(Context paramContext)
  {
    AppMethodBeat.i(333961);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).setClass(paramContext, FinderPoiManageUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiManageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiManageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(333961);
  }
  
  public static void h(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(333956);
    kotlin.g.b.s.u(paramActivity, "context");
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.setClass((Context)paramActivity, FinderPoiRelateListUI.class);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiRelativeList", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(333956);
  }
  
  public static void h(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(334517);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if ((paramContext instanceof Activity))
    {
      if ((paramContext instanceof Activity)) {
        break label179;
      }
      paramIntent = localIntent;
      label43:
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      if (!paramBoolean) {
        break label184;
      }
    }
    label179:
    label184:
    for (paramIntent = FinderFloatBallDetailUI.class;; paramIntent = FinderMultiTaskUI.class)
    {
      localIntent.setClass(paramContext, paramIntent);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFloatBallDetailUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFloatBallDetailUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334517);
      return;
      paramIntent = ((l)com.tencent.mm.kernel.h.ax(l.class)).bUR();
      if (paramIntent == null) {
        break;
      }
      paramContext = (Context)paramIntent;
      break;
      paramIntent = null;
      break label43;
    }
  }
  
  public static void ha(Context paramContext)
  {
    AppMethodBeat.i(167859);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localObject = as.GSQ;
      as.a.a(paramContext, localIntent, 0L, 0, false, 124);
      localIntent.setClass(paramContext, FinderWxMsgUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167859);
      return;
    }
  }
  
  public static void hb(Context paramContext)
  {
    AppMethodBeat.i(167861);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramContext, FinderSelfQRCodeUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167861);
  }
  
  public static void hc(Context paramContext)
  {
    AppMethodBeat.i(167866);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = new Intent(paramContext, FinderUnOpenUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167866);
  }
  
  public static void hd(Context paramContext)
  {
    AppMethodBeat.i(334275);
    kotlin.g.b.s.u(paramContext, "context");
    ax(paramContext, 1);
    AppMethodBeat.o(334275);
  }
  
  public static void he(Context paramContext)
  {
    AppMethodBeat.i(334330);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = new Intent();
    Object localObject = as.GSQ;
    as.a.a(paramContext, localIntent, 0L, 0, false, 124);
    if (!(paramContext instanceof Activity)) {}
    for (localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderFinderSysMsgUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334330);
      return;
    }
  }
  
  public static void hf(Context paramContext)
  {
    AppMethodBeat.i(334339);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderFansListUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334339);
      return;
    }
  }
  
  public static void hm(Context paramContext)
  {
    AppMethodBeat.i(334584);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject1 = am.aixg;
    localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adfc, "");
    if (localObject1 == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(334584);
      throw paramContext;
    }
    localObject1 = String.format(kotlin.g.b.s.X((String)localObject1, "?wechat_real_lang=%s&username=%s"), Arrays.copyOf(new Object[] { LocaleUtil.getApplicationLanguage(), com.tencent.mm.model.z.bAW() }, 2));
    kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
    Object localObject2 = av.GiL;
    if (av.bgV()) {
      aa.makeText(paramContext, (CharSequence)kotlin.g.b.s.X("url:", localObject1), 1).show();
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
    localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.b(paramContext, 9L, 1L);
    AppMethodBeat.o(334584);
  }
  
  public static void j(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(334150);
    kotlin.g.b.s.u(paramActivity, "context");
    Bundle localBundle = new Bundle();
    String str;
    if (Util.isNullOrNil(paramString))
    {
      str = paramActivity.getComponentName().getClassName();
      kotlin.g.b.s.s(str, "context.componentName.className");
      paramString = kotlin.g.b.s.X(MMApplicationContext.getSourcePackageName(), ".plugin.finder");
      if (!n.U(str, paramString, false)) {
        break label163;
      }
      paramString = str.substring(paramString.length());
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      Log.i("Finder.ActivityRouter", "fullActivity " + str + ", fromActivity " + paramString);
      localBundle.putString("realname_verify_process_jump_activity", paramString);
      for (;;)
      {
        localBundle.putString("realname_verify_process_jump_plugin", "finder");
        ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wxpaysdk.api.c.class)).h(paramActivity, localBundle);
        AppMethodBeat.o(334150);
        return;
        localBundle.putString("realname_verify_process_jump_activity", paramString);
      }
      label163:
      paramString = str;
    }
  }
  
  public static void k(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(167864);
    kotlin.g.b.s.u(paramActivity, "context");
    if ((Util.isNullOrNil(paramString)) && (!(paramActivity instanceof FinderHomeUI)) && (!(paramActivity instanceof FinderTimelineUI)) && (!(paramActivity instanceof FinderSelfUI)))
    {
      paramString = new Intent();
      paramString.setClass((Context)paramActivity, FinderRealnameVerifyRouteUI.class);
      paramString.putExtra("enterRealnameVerifyUI", true);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRealnameVerifyUI", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRealnameVerifyUI", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167864);
      return;
    }
    j(paramActivity, paramString);
    AppMethodBeat.o(167864);
  }
  
  public static void n(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(333941);
    kotlin.g.b.s.u(paramActivity, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(67108864);
    localIntent.setClass((Context)paramActivity, FinderSettingInfoUI.class);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(10010, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(333941);
  }
  
  public static void o(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334048);
    kotlin.g.b.s.u(paramActivity, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = av.GiL;
    av.aP(localIntent);
    localIntent.setClass((Context)paramActivity, FinderShareFeedRelUI.class);
    paramIntent = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.eMN();
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(510, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(334048);
  }
  
  public static void p(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334224);
    kotlin.g.b.s.u(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderFavTimelineUI.class);
    as.a locala = as.GSQ;
    as.a.a((Context)paramActivity, paramIntent, 0L, 0, false, 124);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(10001, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFavTimelineUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(334224);
  }
  
  public static void q(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334230);
    kotlin.g.b.s.u(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, BizProfileTimelineUI.class);
    Object localObject = as.GSQ;
    as.a.a((Context)paramActivity, paramIntent, 0L, 0, false, 124);
    localObject = av.GiL;
    av.aP(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(10010, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterBizProfileTimelineUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(334230);
  }
  
  public static void r(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334602);
    kotlin.g.b.s.u(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderAtFeedManageUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtFeedManageUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtFeedManageUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334602);
  }
  
  public final void A(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167870);
    kotlin.g.b.s.u(paramContext, "context");
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
      if (paramIntent == null) {
        paramContext = Integer.valueOf(5);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(20912, new Object[] { Integer.valueOf(3), paramContext, "", "" });
        AppMethodBeat.o(167870);
        return;
        paramIntent = paramIntent.getStringExtra("key_finder_teen_mode_scene");
        paramContext = paramIntent;
        if (paramIntent == null) {
          paramContext = Integer.valueOf(5);
        }
      }
    }
    boolean bool;
    if ((paramContext instanceof Activity))
    {
      if (paramIntent != null) {
        break label318;
      }
      bool = false;
      label132:
      if (paramIntent != null) {
        break label330;
      }
      paramIntent = new Intent();
      label144:
      paramIntent.putExtra("key_to_comment_scene", 22);
      if (!bool)
      {
        localObject = as.GSQ;
        as.a.a(paramContext, paramIntent, 0L, 0, false, 124);
      }
      if ((paramContext instanceof Activity)) {
        break label333;
      }
    }
    label318:
    label330:
    label333:
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderTopicFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167870);
      return;
      localObject = ((l)com.tencent.mm.kernel.h.ax(l.class)).bUR();
      if (localObject == null) {
        break;
      }
      paramContext = (Context)localObject;
      break;
      bool = paramIntent.getBooleanExtra("KEY_IGNORE_REPORT_INIT", false);
      break label132;
      break label144;
    }
  }
  
  public final int a(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent, boolean paramBoolean)
  {
    final boolean bool = true;
    AppMethodBeat.i(334851);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFinderLiveBundle, "config");
    kotlin.g.b.s.u(paramString1, "contextId");
    kotlin.g.b.s.u(paramString2, "clickTabContextId");
    Log.i("Finder.ActivityRouter", "[enterFinderLiveVisitorUI] " + paramFinderLiveBundle + ",contextId:" + paramString1 + ",clickTabContextId:" + paramString2);
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    LiveConfig localLiveConfig;
    if (((Number)com.tencent.d.a.a.a.a.a.jUv().bmg()).intValue() == 1)
    {
      localObject = com.tencent.mm.plugin.finder.report.av.Fui;
      com.tencent.mm.plugin.finder.report.av.tY(bool);
      localObject = com.tencent.mm.plugin.finder.report.r.Fqi;
      com.tencent.mm.plugin.finder.report.r.pC(1L);
      localObject = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
      localLiveConfig = paramFinderLiveBundle.ekC();
      if (localLiveConfig != null) {
        break label194;
      }
    }
    label194:
    for (long l = 0L;; l = localLiveConfig.liveId)
    {
      ((com.tencent.d.a.a.a.b)localObject).cleatLiveStatusCache(l);
      if ((paramFinderLiveBundle.extFlag & 0x4) <= 0) {
        break label204;
      }
      ((com.tencent.mm.plugin.festival.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.festival.a.a.class)).gn(paramContext);
      AppMethodBeat.o(334851);
      return 0;
      bool = false;
      break;
    }
    label204:
    int i = ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).a(paramContext, paramFinderLiveBundle, paramString1, paramString2, paramIntent, paramBoolean, (kotlin.g.a.a)new g(paramFinderLiveBundle, bool));
    AppMethodBeat.o(334851);
    return i;
  }
  
  public final void a(Activity paramActivity, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(335009);
    kotlin.g.b.s.u(paramActivity, "context");
    paramIntent.putExtra("KEY_IS_FROM_SETTING", paramBoolean);
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsE());
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveVisitorRoleUI", "(Landroid/app/Activity;Landroid/content/Intent;IZ)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    paramActivity.overridePendingTransition(com.tencent.mm.plugin.finder.e.a.sight_slide_bottom_in, com.tencent.mm.plugin.finder.e.a.anim_not_change);
    AppMethodBeat.o(335009);
  }
  
  public final void a(Activity paramActivity, Intent paramIntent, FinderContact paramFinderContact)
  {
    AppMethodBeat.i(335037);
    kotlin.g.b.s.u(paramActivity, "activity");
    kotlin.g.b.s.u(paramFinderContact, "contact");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("KEY_FINDER_LIVE_NOTICE_CONTACT", paramFinderContact.toByteArray());
    localIntent.putExtra("KEY_FINDER_LIVE_NOTICE_IS_CAN_CREATE", true);
    paramIntent = (Context)paramActivity;
    paramFinderContact = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass(paramIntent, com.tencent.mm.plugin.findersdk.e.a.fsX());
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(100, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveNoticeUI", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/protocal/protobuf/FinderContact;IZ)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    paramActivity.overridePendingTransition(com.tencent.mm.plugin.finder.e.a.sight_slide_bottom_in, com.tencent.mm.plugin.finder.e.a.anim_not_change);
    AppMethodBeat.o(335037);
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(334768);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(paramString1, "inputPath");
    kotlin.g.b.s.u(paramString2, "outputPath");
    paramString1 = RecordConfigProvider.lj(paramString1, paramString2);
    paramString1.scene = 11;
    paramString2 = new Bundle();
    paramString2.putFloat("crop_fix_ratio", 0.75F);
    paramString2.putInt("button_custom_color", paramInt2);
    paramString1.oSS = paramString2;
    paramString1.cD(1, ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishVlogApi().eLg());
    CaptureDataManager.NHH.NHG = null;
    paramString2 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
    paramActivity = (Context)paramActivity;
    paramInt2 = com.tencent.mm.plugin.finder.e.a.anim_not_change;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(paramActivity, paramInt1, paramInt2, paramInt2, paramString1, 1, 1);
    AppMethodBeat.o(334768);
  }
  
  public final void a(Context paramContext, int paramInt, bjb parambjb, String paramString, long paramLong, bui parambui, boolean paramBoolean)
  {
    AppMethodBeat.i(334830);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parambjb, "toUser");
    kotlin.g.b.s.u(paramString, "lotteryId");
    if (parambjb.ZPU)
    {
      aa.makeText(paramContext, e.h.finder_message_live_user_account_deleted, 0).show();
      AppMethodBeat.o(334830);
      return;
    }
    String str = parambjb.username;
    parambjb = str;
    if (str == null) {
      parambjb = "";
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      ((bp)com.tencent.mm.kernel.h.ax(bp.class)).a(paramContext, paramInt, parambjb, paramString, Long.valueOf(paramLong), i, new a..ExternalSyntheticLambda3(paramContext, parambui, paramInt));
      AppMethodBeat.o(334830);
      return;
    }
  }
  
  public final void a(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(335031);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = new Intent();
    int i;
    int j;
    if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adae, false))
    {
      i = 1;
      if (paramString == null) {
        break label197;
      }
      if (((CharSequence)paramString).length() <= 0) {
        break label191;
      }
      j = 1;
      label60:
      if (j != 1) {
        break label197;
      }
      j = 1;
      label69:
      if (j == 0) {
        break label203;
      }
    }
    for (;;)
    {
      paramString = Uri.parse(paramString).buildUpon();
      kotlin.g.b.s.s(paramString, "parse(urlStr).buildUpon()");
      paramString.appendQueryParameter("SourceScene", String.valueOf(paramInt));
      paramString = paramString.build().toString();
      kotlin.g.b.s.s(paramString, "builder.build().toString()");
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("KRightBtn", true);
      localIntent.putExtra("rawUrl", paramString);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      if (i != 0) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adae, Boolean.TRUE);
      }
      AppMethodBeat.o(335031);
      return;
      i = 0;
      break;
      label191:
      j = 0;
      break label60;
      label197:
      j = 0;
      break label69;
      label203:
      if (i != 0) {
        paramString = "https://channels.weixin.qq.com/mobile-support/pages/anchor-tasks/whatsnew";
      } else {
        paramString = "https://channels.weixin.qq.com/mobile-support/pages/anchor-tasks/tasks";
      }
    }
  }
  
  public final void a(Context paramContext, long paramLong, String paramString1, bip parambip, bkk parambkk, String paramString2, LinkedList<bno> paramLinkedList, bno parambno, String paramString3, String paramString4, LinkedList<bfh> paramLinkedList1, Intent paramIntent)
  {
    AppMethodBeat.i(334871);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "nonceId");
    kotlin.g.b.s.u(parambip, "liveInfo");
    kotlin.g.b.s.u(paramString3, "contextId");
    LiveConfig.a locala = new LiveConfig.a();
    locala.mIy = LiveConfig.mIs;
    locala.liveId = parambip.liveId;
    locala.mIH = paramLong;
    locala.nonceId = paramString1;
    locala.mIC = com.tencent.mm.model.z.bAW();
    locala.mIL = "";
    locala.mIO = 0L;
    locala.mIP = 0L;
    locala.mIM = "";
    locala.mIN = "";
    locala.desc = paramString2;
    locala.sessionBuffer = paramString4;
    paramString1 = locala.bcd();
    kotlin.g.b.s.s(paramString1, "builder.toWhere(LiveConf…fer)\n            .build()");
    Log.i("Finder.ActivityRouter", kotlin.g.b.s.X("enterFinderLiveAnchorUI ", paramString1.info()));
    paramString2 = new FinderLiveBundle();
    paramString2.CFa.add(paramString1);
    paramString2.Bpo = parambkk;
    paramString2.CFc = parambip.ZRX;
    paramString2.CFd = paramLinkedList;
    paramString2.CFe = parambno;
    paramString2.BpY = paramLinkedList1;
    ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).cleatLiveStatusCache(parambip.liveId);
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    paramString1.putExtra("KEY_PARAMS_SOURCE_TYPE", parambip.ZFJ);
    b(paramContext, paramString2, paramString3, paramString1);
    AppMethodBeat.o(334871);
  }
  
  public final void a(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(334977);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramBoolean) {
      localIntent.putExtra("KEY_IS_FROM_SETTING", true);
    }
    if ((paramContext instanceof Activity)) {}
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramIntent = com.tencent.mm.plugin.findersdk.e.a.HdV;
      localIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsF());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334977);
      return;
      paramIntent = ((l)com.tencent.mm.kernel.h.ax(l.class)).bUR();
      if (paramIntent != null) {
        paramContext = (Context)paramIntent;
      }
    }
  }
  
  public final void a(Context paramContext, awa paramawa, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(334861);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject1;
    Object localObject3;
    label34:
    bkk localbkk;
    label41:
    LinkedList localLinkedList1;
    label48:
    bno localbno;
    label55:
    LinkedList localLinkedList2;
    label62:
    Integer localInteger;
    label69:
    Object localObject2;
    label76:
    label83:
    biz localbiz;
    Object localObject4;
    if (paramawa == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label584;
      }
      localObject3 = new bip();
      if (paramawa != null) {
        break label591;
      }
      localbkk = null;
      if (paramawa != null) {
        break label600;
      }
      localLinkedList1 = null;
      if (paramawa != null) {
        break label609;
      }
      localbno = null;
      if (paramawa != null) {
        break label618;
      }
      localLinkedList2 = null;
      if (paramawa != null) {
        break label627;
      }
      localInteger = null;
      if (paramawa != null) {
        break label639;
      }
      localObject2 = null;
      if (paramawa != null) {
        break label651;
      }
      localObject1 = null;
      localbiz = new biz();
      if (paramawa != null) {
        break label660;
      }
      localObject4 = null;
      label99:
      localbiz.ZGA = ((LinkedList)localObject4);
      localObject4 = ah.aiuX;
      localObject4 = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jTI().bmg()).intValue() <= 0) {
        break label776;
      }
      localObject2 = com.tencent.d.a.a.a.a.a.ahiX;
      localObject2 = com.tencent.d.a.a.a.a.a.jTI().bmg();
      Log.i("Finder.ActivityRouter", kotlin.g.b.s.X("debug enterFinderLivePrepareUI maxUserCount ", localObject2));
    }
    label776:
    for (;;)
    {
      bjh localbjh = new bjh();
      int i;
      label174:
      label188:
      label202:
      int j;
      if (paramawa == null)
      {
        i = 0;
        localbjh.ZGt = i;
        if (paramawa != null) {
          break label678;
        }
        i = 0;
        localbjh.ZGu = i;
        if (paramawa != null) {
          break label687;
        }
        i = 0;
        localObject4 = new LiveConfig.a();
        ((LiveConfig.a)localObject4).mIy = LiveConfig.mIs;
        ((LiveConfig.a)localObject4).liveId = ((bip)localObject3).liveId;
        ((LiveConfig.a)localObject4).mIC = com.tencent.mm.model.z.bAW();
        LiveConfig localLiveConfig = ((LiveConfig.a)localObject4).bcd();
        kotlin.g.b.s.s(localLiveConfig, "builder.toWhere(LiveConf…e())\n            .build()");
        StringBuilder localStringBuilder = new StringBuilder("enterFinderLiveAnchorUI ").append(localLiveConfig.info()).append(", bgMusicInfo:");
        if (localObject1 != null) {
          break label696;
        }
        localObject4 = "";
        label288:
        Log.i("Finder.ActivityRouter", com.tencent.mm.ae.f.dg(localObject4));
        localObject4 = new FinderLiveBundle();
        ((FinderLiveBundle)localObject4).CFa.add(localLiveConfig);
        ((FinderLiveBundle)localObject4).Bpo = localbkk;
        ((FinderLiveBundle)localObject4).CFb = localbiz;
        ((FinderLiveBundle)localObject4).CFc = ((bip)localObject3).ZRX;
        ((FinderLiveBundle)localObject4).CFd = localLinkedList1;
        ((FinderLiveBundle)localObject4).CFe = localbno;
        ((FinderLiveBundle)localObject4).BpY = localLinkedList2;
        if (localInteger != null) {
          break label703;
        }
        j = 0;
        label380:
        ((FinderLiveBundle)localObject4).CFg = j;
        localObject2 = (Integer)localObject2;
        if (localObject2 != null) {
          break label713;
        }
        j = 0;
        label402:
        ((FinderLiveBundle)localObject4).CFh = j;
        ((FinderLiveBundle)localObject4).CFi = localbjh.toByteArray();
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).cleatLiveStatusCache(((bip)localObject3).liveId);
        localObject2 = paramIntent;
        if (paramIntent == null) {
          localObject2 = new Intent();
        }
        if (localObject1 != null) {
          break label723;
        }
        paramIntent = null;
        label461:
        ((Intent)localObject2).putExtra("KEY_PARAMS_BG_MUSIC_ID_LIST", paramIntent);
        ((Intent)localObject2).putExtra("KEY_PARAMS_SOURCE_TYPE", ((bip)localObject3).ZFJ);
        ((Intent)localObject2).putExtra("KEY_PARAMS_RANDOM_MIC_MATCH_TIMEOUT", i);
        if (paramawa != null) {
          break label732;
        }
        paramIntent = null;
        label502:
        ((Intent)localObject2).putExtra("KEY_PARAMS_FANS_CLUB", paramIntent);
        if (paramawa != null) {
          break label754;
        }
        paramawa = null;
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("KEY_PARAMS_LIVE_CO_CERT_REWARD_INFO", paramawa);
        ((Intent)localObject2).putExtra("KEY_PARAMS_LIVE_IS_FROM_SCAN", paramBoolean);
        b(paramContext, (FinderLiveBundle)localObject4, "", (Intent)localObject2);
        AppMethodBeat.o(334861);
        return;
        localObject1 = paramawa.ZGo;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderObject)localObject1).liveInfo;
        break;
        label584:
        localObject3 = localObject1;
        break label34;
        label591:
        localbkk = paramawa.live_notice_info;
        break label41;
        label600:
        localLinkedList1 = paramawa.ZGp;
        break label48;
        label609:
        localbno = paramawa.ZGq;
        break label55;
        label618:
        localLinkedList2 = paramawa.ZGr;
        break label62;
        label627:
        localInteger = Integer.valueOf(paramawa.ZGs);
        break label69;
        label639:
        localObject2 = Integer.valueOf(paramawa.ZGv);
        break label76;
        label651:
        localObject1 = paramawa.ZGx;
        break label83;
        label660:
        localObject4 = paramawa.ZGA;
        break label99;
        i = paramawa.ZGt;
        break label174;
        label678:
        i = paramawa.ZGu;
        break label188;
        label687:
        i = paramawa.ZGC;
        break label202;
        label696:
        localObject4 = localObject1;
        break label288;
        label703:
        j = localInteger.intValue();
        break label380;
        label713:
        j = ((Integer)localObject2).intValue();
        break label402;
        label723:
        paramIntent = ((bfk)localObject1).toByteArray();
        break label461;
        label732:
        paramIntent = paramawa.ZGD;
        if (paramIntent == null)
        {
          paramIntent = null;
          break label502;
        }
        paramIntent = paramIntent.toByteArray();
        break label502;
        label754:
        paramawa = paramawa.ZGE;
        if (paramawa == null) {
          paramawa = null;
        } else {
          paramawa = paramawa.toByteArray();
        }
      }
    }
  }
  
  public final void a(Context paramContext, String paramString, bgh parambgh)
  {
    AppMethodBeat.i(334824);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "fromUsername");
    kotlin.g.b.s.u(parambgh, "toUser");
    if (parambgh.ZPU)
    {
      aa.makeText(paramContext, e.h.finder_message_live_user_account_deleted, 0).show();
      AppMethodBeat.o(334824);
      return;
    }
    Object localObject = parambgh.contact;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      Log.i("Finder.ActivityRouter", "[enterChattingUIFromLive] fromUsername=" + paramString + " toUsername=" + (String)localObject + " scene=1");
      bb.a locala = bb.ABb;
      bb.b(parambgh.ZLo);
      ((bp)com.tencent.mm.kernel.h.ax(bp.class)).a(paramContext, (String)localObject, new a..ExternalSyntheticLambda5((String)localObject, paramContext, paramString));
      AppMethodBeat.o(334824);
      return;
      localObject = ((FinderContact)localObject).username;
      if (localObject == null) {
        localObject = "";
      }
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(334787);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "enterPath");
    kotlin.g.b.s.u(paramString3, "sceneNote");
    Log.i("Finder.ActivityRouter", "enter we app appId:" + paramString1 + ",enterPath:" + paramString2 + ",scene:" + paramInt + ",sceneNote:" + paramString3);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(334787);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramString1;
    localg.qAF = paramString2;
    localg.scene = paramInt;
    localg.hzx = paramString3;
    localg.euz = ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).bUq();
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramContext, localg);
    AppMethodBeat.o(334787);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(334891);
    kotlin.g.b.s.u(paramContext, "context");
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
    ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).cleatLiveStatusCache(paramLong2);
    paramString1 = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsH());
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveInvitedUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveInvitedUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334891);
  }
  
  public final void a(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(335047);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramJSONObject, "necessaryParams");
    com.tencent.mm.plugin.finder.feed.jumper.r localr = com.tencent.mm.plugin.finder.feed.jumper.r.Bej;
    com.tencent.mm.plugin.finder.feed.jumper.r.b(paramContext, 0L, paramJSONObject);
    AppMethodBeat.o(335047);
  }
  
  public final void a(Intent paramIntent, Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, Integer paramInteger, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(334843);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "anchorUserName");
    kotlin.g.b.s.u(paramString2, "nonceId");
    kotlin.g.b.s.u(paramString3, "desc");
    kotlin.g.b.s.u(paramString4, "contextId");
    LiveConfig.a locala = new LiveConfig.a();
    bj localbj = bj.GlQ;
    locala.mIy = LiveConfig.mIt;
    locala.liveId = paramLong2;
    locala.nonceId = paramString2;
    locala.mIE = paramString7;
    int i;
    if (paramInteger == null)
    {
      paramString2 = e.b.mKf;
      i = e.b.bcu();
      locala.mIF = i;
      locala.mIH = paramLong1;
      locala.mIC = paramString1;
      locala.desc = paramString3;
      locala.sessionBuffer = paramString5;
      locala.mJc = paramString6;
      if (paramIntent != null) {
        break label541;
      }
      paramString1 = "";
      label153:
      locala.mIG = paramString1;
      locala.mIW = paramArrayOfByte;
      if (paramIntent != null) {
        break label567;
      }
      i = 0;
      label174:
      locala.mIJ = i;
      if (paramIntent != null) {
        break label580;
      }
      paramString1 = "";
      label190:
      locala.hUQ = paramString1;
      if (paramIntent != null) {
        break label606;
      }
      paramString1 = "";
      label206:
      locala.mIK = paramString1;
      if (paramIntent != null) {
        break label632;
      }
      paramString1 = "";
      label222:
      locala.thumbUrl = paramString1;
      if (paramIntent != null) {
        break label658;
      }
      i = 0;
      label236:
      locala.mIX = i;
      kotlin.g.b.s.s(locala, "builder.toWhere(LiveConf…AM_VR_LIVE_TYPE, 0) ?: 0)");
      paramString2 = (com.tencent.mm.bx.a)new bgr();
      if (paramIntent != null) {
        break label671;
      }
    }
    for (paramString1 = null;; paramString1 = paramIntent.getByteArrayExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO"))
    {
      try
      {
        paramString2.parseFrom(paramString1);
        paramString1 = paramString2;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          label375:
          label632:
          Log.printDebugStack("safeParser", "", new Object[] { paramString1 });
          label541:
          label567:
          label580:
          label606:
          paramString1 = null;
          label658:
          label671:
          continue;
          paramInt1 = 0;
          continue;
          if (paramIntent == null) {}
          for (paramInt1 = 0;; paramInt1 = paramIntent.getIntExtra("key_enter_live_param_visitor_enter_scene", 0))
          {
            paramString2.enterScene = paramInt1;
            switch (paramString2.enterScene)
            {
            default: 
              paramInt1 = paramString2.CFf;
              break label375;
            }
          }
          paramInt1 = 1;
          continue;
          paramString1 = paramIntent.getStringExtra("key_enter_live_export_id");
          continue;
          paramInt1 = 0;
          continue;
          paramString1 = paramIntent.getStringArrayListExtra("key_enter_live_export_id_list");
          continue;
          paramInt1 = 0;
        }
      }
      paramString1 = bj.a(locala, "enterFinderLiveVisitorUI", (bgr)paramString1).bcd();
      kotlin.g.b.s.s(paramString1, "builder.toWhere(LiveConf…O)))\n            .build()");
      paramString2 = new FinderLiveBundle();
      paramString2.CFa.add(paramString1);
      paramString2.extFlag = paramInt1;
      paramString2.AJo = paramInt2;
      if ((paramIntent == null) || (paramIntent.hasExtra("key_enter_live_param_pull_more_type") != true)) {
        break label709;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label715;
      }
      paramInt1 = paramIntent.getIntExtra("key_enter_live_param_pull_more_type", -1);
      paramString2.CFf = paramInt1;
      paramString2.av(paramIntent);
      if (paramIntent != null) {
        break label797;
      }
      paramString1 = null;
      paramString3 = (CharSequence)paramString1;
      if ((paramString3 != null) && (paramString3.length() != 0)) {
        break label809;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        ((Map)paramString2.CFl).put(Long.valueOf(paramLong2), paramString1);
      }
      paramString2.CFk.clear();
      if (paramIntent != null) {
        break label815;
      }
      paramString1 = null;
      paramString3 = (Collection)paramString1;
      if ((paramString3 != null) && (!paramString3.isEmpty())) {
        break label827;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        paramString2.CFk.addAll((Collection)paramString1);
      }
      f.a.a((com.tencent.mm.plugin.f)this, paramContext, paramString2, paramString4, null, paramIntent, paramBoolean, 8);
      AppMethodBeat.o(334843);
      return;
      i = paramInteger.intValue();
      break;
      paramString2 = paramIntent.getStringExtra("key_enter_live_export_id");
      paramString1 = paramString2;
      if (paramString2 != null) {
        break label153;
      }
      paramString1 = "";
      break label153;
      i = paramIntent.getIntExtra("key_enter_live_param_bind_type", 0);
      break label174;
      paramString2 = paramIntent.getStringExtra("key_enter_live_param_by_biz_username");
      paramString1 = paramString2;
      if (paramString2 != null) {
        break label190;
      }
      paramString1 = "";
      break label190;
      paramString2 = paramIntent.getStringExtra("key_enter_live_param_by_biz_nickname");
      paramString1 = paramString2;
      if (paramString2 != null) {
        break label206;
      }
      paramString1 = "";
      break label206;
      paramString2 = paramIntent.getStringExtra("key_enter_live_cover_url");
      paramString1 = paramString2;
      if (paramString2 != null) {
        break label222;
      }
      paramString1 = "";
      break label222;
      i = paramIntent.getIntExtra("KEY_ENTER_LIVE_PARAM_VR_LIVE_TYPE", 0);
      break label236;
    }
  }
  
  public final void a(Intent paramIntent, Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(334878);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "nonceId");
    kotlin.g.b.s.u(paramString3, "contextId");
    LiveConfig.a locala = new LiveConfig.a();
    locala.mIy = LiveConfig.mIs;
    locala.liveId = paramLong2;
    locala.nonceId = paramString1;
    locala.mIH = paramLong1;
    locala.mIC = com.tencent.mm.model.z.bAW();
    locala.desc = paramString2;
    locala.mJc = paramString5;
    locala.sessionBuffer = paramString4;
    paramString2 = locala.bcd();
    kotlin.g.b.s.s(paramString2, "builder.toWhere(LiveConf…fer)\n            .build()");
    paramString1 = new FinderLiveBundle();
    paramString1.CFa.add(paramString2);
    paramString2 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
    paramString2 = com.tencent.mm.plugin.finder.storage.data.e.a.jn(paramLong1);
    int i;
    if (paramString2 == null) {
      i = -1;
    }
    for (;;)
    {
      paramString1.CFc = i;
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).cleatLiveStatusCache(paramLong2);
      b(paramContext, paramString1, paramString3, paramIntent);
      AppMethodBeat.o(334878);
      return;
      paramString2 = paramString2.getLiveInfo();
      if (paramString2 == null) {
        i = -1;
      } else {
        i = paramString2.ZRX;
      }
    }
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, Bundle paramBundle)
  {
    AppMethodBeat.i(335062);
    kotlin.g.b.s.u(paramAppCompatActivity, "context");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    an.GhR.a(paramAppCompatActivity, paramBaseFinderFeed, paramBundle);
    AppMethodBeat.o(335062);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(370245);
    kotlin.g.b.s.u(paramAppCompatActivity, "context");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    an.GhR.a(paramAppCompatActivity, paramBaseFinderFeed, paramBundle, paramInt, 0);
    AppMethodBeat.o(370245);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, Bundle paramBundle, int paramInt, kotlin.g.a.b<? super List<String>, ah> paramb)
  {
    AppMethodBeat.i(335055);
    kotlin.g.b.s.u(paramAppCompatActivity, "context");
    kotlin.g.b.s.u(paramFinderItem, "feedObject");
    an.GhR.a(paramAppCompatActivity, paramFinderItem, paramBundle, paramInt, paramb);
    AppMethodBeat.o(335055);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(335065);
    kotlin.g.b.s.u(paramAppCompatActivity, "context");
    kotlin.g.b.s.u(paramString2, "sourceName");
    kotlin.g.b.s.u(paramString3, "localPicPath");
    an.a locala = an.GhR;
    an.a.a(paramAppCompatActivity, paramString1, paramString2, paramString3);
    AppMethodBeat.o(335065);
  }
  
  public final void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(335023);
    kotlin.g.b.s.u(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsv());
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLivePrecheckLicenseUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(335023);
  }
  
  public final void d(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(335080);
    kotlin.g.b.s.u(paramActivity, "activity");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsZ());
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(1013, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveShoppingManagerUIForResult", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    paramActivity.overridePendingTransition(com.tencent.mm.plugin.finder.e.a.slide_right_in, com.tencent.mm.plugin.finder.e.a.slide_left_out);
    AppMethodBeat.o(335080);
  }
  
  public final void e(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334809);
    kotlin.g.b.s.u(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderLbsStreamListUI.class);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(501, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(334809);
  }
  
  public final void enterFinderGameLiveAuthUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334918);
    kotlin.g.b.s.u(paramContext, "context");
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
      paramIntent = com.tencent.mm.plugin.findersdk.e.a.HdV;
      localIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsP());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLiveAuthUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLiveAuthUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334918);
      return;
    }
  }
  
  public final void enterFinderProfileUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167843);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = (com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class);
    if (paramIntent == null) {}
    for (boolean bool1 = false;; bool1 = paramIntent.aBu())
    {
      boolean bool2 = localIntent.getBooleanExtra("KEY_FROM_TIMELINE", false);
      if ((!bool1) || (bool2)) {
        break;
      }
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
      AppMethodBeat.o(167843);
      return;
    }
    paramIntent = localIntent.getStringExtra("finder_username");
    int i;
    if (kotlin.g.b.s.p(com.tencent.mm.model.z.bAW(), paramIntent))
    {
      i = 33;
      int j = localIntent.getIntExtra("key_entrance_type", -1);
      paramIntent = u.GgT;
      u.a(paramContext, localIntent, i, j);
      if ((paramContext instanceof Activity)) {
        break label382;
      }
      paramIntent = localIntent;
      label156:
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderProfileUI.class);
      if (!(paramContext instanceof Activity)) {
        break label387;
      }
      paramIntent = (Activity)paramContext;
      label190:
      if (paramIntent == null) {
        break label392;
      }
      paramIntent = paramIntent.getIntent();
      if ((paramIntent == null) || (paramIntent.getBooleanExtra("KEY_IS_FROM_FINDER_TASK", false) != true)) {
        break label392;
      }
      i = 1;
      label217:
      if (i != 0) {
        localIntent.putExtra("KEY_IS_FROM_FINDER_TASK", true);
      }
      switch (localIntent.getIntExtra("key_enter_profile_type", 0))
      {
      }
    }
    for (;;)
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167843);
      return;
      i = 32;
      break;
      label382:
      paramIntent = null;
      break label156;
      label387:
      paramIntent = null;
      break label190;
      label392:
      i = 0;
      break label217;
      paramIntent = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
      com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999704);
    }
  }
  
  public final void f(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(335041);
    kotlin.g.b.s.u(paramActivity, "activity");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsW());
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderAnchorVerifyWebviewUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderAnchorVerifyWebviewUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(335041);
  }
  
  public final void g(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334969);
    kotlin.g.b.s.u(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsz());
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(1001, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveVisitorWhiteListUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(334969);
  }
  
  public final void h(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(335017);
    kotlin.g.b.s.u(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsx());
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveCreateVisitorRoleUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(335017);
  }
  
  public final void i(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334966);
    kotlin.g.b.s.u(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsN());
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(1002, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateLotteryUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(334966);
  }
  
  public final void j(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334988);
    kotlin.g.b.s.u(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsI());
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryWinnerListUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryWinnerListUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334988);
  }
  
  public final void k(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(334983);
    kotlin.g.b.s.u(paramActivity, "context");
    Context localContext = (Context)paramActivity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsJ());
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryDetailUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryDetailUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334983);
  }
  
  public final void k(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(335072);
    kotlin.g.b.s.u(paramContext, "context");
    ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).B(paramContext, paramIntent);
    AppMethodBeat.o(335072);
  }
  
  public final void l(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(335004);
    kotlin.g.b.s.u(paramContext, "context");
    paramIntent.setClass(paramContext, FinderPoiTimelineUI.class);
    as.a locala = as.GSQ;
    as.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(335004);
  }
  
  public final void m(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334815);
    kotlin.g.b.s.u(paramContext, "context");
    paramIntent.setClass(paramContext, FinderFeedRelatedTimelineUI.class);
    as.a locala = as.GSQ;
    as.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFeedRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFeedRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334815);
  }
  
  public final void n(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167871);
    kotlin.g.b.s.u(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167871);
      return;
    }
  }
  
  public final void o(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334908);
    kotlin.g.b.s.u(paramContext, "context");
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
      paramIntent = com.tencent.mm.plugin.findersdk.e.a.HdV;
      localIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsR());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLivePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLivePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334908);
      return;
    }
  }
  
  public final void p(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334942);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderLiveCountDownUI");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localObject = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsK());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveCountDownUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveCountDownUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334942);
      return;
    }
  }
  
  public final void q(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334929);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderGameLiveSearchUI");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localObject = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsT());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334929);
      return;
    }
  }
  
  public final void r(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334900);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderLiveFansListUI");
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsG());
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334900);
  }
  
  public final void s(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334949);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderLiveWeCoinHotUI");
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsL());
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveWeCoinHotUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveWeCoinHotUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(334949);
  }
  
  public final void t(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334958);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderLiveChargeAnchorIncomeUI");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localObject = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsM());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveChargeAnchorIncomeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveChargeAnchorIncomeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334958);
      return;
    }
  }
  
  public final void u(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334915);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderGameSelectUI");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localObject = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsU());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameSelectUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameSelectUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334915);
      return;
    }
  }
  
  public final void v(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167860);
    kotlin.g.b.s.u(paramContext, "context");
    paramIntent.setClass(paramContext, FinderImagePreviewUI.class);
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167860);
      return;
    }
  }
  
  public final void w(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334998);
    kotlin.g.b.s.u(paramContext, "context");
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
      if (paramIntent == null) {
        paramContext = Integer.valueOf(5);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(20912, new Object[] { Integer.valueOf(3), paramContext, "", "" });
        AppMethodBeat.o(334998);
        return;
        paramIntent = paramIntent.getStringExtra("key_finder_teen_mode_scene");
        paramContext = paramIntent;
        if (paramIntent == null) {
          paramContext = Integer.valueOf(5);
        }
      }
    }
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
      int i = localIntent.getIntExtra("key_entrance_type", -1);
      paramIntent = u.GgT;
      u.a(paramContext, localIntent, 81, i);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334998);
      return;
    }
  }
  
  public final void x(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167838);
    kotlin.g.b.s.u(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167838);
      return;
    }
  }
  
  public final void y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334922);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("Finder.ActivityRouter", "enterFinderGameLiveFinishUI");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localObject = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsQ());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLiveFinishUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLiveFinishUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334922);
      return;
    }
  }
  
  public final void z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(334936);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("Finder.ActivityRouter", "FinderGameLivePostVerifyUI");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localObject = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsS());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLivePostVerifyUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderGameLivePostVerifyUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(334936);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, bui parambui)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, bui parambui)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, bui parambui)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    e(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, bui parambui, int paramInt3)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(FinderLiveBundle paramFinderLiveBundle, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.a
 * JD-Core Version:    0.7.0.1
 */