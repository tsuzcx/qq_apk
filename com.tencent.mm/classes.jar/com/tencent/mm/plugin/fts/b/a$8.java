package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ap.a;

final class a$8
  implements ap.a
{
  a$8(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(136660);
    a.e(this.mUg).a(131093, new a.u(this.mUg, (byte)0));
    AppMethodBeat.o(136660);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(136661);
    String str = super.toString() + "|atOnceIndexTimer";
    AppMethodBeat.o(136661);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.8
 * JD-Core Version:    0.7.0.1
 */