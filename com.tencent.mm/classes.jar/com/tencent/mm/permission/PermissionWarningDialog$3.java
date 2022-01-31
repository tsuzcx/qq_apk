package com.tencent.mm.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PermissionWarningDialog$3
  implements DialogInterface.OnClickListener
{
  PermissionWarningDialog$3(PermissionWarningDialog paramPermissionWarningDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16648);
    this.giR.finish();
    AppMethodBeat.o(16648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.permission.PermissionWarningDialog.3
 * JD-Core Version:    0.7.0.1
 */