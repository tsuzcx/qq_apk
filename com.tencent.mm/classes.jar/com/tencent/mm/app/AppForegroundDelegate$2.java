package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class AppForegroundDelegate$2
  implements Runnable
{
  AppForegroundDelegate$2(AppForegroundDelegate paramAppForegroundDelegate, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(131736);
    c.aHV().j(true, this.fbK);
    synchronized (AppForegroundDelegate.b(this.fbL))
    {
      LinkedList localLinkedList = new LinkedList(AppForegroundDelegate.b(this.fbL));
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((o)((Iterator)???).next()).onAppForeground(this.fbK);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.AppForegroundDelegate.2
 * JD-Core Version:    0.7.0.1
 */