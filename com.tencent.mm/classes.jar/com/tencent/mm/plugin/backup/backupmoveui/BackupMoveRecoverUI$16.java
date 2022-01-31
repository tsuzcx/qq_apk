package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class BackupMoveRecoverUI$16
  implements DialogInterface.OnClickListener
{
  BackupMoveRecoverUI$16(BackupMoveRecoverUI paramBackupMoveRecoverUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", new Object[] { Integer.valueOf(this.hJF) });
    h.nFQ.a(485L, 44L, 1L, false);
    b.atS().atV().nx(5);
    b.atS().atT().stop();
    b.atS().atV().a(true, true, -100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.16
 * JD-Core Version:    0.7.0.1
 */