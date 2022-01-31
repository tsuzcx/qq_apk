package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements PopupWindow.OnDismissListener
{
  a$1(a parama) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(123872);
    if ((a.a(this.joP) != null) && (!a.b(this.joP))) {
      a.a(this.joP).a("", h.a.jpy);
    }
    AppMethodBeat.o(123872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.a.1
 * JD-Core Version:    0.7.0.1
 */