package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class JsApiStopRecordVoice
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  public static final int CTRL_INDEX = 32;
  public static final String NAME = "stopRecord";
  
  static void m(r paramr)
  {
    AppMethodBeat.i(46003);
    if (bu.isNullOrNil(JsApiStartRecordVoice.kAB))
    {
      AppMethodBeat.o(46003);
      return;
    }
    paramr = o.Ld(paramr.getAppId()).jBW;
    if (paramr != null) {
      paramr.dismiss();
    }
    AppBrandMainProcessService.a(new StopRecordVoice((byte)0));
    JsApiStartRecordVoice.kAB = null;
    AppMethodBeat.o(46003);
  }
  
  static class StopRecordVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StopRecordVoice> CREATOR;
    
    static
    {
      AppMethodBeat.i(46002);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46002);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(46001);
      m.bCj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45999);
          com.tencent.mm.plugin.appbrand.media.record.a.uE(1);
          AppMethodBeat.o(45999);
        }
      });
      AppMethodBeat.o(46001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice
 * JD-Core Version:    0.7.0.1
 */