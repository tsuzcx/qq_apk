package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;

final class IPCallRechargeUI$8
  implements DialogInterface.OnCancelListener
{
  IPCallRechargeUI$8(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    try
    {
      if (this.lxJ.lxI != null) {
        au.Dk().c(this.lxJ.lxI);
      }
      this.lxJ.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", new Object[] { paramDialogInterface.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.8
 * JD-Core Version:    0.7.0.1
 */