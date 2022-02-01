package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.3;
import com.tencent.mm.plugin.backup.c.b.4;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.Iterator;
import java.util.LinkedList;

public final class a$2
  implements Runnable
{
  public a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(21276);
    Log.i("MicroMsg.BackupMoveChooseServer", "start calculateChooseConvSize");
    this.uYo.uYg = new com.tencent.mm.plugin.backup.c.b();
    com.tencent.mm.plugin.backup.c.b localb = this.uYo.uYg;
    LinkedList localLinkedList = this.uYo.cVp();
    a locala = this.uYo;
    long l1 = b.cVs().cUJ().uWo;
    long l2 = Util.nowMilliSecond();
    String str = (String)d.cWK().cWL().ban().d(2, null);
    int i = 0;
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      f.b localb1 = (f.b)localIterator.next();
      if (localb1.uWx >= 0L)
      {
        i += 1;
      }
      else
      {
        if (localb.a(localb1, str, l1)) {
          break label267;
        }
        int j = i + 1;
        i = j;
        if (!localb.uWI)
        {
          i = j;
          if (locala != null)
          {
            MMHandlerThread.postToMainThread(new b.3(localb, locala, localLinkedList, localb1.cUT(), j));
            i = j;
          }
        }
      }
    }
    Log.i("MicroMsg.BackupCalculator", "calculChooseConvSize all, userSize:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if ((!localb.uWI) && (locala != null)) {
      MMHandlerThread.postToMainThread(new b.4(localb, locala, localLinkedList));
    }
    Log.d("MicroMsg.BackupCalculator", "calculChooseConvSize loading time[%d]", new Object[] { Long.valueOf(Util.milliSecondsToNow(l2)) });
    label267:
    AppMethodBeat.o(21276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a.2
 * JD-Core Version:    0.7.0.1
 */