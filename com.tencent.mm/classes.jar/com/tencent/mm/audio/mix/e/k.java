package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends f
{
  private float A;
  private float B;
  private float fpH;
  private float fpI;
  private float fpJ;
  private int fpK;
  private int fpL;
  
  public k()
  {
    AppMethodBeat.i(136878);
    this.fpH = 128.0F;
    this.fpI = 128.0F;
    this.fpJ = 128.0F;
    this.fpK = 44100;
    this.fpL = ((int)(0.02F * this.fpK * 2.0F * 16.0F / 8.0F));
    this.A = (this.fpK / this.fpL);
    this.B = 1.0F;
    AppMethodBeat.o(136878);
  }
  
  protected final byte[] K(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136879);
    int j = 0;
    if (j < paramInt2)
    {
      int i = 0;
      int k = 0;
      if (k < paramInt1)
      {
        i += this.fpv[k][j];
        if (i > this.fpA) {
          this.fpH *= 32768.0F / i;
        }
        for (;;)
        {
          k += 1;
          break;
          if (i < this.fpB) {
            this.fpH *= 32768.0F / i;
          }
        }
      }
      if (this.fpH >= this.fpI) {}
      for (this.fpH = ((this.A * (this.fpI + 1.0F) + this.B * this.fpH) / (this.A + this.B));; this.fpH = ((this.fpI + this.fpH) / 2.0F))
      {
        this.fpI = this.fpH;
        k = i;
        if ((int)(this.fpH * 128.0F) >> 7 != 128) {
          k = (int)(this.fpJ * this.fpH / 128.0F * i) / 128;
        }
        this.fpy[j] = kx(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = cB(paramInt3, paramInt2);
    AppMethodBeat.o(136879);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.k
 * JD-Core Version:    0.7.0.1
 */