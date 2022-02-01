package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class c$8
  implements Runnable
{
  c$8(c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(138954);
    c localc = this.cvH;
    int i = this.val$type;
    ae.i(localc.getLogTag(), "*** handler(%s) handleWebViewBackground, type:%d", new Object[] { localc.BN(), Integer.valueOf(i) });
    localc.cvu = true;
    new c.9(localc, i).run();
    AppMethodBeat.o(138954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.8
 * JD-Core Version:    0.7.0.1
 */