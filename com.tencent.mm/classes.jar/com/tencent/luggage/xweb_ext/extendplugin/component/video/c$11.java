package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class c$11
  implements Runnable
{
  c$11(c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(177149);
    Log.i(this.cJF.getLogTag(), "handleWebViewBackground, type:%s, autoPauseIfNative:%s, autoPauseIfNavigate:%s, isRuntimeInBackground:%s, isPlayingWhenEnterBackground:%s", new Object[] { Integer.valueOf(this.val$type), Boolean.valueOf(this.cJF.cEL), Boolean.valueOf(this.cJF.cEK), Boolean.valueOf(this.cJF.cER), this.cJF.cET });
    if (((this.val$type == 2) && (!this.cJF.cEL)) || ((this.val$type == 1) && (!this.cJF.cEK) && (!this.cJF.cER)))
    {
      if (this.cJF.Qo())
      {
        Log.i(this.cJF.getLogTag(), "handleWebViewBackground, video not auto pause, try resume, type:%s", new Object[] { Integer.valueOf(this.val$type) });
        this.cJF.i(false, true);
        AppMethodBeat.o(177149);
        return;
      }
      Log.i(this.cJF.getLogTag(), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", new Object[] { Integer.valueOf(this.val$type) });
      AppMethodBeat.o(177149);
      return;
    }
    if ((this.cJF.cIV != null) && (this.cJF.cJj) && (this.cJF.cET == null))
    {
      boolean bool = this.cJF.cIV.isPlaying();
      this.cJF.cET = new AtomicBoolean(bool);
      Log.i(this.cJF.getLogTag(), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(bool) });
      if ((this.cJF.cFc) && (1 != this.val$type) && (this.cJF.PV()))
      {
        Log.i(this.cJF.getLogTag(), "handleWebViewBackground runnable, background play audio is enabled, do not pause");
        AppMethodBeat.o(177149);
        return;
      }
      if (this.cJF.PT())
      {
        Log.i(this.cJF.getLogTag(), "handleWebViewBackground runnable, i am pip player, do not pause");
        AppMethodBeat.o(177149);
        return;
      }
      this.cJF.pause();
    }
    AppMethodBeat.o(177149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.11
 * JD-Core Version:    0.7.0.1
 */