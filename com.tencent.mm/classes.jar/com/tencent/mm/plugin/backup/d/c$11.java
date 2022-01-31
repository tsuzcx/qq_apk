package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class c$11
  implements j.a
{
  c$11(c paramc) {}
  
  public final void aTF()
  {
    AppMethodBeat.i(17256);
    this.jBL.rf(b.aTr().aSL().jyN);
    AppMethodBeat.o(17256);
  }
  
  public final void aTG()
  {
    AppMethodBeat.i(17258);
    int i = b.aTr().aSL().jyN;
    ab.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
    if ((i == 23) || (i == 4))
    {
      this.jBL.c(true, false, -4);
      h.qsU.idkeyStat(485L, 43L, 1L, false);
      this.jBL.rj(4);
      b.aTr().aTs().stop();
    }
    AppMethodBeat.o(17258);
  }
  
  public final void rk(int paramInt)
  {
    AppMethodBeat.i(17257);
    int i = b.aTr().aSL().jyN;
    if (paramInt == 1)
    {
      if (i == 23)
      {
        ab.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
        b.aTr().aSL().jyN = 4;
        this.jBL.rf(4);
        this.jBL.rj(8);
        AppMethodBeat.o(17257);
      }
    }
    else if ((paramInt == 0) && (i == 4))
    {
      ab.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
      b.aTr().aSL().jyN = 23;
      this.jBL.rf(23);
      this.jBL.rj(9);
    }
    AppMethodBeat.o(17257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.11
 * JD-Core Version:    0.7.0.1
 */