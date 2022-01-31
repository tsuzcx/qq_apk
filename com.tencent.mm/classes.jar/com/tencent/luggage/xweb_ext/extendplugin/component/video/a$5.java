package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(154415);
    if ((this.bHR.bHu != null) && (this.bHR.bHG) && (this.bHR.bHD))
    {
      ab.i(this.bHR.xo(), "handleWebViewForeground runnable, video playing when enter background");
      this.bHR.bHD = false;
      this.bHR.play();
    }
    AppMethodBeat.o(154415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.5
 * JD-Core Version:    0.7.0.1
 */