package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.c;
import java.util.Iterator;
import java.util.Set;

final class d$2
  implements Runnable
{
  d$2(d paramd, Set paramSet) {}
  
  public final void run()
  {
    AppMethodBeat.i(17522);
    Iterator localIterator = this.jEt.iterator();
    while (localIterator.hasNext()) {
      ((b.c)localIterator.next()).aSJ();
    }
    AppMethodBeat.o(17522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d.2
 * JD-Core Version:    0.7.0.1
 */