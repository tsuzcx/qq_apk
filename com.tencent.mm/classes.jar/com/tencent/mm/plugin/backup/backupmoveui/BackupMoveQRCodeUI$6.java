package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class BackupMoveQRCodeUI$6
  implements DialogInterface.OnClickListener
{
  BackupMoveQRCodeUI$6(BackupMoveQRCodeUI paramBackupMoveQRCodeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click cancel.");
    BackupMoveQRCodeUI.d(this.hJr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.6
 * JD-Core Version:    0.7.0.1
 */