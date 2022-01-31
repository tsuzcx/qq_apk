package com.tencent.mm.plugin.address.ui;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class InvoiceQrcodeTextView$1$2
  implements n.d
{
  InvoiceQrcodeTextView$1$2(InvoiceQrcodeTextView.1 param1, ClipboardManager paramClipboardManager, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(16882);
    if (paramInt == 0)
    {
      this.gMy.setText(this.ehq.getText().toString());
      h.bN(this.ehq.getContext(), this.ehq.getContext().getString(2131296896));
    }
    AppMethodBeat.o(16882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.1.2
 * JD-Core Version:    0.7.0.1
 */