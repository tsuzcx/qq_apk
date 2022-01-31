package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$2
  implements ap.a
{
  c$2(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(17500);
    if (!c.access$200())
    {
      ab.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
      if (c.c(this.jEk) != null) {
        c.c(this.jEk).stopTimer();
      }
      c.d(this.jEk);
    }
    AppMethodBeat.o(17500);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.2
 * JD-Core Version:    0.7.0.1
 */