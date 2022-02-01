package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class c$10
  implements Runnable
{
  c$10(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(138956);
    c localc = this.cvH;
    ae.i(localc.getLogTag(), "*** handler(%s) handleWebViewDestroy", new Object[] { localc.BN() });
    localc.release();
    AppMethodBeat.o(138956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.10
 * JD-Core Version:    0.7.0.1
 */