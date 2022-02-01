package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
{
  public c cRW;
  public long cRX;
  public long cRY;
  public long cRZ;
  public int cSa;
  public long[] cSb;
  public int[] cSc;
  public int[] cSd;
  public int[] cSe;
  public long[] cSf;
  public boolean[] cSg;
  public boolean cSh;
  public boolean[] cSi;
  public k cSj;
  public int cSk;
  public m cSl;
  public boolean cSm;
  public long cSn;
  public int sampleCount;
  
  public final void ce(int paramInt1, int paramInt2)
  {
    this.cSa = paramInt1;
    this.sampleCount = paramInt2;
    if ((this.cSc == null) || (this.cSc.length < paramInt1))
    {
      this.cSb = new long[paramInt1];
      this.cSc = new int[paramInt1];
    }
    if ((this.cSd == null) || (this.cSd.length < paramInt2))
    {
      paramInt1 = paramInt2 * 125 / 100;
      this.cSd = new int[paramInt1];
      this.cSe = new int[paramInt1];
      this.cSf = new long[paramInt1];
      this.cSg = new boolean[paramInt1];
      this.cSi = new boolean[paramInt1];
    }
  }
  
  public final void hN(int paramInt)
  {
    AppMethodBeat.i(92130);
    if ((this.cSl == null) || (this.cSl.limit < paramInt)) {
      this.cSl = new m(paramInt);
    }
    this.cSk = paramInt;
    this.cSh = true;
    this.cSm = true;
    AppMethodBeat.o(92130);
  }
  
  public final long hO(int paramInt)
  {
    return this.cSf[paramInt] + this.cSe[paramInt];
  }
  
  public final void q(m paramm)
  {
    AppMethodBeat.i(92131);
    paramm.readBytes(this.cSl.data, 0, this.cSk);
    this.cSl.setPosition(0);
    this.cSm = false;
    AppMethodBeat.o(92131);
  }
  
  public final void reset()
  {
    this.cSa = 0;
    this.cSn = 0L;
    this.cSh = false;
    this.cSm = false;
    this.cSj = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.l
 * JD-Core Version:    0.7.0.1
 */