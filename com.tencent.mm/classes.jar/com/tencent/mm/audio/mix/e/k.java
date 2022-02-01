package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends f
{
  private float A;
  private float B;
  private float cVX;
  private float cVY;
  private float cVZ;
  private int cWa;
  private int cWb;
  
  public k()
  {
    AppMethodBeat.i(136878);
    this.cVX = 128.0F;
    this.cVY = 128.0F;
    this.cVZ = 128.0F;
    this.cWa = 44100;
    this.cWb = ((int)(0.02F * this.cWa * 2.0F * 16.0F / 8.0F));
    this.A = (this.cWa / this.cWb);
    this.B = 1.0F;
    AppMethodBeat.o(136878);
  }
  
  protected final byte[] G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136879);
    int j = 0;
    if (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      if (k < paramInt1)
      {
        i += this.cVN[k][j];
        if (i > this.MAX_VALUE) {
          this.cVX *= 32768.0F / i;
        }
        for (;;)
        {
          k += 1;
          break;
          if (i < this.MIN_VALUE) {
            this.cVX *= 32768.0F / i;
          }
        }
      }
      if (this.cVX >= this.cVY) {}
      for (this.cVX = ((this.A * (this.cVY + 1.0F) + this.B * this.cVX) / (this.A + this.B));; this.cVX = ((this.cVY + this.cVX) / 2.0F))
      {
        this.cVY = this.cVX;
        k = i;
        if ((int)(this.cVX * 128.0F) >> 7 != 128) {
          k = (int)(this.cVZ * this.cVX / 128.0F * i) / 128;
        }
        this.cVQ[j] = hS(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = cg(paramInt3, paramInt2);
    AppMethodBeat.o(136879);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.k
 * JD-Core Version:    0.7.0.1
 */