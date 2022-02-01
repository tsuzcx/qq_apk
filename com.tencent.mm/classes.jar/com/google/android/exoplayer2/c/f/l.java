package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  implements h
{
  private com.google.android.exoplayer2.c.m cMa;
  private int cNc;
  private boolean cUh;
  private long cUj;
  private final com.google.android.exoplayer2.i.m cVn;
  private int sampleSize;
  
  public l()
  {
    AppMethodBeat.i(92255);
    this.cVn = new com.google.android.exoplayer2.i.m(10);
    AppMethodBeat.o(92255);
  }
  
  public final void Si()
  {
    this.cUh = false;
  }
  
  public final void Sj()
  {
    AppMethodBeat.i(92258);
    if ((!this.cUh) || (this.sampleSize == 0) || (this.cNc != this.sampleSize))
    {
      AppMethodBeat.o(92258);
      return;
    }
    this.cMa.a(this.cUj, 1, this.sampleSize, 0, null);
    this.cUh = false;
    AppMethodBeat.o(92258);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92256);
    paramd.Sv();
    this.cMa = paramg.hz(paramd.getTrackId());
    this.cMa.f(Format.t(paramd.Sw(), "application/id3"));
    AppMethodBeat.o(92256);
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.cUh = true;
    this.cUj = paramLong;
    this.sampleSize = 0;
    this.cNc = 0;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92257);
    if (!this.cUh)
    {
      AppMethodBeat.o(92257);
      return;
    }
    int i = paramm.UF();
    if (this.cNc < 10)
    {
      int j = Math.min(i, 10 - this.cNc);
      System.arraycopy(paramm.data, paramm.position, this.cVn.data, this.cNc, j);
      if (j + this.cNc == 10)
      {
        this.cVn.setPosition(0);
        if ((73 != this.cVn.readUnsignedByte()) || (68 != this.cVn.readUnsignedByte()) || (51 != this.cVn.readUnsignedByte()))
        {
          this.cUh = false;
          AppMethodBeat.o(92257);
          return;
        }
        this.cVn.iH(3);
        this.sampleSize = (this.cVn.UM() + 10);
      }
    }
    i = Math.min(i, this.sampleSize - this.cNc);
    this.cMa.a(paramm, i);
    this.cNc = (i + this.cNc);
    AppMethodBeat.o(92257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.l
 * JD-Core Version:    0.7.0.1
 */