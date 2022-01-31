package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.sdk.platformtools.ab;

final class d$4
  implements j.a
{
  d$4(d paramd) {}
  
  public final void aTF()
  {
    AppMethodBeat.i(153495);
    this.jCb.rl(b.aTr().aSL().jyN);
    AppMethodBeat.o(153495);
  }
  
  public final void aTG()
  {
    AppMethodBeat.i(153497);
    int i = b.aTr().aSL().jyN;
    ab.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
    if ((i == 14) || (i == 4))
    {
      this.jCb.cancel(true);
      b.aTr().aTs().stop();
      b.aTr().aSL().jyN = -4;
      this.jCb.rl(-4);
    }
    AppMethodBeat.o(153497);
  }
  
  public final void rk(int paramInt)
  {
    AppMethodBeat.i(153496);
    int i = b.aTr().aSL().jyN;
    if (paramInt == 1)
    {
      if (i == 14)
      {
        ab.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
        b.aTr().aSL().jyN = 4;
        this.jCb.rl(4);
        AppMethodBeat.o(153496);
      }
    }
    else if ((paramInt == 0) && (i == 4))
    {
      ab.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
      b.aTr().aSL().jyN = 14;
      this.jCb.rl(14);
    }
    AppMethodBeat.o(153496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d.4
 * JD-Core Version:    0.7.0.1
 */