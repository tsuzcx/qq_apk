package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends f
{
  private float cTr = 1.0F;
  private boolean cTs = true;
  
  protected final byte[] G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136877);
    this.cTs = true;
    int j = 0;
    if (j < paramInt2)
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
      if ((bool) && (i < this.MAX_VALUE) && (i > this.MIN_VALUE)) {
        if (this.cTr >= 1.0F) {
          break label280;
        }
      }
      label280:
      for (this.cTr += (1.0F - this.cTr) / 16.0F;; this.cTr = 1.0F)
      {
        this.cTs = false;
        if (j == paramInt2 / 2) {
          this.cTs = true;
        }
        this.cTm[j] = hC(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = ce(paramInt3, paramInt2);
    AppMethodBeat.o(136877);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.j
 * JD-Core Version:    0.7.0.1
 */