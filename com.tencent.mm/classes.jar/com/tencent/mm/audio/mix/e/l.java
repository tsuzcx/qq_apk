package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends f
{
  private float fpF = 1.0F;
  private boolean fpG = true;
  
  protected final byte[] K(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136880);
    this.fpG = true;
    int j = 0;
    while (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      while (k < paramInt1)
      {
        i += this.fpv[k][j];
        k += 1;
      }
      boolean bool = this.fpG;
      for (;;)
      {
        k = (int)(this.fpF * i);
        if (k > this.fpA)
        {
          this.fpF = (this.fpA / i);
          if (this.fpF < 1.0F) {
            this.fpF -= (1.0F - this.fpF) / 16.0F;
          }
          bool = false;
          i = k;
        }
        else
        {
          if (k >= this.fpB) {
            break;
          }
          this.fpF = (this.fpB / i);
          if (this.fpF < 1.0F) {
            this.fpF -= (1.0F - this.fpF) / 16.0F;
          }
          bool = false;
          i = k;
        }
      }
      if ((bool) && (i < this.fpA) && (i > this.fpB))
      {
        if (this.fpF < 1.0F) {
          this.fpF += (1.0F - this.fpF) / 16.0F;
        }
        this.fpG = false;
      }
      this.fpy[j] = kx(k);
      j += 1;
    }
    byte[] arrayOfByte = cB(paramInt3, paramInt2);
    AppMethodBeat.o(136880);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.l
 * JD-Core Version:    0.7.0.1
 */