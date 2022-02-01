package com.tencent.mm.plugin.finder.live.viewmodel;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.b.o.c;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "", "()V", "DROP_LIST_SIZE", "", "getDROP_LIST_SIZE", "()I", "MAX_LOTTERY_ID_LIST", "getMAX_LOTTERY_ID_LIST", "TAG", "", "acceptLinkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLinkMicUser;", "getAcceptLinkUser", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLinkMicUser;", "setAcceptLinkUser", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLinkMicUser;)V", "acceptSeq", "", "getAcceptSeq", "()J", "setAcceptSeq", "(J)V", "actionData", "Ljava/util/HashMap;", "getActionData", "()Ljava/util/HashMap;", "setActionData", "(Ljava/util/HashMap;)V", "actionState", "Landroid/os/Bundle;", "getActionState", "()Landroid/os/Bundle;", "setActionState", "(Landroid/os/Bundle;)V", "alertInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "getAlertInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "setAlertInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;)V", "anchorInitProduct", "", "getAnchorInitProduct", "()Z", "setAnchorInitProduct", "(Z)V", "anchorStatusFlag", "getAnchorStatusFlag", "setAnchorStatusFlag", "(I)V", "anchorUsername", "getAnchorUsername", "()Ljava/lang/String;", "setAnchorUsername", "(Ljava/lang/String;)V", "applyInviteUsername", "getApplyInviteUsername", "setApplyInviteUsername", "applyLinkList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getApplyLinkList", "()Ljava/util/ArrayList;", "setApplyLinkList", "(Ljava/util/ArrayList;)V", "applySessionId", "getApplySessionId", "setApplySessionId", "value", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "badgeInfo", "getBadgeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "setBadgeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;)V", "bindShop", "getBindShop", "setBindShop", "bulletCommetList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "kotlin.jvm.PlatformType", "", "getBulletCommetList", "()Ljava/util/List;", "setBulletCommetList", "(Ljava/util/List;)V", "commentReachLastOnViewDettach", "getCommentReachLastOnViewDettach", "setCommentReachLastOnViewDettach", "commentReadCount", "getCommentReadCount", "setCommentReadCount", "commentSize", "getCommentSize", "setCommentSize", "curAppId", "getCurAppId", "setCurAppId", "curBalance", "getCurBalance", "setCurBalance", "curLinkMicUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "getCurLinkMicUser", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "setCurLinkMicUser", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;)V", "curVisiableFirstPosition", "getCurVisiableFirstPosition", "setCurVisiableFirstPosition", "curVisiableLastPosition", "getCurVisiableLastPosition", "setCurVisiableLastPosition", "desc", "getDesc", "setDesc", "disableCommentCacheMap", "getDisableCommentCacheMap", "setDisableCommentCacheMap", "enableCommentSvr", "getEnableCommentSvr", "()Ljava/lang/Boolean;", "setEnableCommentSvr", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableCustomerComment", "getEnableCustomerComment", "setEnableCustomerComment", "enableGift", "getEnableGift", "setEnableGift", "enableGiftAntispam", "getEnableGiftAntispam", "setEnableGiftAntispam", "enableGiftFlag", "getEnableGiftFlag", "setEnableGiftFlag", "enableGiftSwitch", "getEnableGiftSwitch", "setEnableGiftSwitch", "enableLinkMic", "getEnableLinkMic", "setEnableLinkMic", "enableLinkMicAntispam", "getEnableLinkMicAntispam", "setEnableLinkMicAntispam", "enableLinkMicFlag", "getEnableLinkMicFlag", "setEnableLinkMicFlag", "enableLinkMicSwitch", "getEnableLinkMicSwitch", "setEnableLinkMicSwitch", "enableLiveRoomComment", "getEnableLiveRoomComment", "setEnableLiveRoomComment", "enableLottery", "getEnableLottery", "setEnableLottery", "enableVisitorGiftSwitch", "getEnableVisitorGiftSwitch", "setEnableVisitorGiftSwitch", "exptBeautyEnable", "getExptBeautyEnable", "setExptBeautyEnable", "exptFilterEnable", "getExptFilterEnable", "setExptFilterEnable", "finderDescObject", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getFinderDescObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setFinderDescObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "firstBugProductList", "getFirstBugProductList", "setFirstBugProductList", "floatModeRemoveActivity", "getFloatModeRemoveActivity", "setFloatModeRemoveActivity", "followLinkUserList", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getFollowLinkUserList", "setFollowLinkUserList", "forceChangeOrientation", "getForceChangeOrientation", "setForceChangeOrientation", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "giftQueue", "Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl;", "getGiftQueue", "()Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl;", "setGiftQueue", "(Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl;)V", "hasLotteryHistory", "getHasLotteryHistory", "setHasLotteryHistory", "haveMiniProInstance", "getHaveMiniProInstance", "setHaveMiniProInstance", "highLightCheerList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "getHighLightCheerList", "setHighLightCheerList", "isBussinessVisitor", "setBussinessVisitor", "isLiveQosControlEnabled", "setLiveQosControlEnabled", "isLiveQosReportEnabled", "setLiveQosReportEnabled", "joinLiveTips", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;", "getJoinLiveTips", "()Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;", "setJoinLiveTips", "(Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;)V", "lastCandidateBuffer", "", "getLastCandidateBuffer", "()[B", "setLastCandidateBuffer", "([B)V", "lastChosenTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLastChosenTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setLastChosenTagInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "lastLiveCommentSeq", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "getLastLiveCommentSeq", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "setLastLiveCommentSeq", "(Lcom/tencent/mm/algorithm/MMLRUMap;)V", "likes", "getLikes", "setLikes", "linkApplyTimestamp", "getLinkApplyTimestamp", "setLinkApplyTimestamp", "linkInviteInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LinkInviteInfo;", "getLinkInviteInfo", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/LinkInviteInfo;", "setLinkInviteInfo", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/LinkInviteInfo;)V", "linkMicState", "getLinkMicState", "setLinkMicState", "linkMicUserList", "getLinkMicUserList", "setLinkMicUserList", "linkSucTimestamp", "getLinkSucTimestamp", "setLinkSucTimestamp", "liveBreakRule", "getLiveBreakRule", "setLiveBreakRule", "liveCookies", "getLiveCookies", "setLiveCookies", "liveCoverUrl", "getLiveCoverUrl", "setLiveCoverUrl", "liveExtFlag", "getLiveExtFlag", "setLiveExtFlag", "liveFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLiveFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setLiveFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "liveFinish", "getLiveFinish", "setLiveFinish", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInfo", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)V", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "liveState", "getLiveState", "setLiveState", "localLotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "getLocalLotteryInfoWrapper", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "setLocalLotteryInfoWrapper", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;)V", "localLotteryInfoWrapperList", "Ljava/util/LinkedList;", "getLocalLotteryInfoWrapperList", "()Ljava/util/LinkedList;", "setLocalLotteryInfoWrapperList", "(Ljava/util/LinkedList;)V", "localSaveLotteryIdList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Pair;", "getLocalSaveLotteryIdList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLocalSaveLotteryIdList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "lotteryRecord", "getLotteryRecord", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setLotteryRecord", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;)V", "msgList", "getMsgList", "setMsgList", "needMiniWindow", "getNeedMiniWindow", "setNeedMiniWindow", "newApplyCount", "getNewApplyCount", "setNewApplyCount", "newApplyLinkList", "getNewApplyLinkList", "setNewApplyLinkList", "newLinkMicUserList", "getNewLinkMicUserList", "setNewLinkMicUserList", "nonceId", "getNonceId", "setNonceId", "objectId", "getObjectId", "setObjectId", "offlineMemberCount", "getOfflineMemberCount", "setOfflineMemberCount", "offlineMemberList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getOfflineMemberList", "setOfflineMemberList", "onlineMemberCount", "getOnlineMemberCount", "setOnlineMemberCount", "onlineMemberList", "getOnlineMemberList", "setOnlineMemberList", "onlineSelfContact", "getOnlineSelfContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "setOnlineSelfContact", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;)V", "preloadMiniProgram", "getPreloadMiniProgram", "setPreloadMiniProgram", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "products", "getProducts", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "setProducts", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "promotingProduct", "getPromotingProduct", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "setPromotingProduct", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;)V", "rencentLinkUserList", "getRencentLinkUserList", "setRencentLinkUserList", "requestId", "getRequestId", "setRequestId", "riskControlEnableComment", "getRiskControlEnableComment", "setRiskControlEnableComment", "screenClear", "getScreenClear", "setScreenClear", "sessionBuffer", "getSessionBuffer", "setSessionBuffer", "sessionId", "getSessionId", "setSessionId", "shoppingAvailable", "getShoppingAvailable", "setShoppingAvailable", "shoppingInMiniProgram", "getShoppingInMiniProgram", "setShoppingInMiniProgram", "showStatistics", "getShowStatistics", "setShowStatistics", "sourceType", "getSourceType", "setSourceType", "statistics", "getStatistics", "setStatistics", "statusVerifyInfo", "getStatusVerifyInfo", "setStatusVerifyInfo", "supportScreenRotation", "getSupportScreenRotation", "setSupportScreenRotation", "tagInfo", "getTagInfo", "setTagInfo", "tickleUserCache", "getTickleUserCache", "setTickleUserCache", "topMsgList", "getTopMsgList", "setTopMsgList", "totalCnt", "getTotalCnt", "setTotalCnt", "uiState", "getUiState", "setUiState", "useUpdateStrategy", "getUseUpdateStrategy", "setUseUpdateStrategy", "videoHeight", "getVideoHeight", "setVideoHeight", "videoWidth", "getVideoWidth", "setVideoWidth", "visibilityChooseByteArray", "getVisibilityChooseByteArray", "setVisibilityChooseByteArray", "visibilityMode", "getVisibilityMode", "setVisibilityMode", "visitorWhiteList", "getVisitorWhiteList", "setVisitorWhiteList", "addLiveRoomCommentMsg", "", "liveRoomComment", "audienceMode", "cancelLotteryInfo", "clearLotteryInfoList", "fitLandscapeVideo", "getLotteryIdList", "getTrtcKeyParams", "hasJoinLive", "haveParticipated", "info", "isAnchorAliveExpired", "isLandscapeVideo", "isLiveFinish", "isLiveIdle", "isLivePrepare", "isLiveStarted", "isLiveStartedWait", "isRemoteItemValid", "remoteLotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "localLotteryInfo", "linkMicWait", "linking", "lotteryIdHaveShow", "lotteryId", "lotteryIdListToString", "lotteryList", "mergeLotteryRecord", "record", "mergeProducts", "resp", "printLotteryInfoList", "prefix", "fromJoinLive", "removeLotteryInfoFromList", "saveId", "removeTargetLinkUser", "finderUsername", "replaceLocalLotteryInfo", "lotteryInfoWrapper", "reset", "resetLotteryInfoToList", "liveMsgLotteryInfoList", "resetLotteryRecord", "resetProductList", "safeResetAlertInfo", "safeResetLocalLotteryInfo", "safeSetAlertInfo", "saveLastWinLotteryId", "selfSdkUserId", "setupOnceExptConfig", "toString", "transLotteryInfo", "finderLiveLotteryInfo", "lastDoneLottery", "updateAnchorStatus", "updateFuncEnableAnchor", "switchFlag", "updateFuncEnableVisitor", "contactFlag", "updateJoinLiveCommentState", "enableComment", "(Ljava/lang/Integer;)V", "updateLiveMsgCommentState", "updateLocalAnchorStatus", "updateLocalLotteryInfo", "updateLocalSwitchFlag", "updateLotteryInfo", "lotteryInfo", "updateLotteryInfoList", "lotteryInfoList", "updateOnlineMemberCommentState", "validVideoSize", "Companion", "plugin-finder_release"})
public final class g
{
  public static final a uFg;
  public final String TAG;
  public String dPI;
  public String desc;
  public int friendFollowCount;
  public long hFK;
  public byte[] hIt;
  public cjb hIv;
  public f hIy;
  public String hwd;
  public String hwg;
  public awe liveInfo;
  public String sessionBuffer;
  public long sessionId;
  public int sourceType;
  private boolean uBc;
  public int uDA;
  public boolean uDB;
  public boolean uDC;
  public boolean uDD;
  public b uDE;
  public ArrayList<b> uDF;
  public ArrayList<String> uDG;
  private ArrayList<com.tencent.mm.plugin.finder.api.g> uDH;
  private ArrayList<com.tencent.mm.plugin.finder.api.g> uDI;
  public String uDJ;
  public int uDK;
  private int uDL;
  private byte[] uDM;
  public volatile boolean uDN;
  public h uDO;
  public int uDP;
  public boolean uDQ;
  public boolean uDR;
  public boolean uDS;
  public boolean uDT;
  public int uDU;
  public int uDV;
  public long uDW;
  public HashMap<String, Boolean> uDX;
  public awr uDY;
  public LinkedList<i> uDZ;
  public FinderObjectDesc uDm;
  public ArrayList<avn> uDn;
  public avn uDo;
  public ArrayList<avn> uDp;
  public int uDq;
  public int uDr;
  public List<com.tencent.mm.plugin.finder.live.model.t> uDs;
  public List<awq> uDt;
  public List<awq> uDu;
  public List<aut> uDv;
  public com.tencent.mm.plugin.finder.live.util.n uDw;
  public avi uDx;
  public aug uDy;
  public FinderObject uDz;
  public ArrayList<e> uEA;
  public e uEB;
  public int uEC;
  private int uED;
  public int uEE;
  private boolean uEF;
  public boolean uEG;
  public boolean uEH;
  public int uEI;
  public boolean uEJ;
  public boolean uEK;
  public boolean uEL;
  public long uEM;
  public boolean uEN;
  public int uEO;
  public int uEP;
  public boolean uEQ;
  public long uER;
  public Boolean uES;
  public boolean uET;
  public boolean uEU;
  public boolean uEV;
  public boolean uEW;
  public com.tencent.mm.b.h<Long, com.tencent.mm.plugin.finder.live.model.t> uEX;
  public List<byte[]> uEY;
  public List<byte[]> uEZ;
  public i uEa;
  private ConcurrentLinkedDeque<o<Long, String>> uEb;
  public avy uEc;
  public boolean uEd;
  public boolean uEe;
  public int uEf;
  public int uEg;
  public Bundle uEh;
  public HashMap<Integer, Object> uEi;
  public boolean uEj;
  public boolean uEk;
  public awc uEl;
  public axg uEm;
  public ArrayList<Long> uEn;
  public boolean uEo;
  public boolean uEp;
  public String uEq;
  public boolean uEr;
  public String uEs;
  public int uEt;
  public String uEu;
  public boolean uEv;
  public com.tencent.mm.b.h<String, Long> uEw;
  public long uEx;
  public String uEy;
  public ArrayList<e> uEz;
  public int uFa;
  public boolean uFb;
  public String uFc;
  public boolean uFd;
  private final int uFe;
  private final int uFf;
  public boolean uit;
  public LinkedList<axk> uiw;
  public axk uix;
  public int videoHeight;
  public int videoWidth;
  
