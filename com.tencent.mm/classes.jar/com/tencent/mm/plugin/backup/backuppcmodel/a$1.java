package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.b;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(17477);
    if (this.jDT.jBP != null) {
      this.jDT.jBP.cancel();
    }
    this.jDT.jBP = new b();
    this.jDT.jBP.a(this.jDT);
    AppMethodBeat.o(17477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.a.1
 * JD-Core Version:    0.7.0.1
 */