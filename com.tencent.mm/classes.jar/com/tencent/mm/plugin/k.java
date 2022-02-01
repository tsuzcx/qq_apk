package com.tencent.mm.plugin;

import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.plugin.finder.live.util.s;
import com.tencent.mm.protocal.protobuf.edv;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/IFinderLiveService;", "Lcom/tencent/mm/kernel/service/IService;", "activateMic", "", "delay", "", "checkAcceptMicType", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "micType", "", "checkIsPreciousGift", "", "giftId", "", "createGiftQueue", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "dumpBattlePlayerInfo", "info", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PlayerInfo;", "enterRoom", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "enterCode", "isAnchor", "isAnchorLiveWithoutSndDevice", "linkMicEnterRoomFail", "errCode", "roomId", "liveId", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "notifyAudienceMicUserChange", "notifyRoomPKMicUserChange", "forceUpdate", "refreshMic", "removeBattleEndDelayTimer", "removeBattleStartDelayTimer", "requestStopMic", "requestStopPkMic", "setForbidden", "setupSdkParam", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "startBattleEndDelayTimer", "battleId", "startBattleStartDelayTimer", "startLinkMic", "stopActivateMic", "stopRefreshMic", "updateRemoteLinkMicUserInfo", "sdkUserId", "sdkLiveId", "sessionId", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface k
  extends com.tencent.mm.kernel.c.a
{
  public abstract boolean Sy(String paramString);
  
  public abstract void a(com.tencent.mm.live.model.a parama);
  
  public abstract void a(com.tencent.mm.plugin.finder.live.model.context.a parama, int paramInt);
  
  public abstract boolean a(String paramString1, int paramInt, boolean paramBoolean, String paramString2);
  
  public abstract void b(h paramh, b<? super Integer, ah> paramb);
  
  public abstract boolean bUB();
  
  public abstract boolean bUC();
  
  public abstract void bUD();
  
  public abstract void bUE();
  
  public abstract com.tencent.mm.live.core.core.trtc.a bUF();
  
  public abstract void bUG();
  
  public abstract s bUH();
  
  public abstract void bUI();
  
  public abstract void bUJ();
  
  public abstract void bUK();
  
  public abstract void bUL();
  
  public abstract void bUM();
  
  public abstract void bUN();
  
  public abstract void bUO();
  
  public abstract void bUP();
  
  public abstract void bUQ();
  
  public abstract void i(int paramInt, long paramLong1, long paramLong2);
  
  public abstract void j(long paramLong, String paramString);
  
  public abstract void k(long paramLong, String paramString);
  
  public abstract void v(LinkedList<edv> paramLinkedList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.k
 * JD-Core Version:    0.7.0.1
 */