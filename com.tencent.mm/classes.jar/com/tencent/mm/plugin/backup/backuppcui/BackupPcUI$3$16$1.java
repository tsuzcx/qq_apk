package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupPcUI$3$16$1
  implements DialogInterface.OnClickListener
{
  BackupPcUI$3$16$1(BackupPcUI.3.16 param16) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(17610);
    ab.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
    b.aTX().aTs().stop();
    b.aTX().aTZ().cancel(true);
    b.aTX().aSL().jyN = -100;
    h.qsU.idkeyStat(400L, 52L, 1L, false);
    b.aTX().aTZ().rr(4);
    BackupPcUI.k(this.jEW.jEQ.jEP);
    AppMethodBeat.o(17610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.16.1
 * JD-Core Version:    0.7.0.1
 */