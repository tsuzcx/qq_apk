package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class InvoiceListUI$6
  implements DialogInterface.OnClickListener
{
  InvoiceListUI$6(InvoiceListUI paramInvoiceListUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20906);
    ad.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
    paramDialogInterface.dismiss();
    AppMethodBeat.o(20906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.6
 * JD-Core Version:    0.7.0.1
 */