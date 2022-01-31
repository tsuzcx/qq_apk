package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.sdk.platformtools.y;

final class BackupMoveQRCodeUI$3
  implements DialogInterface.OnClickListener
{
  BackupMoveQRCodeUI$3(BackupMoveQRCodeUI paramBackupMoveQRCodeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click move all.");
    BackupMoveQRCodeUI.c(this.hJr);
    b.atS().atU().ec(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.3
 * JD-Core Version:    0.7.0.1
 */