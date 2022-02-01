package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import org.json.JSONException;
import org.json.JSONObject;

final class b$13
  implements TXLivePusher.ITXAudioVolumeEvaluationListener
{
  b$13(b paramb, int paramInt, h paramh) {}
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(182553);
    Log.i("MicroMsg.JsApiInsertLivePusher", "onAudioVolumeEvaluationNotify, volume:%s", new Object[] { Integer.valueOf(paramInt) });
    b.a locala = new b.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("volume", paramInt);
      localJSONObject.put("livePusherId", this.lJX);
      this.lJT.a(locala.Zh(localJSONObject.toString()), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.13
 * JD-Core Version:    0.7.0.1
 */