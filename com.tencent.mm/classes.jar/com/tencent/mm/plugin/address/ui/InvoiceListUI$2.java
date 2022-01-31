package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class InvoiceListUI$2
  implements AdapterView.OnItemClickListener
{
  InvoiceListUI$2(InvoiceListUI paramInvoiceListUI) {}
  
  public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
  {
    y.d("MicroMsg.InvoiceListUI", "select pos " + paramInt);
    synchronized (InvoiceListUI.b(this.fuL))
    {
      if (paramInt < InvoiceListUI.c(this.fuL).size())
      {
        InvoiceListUI.a(this.fuL, (b)InvoiceListUI.c(this.fuL).get(paramInt));
        if ((InvoiceListUI.d(this.fuL)) || (InvoiceListUI.e(this.fuL) == null)) {
          break label117;
        }
        InvoiceListUI.a(this.fuL, InvoiceListUI.e(this.fuL).lnP);
      }
      label117:
      while ((InvoiceListUI.e(this.fuL) == null) || (InvoiceListUI.e(this.fuL).lnP == 0))
      {
        InvoiceListUI.f(this.fuL).notifyDataSetChanged();
        return;
      }
      paramView = new Intent();
      paramView.putExtra("choose_invoice_title_info", e.a(InvoiceListUI.e(this.fuL)));
      this.fuL.setResult(-1, paramView);
      this.fuL.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.2
 * JD-Core Version:    0.7.0.1
 */