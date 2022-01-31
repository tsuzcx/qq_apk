package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  implements b.a
{
  private final long axh;
  private final int bitrate;
  private final long firstFramePosition;
  
  public a(long paramLong1, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(94919);
    this.firstFramePosition = paramLong1;
    this.bitrate = paramInt;
    if (paramLong2 == -1L) {}
    for (paramLong1 = -9223372036854775807L;; paramLong1 = G(paramLong2))
    {
      this.axh = paramLong1;
      AppMethodBeat.o(94919);
      return;
    }
  }
  
  public final long E(long paramLong)
  {
    AppMethodBeat.i(94920);
    if (this.axh == -9223372036854775807L)
    {
      AppMethodBeat.o(94920);
      return 0L;
    }
    long l = x.n(paramLong, this.axh);
    paramLong = this.firstFramePosition;
    l = l * this.bitrate / 8000000L;
    AppMethodBeat.o(94920);
    return l + paramLong;
  }
  
  public final long G(long paramLong)
  {
    AppMethodBeat.i(94921);
    paramLong = Math.max(0L, paramLong - this.firstFramePosition) * 1000000L * 8L / this.bitrate;
    AppMethodBeat.o(94921);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    return this.axh;
  }
  
  public final boolean nV()
  {
    return this.axh != -9223372036854775807L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.a
 * JD-Core Version:    0.7.0.1
 */