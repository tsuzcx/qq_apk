package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class c
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277081);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      Log.e("LiteAppJsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.JZj.aJV("invalid_downloadid");
      AppMethodBeat.o(277081);
      return;
    }
    if (f.duv().kR(l) > 0)
    {
      this.JZj.fTW();
      AppMethodBeat.o(277081);
      return;
    }
    this.JZj.aJV("fail");
    AppMethodBeat.o(277081);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.c
 * JD-Core Version:    0.7.0.1
 */