package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.u.a;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class s
{
  public static void a(f paramf, JSONObject paramJSONObject, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(226907);
    a locala = (a)e.M(a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.AppBrand.ReferrerHelper", "mayPutReferrer, referrerHelper is null");
      AppMethodBeat.o(226907);
      return;
    }
    paramf = locala.a(paramJSONObject, paramf);
    if (paramf == null) {
      paramf = locala.bIw();
    }
    for (;;)
    {
      if (c.mou == paramf)
      {
        AppMethodBeat.o(226907);
        return;
      }
      paramIntent.putExtra("IsFromWebViewReffer", paramString);
      AppMethodBeat.o(226907);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.s
 * JD-Core Version:    0.7.0.1
 */