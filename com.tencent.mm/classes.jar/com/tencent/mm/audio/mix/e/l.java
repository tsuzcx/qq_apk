package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends f
{
  private float htO = 1.0F;
  private boolean htP = true;
  
  protected final byte[] aa(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136880);
    this.htP = true;
    int j = 0;
    while (j < paramInt2)
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
      if ((bool) && (i < this.htJ) && (i > this.htK))
      {
        if (this.htO < 1.0F) {
          this.htO += (1.0F - this.htO) / 16.0F;
        }
        this.htP = false;
      }
      this.htH[j] = oe(k);
      j += 1;
    }
    byte[] arrayOfByte = dr(paramInt3, paramInt2);
    AppMethodBeat.o(136880);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.l
 * JD-Core Version:    0.7.0.1
 */