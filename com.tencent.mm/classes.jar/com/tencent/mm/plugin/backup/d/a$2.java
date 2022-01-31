package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.3;
import com.tencent.mm.plugin.backup.c.b.4;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class a$2
  implements Runnable
{
  public a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(17222);
    ab.i("MicroMsg.BackupMoveChooseServer", "start calculateChooseConvSize");
    this.jAV.jAN = new com.tencent.mm.plugin.backup.c.b();
    com.tencent.mm.plugin.backup.c.b localb = this.jAV.jAN;
    LinkedList localLinkedList = this.jAV.aTo();
    a locala = this.jAV;
    long l1 = b.aTr().aSL().jyV;
    long l2 = bo.aoy();
    String str = (String)d.aUK().aUL().Ru().get(2, null);
    int i = 0;
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      f.b localb1 = (f.b)localIterator.next();
      if (localb1.jzd >= 0L)
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
        if (!localb.jzq)
        {
          i = j;
          if (locala != null)
          {
            al.d(new b.3(localb, locala, localLinkedList, localb1.aSV(), j));
            i = j;
          }
        }
      }
    }
    ab.i("MicroMsg.BackupCalculator", "calculChooseConvSize all, userSize:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if ((!localb.jzq) && (locala != null)) {
      al.d(new b.4(localb, locala, localLinkedList));
    }
    ab.d("MicroMsg.BackupCalculator", "calculChooseConvSize loading time[%d]", new Object[] { Long.valueOf(bo.hl(l2)) });
    label267:
    AppMethodBeat.o(17222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a.2
 * JD-Core Version:    0.7.0.1
 */