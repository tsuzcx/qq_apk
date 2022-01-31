package com.tencent.mm.plugin.downloader.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class a$4
  implements ap.a
{
  a$4(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(2494);
    if (!this.kZJ.bjA()) {
      this.kZJ.kZH.ag(240000L, 240000L);
    }
    AppMethodBeat.o(2494);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.a.4
 * JD-Core Version:    0.7.0.1
 */