package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$7
  implements b.d
{
  a$7(a parama) {}
  
  public final boolean bJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154416);
    a locala = this.bHR;
    if (!locala.bHH) {
      ab.i(locala.xo(), "onMediaPlayerInfo, mp released");
    }
    for (;;)
    {
      AppMethodBeat.o(154416);
      return false;
      ab.i(locala.xo(), "onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 701)
      {
        locala.bHC = locala.bHu.isPlaying();
        ab.i(locala.xo(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(locala.bHC) });
        if (locala.xt()) {
          locala.bHv.onVideoWaiting();
        }
      }
      else if (paramInt1 == 702)
      {
        boolean bool = locala.bHu.isPlaying();
        ab.i(locala.xo(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying", new Object[] { Boolean.valueOf(locala.bHC), Boolean.valueOf(bool) });
        if (locala.bHC)
        {
          locala.bHC = false;
          if ((bool) && (locala.xt()))
          {
            ab.i(locala.xo(), "onInfo, buffering end, notify video play");
            locala.bHv.onVideoPlay();
          }
        }
        else if ((!bool) && (locala.xt()))
        {
          ab.i(locala.xo(), "onInfo, buffering end, notify video pause");
          locala.bHv.onVideoPause();
        }
      }
      else if (paramInt2 == -1004)
      {
        ab.i(locala.xo(), "onInfo, special error, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (locala.bHw != null) {
          locala.bHw.bL(paramInt1, paramInt2);
        }
        if (locala.bHx != null) {
          locala.bHx.at(40L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.7
 * JD-Core Version:    0.7.0.1
 */