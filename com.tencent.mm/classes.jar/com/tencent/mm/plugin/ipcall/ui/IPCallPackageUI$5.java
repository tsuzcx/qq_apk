package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.e.f;

final class IPCallPackageUI$5
  implements DialogInterface.OnClickListener
{
  IPCallPackageUI$5(IPCallPackageUI paramIPCallPackageUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22223);
    paramDialogInterface = IPCallPackageUI.b(this.nUs);
    paramDialogInterface.nPD += 1;
    IPCallPackageUI.b(this.nUs).finish();
    AppMethodBeat.o(22223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.5
 * JD-Core Version:    0.7.0.1
 */