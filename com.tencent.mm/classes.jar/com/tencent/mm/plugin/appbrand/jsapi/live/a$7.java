package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONException;
import org.json.JSONObject;

final class a$7
  implements AppBrandLivePlayerView.c
{
  a$7(a parama, int paramInt, e parame) {}
  
  public final void o(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(145852);
    a.b localb = new a.b((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("direction", paramInt);
      localJSONObject.put("livePlayerId", this.jGR);
      label53:
      this.jGO.b(localb.HK(localJSONObject.toString()));
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.7
 * JD-Core Version:    0.7.0.1
 */