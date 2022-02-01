package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  implements h
{
  private com.google.android.exoplayer2.c.m biA;
  private int bjC;
  private boolean bqK;
  private long bqM;
  private final com.google.android.exoplayer2.i.m brQ;
  private int sampleSize;
  
  public l()
  {
    AppMethodBeat.i(92255);
    this.brQ = new com.google.android.exoplayer2.i.m(10);
    AppMethodBeat.o(92255);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92256);
    paramd.uW();
    this.biA = paramg.dV(paramd.getTrackId());
    this.biA.f(Format.k(paramd.uX(), "application/id3"));
    AppMethodBeat.o(92256);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.bqK = true;
    this.bqM = paramLong;
    this.sampleSize = 0;
    this.bjC = 0;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92257);
    if (!this.bqK)
    {
      AppMethodBeat.o(92257);
      return;
    }
    int i = paramm.xd();
    if (this.bjC < 10)
    {
      int j = Math.min(i, 10 - this.bjC);
      System.arraycopy(paramm.data, paramm.position, this.brQ.data, this.bjC, j);
      if (j + this.bjC == 10)
      {
        this.brQ.setPosition(0);
        if ((73 != this.brQ.readUnsignedByte()) || (68 != this.brQ.readUnsignedByte()) || (51 != this.brQ.readUnsignedByte()))
        {
          this.bqK = false;
          AppMethodBeat.o(92257);
          return;
        }
        this.brQ.eZ(3);
        this.sampleSize = (this.brQ.xj() + 10);
      }
    }
    i = Math.min(i, this.sampleSize - this.bjC);
    this.biA.a(paramm, i);
    this.bjC = (i + this.bjC);
    AppMethodBeat.o(92257);
  }
  
  public final void uK()
  {
    this.bqK = false;
  }
  
  public final void uL()
  {
    AppMethodBeat.i(92258);
    if ((!this.bqK) || (this.sampleSize == 0) || (this.bjC != this.sampleSize))
    {
      AppMethodBeat.o(92258);
      return;
    }
    this.biA.a(this.bqM, 1, this.sampleSize, 0, null);
    this.bqK = false;
    AppMethodBeat.o(92258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.l
 * JD-Core Version:    0.7.0.1
 */