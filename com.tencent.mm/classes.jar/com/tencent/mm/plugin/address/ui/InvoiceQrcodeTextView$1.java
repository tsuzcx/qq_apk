package com.tencent.mm.plugin.address.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class InvoiceQrcodeTextView$1
  implements View.OnTouchListener
{
  InvoiceQrcodeTextView$1(InvoiceQrcodeTextView paramInvoiceQrcodeTextView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(231575);
    InvoiceQrcodeTextView.a(this.kux, (int)paramMotionEvent.getRawX());
    InvoiceQrcodeTextView.b(this.kux, (int)paramMotionEvent.getRawY());
    AppMethodBeat.o(231575);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.1
 * JD-Core Version:    0.7.0.1
 */