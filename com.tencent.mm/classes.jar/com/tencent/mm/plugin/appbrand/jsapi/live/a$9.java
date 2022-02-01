package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import org.json.JSONException;
import org.json.JSONObject;

final class a$9
  implements TXLivePlayer.ITXAudioVolumeEvaluationListener
{
  a$9(a parama, int paramInt, e parame) {}
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(145855);
    a.a locala = new a.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePlayerId", this.kFw);
      localJSONObject.put("volume", paramInt);
      label41:
      this.kFs.b(locala.PQ(localJSONObject.toString()));
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.9
 * JD-Core Version:    0.7.0.1
 */