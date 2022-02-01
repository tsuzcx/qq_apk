package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class c$9
  implements Runnable
{
  c$9(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(138955);
    Log.i(this.cJF.getLogTag(), "handleWebViewForeground, requestFocus");
    this.cJF.cEM.bJI();
    AppMethodBeat.o(138955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.9
 * JD-Core Version:    0.7.0.1
 */