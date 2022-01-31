package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.pointers.PBool;
import java.lang.ref.WeakReference;

final class i$3
  implements Runnable
{
  i$3(i parami, PBool paramPBool) {}
  
  public final void run()
  {
    AppMethodBeat.i(141603);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
    this.jlx.value = true;
    if (this.jlw.jlj == null) {}
    for (v localv = null; (localv == null) || (this.jlw.jll == null); localv = (v)this.jlw.jlj.get())
    {
      AppMethodBeat.o(141603);
      return;
    }
    if (o.s(localv) != this.jlw)
    {
      AppMethodBeat.o(141603);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
    h.aQF().c(localv.iuy);
    aj.cW(this.jlw.jll);
    if ((this.jlw.jlm != null) && (this.jlw.jlm.b(null))) {
      this.jlw.jlm.hide();
    }
    this.jlw.jll.a(this.jlw.jle);
    this.jlw.jll.setFocusable(true);
    this.jlw.jll.setFocusableInTouchMode(true);
    this.jlw.jlm.jnn = this.jlw.jll;
    this.jlw.jll.requestFocus();
    aj.cW(this.jlw.jll);
    if (this.jlw.jlm != null) {
      this.jlw.jlm.show();
    }
    AppMethodBeat.o(141603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.3
 * JD-Core Version:    0.7.0.1
 */