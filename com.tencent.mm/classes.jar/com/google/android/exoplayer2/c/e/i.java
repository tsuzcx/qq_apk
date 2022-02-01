package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  private final int bpM;
  int bpN;
  int bpO;
  private final byte[] data;
  
  public i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92167);
    this.data = paramArrayOfByte;
    this.bpM = paramArrayOfByte.length;
    AppMethodBeat.o(92167);
  }
  
  private void uE()
  {
    AppMethodBeat.i(92171);
    if ((this.bpN >= 0) && ((this.bpN < this.bpM) || ((this.bpN == this.bpM) && (this.bpO == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(92171);
      return;
    }
  }
  
  public final int es(int paramInt)
  {
    AppMethodBeat.i(92169);
    int k = this.bpN;
    int j = Math.min(paramInt, 8 - this.bpO);
    byte[] arrayOfByte = this.data;
    int i = k + 1;
    k = (arrayOfByte[k] & 0xFF) >> this.bpO & 255 >> 8 - j;
    while (j < paramInt)
    {
      k |= (this.data[i] & 0xFF) << j;
      j += 8;
      i += 1;
    }
    et(paramInt);
    AppMethodBeat.o(92169);
    return k & -1 >>> 32 - paramInt;
  }
  
  public final void et(int paramInt)
  {
    AppMethodBeat.i(92170);
    int i = paramInt / 8;
    this.bpN += i;
    this.bpO = (paramInt - i * 8 + this.bpO);
    if (this.bpO > 7)
    {
      this.bpN += 1;
      this.bpO -= 8;
    }
    uE();
    AppMethodBeat.o(92170);
  }
  
  public final boolean uD()
  {
    AppMethodBeat.i(92168);
    if (((this.data[this.bpN] & 0xFF) >> this.bpO & 0x1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      et(1);
      AppMethodBeat.o(92168);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.i
 * JD-Core Version:    0.7.0.1
 */