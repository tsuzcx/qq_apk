package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ai;

class JsApiStopPlayVoice$StopPlayVoice
  extends MainProcessTask
{
  public static final Parcelable.Creator<StopPlayVoice> CREATOR = new Parcelable.Creator() {};
  
  public final void Zu()
  {
    ai.d(new Runnable()
    {
      public final void run()
      {
        ((b)g.r(b.class)).stop();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice.StopPlayVoice
 * JD-Core Version:    0.7.0.1
 */