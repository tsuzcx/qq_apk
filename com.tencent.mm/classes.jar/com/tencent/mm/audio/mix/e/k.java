package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends f
{
  private float A;
  private float B;
  private float htQ;
  private float htR;
  private float htS;
  private int htT;
  private int htU;
  
  public k()
  {
    AppMethodBeat.i(136878);
    this.htQ = 128.0F;
    this.htR = 128.0F;
    this.htS = 128.0F;
    this.htT = 44100;
    this.htU = ((int)(0.02F * this.htT * 2.0F * 16.0F / 8.0F));
    this.A = (this.htT / this.htU);
    this.B = 1.0F;
    AppMethodBeat.o(136878);
  }
  
  protected final byte[] aa(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136879);
    int j = 0;
    if (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      if (k < paramInt1)
      {
        i += this.htE[k][j];
        if (i > this.htJ) {
          this.htQ *= 32768.0F / i;
        }
        for (;;)
        {
          k += 1;
          break;
          if (i < this.htK) {
            this.htQ *= 32768.0F / i;
          }
        }
      }
      if (this.htQ >= this.htR) {}
      for (this.htQ = ((this.A * (this.htR + 1.0F) + this.B * this.htQ) / (this.A + this.B));; this.htQ = ((this.htR + this.htQ) / 2.0F))
      {
        this.htR = this.htQ;
        k = i;
        if ((int)(this.htQ * 128.0F) >> 7 != 128) {
          k = (int)(this.htS * this.htQ / 128.0F * i) / 128;
        }
        this.htH[j] = oe(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = dr(paramInt3, paramInt2);
    AppMethodBeat.o(136879);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.k
 * JD-Core Version:    0.7.0.1
 */