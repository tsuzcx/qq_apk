package com.tencent.mm.d.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class r$a$1
  implements ap.a
{
  r$a$1(r.a parama, r paramr, l paraml) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(113874);
    r.a.a(this.ccl, SystemClock.elapsedRealtimeNanos());
    this.cbY.cbC.k(this.ccl);
    AppMethodBeat.o(113874);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.a.r.a.1
 * JD-Core Version:    0.7.0.1
 */