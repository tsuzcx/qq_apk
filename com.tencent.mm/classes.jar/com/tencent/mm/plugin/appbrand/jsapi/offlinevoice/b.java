package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 635;
  public static final String NAME = "loadPaySpeechDialectConfig";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(131372);
    ab.i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "invoke JsApiLoadPaySpeechDialectConfig!");
    if (paramc == null)
    {
      ab.e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:component is null");
      AppMethodBeat.o(131372);
      return;
    }
    if (paramc.getContext() == null)
    {
      ab.e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:context is null");
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(131372);
      return;
    }
    f.a("com.tencent.mm", null, a.class, new com.tencent.mm.ipcinvoker.c() {});
    AppMethodBeat.o(131372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b
 * JD-Core Version:    0.7.0.1
 */