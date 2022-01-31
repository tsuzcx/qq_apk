package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class a$1
  implements Runnable
{
  public a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(17221);
    if (this.jAV.jAN != null) {
      this.jAV.jAN.cancel();
    }
    this.jAV.jAN = new b();
    if ((this.jAV.aTm() == null) || (this.jAV.aTm().size() == 0))
    {
      ab.e("MicroMsg.BackupMoveChooseServer", "backupSessionInfo is null or nill!");
      this.jAV.jAN.a(this.jAV);
    }
    AppMethodBeat.o(17221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a.1
 * JD-Core Version:    0.7.0.1
 */