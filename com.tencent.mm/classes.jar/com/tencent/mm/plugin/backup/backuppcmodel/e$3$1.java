package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.g.b.b;
import com.tencent.mm.sdk.platformtools.ab;

final class e$3$1
  implements b.b
{
  e$3$1(e.3 param3) {}
  
  public final void fC(boolean paramBoolean)
  {
    AppMethodBeat.i(17545);
    if (paramBoolean)
    {
      ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
      com.tencent.mm.plugin.backup.g.b.rv(0);
      AppMethodBeat.o(17545);
      return;
    }
    this.jEA.jEz.rl(b.aTX().aSL().jyN);
    AppMethodBeat.o(17545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.3.1
 * JD-Core Version:    0.7.0.1
 */