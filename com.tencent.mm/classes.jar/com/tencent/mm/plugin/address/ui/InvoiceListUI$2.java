package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class InvoiceListUI$2
  implements AdapterView.OnItemClickListener
{
  InvoiceListUI$2(InvoiceListUI paramInvoiceListUI) {}
  
  public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(16858);
    ab.d("MicroMsg.InvoiceListUI", "select pos ".concat(String.valueOf(paramInt)));
    synchronized (InvoiceListUI.b(this.gMn))
    {
      if (paramInt < InvoiceListUI.c(this.gMn).size())
      {
        InvoiceListUI.a(this.gMn, (b)InvoiceListUI.c(this.gMn).get(paramInt));
        if ((InvoiceListUI.d(this.gMn)) || (InvoiceListUI.e(this.gMn) == null)) {
          break label122;
        }
        InvoiceListUI.a(this.gMn, InvoiceListUI.e(this.gMn).nLm);
      }
      label122:
      while ((InvoiceListUI.e(this.gMn) == null) || (InvoiceListUI.e(this.gMn).nLm == 0))
      {
        InvoiceListUI.f(this.gMn).notifyDataSetChanged();
        AppMethodBeat.o(16858);
        return;
      }
      paramView = new Intent();
      paramView.putExtra("choose_invoice_title_info", e.a(InvoiceListUI.e(this.gMn)));
      this.gMn.setResult(-1, paramView);
      this.gMn.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.2
 * JD-Core Version:    0.7.0.1
 */