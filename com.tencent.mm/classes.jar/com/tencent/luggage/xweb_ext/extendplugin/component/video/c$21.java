package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class c$21
  implements Runnable
{
  c$21(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(215687);
    Log.i(this.cJF.getLogTag(), "video play, requestFocus");
    this.cJF.cEM.bJI();
    AppMethodBeat.o(215687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.21
 * JD-Core Version:    0.7.0.1
 */