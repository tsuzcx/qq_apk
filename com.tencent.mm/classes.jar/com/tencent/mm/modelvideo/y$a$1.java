package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class y$a$1
  implements ap.a
{
  y$a$1(y.a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(50866);
    y.a.a(this.fYk);
    AppMethodBeat.o(50866);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50867);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(50867);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y.a.1
 * JD-Core Version:    0.7.0.1
 */