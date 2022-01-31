package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.h;

final class QrcodeInvoiceUI$6
  implements View.OnClickListener
{
  QrcodeInvoiceUI$6(QrcodeInvoiceUI paramQrcodeInvoiceUI) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getId() == R.h.invoice_qrcode_bar_area) && (QrcodeInvoiceUI.b(this.fvl) != null))
    {
      this.fvl.showPopupWindow(paramView);
      QrcodeInvoiceUI.d(this.fvl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.6
 * JD-Core Version:    0.7.0.1
 */