package com.google.android.exoplayer2.source.b;

import android.os.SystemClock;
import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.source.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$c
  extends b
{
  private int aRn;
  
  public c$c(o paramo, int[] paramArrayOfInt)
  {
    super(paramo, paramArrayOfInt);
    AppMethodBeat.i(125901);
    this.aRn = j(paramo.aQc[0]);
    AppMethodBeat.o(125901);
  }
  
  public final void Y(long paramLong)
  {
    AppMethodBeat.i(125902);
    paramLong = SystemClock.elapsedRealtime();
    if (!k(this.aRn, paramLong))
    {
      AppMethodBeat.o(125902);
      return;
    }
    int i = this.length - 1;
    while (i >= 0)
    {
      if (!k(i, paramLong))
      {
        this.aRn = i;
        AppMethodBeat.o(125902);
        return;
      }
      i -= 1;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(125902);
    throw localIllegalStateException;
  }
  
  public final int pv()
  {
    return this.aRn;
  }
  
  public final int pw()
  {
    return 0;
  }
  
  public final Object px()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c.c
 * JD-Core Version:    0.7.0.1
 */