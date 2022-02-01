package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class c$25
  implements Runnable
{
  c$25(c paramc)
  {
    AppMethodBeat.i(178842);
    AppMethodBeat.o(178842);
  }
  
  public final void run()
  {
    AppMethodBeat.i(215690);
    Log.i(this.cJF.getLogTag(), "video stop, abandonFocus");
    this.cJF.cEM.bJJ();
    AppMethodBeat.o(215690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.25
 * JD-Core Version:    0.7.0.1
 */