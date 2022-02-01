package com.tencent.mm.live.model;

import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bem;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/ILiveSysMsgNotifier;", "", "onAcceptLiveMic", "", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAnchorCallInterruption", "callInterruption", "", "onAnchorConnectionChange", "connectionAvailable", "onApplyLiveMic", "Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "onBanLiveComment", "Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onCloseApplyLiveMic", "Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "onCloseLive", "Lcom/tencent/mm/live/model/CloseLiveInfo;", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onLiveMicSucc", "Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "onOnlineLiveList", "Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "onRandomMicAccept", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgApplyPkInfo;", "onRandomMicApply", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgNotifyApplyRandomMicInfo;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g
{
  public abstract void onAcceptLiveMic(a parama);
  
  public abstract void onAnchorCallInterruption(boolean paramBoolean);
  
  public abstract void onAnchorConnectionChange(boolean paramBoolean);
  
  public abstract void onApplyLiveMic(b paramb);
  
  public abstract void onBanLiveComment(c paramc);
  
  public abstract void onBattleApply();
  
  public abstract void onBattleClose();
  
  public abstract void onBattleDismiss();
  
  public abstract void onBattleEnd();
  
  public abstract void onBattleStart();
  
  public abstract void onCloseApplyLiveMic(d paramd);
  
  public abstract void onCloseLive(e parame);
  
  public abstract void onCloseLiveMic(f paramf);
  
  public abstract void onLiveMicSucc(n paramn);
  
  public abstract void onOnlineLiveList(s params);
  
  public abstract void onRandomMicAccept(bdm parambdm, bdt parambdt);
  
  public abstract void onRandomMicApply(bem parambem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.model.g
 * JD-Core Version:    0.7.0.1
 */