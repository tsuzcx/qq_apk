package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i$b
{
  public volatile long awA;
  public volatile long awB;
  public final com.google.android.exoplayer2.source.i.b awx;
  public final long awy;
  public final long awz;
  
  public i$b(long paramLong)
  {
    this(new com.google.android.exoplayer2.source.i.b(0), paramLong);
    AppMethodBeat.i(94803);
    AppMethodBeat.o(94803);
  }
  
  public i$b(com.google.android.exoplayer2.source.i.b paramb, long paramLong)
  {
    this(paramb, paramLong, -9223372036854775807L);
  }
  
  public i$b(com.google.android.exoplayer2.source.i.b paramb, long paramLong1, long paramLong2)
  {
    this.awx = paramb;
    this.awy = paramLong1;
    this.awz = paramLong2;
    this.awA = paramLong1;
    this.awB = paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.b
 * JD-Core Version:    0.7.0.1
 */