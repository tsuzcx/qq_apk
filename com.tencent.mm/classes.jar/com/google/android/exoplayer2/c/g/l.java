package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  implements h
{
  private com.google.android.exoplayer2.c.m aXw;
  private int aYy;
  private boolean bfO;
  private long bfQ;
  private final com.google.android.exoplayer2.i.m bgV;
  private int sampleSize;
  
  public l()
  {
    AppMethodBeat.i(92255);
    this.bgV = new com.google.android.exoplayer2.i.m(10);
    AppMethodBeat.o(92255);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92256);
    paramd.tj();
    this.aXw = paramg.bh(paramd.getTrackId(), 4);
    this.aXw.f(Format.j(paramd.tl(), "application/id3"));
    AppMethodBeat.o(92256);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.bfO = true;
    this.bfQ = paramLong;
    this.sampleSize = 0;
    this.aYy = 0;
  }
  
  public final void sX()
  {
    this.bfO = false;
  }
  
  public final void sY()
  {
    AppMethodBeat.i(92258);
    if ((!this.bfO) || (this.sampleSize == 0) || (this.aYy != this.sampleSize))
    {
      AppMethodBeat.o(92258);
      return;
    }
    this.aXw.a(this.bfQ, 1, this.sampleSize, 0, null);
    this.bfO = false;
    AppMethodBeat.o(92258);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92257);
    if (!this.bfO)
    {
      AppMethodBeat.o(92257);
      return;
    }
    int i = paramm.vJ();
    if (this.aYy < 10)
    {
      int j = Math.min(i, 10 - this.aYy);
      System.arraycopy(paramm.data, paramm.position, this.bgV.data, this.aYy, j);
      if (j + this.aYy == 10)
      {
        this.bgV.setPosition(0);
        if ((73 != this.bgV.readUnsignedByte()) || (68 != this.bgV.readUnsignedByte()) || (51 != this.bgV.readUnsignedByte()))
        {
          this.bfO = false;
          AppMethodBeat.o(92257);
          return;
        }
        this.bgV.fl(3);
        this.sampleSize = (this.bgV.vP() + 10);
      }
    }
    i = Math.min(i, this.sampleSize - this.aYy);
    this.aXw.a(paramm, i);
    this.aYy = (i + this.aYy);
    AppMethodBeat.o(92257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.l
 * JD-Core Version:    0.7.0.1
 */