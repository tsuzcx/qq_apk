package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AddInvoiceUI$5
  implements DialogInterface.OnClickListener
{
  AddInvoiceUI$5(AddInvoiceUI paramAddInvoiceUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16791);
    this.gLE.setResult(0);
    this.gLE.finish();
    AppMethodBeat.o(16791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI.5
 * JD-Core Version:    0.7.0.1
 */