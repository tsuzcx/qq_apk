package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e;
import com.tencent.mm.sdk.platformtools.ab;

final class w$1
  implements Runnable
{
  w$1(w paramw) {}
  
  public final void run()
  {
    AppMethodBeat.i(123767);
    if ((w.a(this.jnq) == null) || (!t.aw(w.a(this.jnq))))
    {
      AppMethodBeat.o(123767);
      return;
    }
    if (w.b(this.jnq).aRh())
    {
      ab.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
      this.jnq.post(this);
      AppMethodBeat.o(123767);
      return;
    }
    w.c(this.jnq);
    AppMethodBeat.o(123767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w.1
 * JD-Core Version:    0.7.0.1
 */