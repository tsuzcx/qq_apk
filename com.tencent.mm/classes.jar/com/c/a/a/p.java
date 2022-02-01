package com.c.a.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

class p
{
  final long bRC;
  final long bRD;
  final int what;
  
  p(int paramInt)
  {
    this(paramInt, System.currentTimeMillis(), SystemClock.elapsedRealtime());
    AppMethodBeat.i(88024);
    AppMethodBeat.o(88024);
  }
  
  private p(int paramInt, long paramLong1, long paramLong2)
  {
    this.what = paramInt;
    this.bRC = paramLong1;
    this.bRD = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.p
 * JD-Core Version:    0.7.0.1
 */