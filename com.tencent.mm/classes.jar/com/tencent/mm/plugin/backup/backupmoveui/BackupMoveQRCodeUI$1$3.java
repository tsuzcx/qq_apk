package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveQRCodeUI$1$3
  implements DialogInterface.OnClickListener
{
  BackupMoveQRCodeUI$1$3(BackupMoveQRCodeUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(17340);
    ab.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
    BackupMoveQRCodeUI.a(this.jCT.jCS, false);
    b.aTr().aTt().fz(true);
    AppMethodBeat.o(17340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.1.3
 * JD-Core Version:    0.7.0.1
 */