package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class IPCallShareCouponUI$4
  implements DialogInterface.OnCancelListener
{
  IPCallShareCouponUI$4(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(22320);
    try
    {
      this.nWj.finish();
      AppMethodBeat.o(22320);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", new Object[] { paramDialogInterface.getMessage() });
      AppMethodBeat.o(22320);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.4
 * JD-Core Version:    0.7.0.1
 */