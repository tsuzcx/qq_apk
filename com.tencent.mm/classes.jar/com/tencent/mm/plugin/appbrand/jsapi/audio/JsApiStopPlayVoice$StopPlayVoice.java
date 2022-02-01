package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.aq;

class JsApiStopPlayVoice$StopPlayVoice
  extends MainProcessTask
{
  public static final Parcelable.Creator<StopPlayVoice> CREATOR;
  
  static
  {
    AppMethodBeat.i(45996);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(45996);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(45995);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45993);
        b localb = b.jVe;
        b.stop();
        AppMethodBeat.o(45993);
      }
    });
    AppMethodBeat.o(45995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice.StopPlayVoice
 * JD-Core Version:    0.7.0.1
 */