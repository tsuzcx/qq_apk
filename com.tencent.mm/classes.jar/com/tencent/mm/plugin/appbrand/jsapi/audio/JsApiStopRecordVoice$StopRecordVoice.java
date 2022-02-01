package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.record.a;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;

class JsApiStopRecordVoice$StopRecordVoice
  extends MainProcessTask
{
  public static final Parcelable.Creator<StopRecordVoice> CREATOR;
  
  static
  {
    AppMethodBeat.i(46002);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46002);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(46001);
    m.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45999);
        a.uy(1);
        AppMethodBeat.o(45999);
      }
    });
    AppMethodBeat.o(46001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice.StopRecordVoice
 * JD-Core Version:    0.7.0.1
 */