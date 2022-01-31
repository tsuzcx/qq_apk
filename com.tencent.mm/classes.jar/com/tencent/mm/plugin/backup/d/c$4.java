package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$4
  implements ap.a
{
  c$4(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(17249);
    if (!c.access$200())
    {
      ab.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
      if (c.c(this.jBL) != null) {
        c.c(this.jBL).stopTimer();
      }
      c.d(this.jBL);
    }
    AppMethodBeat.o(17249);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.4
 * JD-Core Version:    0.7.0.1
 */