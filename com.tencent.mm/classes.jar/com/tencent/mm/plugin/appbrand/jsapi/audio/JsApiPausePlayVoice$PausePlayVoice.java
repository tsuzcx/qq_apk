package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.aq;

class JsApiPausePlayVoice$PausePlayVoice
  extends MainProcessTask
{
  public static final Parcelable.Creator<PausePlayVoice> CREATOR;
  
  static
  {
    AppMethodBeat.i(45948);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(45948);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(45947);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45945);
        b localb = b.jVe;
        b.pause();
        AppMethodBeat.o(45945);
      }
    });
    AppMethodBeat.o(45947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice.PausePlayVoice
 * JD-Core Version:    0.7.0.1
 */