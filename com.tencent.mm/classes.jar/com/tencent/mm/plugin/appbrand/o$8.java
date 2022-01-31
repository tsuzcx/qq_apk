package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.b;
import com.tencent.mm.sdk.platformtools.ap.a;

final class o$8
  implements ap.a
{
  o$8(o paramo) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(128993);
    b.g(this.gRv);
    AppMethodBeat.o(128993);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.8
 * JD-Core Version:    0.7.0.1
 */