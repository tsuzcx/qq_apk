package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstanceAsync";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145705);
    ac.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: create audio instance async invoke");
    new a()
    {
      public final void MO()
      {
        AppMethodBeat.i(145704);
        ac.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: start create audio instance async");
        String str = d.k(paramc);
        HashMap localHashMap = new HashMap();
        localHashMap.put("audioId", str);
        paramc.h(paramInt, e.this.k("ok", localHashMap));
        AppMethodBeat.o(145704);
      }
    }.aLt();
    AppMethodBeat.o(145705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.e
 * JD-Core Version:    0.7.0.1
 */