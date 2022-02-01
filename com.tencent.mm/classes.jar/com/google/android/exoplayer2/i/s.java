package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  implements i
{
  private long bHm;
  private long bHn;
  private p bcv = p.bdP;
  private boolean started;
  
  public final void a(i parami)
  {
    AppMethodBeat.i(93201);
    ah(parami.tQ());
    this.bcv = parami.tU();
    AppMethodBeat.o(93201);
  }
  
  public final void ah(long paramLong)
  {
    AppMethodBeat.i(93200);
    this.bHm = paramLong;
    if (this.started) {
      this.bHn = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(93200);
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(93203);
    if (this.started) {
      ah(tQ());
    }
    this.bcv = paramp;
    AppMethodBeat.o(93203);
    return paramp;
  }
  
  public final void start()
  {
    AppMethodBeat.i(93198);
    if (!this.started)
    {
      this.bHn = SystemClock.elapsedRealtime();
      this.started = true;
    }
    AppMethodBeat.o(93198);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(93199);
    if (this.started)
    {
      ah(tQ());
      this.started = false;
    }
    AppMethodBeat.o(93199);
  }
  
  public final long tQ()
  {
    AppMethodBeat.i(93202);
    long l2 = this.bHm;
    long l1 = l2;
    if (this.started)
    {
      l1 = SystemClock.elapsedRealtime() - this.bHn;
      if (this.bcv.bdQ != 1.0F) {
        break label54;
      }
    }
    label54:
    for (l1 = l2 + b.w(l1);; l1 = l2 + l1 * this.bcv.bdR)
    {
      AppMethodBeat.o(93202);
      return l1;
    }
  }
  
  public final p tU()
  {
    return this.bcv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i.s
 * JD-Core Version:    0.7.0.1
 */