package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONException;
import org.json.JSONObject;

final class a$7
  implements AppBrandLivePlayerView.c
{
  a$7(a parama, int paramInt, e parame) {}
  
  public final void k(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(96078);
    a.a locala = new a.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("direction", paramInt);
      localJSONObject.put("livePlayerId", this.hEO);
      label53:
      this.hEL.b(locala.BN(localJSONObject.toString()));
      AppMethodBeat.o(96078);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.7
 * JD-Core Version:    0.7.0.1
 */