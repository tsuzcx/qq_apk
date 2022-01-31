package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;

final class QrcodeInvoiceUI$3
  implements View.OnClickListener
{
  QrcodeInvoiceUI$3(QrcodeInvoiceUI paramQrcodeInvoiceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(16914);
    if ((QrcodeInvoiceUI.b(this.gMQ) != null) && (QrcodeInvoiceUI.b(this.gMQ).isShowing())) {
      QrcodeInvoiceUI.b(this.gMQ).dismiss();
    }
    AppMethodBeat.o(16914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.3
 * JD-Core Version:    0.7.0.1
 */