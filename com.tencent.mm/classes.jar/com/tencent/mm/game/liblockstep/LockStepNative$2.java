package com.tencent.mm.game.liblockstep;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class LockStepNative$2
  implements LockStepNative.ILockStepReportListener
{
  LockStepNative$2(LockStepNative paramLockStepNative, LockStepNative.ILockStepReportListener paramILockStepReportListener) {}
  
  public final void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(152612);
    this.ezG.onIdKeyStat(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    AppMethodBeat.o(152612);
  }
  
  public final void onKvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(152611);
    this.ezG.onKvStat(paramInt, paramString);
    AppMethodBeat.o(152611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.game.liblockstep.LockStepNative.2
 * JD-Core Version:    0.7.0.1
 */