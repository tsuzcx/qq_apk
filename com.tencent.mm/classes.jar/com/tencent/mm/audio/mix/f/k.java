package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends f
{
  private float A;
  private float B;
  private float dwV;
  private float dwW;
  private float dwX;
  private int dwY;
  private int dwZ;
  
  public k()
  {
    AppMethodBeat.i(136878);
    this.dwV = 128.0F;
    this.dwW = 128.0F;
    this.dwX = 128.0F;
    this.dwY = 44100;
    this.dwZ = ((int)(0.02F * this.dwY * 2.0F * 16.0F / 8.0F));
    this.A = (this.dwY / this.dwZ);
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
        i += this.dwL[k][j];
        if (i > this.MAX_VALUE) {
          this.dwV *= 32768.0F / i;
        }
        for (;;)
        {
          k += 1;
          break;
          if (i < this.MIN_VALUE) {
            this.dwV *= 32768.0F / i;
          }
        }
      }
      if (this.dwV >= this.dwW) {}
      for (this.dwV = ((this.A * (this.dwW + 1.0F) + this.B * this.dwV) / (this.A + this.B));; this.dwV = ((this.dwW + this.dwV) / 2.0F))
      {
        this.dwW = this.dwV;
        k = i;
        if ((int)(this.dwV * 128.0F) >> 7 != 128) {
          k = (int)(this.dwX * this.dwV / 128.0F * i) / 128;
        }
        this.dwO[j] = jf(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = ci(paramInt3, paramInt2);
    AppMethodBeat.o(136879);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.k
 * JD-Core Version:    0.7.0.1
 */