package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.sdk.platformtools.y;

final class BackupMoveQRCodeUI$2
  implements DialogInterface.OnClickListener
{
  BackupMoveQRCodeUI$2(BackupMoveQRCodeUI paramBackupMoveQRCodeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
    b.atS().atT().stop();
    b.atS().atU().cancel(true);
    b.atS().atn().hFu = -100;
    BackupMoveQRCodeUI.b(this.hJr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.2
 * JD-Core Version:    0.7.0.1
 */