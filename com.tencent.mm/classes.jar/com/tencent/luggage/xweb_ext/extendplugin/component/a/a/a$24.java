package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class a$24
  implements Runnable
{
  a$24(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(138825);
    a locala = this.csS;
    ae.i(locala.getLogTag(), "*** handler(%s) handleWebViewDestroy", new Object[] { locala.BN() });
    locala.release();
    AppMethodBeat.o(138825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.24
 * JD-Core Version:    0.7.0.1
 */