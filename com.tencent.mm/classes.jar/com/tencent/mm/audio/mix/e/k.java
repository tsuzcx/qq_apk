package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends f
{
  private float A;
  private float B;
  private float cha;
  private float chb;
  private float chc;
  private int chd;
  private int che;
  
  public k()
  {
    AppMethodBeat.i(137129);
    this.cha = 128.0F;
    this.chb = 128.0F;
    this.chc = 128.0F;
    this.chd = 44100;
    this.che = ((int)(0.02F * this.chd * 2.0F * 16.0F / 8.0F));
    this.A = (this.chd / this.che);
    this.B = 1.0F;
    AppMethodBeat.o(137129);
  }
  
  protected final byte[] D(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(137130);
    int j = 0;
    if (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      if (k < paramInt1)
      {
        i += this.cgQ[k][j];
        if (i > this.MAX_VALUE) {
          this.cha *= 32768.0F / i;
        }
        for (;;)
        {
          k += 1;
          break;
          if (i < this.MIN_VALUE) {
            this.cha *= 32768.0F / i;
          }
        }
      }
      if (this.cha >= this.chb) {}
      for (this.cha = ((this.A * (this.chb + 1.0F) + this.B * this.cha) / (this.A + this.B));; this.cha = ((this.chb + this.cha) / 2.0F))
      {
        this.chb = this.cha;
        k = i;
        if ((int)(this.cha * 128.0F) >> 7 != 128) {
          k = (int)(this.chc * this.cha / 128.0F * i) / 128;
        }
        this.cgT[j] = gt(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = bR(paramInt3, paramInt2);
    AppMethodBeat.o(137130);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.k
 * JD-Core Version:    0.7.0.1
 */