package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class InvoiceListUI$6
  implements DialogInterface.OnClickListener
{
  InvoiceListUI$6(InvoiceListUI paramInvoiceListUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.6
 * JD-Core Version:    0.7.0.1
 */