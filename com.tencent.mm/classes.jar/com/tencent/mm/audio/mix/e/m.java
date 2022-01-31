package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends f
{
  protected final byte[] D(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(137132);
    int i = 0;
    while (i < paramInt2)
    {
      float f1 = 1.0F;
      int j = 0;
      if (j < paramInt1)
      {
        if (j == 0) {
          f1 = this.cgQ[j][i];
        }
        for (;;)
        {
          j += 1;
          break;
          float f2 = this.cgQ[j][i];
          if ((f1 < 0.0F) && (f2 < 0.0F)) {
            f1 = f1 + f2 - f1 * f2 / this.MIN_VALUE;
          } else if ((f1 > 0.0F) && (f2 > 0.0F)) {
            f1 = f1 + f2 - f1 * f2 / this.MAX_VALUE;
          } else {
            f1 += f2;
          }
        }
      }
      j = (int)f1;
      this.cgT[i] = gt(j);
      i += 1;
    }
    byte[] arrayOfByte = bR(paramInt3, paramInt2);
    AppMethodBeat.o(137132);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.m
 * JD-Core Version:    0.7.0.1
 */