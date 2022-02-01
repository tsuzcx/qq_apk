package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class c
  extends a
{
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211634);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      ad.e("LiteAppJsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.uYz.YL("invalid_downloadid");
      AppMethodBeat.o(211634);
      return;
    }
    if (f.ccl().tR(l) > 0)
    {
      this.uYz.cXe();
      AppMethodBeat.o(211634);
      return;
    }
    this.uYz.YL("fail");
    AppMethodBeat.o(211634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.c
 * JD-Core Version:    0.7.0.1
 */