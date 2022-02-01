package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends f
{
  protected final byte[] H(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136882);
    int i = 0;
    while (i < paramInt2)
    {
      int j = 0;
      int k = 0;
      while (j < paramInt1)
      {
        k += this.dez[j][i];
        j += 1;
      }
      this.deC[i] = ((short)(k / paramInt1));
      i += 1;
    }
    byte[] arrayOfByte = cg(paramInt3, paramInt2);
    AppMethodBeat.o(136882);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.n
 * JD-Core Version:    0.7.0.1
 */