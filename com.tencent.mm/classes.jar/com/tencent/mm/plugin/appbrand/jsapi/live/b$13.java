package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import org.json.JSONException;
import org.json.JSONObject;

final class b$13
  implements TXLivePusher.ITXAudioVolumeEvaluationListener
{
  b$13(b paramb, int paramInt, e parame) {}
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(182553);
    ad.i("MicroMsg.JsApiInsertLivePusher", "onAudioVolumeEvaluationNotify, volume:%s", new Object[] { Integer.valueOf(paramInt) });
    b.a locala = new b.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("volume", paramInt);
      localJSONObject.put("livePusherId", this.kCh);
      this.kCd.b(locala.Pi(localJSONObject.toString()));
      AppMethodBeat.o(182553);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiInsertLivePusher", "onAudioVolumeEvaluationNotify fail", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.13
 * JD-Core Version:    0.7.0.1
 */