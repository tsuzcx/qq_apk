package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.v.a;
import com.tencent.mm.plugin.appbrand.jsapi.v.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class s
{
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(279504);
    a locala = (a)com.tencent.luggage.a.e.K(a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.AppBrand.ReferrerHelper", "mayPutReferrer, referrerHelper is null");
      AppMethodBeat.o(279504);
      return;
    }
    parame = locala.a(paramJSONObject, parame);
    if (parame == null) {
      parame = locala.bUd();
    }
    for (;;)
    {
      if (c.pmz == parame)
      {
        AppMethodBeat.o(279504);
        return;
      }
      paramIntent.putExtra("IsFromWebViewReffer", paramString);
      AppMethodBeat.o(279504);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.s
 * JD-Core Version:    0.7.0.1
 */