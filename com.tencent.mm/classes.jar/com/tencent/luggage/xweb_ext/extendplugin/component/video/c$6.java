package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$6
  implements a.a
{
  c$6(c paramc) {}
  
  public final void hU(int paramInt)
  {
    AppMethodBeat.i(215681);
    Log.i(this.cJF.getLogTag(), "onBackground, type: ".concat(String.valueOf(paramInt)));
    c localc = this.cJF;
    localc.k(new c.10(localc, paramInt));
    AppMethodBeat.o(215681);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(215682);
    c localc = this.cJF;
    localc.k(new c.14(localc));
    AppMethodBeat.o(215682);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(215680);
    Log.i(this.cJF.getLogTag(), "onForeground");
    c localc = this.cJF;
    localc.k(new c.7(localc));
    AppMethodBeat.o(215680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.6
 * JD-Core Version:    0.7.0.1
 */