package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class h$1
  implements ap.a
{
  h$1(h paramh) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(17672);
    if (h.a(this.jFS))
    {
      ab.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", new Object[] { Integer.valueOf(h.access$100()) });
      this.jFS.jFP = 0;
      AppMethodBeat.o(17672);
      return false;
    }
    ab.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", new Object[] { Integer.valueOf(h.access$100()) });
    if (h.access$100() < h.b(this.jFS).length)
    {
      h.c(this.jFS).aUe();
      ap localap = h.d(this.jFS);
      long l = h.b(this.jFS)[h.access$100()];
      localap.ag(l, l);
      h.ade();
    }
    for (;;)
    {
      AppMethodBeat.o(17672);
      return false;
      h.e(this.jFS);
      this.jFS.jFP = 0;
      h.c(this.jFS).aUf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.h.1
 * JD-Core Version:    0.7.0.1
 */