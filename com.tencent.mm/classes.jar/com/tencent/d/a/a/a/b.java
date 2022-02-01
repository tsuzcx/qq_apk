package com.tencent.d.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.EGLContext;
import android.text.style.ImageSpan;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.d.a.a.a.d.c;
import com.tencent.d.a.a.a.d.e;
import com.tencent.d.a.a.a.d.f;
import com.tencent.d.a.a.a.d.h;
import com.tencent.d.a.a.a.d.i;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.dwa;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.a.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/IPluginFinderLive;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "isFinderLiveActivityIconEntranceEnable", "", "()Z", "isFinderLiveActivityIconSharedEnable", "isNewLiveEntranceEnable", "autoOpenFinderLive", "", "extInfo", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "failedCallback", "", "backToFinderLiveAnchorUIOnExternalLive", "isFinish", "needRelaunchWeAppOnLiveFinished", "batchGetLiveStatus", "finderObjectList", "", "Landroid/util/Pair;", "", "", "callback", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderBatchLiveStatusCallback;", "keeper", "callLiveExperimentalAPI", "jsStr", "cancelCirculationFillingActivityIconOfSourceType", "source", "checkInsertLiveNewReddot", "checkLastLiveObject", "Lkotlin/Function1;", "cleatLiveStatusCache", "liveId", "controlLiveMiniWindowVisibility", "visible", "createFinderLive", "createLuckyMoneyLive", "chatroom", "enableAudioVolumeEvaluation", "interval", "enableCustomAudioCapture", "enable", "enableLiveMiniWid", "isEnable", "enableLocalPushStream", "videoPath", "enableMicExternalAudioFrame", "enablePublish", "enablePlayout", "enterFinderGameLiveAuthUI", "intent", "Landroid/content/Intent;", "enterFinderGameLivePostVerifyUI", "appId", "versionType", "ignoreContinueLive", "developerCustomParam", "reportInfo", "enterFinderLiveAnchorUI", "objectId", "nonceId", "desc", "contextId", "sessionBuffer", "redPacketId", "(Landroid/content/Intent;Landroid/content/Context;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "enterFinderLiveCountDownUI", "enterFinderLiveInvitedUI", "username", "nickname", "avatar", "enterFinderLivePostUI", "i", "enterFinderLiveReplayUI", "anchorUserName", "forceCheckTeenMode", "enterFinderLiveTiger", "launchMode", "(Landroid/content/Intent;Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "enterFinderLiveUIByBiz", "feedExportId", "bizUsername", "fromScene", "feedExportIdList", "bizUsernameList", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "enterFinderLiveVisitorUI", "extFlag", "streamUrl", "audienMode", "(Landroid/content/Intent;Landroid/content/Context;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZ)V", "enterLiveTaskPage", "activity", "Landroid/app/Activity;", "sourceSync", "enterPreloadPlayer", "audienceMode", "liveSdkInfoBytes", "", "executeCirculationFillingActivityIcon", "feedId", "iconView", "Landroid/widget/ImageView;", "(Landroid/content/Context;JLjava/lang/String;Landroid/widget/ImageView;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fillAuthIcon", "finderNickname", "Landroid/widget/TextView;", "finderAuthIcon", "finderObject", "Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;", "iconPadding", "", "forceStopCurLive", "gameLiveShare", "businessType", "appid", "isSameAccount", "getFinderLiveActionRecordStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveActionRecordStorage;", "getFinderLiveChargeInfoStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveChargeInfoStorage;", "getFinderLiveConfigStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveConfigStorage;", "getFinderLiveDislikeBannerStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveDislikeBannerStorage;", "getFinderLiveExternalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveExternalInfo;", "getFinderLiveGiftStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveGiftStorage;", "getFinderLiveLastRewardInfoStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLastRewardInfoStorage;", "getFinderLiveLuckyMoneyStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLuckyMoneyStorage;", "getFinderLiveMemberListInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMemberListInfo;", "getFinderLiveNotifyExposureInfoStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveNotifyExposureInfoStorage;", "getFinderLivePreviewUrl", "encryptedId", "scene", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "url", "errMsg", "errCode", "getFinderLiveStatusFromTag", "liveTag", "Landroid/view/View;", "liveEndTag", "(Landroid/view/View;Landroid/view/View;)Ljava/lang/Integer;", "getFinderLiveVideoDefinitionStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveVideoDefinitionStorage;", "getImageResFromActivityType", "actType", "getLiveInfo", "forceRefresh", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "getLiveSettlementInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSettlementInfo;", "getLocalPushStreamPath", "getTopic", "goToAnchorLiveDirect", "finishCallback", "Lkotlin/Function0;", "isFromScan", "gotoLive", "anchorUsername", "fireAuthorInfo", "Lcom/tencent/mm/protocal/protobuf/FinderOlympicLiveFireAuthorInfo;", "reportData", "Lcom/tencent/mm/protocal/protobuf/OlympicsLiveEntranceReportData;", "initOlympicsReport", "isAnchorLiving", "isChargeLive", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "isChatRoomDisable", "groupId", "isGameAnchorLiving", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback$GameLivingStatus;", "isLiveTaskEnable", "entrance", "isReplayLive", "isUnPurchasedChargeLive", "isVisitorLiving", "loadMicInfos", "Lkotlin/Function4;", "errType", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "resp", "loadOlympicsImage", "imageView", "resType", "Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$ResType;", "defaultResId", "loadVisitorCore", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mixExternalAudioFrame", "audioBuffer", "sampleRate", "channel", "timestamp", "openFinderLive", "reportExtraInfo", "parseAllBadgeInfos", "Landroid/text/style/ImageSpan;", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "spanFilter", "", "spanMode", "sizeType", "pauseLive", "pauseVisitorLive", "producingReplay", "registerExternalLiveCallback", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "reportFinderLiveReplay", "pageType", "reportPlayGamePanelShowAction", "jo", "requestFinderLiveNotify", "json", "requestFinderLiveNotifyOnLiveClose", "funcMsgId", "resumeLive", "resumeVisitorLive", "sendExternalLiveAudioData", "sendExternalLiveData", "eglContext", "Landroid/opengl/EGLContext;", "texId", "width", "height", "setCustomResolution", "isVertical", "setFinderLiveTagText", "chargeFlag", "setTopic", "topic", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveSetTopicCallback;", "setVoiceCaptureVolume", "volume", "shareLiveToFriend", "Landroidx/appcompat/app/AppCompatActivity;", "shareLiveToSns", "startLocalAudio", "startPlayGameAnchorSetting", "ck", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveActionCallBack;", "unregisterExternalLiveCallback", "Companion", "FinderBatchLiveStatusCallback", "FinderLiveStatusCallback", "IGameLiveActionCallBack", "IGameLiveSetTopicCallback", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
  extends com.tencent.mm.kernel.b.a
{
  public static final b.a ahiV = b.a.ahiW;
  
  public abstract void autoOpenFinderLive(JSONObject paramJSONObject, Context paramContext, ca.a<Object> parama, ca.a<Integer> parama1);
  
  public abstract void backToFinderLiveAnchorUIOnExternalLive(Context paramContext, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void batchGetLiveStatus(List<? extends Pair<Long, String>> paramList, b.c paramc, Context paramContext);
  
  public abstract void callLiveExperimentalAPI(String paramString);
  
  public abstract void cancelCirculationFillingActivityIconOfSourceType(int paramInt);
  
  public abstract void checkInsertLiveNewReddot();
  
  public abstract void checkLastLiveObject(Context paramContext, kotlin.g.a.b<? super Boolean, ah> paramb);
  
  public abstract void cleatLiveStatusCache(long paramLong);
  
  public abstract void controlLiveMiniWindowVisibility(boolean paramBoolean, Context paramContext);
  
  public abstract void createFinderLive(Context paramContext, String paramString);
  
  public abstract void createLuckyMoneyLive(Context paramContext, String paramString);
  
  public abstract void enableAudioVolumeEvaluation(int paramInt);
  
  public abstract void enableLiveMiniWid(boolean paramBoolean);
  
  public abstract void enableLocalPushStream(String paramString);
  
  public abstract void enableMicExternalAudioFrame(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void enterFinderGameLiveAuthUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderGameLivePostVerifyUI(Context paramContext, String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3);
  
  public abstract void enterFinderLiveAnchorUI(Intent paramIntent, Context paramContext, long paramLong, Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void enterFinderLiveCountDownUI(Context paramContext);
  
  public abstract void enterFinderLiveInvitedUI(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void enterFinderLiveReplayUI(Intent paramIntent, Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean);
  
  public abstract void enterFinderLiveTiger(Intent paramIntent, Context paramContext, Long paramLong1, String paramString1, String paramString2, boolean paramBoolean, int paramInt, Long paramLong2, String paramString3, String paramString4);
  
  public abstract void enterFinderLiveUIByBiz(Context paramContext, String paramString1, String paramString2, Integer paramInteger, List<String> paramList1, List<String> paramList2);
  
  public abstract void enterFinderLiveVisitorUI(Intent paramIntent, Context paramContext, long paramLong, Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, int paramInt2, boolean paramBoolean);
  
  public abstract Object executeCirculationFillingActivityIcon(Context paramContext, long paramLong, String paramString, ImageView paramImageView, int paramInt, kotlin.d.d<? super ah> paramd);
  
  public abstract void fillAuthIcon(TextView paramTextView, ImageView paramImageView, com.tencent.mm.plugin.findersdk.a.b paramb, float paramFloat);
  
  public abstract void gameLiveShare(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract com.tencent.d.a.a.a.d.a getFinderLiveActionRecordStorage();
  
  public abstract com.tencent.d.a.a.a.d.b getFinderLiveChargeInfoStorage();
  
  public abstract c getFinderLiveConfigStorage();
  
  public abstract com.tencent.d.a.a.a.d.d getFinderLiveDislikeBannerStorage();
  
  public abstract bgt getFinderLiveExternalInfo();
  
  public abstract e getFinderLiveGiftStorage();
  
  public abstract f getFinderLiveLastRewardInfoStorage();
  
  public abstract com.tencent.d.a.a.a.d.g getFinderLiveLuckyMoneyStorage();
  
  public abstract void getFinderLiveMemberListInfo(ca.a<List<bjk>> parama);
  
  public abstract h getFinderLiveNotifyExposureInfoStorage();
  
  public abstract void getFinderLivePreviewUrl(String paramString1, String paramString2, int paramInt, q<? super String, ? super String, ? super Integer, ah> paramq);
  
  public abstract i getFinderLiveVideoDefinitionStorage();
  
  public abstract int getImageResFromActivityType(int paramInt);
  
  public abstract void getLiveInfo(long paramLong, boolean paramBoolean, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, b.d paramd);
  
  public abstract bmq getLiveSettlementInfo();
  
  public abstract String getLocalPushStreamPath();
  
  public abstract String getTopic();
  
  public abstract void goToAnchorLiveDirect(Activity paramActivity, kotlin.g.a.a<ah> parama, boolean paramBoolean);
  
  public abstract void gotoLive(Context paramContext, String paramString, brs parambrs, dwa paramdwa);
  
  public abstract void initOlympicsReport(dwa paramdwa);
  
  public abstract boolean isAnchorLiving();
  
  public abstract boolean isChargeLive(bip parambip);
  
  public abstract boolean isChatRoomDisable(String paramString);
  
  public abstract boolean isFinderLiveActivityIconEntranceEnable();
  
  public abstract boolean isFinderLiveActivityIconSharedEnable();
  
  public abstract boolean isNewLiveEntranceEnable();
  
  public abstract boolean isReplayLive(View paramView1, View paramView2, long paramLong);
  
  public abstract boolean isReplayLive(bip parambip);
  
  public abstract boolean isUnPurchasedChargeLive(bip parambip);
  
  public abstract boolean isVisitorLiving();
  
  public abstract void loadMicInfos(String paramString1, String paramString2, r<? super Integer, ? super Integer, ? super String, ? super aub, ah> paramr);
  
  public abstract void loadOlympicsImage(ImageView paramImageView, b.j paramj, int paramInt);
  
  public abstract Object loadVisitorCore(com.tencent.mm.live.core.core.model.g paramg, kotlin.d.d<? super ah> paramd);
  
  public abstract void mixExternalAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong);
  
  public abstract void openFinderLive(JSONObject paramJSONObject, ca.a<Integer> parama, ca.a<Object> parama1, String paramString);
  
  public abstract List<ImageSpan> parseAllBadgeInfos(List<? extends bfl> paramList, int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  public abstract void pauseLive(int paramInt);
  
  public abstract void pauseVisitorLive();
  
  public abstract boolean producingReplay(bip parambip);
  
  public abstract void registerExternalLiveCallback(a parama);
  
  public abstract void reportFinderLiveReplay(long paramLong, String paramString);
  
  public abstract void reportPlayGamePanelShowAction(JSONObject paramJSONObject);
  
  public abstract void requestFinderLiveNotify(String paramString);
  
  public abstract void requestFinderLiveNotifyOnLiveClose(String paramString);
  
  public abstract void resumeLive(int paramInt);
  
  public abstract void resumeVisitorLive();
  
  public abstract void sendExternalLiveData(EGLContext paramEGLContext, int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public abstract void setCustomResolution(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void setFinderLiveTagText(View paramView, int paramInt);
  
  public abstract void setTopic(String paramString, b.f paramf);
  
  public abstract void setVoiceCaptureVolume(int paramInt);
  
  public abstract void shareLiveToFriend(AppCompatActivity paramAppCompatActivity);
  
  public abstract void shareLiveToSns(AppCompatActivity paramAppCompatActivity);
  
  public abstract void startLocalAudio(boolean paramBoolean);
  
  public abstract void startPlayGameAnchorSetting(JSONObject paramJSONObject, b.e parame);
  
  public abstract void unregisterExternalLiveCallback(a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */