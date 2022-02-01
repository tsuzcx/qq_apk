package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  implements h
{
  private com.google.android.exoplayer2.c.m aSe;
  private int aTg;
  private boolean bam;
  private long bao;
  private final com.google.android.exoplayer2.i.m bbs;
  private int sampleSize;
  
  public l()
  {
    AppMethodBeat.i(92255);
    this.bbs = new com.google.android.exoplayer2.i.m(10);
    AppMethodBeat.o(92255);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92256);
    paramd.sR();
    this.aSe = paramg.ej(paramd.getTrackId());
    this.aSe.f(Format.l(paramd.sS(), "application/id3"));
    AppMethodBeat.o(92256);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.bam = true;
    this.bao = paramLong;
    this.sampleSize = 0;
    this.aTg = 0;
  }
  
  public final void sF()
  {
    this.bam = false;
  }
  
  public final void sG()
  {
    AppMethodBeat.i(92258);
    if ((!this.bam) || (this.sampleSize == 0) || (this.aTg != this.sampleSize))
    {
      AppMethodBeat.o(92258);
      return;
    }
    this.aSe.a(this.bao, 1, this.sampleSize, 0, null);
    this.bam = false;
    AppMethodBeat.o(92258);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92257);
    if (!this.bam)
    {
      AppMethodBeat.o(92257);
      return;
    }
    int i = paramm.vg();
    if (this.aTg < 10)
    {
      int j = Math.min(i, 10 - this.aTg);
      System.arraycopy(paramm.data, paramm.position, this.bbs.data, this.aTg, j);
      if (j + this.aTg == 10)
      {
        this.bbs.setPosition(0);
        if ((73 != this.bbs.readUnsignedByte()) || (68 != this.bbs.readUnsignedByte()) || (51 != this.bbs.readUnsignedByte()))
        {
          this.bam = false;
          AppMethodBeat.o(92257);
          return;
        }
        this.bbs.fu(3);
        this.sampleSize = (this.bbs.vn() + 10);
      }
    }
    i = Math.min(i, this.sampleSize - this.aTg);
    this.aSe.a(paramm, i);
    this.aTg = (i + this.aTg);
    AppMethodBeat.o(92257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.l
 * JD-Core Version:    0.7.0.1
 */