package com.tencent.mm.plugin.address.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.R.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class InvoiceListUI$3
  implements AdapterView.OnItemLongClickListener
{
  InvoiceListUI$3(InvoiceListUI paramInvoiceListUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.fuL.getResources().getStringArray(R.c.invoice_opt_list);
    h.a(this.fuL.mController.uMN, null, paramAdapterView, null, new InvoiceListUI.3.1(this, paramInt));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.3
 * JD-Core Version:    0.7.0.1
 */