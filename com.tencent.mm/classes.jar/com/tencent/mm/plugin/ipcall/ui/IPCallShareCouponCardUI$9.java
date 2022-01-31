package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class IPCallShareCouponCardUI$9
  implements DialogInterface.OnCancelListener
{
  IPCallShareCouponCardUI$9(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    try
    {
      this.lyq.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.IPCallShareCouponCardUI", "loadFromSystemAddressBook error: %s", new Object[] { paramDialogInterface.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.9
 * JD-Core Version:    0.7.0.1
 */