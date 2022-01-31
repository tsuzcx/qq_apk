package com.tencent.mm.game.liblockstep;

import android.support.annotation.Keep;

@Keep
public abstract interface LockStepNative$ILockStepReportListener
{
  @Keep
  public abstract void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  @Keep
  public abstract void onKvStat(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
 * JD-Core Version:    0.7.0.1
 */