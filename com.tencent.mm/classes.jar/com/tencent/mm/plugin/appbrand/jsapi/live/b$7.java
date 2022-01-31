package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONException;
import org.json.JSONObject;

final class b$7
  implements AppBrandLivePlayerView.c
{
  b$7(b paramb, int paramInt, e parame) {}
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    b.a locala = new b.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("direction", paramInt);
      localJSONObject.put("livePlayerId", this.gkY);
      label48:
      this.gkV.b(locala.tM(localJSONObject.toString()));
      return;
    }
    catch (JSONException localJSONException)
    {
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.7
 * JD-Core Version:    0.7.0.1
 */