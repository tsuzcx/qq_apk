package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 635;
  public static final String NAME = "loadPaySpeechDialectConfig";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46658);
    ac.i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "invoke JsApiLoadPaySpeechDialectConfig!");
    if (paramc == null)
    {
      ac.e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:component is null");
      AppMethodBeat.o(46658);
      return;
    }
    if (paramc.getContext() == null)
    {
      ac.e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:context is null");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46658);
      return;
    }
    h.a("com.tencent.mm", null, a.class, new d() {});
    AppMethodBeat.o(46658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b
 * JD-Core Version:    0.7.0.1
 */