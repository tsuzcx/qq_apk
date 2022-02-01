package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  implements i
{
  private p cFP = p.cHj;
  private long dkO;
  private long dkP;
  private boolean started;
  
  public final long Rq()
  {
    AppMethodBeat.i(93202);
    long l2 = this.dkO;
    long l1 = l2;
    if (this.started)
    {
      l1 = SystemClock.elapsedRealtime() - this.dkP;
      if (this.cFP.cHk != 1.0F) {
        break label54;
      }
    }
    label54:
    for (l1 = l2 + b.bN(l1);; l1 = l2 + l1 * this.cFP.cHl)
    {
      AppMethodBeat.o(93202);
      return l1;
    }
  }
  
  public final p Ru()
  {
    return this.cFP;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(93201);
    cy(parami.Rq());
    this.cFP = parami.Ru();
    AppMethodBeat.o(93201);
  }
  
  public final p b(p paramp)
  {
    AppMethodBeat.i(93203);
    if (this.started) {
      cy(Rq());
    }
    this.cFP = paramp;
    AppMethodBeat.o(93203);
    return paramp;
  }
  
  public final void cy(long paramLong)
  {
    AppMethodBeat.i(93200);
    this.dkO = paramLong;
    if (this.started) {
      this.dkP = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(93200);
  }
  
  public final void start()
  {
    AppMethodBeat.i(93198);
    if (!this.started)
    {
      this.dkP = SystemClock.elapsedRealtime();
      this.started = true;
    }
    AppMethodBeat.o(93198);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(93199);
    if (this.started)
    {
      cy(Rq());
      this.started = false;
    }
    AppMethodBeat.o(93199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.i.s
 * JD-Core Version:    0.7.0.1
 */