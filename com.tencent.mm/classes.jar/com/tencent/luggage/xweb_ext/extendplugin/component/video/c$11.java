package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class c$11
  implements Runnable
{
  public c$11(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(177149);
    c localc = this.cvH;
    localc.csB = false;
    boolean bool;
    if (!localc.cvu)
    {
      bool = localc.Gw();
      localc.csD = null;
    }
    while (bool) {
      if (localc.Gz())
      {
        ae.i("MicroMsg.SameLayer.VideoPluginHandler", "onRuntimeEnterForeground, cancel resume playing when relaunch");
        AppMethodBeat.o(177149);
        return;
        bool = false;
      }
      else
      {
        ae.i("MicroMsg.SameLayer.VideoPluginHandler", "onRuntimeEnterForeground, isPlayingWhenEnterBackground, try resume");
        localc.i(false, true);
      }
    }
    AppMethodBeat.o(177149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.11
 * JD-Core Version:    0.7.0.1
 */