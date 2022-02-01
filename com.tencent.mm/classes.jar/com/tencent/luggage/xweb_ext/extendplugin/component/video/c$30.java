package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class c$30
  implements n
{
  c$30(c paramc) {}
  
  public final void pause()
  {
    AppMethodBeat.i(220507);
    ae.i(this.cvH.getLogTag(), "pause");
    this.cvH.GA();
    AppMethodBeat.o(220507);
  }
  
  public final void start()
  {
    AppMethodBeat.i(220506);
    ae.i(this.cvH.getLogTag(), "start");
    this.cvH.Gl();
    AppMethodBeat.o(220506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.30
 * JD-Core Version:    0.7.0.1
 */