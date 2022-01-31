package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.b.b.c;
import java.util.Iterator;
import java.util.Set;

final class d$3
  implements Runnable
{
  d$3(d paramd, Set paramSet, int paramInt) {}
  
  public final void run()
  {
    Iterator localIterator = this.hKQ.iterator();
    while (localIterator.hasNext()) {
      ((b.c)localIterator.next()).nt(this.hIo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d.3
 * JD-Core Version:    0.7.0.1
 */