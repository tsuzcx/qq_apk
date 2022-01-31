package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.b.b.c;
import java.util.Iterator;
import java.util.Set;

final class e$5$1
  implements Runnable
{
  e$5$1(e.5 param5, Set paramSet, int paramInt) {}
  
  public final void run()
  {
    Iterator localIterator = this.hKQ.iterator();
    while (localIterator.hasNext()) {
      ((b.c)localIterator.next()).nt(this.hIo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.5.1
 * JD-Core Version:    0.7.0.1
 */