package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$8
  implements Runnable
{
  c$8(c paramc, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(138954);
    if ((this.cJF.cIV != null) && (this.cJF.cJj) && (this.cJI))
    {
      Log.i(this.cJF.getLogTag(), "handleWebViewForeground runnable, video playing when enter background");
      this.cJF.i(false, false);
    }
    AppMethodBeat.o(138954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.8
 * JD-Core Version:    0.7.0.1
 */