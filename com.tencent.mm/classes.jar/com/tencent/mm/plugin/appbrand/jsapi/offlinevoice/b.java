package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class b
  extends c
{
  public static final int CTRL_INDEX = 635;
  public static final String NAME = "loadPaySpeechDialectConfig";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46658);
    Log.i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "invoke JsApiLoadPaySpeechDialectConfig!");
    if (paramf == null)
    {
      Log.e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:component is null");
      AppMethodBeat.o(46658);
      return;
    }
    if (paramf.getContext() == null)
    {
      Log.e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:context is null");
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(46658);
      return;
    }
    j.a(MainProcessIPCService.PROCESS_NAME, null, a.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(46658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b
 * JD-Core Version:    0.7.0.1
 */