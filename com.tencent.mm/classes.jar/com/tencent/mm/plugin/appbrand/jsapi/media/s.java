package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.a;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

final class s
{
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(188452);
    a locala = (a)e.K(a.class);
    if (locala == null)
    {
      ad.w("MicroMsg.AppBrand.ReferrerHelper", "mayPutReferrer, referrerHelper is null");
      AppMethodBeat.o(188452);
      return;
    }
    paramc = locala.a(paramJSONObject, paramc);
    if (paramc == null) {
      paramc = locala.bmo();
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.jsapi.s.c.lfc == paramc)
      {
        AppMethodBeat.o(188452);
        return;
      }
      paramIntent.putExtra("IsFromWebViewReffer", paramString);
      AppMethodBeat.o(188452);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.s
 * JD-Core Version:    0.7.0.1
 */