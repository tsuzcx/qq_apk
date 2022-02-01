package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends f
{
  private float cTr = 1.0F;
  private boolean cTs = true;
  
  protected final byte[] G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136880);
    this.cTs = true;
    int j = 0;
    while (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      while (k < paramInt1)
      {
        i += this.cTj[k][j];
        k += 1;
      }
      boolean bool = this.cTs;
      for (;;)
      {
        k = (int)(this.cTr * i);
        if (k > this.MAX_VALUE)
        {
          this.cTr = (this.MAX_VALUE / i);
          if (this.cTr < 1.0F) {
            this.cTr -= (1.0F - this.cTr) / 16.0F;
          }
          bool = false;
          i = k;
        }
        else
        {
          if (k >= this.MIN_VALUE) {
            break;
          }
          this.cTr = (this.MIN_VALUE / i);
          if (this.cTr < 1.0F) {
            this.cTr -= (1.0F - this.cTr) / 16.0F;
          }
          bool = false;
          i = k;
        }
      }
      if ((bool) && (i < this.MAX_VALUE) && (i > this.MIN_VALUE))
      {
        if (this.cTr < 1.0F) {
          this.cTr += (1.0F - this.cTr) / 16.0F;
        }
        this.cTs = false;
      }
      this.cTm[j] = hC(k);
      j += 1;
    }
    byte[] arrayOfByte = ce(paramInt3, paramInt2);
    AppMethodBeat.o(136880);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.l
 * JD-Core Version:    0.7.0.1
 */