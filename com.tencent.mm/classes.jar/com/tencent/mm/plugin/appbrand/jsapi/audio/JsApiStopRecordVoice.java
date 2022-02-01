package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.media.record.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Util;

public final class JsApiStopRecordVoice
  extends c<v>
{
  public static final int CTRL_INDEX = 32;
  public static final String NAME = "stopRecord";
  
  static void o(v paramv)
  {
    AppMethodBeat.i(46003);
    if (Util.isNullOrNil(JsApiStartRecordVoice.oAv))
    {
      AppMethodBeat.o(46003);
      return;
    }
    paramv = s.abV(paramv.getAppId()).nwd;
    if (paramv != null) {
      paramv.dismiss();
    }
    new StopRecordVoice((byte)0).bsM();
    JsApiStartRecordVoice.oAv = null;
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
    
    public final void RW()
    {
      AppMethodBeat.i(46001);
      m.clV().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45999);
          a.BV(1);
          AppMethodBeat.o(45999);
        }
      });
      AppMethodBeat.o(46001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice
 * JD-Core Version:    0.7.0.1
 */