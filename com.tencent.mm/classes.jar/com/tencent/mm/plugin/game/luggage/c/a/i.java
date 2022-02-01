package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class i
  extends a
{
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211646);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      ad.e("LiteAppJsApiPauseDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.uYz.YL("invalid_downloadid");
      AppMethodBeat.o(211646);
      return;
    }
    paramString = d.ua(l);
    if (paramString == null)
    {
      this.uYz.cXe();
      AppMethodBeat.o(211646);
      return;
    }
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("uiarea");
    int k = paramJSONObject.optInt("notice_id");
    int m = paramJSONObject.optInt("ssid");
    paramString.field_scene = i;
    paramString.field_uiarea = j;
    paramString.field_noticeId = k;
    paramString.field_ssid = m;
    paramString.field_downloadInWifi = false;
    d.e(paramString);
    if (f.ccl().tT(l))
    {
      this.uYz.cXe();
      AppMethodBeat.o(211646);
      return;
    }
    this.uYz.YL("fail");
    AppMethodBeat.o(211646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.i
 * JD-Core Version:    0.7.0.1
 */