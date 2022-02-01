package com.google.android.exoplayer2.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  final d.a dlQ;
  final boolean dlR;
  final long dlS;
  final long dlT;
  long dlU;
  long dlV;
  long dlW;
  boolean dlX;
  long dlY;
  long dlZ;
  long dma;
  
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
      this.dlR = bool;
      if (!this.dlR) {
        break;
      }
      this.dlQ = d.a.Vd();
      this.dlS = ((1000000000.0D / paramDouble));
      this.dlT = (this.dlS * 80L / 100L);
      AppMethodBeat.o(93307);
      return;
    }
    this.dlQ = null;
    this.dlS = -1L;
    this.dlT = -1L;
    AppMethodBeat.o(93307);
  }
  
  public d(Context paramContext) {}
  
  final boolean J(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93308);
    long l = this.dlZ;
    if (Math.abs(paramLong2 - this.dlY - (paramLong1 - l)) > 20000000L)
    {
      AppMethodBeat.o(93308);
      return true;
    }
    AppMethodBeat.o(93308);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.video.d
 * JD-Core Version:    0.7.0.1
 */