package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import java.lang.ref.WeakReference;

final class e$1
  implements Runnable
{
  e$1(e parame, WeakReference paramWeakReference, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(123540);
    v localv = (v)this.hMF.get();
    if (localv == null)
    {
      AppMethodBeat.o(123540);
      return;
    }
    if (localv.aJl() != null) {
      localv.aJl().hideVKB();
    }
    if (o.b(localv, this.hMH)) {}
    for (String str = "ok";; str = "fail")
    {
      localv.h(this.bAX, this.hMI.j(str, null));
      AppMethodBeat.o(123540);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.e.1
 * JD-Core Version:    0.7.0.1
 */