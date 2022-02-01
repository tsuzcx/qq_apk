package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.media.record.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.m.a;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Util;

public final class JsApiStopRecordVoice
  extends c<y>
{
  public static final int CTRL_INDEX = 32;
  public static final String NAME = "stopRecord";
  
  static void o(y paramy)
  {
    AppMethodBeat.i(46003);
    if (Util.isNullOrNil(JsApiStartRecordVoice.rEo))
    {
      AppMethodBeat.o(46003);
      return;
    }
    paramy = u.Ux(paramy.getAppId()).qva;
    if (paramy != null) {
      paramy.dismiss();
    }
    new StopRecordVoice((byte)0).bQt();
    JsApiStartRecordVoice.rEo = null;
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
    
    public final void asn()
    {
      AppMethodBeat.i(46001);
      o.cNm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45999);
          a.Ck(1);
          AppMethodBeat.o(45999);
        }
      });
      AppMethodBeat.o(46001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice
 * JD-Core Version:    0.7.0.1
 */