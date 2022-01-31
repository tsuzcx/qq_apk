package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;

final class e$5
  implements b.b
{
  e$5(e parame) {}
  
  public final void atj()
  {
    h.nFQ.a(400L, 11L, 1L, false);
    h localh = h.nFQ;
    if (e.b(this.hKW) == null)
    {
      l = 0L;
      localh.a(400L, 12L, l, false);
      localh = h.nFQ;
      if (e.b(this.hKW) != null) {
        break label124;
      }
    }
    label124:
    for (long l = 0L;; l = e.b(this.hKW).atB())
    {
      localh.a(400L, 13L, l, false);
      this.hKW.nC(0);
      b.nG(11);
      if (!e.f(this.hKW)) {
        this.hKW.nC(21);
      }
      return;
      l = bk.co(e.b(this.hKW).hGg) / 1000L;
      break;
    }
  }
  
  public final void atk()
  {
    y.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[] { Boolean.valueOf(false) });
    this.hKW.cancel(false);
    h.nFQ.a(400L, 120L, 1L, false);
  }
  
  public final void nt(int paramInt)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(e.d(this.hKW));
    ai.d(new e.5.1(this, localHashSet, paramInt));
    if (e.e(this.hKW) != null) {
      ai.d(new e.5.2(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.5
 * JD-Core Version:    0.7.0.1
 */