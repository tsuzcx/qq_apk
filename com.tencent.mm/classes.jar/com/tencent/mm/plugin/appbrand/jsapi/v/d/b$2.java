package com.tencent.mm.plugin.appbrand.jsapi.v.d;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$2
  implements ap.a
{
  b$2(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(117366);
    if (this.iiP.iiL > 0)
    {
      if ((this.iiP.iiM != null) && (this.iiP.iiM.isPlaying()))
      {
        this.iiP.aGv();
        AppMethodBeat.o(117366);
        return false;
      }
      AppMethodBeat.o(117366);
      return true;
    }
    AppMethodBeat.o(117366);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d.b.2
 * JD-Core Version:    0.7.0.1
 */