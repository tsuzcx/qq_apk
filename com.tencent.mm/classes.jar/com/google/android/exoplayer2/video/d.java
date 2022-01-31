package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(16)
public final class d
{
  long bcA;
  long bcB;
  long bcC;
  final d.a bcs;
  final boolean bct;
  final long bcu;
  final long bcv;
  long bcw;
  long bcx;
  long bcy;
  boolean bcz;
  
  public d()
  {
    this(-1.0D);
  }
  
  private d(double paramDouble)
  {
    AppMethodBeat.i(96036);
    if (paramDouble != -1.0D) {}
    for (boolean bool = true;; bool = false)
    {
      this.bct = bool;
      if (!this.bct) {
        break;
      }
      this.bcs = d.a.rk();
      this.bcu = ((1000000000.0D / paramDouble));
      this.bcv = (this.bcu * 80L / 100L);
      AppMethodBeat.o(96036);
      return;
    }
    this.bcs = null;
    this.bcu = -1L;
    this.bcv = -1L;
    AppMethodBeat.o(96036);
  }
  
  public d(Context paramContext) {}
  
  final boolean o(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(96037);
    long l = this.bcB;
    if (Math.abs(paramLong2 - this.bcA - (paramLong1 - l)) > 20000000L)
    {
      AppMethodBeat.o(96037);
      return true;
    }
    AppMethodBeat.o(96037);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.video.d
 * JD-Core Version:    0.7.0.1
 */