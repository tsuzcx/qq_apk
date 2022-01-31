package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class QrcodeInvoiceUI$6
  implements View.OnClickListener
{
  QrcodeInvoiceUI$6(QrcodeInvoiceUI paramQrcodeInvoiceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(16917);
    if ((paramView.getId() == 2131826275) && (QrcodeInvoiceUI.b(this.gMQ) != null))
    {
      this.gMQ.showPopupWindow(paramView);
      QrcodeInvoiceUI.d(this.gMQ);
    }
    AppMethodBeat.o(16917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.6
 * JD-Core Version:    0.7.0.1
 */