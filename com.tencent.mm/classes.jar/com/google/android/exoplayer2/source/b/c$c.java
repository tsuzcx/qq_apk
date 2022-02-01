package com.google.android.exoplayer2.source.b;

import android.os.SystemClock;
import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$c
  extends b
{
  private int dbk;
  
  public c$c(q paramq, int[] paramArrayOfInt)
  {
    super(paramq, paramArrayOfInt);
    AppMethodBeat.i(62825);
    this.dbk = j(paramq.cZY[0]);
    AppMethodBeat.o(62825);
  }
  
  public final int Tq()
  {
    return 0;
  }
  
  public final Object Tr()
  {
    return null;
  }
  
  public final void cw(long paramLong)
  {
    AppMethodBeat.i(62826);
    paramLong = SystemClock.elapsedRealtime();
    if (!l(this.dbk, paramLong))
    {
      AppMethodBeat.o(62826);
      return;
    }
    int i = this.length - 1;
    while (i >= 0)
    {
      if (!l(i, paramLong))
      {
        this.dbk = i;
        AppMethodBeat.o(62826);
        return;
      }
      i -= 1;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(62826);
    throw localIllegalStateException;
  }
  
  public final int getSelectedIndex()
  {
    return this.dbk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c.c
 * JD-Core Version:    0.7.0.1
 */