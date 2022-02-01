package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.atomic.AtomicBoolean;

final class c$9
  implements Runnable
{
  c$9(c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(138955);
    ae.i(this.cvH.getLogTag(), "handleWebViewBackground, type:%s, autoPauseIfNative:%s, autoPauseIfNavigate:%s, isRuntimeInBackground:%s, isPlayingWhenEnterBackground:%s", new Object[] { Integer.valueOf(this.val$type), Boolean.valueOf(this.cvH.csw), Boolean.valueOf(this.cvH.csv), Boolean.valueOf(this.cvH.csB), this.cvH.csD });
    if (((this.val$type == 2) && (!this.cvH.csw)) || ((this.val$type == 1) && (!this.cvH.csv) && (!this.cvH.csB)))
    {
      if (this.cvH.Gw())
      {
        ae.i(this.cvH.getLogTag(), "handleWebViewBackground, video not auto pause, try resume, type:%s", new Object[] { Integer.valueOf(this.val$type) });
        this.cvH.i(false, true);
        AppMethodBeat.o(138955);
        return;
      }
      ae.i(this.cvH.getLogTag(), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", new Object[] { Integer.valueOf(this.val$type) });
      AppMethodBeat.o(138955);
      return;
    }
    if ((this.cvH.cuX != null) && (this.cvH.cvl) && (this.cvH.csD == null))
    {
      boolean bool = this.cvH.cuX.isPlaying();
      this.cvH.csD = new AtomicBoolean(bool);
      ae.i(this.cvH.getLogTag(), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(bool) });
      if ((this.cvH.csM) && (1 != this.val$type) && (this.cvH.Gm()))
      {
        ae.i(this.cvH.getLogTag(), "handleWebViewBackground runnable, background play audio is enabled, do not pause");
        AppMethodBeat.o(138955);
        return;
      }
      if (this.cvH.Gk())
      {
        ae.i(this.cvH.getLogTag(), "handleWebViewBackground runnable, i am pip player, do not pause");
        AppMethodBeat.o(138955);
        return;
      }
      this.cvH.pause();
    }
    AppMethodBeat.o(138955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.9
 * JD-Core Version:    0.7.0.1
 */