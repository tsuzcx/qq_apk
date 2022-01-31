package com.tencent.mm.plugin.appbrand.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.n.b;

final class d$1
  implements View.OnClickListener
{
  d$1(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126727);
    d locald = this.jsC;
    if (d.c(this.jsC) == null) {}
    for (paramView = null;; paramView = d.c(this.jsC).aEr())
    {
      d.a(locald, true, paramView);
      AppMethodBeat.o(126727);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.d.1
 * JD-Core Version:    0.7.0.1
 */