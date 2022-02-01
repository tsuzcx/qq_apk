package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  implements h
{
  private com.google.android.exoplayer2.c.m biD;
  private int bjF;
  private boolean bqP;
  private long bqR;
  private final com.google.android.exoplayer2.i.m brV;
  private int sampleSize;
  
  public l()
  {
    AppMethodBeat.i(92255);
    this.brV = new com.google.android.exoplayer2.i.m(10);
    AppMethodBeat.o(92255);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92256);
    paramd.uR();
    this.biD = paramg.eb(paramd.getTrackId());
    this.biD.f(Format.k(paramd.uS(), "application/id3"));
    AppMethodBeat.o(92256);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.bqP = true;
    this.bqR = paramLong;
    this.sampleSize = 0;
    this.bjF = 0;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92257);
    if (!this.bqP)
    {
      AppMethodBeat.o(92257);
      return;
    }
    int i = paramm.wV();
    if (this.bjF < 10)
    {
      int j = Math.min(i, 10 - this.bjF);
      System.arraycopy(paramm.data, paramm.position, this.brV.data, this.bjF, j);
      if (j + this.bjF == 10)
      {
        this.brV.setPosition(0);
        if ((73 != this.brV.readUnsignedByte()) || (68 != this.brV.readUnsignedByte()) || (51 != this.brV.readUnsignedByte()))
        {
          this.bqP = false;
          AppMethodBeat.o(92257);
          return;
        }
        this.brV.fa(3);
        this.sampleSize = (this.brV.xb() + 10);
      }
    }
    i = Math.min(i, this.sampleSize - this.bjF);
    this.biD.a(paramm, i);
    this.bjF = (i + this.bjF);
    AppMethodBeat.o(92257);
  }
  
  public final void uF()
  {
    this.bqP = false;
  }
  
  public final void uG()
  {
    AppMethodBeat.i(92258);
    if ((!this.bqP) || (this.sampleSize == 0) || (this.bjF != this.sampleSize))
    {
      AppMethodBeat.o(92258);
      return;
    }
    this.biD.a(this.bqR, 1, this.sampleSize, 0, null);
    this.bqP = false;
    AppMethodBeat.o(92258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.l
 * JD-Core Version:    0.7.0.1
 */