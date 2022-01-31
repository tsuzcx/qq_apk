package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  private final int aJm;
  int aJn;
  int aJo;
  private final byte[] data;
  
  public i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95051);
    this.data = paramArrayOfByte;
    this.aJm = paramArrayOfByte.length;
    AppMethodBeat.o(95051);
  }
  
  private void ok()
  {
    AppMethodBeat.i(95055);
    if ((this.aJn >= 0) && ((this.aJn < this.aJm) || ((this.aJn == this.aJm) && (this.aJo == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(95055);
      return;
    }
  }
  
  public final int dD(int paramInt)
  {
    AppMethodBeat.i(95053);
    int k = this.aJn;
    int j = Math.min(paramInt, 8 - this.aJo);
    byte[] arrayOfByte = this.data;
    int i = k + 1;
    k = (arrayOfByte[k] & 0xFF) >> this.aJo & 255 >> 8 - j;
    while (j < paramInt)
    {
      k |= (this.data[i] & 0xFF) << j;
      j += 8;
      i += 1;
    }
    dE(paramInt);
    AppMethodBeat.o(95053);
    return k & -1 >>> 32 - paramInt;
  }
  
  public final void dE(int paramInt)
  {
    AppMethodBeat.i(95054);
    int i = paramInt / 8;
    this.aJn += i;
    this.aJo = (paramInt - i * 8 + this.aJo);
    if (this.aJo > 7)
    {
      this.aJn += 1;
      this.aJo -= 8;
    }
    ok();
    AppMethodBeat.o(95054);
  }
  
  public final boolean oj()
  {
    AppMethodBeat.i(95052);
    if (((this.data[this.aJn] & 0xFF) >> this.aJo & 0x1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      dE(1);
      AppMethodBeat.o(95052);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.i
 * JD-Core Version:    0.7.0.1
 */