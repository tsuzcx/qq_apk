package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class IPCallShareCouponCardUI$9
  implements DialogInterface.OnCancelListener
{
  IPCallShareCouponCardUI$9(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(25911);
    try
    {
      this.yya.finish();
      AppMethodBeat.o(25911);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Log.e("MicroMsg.IPCallShareCouponCardUI", "loadFromSystemAddressBook error: %s", new Object[] { paramDialogInterface.getMessage() });
      AppMethodBeat.o(25911);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.9
 * JD-Core Version:    0.7.0.1
 */