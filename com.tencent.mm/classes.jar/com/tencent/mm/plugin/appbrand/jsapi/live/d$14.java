package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import org.json.JSONException;
import org.json.JSONObject;

final class d$14
  implements TXLivePusher.ITXAudioVolumeEvaluationListener
{
  d$14(d paramd, int paramInt, h paramh) {}
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(182553);
    Log.i("MicroMsg.JsApiInsertLivePusher", "onAudioVolumeEvaluationNotify, volume:%s", new Object[] { Integer.valueOf(paramInt) });
    d.a locala = new d.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("volume", paramInt);
      localJSONObject.put("livePusherId", this.rJm);
      this.rJh.a(locala.ZR(localJSONObject.toString()), null);
      AppMethodBeat.o(182553);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiInsertLivePusher", "onAudioVolumeEvaluationNotify fail", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d.14
 * JD-Core Version:    0.7.0.1
 */