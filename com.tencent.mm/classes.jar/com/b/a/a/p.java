package com.b.a.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

class p
{
  final long bpg;
  final long bph;
  final int what;
  
  p(int paramInt)
  {
    this(paramInt, System.currentTimeMillis(), SystemClock.elapsedRealtime());
    AppMethodBeat.i(55679);
    AppMethodBeat.o(55679);
  }
  
  private p(int paramInt, long paramLong1, long paramLong2)
  {
    this.what = paramInt;
    this.bpg = paramLong1;
    this.bph = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.a.p
 * JD-Core Version:    0.7.0.1
 */