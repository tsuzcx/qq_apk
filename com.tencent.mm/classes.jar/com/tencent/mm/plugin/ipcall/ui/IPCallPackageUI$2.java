package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;

final class IPCallPackageUI$2
  implements DialogInterface.OnCancelListener
{
  IPCallPackageUI$2(IPCallPackageUI paramIPCallPackageUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    try
    {
      if (IPCallPackageUI.a(this.lxf) != null) {
        au.Dk().c(IPCallPackageUI.a(this.lxf));
      }
      this.lxf.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", new Object[] { paramDialogInterface.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.2
 * JD-Core Version:    0.7.0.1
 */