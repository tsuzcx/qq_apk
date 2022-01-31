package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveRecoverUI$1$19$1
  implements DialogInterface.OnClickListener
{
  BackupMoveRecoverUI$1$19$1(BackupMoveRecoverUI.1.19 param19) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(17381);
    ab.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(this.jDi.jBM) });
    h.qsU.idkeyStat(485L, 48L, 1L, false);
    b.aTr().aTs().stop();
    b.aTr().aTu().c(true, true, -100);
    AppMethodBeat.o(17381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.19.1
 * JD-Core Version:    0.7.0.1
 */