package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends f
{
  private float htO = 1.0F;
  private boolean htP = true;
  
  protected final byte[] aa(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136877);
    this.htP = true;
    int j = 0;
    if (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      while (k < paramInt1)
      {
        i += this.htE[k][j];
        k += 1;
      }
      boolean bool = this.htP;
      for (;;)
      {
        k = (int)(this.htO * i);
        if (k > this.htJ)
        {
          this.htO = (this.htJ / i);
          if (this.htO < 1.0F) {
            this.htO -= (1.0F - this.htO) / 16.0F;
          }
          bool = false;
          i = k;
        }
        else
        {
          if (k >= this.htK) {
            break;
          }
          this.htO = (this.htK / i);
          if (this.htO < 1.0F) {
            this.htO -= (1.0F - this.htO) / 16.0F;
          }
          bool = false;
          i = k;
        }
      }
      if ((bool) && (i < this.htJ) && (i > this.htK)) {
        if (this.htO >= 1.0F) {
          break label280;
        }
      }
      label280:
      for (this.htO += (1.0F - this.htO) / 16.0F;; this.htO = 1.0F)
      {
        this.htP = false;
        if (j == paramInt2 / 2) {
          this.htP = true;
        }
        this.htH[j] = oe(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = dr(paramInt3, paramInt2);
    AppMethodBeat.o(136877);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.j
 * JD-Core Version:    0.7.0.1
 */