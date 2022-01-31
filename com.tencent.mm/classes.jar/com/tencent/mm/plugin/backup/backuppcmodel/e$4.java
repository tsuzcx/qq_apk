package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.b.b.c;
import java.util.Iterator;
import java.util.Set;

final class e$4
  implements Runnable
{
  e$4(e parame, Set paramSet) {}
  
  public final void run()
  {
    Iterator localIterator = this.hKQ.iterator();
    while (localIterator.hasNext()) {
      ((b.c)localIterator.next()).atl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.4
 * JD-Core Version:    0.7.0.1
 */