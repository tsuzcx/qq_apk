package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

final class r
{
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(186709);
    a locala = (a)e.K(a.class);
    if (locala == null)
    {
      ac.w("MicroMsg.AppBrand.ReferrerHelper", "mayPutReferrer, referrerHelper is null");
      AppMethodBeat.o(186709);
      return;
    }
    paramc = locala.a(paramJSONObject, paramc);
    if (paramc == null) {
      paramc = locala.biC();
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.jsapi.p.c.kIJ == paramc)
      {
        AppMethodBeat.o(186709);
        return;
      }
      paramIntent.putExtra("IsFromWebViewReffer", paramString);
      AppMethodBeat.o(186709);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.r
 * JD-Core Version:    0.7.0.1
 */