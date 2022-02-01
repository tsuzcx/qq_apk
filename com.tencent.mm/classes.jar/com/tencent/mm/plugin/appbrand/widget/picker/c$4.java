package com.tencent.mm.plugin.appbrand.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$4
  implements View.OnClickListener
{
  c$4(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138044);
    c localc = this.miF;
    if (c.c(this.miF) == null) {}
    for (paramView = null;; paramView = c.c(this.miF).currentValue())
    {
      c.a(localc, true, paramView);
      AppMethodBeat.o(138044);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.c.4
 * JD-Core Version:    0.7.0.1
 */