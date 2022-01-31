package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  implements i
{
  private p avN = p.axk;
  private long bbp;
  private long bbq;
  private boolean started;
  
  public final void a(i parami)
  {
    AppMethodBeat.i(95937);
    aa(parami.nw());
    this.avN = parami.nA();
    AppMethodBeat.o(95937);
  }
  
  public final void aa(long paramLong)
  {
    AppMethodBeat.i(95936);
    this.bbp = paramLong;
    if (this.started) {
      this.bbq = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(95936);
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(95939);
    if (this.started) {
      aa(nw());
    }
    this.avN = paramp;
    AppMethodBeat.o(95939);
    return paramp;
  }
  
  public final p nA()
  {
    return this.avN;
  }
  
  public final long nw()
  {
    AppMethodBeat.i(95938);
    long l2 = this.bbp;
    long l1 = l2;
    if (this.started)
    {
      l1 = SystemClock.elapsedRealtime() - this.bbq;
      if (this.avN.speed != 1.0F) {
        break label54;
      }
    }
    label54:
    for (l1 = l2 + b.p(l1);; l1 = l2 + l1 * this.avN.axl)
    {
      AppMethodBeat.o(95938);
      return l1;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(95934);
    if (!this.started)
    {
      this.bbq = SystemClock.elapsedRealtime();
      this.started = true;
    }
    AppMethodBeat.o(95934);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(95935);
    if (this.started)
    {
      aa(nw());
      this.started = false;
    }
    AppMethodBeat.o(95935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i.s
 * JD-Core Version:    0.7.0.1
 */