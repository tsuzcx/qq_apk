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
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186903);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      Log.e("LiteAppJsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.yEn.aCS("invalid_downloadid");
      AppMethodBeat.o(186903);
      return;
    }
    if (f.cBv().Cn(l) > 0)
    {
      this.yEn.ecz();
      AppMethodBeat.o(186903);
      return;
    }
    this.yEn.aCS("fail");
    AppMethodBeat.o(186903);
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.c
 * JD-Core Version:    0.7.0.1
 */