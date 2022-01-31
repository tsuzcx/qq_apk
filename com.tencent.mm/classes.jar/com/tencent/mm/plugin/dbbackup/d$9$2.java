package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class d$9$2
  implements Runnable
{
  d$9$2(d.9 param9, boolean paramBoolean, b paramb) {}
  
  public final void run()
  {
    d.a(this.iNz.iNn, null);
    au.Hx();
    long l1 = new com.tencent.mm.vfs.b(c.Dx()).length();
    long l2 = bk.crY();
    if (l1 == 0L) {
      y.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
    }
    do
    {
      return;
      if ((l1 > d.f(this.iNz.iNn)) || (l1 > l2))
      {
        y.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
        h.nFQ.f(11098, new Object[] { Integer.valueOf(10008), String.format("%d|%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }) });
        return;
      }
      d.d(this.iNz.iNn, this.iNz.iNn.a(this.iMt, this.iNb));
    } while (!d.o(this.iNz.iNn));
    y.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.9.2
 * JD-Core Version:    0.7.0.1
 */