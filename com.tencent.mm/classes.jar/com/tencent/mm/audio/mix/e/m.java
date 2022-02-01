package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends f
{
  protected final byte[] K(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136881);
    int i = 0;
    while (i < paramInt2)
    {
      float f1 = 1.0F;
      int j = 0;
      if (j < paramInt1)
      {
        if (j == 0) {
          f1 = this.fpv[j][i];
        }
        for (;;)
        {
          j += 1;
          break;
          float f2 = this.fpv[j][i];
          if ((f1 < 0.0F) && (f2 < 0.0F)) {
            f1 = f1 + f2 - f1 * f2 / this.fpB;
          } else if ((f1 > 0.0F) && (f2 > 0.0F)) {
            f1 = f1 + f2 - f1 * f2 / this.fpA;
          } else {
            f1 += f2;
          }
        }
      }
      j = (int)f1;
      this.fpy[i] = kx(j);
      i += 1;
    }
    byte[] arrayOfByte = cB(paramInt3, paramInt2);
    AppMethodBeat.o(136881);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.m
 * JD-Core Version:    0.7.0.1
 */