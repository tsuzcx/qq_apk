package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  implements h
{
  private com.google.android.exoplayer2.c.m aCe;
  private int aDg;
  private boolean aKp;
  private long aKr;
  private final com.google.android.exoplayer2.i.m aLw;
  private int sampleSize;
  
  public l()
  {
    AppMethodBeat.i(95133);
    this.aLw = new com.google.android.exoplayer2.i.m(10);
    AppMethodBeat.o(95133);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(95134);
    paramd.ox();
    this.aCe = paramg.dm(paramd.oy());
    this.aCe.f(Format.k(paramd.oz(), "application/id3"));
    AppMethodBeat.o(95134);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.aKp = true;
    this.aKr = paramLong;
    this.sampleSize = 0;
    this.aDg = 0;
  }
  
  public final void ol()
  {
    this.aKp = false;
  }
  
  public final void om()
  {
    AppMethodBeat.i(95136);
    if ((!this.aKp) || (this.sampleSize == 0) || (this.aDg != this.sampleSize))
    {
      AppMethodBeat.o(95136);
      return;
    }
    this.aCe.a(this.aKr, 1, this.sampleSize, 0, null);
    this.aKp = false;
    AppMethodBeat.o(95136);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95135);
    if (!this.aKp)
    {
      AppMethodBeat.o(95135);
      return;
    }
    int i = paramm.qM();
    if (this.aDg < 10)
    {
      int j = Math.min(i, 10 - this.aDg);
      System.arraycopy(paramm.data, paramm.position, this.aLw.data, this.aDg, j);
      if (j + this.aDg == 10)
      {
        this.aLw.setPosition(0);
        if ((73 != this.aLw.readUnsignedByte()) || (68 != this.aLw.readUnsignedByte()) || (51 != this.aLw.readUnsignedByte()))
        {
          this.aKp = false;
          AppMethodBeat.o(95135);
          return;
        }
        this.aLw.en(3);
        this.sampleSize = (this.aLw.qS() + 10);
      }
    }
    i = Math.min(i, this.sampleSize - this.aDg);
    this.aCe.a(paramm, i);
    this.aDg = (i + this.aDg);
    AppMethodBeat.o(95135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.l
 * JD-Core Version:    0.7.0.1
 */