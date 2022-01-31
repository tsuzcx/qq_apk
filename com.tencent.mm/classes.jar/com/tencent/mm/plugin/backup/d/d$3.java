package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$3
  implements j.a
{
  d$3(d paramd) {}
  
  public final void aug()
  {
    this.hIC.nt(b.atS().atn().hFu);
  }
  
  public final void auh()
  {
    int i = b.atS().atn().hFu;
    y.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
    if ((i == 14) || (i == 4))
    {
      this.hIC.cancel(true);
      b.atS().atT().stop();
      b.atS().atn().hFu = -4;
      this.hIC.nt(-4);
    }
  }
  
  public final void ny(int paramInt)
  {
    int i = b.atS().atn().hFu;
    if (paramInt == 1) {
      if (i == 14)
      {
        y.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
        b.atS().atn().hFu = 4;
        this.hIC.nt(4);
      }
    }
    while ((paramInt != 0) || (i != 4)) {
      return;
    }
    y.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
    b.atS().atn().hFu = 14;
    this.hIC.nt(14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d.3
 * JD-Core Version:    0.7.0.1
 */