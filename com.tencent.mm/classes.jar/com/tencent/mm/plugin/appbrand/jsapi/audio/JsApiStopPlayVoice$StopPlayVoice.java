package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.al;

class JsApiStopPlayVoice$StopPlayVoice
  extends MainProcessTask
{
  public static final Parcelable.Creator<StopPlayVoice> CREATOR;
  
  static
  {
    AppMethodBeat.i(130807);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(130807);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130806);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130804);
        ((b)g.E(b.class)).stop();
        AppMethodBeat.o(130804);
      }
    });
    AppMethodBeat.o(130806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice.StopPlayVoice
 * JD-Core Version:    0.7.0.1
 */