package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class IPCallPackageUI$4
  implements DialogInterface.OnClickListener
{
  IPCallPackageUI$4(IPCallPackageUI paramIPCallPackageUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = IPCallPackageUI.b(this.lxf);
    paramDialogInterface.lsh += 1;
    IPCallPackageUI.b(this.lxf).finish();
    paramDialogInterface = new Intent();
    paramDialogInterface.setClass(this.lxf.mController.uMN, IPCallRechargeUI.class);
    this.lxf.startActivity(paramDialogInterface);
    this.lxf.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.4
 * JD-Core Version:    0.7.0.1
 */