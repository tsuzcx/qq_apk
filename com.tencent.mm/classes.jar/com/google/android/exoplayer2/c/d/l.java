package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
{
  public c boD;
  public long boE;
  public long boF;
  public long boG;
  public int boH;
  public long[] boI;
  public int[] boJ;
  public int[] boK;
  public int[] boL;
  public long[] boM;
  public boolean[] boN;
  public boolean boO;
  public boolean[] boP;
  public k boQ;
  public int boR;
  public m boS;
  public boolean boT;
  public long boU;
  public int sampleCount;
  
  public final void bj(int paramInt1, int paramInt2)
  {
    this.boH = paramInt1;
    this.sampleCount = paramInt2;
    if ((this.boJ == null) || (this.boJ.length < paramInt1))
    {
      this.boI = new long[paramInt1];
      this.boJ = new int[paramInt1];
    }
    if ((this.boK == null) || (this.boK.length < paramInt2))
    {
      paramInt1 = paramInt2 * 125 / 100;
      this.boK = new int[paramInt1];
      this.boL = new int[paramInt1];
      this.boM = new long[paramInt1];
      this.boN = new boolean[paramInt1];
      this.boP = new boolean[paramInt1];
    }
  }
  
  public final void ep(int paramInt)
  {
    AppMethodBeat.i(92130);
    if ((this.boS == null) || (this.boS.limit < paramInt)) {
      this.boS = new m(paramInt);
    }
    this.boR = paramInt;
    this.boO = true;
    this.boT = true;
    AppMethodBeat.o(92130);
  }
  
  public final long eq(int paramInt)
  {
    return this.boM[paramInt] + this.boL[paramInt];
  }
  
  public final void q(m paramm)
  {
    AppMethodBeat.i(92131);
    paramm.readBytes(this.boS.data, 0, this.boR);
    this.boS.setPosition(0);
    this.boT = false;
    AppMethodBeat.o(92131);
  }
  
  public final void reset()
  {
    this.boH = 0;
    this.boU = 0L;
    this.boO = false;
    this.boT = false;
    this.boQ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.l
 * JD-Core Version:    0.7.0.1
 */