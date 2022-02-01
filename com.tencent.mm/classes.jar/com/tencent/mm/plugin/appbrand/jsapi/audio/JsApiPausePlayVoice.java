package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ap;

public final class JsApiPausePlayVoice
  extends a<q>
{
  public static final int CTRL_INDEX = 34;
  public static final String NAME = "pauseVoice";
  private PausePlayVoice kcz;
  
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
    
    public final void aLq()
    {
      AppMethodBeat.i(45947);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45945);
          b localb = b.jBj;
          b.pause();
          AppMethodBeat.o(45945);
        }
      });
      AppMethodBeat.o(45947);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice
 * JD-Core Version:    0.7.0.1
 */