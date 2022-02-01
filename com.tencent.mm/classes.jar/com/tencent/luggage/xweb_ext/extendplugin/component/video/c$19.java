package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class c$19
  implements Runnable
{
  c$19(c paramc, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(215685);
    if (this.cJJ)
    {
      Log.i(this.cJF.getLogTag(), "video muted, abandonFocus");
      this.cJF.cEM.bJJ();
      AppMethodBeat.o(215685);
      return;
    }
    Log.i(this.cJF.getLogTag(), "video unmuted, requestFocus");
    this.cJF.cEM.bJI();
    AppMethodBeat.o(215685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.19
 * JD-Core Version:    0.7.0.1
 */