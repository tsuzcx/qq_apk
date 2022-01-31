package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallShareCouponCardUI$10
  implements DialogInterface.OnClickListener
{
  IPCallShareCouponCardUI$10(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22292);
    this.nVC.finish();
    AppMethodBeat.o(22292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.10
 * JD-Core Version:    0.7.0.1
 */