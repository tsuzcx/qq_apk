package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends f
{
  private float dwT = 1.0F;
  private boolean dwU = true;
  
  protected final byte[] H(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136880);
    this.dwU = true;
    int j = 0;
    while (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      while (k < paramInt1)
      {
        i += this.dwL[k][j];
        k += 1;
      }
      boolean bool = this.dwU;
      for (;;)
      {
        k = (int)(this.dwT * i);
        if (k > this.MAX_VALUE)
        {
          this.dwT = (this.MAX_VALUE / i);
          if (this.dwT < 1.0F) {
            this.dwT -= (1.0F - this.dwT) / 16.0F;
          }
          bool = false;
          i = k;
        }
        else
        {
          if (k >= this.MIN_VALUE) {
            break;
          }
          this.dwT = (this.MIN_VALUE / i);
          if (this.dwT < 1.0F) {
            this.dwT -= (1.0F - this.dwT) / 16.0F;
          }
          bool = false;
          i = k;
        }
      }
      if ((bool) && (i < this.MAX_VALUE) && (i > this.MIN_VALUE))
      {
        if (this.dwT < 1.0F) {
          this.dwT += (1.0F - this.dwT) / 16.0F;
        }
        this.dwU = false;
      }
      this.dwO[j] = jf(k);
      j += 1;
    }
    byte[] arrayOfByte = ci(paramInt3, paramInt2);
    AppMethodBeat.o(136880);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.l
 * JD-Core Version:    0.7.0.1
 */