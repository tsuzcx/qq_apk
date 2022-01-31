package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.al;

class JsApiPausePlayVoice$PausePlayVoice
  extends MainProcessTask
{
  public static final Parcelable.Creator<PausePlayVoice> CREATOR;
  
  static
  {
    AppMethodBeat.i(130759);
    CREATOR = new JsApiPausePlayVoice.PausePlayVoice.2();
    AppMethodBeat.o(130759);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130758);
    al.d(new JsApiPausePlayVoice.PausePlayVoice.1(this));
    AppMethodBeat.o(130758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice.PausePlayVoice
 * JD-Core Version:    0.7.0.1
 */