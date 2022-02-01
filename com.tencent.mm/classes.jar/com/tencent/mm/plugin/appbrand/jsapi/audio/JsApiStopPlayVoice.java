package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class JsApiStopPlayVoice
  extends d<s>
{
  public static final int CTRL_INDEX = 35;
  public static final String NAME = "stopVoice";
  
  public static void bED()
  {
    AppMethodBeat.i(45997);
    if (Util.isNullOrNil(JsApiStartPlayVoice.lEP))
    {
      AppMethodBeat.o(45997);
      return;
    }
    AppBrandMainProcessService.a(new StopPlayVoice((byte)0));
    JsApiStartPlayVoice.lEP = null;
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
    
    public final void bjj()
    {
      AppMethodBeat.i(45995);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45993);
          b localb = b.lbt;
          b.stop();
          AppMethodBeat.o(45993);
        }
      });
      AppMethodBeat.o(45995);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice
 * JD-Core Version:    0.7.0.1
 */