package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
{
  public int bdA;
  public long[] bdB;
  public int[] bdC;
  public int[] bdD;
  public int[] bdE;
  public long[] bdF;
  public boolean[] bdG;
  public boolean bdH;
  public boolean[] bdI;
  public k bdJ;
  public int bdK;
  public m bdL;
  public boolean bdM;
  public long bdN;
  public c bdw;
  public long bdx;
  public long bdy;
  public long bdz;
  public int sampleCount;
  
  public final void bi(int paramInt1, int paramInt2)
  {
    this.bdA = paramInt1;
    this.sampleCount = paramInt2;
    if ((this.bdC == null) || (this.bdC.length < paramInt1))
    {
      this.bdB = new long[paramInt1];
      this.bdC = new int[paramInt1];
    }
    if ((this.bdD == null) || (this.bdD.length < paramInt2))
    {
      paramInt1 = paramInt2 * 125 / 100;
      this.bdD = new int[paramInt1];
      this.bdE = new int[paramInt1];
      this.bdF = new long[paramInt1];
      this.bdG = new boolean[paramInt1];
      this.bdI = new boolean[paramInt1];
    }
  }
  
  public final void el(int paramInt)
  {
    AppMethodBeat.i(92130);
    if ((this.bdL == null) || (this.bdL.limit < paramInt)) {
      this.bdL = new m(paramInt);
    }
    this.bdK = paramInt;
    this.bdH = true;
    this.bdM = true;
    AppMethodBeat.o(92130);
  }
  
  public final long em(int paramInt)
  {
    return this.bdF[paramInt] + this.bdE[paramInt];
  }
  
  public final void q(m paramm)
  {
    AppMethodBeat.i(92131);
    paramm.readBytes(this.bdL.data, 0, this.bdK);
    this.bdL.setPosition(0);
    this.bdM = false;
    AppMethodBeat.o(92131);
  }
  
  public final void reset()
  {
    this.bdA = 0;
    this.bdN = 0L;
    this.bdH = false;
    this.bdM = false;
    this.bdJ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.l
 * JD-Core Version:    0.7.0.1
 */