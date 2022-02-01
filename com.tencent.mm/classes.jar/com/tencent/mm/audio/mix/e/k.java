package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends f
{
  private float A;
  private float B;
  private float deJ;
  private float deK;
  private float deL;
  private int deM;
  private int deN;
  
  public k()
  {
    AppMethodBeat.i(136878);
    this.deJ = 128.0F;
    this.deK = 128.0F;
    this.deL = 128.0F;
    this.deM = 44100;
    this.deN = ((int)(0.02F * this.deM * 2.0F * 16.0F / 8.0F));
    this.A = (this.deM / this.deN);
    this.B = 1.0F;
    AppMethodBeat.o(136878);
  }
  
  protected final byte[] H(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136879);
    int j = 0;
    if (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      if (k < paramInt1)
      {
        i += this.dez[k][j];
        if (i > this.MAX_VALUE) {
          this.deJ *= 32768.0F / i;
        }
        for (;;)
        {
          k += 1;
          break;
          if (i < this.MIN_VALUE) {
            this.deJ *= 32768.0F / i;
          }
        }
      }
      if (this.deJ >= this.deK) {}
      for (this.deJ = ((this.A * (this.deK + 1.0F) + this.B * this.deJ) / (this.A + this.B));; this.deJ = ((this.deK + this.deJ) / 2.0F))
      {
        this.deK = this.deJ;
        k = i;
        if ((int)(this.deJ * 128.0F) >> 7 != 128) {
          k = (int)(this.deL * this.deJ / 128.0F * i) / 128;
        }
        this.deC[j] = hJ(k);
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