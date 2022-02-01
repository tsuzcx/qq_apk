package com.tencent.mm.plugin.address.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class InvoiceQrcodeTextView$1
  implements View.OnTouchListener
{
  InvoiceQrcodeTextView$1(InvoiceQrcodeTextView paramInvoiceQrcodeTextView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186389);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    InvoiceQrcodeTextView.a(this.jwj, (int)paramMotionEvent.getRawX());
    InvoiceQrcodeTextView.b(this.jwj, (int)paramMotionEvent.getRawY());
    a.a(false, this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(186389);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.1
 * JD-Core Version:    0.7.0.1
 */