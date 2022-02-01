package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$6
  implements a.a
{
  c$6(c paramc) {}
  
  public final void my(int paramInt)
  {
    AppMethodBeat.i(221004);
    Log.i(this.eDU.getLogTag(), "onBackground, type: ".concat(String.valueOf(paramInt)));
    c localc = this.eDU;
    localc.o(new c.10(localc, paramInt));
    AppMethodBeat.o(221004);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(221008);
    c localc = this.eDU;
    localc.o(new c.14(localc));
    AppMethodBeat.o(221008);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(220998);
    Log.i(this.eDU.getLogTag(), "onForeground");
    c localc = this.eDU;
    localc.o(new c.7(localc));
    AppMethodBeat.o(220998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.6
 * JD-Core Version:    0.7.0.1
 */