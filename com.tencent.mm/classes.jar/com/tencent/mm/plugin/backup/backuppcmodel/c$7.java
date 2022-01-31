package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.h.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class c$7
  implements h.a
{
  c$7(c paramc) {}
  
  public final void aUe()
  {
    AppMethodBeat.i(17507);
    ab.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
    int i;
    if (b.aTX().aSL().jyN != 5)
    {
      b.aTX().aSL().jyN = 5;
      i = b.aTX().aTY().jEa;
      if ((1 != i) && (3 != i)) {
        break label82;
      }
      b.aTX().aTZ().rl(5);
    }
    for (;;)
    {
      this.jEk.rq(9);
      AppMethodBeat.o(17507);
      return;
      label82:
      if ((2 == i) || (4 == i)) {
        b.aTX().aUa().rf(5);
      }
    }
  }
  
  public final void aUf()
  {
    AppMethodBeat.i(17508);
    int i = this.jEk.jEa;
    ab.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[] { Integer.valueOf(i) });
    if ((1 == i) || (3 == i))
    {
      b.aTX().aTZ();
      e.aUh();
      b.aTX().aTZ().cancel(true);
      b.aTX().aTs().stop();
      b.aTX().aSL().jyN = -4;
      b.aTX().aTZ().rl(-4);
      h.qsU.idkeyStat(400L, 9L, 1L, false);
      b.aTX().aTZ().rr(3);
      AppMethodBeat.o(17508);
      return;
    }
    if ((2 == i) || (4 == i))
    {
      b.aTX().aUa();
      d.aUg();
      b.aTX().aUa().c(true, false, -4);
      b.aTX().aTs().stop();
      h.qsU.idkeyStat(400L, 17L, 1L, false);
      b.aTX().aUa().rr(3);
    }
    AppMethodBeat.o(17508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.7
 * JD-Core Version:    0.7.0.1
 */