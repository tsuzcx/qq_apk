package com.tencent.mm.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PermissionWarningDialog$1
  implements DialogInterface.OnCancelListener
{
  PermissionWarningDialog$1(PermissionWarningDialog paramPermissionWarningDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(16646);
    this.giR.finish();
    AppMethodBeat.o(16646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.permission.PermissionWarningDialog.1
 * JD-Core Version:    0.7.0.1
 */