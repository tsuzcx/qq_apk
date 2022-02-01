package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public final class JsApiStopPlayVoice
  extends a<r>
{
  public static final int CTRL_INDEX = 35;
  public static final String NAME = "stopVoice";
  
  public static void bjp()
  {
    AppMethodBeat.i(45997);
    if (bu.isNullOrNil(JsApiStartPlayVoice.kAw))
    {
      AppMethodBeat.o(45997);
      return;
    }
    AppBrandMainProcessService.a(new StopPlayVoice((byte)0));
    JsApiStartPlayVoice.kAw = null;
    AppMethodBeat.o(45997);
  }
  
  static class StopPlayVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StopPlayVoice> CREATOR;
    
    static
    {
      AppMethodBeat.i(45996);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45996);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45995);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45993);
          b localb = b.jYv;
          b.stop();
          AppMethodBeat.o(45993);
        }
      });
      AppMethodBeat.o(45995);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice
 * JD-Core Version:    0.7.0.1
 */