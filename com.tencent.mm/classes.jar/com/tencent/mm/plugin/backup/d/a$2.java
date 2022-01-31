package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.3;
import com.tencent.mm.plugin.backup.c.b.4;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class a$2
  implements Runnable
{
  public a$2(a parama) {}
  
  public final void run()
  {
    y.i("MicroMsg.BackupMoveChooseServer", "start calculateChooseConvSize");
    this.hHz.hHr = new com.tencent.mm.plugin.backup.c.b();
    com.tencent.mm.plugin.backup.c.b localb = this.hHz.hHr;
    LinkedList localLinkedList = this.hHz.atQ();
    a locala = this.hHz;
    long l1 = b.atS().atn().hFA;
    long l2 = bk.UY();
    String str = (String)d.avi().avj().Dz().get(2, null);
    int i = 0;
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      f.b localb1 = (f.b)localIterator.next();
      if (localb1.hFG >= 0L)
      {
        i += 1;
      }
      else
      {
        if (localb.a(localb1, str, l1)) {
          return;
        }
        int j = i + 1;
        i = j;
        if (!localb.hFU)
        {
          i = j;
          if (locala != null)
          {
            ai.d(new b.3(localb, locala, localLinkedList, localb1.atx(), j));
            i = j;
          }
        }
      }
    }
    y.i("MicroMsg.BackupCalculator", "calculChooseConvSize all, userSize:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if ((!localb.hFU) && (locala != null)) {
      ai.d(new b.4(localb, locala, localLinkedList));
    }
    y.d("MicroMsg.BackupCalculator", "calculChooseConvSize loading time[%d]", new Object[] { Long.valueOf(bk.co(l2)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a.2
 * JD-Core Version:    0.7.0.1
 */