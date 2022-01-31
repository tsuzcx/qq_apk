package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

final class e$5
  implements b.b
{
  e$5(e parame) {}
  
  public final void aSH()
  {
    AppMethodBeat.i(17551);
    h.qsU.idkeyStat(400L, 11L, 1L, false);
    h localh = h.qsU;
    if (e.b(this.jEz) == null)
    {
      l = 0L;
      localh.idkeyStat(400L, 12L, l, false);
      localh = h.qsU;
      if (e.b(this.jEz) != null) {
        break label136;
      }
    }
    label136:
    for (long l = 0L;; l = e.b(this.jEz).aSZ())
    {
      localh.idkeyStat(400L, 13L, l, false);
      this.jEz.rr(0);
      b.ru(11);
      if (!e.f(this.jEz)) {
        this.jEz.rr(21);
      }
      AppMethodBeat.o(17551);
      return;
      l = bo.hl(e.b(this.jEz).jzC) / 1000L;
      break;
    }
  }
  
  public final void aSI()
  {
    AppMethodBeat.i(17552);
    ab.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[] { Boolean.FALSE });
    this.jEz.cancel(false);
    h.qsU.idkeyStat(400L, 120L, 1L, false);
    AppMethodBeat.o(17552);
  }
  
  public final void rf(int paramInt)
  {
    AppMethodBeat.i(17550);
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(e.d(this.jEz));
    al.d(new e.5.1(this, localHashSet, paramInt));
    if (e.e(this.jEz) != null) {
      al.d(new e.5.2(this, paramInt));
    }
    AppMethodBeat.o(17550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.5
 * JD-Core Version:    0.7.0.1
 */