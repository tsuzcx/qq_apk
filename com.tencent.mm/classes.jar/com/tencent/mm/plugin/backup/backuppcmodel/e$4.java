package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.c;
import java.util.Iterator;
import java.util.Set;

final class e$4
  implements Runnable
{
  e$4(e parame, Set paramSet) {}
  
  public final void run()
  {
    AppMethodBeat.i(17547);
    Iterator localIterator = this.jEt.iterator();
    while (localIterator.hasNext()) {
      ((b.c)localIterator.next()).aSJ();
    }
    AppMethodBeat.o(17547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.4
 * JD-Core Version:    0.7.0.1
 */