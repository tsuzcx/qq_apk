package com.tencent.mm.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PermissionWarningDialog$2
  implements DialogInterface.OnClickListener
{
  PermissionWarningDialog$2(PermissionWarningDialog paramPermissionWarningDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16647);
    this.giR.finish();
    AppMethodBeat.o(16647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.permission.PermissionWarningDialog.2
 * JD-Core Version:    0.7.0.1
 */