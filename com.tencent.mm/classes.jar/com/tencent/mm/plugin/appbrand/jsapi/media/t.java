package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.y.a;
import com.tencent.mm.plugin.appbrand.jsapi.y.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class t
{
  public static void a(f paramf, JSONObject paramJSONObject, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(329311);
    a locala = (a)e.T(a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.AppBrand.ReferrerHelper", "mayPutReferrer, referrerHelper is null");
      AppMethodBeat.o(329311);
      return;
    }
    paramf = locala.a(paramJSONObject, paramf);
    if (paramf == null) {
      paramf = locala.cuq();
    }
    for (;;)
    {
      if (c.srt == paramf)
      {
        AppMethodBeat.o(329311);
        return;
      }
      paramIntent.putExtra("IsFromWebViewReffer", paramString);
      AppMethodBeat.o(329311);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.t
 * JD-Core Version:    0.7.0.1
 */