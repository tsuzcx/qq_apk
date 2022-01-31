package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveRecoverUI$1$14
  implements DialogInterface.OnClickListener
{
  BackupMoveRecoverUI$1$14(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(17376);
    ab.i("MicroMsg.BackupMoveRecoverUI", "move phone old version");
    BackupMoveRecoverUI.h(this.jDd.jDc);
    AppMethodBeat.o(17376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.14
 * JD-Core Version:    0.7.0.1
 */