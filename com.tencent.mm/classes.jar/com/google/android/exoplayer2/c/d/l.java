package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
{
  public c aYa;
  public long aYb;
  public long aYc;
  public long aYd;
  public int aYe;
  public long[] aYf;
  public int[] aYg;
  public int[] aYh;
  public int[] aYi;
  public long[] aYj;
  public boolean[] aYk;
  public boolean aYl;
  public boolean[] aYm;
  public k aYn;
  public int aYo;
  public m aYp;
  public boolean aYq;
  public long aYr;
  public int sampleCount;
  
  public final void bj(int paramInt1, int paramInt2)
  {
    this.aYe = paramInt1;
    this.sampleCount = paramInt2;
    if ((this.aYg == null) || (this.aYg.length < paramInt1))
    {
      this.aYf = new long[paramInt1];
      this.aYg = new int[paramInt1];
    }
    if ((this.aYh == null) || (this.aYh.length < paramInt2))
    {
      paramInt1 = paramInt2 * 125 / 100;
      this.aYh = new int[paramInt1];
      this.aYi = new int[paramInt1];
      this.aYj = new long[paramInt1];
      this.aYk = new boolean[paramInt1];
      this.aYm = new boolean[paramInt1];
    }
  }
  
  public final void ex(int paramInt)
  {
    AppMethodBeat.i(92130);
    if ((this.aYp == null) || (this.aYp.limit < paramInt)) {
      this.aYp = new m(paramInt);
    }
    this.aYo = paramInt;
    this.aYl = true;
    this.aYq = true;
    AppMethodBeat.o(92130);
  }
  
  public final long ey(int paramInt)
  {
    return this.aYj[paramInt] + this.aYi[paramInt];
  }
  
  public final void q(m paramm)
  {
    AppMethodBeat.i(92131);
    paramm.readBytes(this.aYp.data, 0, this.aYo);
    this.aYp.setPosition(0);
    this.aYq = false;
    AppMethodBeat.o(92131);
  }
  
  public final void reset()
  {
    this.aYe = 0;
    this.aYr = 0L;
    this.aYl = false;
    this.aYq = false;
    this.aYn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.l
 * JD-Core Version:    0.7.0.1
 */