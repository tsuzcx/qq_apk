package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class BackupMoveRecoverUI$23$1
  implements DialogInterface.OnClickListener
{
  BackupMoveRecoverUI$23$1(BackupMoveRecoverUI.23 param23) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(this.hJG.hIo) });
    h.nFQ.a(485L, 48L, 1L, false);
    b.atS().atT().stop();
    b.atS().atV().a(true, true, -100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.23.1
 * JD-Core Version:    0.7.0.1
 */