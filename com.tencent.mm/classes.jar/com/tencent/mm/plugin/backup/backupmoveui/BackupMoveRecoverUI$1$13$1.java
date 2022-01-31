package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveRecoverUI$1$13$1
  implements DialogInterface.OnClickListener
{
  BackupMoveRecoverUI$1$13$1(BackupMoveRecoverUI.1.13 param13) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(17374);
    ab.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(this.jDh.jBM) });
    h.qsU.idkeyStat(485L, 44L, 1L, false);
    b.aTr().aTu().rj(5);
    b.aTr().aTs().stop();
    b.aTr().aTu().c(true, true, -100);
    AppMethodBeat.o(17374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.13.1
 * JD-Core Version:    0.7.0.1
 */