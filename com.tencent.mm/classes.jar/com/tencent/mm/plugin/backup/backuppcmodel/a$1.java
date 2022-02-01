package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.b;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(21536);
    if (this.vbp.uZm != null) {
      this.vbp.uZm.cancel();
    }
    this.vbp.uZm = new b();
    this.vbp.uZm.a(this.vbp);
    AppMethodBeat.o(21536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.a.1
 * JD-Core Version:    0.7.0.1
 */