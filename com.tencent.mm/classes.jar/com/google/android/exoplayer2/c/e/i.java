package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  private final int cTe;
  int cTf;
  int cTg;
  private final byte[] data;
  
  public i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92167);
    this.data = paramArrayOfByte;
    this.cTe = paramArrayOfByte.length;
    AppMethodBeat.o(92167);
  }
  
  private void Sh()
  {
    AppMethodBeat.i(92171);
    if ((this.cTf >= 0) && ((this.cTf < this.cTe) || ((this.cTf == this.cTe) && (this.cTg == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(92171);
      return;
    }
  }
  
  public final boolean Sg()
  {
    AppMethodBeat.i(92168);
    if (((this.data[this.cTf] & 0xFF) >> this.cTg & 0x1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      hR(1);
      AppMethodBeat.o(92168);
      return bool;
    }
  }
  
  public final int hQ(int paramInt)
  {
    AppMethodBeat.i(92169);
    int k = this.cTf;
    int j = Math.min(paramInt, 8 - this.cTg);
    byte[] arrayOfByte = this.data;
    int i = k + 1;
    k = (arrayOfByte[k] & 0xFF) >> this.cTg & 255 >> 8 - j;
    while (j < paramInt)
    {
      k |= (this.data[i] & 0xFF) << j;
      j += 8;
      i += 1;
    }
    hR(paramInt);
    AppMethodBeat.o(92169);
    return k & -1 >>> 32 - paramInt;
  }
  
  public final void hR(int paramInt)
  {
    AppMethodBeat.i(92170);
    int i = paramInt / 8;
    this.cTf += i;
    this.cTg = (paramInt - i * 8 + this.cTg);
    if (this.cTg > 7)
    {
      this.cTf += 1;
      this.cTg -= 8;
    }
    Sh();
    AppMethodBeat.o(92170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.i
 * JD-Core Version:    0.7.0.1
 */