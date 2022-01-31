package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.o;

final class h$1
  implements Runnable
{
  h$1(h paramh, v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void run()
  {
    AppMethodBeat.i(123545);
    if (o.a(this.hEe, this.hMH, this.hML, this.hMM))
    {
      this.hEe.h(this.bAX, this.hMN.j("ok", null));
      AppMethodBeat.o(123545);
      return;
    }
    this.hEe.h(this.bAX, this.hMN.j("fail:invalid data", null));
    AppMethodBeat.o(123545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.h.1
 * JD-Core Version:    0.7.0.1
 */