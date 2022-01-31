package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bk;

final class InvoiceQrcodeTextView$1
  implements View.OnClickListener
{
  InvoiceQrcodeTextView$1(InvoiceQrcodeTextView paramInvoiceQrcodeTextView) {}
  
  public final void onClick(View paramView)
  {
    if ((InvoiceQrcodeTextView.a(this.fuU).getVisibility() == 0) && (this.fuU.fun) && (InvoiceQrcodeTextView.b(this.fuU) != 2) && (!bk.bl(this.fuU.getText())))
    {
      this.fuU.fuT.setText("");
      InvoiceQrcodeTextView.a(this.fuU, InvoiceQrcodeTextView.c(this.fuU).isFocused());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.1
 * JD-Core Version:    0.7.0.1
 */