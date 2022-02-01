package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class c$24
  implements Runnable
{
  c$24(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(215689);
    Log.i(this.cJF.getLogTag(), "video pause, abandonFocus");
    this.cJF.cEM.bJJ();
    AppMethodBeat.o(215689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.24
 * JD-Core Version:    0.7.0.1
 */