package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends f
{
  private float deH = 1.0F;
  private boolean deI = true;
  
  protected final byte[] H(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136880);
    this.deI = true;
    int j = 0;
    while (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      while (k < paramInt1)
      {
        i += this.dez[k][j];
        k += 1;
      }
      boolean bool = this.deI;
      for (;;)
      {
        k = (int)(this.deH * i);
        if (k > this.MAX_VALUE)
        {
          this.deH = (this.MAX_VALUE / i);
          if (this.deH < 1.0F) {
            this.deH -= (1.0F - this.deH) / 16.0F;
          }
          bool = false;
          i = k;
        }
        else
        {
          if (k >= this.MIN_VALUE) {
            break;
          }
          this.deH = (this.MIN_VALUE / i);
          if (this.deH < 1.0F) {
            this.deH -= (1.0F - this.deH) / 16.0F;
          }
          bool = false;
          i = k;
        }
      }
      if ((bool) && (i < this.MAX_VALUE) && (i > this.MIN_VALUE))
      {
        if (this.deH < 1.0F) {
          this.deH += (1.0F - this.deH) / 16.0F;
        }
        this.deI = false;
      }
      this.deC[j] = hJ(k);
      j += 1;
    }
    byte[] arrayOfByte = cg(paramInt3, paramInt2);
    AppMethodBeat.o(136880);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.l
 * JD-Core Version:    0.7.0.1
 */