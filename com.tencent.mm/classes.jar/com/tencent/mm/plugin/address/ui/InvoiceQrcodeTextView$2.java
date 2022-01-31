package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class InvoiceQrcodeTextView$2
  implements View.OnClickListener
{
  InvoiceQrcodeTextView$2(InvoiceQrcodeTextView paramInvoiceQrcodeTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(16885);
    if (InvoiceQrcodeTextView.a(this.gMw).getVisibility() == 0)
    {
      if ((this.gMw.gLP) && (InvoiceQrcodeTextView.b(this.gMw) != 2) && (!bo.isNullOrNil(this.gMw.getText())))
      {
        this.gMw.gMv.setText("");
        InvoiceQrcodeTextView.a(this.gMw, InvoiceQrcodeTextView.c(this.gMw).isFocused());
        AppMethodBeat.o(16885);
        return;
      }
      if (InvoiceQrcodeTextView.d(this.gMw) != null) {
        InvoiceQrcodeTextView.d(this.gMw);
      }
    }
    AppMethodBeat.o(16885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.2
 * JD-Core Version:    0.7.0.1
 */