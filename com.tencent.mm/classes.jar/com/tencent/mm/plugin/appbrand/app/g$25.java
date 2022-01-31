package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.appbrand.appcache.b.b.i;
import com.tencent.mm.plugin.appbrand.task.h;

final class g$25
  extends n.a
{
  g$25(g paramg) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(129274);
    h.onNetworkChange();
    i.gXO.awn();
    AppMethodBeat.o(129274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.g.25
 * JD-Core Version:    0.7.0.1
 */