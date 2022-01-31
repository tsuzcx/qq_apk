package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$10
  implements b.b
{
  a$10(a parama) {}
  
  public final void xK()
  {
    AppMethodBeat.i(154419);
    a locala = this.bHR;
    if (!locala.bHH)
    {
      ab.i(locala.xo(), "onMediaPlayerCompletion, mp released");
      AppMethodBeat.o(154419);
      return;
    }
    ab.i(locala.xo(), "onCompletion");
    if (locala.xt()) {
      locala.bHv.xT();
    }
    if (locala.bHI)
    {
      ab.i(locala.xo(), "onCompletion, video loop playing");
      locala.bHA = true;
      locala.seek(0L);
      AppMethodBeat.o(154419);
      return;
    }
    ab.i(locala.xo(), "onCompletion, video end playing");
    locala.bHO = true;
    AppMethodBeat.o(154419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.10
 * JD-Core Version:    0.7.0.1
 */