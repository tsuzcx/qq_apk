package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveQRCodeUI$3
  implements DialogInterface.OnClickListener
{
  BackupMoveQRCodeUI$3(BackupMoveQRCodeUI paramBackupMoveQRCodeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(17347);
    ab.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
    b.aTr().aTs().stop();
    b.aTr().aTt().cancel(true);
    b.aTr().aSL().jyN = -100;
    BackupMoveQRCodeUI.g(this.jCS);
    AppMethodBeat.o(17347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.3
 * JD-Core Version:    0.7.0.1
 */