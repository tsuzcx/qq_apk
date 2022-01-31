package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class QrcodeInvoiceUI$2
  implements MenuItem.OnMenuItemClickListener
{
  QrcodeInvoiceUI$2(QrcodeInvoiceUI paramQrcodeInvoiceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(16913);
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.gMQ, AddInvoiceUI.class);
    paramMenuItem.putExtra("invoice_id", QrcodeInvoiceUI.a(this.gMQ));
    this.gMQ.startActivity(paramMenuItem);
    AppMethodBeat.o(16913);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.2
 * JD-Core Version:    0.7.0.1
 */