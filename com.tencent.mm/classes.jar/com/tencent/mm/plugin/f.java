package com.tencent.mm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.bui;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/IActivityRouter;", "Lcom/tencent/mm/kernel/service/IService;", "enterChattingUIFromLive", "", "context", "Landroid/content/Context;", "fromUsername", "", "toUser", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "scene", "", "enterChattingUIFromLottery", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "lotteryId", "objectId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isAnchorToVisitor", "", "enterFeedRelatedTimelineUI", "i", "Landroid/content/Intent;", "enterFinderAnchorVerifyWebviewUI", "activity", "Landroid/app/Activity;", "enterFinderCreateContactUI", "enterFinderCreateLotteryUI", "requestCode", "enterFinderFixRatioEditUI", "inputPath", "outputPath", "ratio", "", "color", "enterFinderGameLiveAuthUI", "enterFinderGameLiveFinishUI", "enterFinderGameLivePostUI", "enterFinderGameLivePostVerifyUI", "enterFinderGameSearchUI", "enterFinderGameSelectUI", "enterFinderImagePreviewUI", "enterFinderLiveAnchorUI", "nonceId", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInviteInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LinkInviteInfo;", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "desc", "tagInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "chosenTagInfo", "contextId", "sessionBuffer", "visitorWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "intent", "liveId", "redPacketId", "enterFinderLiveChargeAnchorIncomeUI", "enterFinderLiveCountDownUI", "enterFinderLiveCreateVisitorRoleUI", "enterFinderLiveFansListUI", "enterFinderLiveInvitedUI", "username", "nickname", "avatar", "enterFinderLiveNoticeUI", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "isCanCreate", "enterFinderLivePrecheckLicenseUI", "enterFinderLivePrepareUI", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "isFromScan", "enterFinderLiveReplayUI", "enterFinderLiveShoppingManagerUIForResult", "enterFinderLiveVisitorRoleUI", "fromUserGuide", "enterFinderLiveVisitorUI", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "clickTabContextId", "needAnim", "anchorUserName", "extFlag", "streamUrl", "audienMode", "commentScene", "liveSdkInfo", "", "(Landroid/content/Intent;Landroid/content/Context;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I[BZ)V", "enterFinderLiveVisitorWhiteListUI", "enterFinderLiveWeCoinHotUI", "enterFinderLotteryHistoryDetailUI", "enterFinderLotteryHistoryUI", "isFromSetting", "enterFinderLotteryWinnerListUI", "enterFinderProfileUI", "enterLbsStreamListUI", "enterLiveTaskH5", "sourceSync", "forceUrl", "enterPoiFeedUI", "enterPoiTimelineUI", "enterTopicFeedUI", "enterTopicTimelineUI", "enterWeApp", "appId", "enterPath", "sceneNote", "jumpHotSearch", "feedId", "necessaryParams", "Lorg/json/JSONObject;", "shareToConversation", "Landroidx/appcompat/app/AppCompatActivity;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "param", "Landroid/os/Bundle;", "shareType", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "toUsers", "shareToSnsTimeLine", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "postFromSnsType", "shareToStatusTimeLine", "shareWinterOlympicsLiveToStatus", "verifyInfo", "sourceName", "localPicPath", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
  extends a
{
  public abstract void A(Context paramContext, Intent paramIntent);
  
  public abstract int a(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent, boolean paramBoolean);
  
  public abstract void a(Activity paramActivity, Intent paramIntent, int paramInt, boolean paramBoolean);
  
  public abstract void a(Activity paramActivity, Intent paramIntent, FinderContact paramFinderContact);
  
  public abstract void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void a(Context paramContext, int paramInt, bjb parambjb, String paramString, long paramLong, bui parambui, boolean paramBoolean);
  
  public abstract void a(Context paramContext, int paramInt, String paramString);
  
  public abstract void a(Context paramContext, long paramLong, String paramString1, bip parambip, bkk parambkk, String paramString2, LinkedList<bno> paramLinkedList, bno parambno, String paramString3, String paramString4, LinkedList<bfh> paramLinkedList1, Intent paramIntent);
  
  public abstract void a(Context paramContext, Intent paramIntent, boolean paramBoolean);
  
  public abstract void a(Context paramContext, awa paramawa, Intent paramIntent, boolean paramBoolean);
  
  public abstract void a(Context paramContext, String paramString, bgh parambgh);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2);
  
  public abstract void a(Context paramContext, JSONObject paramJSONObject);
  
  public abstract void a(Intent paramIntent, Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, Integer paramInteger, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean);
  
  public abstract void a(Intent paramIntent, Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void a(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, Bundle paramBundle);
  
  public abstract void a(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, Bundle paramBundle, int paramInt);
  
  public abstract void a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, Bundle paramBundle, int paramInt, b<? super List<String>, ah> paramb);
  
  public abstract void a(AppCompatActivity paramAppCompatActivity, String paramString1, String paramString2, String paramString3);
  
  public abstract void b(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void d(Activity paramActivity, Intent paramIntent);
  
  public abstract void e(Activity paramActivity, Intent paramIntent);
  
  public abstract void enterFinderGameLiveAuthUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderProfileUI(Context paramContext, Intent paramIntent);
  
  public abstract void f(Activity paramActivity, Intent paramIntent);
  
  public abstract void g(Activity paramActivity, Intent paramIntent);
  
  public abstract void h(Activity paramActivity, Intent paramIntent);
  
  public abstract void i(Activity paramActivity, Intent paramIntent);
  
  public abstract void j(Activity paramActivity, Intent paramIntent);
  
  public abstract void k(Activity paramActivity, Intent paramIntent);
  
  public abstract void k(Context paramContext, Intent paramIntent);
  
  public abstract void l(Context paramContext, Intent paramIntent);
  
  public abstract void m(Context paramContext, Intent paramIntent);
  
  public abstract void n(Context paramContext, Intent paramIntent);
  
  public abstract void o(Context paramContext, Intent paramIntent);
  
  public abstract void p(Context paramContext, Intent paramIntent);
  
  public abstract void q(Context paramContext, Intent paramIntent);
  
  public abstract void r(Context paramContext, Intent paramIntent);
  
  public abstract void s(Context paramContext, Intent paramIntent);
  
  public abstract void t(Context paramContext, Intent paramIntent);
  
  public abstract void u(Context paramContext, Intent paramIntent);
  
  public abstract void v(Context paramContext, Intent paramIntent);
  
  public abstract void w(Context paramContext, Intent paramIntent);
  
  public abstract void x(Context paramContext, Intent paramIntent);
  
  public abstract void y(Context paramContext, Intent paramIntent);
  
  public abstract void z(Context paramContext, Intent paramIntent);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f
 * JD-Core Version:    0.7.0.1
 */