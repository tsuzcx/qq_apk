package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements b.a
{
  a$3(a parama) {}
  
  public final void fC(int paramInt)
  {
    AppMethodBeat.i(154411);
    a locala = this.bHR;
    if (!locala.bHH)
    {
      ab.i(locala.xo(), "onMediaPlayerBufferingUpdate, mp released");
      AppMethodBeat.o(154411);
      return;
    }
    if (paramInt != locala.bHL)
    {
      locala.bHL = paramInt;
      ab.i(locala.xo(), "onBufferingUpdate, percent:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    if ((locala.xt()) && (locala.bHG)) {
      locala.bHv.fD(paramInt);
    }
    AppMethodBeat.o(154411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.3
 * JD-Core Version:    0.7.0.1
 */