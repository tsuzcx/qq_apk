package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends f
{
  private float A;
  private float B;
  private float dfL;
  private float dfM;
  private float dfN;
  private int dfO;
  private int dfP;
  
  public k()
  {
    AppMethodBeat.i(136878);
    this.dfL = 128.0F;
    this.dfM = 128.0F;
    this.dfN = 128.0F;
    this.dfO = 44100;
    this.dfP = ((int)(0.02F * this.dfO * 2.0F * 16.0F / 8.0F));
    this.A = (this.dfO / this.dfP);
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
        i += this.dfB[k][j];
        if (i > this.MAX_VALUE) {
          this.dfL *= 32768.0F / i;
        }
        for (;;)
        {
          k += 1;
          break;
          if (i < this.MIN_VALUE) {
            this.dfL *= 32768.0F / i;
          }
        }
      }
      if (this.dfL >= this.dfM) {}
      for (this.dfL = ((this.A * (this.dfM + 1.0F) + this.B * this.dfL) / (this.A + this.B));; this.dfL = ((this.dfM + this.dfL) / 2.0F))
      {
        this.dfM = this.dfL;
        k = i;
        if ((int)(this.dfL * 128.0F) >> 7 != 128) {
          k = (int)(this.dfN * this.dfL / 128.0F * i) / 128;
        }
        this.dfE[j] = hL(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = cg(paramInt3, paramInt2);
    AppMethodBeat.o(136879);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.k
 * JD-Core Version:    0.7.0.1
 */