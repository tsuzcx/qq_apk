package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  private final int beF;
  int beG;
  int beH;
  private final byte[] data;
  
  public i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92167);
    this.data = paramArrayOfByte;
    this.beF = paramArrayOfByte.length;
    AppMethodBeat.o(92167);
  }
  
  private void sW()
  {
    AppMethodBeat.i(92171);
    if ((this.beG >= 0) && ((this.beG < this.beF) || ((this.beG == this.beF) && (this.beH == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(92171);
      return;
    }
  }
  
  public final int eo(int paramInt)
  {
    AppMethodBeat.i(92169);
    int k = this.beG;
    int j = Math.min(paramInt, 8 - this.beH);
    byte[] arrayOfByte = this.data;
    int i = k + 1;
    k = (arrayOfByte[k] & 0xFF) >> this.beH & 255 >> 8 - j;
    while (j < paramInt)
    {
      k |= (this.data[i] & 0xFF) << j;
      j += 8;
      i += 1;
    }
    ep(paramInt);
    AppMethodBeat.o(92169);
    return k & -1 >>> 32 - paramInt;
  }
  
  public final void ep(int paramInt)
  {
    AppMethodBeat.i(92170);
    int i = paramInt / 8;
    this.beG += i;
    this.beH = (paramInt - i * 8 + this.beH);
    if (this.beH > 7)
    {
      this.beG += 1;
      this.beH -= 8;
    }
    sW();
    AppMethodBeat.o(92170);
  }
  
  public final boolean sV()
  {
    AppMethodBeat.i(92168);
    if (((this.data[this.beG] & 0xFF) >> this.beH & 0x1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ep(1);
      AppMethodBeat.o(92168);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.i
 * JD-Core Version:    0.7.0.1
 */