package com.tencent.c.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.EGLContext;
import android.util.Pair;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.c.a.a.a.d.c;
import com.tencent.c.a.a.a.d.d;
import com.tencent.c.a.a.a.d.e;
import com.tencent.c.a.a.a.d.f;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.bas;
import com.tencent.mm.protocal.protobuf.bco;
import java.util.List;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/IPluginFinderLive;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "autoOpenFinderLive", "", "extInfo", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "failedCallback", "", "backToFinderLiveAnchorUIOnExternalLive", "isFinish", "", "needRelaunchWeAppOnLiveFinished", "batchGetLiveStatus", "finderObjectList", "", "Landroid/util/Pair;", "", "", "callback", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderBatchLiveStatusCallback;", "callLiveExperimentalAPI", "jsStr", "checkInsertLiveNewReddot", "checkLastLiveObject", "Lkotlin/Function1;", "cleatLiveStatusCache", "liveId", "controlLiveMiniWindowVisibility", "visible", "createFinderLive", "createLuckyMoneyLive", "chatroom", "enableAudioVolumeEvaluation", "interval", "enableCustomAudioCapture", "enable", "enableMicExternalAudioFrame", "enablePublish", "enablePlayout", "enterFinderGameLiveAuthUI", "intent", "Landroid/content/Intent;", "enterFinderGameLivePostVerifyUI", "appId", "versionType", "ignoreContinueLive", "enterFinderLiveAnchorUI", "objectId", "nonceId", "desc", "contextId", "sessionBuffer", "redPacketId", "(Landroid/content/Intent;Landroid/content/Context;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "enterFinderLiveCountDownUI", "enterFinderLiveInvitedUI", "username", "nickname", "avatar", "enterFinderLivePostUI", "i", "enterFinderLiveUIByBiz", "feedExportId", "bizUsername", "fromScene", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "enterFinderLiveVisitorUI", "anchorUserName", "extFlag", "streamUrl", "audienMode", "forceCheckTeenMode", "(Landroid/content/Intent;Landroid/content/Context;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZ)V", "enterLiveTaskPage", "activity", "Landroid/app/Activity;", "sourceSync", "forceStopCurLive", "gameLiveShare", "businessType", "appid", "getFinderLiveActionRecordStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveActionRecordStorage;", "getFinderLiveConfigStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveConfigStorage;", "getFinderLiveExternalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveExternalInfo;", "getFinderLiveGiftStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveGiftStorage;", "getFinderLiveLastRewardInfoStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLastRewardInfoStorage;", "getFinderLiveLuckyMoneyStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLuckyMoneyStorage;", "getFinderLiveMemberListInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMemberListInfo;", "getFinderLiveNotifyExposureInfoStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveNotifyExposureInfoStorage;", "getFinderLivePreviewUrl", "encryptedId", "scene", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "url", "errMsg", "errCode", "getLiveInfo", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "getLiveSettlementInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSettlementInfo;", "isAnchorLiving", "isGameAnchorLiving", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback$GameLivingStatus;", "isLiveTaskEnable", "entrance", "isVisitorLiving", "mixExternalAudioFrame", "audioBuffer", "", "sampleRate", "channel", "timestamp", "openFinderLive", "reportExtraInfo", "pauseLive", "refreshLiveStatus", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "registerExternalLiveCallback", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "requestFinderLiveNotify", "json", "requestFinderLiveNotifyOnLiveClose", "funcMsgId", "resumeLive", "sendExternalLiveAudioData", "sendExternalLiveData", "eglContext", "Landroid/opengl/EGLContext;", "texId", "width", "height", "setCustomResolution", "isVertical", "setVoiceCaptureVolume", "volume", "shareLiveToFriend", "Landroidx/appcompat/app/AppCompatActivity;", "shareLiveToSns", "startLocalAudio", "unregisterExternalLiveCallback", "Companion", "FinderBatchLiveStatusCallback", "FinderLiveStatusCallback", "plugin-finder-live-api_release"})
public abstract interface b
  extends com.tencent.mm.kernel.b.a
{
  public static final b.a Zjl = b.a.Zjm;
  
  public abstract void autoOpenFinderLive(JSONObject paramJSONObject, Context paramContext, ag.a<Object> parama, ag.a<Integer> parama1);
  
  public abstract void backToFinderLiveAnchorUIOnExternalLive(Context paramContext, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void batchGetLiveStatus(List<? extends Pair<Long, String>> paramList, c paramc);
  
  public abstract void callLiveExperimentalAPI(String paramString);
  
  public abstract void checkInsertLiveNewReddot();
  
  public abstract void checkLastLiveObject(Context paramContext, kotlin.g.a.b<? super Boolean, x> paramb);
  
  public abstract void cleatLiveStatusCache(long paramLong);
  
  public abstract void controlLiveMiniWindowVisibility(boolean paramBoolean, Context paramContext);
  
  public abstract void createFinderLive(Context paramContext, String paramString);
  
  public abstract void createLuckyMoneyLive(Context paramContext, String paramString);
  
  public abstract void enableAudioVolumeEvaluation(int paramInt);
  
  public abstract void enableMicExternalAudioFrame(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void enterFinderGameLiveAuthUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderGameLivePostVerifyUI(Context paramContext, String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void enterFinderLiveAnchorUI(Intent paramIntent, Context paramContext, long paramLong, Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void enterFinderLiveCountDownUI(Context paramContext);
  
  public abstract void enterFinderLiveInvitedUI(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void enterFinderLiveUIByBiz(Context paramContext, String paramString1, String paramString2, Integer paramInteger);
  
  public abstract void enterFinderLiveVisitorUI(Intent paramIntent, Context paramContext, long paramLong, Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, int paramInt2, boolean paramBoolean);
  
  public abstract void enterLiveTaskPage(Activity paramActivity, int paramInt);
  
  public abstract void gameLiveShare(String paramString1, String paramString2, String paramString3);
  
  public abstract com.tencent.c.a.a.a.d.a getFinderLiveActionRecordStorage();
  
  public abstract com.tencent.c.a.a.a.d.b getFinderLiveConfigStorage();
  
  public abstract azg getFinderLiveExternalInfo();
  
  public abstract c getFinderLiveGiftStorage();
  
  public abstract d getFinderLiveLastRewardInfoStorage();
  
  public abstract e getFinderLiveLuckyMoneyStorage();
  
  public abstract void getFinderLiveMemberListInfo(ag.a<List<bas>> parama);
  
  public abstract f getFinderLiveNotifyExposureInfoStorage();
  
  public abstract void getFinderLivePreviewUrl(String paramString1, String paramString2, int paramInt, q<? super String, ? super String, ? super Integer, x> paramq);
  
  public abstract void getLiveInfo(long paramLong, d paramd);
  
  public abstract bco getLiveSettlementInfo();
  
  public abstract boolean isAnchorLiving();
  
  public abstract boolean isLiveTaskEnable(String paramString);
  
  public abstract boolean isVisitorLiving();
  
  public abstract void mixExternalAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong);
  
  public abstract void openFinderLive(JSONObject paramJSONObject, ag.a<Integer> parama, ag.a<Object> parama1, String paramString);
  
  public abstract void pauseLive(int paramInt);
  
  public abstract void refreshLiveStatus(long paramLong, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, d paramd);
  
  public abstract void registerExternalLiveCallback(a parama);
  
  public abstract void requestFinderLiveNotify(String paramString);
  
  public abstract void requestFinderLiveNotifyOnLiveClose(String paramString);
  
  public abstract void resumeLive(int paramInt);
  
  public abstract void sendExternalLiveData(EGLContext paramEGLContext, int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public abstract void setCustomResolution(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void setVoiceCaptureVolume(int paramInt);
  
  public abstract void shareLiveToFriend(AppCompatActivity paramAppCompatActivity);
  
  public abstract void shareLiveToSns(AppCompatActivity paramAppCompatActivity);
  
  public abstract void startLocalAudio(boolean paramBoolean);
  
  public abstract void unregisterExternalLiveCallback(a parama);
  
  @l(iBK={1, 1, 16})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderBatchLiveStatusCallback;", "", "onBatchLiveStatusCallback", "", "liveInfoMap", "", "", "", "intervalSec", "plugin-finder-live-api_release"})
  public static abstract interface c
  {
    public abstract void f(Map<Long, Integer> paramMap, int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "", "onLiveStatusCallback", "", "liveId", "", "status", "", "liveInfoResp", "plugin-finder-live-api_release"})
  public static abstract interface d
  {
    public abstract void a(long paramLong, int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */