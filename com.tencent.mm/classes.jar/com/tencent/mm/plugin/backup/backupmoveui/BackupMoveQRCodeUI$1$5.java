package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveQRCodeUI$1$5
  implements DialogInterface.OnClickListener
{
  BackupMoveQRCodeUI$1$5(BackupMoveQRCodeUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(17342);
    ab.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
    AppMethodBeat.o(17342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.1.5
 * JD-Core Version:    0.7.0.1
 */