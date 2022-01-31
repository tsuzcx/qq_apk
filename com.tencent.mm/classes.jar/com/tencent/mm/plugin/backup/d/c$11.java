package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class c$11
  implements j.a
{
  c$11(c paramc) {}
  
  public final void aug()
  {
    this.hIn.nt(b.atS().atn().hFu);
  }
  
  public final void auh()
  {
    int i = b.atS().atn().hFu;
    y.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
    if ((i == 23) || (i == 4))
    {
      this.hIn.a(true, false, -4);
      h.nFQ.a(485L, 43L, 1L, false);
      this.hIn.nx(4);
      b.atS().atT().stop();
    }
  }
  
  public final void ny(int paramInt)
  {
    int i = b.atS().atn().hFu;
    if (paramInt == 1) {
      if (i == 23)
      {
        y.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
        b.atS().atn().hFu = 4;
        this.hIn.nt(4);
        h.nFQ.f(11789, new Object[] { Integer.valueOf(8) });
      }
    }
    while ((paramInt != 0) || (i != 4)) {
      return;
    }
    y.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
    b.atS().atn().hFu = 23;
    this.hIn.nt(23);
    h.nFQ.f(11789, new Object[] { Integer.valueOf(9) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.11
 * JD-Core Version:    0.7.0.1
 */