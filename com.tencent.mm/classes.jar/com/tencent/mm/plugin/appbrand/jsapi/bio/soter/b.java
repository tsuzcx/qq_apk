package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class b
  extends c
{
  public static final int CTRL_INDEX = 277;
  public static final String NAME = "startSoterAuthentication";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159051);
    Log.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
    if ((Activity)paramf.getContext() == null)
    {
      Log.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", new Object[] { paramf.getAppId() });
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(159051);
      return;
    }
    AppMethodBeat.o(159051);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b
 * JD-Core Version:    0.7.0.1
 */