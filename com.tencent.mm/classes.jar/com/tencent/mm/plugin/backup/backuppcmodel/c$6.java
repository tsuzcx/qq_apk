package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class c$6
  implements j.a
{
  c$6(c paramc) {}
  
  public final void aug()
  {
    int i = b.auw().aux().hKx;
    if ((1 == i) || (3 == i)) {
      b.auw().auy().nD(b.auw().atn().hFu);
    }
    while ((2 != i) && (4 != i)) {
      return;
    }
    b.auw().auz().nt(b.auw().atn().hFu);
  }
  
  public final void auh()
  {
    int i = b.auw().atn().hFu;
    y.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
    int j = b.auw().aux().hKx;
    if (((1 == j) || (3 == j)) && ((i == 14) || (i == 4)))
    {
      b.auw().atT().stop();
      b.auw().auy().cancel(true);
      h.nFQ.a(400L, 9L, 1L, false);
      b.auw().auy().nC(18);
      b.auw().atn().hFu = -4;
      b.auw().auy().nD(-4);
    }
    while (((2 != j) && (4 != j)) || ((i != 23) && (i != 4))) {
      return;
    }
    b.auw().atT().stop();
    b.auw().auz().a(true, false, -4);
    h.nFQ.a(400L, 17L, 1L, false);
    b.auw().auz().nC(18);
  }
  
  public final void ny(int paramInt)
  {
    int i = b.auw().atn().hFu;
    if (paramInt == 1) {
      if (((1 == c.h(this.hKH)) || (3 == c.h(this.hKH))) && (i == 14))
      {
        y.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
        b.auw().atn().hFu = 4;
        b.auw().auy().nD(4);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (((2 != c.h(this.hKH)) && (4 != c.h(this.hKH))) || (i != 23));
        y.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
        b.auw().atn().hFu = 4;
        b.auw().auz().nt(4);
        return;
      } while ((paramInt != 0) || (i != 4));
      y.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
      if ((1 == c.h(this.hKH)) || (3 == c.h(this.hKH)))
      {
        b.auw().atn().hFu = 14;
        b.auw().auy().nD(14);
        return;
      }
    } while ((2 != c.h(this.hKH)) && (4 != c.h(this.hKH)));
    b.auw().atn().hFu = 23;
    b.auw().auz().nt(23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.6
 * JD-Core Version:    0.7.0.1
 */