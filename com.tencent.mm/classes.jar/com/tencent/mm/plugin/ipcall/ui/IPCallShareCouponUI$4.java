package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class IPCallShareCouponUI$4
  implements DialogInterface.OnCancelListener
{
  IPCallShareCouponUI$4(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    try
    {
      this.lyX.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", new Object[] { paramDialogInterface.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.4
 * JD-Core Version:    0.7.0.1
 */