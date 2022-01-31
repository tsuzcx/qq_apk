package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.f;

final class IPCallPackageUI$5
  implements DialogInterface.OnClickListener
{
  IPCallPackageUI$5(IPCallPackageUI paramIPCallPackageUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = IPCallPackageUI.b(this.lxf);
    paramDialogInterface.lsi += 1;
    IPCallPackageUI.b(this.lxf).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.5
 * JD-Core Version:    0.7.0.1
 */