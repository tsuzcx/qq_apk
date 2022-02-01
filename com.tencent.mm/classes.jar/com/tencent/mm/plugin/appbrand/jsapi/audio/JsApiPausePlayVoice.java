package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class JsApiPausePlayVoice
  extends d<s>
{
  public static final int CTRL_INDEX = 34;
  public static final String NAME = "pauseVoice";
  private PausePlayVoice lEG;
  
  static class PausePlayVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<PausePlayVoice> CREATOR;
    
    static
    {
      AppMethodBeat.i(45948);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45948);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45947);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45945);
          b localb = b.lbt;
          b.pause();
          AppMethodBeat.o(45945);
        }
      });
      AppMethodBeat.o(45947);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice
 * JD-Core Version:    0.7.0.1
 */