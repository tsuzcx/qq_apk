package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;

final class IPCallMyGiftCardUI$3
  implements DialogInterface.OnCancelListener
{
  IPCallMyGiftCardUI$3(IPCallMyGiftCardUI paramIPCallMyGiftCardUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    try
    {
      if (IPCallMyGiftCardUI.a(this.lwO) != null) {
        au.Dk().c(IPCallMyGiftCardUI.a(this.lwO));
      }
      this.lwO.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", new Object[] { paramDialogInterface.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.3
 * JD-Core Version:    0.7.0.1
 */