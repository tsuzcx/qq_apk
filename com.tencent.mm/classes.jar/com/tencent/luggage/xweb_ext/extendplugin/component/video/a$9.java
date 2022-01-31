package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$9
  implements b.e
{
  a$9(a parama) {}
  
  public final void xJ()
  {
    int j = 0;
    AppMethodBeat.i(154418);
    a locala = this.bHR;
    if (!locala.bHH)
    {
      ab.i(locala.xo(), "onMediaPlayerPrepared, mp released");
      AppMethodBeat.o(154418);
      return;
    }
    ab.i(locala.xo(), "onPrepared");
    locala.bHG = true;
    locala.xB();
    if (locala.bHw != null) {
      locala.bHw.init();
    }
    c localc;
    if ((locala.xt()) && (locala.bHu != null))
    {
      localc = locala.bHv;
      if (locala.bHu == null) {
        break label213;
      }
    }
    label213:
    for (int i = locala.bHu.getVideoWidth();; i = 0)
    {
      if (locala.bHu != null) {
        j = locala.bHu.getVideoHeight();
      }
      localc.B(i, j, locala.getDuration());
      long l = locala.bHE;
      if (l > 0L)
      {
        locala.seek(l);
        locala.bHE = 0L;
      }
      if (locala.bHP) {
        break label234;
      }
      if (!locala.bHF) {
        break;
      }
      ab.i(locala.xo(), "onPrepared, start play when prepared");
      locala.play();
      AppMethodBeat.o(154418);
      return;
    }
    ab.i(locala.xo(), "onPrepared, not set start play when prepared");
    AppMethodBeat.o(154418);
    return;
    label234:
    ab.i(locala.xo(), "onPrepared, stop video auto play when webview in background");
    locala.bHD = locala.bHF;
    AppMethodBeat.o(154418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.9
 * JD-Core Version:    0.7.0.1
 */