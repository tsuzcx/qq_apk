package com.tencent.mm.plugin.address.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class InvoiceListUI$3
  implements AdapterView.OnItemLongClickListener
{
  InvoiceListUI$3(InvoiceListUI paramInvoiceListUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(16860);
    paramAdapterView = this.gMn.getResources().getStringArray(2131755021);
    h.a(this.gMn.getContext(), null, paramAdapterView, null, new InvoiceListUI.3.1(this, paramInt));
    AppMethodBeat.o(16860);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.3
 * JD-Core Version:    0.7.0.1
 */