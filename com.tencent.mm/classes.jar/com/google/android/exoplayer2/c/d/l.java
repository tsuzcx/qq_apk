package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
{
  public c aIe;
  public long aIf;
  public long aIg;
  public long aIh;
  public int aIi;
  public long[] aIj;
  public int[] aIk;
  public int[] aIl;
  public int[] aIm;
  public long[] aIn;
  public boolean[] aIo;
  public boolean aIp;
  public boolean[] aIq;
  public k aIr;
  public int aIs;
  public m aIt;
  public boolean aIu;
  public long aIv;
  public int sampleCount;
  
  public final void aW(int paramInt1, int paramInt2)
  {
    this.aIi = paramInt1;
    this.sampleCount = paramInt2;
    if ((this.aIk == null) || (this.aIk.length < paramInt1))
    {
      this.aIj = new long[paramInt1];
      this.aIk = new int[paramInt1];
    }
    if ((this.aIl == null) || (this.aIl.length < paramInt2))
    {
      paramInt1 = paramInt2 * 125 / 100;
      this.aIl = new int[paramInt1];
      this.aIm = new int[paramInt1];
      this.aIn = new long[paramInt1];
      this.aIo = new boolean[paramInt1];
      this.aIq = new boolean[paramInt1];
    }
  }
  
  public final void dA(int paramInt)
  {
    AppMethodBeat.i(95014);
    if ((this.aIt == null) || (this.aIt.limit < paramInt)) {
      this.aIt = new m(paramInt);
    }
    this.aIs = paramInt;
    this.aIp = true;
    this.aIu = true;
    AppMethodBeat.o(95014);
  }
  
  public final long dB(int paramInt)
  {
    return this.aIn[paramInt] + this.aIm[paramInt];
  }
  
  public final void q(m paramm)
  {
    AppMethodBeat.i(95015);
    paramm.readBytes(this.aIt.data, 0, this.aIs);
    this.aIt.setPosition(0);
    this.aIu = false;
    AppMethodBeat.o(95015);
  }
  
  public final void reset()
  {
    this.aIi = 0;
    this.aIv = 0L;
    this.aIp = false;
    this.aIu = false;
    this.aIr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.l
 * JD-Core Version:    0.7.0.1
 */