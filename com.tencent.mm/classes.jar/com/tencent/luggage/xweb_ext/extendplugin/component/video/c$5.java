package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class c$5
  implements a.a
{
  c$5(c paramc) {}
  
  public final void gF(int paramInt)
  {
    AppMethodBeat.i(138950);
    ae.i(this.cvH.getLogTag(), "onBackground, type: ".concat(String.valueOf(paramInt)));
    c localc = this.cvH;
    localc.k(new c.8(localc, paramInt));
    AppMethodBeat.o(138950);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(138951);
    c localc = this.cvH;
    localc.k(new c.10(localc));
    AppMethodBeat.o(138951);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(138949);
    ae.i(this.cvH.getLogTag(), "onForeground");
    c localc = this.cvH;
    localc.k(new c.6(localc));
    AppMethodBeat.o(138949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.5
 * JD-Core Version:    0.7.0.1
 */