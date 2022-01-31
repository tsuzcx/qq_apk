package com.tencent.mm.plugin.dbbackup;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class d$5
  implements b
{
  int iNv = 0;
  
  d$5(d paramd, com.tencent.mm.vfs.b paramb, b paramb1, WakerLock paramWakerLock) {}
  
  public final void pC(int paramInt)
  {
    int i = paramInt;
    if (this.iNv > 0) {
      y.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", new Object[] { Integer.valueOf(this.iNv), Integer.valueOf(i) });
    }
    if (i == 0)
    {
      this.iNw.delete();
      h.nFQ.a(181L, 29L, 1L, true);
      if (this.iNb != null) {
        this.iNb.pC(i);
      }
      this.iNx.unLock();
      return;
    }
    if (i == -2)
    {
      this.iNw.delete();
      h.nFQ.a(181L, 3L, 1L, true);
      if (this.iNb != null) {
        this.iNb.pC(i);
      }
      this.iNx.unLock();
      return;
    }
    paramInt = this.iNv + 1;
    this.iNv = paramInt;
    switch (paramInt)
    {
    default: 
      this.iNw.delete();
      h.nFQ.a(181L, 30L, 1L, true);
      if (this.iNb != null) {
        this.iNb.pC(i);
      }
      this.iNx.unLock();
      return;
    case 1: 
      y.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", new Object[] { Integer.valueOf(this.iNv) });
      paramInt = this.iNn.b(null, this);
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt != 0) {
        break;
      }
      return;
      y.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", new Object[] { Integer.valueOf(this.iNv) });
      paramInt = this.iNn.a(null, this);
      continue;
      y.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", new Object[] { Integer.valueOf(this.iNv) });
      paramInt = this.iNn.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.5
 * JD-Core Version:    0.7.0.1
 */