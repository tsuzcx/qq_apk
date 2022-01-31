package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class QrcodeInvoiceUI$2
  implements MenuItem.OnMenuItemClickListener
{
  QrcodeInvoiceUI$2(QrcodeInvoiceUI paramQrcodeInvoiceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.fvl, AddInvoiceUI.class);
    paramMenuItem.putExtra("invoice_id", QrcodeInvoiceUI.a(this.fvl));
    this.fvl.startActivity(paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.2
 * JD-Core Version:    0.7.0.1
 */