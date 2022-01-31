package com.tencent.mm.plugin.dbbackup;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class d$5
  implements b
{
  int kUv = 0;
  
  d$5(d paramd, com.tencent.mm.vfs.b paramb, b paramb1, WakerLock paramWakerLock) {}
  
  public final void tT(int paramInt)
  {
    AppMethodBeat.i(18974);
    int i = paramInt;
    if (this.kUv > 0) {
      ab.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", new Object[] { Integer.valueOf(this.kUv), Integer.valueOf(i) });
    }
    if (i == 0)
    {
      this.kUw.delete();
      h.qsU.idkeyStat(181L, 29L, 1L, true);
      if (this.kUb != null) {
        this.kUb.tT(i);
      }
      this.kUx.unLock();
      AppMethodBeat.o(18974);
      return;
    }
    if (i == -2)
    {
      this.kUw.delete();
      h.qsU.idkeyStat(181L, 3L, 1L, true);
      if (this.kUb != null) {
        this.kUb.tT(i);
      }
      this.kUx.unLock();
      AppMethodBeat.o(18974);
      return;
    }
    paramInt = this.kUv + 1;
    this.kUv = paramInt;
    switch (paramInt)
    {
    default: 
      this.kUw.delete();
      h.qsU.idkeyStat(181L, 30L, 1L, true);
      if (this.kUb != null) {
        this.kUb.tT(i);
      }
      this.kUx.unLock();
      AppMethodBeat.o(18974);
      return;
    case 1: 
      ab.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", new Object[] { Integer.valueOf(this.kUv) });
      paramInt = this.kUn.b(null, this);
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt != 0) {
        break;
      }
      AppMethodBeat.o(18974);
      return;
      ab.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", new Object[] { Integer.valueOf(this.kUv) });
      paramInt = this.kUn.a(null, this);
      continue;
      ab.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", new Object[] { Integer.valueOf(this.kUv) });
      paramInt = this.kUn.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.5
 * JD-Core Version:    0.7.0.1
 */