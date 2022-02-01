package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import org.json.JSONException;
import org.json.JSONObject;

final class c$7
  implements AppBrandLivePlayerView.c
{
  c$7(c paramc, int paramInt, g paramg) {}
  
  public final void q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(145852);
    c.b localb = new c.b((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("direction", paramInt);
      localJSONObject.put("livePlayerId", this.oGn);
      label53:
      this.oGi.a(localb.agU(localJSONObject.toString()), null);
      AppMethodBeat.o(145852);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.7
 * JD-Core Version:    0.7.0.1
 */