package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstanceAsync";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145705);
    a(parame, paramJSONObject, paramInt, parame.getJsRuntime());
    AppMethodBeat.o(145705);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt, final o paramo)
  {
    AppMethodBeat.i(225775);
    Log.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: create audio instance async invoke");
    new a()
    {
      public final void adj()
      {
        AppMethodBeat.i(145704);
        Log.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: start create audio instance async");
        String str = e.m(parame);
        HashMap localHashMap = new HashMap();
        localHashMap.put("audioId", str);
        c.ozj.agZ(parame.getAppId()).b(str, paramo);
        parame.j(paramInt, f.this.m("ok", localHashMap));
        AppMethodBeat.o(145704);
      }
    }.bPY();
    AppMethodBeat.o(225775);
  }
  
  public final boolean bPG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.f
 * JD-Core Version:    0.7.0.1
 */