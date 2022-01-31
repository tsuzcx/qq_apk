package com.tencent.mm.plugin.appbrand.page;

import android.support.v4.view.t;
import android.view.ViewGroup;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class av$1
  implements Runnable
{
  av$1(av paramav) {}
  
  public final void run()
  {
    AppMethodBeat.i(140887);
    ViewGroup localViewGroup = this.izr.iux;
    if (t.aw(localViewGroup)) {
      ((c)av.a(this.izr)).post(new av.1.1(this, localViewGroup));
    }
    AppMethodBeat.o(140887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av.1
 * JD-Core Version:    0.7.0.1
 */