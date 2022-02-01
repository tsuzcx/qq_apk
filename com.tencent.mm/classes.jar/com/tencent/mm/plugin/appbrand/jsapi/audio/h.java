package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstanceAsync";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145705);
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
    AppMethodBeat.o(145705);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt, final o paramo)
  {
    AppMethodBeat.i(327783);
    Log.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: create audio instance async invoke");
    new a()
    {
      public final void aFi()
      {
        AppMethodBeat.i(145704);
        Log.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: start create audio instance async");
        String str = g.o(paramf);
        HashMap localHashMap = new HashMap();
        localHashMap.put("audioId", str);
        c.rDb.ZX(paramf.getAppId()).b(str, paramo);
        paramf.callback(paramInt, h.this.m("ok", localHashMap));
        AppMethodBeat.o(145704);
      }
    }.cqe();
    AppMethodBeat.o(327783);
  }
  
  public final boolean cpN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h
 * JD-Core Version:    0.7.0.1
 */