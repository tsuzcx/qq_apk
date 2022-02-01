package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends d
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstanceAsync";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145705);
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
    AppMethodBeat.o(145705);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt, final o paramo)
  {
    AppMethodBeat.i(256423);
    Log.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: create audio instance async invoke");
    new a()
    {
      public final void YC()
      {
        AppMethodBeat.i(145704);
        Log.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: start create audio instance async");
        String str = e.k(paramf);
        HashMap localHashMap = new HashMap();
        localHashMap.put("audioId", str);
        c.lDH.Zm(paramf.getAppId()).a(str, paramo);
        paramf.i(paramInt, f.this.n("ok", localHashMap));
        AppMethodBeat.o(145704);
      }
    }.bEy();
    AppMethodBeat.o(256423);
  }
  
  public final boolean bEi()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.f
 * JD-Core Version:    0.7.0.1
 */