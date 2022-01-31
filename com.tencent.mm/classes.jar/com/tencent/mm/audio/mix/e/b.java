package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends f
{
  protected final byte[] D(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(137086);
    int j = 0;
    while (j < paramInt2)
    {
      int i = 1;
      int k = 0;
      if (k < paramInt1)
      {
        if (k == 0) {}
        for (i = this.cgQ[k][j];; i = (int)((i + this.cgQ[k][j]) / Math.sqrt(2.0D)))
        {
          k += 1;
          break;
        }
      }
      this.cgT[j] = gt(i);
      j += 1;
    }
    byte[] arrayOfByte = bR(paramInt3, paramInt2);
    AppMethodBeat.o(137086);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.b
 * JD-Core Version:    0.7.0.1
 */