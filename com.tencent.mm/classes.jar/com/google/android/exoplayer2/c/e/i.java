package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  private final int bpH;
  int bpI;
  int bpJ;
  private final byte[] data;
  
  public i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92167);
    this.data = paramArrayOfByte;
    this.bpH = paramArrayOfByte.length;
    AppMethodBeat.o(92167);
  }
  
  private void uJ()
  {
    AppMethodBeat.i(92171);
    if ((this.bpI >= 0) && ((this.bpI < this.bpH) || ((this.bpI == this.bpH) && (this.bpJ == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(92171);
      return;
    }
  }
  
  public final int em(int paramInt)
  {
    AppMethodBeat.i(92169);
    int k = this.bpI;
    int j = Math.min(paramInt, 8 - this.bpJ);
    byte[] arrayOfByte = this.data;
    int i = k + 1;
    k = (arrayOfByte[k] & 0xFF) >> this.bpJ & 255 >> 8 - j;
    while (j < paramInt)
    {
      k |= (this.data[i] & 0xFF) << j;
      j += 8;
      i += 1;
    }
    en(paramInt);
    AppMethodBeat.o(92169);
    return k & -1 >>> 32 - paramInt;
  }
  
  public final void en(int paramInt)
  {
    AppMethodBeat.i(92170);
    int i = paramInt / 8;
    this.bpI += i;
    this.bpJ = (paramInt - i * 8 + this.bpJ);
    if (this.bpJ > 7)
    {
      this.bpI += 1;
      this.bpJ -= 8;
    }
    uJ();
    AppMethodBeat.o(92170);
  }
  
  public final boolean uI()
  {
    AppMethodBeat.i(92168);
    if (((this.data[this.bpI] & 0xFF) >> this.bpJ & 0x1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      en(1);
      AppMethodBeat.o(92168);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.i
 * JD-Core Version:    0.7.0.1
 */