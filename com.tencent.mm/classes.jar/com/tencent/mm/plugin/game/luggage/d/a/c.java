package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class c
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(231792);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      Log.e("LiteAppJsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.Ega.aNa("invalid_downloadid");
      AppMethodBeat.o(231792);
      return;
    }
    if (f.cPZ().Iw(l) > 0)
    {
      this.Ega.eLC();
      AppMethodBeat.o(231792);
      return;
    }
    this.Ega.aNa("fail");
    AppMethodBeat.o(231792);
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.c
 * JD-Core Version:    0.7.0.1
 */