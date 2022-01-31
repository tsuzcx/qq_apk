package com.tencent.mm.plugin.address.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

final class AddInvoiceUI$2
  implements View.OnTouchListener
{
  AddInvoiceUI$2(AddInvoiceUI paramAddInvoiceUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      return true;
    }
    if (paramMotionEvent.getAction() != 1) {
      return false;
    }
    if (!AddInvoiceUI.b(this.fuc).isActivated()) {
      AddInvoiceUI.b(this.fuc).setActivated(true);
    }
    if (AddInvoiceUI.b(this.fuc).isActivated())
    {
      AddInvoiceUI.a(this.fuc).setActivated(false);
      AddInvoiceUI.c(this.fuc).type = "1";
    }
    AddInvoiceUI.d(this.fuc);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI.2
 * JD-Core Version:    0.7.0.1
 */