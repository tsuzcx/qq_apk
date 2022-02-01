package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends f
{
  protected final byte[] H(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136835);
    int j = 0;
    while (j < paramInt2)
    {
      int i = 1;
      int k = 0;
      if (k < paramInt1)
      {
        if (k == 0) {}
        for (i = this.dfB[k][j];; i = (int)((i + this.dfB[k][j]) / Math.sqrt(2.0D)))
        {
          k += 1;
          break;
        }
      }
      this.dfE[j] = hL(i);
      j += 1;
    }
    byte[] arrayOfByte = cg(paramInt3, paramInt2);
    AppMethodBeat.o(136835);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.b
 * JD-Core Version:    0.7.0.1
 */