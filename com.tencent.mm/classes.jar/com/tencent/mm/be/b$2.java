package com.tencent.mm.be;

import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(78528);
    ab.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
    a.ymk.d(b.f(this.fNW));
    SwEngine.stopContinousLocationUpdate();
    SwEngine.onDestroy();
    if (b.g(this.fNW) != null)
    {
      b.g(this.fNW).finish();
      b.a(this.fNW, null);
    }
    b.l(this.fNW);
    b.m(this.fNW);
    b.n(this.fNW);
    b.a(this.fNW, false);
    AppMethodBeat.o(78528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.be.b.2
 * JD-Core Version:    0.7.0.1
 */