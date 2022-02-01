package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  private final int aZj;
  int aZk;
  int aZl;
  private final byte[] data;
  
  public i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92167);
    this.data = paramArrayOfByte;
    this.aZj = paramArrayOfByte.length;
    AppMethodBeat.o(92167);
  }
  
  private void sE()
  {
    AppMethodBeat.i(92171);
    if ((this.aZk >= 0) && ((this.aZk < this.aZj) || ((this.aZk == this.aZj) && (this.aZl == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(92171);
      return;
    }
  }
  
  public final int eA(int paramInt)
  {
    AppMethodBeat.i(92169);
    int k = this.aZk;
    int j = Math.min(paramInt, 8 - this.aZl);
    byte[] arrayOfByte = this.data;
    int i = k + 1;
    k = (arrayOfByte[k] & 0xFF) >> this.aZl & 255 >> 8 - j;
    while (j < paramInt)
    {
      k |= (this.data[i] & 0xFF) << j;
      j += 8;
      i += 1;
    }
    eB(paramInt);
    AppMethodBeat.o(92169);
    return k & -1 >>> 32 - paramInt;
  }
  
  public final void eB(int paramInt)
  {
    AppMethodBeat.i(92170);
    int i = paramInt / 8;
    this.aZk += i;
    this.aZl = (paramInt - i * 8 + this.aZl);
    if (this.aZl > 7)
    {
      this.aZk += 1;
      this.aZl -= 8;
    }
    sE();
    AppMethodBeat.o(92170);
  }
  
  public final boolean sD()
  {
    AppMethodBeat.i(92168);
    if (((this.data[this.aZk] & 0xFF) >> this.aZl & 0x1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      eB(1);
      AppMethodBeat.o(92168);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.i
 * JD-Core Version:    0.7.0.1
 */