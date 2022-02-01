package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class g$f
{
  int[] pBz;
  
  private g$f()
  {
    AppMethodBeat.i(229151);
    this.pBz = new int[] { 1, 1, 1, 1 };
    AppMethodBeat.o(229151);
  }
  
  static int u(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = -268435456;; i = 0) {
      return i | paramInt;
    }
  }
  
  final boolean a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 268435455;
      int k = this.pBz.length - paramArrayOfInt.length;
      j = k;
      paramBoolean = true;
      label23:
      if (j >= this.pBz.length) {
        return paramBoolean;
      }
      if ((this.pBz[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
  
  final void t(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(229155);
    int i = u(paramBoolean, paramInt);
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.pBz[3] + ", newState=" + i);
    if (this.pBz[3] == i)
    {
      AppMethodBeat.o(229155);
      return;
    }
    this.pBz[0] = this.pBz[1];
    this.pBz[1] = this.pBz[2];
    this.pBz[2] = this.pBz[3];
    this.pBz[3] = i;
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "new MostRecentState [" + this.pBz[0] + "," + this.pBz[1] + "," + this.pBz[2] + "," + this.pBz[3] + "]");
    AppMethodBeat.o(229155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g.f
 * JD-Core Version:    0.7.0.1
 */