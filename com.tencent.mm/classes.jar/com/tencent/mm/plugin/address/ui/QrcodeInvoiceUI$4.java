package com.tencent.mm.plugin.address.ui;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class QrcodeInvoiceUI$4
  implements PopupWindow.OnDismissListener
{
  QrcodeInvoiceUI$4(QrcodeInvoiceUI paramQrcodeInvoiceUI) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(16915);
    QrcodeInvoiceUI.c(this.gMQ);
    AppMethodBeat.o(16915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.4
 * JD-Core Version:    0.7.0.1
 */