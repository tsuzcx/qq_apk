package com.c.a.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

class p
{
  final long bPk;
  final long bPl;
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
    this.bPk = paramLong1;
    this.bPl = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.p
 * JD-Core Version:    0.7.0.1
 */