package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class k
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277060);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      Log.e("LiteAppJsApiPauseDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.JZj.aJV("invalid_downloadid");
      AppMethodBeat.o(277060);
      return;
    }
    paramString = d.la(l);
    if (paramString == null)
    {
      this.JZj.fTW();
      AppMethodBeat.o(277060);
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
    if (f.duv().kT(l))
    {
      this.JZj.fTW();
      AppMethodBeat.o(277060);
      return;
    }
    this.JZj.aJV("fail");
    AppMethodBeat.o(277060);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.k
 * JD-Core Version:    0.7.0.1
 */