package com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$e
{
  int[] bIR;
  
  private b$e()
  {
    AppMethodBeat.i(139968);
    this.bIR = new int[] { 1, 1, 1, 1 };
    AppMethodBeat.o(139968);
  }
  
  static int e(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = -268435456;; i = 0) {
      return i | paramInt;
    }
  }
  
  final boolean b(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 268435455;
      int k = this.bIR.length - paramArrayOfInt.length;
      j = k;
      paramBoolean = true;
      label23:
      if (j >= this.bIR.length) {
        return paramBoolean;
      }
      if ((this.bIR[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      paramBoolean &= bool;
      j += 1;
      break label23;
      i = -1;
      break;
    }
    return paramBoolean;
  }
  
  final void d(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(139969);
    int i = e(paramBoolean, paramInt);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.bIR[3] + ", newState=" + i);
    if (this.bIR[3] == i)
    {
      AppMethodBeat.o(139969);
      return;
    }
    this.bIR[0] = this.bIR[1];
    this.bIR[1] = this.bIR[2];
    this.bIR[2] = this.bIR[3];
    this.bIR[3] = i;
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "new MostRecentState [" + this.bIR[0] + "," + this.bIR[1] + "," + this.bIR[2] + "," + this.bIR[3] + "]");
    AppMethodBeat.o(139969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */