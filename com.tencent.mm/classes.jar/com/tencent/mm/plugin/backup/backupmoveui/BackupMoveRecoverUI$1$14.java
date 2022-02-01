package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class BackupMoveRecoverUI$1$14
  implements DialogInterface.OnClickListener
{
  BackupMoveRecoverUI$1$14(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(21434);
    ae.i("MicroMsg.BackupMoveRecoverUI", "move phone old version");
    BackupMoveRecoverUI.h(this.nCr.nCq);
    AppMethodBeat.o(21434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.14
 * JD-Core Version:    0.7.0.1
 */