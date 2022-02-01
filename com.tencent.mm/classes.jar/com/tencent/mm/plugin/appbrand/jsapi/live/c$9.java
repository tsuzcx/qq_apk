package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import org.json.JSONException;
import org.json.JSONObject;

final class c$9
  implements TXLivePlayer.ITXAudioVolumeEvaluationListener
{
  c$9(c paramc, int paramInt, g paramg) {}
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(145855);
    c.a locala = new c.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePlayerId", this.oGn);
      localJSONObject.put("volume", paramInt);
      label41:
      this.oGi.a(locala.agU(localJSONObject.toString()), null);
      AppMethodBeat.o(145855);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.9
 * JD-Core Version:    0.7.0.1
 */