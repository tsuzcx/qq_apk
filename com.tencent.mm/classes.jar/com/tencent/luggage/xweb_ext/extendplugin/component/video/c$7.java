package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class c$7
  implements Runnable
{
  c$7(c paramc, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(138953);
    if ((this.cvH.cuX != null) && (this.cvH.cvl) && (this.cvK))
    {
      ae.i(this.cvH.getLogTag(), "handleWebViewForeground runnable, video playing when enter background");
      this.cvH.i(false, false);
    }
    AppMethodBeat.o(138953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.7
 * JD-Core Version:    0.7.0.1
 */