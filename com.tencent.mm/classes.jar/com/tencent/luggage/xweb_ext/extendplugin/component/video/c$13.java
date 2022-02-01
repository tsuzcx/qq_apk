package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c$13
  implements Runnable
{
  public c$13(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(177150);
    c localc = this.cvH;
    localc.csB = true;
    if (localc.csD == null)
    {
      boolean bool = localc.isPlaying();
      localc.csD = new AtomicBoolean(bool);
      ae.i(localc.getLogTag(), "onRuntimeEnterBackground, isPlayingWhenEnterBackground:%s", new Object[] { Boolean.valueOf(bool) });
      if ((localc.csM) && (localc.Gm()))
      {
        ae.i(localc.getLogTag(), "onRuntimeEnterBackground, background play audio is enabled");
        AppMethodBeat.o(177150);
        return;
      }
      localc.pause();
    }
    AppMethodBeat.o(177150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.13
 * JD-Core Version:    0.7.0.1
 */