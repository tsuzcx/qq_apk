package com.tencent.mm.plugin.finder.live.model.mic;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/mic/ILinkMicTimeoutTimer;", "", "onAcceptBattleTimeout", "", "onAcceptMicPkTimeout", "onAcceptMicTimeout", "micId", "", "onApplyBattleTimeout", "onApplyMicPkTimeout", "onApplyMicTimeout", "plugin-finder_release"})
public abstract interface a
{
  public abstract void onAcceptBattleTimeout();
  
  public abstract void onAcceptMicPkTimeout();
  
  public abstract void onAcceptMicTimeout(String paramString);
  
  public abstract void onApplyBattleTimeout();
  
  public abstract void onApplyMicPkTimeout();
  
  public abstract void onApplyMicTimeout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.mic.a
 * JD-Core Version:    0.7.0.1
 */