package com.tencent.mm.d.a;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.TimeUnit;

final class r$a
  extends r.c
  implements Runnable
{
  private final ap caS;
  private long cci;
  private long ccj;
  
  r$a(r paramr, l paraml, int paramInt, V8Function paramV8Function, V8Array paramV8Array, boolean paramBoolean, long paramLong)
  {
    super(paramr, paraml, paramInt, paramV8Function, paramV8Array, paramBoolean, paramLong);
    AppMethodBeat.i(113875);
    this.caS = new ap(paramr.ccf.oNc.getLooper(), new r.a.1(this, paramr, paraml), false);
    AppMethodBeat.o(113875);
  }
  
  final void cancel()
  {
    AppMethodBeat.i(113878);
    this.caS.stopTimer();
    super.cancel();
    AppMethodBeat.o(113878);
  }
  
  public final void run()
  {
    AppMethodBeat.i(113877);
    if (!isValid())
    {
      AppMethodBeat.o(113877);
      return;
    }
    a(this.ccq);
    if (!isValid())
    {
      AppMethodBeat.o(113877);
      return;
    }
    if (!this.ccp)
    {
      cleanup();
      AppMethodBeat.o(113877);
      return;
    }
    long l1 = SystemClock.elapsedRealtimeNanos();
    if (0L == this.cci) {}
    for (this.cci = (l1 - this.ccj);; this.cci = ((l1 + this.cci - this.ccj) / 2L))
    {
      long l2 = this.cco - TimeUnit.NANOSECONDS.toMillis(this.cci);
      l1 = l2;
      if (l2 <= 0L) {
        l1 = this.cco;
      }
      this.caS.ag(l1, l1);
      AppMethodBeat.o(113877);
      return;
    }
  }
  
  final void schedule()
  {
    AppMethodBeat.i(113876);
    this.caS.ag(this.cco, this.cco);
    AppMethodBeat.o(113876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.d.a.r.a
 * JD-Core Version:    0.7.0.1
 */