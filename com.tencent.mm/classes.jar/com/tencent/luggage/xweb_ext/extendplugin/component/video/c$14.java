package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

final class c$14
  implements Runnable
{
  c$14(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(177151);
    if ((this.cvH.cuX != null) && (!this.cvH.cuX.isPlaying())) {
      this.cvH.i(false, true);
    }
    AppMethodBeat.o(177151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.14
 * JD-Core Version:    0.7.0.1
 */