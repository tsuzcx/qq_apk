package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import org.json.JSONException;
import org.json.JSONObject;

final class c$7
  implements AppBrandLivePlayerView.c
{
  c$7(c paramc, int paramInt, h paramh) {}
  
  public final void o(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(145852);
    c.b localb = new c.b((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("direction", paramInt);
      localJSONObject.put("livePlayerId", this.rJm);
      label53:
      this.rJh.a(localb.ZR(localJSONObject.toString()), null);
      AppMethodBeat.o(145852);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.7
 * JD-Core Version:    0.7.0.1
 */