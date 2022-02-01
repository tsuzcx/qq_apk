package com.tencent.mm.live.b;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/ILiveSysMsgNotifier;", "", "onAcceptLiveMic", "", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAnchorCallInterruption", "callInterruption", "", "onAnchorConnectionChange", "connectionAvailable", "onApplyLiveMic", "Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "onBanLiveComment", "Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onCloseApplyLiveMic", "Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "onCloseLive", "Lcom/tencent/mm/live/model/CloseLiveInfo;", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onLiveMicSucc", "Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "onOnlineLiveList", "Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "plugin-logic_release"})
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.g
 * JD-Core Version:    0.7.0.1
 */