package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  implements b.a
{
  private final long aSz;
  private final int bitrate;
  private final long firstFramePosition;
  
  public a(long paramLong1, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(92034);
    this.firstFramePosition = paramLong1;
    this.bitrate = paramInt;
    if (paramLong2 == -1L) {}
    for (paramLong1 = -9223372036854775807L;; paramLong1 = M(paramLong2))
    {
      this.aSz = paramLong1;
      AppMethodBeat.o(92034);
      return;
    }
  }
  
  public final long K(long paramLong)
  {
    AppMethodBeat.i(92035);
    if (this.aSz == -9223372036854775807L)
    {
      AppMethodBeat.o(92035);
      return 0L;
    }
    long l = x.o(paramLong, this.aSz);
    paramLong = this.firstFramePosition;
    l = l * this.bitrate / 8000000L;
    AppMethodBeat.o(92035);
    return l + paramLong;
  }
  
  public final long M(long paramLong)
  {
    AppMethodBeat.i(92036);
    paramLong = Math.max(0L, paramLong - this.firstFramePosition) * 1000000L * 8L / this.bitrate;
    AppMethodBeat.o(92036);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    return this.aSz;
  }
  
  public final boolean sH()
  {
    return this.aSz != -9223372036854775807L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.a
 * JD-Core Version:    0.7.0.1
 */