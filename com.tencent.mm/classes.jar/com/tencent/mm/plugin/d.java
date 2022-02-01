package com.tencent.mm.plugin;

import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.plugin.finder.live.util.p;
import com.tencent.mm.protocal.protobuf.dlk;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/IFinderLiveService;", "Lcom/tencent/mm/kernel/service/IService;", "activateMic", "", "delay", "", "checkAcceptMicType", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "micType", "", "checkIsPreciousGift", "", "giftId", "", "createGiftQueue", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "dumpBattlePlayerInfo", "info", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PlayerInfo;", "enterRoom", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "enterCode", "isAnchor", "linkMicEnterRoomFail", "errCode", "roomId", "liveId", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "notifyAudienceMicUserChange", "refreshMic", "removeBattleEndDelayTimer", "requestStopMic", "requestStopPkMic", "setForbidden", "setupSdkParam", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "startBattleEndDelayTimer", "battleId", "startLinkMic", "stopActivateMic", "stopRefreshMic", "plugin-finder-base_release"})
public abstract interface d
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(com.tencent.mm.live.b.a parama);
  
  public abstract void a(com.tencent.mm.plugin.finder.live.model.context.a parama);
  
  public abstract boolean aae(String paramString);
  
  public abstract void b(g paramg, b<? super Integer, x> paramb);
  
  public abstract boolean bvS();
  
  public abstract com.tencent.mm.live.core.core.trtc.a bvT();
  
  public abstract void bvU();
  
  public abstract p bvV();
  
  public abstract void bvW();
  
  public abstract void bvX();
  
  public abstract void bvY();
  
  public abstract void bvZ();
  
  public abstract void bwa();
  
  public abstract void bwb();
  
  public abstract void bwc();
  
  public abstract void bwd();
  
  public abstract void i(int paramInt, long paramLong1, long paramLong2);
  
  public abstract void i(long paramLong, String paramString);
  
  public abstract void notifyAudienceMicUserChange();
  
  public abstract void s(LinkedList<dlk> paramLinkedList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.d
 * JD-Core Version:    0.7.0.1
 */