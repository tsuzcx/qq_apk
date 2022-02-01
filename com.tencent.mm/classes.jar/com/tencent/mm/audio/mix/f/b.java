package com.tencent.mm.audio.mix.f;

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
        for (i = this.dwL[k][j];; i = (int)((i + this.dwL[k][j]) / Math.sqrt(2.0D)))
        {
          k += 1;
          break;
        }
      }
      this.dwO[j] = jf(i);
      j += 1;
    }
    byte[] arrayOfByte = ci(paramInt3, paramInt2);
    AppMethodBeat.o(136835);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.b
 * JD-Core Version:    0.7.0.1
 */