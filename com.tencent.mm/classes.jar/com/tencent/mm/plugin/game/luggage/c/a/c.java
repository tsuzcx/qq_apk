package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class c
  extends a
{
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193023);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      ae.e("LiteAppJsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.vko.ZC("invalid_downloadid");
      AppMethodBeat.o(193023);
      return;
    }
    if (f.cdA().ui(l) > 0)
    {
      this.vko.cZN();
      AppMethodBeat.o(193023);
      return;
    }
    this.vko.ZC("fail");
    AppMethodBeat.o(193023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.c
 * JD-Core Version:    0.7.0.1
 */