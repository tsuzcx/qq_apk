package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import org.json.JSONException;
import org.json.JSONObject;

final class c$9
  implements TXLivePlayer.ITXAudioVolumeEvaluationListener
{
  c$9(c paramc, int paramInt, h paramh) {}
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(145855);
    c.a locala = new c.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePlayerId", this.rJm);
      localJSONObject.put("volume", paramInt);
      label41:
      this.rJh.a(locala.ZR(localJSONObject.toString()), null);
      AppMethodBeat.o(145855);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.9
 * JD-Core Version:    0.7.0.1
 */