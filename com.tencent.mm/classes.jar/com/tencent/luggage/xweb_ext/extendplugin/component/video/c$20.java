package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$20
  implements Runnable
{
  c$20(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(215686);
    if ((this.cJF.cIV != null) && (!this.cJF.cIV.isPlaying())) {
      this.cJF.i(false, true);
    }
    AppMethodBeat.o(215686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.20
 * JD-Core Version:    0.7.0.1
 */