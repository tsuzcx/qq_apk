package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a$1
  implements Runnable
{
  public a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(21275);
    if (this.uYo.uYg != null) {
      this.uYo.uYg.cancel();
    }
    this.uYo.uYg = new b();
    if ((this.uYo.cVn() == null) || (this.uYo.cVn().size() == 0))
    {
      Log.e("MicroMsg.BackupMoveChooseServer", "backupSessionInfo is null or nill!");
      this.uYo.uYg.a(this.uYo);
    }
    AppMethodBeat.o(21275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a.1
 * JD-Core Version:    0.7.0.1
 */