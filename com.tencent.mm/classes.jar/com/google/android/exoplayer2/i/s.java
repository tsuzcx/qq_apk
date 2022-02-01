package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  implements i
{
  private p aRf = p.aSC;
  private long bzq;
  private long bzr;
  private boolean started;
  
  public final void a(i parami)
  {
    AppMethodBeat.i(93201);
    al(parami.si());
    this.aRf = parami.sm();
    AppMethodBeat.o(93201);
  }
  
  public final void al(long paramLong)
  {
    AppMethodBeat.i(93200);
    this.bzq = paramLong;
    if (this.started) {
      this.bzr = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(93200);
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(93203);
    if (this.started) {
      al(si());
    }
    this.aRf = paramp;
    AppMethodBeat.o(93203);
    return paramp;
  }
  
  public final long si()
  {
    AppMethodBeat.i(93202);
    long l2 = this.bzq;
    long l1 = l2;
    if (this.started)
    {
      l1 = SystemClock.elapsedRealtime() - this.bzr;
      if (this.aRf.aSD != 1.0F) {
        break label54;
      }
    }
    label54:
    for (l1 = l2 + b.u(l1);; l1 = l2 + l1 * this.aRf.aSE)
    {
      AppMethodBeat.o(93202);
      return l1;
    }
  }
  
  public final p sm()
  {
    return this.aRf;
  }
  
  public final void start()
  {
    AppMethodBeat.i(93198);
    if (!this.started)
    {
      this.bzr = SystemClock.elapsedRealtime();
      this.started = true;
    }
    AppMethodBeat.o(93198);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(93199);
    if (this.started)
    {
      al(si());
      this.started = false;
    }
    AppMethodBeat.o(93199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.s
 * JD-Core Version:    0.7.0.1
 */