package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  implements h
{
  private com.google.android.exoplayer2.c.m aYi;
  private int aZk;
  private boolean bgv;
  private long bgx;
  private final com.google.android.exoplayer2.i.m bhB;
  private int sampleSize;
  
  public l()
  {
    AppMethodBeat.i(92255);
    this.bhB = new com.google.android.exoplayer2.i.m(10);
    AppMethodBeat.o(92255);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92256);
    paramd.ts();
    this.aYi = paramg.dW(paramd.getTrackId());
    this.aYi.f(Format.k(paramd.tt(), "application/id3"));
    AppMethodBeat.o(92256);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.bgv = true;
    this.bgx = paramLong;
    this.sampleSize = 0;
    this.aZk = 0;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92257);
    if (!this.bgv)
    {
      AppMethodBeat.o(92257);
      return;
    }
    int i = paramm.vy();
    if (this.aZk < 10)
    {
      int j = Math.min(i, 10 - this.aZk);
      System.arraycopy(paramm.data, paramm.position, this.bhB.data, this.aZk, j);
      if (j + this.aZk == 10)
      {
        this.bhB.setPosition(0);
        if ((73 != this.bhB.readUnsignedByte()) || (68 != this.bhB.readUnsignedByte()) || (51 != this.bhB.readUnsignedByte()))
        {
          this.bgv = false;
          AppMethodBeat.o(92257);
          return;
        }
        this.bhB.eX(3);
        this.sampleSize = (this.bhB.vE() + 10);
      }
    }
    i = Math.min(i, this.sampleSize - this.aZk);
    this.aYi.a(paramm, i);
    this.aZk = (i + this.aZk);
    AppMethodBeat.o(92257);
  }
  
  public final void tg()
  {
    this.bgv = false;
  }
  
  public final void th()
  {
    AppMethodBeat.i(92258);
    if ((!this.bgv) || (this.sampleSize == 0) || (this.aZk != this.sampleSize))
    {
      AppMethodBeat.o(92258);
      return;
    }
    this.aYi.a(this.bgx, 1, this.sampleSize, 0, null);
    this.bgv = false;
    AppMethodBeat.o(92258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.l
 * JD-Core Version:    0.7.0.1
 */