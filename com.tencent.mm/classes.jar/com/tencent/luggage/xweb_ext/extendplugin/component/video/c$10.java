package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$10
  implements Runnable
{
  c$10(c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(138956);
    c localc = this.cJF;
    int i = this.val$type;
    Log.i(localc.getLogTag(), "*** handler(%s) handleWebViewBackground, type:%d", new Object[] { localc.Lb(), Integer.valueOf(i) });
    localc.cJs = true;
    c.11 local11 = new c.11(localc, i);
    h.RTc.aV(new c.13(localc));
    local11.run();
    AppMethodBeat.o(138956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.10
 * JD-Core Version:    0.7.0.1
 */