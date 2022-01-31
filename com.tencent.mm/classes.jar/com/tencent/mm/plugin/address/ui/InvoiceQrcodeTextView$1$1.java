package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class InvoiceQrcodeTextView$1$1
  implements View.OnCreateContextMenuListener
{
  InvoiceQrcodeTextView$1$1(InvoiceQrcodeTextView.1 param1, TextView paramTextView) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(16881);
    paramContextMenu.add(this.ehq.getContext().getString(2131296895));
    AppMethodBeat.o(16881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.1.1
 * JD-Core Version:    0.7.0.1
 */