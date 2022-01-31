package com.tencent.mm.app.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class a$f$1
  implements ap.a
{
  a$f$1(a.f paramf) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(15741);
    ab.i("MicroMsg.SubCoreExtAgent", "Voice record timeout.");
    this.caY.caV = true;
    this.caY.stopRecord();
    AppMethodBeat.o(15741);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a.f.1
 * JD-Core Version:    0.7.0.1
 */