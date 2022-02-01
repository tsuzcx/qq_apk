package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
{
  public long boA;
  public long boB;
  public int boC;
  public long[] boD;
  public int[] boE;
  public int[] boF;
  public int[] boG;
  public long[] boH;
  public boolean[] boI;
  public boolean boJ;
  public boolean[] boK;
  public k boL;
  public int boM;
  public m boN;
  public boolean boO;
  public long boP;
  public c boy;
  public long boz;
  public int sampleCount;
  
  public final void bd(int paramInt1, int paramInt2)
  {
    this.boC = paramInt1;
    this.sampleCount = paramInt2;
    if ((this.boE == null) || (this.boE.length < paramInt1))
    {
      this.boD = new long[paramInt1];
      this.boE = new int[paramInt1];
    }
    if ((this.boF == null) || (this.boF.length < paramInt2))
    {
      paramInt1 = paramInt2 * 125 / 100;
      this.boF = new int[paramInt1];
      this.boG = new int[paramInt1];
      this.boH = new long[paramInt1];
      this.boI = new boolean[paramInt1];
      this.boK = new boolean[paramInt1];
    }
  }
  
  public final void ej(int paramInt)
  {
    AppMethodBeat.i(92130);
    if ((this.boN == null) || (this.boN.limit < paramInt)) {
      this.boN = new m(paramInt);
    }
    this.boM = paramInt;
    this.boJ = true;
    this.boO = true;
    AppMethodBeat.o(92130);
  }
  
  public final long ek(int paramInt)
  {
    return this.boH[paramInt] + this.boG[paramInt];
  }
  
  public final void q(m paramm)
  {
    AppMethodBeat.i(92131);
    paramm.readBytes(this.boN.data, 0, this.boM);
    this.boN.setPosition(0);
    this.boO = false;
    AppMethodBeat.o(92131);
  }
  
  public final void reset()
  {
    this.boC = 0;
    this.boP = 0L;
    this.boJ = false;
    this.boO = false;
    this.boL = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.l
 * JD-Core Version:    0.7.0.1
 */