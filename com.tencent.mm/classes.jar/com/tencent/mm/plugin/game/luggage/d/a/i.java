package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class i
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186915);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      Log.e("LiteAppJsApiPauseDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.yEn.aCS("invalid_downloadid");
      AppMethodBeat.o(186915);
      return;
    }
    paramString = d.Cw(l);
    if (paramString == null)
    {
      this.yEn.ecz();
      AppMethodBeat.o(186915);
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
    if (f.cBv().Cp(l))
    {
      this.yEn.ecz();
      AppMethodBeat.o(186915);
      return;
    }
    this.yEn.aCS("fail");
    AppMethodBeat.o(186915);
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.i
 * JD-Core Version:    0.7.0.1
 */