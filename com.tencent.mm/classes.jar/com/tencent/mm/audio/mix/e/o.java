package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends f
{
  protected final byte[] D(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(137134);
    int i = 0;
    while (i < paramInt2)
    {
      int k = 0;
      int j = 0;
      while (j < paramInt1)
      {
        k += this.cgQ[j][i];
        j += 1;
      }
      this.cgT[i] = gt(k);
      i += 1;
    }
    byte[] arrayOfByte = bR(paramInt3, paramInt2);
    AppMethodBeat.o(137134);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.o
 * JD-Core Version:    0.7.0.1
 */