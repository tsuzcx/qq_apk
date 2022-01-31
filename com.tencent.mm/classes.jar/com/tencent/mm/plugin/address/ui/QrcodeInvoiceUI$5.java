package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.base.o;

final class QrcodeInvoiceUI$5
  implements View.OnClickListener
{
  QrcodeInvoiceUI$5(QrcodeInvoiceUI paramQrcodeInvoiceUI) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getId() == R.h.invoice_popup_qrcode_iv) && (QrcodeInvoiceUI.b(this.fvl) != null) && (QrcodeInvoiceUI.b(this.fvl).isShowing())) {
      QrcodeInvoiceUI.b(this.fvl).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.5
 * JD-Core Version:    0.7.0.1
 */