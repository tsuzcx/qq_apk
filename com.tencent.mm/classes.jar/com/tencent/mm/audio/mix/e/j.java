package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends f
{
  private float cgY = 1.0F;
  private boolean cgZ = true;
  
  protected final byte[] D(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(137128);
    this.cgZ = true;
    int j = 0;
    if (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      while (k < paramInt1)
      {
        i += this.cgQ[k][j];
        k += 1;
      }
      boolean bool = this.cgZ;
      for (;;)
      {
        k = (int)(this.cgY * i);
        if (k > this.MAX_VALUE)
        {
          this.cgY = (this.MAX_VALUE / i);
          if (this.cgY < 1.0F) {
            this.cgY -= (1.0F - this.cgY) / 16.0F;
          }
          bool = false;
          i = k;
        }
        else
        {
          if (k >= this.MIN_VALUE) {
            break;
          }
          this.cgY = (this.MIN_VALUE / i);
          if (this.cgY < 1.0F) {
            this.cgY -= (1.0F - this.cgY) / 16.0F;
          }
          bool = false;
          i = k;
        }
      }
      if ((bool) && (i < this.MAX_VALUE) && (i > this.MIN_VALUE)) {
        if (this.cgY >= 1.0F) {
          break label280;
        }
      }
      label280:
      for (this.cgY += (1.0F - this.cgY) / 16.0F;; this.cgY = 1.0F)
      {
        this.cgZ = false;
        if (j == paramInt2 / 2) {
          this.cgZ = true;
        }
        this.cgT[j] = gt(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = bR(paramInt3, paramInt2);
    AppMethodBeat.o(137128);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.j
 * JD-Core Version:    0.7.0.1
 */