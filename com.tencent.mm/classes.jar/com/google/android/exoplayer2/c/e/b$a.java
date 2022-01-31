package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a
  implements f, l
{
  long[] aIJ;
  long[] aIK;
  private long aIL = -1L;
  long firstFrameOffset = -1L;
  
  public b$a(b paramb) {}
  
  public final long E(long paramLong)
  {
    AppMethodBeat.i(95028);
    paramLong = this.aIM.M(paramLong);
    int i = x.a(this.aIJ, paramLong, true);
    paramLong = this.firstFrameOffset;
    long l = this.aIK[i];
    AppMethodBeat.o(95028);
    return l + paramLong;
  }
  
  public final long K(long paramLong)
  {
    AppMethodBeat.i(95027);
    paramLong = this.aIM.M(paramLong);
    int i = x.a(this.aIJ, paramLong, true);
    this.aIL = this.aIJ[i];
    AppMethodBeat.o(95027);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    g localg = this.aIM.aIH;
    return localg.baQ * 1000000L / localg.sampleRate;
  }
  
  public final long i(com.google.android.exoplayer2.c.f paramf)
  {
    if (this.aIL >= 0L)
    {
      long l = -(this.aIL + 2L);
      this.aIL = -1L;
      return l;
    }
    return -1L;
  }
  
  public final boolean nV()
  {
    return true;
  }
  
  public final l oi()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.b.a
 * JD-Core Version:    0.7.0.1
 */