package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
{
  public c bei;
  public long bej;
  public long bek;
  public long bel;
  public int bem;
  public long[] ben;
  public int[] beo;
  public int[] bep;
  public int[] beq;
  public long[] ber;
  public boolean[] bes;
  public boolean bet;
  public boolean[] beu;
  public k bev;
  public int bew;
  public m bex;
  public boolean bey;
  public long bez;
  public int sampleCount;
  
  public final void bh(int paramInt1, int paramInt2)
  {
    this.bem = paramInt1;
    this.sampleCount = paramInt2;
    if ((this.beo == null) || (this.beo.length < paramInt1))
    {
      this.ben = new long[paramInt1];
      this.beo = new int[paramInt1];
    }
    if ((this.bep == null) || (this.bep.length < paramInt2))
    {
      paramInt1 = paramInt2 * 125 / 100;
      this.bep = new int[paramInt1];
      this.beq = new int[paramInt1];
      this.ber = new long[paramInt1];
      this.bes = new boolean[paramInt1];
      this.beu = new boolean[paramInt1];
    }
  }
  
  public final void el(int paramInt)
  {
    AppMethodBeat.i(92130);
    if ((this.bex == null) || (this.bex.limit < paramInt)) {
      this.bex = new m(paramInt);
    }
    this.bew = paramInt;
    this.bet = true;
    this.bey = true;
    AppMethodBeat.o(92130);
  }
  
  public final long em(int paramInt)
  {
    return this.ber[paramInt] + this.beq[paramInt];
  }
  
  public final void q(m paramm)
  {
    AppMethodBeat.i(92131);
    paramm.readBytes(this.bex.data, 0, this.bew);
    this.bex.setPosition(0);
    this.bey = false;
    AppMethodBeat.o(92131);
  }
  
  public final void reset()
  {
    this.bem = 0;
    this.bez = 0L;
    this.bet = false;
    this.bey = false;
    this.bev = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.l
 * JD-Core Version:    0.7.0.1
 */