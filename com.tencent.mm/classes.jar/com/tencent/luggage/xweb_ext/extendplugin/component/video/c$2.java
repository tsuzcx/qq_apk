package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(138946);
    Log.i(this.cJF.getLogTag(), "onCompletion, abandonFocus");
    this.cJF.cEM.bJJ();
    AppMethodBeat.o(138946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.2
 * JD-Core Version:    0.7.0.1
 */