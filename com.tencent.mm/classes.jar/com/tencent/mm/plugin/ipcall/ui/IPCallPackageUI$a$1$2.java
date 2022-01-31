package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.f;

final class IPCallPackageUI$a$1$2
  implements DialogInterface.OnClickListener
{
  IPCallPackageUI$a$1$2(IPCallPackageUI.a.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(this.lxj.lxh));
    paramDialogInterface.lsd += 1;
    IPCallPackageUI.b(IPCallPackageUI.a.a(this.lxj.lxh)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a.1.2
 * JD-Core Version:    0.7.0.1
 */