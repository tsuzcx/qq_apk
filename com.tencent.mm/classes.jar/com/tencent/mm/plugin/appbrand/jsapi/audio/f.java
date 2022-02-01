package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.ae;
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
    a(paramc, paramJSONObject, paramInt, paramc.aYB());
    AppMethodBeat.o(145705);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt, final o paramo)
  {
    AppMethodBeat.i(210894);
    ae.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: create audio instance async invoke");
    new a()
    {
      public final void Ov()
      {
        AppMethodBeat.i(145704);
        ae.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: start create audio instance async");
        String str = e.k(paramc);
        HashMap localHashMap = new HashMap();
        localHashMap.put("audioId", str);
        c.kzo.PS(paramc.getAppId()).a(str, paramo);
        paramc.h(paramInt, f.this.n("ok", localHashMap));
        AppMethodBeat.o(145704);
      }
    }.bjk();
    AppMethodBeat.o(210894);
  }
  
  public final boolean biS()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.f
 * JD-Core Version:    0.7.0.1
 */