package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstanceAsync";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145705);
    a(paramc, paramJSONObject, paramInt, paramc.aYh());
    AppMethodBeat.o(145705);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt, final o paramo)
  {
    AppMethodBeat.i(198672);
    ad.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: create audio instance async invoke");
    new a()
    {
      public final void Ox()
      {
        AppMethodBeat.i(145704);
        ad.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: start create audio instance async");
        String str = e.k(paramc);
        HashMap localHashMap = new HashMap();
        localHashMap.put("audioId", str);
        c.kvZ.Pk(paramc.getAppId()).a(str, paramo);
        paramc.h(paramInt, f.this.m("ok", localHashMap));
        AppMethodBeat.o(145704);
      }
    }.biB();
    AppMethodBeat.o(198672);
  }
  
  public final boolean bij()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.f
 * JD-Core Version:    0.7.0.1
 */