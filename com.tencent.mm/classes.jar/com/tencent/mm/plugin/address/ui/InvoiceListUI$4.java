package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class InvoiceListUI$4
  implements MenuItem.OnMenuItemClickListener
{
  InvoiceListUI$4(InvoiceListUI paramInvoiceListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(16861);
    this.gMn.setResult(0);
    this.gMn.finish();
    AppMethodBeat.o(16861);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.4
 * JD-Core Version:    0.7.0.1
 */