package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$14
  implements Runnable
{
  c$14(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(177151);
    c localc = this.cJF;
    Log.i(localc.getLogTag(), "*** handler(%s) handleWebViewDestroy", new Object[] { localc.Lb() });
    localc.release();
    AppMethodBeat.o(177151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.14
 * JD-Core Version:    0.7.0.1
 */