  static
  {
    AppMethodBeat.i(248005);
    uFg = new a((byte)0);
    AppMethodBeat.o(248005);
  }
  
  public g()
  {
    AppMethodBeat.i(248004);
    this.TAG = ("FinderLiveRoomData@" + hashCode());
    this.hIv = new cjb();
    this.liveInfo = new awe();
    this.uDn = new ArrayList();
    this.uDp = new ArrayList();
    this.uDs = Collections.synchronizedList((List)new ArrayList());
    this.uDt = Collections.synchronizedList((List)new ArrayList());
    this.uDu = Collections.synchronizedList((List)new ArrayList());
    this.uDv = Collections.synchronizedList((List)new ArrayList());
    this.uDw = new com.tencent.mm.plugin.finder.live.util.n();
    this.hwd = "";
    this.uDB = true;
    this.uDC = true;
    this.uDD = true;
    this.uDF = new ArrayList();
    this.uDG = new ArrayList();
    this.uDH = new ArrayList();
    this.uDI = new ArrayList();
    this.uDJ = "";
    this.hwg = "";
    this.sessionBuffer = "";
    this.uDS = true;
    this.uDU = -1;
    this.uDX = new HashMap();
    this.uDZ = new LinkedList();
    this.uEb = new ConcurrentLinkedDeque();
    this.uEi = new HashMap();
    this.uEn = new ArrayList();
    this.uEq = "";
    for (;;)
    {
      try
      {
        localObject = this.uDz;
        if (localObject == null) {
          continue;
        }
        localObject = ((FinderObject)localObject).objectDesc;
        if (localObject == null) {
          continue;
        }
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject == null) {
          continue;
        }
        if (((LinkedList)localObject).isEmpty()) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        StringBuilder localStringBuilder;
        y localy;
        Log.i(this.TAG, "getLiveCoverUrl exception:" + localException.getMessage());
        String str = "";
        continue;
        boolean bool = false;
        continue;
        continue;
        if (i == 0) {
          continue;
        }
        continue;
      }
      if (localObject != null)
      {
        localObject = (FinderMedia)((LinkedList)localObject).getFirst();
        if (localObject != null)
        {
          localObject = ((FinderMedia)localObject).coverUrl;
          if (localObject != null) {
            continue;
          }
        }
      }
      localObject = "";
      this.uEu = ((String)localObject);
      this.uEw = new com.tencent.mm.b.h(100);
      this.uEy = "";
      this.uEz = new ArrayList();
      this.uEA = new ArrayList();
      this.uEE = -1;
      this.uEH = true;
      this.uEI = -1;
      this.uEL = true;
      this.uEO = -1;
      this.uEP = -1;
      this.uEQ = true;
      this.uEV = true;
      this.uEW = true;
      this.dPI = "";
      this.uEX = new com.tencent.mm.b.h(20);
      localObject = c.vCb;
      if (((Number)c.dvq().value()).intValue() != 1) {
        continue;
      }
      bool = true;
      this.uFd = bool;
      localObject = this.TAG;
      localStringBuilder = new StringBuilder("FinderLiveRoomData init ");
      localy = y.vXH;
      Log.i((String)localObject, y.dCN());
      localObject = c.vCb;
      this.uFe = ((Number)c.dvr().value()).intValue();
      this.uFf = (this.uFe / 2);
      AppMethodBeat.o(248004);
      return;
      i = 0;
      continue;
      localObject = null;
    }
  }
  
  public static void EP(long paramLong)
  {
    AppMethodBeat.i(247975);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Okl, Long.valueOf(paramLong));
    AppMethodBeat.o(247975);
  }
  
  public static void EQ(long paramLong)
  {
    AppMethodBeat.i(247976);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Okm, Long.valueOf(paramLong));
    AppMethodBeat.o(247976);
  }
  
  private void a(awc paramawc)
  {
    AppMethodBeat.i(247964);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("FinderLiveGetShopWindowProductResponse:");
    if (paramawc == null) {}
    for (Object localObject = "";; localObject = paramawc)
    {
      Log.i(str, com.tencent.mm.ac.g.bN(localObject));
      this.uEl = paramawc;
      AppMethodBeat.o(247964);
      return;
    }
  }
  
  public static i b(awi paramawi, boolean paramBoolean)
  {
    AppMethodBeat.i(247989);
    p.h(paramawi, "finderLiveLotteryInfo");
    paramawi = new i(paramawi.uhE, paramawi.LHb, paramawi, paramBoolean, 96);
    AppMethodBeat.o(247989);
    return paramawi;
  }
  
  private void djb()
  {
    AppMethodBeat.i(247967);
    Log.i(this.TAG, "set enableGift:false");
    this.uBc = false;
    AppMethodBeat.o(247967);
  }
  
  private void djf()
  {
    AppMethodBeat.i(247984);
    d.h((a)new i(this));
    AppMethodBeat.o(247984);
  }
  
  private ConcurrentLinkedDeque<o<Long, String>> dji()
  {
    AppMethodBeat.i(247995);
    Object localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Okn, "");
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(247995);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = (String)localObject1;
    localObject1 = new ConcurrentLinkedDeque();
    Object localObject3 = (CharSequence)localObject2;
    if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.TAG, "getLotteryIdList lotteryList is empty!");
      AppMethodBeat.o(247995);
      return localObject1;
    }
    localObject2 = kotlin.n.n.b((CharSequence)localObject2, new String[] { "|" });
    int k = ((List)localObject2).size();
    i = 0;
    if (i < k)
    {
      localObject3 = (String)((List)localObject2).get(i);
      Object localObject4 = kotlin.n.n.b((CharSequence)localObject3, new String[] { ":" });
      if (((List)localObject4).size() != 2)
      {
        localObject4 = y.vXH;
        if (y.dCM()) {
          Log.i(this.TAG, "getLotteryIdList invalid lotteryInfo:".concat(String.valueOf(localObject3)));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        long l = Util.safeParseLong((String)((List)localObject4).get(0));
        localObject4 = (String)((List)localObject4).get(1);
        if (l != 0L)
        {
          CharSequence localCharSequence = (CharSequence)localObject4;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label340;
          }
        }
        label340:
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label345;
          }
          localObject4 = y.vXH;
          if (!y.dCM()) {
            break;
          }
          Log.i(this.TAG, "getLotteryIdList invalid liveId lotteryInfo:".concat(String.valueOf(localObject3)));
          break;
        }
        label345:
        ((ConcurrentLinkedDeque)localObject1).add(new o(Long.valueOf(l), localObject4));
      }
    }
    Log.i(this.TAG, "getLotteryIdList lotteryList:".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(247995);
    return localObject1;
  }
  
  private boolean djo()
  {
    AppMethodBeat.i(248001);
    boolean bool = djp();
    Log.i(this.TAG, "isLandscapeVideo validVideoSize:".concat(String.valueOf(bool)));
    if ((bool) && (this.videoWidth >= this.videoHeight))
    {
      AppMethodBeat.o(248001);
      return true;
    }
    AppMethodBeat.o(248001);
    return false;
  }
  
  public final void EN(long paramLong)
  {
    AppMethodBeat.i(247969);
    Log.i(this.TAG, "set curBalance:".concat(String.valueOf(paramLong)));
    this.uEM = paramLong;
    AppMethodBeat.o(247969);
  }
  
  public final void EO(long paramLong)
  {
    AppMethodBeat.i(247974);
    this.uEG = d.cW((int)paramLong, 4);
    com.tencent.mm.plugin.finder.utils.m localm = com.tencent.mm.plugin.finder.utils.m.vVH;
    this.uEJ = com.tencent.mm.plugin.finder.utils.m.Gd(paramLong);
    AppMethodBeat.o(247974);
  }
  
  public final void a(avi paramavi)
  {
    AppMethodBeat.i(247959);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("set badgeInfo:");
    if (paramavi == null) {}
    for (Object localObject = "";; localObject = paramavi)
    {
      Log.i(str, com.tencent.mm.ac.g.bN(localObject));
      this.uDx = paramavi;
      AppMethodBeat.o(247959);
      return;
    }
  }
  
  public final void a(final awi paramawi)
  {
    AppMethodBeat.i(247986);
    d.h((a)new l(this, paramawi));
    AppMethodBeat.o(247986);
  }
  
  public final void a(cjb paramcjb)
  {
    AppMethodBeat.i(247957);
    p.h(paramcjb, "<set-?>");
    this.hIv = paramcjb;
    AppMethodBeat.o(247957);
  }
  
  public final boolean a(awi paramawi1, awi paramawi2)
  {
    AppMethodBeat.i(247985);
    p.h(paramawi1, "remoteLotteryInfo");
    p.h(paramawi2, "localLotteryInfo");
    if ((p.j(paramawi1.id, paramawi2.id) ^ true))
    {
      Log.i(this.TAG, "isRemoteItemValid invalid id:" + paramawi1.id + ',' + paramawi2.id);
      AppMethodBeat.o(247985);
      return false;
    }
    if (!this.uFd)
    {
      AppMethodBeat.o(247985);
      return true;
    }
    int i = paramawi2.uhE;
    int j = paramawi1.uhE;
    int k = paramawi2.LHb;
    int m = paramawi1.LHb;
    if (m >= k)
    {
      if (k < m)
      {
        Log.i(this.TAG, "printLotteryInfoList RemoteItem:" + com.tencent.mm.ac.g.bN(Integer.valueOf(j)) + " invalid");
        AppMethodBeat.o(247985);
        return false;
      }
      if (((j == 1) && (i != 1)) || ((j == 2) && (i == 3)))
      {
        Log.i(this.TAG, "printLotteryInfoList RemoteItem:" + com.tencent.mm.ac.g.bN(Integer.valueOf(j)) + " invalid");
        AppMethodBeat.o(247985);
        return false;
      }
    }
    AppMethodBeat.o(247985);
    return true;
  }
  
  public final void aq(LinkedList<awq> paramLinkedList)
  {
    AppMethodBeat.i(247979);
    p.h(paramLinkedList, "msgList");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    while (paramLinkedList.hasNext())
    {
      awq localawq = (awq)paramLinkedList.next();
      int j = localawq.type;
      o.c localc = o.c.hGH;
      if (j == o.c.aFs())
      {
        i = localawq.type;
        this.uDC = true;
      }
      else
      {
        localc = o.c.hGH;
        if (j != o.c.aFr()) {
          break label145;
        }
        i = localawq.type;
        this.uDC = false;
      }
    }
    label145:
    for (;;)
    {
      break;
      paramLinkedList = o.c.hGH;
      if (i == o.c.aFr())
      {
        paramLinkedList = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.dpo();
      }
      Log.i(this.TAG, "updateLiveMsg commentType:".concat(String.valueOf(i)));
      AppMethodBeat.o(247979);
      return;
    }
  }
  
  public final void atS(String paramString)
  {
    AppMethodBeat.i(247961);
    p.h(paramString, "<set-?>");
    this.hwg = paramString;
    AppMethodBeat.o(247961);
  }
  
  public final void atT(String paramString)
  {
    AppMethodBeat.i(247960);
    p.h(paramString, "<set-?>");
    this.hwd = paramString;
    AppMethodBeat.o(247960);
  }
  
  public final void atU(String paramString)
  {
    AppMethodBeat.i(247966);
    p.h(paramString, "<set-?>");
    this.uEq = paramString;
    AppMethodBeat.o(247966);
  }
  
  public final void atV(String paramString)
  {
    AppMethodBeat.i(247970);
    p.h(paramString, "<set-?>");
    this.dPI = paramString;
    AppMethodBeat.o(247970);
  }
  
  public final b atW(String paramString)
  {
    AppMethodBeat.i(247978);
    p.h(paramString, "finderUsername");
    Object localObject2 = ((Iterable)this.uDF).iterator();
    Object localObject1;
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!Util.isEqual(((b)localObject1).finderUsername, paramString));
    for (paramString = (String)localObject1;; paramString = null)
    {
      paramString = (b)paramString;
      if (paramString == null) {
        break label136;
      }
      localObject1 = (Collection)this.uDG;
      localObject2 = paramString.uCo;
      if (localObject1 != null) {
        break;
      }
      paramString = new kotlin.t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
      AppMethodBeat.o(247978);
      throw paramString;
    }
    af.eV(localObject1).remove(localObject2);
    this.uDF.remove(paramString);
    AppMethodBeat.o(247978);
    return paramString;
    label136:
    AppMethodBeat.o(247978);
    return null;
  }
  
  public final boolean atX(String paramString)
  {
    AppMethodBeat.i(247993);
    p.h(paramString, "lotteryId");
    if (this.uEb.isEmpty()) {
      this.uEb = dji();
    }
    Iterator localIterator = this.uEb.iterator();
    p.g(localIterator, "localSaveLotteryIdList.iterator()");
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if ((((Number)localo.first).longValue() == this.liveInfo.liveId) && (p.j((String)localo.second, paramString)))
      {
        AppMethodBeat.o(247993);
        return true;
      }
    }
    AppMethodBeat.o(247993);
    return false;
  }
  
  public final void atY(String paramString)
  {
    AppMethodBeat.i(247994);
    Object localObject1;
    Object localObject2;
    if (paramString != null)
    {
      if (this.uEb.isEmpty()) {
        this.uEb = dji();
      }
      localObject1 = this.uEb.iterator();
      p.g(localObject1, "localSaveLotteryIdList.iterator()");
      while (((Iterator)localObject1).hasNext()) {
        if (((Number)((o)((Iterator)localObject1).next()).first).longValue() == this.liveInfo.liveId) {
          ((Iterator)localObject1).remove();
        }
      }
      if (this.uEb.size() > this.uFe)
      {
        int j = this.uFf;
        i = 0;
        while (i < j)
        {
          this.uEb.removeLast();
          i += 1;
        }
      }
      localObject1 = new o(Long.valueOf(this.liveInfo.liveId), paramString);
      this.uEb.add(localObject1);
      localObject2 = this.uEb;
      localObject1 = new StringBuilder();
      localObject2 = ((ConcurrentLinkedDeque)localObject2).iterator();
      p.g(localObject2, "lotteryList.iterator()");
      while (((Iterator)localObject2).hasNext())
      {
        o localo = (o)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(((Number)localo.first).longValue() + ':' + (String)localo.second).append("|");
      }
      if (((CharSequence)localObject1).length() != 0) {
        break label440;
      }
    }
    label440:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      p.g(localObject1, "result.toString()");
      localObject2 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject2).azQ().set(ar.a.Okn, localObject1);
      Log.i(this.TAG, "saveLastWinLotteryId MAX_LOTTERY_ID_LIST:" + this.uFe + ",DROP_LIST_SIZE:" + this.uFf + ",liveId:" + this.liveInfo.liveId + ",lotteryId:" + paramString + ",lotteryList:" + this.uEb + ",cacheListStr:" + (String)localObject1);
      AppMethodBeat.o(247994);
      return;
    }
  }
  
  public final void b(awc paramawc)
  {
    AppMethodBeat.i(247981);
    if (paramawc != null)
    {
      if (this.uEl == null)
      {
        a(paramawc);
        AppMethodBeat.o(247981);
        return;
      }
      awc localawc = this.uEl;
      if (localawc != null)
      {
        localawc.continueFlag = paramawc.continueFlag;
        localawc.tVM = paramawc.tVM;
        localawc.LGC = paramawc.LGC;
        localawc.LGA = paramawc.LGA;
        localawc.LGz = paramawc.LGz;
        localawc.LGD = paramawc.LGD;
        localawc.LGB = paramawc.LGB;
        localawc.ukr = paramawc.ukr;
        localawc.vtD = paramawc.vtD;
        localawc.LGH = paramawc.LGH;
        localawc.LGI = paramawc.LGI;
        LinkedList localLinkedList = new LinkedList();
        paramawc = paramawc.LGy;
        p.g(paramawc, "resp.productList");
        paramawc = ((Iterable)paramawc).iterator();
        label278:
        label288:
        while (paramawc.hasNext())
        {
          axg localaxg = (axg)paramawc.next();
          Object localObject = localawc.LGy;
          p.g(localObject, "it.productList");
          localObject = ((List)localObject).iterator();
          int i = 0;
          label219:
          int j;
          if (((Iterator)localObject).hasNext()) {
            if (((axg)((Iterator)localObject).next()).uko == localaxg.uko)
            {
              j = 1;
              label253:
              if (j == 0) {
                break label278;
              }
            }
          }
          for (;;)
          {
            if (i != -1) {
              break label288;
            }
            localLinkedList.add(localaxg);
            break;
            j = 0;
            break label253;
            i += 1;
            break label219;
            i = -1;
          }
        }
        localawc.LGy.addAll((Collection)localLinkedList);
        localawc.gAZ = localawc.LGy.size();
        AppMethodBeat.o(247981);
        return;
      }
    }
    AppMethodBeat.o(247981);
  }
  
  public final void b(axg paramaxg)
  {
    AppMethodBeat.i(247965);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("FinderLiveShopWindowProductItem:");
    if (paramaxg == null) {}
    for (Object localObject = "";; localObject = paramaxg)
    {
      Log.i(str, com.tencent.mm.ac.g.bN(localObject));
      boolean bool2 = this.uEk;
      if ((paramaxg != null) && (paramaxg.LHK == 1)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.uEk = (bool1 | bool2);
        this.uEm = paramaxg;
        AppMethodBeat.o(247965);
        return;
      }
    }
  }
  
  public final void b(final LinkedList<awi> paramLinkedList, final boolean paramBoolean)
  {
    AppMethodBeat.i(247987);
    p.h(paramLinkedList, "liveMsgLotteryInfoList");
    d.h((a)new g(this, paramLinkedList, paramBoolean));
    AppMethodBeat.o(247987);
  }
  
  public final void bj(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(247991);
    d.h((a)new e(this, paramBoolean, paramString));
    AppMethodBeat.o(247991);
  }
  
  public final void bk(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(247996);
    p.h(paramString, "prefix");
    paramString = new StringBuilder("printLotteryInfoList(" + paramString + ",fromJoinLive:" + paramBoolean + ")：");
    Object localObject1 = (Iterable)this.uDZ;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.hxH();
      }
      localObject2 = (i)localObject2;
      paramString.append("index:" + i + ',' + localObject2 + "};");
      i += 1;
    }
    Log.i(this.TAG, paramString.toString());
    AppMethodBeat.o(247996);
  }
  
  public final void c(avy paramavy)
  {
    AppMethodBeat.i(247963);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("lotteryRecord:");
    avy localavy = this.uEc;
    Object localObject = localavy;
    if (localavy == null) {
      localObject = "";
    }
    Log.i(str, com.tencent.mm.ac.g.bN(localObject));
    this.uEc = paramavy;
    AppMethodBeat.o(247963);
  }
  
  public final void d(final avy paramavy)
  {
    AppMethodBeat.i(247980);
    d.h((a)new d(this, paramavy));
    AppMethodBeat.o(247980);
  }
  
  public final boolean diZ()
  {
    return this.uEE == 1;
  }
  
  public final boolean dja()
  {
    return this.uEI == 1;
  }
  
  public final int djc()
  {
    AppMethodBeat.i(247977);
    Object localObject = this.hIy;
    if (localObject != null)
    {
      localObject = ((f)localObject).hwP;
      if (localObject != null)
      {
        i = ((com.tencent.mm.live.core.core.b.e)localObject).hzl;
        AppMethodBeat.o(247977);
        return i;
      }
    }
    localObject = e.a.hxc;
    int i = e.a.aCf();
    AppMethodBeat.o(247977);
    return i;
  }
  
  public final void djd()
  {
    AppMethodBeat.i(247982);
    Object localObject = this.uEl;
    if (localObject != null)
    {
      localObject = ((awc)localObject).LGy;
      if (localObject != null)
      {
        ((LinkedList)localObject).clear();
        AppMethodBeat.o(247982);
        return;
      }
    }
    AppMethodBeat.o(247982);
  }
  
  public final void dje()
  {
    AppMethodBeat.i(247983);
    d.h((a)new h(this));
    AppMethodBeat.o(247983);
  }
  
  public final void djg()
  {
    AppMethodBeat.i(247990);
    d.h((a)new c(this));
    AppMethodBeat.o(247990);
  }
  
  public final boolean djh()
  {
    AppMethodBeat.i(247992);
    Object localObject = this.uEa;
    if (localObject != null)
    {
      localObject = ((i)localObject).tWe;
      if (localObject == null) {}
    }
    for (int i = ((awi)localObject).extFlag;; i = 0)
    {
      boolean bool = d.cW(i, 1);
      Log.i(this.TAG, "haveParticipated :".concat(String.valueOf(bool)));
      AppMethodBeat.o(247992);
      return bool;
    }
  }
  
  public final String djj()
  {
    Object localObject2 = null;
    AppMethodBeat.i(247998);
    StringBuilder localStringBuilder = new StringBuilder("appId:");
    Object localObject1 = this.hIy;
    if (localObject1 != null)
    {
      localObject1 = ((f)localObject1).hzu;
      if (localObject1 == null) {}
    }
    for (localObject1 = Integer.valueOf(((TRTCCloudDef.TRTCParams)localObject1).sdkAppId);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append("\nroomId:");
      Object localObject3 = this.hIy;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((f)localObject3).hzu;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = Integer.valueOf(((TRTCCloudDef.TRTCParams)localObject3).roomId);
        }
      }
      localObject1 = localObject1 + '\n';
      AppMethodBeat.o(247998);
      return localObject1;
    }
  }
  
  public final boolean djk()
  {
    boolean bool1 = true;
    AppMethodBeat.i(247999);
    com.tencent.mm.plugin.finder.utils.m localm = com.tencent.mm.plugin.finder.utils.m.vVH;
    boolean bool2 = com.tencent.mm.plugin.finder.utils.m.dBP();
    if (this.uEg == 1) {}
    for (;;)
    {
      AppMethodBeat.o(247999);
      return bool1 & bool2;
      bool1 = false;
    }
  }
  
  public final boolean djl()
  {
    return this.uEg == 4;
  }
  
  public final boolean djm()
  {
    return this.uEt == 1;
  }
  
  public final boolean djn()
  {
    AppMethodBeat.i(248000);
    c localc = c.vCb;
    boolean bool1 = c.dvk();
    boolean bool2 = djo();
    Log.i(this.TAG, "fitLandscapeVideo config:" + bool1 + ",isLandscapeVideo:" + bool2);
    AppMethodBeat.o(248000);
    return bool1 & bool2;
  }
  
  public final boolean djp()
  {
    AppMethodBeat.i(248002);
    Log.i(this.TAG, "validVideoSize videoWidth:" + this.videoWidth + ",videoHeight:" + this.videoHeight);
    if ((this.videoWidth > 0) && (this.videoHeight > 0))
    {
      AppMethodBeat.o(248002);
      return true;
    }
    AppMethodBeat.o(248002);
    return false;
  }
  
  public final String djq()
  {
    Object localObject = this.hIy;
    if (localObject != null)
    {
      localObject = ((f)localObject).hzu;
      if (localObject != null) {
        return ((TRTCCloudDef.TRTCParams)localObject).userId;
      }
    }
    return null;
  }
  
  public final boolean djr()
  {
    return (this.uEC == 1) || (this.uEC == 2);
  }
  
  public final boolean djs()
  {
    return (this.uEC == 3) || (this.uEC == 4);
  }
  
  public final String info()
  {
    AppMethodBeat.i(247972);
    String str = "liveId:" + this.liveInfo.liveId + ",objectId:" + this.hFK + ", " + d.zs(this.hFK) + ",uiState:" + this.uEf + ",liveState:" + this.uEg + ",bindShop:" + this.uit + ",shoppingAvailable:" + this.uEk + ",qosReport:" + this.uET + ",qosContrl:" + this.uEU;
    AppMethodBeat.o(247972);
    return str;
  }
  
  public final boolean isLiveStarted()
  {
    return (this.uEg == 3) || (this.uEg == 2);
  }
  
  public final void nB(boolean paramBoolean)
  {
    AppMethodBeat.i(247962);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("liveFinish:").append(this.uDN).append(",value:").append(paramBoolean).append(",liveId:");
    Object localObject = this.liveInfo;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((awe)localObject).liveId);; localObject = null)
    {
      Log.i(str, ((Long)localObject).longValue());
      this.uDN = paramBoolean;
      AppMethodBeat.o(247962);
      return;
    }
  }
  
  public final void nC(boolean paramBoolean)
  {
    AppMethodBeat.i(247968);
    Log.i(this.TAG, "set enableVisitorGiftSwitch:".concat(String.valueOf(paramBoolean)));
    this.uEK = paramBoolean;
    AppMethodBeat.o(247968);
  }
  
  public final void nD(boolean paramBoolean)
  {
    AppMethodBeat.i(247971);
    Log.i(this.TAG, "set isBussinessVisitor:" + paramBoolean + ",ori value:" + this.uFb);
    this.uFb = paramBoolean;
    AppMethodBeat.o(247971);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(247973);
    Log.i(this.TAG, "reset");
    this.hFK = 0L;
    setLiveInfo(new awe());
    this.hIv = new cjb();
    this.hIt = null;
    this.hIy = null;
    this.uDm = null;
    this.uDn.clear();
    this.uDo = null;
    this.uDp.clear();
    this.uDq = 0;
    this.uDr = 0;
    a(null);
    this.uDs.clear();
    this.uDt.clear();
    this.uDw.clear();
    this.uDu.clear();
    this.uDy = null;
    this.uDE = null;
    this.uDF.clear();
    this.uDG.clear();
    this.uDz = null;
    this.hwg = "";
    this.sessionBuffer = "";
    this.hwd = "";
    this.uDA = 0;
    this.uDB = true;
    this.uDC = true;
    this.uDD = true;
    this.uDL = 0;
    this.uDM = null;
    this.uDK = 0;
    nB(false);
    this.uDO = null;
    this.uDH.clear();
    this.uDI.clear();
    this.uDJ = "";
    this.uDP = 0;
    this.uDQ = false;
    this.uDR = false;
    this.uDS = true;
    this.uDT = false;
    this.uDU = -1;
    this.uDV = 0;
    this.friendFollowCount = 0;
    this.desc = null;
    this.uDX.clear();
    dje();
    djf();
    djg();
    this.uEb = new ConcurrentLinkedDeque();
    this.uEe = false;
    c(null);
    this.uEd = false;
    this.uEf = 0;
    this.uEg = 0;
    this.uEh = null;
    this.uEi = new HashMap();
    this.uit = false;
    this.uEj = false;
    this.uEk = false;
    a(null);
    b(null);
    this.uEn.clear();
    this.uEo = false;
    this.uEp = false;
    this.uEq = "";
    this.sessionId = 0L;
    this.uEs = null;
    this.uEt = 0;
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.uDW = 0L;
    this.uEu = "";
    this.uEv = false;
    this.uEz.clear();
    this.uEA.clear();
    this.uEB = null;
    this.uEC = 0;
    this.uED = 0;
    this.uEE = -1;
    this.uEF = false;
    this.uEG = false;
    this.uEH = true;
    this.uEy = "";
    this.uEx = 0L;
    this.uEI = -1;
    djb();
    this.uEJ = false;
    nC(false);
    this.uEL = true;
    EN(0L);
    this.uEN = false;
    this.uEQ = true;
    this.uER = 0L;
    this.uES = null;
    this.uET = false;
    this.uEU = false;
    this.dPI = "";
    this.uEV = true;
    this.uEW = true;
    this.uiw = null;
    this.uix = null;
    this.uEY = null;
    this.uFa = 0;
    this.uEZ = null;
    nD(false);
    this.uFd = false;
    this.uFc = null;
    this.uEX.clear();
    this.uEw.clear();
    AppMethodBeat.o(247973);
  }
  
  public final void setLiveInfo(awe paramawe)
  {
    AppMethodBeat.i(247958);
    p.h(paramawe, "value");
    Log.i(this.TAG, "write liveInfo to:[liveId:" + paramawe.liveId + ", liveStatus:" + paramawe.liveStatus + ']');
    this.liveInfo = paramawe;
    AppMethodBeat.o(247958);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248003);
    String str = info();
    AppMethodBeat.o(248003);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData$Companion;", "", "()V", "LIVE_STATE_DEFAULT", "", "LIVE_STATE_FINISHED", "LIVE_STATE_PREPARE", "LIVE_STATE_STARTED", "LIVE_STATE_STARTED_WAIT", "SUPPORT_SCREEN_ROTATION", "UI_STATE_ANCHOR_EXIT", "UI_STATE_ANCHOR_POST", "UI_STATE_CAMERA_OPT", "UI_STATE_COMMENT", "UI_STATE_DEFAULT", "UI_STATE_DISCONNECTION", "UI_STATE_DISPLAY_LINK_APPLY_LISENCE", "UI_STATE_DISPLAY_LINK_APPLY_LIST", "UI_STATE_EXPLAIN_WECOIN_HOT", "UI_STATE_GIFT", "UI_STATE_KICKED", "UI_STATE_MEMBER_LIST", "UI_STATE_MINI_WINDOW_PERMISSION", "UI_STATE_MORE_ACTION", "UI_STATE_NORMAL", "UI_STATE_POST_LANDSCAPE_ACTION", "UI_STATE_POST_PORTRAIT_ACTION", "UI_STATE_PRIVATE_PERMISSION", "UI_STATE_REAL_NAME_COMMENT", "UI_STATE_RECONNECTING", "UI_STATE_SHOPPING_PANEL", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements a<x>
  {
    public b(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(g paramg, avy paramavy)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(g paramg, boolean paramBoolean, String paramString)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "item", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<i, Boolean>
    {
      a(g.e parame)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class f
    extends q
    implements a<x>
  {
    public f(g paramg, i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(g paramg, LinkedList paramLinkedList, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<x>
  {
    i(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class j
    extends q
    implements a<x>
  {
    public j(g paramg, awr paramawr)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class k
    extends q
    implements a<x>
  {
    public k(g paramg, i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements a<x>
  {
    l(g paramg, awi paramawi)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.g
 * JD-Core Version:    0.7.0.1
 */