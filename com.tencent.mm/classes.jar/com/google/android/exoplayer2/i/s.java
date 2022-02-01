package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  implements i
{
  private p aSa = p.aTv;
  private long bwY;
  private long bwZ;
  private boolean started;
  
  public final void a(i parami)
  {
    AppMethodBeat.i(93201);
    ah(parami.sr());
    this.aSa = parami.sv();
    AppMethodBeat.o(93201);
  }
  
  public final void ah(long paramLong)
  {
    AppMethodBeat.i(93200);
    this.bwY = paramLong;
    if (this.started) {
      this.bwZ = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(93200);
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(93203);
    if (this.started) {
      ah(sr());
    }
    this.aSa = paramp;
    AppMethodBeat.o(93203);
    return paramp;
  }
  
  public final long sr()
  {
    AppMethodBeat.i(93202);
    long l2 = this.bwY;
    long l1 = l2;
    if (this.started)
    {
      l1 = SystemClock.elapsedRealtime() - this.bwZ;
      if (this.aSa.aTw != 1.0F) {
        break label54;
      }
    }
    label54:
    for (l1 = l2 + b.w(l1);; l1 = l2 + l1 * this.aSa.aTx)
    {
      AppMethodBeat.o(93202);
      return l1;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(93198);
    if (!this.started)
    {
      this.bwZ = SystemClock.elapsedRealtime();
      this.started = true;
    }
    AppMethodBeat.o(93198);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(93199);
    if (this.started)
    {
      ah(sr());
      this.started = false;
    }
    AppMethodBeat.o(93199);
  }
  
  public final p sv()
  {
    return this.aSa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.s
 * JD-Core Version:    0.7.0.1
 */