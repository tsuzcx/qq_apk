package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveUI$3
  implements DialogInterface.OnClickListener
{
  BackupMoveUI$3(BackupMoveUI paramBackupMoveUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(17410);
    ab.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
    h.qsU.idkeyStat(485L, 25L, 1L, false);
    b.aTr().aTs().stop();
    b.aTr().aTt().cancel(false);
    b.aTr().aSL().jyN = -100;
    BackupMoveUI.f(this.jDk);
    AppMethodBeat.o(17410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI.3
 * JD-Core Version:    0.7.0.1
 */