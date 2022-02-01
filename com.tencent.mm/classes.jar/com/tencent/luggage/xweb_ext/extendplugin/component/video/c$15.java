package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c$15
  implements Runnable
{
  public c$15(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(177152);
    c localc = this.cJF;
    localc.cER = false;
    boolean bool;
    if (!localc.cJs)
    {
      bool = localc.Qo();
      localc.cET = null;
    }
    for (;;)
    {
      Log.d(localc.getLogTag(), "onRuntimeEnterForeground, mWebViewInBackground: " + localc.cJs);
      if ((!localc.cJs) && (localc.isPlaying()) && (!localc.cJm)) {
        h.RTc.aV(new c.16(localc));
      }
      if (!bool) {
        break label139;
      }
      if (!localc.Qr()) {
        break;
      }
      Log.i("MicroMsg.SameLayer.VideoPluginHandler", "onRuntimeEnterForeground, cancel resume playing when relaunch");
      AppMethodBeat.o(177152);
      return;
      bool = false;
    }
    Log.i("MicroMsg.SameLayer.VideoPluginHandler", "onRuntimeEnterForeground, isPlayingWhenEnterBackground, try resume");
    localc.i(false, true);
    label139:
    AppMethodBeat.o(177152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.15
 * JD-Core Version:    0.7.0.1
 */