package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$e
  extends r.a
{
  private final int boP;
  private final long bpA;
  private final long bpC;
  private final boolean bpD;
  private final String bpz;
  
  private r$e(r paramr, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    super(paramr, (byte)0);
    this.bpz = paramString;
    this.bpA = paramLong1;
    this.bpC = paramLong2;
    this.boP = paramInt;
    this.bpD = true;
  }
  
  public final void run()
  {
    AppMethodBeat.i(55544);
    try
    {
      r.a(tv(), this.bpz, this.bpA, this.bpC, this.boP, this.bpD);
      AppMethodBeat.o(55544);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55544);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.b.a.a.r.e
 * JD-Core Version:    0.7.0.1
 */