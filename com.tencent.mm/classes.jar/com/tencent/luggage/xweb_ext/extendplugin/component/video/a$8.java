package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$8
  implements b.c
{
  a$8(a parama) {}
  
  public final boolean bK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154417);
    a locala = this.bHR;
    if (!locala.bHH) {
      ab.i(locala.xo(), "onMediaPlayerError, mp released");
    }
    for (;;)
    {
      AppMethodBeat.o(154417);
      return false;
      ab.i(locala.xo(), "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (locala.bHw != null)
      {
        locala.bHw.bL(paramInt1, paramInt2);
        if (locala.bHx != null) {
          if (paramInt1 == -1024) {
            locala.bHx.at(-paramInt2);
          } else {
            locala.bHx.at(41L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.8
 * JD-Core Version:    0.7.0.1
 */