package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ap.a;

final class q$1
  implements ap.a
{
  q$1(PBool paramPBool1, PBool paramPBool2) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(129598);
    if (this.hbG.value)
    {
      AppMethodBeat.o(129598);
      return false;
    }
    this.hbH.value = true;
    q.a(null);
    AppMethodBeat.o(129598);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.q.1
 * JD-Core Version:    0.7.0.1
 */