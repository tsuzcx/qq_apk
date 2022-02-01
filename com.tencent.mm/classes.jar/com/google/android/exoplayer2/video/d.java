package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(16)
public final class d
{
  final d.a bIE;
  final boolean bIF;
  final long bIG;
  final long bIH;
  long bII;
  long bIJ;
  long bIK;
  boolean bIL;
  long bIM;
  long bIN;
  long bIO;
  
  public d()
  {
    this(-1.0D);
  }
  
  private d(double paramDouble)
  {
    AppMethodBeat.i(93307);
    if (paramDouble != -1.0D) {}
    for (boolean bool = true;; bool = false)
    {
      this.bIF = bool;
      if (!this.bIF) {
        break;
      }
      this.bIE = d.a.xB();
      this.bIG = ((1000000000.0D / paramDouble));
      this.bIH = (this.bIG * 80L / 100L);
      AppMethodBeat.o(93307);
      return;
    }
    this.bIE = null;
    this.bIG = -1L;
    this.bIH = -1L;
    AppMethodBeat.o(93307);
  }
  
  public d(Context paramContext) {}
  
  final boolean m(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93308);
    long l = this.bIN;
    if (Math.abs(paramLong2 - this.bIM - (paramLong1 - l)) > 20000000L)
    {
      AppMethodBeat.o(93308);
      return true;
    }
    AppMethodBeat.o(93308);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.video.d
 * JD-Core Version:    0.7.0.1
 */