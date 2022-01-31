package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class d$9$2
  implements Runnable
{
  d$9$2(d.9 param9, boolean paramBoolean, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(18980);
    d.a(this.kUz.kUn, null);
    aw.aaz();
    long l1 = new com.tencent.mm.vfs.b(c.Rs()).length();
    long l2 = bo.dtV();
    if (l1 == 0L)
    {
      ab.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
      AppMethodBeat.o(18980);
      return;
    }
    if ((l1 > d.f(this.kUz.kUn)) || (l1 > l2))
    {
      ab.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
      h.qsU.e(11098, new Object[] { Integer.valueOf(10008), String.format("%d|%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }) });
      AppMethodBeat.o(18980);
      return;
    }
    d.d(this.kUz.kUn, this.kUz.kUn.a(this.kTr, this.kUb));
    if (d.o(this.kUz.kUn)) {
      ab.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
    }
    AppMethodBeat.o(18980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.9.2
 * JD-Core Version:    0.7.0.1
 */