package com.tencent.mm.plugin.finder.live.model.mic;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/mic/ILinkMicTimeoutTimer;", "", "onAcceptBattleTimeout", "", "onAcceptMicPkTimeout", "onAcceptMicTimeout", "micId", "", "onApplyBattleTimeout", "onApplyMicPkTimeout", "onApplyMicTimeout", "onRandomMatchTimeout", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract void onAcceptBattleTimeout();
  
  public abstract void onAcceptMicPkTimeout();
  
  public abstract void onAcceptMicTimeout(String paramString);
  
  public abstract void onApplyBattleTimeout();
  
  public abstract void onApplyMicPkTimeout();
  
  public abstract void onApplyMicTimeout();
  
  public abstract void onRandomMatchTimeout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.mic.a
 * JD-Core Version:    0.7.0.1
 */