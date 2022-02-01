package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends f
{
  private float cVV = 1.0F;
  private boolean cVW = true;
  
  protected final byte[] G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136877);
    this.cVW = true;
    int j = 0;
    if (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      while (k < paramInt1)
      {
        i += this.cVN[k][j];
        k += 1;
      }
      boolean bool = this.cVW;
      for (;;)
      {
        k = (int)(this.cVV * i);
        if (k > this.MAX_VALUE)
        {
          this.cVV = (this.MAX_VALUE / i);
          if (this.cVV < 1.0F) {
            this.cVV -= (1.0F - this.cVV) / 16.0F;
          }
          bool = false;
          i = k;
        }
        else
        {
          if (k >= this.MIN_VALUE) {
            break;
          }
          this.cVV = (this.MIN_VALUE / i);
          if (this.cVV < 1.0F) {
            this.cVV -= (1.0F - this.cVV) / 16.0F;
          }
          bool = false;
          i = k;
        }
      }
      if ((bool) && (i < this.MAX_VALUE) && (i > this.MIN_VALUE)) {
        if (this.cVV >= 1.0F) {
          break label280;
        }
      }
      label280:
      for (this.cVV += (1.0F - this.cVV) / 16.0F;; this.cVV = 1.0F)
      {
        this.cVW = false;
        if (j == paramInt2 / 2) {
          this.cVW = true;
        }
        this.cVQ[j] = hS(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = cg(paramInt3, paramInt2);
    AppMethodBeat.o(136877);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.j
 * JD-Core Version:    0.7.0.1
 */