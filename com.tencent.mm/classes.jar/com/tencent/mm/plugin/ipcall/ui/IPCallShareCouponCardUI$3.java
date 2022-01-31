package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class IPCallShareCouponCardUI$3
  implements DialogInterface.OnClickListener
{
  IPCallShareCouponCardUI$3(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22284);
    d.b(this.nVC.getContext(), "account", ".ui.FacebookAuthUI", new Intent());
    AppMethodBeat.o(22284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.3
 * JD-Core Version:    0.7.0.1
 */