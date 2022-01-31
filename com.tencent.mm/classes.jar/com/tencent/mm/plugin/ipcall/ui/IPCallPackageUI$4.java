package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.e.f;

final class IPCallPackageUI$4
  implements DialogInterface.OnClickListener
{
  IPCallPackageUI$4(IPCallPackageUI paramIPCallPackageUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22222);
    paramDialogInterface = IPCallPackageUI.b(this.nUs);
    paramDialogInterface.nPC += 1;
    IPCallPackageUI.b(this.nUs).finish();
    paramDialogInterface = new Intent();
    paramDialogInterface.setClass(this.nUs.getContext(), IPCallRechargeUI.class);
    this.nUs.startActivity(paramDialogInterface);
    this.nUs.finish();
    AppMethodBeat.o(22222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.4
 * JD-Core Version:    0.7.0.1
 */