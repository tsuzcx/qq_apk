package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.g;
import com.tencent.mm.sdk.platformtools.Log;

final class a$5
  implements g
{
  a$5(a parama) {}
  
  public final void notifyLongTask(long paramLong)
  {
    AppMethodBeat.i(169500);
    Log.d("Luggage.AbstractMPPageViewRenderer", "notifyLongTask :%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(169500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.5
 * JD-Core Version:    0.7.0.1
 */