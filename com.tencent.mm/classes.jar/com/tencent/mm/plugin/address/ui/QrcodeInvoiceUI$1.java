package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class QrcodeInvoiceUI$1
  implements MenuItem.OnMenuItemClickListener
{
  QrcodeInvoiceUI$1(QrcodeInvoiceUI paramQrcodeInvoiceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(20957);
    this.iAy.setResult(0);
    this.iAy.finish();
    AppMethodBeat.o(20957);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.1
 * JD-Core Version:    0.7.0.1
 */