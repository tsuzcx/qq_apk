package com.tencent.mm.plugin.address.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AddInvoiceUI$2
  implements View.OnTouchListener
{
  AddInvoiceUI$2(AddInvoiceUI paramAddInvoiceUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(16788);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(16788);
      return true;
    }
    if (paramMotionEvent.getAction() != 1)
    {
      AppMethodBeat.o(16788);
      return false;
    }
    if (!AddInvoiceUI.b(this.gLE).isActivated()) {
      AddInvoiceUI.b(this.gLE).setActivated(true);
    }
    if (AddInvoiceUI.b(this.gLE).isActivated())
    {
      AddInvoiceUI.a(this.gLE).setActivated(false);
      AddInvoiceUI.c(this.gLE).type = "1";
    }
    AddInvoiceUI.d(this.gLE);
    AppMethodBeat.o(16788);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI.2
 * JD-Core Version:    0.7.0.1
 */