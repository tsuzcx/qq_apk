package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends f
{
  private float A;
  private float B;
  private float cTt;
  private float cTu;
  private float cTv;
  private int cTw;
  private int cTx;
  
  public k()
  {
    AppMethodBeat.i(136878);
    this.cTt = 128.0F;
    this.cTu = 128.0F;
    this.cTv = 128.0F;
    this.cTw = 44100;
    this.cTx = ((int)(0.02F * this.cTw * 2.0F * 16.0F / 8.0F));
    this.A = (this.cTw / this.cTx);
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
        i += this.cTj[k][j];
        if (i > this.MAX_VALUE) {
          this.cTt *= 32768.0F / i;
        }
        for (;;)
        {
          k += 1;
          break;
          if (i < this.MIN_VALUE) {
            this.cTt *= 32768.0F / i;
          }
        }
      }
      if (this.cTt >= this.cTu) {}
      for (this.cTt = ((this.A * (this.cTu + 1.0F) + this.B * this.cTt) / (this.A + this.B));; this.cTt = ((this.cTu + this.cTt) / 2.0F))
      {
        this.cTu = this.cTt;
        k = i;
        if ((int)(this.cTt * 128.0F) >> 7 != 128) {
          k = (int)(this.cTv * this.cTt / 128.0F * i) / 128;
        }
        this.cTm[j] = hC(k);
        j += 1;
        break;
      }
    }
    byte[] arrayOfByte = ce(paramInt3, paramInt2);
    AppMethodBeat.o(136879);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.k
 * JD-Core Version:    0.7.0.1
 */