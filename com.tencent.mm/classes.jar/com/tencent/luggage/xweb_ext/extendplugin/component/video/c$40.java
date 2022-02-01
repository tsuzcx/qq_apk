package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$40
  implements n
{
  c$40(c paramc) {}
  
  public final void pause()
  {
    AppMethodBeat.i(215712);
    Log.i(this.cJF.getLogTag(), "pause");
    this.cJF.Qs();
    AppMethodBeat.o(215712);
  }
  
  public final void start()
  {
    AppMethodBeat.i(215711);
    Log.i(this.cJF.getLogTag(), "start");
    this.cJF.PU();
    AppMethodBeat.o(215711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.40
 * JD-Core Version:    0.7.0.1
 */