package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$11
  implements b.f
{
  a$11(a parama) {}
  
  public final void xL()
  {
    AppMethodBeat.i(154420);
    a locala = this.bHR;
    if (!locala.bHH)
    {
      ab.i(locala.xo(), "onMediaPlayerSeekComplete, mp released");
      AppMethodBeat.o(154420);
      return;
    }
    ab.i(locala.xo(), "onSeekComplete");
    if (locala.bHA)
    {
      ab.i(locala.xo(), "onSeekComplete, start when seek complete");
      locala.bHA = false;
      locala.play();
      AppMethodBeat.o(154420);
      return;
    }
    boolean bool = locala.bHu.isPlaying();
    if (locala.bHB)
    {
      ab.i(locala.xo(), "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(locala.bHu.getCurrentPosition()), Integer.valueOf(locala.bHu.getDuration()) });
      locala.bHB = false;
      if (locala.bHu.getCurrentPosition() / 1000 < locala.bHu.getDuration() / 1000)
      {
        ab.i(locala.xo(), "onSeekComplete, video not end");
        if ((bool) && (locala.xt()))
        {
          ab.i(locala.xo(), "onSeekComplete, dispatch play again");
          locala.bHv.onVideoPlay();
          AppMethodBeat.o(154420);
        }
      }
      else
      {
        ab.i(locala.xo(), "onSeekComplete, video ends");
        locala.bHu.pause();
        locala.bHu.start();
        AppMethodBeat.o(154420);
      }
    }
    else
    {
      ab.i(locala.xo(), "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) && (locala.xt()))
      {
        ab.i(locala.xo(), "onSeekComplete, dispatch pause again");
        locala.bHv.onVideoPause();
      }
    }
    AppMethodBeat.o(154420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.11
 * JD-Core Version:    0.7.0.1
 */