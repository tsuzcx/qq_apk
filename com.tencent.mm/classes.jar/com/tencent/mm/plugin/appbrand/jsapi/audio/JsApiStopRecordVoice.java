package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class JsApiStopRecordVoice
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  public static final int CTRL_INDEX = 32;
  public static final String NAME = "stopRecord";
  
  static void m(q paramq)
  {
    AppMethodBeat.i(46003);
    if (bs.isNullOrNil(JsApiStartRecordVoice.kcM))
    {
      AppMethodBeat.o(46003);
      return;
    }
    paramq = n.Hr(paramq.getAppId()).jfQ;
    if (paramq != null) {
      paramq.dismiss();
    }
    AppBrandMainProcessService.a(new StopRecordVoice((byte)0));
    JsApiStartRecordVoice.kcM = null;
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
    
    public final void aLq()
    {
      AppMethodBeat.i(46001);
      l.bxj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45999);
          com.tencent.mm.plugin.appbrand.media.record.a.tU(1);
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