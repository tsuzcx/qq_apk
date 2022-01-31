package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class i$8
  implements w.e
{
  i$8(i parami) {}
  
  public final void fq(int paramInt)
  {
    AppMethodBeat.i(141608);
    ab.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 2)
    {
      if ((paramInt == 0) && (this.jlw.jll != null)) {
        this.jlw.jll.requestFocus();
      }
      i.g(this.jlw);
      if ((this.jlw.jlj != null) && (this.jlw.jlj.get() != null))
      {
        o.a((v)this.jlw.jlj.get(), this.jlw.jll);
        AppMethodBeat.o(141608);
      }
    }
    else
    {
      this.jlw.jlh = i.d.jlA;
      i.f(this.jlw);
      this.jlw.jlh = null;
    }
    AppMethodBeat.o(141608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.8
 * JD-Core Version:    0.7.0.1
 */