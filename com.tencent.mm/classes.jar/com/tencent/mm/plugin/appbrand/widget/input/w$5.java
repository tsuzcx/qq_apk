package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class w$5
  implements Runnable
{
  w$5(w paramw, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(123772);
    int i = w.e(this.jnq);
    if (!this.jnq.isShown()) {
      w.a(this.jnq, 2);
    }
    while (w.f(this.jnq) == null)
    {
      AppMethodBeat.o(123772);
      return;
      w.a(this.jnq, this.jnr);
    }
    if ((i != w.e(this.jnq)) && (!this.jns)) {
      w.f(this.jnq).fq(w.e(this.jnq));
    }
    AppMethodBeat.o(123772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w.5
 * JD-Core Version:    0.7.0.1
 */