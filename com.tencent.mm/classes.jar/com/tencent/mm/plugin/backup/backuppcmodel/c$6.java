package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class c$6
  implements j.a
{
  c$6(c paramc) {}
  
  public final void aTF()
  {
    AppMethodBeat.i(17504);
    int i = b.aTX().aTY().jEa;
    if ((1 == i) || (3 == i))
    {
      b.aTX().aTZ().rl(b.aTX().aSL().jyN);
      AppMethodBeat.o(17504);
      return;
    }
    if ((2 == i) || (4 == i)) {
      b.aTX().aUa().rf(b.aTX().aSL().jyN);
    }
    AppMethodBeat.o(17504);
  }
  
  public final void aTG()
  {
    AppMethodBeat.i(17506);
    int i = b.aTX().aSL().jyN;
    ab.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
    int j = b.aTX().aTY().jEa;
    if (((1 == j) || (3 == j)) && ((i == 14) || (i == 4)))
    {
      b.aTX().aTs().stop();
      b.aTX().aTZ().cancel(true);
      h.qsU.idkeyStat(400L, 9L, 1L, false);
      b.aTX().aTZ().rr(18);
      b.aTX().aSL().jyN = -4;
      b.aTX().aTZ().rl(-4);
      AppMethodBeat.o(17506);
      return;
    }
    if (((2 == j) || (4 == j)) && ((i == 23) || (i == 4)))
    {
      b.aTX().aTs().stop();
      b.aTX().aUa().c(true, false, -4);
      h.qsU.idkeyStat(400L, 17L, 1L, false);
      b.aTX().aUa().rr(18);
    }
    AppMethodBeat.o(17506);
  }
  
  public final void rk(int paramInt)
  {
    AppMethodBeat.i(17505);
    int i = b.aTX().aSL().jyN;
    if (paramInt == 1)
    {
      if (((1 == c.h(this.jEk)) || (3 == c.h(this.jEk))) && (i == 14))
      {
        ab.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
        b.aTX().aSL().jyN = 4;
        b.aTX().aTZ().rl(4);
        AppMethodBeat.o(17505);
        return;
      }
      if (((2 == c.h(this.jEk)) || (4 == c.h(this.jEk))) && (i == 23))
      {
        ab.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
        b.aTX().aSL().jyN = 4;
        b.aTX().aUa().rf(4);
        AppMethodBeat.o(17505);
      }
    }
    else if ((paramInt == 0) && (i == 4))
    {
      ab.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
      if ((1 == c.h(this.jEk)) || (3 == c.h(this.jEk)))
      {
        b.aTX().aSL().jyN = 14;
        b.aTX().aTZ().rl(14);
        AppMethodBeat.o(17505);
        return;
      }
      if ((2 == c.h(this.jEk)) || (4 == c.h(this.jEk)))
      {
        b.aTX().aSL().jyN = 23;
        b.aTX().aUa().rf(23);
      }
    }
    AppMethodBeat.o(17505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.6
 * JD-Core Version:    0.7.0.1
 */