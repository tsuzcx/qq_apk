package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c$17
  implements Runnable
{
  public c$17(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(215683);
    c localc = this.cJF;
    localc.cER = true;
    if (localc.cET == null)
    {
      boolean bool = localc.isPlaying();
      localc.cET = new AtomicBoolean(bool);
      h.RTc.aV(new c.18(localc));
      Log.i(localc.getLogTag(), "onRuntimeEnterBackground, isPlayingWhenEnterBackground:%s", new Object[] { Boolean.valueOf(bool) });
      if ((localc.cFc) && (localc.PV()))
      {
        Log.i(localc.getLogTag(), "onRuntimeEnterBackground, background play audio is enabled");
        AppMethodBeat.o(215683);
        return;
      }
      localc.pause();
    }
    AppMethodBeat.o(215683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.17
 * JD-Core Version:    0.7.0.1
 */